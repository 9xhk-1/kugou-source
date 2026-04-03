package e.c.a.g.a.d.v;

import android.content.Context;
import com.kugou.android.watch.lite.base.main.FrameworkContentView;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements FrameworkContentView.b {

    public static final class a {
        public static e a;

        static {
            try {
                a = (e) Class.forName("e.c.a.g.a.d.v.a").newInstance();
            } catch (Exception e2) {
                g0.k(e2);
            }
        }
    }

    public static e b() {
        return a.a;
    }

    public abstract void a(Context context);

    public abstract long c();

    public abstract boolean d();
}
