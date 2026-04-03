package androidx.core.text;

import android.text.TextUtils;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class StringKt {
    public static final String htmlEncode(String str) {
        j.f(str, "$this$htmlEncode");
        String strHtmlEncode = TextUtils.htmlEncode(str);
        j.b(strHtmlEncode, "TextUtils.htmlEncode(this)");
        return strHtmlEncode;
    }
}
