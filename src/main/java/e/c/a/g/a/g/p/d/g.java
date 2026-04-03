package e.c.a.g.a.g.p.d;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    @SerializedName("pop_pic")
    private String a = "";

    @SerializedName("close_btn")
    private String b = "";

    @SerializedName("open_btn")
    private String c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("jump_type")
    private int f1048d = 1;

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.a;
    }

    public final int d() {
        return this.f1048d;
    }

    public final boolean e() {
        if (this.a.length() > 0) {
            if (this.b.length() > 0) {
                if (this.c.length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
