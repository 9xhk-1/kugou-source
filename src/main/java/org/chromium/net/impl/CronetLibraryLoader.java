package org.chromium.net.impl;

import android.os.ConditionVariable;
import android.os.HandlerThread;
import h.a.b.o.c;

/* JADX INFO: loaded from: classes2.dex */
public class CronetLibraryLoader {
    static {
        String str = "cronet." + c.a();
        new HandlerThread("CronetInit");
        new ConditionVariable();
    }

    private static native void nativeCronetInitOnInitThread();

    private static native String nativeGetCronetVersion();
}
