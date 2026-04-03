package com.kugou.common.network.retry;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Pair;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.RequestDelay;
import com.kugou.common.network.ackutils.IPAddressUtil;
import com.kugou.common.network.netgate.AckHostConfigEntity;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckProtocolTypeUtil;
import com.kugou.common.network.netgate.HostKeyProtocolEntity;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.proxy.ProxyCompator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public class ACKProtocolRetryMode extends AbstractHttpRetryMode {
    private static final String GATEWAY_HOST = "gateway.kugou.com";

    private ACKProtocolRetryMode(RetryExtraParam retryExtraParam, IHttpRetryMode iHttpRetryMode) {
        super(retryExtraParam, iHttpRetryMode);
    }

    private static List<IHttpRetryMode> generateProtocolRetryModes(HostKeyProtocolEntity hostKeyProtocolEntity, String str, @Nullable IHttpRetryMode iHttpRetryMode, boolean z, AbsHttpVars absHttpVars, int i2) {
        List<AckHostConfigEntity.UrlHostEntity> list;
        String str2;
        String str3;
        ArrayList arrayList = new ArrayList();
        if (hostKeyProtocolEntity != null && (list = hostKeyProtocolEntity.urlHosts) != null) {
            for (AckHostConfigEntity.UrlHostEntity urlHostEntity : list) {
                if (urlHostEntity.protocol != 0) {
                    byte[] bArrTextToNumericFormatV4 = IPAddressUtil.textToNumericFormatV4(urlHostEntity.urlHost);
                    String str4 = GATEWAY_HOST;
                    boolean z2 = (bArrTextToNumericFormatV4 == null || str == null || !str.contains(GATEWAY_HOST)) ? false : true;
                    int i3 = urlHostEntity.protocol;
                    if (!z2) {
                        str4 = urlHostEntity.urlHost;
                    }
                    String strReplaceSchemeAndHost = AckProtocolTypeUtil.replaceSchemeAndHost(i3, str4, str);
                    RetryExtraParam retryExtraParam = new RetryExtraParam();
                    retryExtraParam.mAckElapsedTime = SystemClock.elapsedRealtime();
                    retryExtraParam.mUrl = strReplaceSchemeAndHost;
                    retryExtraParam.mVisitUrl = str;
                    retryExtraParam.mHeaders = new HashMap();
                    if (z2) {
                        retryExtraParam.directIp = bArrTextToNumericFormatV4;
                    }
                    List<AckHostConfigEntity.HeaderParam> list2 = hostKeyProtocolEntity.headerParams;
                    if (list2 != null) {
                        for (AckHostConfigEntity.HeaderParam headerParam : list2) {
                            if (headerParam != null && (str2 = headerParam.key) != null && (str3 = headerParam.value) != null) {
                                retryExtraParam.mHeaders.put(str2, str3);
                            }
                        }
                    }
                    ACKProtocolRetryMode aCKProtocolRetryMode = new ACKProtocolRetryMode(retryExtraParam, iHttpRetryMode);
                    aCKProtocolRetryMode.setProtocolType(urlHostEntity.protocol);
                    aCKProtocolRetryMode.setVersion(i2);
                    if (z) {
                        aCKProtocolRetryMode.setHttpProxy(ProxyCompator.createHttpProxy(strReplaceSchemeAndHost, absHttpVars));
                    }
                    arrayList.add(aCKProtocolRetryMode);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static List<IHttpRetryMode> makeHttpRetryMode(String str, @NonNull Pair<String, String> pair, @Nullable IHttpRetryMode iHttpRetryMode, boolean z, AbsHttpVars absHttpVars, int i2) {
        HostKeyProtocolEntity ackProtocolEntity = AckManager.getAckVars().getAckProtocolEntity((String) pair.second);
        List<IHttpRetryMode> listGenerateProtocolRetryModes = ackProtocolEntity != null ? generateProtocolRetryModes(ackProtocolEntity, str, iHttpRetryMode, z, absHttpVars, i2) : null;
        if ((listGenerateProtocolRetryModes == null || listGenerateProtocolRetryModes.isEmpty()) && "http".equals(pair.first)) {
            HostKeyProtocolEntity extraAckProtocolEntity = AckManager.getAckVars().getExtraAckProtocolEntity((String) pair.second);
            if (extraAckProtocolEntity != null) {
                listGenerateProtocolRetryModes = generateProtocolRetryModes(extraAckProtocolEntity, str, iHttpRetryMode, z, absHttpVars, i2);
            }
            if (listGenerateProtocolRetryModes == null || listGenerateProtocolRetryModes.isEmpty()) {
                return null;
            }
        }
        return listGenerateProtocolRetryModes;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public String getGETMethod() {
        return RequestDelay.GET_METHOD_PROTOCOL;
    }

    @Override // com.kugou.common.network.retry.AbstractHttpRetryMode, com.kugou.common.network.retry.IHttpRetryMode
    public int getProtocolType() {
        return this.protocolType;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getServiceId() {
        return 0;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getType() {
        return 114;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int onHttpClientException(Exception exc, RequestPackage requestPackage) {
        if (requestPackage == null) {
            return 0;
        }
        AbsHttpRetryModeProperty.handleNetQuality(this.mHttpClient, getRetryExtraParam(), requestPackage, exc);
        return 0;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int onHttpClientSuccess(RequestPackage requestPackage, HttpResponse httpResponse) {
        if (requestPackage == null) {
            return 0;
        }
        AbsHttpRetryModeProperty.handleNetQuality(this.mHttpClient, getRetryExtraParam(), requestPackage, null);
        return 0;
    }
}
