package com.xtc.payapi.paymanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.payapi.constants.PayConstant;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final String a = "pay_sdkPayMessage";

    /* JADX INFO: renamed from: com.xtc.payapi.paymanager.a$a, reason: collision with other inner class name */
    public static class C0028a {
        public String a;
        public String b;
        public int c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Bundle f288d;

        public String toString() {
            return "Args{targetPkgName='" + this.a + "', targetClassName='" + this.b + "', flags=" + this.c + ", bundle=" + this.f288d + '}';
        }
    }

    public static boolean a(Context context, C0028a c0028a) {
        String string;
        StringBuilder sb;
        String str;
        if (context == null || c0028a == null) {
            string = "send fail, invalid argument";
        } else {
            if (TextUtils.isEmpty(c0028a.a)) {
                sb = new StringBuilder();
                sb.append("send fail, invalid targetPkgName, targetPkgName = ");
                str = c0028a.a;
            } else if (TextUtils.isEmpty(c0028a.b)) {
                sb = new StringBuilder();
                sb.append("send fail, invalid targetClassName, targetClassName = ");
                str = c0028a.b;
            } else {
                Intent intent = new Intent();
                intent.setClassName(c0028a.a, c0028a.b);
                Bundle bundle = c0028a.f288d;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                intent.putExtra(PayConstant.SourceAppInfo.SOURCE_PAY_VERSION_KEY, "1");
                intent.putExtra(PayConstant.SourceAppInfo.SOURCE_PACKAGE_NAME_KEY, context.getPackageName());
                intent.putExtra(PayConstant.SourceAppInfo.SOURCE_CLASS_NAME_KEY, context.getClass().getName());
                int i2 = c0028a.c;
                if (i2 == -1) {
                    intent.addFlags(268435456).addFlags(134217728);
                } else {
                    intent.setFlags(i2);
                }
                try {
                    context.startActivity(intent);
                    Log.d(a, "send message, intent=" + intent);
                    return true;
                } catch (Exception e2) {
                    string = "send fail, ex = " + e2.getMessage();
                }
            }
            sb.append(str);
            string = sb.toString();
        }
        Log.e(a, string);
        return false;
    }
}
