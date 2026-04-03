package com.kugou.common.network.retry;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.RFCode;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckProtocal;
import com.kugou.common.network.netgate.NetgateEntity;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.protocol.ResponsePackage;
import com.kugou.common.network.proxy.KGHttpProxy;
import com.kugou.common.network.retry.RetryConfigInfo;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ACKRetryStrategy implements IRetryStrategy {
    private static final String TAG = "ACKRetryStrategy";
    private static volatile ACKRetryStrategy mInstance;

    private boolean addAckDnsRetryMode(String str, int i2, List<IHttpRetryMode> list, boolean z, @NonNull AbsHttpVars absHttpVars, int i3) {
        List<IHttpRetryMode> listMakeHttpRetryMode = ACKDnsHttpRetryMode.makeHttpRetryMode(str, list.size() > 0 ? list.get(list.size() - 1) : null, z, absHttpVars, i3);
        if (listMakeHttpRetryMode == null || listMakeHttpRetryMode.size() <= 0) {
            AckManager.getAckVars().markRequest(str, null, 111, -2);
            return false;
        }
        boolean z2 = false;
        for (int i4 = 0; i4 < listMakeHttpRetryMode.size(); i4++) {
            IHttpRetryMode iHttpRetryMode = listMakeHttpRetryMode.get(i4);
            if (iHttpRetryMode != null) {
                if (NetLog.isDebug()) {
                    NetLog.d(TAG, "add retryMode(" + listMakeHttpRetryMode.get(i4).getType() + "), record(" + i2 + ")");
                }
                if (iHttpRetryMode.getHttpProxy() == null) {
                    list.add(listMakeHttpRetryMode.get(i4));
                }
                z2 = true;
            }
        }
        return z2;
    }

    private boolean addDnsRetryMode(String str, int i2, List<IHttpRetryMode> list, boolean z, @NonNull AbsHttpVars absHttpVars, int i3) {
        IHttpRetryMode iHttpRetryModeMakeHttpRetryMode = DNSHttpRetryMode.makeHttpRetryMode(str, list.size() > 0 ? list.get(list.size() - 1) : null, z, absHttpVars, i3);
        if (iHttpRetryModeMakeHttpRetryMode == null) {
            AckManager.getAckVars().markRequest(str, null, 112, -2);
            return false;
        }
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "add retryMode(" + iHttpRetryModeMakeHttpRetryMode.getType() + "), record(" + i2 + ")");
        }
        list.add(iHttpRetryModeMakeHttpRetryMode);
        return true;
    }

    private boolean addHttpRetryMode(@NonNull List<List<IHttpRetryMode>> list, @NonNull List<List<IHttpRetryMode>> list2, String str, int i2, int i3, boolean z, @NonNull AbsHttpVars absHttpVars, int i4) {
        int i5;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (i2 == -1) {
            i5 = 2;
        } else if (i2 == 0) {
            i5 = 1;
        } else {
            if (i2 != 1) {
                return false;
            }
            i5 = 0;
        }
        if (i3 == 0) {
            return addAckDnsRetryMode(str, i2, list.get(i5), z, absHttpVars, i4);
        }
        if (i3 == 1) {
            return addDnsRetryMode(str, i2, list.get(i5), z, absHttpVars, i4);
        }
        if (i3 != 2) {
            return false;
        }
        return addNetgateRetryMode(str, i2, list2.get(i5), z, absHttpVars, i4);
    }

    private boolean addNetgateRetryMode(String str, int i2, List<IHttpRetryMode> list, boolean z, @NonNull AbsHttpVars absHttpVars, int i3) {
        List<NetgateEntity> netgate = AckManager.getAckVars().getNetgate(str);
        Pair<String, String> schemeHostPair = HttpRetryManager.getSchemeHostPair(str);
        if (schemeHostPair == null || netgate == null || netgate.size() <= 0) {
            AckManager.getAckVars().markRequest(str, null, 113, -2);
            return false;
        }
        boolean z2 = false;
        for (int i4 = 0; i4 < netgate.size(); i4++) {
            IHttpRetryMode iHttpRetryModeMakeHttpRetryMode = ACKNetgateHttpRetryMode.makeHttpRetryMode((String) schemeHostPair.second, netgate.get(i4), list.size() > 0 ? list.get(list.size() - 1) : null, z, absHttpVars, i3);
            if (iHttpRetryModeMakeHttpRetryMode != null && iHttpRetryModeMakeHttpRetryMode.getHttpProxy() == null) {
                if (NetLog.isDebug()) {
                    NetLog.d(TAG, "add retryMode(" + iHttpRetryModeMakeHttpRetryMode.getType() + "), record(" + i2 + ")");
                }
                list.add(iHttpRetryModeMakeHttpRetryMode);
                z2 = true;
            }
        }
        return z2;
    }

    private boolean addProtocolRetryMode(String str, List<IHttpRetryMode> list, boolean z, @NonNull AbsHttpVars absHttpVars, int i2) {
        Pair<String, String> schemeHostPair = HttpRetryManager.getSchemeHostPair(str);
        if (schemeHostPair == null) {
            return false;
        }
        List<IHttpRetryMode> listMakeHttpRetryMode = ACKProtocolRetryMode.makeHttpRetryMode(str, schemeHostPair, list.size() > 0 ? list.get(list.size() - 1) : null, z, absHttpVars, i2);
        if (listMakeHttpRetryMode == null || listMakeHttpRetryMode.size() <= 0) {
            return false;
        }
        for (IHttpRetryMode iHttpRetryMode : listMakeHttpRetryMode) {
            int protocolType = iHttpRetryMode.getProtocolType();
            if (protocolType == 1 || protocolType == 2) {
                KGHttpProxy httpProxy = iHttpRetryMode.getHttpProxy();
                if (httpProxy == null || httpProxy.isHttpsEnableProxy()) {
                    list.add(iHttpRetryMode);
                }
            } else {
                list.add(iHttpRetryMode);
            }
        }
        return list.size() > 0;
    }

    private List<IHttpRetryMode> generateRetryMechanismInner(List<String> list, boolean z, @NonNull AbsHttpVars absHttpVars) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList.add(new ArrayList());
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < 3; i4++) {
            arrayList2.add(new ArrayList());
        }
        for (String str : new ArrayList(list)) {
            if (!TextUtils.isEmpty(str)) {
                RetryConfigInfo retryConfigInfo = AckManager.getAckVars().getRetryConfigInfo(str);
                prepareDnsRetryMode(arrayList, arrayList2, str, retryConfigInfo, z, absHttpVars, retryConfigInfo == null ? RFCode.ACK_RETRY_STRATEGY_RETRY_INFO_NULL : retryConfigInfo.version);
            }
        }
        while (true) {
            if (i2 >= 3) {
                break;
            }
            Iterator<IHttpRetryMode> it = arrayList2.get(i2).iterator();
            if (it.hasNext()) {
                arrayList.get(i2).add(it.next());
                break;
            }
            i2++;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<List<IHttpRetryMode>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.addAll(it2.next());
        }
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "=====================");
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                NetLog.d(TAG, String.valueOf((IHttpRetryMode) it3.next()));
            }
        }
        return arrayList3;
    }

    public static synchronized ACKRetryStrategy getInstance() {
        if (mInstance == null) {
            synchronized (ACKRetryStrategy.class) {
                if (mInstance == null) {
                    mInstance = new ACKRetryStrategy();
                }
            }
        }
        return mInstance;
    }

    private boolean isStaticsReqeustPackage(RequestPackage requestPackage) {
        return (requestPackage instanceof AbsHttpClient.IStaticsRequest) && ((AbsHttpClient.IStaticsRequest) requestPackage).isStaticsReqeustPackage();
    }

    private boolean isUnifiedGatewayUrl(String str, AbsHttpVars absHttpVars) {
        String host;
        if (!TextUtils.isEmpty(str) && absHttpVars != null) {
            try {
                Uri uri = Uri.parse(str);
                if (uri != null && (host = uri.getHost()) != null) {
                    return absHttpVars.isUnifiedGateway(host);
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void prepareDnsRetryMode(@NonNull List<List<IHttpRetryMode>> list, @NonNull List<List<IHttpRetryMode>> list2, String str, RetryConfigInfo retryConfigInfo, boolean z, @NonNull AbsHttpVars absHttpVars, int i2) {
        boolean zAddHttpRetryMode = false;
        if (retryConfigInfo != null) {
            List<RetryConfigInfo.RetryRecord> list3 = retryConfigInfo.mRetryRecords;
            RetryConfigInfo.RetryRecord retryRecord = retryConfigInfo.originHostRecord;
            boolean z2 = AckManager.getAckVars().isEnableProtocolRetry() && addProtocolRetryMode(str, list.get(0), z, absHttpVars, i2);
            if (list3 == null || list3.isEmpty()) {
                boolean z3 = (isUnifiedGatewayUrl(str, absHttpVars) && z2) ? false : true;
                if (retryRecord == null || !z3) {
                    zAddHttpRetryMode = z2;
                } else {
                    int[] iArr = retryConfigInfo.originHostRecord.records;
                    zAddHttpRetryMode = z2;
                    for (int i3 = 0; i3 < iArr.length; i3++) {
                        zAddHttpRetryMode |= addHttpRetryMode(list, list2, str, iArr[i3], i3, z, absHttpVars, i2);
                    }
                }
            } else {
                Iterator<RetryConfigInfo.RetryRecord> it = list3.iterator();
                boolean zAddHttpRetryMode2 = z2;
                while (it.hasNext()) {
                    RetryConfigInfo.RetryRecord next = it.next();
                    String strUrlMakeNewDomain = urlMakeNewDomain(str, next.domain);
                    int i4 = 0;
                    while (i4 < 3) {
                        zAddHttpRetryMode2 |= addHttpRetryMode(list, list2, strUrlMakeNewDomain, next.records[i4], i4, z, absHttpVars, i2);
                        i4++;
                        next = next;
                    }
                }
                zAddHttpRetryMode = zAddHttpRetryMode2 | addHttpRetryMode(list, list2, str, retryConfigInfo.originHostRecord.records[2], 2, z, absHttpVars, i2);
            }
        }
        if (zAddHttpRetryMode) {
            return;
        }
        try {
            list.get(1).add(DNSHttpRetryMode.makeHttpRetryMode(str, null, z, absHttpVars, i2));
        } catch (Exception e2) {
            NetLog.uploadException(e2);
        }
    }

    private String urlMakeNewDomain(String str, String str2) {
        String str3;
        try {
            URI uri = new URI(str);
            int port = uri.getPort();
            StringBuilder sb = new StringBuilder();
            sb.append(uri.getScheme());
            sb.append("://");
            sb.append(str2);
            String str4 = "";
            if (port == -1 || port == 80) {
                str3 = "";
            } else {
                str3 = ":" + port;
            }
            sb.append(str3);
            sb.append(!TextUtils.isEmpty(uri.getRawPath()) ? uri.getRawPath() : "");
            if (!TextUtils.isEmpty(uri.getRawQuery())) {
                str4 = "?" + uri.getRawQuery();
            }
            sb.append(str4);
            return sb.toString();
        } catch (URISyntaxException e2) {
            NetLog.uploadException(e2);
            return null;
        }
    }

    @Override // com.kugou.common.network.retry.IRetryStrategy
    public void beforeStartRetry(RequestPackage requestPackage, ResponsePackage<Object> responsePackage, AbsHttpClient absHttpClient) {
        if ((requestPackage instanceof AckProtocal.AckRequestPackage) || isStaticsReqeustPackage(requestPackage)) {
            return;
        }
        AckManager.getAckVars().setLastNetworkActiveMillies(System.currentTimeMillis());
    }

    public String[] generateDynamicHostUrls(String[] strArr) {
        int[] iArr;
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 3; i2++) {
            arrayList.add(new ArrayList());
        }
        for (String str : strArr) {
            RetryConfigInfo retryConfigInfo = AckManager.getAckVars().getRetryConfigInfo(str);
            if (retryConfigInfo == null || retryConfigInfo.mRetryRecords.isEmpty()) {
                ((ArrayList) arrayList.get(1)).add(str);
            } else {
                boolean z = false;
                for (RetryConfigInfo.RetryRecord retryRecord : retryConfigInfo.mRetryRecords) {
                    if (retryRecord != null && !TextUtils.isEmpty(retryRecord.domain) && (iArr = retryRecord.records) != null && iArr.length >= 2) {
                        String strUrlMakeNewDomain = urlMakeNewDomain(str, retryRecord.domain);
                        if (!TextUtils.isEmpty(strUrlMakeNewDomain)) {
                            int i3 = 0;
                            while (true) {
                                int[] iArr2 = RetryConfigInfo.RECORD_STATES;
                                if (i3 < iArr2.length - 1) {
                                    if (retryRecord.records[1] == iArr2[i3]) {
                                        ((ArrayList) arrayList.get(i3)).add(strUrlMakeNewDomain);
                                        z = true;
                                    }
                                    i3++;
                                }
                            }
                        }
                    }
                }
                if (!z) {
                    ((ArrayList) arrayList.get(1)).add(str);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll((ArrayList) it.next());
        }
        return arrayList2.isEmpty() ? strArr : (String[]) arrayList2.toArray(new String[0]);
    }

    @Override // com.kugou.common.network.retry.IRetryStrategy
    public List<IHttpRetryMode> generateRetryMechanism(List<String> list, boolean z, AbsHttpVars absHttpVars) {
        return generateRetryMechanismInner(list, z, absHttpVars);
    }

    @Override // com.kugou.common.network.retry.IRetryStrategy
    public RetryStaticsLOG getRetryStatics(Context context) {
        return AckManager.getAckVars().getRetryStaticsLOG();
    }

    public void markUrlResult(String str, boolean z) {
        AckManager.getAckVars().markRequest(str, str, 112, z ? 1 : -1);
    }

    @Override // com.kugou.common.network.retry.IRetryStrategy
    public void beforeStartRetry(RequestPackage requestPackage, AbsHttpClient.IStreamHandler iStreamHandler, AbsHttpClient absHttpClient) {
        if ((requestPackage instanceof AckProtocal.AckRequestPackage) || isStaticsReqeustPackage(requestPackage)) {
            return;
        }
        AckManager.getAckVars().setLastNetworkActiveMillies(System.currentTimeMillis());
    }
}
