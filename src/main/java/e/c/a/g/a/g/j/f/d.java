package e.c.a.g.a.g.j.f;

import android.view.ViewGroup;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.component.player.subview.PlayerMenuView;
import f.u.m;
import f.z.d.j;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends e.c.a.g.a.g.j.c.a {
    public final List<e.c.a.g.a.g.j.c.a> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e.c.a.g.a.g.j.c.b bVar, ViewGroup viewGroup) {
        super(bVar);
        j.e(bVar, "provider");
        j.e(viewGroup, "contentView");
        this.b = m.f(new e(viewGroup, d()), new a(viewGroup, d()), new PlayerMenuView(viewGroup, d()), new b(viewGroup, d()), new c(viewGroup, d()), new f(this, viewGroup, d()));
        e();
        e.c.a.g.a.f.o.e.a(viewGroup);
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void e() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void g(DelegateFragment delegateFragment, int i2) {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().g(delegateFragment, i2);
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void h() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void i(String str) {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().i(str);
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void j() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void k() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void l() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().l();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void m() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().m();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void n() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().n();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void o() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void p() {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void q(boolean z) {
        super.q(z);
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().q(z);
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void r(boolean z) {
        super.r(z);
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().r(z);
        }
    }

    @Override // e.c.a.g.a.g.j.c.a
    public void s(boolean z) {
        Iterator<e.c.a.g.a.g.j.c.a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().s(z);
        }
    }
}
