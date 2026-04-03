package com.kugou.common.network;

import android.text.TextUtils;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.networkutils.UrlEncoderUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes2.dex */
public final class OkApacheClient implements HttpClient {
    private OkHttpClient client;
    private final HttpParams params = new AbstractHttpParams() { // from class: com.kugou.common.network.OkApacheClient.2
        @Override // org.apache.http.params.HttpParams
        public HttpParams copy() {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.http.params.HttpParams
        public Object getParameter(String str) {
            if (!str.equals(ConnRoutePNames.DEFAULT_PROXY)) {
                throw new IllegalArgumentException(str);
            }
            Proxy proxy = OkApacheClient.this.client.proxy();
            if (proxy == null) {
                return null;
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
            return new HttpHost(inetSocketAddress.getHostName(), inetSocketAddress.getPort());
        }

        @Override // org.apache.http.params.HttpParams
        public boolean removeParameter(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.http.params.HttpParams
        public HttpParams setParameter(String str, Object obj) {
            if (!str.equals(ConnRoutePNames.DEFAULT_PROXY)) {
                throw new IllegalArgumentException(str);
            }
            HttpHost httpHost = (HttpHost) obj;
            Proxy proxy = httpHost != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpHost.getHostName(), httpHost.getPort())) : null;
            OkApacheClient okApacheClient = OkApacheClient.this;
            okApacheClient.client = okApacheClient.client.newBuilder().proxy(proxy).build();
            return this;
        }
    };

    public OkApacheClient(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    private static void consumeContentQuietly(HttpResponse httpResponse) {
        try {
            httpResponse.getEntity().consumeContent();
        } catch (Throwable unused) {
        }
    }

    private HttpResponse doExecute(boolean z, AbsHttpClient.OKHttpCallWrapper oKHttpCallWrapper, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, byte[] bArr) throws IOException {
        Call callNewCall = this.client.newCall(transformRequest(z, httpRequest, bArr));
        if (oKHttpCallWrapper != null) {
            oKHttpCallWrapper.call = callNewCall;
        }
        return transformResponse(callNewCall.execute());
    }

    private static Request transformRequest(boolean z, HttpRequest httpRequest, final byte[] bArr) {
        Request.Builder builder = new Request.Builder();
        RequestLine requestLine = httpRequest.getRequestLine();
        String method = requestLine.getMethod();
        builder.url(requestLine.getUri());
        if (bArr != null) {
            builder.privateDns(new Dns() { // from class: com.kugou.common.network.OkApacheClient.1
                @Override // okhttp3.Dns
                public List<InetAddress> lookup(String str) throws UnknownHostException {
                    return Arrays.asList(InetAddress.getByAddress(str, bArr));
                }
            });
        }
        RequestBody httpEntityBody = null;
        String value = null;
        for (Header header : httpRequest.getAllHeaders()) {
            String name = header.getName();
            if ("Content-Type".equalsIgnoreCase(name)) {
                value = header.getValue();
            } else if (!TextUtils.isEmpty(header.getValue())) {
                if (UrlEncoderUtil.hasExpChar(header.getValue())) {
                    builder.header(name, UrlEncoderUtil.encodeHeadInfo(header.getValue()));
                } else {
                    builder.header(name, header.getValue());
                }
            }
        }
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity != null) {
                httpEntityBody = new HttpEntityBody(entity, value);
                Header contentEncoding = entity.getContentEncoding();
                if (contentEncoding != null) {
                    builder.header(contentEncoding.getName(), contentEncoding.getValue());
                }
            } else {
                httpEntityBody = Util.EMPTY_REQUEST;
            }
        }
        builder.method(method, httpEntityBody);
        return builder.build();
    }

    private static HttpResponse transformResponse(Response response) {
        InputStreamEntity inputStreamEntity;
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(HttpVersion.HTTP_1_1, response.code(), response.message());
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            inputStreamEntity = new InputStreamEntity(responseBodyBody.byteStream(), responseBodyBody.contentLength());
            basicHttpResponse.setEntity(inputStreamEntity);
        } else {
            inputStreamEntity = null;
        }
        Headers headers = response.headers();
        if (headers != null) {
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                String strName = headers.name(i2);
                String strValue = headers.value(i2);
                basicHttpResponse.addHeader(strName, strValue);
                if (inputStreamEntity != null) {
                    if ("Content-Type".equalsIgnoreCase(strName)) {
                        inputStreamEntity.setContentType(strValue);
                    } else if (HTTP.CONTENT_ENCODING.equalsIgnoreCase(strName)) {
                        inputStreamEntity.setContentEncoding(strValue);
                    }
                }
            }
        }
        return basicHttpResponse;
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return execute((HttpHost) null, httpUriRequest, (HttpContext) null);
    }

    public HttpResponse executeWithCall(boolean z, AbsHttpClient.OKHttpCallWrapper oKHttpCallWrapper, HttpUriRequest httpUriRequest, byte[] bArr) throws IOException {
        return doExecute(z, oKHttpCallWrapper, null, httpUriRequest, null, bArr);
    }

    @Override // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        return this.params;
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return execute((HttpHost) null, httpUriRequest, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        return doExecute(false, null, httpHost, httpRequest, httpContext, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) execute(null, httpUriRequest, responseHandler, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) execute(null, httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) execute(httpHost, httpRequest, responseHandler, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        HttpResponse httpResponseExecute = execute(httpHost, httpRequest, httpContext);
        try {
            return responseHandler.handleResponse(httpResponseExecute);
        } finally {
            consumeContentQuietly(httpResponseExecute);
        }
    }
}
