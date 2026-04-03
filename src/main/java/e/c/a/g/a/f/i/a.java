package e.c.a.g.a.f.i;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements e {
    public ContentResolver a;
    public Uri b;
    public long c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f660i;
    public b j;
    public int k = -1;
    public int l = -1;

    public a(b bVar, ContentResolver contentResolver, long j, int i2, Uri uri, String str, long j2, String str2, long j3, String str3, String str4) {
        this.j = bVar;
        this.a = contentResolver;
        this.c = j;
        this.f656e = i2;
        this.b = uri;
        this.f655d = str;
        this.f657f = str2;
        this.f658g = j3;
        this.f659h = str3;
        this.f660i = str4;
    }

    public void a() {
    }

    public final void b() {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = null;
        try {
            try {
                parcelFileDescriptorOpenFileDescriptor = this.a.openFileDescriptor(this.b, "r");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                Bitmap bitmapB = c.d().b(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor(), options);
                if (bitmapB != null) {
                    bitmapB.recycle();
                }
                this.k = options.outWidth;
                this.l = options.outHeight;
            } catch (FileNotFoundException unused) {
                this.k = 0;
                this.l = 0;
            }
        } finally {
            e.c.a.g.a.s.f.a(parcelFileDescriptorOpenFileDescriptor);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        return this.b.equals(((g) obj).b);
    }

    @Override // e.c.a.g.a.f.i.e
    public Bitmap fullSizeBitmap(int i2, int i3) {
        return fullSizeBitmap(i2, i3, true, false);
    }

    @Override // e.c.a.g.a.f.i.e
    public InputStream fullSizeImageData() {
        try {
            return this.a.openInputStream(this.b);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // e.c.a.g.a.f.i.e
    public long fullSizeImageId() {
        return this.c;
    }

    @Override // e.c.a.g.a.f.i.e
    public Uri fullSizeImageUri() {
        return this.b;
    }

    @Override // e.c.a.g.a.f.i.e
    public f getContainer() {
        return this.j;
    }

    @Override // e.c.a.g.a.f.i.e
    public String getDataPath() {
        return this.f655d;
    }

    @Override // e.c.a.g.a.f.i.e
    public long getDateTaken() {
        return this.f658g;
    }

    @Override // e.c.a.g.a.f.i.e
    public int getDegreesRotated() {
        return 0;
    }

    @Override // e.c.a.g.a.f.i.e
    public String getDisplayName() {
        return this.f660i;
    }

    @Override // e.c.a.g.a.f.i.e
    public int getHeight() {
        if (this.l == -1) {
            b();
        }
        return this.l;
    }

    @Override // e.c.a.g.a.f.i.e
    public String getMimeType() {
        return this.f657f;
    }

    @Override // e.c.a.g.a.f.i.e
    public String getTitle() {
        return this.f659h;
    }

    @Override // e.c.a.g.a.f.i.e
    public int getWidth() {
        if (this.k == -1) {
            b();
        }
        return this.k;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // e.c.a.g.a.f.i.e
    public Bitmap miniThumbBitmap() {
        try {
            Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(this.a, this.c, 3, null);
            return thumbnail != null ? e.c.a.g.a.s.f.u(thumbnail, getDegreesRotated()) : thumbnail;
        } catch (Throwable th) {
            Log.e("BaseImage", "miniThumbBitmap got exception", th);
            return null;
        }
    }

    public String toString() {
        return this.b.toString();
    }

    @Override // e.c.a.g.a.f.i.e
    public Bitmap fullSizeBitmap(int i2, int i3, boolean z, boolean z2) throws Throwable {
        Uri uriA = this.j.a(this.c);
        if (uriA == null) {
            return null;
        }
        Bitmap bitmapQ = e.c.a.g.a.s.f.q(i2, i3, uriA, this.a, z2);
        return (bitmapQ == null || !z) ? bitmapQ : e.c.a.g.a.s.f.u(bitmapQ, getDegreesRotated());
    }
}
