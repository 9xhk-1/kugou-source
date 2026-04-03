package com.xtc.payapi.a;

import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final String a = "pay_sdkIntentUtils";

    public static int a(Bundle bundle, String str) {
        if (bundle == null) {
            return -1;
        }
        try {
            return bundle.getInt(str, -1);
        } catch (Exception e2) {
            Log.e(a, "getIntExtra exception:" + e2.getMessage());
            return -1;
        }
    }

    public static String b(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e2) {
            Log.e(a, "getStringExtra exception:" + e2.getMessage());
            return null;
        }
    }

    public static double c(Bundle bundle, String str) {
        if (bundle == null) {
            return -1.0d;
        }
        try {
            return bundle.getDouble(str, -1.0d);
        } catch (Exception e2) {
            Log.e(a, "getDoubleExtra exception:" + e2.getMessage());
            return -1.0d;
        }
    }

    public static byte[] d(Bundle bundle, String str) {
        if (bundle == null) {
            return new byte[-1];
        }
        try {
            return bundle.getByteArray(str);
        } catch (Exception e2) {
            Log.e(a, "getByteExtra exception:" + e2.getMessage());
            return new byte[-1];
        }
    }

    public static boolean e(Bundle bundle, String str) {
        if (bundle == null) {
            return false;
        }
        try {
            return bundle.getBoolean(str, false);
        } catch (Exception e2) {
            Log.e(a, "getIntExtra exception:" + e2.getMessage());
            return false;
        }
    }
}
