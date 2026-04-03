package f;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class n<A, B, C> implements Serializable {
    public final A a;
    public final B b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C f1525d;

    public n(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.f1525d = c;
    }

    public final A a() {
        return this.a;
    }

    public final B b() {
        return this.b;
    }

    public final C c() {
        return this.f1525d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return f.z.d.j.a(this.a, nVar.a) && f.z.d.j.a(this.b, nVar.b) && f.z.d.j.a(this.f1525d, nVar.f1525d);
    }

    public int hashCode() {
        A a = this.a;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.b;
        int iHashCode2 = (iHashCode + (b != null ? b.hashCode() : 0)) * 31;
        C c = this.f1525d;
        return iHashCode2 + (c != null ? c.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ", " + this.f1525d + ')';
    }
}
