package com.kugou.common.network.netgate;

import android.text.TextUtils;
import com.kugou.common.network.networkutils.NetLog;
import java.net.URI;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class AckProtocolTypeUtil {
    public static final String HTTPS_LABEL = "https";
    public static final String HTTP_LABEL = "http";
    public static final String QUIC_LABEL = "quic";

    public static int parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (HTTPS_LABEL.equalsIgnoreCase(str)) {
            return 1;
        }
        if ("quic".equalsIgnoreCase(str)) {
            return 2;
        }
        if ("http".equalsIgnoreCase(str)) {
            return 3;
        }
        if (!NetLog.isDebug()) {
            return 0;
        }
        throw new IllegalArgumentException("protocolName: " + str + " is not support now.");
    }

    public static String replaceHostAndPort(String str, int i2, String str2) {
        try {
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                return str;
            }
            HttpUrl.Builder builder = new HttpUrl.Builder();
            builder.scheme(httpUrl.scheme()).host(str2).port(i2).encodedQuery(httpUrl.encodedQuery()).encodedFragment(httpUrl.encodedFragment()).encodedPath(httpUrl.encodedPath());
            if (NetLog.isDebug()) {
                URI uri = new URI(str);
                if (!TextUtils.equals(new URI(uri.getScheme(), uri.getUserInfo(), str2, i2, uri.getPath(), uri.getQuery(), uri.getFragment()).toString(), builder.toString())) {
                    NetLog.e("kgHttpClient", "Error originUrl: " + str);
                }
            }
            return builder.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private static String replaceHostAndScheme(String str, String str2, String str3) {
        try {
            HttpUrl httpUrl = HttpUrl.parse(str);
            if (httpUrl == null) {
                return str;
            }
            HttpUrl.Builder builder = new HttpUrl.Builder();
            builder.scheme(str2).host(str3).encodedQuery(httpUrl.encodedQuery()).encodedFragment(httpUrl.encodedFragment()).encodedPath(httpUrl.encodedPath());
            if (NetLog.isDebug()) {
                URI uri = new URI(str);
                if (!TextUtils.equals(new URI(str2, str3, uri.getPath(), uri.getQuery(), uri.getFragment()).toString(), builder.toString())) {
                    NetLog.e("kgHttpClient", "Error originUrl: " + str);
                }
            }
            return builder.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String replaceSchemeAndHost(int i2, String str, String str2) {
        return (i2 == 1 || i2 == 2) ? replaceHostAndScheme(str2, HTTPS_LABEL, str) : replaceHostAndScheme(str2, "http", str);
    }
}
