package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class DrawableKt {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0.getConfig() == r9) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Bitmap toBitmap(android.graphics.drawable.Drawable r6, @androidx.annotation.Px int r7, @androidx.annotation.Px int r8, android.graphics.Bitmap.Config r9) {
        /*
            java.lang.String r0 = "$this$toBitmap"
            f.z.d.j.f(r6, r0)
            boolean r0 = r6 instanceof android.graphics.drawable.BitmapDrawable
            java.lang.String r1 = "bitmap"
            if (r0 == 0) goto L42
            if (r9 == 0) goto L1d
            r0 = r6
            android.graphics.drawable.BitmapDrawable r0 = (android.graphics.drawable.BitmapDrawable) r0
            android.graphics.Bitmap r0 = r0.getBitmap()
            f.z.d.j.b(r0, r1)
            android.graphics.Bitmap$Config r0 = r0.getConfig()
            if (r0 != r9) goto L42
        L1d:
            android.graphics.drawable.BitmapDrawable r6 = (android.graphics.drawable.BitmapDrawable) r6
            int r9 = r6.getIntrinsicWidth()
            if (r7 != r9) goto L33
            int r9 = r6.getIntrinsicHeight()
            if (r8 != r9) goto L33
            android.graphics.Bitmap r6 = r6.getBitmap()
            f.z.d.j.b(r6, r1)
            return r6
        L33:
            android.graphics.Bitmap r6 = r6.getBitmap()
            r9 = 1
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r6, r7, r8, r9)
            java.lang.String r7 = "Bitmap.createScaledBitma…map, width, height, true)"
            f.z.d.j.b(r6, r7)
            return r6
        L42:
            android.graphics.Rect r0 = r6.getBounds()
            int r2 = r0.left
            int r3 = r0.top
            int r4 = r0.right
            int r0 = r0.bottom
            if (r9 == 0) goto L51
            goto L53
        L51:
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
        L53:
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r7, r8, r9)
            r5 = 0
            r6.setBounds(r5, r5, r7, r8)
            android.graphics.Canvas r7 = new android.graphics.Canvas
            r7.<init>(r9)
            r6.draw(r7)
            r6.setBounds(r2, r3, r4, r0)
            f.z.d.j.b(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.DrawableKt.toBitmap(android.graphics.drawable.Drawable, int, int, android.graphics.Bitmap$Config):android.graphics.Bitmap");
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if ((i4 & 2) != 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        if ((i4 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i2, i3, config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        j.f(drawable, "$this$updateBounds");
        drawable.setBounds(i2, i3, i4, i5);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = drawable.getBounds().left;
        }
        if ((i6 & 2) != 0) {
            i3 = drawable.getBounds().top;
        }
        if ((i6 & 4) != 0) {
            i4 = drawable.getBounds().right;
        }
        if ((i6 & 8) != 0) {
            i5 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i2, i3, i4, i5);
    }
}
