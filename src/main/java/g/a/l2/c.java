package g.a.l2;

import f.z.d.v;
import g.a.k0;
import g.a.l0;
import g.a.n2.i;
import g.a.t0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<E> implements r<E> {
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");
    public final g.a.n2.g b = new g.a.n2.g();
    private volatile Object onCloseHandler = null;

    public static final class a<E> extends q {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final E f1590f;

        public a(E e2) {
            this.f1590f = e2;
        }

        @Override // g.a.l2.q
        public void s(Object obj) {
            f.z.d.j.f(obj, "token");
            if (k0.a()) {
                if (!(obj == g.a.l2.b.f1588h)) {
                    throw new AssertionError();
                }
            }
        }

        @Override // g.a.l2.q
        public Object t() {
            return this.f1590f;
        }

        @Override // g.a.l2.q
        public void u(h<?> hVar) {
            f.z.d.j.f(hVar, "closed");
        }

        @Override // g.a.l2.q
        public Object v(Object obj) {
            return g.a.l2.b.f1588h;
        }
    }

    public static class b<E> extends i.b<a<? extends E>> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g.a.n2.g gVar, E e2) {
            super(gVar, new a(e2));
            f.z.d.j.f(gVar, "queue");
        }
    }

    /* JADX INFO: renamed from: g.a.l2.c$c, reason: collision with other inner class name */
    public static final class C0272c<E> extends b<E> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0272c(g.a.n2.g gVar, E e2) {
            super(gVar, e2);
            f.z.d.j.f(gVar, "queue");
        }
    }

    public static final class d<E, R> extends q implements t0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f1591f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final r<E> f1592h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final g.a.q2.d<R> f1593i;
        public final f.z.c.p<r<? super E>, f.w.d<? super R>, Object> j;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Object obj, r<? super E> rVar, g.a.q2.d<? super R> dVar, f.z.c.p<? super r<? super E>, ? super f.w.d<? super R>, ? extends Object> pVar) {
            f.z.d.j.f(rVar, "channel");
            f.z.d.j.f(dVar, "select");
            f.z.d.j.f(pVar, "block");
            this.f1591f = obj;
            this.f1592h = rVar;
            this.f1593i = dVar;
            this.j = pVar;
        }

        @Override // g.a.t0
        public void dispose() {
            p();
        }

        @Override // g.a.l2.q
        public void s(Object obj) {
            f.z.d.j.f(obj, "token");
            if (k0.a()) {
                if (!(obj == g.a.l2.b.f1585e)) {
                    throw new AssertionError();
                }
            }
            f.w.f.a(this.j, this.f1592h, this.f1593i.getCompletion());
        }

        @Override // g.a.l2.q
        public Object t() {
            return this.f1591f;
        }

        @Override // g.a.n2.i
        public String toString() {
            return "SendSelect(" + t() + ")[" + this.f1592h + ", " + this.f1593i + ']';
        }

        @Override // g.a.l2.q
        public void u(h<?> hVar) {
            f.z.d.j.f(hVar, "closed");
            if (this.f1593i.trySelect(null)) {
                this.f1593i.resumeSelectCancellableWithException(hVar.z());
            }
        }

        @Override // g.a.l2.q
        public Object v(Object obj) {
            if (this.f1593i.trySelect(obj)) {
                return g.a.l2.b.f1585e;
            }
            return null;
        }
    }

    public static final class e<E> extends i.d<o<? super E>> {
        public Object a;
        public final E b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(E e2, g.a.n2.g gVar) {
            super(gVar);
            f.z.d.j.f(gVar, "queue");
            this.b = e2;
        }
    }

    public static final class f extends i.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f1594d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(g.a.n2.i iVar, g.a.n2.i iVar2, c cVar) {
            super(iVar2);
            this.f1594d = cVar;
        }

        @Override // g.a.n2.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object d(g.a.n2.i iVar) {
            f.z.d.j.f(iVar, "affected");
            if (this.f1594d.s()) {
                return null;
            }
            return g.a.n2.h.a();
        }
    }

    public static final class g implements g.a.q2.c<E, r<? super E>> {
        public g() {
        }

        @Override // g.a.q2.c
        public <R> void registerSelectClause2(g.a.q2.d<? super R> dVar, E e2, f.z.c.p<? super r<? super E>, ? super f.w.d<? super R>, ? extends Object> pVar) throws Throwable {
            f.z.d.j.f(dVar, "select");
            f.z.d.j.f(pVar, "block");
            c.this.w(dVar, e2, pVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final g.a.l2.q A() {
        /*
            r4 = this;
            g.a.n2.g r0 = r4.b
        L2:
            java.lang.Object r1 = r0.h()
            if (r1 == 0) goto L29
            g.a.n2.i r1 = (g.a.n2.i) r1
            r2 = 0
            if (r1 != r0) goto Lf
        Ld:
            r1 = r2
            goto L22
        Lf:
            boolean r3 = r1 instanceof g.a.l2.q
            if (r3 != 0) goto L14
            goto Ld
        L14:
            r2 = r1
            g.a.l2.q r2 = (g.a.l2.q) r2
            boolean r2 = r2 instanceof g.a.l2.h
            if (r2 == 0) goto L1c
            goto L22
        L1c:
            boolean r2 = r1.p()
            if (r2 == 0) goto L25
        L22:
            g.a.l2.q r1 = (g.a.l2.q) r1
            return r1
        L25:
            r1.l()
            goto L2
        L29:
            f.p r0 = new f.p
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r0.<init>(r1)
            goto L32
        L31:
            throw r0
        L32:
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.l2.c.A():g.a.l2.q");
    }

    @Override // g.a.l2.r
    public boolean close(Throwable th) {
        boolean z;
        h<?> hVar = new h<>(th);
        g.a.n2.g gVar = this.b;
        while (true) {
            Object objJ = gVar.j();
            if (objJ == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            g.a.n2.i iVar = (g.a.n2.i) objJ;
            if (!(!(iVar instanceof h))) {
                z = false;
                break;
            }
            if (iVar.b(hVar, gVar)) {
                z = true;
                break;
            }
        }
        if (z) {
            p(hVar);
            q(th);
            return true;
        }
        g.a.n2.i iVarK = this.b.k();
        if (iVarK == null) {
            throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
        }
        p((h) iVarK);
        return false;
    }

    public final int e() {
        Object objH = this.b.h();
        if (objH == null) {
            throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        int i2 = 0;
        for (g.a.n2.i iVarI = (g.a.n2.i) objH; !f.z.d.j.a(iVarI, r0); iVarI = iVarI.i()) {
            if (iVarI instanceof g.a.n2.i) {
                i2++;
            }
        }
        return i2;
    }

    public final i.b<?> f(E e2) {
        return new b(this.b, e2);
    }

    public final i.b<?> g(E e2) {
        return new C0272c(this.b, e2);
    }

    @Override // g.a.l2.r
    public final g.a.q2.c<E, r<E>> getOnSend() {
        return new g();
    }

    public final e<E> h(E e2) {
        return new e<>(e2, this.b);
    }

    public final Object i(q qVar) {
        boolean z;
        g.a.n2.i iVar;
        if (r()) {
            g.a.n2.g gVar = this.b;
            do {
                Object objJ = gVar.j();
                if (objJ == null) {
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
                iVar = (g.a.n2.i) objJ;
                if (iVar instanceof o) {
                    return iVar;
                }
            } while (!iVar.b(qVar, gVar));
            return null;
        }
        g.a.n2.g gVar2 = this.b;
        f fVar = new f(qVar, qVar, this);
        while (true) {
            Object objJ2 = gVar2.j();
            if (objJ2 == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            g.a.n2.i iVar2 = (g.a.n2.i) objJ2;
            if (!(iVar2 instanceof o)) {
                int iR = iVar2.r(qVar, gVar2, fVar);
                z = true;
                if (iR != 1) {
                    if (iR == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return iVar2;
            }
        }
        if (z) {
            return null;
        }
        return g.a.l2.b.f1584d;
    }

    @Override // g.a.l2.r
    public void invokeOnClose(f.z.c.l<? super Throwable, f.s> lVar) {
        f.z.d.j.f(lVar, "handler");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (atomicReferenceFieldUpdater.compareAndSet(this, null, lVar)) {
            h<?> hVarL = l();
            if (hVarL == null || !atomicReferenceFieldUpdater.compareAndSet(this, lVar, g.a.l2.b.f1589i)) {
                return;
            }
            lVar.invoke(hVarL.f1601f);
            return;
        }
        Object obj = this.onCloseHandler;
        if (obj == g.a.l2.b.f1589i) {
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        throw new IllegalStateException("Another handler was already registered: " + obj);
    }

    @Override // g.a.l2.r
    public final boolean isClosedForSend() {
        return l() != null;
    }

    @Override // g.a.l2.r
    public final boolean isFull() {
        return m();
    }

    public String j() {
        return "";
    }

    public final h<?> k() {
        g.a.n2.i iVarI = this.b.i();
        if (!(iVarI instanceof h)) {
            iVarI = null;
        }
        h<?> hVar = (h) iVarI;
        if (hVar == null) {
            return null;
        }
        p(hVar);
        return hVar;
    }

    public final h<?> l() {
        g.a.n2.i iVarK = this.b.k();
        if (!(iVarK instanceof h)) {
            iVarK = null;
        }
        h<?> hVar = (h) iVarK;
        if (hVar == null) {
            return null;
        }
        p(hVar);
        return hVar;
    }

    public final boolean m() {
        return !(this.b.i() instanceof o) && s();
    }

    public final g.a.n2.g n() {
        return this.b;
    }

    public final String o() {
        String string;
        g.a.n2.i iVarI = this.b.i();
        if (iVarI == this.b) {
            return "EmptyQueue";
        }
        if (iVarI instanceof h) {
            string = iVarI.toString();
        } else if (iVarI instanceof m) {
            string = "ReceiveQueued";
        } else if (iVarI instanceof q) {
            string = "SendQueued";
        } else {
            string = "UNEXPECTED:" + iVarI;
        }
        g.a.n2.i iVarK = this.b.k();
        if (iVarK == iVarI) {
            return string;
        }
        String str = string + ",queueSize=" + e();
        if (!(iVarK instanceof h)) {
            return str;
        }
        return str + ",closedForSend=" + iVarK;
    }

    @Override // g.a.l2.r
    public final boolean offer(E e2) throws Throwable {
        Throwable thZ;
        Throwable thJ;
        Object objT = t(e2);
        if (objT == g.a.l2.b.a) {
            return true;
        }
        if (objT == g.a.l2.b.b) {
            h<?> hVarL = l();
            if (hVarL == null || (thZ = hVarL.z()) == null || (thJ = g.a.n2.p.j(thZ)) == null) {
                return false;
            }
            throw thJ;
        }
        if (objT instanceof h) {
            throw g.a.n2.p.j(((h) objT).z());
        }
        throw new IllegalStateException(("offerInternal returned " + objT).toString());
    }

    public final void p(h<?> hVar) {
        while (true) {
            g.a.n2.i iVarK = hVar.k();
            if ((iVarK instanceof g.a.n2.g) || !(iVarK instanceof m)) {
                break;
            } else if (iVarK.p()) {
                ((m) iVarK).s(hVar);
            } else {
                iVarK.m();
            }
        }
        v(hVar);
    }

    public final void q(Throwable th) {
        Object obj;
        Object obj2 = this.onCloseHandler;
        if (obj2 == null || obj2 == (obj = g.a.l2.b.f1589i) || !c.compareAndSet(this, obj2, obj)) {
            return;
        }
        v.a(obj2, 1);
        ((f.z.c.l) obj2).invoke(th);
    }

    public abstract boolean r();

    public abstract boolean s();

    @Override // g.a.l2.r
    public final Object send(E e2, f.w.d<? super f.s> dVar) {
        return offer(e2) ? f.s.a : y(e2, dVar);
    }

    public Object t(E e2) {
        o<E> oVarZ;
        Object objTryResumeReceive;
        do {
            oVarZ = z();
            if (oVarZ == null) {
                return g.a.l2.b.b;
            }
            objTryResumeReceive = oVarZ.tryResumeReceive(e2, null);
        } while (objTryResumeReceive == null);
        oVarZ.completeResumeReceive(objTryResumeReceive);
        return oVarZ.getOfferResult();
    }

    public String toString() {
        return l0.a(this) + '@' + l0.b(this) + '{' + o() + '}' + j();
    }

    public Object u(E e2, g.a.q2.d<?> dVar) {
        f.z.d.j.f(dVar, "select");
        e<E> eVarH = h(e2);
        Object objPerformAtomicTrySelect = dVar.performAtomicTrySelect(eVarH);
        if (objPerformAtomicTrySelect != null) {
            return objPerformAtomicTrySelect;
        }
        o<? super E> oVarB = eVarH.b();
        Object obj = eVarH.a;
        if (obj != null) {
            oVarB.completeResumeReceive(obj);
            return oVarB.getOfferResult();
        }
        f.z.d.j.n();
        throw null;
    }

    public void v(g.a.n2.i iVar) {
        f.z.d.j.f(iVar, "closed");
    }

    public final <R> void w(g.a.q2.d<? super R> dVar, E e2, f.z.c.p<? super r<? super E>, ? super f.w.d<? super R>, ? extends Object> pVar) throws Throwable {
        while (!dVar.isSelected()) {
            if (m()) {
                d dVar2 = new d(e2, this, dVar, pVar);
                Object objI = i(dVar2);
                if (objI == null) {
                    dVar.disposeOnSelect(dVar2);
                    return;
                }
                if (objI instanceof h) {
                    h<?> hVar = (h) objI;
                    p(hVar);
                    throw g.a.n2.p.j(hVar.z());
                }
                if (objI != g.a.l2.b.f1584d && !(objI instanceof m)) {
                    throw new IllegalStateException(("enqueueSend returned " + objI + ' ').toString());
                }
            }
            Object objU = u(e2, dVar);
            if (objU == g.a.q2.e.a()) {
                return;
            }
            if (objU != g.a.l2.b.b) {
                if (objU == g.a.l2.b.a) {
                    g.a.o2.b.c(pVar, this, dVar.getCompletion());
                    return;
                }
                if (objU instanceof h) {
                    h<?> hVar2 = (h) objU;
                    p(hVar2);
                    throw g.a.n2.p.j(hVar2.z());
                }
                throw new IllegalStateException(("offerSelectInternal returned " + objU).toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final o<?> x(E e2) {
        g.a.n2.i iVar;
        g.a.n2.g gVar = this.b;
        a aVar = new a(e2);
        do {
            Object objJ = gVar.j();
            if (objJ == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            iVar = (g.a.n2.i) objJ;
            if (iVar instanceof o) {
                return (o) iVar;
            }
        } while (!iVar.b(aVar, gVar));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object y(E r4, f.w.d<? super f.s> r5) {
        /*
            r3 = this;
            g.a.k r0 = new g.a.k
            f.w.d r1 = f.w.i.b.c(r5)
            r2 = 0
            r0.<init>(r1, r2)
        La:
            boolean r1 = b(r3)
            if (r1 == 0) goto L5f
            g.a.l2.s r1 = new g.a.l2.s
            r1.<init>(r4, r0)
            java.lang.Object r2 = a(r3, r1)
            if (r2 != 0) goto L20
            g.a.l.b(r0, r1)
            goto L90
        L20:
            boolean r1 = r2 instanceof g.a.l2.h
            if (r1 == 0) goto L3a
            g.a.l2.h r2 = (g.a.l2.h) r2
            c(r3, r2)
            java.lang.Throwable r4 = r2.z()
            f.j$a r1 = f.j.a
            java.lang.Object r4 = f.k.a(r4)
            f.j.a(r4)
            r0.resumeWith(r4)
            goto L90
        L3a:
            java.lang.Object r1 = g.a.l2.b.f1584d
            if (r2 != r1) goto L3f
            goto L5f
        L3f:
            boolean r1 = r2 instanceof g.a.l2.m
            if (r1 == 0) goto L44
            goto L5f
        L44:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "enqueueSend returned "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L5f:
            java.lang.Object r1 = r3.t(r4)
            java.lang.Object r2 = g.a.l2.b.a
            if (r1 != r2) goto L72
            f.s r4 = f.s.a
            f.j$a r1 = f.j.a
            f.j.a(r4)
            r0.resumeWith(r4)
            goto L90
        L72:
            java.lang.Object r2 = g.a.l2.b.b
            if (r1 != r2) goto L77
            goto La
        L77:
            boolean r4 = r1 instanceof g.a.l2.h
            if (r4 == 0) goto L9e
            g.a.l2.h r1 = (g.a.l2.h) r1
            c(r3, r1)
            java.lang.Throwable r4 = r1.z()
            f.j$a r1 = f.j.a
            java.lang.Object r4 = f.k.a(r4)
            f.j.a(r4)
            r0.resumeWith(r4)
        L90:
            java.lang.Object r4 = r0.l()
            java.lang.Object r0 = f.w.i.c.d()
            if (r4 != r0) goto L9d
            f.w.j.a.h.c(r5)
        L9d:
            return r4
        L9e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offerInternal returned "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            goto Lba
        Lb9:
            throw r5
        Lba:
            goto Lb9
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.l2.c.y(java.lang.Object, f.w.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [g.a.n2.i] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public g.a.l2.o<E> z() {
        /*
            r4 = this;
            g.a.n2.g r0 = r4.b
        L2:
            java.lang.Object r1 = r0.h()
            if (r1 == 0) goto L29
            g.a.n2.i r1 = (g.a.n2.i) r1
            r2 = 0
            if (r1 != r0) goto Lf
        Ld:
            r1 = r2
            goto L22
        Lf:
            boolean r3 = r1 instanceof g.a.l2.o
            if (r3 != 0) goto L14
            goto Ld
        L14:
            r2 = r1
            g.a.l2.o r2 = (g.a.l2.o) r2
            boolean r2 = r2 instanceof g.a.l2.h
            if (r2 == 0) goto L1c
            goto L22
        L1c:
            boolean r2 = r1.p()
            if (r2 == 0) goto L25
        L22:
            g.a.l2.o r1 = (g.a.l2.o) r1
            return r1
        L25:
            r1.l()
            goto L2
        L29:
            f.p r0 = new f.p
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r0.<init>(r1)
            goto L32
        L31:
            throw r0
        L32:
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.l2.c.z():g.a.l2.o");
    }
}
