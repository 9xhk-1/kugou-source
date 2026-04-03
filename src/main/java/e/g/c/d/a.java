package e.g.c.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(Context context, String str) {
        try {
            int i2 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getInt("open_data_host_version");
            boolean z = i2 >= 1100;
            Log.d("openData_sdkIntentUtils", "check setting meta support = " + z + " version = " + i2);
            return z;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("openData_sdkIntentUtils", "check setting meta support error: ", e2);
            return false;
        }
    }
}
