package e.c.a.g.a.s;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static int b(BitmapFactory.Options options, int i2, int i3) {
        int iCeil;
        int iMin;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        if (i3 == -1) {
            iCeil = 1;
        } else {
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = i3;
            Double.isNaN(d4);
            iCeil = (int) Math.ceil(Math.sqrt((d2 * d3) / d4));
        }
        if (i2 == -1) {
            iMin = 128;
        } else {
            double d5 = i2;
            Double.isNaN(d2);
            Double.isNaN(d5);
            double dFloor = Math.floor(d2 / d5);
            Double.isNaN(d3);
            Double.isNaN(d5);
            iMin = (int) Math.min(dFloor, Math.floor(d3 / d5));
        }
        if (iMin < iCeil) {
            return iCeil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? iCeil : iMin;
    }

    public static int c(BitmapFactory.Options options, int i2, int i3) {
        int iB = b(options, i2, i3);
        if (iB > 8) {
            return ((iB + 7) / 8) * 8;
        }
        int i4 = 1;
        while (i4 < iB) {
            i4 <<= 1;
        }
        return i4;
    }

    public static Bitmap d(int i2, int i3, Bitmap.Config config) {
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        } catch (Exception | OutOfMemoryError unused) {
        } catch (OutOfMemoryError unused2) {
            System.gc();
            bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, config);
        }
        return bitmapCreateBitmap == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8) : bitmapCreateBitmap;
    }

    public static Bitmap e(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        Bitmap bitmapCreateBitmap = null;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
            } catch (Exception | OutOfMemoryError unused) {
            } catch (OutOfMemoryError unused2) {
                System.gc();
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i2, i3, i4, i5);
            }
        }
        return bitmapCreateBitmap == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8) : bitmapCreateBitmap;
    }

    public static Bitmap f(Bitmap bitmap, int i2, int i3, int i4, int i5, Matrix matrix, boolean z) {
        Bitmap bitmapCreateBitmap = null;
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, i4, i5, matrix, true);
            } catch (Exception e2) {
                if (g0.a) {
                    g0.h("torahlog", e2);
                }
            } catch (OutOfMemoryError e3) {
                if (g0.a) {
                    g0.h("torahlog", e3);
                }
                System.gc();
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, i4, i5, matrix, true);
                } catch (OutOfMemoryError e4) {
                    if (g0.a) {
                        g0.h("torahlog", e4);
                    }
                }
            }
        }
        return bitmapCreateBitmap == null ? Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8) : bitmapCreateBitmap;
    }

    public static BitmapFactory.Options g() {
        return new BitmapFactory.Options();
    }

    public static Bitmap h(Bitmap bitmap, int i2, boolean z) {
        if (bitmap == null) {
            return null;
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int i3 = 0;
        loop0: for (int i4 = 0; i4 < height; i4++) {
            for (int i5 = 0; i5 < width; i5++) {
                if (bitmap.getPixel(i4, i5) == i2) {
                    break loop0;
                }
            }
            i3++;
        }
        int i6 = height - 1;
        int i7 = i6;
        loop2: while (i6 >= 0) {
            for (int i8 = 0; i8 < width; i8++) {
                if (bitmap.getPixel(i6, i8) == i2) {
                    break loop2;
                }
            }
            i7--;
            i6--;
        }
        int i9 = 0;
        loop4: for (int i10 = 0; i10 < width; i10++) {
            for (int i11 = 0; i11 < height; i11++) {
                if (bitmap.getPixel(i11, i10) == i2) {
                    break loop4;
                }
            }
            i9++;
        }
        int i12 = width - 1;
        int i13 = i12;
        loop6: while (i12 >= 0) {
            for (int i14 = 0; i14 < height; i14++) {
                if (bitmap.getPixel(i14, i12) == i2) {
                    break loop6;
                }
            }
            i13--;
            i12--;
        }
        return z ? Bitmap.createBitmap(bitmap, i9 / 2, i3 / 2, i13 + 1, i7 + 1) : Bitmap.createBitmap(bitmap, i9, i3, (i13 - i9) + 1, (i7 - i3) + 1);
    }

    public static Bitmap i(String str) {
        return j(str, false);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.FileInputStream, java.io.InputStream] */
    public static Bitmap j(String str, boolean z) {
        FileInputStream fileInputStreamW;
        ?? F = q.F(str);
        Bitmap bitmapL = null;
        try {
            try {
                if (F != 0) {
                    try {
                        fileInputStreamW = q.w(str);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStreamW = null;
                    }
                    try {
                        bitmapL = l(fileInputStreamW);
                        if (fileInputStreamW != null) {
                            fileInputStreamW.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStreamW != null) {
                            fileInputStreamW.close();
                        }
                        throw th;
                    }
                }
            } catch (OutOfMemoryError unused) {
                System.gc();
                try {
                    F = q.w(str);
                    bitmapL = l(F);
                    if (F != 0) {
                        F.close();
                    }
                } catch (Throwable th3) {
                    if (F != 0) {
                        F.close();
                    }
                    throw th3;
                }
            }
        } catch (Exception | OutOfMemoryError unused2) {
        }
        if (bitmapL != null || z) {
            return bitmapL;
        }
        try {
            return d(1, 1, Bitmap.Config.ALPHA_8);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return bitmapL;
        }
    }

    public static Bitmap k(String str, int i2) {
        if (i2 <= 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i4) {
            i3 = i4;
        }
        if (i3 > i2) {
            options.inSampleSize = (int) Math.floor(i3 / i2);
        } else {
            options.inSampleSize = 1;
        }
        options.inJustDecodeBounds = false;
        if (g0.a) {
            g0.e("ImageUploadUtil", String.format("decodeSampledBitmapFromFile 缩小倍数:%s", Integer.valueOf(options.inSampleSize)));
        }
        return v(BitmapFactory.decodeFile(str, options), t(str));
    }

    public static Bitmap l(InputStream inputStream) {
        Bitmap bitmapDecodeStream = null;
        if (inputStream != null) {
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            } catch (Exception | OutOfMemoryError unused) {
            } catch (OutOfMemoryError unused2) {
                System.gc();
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
            }
        }
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        try {
            return d(1, 1, Bitmap.Config.ALPHA_8);
        } catch (Exception | OutOfMemoryError unused3) {
            return bitmapDecodeStream;
        } catch (OutOfMemoryError unused4) {
            System.gc();
            return d(1, 1, Bitmap.Config.ALPHA_8);
        }
    }

    public static Bitmap m(Bitmap bitmap, double d2) {
        return n(bitmap, d2, Bitmap.CompressFormat.JPEG);
    }

    public static Bitmap n(Bitmap bitmap, double d2, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        double length = byteArrayOutputStream.toByteArray().length / 1024;
        if (length <= d2) {
            return bitmap;
        }
        Double.isNaN(length);
        double d3 = length / d2;
        double height = bitmap.getHeight();
        double dSqrt = Math.sqrt(d3);
        Double.isNaN(height);
        double d4 = height / dSqrt;
        double width = bitmap.getWidth();
        double dSqrt2 = Math.sqrt(d3);
        Double.isNaN(width);
        double d5 = width / dSqrt2;
        double d6 = 2.0d * d5;
        if (d4 > d6) {
            d4 = d6;
        }
        return z(bitmap, d5, d4);
    }

    public static Bitmap o(int i2, int i3, ContentResolver contentResolver, ParcelFileDescriptor parcelFileDescriptor, boolean z) {
        return p(i2, i3, null, contentResolver, parcelFileDescriptor, z ? g() : null);
    }

    public static Bitmap p(int i2, int i3, Uri uri, ContentResolver contentResolver, ParcelFileDescriptor parcelFileDescriptor, BitmapFactory.Options options) {
        if (parcelFileDescriptor == null) {
            try {
                parcelFileDescriptor = r(uri, contentResolver);
            } catch (OutOfMemoryError e2) {
                Log.e("BitmapUtils", "Got oom exception ", e2);
                return null;
            } finally {
                a(parcelFileDescriptor);
            }
        }
        if (parcelFileDescriptor == null) {
            return null;
        }
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        options.inJustDecodeBounds = true;
        Bitmap bitmapB = e.c.a.g.a.f.i.c.d().b(fileDescriptor, options);
        if (bitmapB != null) {
            bitmapB.recycle();
        }
        if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
            options.inSampleSize = c(options, i2, i3);
            options.inJustDecodeBounds = false;
            options.inDither = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return e.c.a.g.a.f.i.c.d().b(fileDescriptor, options);
        }
        return null;
    }

    public static Bitmap q(int i2, int i3, Uri uri, ContentResolver contentResolver, boolean z) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        BitmapFactory.Options optionsG;
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(uri, "r");
            if (z) {
                try {
                    optionsG = g();
                } catch (IOException unused) {
                    a(parcelFileDescriptorOpenFileDescriptor);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    a(parcelFileDescriptor);
                    throw th;
                }
            } else {
                optionsG = null;
            }
            Bitmap bitmapP = p(i2, i3, uri, contentResolver, parcelFileDescriptorOpenFileDescriptor, optionsG);
            a(parcelFileDescriptorOpenFileDescriptor);
            return bitmapP;
        } catch (IOException unused2) {
            parcelFileDescriptorOpenFileDescriptor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static ParcelFileDescriptor r(Uri uri, ContentResolver contentResolver) {
        try {
            return contentResolver.openFileDescriptor(uri, "r");
        } catch (IOException unused) {
            return null;
        }
    }

    public static Bitmap s(String str) {
        if (TextUtils.isEmpty(str) || !q.F(str)) {
            return null;
        }
        return i(str);
    }

    public static int t(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Bitmap u(Bitmap bitmap, int i2) {
        if (i2 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i2, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap bitmapF = f(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapF) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapF;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap v(Bitmap bitmap, int i2) {
        if (i2 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i2, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static boolean w(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return x(bitmap, str, compressFormat, 80);
    }

    public static boolean x(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i2) throws Throwable {
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

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap y(android.graphics.Matrix r14, android.graphics.Bitmap r15, int r16, int r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.s.f.y(android.graphics.Matrix, android.graphics.Bitmap, int, int, boolean, boolean):android.graphics.Bitmap");
    }

    public static Bitmap z(Bitmap bitmap, double d2, double d3) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) d2) / width, ((float) d3) / height);
        return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, true);
    }
}
