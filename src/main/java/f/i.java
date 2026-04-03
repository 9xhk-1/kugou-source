package f;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class i<A, B> implements Serializable {
    public final A a;
    public final B b;

    public i(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public final A a() {
        return this.a;
    }

    public final B b() {
        return this.b;
    }

    public final A c() {
        return this.a;
    }

    public final B d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return f.z.d.j.a(this.a, iVar.a) && f.z.d.j.a(this.b, iVar.b);
    }

    public int hashCode() {
        A a = this.a;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.b;
        return iHashCode + (b != null ? b.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.a + ", " + this.b + ')';
    }
}
