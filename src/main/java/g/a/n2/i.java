package g.a.n2;

import g.a.k0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_prev");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1611d = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    private volatile Object _removedRef = null;

    public static abstract class a extends g.a.n2.b {
    }

    public static class b<T extends i> extends a {
        private volatile Object _affectedNode;
        public final T a;

        static {
            AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_affectedNode");
        }

        public b(i iVar, T t) {
            f.z.d.j.f(iVar, "queue");
            f.z.d.j.f(t, "node");
            this.a = t;
            if (k0.a()) {
                if (!(t._next == t && t._prev == t)) {
                    throw new AssertionError();
                }
            }
            this._affectedNode = null;
        }
    }

    public static abstract class c extends g.a.n2.d<i> {
        public i b;
        public final i c;

        public c(i iVar) {
            f.z.d.j.f(iVar, "newNode");
            this.c = iVar;
        }

        @Override // g.a.n2.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(i iVar, Object obj) {
            f.z.d.j.f(iVar, "affected");
            boolean z = obj == null;
            i iVar2 = z ? this.c : this.b;
            if (iVar2 != null && i.a.compareAndSet(iVar, this, iVar2) && z) {
                i iVar3 = this.c;
                i iVar4 = this.b;
                if (iVar4 != null) {
                    iVar3.f(iVar4);
                } else {
                    f.z.d.j.n();
                    throw null;
                }
            }
        }
    }

    public static class d<T> extends a {
        private volatile Object _affectedNode;
        private volatile Object _originalNext;

        static {
            AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_affectedNode");
            AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_originalNext");
        }

        public d(i iVar) {
            f.z.d.j.f(iVar, "queue");
            this._affectedNode = null;
            this._originalNext = null;
        }

        public final i a() {
            return (i) this._affectedNode;
        }

        public final T b() {
            T t = (T) a();
            if (t != null) {
                return t;
            }
            f.z.d.j.n();
            throw null;
        }
    }

    public final boolean b(i iVar, i iVar2) {
        f.z.d.j.f(iVar, "node");
        f.z.d.j.f(iVar2, "next");
        b.lazySet(iVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(iVar, iVar2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, iVar2, iVar)) {
            return false;
        }
        iVar.f(iVar2);
        return true;
    }

    public final boolean c(i iVar) {
        f.z.d.j.f(iVar, "node");
        b.lazySet(iVar, this);
        a.lazySet(iVar, this);
        while (h() == this) {
            if (a.compareAndSet(this, this, iVar)) {
                iVar.f(this);
                return true;
            }
        }
        return false;
    }

    public final i d(i iVar, l lVar) {
        Object obj;
        while (true) {
            i iVar2 = null;
            while (true) {
                obj = iVar._next;
                if (obj == lVar) {
                    return iVar;
                }
                if (obj instanceof l) {
                    ((l) obj).a(iVar);
                } else if (!(obj instanceof m)) {
                    Object obj2 = this._prev;
                    if (obj2 instanceof m) {
                        return null;
                    }
                    if (obj != this) {
                        if (obj == null) {
                            throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                        iVar2 = iVar;
                        iVar = (i) obj;
                    } else {
                        if (obj2 == iVar) {
                            return null;
                        }
                        if (b.compareAndSet(this, obj2, iVar) && !(iVar._prev instanceof m)) {
                            return null;
                        }
                    }
                } else {
                    if (iVar2 != null) {
                        break;
                    }
                    iVar = h.b(iVar._prev);
                }
            }
            iVar.o();
            a.compareAndSet(iVar2, iVar, ((m) obj).a);
            iVar = iVar2;
        }
    }

    public final i e() {
        i iVarI = this;
        while (!(iVarI instanceof g)) {
            iVarI = iVarI.i();
            if (k0.a()) {
                if (!(iVarI != this)) {
                    throw new AssertionError();
                }
            }
        }
        return iVarI;
    }

    public final void f(i iVar) {
        Object obj;
        do {
            obj = iVar._prev;
            if ((obj instanceof m) || h() != iVar) {
                return;
            }
        } while (!b.compareAndSet(iVar, obj, this));
        if (h() instanceof m) {
            if (obj == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            iVar.d((i) obj, null);
        }
    }

    public final void g(i iVar) {
        l();
        iVar.d(h.b(this._prev), null);
    }

    public final Object h() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof l)) {
                return obj;
            }
            ((l) obj).a(this);
        }
    }

    public final i i() {
        return h.b(h());
    }

    public final Object j() {
        while (true) {
            Object obj = this._prev;
            if (obj instanceof m) {
                return obj;
            }
            if (obj == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            i iVar = (i) obj;
            if (iVar.h() == this) {
                return obj;
            }
            d(iVar, null);
        }
    }

    public final i k() {
        return h.b(j());
    }

    public final void l() {
        Object objH;
        i iVarO = o();
        Object obj = this._next;
        if (obj == null) {
            throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        }
        i iVar = ((m) obj).a;
        while (true) {
            i iVar2 = null;
            while (true) {
                Object objH2 = iVar.h();
                if (objH2 instanceof m) {
                    iVar.o();
                    iVar = ((m) objH2).a;
                } else {
                    objH = iVarO.h();
                    if (objH instanceof m) {
                        if (iVar2 != null) {
                            break;
                        } else {
                            iVarO = h.b(iVarO._prev);
                        }
                    } else if (objH != this) {
                        if (objH == null) {
                            throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                        }
                        i iVar3 = (i) objH;
                        if (iVar3 == iVar) {
                            return;
                        }
                        iVar2 = iVarO;
                        iVarO = iVar3;
                    } else if (a.compareAndSet(iVarO, this, iVar)) {
                        return;
                    }
                }
            }
            iVarO.o();
            a.compareAndSet(iVar2, iVarO, ((m) objH).a);
            iVarO = iVar2;
        }
    }

    public final void m() {
        Object objH = h();
        if (!(objH instanceof m)) {
            objH = null;
        }
        m mVar = (m) objH;
        if (mVar == null) {
            throw new IllegalStateException("Must be invoked on a removed node".toString());
        }
        g(mVar.a);
    }

    public final boolean n() {
        return h() instanceof m;
    }

    public final i o() {
        Object obj;
        i iVarE;
        do {
            obj = this._prev;
            if (obj instanceof m) {
                return ((m) obj).a;
            }
            if (obj == this) {
                iVarE = e();
            } else {
                if (obj == null) {
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                }
                iVarE = (i) obj;
            }
        } while (!b.compareAndSet(this, obj, iVarE.q()));
        return (i) obj;
    }

    public boolean p() {
        Object objH;
        i iVar;
        do {
            objH = h();
            if ((objH instanceof m) || objH == this) {
                return false;
            }
            if (objH == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            iVar = (i) objH;
        } while (!a.compareAndSet(this, objH, iVar.q()));
        g(iVar);
        return true;
    }

    public final m q() {
        m mVar = (m) this._removedRef;
        if (mVar != null) {
            return mVar;
        }
        m mVar2 = new m(this);
        f1611d.lazySet(this, mVar2);
        return mVar2;
    }

    public final int r(i iVar, i iVar2, c cVar) {
        f.z.d.j.f(iVar, "node");
        f.z.d.j.f(iVar2, "next");
        f.z.d.j.f(cVar, "condAdd");
        b.lazySet(iVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(iVar, iVar2);
        cVar.b = iVar2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, iVar2, cVar)) {
            return cVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
