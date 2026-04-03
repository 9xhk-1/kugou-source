package f.w.i;

import f.k;
import f.s;
import f.w.g;
import f.w.j.a.h;
import f.w.j.a.j;
import f.z.c.l;
import f.z.c.p;
import f.z.d.v;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public static final class a extends j {
        public int a;
        public final /* synthetic */ f.w.d b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f1542d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f.w.d dVar, f.w.d dVar2, l lVar) {
            super(dVar2);
            this.b = dVar;
            this.f1542d = lVar;
        }

        @Override // f.w.j.a.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.a = 2;
                k.b(obj);
                return obj;
            }
            this.a = 1;
            k.b(obj);
            l lVar = this.f1542d;
            Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            v.a(lVar, 1);
            return lVar.invoke(this);
        }
    }

    /* JADX INFO: renamed from: f.w.i.b$b, reason: collision with other inner class name */
    public static final class C0269b extends f.w.j.a.d {
        public int a;
        public final /* synthetic */ f.w.d b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f1543d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ l f1544f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0269b(f.w.d dVar, g gVar, f.w.d dVar2, g gVar2, l lVar) {
            super(dVar2, gVar2);
            this.b = dVar;
            this.f1543d = gVar;
            this.f1544f = lVar;
        }

        @Override // f.w.j.a.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.a = 2;
                k.b(obj);
                return obj;
            }
            this.a = 1;
            k.b(obj);
            l lVar = this.f1544f;
            Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            v.a(lVar, 1);
            return lVar.invoke(this);
        }
    }

    public static final class c extends j {
        public int a;
        public final /* synthetic */ f.w.d b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f1545d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Object f1546f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f.w.d dVar, f.w.d dVar2, p pVar, Object obj) {
            super(dVar2);
            this.b = dVar;
            this.f1545d = pVar;
            this.f1546f = obj;
        }

        @Override // f.w.j.a.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.a = 2;
                k.b(obj);
                return obj;
            }
            this.a = 1;
            k.b(obj);
            p pVar = this.f1545d;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            v.a(pVar, 2);
            return pVar.invoke(this.f1546f, this);
        }
    }

    public static final class d extends f.w.j.a.d {
        public int a;
        public final /* synthetic */ f.w.d b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f1547d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ p f1548f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Object f1549h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f.w.d dVar, g gVar, f.w.d dVar2, g gVar2, p pVar, Object obj) {
            super(dVar2, gVar2);
            this.b = dVar;
            this.f1547d = gVar;
            this.f1548f = pVar;
            this.f1549h = obj;
        }

        @Override // f.w.j.a.a
        public Object invokeSuspend(Object obj) throws Throwable {
            int i2 = this.a;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.a = 2;
                k.b(obj);
                return obj;
            }
            this.a = 1;
            k.b(obj);
            p pVar = this.f1548f;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            v.a(pVar, 2);
            return pVar.invoke(this.f1549h, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> f.w.d<s> a(l<? super f.w.d<? super T>, ? extends Object> lVar, f.w.d<? super T> dVar) {
        f.z.d.j.e(lVar, "$this$createCoroutineUnintercepted");
        f.z.d.j.e(dVar, "completion");
        h.a(dVar);
        if (lVar instanceof f.w.j.a.a) {
            return ((f.w.j.a.a) lVar).create(dVar);
        }
        g context = dVar.getContext();
        if (context == f.w.h.a) {
            Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            return new a(dVar, dVar, lVar);
        }
        Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        return new C0269b(dVar, context, dVar, context, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> f.w.d<s> b(p<? super R, ? super f.w.d<? super T>, ? extends Object> pVar, R r, f.w.d<? super T> dVar) {
        f.z.d.j.e(pVar, "$this$createCoroutineUnintercepted");
        f.z.d.j.e(dVar, "completion");
        h.a(dVar);
        if (pVar instanceof f.w.j.a.a) {
            return ((f.w.j.a.a) pVar).create(r, dVar);
        }
        g context = dVar.getContext();
        if (context == f.w.h.a) {
            Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            return new c(dVar, dVar, pVar, r);
        }
        Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        return new d(dVar, context, dVar, context, pVar, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> f.w.d<T> c(f.w.d<? super T> dVar) {
        f.w.d<T> dVar2;
        f.z.d.j.e(dVar, "$this$intercepted");
        f.w.j.a.d dVar3 = (f.w.j.a.d) (!(dVar instanceof f.w.j.a.d) ? null : dVar);
        return (dVar3 == null || (dVar2 = (f.w.d<T>) dVar3.intercepted()) == null) ? dVar : dVar2;
    }
}
