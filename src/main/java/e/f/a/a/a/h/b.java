package e.f.a.a.a.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import com.tme.fireeye.crash.comm.info.PlugInBean;
import e.f.a.a.a.d;
import e.f.a.a.a.k.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static b q0;
    public final Context a;
    public String b;
    public boolean b0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1347g;
    public boolean g0;
    public SharedPreferences i0;
    public final String l;
    public String m;
    public long q;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1348h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1349i = "2.4.14";
    public String k = "unknown";
    public boolean n = true;
    public String o = "unknown";
    public String p = "";
    public String r = null;
    public long s = -1;
    public long t = -1;
    public long u = -1;
    public String v = null;
    public String w = null;
    public Map<String, PlugInBean> x = null;
    public boolean y = true;
    public String z = null;
    public String A = null;
    public String B = null;
    public String C = null;
    public String D = null;
    public Boolean E = null;
    public String F = null;
    public String G = null;
    public String H = null;
    public Map<String, PlugInBean> I = null;
    public Map<String, PlugInBean> J = null;
    public List<String> K = null;
    public int L = -1;
    public int M = -1;
    public Map<String, String> N = new HashMap();
    public Map<String, String> O = new HashMap();
    public Map<String, String> P = new HashMap();
    public boolean Q = true;
    public String R = "unknown";
    public long S = 0;
    public long T = 0;
    public long U = 0;
    public long V = 0;
    public String W = null;
    public String X = null;
    public String Y = null;
    public String Z = "";
    public boolean a0 = false;
    public Boolean c0 = null;
    public Boolean d0 = null;
    public HashMap<String, String> e0 = new HashMap<>();
    public List<String> f0 = new ArrayList();
    public d h0 = null;
    public final Object j0 = new Object();
    public final Object k0 = new Object();
    public final Object l0 = new Object();
    public final Object m0 = new Object();
    public final Object n0 = new Object();
    public final Object o0 = new Object();
    public final Object p0 = new Object();
    public final long c = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte f1344d = 1;
    public final String j = c.e();

    public b(Context context) {
        this.b0 = false;
        this.a = f.d(context);
        this.f1345e = a.d(context);
        this.f1346f = a.e(context, Process.myPid());
        String str = "Android " + c.q() + ",level " + c.d();
        this.l = str;
        String str2 = this.k + RetryStaticsLOG.MARK_END + str;
        try {
            if (!context.getDatabasePath("fireeye_db_").exists()) {
                this.b0 = true;
                e.f.a.a.a.k.c.b("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.i0 = f.j("FIREEYE_COMMON_VALUES", context);
        e.f.a.a.a.k.c.b("com info create end", new Object[0]);
    }

    public static synchronized b e(Context context) {
        if (q0 == null) {
            q0 = new b(context);
        }
        return q0;
    }

    public static synchronized b m() {
        return q0;
    }

    public boolean A() {
        if (this.d0 == null) {
            this.d0 = Boolean.valueOf(c.t(this.a));
            e.f.a.a.a.k.c.f("Does it has hook frame? " + this.d0, new Object[0]);
        }
        return this.d0.booleanValue();
    }

    public boolean B() {
        return this.Q;
    }

    public boolean C() {
        if (this.c0 == null) {
            this.c0 = Boolean.valueOf(c.w(this.a));
            e.f.a.a.a.k.c.f("Is it a virtual machine? " + this.c0, new Object[0]);
        }
        return this.c0.booleanValue();
    }

    public final void D(Context context) {
        PackageInfo packageInfoC = a.c(context);
        if (packageInfoC == null) {
            return;
        }
        try {
            String str = packageInfoC.versionName;
            this.A = str;
            this.W = str;
            this.X = Integer.toString(packageInfoC.versionCode);
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public String E() {
        try {
            Map<String, ?> all = this.a.getSharedPreferences("FireEyeSdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.k0) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.e0.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            e.f.a.a.a.k.c.k(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            e.f.a.a.a.k.c.k(th2);
        }
        if (this.e0.isEmpty()) {
            e.f.a.a.a.k.c.b("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.e0.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(",");
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        e.f.a.a.a.k.c.b("SDK_INFO = %s", sb.toString());
        F("SDK_INFO", sb.toString());
        return sb.toString();
    }

    public void F(String str, String str2) {
        if (!f.q(str) && !f.q(str2)) {
            synchronized (this.m0) {
                this.P.put(str, str2);
            }
            return;
        }
        e.f.a.a.a.k.c.j("server key&value should not be empty %s %s", "" + str, "" + str2);
    }

    public void G(String str, String str2) {
        if (!f.q(str) && !f.q(str2)) {
            synchronized (this.l0) {
                this.N.put(str, str2);
            }
            return;
        }
        e.f.a.a.a.k.c.j("key&value should not be empty %s %s", "" + str, "" + str2);
    }

    public void H() {
        synchronized (this.j0) {
            this.b = UUID.randomUUID().toString();
        }
    }

    public void I(boolean z) {
        this.Q = z;
        d dVar = this.h0;
        if (dVar != null) {
            dVar.setNativeIsAppForeground(z);
        }
    }

    public void J(String str) {
        this.C = str;
        F("APP_ID", str);
    }

    public void K(String str) {
        this.A = str;
    }

    public void L(String str) {
        this.m = str;
        synchronized (this.p0) {
            this.O.put("E8", str);
        }
    }

    public void M(String str) {
        this.k = str;
        String str2 = this.k + RetryStaticsLOG.MARK_END + this.l;
    }

    public synchronized void N(String str) {
        String str2 = "" + str;
    }

    public synchronized void O(String str) {
        this.p = "" + str;
    }

    public void P(String str) {
        synchronized (this.o0) {
            if (str == null) {
                str = "10000";
            }
            this.o = "" + str;
        }
    }

    public Set<String> a() {
        Set<String> setKeySet;
        synchronized (this.l0) {
            setKeySet = this.N.keySet();
        }
        return setKeySet;
    }

    public String b() {
        if (!this.y) {
            return "";
        }
        if (this.r == null) {
            this.r = f.k("androidid", "");
            String strC = c.c(this.a);
            this.r = strC;
            if (!TextUtils.isEmpty(strC)) {
                f.w("androidid", this.r);
            }
        }
        return this.r;
    }

    public String c() {
        return !f.q(this.f1347g) ? this.f1347g : this.C;
    }

    public String d() {
        if (this.A == null) {
            D(this.a);
        }
        return this.A;
    }

    public Map<String, String> f() {
        synchronized (this.p0) {
            if (this.O.size() <= 0) {
                return null;
            }
            return new HashMap(this.O);
        }
    }

    public Map<String, String> g() {
        synchronized (this.m0) {
            if (this.P.size() <= 0) {
                return null;
            }
            return new HashMap(this.P);
        }
    }

    public Map<String, String> h() {
        synchronized (this.l0) {
            if (this.N.size() <= 0) {
                return null;
            }
            return new HashMap(this.N);
        }
    }

    public String i() {
        if (this.z == null) {
            this.z = c.f();
        }
        return this.z;
    }

    public String j() {
        if (this.w == null) {
            this.w = c.h(this.a);
        }
        return this.w;
    }

    public String k() {
        if (this.v == null) {
            this.v = c.g(this.a, true);
        }
        return this.v;
    }

    public String l() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        if (!this.n) {
            return "unknown";
        }
        String strB = b();
        this.m = strB;
        return strB;
    }

    public Boolean n() {
        if (this.E == null) {
            this.E = Boolean.valueOf(c.v());
        }
        return this.E;
    }

    public synchronized Map<String, PlugInBean> o() {
        Map<String, PlugInBean> map;
        map = this.I;
        Map<String, PlugInBean> map2 = this.J;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public synchronized Map<String, PlugInBean> p() {
        Map<String, PlugInBean> map = this.x;
        if (map != null && map.size() > 0) {
            HashMap map2 = new HashMap(this.x.size());
            map2.putAll(this.x);
            return map2;
        }
        return null;
    }

    public synchronized String q() {
        return this.p;
    }

    public String r() {
        if (this.F == null) {
            String str = "" + c.n(this.a);
            this.F = str;
            e.f.a.a.a.k.c.f("ROM ID: %s", str);
        }
        return this.F;
    }

    public int s() {
        return this.M;
    }

    public String t() {
        String str;
        synchronized (this.j0) {
            if (this.b == null) {
                H();
            }
            str = this.b;
        }
        return str;
    }

    public long u() {
        if (this.t <= 0) {
            this.t = c.l();
        }
        return this.t;
    }

    public long v() {
        if (this.s <= 0) {
            this.s = c.o();
        }
        return this.s;
    }

    public long w() {
        if (this.u <= 0) {
            this.u = c.p();
        }
        return this.u;
    }

    public String x() {
        String str;
        synchronized (this.o0) {
            str = this.o;
        }
        return str;
    }

    public int y() {
        int size;
        synchronized (this.l0) {
            size = this.N.size();
        }
        return size;
    }

    public int z() {
        int i2;
        synchronized (this.n0) {
            i2 = this.L;
        }
        return i2;
    }
}
