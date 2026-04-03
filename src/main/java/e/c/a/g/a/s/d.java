package e.c.a.g.a.s;

import android.app.Application;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "1.0";
        }
    }

    public static Object b(Context context) {
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
    public static java.lang.String c(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.s.d.c(android.content.Context):java.lang.String");
    }

    public static long d(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static long e() {
        long blockCount = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            blockCount = 0 + (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
        } catch (Exception unused) {
        }
        try {
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return blockCount + (((long) statFs2.getBlockCount()) * ((long) statFs2.getBlockSize()));
        } catch (Exception unused2) {
            return blockCount;
        }
    }

    public static boolean f(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }
}
