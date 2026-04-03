package me.jessyan.autosize.utils;

import android.app.Application;
import android.content.Context;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class AutoSizeUtils {
    private AutoSizeUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static int dp2px(Context context, float f2) {
        return (int) (TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            if (objInvoke != null) {
                return (Application) objInvoke;
            }
            throw new NullPointerException("you should init first");
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            throw new NullPointerException("you should init first");
        }
    }

    public static int in2px(Context context, float f2) {
        return (int) (TypedValue.applyDimension(4, f2, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int mm2px(Context context, float f2) {
        return (int) (TypedValue.applyDimension(5, f2, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int pt2px(Context context, float f2) {
        return (int) (TypedValue.applyDimension(3, f2, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int sp2px(Context context, float f2) {
        return (int) (TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics()) + 0.5f);
    }
}
