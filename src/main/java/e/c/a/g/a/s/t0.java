package e.c.a.g.a.s;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class t0 {
    public Object a;
    public PackageManager b;

    public t0(Context context) {
        try {
            this.a = Class.forName("android.net.NetworkPolicyManager").getDeclaredMethod("from", Context.class).invoke(null, context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.b = context.getPackageManager();
    }

    public final int a(String str) {
        try {
            return this.b.getApplicationInfo(str, 128).uid;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            Log.e("XTCNetworkPolicy", "error get uid for package name:" + str);
            return -1;
        }
    }

    public boolean b(String str) {
        return c(str, 4);
    }

    public final boolean c(String str, int i2) {
        Method declaredMethod;
        int iA = a(str);
        if (iA <= 1000) {
            Log.e("XTCNetworkPolicy", "invalid uid:" + iA);
            return false;
        }
        try {
            declaredMethod = this.a.getClass().getDeclaredMethod("getUidPolicy", Integer.TYPE);
            declaredMethod.setAccessible(true);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            e2.printStackTrace();
        }
        return (((Integer) declaredMethod.invoke(this.a, Integer.valueOf(iA))).intValue() & i2) != 0;
    }
}
