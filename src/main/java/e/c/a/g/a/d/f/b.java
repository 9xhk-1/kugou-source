package e.c.a.g.a.d.f;

import android.content.Context;
import com.kugou.android.watch.lite.base.db.core.CoreDatabase;
import com.kugou.android.watch.lite.base.db.secondary.SecondaryDatabase;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();

    public final CoreDatabase a(Context context) {
        j.e(context, "context");
        return CoreDatabase.a.b(context);
    }

    public final SecondaryDatabase b(Context context) {
        j.e(context, "context");
        return SecondaryDatabase.a.b(context);
    }

    public final void c(Context context) {
        j.e(context, "context");
        CoreDatabase.a.b(context);
        SecondaryDatabase.a.b(context);
    }
}
