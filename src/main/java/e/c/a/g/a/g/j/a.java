package e.c.a.g.a.g.j;

import android.view.View;
import android.view.ViewGroup;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.component.player.PlayerPage;
import e.c.a.g.a.s.f0;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f926d = "a";
    public PlayerPage a;
    public DelegateFragment b;
    public DelegateFragment c;

    public final void a(int i2) {
        PlayerPage playerPage = this.a;
        if (playerPage == null || i2 == playerPage.d()) {
            return;
        }
        if (i2 == 1) {
            if (this.b == null) {
                throw new IllegalArgumentException("must call setHost first!");
            }
            this.a.t(1);
            this.a.s(this.b);
            return;
        }
        if (i2 != 2) {
            return;
        }
        if (this.c == null) {
            throw new IllegalArgumentException("must call setHost first!");
        }
        this.a.t(2);
        this.a.s(this.c);
    }

    public void b(int i2, DelegateFragment delegateFragment) {
        k();
        if (2 == i2) {
            this.c = delegateFragment;
            this.a.t(2);
            this.a.s(this.c);
        } else {
            if (1 != i2) {
                throw new IllegalArgumentException(String.format("No support type here! type:%s", Integer.valueOf(i2)));
            }
            this.b = delegateFragment;
            this.a.t(1);
            this.a.s(this.b);
        }
    }

    public void c() {
        PlayerPage playerPage = this.a;
        if (playerPage == null) {
            return;
        }
        playerPage.r();
        DelegateFragment delegateFragment = this.b;
        if (delegateFragment == null) {
            return;
        }
        View view = delegateFragment.getView();
        if (view instanceof ViewGroup) {
            this.a.r();
            ((ViewGroup) view).addView(this.a.f());
            if (g0.a) {
                g0.b(f926d, "onAttachToMainFragment");
            }
            this.a.b(this.b, 1);
            this.a.g();
        }
    }

    public void d() {
        DelegateFragment delegateFragment;
        if (this.a == null || (delegateFragment = this.c) == null) {
            return;
        }
        View view = delegateFragment.getView();
        if (view instanceof ViewGroup) {
            this.a.r();
            ((ViewGroup) view).addView(this.a.f());
            if (g0.a) {
                g0.b(f926d, "onAttachToNormalFragment");
            }
            this.a.b(this.c, 2);
        }
    }

    public void e(int i2) {
        if (this.a.f() == null) {
            a(i2);
            this.a.i();
        }
    }

    public void f(int i2) {
        this.b = null;
        this.c = null;
        l();
    }

    public void g(int i2) {
        a(i2);
        PlayerPage playerPage = this.a;
        if (playerPage != null) {
            playerPage.l();
        }
    }

    public void h(int i2) {
        a(i2);
        PlayerPage playerPage = this.a;
        if (playerPage != null) {
            playerPage.p();
        }
    }

    public void i(int i2) {
        a(i2);
        this.a.q();
    }

    public void j(int i2, boolean z) {
        if (this.a == null) {
            return;
        }
        a(i2);
        this.a.u(z);
    }

    public void k() {
        if (g0.a) {
            f0.c();
        }
        if (this.a == null) {
            this.a = new PlayerPage();
        }
    }

    public void l() {
        if (g0.a) {
            f0.c();
        }
        PlayerPage playerPage = this.a;
        if (playerPage != null && this.c == null && this.b == null) {
            playerPage.j();
            this.a = null;
        }
    }
}
