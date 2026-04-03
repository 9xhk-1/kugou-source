package e.c.c.k.f;

import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a = "rawQuery";
    public static String b = "rawQueryAttach";
    public static String c = "upgrateDB";

    public static String a() {
        return e.c.c.o.f.a().getPackageName() + ".datacollect.provider";
    }

    public static String b(String str) {
        return str + ".datacollect.provider";
    }

    public static Uri c() {
        return Uri.parse("content://" + a() + "/" + a);
    }
}
