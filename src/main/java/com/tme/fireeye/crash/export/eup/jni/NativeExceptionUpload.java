package com.tme.fireeye.crash.export.eup.jni;

import e.f.a.a.c.c.d.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExceptionUpload {
    public static a a;

    static {
        new AtomicBoolean(true);
    }

    public static synchronized void a(a aVar) {
        a = aVar;
    }

    public static native boolean appendNativeLog(String str, String str2, String str3);

    public static native boolean appendWholeNativeLog(String str);

    public static native void doNativeCrashForTest();

    public static native void enableHandler(boolean z);

    public static native String getNativeKeyValueList();

    public static native String getNativeLog();

    public static native boolean putNativeKeyValue(String str, String str2);

    public static native boolean registNativeExceptionHandler(String str, String str2, int i2);

    public static native String registNativeExceptionHandler2(String str, String str2, int i2, int i3);

    public static native String removeNativeKeyValue(String str);

    public static native void setLogMode(int i2);
}
