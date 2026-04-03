package com.kugou.common.network.quic;

import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.quic.CronetApacheClient;
import h.a.b.c;
import h.a.b.m;
import h.a.b.o.b;
import h.a.b.p.d;
import h.a.b.p.e;
import h.a.b.p.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.KGOKHttpClientExt;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;
import org.chromium.net.ProxyChangeListener;
import org.chromium.net.impl.CronetUrlRequest;

/* JADX INFO: loaded from: classes2.dex */
public class CronetHandler {
    private static final int MAX_CACHE_SIZE = 20971520;
    private volatile c cronetEngineHttps;
    private volatile c cronetEngineQuic;
    private h urlStreamHandlerFactory;

    public static class Holder {
        public static CronetHandler INSTANCE = new CronetHandler();
    }

    private c getCronetEngine(boolean z) {
        return z ? this.cronetEngineQuic : this.cronetEngineHttps;
    }

    public static CronetHandler getInstance() {
        return Holder.INSTANCE;
    }

    private void setCronetEngine(boolean z, c cVar) {
        if (z) {
            this.cronetEngineQuic = cVar;
        } else {
            this.cronetEngineHttps = cVar;
            this.urlStreamHandlerFactory = new h((b) cVar);
        }
    }

    public void checkInitCronetEngine(Context context, boolean z) {
        if (getCronetEngine(z) == null) {
            synchronized (CronetHandler.class) {
                if (getCronetEngine(z) == null) {
                    c.a aVar = new c.a(context);
                    File file = new File(context.getCacheDir(), ".cronet");
                    if (file.exists() || file.mkdirs()) {
                        aVar.j(file.getAbsolutePath());
                        aVar.f(3, 20971520L);
                    }
                    if (z) {
                        aVar.a("qgw.kugou.com", 443, 443);
                        aVar.a("gateway.kugou.com", 443, 443);
                        aVar.a("gatewayretry.kugou.com", 443, 443);
                        aVar.g(true);
                    }
                    aVar.e(true);
                    aVar.h(true);
                    setCronetEngine(z, aVar.b());
                }
            }
        }
    }

    public c getCronetEngineQuic() {
        return this.cronetEngineQuic;
    }

    public CronetApacheClient.CronetResponseEntity request(boolean z, AbsHttpClient.CronetCallWrapper cronetCallWrapper, HttpHost httpHost, CronetReqBuilder cronetReqBuilder) throws Exception {
        ProxyChangeListener proxyChangeListenerA;
        HttpEntityUploadProvider httpEntityUploadProvider;
        CronetApacheClient.CronetResponseEntity cronetResponseEntity = new CronetApacheClient.CronetResponseEntity();
        if (z) {
            Object obj = new Object();
            m.a aVarA = getCronetEngine(true).a(cronetReqBuilder.url, new CronetRequestCallback(obj, cronetResponseEntity), KGOKHttpClientExt.getOKHttpExecutor());
            aVarA.d(cronetReqBuilder.method);
            if ("POST".equals(cronetReqBuilder.method) && (httpEntityUploadProvider = cronetReqBuilder.provider) != null) {
                aVarA.a("Content-Type", httpEntityUploadProvider.getMediaType().toString());
                aVarA.e(cronetReqBuilder.provider, KGOKHttpClientExt.getOKHttpExecutor());
            }
            Header[] headerArr = cronetReqBuilder.headers;
            if (headerArr != null) {
                for (Header header : headerArr) {
                    if (!TextUtils.isEmpty(header.getName()) && !TextUtils.isEmpty(header.getValue())) {
                        aVarA.a(header.getName(), header.getValue());
                    }
                }
            }
            CronetUrlRequest cronetUrlRequest = (CronetUrlRequest) aVarA.b();
            cronetUrlRequest.e();
            if (cronetCallWrapper != null) {
                cronetCallWrapper.urlRequest = cronetUrlRequest;
            }
            synchronized (obj) {
                obj.wait(cronetReqBuilder.timeOut);
            }
        } else {
            URL url = new URL(cronetReqBuilder.url);
            e eVar = (e) this.urlStreamHandlerFactory.createURLStreamHandler(url.getProtocol());
            if (httpHost != null && (proxyChangeListenerA = ProxyChangeListener.a()) != null) {
                proxyChangeListenerA.c(new ProxyChangeListener.b(httpHost.getHostName(), httpHost.getPort(), null, new String[0]));
            }
            d dVar = (d) eVar.openConnection(url);
            dVar.setRequestMethod(cronetReqBuilder.method);
            dVar.setRequestProperty(Headers.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            Header[] headerArr2 = cronetReqBuilder.headers;
            if (headerArr2 != null) {
                for (Header header2 : headerArr2) {
                    if (!TextUtils.isEmpty(header2.getName()) && !TextUtils.isEmpty(header2.getValue())) {
                        dVar.setRequestProperty(header2.getName(), header2.getValue());
                    }
                }
            }
            if (cronetReqBuilder.provider != null && cronetReqBuilder.method.equalsIgnoreCase("POST")) {
                dVar.addRequestProperty("Content-Type", cronetReqBuilder.provider.getMediaType().toString());
                dVar.v(cronetReqBuilder.provider);
            }
            dVar.connect();
            int responseCode = dVar.getResponseCode();
            String responseMessage = dVar.getResponseMessage();
            Map<String, List<String>> headerFields = dVar.getHeaderFields();
            ArrayList arrayList = new ArrayList();
            if (headerFields != null) {
                for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                    StringBuilder sb = new StringBuilder();
                    List<String> value = entry.getValue();
                    int size = value.size() - 1;
                    for (int i2 = 0; i2 <= size; i2++) {
                        sb.append(value.get(i2));
                        if (i2 < size) {
                            sb.append(",");
                        }
                    }
                    arrayList.add(new AbstractMap.SimpleEntry(entry.getKey(), sb.toString()));
                }
            }
            if (responseCode >= 200 && responseCode < 300) {
                InputStream inputStream = dVar.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i3 = inputStream.read(bArr);
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                }
                byteArrayOutputStream.close();
                inputStream.close();
                cronetResponseEntity.responseBytes = byteArrayOutputStream.toByteArray();
            }
            cronetResponseEntity.message = responseMessage;
            cronetResponseEntity.code = responseCode;
            cronetResponseEntity.headerList = arrayList;
        }
        return cronetResponseEntity;
    }

    private CronetHandler() {
    }
}
