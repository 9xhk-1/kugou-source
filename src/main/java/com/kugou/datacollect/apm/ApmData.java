package com.kugou.datacollect.apm;

import com.kugou.common.apm.sdk.ApmDataKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ApmData {
    public long dataTime = System.currentTimeMillis();
    public String fs;
    public String position;
    public int state;
    public String te;
    public int type;

    public ApmData(int i2) {
        this.type = i2;
    }

    public void setFs(String str) {
        this.fs = str;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setTe(String str) {
        this.te = str;
    }

    public Map<String, String> toMap() {
        HashMap map = new HashMap();
        map.put("type", this.type + "");
        map.put(ApmDataKey.STATE, this.state + "");
        map.put(ApmDataKey.TE, this.te);
        map.put(ApmDataKey.POSITION, this.position);
        map.put(ApmDataKey.FS, this.fs);
        map.put("dataTime", this.dataTime + "");
        return map;
    }
}
