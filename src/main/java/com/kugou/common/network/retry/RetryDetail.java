package com.kugou.common.network.retry;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.kugou.common.network.protocol.H2QuicVersion;

/* JADX INFO: loaded from: classes2.dex */
public class RetryDetail {
    private static final int CRONET_PROTOCOL_HTTP2 = 1;
    private static final int CRONET_PROTOCOL_NULL = 0;
    private static final int CRONET_PROTOCOL_QUIC = 2;
    private static final int CRONET_PROTOCOL_UNKNOWN = 3;
    private int cronetRealProtocolType;
    private long duration;
    private Throwable error;
    private String host;
    private int netMode;
    private String schema;
    private String serverIp;

    public RetryDetail(String str, String str2, String str3, int i2, Throwable th, long j, String str4) {
        this.schema = str;
        this.host = str2;
        this.serverIp = str3;
        this.netMode = i2;
        this.error = th;
        this.duration = j;
        if (str4 == null) {
            this.cronetRealProtocolType = 0;
            return;
        }
        if (H2QuicVersion.HTTP2.equals(str4)) {
            this.cronetRealProtocolType = 1;
        } else if ("quic".equals(str4)) {
            this.cronetRealProtocolType = 2;
        } else {
            this.cronetRealProtocolType = 3;
        }
    }

    public int getCronetRealProtocolType() {
        return this.cronetRealProtocolType;
    }

    public long getDuration() {
        return this.duration;
    }

    public Throwable getError() {
        return this.error;
    }

    public String getHost() {
        return this.host;
    }

    public int getNetMode() {
        return this.netMode;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getServerIp() {
        return this.serverIp;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(this.schema);
        sb.append(",");
        sb.append(this.host);
        sb.append(",");
        sb.append(TextUtils.isEmpty(this.serverIp) ? "none" : this.serverIp);
        sb.append(",");
        sb.append(this.netMode);
        sb.append(",");
        sb.append(this.cronetRealProtocolType);
        sb.append(",");
        sb.append(this.duration);
        sb.append(",");
        Object obj = this.error;
        if (obj == null) {
            obj = "success";
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
