package com.kugou.common.apm.sdk;

import android.text.TextUtils;
import com.kugou.datacollect.apm.ApmData;
import f.z.d.j;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class YoungApmData extends ApmData {
    private long allLoadTime;
    private Map<String, String> extParams;
    private long netDelay;
    private String para;
    private String param3rd;
    private long startTime;
    private String state1;
    private String state2;
    private long uiLoadTime;

    public YoungApmData(int i2) {
        super(i2);
        this.state1 = "";
        this.state2 = "";
        this.param3rd = "";
        this.para = "";
    }

    public final void add(String str, String str2) {
        j.e(str, "key");
        if (str2 == null || str2.length() == 0) {
            return;
        }
        if (this.extParams == null) {
            this.extParams = new LinkedHashMap();
        }
        Map<String, String> map = this.extParams;
        j.c(map);
        map.put(str, str2);
    }

    public final boolean check() {
        return this.startTime > 0;
    }

    public final long getAllLoadTime() {
        return this.allLoadTime;
    }

    public final long getNetDelay() {
        return this.netDelay;
    }

    public final String getPara() {
        return this.para;
    }

    public final String getParam3rd() {
        return this.param3rd;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getState1() {
        return this.state1;
    }

    public final String getState2() {
        return this.state2;
    }

    public final long getUiLoadTime() {
        return this.uiLoadTime;
    }

    public final void setAllLoadTime(long j) {
        this.allLoadTime = j;
    }

    public final void setNetDelay(long j) {
        this.netDelay = j;
    }

    public final void setPara(String str) {
        this.para = str;
    }

    public final void setParam3rd(String str) {
        this.param3rd = str;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final void setState1(String str) {
        this.state1 = str;
    }

    public final void setState2(String str) {
        this.state2 = str;
    }

    public final void setUiLoadTime(long j) {
        this.uiLoadTime = j;
    }

    @Override // com.kugou.datacollect.apm.ApmData
    public Map<String, String> toMap() {
        Map<String, String> map = super.toMap();
        map.remove("dataTime");
        j.d(map, "result");
        map.put("datetime", String.valueOf(this.allLoadTime));
        map.put("loadtime", String.valueOf(this.uiLoadTime));
        map.put("delay", String.valueOf(this.netDelay));
        String str = this.state1;
        if (str == null) {
            str = "";
        }
        map.put(ApmDataKey.STATE_1, str);
        String str2 = this.state2;
        if (str2 == null) {
            str2 = "";
        }
        map.put(ApmDataKey.STATE_2, str2);
        String str3 = this.param3rd;
        if (str3 == null) {
            str3 = "";
        }
        map.put("3rd", str3);
        String str4 = this.para;
        map.put(ApmDataKey.PARA, str4 != null ? str4 : "");
        Map<String, String> map2 = this.extParams;
        if (!(map2 == null || map2.isEmpty())) {
            Map<String, String> map3 = this.extParams;
            j.c(map3);
            map.putAll(map3);
        }
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.isEmpty(next.getValue()) || j.a("null", next.getValue())) {
                it.remove();
            }
        }
        return map;
    }
}
