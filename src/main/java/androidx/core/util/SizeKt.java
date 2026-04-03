package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import androidx.annotation.RequiresApi;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class SizeKt {
    @RequiresApi(21)
    public static final int component1(Size size) {
        j.f(size, "$this$component1");
        return size.getWidth();
    }

    @RequiresApi(21)
    public static final int component2(Size size) {
        j.f(size, "$this$component2");
        return size.getHeight();
    }

    @RequiresApi(21)
    public static final float component1(SizeF sizeF) {
        j.f(sizeF, "$this$component1");
        return sizeF.getWidth();
    }

    @RequiresApi(21)
    public static final float component2(SizeF sizeF) {
        j.f(sizeF, "$this$component2");
        return sizeF.getHeight();
    }
}
