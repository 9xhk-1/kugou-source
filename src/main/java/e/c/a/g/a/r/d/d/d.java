package e.c.a.g.a.r.d.d;

import android.text.TextUtils;
import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.r.d.d.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.k;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.q0;
import e.c.a.g.a.s.r1;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public int a = 0;
    public int b = 0;
    public boolean c = false;

    public class b extends AbstractRequestPackage {
        public File a;
        public String b;

        public b(File file, Hashtable<String, String> hashtable) {
            this.a = file;
            if (hashtable != null) {
                if (this.mParams == null) {
                    this.mParams = new Hashtable<>();
                }
                this.mParams.putAll(hashtable);
            }
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            String string;
            if (this.mParams != null) {
                if (getPostRequestEntity() != null) {
                    try {
                        string = EntityUtils.toString(getPostRequestEntity(), "utf-8");
                    } catch (IOException | UnsupportedOperationException e2) {
                        g0.k(e2);
                        string = "";
                    }
                    this.mParams.put("signature", r1.d(r1.g(this.mParams) + string));
                } else {
                    string = "";
                    this.mParams.put("signature", r1.d(r1.g(this.mParams) + string));
                }
            }
            return super.getGetRequestParams();
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public Header[] getHttpHeaders() {
            return !TextUtils.isEmpty(this.b) ? new Header[]{new BasicHeader(HTTP.TARGET_HOST, this.b)} : super.getHttpHeaders();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            File file = this.a;
            if (file == null || !file.exists() || this.a.isDirectory()) {
                return null;
            }
            MultipartEntity multipartEntity = new MultipartEntity();
            try {
                String strE = new q0().e(k.c(l1.b(), "yyyyMMdd") + "hewry678WEK23D");
                multipartEntity.addPart("type", new StringBody(d.this.c()));
                multipartEntity.addPart("md5", new StringBody(strE));
                multipartEntity.addPart("file", new FileBody(new e.c.a.g.a.f.g.a(this.a.getPath())));
            } catch (UnsupportedEncodingException e2) {
                g0.k(e2);
            }
            return multipartEntity;
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return d.this.b();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            String config = e.c.a.g.a.f.e.c.c().getConfig(d.this.e());
            if (config == null || TextUtils.isEmpty(config)) {
                config = d.this.a();
            }
            try {
                this.b = new URL(config).getHost();
            } catch (MalformedURLException e2) {
                g0.k(e2);
            }
            return config;
        }
    }

    public static class c extends e.c.a.g.a.f.k.k.a<f.a> {
        public e.c.a.g.a.d.b.a a;
        public String b;

        public c() {
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void getResponseData(f.a aVar) {
            try {
                JSONObject jSONObject = new JSONObject(this.b);
                aVar.f(jSONObject.optBoolean("IsSuccess"));
                JSONArray jSONArray = jSONObject.getJSONArray("Message");
                if (jSONArray != null && jSONArray.length() > 0) {
                    aVar.d(jSONArray.optString(0));
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("FileName");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    aVar.c(jSONArray2.optString(0));
                }
                if (g0.a) {
                    g0.b("postFileEntity", "data is --" + aVar.a());
                }
            } catch (Exception e2) {
                aVar.f(false);
                g0.k(e2);
            }
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.JSON;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
        }

        @Override // e.c.a.g.a.f.k.k.a
        public void onHandleApmData(e.c.a.g.a.d.b.a aVar) {
            this.a = aVar;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                this.b = new String(bArr, "UTF-8");
                if (g0.a) {
                    g0.b("UPLOAD_FILE", "jsonString is " + this.b);
                }
            } catch (UnsupportedEncodingException e2) {
                g0.k(e2);
            }
        }
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public abstract Hashtable<String, String> d();

    public abstract ConfigKey e();

    public f.a f(File file) {
        f.a aVar = new f.a();
        if (file == null || !file.exists() || file.isDirectory()) {
            aVar.f(false);
            e.c.a.g.a.d.b.a aVar2 = new e.c.a.g.a.d.b.a();
            aVar2.i(1);
            aVar2.k(ResponseHandlerForApm.E4);
            aVar.e(aVar2);
            return aVar;
        }
        b bVar = new b(file, d());
        c cVar = new c();
        e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
        if (this.c) {
            eVarA.resetTimeOut(this.a, this.b);
        }
        try {
            eVarA.request(bVar, cVar);
            cVar.getResponseData(aVar);
        } catch (Exception e2) {
            cVar.getResponseData(aVar);
            g0.k(e2);
        }
        aVar.e(cVar.a);
        return aVar;
    }

    public f.a g(String str) {
        return f(new File(str));
    }
}
