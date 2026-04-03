package e.c.a.g.a.d.f.d.a;

import android.content.Context;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.d.f.d.b.d;
import e.c.a.g.a.d.f.d.b.e;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b a = new b();
    public static final e b;

    static {
        e.c.a.g.a.d.f.b bVar = e.c.a.g.a.d.f.b.a;
        Context context = KGApplication.getContext();
        j.d(context, "getContext()");
        b = bVar.b(context).d();
    }

    public final void a(long j, String str, String str2) {
        b.h(j, str, str2);
    }

    public final d b(long j, String str, String str2) {
        return b.i(j, str, str2);
    }

    public final void c(long j, String str, String str2, String str3) {
        b.d(new d(0, str, str2, j, 0L, str3, 17, null));
    }
}
