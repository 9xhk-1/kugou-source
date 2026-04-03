package com.kugou.common.network.netgate;

import android.net.Proxy;
import android.text.TextUtils;
import android.util.Base64;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.ackutils.SoftEncrypt;
import com.kugou.common.network.ackutils.StringResponsePackage;
import com.kugou.common.network.netgate.AckManager;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AckProtocal {
    private int mKey;
    private long mKeyCrc;
    private byte[] mKeyEncoded;
    private byte[] mKeyRaw;

    public static class AckRequestPackage extends AbstractRequestPackage {
        private String mAckServer;
        private Hashtable<String, String> mMyParams;
        private String mTargetHost;

        public AckRequestPackage(String str, Hashtable<String, String> hashtable) {
            this.mAckServer = str;
            this.mMyParams = hashtable;
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public Header[] getHttpHeaders() {
            return !TextUtils.isEmpty(this.mTargetHost) ? new Header[]{new BasicHeader(HTTP.TARGET_HOST, this.mTargetHost)} : super.getHttpHeaders();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            if (this.mMyParams == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.mMyParams.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            try {
                return new UrlEncodedFormEntity(arrayList);
            } catch (UnsupportedEncodingException e2) {
                NetLog.uploadException(e2);
                return null;
            }
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "AckProtocal";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            String ackUrl = AckManager.getAckVars().getAckUrl();
            if (TextUtils.isEmpty(ackUrl) && NetLog.isDebug()) {
                NetLog.e("BLUE", "got empty comon_ack_url_new");
            }
            if (TextUtils.isEmpty(this.mAckServer) || AckManager.ACK_ADDRESS_TAG.equals(this.mAckServer) || AckManager.getAckVars().canUseUnicomProxy() || !TextUtils.isEmpty(Proxy.getDefaultHost())) {
                return ackUrl;
            }
            try {
                URL url = new URL(ackUrl);
                ackUrl = "http://" + this.mAckServer + (url.getFile() == null ? "" : url.getFile());
                this.mTargetHost = url.getHost();
                return ackUrl;
            } catch (MalformedURLException e2) {
                NetLog.uploadException(e2);
                return ackUrl;
            }
        }
    }

    public static class AckResponsePackage extends StringResponsePackage<AckManager.AckConfigEntity> {
        private int mKey;

        public AckResponsePackage(int i2) {
            this.mKey = i2;
        }

        @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
        public void getResponseData(AckManager.AckConfigEntity ackConfigEntity) {
            try {
                JSONObject jSONObject = new JSONObject(this.mJsonString);
                ackConfigEntity.status = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                ackConfigEntity.time = jSONObject.optLong("time", 0L);
                ackConfigEntity.errorCode = jSONObject.getInt("error_code");
                ackConfigEntity.isp = jSONObject.getInt("isp");
                ackConfigEntity.area = jSONObject.getInt("area");
                byte[] bArrDecode = Base64.decode(jSONObject.getString("data"), 0);
                SoftEncrypt.DecodeEx(bArrDecode, 0, bArrDecode.length, 0L, this.mKey);
                ackConfigEntity.data = new String(bArrDecode);
                byte[] bArrDecode2 = Base64.decode(jSONObject.optString("url_host_map"), 0);
                SoftEncrypt.DecodeEx(bArrDecode2, 0, bArrDecode2.length, 0L, this.mKey);
                ackConfigEntity.urlHostMap = new String(bArrDecode2);
                if (NetLog.isDebug()) {
                    NetLog.d("BLUE", "data is " + ackConfigEntity.data + "n url_host_map is " + ackConfigEntity.urlHostMap);
                }
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
            } catch (Exception e3) {
                NetLog.uploadException(e3);
            }
        }
    }

    public AckProtocal() {
        int iNextInt = new Random().nextInt(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mKey = iNextInt;
        byte[] bytes = String.valueOf(iNextInt).getBytes();
        this.mKeyRaw = bytes;
        byte[] bArr = new byte[bytes.length];
        this.mKeyEncoded = bArr;
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        byte[] bArr2 = this.mKeyEncoded;
        this.mKeyCrc = SoftEncrypt.Encode3(bArr2, 0, bArr2.length);
    }

    public AckManager.AckConfigEntity getAckService(int[] iArr, int[] iArr2, Map<String, Integer> map, int i2, int i3, String str) {
        if (iArr.length == 0 || iArr.length != iArr2.length) {
            throw new IllegalArgumentException("serviceIds.lenght mismatch oldVersion.length");
        }
        AckManager.AckConfigEntity ackConfigEntity = null;
        JSONObject jSONObject = new JSONObject();
        for (int i4 = 0; i4 < iArr.length; i4++) {
            try {
                jSONObject.put(String.valueOf(iArr[i4]), String.valueOf(iArr2[i4]));
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
            }
        }
        String string = jSONObject.toString();
        JSONArray jSONArray = new JSONArray();
        if (map != null) {
            try {
                for (String str2 : map.keySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(AckUpdateStatEntity.HOST_KEY, str2);
                    jSONObject2.put(ClientCookie.VERSION_ATTR, map.get(str2));
                    jSONArray.put(jSONObject2);
                }
            } catch (JSONException e3) {
                NetLog.uploadException(e3);
            }
        }
        Hashtable hashtable = new Hashtable();
        hashtable.putAll(AckManager.getAckVars().getAckRequestParams());
        hashtable.put("plats", string);
        hashtable.put("url_host_map", jSONArray.toString());
        if (i2 >= 0) {
            hashtable.put("isp", String.valueOf(i2));
        }
        if (i3 >= 0) {
            hashtable.put("area", String.valueOf(i3));
        }
        hashtable.put("p", new String(Base64.encode(this.mKeyEncoded, 2)));
        hashtable.put("c", String.valueOf(this.mKeyCrc));
        if (AckManager.getAckVars().isEnableProtocolRetry()) {
            hashtable.put("base_on", "1");
        }
        AckRequestPackage ackRequestPackage = new AckRequestPackage(str, hashtable);
        AckResponsePackage ackResponsePackage = new AckResponsePackage(this.mKey);
        try {
            AckManager.getAckVars().getHttpClient().request(ackRequestPackage, ackResponsePackage);
            AckManager.AckConfigEntity ackConfigEntity2 = new AckManager.AckConfigEntity();
            try {
                ackResponsePackage.getResponseData(ackConfigEntity2);
                return ackConfigEntity2;
            } catch (Exception e4) {
                e = e4;
                ackConfigEntity = ackConfigEntity2;
                NetLog.uploadException(e);
                return ackConfigEntity;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }
}
