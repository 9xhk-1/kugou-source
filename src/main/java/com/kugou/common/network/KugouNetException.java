package com.kugou.common.network;

import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.networkutils.KGNetworkUtil;
import java.io.IOException;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes2.dex */
public class KugouNetException extends IOException {
    public static final int ERROR_DISAGREE_HTTP_HEADERS = 5;
    public static final int ERROR_INVALID_STATUS_CODE = 7;
    public static final int ERROR_JAVA_ERROR = 6;
    public static final int ERROR_NO_KUGOU_RES_TAG = 3;
    public static final int ERROR_WIFI_NEED_AUTH = 2;
    public static final int ERROR_WRONG_CONTENT_TYPE = 1;
    public static final int ERROR_WRONG_RESPONSE_TYPE = 4;
    private static final long serialVersionUID = 5034313558843402928L;
    private byte[] data;
    private int error;
    private Header[] headers;
    private Error javaError;
    private ResponseTypeChecker.ResponseType rightResponseType;
    private int statusCode;
    private String statusCodeDetail;

    public KugouNetException() {
        this.data = null;
        this.headers = null;
    }

    private static String buildDetailMessage(byte[] bArr) {
        return "\n返回：" + KGNetworkUtil.dataToHTML(bArr);
    }

    public byte[] getData() {
        return this.data;
    }

    public int getError() {
        return this.error;
    }

    public Header[] getHeaders() {
        return this.headers;
    }

    public Error getJavaError() {
        return this.javaError;
    }

    public ResponseTypeChecker.ResponseType getRightResponseType() {
        return this.rightResponseType;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusCodeDetail() {
        return this.statusCodeDetail;
    }

    private static String buildDetailMessage(Header[] headerArr) {
        if (headerArr != null && headerArr.length != 0) {
            String str = "";
            for (int i2 = 0; i2 < headerArr.length; i2++) {
                try {
                    str = str + headerArr[i2].getName() + ": " + headerArr[i2].getValue() + ";\n";
                } catch (Exception unused) {
                }
            }
            return "\nHeaders:{\n" + str + "}";
        }
        return "";
    }

    public KugouNetException(int i2, String str, byte[] bArr) {
        super(str + buildDetailMessage(bArr));
        this.data = null;
        this.headers = null;
        this.error = i2;
        this.data = bArr;
    }

    public KugouNetException(ResponseTypeChecker.ResponseType responseType, String str, byte[] bArr) {
        super(str + buildDetailMessage(bArr));
        this.data = null;
        this.headers = null;
        this.error = 4;
        this.data = bArr;
        this.rightResponseType = responseType;
    }

    public KugouNetException(int i2, String str, Header[] headerArr) {
        super(str + buildDetailMessage(headerArr));
        this.data = null;
        this.headers = null;
        this.error = i2;
        this.headers = headerArr;
    }

    public KugouNetException(Error error) {
        super("Java Error 错误：" + error.getMessage());
        this.data = null;
        this.headers = null;
        this.error = 6;
        this.javaError = error;
    }

    public KugouNetException(int i2, String str) {
        super("Invalid StatusCode " + i2 + " " + str);
        this.data = null;
        this.headers = null;
        this.error = 7;
        this.statusCode = i2;
        this.statusCodeDetail = str;
    }
}
