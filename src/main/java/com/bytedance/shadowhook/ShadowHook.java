package com.bytedance.shadowhook;

import i.b;
import sdk.SdkMark;

/* JADX INFO: loaded from: classes.dex */
@SdkMark(code = 536)
public final class ShadowHook {

    @SdkMark(code = 536)
    public enum a {
        SHARED(0),
        UNIQUE(1);

        public final int a;

        static {
            b.a();
        }

        a(int i2) {
            this.a = i2;
        }

        public int a() {
            return this.a;
        }
    }

    static {
        b.a();
        a.SHARED.a();
    }

    private static native String nativeGetArch();

    private static native boolean nativeGetDebuggable();

    private static native int nativeGetInitErrno();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int i2);

    private static native String nativeGetVersion();

    private static native int nativeInit(int i2, boolean z);

    private static native void nativeSetDebuggable(boolean z);

    private static native void nativeSetRecordable(boolean z);

    private static native String nativeToErrmsg(int i2);
}
