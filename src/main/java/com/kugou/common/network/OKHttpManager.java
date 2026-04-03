package com.kugou.common.network;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.proxy.KGHttpProxy;
import com.kugou.common.network.proxy.ProxyAuthenticator;
import com.kugou.common.network.proxy.ProxyUtils;
import com.kugou.common.network.proxy.ProxyWrapper;
import java.net.Authenticator;
import java.security.GeneralSecurityException;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionPool;
import okhttp3.KGOKHttpClientExt;
import okhttp3.OkHttpClient;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public class OKHttpManager {
    public static final String GATEWAY_KEY = "gateway";
    private static final int MIN_TIMEOUT = 5000;
    private static int dftConnectTimeOut;
    private static int dftSeparateConnectTimeOut;
    private static int dftSeparateConnectWriteTimeOut;
    private static int dftWriteTimeOut;
    private static volatile OkHttpClient firstCustomTimeoutSeparateConnectionHttpClient;
    private static int proxyConfigHashCode;
    private static volatile OkHttpClient proxyGatewayHttpClient;
    private static volatile OkHttpClient proxyHttpClient;
    private static volatile OkHttpClient proxySeparateConnectionHttpClient;
    private static ConnectionPool sGlobalSeparateConnectionPool;
    private static volatile boolean sHasInitSeparateConnectionParameters;
    private static volatile int sMaxIdleSeparateConnectionCount;
    private static boolean sShouldCacheCustomTimeoutHttpClient;
    private static SSLSocketFactory separateConnectionSslSocketFactory;
    private static X509TrustManager separateConnectionTrustManager;
    private static int separateProxyConfigHashCode;
    private static volatile OkHttpClient unProxyGatewayHttpClient;
    private static volatile OkHttpClient unProxyHttpClient;
    private static volatile OkHttpClient unProxySeparateConnectionHttpClient;
    public static ConnectionPool sGlobalHttpDftTimeOutConnectionPool = new ConnectionPool(5, 10, TimeUnit.SECONDS);
    public static ConnectionPool gatewayConnectionPool = new ConnectionPool(2, 5, TimeUnit.MINUTES);
    public static final ThreadLocal<String> sThreadLocal = new ThreadLocal<>();
    public static final ThreadLocal<String> sConnectionIpAcquired = new ThreadLocal<>();

    static {
        Authenticator.setDefault(ProxyAuthenticator.getInstance());
    }

    private static OkHttpClient.Builder getCustomTimeoutClientBuilder(int i2, int i3, @Nullable KGHttpProxy kGHttpProxy) {
        OkHttpClient.Builder builderOnlyCallByKGHttpClient2 = KGOKHttpClientExt.onlyCallByKGHttpClient2();
        long j = i2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder builderConnectTimeout = builderOnlyCallByKGHttpClient2.connectTimeout(j, timeUnit);
        long j2 = i3;
        OkHttpClient.Builder builderWriteTimeout = builderConnectTimeout.readTimeout(j2, timeUnit).writeTimeout(j2, timeUnit);
        initBuilderProxy(kGHttpProxy, builderWriteTimeout);
        builderWriteTimeout.dns(Ipv6ClientListenerInfo.init().getInitIpv6Dns());
        builderWriteTimeout.eventListener(EventListenerProxy.getInstance().rebuild());
        builderWriteTimeout.connectIpv6Timeout(500L, timeUnit);
        return builderWriteTimeout;
    }

    private static ConnectionPool getGlobalSeparateConnectionPool() {
        if (sGlobalSeparateConnectionPool == null) {
            sGlobalSeparateConnectionPool = new ConnectionPool(Math.max(2, Math.min(15, sMaxIdleSeparateConnectionCount)), 5L, TimeUnit.MINUTES);
        }
        return sGlobalSeparateConnectionPool;
    }

    public static synchronized OkHttpClient getHttpsClient(String str, boolean z, int i2, int i3, boolean z2, @Nullable KGHttpProxy kGHttpProxy, long j, boolean z3, boolean z4) {
        int i4;
        int i5;
        int i6 = i2;
        synchronized (OKHttpManager.class) {
            if (i6 < 10000 || i3 < 10000) {
                NetLog.d("the timeout value was set too short!");
            }
            if (z4) {
                if (i6 <= 0) {
                    i6 = 5000;
                }
                if (i3 <= 0) {
                    i4 = i6;
                    i5 = 5000;
                }
                i4 = i6;
                i5 = i3;
            } else {
                if (i6 < 5000) {
                    i6 = 5000;
                }
                if (i3 < 5000) {
                    i4 = i6;
                    i5 = 5000;
                } else {
                    i4 = i6;
                    i5 = i3;
                }
            }
            if (!z) {
                return getOkHttpClient(str, i4, i5, z2, kGHttpProxy, j, z3);
            }
            OkHttpClient.Builder separateConnectionCustomTimeoutClientBuilder = (sHasInitSeparateConnectionParameters && z3) ? getSeparateConnectionCustomTimeoutClientBuilder(i4, i5, kGHttpProxy, z2, j) : getCustomTimeoutClientBuilder(i4, i5, kGHttpProxy);
            if (sHasInitSeparateConnectionParameters && z3) {
                separateConnectionCustomTimeoutClientBuilder.connectionPool(getGlobalSeparateConnectionPool());
            } else {
                separateConnectionCustomTimeoutClientBuilder.connectionPool(sGlobalHttpDftTimeOutConnectionPool);
            }
            if (!sHasInitSeparateConnectionParameters || !z3) {
                return separateConnectionCustomTimeoutClientBuilder.build();
            }
            OkHttpClient okHttpClientBuild = separateConnectionCustomTimeoutClientBuilder.build();
            if (sShouldCacheCustomTimeoutHttpClient) {
                firstCustomTimeoutSeparateConnectionHttpClient = okHttpClientBuild;
                sShouldCacheCustomTimeoutHttpClient = false;
            }
            return okHttpClientBuild;
        }
    }

    private static OkHttpClient getOkHttpClient(String str, int i2, int i3, boolean z, @Nullable KGHttpProxy kGHttpProxy, long j, boolean z2) {
        boolean z3 = kGHttpProxy == null || !z;
        if (str.contains(GATEWAY_KEY)) {
            if (z3) {
                if (unProxyGatewayHttpClient == null) {
                    initGatewayHttpClient(null);
                }
                return unProxyGatewayHttpClient;
            }
            if (proxyGatewayHttpClient == null || isDiffProxy(kGHttpProxy)) {
                initGatewayHttpClient(kGHttpProxy);
            }
            return proxyGatewayHttpClient;
        }
        if (sHasInitSeparateConnectionParameters && z2) {
            if (z3) {
                if (unProxySeparateConnectionHttpClient == null || dftSeparateConnectTimeOut != i2 || dftSeparateConnectWriteTimeOut != i3) {
                    initSeparateConnectionUnProxyHttpClient(i2, i3, j);
                }
                return unProxySeparateConnectionHttpClient;
            }
            if (proxySeparateConnectionHttpClient == null || isDiffSeparateConnectProxy(kGHttpProxy) || dftSeparateConnectTimeOut != i2 || dftSeparateConnectWriteTimeOut != i3) {
                initSeparateConnectionProxyHttpClient(i2, i3, kGHttpProxy, j);
            }
            return proxySeparateConnectionHttpClient;
        }
        if (z3) {
            if (unProxyHttpClient == null || dftConnectTimeOut != i2 || dftWriteTimeOut != i3) {
                initUnProxyHttpClient(i2, i3);
            }
            return unProxyHttpClient;
        }
        if (proxyHttpClient == null || isDiffProxy(kGHttpProxy) || dftConnectTimeOut != i2 || dftWriteTimeOut != i3) {
            initProxyHttpClient(i2, i3, kGHttpProxy);
        }
        return proxyHttpClient;
    }

    private static OkHttpClient.Builder getSeparateConnectionCustomTimeoutClientBuilder(int i2, int i3, @Nullable KGHttpProxy kGHttpProxy, boolean z, long j) {
        OkHttpClient.Builder builderOnlyCallByKGHttpClient2;
        OkHttpClient okHttpClient = (kGHttpProxy == null || !z) ? unProxySeparateConnectionHttpClient : proxySeparateConnectionHttpClient;
        if (okHttpClient == null) {
            okHttpClient = firstCustomTimeoutSeparateConnectionHttpClient;
        }
        sShouldCacheCustomTimeoutHttpClient = false;
        if (okHttpClient == null) {
            builderOnlyCallByKGHttpClient2 = KGOKHttpClientExt.onlyCallByKGHttpClient2();
            SSLSocketFactory separateConnectionSslSocketFactory2 = getSeparateConnectionSslSocketFactory();
            X509TrustManager separateConnectionTrustManager2 = getSeparateConnectionTrustManager();
            if (separateConnectionSslSocketFactory2 != null && separateConnectionTrustManager2 != null) {
                builderOnlyCallByKGHttpClient2.sslSocketFactory(separateConnectionSslSocketFactory2, separateConnectionTrustManager2);
            }
            sShouldCacheCustomTimeoutHttpClient = true;
        } else {
            builderOnlyCallByKGHttpClient2 = KGOKHttpClientExt.onlyCallByKGHttpClient2(okHttpClient);
        }
        long j2 = i2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j3 = i3;
        builderOnlyCallByKGHttpClient2.connectTimeout(j2, timeUnit).readTimeout(j3, timeUnit).writeTimeout(j3, timeUnit);
        if (j > 0) {
            builderOnlyCallByKGHttpClient2.pingInterval(j, timeUnit);
        } else {
            builderOnlyCallByKGHttpClient2.pingInterval(0L, timeUnit);
        }
        initBuilderProxy(kGHttpProxy, builderOnlyCallByKGHttpClient2);
        builderOnlyCallByKGHttpClient2.dns(Ipv6ClientListenerInfo.init().getInitIpv6Dns());
        builderOnlyCallByKGHttpClient2.eventListener(EventListenerProxy.getInstance().rebuild());
        builderOnlyCallByKGHttpClient2.connectIpv6Timeout(500L, timeUnit);
        return builderOnlyCallByKGHttpClient2;
    }

    private static SSLSocketFactory getSeparateConnectionSslSocketFactory() {
        X509TrustManager separateConnectionTrustManager2;
        if (separateConnectionSslSocketFactory == null && (separateConnectionTrustManager2 = getSeparateConnectionTrustManager()) != null) {
            separateConnectionSslSocketFactory = newSslSocketFactory(separateConnectionTrustManager2);
        }
        return separateConnectionSslSocketFactory;
    }

    private static X509TrustManager getSeparateConnectionTrustManager() {
        if (separateConnectionTrustManager == null) {
            try {
                separateConnectionTrustManager = Util.platformTrustManager();
            } catch (Throwable unused) {
            }
        }
        return separateConnectionTrustManager;
    }

    public static boolean hasInitSeparateConnectionParameters() {
        return sHasInitSeparateConnectionParameters;
    }

    private static void initBuilderProxy(@Nullable KGHttpProxy kGHttpProxy, OkHttpClient.Builder builder) {
        ProxyWrapper proxyWrapper;
        if (kGHttpProxy == null || (proxyWrapper = kGHttpProxy.getProxyWrapper()) == null) {
            builder.proxy(null);
            return;
        }
        proxyConfigHashCode = proxyWrapper.hashCode();
        separateProxyConfigHashCode = proxyWrapper.hashCode();
        HttpHost httpHost = proxyWrapper.getHttpHost();
        builder.proxy(ProxyUtils.createProxy(proxyWrapper, httpHost));
        if (proxyWrapper.isNeedAuthorization()) {
            ProxyWrapper.ProxyAuthorization proxyAuthorization = proxyWrapper.getProxyAuthorization();
            ProxyAuthenticator.getInstance().setProxy(httpHost.getHostName(), httpHost.getPort(), proxyAuthorization.getUserName(), proxyAuthorization.getPassWd());
        }
    }

    private static void initGatewayHttpClient(KGHttpProxy kGHttpProxy) {
        boolean z = kGHttpProxy != null;
        OkHttpClient.Builder builderOnlyCallByKGHttpClient2 = KGOKHttpClientExt.onlyCallByKGHttpClient2();
        initBuilderProxy(kGHttpProxy, builderOnlyCallByKGHttpClient2);
        builderOnlyCallByKGHttpClient2.dns(Ipv6ClientListenerInfo.init().getInitIpv6Dns());
        builderOnlyCallByKGHttpClient2.eventListener(EventListenerProxy.getInstance().rebuild());
        builderOnlyCallByKGHttpClient2.connectIpv6Timeout(500L, TimeUnit.MILLISECONDS);
        if (z) {
            proxyGatewayHttpClient = builderOnlyCallByKGHttpClient2.connectionPool(gatewayConnectionPool).build();
        } else {
            unProxyGatewayHttpClient = builderOnlyCallByKGHttpClient2.connectionPool(gatewayConnectionPool).build();
        }
    }

    private static void initProxyHttpClient(int i2, int i3, @NonNull KGHttpProxy kGHttpProxy) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j = i3;
        OkHttpClient.Builder builderWriteTimeout = KGOKHttpClientExt.onlyCallByKGHttpClient2().connectTimeout(i2, timeUnit).readTimeout(j, timeUnit).writeTimeout(j, timeUnit);
        dftConnectTimeOut = i2;
        dftWriteTimeOut = i3;
        initBuilderProxy(kGHttpProxy, builderWriteTimeout);
        builderWriteTimeout.dns(Ipv6ClientListenerInfo.init().getInitIpv6Dns());
        builderWriteTimeout.eventListener(EventListenerProxy.getInstance().rebuild());
        builderWriteTimeout.connectIpv6Timeout(500L, timeUnit);
        if (proxyHttpClient != null) {
            proxyHttpClient.dispatcher().executorService().shutdown();
        }
        proxyHttpClient = builderWriteTimeout.connectionPool(sGlobalHttpDftTimeOutConnectionPool).build();
    }

    public static void initSeparateConnectionParameters(int i2) {
        if (sHasInitSeparateConnectionParameters) {
            return;
        }
        synchronized (OKHttpManager.class) {
            if (!sHasInitSeparateConnectionParameters) {
                sMaxIdleSeparateConnectionCount = i2;
                sHasInitSeparateConnectionParameters = true;
            }
        }
    }

    private static void initSeparateConnectionProxyHttpClient(int i2, int i3, @NonNull KGHttpProxy kGHttpProxy, long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j2 = i3;
        OkHttpClient.Builder builderWriteTimeout = KGOKHttpClientExt.onlyCallByKGHttpClient2().connectTimeout(i2, timeUnit).readTimeout(j2, timeUnit).writeTimeout(j2, timeUnit);
        dftSeparateConnectTimeOut = i2;
        dftSeparateConnectWriteTimeOut = i3;
        initBuilderProxy(kGHttpProxy, builderWriteTimeout);
        builderWriteTimeout.dns(Ipv6ClientListenerInfo.init().getInitIpv6Dns());
        builderWriteTimeout.eventListener(EventListenerProxy.getInstance().rebuild());
        builderWriteTimeout.connectIpv6Timeout(500L, timeUnit);
        if (proxySeparateConnectionHttpClient != null) {
            proxySeparateConnectionHttpClient.dispatcher().executorService().shutdown();
        }
        if (j > 0) {
            builderWriteTimeout.pingInterval(j, timeUnit);
        }
        SSLSocketFactory separateConnectionSslSocketFactory2 = getSeparateConnectionSslSocketFactory();
        X509TrustManager separateConnectionTrustManager2 = getSeparateConnectionTrustManager();
        if (separateConnectionSslSocketFactory2 != null && separateConnectionTrustManager2 != null) {
            builderWriteTimeout.sslSocketFactory(separateConnectionSslSocketFactory2, separateConnectionTrustManager2);
        }
        proxySeparateConnectionHttpClient = builderWriteTimeout.connectionPool(getGlobalSeparateConnectionPool()).build();
    }

    private static void initSeparateConnectionUnProxyHttpClient(int i2, int i3, long j) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j2 = i3;
        OkHttpClient.Builder builderWriteTimeout = KGOKHttpClientExt.onlyCallByKGHttpClient2().connectTimeout(i2, timeUnit).readTimeout(j2, timeUnit).writeTimeout(j2, timeUnit);
        dftSeparateConnectTimeOut = i2;
        dftSeparateConnectWriteTimeOut = i3;
        builderWriteTimeout.dns(Ipv6ClientListenerInfo.init().getInitIpv6Dns());
        builderWriteTimeout.eventListener(EventListenerProxy.getInstance().rebuild());
        builderWriteTimeout.connectIpv6Timeout(500L, timeUnit);
        if (j > 0) {
            builderWriteTimeout.pingInterval(j, timeUnit);
        }
        SSLSocketFactory separateConnectionSslSocketFactory2 = getSeparateConnectionSslSocketFactory();
        X509TrustManager separateConnectionTrustManager2 = getSeparateConnectionTrustManager();
        if (separateConnectionSslSocketFactory2 != null && separateConnectionTrustManager2 != null) {
            builderWriteTimeout.sslSocketFactory(separateConnectionSslSocketFactory2, separateConnectionTrustManager2);
        }
        unProxySeparateConnectionHttpClient = builderWriteTimeout.connectionPool(getGlobalSeparateConnectionPool()).build();
    }

    private static void initUnProxyHttpClient(int i2, int i3) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long j = i3;
        OkHttpClient.Builder builderWriteTimeout = KGOKHttpClientExt.onlyCallByKGHttpClient2().connectTimeout(i2, timeUnit).readTimeout(j, timeUnit).writeTimeout(j, timeUnit);
        dftConnectTimeOut = i2;
        dftWriteTimeOut = i3;
        builderWriteTimeout.dns(Ipv6ClientListenerInfo.init().getInitIpv6Dns());
        builderWriteTimeout.eventListener(EventListenerProxy.getInstance().rebuild());
        builderWriteTimeout.connectIpv6Timeout(500L, timeUnit);
        unProxyHttpClient = builderWriteTimeout.connectionPool(sGlobalHttpDftTimeOutConnectionPool).build();
    }

    private static boolean isDiffProxy(KGHttpProxy kGHttpProxy) {
        if (kGHttpProxy != null) {
            return proxyConfigHashCode != kGHttpProxy.getProxyWrapper().hashCode();
        }
        if (proxyConfigHashCode == 0) {
            return false;
        }
        proxyConfigHashCode = 0;
        return true;
    }

    private static boolean isDiffSeparateConnectProxy(KGHttpProxy kGHttpProxy) {
        if (kGHttpProxy != null) {
            return separateProxyConfigHashCode != kGHttpProxy.getProxyWrapper().hashCode();
        }
        if (separateProxyConfigHashCode == 0) {
            return false;
        }
        separateProxyConfigHashCode = 0;
        return true;
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }
}
