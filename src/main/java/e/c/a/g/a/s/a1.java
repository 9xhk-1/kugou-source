package e.c.a.g.a.s;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a1 {
    public static Field a(Class<?> cls, String str) {
        while (cls != Object.class) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Field b(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        return a(obj.getClass(), str);
    }

    public static Object c(Object obj, String str) {
        Field fieldB = b(obj, str);
        if (fieldB == null) {
            return null;
        }
        try {
            fieldB.setAccessible(true);
            return fieldB.get(obj);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Class d(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Object e(Class<?> cls, String str, Object obj) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
