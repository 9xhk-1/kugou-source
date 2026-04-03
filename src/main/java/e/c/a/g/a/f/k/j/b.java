package e.c.a.g.a.f.k.j;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes.dex */
public class b implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        HttpUrl.Builder builderNewBuilder;
        Request request = chain.request();
        if (a.f694d != null) {
            HttpUrl httpUrlUrl = request.url();
            String string = httpUrlUrl.toString();
            for (a aVar : a.f694d) {
                String str = aVar.a;
                String str2 = aVar.b;
                String strHost = !TextUtils.isEmpty(aVar.c) ? aVar.c : httpUrlUrl.host();
                if (string.contains(str) && !TextUtils.isEmpty(str2) && (builderNewBuilder = httpUrlUrl.newBuilder(string.replace(str, str2))) != null) {
                    return chain.proceed(request.newBuilder().headers(request.headers().newBuilder().set(HTTP.TARGET_HOST, strHost).build()).url(builderNewBuilder.build()).build());
                }
            }
        }
        return chain.proceed(request);
    }
}
