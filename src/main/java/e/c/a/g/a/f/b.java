package e.c.a.g.a.f;

import com.kugou.android.watch.lite.base.application.KGApplication;
import com.xtc.payapi.paymanager.PayApiManager;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static Boolean a;

    public static boolean a() {
        return c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.h2, true);
    }

    public static boolean b() {
        if (!l1.m0()) {
            return l1.V() || l1.X() || l1.b0() || l1.g0();
        }
        if (a == null) {
            a = Boolean.valueOf(new PayApiManager(KGApplication.getContext()).isSupportPay());
        }
        return a.booleanValue();
    }

    public static boolean c() {
        if (c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.h2, true)) {
            return b();
        }
        return false;
    }

    public static boolean d() {
        if (c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.i2, true)) {
            return b();
        }
        return false;
    }
}
