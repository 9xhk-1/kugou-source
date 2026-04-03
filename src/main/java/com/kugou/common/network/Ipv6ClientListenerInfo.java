package com.kugou.common.network;

import android.support.annotation.Nullable;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes2.dex */
public class Ipv6ClientListenerInfo {
    public static final int CONNECT_IPV6_TIMEOUT = 500;
    public static Ipv6ClientListenerInfo INSTANCE;
    public Dns initIpv6Dns = new Dns() { // from class: com.kugou.common.network.Ipv6ClientListenerInfo.1
        @Override // okhttp3.Dns
        public List<InetAddress> lookup(String str) throws UnknownHostException {
            return IPUtil.sortAddress(str);
        }
    };
    public EventListener initIpv6EventListener = new EventListener() { // from class: com.kugou.common.network.Ipv6ClientListenerInfo.2
        @Override // okhttp3.EventListener
        public void callEnd(Call call) {
            super.callEnd(call);
        }

        @Override // okhttp3.EventListener
        public void callFailed(Call call, IOException iOException) {
            super.callFailed(call, iOException);
        }

        @Override // okhttp3.EventListener
        public void callStart(Call call) {
            super.callStart(call);
        }

        @Override // okhttp3.EventListener
        public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol);
        }

        @Override // okhttp3.EventListener
        public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, @Nullable Protocol protocol, IOException iOException) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }

        @Override // okhttp3.EventListener
        public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
            super.connectStart(call, inetSocketAddress, proxy);
        }

        @Override // okhttp3.EventListener
        public void connectionAcquired(Call call, Connection connection) {
            super.connectionAcquired(call, connection);
        }

        @Override // okhttp3.EventListener
        public void connectionReleased(Call call, Connection connection) {
            super.connectionReleased(call, connection);
        }

        @Override // okhttp3.EventListener
        public void dnsEnd(Call call, String str, List<InetAddress> list) {
            super.dnsEnd(call, str, list);
        }

        @Override // okhttp3.EventListener
        public void dnsStart(Call call, String str) {
            super.dnsStart(call, str);
        }

        @Override // okhttp3.EventListener
        public void requestHeadersStart(Call call) {
            super.requestHeadersStart(call);
        }

        @Override // okhttp3.EventListener
        public void secureConnectEnd(Call call, Handshake handshake) {
            super.secureConnectEnd(call, handshake);
        }

        @Override // okhttp3.EventListener
        public void secureConnectStart(Call call) {
            super.secureConnectStart(call);
        }
    };

    public static Ipv6ClientListenerInfo init() {
        if (INSTANCE == null) {
            synchronized (Ipv6ClientListenerInfo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Ipv6ClientListenerInfo();
                }
            }
        }
        return INSTANCE;
    }

    public Dns getInitIpv6Dns() {
        return this.initIpv6Dns;
    }

    public EventListener getInitIpv6EventListener() {
        return this.initIpv6EventListener;
    }

    public void setInitIpv6Dns(Dns dns) {
        this.initIpv6Dns = dns;
    }

    public void setInitIpv6EventListener(EventListener eventListener) {
        this.initIpv6EventListener = eventListener;
    }
}
