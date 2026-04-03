package com.kugou.framework.musichunter;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    public static final int MODE_COVER = 1;
    public static final int MODE_UNCOVER = 0;

    public static boolean appendData(String str, byte[] bArr) {
        try {
            File file = new File(str);
            if (file.exists()) {
                createParentIfNecessary(str);
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean createFile(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } else if (i2 == 1) {
                file.delete();
                file.createNewFile();
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void createParentIfNecessary(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static byte[] getFileData(String str) {
        byte[] bArr = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            bArr = new byte[(int) file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
            return bArr;
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr;
        }
    }

    public static boolean isExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }
}
