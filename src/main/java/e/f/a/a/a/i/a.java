package e.f.a.a.a.i;

import android.content.Context;
import com.kugou.common.network.OKHttpManager;
import com.tme.fireeye.crash.comm.strategy.StrategyBean;
import e.f.a.a.a.g.b;
import e.f.a.a.a.k.c;
import e.f.a.a.a.k.f;
import e.f.a.a.d.a.h;
import e.f.a.a.d.a.i;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f1350f = 1000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static a f1351g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f1352h = 259200000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f1353i;
    public final List<e.f.a.a.a.a> a;
    public final e.f.a.a.a.k.a b;
    public final StrategyBean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StrategyBean f1354d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f1355e;

    /* JADX INFO: renamed from: e.f.a.a.a.i.a$a, reason: collision with other inner class name */
    public class C0245a extends Thread {
        public C0245a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Map<String, byte[]> mapV = b.r().v(a.f1350f, null, true);
                if (mapV != null) {
                    byte[] bArr = mapV.get("device");
                    byte[] bArr2 = mapV.get(OKHttpManager.GATEWAY_KEY);
                    if (bArr != null) {
                        e.f.a.a.a.h.b.e(a.this.f1355e).O(new String(bArr));
                    }
                    if (bArr2 != null) {
                        e.f.a.a.a.h.b.e(a.this.f1355e).N(new String(bArr2));
                    }
                }
                a aVar = a.this;
                aVar.f1354d = aVar.l();
                if (a.this.f1354d != null) {
                    if (f.q(a.f1353i) || !f.J(a.f1353i)) {
                        a.this.f1354d.q = StrategyBean.z;
                        a.this.f1354d.r = StrategyBean.A;
                    } else {
                        a.this.f1354d.q = a.f1353i;
                        a.this.f1354d.r = a.f1353i;
                    }
                }
            } catch (Throwable th) {
                if (!c.k(th)) {
                    th.printStackTrace();
                }
            }
            a aVar2 = a.this;
            aVar2.m(aVar2.f1354d, false);
        }
    }

    public a(Context context, List<e.f.a.a.a.a> list) {
        this.f1355e = context;
        e(context);
        this.c = new StrategyBean();
        this.a = list;
        this.b = e.f.a.a.a.k.a.b();
    }

    public static void e(Context context) {
        if (e.f.a.a.a.h.b.e(context) != null) {
            String str = e.f.a.a.a.h.b.e(context).Z;
            if ("oversea".equals(str)) {
                StrategyBean.z = "https://report.tencentmusic.com/api/v1/crash";
                StrategyBean.A = "https://report.tencentmusic.com/api/v1/crash";
            } else if ("na_https".equals(str)) {
                StrategyBean.z = "https://report.tencentmusic.com/api/v1/crash";
                StrategyBean.A = "https://report.tencentmusic.com/api/v1/crash";
            }
        }
    }

    public static synchronized a g() {
        return f1351g;
    }

    public static synchronized a j(Context context, List<e.f.a.a.a.a> list) {
        if (f1351g == null) {
            f1351g = new a(context, list);
        }
        return f1351g;
    }

    public StrategyBean f() {
        return this.c;
    }

    public StrategyBean h() {
        StrategyBean strategyBean = this.f1354d;
        if (strategyBean != null) {
            if (!f.J(strategyBean.q)) {
                this.f1354d.q = StrategyBean.z;
            }
            if (!f.J(this.f1354d.r)) {
                this.f1354d.r = StrategyBean.A;
            }
            return this.f1354d;
        }
        if (!f.q(f1353i) && f.J(f1353i)) {
            StrategyBean strategyBean2 = this.c;
            String str = f1353i;
            strategyBean2.q = str;
            strategyBean2.r = str;
        }
        return this.c;
    }

    public synchronized boolean i() {
        return this.f1354d != null;
    }

    public void k(long j) {
        this.b.e(new C0245a(), j);
    }

    public StrategyBean l() {
        byte[] bArr;
        List<e.f.a.a.a.g.c> listT = b.r().t(2);
        if (listT == null || listT.size() <= 0 || (bArr = listT.get(0).f1343g) == null) {
            return null;
        }
        return (StrategyBean) f.H(bArr, StrategyBean.CREATOR);
    }

    public void m(StrategyBean strategyBean, boolean z) {
        c.b("[Strategy] Notify %s", e.f.a.a.a.e.b.class.getName());
        e.f.a.a.a.e.b.w(strategyBean, z);
        for (e.f.a.a.a.a aVar : this.a) {
            try {
                c.b("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.f(strategyBean);
            } catch (Throwable th) {
                if (!c.k(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void n(i iVar) {
        if (iVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f1354d;
        if (strategyBean == null || iVar.k != strategyBean.o) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f269d = iVar.a;
            strategyBean2.f271h = iVar.f1448d;
            strategyBean2.f270f = iVar.b;
            if (f.q(f1353i) || !f.J(f1353i)) {
                if (f.J(iVar.f1449f)) {
                    c.b("[Strategy] Upload url changes to %s", iVar.f1449f);
                    strategyBean2.q = iVar.f1449f;
                }
                if (f.J(iVar.f1450h)) {
                    c.b("[Strategy] Exception upload url changes to %s", iVar.f1450h);
                    strategyBean2.r = iVar.f1450h;
                }
            }
            h hVar = iVar.f1451i;
            if (hVar != null && !f.q(hVar.a)) {
                strategyBean2.s = iVar.f1451i.a;
            }
            long j = iVar.k;
            if (j != 0) {
                strategyBean2.o = j;
            }
            Map<String, String> map = iVar.j;
            if (map != null && map.size() > 0) {
                Map<String, String> map2 = iVar.j;
                strategyBean2.t = map2;
                String str = map2.get("B11");
                if (str == null || !str.equals("1")) {
                    strategyBean2.f272i = false;
                } else {
                    strategyBean2.f272i = true;
                }
                String str2 = iVar.j.get("B3");
                if (str2 != null) {
                    strategyBean2.w = Long.valueOf(str2).longValue();
                }
                int i2 = iVar.o;
                strategyBean2.p = i2;
                strategyBean2.v = i2;
                String str3 = iVar.j.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int i3 = Integer.parseInt(str3);
                        if (i3 > 0) {
                            strategyBean2.u = i3;
                        }
                    } catch (Exception e2) {
                        if (!c.k(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = iVar.j.get("B25");
                if (str4 == null || !str4.equals("1")) {
                    strategyBean2.k = false;
                } else {
                    strategyBean2.k = true;
                }
            }
            c.f("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f269d), Boolean.valueOf(strategyBean2.f271h), Boolean.valueOf(strategyBean2.f270f), Boolean.valueOf(strategyBean2.f272i), Boolean.valueOf(strategyBean2.j), Boolean.valueOf(strategyBean2.m), Boolean.valueOf(strategyBean2.n), Long.valueOf(strategyBean2.p), Boolean.valueOf(strategyBean2.k), Long.valueOf(strategyBean2.o));
            this.f1354d = strategyBean2;
            if (!f.J(iVar.f1449f)) {
                c.b("[Strategy] download url is null", new Object[0]);
                this.f1354d.q = "";
            }
            if (!f.J(iVar.f1450h)) {
                c.b("[Strategy] download crashurl is null", new Object[0]);
                this.f1354d.r = "";
            }
            b.r().y(2);
            e.f.a.a.a.g.c cVar = new e.f.a.a.a.g.c();
            cVar.b = 2;
            cVar.a = strategyBean2.a;
            cVar.f1341e = strategyBean2.b;
            cVar.f1343g = f.t(strategyBean2);
            b.r().C(cVar);
            m(strategyBean2, true);
        }
    }
}
