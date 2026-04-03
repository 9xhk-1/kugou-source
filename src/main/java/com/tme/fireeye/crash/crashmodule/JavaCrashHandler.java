package com.tme.fireeye.crash.crashmodule;

import android.content.Context;
import android.os.Process;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import e.f.a.a.a.h.b;
import e.f.a.a.a.i.a;
import e.f.a.a.a.k.c;
import e.f.a.a.a.k.e;
import e.f.a.a.a.k.f;
import java.lang.Thread;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class JavaCrashHandler implements Thread.UncaughtExceptionHandler {
    private static final Object HANDLE_FLAG_LOCK = new Object();
    private static final int MAX_HANDLE_NUM = 10;
    public static boolean canEnableJavaCrashHandler = true;
    private static String lastThreadName;
    public final b comInfo;
    public final Context context;
    public final e.f.a.a.b.b crashHandler;
    public Thread.UncaughtExceptionHandler defaultHandler;
    public boolean enable = false;
    private int handleNum;
    public final a strategyManager;
    public Thread.UncaughtExceptionHandler systemHandler;

    public JavaCrashHandler(Context context, e.f.a.a.b.b bVar, a aVar, b bVar2) {
        this.context = context;
        this.crashHandler = bVar;
        this.strategyManager = aVar;
        this.comInfo = bVar2;
    }

    public static String genMessage(Throwable th, int i2) {
        if (th.getMessage() == null) {
            return "";
        }
        if (i2 < 0 || th.getMessage().length() <= i2) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, i2) + "\n[Message over limit size:" + i2 + ", has been cutted!]";
    }

    public static String genThrowableStack(Throwable th, int i2) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i2 > 0 && sb.length() >= i2) {
                        sb.append("\n[Stack over limit size :" + i2 + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            c.c("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    private boolean handlerNotCalling(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasHandledCrash(Thread thread) {
        synchronized (HANDLE_FLAG_LOCK) {
            if (lastThreadName != null && thread.getName().equals(lastThreadName)) {
                return true;
            }
            lastThreadName = thread.getName();
            return false;
        }
    }

    public void defaultCrashHandle(Thread thread, Throwable th) {
        c.c("current process die", new Object[0]);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public synchronized Thread.UncaughtExceptionHandler getDefaultHandler() {
        return this.defaultHandler;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f269d;
            if (z != this.enable) {
                c.f("java changed to %b", Boolean.valueOf(z));
                if (strategyBean.f269d) {
                    registJavaCrashHandler();
                } else {
                    unregistJavaCrashHandler();
                }
            }
        }
    }

    public CrashDetailBean packageCrashDatas(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String strGenThrowableStack;
        if (th == null) {
            c.j("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean zF = e.f.a.a.b.c.c().f();
        String str2 = (zF && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![FireEye]" : "";
        if (zF && z) {
            c.c("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.J = e.f.a.a.a.h.c.k();
        crashDetailBean.K = e.f.a.a.a.h.c.m();
        crashDetailBean.L = e.f.a.a.a.h.c.i();
        crashDetailBean.M = this.comInfo.u();
        crashDetailBean.N = this.comInfo.v();
        crashDetailBean.O = this.comInfo.w();
        crashDetailBean.D = f.x(this.context, e.f.a.a.b.c.l, e.f.a.a.b.c.o);
        byte[] bArrB = e.b();
        crashDetailBean.F = bArrB;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(bArrB == null ? 0 : bArrB.length);
        c.f("user log size:%d", objArr);
        crashDetailBean.b = z ? 0 : 2;
        crashDetailBean.f275h = this.comInfo.l();
        crashDetailBean.f276i = this.comInfo.d();
        crashDetailBean.j = this.comInfo.i();
        crashDetailBean.q = this.comInfo.x();
        String name = th.getClass().getName();
        String strGenMessage = genMessage(th, 1000);
        if (strGenMessage == null) {
            strGenMessage = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        c.c("stack frame :%d, has cause %b", objArr2);
        String string = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable cause = th;
        while (cause != null && cause.getCause() != null) {
            cause = cause.getCause();
        }
        if (cause == null || cause == th) {
            crashDetailBean.r = name;
            String str3 = strGenMessage + "" + str2;
            crashDetailBean.s = str3;
            if (str3 == null) {
                crashDetailBean.s = "";
            }
            crashDetailBean.t = string;
            strGenThrowableStack = genThrowableStack(th, e.f.a.a.b.c.m);
            crashDetailBean.u = strGenThrowableStack;
        } else {
            crashDetailBean.r = cause.getClass().getName();
            String strGenMessage2 = genMessage(cause, 1000);
            crashDetailBean.s = strGenMessage2;
            if (strGenMessage2 == null) {
                crashDetailBean.s = "";
            }
            if (cause.getStackTrace().length > 0) {
                crashDetailBean.t = cause.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(strGenMessage);
            sb.append("\n");
            sb.append(string);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.r);
            sb.append(":");
            sb.append(crashDetailBean.s);
            sb.append("\n");
            strGenThrowableStack = genThrowableStack(cause, e.f.a.a.b.c.m);
            sb.append(strGenThrowableStack);
            crashDetailBean.u = sb.toString();
        }
        crashDetailBean.v = System.currentTimeMillis();
        crashDetailBean.y = f.p(crashDetailBean.u.getBytes());
        try {
            crashDetailBean.G = f.i(e.f.a.a.b.c.m, false);
            crashDetailBean.H = this.comInfo.f1346f;
            String str4 = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.I = str4;
            crashDetailBean.G.put(str4, strGenThrowableStack);
            crashDetailBean.P = this.comInfo.r();
            crashDetailBean.k = this.comInfo.p();
            crashDetailBean.l = this.comInfo.o();
            b bVar = this.comInfo;
            crashDetailBean.U = bVar.c;
            crashDetailBean.V = bVar.B();
            if (z) {
                this.crashHandler.l(crashDetailBean);
            } else {
                boolean z2 = str != null && str.length() > 0;
                boolean z3 = bArr != null && bArr.length > 0;
                if (z2) {
                    HashMap map = new HashMap(1);
                    crashDetailBean.W = map;
                    map.put("UserData", str);
                }
                if (z3) {
                    crashDetailBean.c0 = bArr;
                }
            }
            crashDetailBean.Y = this.comInfo.z();
            crashDetailBean.Z = this.comInfo.s();
            crashDetailBean.a0 = this.comInfo.h();
            crashDetailBean.b0 = this.comInfo.g();
        } catch (Throwable th2) {
            c.c("handle crash error %s", th2.toString());
        }
        return crashDetailBean;
    }

    public synchronized void registJavaCrashHandler() {
        if (canEnableJavaCrashHandler) {
            if (this.handleNum >= 10) {
                c.f("java crash handler over %d, no need set.", 10);
                return;
            }
            this.enable = true;
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    return;
                }
                if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                    c.f("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.systemHandler = defaultUncaughtExceptionHandler;
                    this.defaultHandler = defaultUncaughtExceptionHandler;
                } else {
                    c.f("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                    this.defaultHandler = defaultUncaughtExceptionHandler;
                }
            }
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.handleNum++;
            c.f("registered java monitor: %s", toString());
        }
    }

    public synchronized void setDefaultHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.defaultHandler = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        if (z) {
            c.c("Java Crash Happen cause by %s(%d)", thread.getName(), Long.valueOf(thread.getId()));
            if (hasHandledCrash(thread)) {
                c.f("this class has handled this exception", new Object[0]);
                if (this.systemHandler != null) {
                    c.f("call system handler", new Object[0]);
                    this.systemHandler.uncaughtException(thread, th);
                } else {
                    defaultCrashHandle(thread, th);
                }
            }
        } else {
            c.c("Java Catch Happen", new Object[0]);
        }
        try {
            if (!this.enable) {
                c.b("Java crash handler is disable. Just return.", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultHandler;
                    if (uncaughtExceptionHandler != null && handlerNotCalling(uncaughtExceptionHandler)) {
                        c.c("sys default last handle start!", new Object[0]);
                        this.defaultHandler.uncaughtException(thread, th);
                        c.c("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.systemHandler != null) {
                        c.c("system handle start!", new Object[0]);
                        this.systemHandler.uncaughtException(thread, th);
                        c.c("system handle end!", new Object[0]);
                        return;
                    } else {
                        c.c("crashreport last handle start!", new Object[0]);
                        defaultCrashHandle(thread, th);
                        c.c("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            if (!this.strategyManager.i()) {
                c.j("no remote but still store!", new Object[0]);
            }
            if (!this.strategyManager.h().f269d && this.strategyManager.i()) {
                c.c("crash report was closed by remote , will not upload to FireEye , print local for helpful!", new Object[0]);
                e.f.a.a.b.b.t(z ? "JAVA_CRASH" : "JAVA_CATCH", f.m(), this.comInfo.f1346f, thread.getName(), f.v(th), null);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.defaultHandler;
                    if (uncaughtExceptionHandler2 != null && handlerNotCalling(uncaughtExceptionHandler2)) {
                        c.c("sys default last handle start!", new Object[0]);
                        this.defaultHandler.uncaughtException(thread, th);
                        c.c("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.systemHandler != null) {
                        c.c("system handle start!", new Object[0]);
                        this.systemHandler.uncaughtException(thread, th);
                        c.c("system handle end!", new Object[0]);
                        return;
                    } else {
                        c.c("crashreport last handle start!", new Object[0]);
                        defaultCrashHandle(thread, th);
                        c.c("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            CrashDetailBean crashDetailBeanPackageCrashDatas = packageCrashDatas(thread, th, z, str, bArr);
            if (crashDetailBeanPackageCrashDatas == null) {
                c.c("pkg crash datas fail!", new Object[0]);
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.defaultHandler;
                    if (uncaughtExceptionHandler3 != null && handlerNotCalling(uncaughtExceptionHandler3)) {
                        c.c("sys default last handle start!", new Object[0]);
                        this.defaultHandler.uncaughtException(thread, th);
                        c.c("sys default last handle end!", new Object[0]);
                        return;
                    } else if (this.systemHandler != null) {
                        c.c("system handle start!", new Object[0]);
                        this.systemHandler.uncaughtException(thread, th);
                        c.c("system handle end!", new Object[0]);
                        return;
                    } else {
                        c.c("crashreport last handle start!", new Object[0]);
                        defaultCrashHandle(thread, th);
                        c.c("crashreport last handle end!", new Object[0]);
                        return;
                    }
                }
                return;
            }
            e.f.a.a.b.b.t(z ? "JAVA_CRASH" : "JAVA_CATCH", f.m(), this.comInfo.f1346f, thread.getName(), f.v(th), crashDetailBeanPackageCrashDatas);
            if (!this.crashHandler.j(crashDetailBeanPackageCrashDatas)) {
                this.crashHandler.A(crashDetailBeanPackageCrashDatas, 3000L, z);
            }
            if (z) {
                this.crashHandler.r(crashDetailBeanPackageCrashDatas);
            }
            if (z) {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler4 = this.defaultHandler;
                if (uncaughtExceptionHandler4 != null && handlerNotCalling(uncaughtExceptionHandler4)) {
                    c.c("sys default last handle start!", new Object[0]);
                    this.defaultHandler.uncaughtException(thread, th);
                    c.c("sys default last handle end!", new Object[0]);
                } else if (this.systemHandler != null) {
                    c.c("system handle start!", new Object[0]);
                    this.systemHandler.uncaughtException(thread, th);
                    c.c("system handle end!", new Object[0]);
                } else {
                    c.c("crashreport last handle start!", new Object[0]);
                    defaultCrashHandle(thread, th);
                    c.c("crashreport last handle end!", new Object[0]);
                }
            }
        } catch (Throwable th2) {
            try {
                if (!c.k(th2)) {
                    th2.printStackTrace();
                }
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler5 = this.defaultHandler;
                    if (uncaughtExceptionHandler5 != null && handlerNotCalling(uncaughtExceptionHandler5)) {
                        c.c("sys default last handle start!", new Object[0]);
                        this.defaultHandler.uncaughtException(thread, th);
                        c.c("sys default last handle end!", new Object[0]);
                    } else if (this.systemHandler != null) {
                        c.c("system handle start!", new Object[0]);
                        this.systemHandler.uncaughtException(thread, th);
                        c.c("system handle end!", new Object[0]);
                    } else {
                        c.c("crashreport last handle start!", new Object[0]);
                        defaultCrashHandle(thread, th);
                        c.c("crashreport last handle end!", new Object[0]);
                    }
                }
            } catch (Throwable th3) {
                if (z) {
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler6 = this.defaultHandler;
                    if (uncaughtExceptionHandler6 != null && handlerNotCalling(uncaughtExceptionHandler6)) {
                        c.c("sys default last handle start!", new Object[0]);
                        this.defaultHandler.uncaughtException(thread, th);
                        c.c("sys default last handle end!", new Object[0]);
                    } else if (this.systemHandler != null) {
                        c.c("system handle start!", new Object[0]);
                        this.systemHandler.uncaughtException(thread, th);
                        c.c("system handle end!", new Object[0]);
                    } else {
                        c.c("crashreport last handle start!", new Object[0]);
                        defaultCrashHandle(thread, th);
                        c.c("crashreport last handle end!", new Object[0]);
                    }
                }
                throw th3;
            }
        }
    }

    public synchronized void unregistJavaCrashHandler() {
        if (canEnableJavaCrashHandler) {
            this.enable = false;
            c.f("close java monitor!", new Object[0]);
            if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("fireeye")) {
                c.f("Java monitor to unregister: %s", toString());
                Thread.setDefaultUncaughtExceptionHandler(this.defaultHandler);
                this.handleNum--;
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        synchronized (HANDLE_FLAG_LOCK) {
            uncaughtException(thread, th, true, null, null);
        }
    }
}
