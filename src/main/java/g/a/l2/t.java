package g.a.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class t<T> {
    public static final b b = new b(null);
    public final Object a;

    public static final class a {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && f.z.d.j.a(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(f.z.d.g gVar) {
            this();
        }
    }

    public /* synthetic */ t(Object obj) {
        this.a = obj;
    }

    public static final /* synthetic */ t a(Object obj) {
        return new t(obj);
    }

    public static Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof t) && f.z.d.j.a(obj, ((t) obj2).f());
    }

    public static int d(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String e(Object obj) {
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ Object f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    public String toString() {
        return e(this.a);
    }
}
