package com.kugou.common.network.retry;

import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.proxy.KGHttpProxy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractHttpRetryMode implements IHttpRetryMode {
    public static final int BASE_TYPE = 110;
    public Exception mException;
    public AbsHttpClient mHttpClient;
    public KGHttpProxy mHttpProxy;
    public IHttpRetryMode mLastHttpRetryMode;
    public RetryExtraParam mRetryExtraParam;
    public boolean mIsInStreamMode = false;
    public int protocolType = 3;
    public int mVersion = 32768;

    public AbstractHttpRetryMode(RetryExtraParam retryExtraParam, IHttpRetryMode iHttpRetryMode) {
        this.mRetryExtraParam = retryExtraParam;
        this.mLastHttpRetryMode = iHttpRetryMode;
    }

    public Exception getException() {
        return this.mException;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public KGHttpProxy getHttpProxy() {
        return this.mHttpProxy;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public IHttpRetryMode getLastHttpRetryMode() {
        return this.mLastHttpRetryMode;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getProtocolType() {
        return this.protocolType;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public RetryExtraParam getRetryExtraParam() {
        return this.mRetryExtraParam;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getVersion() {
        return this.mVersion;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public boolean isInStream() {
        return this.mIsInStreamMode;
    }

    public void setHttpProxy(KGHttpProxy kGHttpProxy) {
        this.mHttpProxy = kGHttpProxy;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public void setInStreamMode(boolean z) {
        this.mIsInStreamMode = z;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public void setProtocolType(int i2) {
        this.protocolType = i2;
    }

    public void setVersion(int i2) {
        this.mVersion = i2;
    }

    public String toString() {
        return "AbstractHttpRetryMode{mIsInStreamMode=" + this.mIsInStreamMode + ", mRetryExtraParam=" + this.mRetryExtraParam + ", mException=" + this.mException + ", mHttpClient=" + this.mHttpClient + ", mLastHttpRetryMode=" + this.mLastHttpRetryMode + '}';
    }
}
