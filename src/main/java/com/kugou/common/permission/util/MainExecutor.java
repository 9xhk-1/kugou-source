package com.kugou.common.permission.util;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class MainExecutor {
    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    public void post(Runnable runnable) {
        HANDLER.post(runnable);
    }

    public void postDelayed(Runnable runnable, long j) {
        HANDLER.postDelayed(runnable, j);
    }
}
