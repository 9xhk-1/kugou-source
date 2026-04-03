package e.c.a.g.a.s;

/* JADX INFO: loaded from: classes2.dex */
public class k1 {
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0097: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:30:0x0097 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Exception while closing InputStream"
            java.lang.String r1 = "SystemPropertyUtil"
            r2 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r4.<init>()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.lang.String r5 = "getprop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r4.append(r7)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.lang.Process r3 = r3.exec(r4)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.InputStream r3 = r3.getInputStream()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r3 = 1024(0x400, float:1.435E-42)
            r4.<init>(r5, r3)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.lang.String r3 = r4.readLine()     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L96
            r4.close()     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L96
            r4.close()     // Catch: java.io.IOException -> L39
            goto L52
        L39:
            r7 = move-exception
            boolean r2 = e.c.a.g.a.s.g0.f()
            if (r2 == 0) goto L52
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            e.c.a.g.a.s.g0.b(r1, r7)
        L52:
            return r3
        L53:
            r3 = move-exception
            goto L59
        L55:
            r7 = move-exception
            goto L98
        L57:
            r3 = move-exception
            r4 = r2
        L59:
            boolean r5 = e.c.a.g.a.s.g0.f()     // Catch: java.lang.Throwable -> L96
            if (r5 == 0) goto L76
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r5.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String r6 = "Unable to read sysprop "
            r5.append(r6)     // Catch: java.lang.Throwable -> L96
            r5.append(r7)     // Catch: java.lang.Throwable -> L96
            r5.append(r3)     // Catch: java.lang.Throwable -> L96
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L96
            e.c.a.g.a.s.g0.b(r1, r7)     // Catch: java.lang.Throwable -> L96
        L76:
            if (r4 == 0) goto L95
            r4.close()     // Catch: java.io.IOException -> L7c
            goto L95
        L7c:
            r7 = move-exception
            boolean r3 = e.c.a.g.a.s.g0.f()
            if (r3 == 0) goto L95
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            e.c.a.g.a.s.g0.b(r1, r7)
        L95:
            return r2
        L96:
            r7 = move-exception
            r2 = r4
        L98:
            if (r2 == 0) goto Lb7
            r2.close()     // Catch: java.io.IOException -> L9e
            goto Lb7
        L9e:
            r2 = move-exception
            boolean r3 = e.c.a.g.a.s.g0.f()
            if (r3 == 0) goto Lb7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            e.c.a.g.a.s.g0.b(r1, r0)
        Lb7:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.s.k1.a(java.lang.String):java.lang.String");
    }
}
