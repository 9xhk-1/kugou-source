package e.c.a.g.a.g.f;

import android.text.TextUtils;
import com.kugou.android.watch.lite.bi.YoungBITask;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static void a(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e.c.a.g.a.e.b.b(new YoungBITask(22020001, "exposure").setType(String.valueOf(i2)).setSvar1(str));
    }

    public static void b(int i2, String str, String str2) {
        e.c.a.g.a.e.b.b(new YoungBITask(22020002, "exposure").setType(String.valueOf(i2)).setSvar1(str).setSvar2(str2));
    }

    public static void c(int i2, String str, String str2) {
        e.c.a.g.a.e.b.b(new YoungBITask(22020002, "exposure").setSvar1(str).setSvar2(str2));
    }

    public static void d(String str, String str2) {
        c(1, str, str2);
    }
}
