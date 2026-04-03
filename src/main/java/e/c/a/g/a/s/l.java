package e.c.a.g.a.s;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import androidx.appcompat.widget.ActivityChooserModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static final FileFilter a = new a();

    public class a implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i2 = 3; i2 < name.length(); i2++) {
                if (!Character.isDigit(name.charAt(i2))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static int a(byte[] bArr, int i2) {
        while (i2 < bArr.length && bArr[i2] != 10) {
            if (Character.isDigit(bArr[i2])) {
                int i3 = i2 + 1;
                while (i3 < bArr.length && Character.isDigit(bArr[i3])) {
                    i3++;
                }
                return Integer.parseInt(new String(bArr, 0, i2, i3 - i2));
            }
            i2++;
        }
        return -1;
    }

    public static long b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long c() {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return ((blockSize * availableBlocks) / 1024) / 1024;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static int d() {
        int iIntValue = -1;
        for (int i2 = 0; i2 < g(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (Character.isDigit(bArr[i3]) && i3 < 128) {
                            i3++;
                        }
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (numValueOf.intValue() > iIntValue) {
                            iIntValue = numValueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (iIntValue == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int i4 = i("cpu MHz", fileInputStream2) * 1000;
                if (i4 > iIntValue) {
                    iIntValue = i4;
                }
                fileInputStream2.close();
            } catch (Throwable th2) {
                fileInputStream2.close();
                throw th2;
            }
        }
        return iIntValue;
    }

    public static int e(String str) throws Throwable {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                int iF = f(line);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return iF;
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int f(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    public static int g() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int iE = e("/sys/devices/system/cpu/possible");
            if (iE == -1) {
                iE = e("/sys/devices/system/cpu/present");
            }
            if (iE == -1) {
                iE = new File("/sys/devices/system/cpu/").listFiles(a).length;
            }
            return iE;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    @TargetApi(16)
    public static long h(Context context) {
        long j;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        ?? I = -1;
        I = -1;
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
            try {
                I = i("MemTotal", fileInputStream);
                long j2 = ((long) I) * 1024;
                fileInputStream.close();
                j = j2;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            j = I;
        }
        return j;
    }

    public static int i(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int i2 = fileInputStream.read(bArr);
            int i3 = 0;
            while (i3 < i2) {
                if (bArr[i3] == 10 || i3 == 0) {
                    if (bArr[i3] == 10) {
                        i3++;
                    }
                    for (int i4 = i3; i4 < i2; i4++) {
                        int i5 = i4 - i3;
                        if (bArr[i4] != str.charAt(i5)) {
                            break;
                        }
                        if (i5 == str.length() - 1) {
                            return a(bArr, i4);
                        }
                    }
                }
                i3++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }
}
