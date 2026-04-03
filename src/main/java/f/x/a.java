package f.x;

import f.z.d.j;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: f.x.a$a, reason: collision with other inner class name */
    public static final class C0270a {
        public static final Method a;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                f.z.d.j.d(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            Le:
                java.lang.String r5 = "it"
                if (r4 >= r2) goto L41
                r6 = r1[r4]
                f.z.d.j.d(r6, r5)
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = f.z.d.j.a(r7, r8)
                if (r7 == 0) goto L3a
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                f.z.d.j.d(r7, r8)
                java.lang.Object r7 = f.u.i.q(r7)
                java.lang.Class r7 = (java.lang.Class) r7
                boolean r7 = f.z.d.j.a(r7, r0)
                if (r7 == 0) goto L3a
                r7 = 1
                goto L3b
            L3a:
                r7 = 0
            L3b:
                if (r7 == 0) goto L3e
                goto L42
            L3e:
                int r4 = r4 + 1
                goto Le
            L41:
                r6 = 0
            L42:
                f.x.a.C0270a.a = r6
                int r0 = r1.length
            L45:
                if (r3 >= r0) goto L5c
                r2 = r1[r3]
                f.z.d.j.d(r2, r5)
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = f.z.d.j.a(r2, r4)
                if (r2 == 0) goto L59
                goto L5c
            L59:
                int r3 = r3 + 1
                goto L45
            L5c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f.x.a.C0270a.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        j.e(th, "cause");
        j.e(th2, "exception");
        Method method = C0270a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
