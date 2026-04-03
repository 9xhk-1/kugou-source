package e.c.a.g.a.d.r.j.c;

import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.u0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends d {
    public f(e.c.a.g.a.d.r.n.d dVar) {
        super(dVar);
    }

    public void A() {
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public void finish() {
        this.b.callFinish();
    }

    public boolean l() {
        return true;
    }

    public void m(e.c.a.g.a.d.r.l.a aVar) {
        g();
        int i2 = aVar.a;
        if (i2 == 1) {
            v(getTaskInfo().d());
        } else if (i2 == 0) {
            s(getTaskInfo().d(), aVar.b, aVar.c);
        } else {
            u(getTaskInfo().d(), aVar.c);
        }
    }

    public void n(e.c.a.g.a.d.r.l.a aVar) {
    }

    public int o() {
        List<e.c.a.g.a.d.r.n.a<?>> listB = b();
        if ((listB != null ? listB.size() : 0) > 0 && !e.c.a.g.a.r.b.F()) {
            showLoginDialog();
            return 0;
        }
        j(false);
        this.b.callPayInBackGuound();
        return 0;
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void onEndCheckPrivilege(e.c.a.g.a.d.r.p.a.a aVar) {
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void onFinishFeesDialog(int i2) {
        getFeeTaskImpl().H(i2);
        onFinishFeesDialogOnlyFinish();
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void onFinishFeesDialogOnlyFinish() {
        this.b.callFinish();
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void onPayInBackGuound() {
        if (!u0.m(this.c)) {
            g();
            this.b.callFinish();
            return;
        }
        this.f490e = false;
        e.c.a.g.a.d.r.l.a aVarProcessBuyResource = this.b.processBuyResource();
        n(aVarProcessBuyResource);
        if (aVarProcessBuyResource == null) {
            return;
        }
        if (g0.a) {
            g0.e(this.a, "payInBackGuound/processBuyResource:" + aVarProcessBuyResource);
        }
        this.f490e = true;
        m(aVarProcessBuyResource);
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void onShowFeesDialog() {
        if (showFeesDialog()) {
            this.b.callFinish();
            return;
        }
        if (!l()) {
            this.b.callFinish();
            return;
        }
        if (this.f491f && "Download".equals(getTaskInfo().d())) {
            j(false);
            onPayInBackGuound();
        } else {
            if (g0.a) {
                g0.b(this.a, "onShowFeesDialog call callFinishFeesDialog");
            }
            a();
        }
    }

    public void p(int i2) {
        if (i2 == 31401) {
            new e.c.a.g.a.d.r.d().j(this.c);
            showAlbumDialog();
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g
    public int pay(boolean z) {
        return o();
    }

    public void q() {
        r();
        a();
    }

    public void r() {
        h("已购买专辑");
    }

    public final void s(String str, int i2, int i3) {
        t(i2);
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.n.g, e.c.a.g.a.d.r.j.d.b
    public void showLoginDialog() {
    }

    public final void t(int i2) {
        if (isCurrentAlbumBuy()) {
            p(i2);
        } else {
            z(i2);
        }
    }

    public final void u(String str, int i2) {
        a();
    }

    public final void v(String str) {
        if ("Listen".equals(str)) {
            x();
        } else if ("Collection".equals(str)) {
            w();
        } else {
            y();
        }
    }

    public final void w() {
        if (isCurrentAlbumBuy()) {
            q();
        } else {
            a();
        }
    }

    public final void x() {
        if (isCurrentAlbumBuy()) {
            q();
        } else {
            h("已购买歌曲");
            a();
        }
    }

    public final void y() {
        if (isCurrentAlbumBuy()) {
            q();
        }
    }

    public void z(int i2) {
        h(e.c.a.g.a.d.r.g.g(i2));
        a();
    }
}
