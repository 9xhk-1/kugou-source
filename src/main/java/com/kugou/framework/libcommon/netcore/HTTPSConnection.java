package com.kugou.framework.libcommon.netcore;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class HTTPSConnection extends BaseConnection {
    private HttpsURLConnection mConn;

    public HTTPSConnection(String str, Proxy proxy) {
        this.mConn = null;
        try {
            if (proxy != null) {
                this.mConn = (HttpsURLConnection) new URL(str).openConnection(proxy);
            } else {
                this.mConn = (HttpsURLConnection) new URL(str).openConnection();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kugou.framework.libcommon.netcore.BaseConnection
    public HttpURLConnection getURLConnection() {
        return this.mConn;
    }
}
