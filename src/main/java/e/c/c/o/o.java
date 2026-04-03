package e.c.c.o;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(ZipOutputStream zipOutputStream, File file, String str) throws Exception {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
            String str2 = str.length() == 0 ? "" : str + "/";
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                b(zipOutputStream, fileArrListFiles[i2], str2 + fileArrListFiles[i2].getName());
            }
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            zipOutputStream.putNextEntry(new ZipEntry(str));
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[65536];
                while (true) {
                    int i3 = fileInputStream2.read(bArr);
                    if (i3 == -1) {
                        a(fileInputStream2);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, i3);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                a(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(String str, File file) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
                try {
                    b(zipOutputStream2, file, "");
                    a(zipOutputStream2);
                    return true;
                } catch (Exception e2) {
                    e = e2;
                    zipOutputStream = zipOutputStream2;
                    e.printStackTrace();
                    a(zipOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = zipOutputStream2;
                    a(zipOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void d(String str, String str2) throws Throwable {
        c(str2, new File(str));
    }
}
