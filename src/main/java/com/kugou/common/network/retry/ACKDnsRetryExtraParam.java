package com.kugou.common.network.retry;

/* JADX INFO: loaded from: classes2.dex */
public class ACKDnsRetryExtraParam extends RetryExtraParam {
    public String mAckDnsAddress;
    public String mAckDnsDomain;

    @Override // com.kugou.common.network.retry.RetryExtraParam
    public String toString() {
        return "ACKDnsRetryExtraParam{mUrl=" + this.mUrl + "mVisitUrl=" + this.mVisitUrl + "mAckDnsDomain='" + this.mAckDnsDomain + "', mAckDnsAddress='" + this.mAckDnsAddress + "'}";
    }
}
