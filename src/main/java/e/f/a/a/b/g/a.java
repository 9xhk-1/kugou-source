package e.f.a.a.b.g;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import com.tme.fireeye.crash.crashmodule.CrashDetailBean;
import com.tme.fireeye.crash.crashmodule.jni.NativeExceptionHandler;
import e.f.a.a.a.h.b;
import e.f.a.a.a.k.c;
import e.f.a.a.a.k.f;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static List<File> a = new ArrayList();

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String[] strArrSplit = str.split("\n");
        if (strArrSplit == null || strArrSplit.length == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            if (!str2.contains("java.lang.Thread.getStackTrace(")) {
                sb.append(str2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void b(String str) {
        File[] fileArrListFiles;
        if (str == null) {
            return;
        }
        try {
            File file = new File(str);
            if (file.canRead() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.canRead() && file2.canWrite() && file2.length() == 0) {
                        file2.delete();
                        c.b("Delete empty record file %s", file2.getAbsoluteFile());
                    }
                }
            }
        } catch (Throwable th) {
            c.k(th);
        }
    }

    public static void c(boolean z, String str) {
        if (str != null) {
            a.add(new File(str, "rqd_record.eup"));
            a.add(new File(str, "reg_record.txt"));
            a.add(new File(str, "map_record.txt"));
            a.add(new File(str, "backup_record.txt"));
            if (z) {
                b(str);
            }
        }
        List<File> list = a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (File file : a) {
            if (file.exists() && file.canWrite()) {
                file.delete();
                c.b("Delete record file %s", file.getAbsoluteFile());
            }
        }
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str, "backup_record.txt");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    public static CrashDetailBean e(Context context, String str, NativeExceptionHandler nativeExceptionHandler) throws Throwable {
        BufferedInputStream bufferedInputStream;
        String str2;
        String strL;
        BufferedInputStream bufferedInputStream2 = 0;
        if (context == null || str == null || nativeExceptionHandler == null) {
            c.c("get eup record file args error", new Object[0]);
            return null;
        }
        File file = new File(str, "rqd_record.eup");
        if (file.exists()) {
            ?? CanRead = file.canRead();
            try {
                if (CanRead != 0) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e2) {
                        e = e2;
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedInputStream2 != 0) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        String strL2 = l(bufferedInputStream);
                        if (strL2 != null && strL2.equals("NATIVE_RQD_REPORT")) {
                            HashMap map = new HashMap();
                            loop0: while (true) {
                                str2 = null;
                                while (true) {
                                    strL = l(bufferedInputStream);
                                    if (strL == null) {
                                        break loop0;
                                    }
                                    if (str2 == null) {
                                        str2 = strL;
                                    }
                                }
                                map.put(str2, strL);
                            }
                            if (str2 != null) {
                                c.c("record not pair! drop! %s", str2);
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                return null;
                            }
                            CrashDetailBean crashDetailBeanH = h(context, map, nativeExceptionHandler);
                            if (crashDetailBeanH != null) {
                                String str3 = (String) map.get("jniLogPath");
                                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(crashDetailBeanH.E)) {
                                    f.c(str3);
                                }
                            }
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                            return crashDetailBeanH;
                        }
                        c.c("record read fail! %s", strL2);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        return null;
                    } catch (IOException e7) {
                        e = e7;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = CanRead;
            }
        }
        return null;
    }

    public static String f(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String strK = k(str, str2);
        if (strK != null && !strK.isEmpty()) {
            sb.append("Register infos:\n");
            sb.append(strK);
        }
        String strJ = j(str, str2);
        if (strJ != null && !strJ.isEmpty()) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("System SO infos:\n");
            sb.append(strJ);
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.String] */
    public static String g(String str, int i2, String str2, boolean z) {
        BufferedReader bufferedReader = null;
        if (str != null && i2 > 0) {
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                c.f("Read system log from native record file(length: %s bytes): %s", Long.valueOf(file.length()), file.getAbsolutePath());
                a.add(file);
                c.b("Add this record file to list for cleaning lastly.", new Object[0]);
                if (str2 == null) {
                    return f.e(new File(str), i2, z);
                }
                String sb = new StringBuilder();
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                        while (true) {
                            try {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                if (Pattern.compile(str2 + "[ ]*:").matcher(line).find()) {
                                    sb.append(line);
                                    sb.append("\n");
                                }
                                if (i2 > 0 && sb.length() > i2) {
                                    if (z) {
                                        sb.delete(i2, sb.length());
                                        break;
                                    }
                                    sb.delete(0, sb.length() - i2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                try {
                                    c.k(th);
                                    sb.append("\n[error:" + th.toString() + "]");
                                    String string = sb.toString();
                                    if (bufferedReader == null) {
                                        return string;
                                    }
                                    bufferedReader.close();
                                    sb = string;
                                } catch (Throwable th2) {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (Exception e2) {
                                            c.k(e2);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        String string2 = sb.toString();
                        bufferedReader2.close();
                        sb = string2;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    return sb;
                } catch (Exception e3) {
                    c.k(e3);
                    return sb;
                }
            }
        }
        return null;
    }

    public static CrashDetailBean h(Context context, Map<String, String> map, NativeExceptionHandler nativeExceptionHandler) {
        String str;
        String str2;
        HashMap map2;
        if (map == null) {
            return null;
        }
        if (b.e(context) == null) {
            c.c("abnormal com info not created", new Object[0]);
            return null;
        }
        String str3 = map.get("intStateStr");
        if (str3 == null || str3.trim().length() <= 0) {
            c.c("no intStateStr", new Object[0]);
            return null;
        }
        Map<String, Integer> mapI = i(str3);
        if (mapI == null) {
            c.c("parse intSateMap fail", Integer.valueOf(map.size()));
            return null;
        }
        try {
            mapI.get("sino").intValue();
            mapI.get("sud").intValue();
            String str4 = map.get("soVersion");
            if (TextUtils.isEmpty(str4)) {
                c.c("error format at version", new Object[0]);
                return null;
            }
            String str5 = map.get("errorAddr");
            String str6 = "unknown";
            String str7 = str5 == null ? "unknown" : str5;
            String str8 = map.get("codeMsg");
            if (str8 == null) {
                str8 = "unknown";
            }
            String str9 = map.get("tombPath");
            String str10 = str9 == null ? "unknown" : str9;
            String str11 = map.get("signalName");
            if (str11 == null) {
                str11 = "unknown";
            }
            map.get("errnoMsg");
            String str12 = map.get("stack");
            if (str12 == null) {
                str12 = "unknown";
            }
            String str13 = map.get("jstack");
            if (str13 != null) {
                str12 = str12 + "java:\n" + str13;
            }
            Integer num = mapI.get("sico");
            if (num == null || num.intValue() <= 0) {
                str = str8;
                str2 = str11;
            } else {
                str2 = str11 + "(" + str8 + ")";
                str = "KERNEL";
            }
            String str14 = map.get("nativeLog");
            byte[] bArrO = (str14 == null || str14.isEmpty()) ? null : f.O(null, str14, "FireEyeNativeLog.txt");
            String str15 = map.get("sendingProcess");
            if (str15 == null) {
                str15 = "unknown";
            }
            Integer num2 = mapI.get("spd");
            if (num2 != null) {
                str15 = str15 + "(" + num2 + ")";
            }
            String str16 = str15;
            String str17 = map.get("threadName");
            if (str17 == null) {
                str17 = "unknown";
            }
            Integer num3 = mapI.get("et");
            if (num3 != null) {
                str17 = str17 + "(" + num3 + ")";
            }
            String str18 = str17;
            String str19 = map.get("processName");
            if (str19 != null) {
                str6 = str19;
            }
            Integer num4 = mapI.get("ep");
            if (num4 != null) {
                str6 = str6 + "(" + num4 + ")";
            }
            String str20 = str6;
            String str21 = map.get("key-value");
            if (str21 != null) {
                HashMap map3 = new HashMap();
                String[] strArrSplit = str21.split("\n");
                int length = strArrSplit.length;
                int i2 = 0;
                while (i2 < length) {
                    String[] strArrSplit2 = strArrSplit[i2].split(BaseConnection.HTTP_REQ_ENTITY_MERGE);
                    String[] strArr = strArrSplit;
                    if (strArrSplit2.length == 2) {
                        map3.put(strArrSplit2[0], strArrSplit2[1]);
                    }
                    i2++;
                    strArrSplit = strArr;
                }
                map2 = map3;
            } else {
                map2 = null;
            }
            CrashDetailBean crashDetailBeanPackageCrashDatas = nativeExceptionHandler.packageCrashDatas(str20, str18, (((long) mapI.get("etms").intValue()) / 1000) + (((long) mapI.get("ets").intValue()) * 1000), str2, str7, a(str12), str, str16, str10, map.get("sysLogPath"), map.get("jniLogPath"), str4, bArrO, map2, false, false);
            if (crashDetailBeanPackageCrashDatas != null) {
                String str22 = map.get("userId");
                if (str22 != null) {
                    c.b("[Native record info] userId: %s", str22);
                    crashDetailBeanPackageCrashDatas.q = str22;
                }
                String str23 = map.get("sysLog");
                if (str23 != null) {
                    crashDetailBeanPackageCrashDatas.D = str23;
                }
                String str24 = map.get("appVersion");
                if (str24 != null) {
                    c.b("[Native record info] appVersion: %s", str24);
                    crashDetailBeanPackageCrashDatas.f276i = str24;
                }
                String str25 = map.get("isAppForeground");
                if (str25 != null) {
                    c.b("[Native record info] isAppForeground: %s", str25);
                    crashDetailBeanPackageCrashDatas.V = str25.equalsIgnoreCase("true");
                }
                String str26 = map.get("launchTime");
                if (str26 != null) {
                    c.b("[Native record info] launchTime: %s", str26);
                    try {
                        crashDetailBeanPackageCrashDatas.U = Long.parseLong(str26);
                    } catch (NumberFormatException e2) {
                        if (!c.k(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                crashDetailBeanPackageCrashDatas.G = null;
                crashDetailBeanPackageCrashDatas.o = true;
            }
            return crashDetailBeanPackageCrashDatas;
        } catch (Throwable th) {
            c.c("error format", new Object[0]);
            th.printStackTrace();
            return null;
        }
    }

    public static Map<String, Integer> i(String str) {
        if (str == null) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            for (String str2 : str.split(",")) {
                String[] strArrSplit = str2.split(":");
                if (strArrSplit.length != 2) {
                    c.c("error format at %s", str2);
                    return null;
                }
                map.put(strArrSplit[0], Integer.valueOf(Integer.parseInt(strArrSplit[1])));
            }
            return map;
        } catch (Exception e2) {
            c.c("error format intStateStr %s", str);
            e2.printStackTrace();
            return null;
        }
    }

    public static String j(String str, String str2) {
        BufferedReader bufferedReaderG = f.g(str, "map_record.txt");
        if (bufferedReaderG == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReaderG.readLine();
            if (line != null && line.startsWith(str2)) {
                while (true) {
                    String line2 = bufferedReaderG.readLine();
                    if (line2 == null) {
                        break;
                    }
                    sb.append("  ");
                    sb.append(line2);
                    sb.append("\n");
                }
                return sb.toString();
            }
            if (bufferedReaderG != null) {
                try {
                    bufferedReaderG.close();
                } catch (Exception e2) {
                    c.k(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                c.k(th);
                if (bufferedReaderG != null) {
                    try {
                        bufferedReaderG.close();
                    } catch (Exception e3) {
                        c.k(e3);
                    }
                }
                return null;
            } finally {
                if (bufferedReaderG != null) {
                    try {
                        bufferedReaderG.close();
                    } catch (Exception e4) {
                        c.k(e4);
                    }
                }
            }
        }
    }

    public static String k(String str, String str2) {
        BufferedReader bufferedReaderG = f.g(str, "reg_record.txt");
        if (bufferedReaderG == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String line = bufferedReaderG.readLine();
            if (line != null && line.startsWith(str2)) {
                int i2 = 18;
                int i3 = 0;
                int length = 0;
                while (true) {
                    String line2 = bufferedReaderG.readLine();
                    if (line2 == null) {
                        break;
                    }
                    if (i3 % 4 == 0) {
                        if (i3 > 0) {
                            sb.append("\n");
                        }
                        sb.append("  ");
                    } else {
                        if (line2.length() > 16) {
                            i2 = 28;
                        }
                        sb.append("                ".substring(0, i2 - length));
                    }
                    length = line2.length();
                    sb.append(line2);
                    i3++;
                }
                sb.append("\n");
                return sb.toString();
            }
            if (bufferedReaderG != null) {
                try {
                    bufferedReaderG.close();
                } catch (Exception e2) {
                    c.k(e2);
                }
            }
            return null;
        } catch (Throwable th) {
            try {
                c.k(th);
                if (bufferedReaderG != null) {
                    try {
                        bufferedReaderG.close();
                    } catch (Exception e3) {
                        c.k(e3);
                    }
                }
                return null;
            } finally {
                if (bufferedReaderG != null) {
                    try {
                        bufferedReaderG.close();
                    } catch (Exception e4) {
                        c.k(e4);
                    }
                }
            }
        }
    }

    public static String l(BufferedInputStream bufferedInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bufferedInputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            while (true) {
                try {
                    int i2 = bufferedInputStream.read();
                    if (i2 == -1) {
                        break;
                    }
                    if (i2 == 0) {
                        String str = new String(byteArrayOutputStream.toByteArray(), "UTf-8");
                        byteArrayOutputStream.close();
                        return str;
                    }
                    byteArrayOutputStream.write(i2);
                } catch (Throwable th) {
                    th = th;
                    try {
                        c.k(th);
                        return null;
                    } finally {
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }
}
