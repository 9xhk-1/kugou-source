package com.kugou.common.network;

import com.kugou.common.network.networkutils.NetLog;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class ExceptionParse {
    public static final String NET_CONTENT_ARRAY_EMPTY = "183";
    public static final String NET_CONTENT_CHARSET_ERROR = "185";
    public static final String NET_CONTENT_EMPTY = "182";
    public static final String NET_CONTENT_INVALID = "181";
    public static final String NET_CONTENT_STATUS_ERROR = "184";
    public static final String NET_CONTENT_TYPE_WRONG = "180";
    public static final String NET_DISAGREE_HTTP_HEADERS = "111";
    public static final String NET_DNS_FAIL = "101";
    public static final String NET_EXCEPTION = "1";
    public static final String NET_HTTP_HEADER_BROKEN = "110";
    public static final String NET_IMAGE_PARSE_ERROR = "186";
    public static final String NET_INTERRUPT = "2";
    public static final String NET_ISP_GATEWAY_BUSY = "160";
    public static final String NET_ISP_WIFI_AUTHENTICATION = "170";
    public static final String NET_JAVA_ERROR = "3";
    public static final String NET_JSON_PARSE_ERROR = "187";
    public static final String NET_LYRIC_PARSE_ERROR = "189";
    public static final String NET_LYRIC_PARSE_XML = "190";
    public static final String NET_NO_KUGOU_RES_TAG = "188";
    public static final String NET_OK = "0";
    public static final String NET_PING_FAIL = "102";
    public static final String NET_RESPONSE_404 = "144";
    public static final String NET_RESPONSE_502 = "152";
    public static final String NET_TCP_CONNECT_TIMEOUT = "105";
    public static final String NET_TCP_TRANSFER_TIMEOUT = "106";
    public static final String NET_URL_PROTOCOL_ERROR = "100";

    public static String parseResultCode(Exception exc) {
        NetLog.e("parseResultCode", "parse result code");
        if (exc instanceof UnknownHostException) {
            return NET_DNS_FAIL;
        }
        if ((exc instanceof ConnectTimeoutException) || (exc instanceof ConnectException)) {
            return NET_TCP_CONNECT_TIMEOUT;
        }
        if ((exc instanceof SocketTimeoutException) || (exc instanceof SocketException)) {
            return NET_TCP_TRANSFER_TIMEOUT;
        }
        if (!(exc instanceof KugouNetException)) {
            if (exc instanceof IOException) {
            }
            return "1";
        }
        KugouNetException kugouNetException = (KugouNetException) exc;
        NetLog.e("ExceptionParse", "parse KugouNetException(" + kugouNetException.getError() + ")");
        switch (kugouNetException.getError()) {
            case 4:
                if (kugouNetException.getRightResponseType() != null) {
                    int checkType = kugouNetException.getRightResponseType().getCheckType();
                    if (checkType != 0) {
                        if (checkType != 1) {
                            if (checkType != 2) {
                                if (checkType != 3) {
                                }
                            }
                        }
                    }
                }
                break;
        }
        return NET_TCP_CONNECT_TIMEOUT;
    }

    public static String responseCodeToResultCode(int i2) {
        if (i2 < 400 || i2 >= 600) {
            return "";
        }
        int i3 = i2 / 100;
        int i4 = i2 % 100;
        if (i4 > 9) {
            i4 = 0;
        }
        return "1" + i3 + "" + i4;
    }
}
