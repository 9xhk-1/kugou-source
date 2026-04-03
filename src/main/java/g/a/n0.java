package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class n0<T> extends q0<T> implements f.w.j.a.e, f.w.d<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f1608f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f.w.j.a.e f1609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f1610i;
    public final b0 j;
    public final f.w.d<T> k;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [f.w.d<? super T>, f.w.d<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type f.w.d<? super T> to ?? for r3v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.instructions.args.InsnArg.wrapInstruction(InsnArg.java:138)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.inline(CodeShrinkVisitor.java:213)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:143)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:68)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:48)
        	at jadx.core.dex.visitors.regions.TernaryMod.replaceWithTernary(TernaryMod.java:347)
        	at jadx.core.dex.visitors.regions.TernaryMod.processOneBranchTernary(TernaryMod.java:273)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:77)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public n0(g.a.b0 r2, f.w.d<? super T> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "dispatcher"
            f.z.d.j.f(r2, r0)
            java.lang.String r0 = "continuation"
            f.z.d.j.f(r3, r0)
            r0 = 0
            r1.<init>(r0)
            r1.j = r2
            r1.k = r3
            g.a.n2.q r2 = g.a.p0.a()
            r1.f1608f = r2
            boolean r2 = r3 instanceof f.w.j.a.e
            if (r2 != 0) goto L1d
            r3 = 0
        L1d:
            f.w.j.a.e r3 = (f.w.j.a.e) r3
            r1.f1609h = r3
            f.w.g r2 = r1.getContext()
            java.lang.Object r2 = g.a.n2.u.b(r2)
            r1.f1610i = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.n0.<init>(g.a.b0, f.w.d):void");
    }

    @Override // g.a.q0
    public f.w.d<T> c() {
        return this;
    }

    @Override // g.a.q0
    public Object g() {
        Object obj = this.f1608f;
        if (k0.a()) {
            if (!(obj != p0.a)) {
                throw new AssertionError();
            }
        }
        this.f1608f = p0.a;
        return obj;
    }

    @Override // f.w.j.a.e
    public f.w.j.a.e getCallerFrame() {
        return this.f1609h;
    }

    @Override // f.w.d
    public f.w.g getContext() {
        return this.k.getContext();
    }

    @Override // f.w.j.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // f.w.d
    public void resumeWith(Object obj) {
        f.w.g context = this.k.getContext();
        Object objA = u.a(obj);
        if (this.j.b(context)) {
            this.f1608f = objA;
            this.f1648d = 0;
            this.j.a(context, this);
            return;
        }
        w0 w0VarB = f2.b.b();
        if (w0VarB.j()) {
            this.f1608f = objA;
            this.f1648d = 0;
            w0VarB.f(this);
            return;
        }
        w0VarB.h(true);
        try {
            f.w.g context2 = getContext();
            Object objC = g.a.n2.u.c(context2, this.f1610i);
            try {
                this.k.resumeWith(obj);
                f.s sVar = f.s.a;
                while (w0VarB.m()) {
                }
            } finally {
                g.a.n2.u.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.j + ", " + l0.c(this.k) + ']';
    }
}
