package g.a;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {
    public static final boolean a;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = g.a.n2.r.d(r0)
            if (r0 != 0) goto L9
            goto L33
        L9:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L22
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L37
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r0 = 0
            goto L34
        L22:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            goto L33
        L2b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
        L33:
            r0 = 1
        L34:
            g.a.a0.a = r0
            return
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a0.<clinit>():void");
    }

    public static final b0 a() {
        return a ? g.a.p2.c.j : r.f1649d;
    }

    public static final String b(f.w.g gVar) {
        e0 e0Var;
        String name;
        f.z.d.j.f(gVar, "$this$coroutineName");
        if (!k0.c() || (e0Var = (e0) gVar.get(e0.b)) == null) {
            return null;
        }
        f0 f0Var = (f0) gVar.get(f0.b);
        if (f0Var == null || (name = f0Var.getName()) == null) {
            name = "coroutine";
        }
        return name + '#' + e0Var.a();
    }

    public static final f.w.g c(g0 g0Var, f.w.g gVar) {
        f.z.d.j.f(g0Var, "$this$newCoroutineContext");
        f.z.d.j.f(gVar, "context");
        f.w.g gVarPlus = g0Var.getCoroutineContext().plus(gVar);
        f.w.g gVarPlus2 = k0.c() ? gVarPlus.plus(new e0(k0.b().incrementAndGet())) : gVarPlus;
        return (gVarPlus == s0.a() || gVarPlus.get(f.w.e.c) != null) ? gVarPlus2 : gVarPlus2.plus(s0.a());
    }
}
