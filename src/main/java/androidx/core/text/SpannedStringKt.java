package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned spanned, int i2, int i3) {
        j.f(spanned, "$this$getSpans");
        j.i(4, ExifInterface.GPS_DIRECTION_TRUE);
        throw null;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned spanned, int i2, int i3, int i4, Object obj) {
        int i5 = i4 & 1;
        if ((i4 & 2) != 0) {
            spanned.length();
        }
        j.f(spanned, "$this$getSpans");
        j.i(4, ExifInterface.GPS_DIRECTION_TRUE);
        throw null;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        j.f(charSequence, "$this$toSpanned");
        SpannedString spannedStringValueOf = SpannedString.valueOf(charSequence);
        j.b(spannedStringValueOf, "SpannedString.valueOf(this)");
        return spannedStringValueOf;
    }
}
