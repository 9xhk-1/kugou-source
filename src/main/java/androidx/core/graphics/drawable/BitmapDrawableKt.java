package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class BitmapDrawableKt {
    public static final BitmapDrawable toDrawable(Bitmap bitmap, Resources resources) {
        j.f(bitmap, "$this$toDrawable");
        j.f(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}
