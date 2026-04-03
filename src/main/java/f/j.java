package f;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class j<T> implements Serializable {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }
    }

    public static final class b implements Serializable {
        public final Throwable a;

        public b(Throwable th) {
            f.z.d.j.e(th, "exception");
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && f.z.d.j.a(this.a, ((b) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.a + ')';
        }
    }

    public static Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).a;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
