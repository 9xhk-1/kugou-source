package e.f.a.b.a.m.d;

import e.f.a.b.a.c;
import f.o;
import f.s;
import f.u.c0;
import f.z.c.l;
import f.z.c.p;
import f.z.d.j;
import f.z.d.k;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    public static final class a extends k implements p<Long, InputStream, s> {
        public final /* synthetic */ e.f.a.b.a.m.d.a a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f1484d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e.f.a.b.a.m.d.a aVar, String str, l lVar) {
            super(2);
            this.a = aVar;
            this.b = str;
            this.f1484d = lVar;
        }

        public final void a(long j, InputStream inputStream) {
            j.f(inputStream, "inputStream");
            String strA = e.f.a.b.a.m.b.a(inputStream);
            if (strA == null) {
                e.f.a.b.a.m.d.a aVar = this.a;
                if (aVar != null) {
                    aVar.onError(1, "Read Stream to String Fail.", false);
                    return;
                }
                return;
            }
            c.a aVar2 = e.f.a.b.a.c.b;
            StringBuilder sb = new StringBuilder();
            sb.append("Http Download Success: ");
            sb.append(this.b);
            sb.append(' ');
            sb.append("(thread: ");
            Thread threadCurrentThread = Thread.currentThread();
            j.b(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getId());
            sb.append(')');
            aVar2.d("SimpleDownloader", sb.toString());
            this.f1484d.invoke(strA);
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ s invoke(Long l, InputStream inputStream) {
            a(l.longValue(), inputStream);
            return s.a;
        }
    }

    /* JADX INFO: renamed from: e.f.a.b.a.m.d.b$b, reason: collision with other inner class name */
    public static final class C0255b extends k implements l<HttpURLConnection, s> {
        public final /* synthetic */ Map b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f1485d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0255b(Map map, p pVar) {
            super(1);
            this.b = map;
            this.f1485d = pVar;
        }

        public final void a(HttpURLConnection httpURLConnection) throws IOException {
            j.f(httpURLConnection, "conn");
            b.this.j(this.b, httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            e.f.a.b.a.c.b.d("SimpleDownloader", "Http Response Code = " + responseCode);
            this.f1485d.invoke(Integer.valueOf(responseCode), httpURLConnection);
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(HttpURLConnection httpURLConnection) throws IOException {
            a(httpURLConnection);
            return s.a;
        }
    }

    public static final class c extends k implements l<Throwable, s> {
        public final /* synthetic */ e.f.a.b.a.m.d.a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e.f.a.b.a.m.d.a aVar) {
            super(1);
            this.b = aVar;
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(Throwable th) {
            invoke2(th);
            return s.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            j.f(th, "it");
            b.this.e(th, this.b);
        }
    }

    public static final class d extends k implements p<Integer, HttpURLConnection, s> {
        public final /* synthetic */ p b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e.f.a.b.a.m.d.a f1486d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(p pVar, e.f.a.b.a.m.d.a aVar) {
            super(2);
            this.b = pVar;
            this.f1486d = aVar;
        }

        public final void a(int i2, HttpURLConnection httpURLConnection) {
            j.f(httpURLConnection, "conn");
            if (i2 != 200) {
                b.this.f(i2, this.f1486d);
                return;
            }
            p pVar = this.b;
            Long lValueOf = Long.valueOf(httpURLConnection.getContentLength());
            InputStream inputStream = httpURLConnection.getInputStream();
            j.b(inputStream, "conn.inputStream");
            pVar.invoke(lValueOf, inputStream);
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ s invoke(Integer num, HttpURLConnection httpURLConnection) {
            a(num.intValue(), httpURLConnection);
            return s.a;
        }
    }

    public final void d(String str, e.f.a.b.a.m.d.a aVar, l<? super String, s> lVar) {
        j.f(str, "url");
        j.f(lVar, "successAction");
        i(str, aVar, new a(aVar, str, lVar));
    }

    public final void e(Throwable th, e.f.a.b.a.m.d.a aVar) {
        if (aVar != null) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            aVar.onError(2, message, false);
        }
    }

    public final void f(int i2, e.f.a.b.a.m.d.a aVar) {
        if (aVar != null) {
            aVar.onError(i2, "Bad Http Response Code " + i2, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d A[Catch: all -> 0x0086, TryCatch #1 {all -> 0x0086, blocks: (B:3:0x0001, B:6:0x0014, B:8:0x002d, B:10:0x0054, B:16:0x0065, B:11:0x0057, B:12:0x005c, B:13:0x005d, B:15:0x0063, B:20:0x0080, B:21:0x0085), top: B:37:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(java.lang.String r7, java.lang.String r8, f.z.c.l<? super java.lang.Throwable, f.s> r9, f.z.c.l<? super java.net.HttpURLConnection, f.s> r10) {
        /*
            r6 = this;
            r0 = 0
            e.f.a.b.a.m.d.c.a()     // Catch: java.lang.Throwable -> L86
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L86
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L86
            android.app.Application r7 = e.f.a.b.a.d.a     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = e.f.a.b.a.m.a.a(r7)     // Catch: java.lang.Throwable -> L86
            java.lang.String r2 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r3 = 0
            if (r7 == 0) goto L5d
            java.util.Locale r4 = java.util.Locale.US     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = "Locale.US"
            f.z.d.j.b(r4, r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = r7.toLowerCase(r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = "(this as java.lang.String).toLowerCase(locale)"
            f.z.d.j.b(r7, r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = "wap"
            r5 = 2
            boolean r7 = f.e0.o.v(r7, r4, r3, r5, r0)     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L5d
            java.lang.String r7 = "http.proxyHost"
            java.lang.String r7 = java.lang.System.getProperty(r7)     // Catch: java.lang.Throwable -> L86
            java.lang.String r4 = "http.proxyPort"
            java.lang.String r4 = java.lang.System.getProperty(r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r5 = "proxyPort"
            f.z.d.j.b(r4, r5)     // Catch: java.lang.Throwable -> L86
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L86
            java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch: java.lang.Throwable -> L86
            r5.<init>(r7, r4)     // Catch: java.lang.Throwable -> L86
            java.net.Proxy r7 = new java.net.Proxy     // Catch: java.lang.Throwable -> L86
            java.net.Proxy$Type r4 = java.net.Proxy.Type.HTTP     // Catch: java.lang.Throwable -> L86
            r7.<init>(r4, r5)     // Catch: java.lang.Throwable -> L86
            java.net.URLConnection r7 = r1.openConnection(r7)     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L57
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L86
            goto L65
        L57:
            f.p r7 = new f.p     // Catch: java.lang.Throwable -> L86
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L86
            throw r7     // Catch: java.lang.Throwable -> L86
        L5d:
            java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L86
            if (r7 == 0) goto L80
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L86
        L65:
            r0 = r7
            r0.setRequestMethod(r8)     // Catch: java.lang.Throwable -> L86
            r7 = 30000(0x7530, float:4.2039E-41)
            r0.setConnectTimeout(r7)     // Catch: java.lang.Throwable -> L86
            r0.setReadTimeout(r7)     // Catch: java.lang.Throwable -> L86
            r0.setUseCaches(r3)     // Catch: java.lang.Throwable -> L86
            r0.setInstanceFollowRedirects(r3)     // Catch: java.lang.Throwable -> L86
            r10.invoke(r0)     // Catch: java.lang.Throwable -> L86
            if (r0 == 0) goto L8d
        L7c:
            r0.disconnect()     // Catch: java.lang.Throwable -> L8d
            goto L8d
        L80:
            f.p r7 = new f.p     // Catch: java.lang.Throwable -> L86
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L86
            throw r7     // Catch: java.lang.Throwable -> L86
        L86:
            r7 = move-exception
            r9.invoke(r7)     // Catch: java.lang.Throwable -> L8e
            if (r0 == 0) goto L8d
            goto L7c
        L8d:
            return
        L8e:
            r7 = move-exception
            if (r0 == 0) goto L94
            r0.disconnect()     // Catch: java.lang.Throwable -> L94
        L94:
            goto L96
        L95:
            throw r7
        L96:
            goto L95
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.b.a.m.d.b.g(java.lang.String, java.lang.String, f.z.c.l, f.z.c.l):void");
    }

    public final void h(String str, String str2, Map<String, String> map, e.f.a.b.a.m.d.a aVar, p<? super Integer, ? super HttpURLConnection, s> pVar) {
        c.a aVar2 = e.f.a.b.a.c.b;
        StringBuilder sb = new StringBuilder();
        sb.append("Http Request(");
        sb.append(str);
        sb.append("): ");
        sb.append(str2);
        sb.append(" (thread: ");
        Thread threadCurrentThread = Thread.currentThread();
        j.b(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getId());
        sb.append(')');
        aVar2.d("SimpleDownloader", sb.toString());
        g(str2, str, new c(aVar), new C0255b(map, pVar));
    }

    public final void i(String str, e.f.a.b.a.m.d.a aVar, p<? super Long, ? super InputStream, s> pVar) {
        h("GET", str, c0.b(o.a("Accept-Encoding", HTTP.IDENTITY_CODING)), aVar, new d(pVar, aVar));
    }

    public final void j(Map<String, String> map, HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
