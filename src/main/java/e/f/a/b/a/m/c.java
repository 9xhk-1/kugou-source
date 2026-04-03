package e.f.a.b.a.m;

import android.app.ActivityManager;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static ActivityManager a;
    public static final Map<String, String> b = new HashMap();

    public static ArrayList<String> a(Context context, String[] strArr) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Process processExec;
        if (d(context)) {
            return new ArrayList<>(Collections.singletonList("unknown(low memory)"));
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
            bufferedReader2 = null;
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                arrayList.add(line);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = null;
            }
            try {
                e.f.a.b.a.c.b("Utils", "[executeCommand] err=", th);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } finally {
            }
        }
        bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getErrorStream()));
        while (true) {
            try {
                String line2 = bufferedReader2.readLine();
                if (line2 != null) {
                    arrayList.add(line2);
                } else {
                    try {
                        break;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        bufferedReader.close();
        try {
            bufferedReader2.close();
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        return arrayList;
    }

    public static String b(Context context, String str) {
        String str2;
        if (str == null || str.trim().equals("")) {
            return "";
        }
        Map<String, String> map = b;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        ArrayList<String> arrayListA = a(context, new String[]{(new File("/system/bin/sh").exists() && new File("/system/bin/sh").canExecute()) ? "/system/bin/sh" : "sh", "-c", "getprop " + str});
        if (arrayListA == null || arrayListA.size() <= 0) {
            e.f.a.b.a.c.c("Utils", "Failed get 'getprop'. " + str);
            str2 = "fail";
        } else {
            str2 = arrayListA.get(0);
            e.f.a.b.a.c.c("Utils", "Successfully get 'getprop'. " + str + " = " + str2);
        }
        map.put(str, str2);
        return str2;
    }

    public static boolean c(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Throwable th) {
            e.f.a.b.a.c.b("Utils", "[isJsonObject] t=", th);
            return false;
        }
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        if (a == null) {
            a = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            a.getMemoryInfo(memoryInfo);
            return memoryInfo.lowMemory;
        } catch (Throwable th) {
            e.f.a.b.a.c.b("Utils", "[isLowMemory] err=", th);
            return false;
        }
    }
}
