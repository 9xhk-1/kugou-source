package com.kugou.uilib.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIStringParseUtils {
    public static double parseDouble(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return Double.parseDouble(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static float parseFloat(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0f;
            }
            return Float.parseFloat(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0f;
        }
    }

    public static int parseInt(String str, int i2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static long parseLong(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            return Long.parseLong(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static int parseInt(String str) {
        return parseInt(str, 10);
    }
}
