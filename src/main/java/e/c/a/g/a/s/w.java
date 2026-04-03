package e.c.a.g.a.s;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.multidex.MultiDexExtractor;
import dalvik.system.DexFile;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class w {
    public static Object a;
    public static Method b;

    public static int a(Context context) {
        if (Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        d();
        if (c()) {
            Log.d("HiddenAPIUtil", "exemptAll success");
            return 0;
        }
        if (e(context)) {
            return 0;
        }
        Log.d("HiddenAPIUtil", "exemptAll failed");
        return -1;
    }

    public static boolean b(String... strArr) {
        Method method;
        Object obj = a;
        if (obj != null && (method = b) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean c() {
        return b("L");
    }

    public static void d() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            a = method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            Log.e("HiddenAPIUtil", "exemptAll failed:" + Log.getStackTraceString(th));
        }
    }

    @RequiresApi(api = 21)
    public static boolean e(Context context) {
        byte[] bArrDecode = Base64.decode("ZGV4CjAzNQC64r+eF3W05uI510eLKDFIzeKIEI6uUIgoBQAAcAAAAHhWNBIAAAAAAAAAAJQEAAAZAAAAcAAAAAsAAADUAAAABQAAAAABAAAAAAAAAAAAAAcAAAA8AQAAAQAAAHQBAACUAwAAlAEAAFYCAABYAgAAYgIAAGoCAABtAgAAcQIAAHYCAAB7AgAAjgIAAKICAADAAgAA1AIAAOsCAAAHAwAACgMAAA4DAAAiAwAANwMAAEwDAABlAwAAbgMAAIEDAACNAwAAlQMAAK0DAAAGAAAABwAAAAgAAAAJAAAACgAAAAsAAAAMAAAADQAAAA8AAAAQAAAAEQAAAAQAAAABAAAAOAIAAAUAAAACAAAAQAIAAAUAAAAGAAAASAIAAA0AAAAHAAAAAAAAAA4AAAAHAAAAUAIAAAAAAwABAAAAAAADAAIAAAABAAAAEwAAAAEAAgAUAAAAAgADAAIAAAADAAQAAgAAAAYAAQAWAAAAAAAAAAEAAAACAAAAAAAAAAAAAAAAAAAAfwQAAAAAAAAHAAAAAwABAAAAAAA4AAAAGgASAHEQAgAAAAwAGgEVABICIyMIAG4wAwAQAwwBGgMXABIUI0UIABwGCgBNBgUCbjADADAFDAASAyMlCQBuMAYAMQUMASNDCQAjRAoAGgUDAE0FBAJNBAMCbjAGABADDgANACIBAwBwIAUAAQAnAQAAAAAwAAEAAQAxAAEAAQABAAAAAAAAAAQAAABwEAQAAAAOAAEAAAAEAAAAAgAAAAIACQACAAAABAAIAAEAAAAFAAAACDxjbGluaXQ+AAY8aW5pdD4AAUwAAkxMAANMTEwAA0xhOwARTGphdmEvbGFuZy9DbGFzczsAEkxqYXZhL2xhbmcvT2JqZWN0OwAcTGphdmEvbGFuZy9SdW50aW1lRXhjZXB0aW9uOwASTGphdmEvbGFuZy9TdHJpbmc7ABVMamF2YS9sYW5nL1Rocm93YWJsZTsAGkxqYXZhL2xhbmcvcmVmbGVjdC9NZXRob2Q7AAFWAAJWTAASW0xqYXZhL2xhbmcvQ2xhc3M7ABNbTGphdmEvbGFuZy9PYmplY3Q7ABNbTGphdmEvbGFuZy9TdHJpbmc7ABdkYWx2aWsuc3lzdGVtLlZNUnVudGltZQAHZm9yTmFtZQARZ2V0RGVjbGFyZWRNZXRob2QACmdldFJ1bnRpbWUABmludm9rZQAWc2V0SGlkZGVuQXBpRXhlbXB0aW9ucwDPAX5+Ujh7ImJhY2tlbmQiOiJkZXgiLCJjb21waWxhdGlvbi1tb2RlIjoicmVsZWFzZSIsImhhcy1jaGVja3N1bXMiOmZhbHNlLCJtaW4tYXBpIjoxNCwicGctbWFwLWlkIjoiYmMzMGRiYyIsInI4LW1vZGUiOiJjb21wYXRpYmlsaXR5Iiwic2hhLTEiOiIzYjI0N2VmYTliZTk2OGJiZjI0YmU4YzU0ZjZjNWVhMWY1Yzk5M2IwIiwidmVyc2lvbiI6IjMuMC4yMC1kZXYifQAAAAIAAImABJQDAYGABKAEAAAAAAAMAAAAAAAAAAEAAAAAAAAAAQAAABkAAABwAAAAAgAAAAsAAADUAAAAAwAAAAUAAAAAAQAABQAAAAcAAAA8AQAABgAAAAEAAAB0AQAAASAAAAIAAACUAQAAARAAAAQAAAA4AgAAAiAAABkAAABWAgAAACAAAAEAAAB/BAAAAxAAAAEAAACQBAAAABAAAAEAAACUBAAA", 2);
        try {
            File file = new File(context.getCodeCacheDir(), System.currentTimeMillis() + MultiDexExtractor.DEX_SUFFIX);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArrDecode);
                fileOutputStream.close();
                new DexFile(file).loadClass("a", null).newInstance();
                return true;
            } finally {
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
