package com.kugou.common.network.retry;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.kugou.common.network.AbsAckVars;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.RequestDelay;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.proxy.ProxyCompator;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public class DNSHttpRetryMode extends AbsHttpRetryModeProperty {
    private static final int NONE_SERVICE = 0;
    private static final String TAG = "DNSHttpRetryMode";
    public static final int TYPE = 112;

    public DNSHttpRetryMode(RetryExtraParam retryExtraParam, IHttpRetryMode iHttpRetryMode) {
        super(retryExtraParam, iHttpRetryMode);
    }

    public static IHttpRetryMode makeHttpRetryMode(String str, IHttpRetryMode iHttpRetryMode, boolean z, @NonNull AbsHttpVars absHttpVars, int i2) {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "makeHttpRetryMode(DNS) url=" + str);
        }
        Pair<String, String> schemeHostPair = HttpRetryManager.getSchemeHostPair(str);
        RetryExtraParam retryExtraParam = new RetryExtraParam();
        retryExtraParam.mAckElapsedTime = SystemClock.elapsedRealtime();
        retryExtraParam.mUrl = str;
        retryExtraParam.mVisitUrl = str;
        DNSHttpRetryMode dNSHttpRetryMode = new DNSHttpRetryMode(retryExtraParam, iHttpRetryMode);
        dNSHttpRetryMode.setHostKey(schemeHostPair == null ? "" : (String) schemeHostPair.second);
        dNSHttpRetryMode.setVersion(i2);
        if (z) {
            dNSHttpRetryMode.setHttpProxy(ProxyCompator.createHttpProxy(str, absHttpVars));
        }
        return dNSHttpRetryMode;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public String getGETMethod() {
        return RequestDelay.GET_METHOD_DIRECT;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getServiceId() {
        return 0;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getType() {
        return 112;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int onHttpClientException(Exception exc, RequestPackage requestPackage) {
        if (requestPackage != null) {
            onNetQuality(requestPackage, exc);
        }
        this.mException = exc;
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "RetryMode(DNS) Exception");
        }
        if (this.mRetryExtraParam == null || AckManager.getAckVars() == null) {
            return 0;
        }
        AbsAckVars ackVars = AckManager.getAckVars();
        RetryExtraParam retryExtraParam = this.mRetryExtraParam;
        ackVars.markRequest(retryExtraParam.mVisitUrl, retryExtraParam.mUrl, getType(), -1);
        return 0;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int onHttpClientSuccess(RequestPackage requestPackage, HttpResponse httpResponse) {
        if (requestPackage != null) {
            onNetQuality(requestPackage, null);
        }
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "RetryMode(DNS) Success");
        }
        if (this.mRetryExtraParam == null) {
            return 0;
        }
        AbsAckVars ackVars = AckManager.getAckVars();
        RetryExtraParam retryExtraParam = this.mRetryExtraParam;
        ackVars.markRequest(retryExtraParam.mVisitUrl, retryExtraParam.mUrl, getType(), 1);
        return 0;
    }
}
