package com.kugou.common.network.retry;

import com.kugou.common.network.netgate.NetgateEntity;

/* JADX INFO: loaded from: classes2.dex */
public class ACKNetgateRetryExtraParam extends RetryExtraParam {
    public NetgateEntity mNetgateEntity;
    public String mOriUrl;

    @Override // com.kugou.common.network.retry.RetryExtraParam
    public String toString() {
        return "ACKNetgateRetryExtraParam{mUrl='" + this.mUrl + "', mOriUrl='" + this.mOriUrl + "', mVisitUrl='" + this.mVisitUrl + "', mHeaders=" + this.mHeaders + ", mGetRequestParams='" + this.mGetRequestParams + "', mActTime=" + this.mActTime + ", mAckElapsedTime=" + this.mAckElapsedTime + ", durtion=" + this.durtion + ", mNetgateEntity=" + this.mNetgateEntity + '}';
    }
}
