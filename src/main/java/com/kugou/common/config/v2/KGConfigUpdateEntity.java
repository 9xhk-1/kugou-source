package com.kugou.common.config.v2;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class KGConfigUpdateEntity {

    @SerializedName("data")
    public KGConfigUpdateData data;

    @SerializedName("errcode")
    public int errCode;

    @SerializedName("error")
    public String error;

    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    public int status;

    public String toString() {
        return "KGConfigUpdateEntity{status=" + this.status + ", errcode=" + this.errCode + ", error='" + this.error + "', data=" + this.data + '}';
    }
}
