package e.c.a.g.a.g.p.d;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends e.c.a.g.a.g.p.d.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SerializedName("pay_data")
    private a f1050f;

    public static final class a {

        @SerializedName("type")
        private int a;

        @SerializedName("data")
        private C0158a b;

        /* JADX INFO: renamed from: e.c.a.g.a.g.p.d.i$a$a, reason: collision with other inner class name */
        public static final class C0158a {

            @SerializedName("checkCode")
            private String a = "";

            @SerializedName("order_no")
            private String b = "";

            @SerializedName("out_trade_no")
            private String c = "";

            public final String a() {
                return this.a;
            }

            public final String b() {
                return this.c;
            }
        }

        public final C0158a a() {
            return this.b;
        }
    }

    public final a d() {
        return this.f1050f;
    }
}
