package com.tencent.tmachine.trace.looper.monitor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.tencent.tmachine.trace.looper.data.DispatchRecordTrace;
import com.tencent.tmachine.trace.looper.data.HistoryRecord;
import com.tencent.tmachine.trace.looper.data.KeyPendingMsg;
import com.tencent.tmachine.trace.looper.data.MsgDesc;
import com.tencent.tmachine.trace.looper.data.PendingMsgTrace;
import com.tencent.tmachine.trace.looper.data.PendingRecord;
import com.tencent.tmachine.trace.looper.data.RunningRecord;
import com.tencent.tmachine.trace.looper.data.SyncBarrierMsg;
import com.tencent.tmachine.trace.looper.listeners.ILooperListener;
import com.tencent.tmachine.trace.looper.util.ActivityThreadUtil;
import com.tencent.tmachine.trace.looper.util.LooperUtil;
import com.tencent.tmachine.trace.util.TMachineLog;
import com.tencent.tmachine.trace.util.TraceUtil;
import f.u.m;
import f.z.d.g;
import f.z.d.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class LooperMsgDispatchMonitor implements ILooperListener, Handler.Callback {
    private static final long NOT_INIT = -1;
    private static final String TAG = "LooperMsgDispatchMonitor";
    private static Message activityThreadHMsg;
    private static Config config;
    private static Handler historyMsgHandler;
    private static HandlerThread historyMsgHandlerThread;
    private static boolean isStarted;
    private static HistoryRecord multiDispatchRecord;
    public static final LooperMsgDispatchMonitor INSTANCE = new LooperMsgDispatchMonitor();
    private static long startWallTime = -1;
    private static long startCpuTime = -1;
    private static long endWallTime = -1;
    private static long endCpuTime = -1;
    private static long curMsgStartTime = -1;
    private static final ConcurrentLinkedQueue<HistoryRecord> cache = new ConcurrentLinkedQueue<>();

    public static final class Config {
        public static final Companion Companion = new Companion(null);
        public static final long DEFAULT_CLUSTER_THRESHOLD = 300;
        public static final int DEFAULT_DISPATCH_RECORD_CACHE_MAX_SIZE = 100;
        public static final long DEFAULT_IDLE_MAX_THRESHOLD = 300;
        public static final long DEFAULT_SPLIT_THRESHOLD = 300;
        private long clusterThreshold = 300;
        private long splitThreshold = 300;
        private long idleMaxThreshold = 300;
        private int dispatchRecordCacheMaxSize = 100;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }
        }

        public final long getClusterThreshold() {
            return this.clusterThreshold;
        }

        public final int getDispatchRecordCacheMaxSize() {
            return this.dispatchRecordCacheMaxSize;
        }

        public final long getIdleMaxThreshold() {
            return this.idleMaxThreshold;
        }

        public final long getSplitThreshold() {
            return this.splitThreshold;
        }

        public final void setClusterThreshold(long j) {
            this.clusterThreshold = j;
        }

        public final void setDispatchRecordCacheMaxSize(int i2) {
            this.dispatchRecordCacheMaxSize = i2;
        }

        public final void setIdleMaxThreshold(long j) {
            this.idleMaxThreshold = j;
        }

        public final void setSplitThreshold(long j) {
            this.splitThreshold = j;
        }
    }

    private LooperMsgDispatchMonitor() {
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getCache$p(LooperMsgDispatchMonitor looperMsgDispatchMonitor) {
        return cache;
    }

    public static final /* synthetic */ Config access$getConfig$p(LooperMsgDispatchMonitor looperMsgDispatchMonitor) {
        Config config2 = config;
        if (config2 != null) {
            return config2;
        }
        j.t("config");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HistoryRecord generateHistoryRecord(long j, long j2, long j3, int i2, String str, MsgDesc msgDesc) {
        HistoryRecord historyRecord = new HistoryRecord(j, i2);
        historyRecord.setWallTime(j2);
        historyRecord.setCpuTime(j3);
        if (i2 == 3) {
            historyRecord.setMsgCount(0);
        } else {
            historyRecord.setMsgCount(1);
        }
        historyRecord.setDesc(str);
        historyRecord.setMsgDesc(msgDesc);
        return historyRecord;
    }

    public static /* synthetic */ HistoryRecord generateHistoryRecord$default(LooperMsgDispatchMonitor looperMsgDispatchMonitor, long j, long j2, long j3, int i2, String str, MsgDesc msgDesc, int i3, Object obj) {
        return looperMsgDispatchMonitor.generateHistoryRecord(j, j2, j3, i2, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? null : msgDesc);
    }

    private final HandlerThread getNewHandlerThread() {
        HandlerThread handlerThread = new HandlerThread("historyMsgHandlerThread");
        handlerThread.setPriority(5);
        handlerThread.start();
        return handlerThread;
    }

    private final void recordHistoryDispatch(final HistoryRecord historyRecord) {
        Handler handler = historyMsgHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.tmachine.trace.looper.monitor.LooperMsgDispatchMonitor.recordHistoryDispatch.1
                @Override // java.lang.Runnable
                public final void run() {
                    LooperMsgDispatchMonitor looperMsgDispatchMonitor = LooperMsgDispatchMonitor.INSTANCE;
                    if (LooperMsgDispatchMonitor.access$getCache$p(looperMsgDispatchMonitor).size() == LooperMsgDispatchMonitor.access$getConfig$p(looperMsgDispatchMonitor).getDispatchRecordCacheMaxSize()) {
                        LooperMsgDispatchMonitor.access$getCache$p(looperMsgDispatchMonitor).poll();
                    }
                    LooperMsgDispatchMonitor.access$getCache$p(looperMsgDispatchMonitor).offer(historyRecord);
                }
            });
        }
    }

    public static /* synthetic */ void recordHistoryDispatch$default(LooperMsgDispatchMonitor looperMsgDispatchMonitor, long j, long j2, long j3, int i2, Message message, int i3, Object obj) {
        looperMsgDispatchMonitor.recordHistoryDispatch(j, j2, j3, i2, (i3 & 16) != 0 ? null : message);
    }

    private final void recordMultiDispatch() {
        HistoryRecord historyRecord = multiDispatchRecord;
        if (historyRecord != null) {
            INSTANCE.recordHistoryDispatch(historyRecord);
        }
        multiDispatchRecord = null;
    }

    public static /* synthetic */ void startMonitor$default(LooperMsgDispatchMonitor looperMsgDispatchMonitor, Config config2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config2 = null;
        }
        looperMsgDispatchMonitor.startMonitor(config2);
    }

    public final PendingMsgTrace generatePendingMsgTrace(List<Message> list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int msgCount = 0;
        ArrayList arrayList3 = null;
        if (list == null || list.isEmpty()) {
            arrayList = null;
            arrayList2 = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            PendingRecord pendingRecord = null;
            arrayList = null;
            arrayList2 = null;
            int msgCount2 = 0;
            for (Object obj : list) {
                int i2 = msgCount + 1;
                if (msgCount < 0) {
                    m.i();
                    throw null;
                }
                Message message = (Message) obj;
                long jUptimeMillis = SystemClock.uptimeMillis() - message.getWhen();
                MsgDesc msgDesc = MsgDesc.Companion.toMsgDesc(message);
                if (msgDesc != null && msgDesc.getTarget() == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    if (arrayList != null) {
                        arrayList.add(new SyncBarrierMsg(msgCount, jUptimeMillis, msgDesc));
                    }
                }
                String strIsKeyMsg = ActivityThreadUtil.isKeyMsg(message);
                if (strIsKeyMsg != null) {
                    if (pendingRecord != null) {
                        if (pendingRecord == null) {
                            j.n();
                            throw null;
                        }
                        msgCount2 += pendingRecord.getMsgCount();
                        if (pendingRecord == null) {
                            j.n();
                            throw null;
                        }
                        arrayList4.add(pendingRecord);
                        pendingRecord = null;
                    }
                    msgCount2++;
                    arrayList4.add(new PendingRecord(jUptimeMillis, strIsKeyMsg, msgDesc));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(new KeyPendingMsg(jUptimeMillis, strIsKeyMsg, msgDesc));
                    }
                } else if (pendingRecord == null) {
                    pendingRecord = new PendingRecord(jUptimeMillis, null, msgDesc);
                } else {
                    if (pendingRecord == null) {
                        j.n();
                        throw null;
                    }
                    pendingRecord.setMsgCount(pendingRecord.getMsgCount() + 1);
                }
                msgCount = i2;
            }
            if (pendingRecord == null) {
                arrayList3 = arrayList4;
                msgCount = msgCount2;
            } else {
                if (pendingRecord == null) {
                    j.n();
                    throw null;
                }
                msgCount = msgCount2 + pendingRecord.getMsgCount();
                if (pendingRecord == null) {
                    j.n();
                    throw null;
                }
                arrayList4.add(pendingRecord);
                arrayList3 = arrayList4;
            }
        }
        return new PendingMsgTrace(arrayList3, msgCount, arrayList, arrayList2);
    }

    public final JSONObject generatePendingMsgTraceJsonObject() {
        return TraceUtil.pendingMsgTraceToJSON(generatePendingMsgTrace(LooperUtil.getLooperPendingMessages()));
    }

    public final DispatchRecordTrace getCache() {
        if (!isStarted()) {
            TMachineLog.e(TAG, "looper message dispatch monitor is not enable, return null", new Object[0]);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(cache);
        HistoryRecord historyRecord = multiDispatchRecord;
        if (historyRecord != null) {
            arrayList.add(historyRecord);
        }
        long j = curMsgStartTime;
        RunningRecord runningRecord = j != -1 ? new RunningRecord(j, SystemClock.elapsedRealtime() - j) : null;
        PendingMsgTrace pendingMsgTraceGeneratePendingMsgTrace = generatePendingMsgTrace(LooperUtil.getLooperPendingMessages());
        DispatchRecordTrace dispatchRecordTrace = new DispatchRecordTrace(arrayList, runningRecord, pendingMsgTraceGeneratePendingMsgTrace.getPendingRecordList());
        dispatchRecordTrace.setPendingMsgCnt(pendingMsgTraceGeneratePendingMsgTrace.getPendingMsgCnt());
        dispatchRecordTrace.setSyncBarrierMsgList(pendingMsgTraceGeneratePendingMsgTrace.getSyncBarrierMsgList());
        dispatchRecordTrace.setKeyPendingMsgList(pendingMsgTraceGeneratePendingMsgTrace.getKeyPendingMsgList());
        return dispatchRecordTrace;
    }

    public final JSONObject getCacheJsonObject() {
        DispatchRecordTrace cache2 = getCache();
        if (cache2 == null) {
            return null;
        }
        return TraceUtil.dispatchRecordTraceToJSON(cache2);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        j.f(message, NotificationCompat.CATEGORY_MESSAGE);
        activityThreadHMsg = message;
        return true;
    }

    public final synchronized boolean isStarted() {
        return isStarted;
    }

    @Override // com.tencent.tmachine.trace.looper.listeners.ILooperListener
    public boolean isValid() {
        return true;
    }

    @Override // com.tencent.tmachine.trace.looper.listeners.ILooperListener
    public void onDispatchBegin(String str) {
        startWallTime = SystemClock.elapsedRealtime();
        startCpuTime = SystemClock.currentThreadTimeMillis();
        long j = startWallTime;
        curMsgStartTime = j;
        long j2 = endWallTime;
        if (j2 != -1) {
            long j3 = j - j2;
            Config config2 = config;
            if (config2 == null) {
                j.t("config");
                throw null;
            }
            if (j3 >= config2.getIdleMaxThreshold()) {
                recordMultiDispatch();
                recordHistoryDispatch$default(this, endWallTime, j3, startCpuTime - endCpuTime, 3, null, 16, null);
            }
        }
    }

    @Override // com.tencent.tmachine.trace.looper.listeners.ILooperListener
    public void onDispatchEnd(String str, long j, long j2) {
        curMsgStartTime = -1L;
        endWallTime = SystemClock.elapsedRealtime();
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        endCpuTime = jCurrentThreadTimeMillis;
        long j3 = endWallTime - startWallTime;
        long j4 = jCurrentThreadTimeMillis - startCpuTime;
        Message message = activityThreadHMsg;
        activityThreadHMsg = null;
        if (ActivityThreadUtil.hasHacked && message != null && ActivityThreadUtil.isKeyMsg(message) != null) {
            recordMultiDispatch();
            recordHistoryDispatch(generateHistoryRecord(startWallTime, j3, j4, 4, ActivityThreadUtil.isKeyMsg(message), MsgDesc.Companion.toMsgDesc(message)));
            return;
        }
        Config config2 = config;
        if (config2 == null) {
            j.t("config");
            throw null;
        }
        if (j3 >= config2.getSplitThreshold()) {
            recordMultiDispatch();
            recordHistoryDispatch$default(this, startWallTime, j3, j4, 2, null, 16, null);
            return;
        }
        HistoryRecord historyRecordGenerateHistoryRecord$default = multiDispatchRecord;
        if (historyRecordGenerateHistoryRecord$default == null) {
            historyRecordGenerateHistoryRecord$default = generateHistoryRecord$default(this, startWallTime, j3, j4, 1, null, null, 48, null);
            multiDispatchRecord = historyRecordGenerateHistoryRecord$default;
        } else {
            historyRecordGenerateHistoryRecord$default.setWallTime(historyRecordGenerateHistoryRecord$default.getWallTime() + j3);
            historyRecordGenerateHistoryRecord$default.setCpuTime(historyRecordGenerateHistoryRecord$default.getCpuTime() + j4);
            historyRecordGenerateHistoryRecord$default.setMsgCount(historyRecordGenerateHistoryRecord$default.getMsgCount() + 1);
        }
        long wallTime = historyRecordGenerateHistoryRecord$default.getWallTime();
        Config config3 = config;
        if (config3 == null) {
            j.t("config");
            throw null;
        }
        if (wallTime > config3.getClusterThreshold()) {
            recordMultiDispatch();
        }
    }

    public final void startMonitor() {
        startMonitor$default(this, null, 1, null);
    }

    public final synchronized void startMonitor(Config config2) {
        if (isStarted()) {
            return;
        }
        TMachineLog.i(TAG, "start looper message dispatch monitor", new Object[0]);
        if (config2 == null) {
            config2 = new Config();
        }
        config = config2;
        historyMsgHandlerThread = getNewHandlerThread();
        HandlerThread handlerThread = historyMsgHandlerThread;
        if (handlerThread == null) {
            j.n();
            throw null;
        }
        historyMsgHandler = new Handler(handlerThread.getLooper());
        ActivityThreadUtil.hackSysHandlerCallback();
        ActivityThreadUtil.register(this);
        LooperMonitor.register(this);
        isStarted = true;
    }

    public final synchronized void stopMonitor() {
        if (isStarted()) {
            TMachineLog.i(TAG, "stop looper message dispatch monitor", new Object[0]);
            startWallTime = -1L;
            startCpuTime = -1L;
            endWallTime = -1L;
            endCpuTime = -1L;
            curMsgStartTime = -1L;
            ActivityThreadUtil.unRegister(this);
            LooperMonitor.unregister(this);
            cache.clear();
            Handler handler = historyMsgHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            historyMsgHandler = null;
            try {
                HandlerThread handlerThread = historyMsgHandlerThread;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                historyMsgHandlerThread = null;
            } catch (Throwable unused) {
            }
            isStarted = false;
        }
    }

    private final void recordHistoryDispatch(final long j, final long j2, final long j3, final int i2, final Message message) {
        Handler handler = historyMsgHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.tmachine.trace.looper.monitor.LooperMsgDispatchMonitor.recordHistoryDispatch.2
                @Override // java.lang.Runnable
                public final void run() {
                    Message message2;
                    LooperMsgDispatchMonitor looperMsgDispatchMonitor = LooperMsgDispatchMonitor.INSTANCE;
                    if (LooperMsgDispatchMonitor.access$getCache$p(looperMsgDispatchMonitor).size() == LooperMsgDispatchMonitor.access$getConfig$p(looperMsgDispatchMonitor).getDispatchRecordCacheMaxSize()) {
                        LooperMsgDispatchMonitor.access$getCache$p(looperMsgDispatchMonitor).poll();
                    }
                    LooperMsgDispatchMonitor.access$getCache$p(looperMsgDispatchMonitor).offer(looperMsgDispatchMonitor.generateHistoryRecord(j, j2, j3, i2, (!ActivityThreadUtil.hasHacked || (message2 = message) == null) ? null : ActivityThreadUtil.isKeyMsg(message2), MsgDesc.Companion.toMsgDesc(message)));
                }
            });
        }
    }
}
