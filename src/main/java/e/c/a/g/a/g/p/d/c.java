package e.c.a.g.a.g.p.d;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    @SerializedName("kugouid")
    private long b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName(NotificationCompat.CATEGORY_STATUS)
    private int f1032e;

    @SerializedName("product_id")
    private String a = "";

    @SerializedName("busi_type")
    private String c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("order_no")
    private String f1031d = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SerializedName("add_time")
    private String f1033f = "";

    public final int a() {
        return this.f1032e;
    }

    public String toString() {
        return "OrderStatusEntity(productId='" + this.a + "', kugouid=" + this.b + ", busiType='" + this.c + "', orderNo='" + this.f1031d + "', status=" + this.f1032e + ", addTime='" + this.f1033f + "')";
    }
}
