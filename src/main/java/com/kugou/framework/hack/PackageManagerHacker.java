package com.kugou.framework.hack;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.kugou.framework.hack.HackHub;
import com.kugou.framework.hack.SystemHacker;
import e.c.a.g.a.s.d;
import e.c.a.g.a.s.g0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class PackageManagerHacker {
    private static final String TAG = "Hack.Package";

    public static class PMClientProxy extends SystemHacker.ProxyHandler {
        @Override // com.kugou.framework.hack.SystemHacker.ProxyHandler
        public Object performInvoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            if (g0.a) {
                g0.b(PackageManagerHacker.TAG, "performInvoke: name=" + name);
            }
            HackHub.Reply<?> replyNotifyGetInstalledPackages = "getInstalledPackages".equals(name) ? HackHub.pkg().notifyGetInstalledPackages() : "getInstalledApplications".equals(name) ? HackHub.pkg().notifyGetInstalledApplications() : null;
            return (replyNotifyGetInstalledPackages == null || !replyNotifyGetInstalledPackages.handled) ? method.invoke(this.origin, objArr) : replyNotifyGetInstalledPackages.result;
        }

        private PMClientProxy(Object obj) {
            super(obj);
        }
    }

    public static void inject(Context context) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            Object objB = d.b(applicationContext);
            Field declaredField = objB.getClass().getDeclaredField("sPackageManager");
            declaredField.setAccessible(true);
            Object objNewProxyInstance = Proxy.newProxyInstance(applicationContext.getClassLoader(), new Class[]{Class.forName("android.content.pm.IPackageManager")}, new PMClientProxy(declaredField.get(objB)));
            declaredField.set(objB, objNewProxyInstance);
            Log.i(TAG, "inject [PackageManager] success.");
            Field declaredField2 = Class.forName("android.app.ApplicationPackageManager").getDeclaredField("mPM");
            declaredField2.setAccessible(true);
            PackageManager packageManager = applicationContext.getPackageManager();
            if (declaredField2.get(packageManager) != objNewProxyInstance) {
                declaredField2.set(packageManager, objNewProxyInstance);
                Log.i(TAG, "modify package PackageManager instance in application's context.");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
