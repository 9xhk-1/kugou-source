package com.kugou.common.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import com.kugou.common.permission.overlay.setting.AlertWindowSettingPage;
import com.kugou.common.permission.overlay.setting.OverlaySettingPage;
import com.kugou.common.permission.particular.setting.ParticularSettingPage;
import com.kugou.common.permission.runtime.setting.RuntimeSettingPage;
import com.kugou.common.permission.source.ContextSource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionActivity extends Activity {
    private static final String KEY_INPUT_OPERATION = "KEY_INPUT_OPERATION";
    private static final String KEY_INPUT_PERMISSIONS = "KEY_INPUT_PERMISSIONS";
    private static final int VALUE_INPUT_ALERT_WINDOW = 5;
    private static final int VALUE_INPUT_INSTALL = 3;
    private static final int VALUE_INPUT_OVERLAY = 4;
    private static final int VALUE_INPUT_PERMISSION = 1;
    private static final int VALUE_INPUT_PERMISSION_SETTING = 2;
    private static final int VALUE_INPUT_WRITE_SETTINGS = 6;
    private static RequestListener sRequestListener;

    public interface RequestListener {
        void onRequestCallback();
    }

    private boolean fixOrientation() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean isTranslucentOrFloating() {
        Exception e2;
        boolean zBooleanValue;
        try {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            zBooleanValue = ((Boolean) method.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e3) {
                e2 = e3;
                e2.printStackTrace();
            }
        } catch (Exception e4) {
            e2 = e4;
            zBooleanValue = false;
        }
        return zBooleanValue;
    }

    public static void permissionSetting(Context context, RequestListener requestListener) {
        sRequestListener = requestListener;
        Intent intent = new Intent(context, PermissionGlobalSetting.getProcessPermissionClass());
        intent.putExtra(KEY_INPUT_OPERATION, 2);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void requestAlertWindow(Context context, RequestListener requestListener) {
        sRequestListener = requestListener;
        Intent intent = new Intent(context, PermissionGlobalSetting.getProcessPermissionClass());
        intent.putExtra(KEY_INPUT_OPERATION, 5);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void requestInstall(Context context, RequestListener requestListener) {
        sRequestListener = requestListener;
        Intent intent = new Intent(context, PermissionGlobalSetting.getProcessPermissionClass());
        intent.putExtra(KEY_INPUT_OPERATION, 3);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void requestOverlay(Context context, RequestListener requestListener) {
        sRequestListener = requestListener;
        Intent intent = new Intent(context, PermissionGlobalSetting.getProcessPermissionClass());
        intent.putExtra(KEY_INPUT_OPERATION, 4);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void requestParticular(Context context, RequestListener requestListener) {
        sRequestListener = requestListener;
        Intent intent = new Intent(context, PermissionGlobalSetting.getProcessPermissionClass());
        intent.putExtra(KEY_INPUT_OPERATION, 6);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void requestPermission(Context context, String[] strArr, RequestListener requestListener) {
        sRequestListener = requestListener;
        Intent intent = new Intent(context, PermissionGlobalSetting.getProcessPermissionClass());
        intent.putExtra(KEY_INPUT_OPERATION, 1);
        intent.putExtra(KEY_INPUT_PERMISSIONS, strArr);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void finish() {
        sRequestListener = null;
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        RequestListener requestListener = sRequestListener;
        if (requestListener != null) {
            requestListener.onRequestCallback();
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && isTranslucentOrFloating()) {
            fixOrientation();
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        switch (intent.getIntExtra(KEY_INPUT_OPERATION, 0)) {
            case 1:
                String[] stringArrayExtra = intent.getStringArrayExtra(KEY_INPUT_PERMISSIONS);
                if (stringArrayExtra == null || sRequestListener == null) {
                    finish();
                    return;
                } else {
                    requestPermissions(stringArrayExtra, 1);
                    return;
                }
            case 2:
                if (sRequestListener != null) {
                    new RuntimeSettingPage(new ContextSource(this)).start(2);
                    return;
                } else {
                    finish();
                    return;
                }
            case 3:
                if (sRequestListener == null) {
                    finish();
                    return;
                }
                Intent intent2 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                intent2.setData(Uri.fromParts("package", getPackageName(), null));
                startActivityForResult(intent2, 3);
                return;
            case 4:
                if (sRequestListener != null) {
                    new OverlaySettingPage(new ContextSource(this)).start(4);
                    return;
                } else {
                    finish();
                    return;
                }
            case 5:
                if (sRequestListener != null) {
                    new AlertWindowSettingPage(new ContextSource(this)).start(5);
                    return;
                } else {
                    finish();
                    return;
                }
            case 6:
                if (sRequestListener != null) {
                    new ParticularSettingPage(new ContextSource(this)).start(6);
                    return;
                } else {
                    finish();
                    return;
                }
            default:
                throw new AssertionError("This should not be the case.");
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        RequestListener requestListener = sRequestListener;
        if (requestListener != null) {
            requestListener.onRequestCallback();
        }
        finish();
    }
}
