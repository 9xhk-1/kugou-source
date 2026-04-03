package e.c.a.g.a.n.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public int a;
    public boolean b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1117e;

    public a() {
        this.f1117e = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.G0, 1) == 1;
    }

    public String a() {
        return b(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038 A[PHI: r3
  0x0038: PHI (r3v9 java.lang.String) = (r3v6 java.lang.String), (r3v12 java.lang.String) binds: [B:12:0x0035, B:9:0x0024] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(boolean r3) {
        /*
            r2 = this;
            java.lang.String r3 = r2.c
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L96
            boolean r3 = e.c.a.g.a.f.a.v()
            java.lang.String r0 = "https://h5.kugou.com/watch2client/v-2d639b28/index.html"
            if (r3 == 0) goto L27
            boolean r3 = e.c.a.g.a.f.a.u()
            if (r3 == 0) goto L27
            e.c.a.g.a.f.e.c r3 = e.c.a.g.a.f.e.c.c()
            com.kugou.common.config.ConfigKey r1 = e.c.a.g.a.f.e.b.S2
            java.lang.String r3 = r3.getConfig(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L38
            goto L39
        L27:
            e.c.a.g.a.f.e.c r3 = e.c.a.g.a.f.e.c.c()
            com.kugou.common.config.ConfigKey r1 = e.c.a.g.a.f.e.b.Q2
            java.lang.String r3 = r3.getConfig(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 == 0) goto L38
            goto L39
        L38:
            r0 = r3
        L39:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.lang.String r0 = "?"
            r3.append(r0)
            java.lang.String r0 = "qrcode="
            r3.append(r0)
            java.lang.String r0 = r2.c
            r3.append(r0)
            java.lang.String r0 = "&"
            r3.append(r0)
            java.lang.String r1 = "appid="
            r3.append(r1)
            r1 = 3337(0xd09, float:4.676E-42)
            r3.append(r1)
            r3.append(r0)
            java.lang.String r1 = "channel="
            r3.append(r1)
            java.lang.String r1 = e.c.a.g.a.s.l1.j()
            r3.append(r1)
            boolean r1 = e.c.a.g.a.f.a.v()
            if (r1 == 0) goto L7c
            boolean r1 = e.c.a.g.a.f.a.u()
            if (r1 == 0) goto L7c
            java.lang.String r1 = "&version=2"
            r3.append(r1)
        L7c:
            boolean r1 = r2.f1117e
            if (r1 == 0) goto L89
            r3.append(r0)
            java.lang.String r0 = "type=1"
            r3.append(r0)
            goto L91
        L89:
            r3.append(r0)
            java.lang.String r0 = "name=概念版手表登录确认"
            r3.append(r0)
        L91:
            java.lang.String r3 = r3.toString()
            return r3
        L96:
            java.lang.String r3 = ""
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.n.b.a.b(boolean):java.lang.String");
    }

    public String c() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public String toString() {
        return "KGCode{error_code=" + this.a + ", hasData=" + this.b + ", qrcode='" + this.c + "', shortUrl='" + this.f1116d + "'}";
    }
}
