package e.b.a;

/* JADX INFO: loaded from: classes.dex */
public final class n extends t {
    public n() {
        h();
    }

    public int f() {
        m mVar = this.k;
        if (mVar == null) {
            return -2;
        }
        return mVar.c();
    }

    public int g(int i2) {
        m mVar = this.k;
        if (mVar == null) {
            return -2;
        }
        return mVar.b(i2);
    }

    public int h() {
        return i(15);
    }

    public int i(int i2) {
        return j(i2, false);
    }

    public int j(int i2, boolean z) {
        m mVar = new m(this);
        this.k = mVar;
        if (z) {
            i2 = -i2;
        }
        return mVar.d(i2);
    }
}
