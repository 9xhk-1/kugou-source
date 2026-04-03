package androidx.core.graphics.drawable;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class ColorDrawableKt {
    public static final ColorDrawable toDrawable(@ColorInt int i2) {
        return new ColorDrawable(i2);
    }

    @RequiresApi(26)
    public static final ColorDrawable toDrawable(Color color) {
        j.f(color, "$this$toDrawable");
        return new ColorDrawable(color.toArgb());
    }
}
