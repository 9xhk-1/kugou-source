package com.kugou.framework.bilib.bi.easytrace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class StatisticsThreadPool {
    private static volatile StatisticsThreadPool sPool;
    private ExecutorService mPoolService = Executors.newScheduledThreadPool(0);

    private StatisticsThreadPool() {
    }

    public static synchronized StatisticsThreadPool getInstance() {
        if (sPool == null) {
            sPool = new StatisticsThreadPool();
        }
        return sPool;
    }

    public void execute(Runnable runnable) {
        ExecutorService executorService;
        if (runnable == null || this.mPoolService.isShutdown() || (executorService = this.mPoolService) == null) {
            return;
        }
        executorService.execute(runnable);
    }

    public void shutdown() {
        this.mPoolService.shutdown();
        sPool = null;
        this.mPoolService = null;
    }
}
