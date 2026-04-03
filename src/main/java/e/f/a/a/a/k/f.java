package e.f.a.a.a.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.exifinterface.media.ExifInterface;
import com.tme.fireeye.crash.comm.info.PlugInBean;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static void A(String str, String str2, int i2) {
        c.b("rqdp{  sv sd start} %s", str);
        if (str2 == null || str2.trim().length() <= 0) {
            return;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = file.length() >= ((long) i2) ? new FileOutputStream(file, false) : new FileOutputStream(file, true);
                fileOutputStream.write(str2.getBytes("UTF-8"));
                fileOutputStream.flush();
            } catch (Throwable th) {
                try {
                    if (!c.k(th)) {
                        th.printStackTrace();
                    }
                    if (fileOutputStream != null) {
                    }
                    c.b("rqdp{  sv sd end}", new Object[0]);
                } catch (Throwable th2) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th2;
                }
            }
            fileOutputStream.close();
        } catch (Throwable th3) {
            if (!c.k(th3)) {
                th3.printStackTrace();
            }
        }
        c.b("rqdp{  sv sd end}", new Object[0]);
    }

    public static void B(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj2, obj);
        } catch (Exception unused) {
        }
    }

    public static void C(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public static Thread D(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Throwable th) {
            c.c("[Util] Failed to start a thread to execute task with message: %s", th.getMessage());
            return null;
        }
    }

    public static boolean E(Context context, String str, long j) {
        c.b("[Util] Try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                c.b("[Util] Lock file (%s) is expired, unlock it.", str);
                F(context, str);
            }
            if (file.createNewFile()) {
                c.b("[Util] Successfully locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            c.b("[Util] Failed to locked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            c.k(th);
            return false;
        }
    }

    public static boolean F(Context context, String str) {
        c.b("[Util] Try to unlock file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            File file = new File(context.getFilesDir() + File.separator + str);
            if (!file.exists()) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
            c.b("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Throwable th) {
            c.k(th);
            return false;
        }
    }

    public static Parcel G(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        return parcelObtain;
    }

    public static <T> T H(byte[] bArr, Parcelable.Creator<T> creator) {
        Parcel parcelG = G(bArr);
        try {
            return creator.createFromParcel(parcelG);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (parcelG != null) {
                    parcelG.recycle();
                }
                return null;
            } finally {
                if (parcelG != null) {
                    parcelG.recycle();
                }
            }
        }
    }

    public static byte[] I(byte[] bArr, int i2) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i2 == 2 ? "Gzip" : "zip";
        c.b("[Util] Unzip %d bytes data with type %s", objArr);
        try {
            e.f.a.a.d.c.a.a.a.b bVarA = e.f.a.a.d.c.a.a.a.a.a(i2);
            if (bVarA == null) {
                return null;
            }
            return bVarA.unZip(bArr);
        } catch (Throwable th) {
            if (th.getMessage() != null && th.getMessage().contains("Not in GZIP format")) {
                c.j(th.getMessage(), new Object[0]);
            } else if (!c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean J(String str) {
        if (q(str)) {
            return false;
        }
        if (str.length() > 255) {
            c.f("URL(%s)'s length is larger than 255.", str);
            return false;
        }
        if (str.toLowerCase().startsWith("http")) {
            return true;
        }
        c.f("URL(%s) is not start with \"http\".", str);
        return false;
    }

    public static void K(Parcel parcel, Map<String, PlugInBean> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Map.Entry<String, PlugInBean> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putInt("pluginNum", arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bundle.putString("pluginKey" + i2, (String) arrayList.get(i2));
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            bundle.putString("pluginVal" + i3 + "plugInId", ((PlugInBean) arrayList2.get(i3)).a);
            bundle.putString("pluginVal" + i3 + "plugInUUID", ((PlugInBean) arrayList2.get(i3)).f268d);
            bundle.putString("pluginVal" + i3 + "plugInVersion", ((PlugInBean) arrayList2.get(i3)).b);
        }
        parcel.writeBundle(bundle);
    }

    public static void L(Parcel parcel, Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            parcel.writeBundle(null);
            return;
        }
        int size = map.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        ArrayList<String> arrayList2 = new ArrayList<>(size);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("keys", arrayList);
        bundle.putStringArrayList("values", arrayList2);
        parcel.writeBundle(bundle);
    }

    public static byte[] M(byte[] bArr, int i2) {
        if (bArr == null || i2 == -1) {
            return bArr;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr.length);
        objArr[1] = i2 == 2 ? "Gzip" : "zip";
        c.b("[Util] Zip %d bytes data with type %s", objArr);
        try {
            e.f.a.a.d.c.a.a.a.b bVarA = e.f.a.a.d.c.a.a.a.a.a(i2);
            if (bVarA == null) {
                return null;
            }
            return bVarA.zip(bArr);
        } catch (Throwable th) {
            if (!c.k(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static boolean N(File file, File file2, int i2) {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        c.b("rqdp{  ZF start}", new Object[0]);
        if (file == null || file2 == null || file.equals(file2)) {
            c.j("rqdp{  err ZF 1R!}", new Object[0]);
            return false;
        }
        if (!file.exists() || !file.canRead()) {
            c.j("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
            return false;
        }
        try {
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (Throwable th) {
            if (!c.k(th)) {
                th.printStackTrace();
            }
        }
        if (!file2.exists() || !file2.canRead()) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
        try {
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            if (i2 <= 1000) {
                i2 = 1000;
            }
            byte[] bArr = new byte[i2];
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 <= 0) {
                    break;
                }
                zipOutputStream.write(bArr, 0, i3);
            }
            zipOutputStream.flush();
            zipOutputStream.closeEntry();
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                zipOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            c.b("rqdp{  ZF end}", new Object[0]);
            return true;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream2 = fileInputStream;
            try {
                if (!c.k(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                c.b("rqdp{  ZF end}", new Object[0]);
                return false;
            } catch (Throwable th5) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                c.b("rqdp{  ZF end}", new Object[0]);
                throw th5;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a8 A[Catch: all -> 0x00c5, TRY_LEAVE, TryCatch #4 {all -> 0x00c5, blocks: (B:48:0x00a2, B:50:0x00a8), top: B:85:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] O(java.io.File r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.f.a.a.a.k.f.O(java.io.File, java.lang.String, java.lang.String):byte[]");
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & ExifInterface.MARKER);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static long b(byte[] bArr) {
        if (bArr == null) {
            return -1L;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static void c(String str) {
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.isFile() && file.exists() && file.canWrite()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public static Context d(Context context) {
        Context applicationContext;
        return (context == null || (applicationContext = context.getApplicationContext()) == null) ? context : applicationContext;
    }

    public static String e(File file, int i2, boolean z) {
        BufferedReader bufferedReader;
        if (file == null || !file.exists() || !file.canRead()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append("\n");
                    if (i2 > 0 && sb.length() > i2) {
                        if (z) {
                            sb.delete(i2, sb.length());
                            break;
                        }
                        sb.delete(0, sb.length() - i2);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        c.k(th);
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                c.k(e2);
                            }
                        }
                    }
                }
            }
            String string = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception e3) {
                c.k(e3);
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public static BufferedReader f(File file) {
        if (file != null && file.exists() && file.canRead()) {
            try {
                return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            } catch (Throwable th) {
                c.k(th);
            }
        }
        return null;
    }

    public static BufferedReader g(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() && file.canRead()) {
                return f(file);
            }
            return null;
        } catch (NullPointerException e2) {
            c.k(e2);
            return null;
        }
    }

    public static String h(Thread thread) {
        if (thread == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Map<String, String> i(int i2, boolean z) {
        HashMap map = new HashMap(12);
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return null;
        }
        Thread thread = Looper.getMainLooper().getThread();
        if (!allStackTraces.containsKey(thread)) {
            allStackTraces.put(thread, thread.getStackTrace());
        }
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
            if (!z || id != entry.getKey().getId()) {
                int i3 = 0;
                sb.setLength(0);
                if (entry.getValue() != null && entry.getValue().length != 0) {
                    StackTraceElement[] value = entry.getValue();
                    int length = value.length;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        StackTraceElement stackTraceElement = value[i3];
                        if (i2 > 0 && sb.length() >= i2) {
                            sb.append("\n[Stack over limit size :" + i2 + " , has been cut!]");
                            break;
                        }
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                        i3++;
                    }
                    map.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                }
            }
        }
        return map;
    }

    public static SharedPreferences j(String str, Context context) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static String k(String str, String str2) {
        return (e.f.a.a.a.h.b.m() == null || e.f.a.a.a.h.b.m().i0 == null) ? "" : e.f.a.a.a.h.b.m().i0.getString(str, str2);
    }

    public static String l(Context context, String str) {
        return e.f.a.b.a.m.c.b(context, str);
    }

    public static String m() {
        return n(System.currentTimeMillis());
    }

    public static String n(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(j));
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static long o() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (c.k(th)) {
                return -1L;
            }
            th.printStackTrace();
            return -1L;
        }
    }

    public static String p(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "NULL";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (Throwable th) {
            if (c.k(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static boolean q(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static boolean r() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static byte[] s(long j) {
        try {
            return ("" + j).getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] t(Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static String u(Date date) {
        if (date == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
        } catch (Exception unused) {
            return new Date().toString();
        }
    }

    public static String v(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (c.k(th2)) {
                return "fail";
            }
            th2.printStackTrace();
            return "fail";
        }
    }

    public static void w(String str, String str2) {
        if (e.f.a.a.a.h.b.m() == null || e.f.a.a.a.h.b.m().i0 == null) {
            return;
        }
        e.f.a.a.a.h.b.m().i0.edit().putString(str, str2).apply();
    }

    public static String x(Context context, int i2, String str) {
        Process processExec = null;
        if (Build.VERSION.SDK_INT < 16 && !e.f.a.a.a.h.a.f(context, "android.permission.READ_LOGS")) {
            c.j("no read_log permission!", new Object[0]);
            return null;
        }
        String[] strArr = str == null ? new String[]{"logcat", "-d", "-v", "threadtime"} : new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        StringBuilder sb = new StringBuilder();
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
                if (i2 > 0 && sb.length() > i2) {
                    sb.delete(0, sb.length() - i2);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            try {
                if (!c.k(th)) {
                    th.printStackTrace();
                }
                sb.append("\n[error:" + th.toString() + "]");
                String string = sb.toString();
                if (processExec != null) {
                    try {
                        processExec.getOutputStream().close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        processExec.getInputStream().close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    try {
                        processExec.getErrorStream().close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return string;
            } finally {
                if (processExec != null) {
                    try {
                        processExec.getOutputStream().close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    try {
                        processExec.getInputStream().close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    try {
                        processExec.getErrorStream().close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
    }

    public static Map<String, PlugInBean> y(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        HashMap map = null;
        if (bundle == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iIntValue = ((Integer) bundle.get("pluginNum")).intValue();
        for (int i2 = 0; i2 < iIntValue; i2++) {
            arrayList.add(bundle.getString("pluginKey" + i2));
        }
        for (int i3 = 0; i3 < iIntValue; i3++) {
            arrayList2.add(new PlugInBean(bundle.getString("pluginVal" + i3 + "plugInId"), bundle.getString("pluginVal" + i3 + "plugInVersion"), bundle.getString("pluginVal" + i3 + "plugInUUID")));
        }
        if (arrayList.size() == arrayList2.size()) {
            map = new HashMap(arrayList.size());
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                map.put((String) arrayList.get(i4), (PlugInBean) PlugInBean.class.cast(arrayList2.get(i4)));
            }
        } else {
            c.c("map plugin parcel error!", new Object[0]);
        }
        return map;
    }

    public static Map<String, String> z(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        HashMap map = null;
        if (bundle == null) {
            return null;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("keys");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("values");
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            c.c("map parcel error!", new Object[0]);
        } else {
            map = new HashMap(stringArrayList.size());
            for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                map.put(stringArrayList.get(i2), stringArrayList2.get(i2));
            }
        }
        return map;
    }
}
