package com.kugou.common.network.proxy;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class SocksProxy extends Proxy {
    private String hostname;
    private int port;

    public SocksProxy(String str, int i2) {
        super(Proxy.Type.SOCKS, new InetSocketAddress(str, i2));
        this.hostname = str;
        this.port = i2;
    }

    public String getHostname() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }
}
