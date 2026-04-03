package com.kugou.common.network.retry;

import android.text.TextUtils;
import com.kugou.common.network.networkutils.NetLog;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewACKRetryStrategy implements IWebViewACKRetryStrategy {
    private static volatile IWebViewACKRetryStrategy instance;
    private final String TAG = "WebViewACKRetryStrategy";
    private Map<String, Map<String, String>> ackKeyMap;

    private synchronized void addACK(String str, String str2, String str3) {
        Map<String, String> map = this.ackKeyMap.get(str);
        if (map != null) {
            map.put(str2, str3);
        }
    }

    private synchronized String getACK(String str, String str2) {
        Map<String, String> map;
        map = this.ackKeyMap.get(str);
        return map != null ? map.get(str2) : "";
    }

    private synchronized String getACKRequestOriginHost(String str, String str2) {
        Map<String, String> map = this.ackKeyMap.get(str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (str2.equals(entry.getValue())) {
                    return entry.getKey();
                }
            }
        }
        return str2;
    }

    private String getHost(String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        Matcher matcher = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    public static IWebViewACKRetryStrategy getInstance() {
        if (instance == null) {
            synchronized (WebViewACKRetryStrategy.class) {
                if (instance == null) {
                    instance = new WebViewACKRetryStrategy();
                }
            }
        }
        return instance;
    }

    private boolean isHostEqual(String str, String str2) {
        return TextUtils.equals(str, str2);
    }

    private synchronized void removeACK(String str, String str2) {
        Map<String, String> map = this.ackKeyMap.get(str);
        if (map != null) {
            map.remove(str2);
        }
    }

    private String replaceUrlByAckByKey(String str, String str2, String str3, boolean z) {
        String host;
        String host2 = getHost(str3);
        if (NetLog.isDebug()) {
            NetLog.i("WebViewACKRetryStrategy", "replaceUrlByAckByKey1[" + str + "/" + host2 + "/" + str3 + "]");
        }
        if (TextUtils.isEmpty(str)) {
            str = getACKRequestOriginHost(str2, host2);
        }
        String str4 = TextUtils.isEmpty(str) ? host2 : str;
        String strReplace = (TextUtils.isEmpty(host2) || host2.equals(str)) ? str3 : str3.replace(host2, str);
        if (NetLog.isDebug()) {
            NetLog.i("WebViewACKRetryStrategy", "replaceUrlByAckByKey2[" + str + "/" + host2 + "/" + strReplace + "]");
        }
        if (!TextUtils.isEmpty(getACK(str2, host2))) {
            return strReplace.replace(str4, getACK(str2, host2));
        }
        int i2 = 0;
        String[] strArrGenerateDynamicHostUrls = ACKRetryStrategy.getInstance().generateDynamicHostUrls(new String[]{strReplace});
        if (NetLog.isDebug()) {
            for (int i3 = 0; i3 < strArrGenerateDynamicHostUrls.length; i3++) {
                NetLog.e("WebViewACKRetryStrategy", "replaceUrlByAck,i=" + i3 + "tstring=" + strArrGenerateDynamicHostUrls[i3]);
            }
        }
        if (z) {
            while (true) {
                host = null;
                if (i2 >= strArrGenerateDynamicHostUrls.length) {
                    break;
                }
                host = getHost(strArrGenerateDynamicHostUrls[i2]);
                if (!isHostEqual(host, host2) && TextUtils.isEmpty(getACK(str2, host))) {
                    break;
                }
                i2++;
            }
        } else {
            host = getHost(strArrGenerateDynamicHostUrls[0]);
        }
        if (TextUtils.isEmpty(host) || !TextUtils.isEmpty(getACK(str2, host))) {
            return str3;
        }
        addACK(str2, host2, host);
        if (!isHostEqual(host2, str4)) {
            addACK(str2, str4, host);
        }
        return strReplace.replace(str4, host);
    }

    @Override // com.kugou.common.network.retry.IWebViewACKRetryStrategy
    public String getAckNextUrl(String str, String str2) {
        String host = getHost(str2);
        String aCKRequestOriginHost = getACKRequestOriginHost(str, host);
        ACKRetryStrategy.getInstance().markUrlResult(str2, false);
        if (NetLog.isDebug()) {
            NetLog.e("WebViewACKRetryStrategy", "reload failingUrl=" + str2 + "toriginAckHost=" + aCKRequestOriginHost);
        }
        removeACK(str, aCKRequestOriginHost);
        String strReplaceUrlByAck = replaceUrlByAck(aCKRequestOriginHost, str, str2);
        if (NetLog.isDebug()) {
            NetLog.e("WebViewACKRetryStrategy", "reload newUrl=" + strReplaceUrlByAck);
        }
        if (!host.equals(getHost(strReplaceUrlByAck)) && !TextUtils.isEmpty(getACK(str, aCKRequestOriginHost))) {
            return strReplaceUrlByAck;
        }
        if (!NetLog.isDebug()) {
            return "";
        }
        NetLog.i("WebViewACKRetryStrategy", "getAckNextUrl Sorry,no exist next url.");
        return "";
    }

    @Override // com.kugou.common.network.retry.IWebViewACKRetryStrategy
    public synchronized void initAckMapByKey(String str) {
        if (this.ackKeyMap == null) {
            this.ackKeyMap = new HashMap();
        }
        if (!this.ackKeyMap.containsKey(str)) {
            this.ackKeyMap.put(str, new HashMap());
        }
    }

    @Override // com.kugou.common.network.retry.IWebViewACKRetryStrategy
    public void removeAndmarkFailingHost(String str, String str2) {
        String aCKRequestOriginHost = getACKRequestOriginHost(str, getHost(str2));
        ACKRetryStrategy.getInstance().markUrlResult(str2, false);
        removeACK(str, aCKRequestOriginHost);
        if (NetLog.isDebug()) {
            NetLog.e("hch-ack", "removeAndmarkFailingHost url = " + str2 + " originhost = " + getACK(str, aCKRequestOriginHost));
        }
    }

    @Override // com.kugou.common.network.retry.IWebViewACKRetryStrategy
    public String replaceUrlByAck(String str, String str2) {
        return (str2.startsWith("http://") || str2.startsWith("https://")) ? replaceUrlByAckByKey("", str, str2, false) : str2;
    }

    @Override // com.kugou.common.network.retry.IWebViewACKRetryStrategy
    public synchronized void resetAckMapByKey(String str) {
        if (this.ackKeyMap.containsKey(str)) {
            this.ackKeyMap.remove(str);
        }
    }

    @Override // com.kugou.common.network.retry.IWebViewACKRetryStrategy
    public synchronized void resetAllACKMap() {
        Map<String, Map<String, String>> map = this.ackKeyMap;
        if (map != null) {
            map.clear();
            this.ackKeyMap = null;
        }
    }

    @Override // com.kugou.common.network.retry.IWebViewACKRetryStrategy
    public String replaceUrlByAck(String str, String str2, String str3) {
        return (str3.startsWith("http://") || str3.startsWith("https://")) ? replaceUrlByAckByKey(str, str2, str3, true) : str3;
    }
}
