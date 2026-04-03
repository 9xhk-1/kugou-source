package e.c.a.g.a.d.r.j.c;

import android.content.BroadcastReceiver;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BroadcastReceiver f492g;

    public g(e.c.a.g.a.d.r.n.d dVar) {
        super(dVar);
        this.f490e = false;
        this.f491f = false;
    }

    public final void e() {
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public boolean isCurrentAlbumBuy() {
        return false;
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public boolean isSkipBuy() {
        return false;
    }

    @Override // e.c.a.g.a.d.r.j.c.e, e.c.a.g.a.d.r.j.d.c
    public void onCreate() {
        super.onCreate();
        e();
        if (e.c.a.g.a.r.b.F()) {
            this.f491f = false;
        }
    }

    @Override // e.c.a.g.a.d.r.j.c.e, e.c.a.g.a.d.r.j.d.c
    public void onDestroy() {
        super.onDestroy();
        getFeeTaskImpl().e();
        BroadcastReceiver broadcastReceiver = this.f492g;
        if (broadcastReceiver != null) {
            e.c.a.g.a.f.d.a.g(broadcastReceiver);
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void setDownloadSize(float f2) {
    }
}
