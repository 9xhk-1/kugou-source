package e.c.a.g.a.f.j.b;

import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import e.c.a.g.a.f.j.b.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> implements n {
    public T a;
    public String b;
    public int c;

    public b(T t) {
        this.a = t;
    }

    public void a(boolean z) {
        this.c = m.p(z, this.c);
    }

    public void b(boolean z) {
        this.c = m.u(z, this.c);
    }

    public void c(boolean z) {
        this.c = m.r(z, this.c);
    }

    public void d(boolean z) {
        this.c = m.s(z, this.c);
    }

    public void e(boolean z) {
        this.c = m.t(z, this.c);
    }

    public void f(boolean z) {
        this.c = m.v(z, this.c);
    }

    @Override // e.c.a.g.a.f.j.b.n
    public boolean feeKeyVaild() {
        return !TextUtils.isEmpty(getHash());
    }

    @Override // e.c.a.g.a.f.j.b.n
    public boolean fromCache() {
        return getMusicTransParamEnenty() != null && getMusicTransParamEnenty().isFromCache();
    }

    @Override // e.c.a.g.a.f.j.b.n, e.c.a.g.a.f.j.b.o
    public String getFeeKey() {
        if (this.b == null) {
            this.b = m.e(getHash(), getAlbumId());
        }
        return this.b;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public abstract MusicTransParamEnenty getMusicTransParamEnenty();

    @Override // e.c.a.g.a.f.j.b.n
    public int getUpdataFlag() {
        return this.c;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public boolean isUpdateFeeStatusTimeOut() {
        return m.k(getUpdateFeeStatusTime());
    }

    @Override // e.c.a.g.a.f.j.b.n
    public void updateData(n nVar, j.c cVar) {
        updateData(nVar);
    }
}
