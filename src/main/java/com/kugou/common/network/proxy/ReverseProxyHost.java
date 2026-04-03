package com.kugou.common.network.proxy;

import com.kugou.common.network.netgate.AckProtocolTypeUtil;
import org.apache.http.Header;
import org.apache.http.message.HeaderGroup;

/* JADX INFO: loaded from: classes2.dex */
public class ReverseProxyHost {
    public static final int KING_CARD_HTTPS_PORT = 8443;
    public static final int KING_CARD_HTTP_PORT = 8080;
    public static final int TYPE_KING_CARD = 1;
    public final HeaderGroup headerGroup = new HeaderGroup();
    public final String originHost;
    public final String proxyHost;
    public final String scheme;
    public final int type;

    public ReverseProxyHost(int i2, boolean z, String str, String str2) {
        this.type = i2;
        this.scheme = z ? AckProtocolTypeUtil.HTTPS_LABEL : "http";
        this.originHost = str;
        this.proxyHost = str2;
    }

    public static int getPort(boolean z) {
        return z ? KING_CARD_HTTPS_PORT : KING_CARD_HTTP_PORT;
    }

    public void addHeader(Header header) {
        this.headerGroup.addHeader(header);
    }
}
