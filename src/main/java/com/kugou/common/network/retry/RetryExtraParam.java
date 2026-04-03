package com.kugou.common.network.retry;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RetryExtraParam {
    public byte[] directIp;
    public long durtion;
    public long mAckElapsedTime;
    public long mActTime;
    public String mGetRequestParams;
    public Map<String, String> mHeaders;
    public String mUrl;
    public String mVisitUrl;

    public String toString() {
        return "RetryExtraParam{mUrl='" + this.mUrl + "', mVisitUrl='" + this.mVisitUrl + "'}";
    }
}
