package g.a;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {
    public static final boolean a = false;
    public static final boolean b;
    public static final boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f1572d;

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if (r0.equals("on") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r0.equals("") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        r0 = true;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = g.a.n2.r.d(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lb
            goto L27
        Lb:
            int r3 = r0.hashCode()
            if (r3 == 0) goto L3b
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L32
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L29
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L5e
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
        L27:
            r0 = 0
            goto L44
        L29:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
            goto L27
        L32:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
            goto L43
        L3b:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L5e
        L43:
            r0 = 1
        L44:
            g.a.k0.b = r0
            if (r0 == 0) goto L51
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = g.a.n2.r.e(r0, r1)
            if (r0 == 0) goto L51
            goto L52
        L51:
            r1 = 0
        L52:
            g.a.k0.c = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            g.a.k0.f1572d = r0
            return
        L5e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            goto L7f
        L7e:
            throw r1
        L7f:
            goto L7e
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.k0.<clinit>():void");
    }

    public static final boolean a() {
        return a;
    }

    public static final AtomicLong b() {
        return f1572d;
    }

    public static final boolean c() {
        return b;
    }

    public static final boolean d() {
        return c;
    }
}
