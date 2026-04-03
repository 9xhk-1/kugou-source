package com.kugou.framework.bilib.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class SystemUtils {
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void deleteFile(String str) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    deleteFile(file2.getAbsolutePath());
                }
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    public static String getMid(Context context) {
        return LibConfig.getInstance().getMid(context);
    }

    public static int[] getScreenSize() {
        DisplayMetrics displayMetrics = LibConfig.getContext().getApplicationContext().getResources().getDisplayMetrics();
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static String getSysModel() {
        return Build.MODEL;
    }

    public static String getSystemSDK() {
        return "Android" + Build.VERSION.RELEASE.replace(".", "");
    }

    public static boolean isWifi(Context context) {
        return true;
    }

    public static String readFile(String str) {
        String str2 = null;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.createNewFile();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            String str3 = new String(bArr, "UTF-8");
            try {
                fileInputStream.close();
                return str3;
            } catch (IOException e2) {
                e = e2;
                str2 = str3;
                e.printStackTrace();
                return str2;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    public static void writeFile(String str, String str2) {
        if (str == null) {
            return;
        }
        try {
            FileWriter fileWriter = new FileWriter(str);
            fileWriter.write(str2);
            fileWriter.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
