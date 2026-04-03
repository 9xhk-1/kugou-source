package e.c.a.g.a.g.j.c;

import android.util.Log;
import android.view.View;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.f.j.c.d;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.y0;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public final b a;

    public a(b bVar) {
        j.e(bVar, "provider");
        this.a = bVar;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z, boolean z2, boolean z3, boolean z4, View view, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkCommon");
        }
        boolean z5 = (i2 & 8) != 0 ? true : z4;
        if ((i2 & 32) != 0) {
            str = "0";
        }
        return aVar.a(z, z2, z3, z5, view, str);
    }

    public final boolean a(boolean z, boolean z2, boolean z3, boolean z4, View view, String str) {
        j.e(view, "view");
        j.e(str, "loginSource");
        if (z4 && u1.h(700)) {
            Log.d("mhs_watch", "checkCommon = 1");
            return false;
        }
        if (z && this.a.isQueueEmpty()) {
            DelegateFragment fragment = this.a.getFragment();
            p1.h(fragment == null ? null : fragment.requireContext(), "播放队列暂无歌曲，请添加后操作");
            Log.d("mhs_watch", "checkCommon = 2");
            return false;
        }
        if (z2 && c(str)) {
            Log.d("mhs_watch", "checkCommon = 2");
            return false;
        }
        if (!z3 || u0.m(this.a.getFragment().requireContext())) {
            Log.d("mhs_watch", "checkCommon = 4");
            return true;
        }
        Log.d("mhs_watch", "checkCommon = 3");
        return false;
    }

    public final boolean c(String str) {
        if (e.c.a.g.a.r.b.F()) {
            return false;
        }
        s0.a.l(str);
        return true;
    }

    public final b d() {
        return this.a;
    }

    public void e() {
    }

    public final boolean f() {
        KGMusicWrapper cur = this.a.getCur();
        if (cur == null) {
            return false;
        }
        if (d.c(cur)) {
            return true;
        }
        return f.p(true) && y0.c(cur, -1) > 0;
    }

    public void g(DelegateFragment delegateFragment, int i2) {
    }

    public void h() {
    }

    public void i(String str) {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void o() {
    }

    public void p() {
    }

    public void q(boolean z) {
    }

    public void r(boolean z) {
    }

    public void s(boolean z) {
    }
}
