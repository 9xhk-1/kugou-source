package com.kugou.framework.musichunter.v2;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.kugou.framework.libcommon.LogUtils;
import com.kugou.framework.musichunter.Global;
import com.kugou.framework.musichunter.RecognizeResult;
import com.kugou.framework.worker.WorkScheduler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IdentifyProcessor {
    public static final int FROM_FC = 3;
    public static final int FROM_FINGER = 1;
    public static final int FROM_PCM = 7;
    public static final int FROM_QC = 4;
    public static final int FROM_QM = 5;
    public static final int FROM_QM_FC = 6;
    public static final int FROM_SECOND = 2;
    public static final int FROM_UNKNOWN = 0;
    public boolean canceled;
    private IdentifyContext mIdentifyContext;

    @NonNull
    private OnProcessFinish onProcessFinish;
    private boolean pcmEnd;
    public List<IdentifyTask> scheduleTasks = Collections.synchronizedList(new ArrayList());
    public Scheduler scheduler;

    public static class IdentifyTask implements Runnable {
        public static final String TAG = "IdentifyTask";
        public volatile boolean isCanceled;

        @NonNull
        public IdentifyProcessor model;

        @NonNull
        public PcmData pcmData;

        @NonNull
        public OnTaskResult resultCallBack;

        public IdentifyTask(@NonNull IdentifyProcessor identifyProcessor, @NonNull PcmData pcmData) {
            this.model = identifyProcessor;
            this.pcmData = pcmData;
        }

        public void cancel() {
            this.isCanceled = true;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            RecognizeResult recognizeResultProcess;
            try {
                if (this.isCanceled) {
                    recognizeResultProcess = this.model.buildInvalidResult(1);
                    LogUtils.d(TAG, String.format("task is canceled. data:%s processor:%s", this.pcmData.getLogIdStr(), this.model.getLogIdStr()));
                } else {
                    recognizeResultProcess = this.model.process(this.pcmData);
                }
                this.resultCallBack.onResult(recognizeResultProcess);
            } catch (Exception e2) {
                if (Global.isDebugModel()) {
                    throw e2;
                }
            }
        }
    }

    public interface OnProcessFinish {
        void onFinish(IdentifyProcessor identifyProcessor, RecognizeResult recognizeResult);
    }

    public interface OnTaskResult {
        void onResult(RecognizeResult recognizeResult);
    }

    public static abstract class Scheduler {
        public List<IdentifyTask> schedulingTasks = Collections.synchronizedList(new ArrayList());

        public static class DIRECT extends Scheduler {
            @Override // com.kugou.framework.musichunter.v2.IdentifyProcessor.Scheduler
            public void doSchedule(IdentifyTask identifyTask) throws Exception {
                identifyTask.run();
            }
        }

        public static class Parallel extends Scheduler {
            public static final String TAG = "Identify.Scheduler.Parallel";

            @Override // com.kugou.framework.musichunter.v2.IdentifyProcessor.Scheduler
            public void doSchedule(IdentifyTask identifyTask) {
                new WorkScheduler(TAG).post(identifyTask);
            }
        }

        public static class Serial extends Scheduler {
            public static final String TAG = "Identify.Scheduler.Serial";
            private final WorkScheduler mScheduler = new WorkScheduler(TAG);

            @Override // com.kugou.framework.musichunter.v2.IdentifyProcessor.Scheduler
            public void doSchedule(IdentifyTask identifyTask) {
                this.mScheduler.post(identifyTask);
            }
        }

        public abstract void doSchedule(IdentifyTask identifyTask);
    }

    public IdentifyProcessor(Scheduler scheduler, @NonNull OnProcessFinish onProcessFinish, IdentifyContext identifyContext) {
        this.scheduler = scheduler;
        this.onProcessFinish = onProcessFinish;
        this.mIdentifyContext = identifyContext;
    }

    private void cancelAllTask() {
        for (IdentifyTask identifyTask : this.scheduleTasks) {
            if (!identifyTask.isCanceled) {
                identifyTask.cancel();
            }
        }
    }

    public RecognizeResult buildInvalidResult(@IntRange(from = 0) int i2) {
        return RecognizeResult.buildInvalidResult2(this instanceof PcmModelProcessor ? 7 : 0, i2);
    }

    public void cancel() {
        cancelAllTask();
        this.canceled = true;
    }

    public long getFinalTime() {
        return this.mIdentifyContext.finalTime;
    }

    public IdentifyContext getIdentifyContext() {
        return this.mIdentifyContext;
    }

    public String getLogIdStr() {
        return "IdentifyProcessor";
    }

    public int getMaxSlice() {
        return this.mIdentifyContext.maxSlice;
    }

    public String getPcmFileName() {
        IdentifyContext identifyContext = this.mIdentifyContext;
        return identifyContext.isLocal ? identifyContext.localPcmName : identifyContext.pcmFileName;
    }

    public int getRecordType() {
        return this.mIdentifyContext.recordType;
    }

    public int getTaskId() {
        return this.mIdentifyContext.taskId;
    }

    public long getUniqueId() {
        return this.mIdentifyContext.uniqueId;
    }

    public boolean hasRamainTask() {
        return !this.scheduleTasks.isEmpty();
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isLocalIdentify() {
        return this.mIdentifyContext.isLocal;
    }

    public boolean isOverTime() {
        return System.nanoTime() >= getFinalTime();
    }

    public void log(String str) {
        LogUtils.log(str);
    }

    public abstract RecognizeResult process(PcmData pcmData);

    public byte[] readPcmBuffer(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        return this.mIdentifyContext.pcmSlices.readPcmBuffer(i2, i3);
    }

    public void release() {
    }

    public void scheduleProcess(final PcmData pcmData) {
        if (isCanceled() || isOverTime()) {
            log("识别取消或超时，放弃schedule" + pcmData.getLogIdStr());
            return;
        }
        final IdentifyTask identifyTask = new IdentifyTask(this, pcmData);
        identifyTask.resultCallBack = new OnTaskResult() { // from class: com.kugou.framework.musichunter.v2.IdentifyProcessor.1
            @Override // com.kugou.framework.musichunter.v2.IdentifyProcessor.OnTaskResult
            public void onResult(RecognizeResult recognizeResult) {
                IdentifyProcessor.this.scheduleTasks.remove(identifyTask);
                if (IdentifyProcessor.this.isCanceled() || IdentifyProcessor.this.isOverTime()) {
                    IdentifyProcessor.this.log("识别取消或超时，拦截结果" + pcmData.getLogIdStr());
                    return;
                }
                IdentifyProcessor identifyProcessor = IdentifyProcessor.this;
                identifyProcessor.pcmEnd = identifyProcessor.pcmEnd || pcmData.pcmEnd;
                if (recognizeResult.isValid()) {
                    IdentifyProcessor.this.cancel();
                }
                if (recognizeResult.isValid() || (IdentifyProcessor.this.pcmEnd && !IdentifyProcessor.this.hasRamainTask())) {
                    IdentifyProcessor.this.onProcessFinish.onFinish(IdentifyProcessor.this, recognizeResult);
                }
            }
        };
        this.scheduleTasks.add(identifyTask);
        this.scheduler.doSchedule(identifyTask);
    }

    public void setPcmEnd(boolean z) {
        this.pcmEnd = z;
    }
}
