package com.xtc.shareapi.share.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.utils.system.SystemPropertyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class ShareUtil {
    private static final String READ_CONTACT_PERMISSION = "android.permission.READ_CONTACTS";
    private static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    private static final String TAG = OpenApiConstant.TAG + ShareUtil.class.getSimpleName();
    private static final String WEICHAT_PACKAGE_WEICHAT = "com.xtc.weichat";

    public static synchronized String getAppName(Context context) {
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e(TAG, "get app name error = " + e2);
            return null;
        }
        return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
    }

    public static synchronized Bitmap getBitmap(Context context) {
        PackageManager packageManager;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "get app icon error = " + e2);
            return null;
        }
        return BitmapUtil.scaleIcon(context, ((BitmapDrawable) packageManager.getApplicationIcon(packageManager.getApplicationInfo(context.getPackageName(), 0))).getBitmap());
    }

    public static int getHostSdkVersion(Context context, String str) {
        try {
            int i2 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getInt(OpenApiConstant.App.META_DATA_VERSION);
            Log.d(TAG, "get host sdk version = " + i2);
            return i2;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "get host sdk version error = " + e2.getMessage());
            return -1;
        }
    }

    public static String getTargetClassName(Context context, String str, String str2) {
        try {
            String string = context.getPackageManager().getApplicationInfo(str, 128).metaData.getString(str2);
            Log.d(TAG, "get meta info " + string);
            return string;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isAllowContactPermission(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.checkPermission("android.permission.READ_EXTERNAL_STORAGE", "com.xtc.weichat") == 0 && packageManager.checkPermission("android.permission.READ_CONTACTS", "com.xtc.weichat") == 0;
    }

    public static boolean isAppInWhiteList(Context context, String str) {
        if (!isSystemSupportCta()) {
            Log.d(TAG, "Not Support Cta");
            return true;
        }
        try {
            Bundle bundleCall = context.getContentResolver().call(Uri.parse(OpenApiConstant.SelfStart.LAUNCHER_SELF_START_URI), OpenApiConstant.SelfStart.METHOD_GET_PACKAGE_SELF_START, str, (Bundle) null);
            if (bundleCall != null) {
                return bundleCall.getBoolean(OpenApiConstant.SelfStart.EXTRA_SELF_START, true);
            }
            return true;
        } catch (Exception e2) {
            Log.e(TAG, "读取应用自启权限失败, error = " + e2);
            return true;
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static boolean isInstallScene(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "not install " + str, e2);
            return false;
        }
    }

    public static boolean isSystemSupportCta() {
        return SystemPropertyUtil.getInt("ro.xtc.ctaversion", 0) == 1;
    }

    public static void startTargetActivity(Context context, int i2, String str) {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName(context.getPackageName(), context.getClass().getName());
        intent.putExtra(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_CODE, i2);
        intent.putExtra(OpenApiConstant.ResponseConstant.BUNDLE_ERROR_DESC, str);
        intent.setComponent(componentName);
        context.startActivity(intent);
    }
}
