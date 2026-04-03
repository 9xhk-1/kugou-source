package e.c.a.g.a.f.i;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class l implements e {
    public final Uri a;
    public final f b;
    public final ContentResolver c;

    public l(f fVar, ContentResolver contentResolver, Uri uri) {
        this.b = fVar;
        this.c = contentResolver;
        this.a = uri;
    }

    public Bitmap a(int i2, int i3, boolean z) {
        return fullSizeBitmap(i2, i3, z, false);
    }

    public final InputStream b() {
        try {
            return this.a.getScheme().equals("file") ? new FileInputStream(this.a.getPath()) : this.c.openInputStream(this.a);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public final ParcelFileDescriptor c() {
        try {
            return this.a.getScheme().equals("file") ? ParcelFileDescriptor.open(new e.c.a.g.a.f.g.a(this.a.getPath()), 268435456) : this.c.openFileDescriptor(this.a, "r");
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public final BitmapFactory.Options d() {
        ParcelFileDescriptor parcelFileDescriptorC = c();
        if (parcelFileDescriptorC == null) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Bitmap bitmapB = c.d().b(parcelFileDescriptorC.getFileDescriptor(), options);
            if (bitmapB != null) {
                bitmapB.recycle();
            }
            return options;
        } finally {
            e.c.a.g.a.s.f.a(parcelFileDescriptorC);
        }
    }

    @Override // e.c.a.g.a.f.i.e
    public Bitmap fullSizeBitmap(int i2, int i3) {
        return fullSizeBitmap(i2, i3, true, false);
    }

    @Override // e.c.a.g.a.f.i.e
    public InputStream fullSizeImageData() {
        return b();
    }

    @Override // e.c.a.g.a.f.i.e
    public long fullSizeImageId() {
        return 0L;
    }

    @Override // e.c.a.g.a.f.i.e
    public Uri fullSizeImageUri() {
        return this.a;
    }

    @Override // e.c.a.g.a.f.i.e
    public f getContainer() {
        return this.b;
    }

    @Override // e.c.a.g.a.f.i.e
    public String getDataPath() {
        return this.a.getPath();
    }

    @Override // e.c.a.g.a.f.i.e
    public long getDateTaken() {
        return 0L;
    }

    @Override // e.c.a.g.a.f.i.e
    public int getDegreesRotated() {
        return 0;
    }

    @Override // e.c.a.g.a.f.i.e
    public String getDisplayName() {
        return getTitle();
    }

    @Override // e.c.a.g.a.f.i.e
    public int getHeight() {
        BitmapFactory.Options optionsD = d();
        if (optionsD != null) {
            return optionsD.outHeight;
        }
        return 0;
    }

    @Override // e.c.a.g.a.f.i.e
    public String getMimeType() {
        String str;
        BitmapFactory.Options optionsD = d();
        return (optionsD == null || (str = optionsD.outMimeType) == null) ? "" : str;
    }

    @Override // e.c.a.g.a.f.i.e
    public String getTitle() {
        return this.a.toString();
    }

    @Override // e.c.a.g.a.f.i.e
    public int getWidth() {
        BitmapFactory.Options optionsD = d();
        if (optionsD != null) {
            return optionsD.outWidth;
        }
        return 0;
    }

    @Override // e.c.a.g.a.f.i.e
    public boolean isDrm() {
        return false;
    }

    @Override // e.c.a.g.a.f.i.e
    public boolean isReadonly() {
        return true;
    }

    @Override // e.c.a.g.a.f.i.e
    public Bitmap miniThumbBitmap() {
        return thumbBitmap(true);
    }

    @Override // e.c.a.g.a.f.i.e
    public boolean rotateImageBy(int i2) {
        return false;
    }

    @Override // e.c.a.g.a.f.i.e
    public Bitmap thumbBitmap(boolean z) {
        return a(ShareCloudFileResource.WIDTH, 196608, z);
    }

    @Override // e.c.a.g.a.f.i.e
    public Bitmap fullSizeBitmap(int i2, int i3, boolean z, boolean z2) {
        try {
            return e.c.a.g.a.s.f.o(i2, i3, this.c, c(), z2);
        } catch (Exception e2) {
            Log.e("UriImage", "got exception decoding bitmap ", e2);
            return null;
        }
    }
}
