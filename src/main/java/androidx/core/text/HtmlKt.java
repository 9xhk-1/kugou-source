package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        j.f(str, "$this$parseAsHtml");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
        j.b(spannedFromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            imageGetter = null;
        }
        if ((i3 & 4) != 0) {
            tagHandler = null;
        }
        j.f(str, "$this$parseAsHtml");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
        j.b(spannedFromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return spannedFromHtml;
    }

    public static final String toHtml(Spanned spanned, int i2) {
        j.f(spanned, "$this$toHtml");
        String html = HtmlCompat.toHtml(spanned, i2);
        j.b(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        j.f(spanned, "$this$toHtml");
        String html = HtmlCompat.toHtml(spanned, i2);
        j.b(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
