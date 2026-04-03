package com.kugou.common.player.kugouplayer;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.net.TrafficStats;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kugou.common.player.kugouplayer.MVExtractor;
import e.c.e.b.b.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class MVExtractDecode {
    private static int API = Build.VERSION.SDK_INT;
    public static final int KPLAYER_ERROR = 4;
    public static final int KPLAYER_MV_ERROR_DECODEC_FAILED = 3;
    public static final int KPLAYER_MV_ERROR_DECODEC_INIT_FAILED = 5;
    public static final int KPLAYER_MV_ERROR_EXCEPTION = 4;
    public static final int KPLAYER_MV_ERROR_EXTRACTOR_FAILED = 2;
    public static final int KPLAYER_MV_ERROR_INIT_FAILED = 1;
    public static final int KPLAYER_MV_ERROR_UNKNOW = 0;
    private static final String OUTPUT_AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final String OUTPUT_VIDEO_MIME_TYPE = "video/avc";
    private static final int STATE_INITED = 1;
    private static final int STATE_NO_INIT = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_RELAEASE = 6;
    private static final int STATE_STARTED = 3;
    private static final int STATE_STARTING = 2;
    private static final int STATE_STOP = 5;
    private static final String TAG = "MVExtractDecode";
    private static final int TIMEOUT_USEC = 5000;
    private static final boolean VERBOSE = false;
    private static final int audio_buffer_max_num = 256;
    private static int mAudioDecodeContinuousExceptionCount = 0;
    private static int mVideoDecodeContinuousExceptionCount = 0;
    private static final int vido_buffer_max_num = 8;
    private int extractor_read_ts;
    private MediaCodec mAudioDecoder;
    private Condition mAudioDecoderCondition;
    private boolean mAudioDecoderDone;
    private Lock mAudioDecoderlock;
    private boolean mAudioExtractorDone;
    public int mAudioIndex;
    private boolean mAudioSeekDone;
    private boolean mAudioThreadIsRun;
    private Condition mCondition;
    private boolean mCopyAudio;
    private boolean mCopyVideo;
    private int mCurrentId;
    private Condition mDrawCondition;
    private Lock mDrawlock;
    private String mInputFile;
    private long mInputStream;
    private Lock mLock;
    private MVExtractor mMVExtractor;
    private Condition mMainCondition;
    private boolean mMainThreadIsRun;
    private Lock mMainlock;
    private NativeMediaSource mMediasource;
    private int mNewId;
    private MVExtractor mNewMVExtractor;
    private boolean mOnComplete;
    private MVListener mOnListener;
    private Object mPlaycontroller;
    public PackageManager mPm;
    private Condition mRenderCondition;
    private Lock mRenderLock;
    private boolean mRenderThreadIsRun;
    private Condition mSeekCondition;
    private Lock mSeektimelock;
    private int mState;
    private Surface mSurface;
    private Condition mSurfaceCondition;
    private SurfaceHolder mSurfaceHolder;
    private Lock mSurfaceLock;
    private boolean mTryAgain;
    private Lock mVarLock;
    private MediaCodec mVideoDecoder;
    private boolean mVideoDecoderDone;
    private boolean mVideoExtractorDone;
    public int mVideoIndex;
    private boolean mVideoSeekDone;
    private boolean mVideoThreadIsRun;
    private int videoExtractedFrameCount;
    private boolean mErrorIsReported = false;
    private int mErrorNo = 0;
    private int mErrorType = 0;
    private boolean mUseRender = false;
    private long mStartTime = 0;
    private long mDurationMs = 0;
    private long mTimeUs = -1;
    private long mSeekTimeUs = -1;

    public interface MVListener {
        long getCurPosition(Object obj);

        void onError(int i2, int i3, int i4);

        void onRender(Object obj);
    }

    public MVExtractDecode() {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        this.mSeektimelock = reentrantLock;
        this.mSeekCondition = reentrantLock.newCondition();
        ReentrantLock reentrantLock2 = new ReentrantLock(true);
        this.mLock = reentrantLock2;
        this.mCondition = reentrantLock2.newCondition();
        this.mVarLock = new ReentrantLock(true);
        ReentrantLock reentrantLock3 = new ReentrantLock(true);
        this.mSurfaceLock = reentrantLock3;
        this.mSurfaceCondition = reentrantLock3.newCondition();
        ReentrantLock reentrantLock4 = new ReentrantLock(true);
        this.mRenderLock = reentrantLock4;
        this.mRenderCondition = reentrantLock4.newCondition();
        ReentrantLock reentrantLock5 = new ReentrantLock(true);
        this.mDrawlock = reentrantLock5;
        this.mDrawCondition = reentrantLock5.newCondition();
        ReentrantLock reentrantLock6 = new ReentrantLock(true);
        this.mMainlock = reentrantLock6;
        this.mMainCondition = reentrantLock6.newCondition();
        ReentrantLock reentrantLock7 = new ReentrantLock(true);
        this.mAudioDecoderlock = reentrantLock7;
        this.mAudioDecoderCondition = reentrantLock7.newCondition();
        this.mAudioSeekDone = true;
        this.mVideoSeekDone = true;
        this.mAudioThreadIsRun = false;
        this.mVideoThreadIsRun = false;
        this.mRenderThreadIsRun = false;
        this.mMainThreadIsRun = false;
        this.mVideoDecoderDone = false;
        this.mAudioDecoderDone = false;
        this.mVideoExtractorDone = false;
        this.mAudioExtractorDone = false;
        this.mOnComplete = false;
        this.mMVExtractor = null;
        this.mNewMVExtractor = null;
        this.mMediasource = null;
        this.mSurfaceHolder = null;
        this.mSurface = null;
        this.mVideoDecoder = null;
        this.mAudioDecoder = null;
        this.mTryAgain = true;
        this.mState = 0;
        this.mNewId = 0;
        this.mCurrentId = 0;
        this.mVideoIndex = -1;
        this.mAudioIndex = -1;
        this.videoExtractedFrameCount = 0;
        this.extractor_read_ts = 0;
        this.mInputFile = null;
        this.mInputStream = 0L;
        if (b.f().debug()) {
            b.f().d(TAG, "MVExtractDecode create this:" + this + " hashCode" + hashCode());
        }
        this.mMediasource = new NativeMediaSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0465 A[Catch: all -> 0x04e5, Exception -> 0x04e7, TryCatch #16 {Exception -> 0x04e7, blocks: (B:182:0x0461, B:184:0x0465, B:186:0x0485), top: B:253:0x0461, outer: #1 }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int AudioThread() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.player.kugouplayer.MVExtractDecode.AudioThread():int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RenderThread() {
        if (b.f().debug()) {
            b.f().eLF(TAG, "RenderThread start");
        }
        this.mLock.lock();
        try {
            try {
                this.mRenderThreadIsRun = true;
                this.mCondition.signalAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mLock.unlock();
            while (true) {
                int i2 = this.mState;
                if (i2 != 3 && i2 != 4) {
                    break;
                }
                this.mRenderLock.lock();
                try {
                    try {
                        this.mRenderCondition.awaitNanos(16000000L);
                        MVListener mVListener = this.mOnListener;
                        if (mVListener != null && this.mUseRender) {
                            mVListener.onRender(this.mPlaycontroller);
                        }
                    } finally {
                        this.mRenderLock.unlock();
                    }
                } catch (Exception e3) {
                    if (b.f().debug()) {
                        b.f().eLF(TAG, "RenderThread Exception:" + e3);
                    }
                    e3.printStackTrace();
                }
            }
            if (b.f().debug()) {
                b.f().i(TAG, "RenderThread end");
            }
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    private void StartAudioDecodeWrite() {
        b.f().i(TAG, "====AudioThread StartAudioDecodeWrite");
        new Thread(new Runnable() { // from class: com.kugou.common.player.kugouplayer.MVExtractDecode.3
            @Override // java.lang.Runnable
            public void run() {
                b.f().i(MVExtractDecode.TAG, "====AudioThread start");
                try {
                    try {
                        int iAudioThread = MVExtractDecode.this.AudioThread();
                        if (iAudioThread < 0) {
                            b.f().i(MVExtractDecode.TAG, "====AudioThread error:" + iAudioThread);
                            if (MVExtractDecode.this.mErrorNo == 0) {
                                MVExtractDecode.this.mErrorNo = 20010;
                            }
                            MVExtractDecode mVExtractDecode = MVExtractDecode.this;
                            mVExtractDecode.sendErrorReport(mVExtractDecode.mErrorNo, MVExtractDecode.this.mErrorType, null);
                        } else {
                            b.f().i(MVExtractDecode.TAG, "====AudioThread normal end");
                        }
                        if (b.f().debug()) {
                            b.f().d(MVExtractDecode.TAG, "AudioThread finally");
                        }
                        MVExtractDecode.this.mLock.lock();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        if (MVExtractDecode.this.mErrorNo == 0) {
                            MVExtractDecode.this.mErrorNo = 30005;
                        }
                        MVExtractDecode mVExtractDecode2 = MVExtractDecode.this;
                        mVExtractDecode2.sendErrorReport(mVExtractDecode2.mErrorNo, MVExtractDecode.this.mErrorType, e2);
                        if (b.f().debug()) {
                            b.f().d(MVExtractDecode.TAG, "AudioThread finally");
                        }
                        MVExtractDecode.this.mLock.lock();
                        try {
                            try {
                                MVExtractDecode.this.mAudioThreadIsRun = false;
                                MVExtractDecode.this.mCondition.signalAll();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            MVExtractDecode.this.mLock.unlock();
                            if (!b.f().debug()) {
                                return;
                            }
                        } finally {
                        }
                    }
                    try {
                        try {
                            MVExtractDecode.this.mAudioThreadIsRun = false;
                            MVExtractDecode.this.mCondition.signalAll();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        MVExtractDecode.this.mLock.unlock();
                        if (!b.f().debug()) {
                            return;
                        }
                        b.f().d(MVExtractDecode.TAG, "====run audio thread end");
                    } finally {
                    }
                } catch (Throwable th) {
                    if (b.f().debug()) {
                        b.f().d(MVExtractDecode.TAG, "AudioThread finally");
                    }
                    MVExtractDecode.this.mLock.lock();
                    try {
                        try {
                            MVExtractDecode.this.mAudioThreadIsRun = false;
                            MVExtractDecode.this.mCondition.signalAll();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        MVExtractDecode.this.mLock.unlock();
                        if (!b.f().debug()) {
                            throw th;
                        }
                        b.f().d(MVExtractDecode.TAG, "====run audio thread end");
                        throw th;
                    } finally {
                    }
                }
            }
        }).start();
    }

    private void StartRender() {
        e.c.e.a.a.b bVarF = b.f();
        String str = TAG;
        bVarF.i(str, "====StartRender entry");
        new Thread(new Runnable() { // from class: com.kugou.common.player.kugouplayer.MVExtractDecode.1
            @Override // java.lang.Runnable
            public void run() {
                b.f().i(MVExtractDecode.TAG, "====run render start");
                try {
                    try {
                        b.f().i(MVExtractDecode.TAG, "====call RenderThread");
                        MVExtractDecode.this.RenderThread();
                        b.f().i(MVExtractDecode.TAG, "====call RenderThread end");
                        b.f().i(MVExtractDecode.TAG, "RenderThread finally");
                        MVExtractDecode.this.mLock.lock();
                    } catch (Exception e2) {
                        if (b.f().debug()) {
                            b.f().eLF(MVExtractDecode.TAG, "RenderThread Exception:" + e2);
                        }
                        e2.printStackTrace();
                        b.f().i(MVExtractDecode.TAG, "RenderThread finally");
                        MVExtractDecode.this.mLock.lock();
                        try {
                            try {
                                MVExtractDecode.this.mRenderThreadIsRun = false;
                                MVExtractDecode.this.mCondition.signalAll();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        } finally {
                        }
                    }
                    try {
                        try {
                            MVExtractDecode.this.mRenderThreadIsRun = false;
                            MVExtractDecode.this.mCondition.signalAll();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                        MVExtractDecode.this.mLock.unlock();
                        b.f().i(MVExtractDecode.TAG, "====run render end");
                    } finally {
                    }
                } catch (Throwable th) {
                    b.f().i(MVExtractDecode.TAG, "RenderThread finally");
                    MVExtractDecode.this.mLock.lock();
                    try {
                        try {
                            MVExtractDecode.this.mRenderThreadIsRun = false;
                            MVExtractDecode.this.mCondition.signalAll();
                        } finally {
                        }
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    MVExtractDecode.this.mLock.unlock();
                    b.f().i(MVExtractDecode.TAG, "====run render end");
                    throw th;
                }
            }
        }).start();
        b.f().i(str, "====StartRender end");
    }

    private void StartVideoDecoderAndDraw() {
        e.c.e.a.a.b bVarF = b.f();
        String str = TAG;
        bVarF.i(str, "====StartVideoDecoderAndDraw entry");
        new Thread(new Runnable() { // from class: com.kugou.common.player.kugouplayer.MVExtractDecode.2
            @Override // java.lang.Runnable
            public void run() {
                b.f().i(MVExtractDecode.TAG, "====VideoThread run");
                try {
                    try {
                        b.f().i(MVExtractDecode.TAG, "====call VideoThread");
                        int iVideoThread = MVExtractDecode.this.VideoThread();
                        if (iVideoThread < 0) {
                            b.f().i(MVExtractDecode.TAG, "====VideoThread error:" + iVideoThread);
                            if (MVExtractDecode.this.mErrorNo == 0) {
                                MVExtractDecode.this.mErrorNo = 100100;
                            }
                            MVExtractDecode mVExtractDecode = MVExtractDecode.this;
                            mVExtractDecode.sendErrorReport(mVExtractDecode.mErrorNo, MVExtractDecode.this.mErrorType, null);
                        } else {
                            b.f().i(MVExtractDecode.TAG, "====VideoThread normal end");
                        }
                        b.f().i(MVExtractDecode.TAG, "====VideoThread  end");
                        b.f().i(MVExtractDecode.TAG, "VideoThread finally");
                    } catch (Exception e2) {
                        if (b.f().debug()) {
                            b.f().eLF(MVExtractDecode.TAG, "VideoThread Exception:" + e2);
                        }
                        e2.printStackTrace();
                        if (MVExtractDecode.this.mErrorNo == 0) {
                            MVExtractDecode.this.mErrorNo = 30004;
                        }
                        MVExtractDecode mVExtractDecode2 = MVExtractDecode.this;
                        mVExtractDecode2.sendErrorReport(mVExtractDecode2.mErrorNo, MVExtractDecode.this.mErrorType, e2);
                        b.f().i(MVExtractDecode.TAG, "VideoThread finally");
                        try {
                            try {
                                if (MVExtractDecode.this.mVideoDecoder != null) {
                                    if (b.f().debug()) {
                                        b.f().d(MVExtractDecode.TAG, "VideoThread releasing VideoDecoder");
                                    }
                                    MVExtractDecode.this.mVideoDecoder.stop();
                                    MVExtractDecode.this.mVideoDecoder.release();
                                    MVExtractDecode.this.mVideoDecoder = null;
                                    if (b.f().debug()) {
                                        b.f().d(MVExtractDecode.TAG, "VideoThread  VideoDecoder release end");
                                    }
                                }
                            } catch (Exception e3) {
                                if (b.f().debug()) {
                                    b.f().eLF(MVExtractDecode.TAG, "VideoThread error while stop or releas videoDecoder");
                                }
                                if (b.f().debug()) {
                                    b.f().eLF(MVExtractDecode.TAG, "VideoThread run Exception:" + e3);
                                }
                                e3.printStackTrace();
                            }
                            if (b.f().debug()) {
                                b.f().d(MVExtractDecode.TAG, "VideoThread  finally 2");
                            }
                            MVExtractDecode.this.mLock.lock();
                            try {
                                try {
                                    if (b.f().debug()) {
                                        b.f().d(MVExtractDecode.TAG, "VideoThread  set mVideoThreadIsRun");
                                    }
                                    MVExtractDecode.this.mVideoThreadIsRun = false;
                                    MVExtractDecode.this.mCondition.signalAll();
                                } finally {
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        } finally {
                        }
                    }
                    try {
                        try {
                            if (MVExtractDecode.this.mVideoDecoder != null) {
                                if (b.f().debug()) {
                                    b.f().d(MVExtractDecode.TAG, "VideoThread releasing VideoDecoder");
                                }
                                MVExtractDecode.this.mVideoDecoder.stop();
                                MVExtractDecode.this.mVideoDecoder.release();
                                MVExtractDecode.this.mVideoDecoder = null;
                                if (b.f().debug()) {
                                    b.f().d(MVExtractDecode.TAG, "VideoThread  VideoDecoder release end");
                                }
                            }
                        } catch (Exception e5) {
                            if (b.f().debug()) {
                                b.f().eLF(MVExtractDecode.TAG, "VideoThread error while stop or releas videoDecoder");
                            }
                            if (b.f().debug()) {
                                b.f().eLF(MVExtractDecode.TAG, "VideoThread run Exception:" + e5);
                            }
                            e5.printStackTrace();
                        }
                        if (b.f().debug()) {
                            b.f().d(MVExtractDecode.TAG, "VideoThread  finally 2");
                        }
                        MVExtractDecode.this.mLock.lock();
                        try {
                            try {
                                if (b.f().debug()) {
                                    b.f().d(MVExtractDecode.TAG, "VideoThread  set mVideoThreadIsRun");
                                }
                                MVExtractDecode.this.mVideoThreadIsRun = false;
                                MVExtractDecode.this.mCondition.signalAll();
                            } finally {
                            }
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        MVExtractDecode.this.mLock.unlock();
                        b.f().i(MVExtractDecode.TAG, "====VideoThread quit");
                    } finally {
                    }
                } catch (Throwable th) {
                    b.f().i(MVExtractDecode.TAG, "VideoThread finally");
                    try {
                        try {
                            if (MVExtractDecode.this.mVideoDecoder != null) {
                                if (b.f().debug()) {
                                    b.f().d(MVExtractDecode.TAG, "VideoThread releasing VideoDecoder");
                                }
                                MVExtractDecode.this.mVideoDecoder.stop();
                                MVExtractDecode.this.mVideoDecoder.release();
                                MVExtractDecode.this.mVideoDecoder = null;
                                if (b.f().debug()) {
                                    b.f().d(MVExtractDecode.TAG, "VideoThread  VideoDecoder release end");
                                }
                            }
                        } finally {
                        }
                    } catch (Exception e7) {
                        if (b.f().debug()) {
                            b.f().eLF(MVExtractDecode.TAG, "VideoThread error while stop or releas videoDecoder");
                        }
                        if (b.f().debug()) {
                            b.f().eLF(MVExtractDecode.TAG, "VideoThread run Exception:" + e7);
                        }
                        e7.printStackTrace();
                    }
                    if (b.f().debug()) {
                        b.f().d(MVExtractDecode.TAG, "VideoThread  finally 2");
                    }
                    MVExtractDecode.this.mLock.lock();
                    try {
                        try {
                            if (b.f().debug()) {
                                b.f().d(MVExtractDecode.TAG, "VideoThread  set mVideoThreadIsRun");
                            }
                            MVExtractDecode.this.mVideoThreadIsRun = false;
                            MVExtractDecode.this.mCondition.signalAll();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                        MVExtractDecode.this.mLock.unlock();
                        b.f().i(MVExtractDecode.TAG, "====VideoThread quit");
                        throw th;
                    } finally {
                    }
                }
            }
        }).start();
        b.f().i(str, "====StartVideoDecoderAndDraw end");
    }

    private void VideoDecoderInput(ByteBuffer[] byteBufferArr) throws Exception {
        if (this.mVideoDecoder == null || ((byteBufferArr == null && API < 21) || this.mMVExtractor == null)) {
            if (b.f().debug()) {
                b.f().eLF(TAG, "VideoThread InputBuffer= video decoder(" + this.mVideoDecoder + ") or input buffers(" + byteBufferArr + ") API(" + API + ") or mvExtractor(" + this.mMVExtractor + ") is null.");
                return;
            }
            return;
        }
        if (this.videoExtractedFrameCount < 64 && b.f().debug()) {
            b.f().d(TAG, "VideoThread InputBuffer=== extractor video start: currentTime clock:" + (System.currentTimeMillis() - this.mStartTime) + "ms");
        }
        while (this.mCopyVideo && !this.mVideoExtractorDone && this.mVideoSeekDone) {
            int i2 = this.mState;
            if (i2 != 3 && i2 != 4) {
                return;
            }
            try {
                int iDequeueInputBuffer = this.mVideoDecoder.dequeueInputBuffer(this.videoExtractedFrameCount > 3 ? 0L : 5000L);
                if (iDequeueInputBuffer == -1) {
                    if (this.videoExtractedFrameCount != 0) {
                        return;
                    }
                    if (b.f().debug()) {
                        b.f().d(TAG, "VideoThread InputBuffer==aaa===video dequeueInputBuffer failed try again later");
                    }
                } else {
                    if (iDequeueInputBuffer < 0 || (byteBufferArr != null && iDequeueInputBuffer >= byteBufferArr.length)) {
                        if (b.f().debug()) {
                            b.f().eLF(TAG, "VideoThread InputBuffer:video decoder input buffer:decoderInputBufferIndex error: " + iDequeueInputBuffer);
                            return;
                        }
                        return;
                    }
                    ByteBuffer byteBuffer = byteBufferArr != null ? byteBufferArr[iDequeueInputBuffer] : null;
                    if (byteBuffer == null) {
                        if (b.f().debug()) {
                            b.f().eLF(TAG, "VideoThread InputBuffer:video decoder: buffer is null input buffer: " + iDequeueInputBuffer);
                            return;
                        }
                        return;
                    }
                    if (!this.mCopyAudio) {
                        this.mMVExtractor.clear(this.mAudioIndex);
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    MVExtractor.Frame frame = this.mMVExtractor.readFrame(this.mVideoIndex);
                    this.extractor_read_ts = (int) (((long) this.extractor_read_ts) + (System.currentTimeMillis() - jCurrentTimeMillis));
                    if (!this.mVideoSeekDone || this.mSeekTimeUs >= 0) {
                        if (b.f().debug()) {
                            b.f().d(TAG, "VideoThread InputBuffer:video is seeking...");
                            return;
                        }
                        return;
                    }
                    if (frame == null) {
                        if (!this.mMVExtractor.isEof()) {
                            if (this.mVideoSeekDone) {
                                if (b.f().debug()) {
                                    b.f().eLF(TAG, "VideoThread InputBuffer===ERROR====:video extractor read frame is null");
                                    return;
                                }
                                return;
                            } else {
                                if (b.f().debug()) {
                                    b.f().d(TAG, "VideoThread InputBuffer: is seeking");
                                    return;
                                }
                                return;
                            }
                        }
                        this.mVideoExtractorDone = true;
                        if (b.f().debug()) {
                            b.f().d(TAG, "VideoThread InputBuffer:video extractor: EOS");
                        }
                        try {
                            this.mVideoDecoder.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            return;
                        } catch (Exception e2) {
                            if (b.f().debug()) {
                                b.f().iLF(TAG, "VideoThread===InputBuffer:queueInputBuffer Exception:" + e2);
                            }
                            mVideoDecodeContinuousExceptionCount++;
                            this.mErrorNo = 100020;
                            this.mErrorType = 3;
                            throw e2;
                        }
                    }
                    byteBuffer.position(0);
                    byteBuffer.put(frame.buffer);
                    int i3 = frame.bufferSize;
                    long j = frame.ptsUs;
                    int i4 = frame.sampleFlags;
                    if (i3 >= 0) {
                        try {
                            MediaCodec mediaCodec = this.mVideoDecoder;
                            if (mediaCodec != null) {
                                mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, i3, j, i4);
                            }
                        } catch (Exception e3) {
                            if (b.f().debug()) {
                                b.f().iLF(TAG, "VideoThread===InputBuffer:queueInputBuffer 2 Exception:" + e3);
                            }
                            mVideoDecodeContinuousExceptionCount++;
                            this.mErrorNo = 100021;
                            this.mErrorType = 3;
                            throw e3;
                        }
                    }
                    if (this.videoExtractedFrameCount < 64 && b.f().debug()) {
                        b.f().d(TAG, "VideoThread InputBuffer:==cccc===video extractor read " + this.videoExtractedFrameCount + " frame extractor_read:" + this.extractor_read_ts + " currentTime clock:" + (System.currentTimeMillis() - this.mStartTime) + "ms");
                    }
                    this.videoExtractedFrameCount++;
                }
            } catch (Exception e4) {
                if (b.f().debug()) {
                    b.f().iLF(TAG, "VideoThread===InputBuffer:dequeueInputBuffer Exception:" + e4);
                }
                mVideoDecodeContinuousExceptionCount++;
                this.mErrorNo = 100022;
                this.mErrorType = 3;
                throw e4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:276:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x062b A[Catch: all -> 0x066f, Exception -> 0x0671, TRY_LEAVE, TryCatch #9 {Exception -> 0x0671, blocks: (B:277:0x05a4, B:281:0x05ab, B:283:0x05b5, B:284:0x05ed, B:286:0x05f7, B:288:0x0620, B:289:0x0625, B:291:0x062b), top: B:384:0x05a4, outer: #10 }] */
    /* JADX WARN: Type inference failed for: r4v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int VideoThread() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 2024
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.player.kugouplayer.MVExtractDecode.VideoThread():int");
    }

    private MediaCodec createAudioDecoder(MediaFormat mediaFormat) throws IOException {
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(getMimeTypeFor(mediaFormat));
        mediaCodecCreateDecoderByType.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        mediaCodecCreateDecoderByType.start();
        return mediaCodecCreateDecoderByType;
    }

    private MediaCodec createVideoDecoder(MediaFormat mediaFormat, Surface surface) throws Exception {
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(getMimeTypeFor(mediaFormat));
        try {
            mediaCodecCreateDecoderByType.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            mediaCodecCreateDecoderByType.start();
            return mediaCodecCreateDecoderByType;
        } catch (Exception e2) {
            if (b.f().debug()) {
                b.f().eLF(TAG, "createVideoDecoder Exception:" + e2);
            }
            e2.printStackTrace();
            mediaCodecCreateDecoderByType.release();
            throw e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(6:349|301|(1:303)|304|(3:389|306|394)(1:393)|392)|296|367) */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x059f, code lost:
    
        if (r5 < 0) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x05a2, code lost:
    
        if (r5 < r2.length) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x05a6, code lost:
    
        r11 = r2[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x05a8, code lost:
    
        if (r11 != 0) goto L236;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x05ae, code lost:
    
        if (r27.mCopyVideo != false) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x05b0, code lost:
    
        r27.mMVExtractor.clear(r27.mVideoIndex);
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x05b7, code lost:
    
        java.lang.System.currentTimeMillis();
        r13 = r27.mMVExtractor.readFrame(r27.mAudioIndex);
        java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x05cb, code lost:
    
        if (r27.mSeekTimeUs < 0) goto L242;
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x05cf, code lost:
    
        if (r13 != null) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x05d7, code lost:
    
        if (r27.mMVExtractor.isEof() == false) goto L257;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x05d9, code lost:
    
        r27.mAudioExtractorDone = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x05db, code lost:
    
        r27.mAudioDecoder.queueInputBuffer(r5, 0, 0, 0, 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x05f0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x05f5, code lost:
    
        r27.mErrorNo = 200012;
        r27.mErrorType = 3;
        com.kugou.common.player.kugouplayer.MVExtractDecode.mAudioDecodeContinuousExceptionCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x0606, code lost:
    
        if (e.c.e.b.b.b.f().debug() != false) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x0608, code lost:
    
        e.c.e.b.b.b.f().eLF(com.kugou.common.player.kugouplayer.MVExtractDecode.TAG, "=AudioThread=== queueInputBuffer no:" + r27.mErrorNo + r8 + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x062a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0632, code lost:
    
        if (r27.mSeekTimeUs >= 0) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x063c, code lost:
    
        if (e.c.e.b.b.b.f().debug() == false) goto L262;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x063e, code lost:
    
        e.c.e.b.b.b.f().eLF(com.kugou.common.player.kugouplayer.MVExtractDecode.TAG, "ExtractorAudioThread===ERROR===audio extractor frame is null(not seek/not eof)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x064c, code lost:
    
        r11.position(r7);
        r11.put(r13.buffer);
        r11 = r13.bufferSize;
        r14 = r13.ptsUs;
        r13 = r13.sampleFlags;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x065a, code lost:
    
        if (r11 < 0) goto L279;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x065c, code lost:
    
        r26 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x0664, code lost:
    
        if (r27.mSeekTimeUs >= 0) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x0666, code lost:
    
        r27.mAudioDecoder.queueInputBuffer(r5, 0, r11, r14, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x067b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0680, code lost:
    
        r27.mErrorNo = 200013;
        r27.mErrorType = 3;
        com.kugou.common.player.kugouplayer.MVExtractDecode.mAudioDecodeContinuousExceptionCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0691, code lost:
    
        if (e.c.e.b.b.b.f().debug() != false) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0693, code lost:
    
        e.c.e.b.b.b.f().eLF(com.kugou.common.player.kugouplayer.MVExtractDecode.TAG, "=AudioThread=== queueInputBuffer 2 no:" + r27.mErrorNo + r26 + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x06b7, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x06b9, code lost:
    
        r7 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x06bc, code lost:
    
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x06bd, code lost:
    
        r4 = r4 + 1;
        com.kugou.common.player.kugouplayer.MVExtractDecode.mAudioDecodeContinuousExceptionCount = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x06c3, code lost:
    
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x06cc, code lost:
    
        if (e.c.e.b.b.b.f().debug() == false) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x06ce, code lost:
    
        e.c.e.b.b.b.f().eLF(com.kugou.common.player.kugouplayer.MVExtractDecode.TAG, "ExtractorAudioThread audio decoder input buffer:decoderInputBufferIndex error: " + r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x077a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:?, code lost:
    
        throw r0;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0198 A[Catch: all -> 0x0188, TryCatch #7 {, blocks: (B:29:0x00a4, B:31:0x00b6, B:36:0x00da, B:38:0x00f6, B:40:0x011d, B:42:0x0130, B:58:0x018e, B:60:0x0198, B:61:0x01b2, B:63:0x01b8, B:65:0x01c7, B:67:0x01d1, B:68:0x01f4, B:69:0x01f7, B:64:0x01c0, B:43:0x0133, B:45:0x013e, B:46:0x0149), top: B:353:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b8 A[Catch: all -> 0x0188, TryCatch #7 {, blocks: (B:29:0x00a4, B:31:0x00b6, B:36:0x00da, B:38:0x00f6, B:40:0x011d, B:42:0x0130, B:58:0x018e, B:60:0x0198, B:61:0x01b2, B:63:0x01b8, B:65:0x01c7, B:67:0x01d1, B:68:0x01f4, B:69:0x01f7, B:64:0x01c0, B:43:0x0133, B:45:0x013e, B:46:0x0149), top: B:353:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c0 A[Catch: all -> 0x0188, TryCatch #7 {, blocks: (B:29:0x00a4, B:31:0x00b6, B:36:0x00da, B:38:0x00f6, B:40:0x011d, B:42:0x0130, B:58:0x018e, B:60:0x0198, B:61:0x01b2, B:63:0x01b8, B:65:0x01c7, B:67:0x01d1, B:68:0x01f4, B:69:0x01f7, B:64:0x01c0, B:43:0x0133, B:45:0x013e, B:46:0x0149), top: B:353:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d1 A[Catch: all -> 0x0188, TryCatch #7 {, blocks: (B:29:0x00a4, B:31:0x00b6, B:36:0x00da, B:38:0x00f6, B:40:0x011d, B:42:0x0130, B:58:0x018e, B:60:0x0198, B:61:0x01b2, B:63:0x01b8, B:65:0x01c7, B:67:0x01d1, B:68:0x01f4, B:69:0x01f7, B:64:0x01c0, B:43:0x0133, B:45:0x013e, B:46:0x0149), top: B:353:0x00a4 }] */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v68 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r5v53, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int doExtractDecode() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 2030
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.player.kugouplayer.MVExtractDecode.doExtractDecode():int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:156:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0424 A[Catch: all -> 0x0570, Exception -> 0x0574, TryCatch #10 {Exception -> 0x0574, blocks: (B:160:0x0420, B:162:0x0424, B:164:0x0428, B:168:0x0434, B:170:0x043e, B:172:0x0479, B:174:0x0496, B:176:0x04b7, B:178:0x04c1, B:179:0x04c3, B:187:0x04d3, B:189:0x04dd, B:190:0x04e8, B:192:0x04ec, B:193:0x04ef, B:195:0x04f9, B:196:0x052f, B:198:0x0541, B:199:0x055f, B:200:0x056a, B:201:0x056f, B:186:0x04d0), top: B:582:0x0420, outer: #34 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x043e A[Catch: all -> 0x0570, Exception -> 0x0574, TryCatch #10 {Exception -> 0x0574, blocks: (B:160:0x0420, B:162:0x0424, B:164:0x0428, B:168:0x0434, B:170:0x043e, B:172:0x0479, B:174:0x0496, B:176:0x04b7, B:178:0x04c1, B:179:0x04c3, B:187:0x04d3, B:189:0x04dd, B:190:0x04e8, B:192:0x04ec, B:193:0x04ef, B:195:0x04f9, B:196:0x052f, B:198:0x0541, B:199:0x055f, B:200:0x056a, B:201:0x056f, B:186:0x04d0), top: B:582:0x0420, outer: #34 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0496 A[Catch: all -> 0x0570, Exception -> 0x0574, TryCatch #10 {Exception -> 0x0574, blocks: (B:160:0x0420, B:162:0x0424, B:164:0x0428, B:168:0x0434, B:170:0x043e, B:172:0x0479, B:174:0x0496, B:176:0x04b7, B:178:0x04c1, B:179:0x04c3, B:187:0x04d3, B:189:0x04dd, B:190:0x04e8, B:192:0x04ec, B:193:0x04ef, B:195:0x04f9, B:196:0x052f, B:198:0x0541, B:199:0x055f, B:200:0x056a, B:201:0x056f, B:186:0x04d0), top: B:582:0x0420, outer: #34 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04dd A[Catch: all -> 0x0570, Exception -> 0x0574, TryCatch #10 {Exception -> 0x0574, blocks: (B:160:0x0420, B:162:0x0424, B:164:0x0428, B:168:0x0434, B:170:0x043e, B:172:0x0479, B:174:0x0496, B:176:0x04b7, B:178:0x04c1, B:179:0x04c3, B:187:0x04d3, B:189:0x04dd, B:190:0x04e8, B:192:0x04ec, B:193:0x04ef, B:195:0x04f9, B:196:0x052f, B:198:0x0541, B:199:0x055f, B:200:0x056a, B:201:0x056f, B:186:0x04d0), top: B:582:0x0420, outer: #34 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04ec A[Catch: all -> 0x0570, Exception -> 0x0574, TryCatch #10 {Exception -> 0x0574, blocks: (B:160:0x0420, B:162:0x0424, B:164:0x0428, B:168:0x0434, B:170:0x043e, B:172:0x0479, B:174:0x0496, B:176:0x04b7, B:178:0x04c1, B:179:0x04c3, B:187:0x04d3, B:189:0x04dd, B:190:0x04e8, B:192:0x04ec, B:193:0x04ef, B:195:0x04f9, B:196:0x052f, B:198:0x0541, B:199:0x055f, B:200:0x056a, B:201:0x056f, B:186:0x04d0), top: B:582:0x0420, outer: #34 }] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04f9 A[Catch: all -> 0x0570, Exception -> 0x0574, TryCatch #10 {Exception -> 0x0574, blocks: (B:160:0x0420, B:162:0x0424, B:164:0x0428, B:168:0x0434, B:170:0x043e, B:172:0x0479, B:174:0x0496, B:176:0x04b7, B:178:0x04c1, B:179:0x04c3, B:187:0x04d3, B:189:0x04dd, B:190:0x04e8, B:192:0x04ec, B:193:0x04ef, B:195:0x04f9, B:196:0x052f, B:198:0x0541, B:199:0x055f, B:200:0x056a, B:201:0x056f, B:186:0x04d0), top: B:582:0x0420, outer: #34 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0541 A[Catch: all -> 0x0570, Exception -> 0x0574, TryCatch #10 {Exception -> 0x0574, blocks: (B:160:0x0420, B:162:0x0424, B:164:0x0428, B:168:0x0434, B:170:0x043e, B:172:0x0479, B:174:0x0496, B:176:0x04b7, B:178:0x04c1, B:179:0x04c3, B:187:0x04d3, B:189:0x04dd, B:190:0x04e8, B:192:0x04ec, B:193:0x04ef, B:195:0x04f9, B:196:0x052f, B:198:0x0541, B:199:0x055f, B:200:0x056a, B:201:0x056f, B:186:0x04d0), top: B:582:0x0420, outer: #34 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x05d8 A[Catch: all -> 0x0600, Exception -> 0x0605, TryCatch #25 {Exception -> 0x0605, blocks: (B:220:0x05cf, B:222:0x05d8, B:224:0x05e2, B:225:0x05ed), top: B:597:0x05cf, outer: #38 }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0670 A[Catch: all -> 0x068b, Exception -> 0x068e, TryCatch #20 {Exception -> 0x068e, blocks: (B:246:0x0661, B:248:0x0670, B:249:0x067b, B:251:0x067f), top: B:591:0x0661, outer: #44 }] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x067f A[Catch: all -> 0x068b, Exception -> 0x068e, TRY_LEAVE, TryCatch #20 {Exception -> 0x068e, blocks: (B:246:0x0661, B:248:0x0670, B:249:0x067b, B:251:0x067f), top: B:591:0x0661, outer: #44 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x06e3  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x07b3  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x07c6  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x07f7 A[Catch: all -> 0x091e, Exception -> 0x0922, TryCatch #37 {Exception -> 0x0922, blocks: (B:317:0x07d9, B:319:0x07dd, B:321:0x07e1, B:325:0x07ed, B:327:0x07f7, B:328:0x082b, B:330:0x0848, B:331:0x0864, B:333:0x086e, B:334:0x0870, B:342:0x0880, B:344:0x088a, B:345:0x0895, B:347:0x0899, B:348:0x089c, B:350:0x08a6, B:351:0x08dc, B:353:0x08f1, B:354:0x090f, B:355:0x0918, B:356:0x091d, B:341:0x087d), top: B:604:0x07d9, outer: #50 }] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0848 A[Catch: all -> 0x091e, Exception -> 0x0922, TryCatch #37 {Exception -> 0x0922, blocks: (B:317:0x07d9, B:319:0x07dd, B:321:0x07e1, B:325:0x07ed, B:327:0x07f7, B:328:0x082b, B:330:0x0848, B:331:0x0864, B:333:0x086e, B:334:0x0870, B:342:0x0880, B:344:0x088a, B:345:0x0895, B:347:0x0899, B:348:0x089c, B:350:0x08a6, B:351:0x08dc, B:353:0x08f1, B:354:0x090f, B:355:0x0918, B:356:0x091d, B:341:0x087d), top: B:604:0x07d9, outer: #50 }] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x088a A[Catch: all -> 0x091e, Exception -> 0x0922, TryCatch #37 {Exception -> 0x0922, blocks: (B:317:0x07d9, B:319:0x07dd, B:321:0x07e1, B:325:0x07ed, B:327:0x07f7, B:328:0x082b, B:330:0x0848, B:331:0x0864, B:333:0x086e, B:334:0x0870, B:342:0x0880, B:344:0x088a, B:345:0x0895, B:347:0x0899, B:348:0x089c, B:350:0x08a6, B:351:0x08dc, B:353:0x08f1, B:354:0x090f, B:355:0x0918, B:356:0x091d, B:341:0x087d), top: B:604:0x07d9, outer: #50 }] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0899 A[Catch: all -> 0x091e, Exception -> 0x0922, TryCatch #37 {Exception -> 0x0922, blocks: (B:317:0x07d9, B:319:0x07dd, B:321:0x07e1, B:325:0x07ed, B:327:0x07f7, B:328:0x082b, B:330:0x0848, B:331:0x0864, B:333:0x086e, B:334:0x0870, B:342:0x0880, B:344:0x088a, B:345:0x0895, B:347:0x0899, B:348:0x089c, B:350:0x08a6, B:351:0x08dc, B:353:0x08f1, B:354:0x090f, B:355:0x0918, B:356:0x091d, B:341:0x087d), top: B:604:0x07d9, outer: #50 }] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x08a6 A[Catch: all -> 0x091e, Exception -> 0x0922, TryCatch #37 {Exception -> 0x0922, blocks: (B:317:0x07d9, B:319:0x07dd, B:321:0x07e1, B:325:0x07ed, B:327:0x07f7, B:328:0x082b, B:330:0x0848, B:331:0x0864, B:333:0x086e, B:334:0x0870, B:342:0x0880, B:344:0x088a, B:345:0x0895, B:347:0x0899, B:348:0x089c, B:350:0x08a6, B:351:0x08dc, B:353:0x08f1, B:354:0x090f, B:355:0x0918, B:356:0x091d, B:341:0x087d), top: B:604:0x07d9, outer: #50 }] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x08f1 A[Catch: all -> 0x091e, Exception -> 0x0922, TryCatch #37 {Exception -> 0x0922, blocks: (B:317:0x07d9, B:319:0x07dd, B:321:0x07e1, B:325:0x07ed, B:327:0x07f7, B:328:0x082b, B:330:0x0848, B:331:0x0864, B:333:0x086e, B:334:0x0870, B:342:0x0880, B:344:0x088a, B:345:0x0895, B:347:0x0899, B:348:0x089c, B:350:0x08a6, B:351:0x08dc, B:353:0x08f1, B:354:0x090f, B:355:0x0918, B:356:0x091d, B:341:0x087d), top: B:604:0x07d9, outer: #50 }] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0962  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0986 A[Catch: all -> 0x09ac, Exception -> 0x09b1, TryCatch #32 {Exception -> 0x09b1, blocks: (B:375:0x097d, B:377:0x0986, B:379:0x0990, B:380:0x0999), top: B:579:0x097d, outer: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x09f3  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0a1c A[Catch: all -> 0x0a37, Exception -> 0x0a3a, TryCatch #47 {Exception -> 0x0a3a, blocks: (B:401:0x0a0d, B:403:0x0a1c, B:404:0x0a27, B:406:0x0a2b), top: B:586:0x0a0d, outer: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0a2b A[Catch: all -> 0x0a37, Exception -> 0x0a3a, TRY_LEAVE, TryCatch #47 {Exception -> 0x0a3a, blocks: (B:401:0x0a0d, B:403:0x0a1c, B:404:0x0a27, B:406:0x0a2b), top: B:586:0x0a0d, outer: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:422:0x0a81  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0abf  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0acd  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0ad3  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x0ae1 A[Catch: all -> 0x0c2d, Exception -> 0x0c31, TryCatch #33 {Exception -> 0x0c31, blocks: (B:442:0x0add, B:444:0x0ae1, B:446:0x0ae5, B:450:0x0af1, B:452:0x0afb, B:454:0x0b34, B:456:0x0b51, B:457:0x0b71, B:459:0x0b7b, B:460:0x0b7d, B:468:0x0b8d, B:470:0x0b97, B:471:0x0ba2, B:473:0x0ba6, B:474:0x0ba9, B:476:0x0bb3, B:477:0x0be9, B:479:0x0bfe, B:480:0x0c1c, B:481:0x0c27, B:482:0x0c2c, B:467:0x0b8a), top: B:584:0x0add, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0afb A[Catch: all -> 0x0c2d, Exception -> 0x0c31, TryCatch #33 {Exception -> 0x0c31, blocks: (B:442:0x0add, B:444:0x0ae1, B:446:0x0ae5, B:450:0x0af1, B:452:0x0afb, B:454:0x0b34, B:456:0x0b51, B:457:0x0b71, B:459:0x0b7b, B:460:0x0b7d, B:468:0x0b8d, B:470:0x0b97, B:471:0x0ba2, B:473:0x0ba6, B:474:0x0ba9, B:476:0x0bb3, B:477:0x0be9, B:479:0x0bfe, B:480:0x0c1c, B:481:0x0c27, B:482:0x0c2c, B:467:0x0b8a), top: B:584:0x0add, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:453:0x0b32  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x0b51 A[Catch: all -> 0x0c2d, Exception -> 0x0c31, TryCatch #33 {Exception -> 0x0c31, blocks: (B:442:0x0add, B:444:0x0ae1, B:446:0x0ae5, B:450:0x0af1, B:452:0x0afb, B:454:0x0b34, B:456:0x0b51, B:457:0x0b71, B:459:0x0b7b, B:460:0x0b7d, B:468:0x0b8d, B:470:0x0b97, B:471:0x0ba2, B:473:0x0ba6, B:474:0x0ba9, B:476:0x0bb3, B:477:0x0be9, B:479:0x0bfe, B:480:0x0c1c, B:481:0x0c27, B:482:0x0c2c, B:467:0x0b8a), top: B:584:0x0add, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:470:0x0b97 A[Catch: all -> 0x0c2d, Exception -> 0x0c31, TryCatch #33 {Exception -> 0x0c31, blocks: (B:442:0x0add, B:444:0x0ae1, B:446:0x0ae5, B:450:0x0af1, B:452:0x0afb, B:454:0x0b34, B:456:0x0b51, B:457:0x0b71, B:459:0x0b7b, B:460:0x0b7d, B:468:0x0b8d, B:470:0x0b97, B:471:0x0ba2, B:473:0x0ba6, B:474:0x0ba9, B:476:0x0bb3, B:477:0x0be9, B:479:0x0bfe, B:480:0x0c1c, B:481:0x0c27, B:482:0x0c2c, B:467:0x0b8a), top: B:584:0x0add, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:473:0x0ba6 A[Catch: all -> 0x0c2d, Exception -> 0x0c31, TryCatch #33 {Exception -> 0x0c31, blocks: (B:442:0x0add, B:444:0x0ae1, B:446:0x0ae5, B:450:0x0af1, B:452:0x0afb, B:454:0x0b34, B:456:0x0b51, B:457:0x0b71, B:459:0x0b7b, B:460:0x0b7d, B:468:0x0b8d, B:470:0x0b97, B:471:0x0ba2, B:473:0x0ba6, B:474:0x0ba9, B:476:0x0bb3, B:477:0x0be9, B:479:0x0bfe, B:480:0x0c1c, B:481:0x0c27, B:482:0x0c2c, B:467:0x0b8a), top: B:584:0x0add, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x0bb3 A[Catch: all -> 0x0c2d, Exception -> 0x0c31, TryCatch #33 {Exception -> 0x0c31, blocks: (B:442:0x0add, B:444:0x0ae1, B:446:0x0ae5, B:450:0x0af1, B:452:0x0afb, B:454:0x0b34, B:456:0x0b51, B:457:0x0b71, B:459:0x0b7b, B:460:0x0b7d, B:468:0x0b8d, B:470:0x0b97, B:471:0x0ba2, B:473:0x0ba6, B:474:0x0ba9, B:476:0x0bb3, B:477:0x0be9, B:479:0x0bfe, B:480:0x0c1c, B:481:0x0c27, B:482:0x0c2c, B:467:0x0b8a), top: B:584:0x0add, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0bfe A[Catch: all -> 0x0c2d, Exception -> 0x0c31, TryCatch #33 {Exception -> 0x0c31, blocks: (B:442:0x0add, B:444:0x0ae1, B:446:0x0ae5, B:450:0x0af1, B:452:0x0afb, B:454:0x0b34, B:456:0x0b51, B:457:0x0b71, B:459:0x0b7b, B:460:0x0b7d, B:468:0x0b8d, B:470:0x0b97, B:471:0x0ba2, B:473:0x0ba6, B:474:0x0ba9, B:476:0x0bb3, B:477:0x0be9, B:479:0x0bfe, B:480:0x0c1c, B:481:0x0c27, B:482:0x0c2c, B:467:0x0b8a), top: B:584:0x0add, outer: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:497:0x0c71  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0c95 A[Catch: all -> 0x0cbb, Exception -> 0x0cc0, TryCatch #46 {Exception -> 0x0cc0, blocks: (B:501:0x0c8c, B:503:0x0c95, B:505:0x0c9f, B:506:0x0ca8), top: B:587:0x0c8c, outer: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0d00  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x0d27 A[Catch: all -> 0x0d42, Exception -> 0x0d45, TryCatch #49 {Exception -> 0x0d45, blocks: (B:527:0x0d18, B:529:0x0d27, B:530:0x0d32, B:532:0x0d36), top: B:590:0x0d18, outer: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0d36 A[Catch: all -> 0x0d42, Exception -> 0x0d45, TRY_LEAVE, TryCatch #49 {Exception -> 0x0d45, blocks: (B:527:0x0d18, B:529:0x0d27, B:530:0x0d32, B:532:0x0d36), top: B:590:0x0d18, outer: #19 }] */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0d84  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x0d9a  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x03d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:631:0x055f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:634:0x090f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:637:0x0c1c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:645:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int extractDecodeThread() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 3574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.player.kugouplayer.MVExtractDecode.extractDecodeThread():int");
    }

    private static String getMimeTypeFor(MediaFormat mediaFormat) {
        return mediaFormat.getString("mime");
    }

    public static boolean isSupport() {
        return mVideoDecodeContinuousExceptionCount < 2 && mAudioDecodeContinuousExceptionCount < 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetParameters() {
        this.mVideoIndex = -1;
        this.mAudioIndex = -1;
        this.mDurationMs = 0L;
        this.mTimeUs = -1L;
        this.mSeekTimeUs = -1L;
        this.mAudioSeekDone = true;
        this.mVideoSeekDone = true;
        this.mAudioThreadIsRun = false;
        this.mVideoThreadIsRun = false;
        this.mVideoDecoderDone = false;
        this.mAudioDecoderDone = false;
        this.mVideoExtractorDone = false;
        this.mAudioExtractorDone = false;
        this.mVarLock.lock();
        this.mErrorIsReported = false;
        this.mVarLock.unlock();
        this.mErrorNo = 0;
        this.mErrorType = 0;
    }

    private static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    private void sendErrorReportEvent(int i2, int i3, int i4, int i5, Exception exc) {
        SurfaceHolder surfaceHolder;
        if (b.f().debug()) {
            b.f().eLF(TAG, "sendErrorReportEvent: err:" + i2 + ",errortype:" + i3 + ",sourcetype:" + i4 + ",inputfileErrorState:" + i5 + " Exception:" + exc + " ExceptionNo:" + this.mErrorNo + " VideoExceptionCount:" + mVideoDecodeContinuousExceptionCount + " AudioExceptionCount:" + mAudioDecodeContinuousExceptionCount);
        }
        try {
            try {
                this.mSurfaceLock.lock();
                SurfaceHolder surfaceHolder2 = this.mSurfaceHolder;
                if (surfaceHolder2 != null && surfaceHolder2.getSurface() != null && this.mSurfaceHolder.getSurface().isValid() && exc != null && exc.getClass().equals(IllegalStateException.class)) {
                    if (b.f().debug()) {
                        b.f().eLF(TAG, "sendErrorReportEvent: " + exc.getClass() + " wait:300ms");
                    }
                    this.mSurfaceCondition.awaitNanos(300000000L);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            this.mSurfaceLock.unlock();
            int i6 = this.mState;
            if (i6 != 3 && i6 != 4) {
                if (b.f().debug()) {
                    b.f().iLF(TAG, "sendErrorReportEvent: alread stop,ignore it. state:" + this.mState);
                    return;
                }
                return;
            }
            if (this.mCurrentId != this.mNewId) {
                if (b.f().debug()) {
                    b.f().iLF(TAG, "sendErrorReport: wait new mv start,ignore it. currentId:" + this.mCurrentId + " newId:" + this.mNewId);
                    return;
                }
                return;
            }
            stop();
            int i7 = 7;
            boolean z = false;
            if (i3 == 2 || (i3 <= 1 && i5 != MVExtractor.EXTRACTOR_NO_ERRROR)) {
                if (i4 == MVExtractor.EXTRACTOR_SOURCE_TYPE_PROXY) {
                    this.mTryAgain = false;
                    i7 = 13;
                } else if (i4 == MVExtractor.EXTRACTOR_SOURCE_TYPE_NET) {
                    i7 = 12;
                } else if (i4 == MVExtractor.EXTRACTOR_SOURCE_TYPE_LOCAL) {
                    i7 = 2;
                }
            } else if (i3 == 3) {
                i7 = 14;
            } else if (i3 == 1) {
                i7 = 17;
            } else if (i3 == 4) {
                i7 = 18;
            } else if (i3 == 5) {
                i7 = 19;
            }
            this.mSurfaceLock.lock();
            SurfaceHolder surfaceHolder3 = this.mSurfaceHolder;
            if (surfaceHolder3 == null || surfaceHolder3.getSurface() == null || ((surfaceHolder = this.mSurfaceHolder) != null && !surfaceHolder.getSurface().isValid())) {
                z = true;
            }
            this.mSurfaceLock.unlock();
            if (b.f().debug()) {
                b.f().iLF(TAG, "sendErrorReportEvent:errortype:" + i7 + ",Exception:" + exc);
            }
            if (this.mOnListener == null || z) {
                if (b.f().debug()) {
                    b.f().iLF(TAG, "sendErrorReportEvent: surface view is destory,ignore it. surfaceIsDestroy:" + z + ",Exception:" + exc);
                    return;
                }
                return;
            }
            if (b.f().debug()) {
                b.f().eLF(TAG, "sendErrorReportEvent: call MVErrorListener errortype:" + i7 + ",errorno:" + i2);
            }
            if (mVideoDecodeContinuousExceptionCount <= 0 && mAudioDecodeContinuousExceptionCount <= 0) {
                this.mOnListener.onError(4, i7, i2);
                return;
            }
            if (b.f().debug()) {
                b.f().eLF(TAG, "sendErrorReportEvent:  errortype:" + i7 + ",ErrorNo:" + i2 + ",errorType:" + i3);
            }
            this.mOnListener.onError(4, i7, i2);
        } catch (Throwable th) {
            this.mSurfaceLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCopyAudio() {
        this.mCopyAudio = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCopyVideo() {
        this.mCopyVideo = true;
    }

    private int setSourcePath2(String str, long j) {
        if (b.f().debug()) {
            b.f().d(TAG, "setSourcePath entry  currentTime:" + System.currentTimeMillis());
        }
        if (b.f().debug()) {
            b.f().d(TAG, "setSourcePath path:" + str + "startMs:" + j);
        }
        int i2 = this.mState;
        if (i2 == 3 || i2 == 4) {
            if (!b.f().debug()) {
                return -1;
            }
            b.f().eLF(TAG, "setSourcePath already start,please stop and try again!");
            return -1;
        }
        this.mStartTime = System.currentTimeMillis();
        this.mInputFile = str;
        this.mState = 1;
        if (!b.f().debug()) {
            return 0;
        }
        b.f().d(TAG, "setSourcePath end  currentTime:" + System.currentTimeMillis() + ":" + (System.currentTimeMillis() - this.mStartTime));
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalAllCondition() {
        this.mLock.lock();
        try {
            try {
                this.mCondition.signalAll();
            } catch (Exception e2) {
                if (b.f().debug()) {
                    b.f().eLF(TAG, "signalAllCondition mCondition Exception:" + e2);
                }
                e2.printStackTrace();
            }
            this.mSurfaceLock.lock();
            try {
                try {
                    this.mSurfaceCondition.signal();
                } finally {
                    this.mSurfaceLock.unlock();
                }
            } catch (Exception e3) {
                if (b.f().debug()) {
                    b.f().eLF(TAG, "signalAllCondition mSurfaceCondition Exception:" + e3);
                }
                e3.printStackTrace();
            }
            this.mSeektimelock.lock();
            try {
                try {
                    this.mSeekCondition.signalAll();
                } catch (Exception e4) {
                    if (b.f().debug()) {
                        b.f().eLF(TAG, "signalAllCondition SeekCondition Exception:" + e4);
                    }
                    e4.printStackTrace();
                }
                this.mAudioDecoderlock.lock();
                try {
                    try {
                        this.mAudioDecoderCondition.signalAll();
                    } catch (Exception e5) {
                        if (b.f().debug()) {
                            b.f().eLF(TAG, "signalAllCondition AudioDecoderCondition Exception:" + e5);
                        }
                        e5.printStackTrace();
                    }
                    this.mRenderLock.lock();
                    try {
                        try {
                            this.mRenderCondition.signalAll();
                        } catch (Exception e6) {
                            if (b.f().debug()) {
                                b.f().eLF(TAG, "signalAllCondition RenderCondition Exception:" + e6);
                            }
                            e6.printStackTrace();
                        }
                        this.mDrawlock.lock();
                        try {
                            try {
                                this.mDrawCondition.signalAll();
                            } finally {
                                this.mDrawlock.unlock();
                            }
                        } catch (Exception e7) {
                            if (b.f().debug()) {
                                b.f().eLF(TAG, "signalAllCondition DrawCondition Exception:" + e7);
                            }
                            e7.printStackTrace();
                        }
                        this.mMainlock.lock();
                        try {
                            try {
                                this.mMainCondition.signalAll();
                            } catch (Exception e8) {
                                if (b.f().debug()) {
                                    b.f().eLF(TAG, "signalAllCondition MainCondition Exception:" + e8);
                                }
                                e8.printStackTrace();
                            }
                        } finally {
                            this.mMainlock.unlock();
                        }
                    } finally {
                        this.mRenderLock.unlock();
                    }
                } finally {
                    this.mAudioDecoderlock.unlock();
                }
            } finally {
                this.mSeektimelock.unlock();
            }
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private void writeFrameToFile(MVExtractor.Frame frame, String str) throws Throwable {
        if (b.f().debug()) {
            b.f().d(TAG, "writeFrameToFile size:" + frame.bufferSize);
        }
        ?? r0 = 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    fileOutputStream2.write(frame.buffer.array());
                    fileOutputStream2.close();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    boolean zDebug = b.f().debug();
                    ?? r02 = zDebug;
                    if (zDebug) {
                        e.c.e.a.a.b bVarF = b.f();
                        bVarF.d(TAG, "FileOutputStream鎵ц\ue511鑰楁椂:" + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " 璞\ue046\ue757");
                        r02 = bVarF;
                    }
                    try {
                        fileOutputStream2.close();
                        r0 = r02;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        r0 = r02;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    try {
                        fileOutputStream.close();
                        r0 = fileOutputStream;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        r0 = fileOutputStream;
                    }
                } catch (Throwable th) {
                    th = th;
                    r0 = fileOutputStream2;
                    try {
                        r0.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void finalize() {
        if (b.f().debug()) {
            b.f().d(TAG, "============finalize==========hashCode:" + hashCode());
        }
        NativeMediaSource nativeMediaSource = this.mMediasource;
        if (nativeMediaSource != null) {
            nativeMediaSource.Release();
            this.mMediasource = null;
        }
    }

    public boolean frameIsEmpty() {
        MVExtractor mVExtractor;
        this.mSeektimelock.lock();
        boolean zFrameQueueIsEmpty = (!this.mAudioThreadIsRun || (mVExtractor = this.mMVExtractor) == null) ? true : mVExtractor.frameQueueIsEmpty();
        this.mSeektimelock.unlock();
        return zFrameQueueIsEmpty;
    }

    public long getDuration() {
        MVExtractor mVExtractor;
        if (b.f().debug()) {
            b.f().d(TAG, "=prepare=getDuration:" + this.mDurationMs + " currentTime" + System.currentTimeMillis());
        }
        this.mLock.lock();
        try {
            try {
                if (this.mDurationMs == 0 && (mVExtractor = this.mMVExtractor) != null) {
                    int audioIndex = mVExtractor.getAudioIndex();
                    this.mAudioIndex = audioIndex;
                    MediaFormat trackFormat = this.mMVExtractor.getTrackFormat(audioIndex);
                    if (trackFormat != null) {
                        this.mDurationMs = trackFormat.getLong("durationUs") / 1000;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (b.f().debug()) {
                b.f().d(TAG, "=prepare=getDuration:" + this.mDurationMs + "ms end currentTime" + System.currentTimeMillis());
            }
            return this.mDurationMs;
        } finally {
            this.mLock.unlock();
        }
    }

    public long getMvMediaSource() {
        NativeMediaSource nativeMediaSource = this.mMediasource;
        if (nativeMediaSource == null) {
            return 0L;
        }
        return nativeMediaSource.getMvMediaSource();
    }

    public long getUidRxBytes() {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = this.mPm;
        if (packageManager == null) {
            return 0L;
        }
        try {
            applicationInfo = packageManager.getApplicationInfo("com.example.videotest", 1);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        if (TrafficStats.getUidRxBytes(applicationInfo.uid) == -1) {
            b.f().i(TAG, "============getUidRxBytes UNSUPPORTED");
            return 0L;
        }
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        b.f().i(TAG, "============getUidRxBytes rx:" + totalRxBytes + " Byte");
        return totalRxBytes / 1024;
    }

    public void pause() {
        this.mLock.lock();
        try {
            try {
                int i2 = this.mState;
                if (i2 == 3 || i2 == 2) {
                    this.mState = 4;
                    if (b.f().debug()) {
                        b.f().d(TAG, "operation: mediaplayer started => paused");
                    }
                }
                this.mCondition.signalAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public void release() {
        if (b.f().debug()) {
            b.f().d(TAG, "operation: mediaplayer release hashCode:" + hashCode());
        }
        stop();
        NativeMediaSource nativeMediaSource = this.mMediasource;
        if (nativeMediaSource != null) {
            nativeMediaSource.ClearBuffer();
            this.mMediasource.Stop();
        }
        this.mLock.lock();
        try {
            try {
                this.mState = 6;
                this.mCondition.signalAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.mLock.unlock();
            this.mSeektimelock.lock();
            try {
                try {
                    MVExtractor mVExtractor = this.mNewMVExtractor;
                    if (mVExtractor != null) {
                        mVExtractor.release();
                        this.mNewMVExtractor = null;
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } finally {
                this.mSeektimelock.unlock();
            }
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public void seek(long j) {
        Lock lock;
        if (b.f().debug()) {
            b.f().d(TAG, " seek " + j + "us");
        }
        if (j < 0 || this.mOnComplete) {
            if (b.f().debug()) {
                b.f().eLF(TAG, " seek " + j + "us,invalid time or play complete:" + this.mOnComplete);
                return;
            }
            return;
        }
        this.mStartTime = System.currentTimeMillis();
        if (b.f().debug()) {
            b.f().d(TAG, "seek seekTTTT:" + System.currentTimeMillis() + ":" + (System.currentTimeMillis() - this.mStartTime));
        }
        this.mLock.lock();
        int i2 = this.mState;
        if (i2 != 3 && i2 != 2 && i2 != 4) {
            if (b.f().debug()) {
                b.f().eLF(TAG, " seek " + j + "us, Invalid operation, State:" + this.mState);
            }
            this.mLock.unlock();
            return;
        }
        this.mLock.unlock();
        this.mSeektimelock.lock();
        try {
            try {
                this.mSeekTimeUs = j;
                this.mOnComplete = false;
                NativeMediaSource nativeMediaSource = this.mMediasource;
                if (nativeMediaSource != null) {
                    nativeMediaSource.SetSeekState(this.mAudioIndex, true);
                    this.mMediasource.SetSeekState(this.mVideoIndex, true);
                }
                this.mAudioDecoderlock.lock();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                try {
                    this.mAudioSeekDone = false;
                    this.mAudioExtractorDone = false;
                    this.mAudioDecoderCondition.signalAll();
                    lock = this.mAudioDecoderlock;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    lock = this.mAudioDecoderlock;
                }
                lock.unlock();
                this.mVideoSeekDone = false;
                this.mVideoExtractorDone = false;
                MVExtractor mVExtractor = this.mNewMVExtractor;
                if (mVExtractor != null) {
                    mVExtractor.seekTo(this.mSeekTimeUs, 1);
                } else {
                    MVExtractor mVExtractor2 = this.mMVExtractor;
                    if (mVExtractor2 != null) {
                        mVExtractor2.seekTo(this.mSeekTimeUs, 1);
                    }
                }
                this.mSeektimelock.unlock();
                signalAllCondition();
                if (b.f().debug()) {
                    b.f().d(TAG, "seek " + j + "us end");
                }
            } catch (Throwable th) {
                this.mAudioDecoderlock.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            this.mSeektimelock.unlock();
            throw th2;
        }
    }

    public void sendErrorReport(int i2, int i3, Exception exc) {
        int i4;
        int sourcType;
        int i5;
        if (b.f().debug()) {
            b.f().eLF(TAG, "sendErrorReport: err:" + i2 + ",errortype:" + i3 + " Exception:" + exc + " ExceptionNo:" + this.mErrorNo + " VideoExceptionCount:" + mVideoDecodeContinuousExceptionCount + " AudioExceptionCount:" + mAudioDecodeContinuousExceptionCount);
        }
        this.mVarLock.lock();
        boolean z = this.mErrorIsReported;
        if (!z && (((i4 = this.mState) == 3 || i4 == 4) && this.mCurrentId == this.mNewId)) {
            this.mErrorIsReported = true;
            this.mVarLock.unlock();
            MVExtractor mVExtractor = this.mMVExtractor;
            if (mVExtractor != null) {
                int errorState = mVExtractor.getErrorState();
                sourcType = this.mMVExtractor.getSourcType();
                i5 = errorState;
            } else {
                sourcType = -1;
                i5 = -1;
            }
            if (b.f().debug()) {
                b.f().iLF(TAG, "sendErrorReport: MVExtractor:" + this.mMVExtractor + ",inputfileErrorState:" + i5 + " sourcetype:" + sourcType);
            }
            sendErrorReportEvent(i2, i3, sourcType, i5, exc);
            return;
        }
        if (z) {
            if (b.f().debug()) {
                b.f().iLF(TAG, "sendErrorReport: already report,ignore it. err:" + i2 + ",errortype:" + i3);
            }
        } else if (this.mCurrentId != this.mNewId) {
            if (b.f().debug()) {
                b.f().iLF(TAG, "sendErrorReport: wait new mv start,ignore it. currentId:" + this.mCurrentId + " newId:" + this.mNewId);
            }
        } else if (b.f().debug()) {
            b.f().iLF(TAG, "sendErrorReport: alread stop,ignore it. state:" + this.mState);
        }
        this.mVarLock.unlock();
    }

    public void setOnMVListener(Object obj, MVListener mVListener) {
        if (b.f().debug()) {
            b.f().d(TAG, " setMVErrorListener");
        }
        this.mOnListener = mVListener;
        this.mPlaycontroller = obj;
    }

    public void setPm(PackageManager packageManager) throws Exception {
        this.mPm = packageManager;
    }

    public int setSourcePath(String str, long j) {
        if (b.f().debug()) {
            b.f().d(TAG, "setSourcePath entry  currentTime:" + System.currentTimeMillis());
        }
        if (b.f().debug()) {
            b.f().d(TAG, "setSourcePath hashCode:" + hashCode() + " path:" + str + "startMs:" + j);
        }
        this.mLock.lock();
        int i2 = this.mState;
        if (i2 == 3 || i2 == 2 || i2 == 4 || i2 == 6) {
            if (b.f().debug()) {
                b.f().eLF(TAG, "setSourcePath invalid state:" + this.mState);
            }
            return -1;
        }
        try {
            try {
                this.mStartTime = System.currentTimeMillis();
                this.mInputFile = str;
                MVExtractor mVExtractor = this.mNewMVExtractor;
                if (mVExtractor != null) {
                    mVExtractor.release();
                    this.mNewMVExtractor = null;
                }
                MVExtractor mVExtractor2 = new MVExtractor(this.mInputFile, 0L);
                this.mNewMVExtractor = mVExtractor2;
                if (mVExtractor2 != null && j > 0) {
                    mVExtractor2.seekTo(j * 1000, 1);
                    this.mNewMVExtractor.setReadState(-1);
                }
                this.mState = 1;
            } catch (Exception e2) {
                if (b.f().debug()) {
                    b.f().eLF(TAG, "setSourcePath Exception:" + e2);
                }
                e2.printStackTrace();
            }
            this.mLock.unlock();
            this.mTryAgain = true;
            return 0;
        } finally {
            this.mLock.unlock();
        }
    }

    public void setSurface(SurfaceHolder surfaceHolder) {
        if (b.f().debug()) {
            b.f().d(TAG, "setSurface surfaceHolder:" + surfaceHolder);
        }
        this.mSurfaceLock.lock();
        this.mSurfaceHolder = surfaceHolder;
        this.mSurfaceCondition.signalAll();
        this.mSurfaceLock.unlock();
    }

    public int start() {
        int i2;
        Lock lock;
        if (b.f().debug()) {
            b.f().d(TAG, "MainThread start() entry  hashCode:" + hashCode() + "/" + this + " currentTime:" + System.currentTimeMillis() + ":" + (System.currentTimeMillis() - this.mStartTime));
        }
        this.mLock.lock();
        try {
            try {
                i2 = this.mState;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i2 == 0) {
                if (b.f().debug()) {
                    b.f().eLF(TAG, "====start error,please  first set source path and try again");
                }
            } else if (i2 == 3 || i2 == 2) {
                if (b.f().debug()) {
                    b.f().eLF(TAG, "====start error,already started");
                }
            } else {
                if (i2 != 5 && i2 != 6) {
                    if (i2 == 4) {
                        this.mState = 3;
                        if (b.f().debug()) {
                            b.f().d(TAG, "operation: mediaplayer paused => start");
                        }
                        this.mCondition.signalAll();
                        this.mDrawlock.lock();
                        try {
                            try {
                                this.mDrawCondition.signal();
                                lock = this.mDrawlock;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                lock = this.mDrawlock;
                            }
                            lock.unlock();
                            return 0;
                        } catch (Throwable th) {
                            this.mDrawlock.unlock();
                            throw th;
                        }
                    }
                    this.mState = 2;
                    int i3 = this.mNewId + 1;
                    this.mNewId = i3;
                    this.mNewId = i3 % 1000;
                    this.mLock.unlock();
                    new Thread(new Runnable() { // from class: com.kugou.common.player.kugouplayer.MVExtractDecode.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.f().debug()) {
                                b.f().d(MVExtractDecode.TAG, "====run start " + MVExtractDecode.this.mNewId);
                            }
                            MVExtractDecode.this.mMainlock.lock();
                            try {
                                try {
                                    boolean unused = MVExtractDecode.this.mMainThreadIsRun;
                                    while (MVExtractDecode.this.mMainThreadIsRun && (MVExtractDecode.this.mState == 2 || MVExtractDecode.this.mState == 4)) {
                                        MVExtractDecode.this.mMainlock.unlock();
                                        MVExtractDecode.this.signalAllCondition();
                                        MVExtractDecode.this.mMainlock.lock();
                                        MVExtractDecode.this.mMainCondition.awaitNanos(100000000L);
                                    }
                                    if (MVExtractDecode.this.mMainThreadIsRun) {
                                        if (b.f().debug()) {
                                            b.f().eLF(MVExtractDecode.TAG, "MainThread has been stop again, try start, state:" + MVExtractDecode.this.mState);
                                        }
                                        return;
                                    }
                                } catch (InterruptedException e4) {
                                    if (b.f().debug()) {
                                        b.f().eLF(MVExtractDecode.TAG, "==MainThread wait exception");
                                    }
                                    e4.printStackTrace();
                                    MVExtractDecode.this.mErrorNo = 30001;
                                    MVExtractDecode mVExtractDecode = MVExtractDecode.this;
                                    mVExtractDecode.sendErrorReport(mVExtractDecode.mErrorNo, MVExtractDecode.this.mErrorType, e4);
                                }
                                MVExtractDecode.this.mLock.lock();
                                if (MVExtractDecode.this.mState == 5 || MVExtractDecode.this.mState == 6) {
                                    MVExtractDecode.this.mLock.unlock();
                                    return;
                                }
                                MVExtractDecode.this.mState = 3;
                                MVExtractDecode.this.mLock.unlock();
                                Exception e5 = null;
                                try {
                                    try {
                                        MVExtractDecode.this.resetParameters();
                                        MVExtractDecode.this.setCopyVideo();
                                        MVExtractDecode.this.setCopyAudio();
                                        if (MVExtractDecode.this.extractDecodeThread() < 0) {
                                            if (MVExtractDecode.this.mErrorNo == 0) {
                                                MVExtractDecode.this.mErrorNo = 30002;
                                            }
                                            MVExtractDecode mVExtractDecode2 = MVExtractDecode.this;
                                            mVExtractDecode2.sendErrorReport(mVExtractDecode2.mErrorNo, MVExtractDecode.this.mErrorType, null);
                                        }
                                        MVExtractDecode.this.mMainlock.lock();
                                        try {
                                            try {
                                                MVExtractDecode.this.mMainThreadIsRun = false;
                                                MVExtractDecode.this.mMainCondition.signal();
                                            } catch (Exception e6) {
                                                e6.printStackTrace();
                                            }
                                            MVExtractDecode.this.mMainlock.unlock();
                                            if (!b.f().debug()) {
                                                return;
                                            }
                                        } finally {
                                        }
                                    } catch (Throwable th2) {
                                        if (e5 != null) {
                                            if (b.f().debug()) {
                                                b.f().eLF(MVExtractDecode.TAG, "===call=sendErrorReport");
                                            }
                                            if (MVExtractDecode.this.mErrorNo == 0) {
                                                MVExtractDecode.this.mErrorNo = 30003;
                                            }
                                            MVExtractDecode mVExtractDecode3 = MVExtractDecode.this;
                                            mVExtractDecode3.sendErrorReport(mVExtractDecode3.mErrorNo, MVExtractDecode.this.mErrorType, e5);
                                        }
                                        MVExtractDecode.this.mMainlock.lock();
                                        try {
                                            try {
                                                MVExtractDecode.this.mMainThreadIsRun = false;
                                                MVExtractDecode.this.mMainCondition.signal();
                                            } catch (Exception e7) {
                                                e7.printStackTrace();
                                            }
                                            MVExtractDecode.this.mMainlock.unlock();
                                            if (!b.f().debug()) {
                                                throw th2;
                                            }
                                            b.f().d(MVExtractDecode.TAG, "====extractDecodeThread run finally");
                                            throw th2;
                                        } finally {
                                        }
                                    }
                                } catch (Exception e8) {
                                    e5 = e8;
                                    e5.printStackTrace();
                                    if (b.f().debug()) {
                                        b.f().eLF(MVExtractDecode.TAG, "===call=sendErrorReport");
                                    }
                                    if (MVExtractDecode.this.mErrorNo == 0) {
                                        MVExtractDecode.this.mErrorNo = 30003;
                                    }
                                    MVExtractDecode mVExtractDecode4 = MVExtractDecode.this;
                                    mVExtractDecode4.sendErrorReport(mVExtractDecode4.mErrorNo, MVExtractDecode.this.mErrorType, e5);
                                    MVExtractDecode.this.mMainlock.lock();
                                    try {
                                        try {
                                            MVExtractDecode.this.mMainThreadIsRun = false;
                                            MVExtractDecode.this.mMainCondition.signal();
                                        } finally {
                                        }
                                    } catch (Exception e9) {
                                        e9.printStackTrace();
                                    }
                                    MVExtractDecode.this.mMainlock.unlock();
                                    if (!b.f().debug()) {
                                        return;
                                    }
                                }
                                b.f().d(MVExtractDecode.TAG, "====extractDecodeThread run finally");
                            } finally {
                            }
                        }
                    }).start();
                    if (b.f().debug()) {
                        b.f().d(TAG, "start() end  currentTime:" + System.currentTimeMillis() + ":" + (System.currentTimeMillis() - this.mStartTime));
                    }
                    return 0;
                }
                if (b.f().debug()) {
                    b.f().eLF(TAG, "====start error,already stop or release");
                }
            }
            return -1;
        } finally {
            this.mLock.unlock();
        }
    }

    public void stop() {
        if (b.f().debug()) {
            b.f().d(TAG, "stop");
        }
        this.mLock.lock();
        int i2 = this.mState;
        if (i2 == 3 || i2 == 4 || i2 == 2) {
            this.mState = 5;
            this.mLock.unlock();
            if (b.f().debug()) {
                b.f().d(TAG, "operation: mediaplayer stop hashCode:" + hashCode());
            }
            this.mSeektimelock.lock();
            try {
                try {
                    this.mAudioSeekDone = true;
                    this.mVideoSeekDone = true;
                    this.mVideoExtractorDone = true;
                    this.mAudioExtractorDone = true;
                    this.mVideoDecoderDone = true;
                    this.mAudioDecoderDone = true;
                    MVExtractor mVExtractor = this.mMVExtractor;
                    if (mVExtractor != null) {
                        mVExtractor.stop();
                        this.mMVExtractor.release();
                    }
                } catch (Exception e2) {
                    if (b.f().debug()) {
                        b.f().eLF(TAG, "stop Exception:" + e2);
                    }
                    e2.printStackTrace();
                }
                this.mSeektimelock.unlock();
                NativeMediaSource nativeMediaSource = this.mMediasource;
                if (nativeMediaSource != null) {
                    nativeMediaSource.ClearBuffer();
                }
            } catch (Throwable th) {
                this.mSeektimelock.unlock();
                throw th;
            }
        } else {
            this.mLock.unlock();
            if (b.f().debug()) {
                b.f().eLF(TAG, "already stop hashCode:" + hashCode());
            }
        }
        signalAllCondition();
        if (b.f().debug()) {
            b.f().d(TAG, "stop end");
        }
    }

    public void setSurface(Surface surface) {
        if (b.f().debug()) {
            b.f().d(TAG, "setSurface surface:" + surface);
        }
        this.mSurfaceLock.lock();
        try {
            try {
                this.mSurface = surface;
                this.mSurfaceCondition.signalAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            this.mSurfaceLock.unlock();
        }
    }

    public int setSourcePath(long j, long j2) {
        if (b.f().debug()) {
            b.f().d(TAG, "setSourcePath entry  currentTime:" + System.currentTimeMillis());
        }
        if (b.f().debug()) {
            b.f().d(TAG, "setSourcePath hashCode:" + hashCode() + " path:" + j + "startMs:" + j2);
        }
        this.mLock.lock();
        int i2 = this.mState;
        if (i2 != 3 && i2 != 2 && i2 != 4 && i2 != 6) {
            try {
                try {
                    this.mStartTime = System.currentTimeMillis();
                    this.mInputStream = j;
                    MVExtractor mVExtractor = this.mNewMVExtractor;
                    if (mVExtractor != null) {
                        mVExtractor.release();
                        this.mNewMVExtractor = null;
                    }
                    MVExtractor mVExtractor2 = new MVExtractor(null, this.mInputStream);
                    this.mNewMVExtractor = mVExtractor2;
                    if (mVExtractor2 != null && j2 > 0) {
                        mVExtractor2.seekTo(j2 * 1000, 1);
                        this.mNewMVExtractor.setReadState(-1);
                    }
                    this.mState = 1;
                } catch (Exception e2) {
                    if (b.f().debug()) {
                        b.f().eLF(TAG, "setSourcePath Exception:" + e2);
                    }
                    e2.printStackTrace();
                }
                this.mLock.unlock();
                this.mTryAgain = true;
                return 0;
            } finally {
                this.mLock.unlock();
            }
        }
        if (b.f().debug()) {
            b.f().eLF(TAG, "setSourcePath invalid state:" + this.mState);
        }
        return -1;
    }
}
