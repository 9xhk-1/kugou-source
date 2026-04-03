package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import f.z.d.j;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleKt {
    @RequiresApi(17)
    public static final int getLayoutDirection(Locale locale) {
        j.f(locale, "$this$layoutDirection");
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
