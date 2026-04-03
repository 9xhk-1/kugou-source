package com.kugou.framework.bilib.statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class StatisticLog implements Serializable {
    private static final long serialVersionUID = 8323895406710233222L;
    private List<String> lstStatUrl = new ArrayList();

    public static void fromJson(StatisticLog statisticLog, String str) throws JSONException {
        JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("lstStatUrl");
        for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
            statisticLog.addUrl(jSONArrayOptJSONArray.optString(i2));
        }
    }

    public static String toJson(StatisticLog statisticLog) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (statisticLog.getList() != null) {
            Iterator<String> it = statisticLog.getList().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        jSONObject.put("lstStatUrl", jSONArray);
        return jSONObject.toString();
    }

    public void addUrl(String str) {
        if (this.lstStatUrl == null) {
            this.lstStatUrl = new ArrayList();
        }
        this.lstStatUrl.add(str);
    }

    public List<String> getList() {
        return this.lstStatUrl;
    }

    public int getSize() {
        List<String> list = this.lstStatUrl;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
