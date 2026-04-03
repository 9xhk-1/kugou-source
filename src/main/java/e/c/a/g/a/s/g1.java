package e.c.a.g.a.s;

import e.c.a.g.a.s.c0;
import e.c.a.g.a.s.g1.b;

/* JADX INFO: loaded from: classes2.dex */
public class g1<S extends b> {
    public final c0<S> a;
    public c<S> b;
    public S c;

    public class a implements c0.b<S> {
        public a() {
        }

        @Override // e.c.a.g.a.s.c0.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onInit(S s) {
            s.f(g1.this);
            s.c();
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public static class b {
        public g1 a;
        public Class<? extends b> b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Class<? extends b> f1202d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1203f;

        public boolean a() {
            return this.f1203f;
        }

        public <E extends b> E b(Class<E> cls) {
            return (E) this.a.b(cls);
        }

        public void c() {
        }

        public void d(Object obj) {
        }

        public void e() {
        }

        public void f(g1<? extends b> g1Var) {
            this.a = g1Var;
        }
    }

    public interface c<T> {
        void onStateChanged(T t, T t2);
    }

    public g1(c0.a<S> aVar) {
        c0<S> c0Var = new c0<>();
        this.a = c0Var;
        c0Var.d(aVar);
        c0Var.e(new a());
    }

    public S a() {
        return this.c;
    }

    /* JADX WARN: Incorrect return type in method signature: <E:TS;>(Ljava/lang/Class<TE;>;)TE; */
    public b b(Class cls) {
        return c(cls, null);
    }

    /* JADX WARN: Incorrect return type in method signature: <E:TS;>(Ljava/lang/Class<TE;>;Ljava/lang/Object;)TE; */
    public b c(Class cls, Object obj) {
        S s = this.c;
        if (s == null) {
            throw new IllegalStateException("Please start the state using method StateCtrl#start() before move state");
        }
        s.f1203f = false;
        s.f1202d = cls;
        s.e();
        Class cls2 = this.c.getClass();
        S s2 = this.c;
        S s3 = (S) this.a.c(cls);
        this.c = s3;
        s3.f1203f = true;
        s3.b = cls2;
        s3.f1202d = null;
        s3.d(obj);
        c<S> cVar = this.b;
        if (cVar != null) {
            cVar.onStateChanged(s2, this.c);
        }
        return this.c;
    }

    public void d() {
        S s = this.c;
        if (s != null) {
            s.f1203f = false;
            s.b = null;
            s.e();
            c<S> cVar = this.b;
            if (cVar != null) {
                cVar.onStateChanged(this.c, null);
            }
            this.c = null;
        }
    }

    public void e(c<S> cVar) {
        this.b = cVar;
    }

    public <E extends S> void f(Class<E> cls) {
        g(cls, null);
    }

    public <E extends S> void g(Class<E> cls, Object obj) {
        if (this.c != null) {
            throw new IllegalStateException("Cant't start the state after is had working");
        }
        S s = (S) this.a.c(cls);
        this.c = s;
        s.f1203f = true;
        s.d(obj);
        c<S> cVar = this.b;
        if (cVar != null) {
            cVar.onStateChanged(null, this.c);
        }
    }
}
