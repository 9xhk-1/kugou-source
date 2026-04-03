package okhttp3;

import e.c.a.g.a.f.k.j.b;
import java.util.concurrent.Executor;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes2.dex */
public class KGOKHttpClientExt {
    public static Executor getOKHttpExecutor() {
        return ConnectionPool.executor;
    }

    public static OkHttpClient onlyCallByKGHttpClient() {
        return new OkHttpClient();
    }

    public static OkHttpClient.Builder onlyCallByKGHttpClient2() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.hostnameVerifier(new HostVerifyHooker(builder.hostnameVerifier));
        builder.addInterceptor(new b());
        return builder;
    }

    public static OkHttpClient.Builder onlyCallByKGHttpClient2(OkHttpClient okHttpClient) {
        return new OkHttpClient.Builder(okHttpClient);
    }
}
