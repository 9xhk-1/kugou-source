package com.kugou.common.network.retry;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AckHostAttrRetryMode extends AbstractHttpRetryMode implements IRequestHostKey {
    private static final String TAG = "AckHostAttrRetryMode";
    private String hostKey;

    public AckHostAttrRetryMode(RetryExtraParam retryExtraParam, IHttpRetryMode iHttpRetryMode) {
        super(retryExtraParam, iHttpRetryMode);
    }

    @Override // com.kugou.common.network.retry.IRequestHostKey
    public String getHostKey() {
        return this.hostKey;
    }

    @Override // com.kugou.common.network.retry.IRequestHostKey
    public void setHostKey(String str) {
        this.hostKey = str;
    }
}
