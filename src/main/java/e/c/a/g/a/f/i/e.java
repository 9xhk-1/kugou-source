package e.c.a.g.a.f.i;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public interface e {
    Bitmap fullSizeBitmap(int i2, int i3);

    Bitmap fullSizeBitmap(int i2, int i3, boolean z, boolean z2);

    InputStream fullSizeImageData();

    long fullSizeImageId();

    Uri fullSizeImageUri();

    f getContainer();

    String getDataPath();

    long getDateTaken();

    int getDegreesRotated();

    String getDisplayName();

    int getHeight();

    String getMimeType();

    String getTitle();

    int getWidth();

    boolean isDrm();

    boolean isReadonly();

    Bitmap miniThumbBitmap();

    boolean rotateImageBy(int i2);

    Bitmap thumbBitmap(boolean z);
}
