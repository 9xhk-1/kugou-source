package com.kugou.android.watch.lite.common.image;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import com.kugou.common.config.util.FileUtil;
import e.c.a.g.a.f.i.e;
import e.c.a.g.a.f.i.f;
import e.c.a.g.a.f.i.h;
import e.c.a.g.a.f.i.i;
import e.c.a.g.a.f.i.k;
import e.c.a.g.a.s.q;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ImageManager {
    public static final Uri a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    public static final Uri b = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
    public static final String c;

    public static class ImageListParam implements Parcelable {
        public static final Parcelable.Creator CREATOR = new a();
        public int a;
        public int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f99d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f100f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Uri f101h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f102i;

        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ImageListParam createFromParcel(Parcel parcel) {
                return new ImageListParam(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ImageListParam[] newArray(int i2) {
                return new ImageListParam[i2];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return String.format("ImageListParam{loc=%s,inc=%d,sort=%d,bucket=%s,empty=%letters,single=%s}", Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.f99d), this.f100f, Boolean.valueOf(this.f102i), this.f101h);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.f99d);
            parcel.writeString(this.f100f);
            parcel.writeParcelable(this.f101h, i2);
            parcel.writeInt(this.f102i ? 1 : 0);
        }

        public ImageListParam() {
        }

        public ImageListParam(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.f99d = parcel.readInt();
            this.f100f = parcel.readString();
            this.f101h = (Uri) parcel.readParcelable(null);
            this.f102i = parcel.readInt() != 0;
        }
    }

    public static class b implements f {
        public b() {
        }

        @Override // e.c.a.g.a.f.i.f
        public void close() {
        }

        @Override // e.c.a.g.a.f.i.f
        public HashMap<String, String> getBucketIds() {
            return new HashMap<>();
        }

        @Override // e.c.a.g.a.f.i.f
        public int getCount() {
            return 0;
        }

        @Override // e.c.a.g.a.f.i.f
        public e getImageAt(int i2) {
            return null;
        }

        @Override // e.c.a.g.a.f.i.f
        public e getImageForUri(Uri uri) {
            return null;
        }

        @Override // e.c.a.g.a.f.i.f
        public int getImageIndex(e eVar) {
            throw new UnsupportedOperationException();
        }

        @Override // e.c.a.g.a.f.i.f
        public boolean isEmpty() {
            return true;
        }

        @Override // e.c.a.g.a.f.i.f
        public boolean removeImage(e eVar) {
            return false;
        }

        @Override // e.c.a.g.a.f.i.f
        public boolean removeImageAt(int i2) {
            return false;
        }
    }

    static {
        Uri.parse("content://media/external/video/media");
        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera";
        c = str;
        d(str);
    }

    public static Uri a(ContentResolver contentResolver, String str, long j, Location location, String str2, String str3, Bitmap bitmap, int i2, byte[] bArr, int[] iArr, int i3) throws Throwable {
        String str4 = str2 + "/" + str3;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str2);
                if (!aVar.exists()) {
                    aVar.mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new e.c.a.g.a.f.g.a(str2, str3));
                try {
                    if (bitmap != null) {
                        if (i3 == 2) {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream2);
                        } else {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream2);
                        }
                        iArr[0] = 0;
                    } else {
                        fileOutputStream2.write(bArr);
                        iArr[0] = e(str4);
                    }
                    q.c(fileOutputStream2);
                    return Uri.parse("file:///" + str4);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    Log.w("ImageManager", e);
                    Uri uri = Uri.EMPTY;
                    q.c(fileOutputStream);
                    return uri;
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    Log.w("ImageManager", e);
                    Uri uri2 = Uri.EMPTY;
                    q.c(fileOutputStream);
                    return uri2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    q.c(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Uri b(ContentResolver contentResolver, String str, long j, Location location, String str2, String str3, Bitmap bitmap, byte[] bArr, int[] iArr, int i2) {
        return a(contentResolver, str, j, location, str2, str3, bitmap, 75, bArr, iArr, i2);
    }

    public static boolean c() {
        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM";
        e.c.a.g.a.f.g.a aVar = new e.c.a.g.a.f.g.a(str);
        if (!aVar.isDirectory() && !aVar.mkdirs()) {
            return false;
        }
        e.c.a.g.a.f.g.a aVar2 = new e.c.a.g.a.f.g.a(str, ".probe");
        try {
            if (aVar2.exists()) {
                FileUtil.deleteFile(aVar2);
            }
            if (!aVar2.createNewFile()) {
                return false;
            }
            FileUtil.deleteFile(aVar2);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static String d(String str) {
        return String.valueOf(str.toLowerCase().hashCode());
    }

    public static int e(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e2) {
            Log.e("ImageManager", "cannot read exif", e2);
            exifInterface = null;
        }
        if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) != -1) {
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt == 8) {
                return 270;
            }
        }
        return 0;
    }

    public static ImageListParam f(int i2, int i3, int i4, String str) {
        ImageListParam imageListParam = new ImageListParam();
        imageListParam.a = i2;
        imageListParam.b = i3;
        imageListParam.f99d = i4;
        imageListParam.f100f = str;
        return imageListParam;
    }

    public static ImageListParam g(Uri uri) {
        ImageListParam imageListParam = new ImageListParam();
        imageListParam.f101h = uri;
        return imageListParam;
    }

    public static boolean h(boolean z) {
        String externalStorageState = Environment.getExternalStorageState();
        if (!"mounted".equals(externalStorageState)) {
            return !z && "mounted_ro".equals(externalStorageState);
        }
        if (z) {
            return c();
        }
        return true;
    }

    public static boolean i(String str) {
        return (str.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || str.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString())) ? false : true;
    }

    public static f j(ContentResolver contentResolver, int i2, int i3, int i4, String str) {
        return l(contentResolver, f(i2, i3, i4, str));
    }

    public static f k(ContentResolver contentResolver, Uri uri, int i2) {
        String string = uri != null ? uri.toString() : "";
        return string.startsWith("content://drm") ? j(contentResolver, 4, 2, i2, null) : string.startsWith("content://media/external/video") ? j(contentResolver, 3, 4, i2, null) : i(string) ? m(contentResolver, uri) : j(contentResolver, 4, 1, i2, uri.getQueryParameter("bucketId"));
    }

    public static f l(ContentResolver contentResolver, ImageListParam imageListParam) {
        int i2 = imageListParam.a;
        int i3 = imageListParam.b;
        int i4 = imageListParam.f99d;
        String str = imageListParam.f100f;
        Uri uri = imageListParam.f101h;
        if (imageListParam.f102i || contentResolver == null) {
            return new b();
        }
        if (uri != null) {
            return new k(contentResolver, uri);
        }
        boolean zH = h(false);
        ArrayList arrayList = new ArrayList();
        if (zH && i2 != 2 && (i3 & 1) != 0) {
            arrayList.add(new h(contentResolver, a, b, i4, str));
        }
        if ((i2 == 2 || i2 == 4) && (i3 & 1) != 0) {
            arrayList.add(new h(contentResolver, MediaStore.Images.Media.INTERNAL_CONTENT_URI, MediaStore.Images.Thumbnails.INTERNAL_CONTENT_URI, i4, str));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e.c.a.g.a.f.i.b bVar = (e.c.a.g.a.f.i.b) it.next();
            if (bVar.isEmpty()) {
                bVar.close();
                it.remove();
            }
        }
        return arrayList.size() == 1 ? (e.c.a.g.a.f.i.b) arrayList.get(0) : new i((f[]) arrayList.toArray(new f[arrayList.size()]), i4);
    }

    public static f m(ContentResolver contentResolver, Uri uri) {
        return l(contentResolver, g(uri));
    }
}
