package e.c.a.g.a.g.i;

import com.google.gson.Gson;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.ResponsePackage;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.g0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes2.dex */
public class z extends e.c.a.g.a.f.k.a implements ResponsePackage {
    public String b;
    public HashMap<String, Object> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConfigKey f924d;
    public String a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f925e = 1;

    public z(HashMap<String, Object> map, String str, ConfigKey configKey) {
        this.b = "GET";
        this.c = null;
        this.f924d = null;
        this.b = str;
        this.f924d = configKey;
        this.c = map;
    }

    public static String a(HashMap<String, Object> map) {
        Object obj;
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");
        int i2 = 0;
        for (String str : map.keySet()) {
            if (str != null && (obj = map.get(str)) != null) {
                if (i2 != 0) {
                    stringBuffer.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
                }
                stringBuffer.append(str);
                stringBuffer.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
                stringBuffer.append(obj.toString());
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    public final HttpEntity b() {
        Object obj;
        HashMap<String, Object> map = this.c;
        if (map != null && map.size() > 0) {
            if (this.f925e == 2) {
                try {
                    if (g0.a) {
                        g0.e("JsonRespHttpUrlTransor", " json: " + new Gson().toJson(this.c));
                    }
                    return new StringEntity(e.c.a.g.a.s.t.c(this.c));
                } catch (Exception unused) {
                    return null;
                }
            }
            ArrayList arrayList = new ArrayList();
            for (String str : this.c.keySet()) {
                if (str != null && (obj = this.c.get(str)) != null) {
                    arrayList.add(new BasicNameValuePair(str, obj.toString()));
                }
            }
            try {
                return new UrlEncodedFormEntity(arrayList, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                if (g0.a) {
                    g0.c("JsonRespHttpUrlTransor", e2.getMessage() + "");
                }
            }
        }
        return null;
    }

    public String c() {
        return this.a;
    }

    public void d(int i2) {
        this.f925e = i2;
    }

    @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
    public String getGetRequestParams() {
        return "GET".equals(this.b) ? a(this.c) : super.getGetRequestParams();
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public HttpEntity getPostRequestEntity() {
        if ("POST".equals(this.b)) {
            return b();
        }
        return null;
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestModuleName() {
        return "JsonRespHttpTransor";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestType() {
        return this.b;
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    @Deprecated
    public final void getResponseData(Object obj) {
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public ResponseTypeChecker.ResponseType getResponseType() {
        return ResponseTypeChecker.ResponseType.JSON;
    }

    @Override // e.c.a.g.a.f.k.a
    public ConfigKey getUrlConfigKey() {
        return this.f924d;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onContentException(int i2, String str, int i3, byte[] bArr) {
        if (g0.a) {
            g0.c("JsonRespHttpUrlTransor", getRequestModuleName() + "onContentException");
        }
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        if (g0.a) {
            g0.c("JsonRespHttpUrlTransor", getRequestModuleName() + "onHeaderException");
        }
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public void setContext(byte[] bArr) {
        try {
            this.a = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            if (g0.a) {
                g0.c("JsonRespHttpUrlTransor", e2.getMessage() + "");
            }
        }
    }
}
