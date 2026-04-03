package f.w;

import f.w.g;
import f.z.c.p;
import f.z.d.j;
import f.z.d.k;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements g, Serializable {
    public final g a;
    public final g.b b;

    public static final class a extends k implements p<String, g.b, String> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // f.z.c.p
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, g.b bVar) {
            j.e(str, "acc");
            j.e(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public c(g gVar, g.b bVar) {
        j.e(gVar, "left");
        j.e(bVar, "element");
        this.a = gVar;
        this.b = bVar;
    }

    public final boolean a(g.b bVar) {
        return j.a(get(bVar.getKey()), bVar);
    }

    public final boolean b(c cVar) {
        while (a(cVar.b)) {
            g gVar = cVar.a;
            if (!(gVar instanceof c)) {
                Objects.requireNonNull(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    public final int c() {
        int i2 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.a;
            if (!(gVar instanceof c)) {
                gVar = null;
            }
            cVar = (c) gVar;
            if (cVar == null) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.c() != c() || !cVar.b(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // f.w.g
    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar) {
        j.e(pVar, "operation");
        return pVar.invoke((Object) this.a.fold(r, pVar), this.b);
    }

    @Override // f.w.g
    public <E extends g.b> E get(g.c<E> cVar) {
        j.e(cVar, "key");
        c cVar2 = this;
        while (true) {
            E e2 = (E) cVar2.b.get(cVar);
            if (e2 != null) {
                return e2;
            }
            g gVar = cVar2.a;
            if (!(gVar instanceof c)) {
                return (E) gVar.get(cVar);
            }
            cVar2 = (c) gVar;
        }
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.hashCode();
    }

    @Override // f.w.g
    public g minusKey(g.c<?> cVar) {
        j.e(cVar, "key");
        if (this.b.get(cVar) != null) {
            return this.a;
        }
        g gVarMinusKey = this.a.minusKey(cVar);
        return gVarMinusKey == this.a ? this : gVarMinusKey == h.a ? this.b : new c(gVarMinusKey, this.b);
    }

    @Override // f.w.g
    public g plus(g gVar) {
        j.e(gVar, "context");
        return g.a.a(this, gVar);
    }

    public String toString() {
        return "[" + ((String) fold("", a.a)) + "]";
    }
}
