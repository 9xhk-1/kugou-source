package e.a.a.a;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static a a;

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public static a b(Context context, b bVar) {
        b.a(context, bVar);
        return a();
    }

    public void c() {
        Log.i("BlockCanary-no-op", "start");
    }
}
