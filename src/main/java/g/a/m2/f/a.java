package g.a.m2.f;

import f.s;
import f.w.d;
import f.w.g;
import f.z.c.p;
import f.z.d.j;
import f.z.d.k;
import g.a.m1;
import g.a.n2.n;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements g.a.m2.b<T> {
    public final int a;
    public g b;
    public final g.a.m2.b<T> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f1606d;

    /* JADX INFO: renamed from: g.a.m2.f.a$a, reason: collision with other inner class name */
    public static final class C0274a extends k implements p<Integer, g.b, Integer> {
        public C0274a() {
            super(2);
        }

        public final int a(int i2, g.b bVar) {
            j.f(bVar, "element");
            g.c<?> key = bVar.getKey();
            g.b bVar2 = a.this.f1606d.get(key);
            if (key != m1.f1605g) {
                if (bVar != bVar2) {
                    return Integer.MIN_VALUE;
                }
                return i2 + 1;
            }
            m1 m1Var = (m1) bVar2;
            m1 m1VarD = a.this.d((m1) bVar, m1Var);
            if (m1VarD == m1Var) {
                return m1Var == null ? i2 : i2 + 1;
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + m1VarD + ", expected child of " + m1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return Integer.valueOf(a(num.intValue(), bVar));
        }
    }

    public static final class b extends k implements p<Integer, g.b, Integer> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        public final int a(int i2, g.b bVar) {
            j.f(bVar, "<anonymous parameter 1>");
            return i2 + 1;
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return Integer.valueOf(a(num.intValue(), bVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(g.a.m2.b<? super T> bVar, g gVar) {
        j.f(bVar, "collector");
        j.f(gVar, "collectContext");
        this.c = bVar;
        this.f1606d = gVar;
        this.a = ((Number) gVar.fold(0, b.a)).intValue();
    }

    public final void c(g gVar) {
        if (((Number) gVar.fold(0, new C0274a())).intValue() == this.a) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + this.f1606d + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public final m1 d(m1 m1Var, m1 m1Var2) {
        while (m1Var != null) {
            if (m1Var == m1Var2 || !(m1Var instanceof n)) {
                return m1Var;
            }
            m1Var = ((n) m1Var).g0();
        }
        return null;
    }

    @Override // g.a.m2.b
    public Object emit(T t, d<? super s> dVar) {
        g context = dVar.getContext();
        if (this.b != context) {
            c(context);
            this.b = context;
        }
        return this.c.emit(t, dVar);
    }
}
