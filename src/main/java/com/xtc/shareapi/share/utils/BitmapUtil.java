package com.xtc.shareapi.share.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.google.webp.libwebp;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import java.io.ByteArrayOutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapUtil {
    private static final String TAG;
    public static final int THUMB_LENGTH = 350;
    private static final int THUMB_SIZE = 14;

    static {
        System.loadLibrary("webp");
        TAG = OpenApiConstant.TAG + BitmapUtil.class.getSimpleName();
    }

    public static byte[] bitmapToByteArray(Bitmap bitmap) {
        byte[] bArrWebPEncodeRGB = null;
        try {
            int i2 = 0;
            if (!Objects.equals(bitmap.getConfig(), Bitmap.Config.ARGB_8888)) {
                bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            }
            byte[] bArrConvertARGB8888toRGB888 = convertARGB8888toRGB888(bitmap, bitmap.getWidth(), bitmap.getHeight());
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                bArrWebPEncodeRGB = libwebp.WebPEncodeRGB(bArrConvertARGB8888toRGB888, bitmap.getWidth(), bitmap.getHeight(), bitmap.getWidth() * 3, 10.0f);
                Log.i(TAG, "bitmapToByteArray webp length:" + bArrWebPEncodeRGB.length);
                if (bArrWebPEncodeRGB.length <= 350) {
                    break;
                }
                i2 = i3;
            }
        } catch (Exception e2) {
            Log.e(TAG, "bitmapToByteArray exception:" + e2.getMessage());
        }
        return bArrWebPEncodeRGB;
    }

    public static byte[] bitmapToByteArray1(Bitmap bitmap) {
        byte[] bArr = new byte[0];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.WEBP, 10, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            Log.e(TAG, "bitmapToByteArray exception:" + e2.getMessage());
            return bArr;
        }
    }

    public static byte[] convertARGB8888toRGB888(Bitmap bitmap, int i2, int i3) {
        byte[] bArr = new byte[i2 * i3 * 3];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                int pixel = bitmap.getPixel(i5, i4);
                int i6 = ((i4 * i2) + i5) * 3;
                bArr[i6] = (byte) ((pixel >> 16) & 255);
                bArr[i6 + 1] = (byte) ((pixel >> 8) & 255);
                bArr[i6 + 2] = (byte) (pixel & 255);
            }
        }
        return bArr;
    }

    private static int dpToPx(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static Bitmap scaleIcon(Context context, Bitmap bitmap) {
        int iDpToPx = dpToPx(context, 14.0f);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iDpToPx, iDpToPx, true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iDpToPx, iDpToPx, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(Color.parseColor("#000000"));
        canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapCreateBitmap;
    }
}
