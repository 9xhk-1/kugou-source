package com.kugou.common.network;

import android.util.Pair;
import com.kugou.common.network.proxy.ProxyAuthenticator;
import com.kugou.common.network.proxy.SocksProxy;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes2.dex */
public final class EventListenerProxy extends EventListener {
    private EventListener eventListenerProxyImpl;
    private EventListener ipv6ClientListenerInfo;

    public static class Holder {
        public static final EventListenerProxy INSTANCE = new EventListenerProxy();

        private Holder() {
        }
    }

    public static EventListenerProxy getInstance() {
        return Holder.INSTANCE;
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        EventListener eventListener = this.eventListenerProxyImpl;
        if (eventListener != null) {
            eventListener.callFailed(call, iOException);
        }
        EventListener eventListener2 = this.ipv6ClientListenerInfo;
        if (eventListener2 != null) {
            eventListener2.callFailed(call, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        EventListener eventListener = this.eventListenerProxyImpl;
        if (eventListener != null) {
            eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
        EventListener eventListener2 = this.ipv6ClientListenerInfo;
        if (eventListener2 != null) {
            eventListener2.connectEnd(call, inetSocketAddress, proxy, protocol);
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        EventListener eventListener = this.eventListenerProxyImpl;
        if (eventListener != null) {
            eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
        EventListener eventListener2 = this.ipv6ClientListenerInfo;
        if (eventListener2 != null) {
            eventListener2.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        EventListener eventListener = this.eventListenerProxyImpl;
        if (eventListener != null) {
            eventListener.connectStart(call, inetSocketAddress, proxy);
        }
        EventListener eventListener2 = this.ipv6ClientListenerInfo;
        if (eventListener2 != null) {
            eventListener2.connectStart(call, inetSocketAddress, proxy);
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        EventListener eventListener = this.eventListenerProxyImpl;
        if (eventListener != null) {
            eventListener.connectionAcquired(call, connection);
        }
        EventListener eventListener2 = this.ipv6ClientListenerInfo;
        if (eventListener2 != null) {
            eventListener2.connectionAcquired(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        EventListener eventListener = this.eventListenerProxyImpl;
        if (eventListener != null) {
            eventListener.dnsEnd(call, str, list);
        }
        EventListener eventListener2 = this.ipv6ClientListenerInfo;
        if (eventListener2 != null) {
            eventListener2.dnsEnd(call, str, list);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        EventListener eventListener = this.eventListenerProxyImpl;
        if (eventListener != null) {
            eventListener.dnsStart(call, str);
        }
        EventListener eventListener2 = this.ipv6ClientListenerInfo;
        if (eventListener2 != null) {
            eventListener2.dnsStart(call, str);
        }
    }

    public EventListenerProxy rebuild() {
        this.ipv6ClientListenerInfo = Ipv6ClientListenerInfo.init().getInitIpv6EventListener();
        return this;
    }

    private EventListenerProxy() {
        this.eventListenerProxyImpl = new EventListener() { // from class: com.kugou.common.network.EventListenerProxy.1
            @Override // okhttp3.EventListener
            public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
                InetAddress address;
                if (inetSocketAddress != null && (address = inetSocketAddress.getAddress()) != null) {
                    OKHttpManager.sThreadLocal.set(address.getHostAddress());
                }
                ProxyAuthenticator.getInstance().clearCredentials();
            }

            @Override // okhttp3.EventListener
            public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
                InetAddress address;
                if (inetSocketAddress != null && (address = inetSocketAddress.getAddress()) != null) {
                    OKHttpManager.sThreadLocal.set(address.getHostAddress());
                }
                ProxyAuthenticator.getInstance().clearCredentials();
            }

            @Override // okhttp3.EventListener
            public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                super.connectStart(call, inetSocketAddress, proxy);
                if (proxy instanceof SocksProxy) {
                    SocksProxy socksProxy = (SocksProxy) proxy;
                    Pair<String, String> authenticatorByProxy = ProxyAuthenticator.getInstance().getAuthenticatorByProxy(socksProxy.getHostname(), socksProxy.getPort());
                    if (authenticatorByProxy != null) {
                        ProxyAuthenticator.getInstance().setCredentials((String) authenticatorByProxy.first, (String) authenticatorByProxy.second);
                    }
                }
            }

            @Override // okhttp3.EventListener
            public void connectionAcquired(Call call, Connection connection) {
                InetAddress address;
                super.connectionAcquired(call, connection);
                if (connection == null || connection.route() == null || connection.route().socketAddress() == null || (address = connection.route().socketAddress().getAddress()) == null) {
                    return;
                }
                OKHttpManager.sConnectionIpAcquired.set(address.getHostAddress());
            }
        };
    }
}
