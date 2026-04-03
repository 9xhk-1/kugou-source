package com.kugou.common.network;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.common.network.KGHttpCache;
import com.kugou.common.network.NetModeControler;
import com.kugou.common.network.cache.CacheStrategy;
import com.kugou.common.network.exception.ServerFlowControlException;
import com.kugou.common.network.intercept.SSAInterceptor;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.netgate.AckProtocolTypeUtil;
import com.kugou.common.network.netgate.HostKeyProtocolEntity;
import com.kugou.common.network.networkutils.KGNetworkUtil;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.protocol.AbstractLastUrlResponsePackage;
import com.kugou.common.network.protocol.AbstractMultiUrlRequestPackage;
import com.kugou.common.network.protocol.ProtocolFeature;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.protocol.ResponsePackage;
import com.kugou.common.network.proxy.KGHttpProxy;
import com.kugou.common.network.proxy.ReverseProxyHost;
import com.kugou.common.network.quic.CronetApacheClient;
import com.kugou.common.network.quic.CronetHandler;
import com.kugou.common.network.retry.ACKNetgateHttpRetryMode;
import com.kugou.common.network.retry.DefaultRetryStrategy;
import com.kugou.common.network.retry.IHttpRetryMode;
import com.kugou.common.network.retry.IRetryStrategy;
import com.kugou.common.network.retry.RetryDetail;
import com.kugou.common.network.retry.RetryExtraParam;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import h.a.b.m;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.Call;
import okhttp3.Headers;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsHttpClient implements Observer {
    public static final String GB2312 = "GB2312";
    private static final String HEADER_USER_ID = "KG-FAKE";
    public static final int SC_CUSTOM_LIMIT = 800;
    public static final int SC_PRIVATE = 600;
    private static final String TAG = "AbsHttpClient";
    private KGHttpCache cache;
    public OKHttpCallWrapper callWrapper;
    private boolean canUseProxy;
    public CronetCallWrapper cronetCallWrapper;
    private String cronetRealProtocol;
    private long curThreadId;
    private String currentConnectionIp;
    private boolean disableOffline;
    private String firstIp;
    private String firstURL;
    private boolean hasUsedProxy;
    private HttpParams httpParams;
    private boolean isCustomTimeOut;
    private boolean isEnableACK;
    private boolean isHttpKeepAlive;
    private String lastIp;
    private List<ACKTraceRecord> mACKTraceList;
    private ACKTraceRecord mACKTraceRecord;
    private int mConnTimeOut;
    private Context mContext;
    private boolean mEnableKugouResTag;
    private EnumSet<ProtocolFeature> mFeatures;
    public HttpClient mHttpClient;
    private AbsHttpVars mHttpVariables;
    private INetworkState mINetworkState;
    private IHttpRetryMode mLastRetryMode;
    private long mMaxWaitTime;
    private long mReadContentBytes;
    private int mReadTimeOut;
    private RequestDelay mRequestDelay;
    private long mRequestTime;
    private IRequestUrlReceiver mRequestUrlReceiver;
    private int mRetryCount;
    private RetryStaticsLOG mRetryStaticsLOG;
    private IRetryStrategy mRetryStrategy;
    private boolean mUseExpireDataWhenNoNet;
    private boolean monitorEnable;
    private int netMode;
    public SchemeCallBack schemeCallBack;
    private String serverIp;
    public String stackHash;

    public class ConnectUrl {
        public String url;

        private ConnectUrl() {
        }
    }

    public static class CronetCallWrapper {
        public m urlRequest;
    }

    public class CustomSSLHttpClient extends DefaultHttpClient {
        private int port;
        private String scheme;

        public CustomSSLHttpClient(String str, int i2) {
            this.scheme = str;
            this.port = i2;
        }

        @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
        public ClientConnectionManager createClientConnectionManager() {
            int i2;
            int i3;
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            try {
                KugouSocketFactory kugouSocketFactory = new KugouSocketFactory();
                int i4 = 80;
                if ("http".equals(this.scheme) && (i3 = this.port) > 0) {
                    i4 = i3;
                }
                schemeRegistry.register(new Scheme("http", kugouSocketFactory, i4));
                KugouSSLSocketFactory kugouSSLSocketFactory = AbsHttpClient.this.new KugouSSLSocketFactory(null);
                int i5 = 443;
                if (AckProtocolTypeUtil.HTTPS_LABEL.equals(this.scheme) && (i2 = this.port) > 0) {
                    i5 = i2;
                }
                schemeRegistry.register(new Scheme(AckProtocolTypeUtil.HTTPS_LABEL, kugouSSLSocketFactory, i5));
            } catch (KeyManagementException e2) {
                e2.printStackTrace();
            } catch (KeyStoreException e3) {
                e3.printStackTrace();
            } catch (NoSuchAlgorithmException e4) {
                e4.printStackTrace();
            } catch (UnrecoverableKeyException e5) {
                e5.printStackTrace();
            }
            return new SingleClientConnManager(getParams(), schemeRegistry);
        }
    }

    public interface ICheckChinaIP {
        void checkIp() throws Exception;

        boolean shouldBeSilent();
    }

    public interface IContentBytes {
        void onRead(long j);
    }

    public interface IHardCodeJsonSchema {
        String getJsonSchema();
    }

    public interface IHttpException {
        void onContentException(int i2, String str, int i3, byte[] bArr);

        void onHeaderException(int i2, String str, int i3, Header[] headerArr);
    }

    public interface IHttpProperty {
        boolean onContentType(String str);

        boolean onHeaders(Header[] headerArr);

        boolean onResponseCode(int i2);
    }

    public interface IKugouResTag {
    }

    public interface INoState {
    }

    public interface IRequestUrlReceiver {
        String getRequestUrl(String str);

        void onHttpGet(String str);

        void onHttpPost(String str);

        void onUrlState(String str, boolean z);
    }

    public interface IStaticsRequest {
        boolean isNetTrafficTask();

        boolean isStaticsReqeustPackage();
    }

    public interface IStreamHandler {
        void handlerStream(InputStream inputStream, long j, IContentBytes iContentBytes) throws Exception;
    }

    public interface IUrlExtension {
        String getFileExtension();
    }

    public class KugouSSLSocketFactory extends SSLSocketFactory {
        private SSLContext sslContext;

        public KugouSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException {
            super(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            this.sslContext = sSLContext;
            sSLContext.init(null, new TrustManager[]{new KugouTrustManager()}, null);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket connectSocket(Socket socket, String str, int i2, InetAddress inetAddress, int i3, HttpParams httpParams) throws IOException {
            return super.connectSocket(socket, str, i2, inetAddress, i3, httpParams);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() throws IOException {
            return this.sslContext.getSocketFactory().createSocket();
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
            InetAddress inetAddress = socket.getInetAddress();
            if (inetAddress == null) {
                inetAddress = InetAddress.getByName(str);
            }
            AbsHttpClient.this.updateIpRecord(inetAddress);
            Socket socketCreateSocket = this.sslContext.getSocketFactory().createSocket(socket, str, i2, z);
            AbsHttpClient.this.setTimeout();
            return socketCreateSocket;
        }
    }

    public class KugouSocketFactory implements SocketFactory {
        private KugouSocketFactory() {
        }

        @Override // org.apache.http.conn.scheme.SocketFactory
        public Socket connectSocket(Socket socket, String str, int i2, InetAddress inetAddress, int i3, HttpParams httpParams) throws IOException {
            if (socket == null) {
                socket = createSocket();
            }
            if (inetAddress != null || i3 > 0) {
                if (i3 <= 0) {
                    i3 = 0;
                }
                socket.bind(new InetSocketAddress(inetAddress, i3));
            }
            InetAddress byName = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(byName, i2);
            AbsHttpClient.this.updateIpRecord(byName);
            AbsHttpClient.this.setTimeout();
            try {
                int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
                int soTimeout = HttpConnectionParams.getSoTimeout(httpParams);
                socket.connect(inetSocketAddress, connectionTimeout);
                socket.setSoTimeout(soTimeout);
                return socket;
            } catch (SocketTimeoutException unused) {
                throw new ConnectTimeoutException("Connect to " + inetSocketAddress + " timed out");
            }
        }

        @Override // org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() throws IOException {
            return new Socket();
        }

        @Override // org.apache.http.conn.scheme.SocketFactory
        public boolean isSecure(Socket socket) throws IllegalArgumentException {
            return false;
        }
    }

    public static class OKHttpCallWrapper {
        public Call call;
    }

    public interface SchemeCallBack {
        void setRequestPackageScheme(RequestPackage requestPackage, RequestParams requestParams);

        byte[] splitDataByHardCodeScheme(byte[] bArr, String str);

        byte[] splitDataByScheme(byte[] bArr, String str);
    }

    public AbsHttpClient(Context context, AbsHttpVars absHttpVars) {
        this.callWrapper = new OKHttpCallWrapper();
        this.cronetCallWrapper = new CronetCallWrapper();
        this.mRetryStrategy = DefaultRetryStrategy.getInstance();
        this.mConnTimeOut = 10000;
        this.mReadTimeOut = 10000;
        this.isCustomTimeOut = false;
        this.mUseExpireDataWhenNoNet = false;
        this.canUseProxy = true;
        this.disableOffline = false;
        this.isEnableACK = true;
        this.isHttpKeepAlive = false;
        this.stackHash = null;
        this.firstIp = null;
        this.lastIp = null;
        this.mFeatures = EnumSet.noneOf(ProtocolFeature.class);
        this.mACKTraceList = null;
        this.mACKTraceRecord = null;
        this.monitorEnable = true;
        this.hasUsedProxy = false;
        this.firstURL = "";
        this.mRetryCount = 0;
        this.schemeCallBack = null;
        this.mContext = context;
        setmHttpVariables(absHttpVars);
        initConfigParams();
        if (this.mHttpVariables.getRetryStrategy() != null) {
            this.mRetryStrategy = this.mHttpVariables.getRetryStrategy();
        }
    }

    private void addHeaderIfNeeded(String str, List<IHttpRetryMode> list) {
        RetryExtraParam retryExtraParam;
        Pair<String, String> unifiedGatewayHeader;
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        String host = getHost(str);
        if (TextUtils.isEmpty(host)) {
            return;
        }
        for (IHttpRetryMode iHttpRetryMode : list) {
            if (iHttpRetryMode != null && (retryExtraParam = iHttpRetryMode.getRetryExtraParam()) != null) {
                String host2 = getHost(retryExtraParam.mUrl);
                if (!TextUtils.isEmpty(host2) && (unifiedGatewayHeader = this.mHttpVariables.getUnifiedGatewayHeader(host, host2)) != null && !TextUtils.isEmpty((CharSequence) unifiedGatewayHeader.first) && !TextUtils.isEmpty((CharSequence) unifiedGatewayHeader.second)) {
                    if (retryExtraParam.mHeaders == null) {
                        retryExtraParam.mHeaders = new HashMap();
                    }
                    retryExtraParam.mHeaders.put((String) unifiedGatewayHeader.first, (String) unifiedGatewayHeader.second);
                }
            }
        }
    }

    public static String appendFileExtension(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return str;
        }
        if (!str2.startsWith("/")) {
            str2 = "/" + str2;
        }
        if (!str.contains("?")) {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            return str + str2;
        }
        String[] strArrSplit = str.split("\\?", 2);
        String strSubstring = strArrSplit.length >= 1 ? strArrSplit[0] : "";
        String str3 = strArrSplit.length >= 2 ? strArrSplit[1] : "";
        if (strSubstring.endsWith("/")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        if (!TextUtils.isEmpty(str3)) {
            str3 = "?" + str3;
        }
        return strSubstring + str2 + str3;
    }

    private boolean canUseCacheData(Exception exc, RequestParams requestParams, Object obj) {
        return this.mUseExpireDataWhenNoNet && requestParams.getCacheEntry() != null && (obj instanceof ResponsePackage) && canUseCacheException(exc) && !KGNetworkUtil.isNetworkConected(this.mContext);
    }

    private boolean canUseCacheException(Exception exc) {
        return (exc instanceof UnknownHostException) || (exc instanceof ConnectException) || (exc instanceof SocketException);
    }

    private void checkAndSetMultiUrlReq(RequestParams requestParams, IHttpRetryMode iHttpRetryMode) {
        if (requestParams.isMultiUrlReqPkg()) {
            String url = requestParams.getUrl();
            if (iHttpRetryMode != null && iHttpRetryMode.getRetryExtraParam().mVisitUrl != null) {
                url = iHttpRetryMode.getRetryExtraParam().mVisitUrl;
            }
            ((AbstractMultiUrlRequestPackage) requestParams.getRequestPkg()).setLastVisitUrl(url);
        }
    }

    private void checkAndSetTrafficTask(RequestParams requestParams) {
        if (requestParams.isNetTrafficTask()) {
            return;
        }
        this.mHttpVariables.startNetTraffic();
    }

    private boolean checkContentType(HttpResponse httpResponse, Object obj) {
        try {
            if (!(obj instanceof IHttpProperty)) {
                return true;
            }
            IHttpProperty iHttpProperty = (IHttpProperty) obj;
            Header[] headers = httpResponse.getHeaders("Content-Type");
            if (headers != null && headers.length != 0) {
                return iHttpProperty.onContentType(headers[0].getValue());
            }
            return iHttpProperty.onContentType(null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private void checkContentTypeAndHeaders(Object obj, HttpResponse httpResponse) throws KugouNetException {
        if (!checkContentType(httpResponse, obj)) {
            throw new KugouNetException(1, "wrong Content-Type", httpResponse.getHeaders("Content-Type"));
        }
        if (!checkHeaders(httpResponse.getAllHeaders(), obj)) {
            throw new KugouNetException(5, "disagree HTTP headers", httpResponse.getAllHeaders());
        }
    }

    private boolean checkHeaders(Header[] headerArr, Object obj) {
        if (obj instanceof IHttpProperty) {
            return ((IHttpProperty) obj).onHeaders(headerArr);
        }
        return true;
    }

    private boolean checkResponseCode(int i2, Object obj) {
        if (obj instanceof IHttpProperty) {
            return ((IHttpProperty) obj).onResponseCode(i2);
        }
        return true;
    }

    private void checkip(RequestPackage requestPackage) throws Exception {
        if (requestPackage instanceof ICheckChinaIP) {
            ((ICheckChinaIP) requestPackage).checkIp();
        }
    }

    private void closeCronetRequest() {
        m mVar = this.cronetCallWrapper.urlRequest;
        if (mVar == null || mVar.c()) {
            return;
        }
        try {
            this.cronetCallWrapper.urlRequest.a();
        } catch (Exception unused) {
        }
    }

    private void closeHttpClientRequest() {
        HttpClient httpClient = this.mHttpClient;
        if (httpClient != null) {
            try {
                httpClient.getConnectionManager().shutdown();
            } catch (AssertionError e2) {
                e2.printStackTrace();
            }
        }
    }

    private void closeOKHttpRequest() {
        Call call = this.callWrapper.call;
        if (call == null || call.isCanceled()) {
            return;
        }
        try {
            this.callWrapper.call.cancel();
        } catch (Exception unused) {
        }
    }

    @NonNull
    private HttpResponse connect(RequestParams requestParams, ConnectUrl connectUrl, IHttpRetryMode iHttpRetryMode, int i2) throws Exception {
        HttpUriRequest httpGet;
        KGHttpProxy httpProxy = (iHttpRetryMode == null || (iHttpRetryMode instanceof ACKNetgateHttpRetryMode)) ? null : iHttpRetryMode.getHttpProxy();
        String url = iHttpRetryMode == null ? requestParams.getUrl() : iHttpRetryMode.getRetryExtraParam().mUrl;
        if (requestParams.isUrlExtension()) {
            url = appendFileExtension(url, ((IUrlExtension) requestParams.getRequestPkg()).getFileExtension());
        }
        RequestDelay requestDelay = this.mRequestDelay;
        if (requestDelay != null) {
            requestDelay.setSerId(iHttpRetryMode != null ? iHttpRetryMode.getServiceId() : 0);
            this.mRequestDelay.setGetMethod(iHttpRetryMode != null ? iHttpRetryMode.getGETMethod() : RequestDelay.GET_METHOD_DIRECT);
            this.mRequestDelay.setSerIp(url);
        }
        String getRequestParams = requestParams.getGetRequestParams();
        if (!TextUtils.isEmpty(getRequestParams)) {
            StringBuilder sb = new StringBuilder(url);
            if (url.contains("?")) {
                if (!url.endsWith(BaseConnection.HTTP_REQ_ENTITY_JOIN) && !url.endsWith("?")) {
                    sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
                }
                sb.append((CharSequence) getRequestParams, getRequestParams.startsWith("?") ? 1 : 0, getRequestParams.length());
            } else {
                if (!getRequestParams.startsWith("?")) {
                    sb.append("?");
                }
                sb.append(getRequestParams);
            }
            url = sb.toString();
        }
        if (this.mEnableKugouResTag) {
            url = urlAppendKugouResTag(url);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connect url : ");
        sb2.append(url);
        sb2.append(", in retryMode(");
        sb2.append(iHttpRetryMode != null ? Integer.valueOf(iHttpRetryMode.getType()) : "null");
        sb2.append(")");
        NetLog.d(TAG, sb2.toString());
        URI uri = new URI(url);
        if (connectUrl != null) {
            connectUrl.url = url;
        }
        if ("GET".equalsIgnoreCase(requestParams.getRequestType())) {
            IRequestUrlReceiver iRequestUrlReceiver = this.mRequestUrlReceiver;
            if (iRequestUrlReceiver != null) {
                iRequestUrlReceiver.onHttpGet(url);
            }
            httpGet = new HttpGet(uri);
        } else {
            IRequestUrlReceiver iRequestUrlReceiver2 = this.mRequestUrlReceiver;
            if (iRequestUrlReceiver2 != null) {
                iRequestUrlReceiver2.onHttpPost(url);
            }
            HttpPost httpPost = new HttpPost(uri);
            httpPost.setEntity(requestParams.getPostRequestEntity());
            httpGet = httpPost;
        }
        httpGet.addHeader(HTTP.USER_AGENT, requestParams.getUserAgent(this.mContext, this.mHttpVariables));
        if (!TextUtils.isEmpty(this.stackHash) && this.mHttpVariables.isEnableTHash() && this.monitorEnable) {
            httpGet.addHeader("KG-THash", this.stackHash);
        }
        if (this.mHttpVariables.getRec() < 3) {
            httpGet.addHeader("KG-Rec", String.valueOf(this.mHttpVariables.getRec()));
        }
        if (isNeedUnZipStreamNetMode()) {
            httpGet.addHeader("Accept-Encoding", "gzip, deflate");
        }
        if (this.mHttpVariables.isEnableRC() && !isStatisticHost()) {
            httpGet.addHeader("KG-RC", String.valueOf(i2));
        }
        if (this.mHttpVariables.isEnableUserId()) {
            httpGet.setHeader(HEADER_USER_ID, String.valueOf(this.mHttpVariables.getUserId()));
        }
        if (this.mHttpVariables.isEnableRF()) {
            int version = iHttpRetryMode == null ? RFCode.RETRY_MODE_NIL : iHttpRetryMode.getVersion();
            int iIdentityHashCode = System.identityHashCode(this);
            httpGet.addHeader("KG-RF", String.format(Locale.getDefault(), "%08x", Integer.valueOf((version << 16) | ((iIdentityHashCode & 65535) ^ (iIdentityHashCode >>> 16)))));
        }
        if (AbsHttpVars.switchparam_kg_user_agent) {
            httpGet.addHeader("KG-USER-AGENT", this.mHttpVariables.getNameOfPlatformVersion() + "-kugoumusic-107");
        }
        Header[] httpHeaders = requestParams.getHttpHeaders();
        if (httpHeaders != null) {
            for (Header header : httpHeaders) {
                httpGet.addHeader(header);
            }
        }
        if (iHttpRetryMode != null && iHttpRetryMode.getRetryExtraParam().mHeaders != null) {
            for (Map.Entry<String, String> entry : iHttpRetryMode.getRetryExtraParam().mHeaders.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (httpProxy != null && httpProxy.canUseProxy() && httpProxy.getHttpHost() != null) {
            httpProxy.onHeadersHandled(httpGet);
            this.hasUsedProxy = true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (iHttpRetryMode != null) {
            iHttpRetryMode.getRetryExtraParam().mActTime = jCurrentTimeMillis;
            iHttpRetryMode.getRetryExtraParam().mAckElapsedTime = SystemClock.elapsedRealtime();
        }
        if (this.mACKTraceList != null) {
            ACKTraceRecord aCKTraceRecord = new ACKTraceRecord();
            this.mACKTraceRecord = aCKTraceRecord;
            aCKTraceRecord.url = url;
        }
        HttpResponse httpResponse = getHttpResponse(httpGet, httpProxy, iHttpRetryMode.getRetryExtraParam().directIp);
        RequestDelay requestDelay2 = this.mRequestDelay;
        if (requestDelay2 != null) {
            requestDelay2.setDelayMillis(System.currentTimeMillis() - jCurrentTimeMillis);
        }
        List<ACKTraceRecord> list = this.mACKTraceList;
        if (list != null) {
            list.add(this.mACKTraceRecord);
            this.mACKTraceRecord = null;
        }
        return httpResponse;
    }

    private void doRequest(RequestParams requestParams, ResponsePackage<Object> responsePackage, @Nullable IHttpRetryMode iHttpRetryMode, int i2, List<RetryDetail> list) throws Exception {
        long j;
        String url = requestParams.getUrl();
        if (iHttpRetryMode != null && iHttpRetryMode.getRetryExtraParam().mVisitUrl != null) {
            url = iHttpRetryMode.getRetryExtraParam().mVisitUrl;
        }
        String str = url;
        String url2 = iHttpRetryMode == null ? requestParams.getUrl() : iHttpRetryMode.getRetryExtraParam().mUrl;
        String str2 = (iHttpRetryMode == null || iHttpRetryMode.getRetryExtraParam().mHeaders == null) ? null : iHttpRetryMode.getRetryExtraParam().mHeaders.get(HTTP.TARGET_HOST);
        try {
            this.mRequestDelay = new RequestDelay();
            RetryStaticsLOG retryStaticsLOG = this.mRetryStaticsLOG;
            if (retryStaticsLOG != null) {
                retryStaticsLOG.markRequestStart(requestParams.getRequestType());
                this.mRetryStaticsLOG.setRequestType(iHttpRetryMode != null ? iHttpRetryMode.getType() : 110, url2, str2);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            try {
                HttpResponse httpResponseStart = start(requestParams, responsePackage, iHttpRetryMode, i2);
                if (httpResponseStart == null) {
                    return;
                }
                RetryStaticsLOG retryStaticsLOG2 = this.mRetryStaticsLOG;
                if (retryStaticsLOG2 != null) {
                    retryStaticsLOG2.markRequestGotResponse(httpResponseStart.getStatusLine().getStatusCode());
                    this.mRetryStaticsLOG.markRequestEnd(null);
                }
                IRequestUrlReceiver iRequestUrlReceiver = this.mRequestUrlReceiver;
                if (iRequestUrlReceiver != null) {
                    iRequestUrlReceiver.onUrlState(str, true);
                }
                if (iHttpRetryMode != null) {
                    this.mLastRetryMode = (this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITH_RETRY) || this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITHOUT_RETRY)) ? iHttpRetryMode : null;
                    iHttpRetryMode.onHttpClientSuccess(requestParams.getRequestPkg(), httpResponseStart);
                    saveRetryDetail(list, iHttpRetryMode, jElapsedRealtime, null);
                    RetryExtraParam retryExtraParam = iHttpRetryMode.getRetryExtraParam();
                    if (retryExtraParam == null || !(responsePackage instanceof AbstractLastUrlResponsePackage)) {
                        return;
                    }
                    ((AbstractLastUrlResponsePackage) responsePackage).setLastUrl(retryExtraParam.mUrl);
                }
            } catch (Exception e2) {
                e = e2;
                j = jElapsedRealtime;
                this.mLastRetryMode = null;
                if (iHttpRetryMode != null) {
                    iHttpRetryMode.onHttpClientException(e, requestParams.getRequestPkg());
                    saveRetryDetail(list, iHttpRetryMode, j, e);
                    RetryExtraParam retryExtraParam2 = iHttpRetryMode.getRetryExtraParam();
                    if (retryExtraParam2 != null && (responsePackage instanceof AbstractLastUrlResponsePackage)) {
                        ((AbstractLastUrlResponsePackage) responsePackage).setLastUrl(retryExtraParam2.mUrl);
                    }
                }
                RetryStaticsLOG retryStaticsLOG3 = this.mRetryStaticsLOG;
                if (retryStaticsLOG3 != null) {
                    retryStaticsLOG3.markRequestEnd(e);
                }
                IRequestUrlReceiver iRequestUrlReceiver2 = this.mRequestUrlReceiver;
                if (iRequestUrlReceiver2 != null) {
                    iRequestUrlReceiver2.onUrlState(str, false);
                }
                if (NetLog.isDebug()) {
                    NetLog.e(TAG, "doRequest failed. \n", e);
                }
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            j = 0;
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

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private HttpResponse getHttpResponse(@NonNull HttpUriRequest httpUriRequest, KGHttpProxy kGHttpProxy, byte[] bArr) throws IOException {
        boolean z;
        int totalTimeOut;
        boolean z2;
        String host;
        boolean zEqualsIgnoreCase;
        KGHttpProxy kGHttpProxy2;
        ProtocolVersion protocolVersion;
        HttpUriRequest httpGet = httpUriRequest;
        boolean z3 = true;
        if (httpUriRequest.getURI() != null) {
            boolean zIsUnifiedGateway = this.mHttpVariables.isUnifiedGateway(httpUriRequest.getURI().getHost());
            if (zIsUnifiedGateway) {
                totalTimeOut = this.mHttpVariables.getUnifiedGatewayTimeout();
                z2 = zIsUnifiedGateway;
                z = totalTimeOut > 0;
            } else {
                z2 = zIsUnifiedGateway;
                z = false;
                totalTimeOut = 0;
            }
        } else {
            z = false;
            totalTimeOut = 0;
            z2 = false;
        }
        int i2 = this.netMode;
        if (i2 == 1) {
            return this.mHttpClient.execute(httpGet);
        }
        if (i2 != 2) {
            if (i2 == 3) {
                CronetHandler.getInstance().checkInitCronetEngine(this.mContext, false);
                CronetApacheClient cronetApacheClient = new CronetApacheClient();
                if (!z) {
                    totalTimeOut = getTotalTimeOut();
                }
                return cronetApacheClient.executeWithCall(false, totalTimeOut, this.cronetCallWrapper, kGHttpProxy, httpUriRequest, z2);
            }
            if (i2 != 4) {
                throw new UnsupportedOperationException("not support this network mode now!");
            }
            CronetHandler.getInstance().checkInitCronetEngine(this.mContext, true);
            CronetApacheClient cronetApacheClient2 = new CronetApacheClient();
            if (!z) {
                totalTimeOut = getTotalTimeOut();
            }
            HttpResponse httpResponseExecuteWithCall = cronetApacheClient2.executeWithCall(true, totalTimeOut, this.cronetCallWrapper, kGHttpProxy, httpUriRequest, z2);
            if (httpResponseExecuteWithCall == null || (protocolVersion = httpResponseExecuteWithCall.getProtocolVersion()) == null) {
                return httpResponseExecuteWithCall;
            }
            this.cronetRealProtocol = protocolVersion.getProtocol();
            return httpResponseExecuteWithCall;
        }
        if (httpUriRequest.getURI() != null) {
            zEqualsIgnoreCase = AckProtocolTypeUtil.HTTPS_LABEL.equalsIgnoreCase(httpUriRequest.getURI().getScheme());
            host = httpUriRequest.getURI().getHost();
        } else {
            host = null;
            zEqualsIgnoreCase = false;
        }
        boolean z4 = httpUriRequest.getURI() != null && isUriUsingSeparateConnectionPool(httpUriRequest.getURI());
        if (z4 && !OKHttpManager.hasInitSeparateConnectionParameters()) {
            OKHttpManager.initSeparateConnectionParameters(this.mHttpVariables.getMaxIdleSeparateConnectionCount());
        }
        if (kGHttpProxy == null || kGHttpProxy.getReverseProxyHost() == null) {
            kGHttpProxy2 = kGHttpProxy;
        } else {
            ReverseProxyHost reverseProxyHost = kGHttpProxy.getReverseProxyHost();
            Header[] allHeaders = reverseProxyHost.headerGroup.getAllHeaders();
            if (allHeaders != null && allHeaders.length > 0) {
                Header[] headers = httpGet.getHeaders(HTTP.TARGET_HOST);
                if (headers == null || headers.length <= 0) {
                    httpGet.addHeader(KGHttpProxy.X_REAL_HOST_KEY, reverseProxyHost.originHost);
                } else {
                    httpGet.addHeader(KGHttpProxy.X_REAL_HOST_KEY, headers[0].getValue());
                }
                Header[] allHeaders2 = httpUriRequest.getAllHeaders();
                String strReplaceHostAndPort = AckProtocolTypeUtil.replaceHostAndPort(httpUriRequest.getURI().toString(), ReverseProxyHost.getPort(zEqualsIgnoreCase), reverseProxyHost.proxyHost);
                if (httpGet instanceof HttpGet) {
                    httpGet = new HttpGet(strReplaceHostAndPort);
                } else if (httpGet instanceof HttpPost) {
                    HttpPost httpPost = new HttpPost(strReplaceHostAndPort);
                    httpPost.setEntity(((HttpPost) httpGet).getEntity());
                    httpGet = httpPost;
                }
                httpGet.setHeaders((Header[]) KGNetworkUtil.concat(allHeaders, allHeaders2));
            }
            kGHttpProxy2 = null;
        }
        if (z) {
            totalTimeOut /= 2;
        }
        try {
            OkApacheClient okApacheClient = new OkApacheClient(OKHttpManager.getHttpsClient(host, z || this.isCustomTimeOut, z ? totalTimeOut : this.mConnTimeOut, z ? totalTimeOut : this.mReadTimeOut, this.canUseProxy, kGHttpProxy2, this.mHttpVariables.getOkHttpPingInterval(), z4, z2));
            if (zEqualsIgnoreCase || this.isHttpKeepAlive) {
                z3 = false;
            }
            return okApacheClient.executeWithCall(z3, this.callWrapper, httpGet, bArr);
        } finally {
            this.serverIp = OKHttpManager.sThreadLocal.get();
            this.currentConnectionIp = OKHttpManager.sConnectionIpAcquired.get();
        }
    }

    private List<String> getNewDomainRetryUrls(List<String> list) {
        AbsAckVars ackVars;
        String strReplaceDomain;
        if (list != null && !list.isEmpty()) {
            String str = list.get(0);
            String host = getHost(str);
            if (TextUtils.isEmpty(host) || (ackVars = AckManager.getAckVars()) == null) {
                return null;
            }
            HostKeyProtocolEntity ackProtocolEntity = ackVars.getAckProtocolEntity(host);
            String newDomain = this.mHttpVariables.getNewDomain(str, ackProtocolEntity != null ? ackProtocolEntity.urlHosts : null);
            if (!TextUtils.isEmpty(newDomain) && (strReplaceDomain = replaceDomain(str, newDomain)) != null && !"".equals(strReplaceDomain) && !strReplaceDomain.equals(str)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(strReplaceDomain);
                return arrayList;
            }
        }
        return null;
    }

    private Pair<String, String> getSchemaAndHost(IHttpRetryMode iHttpRetryMode) {
        if (iHttpRetryMode == null || iHttpRetryMode.getRetryExtraParam() == null || TextUtils.isEmpty(iHttpRetryMode.getRetryExtraParam().mUrl)) {
            return null;
        }
        try {
            Uri uri = Uri.parse(iHttpRetryMode.getRetryExtraParam().mUrl);
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(host)) {
                return null;
            }
            return new Pair<>(scheme, host);
        } catch (Throwable unused) {
            return null;
        }
    }

    private int getTotalTimeOut() {
        return getConnTimeout() + getReadTimeout();
    }

    private int getUnifiedGatewayNetMode(IHttpRetryMode iHttpRetryMode) {
        AbsHttpVars absHttpVars = this.mHttpVariables;
        if (absHttpVars == null) {
            return 2;
        }
        return (((iHttpRetryMode == null && this.netMode == 4) || (iHttpRetryMode != null && iHttpRetryMode.getHttpProxy() == null && iHttpRetryMode.getProtocolType() == 2)) && absHttpVars.isCronetEnabled()) ? 4 : 2;
    }

    private List<String> getUrlsFromRequestPackage(RequestPackage requestPackage) {
        AbsAckVars ackVars = AckManager.getAckVars();
        List<String> requestRetryUrls = ackVars == null ? null : ackVars.getRequestRetryUrls(requestPackage);
        if (requestRetryUrls != null && !requestRetryUrls.isEmpty()) {
            return requestRetryUrls;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(requestPackage.getUrl());
        return arrayList;
    }

    private void handleProxyLegacy(IHttpRetryMode iHttpRetryMode, RequestParams requestParams, HttpResponse httpResponse, Object obj, int i2, int i3, String str) throws Exception {
        KGHttpProxy httpProxy = iHttpRetryMode == null ? null : iHttpRetryMode.getHttpProxy();
        if (httpProxy == null || !httpProxy.canUseProxy()) {
            throw new KugouNetException(i3, str);
        }
        KGHttpProxy kGHttpProxyOnProxyFailAfterConnected = httpProxy.onProxyFailAfterConnected(requestParams.getRequestPkg(), httpResponse, this.mHttpClient);
        if (kGHttpProxyOnProxyFailAfterConnected != null) {
            httpProxy = kGHttpProxyOnProxyFailAfterConnected;
        }
        if (httpProxy.canRetry()) {
            start(requestParams, obj, iHttpRetryMode, i2);
        }
    }

    private void initConfigParams() {
        String networkType = KGNetworkUtil.getNetworkType(this.mContext);
        if ("wifi".equals(networkType)) {
            this.mConnTimeOut = AbsHttpVars.timeoutparam_wificonnect;
            this.mReadTimeOut = AbsHttpVars.timeoutparam_wifiread;
        } else if ("3G".equals(networkType) || "4G".equals(networkType)) {
            this.mConnTimeOut = AbsHttpVars.timeoutparam_3gconnent;
            this.mReadTimeOut = AbsHttpVars.timeoutparam_3gread;
        } else {
            this.mConnTimeOut = AbsHttpVars.timeoutparam_2gconnent;
            this.mReadTimeOut = AbsHttpVars.timeoutparam_2gread;
        }
    }

    private boolean isGzipStream(HttpEntity httpEntity) throws IllegalStateException, IOException {
        Header contentEncoding;
        return (httpEntity == null || (contentEncoding = httpEntity.getContentEncoding()) == null || contentEncoding.getValue() == null || !contentEncoding.getValue().toLowerCase(Locale.US).contains("gzip")) ? false : true;
    }

    private boolean isNeedUnZipStreamNetMode() {
        int i2 = this.netMode;
        return i2 == 2 || i2 == 1;
    }

    private boolean isPostNotRepeatable(HttpEntity httpEntity) {
        return (httpEntity == null || httpEntity.isRepeatable()) ? false : true;
    }

    private boolean isUnifiedGatewayUrl(String str, IHttpRetryMode iHttpRetryMode) {
        AbsHttpVars absHttpVars = this.mHttpVariables;
        if (absHttpVars == null) {
            return false;
        }
        String host = null;
        if (iHttpRetryMode != null && iHttpRetryMode.getRetryExtraParam() != null) {
            host = getHost(iHttpRetryMode.getRetryExtraParam().mUrl);
        } else if (!TextUtils.isEmpty(str)) {
            host = getHost(str);
        }
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        return absHttpVars.isUnifiedGateway(host);
    }

    private boolean isUriUsingSeparateConnectionPool(URI uri) {
        if (uri == null || this.mHttpVariables == null || TextUtils.isEmpty(uri.getHost())) {
            return false;
        }
        return this.mHttpVariables.isHostUsingSeparateConnectionPool(uri.getHost());
    }

    private void notifyContentException(int i2, String str, int i3, byte[] bArr, Object obj) {
        if (obj instanceof IHttpException) {
            ((IHttpException) obj).onContentException(i2, str, i3, bArr);
        }
    }

    private void notifyHeaderException(int i2, String str, int i3, Header[] headerArr, Object obj) {
        if (obj instanceof IHttpException) {
            ((IHttpException) obj).onHeaderException(i2, str, i3, headerArr);
        }
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

    private void printRetryErr(@Nullable IHttpRetryMode iHttpRetryMode, Exception exc) {
        StringBuilder sb = new StringBuilder();
        sb.append("ack_retry_err: ");
        sb.append(Log.getStackTraceString(exc));
        sb.append("\n\t\t");
        sb.append(iHttpRetryMode == null ? "" : iHttpRetryMode.getRetryExtraParam().mUrl);
        sb.append("\n\t\t");
        sb.append(iHttpRetryMode != null ? iHttpRetryMode.getRetryExtraParam().mVisitUrl : "");
        NetLog.d("zlx_net", sb.toString());
    }

    private void readData(RequestParams requestParams, HttpResponse httpResponse, Object obj) throws Exception {
        HttpEntity entity = httpResponse.getEntity();
        if (!(obj instanceof ResponsePackage)) {
            if (obj instanceof IStreamHandler) {
                IStreamHandler iStreamHandler = (IStreamHandler) obj;
                INetworkState iNetworkState = this.mINetworkState;
                if (iNetworkState != null) {
                    iNetworkState.onReadStart();
                }
                iStreamHandler.handlerStream((isNeedUnZipStreamNetMode() && isGzipStream(entity)) ? new GZIPInputStream(entity.getContent()) : entity.getContent(), entity.getContentLength(), new IContentBytes() { // from class: com.kugou.common.network.AbsHttpClient.1
                    @Override // com.kugou.common.network.AbsHttpClient.IContentBytes
                    public void onRead(long j) {
                        AbsHttpClient.this.mReadContentBytes += j;
                    }
                });
                INetworkState iNetworkState2 = this.mINetworkState;
                if (iNetworkState2 != null) {
                    iNetworkState2.onReadEnd();
                    return;
                }
                return;
            }
            return;
        }
        ResponsePackage responsePackage = (ResponsePackage) obj;
        INetworkState iNetworkState3 = this.mINetworkState;
        if (iNetworkState3 != null) {
            iNetworkState3.onReadStart();
        }
        byte[] byteArray = (isNeedUnZipStreamNetMode() && isGzipStream(entity)) ? EntityUtils.toByteArray(new GzipDecompressingEntity(entity)) : EntityUtils.toByteArray(entity);
        if (byteArray != null) {
            this.mReadContentBytes = byteArray.length;
        }
        INetworkState iNetworkState4 = this.mINetworkState;
        if (iNetworkState4 != null) {
            iNetworkState4.onReadEnd();
        }
        if (this.mEnableKugouResTag) {
            byte[] kugouResTag = parseKugouResTag(byteArray);
            if (kugouResTag == null) {
                throw new KugouNetException(3, "No kugou res tag", byteArray);
            }
            byteArray = kugouResTag;
        }
        int i2 = 0;
        if (responsePackage != null && responsePackage.getResponseType() != null && !responsePackage.getResponseType().checkResponseType(byteArray)) {
            int checkType = responsePackage.getResponseType().getCheckType();
            StringBuilder sb = new StringBuilder("Wrong response type ");
            sb.append(checkType);
            sb.append(" :");
            if (byteArray != null) {
                int length = byteArray.length;
                while (i2 < length) {
                    sb.append((int) byteArray[i2]);
                    sb.append(" ");
                    i2++;
                }
            }
            throw new KugouNetException(4, sb.toString());
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (NetLog.isDebug()) {
            NetLog.d(TAG, "responseCode: " + statusCode);
        }
        KGHttpCache kgHttpCache = requestParams.getKgHttpCache();
        if (kgHttpCache != null && KGHttpCache.isCacheable(httpResponse)) {
            i2 = 1;
        }
        if (statusCode == 304) {
            if (kgHttpCache != null) {
                if (NetLog.isDebug()) {
                    NetLog.d(TAG, "304: updateCache");
                }
                kgHttpCache.update(requestParams, httpResponse);
                byteArray = kgHttpCache.getCacheEntry().data;
            } else {
                NetLog.e(TAG, "check it");
            }
        } else if (i2 != 0) {
            try {
                kgHttpCache.put(requestParams, byteArray, httpResponse);
                if (NetLog.isDebug()) {
                    NetLog.d(TAG, "cache result");
                }
            } catch (Exception unused) {
            }
        }
        if (this.schemeCallBack != null) {
            RequestPackage requestPkg = requestParams.getRequestPkg();
            byteArray = (!(requestPkg instanceof IHardCodeJsonSchema) || requestPkg == null) ? this.schemeCallBack.splitDataByScheme(byteArray, requestParams.getJsonScheme()) : this.schemeCallBack.splitDataByHardCodeScheme(byteArray, ((IHardCodeJsonSchema) requestPkg).getJsonSchema());
        }
        responsePackage.setContext(byteArray);
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

    private void saveRetryDetail(List<RetryDetail> list, IHttpRetryMode iHttpRetryMode, long j, Throwable th) {
        Pair<String, String> schemaAndHost;
        if (list == null || j <= 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (jElapsedRealtime <= 0 || (schemaAndHost = getSchemaAndHost(iHttpRetryMode)) == null) {
            return;
        }
        list.add(new RetryDetail((String) schemaAndHost.first, (String) schemaAndHost.second, this.currentConnectionIp, this.netMode, th, jElapsedRealtime, this.cronetRealProtocol));
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

    private void setCacheResult(RequestPackage requestPackage, ResponsePackage responsePackage, KGHttpCache.Entry entry) {
        checkResponseCode(entry.code, requestPackage);
        RequestDelay requestDelay = new RequestDelay();
        this.mRequestDelay = requestDelay;
        requestDelay.setGetMethod(RequestDelay.GET_METHOD_CACHE);
        this.mRequestDelay.setDelayMillis(0L);
        responsePackage.setContext(entry.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTimeout() {
        if (this.httpParams != null) {
            int i2 = this.mReadTimeOut;
            int i3 = this.mConnTimeOut;
            if (this.mMaxWaitTime > 0 && SystemClock.elapsedRealtime() - this.mRequestTime > this.mMaxWaitTime) {
                i2 /= 2;
                i3 /= 2;
            }
            HttpConnectionParams.setConnectionTimeout(this.httpParams, i3);
            HttpConnectionParams.setSoTimeout(this.httpParams, i2);
        }
    }

    private HttpResponse ssaConnect(RequestParams requestParams, IHttpRetryMode iHttpRetryMode, int i2, HttpResponse httpResponse, ConnectUrl connectUrl, SSAInterceptor sSAInterceptor, Header header) throws Exception {
        int i3;
        if (sSAInterceptor.getLock().tryLock()) {
            sSAInterceptor.resetVerifyResult();
            if (sSAInterceptor.onIntercept(requestParams.getRequestPkg().getUrl(), header.getValue(), sSAInterceptor.getOnVerificationListener())) {
                Headers headers = sSAInterceptor.getOnVerificationListener().getHeaders();
                if (headers != null) {
                    requestParams.addHeader(new BasicHeader("VerifyData", headers.get("VerifyData")));
                }
                HttpResponse httpResponseConnect = connect(requestParams, connectUrl, iHttpRetryMode, i2);
                Header[] allHeaders = httpResponseConnect.getAllHeaders();
                int length = allHeaders.length;
                HttpResponse httpResponseSsaConnect = httpResponseConnect;
                int i4 = 0;
                while (i4 < length) {
                    Header header2 = allHeaders[i4];
                    if ("SSA-CODE".equalsIgnoreCase(header2.getName())) {
                        i3 = i4;
                        httpResponseSsaConnect = ssaConnect(requestParams, iHttpRetryMode, i2, httpResponseSsaConnect, connectUrl, sSAInterceptor, header2);
                    } else {
                        i3 = i4;
                    }
                    i4 = i3 + 1;
                }
                return httpResponseSsaConnect;
            }
        } else {
            sSAInterceptor.getLock().lock();
            boolean verifyResult = sSAInterceptor.getVerifyResult();
            sSAInterceptor.getLock().unlock();
            if (verifyResult) {
                return connect(requestParams, connectUrl, iHttpRetryMode, i2);
            }
        }
        return httpResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x019d A[Catch: Exception -> 0x01cc, all -> 0x01d2, Error -> 0x022f, TRY_LEAVE, TryCatch #3 {Error -> 0x022f, blocks: (B:10:0x0048, B:11:0x0054, B:13:0x005c, B:15:0x0068, B:17:0x0072, B:19:0x0078, B:21:0x0082, B:23:0x0090, B:25:0x00aa, B:27:0x00b6, B:30:0x00c5, B:32:0x00c9, B:33:0x00cc, B:35:0x00d6, B:36:0x00e7, B:42:0x00f5, B:44:0x00fa, B:70:0x0199, B:72:0x019d, B:48:0x0100, B:50:0x0105, B:52:0x0113, B:53:0x0125, B:59:0x0132, B:61:0x013c, B:62:0x014e, B:65:0x0168, B:68:0x0173, B:69:0x0186, B:83:0x01c6, B:84:0x01cb), top: B:132:0x0048, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01bd  */
    @android.support.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.http.HttpResponse start(com.kugou.common.network.RequestParams r23, java.lang.Object r24, com.kugou.common.network.retry.IHttpRetryMode r25, int r26) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 605
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.network.AbsHttpClient.start(com.kugou.common.network.RequestParams, java.lang.Object, com.kugou.common.network.retry.IHttpRetryMode, int):org.apache.http.HttpResponse");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIpRecord(@NonNull InetAddress inetAddress) {
        String hostAddress = inetAddress.getHostAddress();
        this.serverIp = hostAddress;
        if (this.firstIp == null) {
            this.firstIp = hostAddress;
        }
        this.lastIp = hostAddress;
        ACKTraceRecord aCKTraceRecord = this.mACKTraceRecord;
        if (aCKTraceRecord != null) {
            aCKTraceRecord.ip = hostAddress;
        }
    }

    public static String urlAppendKugouResTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + (str.indexOf(63) >= 0 ? '&' : '?') + "with_res_tag=1";
    }

    public void createHttpClient(RequestParams requestParams, IHttpRetryMode iHttpRetryMode) {
        URI uri;
        if (this.mHttpClient == null || !(this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITH_RETRY) || this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITHOUT_RETRY))) {
            if (iHttpRetryMode != null) {
                try {
                    uri = iHttpRetryMode.getRetryExtraParam() == null ? new URI(requestParams.getUrl()) : new URI(iHttpRetryMode.getRetryExtraParam().mUrl);
                } catch (URISyntaxException e2) {
                    NetLog.e(TAG, "retrymode url syntax exception + " + e2.getMessage());
                    return;
                }
            }
            CustomSSLHttpClient customSSLHttpClient = new CustomSSLHttpClient(uri.getScheme(), uri.getPort());
            HttpParams params = customSSLHttpClient.getParams();
            this.httpParams = params;
            params.setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, Boolean.FALSE);
            if (iHttpRetryMode != null && iHttpRetryMode.getHttpProxy() != null && !(iHttpRetryMode instanceof ACKNetgateHttpRetryMode)) {
                this.httpParams.setParameter(ConnRoutePNames.DEFAULT_PROXY, iHttpRetryMode.getHttpProxy().getHttpHost());
            }
            setTimeout();
            this.mHttpClient = customSSLHttpClient;
        }
    }

    public void disableOffline(boolean z) {
        this.disableOffline = z;
    }

    public int getConnTimeout() {
        return this.mConnTimeOut;
    }

    public String getCurServerIp() {
        return TextUtils.isEmpty(this.serverIp) ? "" : this.serverIp;
    }

    public String getFirstIp() {
        return this.firstIp;
    }

    public String getLastIp() {
        return this.lastIp;
    }

    public int getNetMode() {
        return this.netMode;
    }

    public long getReadContentBytes() {
        return this.mReadContentBytes;
    }

    public int getReadTimeout() {
        return this.mReadTimeOut;
    }

    public RequestDelay getRequestDelay() {
        return this.mRequestDelay;
    }

    public int getRetryCount() {
        return this.mRetryCount;
    }

    public AbsHttpVars getmHttpVariables() {
        return this.mHttpVariables;
    }

    public boolean isHaveProxy() {
        return this.hasUsedProxy;
    }

    public boolean isMonitorEnable() {
        return this.monitorEnable;
    }

    public boolean isStatisticHost() {
        return false;
    }

    public void request(RequestPackage requestPackage, ResponsePackage<Object> responsePackage) throws Exception {
        RetryStaticsLOG retryStaticsLOG;
        boolean z;
        EnumSet<ProtocolFeature> enumSet = this.mFeatures;
        ProtocolFeature protocolFeature = ProtocolFeature.KEEPALIVE_WITH_RETRY;
        if ((enumSet.contains(protocolFeature) || this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITHOUT_RETRY)) && this.curThreadId != Thread.currentThread().getId()) {
            throw new ThreadNotSafeException("Client instance not share between threads");
        }
        if (!this.disableOffline && !this.mHttpVariables.isOnline() && KGNetworkUtil.isNetworkConected(this.mContext)) {
            NetLog.e(TAG, "Network is offline-mode");
            throw new IllegalStateException("network is offline-mode");
        }
        RequestParams requestParams = new RequestParams(requestPackage);
        SchemeCallBack schemeCallBack = this.schemeCallBack;
        if (schemeCallBack != null) {
            schemeCallBack.setRequestPackageScheme(requestPackage, requestParams);
        }
        this.mRequestTime = SystemClock.elapsedRealtime();
        if (this.mLastRetryMode == null) {
            checkip(requestPackage);
        }
        if (!requestParams.isStaticsRequestPackage() && this.mHttpVariables.isRetryStaticsOn()) {
            RetryStaticsLOG retryStatics = this.mRetryStrategy.getRetryStatics(this.mContext);
            this.mRetryStaticsLOG = retryStatics;
            retryStatics.init(requestPackage);
        }
        if (requestPackage instanceof IKugouResTag) {
            this.mEnableKugouResTag = AbsHttpVars.switchparam_restag;
        }
        if (NetLog.isDebug()) {
            NetLog.e(TAG, "request start.");
        }
        if (this.cache != null && requestParams.getRequestType().equalsIgnoreCase("GET")) {
            if (NetLog.isDebug()) {
                NetLog.d(TAG, "needCheckCache");
            }
            KGHttpCache.Entry entry = this.cache.get(requestParams);
            if (entry != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                CacheStrategy cacheStrategy = new CacheStrategy(entry);
                if (cacheStrategy.canUseCache(jCurrentTimeMillis)) {
                    if (NetLog.isDebug()) {
                        NetLog.d(TAG, "local cache only");
                    }
                    setCacheResult(requestPackage, responsePackage, entry);
                    return;
                }
                if (NetLog.isDebug()) {
                    NetLog.d(TAG, "needRefreshCache");
                }
                Header headerCreateHeaderForCache = cacheStrategy.createHeaderForCache();
                if (headerCreateHeaderForCache != null) {
                    requestParams.addHeader(headerCreateHeaderForCache);
                }
                if (NetLog.isDebug()) {
                    NetLog.d(TAG, "isExpired cache" + requestParams);
                }
                requestParams.setCacheEntry(entry);
            }
            requestParams.setHttpCache(this.cache);
        }
        this.mRetryStrategy.beforeStartRetry(requestPackage, responsePackage, this);
        ArrayList arrayList = new ArrayList();
        try {
            List<String> urlsFromRequestPackage = getUrlsFromRequestPackage(requestPackage);
            if (urlsFromRequestPackage != null && !urlsFromRequestPackage.isEmpty()) {
                this.firstURL = urlsFromRequestPackage.get(0);
                if (TrafficControl.getInstance().inBlacklist(this.firstURL)) {
                    throw new ServerFlowControlException("服务端流量控制");
                }
            }
            List<String> newDomainRetryUrls = getNewDomainRetryUrls(urlsFromRequestPackage);
            if (newDomainRetryUrls == null || newDomainRetryUrls.isEmpty()) {
                z = false;
            } else {
                urlsFromRequestPackage = newDomainRetryUrls;
                z = true;
            }
            List<IHttpRetryMode> listGenerateRetryMechanism = this.mRetryStrategy.generateRetryMechanism(urlsFromRequestPackage, this.canUseProxy, this.mHttpVariables);
            if (!this.isEnableACK || listGenerateRetryMechanism == null || listGenerateRetryMechanism.size() == 0) {
                listGenerateRetryMechanism = DefaultRetryStrategy.getInstance().generateRetryMechanism(urlsFromRequestPackage, this.canUseProxy, this.mHttpVariables);
            }
            if (z) {
                addHeaderIfNeeded(requestPackage.getUrl(), listGenerateRetryMechanism);
            }
            if (this.mLastRetryMode != null) {
                if (this.mFeatures.contains(protocolFeature)) {
                    listGenerateRetryMechanism.add(0, this.mLastRetryMode);
                } else if (this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITHOUT_RETRY)) {
                    listGenerateRetryMechanism = new ArrayList<>();
                    listGenerateRetryMechanism.add(this.mLastRetryMode);
                }
            }
            List<IHttpRetryMode> list = listGenerateRetryMechanism;
            int size = isPostNotRepeatable(requestParams.getPostRequestEntity()) ? 1 : list.size();
            this.mRetryCount = 0;
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    this.mRetryCount++;
                    IHttpRetryMode iHttpRetryMode = list.get(i2);
                    setNetMode(iHttpRetryMode, isUnifiedGatewayUrl(requestParams.getUrl(), iHttpRetryMode));
                    StringBuilder sb = new StringBuilder();
                    sb.append("retry count : ");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    sb.append(", ");
                    sb.append(iHttpRetryMode == null ? "null" : iHttpRetryMode.toString());
                    NetLog.d("ACKRetryStrategy", sb.toString());
                    doRequest(requestParams, responsePackage, iHttpRetryMode, i3, arrayList);
                    break;
                } catch (Exception e2) {
                    if (NetLog.isDebug()) {
                        printRetryErr(list.get(i2), e2);
                    }
                    if (i2 == size - 1) {
                        throw e2;
                    }
                }
            }
        } finally {
            if (!requestParams.isStaticsRequestPackage() && (retryStaticsLOG = this.mRetryStaticsLOG) != null) {
                this.mHttpVariables.logRetryNetwork(retryStaticsLOG);
            }
            this.mACKTraceList = null;
            this.mACKTraceRecord = null;
            if (responsePackage instanceof AbstractLastUrlResponsePackage) {
                ((AbstractLastUrlResponsePackage) responsePackage).setRetryDetails(arrayList);
            }
        }
    }

    public void requestWithWatch(RequestPackage requestPackage, IStreamHandler iStreamHandler) throws Exception {
        boolean z;
        EnumSet<ProtocolFeature> enumSet = this.mFeatures;
        ProtocolFeature protocolFeature = ProtocolFeature.KEEPALIVE_WITH_RETRY;
        if ((enumSet.contains(protocolFeature) || this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITHOUT_RETRY)) && this.curThreadId != Thread.currentThread().getId()) {
            throw new ThreadNotSafeException("Client instance not share between threads");
        }
        if (this.mHttpVariables.isOnline()) {
            RequestParams requestParams = new RequestParams(requestPackage);
            this.mRequestTime = SystemClock.elapsedRealtime();
            if (this.mLastRetryMode == null) {
                checkip(requestPackage);
            }
            NetLog.e(TAG, "requestWithWatch start.");
            this.mRetryStrategy.beforeStartRetry(requestPackage, iStreamHandler, this);
            try {
                try {
                    List<String> urlsFromRequestPackage = getUrlsFromRequestPackage(requestPackage);
                    if (urlsFromRequestPackage != null && !urlsFromRequestPackage.isEmpty()) {
                        this.firstURL = urlsFromRequestPackage.get(0);
                        if (TrafficControl.getInstance().inBlacklist(this.firstURL)) {
                            throw new ServerFlowControlException("服务端流量控制");
                        }
                    }
                    List<String> newDomainRetryUrls = getNewDomainRetryUrls(urlsFromRequestPackage);
                    if (newDomainRetryUrls == null || newDomainRetryUrls.isEmpty()) {
                        z = false;
                    } else {
                        urlsFromRequestPackage = newDomainRetryUrls;
                        z = true;
                    }
                    List<IHttpRetryMode> listGenerateRetryMechanism = this.mRetryStrategy.generateRetryMechanism(urlsFromRequestPackage, this.canUseProxy, this.mHttpVariables);
                    if (listGenerateRetryMechanism == null || listGenerateRetryMechanism.size() == 0) {
                        listGenerateRetryMechanism = DefaultRetryStrategy.getInstance().generateRetryMechanism(urlsFromRequestPackage, this.canUseProxy, this.mHttpVariables);
                    }
                    if (z) {
                        addHeaderIfNeeded(requestPackage.getUrl(), listGenerateRetryMechanism);
                    }
                    if (this.mLastRetryMode != null) {
                        if (this.mFeatures.contains(protocolFeature)) {
                            listGenerateRetryMechanism.add(0, this.mLastRetryMode);
                        } else if (this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITHOUT_RETRY)) {
                            listGenerateRetryMechanism = new ArrayList<>();
                            listGenerateRetryMechanism.add(this.mLastRetryMode);
                        }
                    }
                    int size = listGenerateRetryMechanism.size();
                    if (isPostNotRepeatable(requestParams.getPostRequestEntity())) {
                        size = 1;
                    }
                    this.mRetryCount = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        IHttpRetryMode iHttpRetryMode = listGenerateRetryMechanism.get(i2);
                        try {
                            this.mRetryCount++;
                            setNetMode(iHttpRetryMode, isUnifiedGatewayUrl(requestParams.getUrl(), iHttpRetryMode));
                            HttpResponse httpResponseStart = start(requestParams, iStreamHandler, iHttpRetryMode, i2 + 1);
                            if (httpResponseStart != null && iHttpRetryMode != null) {
                                this.mLastRetryMode = (this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITH_RETRY) || this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITHOUT_RETRY)) ? iHttpRetryMode : null;
                                iHttpRetryMode.onHttpClientSuccess(requestPackage, httpResponseStart);
                                break;
                            }
                            break;
                        } catch (Exception e2) {
                            this.mLastRetryMode = null;
                            if (iHttpRetryMode != null) {
                                iHttpRetryMode.onHttpClientException(e2, requestPackage);
                            }
                            if (NetLog.isDebug()) {
                                printRetryErr(listGenerateRetryMechanism.get(i2), e2);
                            }
                            if (i2 == size - 1) {
                                throw e2;
                            }
                        }
                    }
                } catch (Exception e3) {
                    NetLog.e(TAG, "requestWithWatch failed. \n", e3);
                    throw e3;
                }
            } finally {
                this.mACKTraceList = null;
                this.mACKTraceRecord = null;
            }
        }
    }

    public void resetTimeOut(int i2, int i3) {
        this.isCustomTimeOut = true;
        this.mConnTimeOut = i2;
        this.mReadTimeOut = i3;
    }

    public void setACKTraceList(List<ACKTraceRecord> list) {
        this.mACKTraceList = list;
    }

    public void setCanUseProxy(boolean z) {
        this.canUseProxy = z;
    }

    public void setConnTimeout(int i2) {
        this.isCustomTimeOut = true;
        this.mConnTimeOut = i2;
    }

    public void setDefaultTimeout(int i2, int i3) {
        this.mConnTimeOut = i2;
        this.mReadTimeOut = i3;
    }

    public void setEnableACK(boolean z) {
        this.isEnableACK = z;
    }

    public void setMaxWaitDuration(int i2) {
        if (i2 < 0) {
            NetLog.e(TAG, "MaxWaitDuration not allow < 0");
        } else {
            this.mMaxWaitTime = i2;
        }
    }

    public void setMonitorEnable(boolean z) {
        this.monitorEnable = z;
    }

    public void setNetMode(int i2) {
        this.netMode = i2;
    }

    public void setNetworkStateListener(INetworkState iNetworkState) {
        this.mINetworkState = iNetworkState;
    }

    public void setReadTimeout(int i2) {
        this.isCustomTimeOut = true;
        this.mReadTimeOut = i2;
    }

    public void setRequestUrlReceiver(IRequestUrlReceiver iRequestUrlReceiver) {
        this.mRequestUrlReceiver = iRequestUrlReceiver;
    }

    public void setRetryStrategy(IRetryStrategy iRetryStrategy) {
        if (iRetryStrategy == null) {
            return;
        }
        this.mRetryStrategy = iRetryStrategy;
    }

    public void setmHttpVariables(AbsHttpVars absHttpVars) {
        Objects.requireNonNull(absHttpVars, "AbsHttpVars must not be null");
        this.mHttpVariables = absHttpVars;
        this.netMode = AbsHttpVars.networkMode;
        NetLog.init(absHttpVars.getILog());
    }

    public void stop() {
        int i2 = this.netMode;
        if (i2 == 1) {
            closeHttpClientRequest();
        } else if (i2 == 2) {
            closeOKHttpRequest();
        } else {
            if (i2 != 3 && i2 != 4) {
                throw new UnsupportedOperationException("not support this network mode now!");
            }
            closeCronetRequest();
        }
        NetModeControler.getInstance().deleteObserver(this);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (observable instanceof NetModeControler) {
            NetModeControler.StateObject stateObject = (NetModeControler.StateObject) obj;
            if (stateObject.getNotifyType() == 2 && ((Integer) stateObject.getData()).intValue() == 1) {
                stop();
            }
        }
    }

    private void setNetMode(@Nullable IHttpRetryMode iHttpRetryMode, boolean z) {
        if (AbsHttpVars.isEnableProtocolRetry) {
            if (iHttpRetryMode == null) {
                this.netMode = z ? getUnifiedGatewayNetMode(null) : 2;
                return;
            }
            int protocolType = iHttpRetryMode.getProtocolType();
            if (protocolType != 0 && protocolType != 1) {
                if (protocolType == 2) {
                    this.netMode = iHttpRetryMode.getHttpProxy() == null ? z ? getUnifiedGatewayNetMode(iHttpRetryMode) : 4 : 2;
                    return;
                } else if (protocolType != 3) {
                    return;
                }
            }
            this.netMode = 2;
        }
    }

    public AbsHttpClient(Context context, AbsHttpVars absHttpVars, EnumSet<ProtocolFeature> enumSet) {
        this(context, absHttpVars);
        this.mFeatures.addAll(enumSet);
        if (this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITH_RETRY) || this.mFeatures.contains(ProtocolFeature.KEEPALIVE_WITHOUT_RETRY)) {
            this.curThreadId = Thread.currentThread().getId();
            this.isHttpKeepAlive = true;
        }
    }

    public AbsHttpClient(boolean z, Context context, AbsHttpVars absHttpVars) {
        this.callWrapper = new OKHttpCallWrapper();
        this.cronetCallWrapper = new CronetCallWrapper();
        this.mRetryStrategy = DefaultRetryStrategy.getInstance();
        this.mConnTimeOut = 10000;
        this.mReadTimeOut = 10000;
        this.isCustomTimeOut = false;
        this.mUseExpireDataWhenNoNet = false;
        this.canUseProxy = true;
        this.disableOffline = false;
        this.isEnableACK = true;
        this.isHttpKeepAlive = false;
        this.stackHash = null;
        this.firstIp = null;
        this.lastIp = null;
        this.mFeatures = EnumSet.noneOf(ProtocolFeature.class);
        this.mACKTraceList = null;
        this.mACKTraceRecord = null;
        this.monitorEnable = true;
        this.hasUsedProxy = false;
        this.firstURL = "";
        this.mRetryCount = 0;
        this.schemeCallBack = null;
        this.mContext = context;
        setmHttpVariables(absHttpVars);
        this.canUseProxy = !z;
        initConfigParams();
        if (this.mHttpVariables.getRetryStrategy() != null) {
            this.mRetryStrategy = this.mHttpVariables.getRetryStrategy();
        }
    }
}
