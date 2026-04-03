package com.kugou.common.network.netgate;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.kugou.common.network.networkutils.NetLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AckHostConfigEntity {
    private static final String CACHE_URL_HOSTS_KEY = "url_hosts_2";
    private static final String NET_URL_HOSTS_KEY = "url_hosts";
    private static final String OLD_URL_HOSTS_KEY = "url_hosts";
    private static final String URL_HOSTS_KEY = "host_key";
    private static final String URL_HOSTS_KEY_HEADER = "header-param";
    private static final String URL_HOSTS_KEY_HOST = "url_host";
    private static final String URL_HOSTS_KEY_PROTOCOL = "protol";
    private static final String URL_HOSTS_KEY_VERSION = "version";
    public List<HeaderParam> headerParams;
    public String hostKey;
    public List<UrlHostEntity> urlHosts;
    public int version;

    public AckHostConfigEntity(String str, int i2, List<UrlHostEntity> list, List<HeaderParam> list2) {
        this.hostKey = str;
        this.version = i2;
        this.urlHosts = list;
        this.headerParams = list2;
    }

    private static String headerParamsToString(List<HeaderParam> list) {
        if (list == null) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (HeaderParam headerParam : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", headerParam.key);
                jSONObject.put("value", headerParam.value);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e2) {
            NetLog.uploadException(e2);
            return "";
        }
    }

    private static AckHostConfigEntity parse(String str, boolean z) {
        boolean z2;
        int iOptInt;
        String strOptString;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString2 = jSONObject.optString("host_key");
            int iOptInt2 = jSONObject.optInt("version", -1);
            String strOptString3 = jSONObject.optString(URL_HOSTS_KEY_HEADER);
            ArrayList arrayList = new ArrayList();
            if (z) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("url_hosts");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject != null) {
                            arrayList.add(new UrlHostEntity(jSONObjectOptJSONObject.optString(URL_HOSTS_KEY_HOST), AckProtocolTypeUtil.parse(jSONObjectOptJSONObject.optString(URL_HOSTS_KEY_PROTOCOL))));
                        }
                    }
                }
            } else {
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("url_hosts");
                if (jSONArrayOptJSONArray2 == null) {
                    jSONArrayOptJSONArray2 = jSONObject.optJSONArray(CACHE_URL_HOSTS_KEY);
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                        if (z2) {
                            strOptString = jSONArrayOptJSONArray2.optString(i3);
                            iOptInt = 0;
                        } else {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i3);
                            if (jSONObjectOptJSONObject2 != null) {
                                String strOptString4 = jSONObjectOptJSONObject2.optString(URL_HOSTS_KEY_HOST);
                                iOptInt = jSONObjectOptJSONObject2.optInt(URL_HOSTS_KEY_PROTOCOL, 0);
                                strOptString = strOptString4;
                            }
                        }
                        arrayList.add(new UrlHostEntity(strOptString, iOptInt));
                    }
                }
            }
            if (TextUtils.isEmpty(strOptString2)) {
                return null;
            }
            return new AckHostConfigEntity(strOptString2, iOptInt2, arrayList, parseHeaderParams(strOptString2, strOptString3));
        } catch (JSONException e2) {
            NetLog.uploadException(e2);
            return null;
        }
    }

    public static AckHostConfigEntity parseFromCache(String str) {
        return parse(str, false);
    }

    public static AckHostConfigEntity parseFromNet(String str) {
        return parse(str, true);
    }

    private static List<HeaderParam> parseHeaderParams(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                arrayList.add(new HeaderParam(jSONObject.getString("name"), jSONObject.getString("value")));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("host_key", !TextUtils.isEmpty(this.hostKey) ? this.hostKey : "");
            jSONObject.put("version", this.version);
            jSONObject.put(URL_HOSTS_KEY_HEADER, headerParamsToString(this.headerParams));
            JSONArray jSONArray = new JSONArray();
            if (this.urlHosts != null) {
                for (int i2 = 0; i2 < this.urlHosts.size(); i2++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(URL_HOSTS_KEY_HOST, this.urlHosts.get(i2).urlHost);
                    jSONObject2.put(URL_HOSTS_KEY_PROTOCOL, this.urlHosts.get(i2).protocol);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(CACHE_URL_HOSTS_KEY, jSONArray);
            return jSONObject.toString();
        } catch (JSONException e2) {
            NetLog.uploadException(e2);
            return null;
        }
    }

    public static class HeaderParam implements Parcelable {
        public static final Parcelable.Creator<HeaderParam> CREATOR = new Parcelable.Creator<HeaderParam>() { // from class: com.kugou.common.network.netgate.AckHostConfigEntity.HeaderParam.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HeaderParam createFromParcel(Parcel parcel) {
                return new HeaderParam(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public HeaderParam[] newArray(int i2) {
                return new HeaderParam[i2];
            }
        };
        public final String key;
        public final String value;

        public HeaderParam(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.key);
            parcel.writeString(this.value);
        }

        public HeaderParam(Parcel parcel) {
            this.key = parcel.readString();
            this.value = parcel.readString();
        }
    }

    public static class UrlHostEntity implements Parcelable {
        public static final Parcelable.Creator<UrlHostEntity> CREATOR = new Parcelable.Creator<UrlHostEntity>() { // from class: com.kugou.common.network.netgate.AckHostConfigEntity.UrlHostEntity.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UrlHostEntity createFromParcel(Parcel parcel) {
                return new UrlHostEntity(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public UrlHostEntity[] newArray(int i2) {
                return new UrlHostEntity[i2];
            }
        };
        public final int protocol;
        public final String urlHost;

        public UrlHostEntity(String str, int i2) {
            this.urlHost = str;
            this.protocol = i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "UrlHostEntity{urlHost='" + this.urlHost + "', protocol=" + this.protocol + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.urlHost);
            parcel.writeInt(this.protocol);
        }

        public UrlHostEntity(Parcel parcel) {
            this.urlHost = parcel.readString();
            this.protocol = parcel.readInt();
        }
    }
}
