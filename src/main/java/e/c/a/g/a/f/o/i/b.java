package e.c.a.g.a.f.o.i;

import com.google.gson.annotations.SerializedName;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class b {

    @SerializedName("model")
    public String a;

    @SerializedName("margin_h")
    private float b;

    @SerializedName("margin_v")
    private float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("isRound")
    private boolean f738d;

    public b() {
    }

    public final float a() {
        double dZ = l1.z(KGApplication.getContext()) / 2.0f;
        double dSqrt = Math.sqrt(2.0d) / 2.0d;
        Double.isNaN(dZ);
        Double.isNaN(dZ);
        return (float) (dZ - (dSqrt * dZ));
    }

    public float b() {
        if (this.f738d) {
            return a();
        }
        if (this.b <= 0.0f) {
            return -1.0f;
        }
        return l1.c(r0);
    }

    public float c() {
        if (this.f738d) {
            return a();
        }
        if (this.c <= 0.0f) {
            return -1.0f;
        }
        return l1.c(r0);
    }

    public boolean d() {
        return this.f738d;
    }

    public String toString() {
        return "DeviceCorner{model='" + this.a + "', marginH=" + this.b + ", marginV=" + this.c + '}';
    }

    public b(String str, float f2, float f3) {
        this.a = str;
        this.b = f2;
        this.c = f3;
    }

    public b(String str, boolean z) {
        this.a = str;
        this.f738d = z;
    }
}
