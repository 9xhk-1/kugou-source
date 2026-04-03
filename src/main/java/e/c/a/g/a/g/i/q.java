package e.c.a.g.a.g.i;

import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import e.c.a.g.a.s.l1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public short a;
    public long b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f884e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f888i;
    public boolean j;
    public boolean k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f885f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f886g = -1;
    public ArrayList<e.c.a.g.a.g.k.c.a> l = new ArrayList<>(0);

    public void a(ArrayList<e.c.a.g.a.g.k.c.a> arrayList) {
        if (arrayList == null) {
            return;
        }
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.addAll(arrayList);
    }

    public boolean b(int i2, int i3, String str, int i4, int i5, int i6, short s, String str2, int i7, String str3, int i8, int i9, String str4, long j, int i10, int i11, String str5, int i12, int i13, long j2, boolean z, MusicTransParamEnenty musicTransParamEnenty, String str6, int i14) {
        if (this.l == null) {
            this.l = new ArrayList<>(300);
        }
        e.c.a.g.a.g.k.c.a aVar = new e.c.a.g.a.g.k.c.a(i2, i3, str, i4, i5, i6, s, str2, i7, str3, i8, i9, str4, j, z);
        aVar.F(i10);
        aVar.B(i11);
        aVar.C(str5);
        aVar.G(i12);
        aVar.H(l1.b());
        aVar.E(i13);
        aVar.A(j2);
        aVar.D(musicTransParamEnenty);
        aVar.y(str6);
        aVar.z(i14);
        this.l.add(aVar);
        return true;
    }

    public String c() {
        return this.f888i;
    }

    public int d() {
        return this.f886g;
    }

    public short e() {
        return this.a;
    }

    public int f() {
        return this.f883d;
    }

    public int g() {
        return this.f884e;
    }

    public ArrayList<e.c.a.g.a.g.k.c.a> h() {
        return this.l;
    }

    public int i() {
        return this.c;
    }

    public long j() {
        return this.b;
    }

    public boolean k() {
        return this.j;
    }

    public void l(String str) {
        this.f888i = str;
    }

    public void m(int i2) {
        this.f886g = i2;
    }

    public void n(boolean z) {
        this.j = z;
    }

    public void o(short s) {
        this.a = s;
    }

    public void p(int i2) {
        this.f883d = i2;
    }

    public void q(int i2) {
        this.f884e = i2;
    }

    public void r(ArrayList<e.c.a.g.a.g.k.c.a> arrayList) {
        this.l = arrayList;
    }

    public void s(int i2) {
        this.c = i2;
    }

    public void t(long j) {
        this.b = j;
    }

    public String toString() {
        return "CloudMusicListFileData{mCMD=" + ((int) this.a) + ", mUserID=" + this.b + ", mListID=" + this.c + ", mListFMVersion=" + this.f883d + ", mListFileCount=" + this.f884e + ", mGnbWatchSrcCount=" + this.f885f + ", mGnbWatchRemoveCount=" + this.f886g + ", mCount=" + this.f887h + ", errorCode='" + this.f888i + "', isSucceed=" + this.j + ", mListFiles=" + this.l + '}';
    }
}
