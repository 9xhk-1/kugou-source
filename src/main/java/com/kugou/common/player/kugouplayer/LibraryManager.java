package com.kugou.common.player.kugouplayer;

/* JADX INFO: loaded from: classes2.dex */
public class LibraryManager {
    private static boolean mLibraryLoadSuccess = false;

    public static final synchronized boolean loadLibrary() {
        boolean z = mLibraryLoadSuccess;
        if (z) {
            return z;
        }
        try {
            System.loadLibrary("ffmpeg");
            System.loadLibrary("kugouplayer");
            PlayController.native_init();
            mLibraryLoadSuccess = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            mLibraryLoadSuccess = false;
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            mLibraryLoadSuccess = false;
        }
        return mLibraryLoadSuccess;
    }

    public static final synchronized boolean nativeInit() {
        boolean z = mLibraryLoadSuccess;
        if (z) {
            return z;
        }
        try {
            PlayController.native_init();
            mLibraryLoadSuccess = true;
        } catch (Exception unused) {
        }
        return mLibraryLoadSuccess;
    }
}
