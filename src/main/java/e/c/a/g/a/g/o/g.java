package e.c.a.g.a.g.o;

import com.kugou.common.network.RequestDelay;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a implements Serializable {
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1010d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1011f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1013i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public int o;
    public boolean p;
    public long r;
    public String t;
    public RequestDelay u;
    public ArrayList<h> q = new ArrayList<>(0);
    public boolean s = false;

    public int e() {
        return this.o;
    }

    public ArrayList<h> f() {
        return this.q;
    }

    public boolean g() {
        return this.p;
    }

    public void h(String str) {
        this.n = str;
    }

    public void i(RequestDelay requestDelay) {
        this.u = requestDelay;
    }

    public void j(boolean z) {
        this.p = z;
    }

    public void k(int i2) {
        this.o = i2;
    }

    public void l(String str) {
        this.l = str;
    }

    public void m(String str) {
        this.m = str;
    }

    public void n(long j) {
        this.r = j;
    }

    public void o(ArrayList<h> arrayList) {
        this.q = arrayList;
    }

    public void p(boolean z) {
        this.f1013i = z;
    }

    public void q(int i2) {
        this.b = i2;
    }

    public String toString() {
        return "SearchSongResponse{totalCount=" + this.b + ", isTag=" + this.f1010d + ", isTagRes=" + this.f1011f + ", correction=" + this.f1012h + ", isShareResult=" + this.f1013i + ", correctionTip='" + this.j + "', tab='" + this.k + "', errorInfo='" + this.l + "', failReason='" + this.m + "', allowerr='" + this.n + "', errorCode=" + this.o + ", isEnd=" + this.p + ", searchVersionSongInfo=" + this.q + ", searchTime=" + this.r + ", isNoNeedToLoadMoreData=" + this.s + ", retryDomainStates='" + this.t + "', mDelay=" + this.u + '}';
    }
}
