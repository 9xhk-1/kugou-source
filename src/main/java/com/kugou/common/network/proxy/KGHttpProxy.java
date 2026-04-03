package com.kugou.common.network.proxy;

import com.kugou.common.network.protocol.RequestPackage;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.HeaderGroup;

/* JADX INFO: loaded from: classes.dex */
public interface KGHttpProxy {
    public static final String X_HOST_KEY = "X-Host";
    public static final String X_REAL_HOST_KEY = "X-Real-Host";

    boolean canRetry();

    boolean canUseProxy();

    HeaderGroup getHeaderGroup();

    @Deprecated
    HttpHost getHttpHost();

    ProxyWrapper getProxyWrapper();

    ReverseProxyHost getReverseProxyHost();

    boolean isHttpsEnableProxy();

    boolean onHeadersHandled(HttpUriRequest httpUriRequest);

    KGHttpProxy onProxyFailAfterConnected(RequestPackage requestPackage, HttpResponse httpResponse, HttpClient httpClient) throws Exception;
}
