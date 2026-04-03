package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import f.b0.d;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(Spannable spannable) {
        j.f(spannable, "$this$clearSpans");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        j.b(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i2, int i3, Object obj) {
        j.f(spannable, "$this$set");
        j.f(obj, "span");
        spannable.setSpan(obj, i2, i3, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        j.f(charSequence, "$this$toSpannable");
        SpannableString spannableStringValueOf = SpannableString.valueOf(charSequence);
        j.b(spannableStringValueOf, "SpannableString.valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void set(Spannable spannable, d dVar, Object obj) {
        j.f(spannable, "$this$set");
        j.f(dVar, "range");
        j.f(obj, "span");
        spannable.setSpan(obj, dVar.getStart().intValue(), dVar.getEndInclusive().intValue(), 17);
    }
}
