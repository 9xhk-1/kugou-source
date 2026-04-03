package com.kugou.common.filemanager.downloadengine.http;

import com.kugou.common.filemanager.downloadengine.NetLog;
import com.kugou.common.filemanager.downloadengine.http.HttpTaskManager;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpConnectionParams;

/* JADX INFO: loaded from: classes2.dex */
public class HttpConnector {
    private HttpClient mHttpClient;
    private HttpTaskManager.IHttpProxyProvider proxyProvider;
    private int mConnTimeOut = 30000;
    private int mReadTimeOut = 30000;

    public HttpConnector(HttpTaskManager.IHttpProxyProvider iHttpProxyProvider, String str) {
        this.proxyProvider = iHttpProxyProvider;
        this.mHttpClient = create(str);
    }

    private void addProxyHeader(HttpGet httpGet, String str) {
        Header[] allHeaders = this.proxyProvider.getAllHeaders(str);
        if (allHeaders != null) {
            for (Header header : allHeaders) {
                httpGet.addHeader(header);
            }
        }
    }

    private HttpResponse connect(HttpClient httpClient, String str) throws Exception {
        HttpGet httpGet = new HttpGet(str);
        addProxyHeader(httpGet, str);
        return httpClient.execute(httpGet);
    }

    private HttpClient create(String str) {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.mConnTimeOut);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.mReadTimeOut);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 65536);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        defaultHttpClient.getParams().setParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, Boolean.FALSE);
        HttpHost proxy = this.proxyProvider.getProxy(str);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
        }
        return defaultHttpClient;
    }

    private KGHttpResponse handleResponse(HttpResponse httpResponse) throws Exception {
        if (httpResponse == null) {
            return null;
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (NetLog.isDebug()) {
            NetLog.d("responseCode", "responseCode-->" + statusCode);
        }
        HttpEntity entity = httpResponse.getEntity();
        InputStream content = entity.getContent();
        long contentLength = entity.getContentLength();
        KGHttpResponse kGHttpResponse = new KGHttpResponse(statusCode, content);
        kGHttpResponse.setContentLength(contentLength);
        Header contentType = entity.getContentType();
        if (contentType != null) {
            kGHttpResponse.setContentType(contentType.getValue());
        }
        return kGHttpResponse;
    }

    public void close() throws Exception {
        HttpClient httpClient = this.mHttpClient;
        if (httpClient != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public KGHttpResponse getHttpResponse(String str) throws Exception {
        return handleResponse(connect(this.mHttpClient, str));
    }
}
