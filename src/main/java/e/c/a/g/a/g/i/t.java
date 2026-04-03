package e.c.a.g.a.g.i;

import com.kugou.common.network.RequestDelay;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public short a;
    public long b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f905f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f907h;
    public RequestDelay j;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f906g = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<a> f908i = null;

    public class a {
        public int a;
        public int b;

        public a(t tVar, int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        public String toString() {
            return "ListVersion{mListID=" + this.a + ", mListFMVersion=" + this.b + '}';
        }
    }

    public boolean a(int i2, int i3) {
        if (this.f908i == null) {
            this.f908i = new ArrayList(1);
        }
        this.f908i.add(new a(this, i2, i3));
        return true;
    }

    public int b() {
        return this.f905f;
    }

    public short c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public void e(RequestDelay requestDelay) {
        this.j = requestDelay;
    }

    public void f(int i2) {
        this.f905f = i2;
    }

    public void g(int i2) {
        this.f904e = i2;
    }

    public void h(String str) {
        this.f907h = str;
    }

    public void i(short s) {
        this.a = s;
    }

    public void j(int i2) {
        this.f903d = i2;
    }

    public void k(int i2) {
        this.c = i2;
    }

    public void l(long j) {
        this.b = j;
    }

    public String toString() {
        return "CloudMusicVersionData{mCMD=" + ((int) this.a) + ", mUserId=" + this.b + ", mLMVersion=" + this.c + ", mLMCount=" + this.f903d + ", httpStatusCode=" + this.f904e + ", errorCode=" + this.f905f + ", netErrorCode='" + this.f906g + "', url='" + this.f907h + "', mListVersion=" + this.f908i + ", mDelay=" + this.j + '}';
    }
}
