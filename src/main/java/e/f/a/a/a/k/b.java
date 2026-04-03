package e.f.a.a.a.k;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static boolean a(String str) {
        return Build.MANUFACTURER.equalsIgnoreCase(str);
    }

    public static boolean b() {
        return a("oppo") || a("oneplus") || a("realme");
    }

    public static boolean c() {
        return a("vivo");
    }
}
