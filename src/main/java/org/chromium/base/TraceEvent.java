package org.chromium.base;

/* JADX INFO: loaded from: classes2.dex */
public class TraceEvent implements AutoCloseable {
    public static volatile boolean b;
    public final String a;

    public static void a(String str) {
        b(str, null);
    }

    public static void b(String str, String str2) {
        EarlyTraceEvent.b(str);
        if (b) {
            nativeEnd(str, str2);
        }
    }

    private static native void nativeBegin(String str, String str2);

    private static native void nativeBeginToplevel(String str);

    private static native void nativeEnd(String str, String str2);

    private static native void nativeEndToplevel();

    private static native void nativeFinishAsync(String str, long j);

    private static native void nativeInstant(String str, String str2);

    private static native void nativeRegisterEnabledObserver();

    private static native void nativeStartATrace();

    private static native void nativeStartAsync(String str, long j);

    private static native void nativeStopATrace();

    @Override // java.lang.AutoCloseable
    public void close() {
        a(this.a);
    }
}
