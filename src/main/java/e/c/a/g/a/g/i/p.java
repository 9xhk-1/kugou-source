package e.c.a.g.a.g.i;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    public short a;
    public long b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<o> f882f;

    public p() {
        this.f882f = null;
        this.f882f = new ArrayList<>();
    }

    public boolean a(o oVar) {
        if (this.f882f.size() > 0) {
            int size = this.f882f.size() - 1;
            int i2 = size;
            while (true) {
                if (i2 < 0) {
                    i2 = -1;
                    break;
                }
                if (this.f882f.get(i2).k() <= oVar.k()) {
                    break;
                }
                i2--;
            }
            if (size == i2) {
                this.f882f.add(oVar);
            } else if (i2 != -1) {
                this.f882f.add(i2 + 1, oVar);
            } else {
                this.f882f.add(1, oVar);
            }
        } else {
            this.f882f.add(oVar);
        }
        return true;
    }

    public int b() {
        return this.f881e;
    }

    public long c() {
        return this.b;
    }

    public short d() {
        return this.a;
    }

    public int e() {
        return this.f880d;
    }

    public ArrayList<o> f() {
        return this.f882f;
    }

    public void g(int i2) {
        this.f881e = i2;
    }

    public void h(short s) {
        this.a = s;
    }

    public void i(int i2) {
        this.f880d = i2;
    }

    public void j(int i2) {
        this.c = i2;
    }

    public void k(long j) {
        this.b = j;
    }

    public String toString() {
        return "CloudMusicLMListData{mCMD=" + ((int) this.a) + ", mUserId=" + this.b + ", mLMVersion=" + this.c + ", mCount=" + this.f880d + ", mErrorCode=" + this.f881e + ", mLMLists=" + this.f882f + '}';
    }
}
