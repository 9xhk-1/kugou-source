package com.kugou.framework.bilib.statistics.cscc;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.bilib.statistics.cscc.utils.AesTool;
import com.kugou.framework.bilib.statistics.cscc.utils.RsaTool;
import com.kugou.framework.libcommon.MD5Util;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CsccCypher {
    private static final String ALLOWED_CHARACTERS = "1234567890qwertyuiopasdfghjklzxcvbnm";
    private String mDynamicKey;
    private ServerResp mServerResp;
    private final String UUID = LibConfig.getInstance().getUUID();
    private final String RSA_PUBLIC_KEY = LibConfig.getInstance().getPublicKey();
    private String mClientAesKey = genClientAesKey(32);

    public static class ServerResp {
        public long mClientTime;
        public String mCookie;
        public String mServerKey;
        public long mServerTime;
    }

    private String genClientAesKey(int i2) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(ALLOWED_CHARACTERS.charAt(random.nextInt(36)));
        }
        return sb.toString();
    }

    private long getTimestampMs(String str) {
        return ((System.currentTimeMillis() / 1000) * 1000) + ((long) (str.hashCode() % 1000));
    }

    private void refreshDynamicKey(ServerResp serverResp) {
        if (serverResp == null) {
            return;
        }
        try {
            this.mDynamicKey = MD5Util.getMd5((this.UUID + serverResp.mClientTime + this.mClientAesKey + serverResp.mServerKey).getBytes("UTF-8"));
            Log.i("burone-cypher", "mDynamicKey = " + this.mDynamicKey);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    public byte[] encryptWithImeiIv(byte[] bArr) {
        return AesTool.encryptWithImeiIv(this.mDynamicKey, this.UUID, bArr);
    }

    public String genClientEncodeBase64S(long j) {
        String str = this.mClientAesKey;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.UUID + DataWrapper.MARK_SEPERATE + str;
        byte[] bArrEncrypt = RsaTool.encrypt(str2 + DataWrapper.MARK_SEPERATE + String.valueOf(getTimestampMs(str2)), this.RSA_PUBLIC_KEY);
        if (bArrEncrypt == null || bArrEncrypt.length <= 0) {
            return null;
        }
        return Base64.encodeToString(bArrEncrypt, 2);
    }

    public ServerResp getServerResp() {
        return this.mServerResp;
    }

    public String getUUID() {
        return this.UUID;
    }

    public boolean isGenOk() {
        ServerResp serverResp = this.mServerResp;
        return (serverResp == null || serverResp.mCookie == null || serverResp.mServerKey == null || serverResp.mServerTime <= 0 || this.mClientAesKey == null) ? false : true;
    }

    public void setServerEncodeBase64Data(String str) {
        try {
            JSONObject jSONObject = new JSONObject(AesTool.decryptWithImeiIv(this.mClientAesKey, this.UUID, Base64.decode(str, 2)));
            if (this.mServerResp == null) {
                this.mServerResp = new ServerResp();
            }
            this.mServerResp.mClientTime = jSONObject.getLong("clienttime");
            this.mServerResp.mServerTime = jSONObject.getLong("servertime");
            this.mServerResp.mServerKey = jSONObject.getString("serverstr");
            this.mServerResp.mCookie = jSONObject.getString("cookie");
            refreshDynamicKey(this.mServerResp);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
