package com.kugou.common.network.retry;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.protocol.ResponsePackage;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultRetryStrategy implements IRetryStrategy {
    private static volatile DefaultRetryStrategy mInstance;

    private DefaultRetryStrategy() {
    }

    private String getHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                return uri.getHost();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static DefaultRetryStrategy getInstance() {
        if (mInstance == null) {
            synchronized (DefaultRetryStrategy.class) {
                if (mInstance == null) {
                    mInstance = new DefaultRetryStrategy();
                }
            }
        }
        return mInstance;
    }

    private boolean isQuicUnifiedGatewayUrl(String str, AbsHttpVars absHttpVars) {
        if (!TextUtils.isEmpty(str) && absHttpVars != null) {
            String host = getHost(str);
            if (!TextUtils.isEmpty(host)) {
                return absHttpVars.isQuicUnifiedGateway(host);
            }
        }
        return false;
    }

    @Override // com.kugou.common.network.retry.IRetryStrategy
    public void beforeStartRetry(RequestPackage requestPackage, AbsHttpClient.IStreamHandler iStreamHandler, AbsHttpClient absHttpClient) {
    }

    @Override // com.kugou.common.network.retry.IRetryStrategy
    public void beforeStartRetry(RequestPackage requestPackage, ResponsePackage<Object> responsePackage, AbsHttpClient absHttpClient) {
    }

    @Override // com.kugou.common.network.retry.IRetryStrategy
    public List<IHttpRetryMode> generateRetryMechanism(List<String> list, boolean z, @NonNull AbsHttpVars absHttpVars) {
        ArrayList arrayList = new ArrayList(1);
        if (list.isEmpty()) {
            arrayList.add(null);
        } else {
            String str = list.get(0);
            IHttpRetryMode iHttpRetryModeMakeHttpRetryMode = DNSHttpRetryMode.makeHttpRetryMode(str, null, z, absHttpVars, 32773);
            if (iHttpRetryModeMakeHttpRetryMode != null && isQuicUnifiedGatewayUrl(str, absHttpVars)) {
                iHttpRetryModeMakeHttpRetryMode.setProtocolType(2);
            }
            arrayList.add(iHttpRetryModeMakeHttpRetryMode);
        }
        return arrayList;
    }

    @Override // com.kugou.common.network.retry.IRetryStrategy
    public RetryStaticsLOG getRetryStatics(Context context) {
        return new RetryStaticsLOG(context);
    }
}
