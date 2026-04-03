package e.b.a;

/* JADX INFO: loaded from: classes.dex */
public final class f extends t {
    public boolean n;

    public f(int i2, boolean z) throws h {
        this(i2, 15, z);
    }

    public int f(int i2) {
        e eVar = this.j;
        if (eVar == null) {
            return -2;
        }
        int iJ = eVar.j(i2);
        if (iJ == 1) {
            this.n = true;
        }
        return iJ;
    }

    public int g() {
        this.n = true;
        e eVar = this.j;
        if (eVar == null) {
            return -2;
        }
        int iK = eVar.k();
        this.j = null;
        b();
        return iK;
    }

    public boolean h() {
        return this.n;
    }

    public int i(int i2, int i3, boolean z) {
        this.n = false;
        e eVar = new e(this);
        this.j = eVar;
        if (z) {
            i3 = -i3;
        }
        return eVar.l(i2, i3);
    }

    public f(int i2, int i3, boolean z) throws h {
        this.n = false;
        int i4 = i(i2, i3, z);
        if (i4 == 0) {
            return;
        }
        throw new h(String.valueOf(i4) + ": " + this.f359i);
    }
}
