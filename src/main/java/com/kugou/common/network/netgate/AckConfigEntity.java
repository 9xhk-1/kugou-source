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
public class AckConfigEntity {
    public List<AckDomainItem> domains;
    public int duration;
    public List<AckListItem> list;
    public int serviceId;
    public int version;

    public static class AckAddressItem {
        public String host;
        public int httpPort;
        public int udpPort;
    }

    public static class AckDomainItem {
        public String aliasHost;
        public String oriHost;

        public AckDomainItem(String str, String str2) {
            this.oriHost = str;
            this.aliasHost = str2;
        }
    }

    public static class AckListItem {
        public List<AckAddressItem> address;
        public List<List<AckAddressItem>> backupAddress;
        public String domain;
        public String filterid;
    }

    public AckConfigEntity(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("serverid", -1);
            this.serviceId = iOptInt;
            if (iOptInt == -1) {
                this.serviceId = Integer.valueOf(jSONObject.optString("serverid", BaseResponse.Code.ERROR_NETWORK)).intValue();
            }
            int iOptInt2 = jSONObject.optInt(ClientCookie.VERSION_ATTR, -1);
            this.version = iOptInt2;
            if (iOptInt2 == -1) {
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
            int iOptInt3 = jSONObject.optInt("duration", 0);
            this.duration = iOptInt3;
            if (iOptInt3 == 0) {
                try {
                    this.duration = Integer.valueOf(jSONObject.optString("duration", "0")).intValue();
                } catch (NumberFormatException unused) {
                }
            }
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
}
