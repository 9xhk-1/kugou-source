package com.kugou.common.network.retry;

/* JADX INFO: loaded from: classes2.dex */
public class AckRetryUtils {
    public static boolean isErrorHtml(String str) {
        if (str != null) {
            return !(str.contains("<meta") || str.contains("<head><head></head><body></body></head>")) || str.contains("<title>网页无法打开</title>");
        }
        return true;
    }
}
