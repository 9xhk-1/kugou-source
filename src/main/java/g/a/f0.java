package g.a;

import f.w.g;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 extends f.w.a {
    public static final a b = new a(null);
    public final String a;

    public static final class a implements g.c<f0> {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof f0) && f.z.d.j.a(this.a, ((f0) obj).a);
        }
        return true;
    }

    public final String getName() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "CoroutineName(" + this.a + ')';
    }
}
