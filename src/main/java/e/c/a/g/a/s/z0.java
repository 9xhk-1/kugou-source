package e.c.a.g.a.s;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.annotation.WorkerThread;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.kugou.android.watch.lite.base.application.KGApplication;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {
    @WorkerThread
    public static final Bitmap a(String str, float f2) {
        f.z.d.j.e(str, "shareUrl");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iApplyDimension = (int) TypedValue.applyDimension(1, f2, KGApplication.getContext().getResources().getDisplayMetrics());
        try {
            Hashtable hashtable = new Hashtable(2);
            hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hashtable.put(EncodeHintType.MARGIN, 1);
            BitMatrix bitMatrixEncode = new QRCodeWriter().encode(str, 12, iApplyDimension, iApplyDimension, hashtable);
            int[] iArr = new int[iApplyDimension * iApplyDimension];
            if (iApplyDimension > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    if (iApplyDimension > 0) {
                        int i4 = 0;
                        while (true) {
                            int i5 = i4 + 1;
                            if (bitMatrixEncode.get(i4, i2)) {
                                iArr[(i2 * iApplyDimension) + i4] = -16777216;
                            } else {
                                iArr[(i2 * iApplyDimension) + i4] = -1;
                            }
                            if (i5 >= iApplyDimension) {
                                break;
                            }
                            i4 = i5;
                        }
                    }
                    if (i3 >= iApplyDimension) {
                        break;
                    }
                    i2 = i3;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iApplyDimension, iApplyDimension, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, iApplyDimension, 0, 0, iApplyDimension, iApplyDimension);
            Bitmap bitmapH = f.h(bitmapCreateBitmap, -16777216, false);
            bitmapCreateBitmap.recycle();
            return bitmapH;
        } catch (Exception e2) {
            g0.k(e2);
            return null;
        }
    }
}
