package com.kugou.common.network.quic;

import com.kugou.common.network.netgate.AckManager;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RealResponseBody;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: classes2.dex */
public class CronetOKClientInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (!request.isQuicRequest()) {
            return chain.proceed(request);
        }
        CronetHandler.getInstance().checkInitCronetEngine(AckManager.getAckVars().getContext(), true);
        HttpURLConnection httpURLConnection = (HttpURLConnection) CronetHandler.getInstance().getCronetEngineQuic().b(request.url().url());
        Headers headers = request.headers();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            httpURLConnection.addRequestProperty(headers.name(i2), headers.value(i2));
        }
        httpURLConnection.setRequestMethod(request.method());
        if (request.body() != null) {
            MediaType mediaTypeContentType = request.body().contentType();
            if (mediaTypeContentType != null) {
                httpURLConnection.setRequestProperty("Content-Type", mediaTypeContentType.toString());
            }
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(outputStream));
            request.body().writeTo(bufferedSinkBuffer);
            bufferedSinkBuffer.flush();
            outputStream.close();
        }
        Response.Builder builderMessage = new Response.Builder().request(request).protocol(Protocol.QUIC).code(httpURLConnection.getResponseCode()).message(httpURLConnection.getResponseMessage());
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            builderMessage.addHeader(entry.getKey(), entry.getValue().toString());
        }
        builderMessage.body(new RealResponseBody(httpURLConnection.getContentType(), httpURLConnection.getContentLength(), Okio.buffer(Okio.source(httpURLConnection.getInputStream()))));
        return builderMessage.build();
    }
}
