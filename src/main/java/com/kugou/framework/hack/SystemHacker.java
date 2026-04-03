package com.kugou.framework.hack;

import android.content.Context;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SystemHacker {
    private static Object sActivityThread;

    public static abstract class ProxyHandler implements InvocationHandler {
        public final Object origin;

        public ProxyHandler(Object obj) {
            this.origin = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return performInvoke(obj, method, objArr);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e2;
            }
        }

        public abstract Object performInvoke(Object obj, Method method, Object[] objArr) throws Throwable;
    }

    public static Field findField(Class<?> cls, String str) throws NoSuchFieldException {
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + cls);
    }

    public static Method findMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + cls);
    }

    public static Object getActivityThread(Context context, Class<?> cls) {
        try {
            Object obj = sActivityThread;
            if (obj != null) {
                return obj;
            }
            if (cls == null) {
                cls = Class.forName("android.app.ActivityThread");
            }
            Method method = cls.getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            if (objInvoke == null && context != null) {
                Field field = context.getClass().getField("mLoadedApk");
                field.setAccessible(true);
                Object obj2 = field.get(context);
                Field declaredField = obj2.getClass().getDeclaredField("mActivityThread");
                declaredField.setAccessible(true);
                objInvoke = declaredField.get(obj2);
            }
            if (objInvoke != null) {
                sActivityThread = objInvoke;
            }
            return objInvoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void inject(Context context) {
        performInject(context.getApplicationContext());
    }

    public abstract void performInject(Context context);
}
