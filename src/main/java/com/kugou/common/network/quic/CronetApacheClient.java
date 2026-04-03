package com.kugou.common.network.quic;

import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.proxy.KGHttpProxy;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes2.dex */
public class CronetApacheClient implements HttpClient {

    public static class CronetResponseEntity {
        public int code;
        public List<Map.Entry<String, String>> headerList;
        public String message;
        public byte[] responseBytes = new byte[0];
        public ProtocolVersion protocolVersion = HttpVersion.HTTP_1_1;
    }

    private static void consumeContentQuietly(HttpResponse httpResponse) {
        try {
            httpResponse.getEntity().consumeContent();
        } catch (Throwable unused) {
        }
    }

    private HttpResponse doExecute(boolean z, int i2, AbsHttpClient.CronetCallWrapper cronetCallWrapper, HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, boolean z2) throws IOException {
        try {
            return transformResponse(CronetHandler.getInstance().request(z, cronetCallWrapper, httpHost, transformRequest(i2, httpRequest, z2)));
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static CronetReqBuilder transformRequest(int i2, HttpRequest httpRequest, boolean z) throws IOException {
        HttpEntity entity;
        RequestLine requestLine = httpRequest.getRequestLine();
        String method = requestLine.getMethod();
        String uri = requestLine.getUri();
        Header[] allHeaders = httpRequest.getAllHeaders();
        String value = null;
        for (Header header : allHeaders) {
            if ("Content-Type".equalsIgnoreCase(header.getName())) {
                value = header.getValue();
            }
        }
        CronetReqBuilder cronetReqBuilderBuild = new CronetReqBuilder().method(method).url(uri).setTimeOut(i2, z).headers(allHeaders).build();
        if ((httpRequest instanceof HttpEntityEnclosingRequest) && (entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity()) != null) {
            cronetReqBuilderBuild.body(new HttpEntityUploadProvider(entity, value));
        }
        return cronetReqBuilderBuild;
    }

    private static HttpResponse transformResponse(CronetResponseEntity cronetResponseEntity) {
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(cronetResponseEntity.protocolVersion, cronetResponseEntity.code, cronetResponseEntity.message);
        InputStreamEntity inputStreamEntity = new InputStreamEntity(new ByteArrayInputStream(cronetResponseEntity.responseBytes), cronetResponseEntity.responseBytes.length);
        basicHttpResponse.setEntity(inputStreamEntity);
        List<Map.Entry<String, String>> list = cronetResponseEntity.headerList;
        if (list != null) {
            for (Map.Entry<String, String> entry : list) {
                String key = entry.getKey();
                String value = entry.getValue();
                basicHttpResponse.addHeader(key, value);
                if ("Content-Type".equalsIgnoreCase(key)) {
                    inputStreamEntity.setContentType(value);
                } else if (HTTP.CONTENT_ENCODING.equalsIgnoreCase(key)) {
                    inputStreamEntity.setContentEncoding(value);
                }
            }
        }
        return basicHttpResponse;
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return execute((HttpHost) null, httpUriRequest, (HttpContext) null);
    }

    public HttpResponse executeWithCall(boolean z, int i2, AbsHttpClient.CronetCallWrapper cronetCallWrapper, KGHttpProxy kGHttpProxy, HttpUriRequest httpUriRequest, boolean z2) throws IOException {
        return doExecute(z, i2, cronetCallWrapper, kGHttpProxy == null ? null : kGHttpProxy.getHttpHost(), httpUriRequest, null, z2);
    }

    @Override // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        return new AbstractHttpParams() { // from class: com.kugou.common.network.quic.CronetApacheClient.1
            @Override // org.apache.http.params.HttpParams
            public HttpParams copy() {
                throw new UnsupportedOperationException();
            }

            @Override // org.apache.http.params.HttpParams
            public Object getParameter(String str) {
                throw new IllegalArgumentException(str);
            }

            @Override // org.apache.http.params.HttpParams
            public boolean removeParameter(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // org.apache.http.params.HttpParams
            public HttpParams setParameter(String str, Object obj) {
                throw new IllegalArgumentException(str);
            }
        };
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
        return doExecute(false, 0, null, httpHost, httpRequest, httpContext, false);
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
