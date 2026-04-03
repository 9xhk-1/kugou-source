package com.kugou.common.network.protocol;

import com.kugou.common.network.retry.RetryDetail;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractLastUrlResponsePackage<T> implements ResponsePackage<T> {
    private String mLastUrl;
    private List<RetryDetail> mRetryDetails;

    public String getLastUrl() {
        return this.mLastUrl;
    }

    public List<RetryDetail> getRetryDetails() {
        return this.mRetryDetails;
    }

    public void setLastUrl(String str) {
        this.mLastUrl = str;
    }

    public void setRetryDetails(List<RetryDetail> list) {
        this.mRetryDetails = list;
    }
}
