package com.kugou.framework.widget;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionUtils2 {
    public static <E> E callWithDefault(Object obj, String str, E e2) {
        try {
            return (E) obj.getClass().getMethod(str, null).invoke(obj, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return e2;
        }
    }

    public static Object tryInvoke(Object obj, String str, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            clsArr[i2] = objArr[i2].getClass();
        }
        return tryInvoke(obj, str, clsArr, objArr);
    }

    public static Object tryInvoke(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
