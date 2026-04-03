package com.kugou.common.network.retry;

/* JADX INFO: loaded from: classes2.dex */
public interface IWebViewACKRetryStrategy {
    String getAckNextUrl(String str, String str2);

    void initAckMapByKey(String str);

    void removeAndmarkFailingHost(String str, String str2);

    String replaceUrlByAck(String str, String str2);

    String replaceUrlByAck(String str, String str2, String str3);

    void resetAckMapByKey(String str);

    void resetAllACKMap();
}
