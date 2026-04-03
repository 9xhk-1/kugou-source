package e.c.a.g.a.s;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.network.ExceptionParse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {
    @Nullable
    public static Bitmap a(String str) {
        int iMin = Math.min(l1.d(KGApplication.getContext(), 160.0f), (int) (l1.z(r0) * 0.8f));
        return b(str, iMin, iMin, -16777216, -1);
    }

    @Nullable
    public static Bitmap b(String str, int i2, int i3, int i4, int i5) {
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.MARGIN, 1);
            BitMatrix bitMatrixEncode = new QRCodeWriter().encode(str, 12, i2, i3, hashtable);
            int[] iArr = new int[i2 * i3];
            for (int i6 = 0; i6 < i3; i6++) {
                for (int i7 = 0; i7 < i2; i7++) {
                    if (bitMatrixEncode.get(i7, i6)) {
                        iArr[(i6 * i2) + i7] = i4;
                    } else {
                        iArr[(i6 * i2) + i7] = i5;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.RGB_565);
            bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i2);
            return bitmapCreateBitmap;
        } catch (WriterException e2) {
            g0.k(e2);
            return null;
        }
    }

    public static String c(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceAll("imge.kugou.com/kugouicon/[0-9]{1,3}/", "imge.kugou.com/kugouicon/60/");
    }

    public static String d(String str) {
        if (str == null || !str.contains("{size}")) {
            return str;
        }
        return str.replace("{size}", m.m() ? ExceptionParse.NET_URL_PROTOCOL_ERROR : "120");
    }

    public static String e(String str) {
        if (str == null || !str.contains("{size}")) {
            return str;
        }
        return str.replace("{size}", m.m() ? "240" : "400");
    }

    public static boolean f(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return g(bitmap, str, compressFormat, 80);
    }

    public static boolean g(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) throws Throwable {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 50) {
            i2 = 50;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
                if (!aVar.exists()) {
                    e.c.a.g.a.f.g.a aVar2 = new e.c.a.g.a.f.g.a(aVar.getParent());
                    if (!aVar2.exists()) {
                        aVar2.mkdirs();
                    }
                    aVar.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(aVar);
                try {
                    bitmap.compress(compressFormat, i2, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
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
                            e5.printStackTrace();
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

    public static boolean h(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) throws Throwable {
        if (bitmap == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (i2 > 100) {
            i2 = 100;
        } else if (i2 < 0) {
            i2 = 10;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
                if (!aVar.exists()) {
                    e.c.a.g.a.f.g.a aVar2 = new e.c.a.g.a.f.g.a(aVar.getParent());
                    if (!aVar2.exists()) {
                        aVar2.mkdirs();
                    }
                    aVar.createNewFile();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(aVar);
                try {
                    bitmap.compress(compressFormat, i2, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
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
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }
}
