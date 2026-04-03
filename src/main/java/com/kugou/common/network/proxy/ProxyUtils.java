package com.kugou.common.network.proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyUtils {
    public static Proxy createProxy(ProxyWrapper proxyWrapper, HttpHost httpHost) {
        if (proxyWrapper == null) {
            return null;
        }
        return proxyWrapper.getProxyType() == Proxy.Type.SOCKS ? new SocksProxy(httpHost.getHostName(), httpHost.getPort()) : new Proxy(proxyWrapper.getProxyType(), new InetSocketAddress(httpHost.getHostName(), httpHost.getPort()));
    }
}
