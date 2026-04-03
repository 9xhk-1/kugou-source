package e.c.a.g.a.d.f.d.a;

import android.content.Context;
import com.kugou.android.watch.lite.base.application.KGApplication;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final a a = new a();
    public static final e.c.a.g.a.d.f.d.b.b b;

    static {
        e.c.a.g.a.d.f.b bVar = e.c.a.g.a.d.f.b.a;
        Context context = KGApplication.getContext();
        j.d(context, "getContext()");
        b = bVar.b(context).c();
    }

    public final void a() {
        b.a();
    }

    public final void b(long j) {
        b.h(j);
    }

    public final void c(long j, String str, String str2, long j2) {
        b.i(j, str, str2, j2);
    }

    public final e.c.a.g.a.d.f.d.b.a d(long j, String str, String str2, long j2) {
        return b.j(j, str, str2, j2);
    }

    public final void e(long j, String str, String str2, long j2, String str3) {
        b.d(new e.c.a.g.a.d.f.d.b.a(0, str, str2, j, j2, str3, 1, null));
    }
}
