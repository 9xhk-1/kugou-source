package e.c.a.g.a.f.i;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class g extends a implements e {
    public ExifInterface m;
    public int n;

    public g(b bVar, ContentResolver contentResolver, long j, int i2, Uri uri, String str, long j2, String str2, long j3, String str3, String str4, int i3) {
        super(bVar, contentResolver, j, i2, uri, str, j2, str2, j3, str3, str4);
        this.n = i3;
    }

    public final void c() {
        try {
            this.m = new ExifInterface(this.f655d);
        } catch (IOException e2) {
            Log.e("BaseImage", "cannot read exif", e2);
        }
    }

    public void d(String str, String str2) {
        if (this.m == null) {
            c();
        }
        this.m.setAttribute(str, str2);
    }

    public final void e() throws IOException {
        ExifInterface exifInterface = this.m;
        if (exifInterface != null) {
            exifInterface.saveAttributes();
        }
    }

    public void f(int i2) {
        if (this.n == i2) {
            return;
        }
        this.n = i2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("orientation", Integer.valueOf(this.n));
        this.a.update(this.b, contentValues, null, null);
    }

    public final void g(int i2) {
        try {
            int i3 = i2 % ShareCloudFileResource.HEIGHT;
            if (i3 < 0) {
                i3 += ShareCloudFileResource.HEIGHT;
            }
            int i4 = 1;
            if (i3 != 0) {
                if (i3 == 90) {
                    i4 = 6;
                } else if (i3 == 180) {
                    i4 = 3;
                } else if (i3 == 270) {
                    i4 = 8;
                }
            }
            d(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, Integer.toString(i4));
            e();
        } catch (Exception e2) {
            Log.e("BaseImage", "unable to save exif data with new orientation " + fullSizeImageUri(), e2);
        }
    }

    @Override // e.c.a.g.a.f.i.a, e.c.a.g.a.f.i.e
    public int getDegreesRotated() {
        return this.n;
    }

    @Override // e.c.a.g.a.f.i.e
    public boolean isDrm() {
        return false;
    }

    @Override // e.c.a.g.a.f.i.e
    public boolean isReadonly() {
        String mimeType = getMimeType();
        return ("image/jpeg".equals(mimeType) || "image/png".equals(mimeType)) ? false : true;
    }

    @Override // e.c.a.g.a.f.i.e
    public boolean rotateImageBy(int i2) {
        int degreesRotated = (getDegreesRotated() + i2) % ShareCloudFileResource.HEIGHT;
        g(degreesRotated);
        f(degreesRotated);
        return true;
    }

    @Override // e.c.a.g.a.f.i.e
    public Bitmap thumbBitmap(boolean z) {
        Bitmap thumbnail;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            thumbnail = MediaStore.Images.Thumbnails.getThumbnail(this.a, this.c, 1, options);
        } catch (Exception e2) {
            e2.printStackTrace();
            thumbnail = null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            thumbnail = null;
        }
        return (thumbnail == null || !z) ? thumbnail : e.c.a.g.a.s.f.u(thumbnail, getDegreesRotated());
    }
}
