package com.kugou.common.network.netgate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AckEntity {
    public int area;
    public List<AckServiceConfigEntity> data;
    public int errorCode;
    public int isp;
    public int status;
    public long time;
    public List<AckHostConfigEntity> urlHostMap;

    public Map<String, Integer> getHostMapVersion() {
        HashMap map = new HashMap();
        List<AckHostConfigEntity> list = this.urlHostMap;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.urlHostMap.size(); i2++) {
                AckHostConfigEntity ackHostConfigEntity = this.urlHostMap.get(i2);
                if (ackHostConfigEntity != null) {
                    map.put(ackHostConfigEntity.hostKey, Integer.valueOf(ackHostConfigEntity.version));
                }
            }
        }
        return map;
    }
}
