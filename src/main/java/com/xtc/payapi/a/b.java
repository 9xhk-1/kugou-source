package com.xtc.payapi.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import com.xtc.payapi.constants.PayConstant;
import com.xtc.payapi.contact.SendPayMesToXTC;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static final String a = PayConstant.TAG + b.class.getSimpleName();

    public static int a(Context context, String str, String str2) {
        try {
            int i2 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getInt(str2);
            Log.d(a, "get meta info = " + i2);
            return i2;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(a, "get meta info error = " + e2.getMessage());
            return -1;
        }
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static String b(Context context, String str, String str2) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 128).metaData.getString(str2);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void c(Context context, String str, String str2) {
        SendPayMesToXTC.Response response = new SendPayMesToXTC.Response();
        response.errorCode = str;
        response.errorDesc = str2;
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        response.toBundle(bundle);
        intent.setClassName(context.getPackageName(), context.getClass().getName());
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
