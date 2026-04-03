package e.c.a.g.a.g.f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.g.i.w;
import e.c.a.g.a.g.i.y;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.u0;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c a = new c();
    public static boolean b;
    public static boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f771i;
    public static final String j;
    public static final boolean k;

    public static final class a implements Runnable {
        public final /* synthetic */ int a;

        public a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (w.l.g()) {
                return;
            }
            e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
            String strJ = e.c.a.g.a.r.b.j();
            j.d(strJ, "getMyFavPlaylistId()");
            e.c.a.g.a.d.f.c.a.j jVarI = bVar.i(strJ);
            w wVarD = y.e().d();
            wVarD.q(this.a);
            y.e().a(1, jVarI == null ? 0 : jVarI.e(), wVarD);
        }
    }

    public static final class b implements Runnable {
        public static final b a = new b();

        @Override // java.lang.Runnable
        public final void run() {
            e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
            String strJ = e.c.a.g.a.r.b.j();
            j.d(strJ, "getMyFavPlaylistId()");
            e.c.a.g.a.d.f.c.a.j jVarI = bVar.i(strJ);
            w wVarD = y.e().d();
            wVarD.q(w.l.e());
            y.e().a(1, jVarI == null ? 0 : jVarI.e(), wVarD);
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        c.b bVar = e.c.a.g.a.f.e.c.a;
        b = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.x3, 1) == 1;
        c = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.w3, 1) == 1;
        f766d = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.z3, 30);
        f767e = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.y3, 0);
        f768f = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.B3, 0) == 1;
        f769g = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.C3, 100);
        f770h = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.l1, 1) == 1;
        f771i = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.T2, 1) == 1;
        j = "FavOptionHelper";
        k = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.y0, 1) == 1;
    }

    public static /* synthetic */ void t(c cVar, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        cVar.s(str, str2);
    }

    public boolean a() {
        boolean z = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.t3, 1) == 1;
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a(w.l.f(), j.l("检查是否满足刷新条件 enable = ", Boolean.valueOf(z)));
        }
        return z;
    }

    public boolean b() {
        if (e.c.a.g.a.r.b.F()) {
            return e.c.a.g.a.f.m.b.m().e() < e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.v3, 500);
        }
        return false;
    }

    public boolean c() {
        int iK = e.c.a.g.a.f.m.b.m().k();
        if (iK != 3 && iK != 4) {
            return true;
        }
        boolean zB = h.a.b();
        if (zB) {
            t(a, "checkApiError = RefreshLimiter canRefresh false", null, 2, null);
        }
        if (g0.a) {
            g0.b(w.l.f(), "checkNeedForceRefreshFavData: checkApiError = RefreshLimiter canApiRefresh = " + zB + "， favLastApiError = " + e.c.a.g.a.f.m.b.m().k());
        }
        return zB;
    }

    public boolean d() {
        int iK;
        if (!n() || !e.c.a.g.a.r.b.F() || (iK = e.c.a.g.a.f.m.b.m().k()) <= 0) {
            return false;
        }
        if (g0.a) {
            g0.b(w.l.f(), j.l("checkNeedForceRefreshFavData: 上次接口调用发生错误，强刷 刷新接口 CommonSettingPrefs.getInstance().favLastApiError = ", Integer.valueOf(iK)));
        }
        t(a, j.l("favLastApiError = ", Integer.valueOf(iK)), null, 2, null);
        return true;
    }

    public boolean e() {
        boolean z = false;
        if (!q() || !e.c.a.g.a.r.b.F() || !u0.n(KGApplication.getContext(), false)) {
            return false;
        }
        i iVar = i.a;
        if (!iVar.b()) {
            return false;
        }
        if (r()) {
            z = true;
            t(a, "checkCountError 数量不满足要求, 触发更新逻辑", null, 2, null);
        }
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a(w.l.f(), "检查更新 checkNeedForceRefreshFavData:  checkCountError = " + z + ", canRefresh = " + iVar.b());
        }
        return z;
    }

    public boolean f() {
        boolean zE = e();
        boolean z = d() && c();
        boolean zG = g();
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a(w.l.f(), "检查是否满足刷新条件 checkNeedForceRefreshFavData: checkCountError = " + zE + ", checkApiError = " + z + ", checkNeedForceReload = " + zG);
        }
        return zE || z || zG;
    }

    public boolean g() {
        if (k() <= 0 || !e.c.a.g.a.r.b.F()) {
            return false;
        }
        u();
        int iL = e.c.a.g.a.f.m.b.m().l();
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a(w.l.f(), "checkCountError: forceUpdateCount = " + k() + " hasForceReloadFavListCount = " + iL);
        }
        return iL < k();
    }

    public boolean h() {
        return f771i;
    }

    public boolean i() {
        return f770h;
    }

    public boolean j() {
        return f768f;
    }

    public int k() {
        return f767e;
    }

    public int l() {
        return f766d;
    }

    public int m() {
        return f769g;
    }

    public boolean n() {
        return b;
    }

    public boolean o() {
        boolean z = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.M3, 1) == 1;
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("mhs_watch_fav", j.l("数量不一致纠错，isEnableAdapterNumError configSwith=", Boolean.valueOf(z)));
        }
        return z;
    }

    public boolean p() {
        boolean zB = b();
        boolean z = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.u3, 1) == 1;
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a("mhs_watch_fav", "isEnableLoadFavData configSwith=" + z + " canRefreshFavCount=" + zB);
        }
        return z && zB;
    }

    public boolean q() {
        return c;
    }

    public boolean r() {
        return e.c.a.g.a.r.b.F() && e.c.a.g.a.f.m.b.m().e() >= 0 && e.c.a.g.a.f.m.b.m().e() <= l();
    }

    public void s(String str, String str2) {
        try {
            if (e.c.a.g.a.d.d0.a.a) {
                e.c.a.g.a.d.d0.a.a(j, "page /收藏/我喜欢歌单同步 1," + ((Object) str) + ",2," + ((Object) str2));
            }
            boolean z = k;
            if (z) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("10").setFo("/收藏/我喜欢歌单同步").setSvar1(str).setSvar2(str2));
            } else if (g0.f()) {
                g0.c("mhs_watch", j.l("TYPE_FAV_SYS needReport = ", Boolean.valueOf(z)));
            }
        } catch (Exception e2) {
            Log.e("reportHead", j.l("e = ", e2));
        }
    }

    public void u() {
        if (k() > 0 && !e.c.a.g.a.f.m.b.m().C()) {
            boolean zA = e.c.a.g.a.f.m.b.m().a();
            e.c.a.g.a.f.m.b.m().S(0);
            e.c.a.g.a.f.m.b.m().U();
            if (e.c.a.g.a.d.d0.a.a) {
                e.c.a.g.a.d.d0.a.a(w.l.f(), "updateForceReloadCount: hasKey = " + zA + " hasForceReloadFavListCount = 0");
            }
        }
    }

    public final void v() {
        e.c.a.g.a.f.m.b.m().Q(-1);
        e.c.a.g.a.f.m.b.m().K(-1);
    }

    public void w(int i2) {
        if (w.l.g()) {
            return;
        }
        j0.b().a(new a(i2));
    }

    public void x(boolean z) {
        if (z) {
            j0.b().a(b.a);
        }
    }

    public void y() {
        if (k() <= 0) {
            return;
        }
        int iL = e.c.a.g.a.f.m.b.m().l();
        if (iL < k()) {
            e.c.a.g.a.f.m.b.m().S(iL + 1);
        }
        if (e.c.a.g.a.d.d0.a.a) {
            e.c.a.g.a.d.d0.a.a(w.l.f(), "updateForceReloadCount: forceUpdateCount = " + k() + " hasForceReloadFavListCount = " + iL);
        }
    }
}
