package e.c.a.g.a.r.e.i;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 11) {
            return str;
        }
        return str.substring(0, 3) + "*****" + str.substring(8, 11);
    }
}
