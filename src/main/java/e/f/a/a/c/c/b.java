package e.f.a.a.c.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmachine.trace.util.TMachineLog;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import com.tme.fireeye.crash.crashmodule.anr.SignalAnrTracer;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import com.tme.fireeye.crash.export.eup.jni.NativeExceptionUpload;
import e.f.a.a.a.j.d;
import e.f.a.a.a.k.f;
import e.f.a.a.b.e;
import e.f.a.a.d.a.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends e.f.a.a.a.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1420d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f1421e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static e f1422f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static e.f.a.a.c.c.a f1423g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static e.f.a.a.a.j.c f1424h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static b f1425i = new b();
    public static boolean j = false;
    public static boolean k = false;
    public static boolean l = false;
    public static boolean m = true;
    public static long n;

    public class a implements e {
        public final /* synthetic */ e.f.a.a.c.c.a a;

        public a(e.f.a.a.c.c.a aVar) {
            this.a = aVar;
        }

        @Override // e.f.a.a.b.e
        public byte[] getCrashExtraData(boolean z, String str, String str2, String str3, int i2, long j) {
            return this.a.getCrashExtraData(z, str, str2, str3, i2, j);
        }

        @Override // e.f.a.a.b.e
        public String getCrashExtraMessage(boolean z, String str, String str2, String str3, int i2, long j) {
            return this.a.getCrashExtraMessage(z, str, str2, str3, i2, j);
        }

        @Override // e.f.a.a.b.e
        public boolean onCrashHandleEnd(boolean z) {
            return this.a.onCrashHandleEnd(z);
        }

        @Override // e.f.a.a.b.e
        public void onCrashHandleStart(boolean z) {
            this.a.onCrashHandleStart(z);
        }

        @Override // e.f.a.a.b.e
        public boolean onCrashSaving(boolean z, String str, String str2, String str3, String str4, int i2, long j, String str5, String str6, String str7, String str8, String str9) {
            return this.a.onCrashSaving(z, str, str3, str4, i2, j, str5, str6, str7, str8);
        }
    }

    /* JADX INFO: renamed from: e.f.a.a.c.c.b$b, reason: collision with other inner class name */
    public class C0250b implements e.f.a.a.a.j.c {
        public final /* synthetic */ e.f.a.a.c.d.a a;

        public C0250b(e.f.a.a.c.d.a aVar) {
            this.a = aVar;
        }

        @Override // e.f.a.a.a.j.c
        public void onUploadEnd(int i2, g gVar, long j, long j2, boolean z, String str) {
            this.a.onUploadEnd(i2, gVar == null ? -1 : gVar.b, j, j2, z, str);
        }

        @Override // e.f.a.a.a.j.c
        public void onUploadStart(int i2) {
            this.a.onUploadStart(i2);
        }
    }

    public static void A() {
        B(false, false, false);
    }

    public static void B(boolean z, boolean z2, boolean z3) {
        if (!f1420d) {
            Log.e(e.f.a.a.a.k.c.b, "NativeCrashReport has not been initialed! pls to call method 'initNativeCrashReport' first!");
        } else {
            e.f.a.a.a.k.c.f("start to create a native crash for test!", new Object[0]);
            e.f.a.a.b.c.c().u(z, z2, z3);
        }
    }

    public static void g(Context context, boolean z) {
        e.f.a.a.a.h.b.e(context).n = z;
    }

    public static b h() {
        return f1425i;
    }

    public static void i(Context context, String str, e.f.a.a.c.c.a aVar, e.f.a.a.c.d.a aVar2, boolean z, c cVar) {
        j(context, str, aVar, aVar2, z, cVar, 0L);
    }

    public static void j(Context context, String str, e.f.a.a.c.c.a aVar, e.f.a.a.c.d.a aVar2, boolean z, c cVar, long j2) {
        String strD;
        if (context == null || f1420d) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            n = SystemClock.elapsedRealtimeNanos();
        } else {
            n = SystemClock.elapsedRealtime() * 1000;
        }
        if (!l) {
            StrategyBean.z = "https://report.tencentmusic.com/api/v1/crash";
            StrategyBean.A = "https://report.tencentmusic.com/api/v1/crash";
        }
        f1421e = cVar;
        q(aVar);
        w(aVar2);
        e.f.a.a.b.c.j = 1;
        e.f.a.a.a.b bVar = new e.f.a.a.a.b();
        if (cVar != null) {
            e.f.a.a.b.c.n = cVar.o() * 24 * 3600 * 1000;
            e.f.a.a.b.c.o = cVar.n();
            e.f.a.a.b.c.p = cVar.y();
            e.f.a.a.b.c.q = cVar.p();
            e.f.a.a.b.c.r = cVar.g();
            e.f.a.a.b.c.l = cVar.l();
            e.f.a.a.b.c.m = cVar.m();
            e.f.a.a.b.c.k = cVar.v();
            e.f.a.a.b.c.s = cVar.z();
            bVar.m(cVar.w());
        }
        bVar.l(j2);
        if (f.q(e.f.a.a.a.h.b.e(context).f1347g)) {
            e.f.a.a.a.h.b.e(context).J(str);
        }
        if (!k && (strD = e.f.a.a.a.h.b.e(context).d()) != null && !f.q(strD)) {
            int i2 = 0;
            for (char c : strD.toCharArray()) {
                if (c == '.') {
                    i2++;
                }
            }
            if (i2 < 3) {
                String str2 = strD + "." + e.f.a.a.a.h.b.e(context).X;
                e.f.a.a.a.h.b.e(context).K(str2);
                e.f.a.a.a.k.c.f("rqdp{ RQD version: %s }", str2);
            }
        }
        e.f.a.a.a.h.b.e(context).f1348h = z;
        bVar.o(z);
        e.f.a.a.a.h.b.e(context).g0 = true;
        e.f.a.a.a.i.a.f1352h = 21600000L;
        bVar.n(j);
        e.f.a.a.a.c.a(h());
        e.f.a.a.a.c.c(context, str, false, bVar);
        f1420d = true;
    }

    public static void k(Context context, String str, boolean z) {
        l(context, str, z, null);
    }

    public static void l(Context context, String str, boolean z, List<File> list) {
        m(context, str, z, list, null);
    }

    @SuppressLint({"SdCardPath"})
    public static void m(Context context, String str, boolean z, List<File> list, File file) {
        n(context, str, z, list, file, 0L);
    }

    @SuppressLint({"SdCardPath"})
    public static void n(Context context, String str, boolean z, List<File> list, File file, long j2) {
        if (f1420d) {
            e.f.a.a.a.h.b bVarE = e.f.a.a.a.h.b.e(context);
            if (file != null) {
                String absolutePath = file.getAbsolutePath();
                if (!f.q(absolutePath)) {
                    bVarE.G = absolutePath;
                }
            }
            if (file != null) {
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(file);
            }
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null && !f.q(str)) {
                nativeCrashHandler.setDumpFilePath(str);
                nativeCrashHandler.setIsNeedRegisterSigQuit(!m);
            }
            e.f.a.a.b.f.c cVarV = e.f.a.a.b.f.c.v();
            if (cVarV != null && !f.q(str)) {
                cVarV.V(str);
                cVarV.b0(m);
                c cVar = f1421e;
                if (cVar != null) {
                    cVarV.Z(cVar.u());
                    cVarV.f0(cVar.q());
                    cVarV.X(cVar.s());
                    cVarV.U(cVar.f());
                    cVarV.Y(cVar.t());
                    cVarV.c0(cVar.k());
                    cVarV.a0(cVar.j());
                    cVarV.T(cVar.d());
                    cVarV.S(cVar.b());
                    SignalAnrTracer.openCheckTime = cVar.x();
                    e.f.a.a.a.i.a aVarG = e.f.a.a.a.i.a.g();
                    if (aVarG != null && aVarG.f() != null) {
                        aVarG.f().x = cVar.h();
                        aVarG.f().y = cVar.i();
                    }
                }
            }
            e.f.a.a.c.c.d.b bVarA = e.f.a.a.c.c.d.b.a(context);
            bVarA.b(str);
            NativeExceptionUpload.a(bVarA);
            e.f.a.a.b.c cVarC = e.f.a.a.b.c.c();
            if (cVarC != null) {
                cVarC.s();
                cVarC.v(j2);
                cVarC.w();
            }
        }
    }

    public static boolean o() {
        return m;
    }

    public static void p(Context context, String str, String str2) {
        if (context == null) {
            e.f.a.a.a.k.c.j("putUserData args context should not be null", new Object[0]);
            return;
        }
        if (f.q(str)) {
            e.f.a.a.a.k.c.j("putUserData args key should not be null", new Object[0]);
            return;
        }
        if (f.q(str2)) {
            e.f.a.a.a.k.c.j("putUserData args value should not be null", new Object[0]);
            return;
        }
        if (!str.matches("[a-zA-Z[0-9]_]+")) {
            e.f.a.a.a.k.c.j("putUserData args key should match [a-zA-Z[0-9]_]+  {" + str + "}", new Object[0]);
            return;
        }
        if (str2.length() > 200) {
            e.f.a.a.a.k.c.j("user data value length over limit %d , has been cutted!", 200);
            str2 = str2.substring(0, 200);
        }
        e.f.a.a.a.h.b bVarE = e.f.a.a.a.h.b.e(context);
        if (bVarE.a().contains(str)) {
            e.f.a.a.a.h.b.e(context).G(str, str2);
            e.f.a.a.a.k.c.b("replace KV %s %s", str, str2);
            return;
        }
        if (bVarE.y() >= 500) {
            e.f.a.a.a.k.c.j("user data size is over limit %d , will drop this new key %s", 50, str);
            return;
        }
        if (str.length() > 50) {
            e.f.a.a.a.k.c.j("user data key length over limit %d , will drop this new key %s", 50, str);
            return;
        }
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.putKeyValueToNative(str, str2);
        }
        e.f.a.a.a.h.b.e(context).G(str, str2);
        e.f.a.a.a.k.c.i("[param] set user data: %s - %s", str, str2);
    }

    public static void q(e.f.a.a.c.c.a aVar) {
        if (aVar == null) {
            return;
        }
        f1423g = aVar;
        f1422f = new a(aVar);
        e.f.a.a.b.c cVarC = e.f.a.a.b.c.c();
        if (cVarC != null) {
            cVarC.k(f1422f);
        }
    }

    public static void r(Context context, String str) {
        if (str != null) {
            e.f.a.a.a.h.b.e(context).L(str);
        }
    }

    public static void s(Context context, String str) {
        if (str != null) {
            e.f.a.a.a.h.b.e(context).M(str);
        }
    }

    public static void t(boolean z, boolean z2) {
        if (!z) {
            e.f.a.a.a.k.c.c = false;
            TMachineLog.setLogEnable(false);
        } else {
            e.f.a.a.a.k.c.c = true;
            e.f.a.a.a.c.b = true;
            TMachineLog.setLogEnable(true);
            e.f.a.a.a.k.c.j("'setLogAble(boolean)' is true , so running in debug model , close it when you release!", new Object[0]);
        }
    }

    public static void u(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 100) {
            String strSubstring = str.substring(0, 100);
            e.f.a.a.a.k.c.j("appVersion %s length is over limit %d substring to %s", str, 100, strSubstring);
            str = strSubstring;
        }
        k = true;
        e.f.a.a.a.h.b.e(context).K(str);
    }

    public static void v(Context context, String str) {
        e.f.a.a.a.h.b.e(context).Y = str;
    }

    public static void w(e.f.a.a.c.d.a aVar) {
        if (aVar == null) {
            return;
        }
        f1424h = new C0250b(aVar);
        d dVarH = d.h();
        if (dVarH != null) {
            dVarH.c = f1424h;
        }
    }

    public static void x(Context context, String str) {
        if (str == null) {
            return;
        }
        if (str.length() > 100) {
            String strSubstring = str.substring(0, 100);
            e.f.a.a.a.k.c.j("userId %s length is over limit %d substring to %s", str, 100, strSubstring);
            str = strSubstring;
        }
        if (str.equals(e.f.a.a.a.h.b.e(context).x())) {
            return;
        }
        e.f.a.a.a.h.b.e(context).P(str);
        e.f.a.a.a.k.c.i("[user] set userId : %s", str);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setNativeUserId(str);
        }
        if (e.f.a.a.a.e.b.a) {
            e.f.a.a.a.e.b.v();
        }
    }

    public static void y() {
        if (!f1420d) {
            Log.e(e.f.a.a.a.k.c.b, "NativeCrashReport has not been initialed! pls to call method 'initNativeCrashReport' first!");
        } else {
            e.f.a.a.a.k.c.f("start to create a anr crash for test!", new Object[0]);
            e.f.a.a.b.c.c().t();
        }
    }

    public static void z() {
        if (f1420d) {
            throw new RuntimeException("This Crash create for Test! You can go to FireEye see more detail!");
        }
        Log.e(e.f.a.a.a.k.c.b, "NativeCrashReport has not been initialed! pls to call method 'initNativeCrashReport' first!");
    }

    @Override // e.f.a.a.a.a
    public String[] a() {
        return new String[]{DbOpenHelper.TABLE_CRASH};
    }

    @Override // e.f.a.a.a.a
    public void b(Context context, boolean z, e.f.a.a.a.b bVar) {
        e.f.a.a.b.c cVarE = e.f.a.a.b.c.e(1003, context, e.f.a.a.a.c.b, null, f1422f, null);
        cVarE.r();
        cVarE.j(true);
        c cVar = f1421e;
        if (cVar != null) {
            cVarE.i(cVar.c());
            cVarE.j(f1421e.e());
            if (f1421e.r()) {
                NativeCrashHandler.getInstance().enableCatchAnrTrace();
            }
            e.f.a.a.b.f.c.v().W(f1421e.r());
        }
        e.f.a.a.b.d.b(context);
        d.h().c = f1424h;
    }

    @Override // e.f.a.a.a.a
    public void f(StrategyBean strategyBean) {
        e.f.a.a.b.c cVarC;
        if (strategyBean == null || (cVarC = e.f.a.a.b.c.c()) == null) {
            return;
        }
        cVarC.g(strategyBean);
    }
}
