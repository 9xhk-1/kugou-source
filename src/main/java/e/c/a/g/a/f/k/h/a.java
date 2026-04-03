package e.c.a.g.a.f.k.h;

import com.kugou.common.network.networkutils.UrlEncoderUtil;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public final Set<String> a = new HashSet();
    public final Lock b = new ReentrantLock();
    public boolean c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f690d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f691e;

    /* JADX INFO: renamed from: e.c.a.g.a.f.k.h.a$a, reason: collision with other inner class name */
    public static class C0103a {
        public static a a = new a();
    }

    public static a a() {
        return C0103a.a;
    }

    public Lock b() {
        return this.b;
    }

    public b c() {
        return this.f691e;
    }

    public boolean d() {
        return this.f690d.get();
    }

    public Response e(Interceptor.Chain chain, Request request) throws IOException {
        Response responseProceed = chain.proceed(request);
        String str = responseProceed.headers().get("SSA-CODE");
        return str != null ? k(chain, responseProceed, str, responseProceed.headers().get("BISID")) : responseProceed;
    }

    public final boolean f(String str) {
        return this.a.contains(str);
    }

    public boolean g(String str, String str2, String str3, b bVar) {
        try {
            if (!this.c && !f(UrlEncoderUtil.excludeUrlParams(str))) {
                return false;
            }
            boolean zOnIntercept = bVar.onIntercept(str, str2, str3);
            this.f690d.set(zOnIntercept);
            return zOnIntercept;
        } finally {
            this.b.unlock();
        }
    }

    public void h() {
        this.f690d.set(false);
    }

    public void i(boolean z) {
        this.c = z;
    }

    public void j(b bVar) {
        this.f691e = bVar;
    }

    public final Response k(Interceptor.Chain chain, Response response, String str, String str2) throws IOException {
        Request request = chain.request();
        if (!b().tryLock()) {
            b().lock();
            boolean zD = d();
            b().unlock();
            return zD ? chain.proceed(request.newBuilder().build()) : response;
        }
        h();
        if (!g(request.url().toString(), str, str2, c())) {
            return response;
        }
        Headers.Builder builderNewBuilder = request.headers().newBuilder();
        Headers headers = c().getHeaders();
        if (headers != null) {
            builderNewBuilder.addAll(headers);
        }
        Response responseProceed = chain.proceed(request.newBuilder().headers(builderNewBuilder.build()).build());
        String str3 = responseProceed.headers().get("SSA-CODE");
        return str3 != null ? k(chain, responseProceed, str3, str2) : responseProceed;
    }
}
