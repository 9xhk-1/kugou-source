package com.kugou.framework.musichunter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.kugou.framework.libcommon.KGHttpClient;
import com.kugou.framework.libcommon.KGThreadPool;
import com.kugou.framework.libcommon.LogUtils;
import com.kugou.framework.libcommon.RequestProxy;
import com.kugou.framework.musichunter.fp2013.Fingerprint2013;
import com.kugou.framework.musichunter.v2.IdentifyContext;
import com.kugou.framework.musichunter.v2.MusicHunterProcessorMgr;
import com.kugou.framework.worker.Instruction;
import com.kugou.framework.worker.WorkScheduler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class MusicHunter implements RecordListener {
    private static final int IDENTIFY_TIME_OUT = 20000;
    private static int MAX_SLICES = 15;
    private static final int SLICE_MS = 1000;
    public static final String TAG = "MusicHunter2016";
    private MusicHunterProcessorMgr identifyProcessor;
    private Context mContext;
    private IMusicHunterEvent mHunterEvent;
    private String mPCMFileName;
    private MusicRecord mRecord;
    private long mUniqueID;
    private int pcmIndex;
    private int recordType;
    private int tempTime;
    private BufferedResampler mResampler = new BufferedResampler();
    private boolean mIsRecording = false;
    private volatile boolean mStopped = false;
    private volatile boolean mHasCallOnFinish = false;
    private int mLastSlices = 0;
    private Object mLocker = new Object();
    private boolean mHasMainProcessStop = false;
    private AtomicInteger mTaskId = new AtomicInteger(0);
    private boolean useQing = true;
    private final int MSG_ON_STOP = 1;
    private final int MSG_ON_CANCEL = 2;
    private final int MSG_ON_FINISH = 3;
    private final int MSG_ON_VOLUME_CHANGED = 4;
    private final int MSG_MAKE_FINGERPRINT = 5;
    private final int MSG_ON_INIT_FAILURE = 6;
    private final int MSG_ON_CANT_RECORD = 10;
    private final int MSG_ON_ERROR = 11;
    private final int MSG_NOTIFY_PCM_END = 12;
    private final Handler mHandler = new Handler() { // from class: com.kugou.framework.musichunter.MusicHunter.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 2) {
                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                if (MusicHunter.this.mHunterEvent != null) {
                    MusicHunter.this.mHunterEvent.onCancel(MusicHunter.this.mPCMFileName, MusicHunter.this.recordType, zBooleanValue);
                }
                if (zBooleanValue) {
                    BIDelegate.reportCancel(MusicHunter.this.recordType, MusicHunter.this.isLocalRecordIdentify(), MusicHunter.this.mUniqueID);
                    return;
                }
                return;
            }
            int iIntValue = 3;
            if (i2 == 3) {
                BIDelegate.reportFinish(MusicHunter.this.recordType, MusicHunter.this.isLocalRecordIdentify(), (RecognizeResult) message.obj, MusicHunter.this.mUniqueID);
                if (MusicHunter.this.mHunterEvent == null || MusicHunter.this.mHasCallOnFinish) {
                    return;
                }
                MusicHunter.this.mHasCallOnFinish = true;
                MusicHunter.this.mHunterEvent.onFinish((RecognizeResult) message.obj, MusicHunter.this.mPCMFileName, MusicHunter.this.tempTime, MusicHunter.this.recordType);
                MusicHunter.this.tempTime = 0;
                return;
            }
            if (i2 == 4) {
                double dDoubleValue = ((Double) message.obj).doubleValue();
                if (MusicHunter.this.mHunterEvent != null) {
                    MusicHunter.this.mHunterEvent.onVolumeChanged(dDoubleValue);
                    return;
                }
                return;
            }
            if (i2 == 6) {
                Object obj = message.obj;
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
                BIDelegate.reportError(MusicHunter.this.recordType, MusicHunter.this.isLocalRecordIdentify(), MusicHunter.this.mUniqueID);
                if (MusicHunter.this.mHunterEvent != null) {
                    MusicHunter.this.mHunterEvent.onInitFailure(iIntValue);
                    MusicHunter.this.mHunterEvent.onHunterStop();
                    return;
                }
                return;
            }
            if (i2 == 10) {
                BIDelegate.reportError(MusicHunter.this.recordType, MusicHunter.this.isLocalRecordIdentify(), MusicHunter.this.mUniqueID);
                if (MusicHunter.this.mHunterEvent != null) {
                    MusicHunter.this.mHunterEvent.onRecordError(3);
                    return;
                }
                return;
            }
            if (i2 != 11) {
                return;
            }
            BIDelegate.reportError(MusicHunter.this.recordType, MusicHunter.this.isLocalRecordIdentify(), MusicHunter.this.mUniqueID);
            RecognizeResult recognizeResult = (RecognizeResult) message.obj;
            if (MusicHunter.this.mHunterEvent != null) {
                MusicHunter.this.mHunterEvent.onNetError(recognizeResult);
            }
        }
    };
    private MusicHunterHandler mMusicHunterHandler = new MusicHunterHandler("MusicHunter2013");
    private String mMachineID = getMachineID();

    public interface Config {
        boolean canAccessDeviceId();
    }

    public static class MakeFingerprint {
        public byte[] pcmBuffer;
        public boolean pcmEnd;
        public int taskId;
        public int timeLength;
    }

    public class MusicHunterHandler extends WorkScheduler {
        public MusicHunterHandler(String str) {
            super(str);
        }

        @Override // com.kugou.framework.worker.WorkScheduler
        public void handleInstruction(Instruction instruction) {
            int i2 = instruction.what;
            if (i2 == 5) {
                MakeFingerprint makeFingerprint = (MakeFingerprint) instruction.obj;
                if (MusicHunter.this.isCurrentTask(makeFingerprint.taskId)) {
                    MusicHunter.access$1108(MusicHunter.this);
                    MusicHunter.this.identifyProcessor.process(MusicHunter.this.pcmIndex, makeFingerprint);
                    return;
                }
                return;
            }
            if (i2 != 12) {
                return;
            }
            if (!MusicHunter.this.isCurrentTask(instruction.arg1) || MusicHunter.this.identifyProcessor == null) {
                return;
            }
            MusicHunter.this.identifyProcessor.setPcmEnd(true);
        }
    }

    public MusicHunter(Context context, IMusicHunterEvent iMusicHunterEvent) {
        this.mHunterEvent = iMusicHunterEvent;
        this.mContext = context;
        Global.createDirectory(context);
    }

    public static /* synthetic */ int access$1108(MusicHunter musicHunter) {
        int i2 = musicHunter.pcmIndex;
        musicHunter.pcmIndex = i2 + 1;
        return i2;
    }

    private double calculateVolume(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
        int iAbs = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iAbs += Math.abs((int) sArr[i2]);
        }
        double dLog10 = Math.log10((iAbs / length) / 32767) * 20.0d;
        if (dLog10 > 0.0d) {
            return 0.0d;
        }
        return dLog10;
    }

    private void changeVolume(double d2) {
        Message message = new Message();
        message.what = 4;
        message.obj = Double.valueOf(d2);
        this.mHandler.sendMessage(message);
    }

    private void clear(boolean z) {
        MusicHunterHandler musicHunterHandler = this.mMusicHunterHandler;
        if (musicHunterHandler != null) {
            musicHunterHandler.removeCallbacksAndInstructions(null);
        }
        if (getIdentifyContext() != null) {
            getIdentifyContext().releaseResource();
        }
        this.mResampler.clear();
    }

    private void computeVolume(byte[] bArr, int i2) {
        if (bArr == 0) {
            changeVolume(0.0d);
            return;
        }
        int i3 = MusicRecord.samples / 1000;
        long j = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < i2; i7 += 2) {
            int i8 = bArr[i7];
            if (i8 >= 128) {
                i8 = 256 - i8;
            }
            if (i8 > i5) {
                i5 = i8;
            }
            i6++;
            if (i6 == i3 || i7 + 1 == i2) {
                j += (long) ((i5 == true ? 1 : 0) * (i5 == true ? 1 : 0));
                i4++;
                i5 = 0;
                i6 = 0;
            }
        }
        double dLog1p = 0.1d;
        if (j > 0 && i4 > 0) {
            double d2 = j;
            Double.isNaN(d2);
            double d3 = i4;
            Double.isNaN(d3);
            dLog1p = Math.log1p((d2 * 1.0d) / d3) / Math.log1p(Math.pow(128.0d, 2.0d));
        }
        changeVolume(dLog1p);
    }

    private static byte[] copyOfRange(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, 0, i4);
        return bArr2;
    }

    private void createNewFile(String str) {
        FileUtil.createFile(str, 1);
    }

    private String getMachineID() {
        return Utils.getMachineID();
    }

    private void init() {
        clear(false);
        this.mTaskId.incrementAndGet();
        this.mUniqueID = Utils.getUniqueID();
        IdentifyContext identifyContextCreate = IdentifyContext.create(this.recordType, this.mTaskId.get(), this.mUniqueID, System.nanoTime() + 25000000000L, this.mPCMFileName);
        identifyContextCreate.init();
        IdentifyContext.mCurContext = identifyContextCreate;
        MusicHunterProcessorMgr musicHunterProcessorMgr = new MusicHunterProcessorMgr(identifyContextCreate, this.useQing);
        musicHunterProcessorMgr.setOnProcessListener(new MusicHunterProcessorMgr.OnProcessListener() { // from class: com.kugou.framework.musichunter.MusicHunter.2
            @Override // com.kugou.framework.musichunter.v2.MusicHunterProcessorMgr.OnProcessListener
            public void onFinish(RecognizeResult recognizeResult) {
                MusicHunter.this.onEndResult(recognizeResult);
            }

            @Override // com.kugou.framework.musichunter.v2.MusicHunterProcessorMgr.OnProcessListener
            public void onFirstLeverEnd(RecognizeResult recognizeResult, boolean z) {
            }
        });
        this.identifyProcessor = musicHunterProcessorMgr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCurrentTask(int i2) {
        synchronized (this.mLocker) {
            if (this.mStopped) {
                return false;
            }
            return this.mTaskId.get() == i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLocalRecordIdentify() {
        return this.mPCMFileName == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEndResult(RecognizeResult recognizeResult) {
        if (this.mHasMainProcessStop) {
            LogUtils.log("主流程已经结束，忽略结果");
            return;
        }
        this.tempTime = (int) this.identifyProcessor.getUseTime();
        this.mHasMainProcessStop = true;
        stop(false);
        if (!recognizeResult.isSuccess()) {
            LogUtils.log("请求失败!");
            onError(recognizeResult);
        } else if (recognizeResult.isValid()) {
            LogUtils.log("music hunter network 请求成功，调用onFinish!");
            onFinish(recognizeResult);
        } else {
            LogUtils.log("调用onFinish!");
            onFinish(recognizeResult);
        }
    }

    private void onError(RecognizeResult recognizeResult) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 11;
        messageObtain.obj = recognizeResult;
        this.mHandler.sendMessage(messageObtain);
    }

    private void onFinish(RecognizeResult recognizeResult) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = recognizeResult;
        this.mHandler.sendMessage(messageObtain);
    }

    public static void preInit(Context context, String str, String str2, Config config) {
        Global.init(context, str, str2, config);
    }

    private void recognizeXiaokong(int i2, int i3) {
        LogUtils.log("music hunter 开始生成指纹 " + i2 + "  " + i3);
        int i4 = this.mTaskId.get();
        if (this.mStopped) {
            return;
        }
        int outputSliceSize = this.mResampler.getOutputSliceSize(this.recordType) * i3;
        byte[] bArrCopyOfRange = new byte[outputSliceSize];
        int i5 = this.mResampler.read(i2, i3, bArrCopyOfRange, 0);
        if (i5 <= 0 || this.mStopped) {
            return;
        }
        if (i5 < outputSliceSize) {
            bArrCopyOfRange = Arrays.copyOfRange(bArrCopyOfRange, 0, i5);
        }
        if (bArrCopyOfRange != null && bArrCopyOfRange.length > 0) {
            this.mHunterEvent.onRecordVolumeSize(calculateVolume(bArrCopyOfRange), false);
        }
        int i6 = i2 + i3;
        boolean z = i6 == MAX_SLICES;
        if (!FileUtil.appendData(this.mPCMFileName, bArrCopyOfRange)) {
            this.mHunterEvent.onNoStorage();
        }
        startMakeFingerprint(i4, bArrCopyOfRange, z, i6 * 1000);
    }

    private void resetState() {
        this.mLastSlices = 0;
        this.pcmIndex = 0;
        this.mStopped = false;
        this.mHasCallOnFinish = false;
    }

    public static void setDebugModel(boolean z) {
        Global.DEBUG = z;
    }

    public static void setMusicHunterCacheDir(String str) {
        Global.setMusicHunterCacheDir(str);
    }

    public static void setRequestProxy(RequestProxy requestProxy) {
        KGHttpClient.setRequestProxy(requestProxy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMakeFingerprint(int i2, byte[] bArr, boolean z, int i3) {
        if (getIdentifyContext() != null) {
            getIdentifyContext().pcmSlices.addPcmSlice(bArr);
        }
        MakeFingerprint makeFingerprint = new MakeFingerprint();
        makeFingerprint.taskId = i2;
        makeFingerprint.pcmBuffer = bArr;
        makeFingerprint.timeLength = i3;
        makeFingerprint.pcmEnd = z;
        Instruction instruction = new Instruction();
        instruction.what = 5;
        instruction.obj = makeFingerprint;
        this.mMusicHunterHandler.sendInstruction(instruction);
    }

    private void stop(boolean z) {
        synchronized (this.mLocker) {
            if (this.mIsRecording) {
                MusicRecord musicRecord = this.mRecord;
                if (musicRecord != null) {
                    try {
                        musicRecord.stopRecord();
                    } catch (Exception unused) {
                    }
                    this.mResampler.clear();
                }
                if (!this.mStopped) {
                    this.mStopped = true;
                    this.mTaskId.incrementAndGet();
                }
                MusicHunterProcessorMgr musicHunterProcessorMgr = this.identifyProcessor;
                if (musicHunterProcessorMgr != null) {
                    musicHunterProcessorMgr.cancel();
                }
                MusicHunterProcessorMgr musicHunterProcessorMgr2 = this.identifyProcessor;
                if (musicHunterProcessorMgr2 != null) {
                    musicHunterProcessorMgr2.release();
                }
                clear(z);
                this.mIsRecording = false;
            }
        }
    }

    public void cancel() {
        cancel(false);
    }

    public IdentifyContext getIdentifyContext() {
        return IdentifyContext.mCurContext;
    }

    public String getMID() {
        return String.valueOf(this.mMachineID);
    }

    public long[] getTimeOffset(RecognizeResult recognizeResult) {
        if (recognizeResult == null || recognizeResult.getResponse() == null || recognizeResult.getResponse().getSongs() == null) {
            return new long[0];
        }
        ArrayList<KGHunterSong> songs = recognizeResult.getResponse().getSongs();
        long[] jArr = new long[songs.size()];
        for (int i2 = 0; i2 < songs.size(); i2++) {
            jArr[i2] = songs.get(i2).getTimeOffset();
        }
        return jArr;
    }

    public String getUID() {
        return String.valueOf(this.mUniqueID);
    }

    public boolean isAutoRecording() {
        MusicRecord musicRecord = this.mRecord;
        return musicRecord != null && musicRecord.isRecording();
    }

    public boolean isRecording() {
        return this.mIsRecording;
    }

    @Override // com.kugou.framework.musichunter.RecordListener
    public void onAudioBuffer(byte[] bArr, int i2) {
        LogUtils.log("music hunter 收到录音内容 " + i2);
        if (this.mLastSlices < MAX_SLICES && this.mResampler.push(bArr, i2)) {
            LogUtils.log("music hunter 压入采集指纹");
            int iValidSlices = this.mResampler.validSlices();
            synchronized (this.mLocker) {
                if (isRecording() && !this.mStopped) {
                    int i3 = this.mLastSlices;
                    if (iValidSlices <= i3 || iValidSlices > MAX_SLICES) {
                        return;
                    }
                    this.mLastSlices = i3 + 1;
                    recognizeXiaokong(i3, 1);
                    if (this.mLastSlices == 1) {
                        this.mHunterEvent.onFirstSliceSend();
                    }
                }
            }
        }
    }

    @Override // com.kugou.framework.musichunter.RecordListener
    public void onAudioInit(int i2) {
        LogUtils.log("record samples: " + i2);
        this.mResampler.reset(i2);
    }

    @Override // com.kugou.framework.musichunter.RecordListener
    public void onRecordComplete(int i2, int i3, int i4) {
        LogUtils.log("music hunter 录音结束");
        Instruction instructionObtain = Instruction.obtain(this.mMusicHunterHandler, 12);
        instructionObtain.arg1 = this.mTaskId.get();
        this.mMusicHunterHandler.sendInstruction(instructionObtain);
    }

    @Override // com.kugou.framework.musichunter.RecordListener
    public void onRecordError(String str) {
        LogUtils.log("music hunter 录音异常 " + str);
        stop(false);
        if (str.equals(MusicRecord.FAIL_AUDIO)) {
            this.mHandler.sendEmptyMessage(10);
        }
    }

    @Override // com.kugou.framework.musichunter.RecordListener
    public void onRecordInitFailure(int i2, int i3) {
        LogUtils.log("music hunter 录音初始化异常，检查下有没有录音权限 " + i2);
        stop(false);
        Message messageObtain = Message.obtain();
        messageObtain.obj = Integer.valueOf(i3);
        messageObtain.what = 6;
        this.mHandler.sendMessage(messageObtain);
    }

    @Override // com.kugou.framework.musichunter.RecordListener
    public void onVolumeChanged(double d2) {
        if (this.mPCMFileName != null) {
            changeVolume(d2);
        }
    }

    public void quit() {
        LogUtils.log("music hunter 销毁!");
        MusicRecord musicRecord = this.mRecord;
        if (musicRecord != null && musicRecord.isRecording()) {
            this.mRecord.stopRecord();
        }
        cancel();
        MusicHunterHandler musicHunterHandler = this.mMusicHunterHandler;
        if (musicHunterHandler != null) {
            musicHunterHandler.removeCallbacksAndInstructions(null);
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHunterEvent = null;
        KGHttpClient.setRequestProxy(null);
    }

    public void setRecordType(int i2) {
        this.recordType = i2;
    }

    public void setUseQing(boolean z) {
        this.useQing = z;
    }

    public void start(int i2) {
        if (!Global.hasInit()) {
            LogUtils.log("！！！MusicHunter未初始化！！！！！，请先调用MusicHunter.preInit方法");
            return;
        }
        LogUtils.log("music hunter 启动! " + i2);
        this.recordType = i2;
        MAX_SLICES = MusicHunterProcessorMgr.maxSlices(i2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Global.MUSIC_RADAR_CACHE_DIR);
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(".pcm");
        String string = stringBuffer.toString();
        this.mPCMFileName = string;
        createNewFile(string);
        this.mHasMainProcessStop = false;
        MusicRecord musicRecord = this.mRecord;
        if (musicRecord == null || !musicRecord.isRecording()) {
            MusicRecord musicRecord2 = new MusicRecord(i2);
            this.mRecord = musicRecord2;
            musicRecord2.setRecordListener(this);
        }
        synchronized (this.mLocker) {
            if (this.mIsRecording) {
                LogUtils.log("music hunter 已启动录音 返回");
                return;
            }
            if (!Fingerprint2013.loadOK()) {
                LogUtils.log("music hunter so加载失败");
                this.mHandler.sendEmptyMessage(6);
                return;
            }
            this.mIsRecording = true;
            init();
            resetState();
            this.identifyProcessor.start();
            IMusicHunterEvent iMusicHunterEvent = this.mHunterEvent;
            if (iMusicHunterEvent != null) {
                iMusicHunterEvent.onMusicHunterStart();
            }
            BIDelegate.reportStart(i2, isLocalRecordIdentify());
            if (this.mRecord.isRecording()) {
                return;
            }
            this.mResampler.clear();
            if (i2 == RecordType.TYPE_HUMMING) {
                this.mRecord.startRecord(MAX_SLICES + 1, false, false);
            } else {
                this.mRecord.startRecord(MAX_SLICES + 1, false, false);
            }
            LogUtils.log("music hunter 开始启动录音");
        }
    }

    public void startWithRecord(final String str, final int i2) {
        this.recordType = i2;
        MAX_SLICES = MusicHunterProcessorMgr.maxSlices(i2);
        this.mPCMFileName = null;
        synchronized (this.mLocker) {
            if (this.mIsRecording) {
                return;
            }
            if (!Fingerprint2013.loadOK()) {
                this.mHandler.sendEmptyMessage(6);
                return;
            }
            this.mIsRecording = true;
            init();
            resetState();
            this.identifyProcessor.setLocalPcm(str);
            this.identifyProcessor.start();
            IMusicHunterEvent iMusicHunterEvent = this.mHunterEvent;
            if (iMusicHunterEvent != null) {
                iMusicHunterEvent.onMusicHunterStart();
            }
            BIDelegate.reportStart(i2, isLocalRecordIdentify());
            this.mHasMainProcessStop = false;
            KGThreadPool.getInstance().execute(new Runnable() { // from class: com.kugou.framework.musichunter.MusicHunter.1
                @Override // java.lang.Runnable
                public void run() {
                    byte[] fileData = FileUtil.getFileData(str);
                    int i3 = i2 == RecordType.TYPE_HUMMING ? 32000 : 16000;
                    int length = (fileData.length / i3) + (fileData.length % i3 > 0 ? 1 : 0);
                    int i4 = 0;
                    while (i4 < length) {
                        int i5 = i4 + 1;
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(fileData, i3 * i4, Math.min(i3 * i5, fileData.length));
                        MusicHunter musicHunter = MusicHunter.this;
                        musicHunter.startMakeFingerprint(musicHunter.mTaskId.get(), bArrCopyOfRange, i4 == length + (-1), bArrCopyOfRange.length);
                        if (i4 == 1) {
                            MusicHunter.this.mHunterEvent.onFirstSliceSend();
                        }
                        i4 = i5;
                    }
                }
            });
        }
    }

    public void stopRecord() {
        MusicRecord musicRecord = this.mRecord;
        if (musicRecord == null || !musicRecord.isRecording()) {
            return;
        }
        this.mRecord.stopRecord();
    }

    public void cancel(boolean z) {
        synchronized (this.mLocker) {
            if (this.mIsRecording) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                messageObtain.obj = Boolean.valueOf(z);
                this.mHandler.sendMessage(messageObtain);
                stop(z);
            }
        }
    }
}
