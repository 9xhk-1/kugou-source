package g.a;

import com.kugou.common.apm.sdk.ApmDataKey;
import f.w.g;
import g.a.m1;
import g.a.n2.i;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public class t1 implements m1, q, y1, g.a.q2.a {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(t1.class, Object.class, "_state");
    private volatile Object _state;
    public volatile o parentHandle;

    public static final class a extends s1<m1> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final t1 f1651h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final b f1652i;
        public final p j;
        public final Object k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t1 t1Var, b bVar, p pVar, Object obj) {
            super(pVar.f1622h);
            f.z.d.j.f(t1Var, "parent");
            f.z.d.j.f(bVar, ApmDataKey.STATE);
            f.z.d.j.f(pVar, "child");
            this.f1651h = t1Var;
            this.f1652i = bVar;
            this.j = pVar;
            this.k = obj;
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ f.s invoke(Throwable th) {
            s(th);
            return f.s.a;
        }

        @Override // g.a.x
        public void s(Throwable th) {
            this.f1651h.l(this.f1652i, this.j, this.k);
        }

        @Override // g.a.n2.i
        public String toString() {
            return "ChildCompletion[" + this.j + ", " + this.k + ']';
        }
    }

    public static final class b implements h1 {
        public volatile Object _exceptionsHolder;
        public final v1 a;
        public volatile boolean isCompleting;
        public volatile Throwable rootCause;

        public b(v1 v1Var, boolean z, Throwable th) {
            f.z.d.j.f(v1Var, "list");
            this.a = v1Var;
            this.isCompleting = z;
            this.rootCause = th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Throwable th) {
            f.z.d.j.f(th, "exception");
            Throwable th2 = this.rootCause;
            if (th2 == null) {
                this.rootCause = th;
                return;
            }
            if (th == th2) {
                return;
            }
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                this._exceptionsHolder = th;
                return;
            }
            if (obj instanceof Throwable) {
                if (th == obj) {
                    return;
                }
                ArrayList<Throwable> arrayListB = b();
                arrayListB.add(obj);
                arrayListB.add(th);
                this._exceptionsHolder = arrayListB;
                return;
            }
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + obj).toString());
        }

        public final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        public final boolean c() {
            return this.rootCause != null;
        }

        public final boolean d() {
            return this._exceptionsHolder == u1.a;
        }

        public final List<Throwable> e(Throwable th) {
            ArrayList arrayListB;
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                arrayListB = b();
            } else if (obj instanceof Throwable) {
                ArrayList arrayListB2 = b();
                arrayListB2.add(obj);
                arrayListB = arrayListB2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayListB = (ArrayList) obj;
            }
            Throwable th2 = this.rootCause;
            if (th2 != null) {
                arrayListB.add(0, th2);
            }
            if (th != null && (!f.z.d.j.a(th, th2))) {
                arrayListB.add(th);
            }
            this._exceptionsHolder = u1.a;
            return arrayListB;
        }

        @Override // g.a.h1
        public v1 getList() {
            return this.a;
        }

        @Override // g.a.h1
        public boolean isActive() {
            return this.rootCause == null;
        }

        public String toString() {
            return "Finishing[cancelling=" + c() + ", completing=" + this.isCompleting + ", rootCause=" + this.rootCause + ", exceptions=" + this._exceptionsHolder + ", list=" + getList() + ']';
        }
    }

    public static final class c extends i.c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t1 f1653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f1654e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g.a.n2.i iVar, g.a.n2.i iVar2, t1 t1Var, Object obj) {
            super(iVar2);
            this.f1653d = t1Var;
            this.f1654e = obj;
        }

        @Override // g.a.n2.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object d(g.a.n2.i iVar) {
            f.z.d.j.f(iVar, "affected");
            if (this.f1653d.u() == this.f1654e) {
                return null;
            }
            return g.a.n2.h.a();
        }
    }

    @f.w.j.a.f(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {897, 899}, m = "invokeSuspend")
    public static final class d extends f.w.j.a.k implements f.z.c.p<f.d0.d<? super q>, f.w.d<? super f.s>, Object> {
        public f.d0.d b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f1655d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f1656f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f1657h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Object f1658i;
        public Object j;
        public Object k;
        public int l;

        public d(f.w.d dVar) {
            super(2, dVar);
        }

        @Override // f.w.j.a.a
        public final f.w.d<f.s> create(Object obj, f.w.d<?> dVar) {
            f.z.d.j.f(dVar, "completion");
            d dVar2 = t1.this.new d(dVar);
            dVar2.b = (f.d0.d) obj;
            return dVar2;
        }

        @Override // f.z.c.p
        public final Object invoke(f.d0.d<? super q> dVar, f.w.d<? super f.s> dVar2) {
            return ((d) create(dVar, dVar2)).invokeSuspend(f.s.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x007d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007f -> B:29:0x009b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:29:0x009b). Please report as a decompilation issue!!! */
        @Override // f.w.j.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = f.w.i.c.d()
                int r1 = r10.l
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3b
                if (r1 == r3) goto L32
                if (r1 != r2) goto L2a
                java.lang.Object r1 = r10.k
                g.a.p r1 = (g.a.p) r1
                java.lang.Object r1 = r10.j
                g.a.n2.i r1 = (g.a.n2.i) r1
                java.lang.Object r4 = r10.f1658i
                g.a.v1 r4 = (g.a.v1) r4
                java.lang.Object r5 = r10.f1657h
                g.a.v1 r5 = (g.a.v1) r5
                java.lang.Object r6 = r10.f1656f
                java.lang.Object r7 = r10.f1655d
                f.d0.d r7 = (f.d0.d) r7
                f.k.b(r11)
                r11 = r10
                goto L9b
            L2a:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L32:
                java.lang.Object r0 = r10.f1655d
                f.d0.d r0 = (f.d0.d) r0
                f.k.b(r11)
                goto La8
            L3b:
                f.k.b(r11)
                f.d0.d r11 = r10.b
                g.a.t1 r1 = g.a.t1.this
                java.lang.Object r1 = r1.u()
                boolean r4 = r1 instanceof g.a.p
                if (r4 == 0) goto L5c
                r2 = r1
                g.a.p r2 = (g.a.p) r2
                g.a.q r2 = r2.f1622h
                r10.f1655d = r11
                r10.f1656f = r1
                r10.l = r3
                java.lang.Object r11 = r11.a(r2, r10)
                if (r11 != r0) goto La8
                return r0
            L5c:
                boolean r4 = r1 instanceof g.a.h1
                if (r4 == 0) goto La8
                r4 = r1
                g.a.h1 r4 = (g.a.h1) r4
                g.a.v1 r4 = r4.getList()
                if (r4 == 0) goto La8
                java.lang.Object r5 = r4.h()
                if (r5 == 0) goto La0
                g.a.n2.i r5 = (g.a.n2.i) r5
                r7 = r11
                r6 = r1
                r1 = r5
                r11 = r10
                r5 = r4
            L76:
                boolean r8 = f.z.d.j.a(r1, r4)
                r8 = r8 ^ r3
                if (r8 == 0) goto La8
                boolean r8 = r1 instanceof g.a.p
                if (r8 == 0) goto L9b
                r8 = r1
                g.a.p r8 = (g.a.p) r8
                g.a.q r9 = r8.f1622h
                r11.f1655d = r7
                r11.f1656f = r6
                r11.f1657h = r5
                r11.f1658i = r4
                r11.j = r1
                r11.k = r8
                r11.l = r2
                java.lang.Object r8 = r7.a(r9, r11)
                if (r8 != r0) goto L9b
                return r0
            L9b:
                g.a.n2.i r1 = r1.i()
                goto L76
            La0:
                f.p r11 = new f.p
            */
            //  java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            /*
                r11.<init>(r0)
                throw r11
            La8:
                f.s r11 = f.s.a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.t1.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public t1(boolean z) {
        this._state = z ? u1.c : u1.b;
    }

    public static /* synthetic */ CancellationException S(t1 t1Var, Throwable th, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i2 & 1) != 0) {
            str = null;
        }
        return t1Var.R(th, str);
    }

    public final /* synthetic */ Object A(f.w.d<? super f.s> dVar) {
        k kVar = new k(f.w.i.b.c(dVar), 1);
        l.a(kVar, invokeOnCompletion(new b2(this, kVar)));
        Object objL = kVar.l();
        if (objL == f.w.i.c.d()) {
            f.w.j.a.h.c(dVar);
        }
        return objL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean B(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r7.u()
            boolean r3 = r2 instanceof g.a.t1.b
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L4a
            monitor-enter(r2)
            r3 = r2
            g.a.t1$b r3 = (g.a.t1.b) r3     // Catch: java.lang.Throwable -> L47
            boolean r3 = r3.d()     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L18
            monitor-exit(r2)
            return r4
        L18:
            r3 = r2
            g.a.t1$b r3 = (g.a.t1.b) r3     // Catch: java.lang.Throwable -> L47
            boolean r3 = r3.c()     // Catch: java.lang.Throwable -> L47
            if (r8 != 0) goto L23
            if (r3 != 0) goto L30
        L23:
            if (r1 == 0) goto L26
            goto L2a
        L26:
            java.lang.Throwable r1 = r7.m(r8)     // Catch: java.lang.Throwable -> L47
        L2a:
            r8 = r2
            g.a.t1$b r8 = (g.a.t1.b) r8     // Catch: java.lang.Throwable -> L47
            r8.a(r1)     // Catch: java.lang.Throwable -> L47
        L30:
            r8 = r2
            g.a.t1$b r8 = (g.a.t1.b) r8     // Catch: java.lang.Throwable -> L47
            java.lang.Throwable r8 = r8.rootCause     // Catch: java.lang.Throwable -> L47
            r1 = r3 ^ 1
            if (r1 == 0) goto L3a
            r0 = r8
        L3a:
            monitor-exit(r2)
            if (r0 == 0) goto L46
            g.a.t1$b r2 = (g.a.t1.b) r2
            g.a.v1 r8 = r2.getList()
            r7.H(r8, r0)
        L46:
            return r5
        L47:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L4a:
            boolean r3 = r2 instanceof g.a.h1
            if (r3 == 0) goto La1
            if (r1 == 0) goto L51
            goto L55
        L51:
            java.lang.Throwable r1 = r7.m(r8)
        L55:
            r3 = r2
            g.a.h1 r3 = (g.a.h1) r3
            boolean r6 = r3.isActive()
            if (r6 == 0) goto L65
            boolean r2 = r7.W(r3, r1)
            if (r2 == 0) goto L2
            return r5
        L65:
            g.a.t r3 = new g.a.t
            r6 = 2
            r3.<init>(r1, r4, r6, r0)
            int r3 = r7.X(r2, r3, r4)
            if (r3 == 0) goto L86
            if (r3 == r5) goto L85
            if (r3 == r6) goto L85
            r2 = 3
            if (r3 != r2) goto L79
            goto L2
        L79:
            java.lang.String r8 = "unexpected result"
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        L85:
            return r5
        L86:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Cannot happen in "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        La1:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.t1.B(java.lang.Object):boolean");
    }

    public final boolean C(Object obj) {
        int iX;
        do {
            boolean z = false;
            iX = X(u(), obj, 0);
            if (iX != 0) {
                z = true;
                if (iX == 1 || iX == 2) {
                }
            }
            return z;
        } while (iX == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public final boolean D(Object obj, int i2) {
        int iX;
        do {
            iX = X(u(), obj, i2);
            if (iX == 0) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, p(obj));
            }
            if (iX == 1) {
                return true;
            }
            if (iX == 2) {
                return false;
            }
        } while (iX == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public final s1<?> E(f.z.c.l<? super Throwable, f.s> lVar, boolean z) {
        if (z) {
            o1 o1Var = (o1) (lVar instanceof o1 ? lVar : null);
            if (o1Var != null) {
                if (!(o1Var.f1650f == this)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (o1Var != null) {
                    return o1Var;
                }
            }
            return new k1(this, lVar);
        }
        s1<?> s1Var = (s1) (lVar instanceof s1 ? lVar : null);
        if (s1Var != null) {
            if (!(s1Var.f1650f == this && !(s1Var instanceof o1))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (s1Var != null) {
                return s1Var;
            }
        }
        return new l1(this, lVar);
    }

    public String F() {
        return l0.a(this);
    }

    public final p G(g.a.n2.i iVar) {
        while (iVar.n()) {
            iVar = iVar.k();
        }
        while (true) {
            iVar = iVar.i();
            if (!iVar.n()) {
                if (iVar instanceof p) {
                    return (p) iVar;
                }
                if (iVar instanceof v1) {
                    return null;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H(g.a.v1 r7, java.lang.Throwable r8) throws java.lang.Throwable {
        /*
            r6 = this;
            r6.J(r8)
            java.lang.Object r0 = r7.h()
            if (r0 == 0) goto L56
            g.a.n2.i r0 = (g.a.n2.i) r0
            r1 = 0
        Lc:
            boolean r2 = f.z.d.j.a(r0, r7)
            r2 = r2 ^ 1
            if (r2 == 0) goto L4d
            boolean r2 = r0 instanceof g.a.o1
            if (r2 == 0) goto L48
            r2 = r0
            g.a.s1 r2 = (g.a.s1) r2
            r2.s(r8)     // Catch: java.lang.Throwable -> L1f
            goto L48
        L1f:
            r3 = move-exception
            if (r1 == 0) goto L28
            f.a.a(r1, r3)
            if (r1 == 0) goto L28
            goto L48
        L28:
            g.a.y r1 = new g.a.y
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception in completion handler "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " for "
            r4.append(r2)
            r4.append(r6)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2, r3)
            f.s r2 = f.s.a
        L48:
            g.a.n2.i r0 = r0.i()
            goto Lc
        L4d:
            if (r1 == 0) goto L52
            r6.w(r1)
        L52:
            r6.i(r8)
            return
        L56:
            f.p r7 = new f.p
        */
        //  java.lang.String r8 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            goto L5f
        L5e:
            throw r7
        L5f:
            goto L5e
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.t1.H(g.a.v1, java.lang.Throwable):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void I(g.a.v1 r7, java.lang.Throwable r8) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r7.h()
            if (r0 == 0) goto L50
            g.a.n2.i r0 = (g.a.n2.i) r0
            r1 = 0
        L9:
            boolean r2 = f.z.d.j.a(r0, r7)
            r2 = r2 ^ 1
            if (r2 == 0) goto L4a
            boolean r2 = r0 instanceof g.a.s1
            if (r2 == 0) goto L45
            r2 = r0
            g.a.s1 r2 = (g.a.s1) r2
            r2.s(r8)     // Catch: java.lang.Throwable -> L1c
            goto L45
        L1c:
            r3 = move-exception
            if (r1 == 0) goto L25
            f.a.a(r1, r3)
            if (r1 == 0) goto L25
            goto L45
        L25:
            g.a.y r1 = new g.a.y
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Exception in completion handler "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = " for "
            r4.append(r2)
            r4.append(r6)
            java.lang.String r2 = r4.toString()
            r1.<init>(r2, r3)
            f.s r2 = f.s.a
        L45:
            g.a.n2.i r0 = r0.i()
            goto L9
        L4a:
            if (r1 == 0) goto L4f
            r6.w(r1)
        L4f:
            return
        L50:
            f.p r7 = new f.p
        */
        //  java.lang.String r8 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r7.<init>(r8)
            goto L59
        L58:
            throw r7
        L59:
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.t1.I(g.a.v1, java.lang.Throwable):void");
    }

    public void J(Throwable th) {
    }

    public void K(Object obj) {
    }

    public void L() {
    }

    public final void M(v0 v0Var) {
        v1 v1Var = new v1();
        Object g1Var = v1Var;
        if (!v0Var.isActive()) {
            g1Var = new g1(v1Var);
        }
        a.compareAndSet(this, v0Var, g1Var);
    }

    public final void N(s1<?> s1Var) {
        s1Var.c(new v1());
        a.compareAndSet(this, s1Var, s1Var.i());
    }

    public final void O(s1<?> s1Var) {
        Object objU;
        f.z.d.j.f(s1Var, "node");
        do {
            objU = u();
            if (!(objU instanceof s1)) {
                if (!(objU instanceof h1) || ((h1) objU).getList() == null) {
                    return;
                }
                s1Var.p();
                return;
            }
            if (objU != s1Var) {
                return;
            }
        } while (!a.compareAndSet(this, objU, u1.c));
    }

    public final int P(Object obj) {
        if (obj instanceof v0) {
            if (((v0) obj).isActive()) {
                return 0;
            }
            if (!a.compareAndSet(this, obj, u1.c)) {
                return -1;
            }
            L();
            return 1;
        }
        if (!(obj instanceof g1)) {
            return 0;
        }
        if (!a.compareAndSet(this, obj, ((g1) obj).getList())) {
            return -1;
        }
        L();
        return 1;
    }

    public final String Q(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof h1 ? ((h1) obj).isActive() ? "Active" : "New" : obj instanceof t ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.c() ? "Cancelling" : bVar.isCompleting ? "Completing" : "Active";
    }

    public final CancellationException R(Throwable th, String str) {
        f.z.d.j.f(th, "$this$toCancellationException");
        CancellationException n1Var = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (n1Var == null) {
            if (str == null) {
                str = l0.a(th) + " was cancelled";
            }
            n1Var = new n1(str, th, this);
        }
        return n1Var;
    }

    public final String T() {
        return F() + '{' + Q(u()) + '}';
    }

    public final boolean U(b bVar, Object obj, int i2) throws Throwable {
        boolean zC;
        Throwable thQ;
        if (!(u() == bVar)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!bVar.d())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!bVar.isCompleting) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        t tVar = (t) (!(obj instanceof t) ? null : obj);
        Throwable th = tVar != null ? tVar.a : null;
        synchronized (bVar) {
            zC = bVar.c();
            List<Throwable> listE = bVar.e(th);
            thQ = q(bVar, listE);
            if (thQ != null) {
                c(thQ, listE);
            }
        }
        if (thQ != null && thQ != th) {
            obj = new t(thQ, false, 2, null);
        }
        if (thQ != null) {
            if (i(thQ) || v(thQ)) {
                if (obj == null) {
                    throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((t) obj).b();
            }
        }
        if (!zC) {
            J(thQ);
        }
        K(obj);
        if (a.compareAndSet(this, bVar, u1.d(obj))) {
            k(bVar, obj, i2);
            return true;
        }
        throw new IllegalArgumentException(("Unexpected state: " + this._state + ", expected: " + bVar + ", update: " + obj).toString());
    }

    public final boolean V(h1 h1Var, Object obj, int i2) throws Throwable {
        if (k0.a()) {
            if (!((h1Var instanceof v0) || (h1Var instanceof s1))) {
                throw new AssertionError();
            }
        }
        if (k0.a() && !(!(obj instanceof t))) {
            throw new AssertionError();
        }
        if (!a.compareAndSet(this, h1Var, u1.d(obj))) {
            return false;
        }
        J(null);
        K(obj);
        k(h1Var, obj, i2);
        return true;
    }

    public final boolean W(h1 h1Var, Throwable th) throws Throwable {
        if (k0.a() && !(!(h1Var instanceof b))) {
            throw new AssertionError();
        }
        if (k0.a() && !h1Var.isActive()) {
            throw new AssertionError();
        }
        v1 v1VarT = t(h1Var);
        if (v1VarT == null) {
            return false;
        }
        if (!a.compareAndSet(this, h1Var, new b(v1VarT, false, th))) {
            return false;
        }
        H(v1VarT, th);
        return true;
    }

    public final int X(Object obj, Object obj2, int i2) {
        if (obj instanceof h1) {
            return ((!(obj instanceof v0) && !(obj instanceof s1)) || (obj instanceof p) || (obj2 instanceof t)) ? Y((h1) obj, obj2, i2) : !V((h1) obj, obj2, i2) ? 3 : 1;
        }
        return 0;
    }

    public final int Y(h1 h1Var, Object obj, int i2) throws Throwable {
        v1 v1VarT = t(h1Var);
        if (v1VarT == null) {
            return 3;
        }
        b bVar = (b) (!(h1Var instanceof b) ? null : h1Var);
        if (bVar == null) {
            bVar = new b(v1VarT, false, null);
        }
        synchronized (bVar) {
            if (bVar.isCompleting) {
                return 0;
            }
            bVar.isCompleting = true;
            if (bVar != h1Var && !a.compareAndSet(this, h1Var, bVar)) {
                return 3;
            }
            if (!(!bVar.d())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            boolean zC = bVar.c();
            t tVar = (t) (!(obj instanceof t) ? null : obj);
            if (tVar != null) {
                bVar.a(tVar.a);
            }
            Throwable th = zC ^ true ? bVar.rootCause : null;
            f.s sVar = f.s.a;
            if (th != null) {
                H(v1VarT, th);
            }
            p pVarO = o(h1Var);
            if (pVarO == null || !Z(bVar, pVarO, obj)) {
                return U(bVar, obj, i2) ? 1 : 3;
            }
            return 2;
        }
    }

    public final boolean Z(b bVar, p pVar, Object obj) {
        while (m1.a.e(pVar.f1622h, false, false, new a(this, bVar, pVar, obj), 1, null) == w1.a) {
            pVar = G(pVar);
            if (pVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // g.a.m1
    public final o attachChild(q qVar) {
        f.z.d.j.f(qVar, "child");
        t0 t0VarE = m1.a.e(this, true, false, new p(this, qVar), 2, null);
        if (t0VarE != null) {
            return (o) t0VarE;
        }
        throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    public final boolean b(Object obj, v1 v1Var, s1<?> s1Var) {
        int iR;
        c cVar = new c(s1Var, s1Var, this, obj);
        do {
            Object objJ = v1Var.j();
            if (objJ == null) {
                throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            iR = ((g.a.n2.i) objJ).r(s1Var, v1Var, cVar);
            if (iR == 1) {
                return true;
            }
        } while (iR != 2);
        return false;
    }

    public final void c(Throwable th, List<? extends Throwable> list) throws IllegalAccessException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setA = g.a.n2.e.a(list.size());
        Throwable thM = g.a.n2.p.m(th);
        Iterator<? extends Throwable> it = list.iterator();
        while (it.hasNext()) {
            Throwable thM2 = g.a.n2.p.m(it.next());
            if (thM2 != th && thM2 != thM && !(thM2 instanceof CancellationException) && setA.add(thM2)) {
                f.a.a(th, thM2);
            }
        }
    }

    @Override // g.a.m1
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public void d(Object obj, int i2) {
    }

    public final boolean e(Throwable th) {
        return f(th);
    }

    public final boolean f(Object obj) {
        if (s() && h(obj)) {
            return true;
        }
        return B(obj);
    }

    @Override // g.a.m1, f.w.g.b, f.w.g
    public <R> R fold(R r, f.z.c.p<? super R, ? super g.b, ? extends R> pVar) {
        f.z.d.j.f(pVar, "operation");
        return (R) m1.a.c(this, r, pVar);
    }

    @Override // g.a.m1
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public boolean cancel(Throwable th) {
        return f(th) && r();
    }

    @Override // g.a.m1, f.w.g.b, f.w.g
    public <E extends g.b> E get(g.c<E> cVar) {
        f.z.d.j.f(cVar, "key");
        return (E) m1.a.d(this, cVar);
    }

    @Override // g.a.m1
    public final CancellationException getCancellationException() {
        Object objU = u();
        if (!(objU instanceof b)) {
            if (objU instanceof h1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objU instanceof t) {
                return S(this, ((t) objU).a, null, 1, null);
            }
            return new n1(l0.a(this) + " has completed normally", null, this);
        }
        Throwable th = ((b) objU).rootCause;
        if (th != null) {
            CancellationException cancellationExceptionR = R(th, l0.a(this) + " is cancelling");
            if (cancellationExceptionR != null) {
                return cancellationExceptionR;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // g.a.y1
    public CancellationException getChildJobCancellationCause() {
        Throwable th;
        Object objU = u();
        if (objU instanceof b) {
            th = ((b) objU).rootCause;
        } else if (objU instanceof t) {
            th = ((t) objU).a;
        } else {
            if (objU instanceof h1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objU).toString());
            }
            th = null;
        }
        CancellationException cancellationException = (CancellationException) (th instanceof CancellationException ? th : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        return new n1("Parent job is " + Q(objU), th, this);
    }

    @Override // g.a.m1
    public final f.d0.b<m1> getChildren() {
        return f.d0.e.b(new d(null));
    }

    @Override // g.a.m1, f.w.g.b
    public final g.c<?> getKey() {
        return m1.f1605g;
    }

    @Override // g.a.m1
    public final g.a.q2.a getOnJoin() {
        return this;
    }

    public final boolean h(Object obj) {
        int iX;
        do {
            Object objU = u();
            if (!(objU instanceof h1) || (((objU instanceof b) && ((b) objU).isCompleting) || (iX = X(objU, new t(m(obj), false, 2, null), 0)) == 0)) {
                return false;
            }
            if (iX == 1 || iX == 2) {
                return true;
            }
        } while (iX == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public final boolean i(Throwable th) {
        if (y()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        o oVar = this.parentHandle;
        return (oVar == null || oVar == w1.a) ? z : oVar.childCancelled(th) || z;
    }

    @Override // g.a.m1
    public final t0 invokeOnCompletion(f.z.c.l<? super Throwable, f.s> lVar) {
        f.z.d.j.f(lVar, "handler");
        return invokeOnCompletion(false, true, lVar);
    }

    @Override // g.a.m1, g.a.q, g.a.y1
    public boolean isActive() {
        Object objU = u();
        return (objU instanceof h1) && ((h1) objU).isActive();
    }

    @Override // g.a.m1
    public final boolean isCancelled() {
        Object objU = u();
        return (objU instanceof t) || ((objU instanceof b) && ((b) objU).c());
    }

    @Override // g.a.m1
    public final boolean isCompleted() {
        return !(u() instanceof h1);
    }

    public boolean j(Throwable th) {
        f.z.d.j.f(th, "cause");
        if (th instanceof CancellationException) {
            return true;
        }
        return f(th) && r();
    }

    @Override // g.a.m1
    public final Object join(f.w.d<? super f.s> dVar) {
        if (z()) {
            return A(dVar);
        }
        k2.a(dVar.getContext());
        return f.s.a;
    }

    public final void k(h1 h1Var, Object obj, int i2) throws Throwable {
        o oVar = this.parentHandle;
        if (oVar != null) {
            oVar.dispose();
            this.parentHandle = w1.a;
        }
        t tVar = (t) (!(obj instanceof t) ? null : obj);
        Throwable th = tVar != null ? tVar.a : null;
        if (h1Var instanceof s1) {
            try {
                ((s1) h1Var).s(th);
            } catch (Throwable th2) {
                w(new y("Exception in completion handler " + h1Var + " for " + this, th2));
            }
        } else {
            v1 list = h1Var.getList();
            if (list != null) {
                I(list, th);
            }
        }
        d(obj, i2);
    }

    public final void l(b bVar, p pVar, Object obj) {
        if (!(u() == bVar)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        p pVarG = G(pVar);
        if ((pVarG == null || !Z(bVar, pVarG, obj)) && U(bVar, obj, 0)) {
        }
    }

    public final Throwable m(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : n();
        }
        if (obj != null) {
            return ((y1) obj).getChildJobCancellationCause();
        }
        throw new f.p("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    @Override // g.a.m1, f.w.g.b, f.w.g
    public f.w.g minusKey(g.c<?> cVar) {
        f.z.d.j.f(cVar, "key");
        return m1.a.f(this, cVar);
    }

    public final n1 n() {
        return new n1("Job was cancelled", null, this);
    }

    public final p o(h1 h1Var) {
        p pVar = (p) (!(h1Var instanceof p) ? null : h1Var);
        if (pVar != null) {
            return pVar;
        }
        v1 list = h1Var.getList();
        if (list != null) {
            return G(list);
        }
        return null;
    }

    public final Throwable p(Object obj) {
        if (!(obj instanceof t)) {
            obj = null;
        }
        t tVar = (t) obj;
        if (tVar != null) {
            return tVar.a;
        }
        return null;
    }

    @Override // g.a.q
    public final void parentCancelled(y1 y1Var) {
        f.z.d.j.f(y1Var, "parentJob");
        f(y1Var);
    }

    @Override // g.a.m1, f.w.g.b, f.w.g
    public f.w.g plus(f.w.g gVar) {
        f.z.d.j.f(gVar, "context");
        return m1.a.g(this, gVar);
    }

    public final Throwable q(b bVar, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.c()) {
                return n();
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : list.get(0);
    }

    public boolean r() {
        return true;
    }

    @Override // g.a.q2.a
    public final <R> void registerSelectClause0(g.a.q2.d<? super R> dVar, f.z.c.l<? super f.w.d<? super R>, ? extends Object> lVar) {
        Object objU;
        f.z.d.j.f(dVar, "select");
        f.z.d.j.f(lVar, "block");
        do {
            objU = u();
            if (dVar.isSelected()) {
                return;
            }
            if (!(objU instanceof h1)) {
                if (dVar.trySelect(null)) {
                    g.a.o2.b.b(lVar, dVar.getCompletion());
                    return;
                }
                return;
            }
        } while (P(objU) != 0);
        dVar.disposeOnSelect(invokeOnCompletion(new c2(this, dVar, lVar)));
    }

    public boolean s() {
        return false;
    }

    @Override // g.a.m1
    public final boolean start() {
        int iP;
        do {
            iP = P(u());
            if (iP == 0) {
                return false;
            }
        } while (iP != 1);
        return true;
    }

    public final v1 t(h1 h1Var) {
        v1 list = h1Var.getList();
        if (list != null) {
            return list;
        }
        if (h1Var instanceof v0) {
            return new v1();
        }
        if (h1Var instanceof s1) {
            N((s1) h1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + h1Var).toString());
    }

    public String toString() {
        return T() + '@' + l0.b(this);
    }

    public final Object u() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof g.a.n2.l)) {
                return obj;
            }
            ((g.a.n2.l) obj).a(this);
        }
    }

    public boolean v(Throwable th) {
        f.z.d.j.f(th, "exception");
        return false;
    }

    public void w(Throwable th) throws Throwable {
        f.z.d.j.f(th, "exception");
        throw th;
    }

    public final void x(m1 m1Var) {
        if (k0.a()) {
            if (!(this.parentHandle == null)) {
                throw new AssertionError();
            }
        }
        if (m1Var == null) {
            this.parentHandle = w1.a;
            return;
        }
        m1Var.start();
        o oVarAttachChild = m1Var.attachChild(this);
        this.parentHandle = oVarAttachChild;
        if (isCompleted()) {
            oVarAttachChild.dispose();
            this.parentHandle = w1.a;
        }
    }

    public boolean y() {
        return false;
    }

    public final boolean z() {
        Object objU;
        do {
            objU = u();
            if (!(objU instanceof h1)) {
                return false;
            }
        } while (P(objU) < 0);
        return true;
    }

    @Override // g.a.m1
    public void cancel(CancellationException cancellationException) {
        cancel(cancellationException);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0082 A[SYNTHETIC] */
    @Override // g.a.m1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final g.a.t0 invokeOnCompletion(boolean r8, boolean r9, f.z.c.l<? super java.lang.Throwable, f.s> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "handler"
            f.z.d.j.f(r10, r0)
            r0 = 0
            r1 = r0
        L7:
            java.lang.Object r2 = r7.u()
            boolean r3 = r2 instanceof g.a.v0
            if (r3 == 0) goto L2c
            r3 = r2
            g.a.v0 r3 = (g.a.v0) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L28
            if (r1 == 0) goto L1b
            goto L1f
        L1b:
            g.a.s1 r1 = r7.E(r10, r8)
        L1f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = g.a.t1.a
            boolean r2 = r3.compareAndSet(r7, r2, r1)
            if (r2 == 0) goto L7
            return r1
        L28:
            r7.M(r3)
            goto L7
        L2c:
            boolean r3 = r2 instanceof g.a.h1
            if (r3 == 0) goto L96
            r3 = r2
            g.a.h1 r3 = (g.a.h1) r3
            g.a.v1 r3 = r3.getList()
            if (r3 != 0) goto L49
            if (r2 == 0) goto L41
            g.a.s1 r2 = (g.a.s1) r2
            r7.N(r2)
            goto L7
        L41:
            f.p r8 = new f.p
            java.lang.String r9 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>"
            r8.<init>(r9)
            throw r8
        L49:
            g.a.w1 r4 = g.a.w1.a
            if (r8 == 0) goto L7f
            boolean r5 = r2 instanceof g.a.t1.b
            if (r5 == 0) goto L7f
            monitor-enter(r2)
            r5 = r2
            g.a.t1$b r5 = (g.a.t1.b) r5     // Catch: java.lang.Throwable -> L7c
            java.lang.Throwable r5 = r5.rootCause     // Catch: java.lang.Throwable -> L7c
            if (r5 == 0) goto L64
            boolean r6 = r10 instanceof g.a.p     // Catch: java.lang.Throwable -> L7c
            if (r6 == 0) goto L78
            r6 = r2
            g.a.t1$b r6 = (g.a.t1.b) r6     // Catch: java.lang.Throwable -> L7c
            boolean r6 = r6.isCompleting     // Catch: java.lang.Throwable -> L7c
            if (r6 != 0) goto L78
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            g.a.s1 r1 = r7.E(r10, r8)     // Catch: java.lang.Throwable -> L7c
        L6b:
            boolean r4 = r7.b(r2, r3, r1)     // Catch: java.lang.Throwable -> L7c
            if (r4 != 0) goto L73
            monitor-exit(r2)
            goto L7
        L73:
            if (r5 != 0) goto L77
            monitor-exit(r2)
            return r1
        L77:
            r4 = r1
        L78:
            f.s r6 = f.s.a     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r2)
            goto L80
        L7c:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L7f:
            r5 = r0
        L80:
            if (r5 == 0) goto L88
            if (r9 == 0) goto L87
            r10.invoke(r5)
        L87:
            return r4
        L88:
            if (r1 == 0) goto L8b
            goto L8f
        L8b:
            g.a.s1 r1 = r7.E(r10, r8)
        L8f:
            boolean r2 = r7.b(r2, r3, r1)
            if (r2 == 0) goto L7
            return r1
        L96:
            if (r9 == 0) goto La6
            boolean r8 = r2 instanceof g.a.t
            if (r8 != 0) goto L9d
            r2 = r0
        L9d:
            g.a.t r2 = (g.a.t) r2
            if (r2 == 0) goto La3
            java.lang.Throwable r0 = r2.a
        La3:
            r10.invoke(r0)
        La6:
            g.a.w1 r8 = g.a.w1.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.t1.invokeOnCompletion(boolean, boolean, f.z.c.l):g.a.t0");
    }

    @Override // g.a.m1
    public m1 plus(m1 m1Var) {
        f.z.d.j.f(m1Var, "other");
        m1.a.h(this, m1Var);
        return m1Var;
    }
}
