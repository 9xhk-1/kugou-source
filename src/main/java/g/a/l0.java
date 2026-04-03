package g.a;

import f.j;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {
    public static final String a(Object obj) {
        f.z.d.j.f(obj, "$this$classSimpleName");
        String simpleName = obj.getClass().getSimpleName();
        f.z.d.j.b(simpleName, "this::class.java.simpleName");
        return simpleName;
    }

    public static final String b(Object obj) {
        f.z.d.j.f(obj, "$this$hexAddress");
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        f.z.d.j.b(hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    public static final String c(f.w.d<?> dVar) {
        Object objA;
        f.z.d.j.f(dVar, "$this$toDebugString");
        if (dVar instanceof n0) {
            return dVar.toString();
        }
        try {
            j.a aVar = f.j.a;
            objA = dVar + '@' + b(dVar);
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = f.k.a(th);
            f.j.a(objA);
        }
        if (f.j.b(objA) != null) {
            objA = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) objA;
    }
}
