package e.c.a.g.a.s;

import androidx.annotation.MainThread;
import com.kugou.android.watch.lite.base.application.KGApplication;

/* JADX INFO: loaded from: classes2.dex */
public class b1 {
    public static int a;

    static {
        w.a(KGApplication.getContext());
    }

    @MainThread
    public static boolean a() {
        if (a == 0) {
            a = e.c.a.g.a.d.y.b.e() ? 1 : 2;
        }
        return a == 1;
    }
}
