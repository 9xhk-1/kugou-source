package com.kugou.framework.hack;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.kugou.framework.hack.sandbox.SandBoxStrategy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SystemHackerManager {
    private static final String TAG = "Hack.Manager";

    public static void challengeGrayApi(String... strArr) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            ((Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class})).invoke(((Method) declaredMethod2.invoke(cls, "getRuntime", null)).invoke(null, new Object[0]), strArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void modifyClassesAccessibility() {
        String[][] strArr = {new String[]{"java.io.FileSystem"}, new String[]{"android.app.SystemServiceRegistry$CachedServiceFetcher", "android.app.ContextImpl$ServiceFetcher"}};
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            for (String str : strArr[i2]) {
                try {
                    arrayList.add(Class.forName(str));
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                publicTheClass((Class) it.next());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void publicTheClass(Class cls) throws Throwable {
        Field declaredField = Class.class.getDeclaredField("accessFlags");
        declaredField.setAccessible(true);
        declaredField.set(cls, Integer.valueOf(1 | ((Integer) declaredField.get(cls)).intValue()));
    }

    public static void startHack(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        challengeGrayApi("L");
        modifyClassesAccessibility();
        PackageManagerHacker.inject(context);
        SandBoxStrategy.apply();
        Log.i(TAG, "hack cost " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + " ms");
    }
}
