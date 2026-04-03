package e.c.a.g.a.r.f;

import android.graphics.Bitmap;
import e.c.a.g.a.s.f;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final String a = "b";

    public static String a(String str, int i2, int i3, int i4) throws Throwable {
        Bitmap bitmapK = f.k(str, i3);
        if (bitmapK == null) {
            return null;
        }
        String strB = b();
        boolean zE = e(bitmapK, strB, i4);
        if (g0.a) {
            g0.e(a, String.format("第一次压缩 压缩比率:%s 压缩后大小(byte):%s", Integer.valueOf(i4), Integer.valueOf(q.y(strB))));
        }
        if (zE && d(strB, i2)) {
            return strB;
        }
        boolean zE2 = e(f.m(bitmapK, i2 / 1024), strB, i4);
        if (g0.a) {
            g0.e(a, String.format("第二次压缩 压缩比率:%s 压缩后大小(byte):%s", Integer.valueOf(i4), Integer.valueOf(q.y(strB))));
        }
        if (zE2) {
            return strB;
        }
        return null;
    }

    public static String b() {
        return e.c.a.g.a.f.f.a.f651g + System.currentTimeMillis() + ".jpg";
    }

    public static String c(String str, int i2, int i3, int i4) {
        if (g0.a) {
            g0.e(a, String.format("上传图片 文件路径:%s 最大限制(byte):%s 最大宽度(像素):%s 压缩比率:%s", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        if (!d(str, i2)) {
            if (g0.a) {
                g0.e(a, String.format("图片超出最大限制 文件大小(byte):%s, 需要进一步压缩", Integer.valueOf(q.y(str))));
            }
            return a(str, i2, i3, i4);
        }
        if (!g0.a) {
            return null;
        }
        g0.e(a, String.format("图片未超出最大限制 文件大小(byte):%s", Integer.valueOf(q.y(str))));
        return null;
    }

    public static boolean d(String str, int i2) {
        File file = new File(str);
        return file.exists() && file.isFile() && file.length() <= ((long) i2);
    }

    public static boolean e(Bitmap bitmap, String str, int i2) throws Throwable {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(q.h(str));
                try {
                    boolean zCompress = bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                        return zCompress;
                    } catch (IOException e2) {
                        g0.k(e2);
                        return zCompress;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    g0.k(e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            g0.k(e4);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                            g0.k(e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }
}
