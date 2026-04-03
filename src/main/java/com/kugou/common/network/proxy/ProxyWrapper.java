package com.kugou.common.network.proxy;

import android.support.annotation.RequiresApi;
import java.net.Proxy;
import java.util.Objects;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
public final class ProxyWrapper {
    private HttpHost httpHost;
    private boolean needAuthorization;
    private ProxyAuthorization proxyAuthorization;
    private Proxy.Type proxyType;

    public static class ProxyAuthorization {
        private String passWd;
        private String userName;

        @RequiresApi(api = 19)
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ProxyAuthorization proxyAuthorization = (ProxyAuthorization) obj;
            if (Objects.equals(this.userName, proxyAuthorization.userName)) {
                return Objects.equals(this.passWd, proxyAuthorization.passWd);
            }
            return false;
        }

        public String getPassWd() {
            return this.passWd;
        }

        public String getUserName() {
            return this.userName;
        }

        public int hashCode() {
            String str = this.userName;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.passWd;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public void setPassWd(String str) {
            this.passWd = str;
        }

        public void setUserName(String str) {
            this.userName = str;
        }
    }

    @RequiresApi(api = 19)
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ProxyWrapper.class != obj.getClass()) {
            return false;
        }
        ProxyWrapper proxyWrapper = (ProxyWrapper) obj;
        if (this.needAuthorization == proxyWrapper.needAuthorization && Objects.equals(this.httpHost, proxyWrapper.httpHost) && this.proxyType == proxyWrapper.proxyType) {
            return Objects.equals(this.proxyAuthorization, proxyWrapper.proxyAuthorization);
        }
        return false;
    }

    public HttpHost getHttpHost() {
        return this.httpHost;
    }

    public ProxyAuthorization getProxyAuthorization() {
        return this.proxyAuthorization;
    }

    public Proxy.Type getProxyType() {
        return this.proxyType;
    }

    public int hashCode() {
        int i2 = (this.needAuthorization ? 1 : 0) * 31;
        HttpHost httpHost = this.httpHost;
        int iHashCode = (i2 + (httpHost != null ? httpHost.hashCode() : 0)) * 31;
        Proxy.Type type = this.proxyType;
        int iHashCode2 = (iHashCode + (type != null ? type.hashCode() : 0)) * 31;
        ProxyAuthorization proxyAuthorization = this.proxyAuthorization;
        return iHashCode2 + (proxyAuthorization != null ? proxyAuthorization.hashCode() : 0);
    }

    public boolean isNeedAuthorization() {
        return this.needAuthorization;
    }

    public void setHttpHost(HttpHost httpHost) {
        this.httpHost = httpHost;
    }

    public void setNeedAuthorization(boolean z) {
        this.needAuthorization = z;
    }

    public void setProxyAuthorization(ProxyAuthorization proxyAuthorization) {
        this.proxyAuthorization = proxyAuthorization;
    }

    public void setProxyType(Proxy.Type type) {
        this.proxyType = type;
    }
}
