package e.c.c;

import android.content.Context;
import com.kugou.common.player.kugouplayer.JniGlobal;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static String a = "";
    public static boolean b = false;

    public static void a(Context context, String str, int i2) {
        if (b) {
            return;
        }
        b = true;
        e.c.c.o.f.c(context);
        e.c.c.m.g.d(context);
        a.e().g(i2 + "");
        a.e().f(str);
        JniGlobal.setEventListen(e.c.c.m.g.d(context));
        a.e().j();
        try {
            g.b().c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        a = i2 + "";
    }

    public static void b(String str) {
        e.c.c.l.e.a.b = str;
    }

    public static void c(String str) {
        e.c.c.l.e.a.c = str;
    }

    public static void d(int i2) {
        b.a = i2;
    }

    public static void e(boolean z) {
        a.e().h(z);
    }

    public static void f(String str) {
        a.e().i(str);
    }
}
