package com.kugou.framework.libcommon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class KGThreadPool {
    private static KGThreadPool sPool;
    private ExecutorService mPoolService = Executors.newCachedThreadPool();

    private KGThreadPool() {
    }

    public static KGThreadPool getInstance() {
        if (sPool == null) {
            init();
        }
        return sPool;
    }

    private static synchronized void init() {
        sPool = new KGThreadPool();
    }

    public void execute(Runnable runnable) {
        if (runnable == null || this.mPoolService.isShutdown()) {
            return;
        }
        this.mPoolService.execute(runnable);
    }

    public void shutdown() {
        this.mPoolService.shutdown();
        sPool = null;
        this.mPoolService = null;
    }
}
