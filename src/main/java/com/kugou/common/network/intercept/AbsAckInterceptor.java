package com.kugou.common.network.intercept;

import android.net.Uri;
import android.os.Build;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.kugou.common.network.AbsAckVars;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.HostKeyProtocolEntity;
import com.kugou.common.network.networkutils.KGNetworkUtil;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.networkutils.UrlEncoderUtil;
import com.kugou.common.network.retry.IHttpRetryMode;
import com.kugou.common.network.retry.RetryExtraParam;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsAckInterceptor implements Interceptor {
    private static final String HEADER_USER_ID = "KG-FAKE";

    private void addHeaderIfNeeded(String str, List<IHttpRetryMode> list) {
        AbsHttpVars httpVarsImpl;
        RetryExtraParam retryExtraParam;
        Pair<String, String> unifiedGatewayHeader;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty() || (httpVarsImpl = getHttpVarsImpl()) == null) {
            return;
        }
        String host = getHost(str);
        if (TextUtils.isEmpty(host)) {
            return;
        }
        for (IHttpRetryMode iHttpRetryMode : list) {
            if (iHttpRetryMode != null && (retryExtraParam = iHttpRetryMode.getRetryExtraParam()) != null) {
                String host2 = getHost(retryExtraParam.mUrl);
                if (!TextUtils.isEmpty(host2) && (unifiedGatewayHeader = httpVarsImpl.getUnifiedGatewayHeader(host, host2)) != null && !TextUtils.isEmpty((CharSequence) unifiedGatewayHeader.first) && !TextUtils.isEmpty((CharSequence) unifiedGatewayHeader.second)) {
                    if (retryExtraParam.mHeaders == null) {
                        retryExtraParam.mHeaders = new HashMap();
                    }
                    retryExtraParam.mHeaders.put((String) unifiedGatewayHeader.first, (String) unifiedGatewayHeader.second);
                }
            }
        }
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

    private List<String> getNewDomainRetryUrls(List<String> list) {
        AbsHttpVars httpVarsImpl;
        AbsAckVars ackVars;
        String strReplaceDomain;
        if (list == null || list.isEmpty() || (httpVarsImpl = getHttpVarsImpl()) == null) {
            return null;
        }
        String str = list.get(0);
        String host = getHost(str);
        if (TextUtils.isEmpty(host) || (ackVars = AckManager.getAckVars()) == null) {
            return null;
        }
        HostKeyProtocolEntity ackProtocolEntity = ackVars.getAckProtocolEntity(host);
        String newDomain = httpVarsImpl.getNewDomain(str, ackProtocolEntity != null ? ackProtocolEntity.urlHosts : null);
        if (!TextUtils.isEmpty(newDomain) && (strReplaceDomain = replaceDomain(str, newDomain)) != null && !"".equals(strReplaceDomain) && !strReplaceDomain.equals(str)) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(strReplaceDomain);
            return arrayList;
        }
        return null;
    }

    public static String getUserAgent(AbsHttpVars absHttpVars, String str) {
        if (TextUtils.isEmpty(str)) {
            str = UrlEncoderUtil.encode("AutoGen");
        }
        String str2 = "Android" + Build.VERSION.RELEASE.replace(".", "");
        String nameOfPlatformVersion = absHttpVars.getNameOfPlatformVersion();
        String str3 = str2 + "-" + nameOfPlatformVersion;
        String str4 = (str3 + "-" + absHttpVars.getChanelid()) + "-0";
        if (!TextUtils.isEmpty(str)) {
            str4 = str4 + "-" + str;
        }
        String currentNetworkIdentifier = KGNetworkUtil.getCurrentNetworkIdentifier(AckManager.getAckVars().getContext());
        if (TextUtils.isEmpty(currentNetworkIdentifier)) {
            return str4;
        }
        return str4 + "-" + currentNetworkIdentifier;
    }

    private boolean isUnifiedGatewayUrl(AbsHttpVars absHttpVars, IHttpRetryMode iHttpRetryMode) {
        if (absHttpVars != null && iHttpRetryMode != null) {
            String host = iHttpRetryMode.getRetryExtraParam() != null ? getHost(iHttpRetryMode.getRetryExtraParam().mUrl) : null;
            if (!TextUtils.isEmpty(host)) {
                return absHttpVars.isUnifiedGateway(host);
            }
        }
        return false;
    }

    private void printLog(int i2, IHttpRetryMode iHttpRetryMode) {
        if (NetLog.isDebug()) {
            NetLog.d("zlx_net", "retryCount: " + i2);
            NetLog.d("zlx_net", "retryUrl: " + iHttpRetryMode.getProtocolType() + " " + iHttpRetryMode.getRetryExtraParam().mUrl);
        }
    }

    private String replaceDomain(String str, String str2) {
        String str3;
        String str4;
        try {
            URI uri = new URI(str);
            int port = uri.getPort();
            String rawPath = uri.getRawPath();
            String rawQuery = uri.getRawQuery();
            String rawFragment = uri.getRawFragment();
            StringBuilder sb = new StringBuilder();
            sb.append(uri.getScheme());
            sb.append("://");
            sb.append(str2);
            String str5 = "";
            if (port == -1 || port == 80) {
                str3 = "";
            } else {
                str3 = ":" + port;
            }
            sb.append(str3);
            if (TextUtils.isEmpty(rawPath)) {
                rawPath = "";
            }
            sb.append(rawPath);
            if (TextUtils.isEmpty(rawQuery)) {
                str4 = "";
            } else {
                str4 = "?" + rawQuery;
            }
            sb.append(str4);
            if (!TextUtils.isEmpty(rawFragment)) {
                str5 = TopicHighlightHelper.SHARP + rawFragment;
            }
            sb.append(str5);
            return sb.toString();
        } catch (URISyntaxException e2) {
            NetLog.uploadException(e2);
            return null;
        }
    }

    public abstract AbsHttpVars getHttpVarsImpl();

    /* JADX WARN: Can't wrap try/catch for region: R(29:39|(1:41)|42|(1:50)(1:49)|51|(3:53|(2:56|54)|199)|57|(1:61)|62|(1:64)|65|(2:(1:68)(1:69)|70)(1:71)|(2:178|72)|(7:74|(18:180|76|(1:90)(8:80|81|(3:174|83|203)|202|84|85|(1:87)(1:88)|89)|91|121|122|(2:182|124)|125|(1:127)|128|(3:191|133|134)|135|(2:137|(2:139|(3:192|141|142))(2:143|(2:193|147)))|148|183|149|150|(2:194|152)(1:197))(2:94|(1:116)(18:98|(3:102|(5:104|105|176|106|201)|200)|107|(3:109|110|111)(1:112)|113|122|(0)|125|(0)|128|(4:130|191|133|134)|135|(0)|148|183|149|150|(0)(0)))|159|160|161|(1:163)|(4:195|165|(1:167)|168)(1:198))(1:119)|120|121|122|(0)|125|(0)|128|(0)|135|(0)|148|183|149|150|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0363, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0364, code lost:
    
        r5 = r21;
     */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02e5 A[Catch: Exception -> 0x0367, TryCatch #4 {Exception -> 0x0367, blocks: (B:122:0x02d0, B:124:0x02d7, B:125:0x02df, B:127:0x02e5, B:128:0x02e8, B:133:0x02fc, B:139:0x0309, B:141:0x0313, B:145:0x0327, B:111:0x02a3, B:113:0x02b3), top: B:182:0x02d7 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0362 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x039d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03b0 A[SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r30) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1015
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.intercept.AbsAckInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
