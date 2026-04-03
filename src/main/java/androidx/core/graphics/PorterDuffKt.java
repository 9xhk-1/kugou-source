package androidx.core.graphics;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class PorterDuffKt {
    public static final PorterDuffColorFilter toColorFilter(PorterDuff.Mode mode, int i2) {
        j.f(mode, "$this$toColorFilter");
        return new PorterDuffColorFilter(i2, mode);
    }

    public static final PorterDuffXfermode toXfermode(PorterDuff.Mode mode) {
        j.f(mode, "$this$toXfermode");
        return new PorterDuffXfermode(mode);
    }
}
