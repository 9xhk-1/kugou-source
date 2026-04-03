package e.c.a.g.a.f.c;

import com.google.gson.annotations.SerializedName;
import com.kugou.common.apm.sdk.ApmDataKey;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    @SerializedName("id")
    private int a;

    @SerializedName("image")
    private String b;

    @SerializedName("button_image")
    private String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName(ApmDataKey.START_TIME)
    private long f636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("end_time")
    private long f637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SerializedName("show_type")
    private int f638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SerializedName("jump_type")
    private int f639g;

    public final String a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final long c() {
        return this.f637e;
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.f639g;
    }

    public final int f() {
        return this.f638f;
    }

    public final long g() {
        return this.f636d;
    }

    public final boolean h() {
        String str = this.b;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = this.c;
        return !(str2 == null || str2.length() == 0);
    }
}
