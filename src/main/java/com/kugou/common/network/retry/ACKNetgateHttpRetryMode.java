package com.kugou.common.network.retry;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.RequestDelay;
import com.kugou.common.network.netgate.NetgateEntity;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.proxy.ProxyCompator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes2.dex */
public class ACKNetgateHttpRetryMode extends AbsHttpRetryModeProperty {
    private static final String TAG = "ACKNetgateHttpRetryMode";
    public static final int TYPE = 113;

    private ACKNetgateHttpRetryMode(RetryExtraParam retryExtraParam, IHttpRetryMode iHttpRetryMode) {
        super(retryExtraParam, iHttpRetryMode);
    }

    public static IHttpRetryMode makeHttpRetryMode(String str, NetgateEntity netgateEntity, IHttpRetryMode iHttpRetryMode, boolean z, @NonNull AbsHttpVars absHttpVars, int i2) {
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "makeHttpRetryMode(Netgate) url=" + netgateEntity.oriUrl + ", netgate=" + netgateEntity.netgate);
        }
        if (netgateEntity == null) {
            return null;
        }
        try {
            URL url = new URL(netgateEntity.oriUrl);
            String str2 = "http://" + netgateEntity.netgate + (url.getFile() == null ? "" : url.getFile());
            String str3 = TextUtils.isEmpty(netgateEntity.aliasHost) ? netgateEntity.oriHost : netgateEntity.aliasHost;
            ACKNetgateRetryExtraParam aCKNetgateRetryExtraParam = new ACKNetgateRetryExtraParam();
            aCKNetgateRetryExtraParam.mAckElapsedTime = SystemClock.elapsedRealtime();
            aCKNetgateRetryExtraParam.mUrl = str2;
            String str4 = netgateEntity.oriUrl;
            aCKNetgateRetryExtraParam.mOriUrl = str4;
            aCKNetgateRetryExtraParam.mVisitUrl = str4.toLowerCase().replace(netgateEntity.oriHost, netgateEntity.aliasHost);
            HashMap map = new HashMap();
            aCKNetgateRetryExtraParam.mHeaders = map;
            map.put(HTTP.TARGET_HOST, str3);
            aCKNetgateRetryExtraParam.mNetgateEntity = netgateEntity;
            ACKNetgateHttpRetryMode aCKNetgateHttpRetryMode = new ACKNetgateHttpRetryMode(aCKNetgateRetryExtraParam, iHttpRetryMode);
            try {
                aCKNetgateHttpRetryMode.setHostKey(str);
                if (z) {
                    aCKNetgateHttpRetryMode.setHttpProxy(ProxyCompator.createHttpProxy(str2, absHttpVars));
                }
                aCKNetgateHttpRetryMode.setVersion(i2);
            } catch (MalformedURLException unused) {
            }
            return aCKNetgateHttpRetryMode;
        } catch (MalformedURLException unused2) {
            return null;
        }
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public String getGETMethod() {
        return RequestDelay.GET_METHOD_NETGATE;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getServiceId() {
        return 108;
    }

    @Override // com.kugou.common.network.retry.IHttpRetryMode
    public int getType() {
        return 113;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[PHI: r7
  0x0031: PHI (r7v2 com.kugou.common.network.retry.ACKNetgateRetryExtraParam) = 
  (r7v1 com.kugou.common.network.retry.ACKNetgateRetryExtraParam)
  (r7v7 com.kugou.common.network.retry.ACKNetgateRetryExtraParam)
 binds: [B:5:0x000f, B:10:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.kugou.common.network.retry.IHttpRetryMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onHttpClientException(java.lang.Exception r6, com.kugou.common.network.protocol.RequestPackage r7) {
        /*
            r5 = this;
            if (r7 == 0) goto L5
            r5.onNetQuality(r7, r6)
        L5:
            r5.mException = r6
            r7 = 0
            com.kugou.common.network.retry.RetryExtraParam r0 = r5.mRetryExtraParam
            boolean r0 = r0 instanceof com.kugou.common.network.retry.ACKNetgateRetryExtraParam
            java.lang.String r1 = "ACKNetgateHttpRetryMode"
            r2 = 0
            if (r0 == 0) goto L31
            boolean r7 = com.kugou.common.network.networkutils.NetLog.isDebug()
            if (r7 == 0) goto L1c
            java.lang.String r7 = "RetryMode(NETGATE) Exception"
            com.kugou.common.network.networkutils.NetLog.d(r1, r7)
        L1c:
            com.kugou.common.network.retry.RetryExtraParam r7 = r5.mRetryExtraParam
            com.kugou.common.network.retry.ACKNetgateRetryExtraParam r7 = (com.kugou.common.network.retry.ACKNetgateRetryExtraParam) r7
            com.kugou.common.network.netgate.NetgateEntity r0 = r7.mNetgateEntity
            if (r0 == 0) goto L31
            com.kugou.common.network.AbsAckVars r0 = com.kugou.common.network.netgate.AckManager.getAckVars()
            com.kugou.common.network.netgate.NetgateEntity r3 = r7.mNetgateEntity
            java.lang.String r3 = r3.netgate
            boolean r0 = r0.setNetgateAvailable(r3, r2)
            goto L32
        L31:
            r0 = 0
        L32:
            if (r0 == 0) goto L50
            com.kugou.common.network.AbsAckVars r0 = com.kugou.common.network.netgate.AckManager.getAckVars()
            java.lang.String r1 = r7.mOriUrl
            java.lang.String r7 = r7.mUrl
            int r3 = r5.getType()
            r4 = -1
            r0.markRequest(r1, r7, r3, r4)
            java.lang.String r6 = com.kugou.common.network.ExceptionParse.parseResultCode(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L5b
            r6.intValue()     // Catch: java.lang.Exception -> L5b
            goto L5b
        L50:
            boolean r6 = com.kugou.common.network.networkutils.NetLog.isDebug()
            if (r6 == 0) goto L5b
            java.lang.String r6 = "NETGATE Exception operate invalid"
            com.kugou.common.network.networkutils.NetLog.d(r1, r6)
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.retry.ACKNetgateHttpRetryMode.onHttpClientException(java.lang.Exception, com.kugou.common.network.protocol.RequestPackage):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031 A[PHI: r6
  0x0031: PHI (r6v2 com.kugou.common.network.retry.ACKNetgateRetryExtraParam) = 
  (r6v1 com.kugou.common.network.retry.ACKNetgateRetryExtraParam)
  (r6v6 com.kugou.common.network.retry.ACKNetgateRetryExtraParam)
 binds: [B:6:0x000e, B:11:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.kugou.common.network.retry.IHttpRetryMode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onHttpClientSuccess(com.kugou.common.network.protocol.RequestPackage r5, org.apache.http.HttpResponse r6) {
        /*
            r4 = this;
            r6 = 0
            if (r5 == 0) goto L6
            r4.onNetQuality(r5, r6)
        L6:
            com.kugou.common.network.retry.RetryExtraParam r5 = r4.mRetryExtraParam
            boolean r5 = r5 instanceof com.kugou.common.network.retry.ACKNetgateRetryExtraParam
            java.lang.String r0 = "ACKNetgateHttpRetryMode"
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L31
            boolean r5 = com.kugou.common.network.networkutils.NetLog.isDebug()
            if (r5 == 0) goto L1b
            java.lang.String r5 = "RetryMode(NETGATE) Success"
            com.kugou.common.network.networkutils.NetLog.d(r0, r5)
        L1b:
            com.kugou.common.network.retry.RetryExtraParam r5 = r4.mRetryExtraParam
            r6 = r5
            com.kugou.common.network.retry.ACKNetgateRetryExtraParam r6 = (com.kugou.common.network.retry.ACKNetgateRetryExtraParam) r6
            com.kugou.common.network.netgate.NetgateEntity r5 = r6.mNetgateEntity
            if (r5 == 0) goto L31
            com.kugou.common.network.AbsAckVars r5 = com.kugou.common.network.netgate.AckManager.getAckVars()
            com.kugou.common.network.netgate.NetgateEntity r3 = r6.mNetgateEntity
            java.lang.String r3 = r3.netgate
            boolean r5 = r5.setNetgateAvailable(r3, r1)
            goto L32
        L31:
            r5 = 0
        L32:
            if (r5 == 0) goto L44
            com.kugou.common.network.AbsAckVars r5 = com.kugou.common.network.netgate.AckManager.getAckVars()
            java.lang.String r0 = r6.mOriUrl
            java.lang.String r6 = r6.mUrl
            int r3 = r4.getType()
            r5.markRequest(r0, r6, r3, r1)
            goto L4f
        L44:
            boolean r5 = com.kugou.common.network.networkutils.NetLog.isDebug()
            if (r5 == 0) goto L4f
            java.lang.String r5 = "NETGATE Success operate invalid"
            com.kugou.common.network.networkutils.NetLog.d(r0, r5)
        L4f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.retry.ACKNetgateHttpRetryMode.onHttpClientSuccess(com.kugou.common.network.protocol.RequestPackage, org.apache.http.HttpResponse):int");
    }
}
