package com.kugou.android.watch.lite.common.network.http;

import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.android.watch.lite.common.network.KGHttpVariables;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.f.k.h.a;
import e.c.a.g.a.s.l1;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class RetrofitRequestInterceptor implements Interceptor, INoGuard {
    private boolean isDisableConnection;

    public RetrofitRequestInterceptor() {
        this.isDisableConnection = false;
        if (l1.f0()) {
            this.isDisableConnection = c.c().getConfigAsBoolean(b.D2, true);
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Headers.Builder builderNewBuilder = request.headers().newBuilder();
        if (KGHttpVariables.getInstance().getRec() < 3) {
            builderNewBuilder.add("KG-Rec", String.valueOf(KGHttpVariables.getInstance().getRec()));
        }
        if (this.isDisableConnection) {
            builderNewBuilder.set(HTTP.CONN_DIRECTIVE, "close");
        }
        return a.a().e(chain, request.newBuilder().headers(builderNewBuilder.build()).build());
    }
}
