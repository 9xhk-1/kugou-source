package e.c.a.g.a.g.p.d;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    @SerializedName("original_price")
    private int b;

    @SerializedName("price")
    private int c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SerializedName("discount_info")
    private a f1036f;

    @SerializedName("product_id")
    private String a = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("product_type")
    private String f1034d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("payment_desc")
    private String f1035e = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SerializedName("busi_type")
    private String f1037g = "";

    public static final class a {

        @SerializedName("on")
        private int a;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.a;
    }
}
