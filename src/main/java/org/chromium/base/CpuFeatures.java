package org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CpuFeatures {
    private static native int nativeGetCoreCount();

    private static native long nativeGetCpuFeatures();
}
