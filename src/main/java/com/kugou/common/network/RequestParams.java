package com.kugou.common.network;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.KGHttpCache;
import com.kugou.common.network.networkutils.KGNetworkUtil;
import com.kugou.common.network.networkutils.UrlEncoderUtil;
import com.kugou.common.network.protocol.AbstractMultiUrlRequestPackage;
import com.kugou.common.network.protocol.RequestPackage;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

/* JADX INFO: loaded from: classes2.dex */
public class RequestParams {
    private Header[] allHeader;
    private KGHttpCache.Entry cacheEntry;
    private String getRequestParams;
    public String jsonScheme = null;
    private KGHttpCache kgHttpCache;
    private HttpEntity postRequestEntity;
    private RequestPackage requestPkg;
    private String url;

    public RequestParams(RequestPackage requestPackage) {
        this.requestPkg = requestPackage;
    }

    public void addHeader(Header header) {
        Header[] httpHeaders = getHttpHeaders();
        if (httpHeaders == null) {
            this.allHeader = new Header[]{header};
            return;
        }
        Header[] headerArr = new Header[httpHeaders.length + 1];
        this.allHeader = headerArr;
        System.arraycopy(httpHeaders, 0, headerArr, 0, httpHeaders.length);
        this.allHeader[httpHeaders.length] = header;
    }

    public KGHttpCache.Entry getCacheEntry() {
        return this.cacheEntry;
    }

    public String getGetRequestParams() {
        if (this.getRequestParams == null) {
            this.getRequestParams = this.requestPkg.getGetRequestParams();
        }
        return this.getRequestParams;
    }

    public Header[] getHttpHeaders() {
        if (this.allHeader == null) {
            this.allHeader = this.requestPkg.getHttpHeaders();
        }
        return this.allHeader;
    }

    public String getJsonScheme() {
        return this.jsonScheme;
    }

    public KGHttpCache getKgHttpCache() {
        return this.kgHttpCache;
    }

    public HttpEntity getPostRequestEntity() {
        if (this.postRequestEntity == null) {
            this.postRequestEntity = this.requestPkg.getPostRequestEntity();
        }
        return this.postRequestEntity;
    }

    public RequestPackage getRequestPkg() {
        return this.requestPkg;
    }

    public String getRequestType() {
        return this.requestPkg.getRequestType();
    }

    public String getUrl() {
        if (this.url == null) {
            this.url = this.requestPkg.getUrl();
        }
        return this.url;
    }

    public String getUserAgent(Context context, AbsHttpVars absHttpVars) {
        RequestPackage requestPackage = this.requestPkg;
        String strEncode = requestPackage == null ? "" : UrlEncoderUtil.encode(requestPackage.getRequestModuleName());
        String str = "Android" + Build.VERSION.RELEASE.replace(".", "");
        String nameOfPlatformVersion = absHttpVars.getNameOfPlatformVersion();
        String str2 = str + "-" + nameOfPlatformVersion;
        String str3 = (str2 + "-" + absHttpVars.getChanelid()) + "-0";
        if (!TextUtils.isEmpty(strEncode)) {
            str3 = str3 + "-" + strEncode;
        }
        String currentNetworkIdentifier = KGNetworkUtil.getCurrentNetworkIdentifier(context);
        if (TextUtils.isEmpty(currentNetworkIdentifier)) {
            return str3;
        }
        return str3 + "-" + currentNetworkIdentifier;
    }

    public boolean isMultiUrlReqPkg() {
        return this.requestPkg instanceof AbstractMultiUrlRequestPackage;
    }

    public boolean isNetTrafficTask() {
        RequestPackage requestPackage = this.requestPkg;
        return (requestPackage instanceof AbsHttpClient.IStaticsRequest) && ((AbsHttpClient.IStaticsRequest) requestPackage).isNetTrafficTask();
    }

    public boolean isStaticsRequestPackage() {
        RequestPackage requestPackage = this.requestPkg;
        return (requestPackage instanceof AbsHttpClient.IStaticsRequest) && ((AbsHttpClient.IStaticsRequest) requestPackage).isStaticsReqeustPackage();
    }

    public boolean isUrlExtension() {
        return this.requestPkg instanceof AbsHttpClient.IUrlExtension;
    }

    public void setCacheEntry(KGHttpCache.Entry entry) {
        this.cacheEntry = entry;
    }

    public void setHttpCache(KGHttpCache kGHttpCache) {
        this.kgHttpCache = kGHttpCache;
    }

    public void setJsonScheme(String str) {
        this.jsonScheme = str;
    }

    public String toString() {
        return "RequestParams{method='" + getRequestType() + "'url='" + this.url + "'scheme='" + this.jsonScheme + "'}";
    }
}
