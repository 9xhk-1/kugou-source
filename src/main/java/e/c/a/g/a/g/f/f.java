package e.c.a.g.a.g.f;

import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final int a;
    public final PageKey b;
    public final KGMusic c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e.c.a.g.a.d.r.e f773e;

    public f(int i2, PageKey pageKey, KGMusic kGMusic, String str, e.c.a.g.a.d.r.e eVar) {
        j.e(pageKey, "pageKey");
        j.e(kGMusic, "music");
        j.e(str, "callbackKey");
        j.e(eVar, "musicFeesInterface");
        this.a = i2;
        this.b = pageKey;
        this.c = kGMusic;
        this.f772d = str;
        this.f773e = eVar;
    }

    public final String a() {
        return this.f772d;
    }

    public final KGMusic b() {
        return this.c;
    }

    public final e.c.a.g.a.d.r.e c() {
        return this.f773e;
    }

    public final int d() {
        return this.a;
    }

    public final PageKey e() {
        return this.b;
    }
}
