package e.c.a.g.a.d.o.f;

import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.d.o.c.g;
import e.c.a.g.a.d.o.f.a;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(String str, String str2) {
        try {
            b().call(2, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static a b() {
        return a.AbstractBinderC0065a.a(g.f("@twin:PierceCaller"));
    }

    public static void c(@NonNull Runnable runnable) {
        if (KGApplication.isForeProcess()) {
            runnable.run();
        }
    }

    public static void d(@NonNull Runnable runnable) {
        a(runnable.getClass().getName(), "run");
    }
}
