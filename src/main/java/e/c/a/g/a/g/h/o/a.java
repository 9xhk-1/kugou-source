package e.c.a.g.a.g.h.o;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.kugou.framework.tmeab.VipPriABConfigHandler;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.s0;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();
    public static final boolean b;

    static {
        b = c.a.a().getConfigAsInt(b.R2, 1) == 1;
        new Handler(Looper.getMainLooper());
    }

    public final int a() {
        int bell = VipPriABConfigHandler.Companion.getBell();
        Log.e("mhs_watch_vip", j.l("getBell ", Integer.valueOf(bell)));
        return bell;
    }

    public final int b() {
        int download = VipPriABConfigHandler.Companion.getDownload();
        Log.e("mhs_watch_vip", j.l("getDownload ", Integer.valueOf(download)));
        return download;
    }

    public final void c(String str) {
        j.e(str, "source");
        if (b) {
            Log.e("mhs_watch_vip", j.l("gotoVipPage ", str));
            Bundle bundle = new Bundle();
            bundle.putString("vip_source", str);
            boolean zO = e.c.a.g.a.r.b.O();
            if (!e.c.a.g.a.r.b.F()) {
                s0.a.l("8");
                return;
            }
            if (zO) {
                s0.a.B(bundle);
                return;
            }
            s0 s0Var = s0.a;
            s0Var.B(bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("viewpager_framework_delegate_open_two_fragment", true);
            bundle2.putString("vip_source", str);
            s0Var.C(bundle2);
        }
    }

    public final boolean d() {
        boolean z = c.a.a().getConfigAsInt(b.d0, 1) == 1;
        Log.e("mhs_watch_vip", j.l("onlyVipCanDownload ", Boolean.valueOf(z)));
        return z;
    }

    public final boolean e() {
        boolean z = c.a.a().getConfigAsInt(b.e0, 1) == 1;
        Log.e("mhs_watch_vip", j.l("onlyVipCanSetRing ", Boolean.valueOf(z)));
        return z;
    }
}
