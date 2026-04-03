package com.kugou.common.network.retry;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.kugou.common.network.AbsAckVars;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.RequestDelay;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckProtocolTypeUtil;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.proxy.ProxyCompator;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public class ACKDnsHttpRetryMode extends AbsHttpRetryModeProperty {
    private static final String TAG = "ACKDnsHttpRetryMode";
    public static final int TYPE = 111;

    private ACKDnsHttpRetryMode(RetryExtraParam retryExtraParam, IHttpRetryMode iHttpRetryMode) {
        super(retryExtraParam, iHttpRetryMode);
    }

    public static List<IHttpRetryMode> makeHttpRetryMode(String str, IHttpRetryMode iHttpRetryMode, boolean z, @NonNull AbsHttpVars absHttpVars, int i2) {
        try {
            URI uri = new URI(str);
            List<String> ackDnsAddress = AckManager.getAckVars().getAckDnsAddress(uri.getHost());
            if (!AckProtocolTypeUtil.HTTPS_LABEL.equalsIgnoreCase(uri.getScheme()) && ackDnsAddress != null && ackDnsAddress.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < ackDnsAddress.size(); i3++) {
                    String str2 = ackDnsAddress.get(i3);
                    if (!TextUtils.isEmpty(str2)) {
                        String rawPath = uri.getRawPath();
                        if (rawPath == null) {
                            rawPath = "";
                        }
                        String host = uri.getHost();
                        String str3 = "http://" + str2 + rawPath;
                        String rawQuery = uri.getRawQuery();
                        if (!TextUtils.isEmpty(rawQuery)) {
                            str3 = str3 + "?" + rawQuery;
                        }
                        ACKDnsRetryExtraParam aCKDnsRetryExtraParam = new ACKDnsRetryExtraParam();
                        aCKDnsRetryExtraParam.mAckElapsedTime = SystemClock.elapsedRealtime();
                        aCKDnsRetryExtraParam.mUrl = str3;
                        aCKDnsRetryExtraParam.mVisitUrl = str;
                        aCKDnsRetryExtraParam.mAckDnsDomain = uri.getHost();
                        aCKDnsRetryExtraParam.mAckDnsAddress = str2;
                        HashMap map = new HashMap();
                        aCKDnsRetryExtraParam.mHeaders = map;
                        map.put(HTTP.TARGET_HOST, host);
                        ACKDnsHttpRetryMode aCKDnsHttpRetryMode = new ACKDnsHttpRetryMode(aCKDnsRetryExtraParam, iHttpRetryMode);
                        aCKDnsHttpRetryMode.setHostKey(uri.getHost());
                        if (z) {
                            aCKDnsHttpRetryMode.setHttpProxy(ProxyCompator.createHttpProxy(str3, absHttpVars));
                        }
                        aCKDnsHttpRetryMode.setVersion(i2);
                        arrayList.add(aCKDnsHttpRetryMode);
                        if (NetLog.isDebug()) {
                            NetLog.d(TAG, "makeHttpRetryMode(ACKDNS) url=" + str + ", value=[" + str2 + "]");
                        }
                    }
                }
                return arrayList;
            }
        } catch (Exception e2) {
            boolean z2 = e2 instanceof URISyntaxException;
        }
        if (!NetLog.isDebug()) {
            return null;
        }
        NetLog.d(TAG, "makeHttpRetryMode(ACKDNS) url=" + str + ", value=null");
        return null;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public String getGETMethod() {
        return RequestDelay.GET_METHOD_DIRECT;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getServiceId() {
        return AckManager.SERVICE_ID_ACK_DNS;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getType() {
        return 111;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int onHttpClientException(Exception exc, RequestPackage requestPackage) {
        boolean ackDnsAddressAvailable;
        if (requestPackage != null) {
            onNetQuality(requestPackage, exc);
        }
        this.mException = exc;
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "RetryMode(ACKDNS) Exception");
        }
        if (this.mRetryExtraParam instanceof ACKDnsRetryExtraParam) {
            AbsAckVars ackVars = AckManager.getAckVars();
            RetryExtraParam retryExtraParam = this.mRetryExtraParam;
            ackDnsAddressAvailable = ackVars.setAckDnsAddressAvailable(((ACKDnsRetryExtraParam) retryExtraParam).mAckDnsDomain, ((ACKDnsRetryExtraParam) retryExtraParam).mAckDnsAddress, false);
        } else {
            ackDnsAddressAvailable = false;
        }
        if (ackDnsAddressAvailable) {
            AbsAckVars ackVars2 = AckManager.getAckVars();
            RetryExtraParam retryExtraParam2 = this.mRetryExtraParam;
            ackVars2.markRequest(retryExtraParam2.mVisitUrl, retryExtraParam2.mUrl, getType(), -1);
        } else if (NetLog.isDebug()) {
            NetLog.d(TAG, "ACKDNS Exceptioni operate invalid");
        }
        return 0;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int onHttpClientSuccess(RequestPackage requestPackage, HttpResponse httpResponse) {
        boolean ackDnsAddressAvailable;
        if (requestPackage != null) {
            if (NetLog.isDebug()) {
                NetLog.d(TAG, "RetryMode(ACKDNS) Success");
            }
            onNetQuality(requestPackage, null);
        }
        if (this.mRetryExtraParam instanceof ACKDnsRetryExtraParam) {
            AbsAckVars ackVars = AckManager.getAckVars();
            RetryExtraParam retryExtraParam = this.mRetryExtraParam;
            ackDnsAddressAvailable = ackVars.setAckDnsAddressAvailable(((ACKDnsRetryExtraParam) retryExtraParam).mAckDnsDomain, ((ACKDnsRetryExtraParam) retryExtraParam).mAckDnsAddress, true);
        } else {
            ackDnsAddressAvailable = false;
        }
        if (ackDnsAddressAvailable) {
            AbsAckVars ackVars2 = AckManager.getAckVars();
            RetryExtraParam retryExtraParam2 = this.mRetryExtraParam;
            ackVars2.markRequest(retryExtraParam2.mVisitUrl, retryExtraParam2.mUrl, getType(), 1);
        } else if (NetLog.isDebug()) {
            NetLog.d(TAG, "ACKDNS Success operate invalid");
        }
        return 0;
    }
}
