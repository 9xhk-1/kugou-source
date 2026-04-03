package e.c.a.g.a.s;

import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {
    public static boolean a(Bundle bundle, String str, boolean z) {
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }

    public static String b(Bundle bundle, String str, String str2) {
        return bundle != null ? bundle.getString(str, str2) : str2;
    }
}
