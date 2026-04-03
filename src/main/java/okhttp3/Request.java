package okhttp3;

import java.net.Proxy;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;

/* JADX INFO: loaded from: classes2.dex */
public final class Request {
    public final RequestBody body;
    private volatile CacheControl cacheControl;
    public final Headers headers;
    private boolean isQuicRequest;
    private boolean isSupportSSA;
    private final String jsonScheme;
    public final String method;
    private final Dns privateDns;
    private final boolean proxyEnable;
    private Proxy requestProxy;
    public final Map<Class<?>, Object> tags;
    public final HttpUrl url;

    public static class Builder {
        public RequestBody body;
        public Headers.Builder headers;
        public boolean isQuicRequest;
        public boolean isSupportSSA;
        public String jsonScheme;
        public String method;
        public Dns privateDns;
        public boolean proxyEnable;
        public Map<Class<?>, Object> tags;
        public HttpUrl url;

        public Builder() {
            this.isQuicRequest = false;
            this.isSupportSSA = false;
            this.proxyEnable = true;
            this.tags = Collections.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
            this.isQuicRequest = false;
            this.isSupportSSA = false;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String string = cacheControl.toString();
            return string.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public Builder delete(RequestBody requestBody) {
            return method(HttpDelete.METHOD_NAME, requestBody);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method(HttpHead.METHOD_NAME, null);
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder isQuic(boolean z) {
            this.isQuicRequest = z;
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder privateDns(Dns dns) {
            this.privateDns = dns;
            return this;
        }

        public Builder proxyEnable(boolean z) {
            this.proxyEnable = z;
            return this;
        }

        public Builder put(RequestBody requestBody) {
            return method(HttpPut.METHOD_NAME, requestBody);
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder setJsonScheme(String str) {
            this.jsonScheme = str;
            return this;
        }

        public Builder setSupportSSA(boolean z) {
            this.isSupportSSA = z;
            return this;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "url == null");
            this.url = httpUrl;
            return this;
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public <T> Builder tag(Class<? super T> cls, T t) {
            Objects.requireNonNull(cls, "type == null");
            if (t == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                this.tags.put(cls, cls.cast(t));
            }
            return this;
        }

        public Builder url(String str) {
            Objects.requireNonNull(str, "url == null");
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return url(HttpUrl.get(str));
        }

        public Builder url(URL url) {
            Objects.requireNonNull(url, "url == null");
            return url(HttpUrl.get(url.toString()));
        }

        public Builder(Request request) {
            Map<Class<?>, Object> linkedHashMap;
            this.isQuicRequest = false;
            this.isSupportSSA = false;
            this.proxyEnable = true;
            this.tags = Collections.emptyMap();
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            if (request.tags.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(request.tags);
            }
            this.tags = linkedHashMap;
            this.headers = request.headers.newBuilder();
            this.isQuicRequest = request.isQuicRequest;
            this.isSupportSSA = request.isSupportSSA;
            this.proxyEnable = request.proxyEnable;
            this.jsonScheme = request.jsonScheme;
            this.privateDns = request.privateDns;
        }
    }

    public Request(Builder builder) {
        this.isQuicRequest = false;
        this.isSupportSSA = false;
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.tags = Util.immutableMap(builder.tags);
        this.isQuicRequest = builder.isQuicRequest;
        this.isSupportSSA = builder.isSupportSSA;
        this.proxyEnable = builder.proxyEnable;
        this.jsonScheme = builder.jsonScheme;
        this.privateDns = builder.privateDns;
    }

    public RequestBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.parse(this.headers);
        this.cacheControl = cacheControl2;
        return cacheControl2;
    }

    public String getJsonScheme() {
        return this.jsonScheme;
    }

    public Proxy getRequestProxy() {
        return this.requestProxy;
    }

    public String header(String str) {
        return this.headers.get(str);
    }

    public Headers headers() {
        return this.headers;
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public boolean isProxyEnable() {
        return this.proxyEnable;
    }

    public boolean isQuicRequest() {
        return this.isQuicRequest;
    }

    public boolean isSupportSSA() {
        return this.isSupportSSA;
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Dns privateDns() {
        return this.privateDns;
    }

    public void setRequestProxy(Proxy proxy) {
        this.requestProxy = proxy;
    }

    public Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    public HttpUrl url() {
        return this.url;
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }
}
