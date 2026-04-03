package com.tme.fireeye.crash.protector;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class CrashProtector {
    private boolean mHasInit;
    private static volatile CrashProtector mInstance = new CrashProtector();
    private static String TAG = "CrashProtector";
    private boolean mIsRunning = false;
    private volatile a mCrashCallback = null;

    public interface a {
        void onNativeCrashProteced();
    }

    private CrashProtector() {
        this.mHasInit = false;
        try {
            System.loadLibrary("FireEye-rqd");
            this.mHasInit = true;
        } catch (Throwable th) {
            th.printStackTrace();
            this.mHasInit = false;
        }
        Log.d(TAG, "init state is " + this.mHasInit);
    }

    private native boolean canProtectNative();

    private native boolean isProtectionHappened();

    private void onNativeCrashProtected() {
        if (this.mCrashCallback != null) {
            this.mCrashCallback.onNativeCrashProteced();
        }
    }

    private native void setCacheFilePathNative(String str, int i2);

    public static CrashProtector sharedInstance() {
        return mInstance;
    }

    private native int startNative();

    private native int stopNative();

    public boolean canProtect() {
        if (this.mHasInit) {
            return canProtectNative();
        }
        return false;
    }

    public boolean isNativeProtectionHappened() {
        return isProtectionHappened();
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    public void registerCallback(a aVar) {
        this.mCrashCallback = aVar;
    }

    public void setProtectionInfo(String str, int i2) {
        if (this.mHasInit) {
            setCacheFilePathNative(str, i2);
        }
    }

    public void start() {
        if (!this.mIsRunning && this.mHasInit && startNative() == 0) {
            this.mIsRunning = true;
        }
    }

    public void stop() {
        if (this.mIsRunning) {
            stopNative();
        }
        this.mIsRunning = false;
    }
}
