package e.c.a.g.a.f;

import android.app.Activity;
import android.text.TextUtils;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a = false;
    public static List<String> b;
    public static List<String> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Boolean f634f;

    public static void a(Activity activity) {
    }

    public static boolean b() {
        if (f632d == null) {
            f632d = Boolean.valueOf(c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.W3, false));
        }
        return f632d.booleanValue();
    }

    public static boolean c() {
        return !m.l();
    }

    public static boolean d() {
        if (l1.X() && "A13".equals(l1.q())) {
            return true;
        }
        return l1.g0();
    }

    public static boolean e() {
        return l1.n0();
    }

    public static boolean f() {
        if (l1.h0() || l1.f0() || l1.n0() || l1.N() || l1.X() || l1.b0()) {
            if (!a) {
                a = true;
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setFo("头像开关").setType("1").setSvar1("头像修改入口展示 isHideEditUserPicEntry = true"));
                e.c.a.g.a.d.d0.a.a("FuncCtrl", "头像修改入口展示 isHideEditUserPicEntry = true");
            }
            return true;
        }
        boolean zC = c();
        boolean zD = d();
        if (!a) {
            a = true;
            String str = "头像修改入口展示, isHideEditPicByCamera = " + zC + ", isHideEditPicByGallery = " + zD;
            e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setFo("头像开关").setType("1").setSvar1(str));
            e.c.a.g.a.d.d0.a.a("FuncCtrl", str);
        }
        return zC && zD;
    }

    public static boolean g() {
        if (l1.n0()) {
            return true;
        }
        return c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.Z1, false);
    }

    public static boolean h() {
        return l1.N();
    }

    public static boolean i() {
        return l1.N();
    }

    public static boolean j() {
        return l1.U() || l1.n0();
    }

    public static boolean k() {
        return l1.g0() ? !f.q() : l1.X();
    }

    public static boolean l() {
        return l1.Y();
    }

    public static boolean m() {
        String[] strArrT;
        if (c == null) {
            String strB = c.c().b(e.c.a.g.a.f.e.b.Y1, "");
            if (!TextUtils.isEmpty(strB) && (strArrT = h1.t(strB, ",")) != null) {
                c = Arrays.asList(strArrT);
            }
            if (c == null) {
                c = Collections.emptyList();
            }
        }
        return c.contains(l1.q());
    }

    public static boolean n() {
        if (f634f == null) {
            f634f = Boolean.valueOf(c.c().getConfigAsInt(e.c.a.g.a.f.e.b.Y3, 1) == 1);
        }
        return f634f.booleanValue();
    }

    public static boolean o() {
        String[] strArrT;
        if (l1.f0() || l1.g0() || l1.X() || l1.b0()) {
            return true;
        }
        if (l1.N() && "D1".equals(l1.q())) {
            return true;
        }
        if (b == null) {
            String config = c.c().getConfig(e.c.a.g.a.f.e.b.V1);
            if (!TextUtils.isEmpty(config) && (strArrT = h1.t(config, ",")) != null) {
                b = Arrays.asList(strArrT);
            }
            if (b == null) {
                b = Collections.emptyList();
            }
        }
        return b.contains(l1.q());
    }

    public static boolean p() {
        try {
            return c.c().getConfigAsInt(e.c.a.g.a.f.e.b.a2, 1) == 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static boolean q() {
        if (l1.f0()) {
            return e.c.a.g.a.f.o.i.c.a().b();
        }
        return false;
    }

    public static boolean r() {
        return j();
    }

    public static boolean s() {
        if (f633e == null) {
            f633e = Boolean.valueOf(c.c().getConfigAsInt(e.c.a.g.a.f.e.b.X3, 1) == 1);
        }
        return f633e.booleanValue();
    }

    public static boolean t() {
        return l1.n0();
    }

    public static boolean u() {
        return (l1.m0() || t()) && c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.k2, true);
    }

    public static boolean v() {
        return c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.l2, true) && !m();
    }
}
