package org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class JavaHandlerThread {
    private native void nativeInitializeThread(long j, long j2);

    private native void nativeOnLooperStopped(long j);

    private native void nativeStopThread(long j);
}
