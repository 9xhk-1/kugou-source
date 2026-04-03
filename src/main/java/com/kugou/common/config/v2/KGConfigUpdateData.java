package com.kugou.common.config.v2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class KGConfigUpdateData {

    @SerializedName("cursor_id")
    public int cursorId;

    @SerializedName("need_next_time")
    public boolean needNextTime;

    @SerializedName("profile")
    public String profile;

    public String toString() {
        return "KGConfigUpdateData{needNextTime=" + this.needNextTime + ", cursorId=" + this.cursorId + ", profile='" + this.profile + "'}";
    }
}
