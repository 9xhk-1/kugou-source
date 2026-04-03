package e.c.a.g.a.d.o.e;

import android.content.Context;
import android.net.Uri;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.ipc.core.RemoteConnector;
import com.kugou.android.watch.lite.base.ipc.peripheral.connect.ForeService;
import e.c.a.g.a.s.g0;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e.c.a.g.a.d.o.e.a$a, reason: collision with other inner class name */
    public static class C0064a {
        public static boolean a(int i2) {
            return (i2 & 1) != 0;
        }

        public static boolean b(int i2) {
            return (i2 & 2) != 0;
        }
    }

    public static e.c.a.g.a.d.o.c.a a() {
        return new e.c.a.g.a.d.o.b();
    }

    public static Context b() {
        return f.a();
    }

    public static Class<? extends RemoteConnector.AdhesiveService> c() {
        if (KGApplication.isForeProcess()) {
            return ForeService.class;
        }
        return null;
    }

    public static Uri d() {
        if (KGApplication.isForeProcess()) {
            return Uri.parse("content://com.kugou.android.watch.lite.ipc.ForeProvider");
        }
        return null;
    }

    public static void e(Object obj) {
        g0.c("burone-service", obj + "");
    }

    public static boolean f() {
        return !e.c.a.g.a.f.n.b.a.a();
    }
}
