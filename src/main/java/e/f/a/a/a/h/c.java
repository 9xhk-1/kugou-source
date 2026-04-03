package e.f.a.a.a.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import e.f.a.a.a.k.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static final String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    public static final String[] b = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static int b() {
        try {
            throw new Exception("detect hook");
        } catch (Exception e2) {
            int i2 = 0;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i2 |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i2 |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i2 |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i3 = i3 + 1) == 2) {
                    i2 |= 32;
                }
            }
            return i2;
        }
    }

    public static String c(Context context) {
        String string = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string == null ? "null" : string.toLowerCase();
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                e.f.a.a.a.k.c.f("Failed to get Android ID.", new Object[0]);
            }
            return string;
        }
    }

    public static int d() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String e() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String f() {
        return "";
    }

    public static String g(Context context, boolean z) {
        String property = null;
        if (z) {
            try {
                String strL = f.l(context, "ro.product.cpu.abilist");
                if (f.q(strL) || strL.equals("fail")) {
                    strL = f.l(context, "ro.product.cpu.abi");
                }
                if (!f.q(strL) && !strL.equals("fail")) {
                    e.f.a.a.a.k.c.a(c.class, "ABI list: " + strL, new Object[0]);
                    property = strL.split(",")[0];
                }
            } catch (Throwable th) {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                return "fail";
            }
        }
        if (property == null) {
            property = System.getProperty("os.arch");
        }
        return "" + property;
    }

    public static String h(Context context) {
        return f.l(context, "ro.board.platform");
    }

    public static long i() {
        if (!a()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String j(Context context) {
        TelephonyManager telephonyManager;
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() != 1) {
                if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    int networkType = telephonyManager.getNetworkType();
                    switch (networkType) {
                        case 1:
                            str = "GPRS";
                            break;
                        case 2:
                            str = "EDGE";
                            break;
                        case 3:
                            str = "UMTS";
                            break;
                        case 4:
                            str = "CDMA";
                            break;
                        case 5:
                            str = "EVDO_0";
                            break;
                        case 6:
                            str = "EVDO_A";
                            break;
                        case 7:
                            str = "1xRTT";
                            break;
                        case 8:
                            str = "HSDPA";
                            break;
                        case 9:
                            str = "HSUPA";
                            break;
                        case 10:
                            str = "HSPA";
                            break;
                        case 11:
                            str = "iDen";
                            break;
                        case 12:
                            str = "EVDO_B";
                            break;
                        case 13:
                            str = "LTE";
                            break;
                        case 14:
                            str = "eHRPD";
                            break;
                        case 15:
                            str = "HSPA+";
                            break;
                        default:
                            str = "MOBILE(" + networkType + ")";
                            break;
                    }
                } else {
                    return "unknown";
                }
            } else {
                str = "WIFI";
            }
            return str;
        } catch (Exception e2) {
            if (e.f.a.a.a.k.c.k(e2)) {
                return "unknown";
            }
            e2.printStackTrace();
            return "unknown";
        }
    }

    public static long k() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            if (line == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!e.f.a.a.a.k.c.k(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!e.f.a.a.a.k.c.k(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long j = (Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024) + 0;
            String line2 = bufferedReader.readLine();
            if (line2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    if (!e.f.a.a.a.k.c.k(e4)) {
                        e4.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e5) {
                    if (!e.f.a.a.a.k.c.k(e5)) {
                        e5.printStackTrace();
                    }
                }
                return -1L;
            }
            long j2 = Long.parseLong(line2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim());
            Long.signum(j2);
            long j3 = j + (j2 * 1024);
            String line3 = bufferedReader.readLine();
            if (line3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    if (!e.f.a.a.a.k.c.k(e6)) {
                        e6.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e7) {
                    if (!e.f.a.a.a.k.c.k(e7)) {
                        e7.printStackTrace();
                    }
                }
                return -1L;
            }
            long j4 = j3 + (Long.parseLong(line3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
            try {
                bufferedReader.close();
            } catch (IOException e8) {
                if (!e.f.a.a.a.k.c.k(e8)) {
                    e8.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e9) {
                if (!e.f.a.a.a.k.c.k(e9)) {
                    e9.printStackTrace();
                }
            }
            return j4;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e10) {
                        if (!e.f.a.a.a.k.c.k(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e11) {
                    if (e.f.a.a.a.k.c.k(e11)) {
                        return -2L;
                    }
                    e11.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        if (!e.f.a.a.a.k.c.k(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e13) {
                        if (!e.f.a.a.a.k.c.k(e13)) {
                            e13.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    public static long l() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            if (line == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!e.f.a.a.a.k.c.k(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!e.f.a.a.a.k.c.k(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long j = Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                if (!e.f.a.a.a.k.c.k(e4)) {
                    e4.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e5) {
                if (!e.f.a.a.a.k.c.k(e5)) {
                    e5.printStackTrace();
                }
            }
            return j;
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!e.f.a.a.a.k.c.k(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        if (!e.f.a.a.a.k.c.k(e6)) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (fileReader == null) {
                    return -2L;
                }
                try {
                    fileReader.close();
                    return -2L;
                } catch (IOException e7) {
                    if (e.f.a.a.a.k.c.k(e7)) {
                        return -2L;
                    }
                    e7.printStackTrace();
                    return -2L;
                }
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        if (!e.f.a.a.a.k.c.k(e8)) {
                            e8.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                        if (!e.f.a.a.a.k.c.k(e9)) {
                            e9.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    public static long m() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static String n(Context context) {
        String strL = f.l(context, "ro.miui.ui.version.name");
        if (!f.q(strL) && !strL.equals("fail")) {
            return "XiaoMi/MIUI/" + strL;
        }
        String strL2 = f.l(context, "ro.build.version.emui");
        if (!f.q(strL2) && !strL2.equals("fail")) {
            return "HuaWei/EMOTION/" + strL2;
        }
        String strL3 = f.l(context, "ro.lenovo.series");
        if (!f.q(strL3) && !strL3.equals("fail")) {
            return "Lenovo/VIBE/" + f.l(context, "ro.build.version.incremental");
        }
        String strL4 = f.l(context, "ro.build.nubia.rom.name");
        if (!f.q(strL4) && !strL4.equals("fail")) {
            return "Zte/NUBIA/" + strL4 + "_" + f.l(context, "ro.build.nubia.rom.code");
        }
        String strL5 = f.l(context, "ro.meizu.product.model");
        if (!f.q(strL5) && !strL5.equals("fail")) {
            return "Meizu/FLYME/" + f.l(context, "ro.build.display.id");
        }
        String strL6 = f.l(context, "ro.build.version.opporom");
        if (!f.q(strL6) && !strL6.equals("fail")) {
            return "Oppo/COLOROS/" + strL6;
        }
        String strL7 = f.l(context, "ro.vivo.os.build.display.id");
        if (!f.q(strL7) && !strL7.equals("fail")) {
            return "Vivo/FUNTOUCH/" + strL7;
        }
        String strL8 = f.l(context, "ro.aa.romver");
        if (!f.q(strL8) && !strL8.equals("fail")) {
            return "htc/" + strL8 + "/" + f.l(context, "ro.build.description");
        }
        String strL9 = f.l(context, "ro.lewa.version");
        if (!f.q(strL9) && !strL9.equals("fail")) {
            return "tcl/" + strL9 + "/" + f.l(context, "ro.build.display.id");
        }
        String strL10 = f.l(context, "ro.gn.gnromvernumber");
        if (!f.q(strL10) && !strL10.equals("fail")) {
            return "amigo/" + strL10 + "/" + f.l(context, "ro.build.display.id");
        }
        String strL11 = f.l(context, "ro.build.tyd.kbstyle_version");
        if (!f.q(strL11) && !strL11.equals("fail")) {
            return "dido/" + strL11;
        }
        return f.l(context, "ro.build.fingerprint") + "/" + f.l(context, "ro.build.rom.id");
    }

    public static long o() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!e.f.a.a.a.k.c.k(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long p() {
        if (!a()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String q() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (e.f.a.a.a.k.c.k(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String r() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = b;
            if (i2 >= strArr.length) {
                break;
            }
            if (i2 == 0) {
                if (!new File(strArr[i2]).exists()) {
                    arrayList.add(Integer.valueOf(i2));
                }
            } else if (new File(strArr[i2]).exists()) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }

    public static int s() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    public static boolean t(Context context) {
        return ((b() | u()) | s()) > 0;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00bb: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:52:0x00bb */
    public static int u() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e2;
        UnsupportedEncodingException e3;
        FileNotFoundException e4;
        HashSet hashSet;
        int i2 = 0;
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    hashSet = new HashSet();
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
                } catch (FileNotFoundException e5) {
                    bufferedReader2 = null;
                    e4 = e5;
                } catch (UnsupportedEncodingException e6) {
                    bufferedReader2 = null;
                    e3 = e6;
                } catch (IOException e7) {
                    bufferedReader2 = null;
                    e2 = e7;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
            }
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.endsWith(".so") || line.endsWith(".jar")) {
                        hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                    }
                } catch (FileNotFoundException e10) {
                    e4 = e10;
                    e4.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i2;
                } catch (UnsupportedEncodingException e11) {
                    e3 = e11;
                    e3.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i2;
                } catch (IOException e12) {
                    e2 = e12;
                    e2.printStackTrace();
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return i2;
                }
                return i2;
            }
            for (Object obj : hashSet) {
                if (((String) obj).toLowerCase().contains("xposed")) {
                    i2 |= 64;
                }
                if (((String) obj).contains("com.saurik.substrate")) {
                    i2 |= 128;
                }
            }
            bufferedReader2.close();
            return i2;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader3 = bufferedReader;
        }
    }

    public static boolean v() {
        boolean z;
        String[] strArr = a;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            }
            i2++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    public static boolean w(Context context) {
        return r() != null;
    }

    public static boolean x(Context context) {
        double dMaxMemory = Runtime.getRuntime().maxMemory();
        Double.isNaN(dMaxMemory);
        float f2 = (float) ((dMaxMemory * 1.0d) / 1048576.0d);
        double d2 = Runtime.getRuntime().totalMemory();
        Double.isNaN(d2);
        float f3 = (float) ((d2 * 1.0d) / 1048576.0d);
        float f4 = f2 - f3;
        e.f.a.a.a.k.c.b("maxMemory : %f", Float.valueOf(f2));
        e.f.a.a.a.k.c.b("totalMemory : %f", Float.valueOf(f3));
        e.f.a.a.a.k.c.b("freeMemory : %f", Float.valueOf(f4));
        return f4 < 10.0f;
    }
}
