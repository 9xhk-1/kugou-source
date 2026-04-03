package e.c.a.g.a.d.r.j.c;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.c.a.g.a.d.r.n.d f488d;

    public c(e.c.a.g.a.d.r.n.d dVar) {
        this.f488d = dVar;
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public void afterChecktPrivilege() {
        this.f488d.a();
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public void beforeCheckPrivilege() {
        this.f488d.b();
    }

    @Override // e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.j.d.b
    public List<e.c.a.g.a.d.r.n.a<?>> getFeeResourceDatas() {
        return this.f488d.f();
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public e.c.a.g.a.d.r.n.d getFeeTaskImpl() {
        return this.f488d;
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public List<e.c.a.g.a.d.r.n.a<?>> getPayFeeResourceDatas() {
        return this.f488d.i();
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public int getSongSource() {
        return this.f488d.k();
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public String getSource() {
        return this.f488d.l();
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public e.c.a.g.a.d.r.n.f getTaskInfo() {
        return this.f488d.n();
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public boolean isInteceptInterrupt() {
        return this.f488d.D();
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public boolean isStartWithoutLoading() {
        return this.f488d.G();
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public void listenSongPart(e.c.a.g.a.d.r.p.a.c cVar) {
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public boolean showFeesDialog() {
        return this.f488d.R();
    }
}
