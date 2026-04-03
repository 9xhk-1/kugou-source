package com.kugou.common.userinfo.protocol;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.ISSARequest;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import e.c.a.g.a.d.b.a;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.f.k.k.e;
import e.c.a.g.a.r.b;
import e.c.a.g.a.r.d.d.g;
import e.c.a.g.a.r.g.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GetVIPInfoProtocol {
    public static int GET_DEFAULT_VIPINFO = 1;
    public static int GET_SIMPLE_VIPINFO = 2;
    public a error;
    private boolean mAutoCharge = false;
    private int mInfoType = GET_DEFAULT_VIPINFO;
    private String mToken;
    private long mUid;

    public class GetVIPInfoRequestPackage extends g implements ISSARequest {
        public GetVIPInfoRequestPackage() {
        }

        @Override // e.c.a.g.a.r.d.d.g, com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            if (!GetVIPInfoProtocol.this.mAutoCharge) {
                return "";
            }
            long jF = l1.f();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("kugouid=");
            stringBuffer.append(GetVIPInfoProtocol.this.mUid);
            stringBuffer.append("&clientappid=");
            stringBuffer.append(jF);
            stringBuffer.append("&clienttoken=");
            stringBuffer.append(b.n());
            stringBuffer.append("&clientver=");
            stringBuffer.append(e.c.a.g.a.r.e.b.c(this.context));
            stringBuffer.append("&infotype=" + GetVIPInfoProtocol.this.mInfoType);
            stringBuffer.append("&level_flag=");
            stringBuffer.append(1);
            stringBuffer.append("&mid=");
            stringBuffer.append(l1.n(this.context));
            return stringBuffer.toString();
        }

        @Override // e.c.a.g.a.r.d.d.g, com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                if (GetVIPInfoProtocol.this.mAutoCharge) {
                    return null;
                }
                this.map.put("userid", Long.valueOf(GetVIPInfoProtocol.this.mUid));
                HashMap map = new HashMap();
                map.put("clienttime", Integer.valueOf(this.clientTime));
                map.put("token", GetVIPInfoProtocol.this.mToken);
                this.map.put("p", d.d(e.c.a.g.a.r.e.b.d(map), l1.h()));
                this.map.put("type", 0);
                return new StringEntity(e.c.a.g.a.r.e.b.d(this.map));
            } catch (Exception e2) {
                g0.k(e2);
                return null;
            }
        }

        @Override // e.c.a.g.a.r.d.d.g, com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "User";
        }

        @Override // e.c.a.g.a.r.d.d.g, com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return GetVIPInfoProtocol.this.mAutoCharge ? "GET" : "POST";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            return GetVIPInfoProtocol.this.mAutoCharge ? c.c().b(e.c.a.g.a.f.e.b.u2, "http://vip.kugou.com/user/vipinfo") : c.c().b(e.c.a.g.a.f.e.b.t2, "http://userinfo.user.kugou.com/get_vip_info");
        }

        @Override // com.kugou.common.network.protocol.ISSARequest
        public boolean isEnableSSA() {
            return true;
        }
    }

    public class VipInfoResponePackage extends e.c.a.g.a.f.k.k.a<UserData> implements AbsHttpClient.IHttpProperty {
        private String respStr;
        private int statusCode;

        public VipInfoResponePackage() {
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.JSON;
        }

        @Override // e.c.a.g.a.f.k.k.a
        public int getStatusCode() {
            return this.statusCode;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                this.respStr = new String(bArr, "UTF-8");
            } catch (Exception unused) {
            }
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
        public boolean onContentType(String str) {
            return true;
        }

        @Override // e.c.a.g.a.f.k.k.a
        public void onHandleApmData(a aVar) {
            GetVIPInfoProtocol.this.error = aVar;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
        public boolean onHeaders(Header[] headerArr) {
            return true;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
        public boolean onResponseCode(int i2) {
            setStatusCode(i2);
            return true;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                String str = new String(bArr, "UTF-8");
                this.respStr = str;
                if (g0.a) {
                    g0.e("user info", str);
                }
            } catch (Exception unused) {
            }
        }

        public void setStatusCode(int i2) {
            this.statusCode = i2;
        }

        @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
        public void getResponseData(UserData userData) {
            VipInfoResponePackage vipInfoResponePackage;
            if (userData == null || TextUtils.isEmpty(this.respStr)) {
                throw new NullPointerException("VIP resp is Empty");
            }
            try {
                JSONObject jSONObject = new JSONObject(this.respStr);
                if (jSONObject.optString(NotificationCompat.CATEGORY_STATUS) == null) {
                    userData.setRespStr(this.respStr);
                    userData.setMessage(jSONObject.getString("data"));
                    throw new NullPointerException("VIP status is Null");
                }
                try {
                    userData.setStatus(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
                    if (jSONObject.getInt(NotificationCompat.CATEGORY_STATUS) == 1) {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.getString("data"));
                        userData.setUserid(jSONObject2.getLong("userid"));
                        userData.setVip_type(jSONObject2.getInt("vip_type"));
                        if (jSONObject2.has("vip_begin_time")) {
                            userData.setVip_begin_time(jSONObject2.getString("vip_begin_time"));
                        }
                        if (jSONObject2.has("vip_end_time")) {
                            userData.setVip_end_time(jSONObject2.getString("vip_end_time"));
                        }
                        if (jSONObject2.has("svip_end_time")) {
                            userData.setSuper_Vip_end_time(jSONObject2.getString("svip_end_time"));
                        }
                        if (jSONObject2.has("servertime")) {
                            userData.setServertime(jSONObject2.getString("servertime"));
                        }
                        if (jSONObject2.has("m_type")) {
                            userData.setMusicType(jSONObject2.getInt("m_type"));
                        }
                        if (jSONObject2.has("y_type")) {
                            userData.setYearType(jSONObject2.optInt("y_type"));
                        }
                        SVIPExtInfoUtil.parseAsSVIPExtInfo(userData, jSONObject2);
                        if (jSONObject2.has("roam_type")) {
                            userData.setRoamType(jSONObject2.optInt("roam_type"));
                        }
                        if (jSONObject2.has("roam_begin_time")) {
                            userData.setRoamBeginTime(jSONObject2.optString("roam_begin_time"));
                        }
                        if (jSONObject2.has("roam_end_time")) {
                            userData.setRoamEndTime(jSONObject2.optString("roam_end_time"));
                        }
                        if (jSONObject2.has("m_clearday")) {
                            userData.setMusic_clearday(jSONObject2.getString("m_clearday"));
                        }
                        if (jSONObject2.has("m_reset_time")) {
                            userData.setMusic_resetTime(jSONObject2.optString("m_reset_time"));
                        }
                        if (jSONObject2.has("m_begin_time")) {
                            userData.setMusicBegin(jSONObject2.getString("m_begin_time"));
                        }
                        if (jSONObject2.has("m_end_time")) {
                            userData.setMusicEnd(jSONObject2.getString("m_end_time"));
                        }
                        vipInfoResponePackage = this;
                        if (GetVIPInfoProtocol.this.mAutoCharge) {
                            if (jSONObject2.has("autoChargeTime")) {
                                userData.setAutochargetime(jSONObject2.getString("autoChargeTime"));
                            }
                            if (jSONObject2.has("autoChargeType")) {
                                userData.setAutochargetype(jSONObject2.getInt("autoChargeType"));
                            }
                            if (jSONObject2.has("autostatus")) {
                                userData.setAutostatus(jSONObject2.getInt("autostatus"));
                            }
                            if (jSONObject2.has("phone")) {
                                userData.setPhone(jSONObject2.getString("phone"));
                            }
                            if (jSONObject2.has("producttype")) {
                                userData.setProducttype(jSONObject2.getString("producttype"));
                            }
                        }
                    } else {
                        vipInfoResponePackage = this;
                        if (jSONObject.getInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                            userData.setStatus(0);
                            if (GetVIPInfoProtocol.this.mAutoCharge) {
                                userData.setError_code(jSONObject.getInt("error_code"));
                            } else {
                                userData.setError_code(jSONObject.getInt("errno"));
                            }
                            userData.setMessage(jSONObject.getString("data"));
                        }
                    }
                    userData.setRespStr(vipInfoResponePackage.respStr);
                    int unused = GetVIPInfoProtocol.this.mInfoType;
                    int i2 = GetVIPInfoProtocol.GET_SIMPLE_VIPINFO;
                } catch (Exception e2) {
                    e = e2;
                    throw new NullPointerException("VIP resp json format Incorrect:" + e.getMessage());
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
    }

    @Nullable
    public UserData getVIPInfo(long j, String str) {
        return getVIPInfo(j, str, false, 0);
    }

    @Nullable
    public UserData getVIPInfo(long j, String str, boolean z, int i2) {
        return getVIPInfo(j, str, z, i2, GET_DEFAULT_VIPINFO);
    }

    @Nullable
    public UserData getVIPInfo(long j, String str, boolean z, int i2, int i3) {
        this.mToken = str;
        this.mUid = j;
        this.mAutoCharge = z;
        this.mInfoType = i3;
        UserData userDataNewEmptyInstance = UserData.newEmptyInstance();
        GetVIPInfoRequestPackage getVIPInfoRequestPackage = new GetVIPInfoRequestPackage();
        VipInfoResponePackage vipInfoResponePackage = new VipInfoResponePackage();
        AbsHttpClient.IRequestUrlReceiver iRequestUrlReceiver = new AbsHttpClient.IRequestUrlReceiver() { // from class: com.kugou.common.userinfo.protocol.GetVIPInfoProtocol.1
            public String mUrl = null;

            @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
            public String getRequestUrl(String str2) {
                return this.mUrl;
            }

            @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
            public void onHttpGet(String str2) {
                this.mUrl = str2;
            }

            @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
            public void onHttpPost(String str2) {
                this.mUrl = str2;
            }

            @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
            public void onUrlState(String str2, boolean z2) {
            }
        };
        try {
            e eVarA = e.a();
            eVarA.setRequestUrlReceiver(iRequestUrlReceiver);
            eVarA.request(getVIPInfoRequestPackage, vipInfoResponePackage);
            if (i2 != 0) {
                eVarA.setMaxWaitDuration(i2);
            }
            vipInfoResponePackage.getResponseData(userDataNewEmptyInstance);
        } catch (Exception unused) {
            userDataNewEmptyInstance = null;
        }
        if (userDataNewEmptyInstance != null) {
            userDataNewEmptyInstance.getStatus();
        }
        return userDataNewEmptyInstance;
    }
}
