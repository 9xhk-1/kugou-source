package e.g.a.b.b.a.g;

import android.content.Context;
import f.j;
import f.k;
import f.s;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new b();
    public static boolean b;

    public final void a(String str, f.z.c.a<s> aVar) {
        Object objA;
        j.e(str, "tag");
        j.e(aVar, "function");
        try {
            j.a aVar2 = f.j.a;
            aVar.invoke();
            objA = s.a;
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar3 = f.j.a;
            objA = k.a(th);
            f.j.a(objA);
        }
        Throwable thB = f.j.b(objA);
        if (thB != null) {
            thB.printStackTrace();
            e.g.b.b.a.b(f.z.d.j.l(str, "_ERR"), f.z.d.j.l("run action has error: ", thB.getMessage()));
        }
    }

    public final void b(Context context) {
        f.z.d.j.e(context, "context");
        b = (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
        e.g.b.b.a.d("Utils", f.z.d.j.l("Utils sIsDebug sync ret: ", Boolean.valueOf(b)));
    }
}
