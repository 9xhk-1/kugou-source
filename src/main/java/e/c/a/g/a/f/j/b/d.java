package e.c.a.g.a.f.j.b;

import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import e.c.a.g.a.f.j.b.j;

/* JADX INFO: loaded from: classes.dex */
public class d implements n {
    public String a;
    public int b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f681f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f682g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f683h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MusicTransParamEnenty f684i;
    public int j;

    public void a(int i2) {
        this.f681f = i2;
    }

    public void b(int i2) {
        this.b = i2;
    }

    public void c(String str) {
        this.a = str;
    }

    public void d(int i2) {
        this.j = i2;
    }

    public void e(long j) {
        this.f682g = j;
    }

    public void f(String str) {
        this.c = str;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public boolean feeKeyVaild() {
        return !TextUtils.isEmpty(this.a);
    }

    @Override // e.c.a.g.a.f.j.b.n
    public boolean fromCache() {
        return true;
    }

    public void g(int i2) {
        this.f679d = i2;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public String getAlbumId() {
        return null;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public int getCharge() {
        return this.f681f;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public int getFailProcess() {
        return this.b;
    }

    @Override // e.c.a.g.a.f.j.b.n, e.c.a.g.a.f.j.b.o
    public String getFeeKey() {
        return this.a;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public String getHash() {
        return null;
    }

    @Override // e.c.a.g.a.f.j.b.n, e.c.a.g.a.f.j.b.o
    public long getMixId() {
        return this.f682g;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public String getMusicFeeType() {
        return this.c;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public MusicTransParamEnenty getMusicTransParamEnenty() {
        return this.f684i;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public String getName() {
        return null;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public int getOldCpy() {
        return this.f679d;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public int getPayType() {
        return this.f680e;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public int getUpdataFlag() {
        return this.j;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public long getUpdateFeeStatusTime() {
        return this.f683h;
    }

    public void h(int i2) {
        this.f680e = i2;
    }

    public void i(long j) {
        this.f683h = j;
    }

    @Override // e.c.a.g.a.f.j.b.n
    public boolean isUpdateFeeStatusTimeOut() {
        return m.k(getUpdateFeeStatusTime());
    }

    @Override // e.c.a.g.a.f.j.b.n
    public void updateData(n nVar) {
        if (getMixId() <= 0 && nVar.getMixId() > 0) {
            this.f682g = nVar.getMixId();
        }
        MusicTransParamEnenty musicTransParamEnentyW = m.w(this.f684i, nVar);
        if (musicTransParamEnentyW != null) {
            this.f684i = musicTransParamEnentyW;
        }
        if (m.j(nVar.getUpdataFlag())) {
            a(nVar.getCharge());
            b(nVar.getFailProcess());
            g(nVar.getOldCpy());
            h(nVar.getPayType());
            f(nVar.getMusicFeeType());
            i(nVar.getUpdateFeeStatusTime());
        }
        int updataFlag = getUpdataFlag();
        if (updataFlag == -1) {
            updataFlag = 63;
        }
        d(m.o(updataFlag | nVar.getUpdataFlag(), nVar));
    }

    @Override // e.c.a.g.a.f.j.b.n
    public void updateData(n nVar, j.c cVar) {
        updateData(nVar);
    }
}
