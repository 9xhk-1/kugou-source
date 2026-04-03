package com.kugou.framework.musichunter.v2;

import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.kugou.framework.musichunter.MusicHunter;
import com.kugou.framework.musichunter.RecognizeResult;
import com.kugou.framework.musichunter.RecordType;
import com.kugou.framework.musichunter.v2.IdentifyProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class MusicHunterProcessorMgr implements IdentifyProcessor.OnProcessFinish {
    private boolean canceled;
    private RecognizeResult finalResult;

    @NonNull
    private IdentifyContext identifyCtx;
    private boolean isPcmEnd;
    private final List<IdentifyProcessor> mIdentifyProcessor;
    private final int maxSlice;
    private OnProcessListener onProcessListener;
    private long startTime;
    private long stopTime;

    public interface OnProcessListener {
        void onFinish(RecognizeResult recognizeResult);

        void onFirstLeverEnd(RecognizeResult recognizeResult, boolean z);
    }

    public MusicHunterProcessorMgr(IdentifyContext identifyContext, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.mIdentifyProcessor = arrayList;
        this.identifyCtx = identifyContext;
        int i2 = identifyContext.recordType;
        this.maxSlice = maxSlices(i2);
        if (i2 != RecordType.TYPE_HUMMING) {
            createPcmModelProcess();
            return;
        }
        if (z) {
            arrayList.add(new QingChangProcessor(new IdentifyProcessor.Scheduler.Parallel(), this, identifyContext));
        }
        arrayList.add(new FCProcessor(new IdentifyProcessor.Scheduler.Serial(), this, identifyContext));
    }

    private void createPcmModelProcess() {
        this.mIdentifyProcessor.add(new PcmModelProcessor(new IdentifyProcessor.Scheduler.Parallel(), this, this.identifyCtx));
    }

    private void log(String str) {
        Log.d("IdentifyProcessor", str);
    }

    public static int maxSlices(@IntRange(from = 0) int i2) {
        return 15;
    }

    private synchronized void onFinalResult(RecognizeResult recognizeResult) {
        if (this.finalResult == null) {
            this.finalResult = recognizeResult;
            cancel();
            OnProcessListener onProcessListener = this.onProcessListener;
            if (onProcessListener != null) {
                onProcessListener.onFinish(recognizeResult);
            }
        }
    }

    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.stopTime = System.currentTimeMillis();
        this.canceled = true;
        Iterator<IdentifyProcessor> it = this.mIdentifyProcessor.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    public long getUseTime() {
        long j;
        long jCurrentTimeMillis = this.stopTime;
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
            j = this.startTime;
        } else {
            j = this.startTime;
        }
        return jCurrentTimeMillis - j;
    }

    @Override // com.kugou.framework.musichunter.v2.IdentifyProcessor.OnProcessFinish
    public void onFinish(IdentifyProcessor identifyProcessor, RecognizeResult recognizeResult) {
        boolean z;
        if (recognizeResult.isValid()) {
            onFinalResult(recognizeResult);
            return;
        }
        Iterator<IdentifyProcessor> it = this.mIdentifyProcessor.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().hasRamainTask();
            }
        }
        if (z) {
            return;
        }
        RecognizeResult recognizeResult2 = this.identifyCtx.fallBackResult;
        if (recognizeResult2 != null) {
            recognizeResult = recognizeResult2;
        }
        onFinalResult(recognizeResult);
    }

    public void overTime() {
        cancel();
    }

    public void process(@IntRange(from = 0) int i2, MusicHunter.MakeFingerprint makeFingerprint) {
        this.isPcmEnd = this.isPcmEnd || makeFingerprint.pcmEnd || i2 >= this.maxSlice;
        log(String.format(Locale.CHINA, "收到第%d秒音频, pcmEnd=%s, realPcmEnd=%s", Integer.valueOf(i2), Boolean.valueOf(makeFingerprint.pcmEnd), Boolean.valueOf(this.isPcmEnd)));
        PcmData pcmData = new PcmData(i2, makeFingerprint.pcmBuffer, makeFingerprint.pcmEnd, makeFingerprint.timeLength);
        Iterator<IdentifyProcessor> it = this.mIdentifyProcessor.iterator();
        while (it.hasNext()) {
            it.next().scheduleProcess(pcmData);
        }
    }

    public void release() {
        Iterator<IdentifyProcessor> it = this.mIdentifyProcessor.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }

    public void setLocalPcm(String str) {
        IdentifyContext identifyContext = IdentifyContext.mCurContext;
        identifyContext.localPcmName = str;
        identifyContext.isLocal = true;
    }

    public void setOnProcessListener(OnProcessListener onProcessListener) {
        this.onProcessListener = onProcessListener;
    }

    public void setPcmEnd(boolean z) {
        Iterator<IdentifyProcessor> it = this.mIdentifyProcessor.iterator();
        while (it.hasNext()) {
            it.next().setPcmEnd(z);
        }
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }
}
