package com.tme.fireeye.crash.crashmodule.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.tme.fireeye.crash.crashmodule.CrashDetailBean;
import e.f.a.a.a.d;
import e.f.a.a.a.h.b;
import e.f.a.a.a.k.c;
import e.f.a.a.a.k.f;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class NativeCrashHandler implements d {
    private static int JNI_CALL_TYPE = 1;
    private static final int NATIVE_INFO_DUMP_ANR_NATIVE_STACK = 19;
    private static final int NATIVE_INFO_KEY_APP_CHANNEL = 12;
    private static final int NATIVE_INFO_KEY_APP_IS_FOREGROUND = 14;
    private static final int NATIVE_INFO_KEY_APP_LAUNCH_TIME = 15;
    private static final int NATIVE_INFO_KEY_APP_PACKAGE = 13;
    private static final int NATIVE_INFO_KEY_APP_VERSION = 10;
    private static final int NATIVE_INFO_KEY_TEST_PENDING_EXCEPTION = 18;
    private static final int NATIVE_INFO_KEY_TEST_SIGABRT_CRASH = 17;
    private static final int NATIVE_INFO_KEY_TEST_SUB_THREAD_CRASH = 16;
    private static final int NATIVE_INFO_KEY_USER_ID = 11;
    private static final int NATIVE_KEY_FILTER_SIGABRT_SYS_LOG = 998;
    private static final int NATIVE_KEY_SHOULD_HANDLE_IN_JAVA = 999;
    public static final long NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME = 10000;
    public static final String NATIVE_RECORD_FILE_LOCK_NAME = "native_record_lock";
    public static boolean canEnableNativeCrashHandler = true;
    private static boolean extraJniCanBeAccessed = true;
    private static boolean infoSettingJniCanBeAccessed = true;
    private static NativeCrashHandler instance = null;
    public static boolean isProtectionModeEnabled = false;
    private static boolean shouldHandleInJava = true;
    private final e.f.a.a.a.k.a asyncHandler;
    private final b comInfo;
    private final Context context;
    private e.f.a.a.b.b crashHandler;
    private String dumpFilePath;
    private final boolean isDebug;
    private boolean isFireEyeSoLoaded = false;
    private boolean isOpened = false;
    private boolean isUserOpened = false;
    private NativeExceptionHandler nativeExceptionHandler;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (!f.E(NativeCrashHandler.this.context, NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_NAME, NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME)) {
                c.f("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                return;
            }
            if (!NativeCrashHandler.shouldHandleInJava) {
                NativeCrashHandler.this.putKeyValueToNative(999, "false");
            }
            CrashDetailBean crashDetailBeanE = e.f.a.a.b.g.a.e(NativeCrashHandler.this.context, NativeCrashHandler.this.dumpFilePath, NativeCrashHandler.this.nativeExceptionHandler);
            if (crashDetailBeanE != null) {
                c.f("[Native] Get crash from native record.", new Object[0]);
                if (!NativeCrashHandler.this.crashHandler.j(crashDetailBeanE)) {
                    NativeCrashHandler.this.crashHandler.A(crashDetailBeanE, 3000L, false);
                }
                e.f.a.a.b.g.a.c(false, NativeCrashHandler.this.dumpFilePath);
            }
            NativeCrashHandler.this.removeOverdueNativeRecordFiles();
            f.F(NativeCrashHandler.this.context, NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_NAME);
        }
    }

    @SuppressLint({"SdCardPath"})
    public NativeCrashHandler(Context context, b bVar, e.f.a.a.b.b bVar2, e.f.a.a.a.i.a aVar, e.f.a.a.a.k.a aVar2, boolean z, String str) {
        this.context = f.d(context);
        try {
            if (f.q(str)) {
                str = context.getDir("fireeye", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + b.e(context).f1345e + "/app_fireeye";
        }
        this.crashHandler = bVar2;
        this.dumpFilePath = str;
        this.comInfo = bVar;
        this.asyncHandler = aVar2;
        this.isDebug = z;
        this.nativeExceptionHandler = new NativeExceptionHandlerImp(context, bVar, bVar2, e.f.a.a.a.i.a.g());
    }

    private synchronized void changeUserOpend(boolean z) {
        if (this.isUserOpened != z) {
            c.f("user change native %b", Boolean.valueOf(z));
            this.isUserOpened = z;
        }
    }

    public static synchronized NativeCrashHandler getInstance(Context context, b bVar, e.f.a.a.b.b bVar2, e.f.a.a.a.i.a aVar, e.f.a.a.a.k.a aVar2, boolean z, String str) {
        if (instance == null) {
            instance = new NativeCrashHandler(context, bVar, bVar2, aVar, aVar2, z, str);
        }
        return instance;
    }

    public static boolean isProtectionModeEnabled() {
        return isProtectionModeEnabled;
    }

    public static boolean isShouldHandleInJava() {
        return shouldHandleInJava;
    }

    public static void setShouldHandleInJava(boolean z) {
        shouldHandleInJava = z;
        NativeCrashHandler nativeCrashHandler = instance;
        if (nativeCrashHandler != null) {
            nativeCrashHandler.putKeyValueToNative(999, "" + z);
        }
    }

    private boolean tryLoadSo(String str, boolean z) {
        boolean z2;
        try {
            c.f("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                c.f("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                c.j(th.getMessage(), new Object[0]);
                c.j("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    @Override // e.f.a.a.a.d
    public boolean appendLogToNative(String str, String str2, String str3) {
        if (this.isFireEyeSoLoaded && extraJniCanBeAccessed && str != null && str2 != null && str3 != null) {
            try {
                return appendNativeLog(str, str2, str3);
            } catch (UnsatisfiedLinkError unused) {
                extraJniCanBeAccessed = false;
            } catch (Throwable th) {
                if (!c.k(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.asyncHandler.d(new a());
    }

    public void dumpAnrNativeStack() {
        putKeyValueToNative(19, "1");
    }

    public void enableCatchAnrTrace() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 30 || i2 < 23) {
            return;
        }
        JNI_CALL_TYPE |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return putKeyValueToNative(NATIVE_KEY_FILTER_SIGABRT_SYS_LOG, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.dumpFilePath;
    }

    @Override // e.f.a.a.a.d
    public String getLogFromNative() {
        if (!this.isFireEyeSoLoaded || !extraJniCanBeAccessed) {
            return null;
        }
        try {
            return getNativeLog();
        } catch (UnsatisfiedLinkError unused) {
            extraJniCanBeAccessed = false;
            return null;
        } catch (Throwable th) {
            if (!c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.nativeExceptionHandler;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public boolean isEnableCatchAnrTrace() {
        return (JNI_CALL_TYPE & 2) == 2;
    }

    public synchronized boolean isOpened() {
        return this.isOpened;
    }

    public synchronized boolean isUserOpened() {
        return this.isUserOpened;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002f A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x000b, B:8:0x0018, B:10:0x0024, B:14:0x002b, B:16:0x002f), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void onStrategyChanged(com.tme.fireeye.crash.comm.strategy.StrategyBean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L18
            boolean r5 = r5.f269d     // Catch: java.lang.Throwable -> L41
            boolean r2 = r4.isOpened     // Catch: java.lang.Throwable -> L41
            if (r5 == r2) goto L18
            java.lang.String r2 = "server native changed to %b"
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L41
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L41
            r3[r1] = r5     // Catch: java.lang.Throwable -> L41
            e.f.a.a.a.k.c.j(r2, r3)     // Catch: java.lang.Throwable -> L41
        L18:
            e.f.a.a.a.i.a r5 = e.f.a.a.a.i.a.g()     // Catch: java.lang.Throwable -> L41
            com.tme.fireeye.crash.comm.strategy.StrategyBean r5 = r5.h()     // Catch: java.lang.Throwable -> L41
            boolean r5 = r5.f269d     // Catch: java.lang.Throwable -> L41
            if (r5 == 0) goto L2a
            boolean r5 = r4.isUserOpened     // Catch: java.lang.Throwable -> L41
            if (r5 == 0) goto L2a
            r5 = 1
            goto L2b
        L2a:
            r5 = 0
        L2b:
            boolean r2 = r4.isOpened     // Catch: java.lang.Throwable -> L41
            if (r5 == r2) goto L3f
            java.lang.String r2 = "native changed to %b"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L41
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L41
            r0[r1] = r3     // Catch: java.lang.Throwable -> L41
            e.f.a.a.a.k.c.f(r2, r0)     // Catch: java.lang.Throwable -> L41
            r4.setOpened(r5)     // Catch: java.lang.Throwable -> L41
        L3f:
            monitor-exit(r4)
            return
        L41:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler.onStrategyChanged(com.tme.fireeye.crash.comm.strategy.StrategyBean):void");
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if (this.isFireEyeSoLoaded && extraJniCanBeAccessed && str != null && str2 != null) {
            try {
                return putNativeKeyValue(str, str2);
            } catch (UnsatisfiedLinkError unused) {
                extraJniCanBeAccessed = false;
            } catch (Throwable th) {
                if (!c.k(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i2);

    public synchronized void registNativeReport(boolean z) {
        if (this.isOpened) {
            c.j("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.isFireEyeSoLoaded) {
            try {
                String strRegist = regist(this.dumpFilePath, z, JNI_CALL_TYPE);
                if (strRegist != null) {
                    c.f("[Native] Native Crash Report enable.", new Object[0]);
                    this.comInfo.H = strRegist;
                    c.f("comInfo.nativeSoVersion %s", strRegist);
                    this.isOpened = true;
                    return;
                }
            } catch (Throwable unused) {
                c.b("[Native] Failed to load FireEye SO file.", new Object[0]);
            }
        }
        this.isFireEyeSoLoaded = false;
    }

    public void removeEmptyNativeRecordFiles() {
        e.f.a.a.b.g.a.b(this.dumpFilePath);
    }

    public native String removeNativeKeyValue(String str);

    public void removeOverdueNativeRecordFiles() {
        long jO = f.o() - e.f.a.a.b.c.n;
        long jO2 = f.o() + 86400000;
        File file = new File(this.dumpFilePath);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : fileArrListFiles) {
                        long jLastModified = file2.lastModified();
                        if (jLastModified < jO || jLastModified >= jO2) {
                            c.f("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    c.b("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                c.k(th);
            }
        }
    }

    public synchronized void setDumpFilePath(String str) {
        this.dumpFilePath = str;
    }

    public void setIsNeedRegisterSigQuit(boolean z) {
        if (z) {
            JNI_CALL_TYPE |= 4;
        } else {
            JNI_CALL_TYPE &= 3;
        }
    }

    public boolean setNativeAppChannel(String str) {
        return putKeyValueToNative(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return putKeyValueToNative(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return putKeyValueToNative(10, str);
    }

    public native void setNativeInfo(int i2, String str);

    @Override // e.f.a.a.a.d
    public boolean setNativeIsAppForeground(boolean z) {
        return putKeyValueToNative(14, z ? "true" : "false");
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return putKeyValueToNative(15, String.valueOf(j));
        } catch (NumberFormatException e2) {
            if (c.k(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return putKeyValueToNative(11, str);
    }

    public synchronized void setOpened(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            unregistNativeReport();
        }
    }

    public synchronized void setUserOpened(boolean z) {
        changeUserOpend(z);
        boolean zIsUserOpened = isUserOpened();
        e.f.a.a.a.i.a aVarG = e.f.a.a.a.i.a.g();
        if (aVarG != null) {
            zIsUserOpened = zIsUserOpened && aVarG.h().f269d;
        }
        if (zIsUserOpened != this.isOpened) {
            c.f("native changed to %b", Boolean.valueOf(zIsUserOpened));
            setOpened(zIsUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (this.isFireEyeSoLoaded) {
            if (canEnableNativeCrashHandler) {
                registNativeReport(this.isDebug);
            }
            return;
        }
        boolean z = !f.q(this.comInfo.G);
        boolean zTryLoadSo = tryLoadSo(z ? this.comInfo.G : "FireEye-rqd", z);
        this.isFireEyeSoLoaded = zTryLoadSo;
        if (zTryLoadSo) {
            if (canEnableNativeCrashHandler) {
                registNativeReport(this.isDebug);
                if (extraJniCanBeAccessed) {
                    setNativeAppVersion(this.comInfo.d());
                    setNativeAppChannel(this.comInfo.D);
                    setNativeAppPackage(this.comInfo.f1345e);
                    setNativeUserId(this.comInfo.x());
                    setNativeIsAppForeground(this.comInfo.B());
                    setNativeLaunchTime(this.comInfo.c);
                }
            }
        }
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (this.isFireEyeSoLoaded) {
            testCrash();
        } else {
            c.j("[Native] FireEye SO file has not been load.", new Object[0]);
        }
    }

    public native String unregist();

    public synchronized void unregistNativeReport() {
        if (canEnableNativeCrashHandler) {
            if (!this.isOpened) {
                c.j("[Native] Native crash report has already unregistered.", new Object[0]);
                return;
            }
            try {
                if (unregist() != null) {
                    c.f("[Native] Successfully closed native crash report.", new Object[0]);
                    this.isOpened = false;
                    return;
                }
            } catch (Throwable unused) {
                c.b("[Native] Failed to close native crash report.", new Object[0]);
            }
            this.isFireEyeSoLoaded = false;
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        return instance;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        putKeyValueToNative(16, "" + z);
        putKeyValueToNative(17, "" + z2);
        putKeyValueToNative(18, "" + z3);
        testNativeCrash();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean putKeyValueToNative(int i2, String str) {
        if (this.isFireEyeSoLoaded && infoSettingJniCanBeAccessed) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                infoSettingJniCanBeAccessed = false;
            } catch (Throwable th) {
                if (!c.k(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
