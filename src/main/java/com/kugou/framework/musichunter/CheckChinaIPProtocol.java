package com.kugou.framework.musichunter;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.framework.libcommon.KGHttpClient;
import com.kugou.framework.libcommon.NetworkUtils;
import com.kugou.framework.libcommon.RequestPackage;
import com.kugou.framework.libcommon.netcore.HttpEntity;
import java.util.Hashtable;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CheckChinaIPProtocol {

    public static class CheckChinaIPRequestPackage implements RequestPackage {
        private Map<String, Object> map;

        public CheckChinaIPRequestPackage(Map<String, Object> map) {
            this.map = map;
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public String getGetRequestParams() {
            return Utils.toRequestParams(this.map);
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public Map<String, String> getHttpHeaders() {
            return null;
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public Map<String, Object> getRequestMapParams() {
            return this.map;
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public String getRequestModuleName() {
            return "CheckChinaIP";
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public String getRequestType() {
            return "GET";
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public String getUrl() {
            return "https://gateway.kugou.com/ip/api/v1/overseas/check_v2";
        }
    }

    public static class CheckChinaIPResponePackage extends StringResponsePackage<CheckChinaIPResult> {
        private String areaCode;
        private String flag;
        private int isSpecialPay;
        private String mData;
        private int mNetError;

        public void onContentException(int i2, String str, int i3, byte[] bArr) {
            this.mNetError = 1;
        }

        @Override // com.kugou.framework.musichunter.StringResponsePackage, com.kugou.framework.libcommon.ResponsePackage
        public void setContext(byte[] bArr) {
            try {
                String str = new String(bArr, "utf-8");
                this.mData = str;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(this.mData);
                if (jSONObject.getString(NotificationCompat.CATEGORY_STATUS) == null) {
                    this.mNetError = 2;
                    return;
                }
                if (!"1".equalsIgnoreCase(jSONObject.getString(NotificationCompat.CATEGORY_STATUS))) {
                    this.mNetError = 2;
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("info");
                this.flag = jSONObject2.getString("flag");
                this.areaCode = jSONObject2.optString("area_code", "1");
                this.isSpecialPay = jSONObject2.optInt("is_special_vip", 0);
                this.mNetError = 0;
            } catch (Exception unused) {
                this.mNetError = 1;
            }
        }

        @Override // com.kugou.framework.musichunter.StringResponsePackage, com.kugou.framework.libcommon.ResponsePackage
        public void getResponseData(CheckChinaIPResult checkChinaIPResult) {
            if (TextUtils.isEmpty(this.mData)) {
                checkChinaIPResult.setNetError(1);
            } else {
                checkChinaIPResult.setNetError(this.mNetError);
            }
            checkChinaIPResult.setmData(this.mData);
            checkChinaIPResult.setFlag(this.flag);
            checkChinaIPResult.setAreaCode(this.areaCode);
            checkChinaIPResult.setIs_special_pay(this.isSpecialPay);
        }
    }

    private static Hashtable<String, Object> assembleCheckIPParams(Context context) {
        String networkType = NetworkUtils.getNetworkType(context);
        int i2 = 0;
        if (!"unknown".equals(networkType)) {
            if ("3G".equals(networkType) || "4G".equals(networkType) || "5G".equals(networkType)) {
                i2 = 2;
            } else if ("wifi".equals(networkType)) {
                i2 = 1;
            }
        }
        Hashtable<String, Object> hashtable = new Hashtable<>();
        hashtable.put("plat", Global.plat);
        hashtable.put(ClientCookie.VERSION_ATTR, Integer.valueOf(Global.CLIENT_VER));
        hashtable.put("userid", 0);
        hashtable.put("token", "");
        hashtable.put("vip_type", 0);
        hashtable.put("music_type", 0);
        hashtable.put("net_type", Integer.valueOf(i2));
        hashtable.put("login", 0);
        hashtable.put("type", 1);
        hashtable.put("apiver", 2);
        return hashtable;
    }

    public static CheckChinaIPResult checkCanUseNetService(Context context) throws Exception {
        CheckChinaIPResult checkChinaIPResult = new CheckChinaIPResult();
        doCheckIPRequest(context, assembleCheckIPParams(context), checkChinaIPResult);
        return checkChinaIPResult;
    }

    private static void doCheckIPRequest(Context context, Hashtable<String, Object> hashtable, CheckChinaIPResult checkChinaIPResult) throws Exception {
        CheckChinaIPRequestPackage checkChinaIPRequestPackage = new CheckChinaIPRequestPackage(hashtable);
        checkChinaIPRequestPackage.getUrl();
        try {
            hashtable.put("appid", Global.appId);
            hashtable.put("dfid", "-");
            hashtable.put("mid", Long.valueOf(Utils.getUniqueID()));
            hashtable.put("uuid", Utils.getStandardUuid());
            hashtable.put("clientver", Integer.valueOf(Global.CLIENT_VER));
            hashtable.put("clienttime", String.valueOf(System.currentTimeMillis() / 1000));
            hashtable.put("signature", Utils.getSignature(Global.appKey, Utils.map2SortString(hashtable), null));
            CheckChinaIPResponePackage checkChinaIPResponePackage = new CheckChinaIPResponePackage();
            KGHttpClient.getInstance(context).request(checkChinaIPRequestPackage, checkChinaIPResponePackage);
            checkChinaIPResponePackage.getResponseData(checkChinaIPResult);
        } catch (Exception e2) {
            e2.printStackTrace();
            checkChinaIPResult.setNetError(1);
        }
    }
}
