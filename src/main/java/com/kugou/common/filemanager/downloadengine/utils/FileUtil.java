package com.kugou.common.filemanager.downloadengine.utils;

import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.NetLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    public static String BUFFER_EXT = ".kgtmp";
    public static String ENCRYPT_BUFFER_EXT = ".kge";
    public static String ENCRYPT_DOWNLOAD_EXT = ".kgm";
    public static final int ENCRYPT_FILE_HEAD_SIZE = 1024;
    public static final byte[] ENCRYPT_HEAD = {124, -43, 50, -21, -122, 2, 127, 75, -88, -81, -90, -114, 15, -1, -103, 20};
    public static String LOSSLESS_ENCRYPT_DOWNLOAD_EXT = ".kgma";
    public static String SHORT_BUFFER_EXT = ".kgt";

    public static boolean bytesEquals(byte[] bArr, byte[] bArr2) {
        int length = bArr == null ? 0 : bArr.length;
        int length2 = bArr2 == null ? 0 : bArr2.length;
        if (length != length2) {
            return false;
        }
        if (length == 0 && length2 == 0) {
            return true;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean createDirectory(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
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

    public static boolean deleteFile(File file) {
        if (file != null) {
            return file.delete();
        }
        return false;
    }

    public static boolean fileIsExist(String str) {
        if (str != null && str.length() >= 1) {
            return new File(str).exists();
        }
        if (NetLog.isDebug()) {
            NetLog.e("param invalid, filePath: " + str);
        }
        return false;
    }

    public static long getEncryptFileSizeByExt(File file) {
        long length = file.length();
        if (!isEncryptPath(file.getPath())) {
            return length;
        }
        if (length > 1024) {
            return length - 1024;
        }
        return 0L;
    }

    public static String getExtName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? "" : str.substring(iLastIndexOf, str.length());
    }

    public static boolean isEncryptPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(ENCRYPT_BUFFER_EXT) || str.endsWith(ENCRYPT_DOWNLOAD_EXT) || str.endsWith(LOSSLESS_ENCRYPT_DOWNLOAD_EXT);
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

    public static boolean isNotTempCachePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !isTempCachePath(str);
    }

    public static boolean isRealEncryptedFile(String str) throws Throwable {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[16];
                if (fileInputStream2.read(bArr) == 16) {
                    if (bytesEquals(bArr, ENCRYPT_HEAD)) {
                        z = true;
                    }
                }
                try {
                    fileInputStream2.close();
                } catch (Exception unused) {
                }
                return z;
            } catch (FileNotFoundException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return false;
            } catch (IOException unused4) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused5) {
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused7) {
        } catch (IOException unused8) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isTempCachePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.endsWith(BUFFER_EXT) || str.endsWith(SHORT_BUFFER_EXT) || str.endsWith(ENCRYPT_BUFFER_EXT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.BufferedInputStream] */
    public static boolean moveFile(String str, String str2) throws Throwable {
        Throwable th;
        Exception e2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (!file.isDirectory() && file.exists()) {
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        File file2 = new File(str2);
                        if (!file2.exists()) {
                            createParentIfNecessary(str2);
                            file2.createNewFile();
                        }
                        str2 = new BufferedInputStream(new FileInputStream(file));
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i2 = str2.read(bArr);
                                    if (i2 == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, i2);
                                }
                                fileOutputStream2.flush();
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                                try {
                                    str2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                return true;
                            } catch (Exception e5) {
                                e2 = e5;
                                fileOutputStream = fileOutputStream2;
                                e2.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (str2 != 0) {
                                    try {
                                        str2.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                        e8.printStackTrace();
                                    }
                                }
                                if (str2 == 0) {
                                    throw th;
                                }
                                try {
                                    str2.close();
                                    throw th;
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                    throw th;
                                }
                            }
                        } catch (Exception e10) {
                            e2 = e10;
                        }
                    } catch (Exception e11) {
                        e2 = e11;
                        str2 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = 0;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        return false;
    }

    public static boolean rename(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.renameTo(new File(str2));
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
