package com.kugou.common.network.retry;

import com.kugou.common.network.AbsAckVars;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.protocol.RequestPackage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsHttpRetryModeProperty extends AckHostAttrRetryMode implements NetQuality {
    private static final int LIMIT_EXCEPTION_DESC = 110;
    private static int appId = 0;
    private static boolean isInitConstantData = false;
    private static int versionCode;

    public AbsHttpRetryModeProperty(RetryExtraParam retryExtraParam, IHttpRetryMode iHttpRetryMode) {
        super(retryExtraParam, iHttpRetryMode);
    }

    public static void handleNetQuality(AbsHttpClient absHttpClient, RetryExtraParam retryExtraParam, RequestPackage requestPackage, Exception exc) {
        AbsAckVars ackVars = AckManager.getAckVars();
        if (ackVars != null) {
            ackVars.handleNetQuality(absHttpClient, retryExtraParam, requestPackage, exc, 110, isInitConstantData, appId, versionCode);
        }
    }

    @Override // com.kugou.common.network.retry.NetQuality
    public void onNetQuality(RequestPackage requestPackage, Exception exc) {
        handleNetQuality(this.mHttpClient, getRetryExtraParam(), requestPackage, exc);
    }
}
