package e.f.a.a.a.j;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static b c;
    public Context a;
    public Map<String, String> b = null;

    public class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            e.f.a.a.a.k.c.b("checkClientTrusted", new Object[0]);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            e.f.a.a.a.k.c.b("checkServerTrusted", new Object[0]);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public b(Context context) {
        this.a = context;
    }

    public static b c(Context context) {
        if (c == null) {
            c = new b(context);
        }
        return c;
    }

    public static void h() {
        TrustManager[] trustManagerArr = {new a()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            e.f.a.a.a.k.c.c("destUrl is null.", new Object[0]);
            return null;
        }
        h();
        HttpURLConnection httpURLConnectionB = b(str2, str);
        if (httpURLConnectionB == null) {
            e.f.a.a.a.k.c.c("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            httpURLConnectionB.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnectionB.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            httpURLConnectionB.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            httpURLConnectionB.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = httpURLConnectionB.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return httpURLConnectionB;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            e.f.a.a.a.k.c.c("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    public HttpURLConnection b(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (e.f.a.a.a.k.d.a() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(e.f.a.a.a.k.d.a());
            } else if (str == null || !str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public final Map<String, String> d(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() >= 1) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    public boolean e(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 307;
    }

    public byte[] f(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = bufferedInputStream.read(bArr);
                if (i2 <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                return null;
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0162 A[PHI: r4 r6 r10 r13 r14
  0x0162: PHI (r4v4 java.lang.Throwable) = (r4v3 java.lang.Throwable), (r4v15 java.lang.Throwable) binds: [B:95:0x0181, B:79:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0162: PHI (r6v7 int) = (r6v6 int), (r6v13 int) binds: [B:95:0x0181, B:79:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0162: PHI (r10v8 java.lang.String) = (r10v7 java.lang.String), (r10v14 java.lang.String) binds: [B:95:0x0181, B:79:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0162: PHI (r13v5 int) = (r13v4 int), (r13v9 int) binds: [B:95:0x0181, B:79:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0162: PHI (r14v5 boolean) = (r14v4 boolean), (r14v11 boolean) binds: [B:95:0x0181, B:79:0x0160] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0174 A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #4 {all -> 0x0168, blocks: (B:24:0x009e, B:26:0x00a6, B:30:0x00b7, B:29:0x00b5, B:38:0x00ca, B:40:0x00d0, B:42:0x00d8, B:55:0x010b, B:57:0x0115, B:71:0x012f, B:74:0x0153, B:88:0x016e, B:90:0x0174), top: B:117:0x009e }] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] g(java.lang.String r21, byte[] r22, e.f.a.a.a.j.e r23, java.util.Map<java.lang.String, java.lang.String> r24) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.j.b.g(java.lang.String, byte[], e.f.a.a.a.j.e, java.util.Map):byte[]");
    }
}
