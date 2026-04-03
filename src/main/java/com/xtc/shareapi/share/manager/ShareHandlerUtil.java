package com.xtc.shareapi.share.manager;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class ShareHandlerUtil {
    private static Handler backgroundHandler;
    private static Handler mainHandler = new Handler(Looper.getMainLooper());

    static {
        HandlerThread handlerThread = new HandlerThread("background_thread", 10);
        handlerThread.start();
        backgroundHandler = new Handler(handlerThread.getLooper());
    }

    public static void runOnBackground(Runnable runnable) {
        backgroundHandler.post(runnable);
    }

    public static void runOnBackgroundDelay(Runnable runnable, long j) {
        backgroundHandler.postDelayed(runnable, j);
    }

    public static void runOnUIThread(Runnable runnable) {
        mainHandler.post(runnable);
    }

    public static void runOnUIThreadDelay(Runnable runnable, long j) {
        mainHandler.postDelayed(runnable, j);
    }
}
