package com.heytap.openid.sdk;

import android.content.Context;
import d.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public class OpenIDSDK {
    public static String getAAID(Context context) {
        if (a.c.a) {
            return a.d.b.a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String getOAID(Context context) {
        if (a.c.a) {
            return a.d.b.a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String getUDID(Context context) {
        if (a.c.a) {
            return a.d.b.a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String getVAID(Context context) {
        if (a.c.a) {
            return a.d.b.a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void init(Context context) {
        a.c.b = a.d.b.a.b(context.getApplicationContext());
        a.c.a = true;
    }

    public static boolean isSupported() {
        if (a.c.a) {
            return a.c.b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
