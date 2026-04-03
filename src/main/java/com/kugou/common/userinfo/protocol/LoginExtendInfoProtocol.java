package com.kugou.common.userinfo.protocol;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import com.kugou.common.network.protocol.ResponsePackage;
import com.kugou.common.useraccount.entity.SVIPExtInfo;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import e.c.a.g.a.f.k.k.e;
import e.c.a.g.a.r.b;
import e.c.a.g.a.r.g.a;
import e.c.a.g.a.r.g.c;
import e.c.a.g.a.r.g.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Hashtable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LoginExtendInfoProtocol {

    public static final class GetUserGradeInfoRequestPackage extends AbstractRequestPackage {
        private final String bodyJsonStr;
        private HashMap<String, Object> map;

        public GetUserGradeInfoRequestPackage() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jO = b.o();
            HashMap<String, Object> map = new HashMap<>();
            this.map = map;
            map.put("plat", "1");
            this.map.put("userid", String.valueOf(jO));
            this.map.put("clienttime_ms", Long.valueOf(jCurrentTimeMillis));
            this.map.put("ext", 2);
            String strD = a.d();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("clienttime_ms", jCurrentTimeMillis);
                jSONObject.put("key", strD);
                this.map.put("pk", d.d(jSONObject.toString(), l1.h()));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("userid", String.valueOf(jO));
                jSONObject2.put("token", b.n());
                this.map.put("params", a.b(jSONObject2.toString(), strD));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String strE = e.c.a.g.a.r.e.b.e(this.map);
            this.bodyJsonStr = strE;
            Hashtable<String, Object> hashtable = new Hashtable<>();
            c cVarZ = c.z();
            cVarZ.s();
            cVarZ.b("clienttime", Long.valueOf(jCurrentTimeMillis / 1000));
            hashtable.putAll(cVarZ.F(strE));
            setParams(hashtable);
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage
        public Hashtable<String, Object> getParams() {
            return super.getParams();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                return new StringEntity(this.bodyJsonStr);
            } catch (UnsupportedEncodingException e2) {
                g0.k(e2);
                return null;
            }
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "get_login_extend_info";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            return e.c.a.g.a.f.e.c.c().b(e.c.a.g.a.f.e.b.m, "https://userinfoservice.kugou.com/v2/get_login_extend_info");
        }
    }

    public static final class GetUserGradeInfoResponsePackage implements ResponsePackage<e.c.a.g.a.f.k.c<LoginExtendInfo>> {
        public String mJsonString;

        private GetUserGradeInfoResponsePackage() {
        }

        public String getJsonString() {
            return this.mJsonString;
        }

        @Override // com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.JSON;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                this.mJsonString = new String(bArr, "UTF-8");
            } catch (Exception unused) {
            }
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                this.mJsonString = new String(bArr, "UTF-8");
            } catch (Exception e2) {
                g0.k(e2);
            }
        }

        @Override // com.kugou.common.network.protocol.ResponsePackage
        public void getResponseData(e.c.a.g.a.f.k.c<LoginExtendInfo> cVar) {
            LoginExtendInfoProtocol.parseUserGradeInfo(cVar, this.mJsonString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void parseUserGradeInfo(e.c.a.g.a.f.k.c<LoginExtendInfo> cVar, String str) {
        JSONObject jSONObjectOptJSONObject;
        if (cVar == null) {
            return;
        }
        cVar.m(0);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (g0.a) {
            g0.b("david", "parseUserGradeInfo: " + str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.m(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0));
            cVar.i(jSONObject.optInt("error_code", 0));
            if (cVar.f() && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null) {
                if (g0.a) {
                    g0.b("david", "vipinfo");
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("vipinfo");
                if (jSONObjectOptJSONObject2 != null) {
                    SVIPExtInfo sVIPExtInfo = new SVIPExtInfo();
                    SVIPExtInfoUtil.parseAsSVIPExtInfo(sVIPExtInfo, jSONObjectOptJSONObject2);
                    SVIPExtInfoUtil.saveSVIPExtInfo(sVIPExtInfo);
                }
            }
        } catch (Exception e2) {
            if (g0.a) {
                g0.i(e2);
            }
            cVar.m(0);
        }
    }

    public e.c.a.g.a.f.k.c<LoginExtendInfo> get() {
        e.c.a.g.a.f.k.c<LoginExtendInfo> cVar = new e.c.a.g.a.f.k.c<>();
        if (!b.F()) {
            return cVar;
        }
        GetUserGradeInfoRequestPackage getUserGradeInfoRequestPackage = new GetUserGradeInfoRequestPackage();
        GetUserGradeInfoResponsePackage getUserGradeInfoResponsePackage = new GetUserGradeInfoResponsePackage();
        try {
            e.a().request(getUserGradeInfoRequestPackage, getUserGradeInfoResponsePackage);
        } catch (Exception e2) {
            g0.k(e2);
        }
        getUserGradeInfoResponsePackage.getResponseData(cVar);
        return cVar;
    }
}
