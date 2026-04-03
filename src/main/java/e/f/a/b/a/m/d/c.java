package e.f.a.b.a.m.d;

import f.z.d.j;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    public static final class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            j.f(x509CertificateArr, "chain");
            j.f(str, "authType");
            e.f.a.b.a.c.b.a("SimpleDownloader", "checkClientTrusted");
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            j.f(x509CertificateArr, "chain");
            j.f(str, "authType");
            e.f.a.b.a.c.b.a("SimpleDownloader", "checkServerTrusted");
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static final void b() {
        TrustManager[] trustManagerArr = {new a()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            j.b(sSLContext, "sc");
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
