package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class IconKt {
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        j.f(bitmap, "$this$toAdaptiveIcon");
        Icon iconCreateWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
        j.b(iconCreateWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap bitmap) {
        j.f(bitmap, "$this$toIcon");
        Icon iconCreateWithBitmap = Icon.createWithBitmap(bitmap);
        j.b(iconCreateWithBitmap, "Icon.createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri uri) {
        j.f(uri, "$this$toIcon");
        Icon iconCreateWithContentUri = Icon.createWithContentUri(uri);
        j.b(iconCreateWithContentUri, "Icon.createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] bArr) {
        j.f(bArr, "$this$toIcon");
        Icon iconCreateWithData = Icon.createWithData(bArr, 0, bArr.length);
        j.b(iconCreateWithData, "Icon.createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
