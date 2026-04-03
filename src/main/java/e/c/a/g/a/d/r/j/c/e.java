package e.c.a.g.a.d.r.j.c;

import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements e.c.a.g.a.d.r.j.d.c, e.c.a.g.a.d.r.j.d.d, e.c.a.g.a.d.r.j.d.b {
    public final String a = "MusicFeesDelegate/" + getClass().getSimpleName();
    public e.c.a.g.a.d.r.j.d.a b;
    public AbsFrameworkActivity c;

    @Override // e.c.a.g.a.d.r.j.d.c
    public void attachActivity(AbsFrameworkActivity absFrameworkActivity) {
        this.c = absFrameworkActivity;
    }

    @Override // e.c.a.g.a.d.r.j.d.b
    public int getSelSongQuality() {
        return 0;
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void onCreate() {
        if (g0.a) {
            g0.e(this.a, "onCreate");
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void onDestroy() {
        if (g0.a) {
            g0.e(this.a, "onDestroy");
        }
    }

    @Override // e.c.a.g.a.d.r.j.d.c
    public void setControlFeesAction(e.c.a.g.a.d.r.j.d.a aVar) {
        this.b = aVar;
    }
}
