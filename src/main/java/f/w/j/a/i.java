package f.w.j.a;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static a b;
    public static final i c = new i();
    public static final a a = new a(null, null, null);

    public static final class a {
        public final Method a;
        public final Method b;
        public final Method c;

        public a(Method method, Method method2, Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }
    }

    public final a a(f.w.j.a.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            b = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = a;
            b = aVar3;
            return aVar3;
        }
    }

    public final String b(f.w.j.a.a aVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        f.z.d.j.e(aVar, "continuation");
        a aVarA = b;
        if (aVarA == null) {
            aVarA = a(aVar);
        }
        if (aVarA == a || (method = aVarA.a) == null || (objInvoke = method.invoke(aVar.getClass(), new Object[0])) == null || (method2 = aVarA.b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVarA.c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        return (String) (objInvoke3 instanceof String ? objInvoke3 : null);
    }
}
