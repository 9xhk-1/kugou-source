package e.f.a.a.a.h;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.FileReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static PackageInfo c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(d(context), 0);
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String e(Context context, int i2) {
        FileReader fileReader;
        Throwable th;
        if (Build.VERSION.SDK_INT >= 28 && i2 == Process.myPid()) {
            return Application.getProcessName();
        }
        try {
            fileReader = new FileReader("/proc/" + i2 + "/cmdline");
        } catch (Throwable th2) {
            fileReader = null;
            th = th2;
        }
        try {
            char[] cArr = new char[512];
            fileReader.read(cArr);
            int i3 = 0;
            while (i3 < 512 && cArr[i3] != 0) {
                i3++;
            }
            String strSubstring = new String(cArr).substring(0, i3);
            if (TextUtils.isEmpty(strSubstring)) {
                strSubstring = b();
                if (TextUtils.isEmpty(strSubstring)) {
                    strSubstring = a();
                }
            }
            try {
                fileReader.close();
            } catch (Throwable unused) {
            }
            return strSubstring;
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                String strB = b();
                if (TextUtils.isEmpty(strB)) {
                    strB = a();
                }
                if (!TextUtils.isEmpty(strB)) {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return strB;
                }
                String strValueOf = String.valueOf(i2);
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                return strValueOf;
            } catch (Throwable th4) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th4;
            }
        }
    }

    public static boolean f(Context context, String str) {
        if (context != null && str != null && str.trim().length() > 0) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str2 : strArr) {
                        if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }
}
