package com.kugou.framework.libcommon;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import com.kugou.framework.libcommon.netcore.HTTPConnection;
import com.kugou.framework.libcommon.netcore.HTTPSConnection;
import com.kugou.framework.libcommon.netcore.HttpBasicRequest;
import com.kugou.framework.libcommon.netcore.HttpEntity;
import com.kugou.framework.musichunter.Global;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class KGHttpClient {
    private static Context mContext;
    private static volatile RequestProxy requestProxy;
    private boolean mEnableKugouResTag;
    private final String TAG = "KGHttpClient";
    private int mConnTimeOut = 10000;
    private int mReadTimeOut = 10000;

    public interface IHttpProperty {
        boolean onContentType(String str);

        boolean onHeaders(Map<String, List<String>> map);

        boolean onResponseCode(int i2);
    }

    public static class KGAdapterRequest extends HttpBasicRequest {
        private RequestPackage kgPackage;

        public KGAdapterRequest(RequestPackage requestPackage) {
            super(requestPackage.getUrl(), requestPackage.getRequestType());
            this.kgPackage = requestPackage;
        }

        @Override // com.kugou.framework.libcommon.netcore.HttpBasicRequest
        public String getContentType() {
            HttpEntity postRequestEntity = this.kgPackage.getPostRequestEntity();
            if (postRequestEntity != null) {
                return postRequestEntity.getContentType();
            }
            return null;
        }

        @Override // com.kugou.framework.libcommon.netcore.HttpBasicRequest
        public byte[] getData() {
            HttpEntity postRequestEntity = this.kgPackage.getPostRequestEntity();
            if (postRequestEntity != null) {
                return postRequestEntity.getBody();
            }
            return null;
        }

        @Override // com.kugou.framework.libcommon.netcore.HttpBasicRequest
        public Map<String, Object> getRequestMapParams() {
            return this.kgPackage.getRequestMapParams();
        }

        @Override // com.kugou.framework.libcommon.netcore.HttpBasicRequest
        public Map<String, String> getRequestProperties() {
            Map<String, String> httpHeaders = this.kgPackage.getHttpHeaders();
            if (httpHeaders == null) {
                httpHeaders = new HashMap<>();
            }
            if (!httpHeaders.containsKey("Accept-Encoding")) {
                httpHeaders.put("Accept-Encoding", "gzip, deflate");
            }
            httpHeaders.put("KG-USER-AGENT", KGHttpClient.getNameOfPlatformVersion() + "-kugoumusic-107");
            return httpHeaders;
        }
    }

    public KGHttpClient() {
        initConfigParams();
    }

    private boolean checkContentType(BaseConnection baseConnection, Object obj) {
        try {
            if (obj instanceof IHttpProperty) {
                return ((IHttpProperty) obj).onContentType(baseConnection.getResponseHeader("Content-Type"));
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    private boolean checkHeaders(Map<String, List<String>> map, Object obj) {
        if (obj instanceof IHttpProperty) {
            return ((IHttpProperty) obj).onHeaders(map);
        }
        return true;
    }

    private boolean checkResponseCode(int i2, Object obj) {
        if (obj instanceof IHttpProperty) {
            return ((IHttpProperty) obj).onResponseCode(i2);
        }
        return true;
    }

    private void doCustomRequest(RequestPackage requestPackage, ResponsePackage<?> responsePackage) throws Exception {
        String str;
        String url = requestPackage.getUrl();
        try {
            String getRequestParams = requestPackage.getGetRequestParams();
            if (url.endsWith("?")) {
                str = url + getRequestParams;
            } else {
                str = url + "?" + getRequestParams;
            }
            LogUtils.logNet("custom 开始请求：" + str);
            CustomResponse customResponseDoRequest = requestProxy.doRequest(str, new KGAdapterRequest(requestPackage));
            if (customResponseDoRequest != null) {
                byte[] bArr = customResponseDoRequest.bytes;
                int i2 = customResponseDoRequest.status;
                LogUtils.logNet("custom responseBody status:" + i2);
                if (i2 != 200 && i2 != 206) {
                    LogUtils.logNet("custom responseBody is null");
                    return;
                }
                responsePackage.setContext(bArr);
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void doRequest(RequestPackage requestPackage, ResponsePackage<?> responsePackage) throws Exception {
        String str;
        byte[] kugouResTag;
        String url = requestPackage.getUrl();
        try {
            String getRequestParams = requestPackage.getGetRequestParams();
            if (url.endsWith("?")) {
                str = url + getRequestParams;
            } else {
                str = url + "?" + getRequestParams;
            }
            LogUtils.logNet("开始请求：" + str);
            BaseConnection connection = getConnection(str);
            byte[] bArrDoRequest = connection.doRequest(new KGAdapterRequest(requestPackage));
            int responseCode = connection.getResponseCode();
            if (!checkResponseCode(responseCode, responsePackage) || (responseCode != 200 && responseCode != 206)) {
                LogUtils.logNet("Code:" + connection.getResponseCode() + ";Messag:" + connection.getResponseMessage());
                LogUtils.logNet("responseBody is null");
                return;
            }
            if (!checkContentType(connection, responsePackage)) {
                throw new Exception("wrong Content-Type");
            }
            if (!checkHeaders(connection.getResponseAllHeaders(), responsePackage)) {
                throw new Exception("disagree HTTP headers");
            }
            if (this.mEnableKugouResTag && (kugouResTag = parseKugouResTag(bArrDoRequest)) != null) {
                bArrDoRequest = kugouResTag;
            }
            responsePackage.setContext(bArrDoRequest);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String getCurrentNet2GType(Context context) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(0)) == null || !networkInfo.isConnected()) ? "cmnet" : "cmwap".equalsIgnoreCase(networkInfo.getExtraInfo()) ? "cmwap" : "cmnet";
        } catch (Exception unused) {
            return "cmnet";
        }
    }

    public static KGHttpClient getInstance(Context context) {
        mContext = context;
        return new KGHttpClient();
    }

    public static String getNameOfPlatformVersion() {
        return "AndroidPhone-" + String.valueOf(7100);
    }

    private static String getNetwork2gType(Context context) {
        return getNetworkType4G(context).equals("2G") ? getCurrentNet2GType(context) : "cmnet";
    }

    public static String getNetworkType4G(Context context) {
        return NetworkUtils.getNetworkType4G(context);
    }

    private void initConfigParams() {
        this.mConnTimeOut = 10000;
        this.mReadTimeOut = 10000;
    }

    private static boolean isCmwap(Context context) {
        return "cmwap".equals(getNetwork2gType(context));
    }

    private byte[] parseKugouResTag(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null && bArr.length != 0) {
            int i2 = 0;
            int iSearchTag = searchTag(bArr, 0, "<!--KG_TAG_RES_START-->".getBytes());
            if (iSearchTag < 0) {
                return null;
            }
            int i3 = iSearchTag + 23;
            int iSearchTag2 = searchTag(bArr, i3, "<!--KG_TAG_RES_END-->".getBytes());
            if (iSearchTag2 >= 0 && iSearchTag2 >= i3) {
                int i4 = iSearchTag2 - i3;
                bArr2 = new byte[i4];
                while (i2 < i4) {
                    bArr2[i2] = bArr[i3];
                    i2++;
                    i3++;
                }
            }
        }
        return bArr2;
    }

    private int searchTag(byte[] bArr, int i2, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0 && bArr.length >= bArr2.length + i2) {
            byte b = bArr2[0];
            boolean zTagHasUniqeHeader = tagHasUniqeHeader(bArr2);
            while (bArr2.length + i2 <= bArr.length) {
                int i3 = i2 + 1;
                if (bArr[i2] == b) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= bArr2.length) {
                            break;
                        }
                        int i5 = i2 + i4;
                        if (bArr[i5] == bArr2[i4]) {
                            i4++;
                        } else if (zTagHasUniqeHeader) {
                            i3 = i5;
                        }
                    }
                    if (i4 == bArr2.length) {
                        return i2;
                    }
                }
                i2 = i3;
            }
        }
        return -1;
    }

    public static void setRequestProxy(RequestProxy requestProxy2) {
        requestProxy = requestProxy2;
    }

    private boolean tagHasUniqeHeader(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return false;
        }
        if (bArr.length == 1) {
            return true;
        }
        byte b = bArr[0];
        for (int i2 = 1; i2 < bArr.length; i2++) {
            if (bArr[i2] == b) {
                return false;
            }
        }
        return true;
    }

    public BaseConnection getConnection(String str) {
        Proxy proxy = (Global.getGlobalContext() == null || !isCmwap(Global.getGlobalContext())) ? null : new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.172", 80));
        BaseConnection hTTPSConnection = str.startsWith("https:") ? new HTTPSConnection(str, proxy) : new HTTPConnection(str, proxy);
        hTTPSConnection.setTimeOut(this.mConnTimeOut, this.mReadTimeOut);
        return hTTPSConnection;
    }

    public void request(RequestPackage requestPackage, ResponsePackage<?> responsePackage) throws Exception {
        try {
            if (requestProxy != null) {
                doCustomRequest(requestPackage, responsePackage);
            } else {
                doRequest(requestPackage, responsePackage);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        }
    }

    public void resetTimeOut(int i2, int i3) {
        this.mConnTimeOut = i2;
        this.mReadTimeOut = i3;
    }
}
