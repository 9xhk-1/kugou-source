package com.kugou.framework.bilib.bi;

import com.kugou.framework.bilib.LibLog;
import com.kugou.framework.bilib.bi.easytrace.EasytraceSender;
import com.kugou.framework.bilib.bi.easytrace.StatisticsThreadPool;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.bilib.common.SystemUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TraceDog {
    private static final String TAG = "TraceDog";
    private static volatile TraceDog sInstance;

    public static class Traceable implements Runnable {
        private AbstractTraceTask mTask;

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!SystemUtils.isWifi(LibConfig.getContext())) {
                    this.mTask.setPostpone();
                }
                HashMap<String, Object> mapRecordMap = this.mTask.recordMap();
                if (LibConfig.isDebug()) {
                    LibLog.d("cjy", "<-----param=" + mapRecordMap.toString());
                }
                if (mapRecordMap == null || mapRecordMap.size() <= 0) {
                    return;
                }
                EasytraceSender.send(mapRecordMap, LibConfig.getInstance().getBiConfigKey());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private Traceable(AbstractTraceTask abstractTraceTask) {
            this.mTask = abstractTraceTask;
        }
    }

    private TraceDog() {
    }

    private void executeTrace(AbstractTraceTask abstractTraceTask) {
        Traceable traceable = new Traceable(abstractTraceTask);
        if (abstractTraceTask.isSync()) {
            traceable.run();
        } else {
            StatisticsThreadPool.getInstance().execute(traceable);
        }
    }

    public static TraceDog getInstance() {
        if (sInstance == null) {
            synchronized (TraceDog.class) {
                if (sInstance == null) {
                    sInstance = new TraceDog();
                }
            }
        }
        return sInstance;
    }

    public void trace(AbstractTraceTask abstractTraceTask) {
        if (abstractTraceTask == null) {
            return;
        }
        executeTrace(abstractTraceTask);
    }
}
