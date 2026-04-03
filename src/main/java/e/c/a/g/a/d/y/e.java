package e.c.a.g.a.d.y;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.c.a.g.a.s.g0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    @NonNull
    public final Constructor<Animator> a;

    @NonNull
    public final Method b;

    public e(@NonNull Class<?> cls, @NonNull Method method, @NonNull Method method2, @NonNull Method method3, @NonNull Method method4, @NonNull Constructor<Animator> constructor, @NonNull Constructor<Animator> constructor2, @NonNull Constructor<Animator> constructor3, @NonNull Method method5, @NonNull Method method6, int i2, int i3) {
        this.a = constructor2;
        this.b = method6;
    }

    @NonNull
    public static <T> Class<T> a(@NonNull Class<?> cls, @NonNull Class<T> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return cls;
        }
        throw new ClassCastException(String.format("Cannot cast class %s to %s.", cls, cls2));
    }

    @Nullable
    public static e b(boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (!z && !p(i2)) {
            return null;
        }
        try {
            ClassLoader classLoader = e.class.getClassLoader();
            Class<?> clsS = s(i2, classLoader);
            Class<?> clsQ = q(classLoader);
            Class<Animator> clsV = v(classLoader);
            Class<Animator> clsU = u(classLoader);
            return new e(clsS, f(clsS, clsQ), g(clsS, clsQ), d(clsQ), e(clsQ), h(clsQ, clsV), n(clsV, clsU), j(clsQ, clsV), l(clsV, clsU, clsS), m(clsV, clsU), k(clsV, clsU), i(clsV, clsU));
        } catch (Exception e2) {
            w("Error while getting render thread methods.", e2);
            return null;
        }
    }

    @NonNull
    public static Method d(@NonNull Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod("createFloat", Float.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @NonNull
    public static Method e(@NonNull Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod("createPaint", Paint.class);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @NonNull
    public static Method f(@NonNull Class<?> cls, @NonNull Class<?> cls2) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod("drawCircle", cls2, cls2, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @NonNull
    public static Method g(@NonNull Class<?> cls, @NonNull Class<?> cls2) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod("drawRoundRect", cls2, cls2, cls2, cls2, cls2, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @NonNull
    public static Constructor<Animator> h(@NonNull Class<?> cls, @NonNull Class<Animator> cls2) throws NoSuchMethodException {
        Constructor<Animator> constructor = cls2.getConstructor(cls, Float.TYPE);
        constructor.setAccessible(true);
        return constructor;
    }

    public static int i(@NonNull Class<Animator> cls, Class<Animator> cls2) throws IllegalAccessException, NoSuchFieldException {
        return Build.VERSION.SDK_INT >= 30 ? o(cls2, "PAINT_ALPHA") : o(cls, "PAINT_ALPHA");
    }

    @NonNull
    public static Constructor<Animator> j(@NonNull Class<?> cls, @NonNull Class<Animator> cls2) throws NoSuchMethodException {
        Constructor<Animator> constructor = cls2.getConstructor(cls, Integer.TYPE, Float.TYPE);
        constructor.setAccessible(true);
        return constructor;
    }

    public static int k(@NonNull Class<Animator> cls, Class<Animator> cls2) throws IllegalAccessException, NoSuchFieldException {
        return Build.VERSION.SDK_INT >= 30 ? o(cls2, "PAINT_STROKE_WIDTH") : o(cls, "PAINT_STROKE_WIDTH");
    }

    @NonNull
    public static Method l(@NonNull Class<Animator> cls, Class<Animator> cls2, Class<?> cls3) throws NoSuchMethodException {
        int i2 = Build.VERSION.SDK_INT;
        Method declaredMethod = i2 >= 30 ? cls2.getDeclaredMethod("setTarget", RecordingCanvas.class) : i2 >= 29 ? cls.getDeclaredMethod("setTarget", cls3) : cls.getDeclaredMethod("setTarget", Canvas.class);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @NonNull
    public static Method m(@NonNull Class<Animator> cls, Class<Animator> cls2) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod("setTarget", View.class);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    @NonNull
    public static Constructor<Animator> n(@NonNull Class<Animator> cls, @NonNull Class<Animator> cls2) throws NoSuchMethodException {
        Constructor<Animator> constructor = cls.getConstructor(Integer.TYPE, Float.TYPE);
        constructor.setAccessible(true);
        return constructor;
    }

    public static int o(@NonNull Class<Animator> cls, @NonNull String str) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.getInt(null);
    }

    public static boolean p(int i2) {
        return i2 >= 21;
    }

    @NonNull
    public static Class<?> q(@NonNull ClassLoader classLoader) throws ClassNotFoundException {
        return classLoader.loadClass("android.graphics.CanvasProperty");
    }

    @NonNull
    public static Class<?> r(@NonNull ClassLoader classLoader) throws ClassNotFoundException {
        return classLoader.loadClass("android.view.DisplayListCanvas");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        throw r1;
     */
    /* JADX WARN: Failed to analyze thrown exceptions
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.validateException(MethodThrowsVisitor.java:228)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.isThrowsRequired(MethodThrowsVisitor.java:216)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visitThrows(MethodThrowsVisitor.java:204)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:155)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:68)
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Class, java.lang.Class<?>, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Class, java.lang.Class<?>, java.lang.Throwable] */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Class<?> s(int r1, @androidx.annotation.NonNull java.lang.ClassLoader r2) throws java.lang.ClassNotFoundException {
        /*
            r0 = 22
            if (r1 < r0) goto Lf
            java.lang.Class r1 = r(r2)     // Catch: java.lang.ClassNotFoundException -> L9
            return r1
        L9:
            r1 = move-exception
            java.lang.Class r1 = t(r2)     // Catch: java.lang.ClassNotFoundException -> L1a
            return r1
        Lf:
            java.lang.Class r1 = t(r2)     // Catch: java.lang.ClassNotFoundException -> L14
            return r1
        L14:
            r1 = move-exception
            java.lang.Class r1 = r(r2)     // Catch: java.lang.ClassNotFoundException -> L1a
            return r1
        L1a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.d.y.e.s(int, java.lang.ClassLoader):java.lang.Class");
    }

    @NonNull
    public static Class<?> t(@NonNull ClassLoader classLoader) throws ClassNotFoundException {
        return classLoader.loadClass("android.view.GLES20Canvas");
    }

    @NonNull
    public static Class<Animator> u(@NonNull ClassLoader classLoader) throws ClassNotFoundException {
        try {
            Class clsLoadClass = classLoader.loadClass("android.graphics.animation.RenderNodeAnimator");
            a(clsLoadClass, Animator.class);
            return clsLoadClass;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @NonNull
    public static Class<Animator> v(@NonNull ClassLoader classLoader) throws ClassNotFoundException {
        Class clsLoadClass = classLoader.loadClass("android.view.RenderNodeAnimator");
        a(clsLoadClass, Animator.class);
        return clsLoadClass;
    }

    public static void w(@NonNull String str, @NonNull Exception exc) {
        if (g0.a) {
            Log.w(e.class.getSimpleName(), str, exc);
        }
    }

    @NonNull
    public Animator c(@NonNull Object obj, float f2) {
        try {
            return this.a.newInstance(obj, Float.valueOf(f2));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    public void x(@NonNull Animator animator, @NonNull View view) {
        try {
            this.b.invoke(animator, view);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }
}
