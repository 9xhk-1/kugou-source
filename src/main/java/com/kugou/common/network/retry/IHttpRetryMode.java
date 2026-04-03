package com.kugou.common.network.retry;

import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.proxy.KGHttpProxy;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpRetryMode {
    String getGETMethod();

    KGHttpProxy getHttpProxy();

    IHttpRetryMode getLastHttpRetryMode();

    int getProtocolType();

    RetryExtraParam getRetryExtraParam();

    int getServiceId();

    int getType();

    int getVersion();

    boolean isInStream();

    int onHttpClientException(Exception exc, RequestPackage requestPackage);

    int onHttpClientSuccess(RequestPackage requestPackage, HttpResponse httpResponse);

    void setInStreamMode(boolean z);

    void setProtocolType(int i2);
}
