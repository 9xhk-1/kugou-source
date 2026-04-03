package e.c.a.g.a.d.z;

import android.app.Application;
import com.kugou.android.watch.lite.base.application.KGApplication;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public Application a;
    public b b = new b();

    /* JADX INFO: renamed from: e.c.a.g.a.d.z.a$a, reason: collision with other inner class name */
    public static class C0099a {
        public static final a a = new a();
    }

    public static b a() {
        return b().b;
    }

    public static a b() {
        return C0099a.a;
    }

    public void c() {
        this.a = KGApplication.getApplication();
        if (KGApplication.isForeProcess()) {
            this.b.c(this.a);
        }
    }
}
