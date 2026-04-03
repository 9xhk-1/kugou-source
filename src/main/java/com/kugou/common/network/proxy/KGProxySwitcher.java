package com.kugou.common.network.proxy;

import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class KGProxySwitcher {
    private Proxy mainProxy;

    public static class Holder {
        public static KGProxySwitcher INSTANCE = new KGProxySwitcher();

        private Holder() {
        }
    }

    public static KGProxySwitcher getInstance() {
        return Holder.INSTANCE;
    }

    public void setMainProxy(Proxy proxy) {
        this.mainProxy = proxy;
    }

    private KGProxySwitcher() {
    }
}
