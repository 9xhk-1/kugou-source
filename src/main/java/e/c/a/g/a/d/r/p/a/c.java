package e.c.a.g.a.d.r.p.a;

import android.text.TextUtils;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public List<c> A;
    public int B;
    public String C;
    public String D;
    public int a;
    public int b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f517i;
    public int j;
    public d k;
    public int l;
    public int m;
    public long n;
    public int o;
    public String q;
    public int t;
    public MusicTransParamEnenty u;
    public HashOffset v;
    public boolean w;
    public int p = -1;
    public boolean r = false;
    public boolean s = true;
    public int x = 0;
    public int y = 0;
    public int z = -1;

    public static c a(int i2) {
        c cVar = new c();
        cVar.s0(0);
        cVar.S(0);
        cVar.k0(i2);
        cVar.l0(1);
        cVar.h0(0);
        cVar.Z(new d());
        cVar.T(true);
        cVar.m0(false);
        return cVar;
    }

    public static c b(boolean z) {
        c cVar = new c();
        cVar.s0(1);
        cVar.S(1);
        cVar.l0(1);
        cVar.k0(0);
        cVar.h0(0);
        cVar.Z(new d());
        cVar.T(true);
        cVar.m0(z);
        cVar.a0(SongQuality.QUALITY_HIGHEST.getType());
        return cVar;
    }

    public static c c(boolean z) {
        c cVarB = b(z);
        c cVarB2 = b(z);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVarB2);
        if (g0.a) {
            g0.e("zzm-log", "设置为标准音质--");
        }
        cVarB.p0(arrayList);
        return cVarB;
    }

    public List<c> A() {
        return this.A;
    }

    public String B() {
        return this.q;
    }

    public int C() {
        return this.a;
    }

    public String D() {
        return this.c;
    }

    public boolean E() {
        return this.r;
    }

    public boolean F() {
        return this.w;
    }

    public boolean G() {
        return this.s;
    }

    public void H(int i2) {
    }

    public void I(String str) {
        this.C = str;
    }

    public void J(String str) {
    }

    public void K(String str) {
    }

    public void L(String str) {
        this.D = str;
    }

    public void M(int i2) {
    }

    public void N(int i2) {
    }

    public void O(int i2) {
        this.o = i2;
    }

    public void P(int i2) {
        this.t = i2;
    }

    public void Q(int i2) {
    }

    public void R(int i2) {
        this.f516h = i2;
    }

    public void S(int i2) {
        this.b = i2;
    }

    public void T(boolean z) {
        this.r = z;
    }

    public void U(String str) {
        this.f513e = str;
    }

    public void V(HashOffset hashOffset) {
        this.v = hashOffset;
    }

    public void W(boolean z) {
        this.w = z;
    }

    public void X(int i2) {
        this.f512d = i2;
    }

    public void Y(int i2) {
        this.z = i2;
    }

    public void Z(d dVar) {
        this.k = dVar;
    }

    public void a0(int i2) {
        this.f515g = i2;
    }

    public void b0(long j) {
        if (j > 0) {
            this.n = j;
        }
    }

    public void c0(MusicTransParamEnenty musicTransParamEnenty) {
        this.u = musicTransParamEnenty;
    }

    public String d() {
        int i2;
        return ((TextUtils.isEmpty(this.C) || "0".equals(this.C)) && (i2 = this.y) > 0) ? String.valueOf(i2) : this.C;
    }

    public void d0(String str) {
        this.f514f = str;
    }

    public String e() {
        return this.D;
    }

    public void e0(int i2) {
        this.p = i2;
    }

    public int f() {
        int iY;
        List<c> list = this.A;
        if (list == null || list.size() == 0) {
            return this.j;
        }
        int i2 = 0;
        List<c> list2 = this.A;
        if (list2 != null) {
            for (c cVar : list2) {
                if (cVar.p() == 2) {
                    iY = cVar.y();
                } else if (cVar.p() == 4) {
                    iY = cVar.y() << 4;
                } else if (cVar.p() == 5) {
                    iY = cVar.y() << 8;
                }
                i2 |= iY;
            }
        }
        return i2;
    }

    public void f0(int i2) {
    }

    public int g() {
        return this.o;
    }

    public void g0(int i2) {
        this.x = i2;
    }

    public int h() {
        return this.t;
    }

    public void h0(int i2) {
        this.m = i2;
    }

    public int i() {
        return this.f516h;
    }

    public void i0(int i2) {
        this.B = i2;
    }

    public int j() {
        return this.b;
    }

    public void j0(int i2) {
        this.l = i2;
    }

    public String k() {
        return this.f513e;
    }

    public void k0(int i2) {
        this.j = i2;
    }

    public HashOffset l() {
        return this.v;
    }

    public void l0(int i2) {
        this.f517i = i2;
    }

    public int m() {
        return this.f512d;
    }

    public void m0(boolean z) {
        this.s = z;
    }

    public int n() {
        return this.z;
    }

    public void n0(int i2) {
    }

    public d o() {
        return this.k;
    }

    public void o0(int i2) {
        this.y = i2;
    }

    public int p() {
        return this.f515g;
    }

    public void p0(List<c> list) {
        this.A = list;
    }

    public long q() {
        return this.n;
    }

    public void q0(String str) {
        this.q = str;
    }

    public MusicTransParamEnenty r() {
        return this.u;
    }

    public void r0(String str) {
    }

    public String s() {
        return this.f514f;
    }

    public void s0(int i2) {
        this.a = i2;
    }

    public int t() {
        return this.p;
    }

    public void t0(String str) {
        this.c = str;
    }

    public int u() {
        return this.x;
    }

    public void u0(long j) {
    }

    public int v() {
        return this.m;
    }

    public int w() {
        return this.B;
    }

    public int x() {
        return this.l;
    }

    public int y() {
        return this.j;
    }

    public int z() {
        return this.f517i;
    }
}
