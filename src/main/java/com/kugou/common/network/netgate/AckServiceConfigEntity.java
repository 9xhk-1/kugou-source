package com.kugou.common.network.netgate;

import android.text.TextUtils;
import com.kugou.common.network.networkutils.NetLog;
import com.xtc.payapi.contact.BaseResponse;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AckServiceConfigEntity {
    public int checkPercent;
    public int checkTime;
    public List<AckDomainItem> domains;
    public int duration;
    public List<AckListItem> list;
    public int serviceId;
    public int version;

    public static class AckAddressItem {
        public String host;
        public int httpPort;
        public int udpPort;

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("host", TextUtils.isEmpty(this.host) ? "" : this.host);
                jSONObject.put("udp_port", this.udpPort);
                jSONObject.put("http_port", this.httpPort);
                return jSONObject.toString();
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
                return null;
            }
        }

        public String toString() {
            return this.host + ":" + this.httpPort;
        }
    }

    public static class AckDomainItem {
        public String aliasHost;
        public String oriHost;

        public AckDomainItem(String str, String str2) {
            this.oriHost = str;
            this.aliasHost = str2;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                String str = "";
                jSONObject.put("url", TextUtils.isEmpty(this.oriHost) ? "" : this.oriHost);
                if (!TextUtils.isEmpty(this.aliasHost)) {
                    str = this.aliasHost;
                }
                jSONObject.put("url_alias", str);
                return jSONObject.toString();
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
                return null;
            }
        }

        public String toString() {
            return this.oriHost + "-" + this.aliasHost;
        }
    }

    public static class AckListItem {
        public List<AckAddressItem> address;
        public List<List<AckAddressItem>> backupAddress;
        public String domain;
        public String filterid;

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ClientCookie.DOMAIN_ATTR, TextUtils.isEmpty(this.domain) ? "" : this.domain);
                JSONArray jSONArray = new JSONArray();
                if (this.address != null) {
                    for (int i2 = 0; i2 < this.address.size(); i2++) {
                        jSONArray.put(new JSONObject(this.address.get(i2).toJson()));
                    }
                }
                jSONObject.put("address", jSONArray);
                JSONArray jSONArray2 = new JSONArray();
                if (this.backupAddress != null) {
                    for (int i3 = 0; i3 < this.backupAddress.size(); i3++) {
                        List<AckAddressItem> list = this.backupAddress.get(i3);
                        JSONArray jSONArray3 = new JSONArray();
                        if (list != null) {
                            for (int i4 = 0; i4 < list.size(); i4++) {
                                jSONArray3.put(new JSONObject(list.get(i4).toJson()));
                            }
                        }
                        jSONArray2.put(jSONArray3);
                    }
                }
                jSONObject.put("backup_address", jSONArray2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                NetLog.uploadException(e2);
                return null;
            }
        }
    }

    public AckServiceConfigEntity(String str) {
        int iOptInt;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt2 = jSONObject.optInt("serverid", -1);
            this.serviceId = iOptInt2;
            if (iOptInt2 == -1) {
                int iIntValue = Integer.valueOf(jSONObject.optString("serverid", BaseResponse.Code.ERROR_NETWORK)).intValue();
                this.serviceId = iIntValue;
                if (iIntValue == -1 && (iOptInt = jSONObject.optInt("serviceid", -1)) != -1) {
                    this.serviceId = iOptInt;
                }
            }
            int iOptInt3 = jSONObject.optInt(ClientCookie.VERSION_ATTR, -1);
            this.version = iOptInt3;
            if (iOptInt3 == -1) {
                this.version = Integer.valueOf(jSONObject.optString(ClientCookie.VERSION_ATTR, BaseResponse.Code.ERROR_NETWORK)).intValue();
            }
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            this.list = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    AckListItem ackListItem = parseAckListItem(jSONObject2);
                    if (jSONObject2 != null) {
                        this.list.add(ackListItem);
                    }
                }
            }
            this.domains = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("domains");
            if (jSONArrayOptJSONArray != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i3);
                    if (jSONObject3 != null) {
                        String strOptString = jSONObject3.optString("url", "");
                        String strOptString2 = jSONObject3.optString("url_alias", "");
                        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                            this.domains.add(new AckDomainItem(strOptString, strOptString2));
                        }
                    }
                }
            }
            int iOptInt4 = jSONObject.optInt("duration", 0);
            this.duration = iOptInt4;
            if (iOptInt4 == 0) {
                try {
                    this.duration = Integer.valueOf(jSONObject.optString("duration", "0")).intValue();
                } catch (NumberFormatException unused) {
                }
            }
            this.checkTime = jSONObject.optInt("checktime");
            this.checkPercent = jSONObject.optInt("checkpercent");
        } catch (JSONException e2) {
            NetLog.uploadException(e2);
        }
    }

    private AckAddressItem parseAckAddressItem(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        AckAddressItem ackAddressItem = new AckAddressItem();
        ackAddressItem.host = jSONObject.optString("host", "");
        ackAddressItem.httpPort = jSONObject.optInt("http_port", 0);
        ackAddressItem.udpPort = jSONObject.optInt("udp_port", 0);
        try {
            if (ackAddressItem.httpPort == 0) {
                ackAddressItem.httpPort = Integer.valueOf(jSONObject.optString("http_port", "")).intValue();
            }
            if (ackAddressItem.udpPort == 0) {
                ackAddressItem.udpPort = Integer.valueOf(jSONObject.optString("udp_port", "")).intValue();
            }
        } catch (NumberFormatException unused) {
        }
        return ackAddressItem;
    }

    private AckListItem parseAckListItem(JSONObject jSONObject) {
        AckAddressItem ackAddressItem;
        if (jSONObject == null) {
            return null;
        }
        AckListItem ackListItem = new AckListItem();
        ackListItem.domain = jSONObject.optString(ClientCookie.DOMAIN_ATTR, "");
        ackListItem.address = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("address");
        for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (jSONArrayOptJSONArray != null && (ackAddressItem = parseAckAddressItem(jSONObjectOptJSONObject)) != null) {
                ackListItem.address.add(ackAddressItem);
            }
        }
        ackListItem.backupAddress = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("backup_address");
        for (int i3 = 0; jSONArrayOptJSONArray2 != null && i3 < jSONArrayOptJSONArray2.length(); i3++) {
            JSONArray jSONArrayOptJSONArray3 = jSONArrayOptJSONArray2.optJSONArray(i3);
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; jSONArrayOptJSONArray3 != null && i4 < jSONArrayOptJSONArray3.length(); i4++) {
                AckAddressItem ackAddressItem2 = parseAckAddressItem(jSONArrayOptJSONArray3.optJSONObject(i4));
                if (ackAddressItem2 != null) {
                    arrayList.add(ackAddressItem2);
                }
            }
            if (arrayList.size() > 0) {
                ackListItem.backupAddress.add(arrayList);
            }
        }
        ackListItem.filterid = jSONObject.optString("filterid", "");
        return ackListItem;
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("serverid", this.serviceId);
            jSONObject.put(ClientCookie.VERSION_ATTR, this.version);
            jSONObject.put("duration", this.duration);
            jSONObject.put("checktime", this.checkTime);
            jSONObject.put("checkpercent", this.checkPercent);
            JSONArray jSONArray = new JSONArray();
            if (this.list != null) {
                for (int i2 = 0; i2 < this.list.size(); i2++) {
                    jSONArray.put(new JSONObject(this.list.get(i2).toJson()));
                }
            }
            jSONObject.put("list", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            if (this.domains != null) {
                for (int i3 = 0; i3 < this.domains.size(); i3++) {
                    jSONArray2.put(new JSONObject(this.domains.get(i3).toJson()));
                }
            }
            jSONObject.put("domains", jSONArray2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            NetLog.uploadException(e2);
            return null;
        }
    }
}
