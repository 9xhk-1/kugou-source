package e.c.b.b;

import e.c.a.g.a.s.g0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public void a(ZipOutputStream zipOutputStream, File file, String str) throws Exception {
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
            String str2 = str.length() == 0 ? "" : str + "/";
            for (int i2 = 0; i2 < fileArrListFiles.length; i2++) {
                a(zipOutputStream, fileArrListFiles[i2], str2 + fileArrListFiles[i2].getName());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[65536];
                while (true) {
                    int i3 = fileInputStream2.read(bArr);
                    if (i3 == -1) {
                        fileInputStream2.close();
                        return;
                    }
                    zipOutputStream.write(bArr, 0, i3);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean b(String str, File file) throws Throwable {
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
                try {
                    a(zipOutputStream2, file, "");
                    try {
                        zipOutputStream2.close();
                    } catch (IOException e2) {
                        g0.k(e2);
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    zipOutputStream = zipOutputStream2;
                    g0.k(e);
                    if (zipOutputStream == null) {
                        return false;
                    }
                    try {
                        zipOutputStream.close();
                        return false;
                    } catch (IOException e4) {
                        g0.k(e4);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    zipOutputStream = zipOutputStream2;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e5) {
                            g0.k(e5);
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void c(String str, String str2) throws Throwable {
        b(str2, new e.c.a.g.a.f.g.a(str));
    }
}
