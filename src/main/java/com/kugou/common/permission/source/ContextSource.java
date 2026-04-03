package com.kugou.common.permission.source;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ContextSource extends Source {
    private Context mContext;

    public ContextSource(Context context) {
        this.mContext = context;
    }

    @Override // com.kugou.common.permission.source.Source
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.kugou.common.permission.source.Source
    public boolean isShowRationalePermission(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            return ((Activity) context).shouldShowRequestPermissionRationale(str);
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            Method method = packageManager.getClass().getMethod("shouldShowRequestPermissionRationale", String.class);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return ((Boolean) method.invoke(packageManager, str)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kugou.common.permission.source.Source
    public void startActivity(Intent intent) {
        if (!(this.mContext instanceof Activity)) {
            intent.setFlags(268435456);
        }
        this.mContext.startActivity(intent);
    }

    @Override // com.kugou.common.permission.source.Source
    public void startActivityForResult(Intent intent, int i2) {
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i2);
        } else {
            intent.setFlags(268435456);
            this.mContext.startActivity(intent);
        }
    }
}
