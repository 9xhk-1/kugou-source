package com.kugou.framework.libcommon.netcore;

import com.kugou.framework.libcommon.INoProguard;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class HttpBasicRequest implements INoProguard {
    public static String GET = "GET";
    public static String POST = "POST";
    public String method;
    public String url;
    public long requestTime = 0;
    public HashMap<String, String> cookieInfo = new HashMap<>();

    public HttpBasicRequest(String str, String str2) {
        this.url = str;
        this.method = str2;
    }

    public String getContentType() {
        return null;
    }

    public abstract byte[] getData();

    public abstract Map<String, Object> getRequestMapParams();

    public Map<String, String> getRequestProperties() {
        return new HashMap();
    }

    public void setRequestTime(long j) {
        this.requestTime = j;
    }
}
