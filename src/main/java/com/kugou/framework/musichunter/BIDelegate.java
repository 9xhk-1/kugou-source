package com.kugou.framework.musichunter;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.kugou.framework.bilib.bi.Function;
import com.kugou.framework.bilib.bi.TraceDog;
import com.kugou.framework.bilib.bi.task.ClickFunctionTask;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.libcommon.LogUtils;
import com.kugou.framework.libcommon.MD5Util;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BIDelegate {
    private static final String SDK_VERSION_CODE = "350";
    private static String appId;

    public static class BiLibImpl extends LibConfig {
        @Override // com.kugou.framework.bilib.common.LibConfig
        public String getAppId() {
            return "3118";
        }

        @Override // com.kugou.framework.bilib.common.LibConfig
        public String getAppKey() {
            return "wYaS8lz7D2pCLXrJrMCkdHnp8KRA2XqZ";
        }

        @Override // com.kugou.framework.bilib.common.LibConfig
        public int getBiConfigKey() {
            return 10047;
        }

        @Override // com.kugou.framework.bilib.common.LibConfig
        public String getMid(Context context) {
            return PrivacyUtils.getMid(context);
        }

        @Override // com.kugou.framework.bilib.common.LibConfig
        public String getPublicKey() {
            return "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUiO8G3iMfZhnUYvm25dDVgKRW\nHQxqw6YmeT3hoC0FKv/gQbIwlg14Zd24v/9SfhJjF97SkSo7QY6Q2t+iL+s6ngTN\nng+PC90nwcj+goO482RhSvRIEXFBzrBrSEaybWeNQl0t7WqGBDewBjF/rM/XBFG2\nW30BINEFPs9j6PhPaQIDAQAB";
        }

        @Override // com.kugou.framework.bilib.common.LibConfig
        public String getUUID() {
            return PrivacyUtils.getUUID(Global.getGlobalContext());
        }

        @Override // com.kugou.framework.bilib.common.LibConfig
        public void log(String str, String str2, String str3) {
            LogUtils.logBi(str, str2, str3);
        }
    }

    public static class PrivacyUtils {
        private static final String KEY_ANDROID_ID = "android_id";
        private static final String KEY_IM = "key_im";
        private static final String KEY_RICH_IM = "key_rich_im";
        private static SharedPreferences sp;

        public static class IMEI {
            public static final int MATERIAL_DEVID = 1;
            public static final int MATERIAL_DISKCACHE = 3;
            public static final int MATERIAL_MACADDR = 2;
            public static final int MATERIAL_UUID = 4;
            private static IMEI memoCache;
            public final String content;
            public final boolean fromFileCache;
            public final int material;
            public final String[] materialDetail;

            private static String flatArray(String[] strArr) {
                StringBuilder sb = new StringBuilder();
                for (String str : strArr) {
                    if (TextUtils.isEmpty(str)) {
                        str = "null";
                    }
                    sb.append(str);
                    sb.append(TopicHighlightHelper.AT);
                }
                sb.deleteCharAt(sb.length() - 1);
                return sb.toString();
            }

            public static IMEI fromJson(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    return new IMEI(jSONObject.getString("content"), jSONObject.getBoolean("fromFileCache"), jSONObject.getInt("material"), humpArray(jSONObject.optString("materialDetail")));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }

            private static String[] humpArray(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return str.split(TopicHighlightHelper.AT);
            }

            public String toJson() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("content", this.content);
                    jSONObject.put("fromFileCache", this.fromFileCache);
                    jSONObject.put("material", this.material);
                    jSONObject.put("materialDetail", flatArray(this.materialDetail));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return jSONObject.toString();
            }

            @NonNull
            public String toString() {
                return toJson();
            }

            private IMEI(String str, boolean z, int i2, String[] strArr) {
                String[] strArr2 = new String[4];
                this.materialDetail = strArr2;
                this.content = str;
                this.fromFileCache = z;
                this.material = i2;
                if (strArr == null || strArr.length != strArr2.length) {
                    return;
                }
                System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static String generateAndroidId(Context context) {
            String string;
            if (Global.enableAndroidId()) {
                try {
                    string = Settings.Secure.getString(context.getContentResolver(), KEY_ANDROID_ID);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    string = "";
                }
            } else {
                string = "";
            }
            if (string == null || string.equals("9774d56d682e549c") || string.length() < 15) {
                string = new BigInteger(64, new SecureRandom()).toString(16);
            }
            String mD5ofStr = MD5Util.getMD5ofStr(string);
            if (getSp() != null) {
                getSp().edit().putString(KEY_ANDROID_ID, mD5ofStr).apply();
            }
            return mD5ofStr;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static synchronized String getAndroidId(Context context) {
            String strGenerateAndroidId;
            strGenerateAndroidId = null;
            if (getSp() != null) {
                LogUtils.log("sp不为空， method: PrivacyUtils#1");
                strGenerateAndroidId = getSp().getString(KEY_ANDROID_ID, "");
            }
            if (strGenerateAndroidId == null || strGenerateAndroidId.equals("") || strGenerateAndroidId.equals("null")) {
                strGenerateAndroidId = generateAndroidId(context);
            }
            return strGenerateAndroidId;
        }

        public static String getMid(Context context) {
            return imeiToBigInteger(getRichIMEI(context).content);
        }

        public static IMEI getRichIMEI(Context context) {
            String[] strArr;
            int i2;
            boolean z;
            String[] strArr2;
            if (IMEI.memoCache != null) {
                return IMEI.memoCache;
            }
            String uuid = "";
            boolean z2 = false;
            if (TextUtils.isEmpty("")) {
                IMEI imeiFromJson = IMEI.fromJson(getSpString(KEY_RICH_IM));
                if (imeiFromJson != null) {
                    String str = imeiFromJson.content;
                    i2 = imeiFromJson.material;
                    strArr = imeiFromJson.materialDetail;
                    uuid = str;
                } else {
                    uuid = getSpString(KEY_IM);
                    i2 = 3;
                    strArr = null;
                }
                z = true;
            } else {
                strArr = null;
                i2 = 0;
                z = false;
            }
            if (TextUtils.isEmpty(uuid)) {
                uuid = getUUID(context);
                i2 = 4;
                strArr2 = null;
            } else {
                strArr2 = strArr;
                z2 = z;
            }
            IMEI imei = new IMEI(uuid, z2, i2, strArr2);
            IMEI unused = IMEI.memoCache = imei;
            if (i2 == 1 && !z2) {
                saveSpString(KEY_IM, uuid);
                saveSpString(KEY_RICH_IM, imei.toJson());
            }
            return imei;
        }

        private static SharedPreferences getSp() {
            if (sp == null && Global.getGlobalContext() != null) {
                sp = Global.getGlobalContext().getSharedPreferences(Global.SP_NAME, 0);
            }
            return sp;
        }

        private static String getSpString(String str) {
            if (getSp() != null) {
                return getSp().getString(str, null);
            }
            return null;
        }

        public static String getUUID(Context context) {
            return getAndroidId(context);
        }

        public static String imeiToBigInteger(String str) {
            try {
                BigInteger bigInteger = new BigInteger("0");
                BigInteger bigInteger2 = new BigInteger("16");
                String mD5ofStr = MD5Util.getMD5ofStr(str);
                int length = mD5ofStr.length();
                for (int i2 = 0; i2 < length; i2++) {
                    bigInteger = bigInteger.add(new BigInteger("" + mD5ofStr.charAt(i2), 16).multiply(bigInteger2.pow((length - 1) - i2)));
                }
                return bigInteger.toString();
            } catch (Exception unused) {
                return "0";
            }
        }

        private static void saveSpString(String str, String str2) {
            if (getSp() != null) {
                getSp().edit().putString(str, str2).apply();
            }
        }
    }

    private static ClickFunctionTask getResultTask(int i2, boolean z, long j) {
        Function functionM12clone = Function.IDENTIFY_RESULT.m12clone();
        if (z) {
            functionM12clone.setCategory("本地录音识别");
        } else if (i2 == RecordType.TYPE_MUSICHUNTER) {
            functionM12clone.setCategory("听歌识曲");
        } else if (i2 == RecordType.TYPE_HUMMING) {
            functionM12clone.setCategory("哼唱识别");
        }
        return new ClickFunctionTask(functionM12clone).setFo(appId).setSvar2(String.valueOf(j));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void init(Context context, String str, boolean z) {
        LibConfig.init(context, new BiLibImpl(), z);
        appId = str;
    }

    public static void reportCancel(int i2, boolean z, long j) {
        TraceDog.getInstance().trace(getResultTask(i2, z, j).setFs("取消"));
    }

    public static void reportError(int i2, boolean z, long j) {
        TraceDog.getInstance().trace(getResultTask(i2, z, j).setFs("失败"));
    }

    public static void reportFinish(int i2, boolean z, RecognizeResult recognizeResult, long j) {
        ClickFunctionTask resultTask = getResultTask(i2, z, j);
        if (recognizeResult != null && recognizeResult.isSuccess() && recognizeResult.isValid()) {
            resultTask.setFs("成功");
            KGHunterSong kGHunterSong = recognizeResult.getResponse().getSongs().get(0);
            resultTask.setMixsongid(String.valueOf(kGHunterSong.getMixSongId()));
            resultTask.setHash(kGHunterSong.getHashValue());
            if (i2 != RecordType.TYPE_MUSICHUNTER) {
                resultTask.setSvar1("哼唱");
            } else if (recognizeResult.isFromFC()) {
                resultTask.setSvar1("翻唱");
            } else if (recognizeResult.isFromSecondLever()) {
                resultTask.setSvar1("二级库");
            } else {
                resultTask.setSvar1("一级库");
            }
        } else {
            resultTask.setFs("失败");
        }
        TraceDog.getInstance().trace(resultTask);
    }

    public static void reportStart(int i2, boolean z) {
        Function functionM12clone = Function.IDENTIFY_START.m12clone();
        if (z) {
            functionM12clone.setCategory("本地录音识别");
        } else if (i2 == RecordType.TYPE_MUSICHUNTER) {
            functionM12clone.setCategory("听歌识曲");
        } else if (i2 == RecordType.TYPE_HUMMING) {
            functionM12clone.setCategory("哼唱识别");
        }
        TraceDog.getInstance().trace(new ClickFunctionTask(functionM12clone).setFo(appId));
    }
}
