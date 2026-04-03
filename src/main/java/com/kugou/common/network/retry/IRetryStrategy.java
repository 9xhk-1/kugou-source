package com.kugou.common.network.retry;

import android.content.Context;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.protocol.ResponsePackage;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IRetryStrategy {
    void beforeStartRetry(RequestPackage requestPackage, AbsHttpClient.IStreamHandler iStreamHandler, AbsHttpClient absHttpClient);

    void beforeStartRetry(RequestPackage requestPackage, ResponsePackage<Object> responsePackage, AbsHttpClient absHttpClient);

    List<IHttpRetryMode> generateRetryMechanism(List<String> list, boolean z, AbsHttpVars absHttpVars);

    RetryStaticsLOG getRetryStatics(Context context);
}
