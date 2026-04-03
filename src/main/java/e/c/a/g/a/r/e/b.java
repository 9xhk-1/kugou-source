package e.c.a.g.a.r.e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.gson.Gson;
import e.c.a.g.a.s.g0;
import e.c.c.o.i;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a = -1;

    public static String a(String str) {
        if (!f(str)) {
            return str;
        }
        String str2 = "";
        for (int i2 = 0; i2 < str.length(); i2++) {
            String hexString = Integer.toHexString(str.charAt(i2));
            if (hexString.length() == 3) {
                hexString = "0" + hexString;
            } else if (hexString.length() == 2) {
                hexString = "00" + hexString;
            } else if (hexString.length() == 1) {
                hexString = "000" + hexString;
            }
            str2 = str2 + "\\u" + hexString;
        }
        return str2;
    }

    public static String b(long j, String str, int i2, String str2) {
        return new i().e(String.valueOf(j) + str + String.valueOf(i2) + str2).toLowerCase();
    }

    public static int c(Context context) {
        int i2 = a;
        if (i2 > 0) {
            return i2;
        }
        try {
            int i3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            a = i3;
            return i3;
        } catch (PackageManager.NameNotFoundException e2) {
            g0.k(e2);
            return 0;
        } catch (RuntimeException e3) {
            g0.k(e3);
            return -1;
        }
    }

    @Deprecated
    public static String d(HashMap map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        String str = "{";
        for (Map.Entry entry : map.entrySet()) {
            String str2 = str + "\"" + entry.getKey() + "\":";
            str = ((entry.getValue() instanceof Integer) || (entry.getValue() instanceof Long)) ? str2 + "" + entry.getValue() + "," : str2 + "\"" + entry.getValue() + "\",";
        }
        return str.substring(0, str.lastIndexOf(",")) + "}";
    }

    public static String e(HashMap map) {
        return new Gson().toJson(map);
    }

    public static boolean f(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= 19968 && cCharAt <= 40869) {
                return true;
            }
        }
        return false;
    }
}
