package g.a.l2;

import f.j;
import g.a.j;
import g.a.k0;
import g.a.l0;
import g.a.l2.f;
import g.a.l2.t;
import g.a.n2.i;
import g.a.t0;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<E> extends g.a.l2.c<E> implements g.a.l2.e<E> {

    /* JADX INFO: renamed from: g.a.l2.a$a, reason: collision with other inner class name */
    public static final class C0271a<E> {
        public final Object a;
        public final E b;

        public C0271a(Object obj, E e2) {
            f.z.d.j.f(obj, "token");
            this.a = obj;
            this.b = e2;
        }
    }

    public static final class b<E> implements g.a.l2.f<E> {
        public Object a;
        public final a<E> b;

        public b(a<E> aVar) {
            f.z.d.j.f(aVar, "channel");
            this.b = aVar;
            this.a = g.a.l2.b.c;
        }

        public final a<E> a() {
            return this.b;
        }

        public final boolean b(Object obj) throws Throwable {
            if (!(obj instanceof g.a.l2.h)) {
                return true;
            }
            g.a.l2.h hVar = (g.a.l2.h) obj;
            if (hVar.f1601f == null) {
                return false;
            }
            throw g.a.n2.p.j(hVar.y());
        }

        public final /* synthetic */ Object c(f.w.d<? super Boolean> dVar) {
            g.a.k kVar = new g.a.k(f.w.i.b.c(dVar), 0);
            d dVar2 = new d(this, kVar);
            while (true) {
                if (a().J(dVar2)) {
                    a().Y(kVar, dVar2);
                    break;
                }
                Object objQ = a().Q();
                d(objQ);
                if (objQ instanceof g.a.l2.h) {
                    g.a.l2.h hVar = (g.a.l2.h) objQ;
                    if (hVar.f1601f == null) {
                        Boolean boolA = f.w.j.a.b.a(false);
                        j.a aVar = f.j.a;
                        f.j.a(boolA);
                        kVar.resumeWith(boolA);
                    } else {
                        Throwable thY = hVar.y();
                        j.a aVar2 = f.j.a;
                        Object objA = f.k.a(thY);
                        f.j.a(objA);
                        kVar.resumeWith(objA);
                    }
                } else if (objQ != g.a.l2.b.c) {
                    Boolean boolA2 = f.w.j.a.b.a(true);
                    j.a aVar3 = f.j.a;
                    f.j.a(boolA2);
                    kVar.resumeWith(boolA2);
                    break;
                }
            }
            Object objL = kVar.l();
            if (objL == f.w.i.c.d()) {
                f.w.j.a.h.c(dVar);
            }
            return objL;
        }

        public final void d(Object obj) {
            this.a = obj;
        }

        @Override // g.a.l2.f
        public Object hasNext(f.w.d<? super Boolean> dVar) {
            Object obj = this.a;
            Object obj2 = g.a.l2.b.c;
            if (obj != obj2) {
                return f.w.j.a.b.a(b(obj));
            }
            Object objQ = this.b.Q();
            this.a = objQ;
            return objQ != obj2 ? f.w.j.a.b.a(b(objQ)) : c(dVar);
        }

        @Override // g.a.l2.f
        public /* synthetic */ Object next(f.w.d<? super E> dVar) {
            return f.a.a(this, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.a.l2.f
        public E next() throws Throwable {
            E e2 = (E) this.a;
            if (e2 instanceof g.a.l2.h) {
                throw g.a.n2.p.j(((g.a.l2.h) e2).y());
            }
            Object obj = g.a.l2.b.c;
            if (e2 == obj) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.a = obj;
            return e2;
        }
    }

    public static final class c<E> extends m<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final g.a.j<Object> f1576f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f1577h;

        public c(g.a.j<Object> jVar, int i2) {
            f.z.d.j.f(jVar, "cont");
            this.f1576f = jVar;
            this.f1577h = i2;
        }

        @Override // g.a.l2.o
        public void completeResumeReceive(Object obj) {
            f.z.d.j.f(obj, "token");
            this.f1576f.completeResume(obj);
        }

        @Override // g.a.l2.m
        public void s(g.a.l2.h<?> hVar) {
            f.z.d.j.f(hVar, "closed");
            int i2 = this.f1577h;
            if (i2 == 1 && hVar.f1601f == null) {
                g.a.j<Object> jVar = this.f1576f;
                j.a aVar = f.j.a;
                f.j.a(null);
                jVar.resumeWith(null);
                return;
            }
            if (i2 != 2) {
                g.a.j<Object> jVar2 = this.f1576f;
                Throwable thY = hVar.y();
                j.a aVar2 = f.j.a;
                Object objA = f.k.a(thY);
                f.j.a(objA);
                jVar2.resumeWith(objA);
                return;
            }
            g.a.j<Object> jVar3 = this.f1576f;
            t.b bVar = t.b;
            t.a aVar3 = new t.a(hVar.f1601f);
            t.b(aVar3);
            t tVarA = t.a(aVar3);
            j.a aVar4 = f.j.a;
            f.j.a(tVarA);
            jVar3.resumeWith(tVarA);
        }

        public final Object t(E e2) {
            if (this.f1577h != 2) {
                return e2;
            }
            t.b bVar = t.b;
            t.b(e2);
            return t.a(e2);
        }

        @Override // g.a.n2.i
        public String toString() {
            return "ReceiveElement[receiveMode=" + this.f1577h + ']';
        }

        @Override // g.a.l2.o
        public Object tryResumeReceive(E e2, Object obj) {
            return this.f1576f.tryResume(t(e2), obj);
        }
    }

    public static final class d<E> extends m<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final b<E> f1578f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final g.a.j<Boolean> f1579h;

        /* JADX WARN: Multi-variable type inference failed */
        public d(b<E> bVar, g.a.j<? super Boolean> jVar) {
            f.z.d.j.f(bVar, "iterator");
            f.z.d.j.f(jVar, "cont");
            this.f1578f = bVar;
            this.f1579h = jVar;
        }

        @Override // g.a.l2.o
        public void completeResumeReceive(Object obj) {
            f.z.d.j.f(obj, "token");
            if (!(obj instanceof C0271a)) {
                this.f1579h.completeResume(obj);
                return;
            }
            C0271a c0271a = (C0271a) obj;
            this.f1578f.d(c0271a.b);
            this.f1579h.completeResume(c0271a.a);
        }

        @Override // g.a.l2.m
        public void s(g.a.l2.h<?> hVar) {
            f.z.d.j.f(hVar, "closed");
            Object objA = hVar.f1601f == null ? j.a.a(this.f1579h, Boolean.FALSE, null, 2, null) : this.f1579h.tryResumeWithException(g.a.n2.p.k(hVar.y(), this.f1579h));
            if (objA != null) {
                this.f1578f.d(hVar);
                this.f1579h.completeResume(objA);
            }
        }

        @Override // g.a.n2.i
        public String toString() {
            return "ReceiveHasNext";
        }

        @Override // g.a.l2.o
        public Object tryResumeReceive(E e2, Object obj) {
            Object objTryResume = this.f1579h.tryResume(Boolean.TRUE, obj);
            if (objTryResume != null) {
                if (obj != null) {
                    return new C0271a(objTryResume, e2);
                }
                this.f1578f.d(e2);
            }
            return objTryResume;
        }
    }

    public static final class e<R, E> extends m<E> implements t0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a<E> f1580f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final g.a.q2.d<R> f1581h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final f.z.c.p<Object, f.w.d<? super R>, Object> f1582i;
        public final int j;

        /* JADX WARN: Multi-variable type inference failed */
        public e(a<E> aVar, g.a.q2.d<? super R> dVar, f.z.c.p<Object, ? super f.w.d<? super R>, ? extends Object> pVar, int i2) {
            f.z.d.j.f(aVar, "channel");
            f.z.d.j.f(dVar, "select");
            f.z.d.j.f(pVar, "block");
            this.f1580f = aVar;
            this.f1581h = dVar;
            this.f1582i = pVar;
            this.j = i2;
        }

        @Override // g.a.l2.o
        public void completeResumeReceive(Object obj) {
            f.z.d.j.f(obj, "token");
            if (obj == g.a.l2.b.f1586f) {
                obj = null;
            }
            f.z.c.p<Object, f.w.d<? super R>, Object> pVar = this.f1582i;
            if (this.j == 2) {
                t.b bVar = t.b;
                t.b(obj);
                obj = t.a(obj);
            }
            f.w.f.a(pVar, obj, this.f1581h.getCompletion());
        }

        @Override // g.a.t0
        public void dispose() {
            if (p()) {
                this.f1580f.O();
            }
        }

        @Override // g.a.l2.m
        public void s(g.a.l2.h<?> hVar) {
            f.z.d.j.f(hVar, "closed");
            if (this.f1581h.trySelect(null)) {
                int i2 = this.j;
                if (i2 == 0) {
                    this.f1581h.resumeSelectCancellableWithException(hVar.y());
                    return;
                }
                if (i2 == 1) {
                    if (hVar.f1601f == null) {
                        f.w.f.a(this.f1582i, null, this.f1581h.getCompletion());
                        return;
                    } else {
                        this.f1581h.resumeSelectCancellableWithException(hVar.y());
                        return;
                    }
                }
                if (i2 != 2) {
                    return;
                }
                f.z.c.p<Object, f.w.d<? super R>, Object> pVar = this.f1582i;
                t.b bVar = t.b;
                t.a aVar = new t.a(hVar.f1601f);
                t.b(aVar);
                f.w.f.a(pVar, t.a(aVar), this.f1581h.getCompletion());
            }
        }

        @Override // g.a.n2.i
        public String toString() {
            return "ReceiveSelect[" + this.f1581h + ",receiveMode=" + this.j + ']';
        }

        @Override // g.a.l2.o
        public Object tryResumeReceive(E e2, Object obj) {
            if (this.f1581h.trySelect(obj)) {
                return e2 != null ? e2 : g.a.l2.b.f1586f;
            }
            return null;
        }
    }

    public final class f extends g.a.h {
        public final m<?> a;
        public final /* synthetic */ a b;

        public f(a aVar, m<?> mVar) {
            f.z.d.j.f(mVar, "receive");
            this.b = aVar;
            this.a = mVar;
        }

        @Override // g.a.i
        public void a(Throwable th) {
            if (this.a.p()) {
                this.b.O();
            }
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
            a(th);
            return f.s.a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.a + ']';
        }
    }

    public static final class g<E> extends i.d<q> {
        public Object a;
        public E b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(g.a.n2.g gVar) {
            super(gVar);
            f.z.d.j.f(gVar, "queue");
        }
    }

    public static final class h extends i.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f1583d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(g.a.n2.i iVar, g.a.n2.i iVar2, a aVar) {
            super(iVar2);
            this.f1583d = aVar;
        }

        @Override // g.a.n2.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object d(g.a.n2.i iVar) {
            f.z.d.j.f(iVar, "affected");
            if (this.f1583d.N()) {
                return null;
            }
            return g.a.n2.h.a();
        }
    }

    public static final class i implements g.a.q2.b<E> {
        public i() {
        }

        @Override // g.a.q2.b
        public <R> void registerSelectClause1(g.a.q2.d<? super R> dVar, f.z.c.p<? super E, ? super f.w.d<? super R>, ? extends Object> pVar) throws Throwable {
            f.z.d.j.f(dVar, "select");
            f.z.d.j.f(pVar, "block");
            a.this.V(dVar, pVar);
        }
    }

    public static final class j implements g.a.q2.b<t<? extends E>> {
        public j() {
        }

        @Override // g.a.q2.b
        public <R> void registerSelectClause1(g.a.q2.d<? super R> dVar, f.z.c.p<? super t<? extends E>, ? super f.w.d<? super R>, ? extends Object> pVar) {
            f.z.d.j.f(dVar, "select");
            f.z.d.j.f(pVar, "block");
            a.this.W(dVar, pVar);
        }
    }

    public static final class k implements g.a.q2.b<E> {
        public k() {
        }

        @Override // g.a.q2.b
        public <R> void registerSelectClause1(g.a.q2.d<? super R> dVar, f.z.c.p<? super E, ? super f.w.d<? super R>, ? extends Object> pVar) throws Throwable {
            f.z.d.j.f(dVar, "select");
            f.z.d.j.f(pVar, "block");
            a.this.X(dVar, pVar);
        }
    }

    @Override // g.a.l2.e, g.a.l2.n
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public boolean cancel(Throwable th) {
        boolean zClose = close(th);
        H();
        return zClose;
    }

    public void H() {
        g.a.l2.h<?> hVarL = l();
        if (hVarL == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        while (true) {
            q qVarA = A();
            if (qVarA == null) {
                throw new IllegalStateException("Cannot happen".toString());
            }
            if (qVarA instanceof g.a.l2.h) {
                if (k0.a()) {
                    if (!(qVarA == hVarL)) {
                        throw new AssertionError();
                    }
                    return;
                }
                return;
            }
            qVarA.u(hVarL);
        }
    }

    public final g<E> I() {
        return new g<>(n());
    }

    public final boolean J(m<? super E> mVar) {
        int iR;
        g.a.n2.i iVar;
        boolean z = false;
        if (M()) {
            g.a.n2.g gVarN = n();
            do {
                Object objJ = gVarN.j();
                if (objJ == null) {
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
                iVar = (g.a.n2.i) objJ;
                if (!(!(iVar instanceof q))) {
                    break;
                }
            } while (!iVar.b(mVar, gVarN));
            z = true;
            break;
        }
        g.a.n2.g gVarN2 = n();
        h hVar = new h(mVar, mVar, this);
        do {
            Object objJ2 = gVarN2.j();
            if (objJ2 == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            g.a.n2.i iVar2 = (g.a.n2.i) objJ2;
            if (!(!(iVar2 instanceof q))) {
                break;
            }
            iR = iVar2.r(mVar, gVarN2, hVar);
            if (iR == 1) {
                z = true;
                break;
            }
        } while (iR != 2);
        if (z) {
            P();
        }
        return z;
    }

    public final <R> boolean K(g.a.q2.d<? super R> dVar, f.z.c.p<Object, ? super f.w.d<? super R>, ? extends Object> pVar, int i2) {
        e eVar = new e(this, dVar, pVar, i2);
        boolean zJ = J(eVar);
        if (zJ) {
            dVar.disposeOnSelect(eVar);
        }
        return zJ;
    }

    public final boolean L() {
        return n().i() instanceof o;
    }

    public abstract boolean M();

    public abstract boolean N();

    public void O() {
    }

    public void P() {
    }

    public Object Q() {
        q qVarA;
        Object objV;
        do {
            qVarA = A();
            if (qVarA == null) {
                return g.a.l2.b.c;
            }
            objV = qVarA.v(null);
        } while (objV == null);
        qVarA.s(objV);
        return qVarA.t();
    }

    public Object R(g.a.q2.d<?> dVar) {
        f.z.d.j.f(dVar, "select");
        g<E> gVarI = I();
        Object objPerformAtomicTrySelect = dVar.performAtomicTrySelect(gVarI);
        if (objPerformAtomicTrySelect != null) {
            return objPerformAtomicTrySelect;
        }
        q qVarB = gVarI.b();
        Object obj = gVarI.a;
        if (obj != null) {
            qVarB.s(obj);
            return gVarI.b;
        }
        f.z.d.j.n();
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final E S(Object obj) throws Throwable {
        if (!(obj instanceof g.a.l2.h)) {
            return obj;
        }
        Throwable th = ((g.a.l2.h) obj).f1601f;
        if (th == null) {
            return null;
        }
        throw g.a.n2.p.j(th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final E T(Object obj) throws Throwable {
        if (obj instanceof g.a.l2.h) {
            throw g.a.n2.p.j(((g.a.l2.h) obj).y());
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <R> Object U(int i2, f.w.d<? super R> dVar) {
        g.a.k kVar = new g.a.k(f.w.i.b.c(dVar), 0);
        c cVar = new c(kVar, i2);
        while (true) {
            if (J(cVar)) {
                Y(kVar, cVar);
                break;
            }
            Object objQ = Q();
            if (objQ instanceof g.a.l2.h) {
                cVar.s((g.a.l2.h) objQ);
                break;
            }
            if (objQ != g.a.l2.b.c) {
                Object objT = cVar.t(objQ);
                j.a aVar = f.j.a;
                f.j.a(objT);
                kVar.resumeWith(objT);
                break;
            }
        }
        Object objL = kVar.l();
        if (objL == f.w.i.c.d()) {
            f.w.j.a.h.c(dVar);
        }
        return objL;
    }

    public final <R> void V(g.a.q2.d<? super R> dVar, f.z.c.p<? super E, ? super f.w.d<? super R>, ? extends Object> pVar) throws Throwable {
        while (!dVar.isSelected()) {
            if (!isEmpty()) {
                Object objR = R(dVar);
                if (objR == g.a.q2.e.a()) {
                    return;
                }
                if (objR != g.a.l2.b.c) {
                    if (objR instanceof g.a.l2.h) {
                        throw g.a.n2.p.j(((g.a.l2.h) objR).y());
                    }
                    g.a.o2.b.c(pVar, objR, dVar.getCompletion());
                    return;
                }
            } else {
                if (pVar == null) {
                    throw new f.p("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
                }
                if (K(dVar, pVar, 0)) {
                    return;
                }
            }
        }
    }

    public final <R> void W(g.a.q2.d<? super R> dVar, f.z.c.p<? super t<? extends E>, ? super f.w.d<? super R>, ? extends Object> pVar) {
        while (!dVar.isSelected()) {
            if (!isEmpty()) {
                Object objR = R(dVar);
                if (objR == g.a.q2.e.a()) {
                    return;
                }
                if (objR == g.a.l2.b.c) {
                    continue;
                } else if (!(objR instanceof g.a.l2.h)) {
                    t.b bVar = t.b;
                    t.b(objR);
                    g.a.o2.b.c(pVar, t.a(objR), dVar.getCompletion());
                    return;
                } else {
                    t.b bVar2 = t.b;
                    t.a aVar = new t.a(((g.a.l2.h) objR).f1601f);
                    t.b(aVar);
                    g.a.o2.b.c(pVar, t.a(aVar), dVar.getCompletion());
                }
            } else {
                if (pVar == null) {
                    throw new f.p("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
                }
                if (K(dVar, pVar, 2)) {
                    return;
                }
            }
        }
    }

    public final <R> void X(g.a.q2.d<? super R> dVar, f.z.c.p<? super E, ? super f.w.d<? super R>, ? extends Object> pVar) throws Throwable {
        while (!dVar.isSelected()) {
            if (!isEmpty()) {
                Object objR = R(dVar);
                if (objR == g.a.q2.e.a()) {
                    return;
                }
                if (objR != g.a.l2.b.c) {
                    if (!(objR instanceof g.a.l2.h)) {
                        g.a.o2.b.c(pVar, objR, dVar.getCompletion());
                        return;
                    }
                    Throwable th = ((g.a.l2.h) objR).f1601f;
                    if (th != null) {
                        throw g.a.n2.p.j(th);
                    }
                    if (dVar.trySelect(null)) {
                        g.a.o2.b.c(pVar, null, dVar.getCompletion());
                        return;
                    }
                    return;
                }
            } else {
                if (pVar == null) {
                    throw new f.p("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
                }
                if (K(dVar, pVar, 1)) {
                    return;
                }
            }
        }
    }

    public final void Y(g.a.j<?> jVar, m<?> mVar) {
        jVar.invokeOnCancellation(new f(this, mVar));
    }

    @Override // g.a.l2.e, g.a.l2.n
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // g.a.l2.e, g.a.l2.n
    public final g.a.q2.b<E> getOnReceive() {
        return new i();
    }

    @Override // g.a.l2.e, g.a.l2.n
    public g.a.q2.b<t<E>> getOnReceiveOrClosed() {
        return new j();
    }

    @Override // g.a.l2.e, g.a.l2.n
    public final g.a.q2.b<E> getOnReceiveOrNull() {
        return new k();
    }

    @Override // g.a.l2.e, g.a.l2.n
    public final boolean isClosedForReceive() {
        return k() != null && N();
    }

    @Override // g.a.l2.e, g.a.l2.n
    public final boolean isEmpty() {
        return !(n().i() instanceof q) && N();
    }

    @Override // g.a.l2.e, g.a.l2.n
    public final g.a.l2.f<E> iterator() {
        return new b(this);
    }

    @Override // g.a.l2.e, g.a.l2.n
    public final E poll() {
        Object objQ = Q();
        if (objQ == g.a.l2.b.c) {
            return null;
        }
        return S(objQ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.l2.e, g.a.l2.n
    public final Object receive(f.w.d<? super E> dVar) throws Throwable {
        Object objQ = Q();
        if (objQ == g.a.l2.b.c) {
            return U(0, dVar);
        }
        T(objQ);
        return objQ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.l2.e, g.a.l2.n
    public final Object receiveOrClosed(f.w.d<? super t<? extends E>> dVar) {
        Object objQ = Q();
        if (objQ == g.a.l2.b.c) {
            return U(2, dVar);
        }
        if (objQ instanceof g.a.l2.h) {
            t.b bVar = t.b;
            objQ = new t.a(((g.a.l2.h) objQ).f1601f);
            t.b(objQ);
        } else {
            t.b bVar2 = t.b;
            t.b(objQ);
        }
        return t.a(objQ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g.a.l2.e, g.a.l2.n
    public final Object receiveOrNull(f.w.d<? super E> dVar) {
        Object objQ = Q();
        return objQ != g.a.l2.b.c ? S(objQ) : U(1, dVar);
    }

    @Override // g.a.l2.c
    public o<E> z() {
        o<E> oVarZ = super.z();
        if (oVarZ != null && !(oVarZ instanceof g.a.l2.h)) {
            O();
        }
        return oVarZ;
    }

    @Override // g.a.l2.e, g.a.l2.n
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(l0.a(this) + " was cancelled");
        }
        cancel(cancellationException);
    }
}
