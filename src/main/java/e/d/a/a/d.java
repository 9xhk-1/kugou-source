package e.d.a.a;

/* JADX INFO: loaded from: classes2.dex */
public final class d<A, B> {
    public final A a;
    public final B b;

    public d(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public static <A, B> d<A, B> b(A a, B b) {
        return new d<>(a, b);
    }

    public A a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        A a = this.a;
        if (a == null) {
            if (dVar.a != null) {
                return false;
            }
        } else if (!a.equals(dVar.a)) {
            return false;
        }
        B b = this.b;
        if (b == null) {
            if (dVar.b != null) {
                return false;
            }
        } else if (!b.equals(dVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a = this.a;
        int iHashCode = ((a == null ? 0 : a.hashCode()) + 31) * 31;
        B b = this.b;
        return iHashCode + (b != null ? b.hashCode() : 0);
    }
}
