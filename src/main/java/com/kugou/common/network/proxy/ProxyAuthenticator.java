package com.kugou.common.network.proxy;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ProxyAuthenticator {

    public static class Holder {
        public static final ThreadLocalProxyAuthenticator INSTANCE = new ThreadLocalProxyAuthenticator();

        private Holder() {
        }
    }

    public static class ThreadLocalProxyAuthenticator extends Authenticator {
        private final Object mutex = new Object();
        private Map<String, Pair<String, String>> proxyInfoMap = new HashMap();
        private ThreadLocal<PasswordAuthentication> credentials = new ThreadLocal<>();

        public static class SingletonHolder {
            private static final ThreadLocalProxyAuthenticator instance = new ThreadLocalProxyAuthenticator();

            private SingletonHolder() {
            }
        }

        public static ThreadLocalProxyAuthenticator getInstance() {
            return SingletonHolder.instance;
        }

        public void clearCredentials() {
            this.credentials.set(null);
        }

        @Nullable
        public Pair<String, String> getAuthenticatorByProxy(String str, int i2) {
            Pair<String, String> pair;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            synchronized (this.mutex) {
                pair = this.proxyInfoMap.get(str + i2);
            }
            return pair;
        }

        @Override // java.net.Authenticator
        public PasswordAuthentication getPasswordAuthentication() {
            return this.credentials.get();
        }

        public void setCredentials(String str, String str2) {
            this.credentials.set(new PasswordAuthentication(str, str2.toCharArray()));
        }

        public void setProxy(String str, int i2, String str2, String str3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (this.mutex) {
                this.proxyInfoMap.put(str + i2, new Pair<>(str2, str3));
            }
        }
    }

    private ProxyAuthenticator() {
    }

    public static ThreadLocalProxyAuthenticator getInstance() {
        return Holder.INSTANCE;
    }
}
