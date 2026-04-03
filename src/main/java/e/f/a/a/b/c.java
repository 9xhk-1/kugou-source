package e.f.a.a.b;

import android.content.Context;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import com.tme.fireeye.crash.crashmodule.CrashDetailBean;
import com.tme.fireeye.crash.crashmodule.JavaCrashHandler;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import com.tme.fireeye.crash.crashmodule.jni.NativeExceptionHandler;
import e.f.a.a.a.b;
import e.f.a.a.a.k.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f1380i = 0;
    public static int j = 2;
    public static boolean k = true;
    public static int l = 20480;
    public static int m = 20480;
    public static long n = 604800000;
    public static String o = null;
    public static boolean p = false;
    public static String q = null;
    public static int r = 5000;
    public static boolean s = true;
    public static boolean t = false;
    public static String u;
    public static String v;
    public static c w;
    public final Context a;
    public final b b;
    public final JavaCrashHandler c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NativeCrashHandler f1381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e.f.a.a.a.i.a f1382e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e.f.a.a.b.f.c f1383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f1384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1385h = 31;

    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            List<CrashDetailBean> list;
            if (!f.E(c.this.a, "local_crash_lock", NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME)) {
                e.f.a.a.a.k.c.b("Failed to lock file for uploading local crash.", new Object[0]);
                return;
            }
            List<CrashDetailBean> listP = c.this.b.p();
            if (listP != null && listP.size() > 0) {
                e.f.a.a.a.k.c.b("Size of crash list: %s", Integer.valueOf(listP.size()));
                int size = listP.size();
                if (size > 20) {
                    ArrayList arrayList = new ArrayList();
                    Collections.sort(listP);
                    for (int i2 = 0; i2 < 20; i2++) {
                        arrayList.add(listP.get((size - 1) - i2));
                    }
                    list = arrayList;
                } else {
                    list = listP;
                }
                c.this.b.e(list, 0L, true, false, false);
            }
            f.F(c.this.a, "local_crash_lock");
        }
    }

    public c(int i2, Context context, e.f.a.a.a.k.a aVar, boolean z, b.a aVar2, e eVar, String str) {
        f1380i = i2;
        Context contextD = f.d(context);
        this.a = contextD;
        e.f.a.a.a.i.a aVarG = e.f.a.a.a.i.a.g();
        this.f1382e = aVarG;
        this.f1384g = eVar;
        e.f.a.a.a.j.d dVarH = e.f.a.a.a.j.d.h();
        e.f.a.a.a.g.b bVarR = e.f.a.a.a.g.b.r();
        b bVar = new b(i2, contextD, dVarH, bVarR, aVarG, aVar2, eVar);
        this.b = bVar;
        e.f.a.a.a.h.b bVarE = e.f.a.a.a.h.b.e(contextD);
        this.c = new JavaCrashHandler(contextD, bVar, aVarG, bVarE);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance(contextD, bVarE, bVar, aVarG, aVar, z, str);
        this.f1381d = nativeCrashHandler;
        bVarE.h0 = nativeCrashHandler;
        this.f1383f = e.f.a.a.b.f.c.w(contextD, aVarG, bVarE, aVar, bVarR, bVar, aVar2);
    }

    public static synchronized c c() {
        return w;
    }

    public static synchronized c e(int i2, Context context, boolean z, b.a aVar, e eVar, String str) {
        if (w == null) {
            w = new c(i2, context, e.f.a.a.a.k.a.b(), z, aVar, eVar, str);
        }
        return w;
    }

    public void b() {
        this.c.unregistJavaCrashHandler();
    }

    public NativeExceptionHandler d() {
        return this.f1381d.getNativeExceptionHandler();
    }

    public boolean f() {
        return this.f1383f.D();
    }

    public void g(StrategyBean strategyBean) {
        this.c.onStrategyChanged(strategyBean);
        this.f1381d.onStrategyChanged(strategyBean);
        this.f1383f.J(strategyBean);
        v(3000L);
    }

    public void h(CrashDetailBean crashDetailBean) {
        this.b.x(crashDetailBean);
    }

    public void i(int i2) {
        this.f1385h = i2;
    }

    public void j(boolean z) {
    }

    public synchronized void k(e eVar) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.f1378e = eVar;
        }
    }

    public boolean l() {
        return (this.f1385h & 8) > 0;
    }

    public boolean m() {
        return (this.f1385h & 16) > 0;
    }

    public boolean n() {
        return (this.f1385h & 2) > 0;
    }

    public boolean o() {
        return (this.f1385h & 1) > 0;
    }

    public boolean p() {
        return (this.f1385h & 4) > 0;
    }

    public void q() {
        this.f1383f.g0(true);
    }

    public void r() {
        this.c.registJavaCrashHandler();
    }

    public void s() {
        this.f1381d.setUserOpened(true);
    }

    public synchronized void t() {
        this.f1383f.n0();
    }

    public synchronized void u(boolean z, boolean z2, boolean z3) {
        this.f1381d.testNativeCrash(z, z2, z3);
    }

    public void v(long j2) {
        e.f.a.a.a.k.a.b().e(new a(), j2);
    }

    public void w() {
        this.f1381d.checkUploadRecordCrash();
    }
}
