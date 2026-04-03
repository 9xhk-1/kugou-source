package e.c.c.o;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    public static Object a(Context context) {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            if (objInvoke != null || context == null) {
                return objInvoke;
            }
            Application application = (Application) context.getApplicationContext();
            Field field = application.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(application);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:16|(2:64|17)|(2:62|18)|(4:19|(1:21)(1:78)|70|23)|22|70|23) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e7, code lost:
    
        r9 = r3.processName;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e9, code lost:
    
        android.util.Log.i("burone-pn", "p3 = " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fd, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ff, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0100, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0108 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.c.o.j.b(android.content.Context):java.lang.String");
    }

    public static String c(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).processName;
    }

    public static boolean d(String str) {
        return str.equals(b(f.a));
    }

    public static boolean e() {
        String strC;
        try {
            strC = c(f.a);
        } catch (Exception unused) {
            strC = "";
        }
        if (strC.equals("")) {
            return true;
        }
        return b(f.a).equals(strC);
    }
}
