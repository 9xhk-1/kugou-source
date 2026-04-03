package androidx.core.util;

import android.util.Half;
import androidx.annotation.RequiresApi;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s) {
        Half halfValueOf = Half.valueOf(s);
        j.b(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(float f2) {
        Half halfValueOf = Half.valueOf(f2);
        j.b(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        j.f(str, "$this$toHalf");
        Half halfValueOf = Half.valueOf(str);
        j.b(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    @RequiresApi(26)
    public static final Half toHalf(double d2) {
        Half halfValueOf = Half.valueOf((float) d2);
        j.b(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }
}
