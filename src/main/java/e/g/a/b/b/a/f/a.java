package e.g.a.b.b.a.f;

import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public final int a;
    public final String b;
    public final byte[] c;

    public a(int i2, String str, byte[] bArr) {
        j.e(str, "callbackId");
        j.e(bArr, "params");
        this.a = i2;
        this.b = str;
        this.c = bArr;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public final byte[] c() {
        return this.c;
    }

    public String toString() {
        return "Command( methodType = " + this.a + ", callbackId = " + this.b + ", params = " + this.c + ')';
    }
}
