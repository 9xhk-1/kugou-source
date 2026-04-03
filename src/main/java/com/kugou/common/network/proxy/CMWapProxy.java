package com.kugou.common.network.proxy;

import android.content.Context;
import com.kugou.common.network.NetModeControler;
import com.kugou.common.network.networkutils.KGNetworkUtil;
import com.kugou.common.network.protocol.RequestPackage;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.HeaderGroup;

/* JADX INFO: loaded from: classes2.dex */
public class CMWapProxy implements KGHttpProxy {
    private boolean isTryAgain = true;
    private HeaderGroup mHeaderGroup;
    private HttpHost mHttpHost;

    public CMWapProxy(HttpHost httpHost, HeaderGroup headerGroup) {
        this.mHttpHost = httpHost;
        this.mHeaderGroup = headerGroup;
    }

    public static KGHttpProxy newInstance(Context context) {
        if (KGNetworkUtil.isCmwap(context)) {
            return new CMWapProxy(new HttpHost(NetModeControler.CMWAP_PROXY, 80, "http"), new HeaderGroup());
        }
        return null;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public boolean canRetry() {
        boolean z = !this.isTryAgain;
        this.isTryAgain = z;
        return z;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public boolean canUseProxy() {
        return true;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public HeaderGroup getHeaderGroup() {
        return this.mHeaderGroup;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public HttpHost getHttpHost() {
        return this.mHttpHost;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public ProxyWrapper getProxyWrapper() {
        return null;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public ReverseProxyHost getReverseProxyHost() {
        return null;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public boolean isHttpsEnableProxy() {
        return false;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public boolean onHeadersHandled(HttpUriRequest httpUriRequest) {
        return true;
    }

    @Override // com.kugou.common.network.proxy.KGHttpProxy
    public KGHttpProxy onProxyFailAfterConnected(RequestPackage requestPackage, HttpResponse httpResponse, HttpClient httpClient) throws Exception {
        return null;
    }
}
