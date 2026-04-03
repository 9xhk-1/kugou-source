package com.kugou.common.permission.overlay.setting;

import android.app.AppOpsManager;
import android.app.Dialog;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.kugou.common.R;
import com.kugou.common.permission.source.ContextSource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import qihoo.sdk.event.SystemEvent;

/* JADX INFO: loaded from: classes2.dex */
public class CheckFloatWindowPermissionUtils {
    public static int OP_FLOAT_WINDOW = 24;

    public static boolean checkHasPermission(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? new ContextSource(context).canDrawOverlays() : checkOpResult(context, OP_FLOAT_WINDOW) == 0 || checkOpResult(context, OP_FLOAT_WINDOW) == 3;
    }

    public static int checkOpResult(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) invokeMethod(appOpsManager, "checkOp", new Class[]{cls, cls, String.class}, new Object[]{Integer.valueOf(i2), Integer.valueOf(Binder.getCallingUid()), context.getPackageName()})).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 2;
    }

    public static Method getDeclaredMethod(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredMethod(str, clsArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method declaredMethod = getDeclaredMethod(obj, str, clsArr);
        if (declaredMethod == null) {
            return null;
        }
        try {
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static boolean tryDisplayDialog(Context context) {
        Dialog dialog = new Dialog(context, R.style.Permission_Theme_Dialog);
        dialog.getWindow().setType(Build.VERSION.SDK_INT >= 26 ? 2038 : SystemEvent.CODE_SYSTEM_EVENT_TEMP_HIGH_EXCEPTION);
        try {
            dialog.show();
            if (!dialog.isShowing()) {
                return true;
            }
            dialog.dismiss();
            return true;
        } catch (Exception unused) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            return false;
        } catch (Throwable th) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            throw th;
        }
    }
}
