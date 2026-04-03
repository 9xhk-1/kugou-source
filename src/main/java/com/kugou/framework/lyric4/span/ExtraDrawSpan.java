package com.kugou.framework.lyric4.span;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.utils.Utils;
import com.kugou.framework.lyricanim.TextBitmapUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ExtraDrawSpan {
    public AttachInfo attachInfo;
    private final int dp10;
    private final int dp11;
    private final int dp12;
    private final int dp5;
    public Paint.FontMetrics fontMetrics;
    public Bitmap mBitmap;
    public Context mContext;
    private int mTextColor;
    public float mTextSize;
    public Paint mSelectBgPaint = new Paint(1);
    public RectF mSelectBgRect = new RectF();
    public Rect mSrc = new Rect();
    public RectF mDst = new RectF();
    public String curTimeStr = " ";
    private boolean isFling = false;
    public boolean isClimax = false;
    public float mAlphaFactor = 1.0f;

    public ExtraDrawSpan(Context context) {
        this.mContext = context;
        this.dp10 = Utils.dip2px(context, 10.0f);
        this.dp12 = Utils.dip2px(this.mContext, 12.0f);
        this.dp11 = Utils.dip2px(this.mContext, 11.0f);
        this.dp5 = Utils.dip2px(this.mContext, 5.0f);
    }

    private void drawTimeTxt(int i2, Canvas canvas) {
        float width = this.mBitmap != null ? r0.getWidth() : 0.0f;
        if (TextUtils.isEmpty(this.curTimeStr)) {
            return;
        }
        if (!this.isClimax) {
            setTextSize(this.dp11);
            float fMeasureText = this.mSelectBgPaint.measureText(this.curTimeStr);
            RectF rectF = this.mSelectBgRect;
            double d2 = rectF.top + rectF.bottom;
            Double.isNaN(d2);
            Paint.FontMetrics fontMetrics = this.fontMetrics;
            double d3 = fontMetrics.descent + fontMetrics.ascent;
            Double.isNaN(d3);
            float f2 = (float) ((d2 / 2.0d) - (d3 / 2.0d));
            float f3 = i2 == 1 ? ((rectF.right - this.dp10) - width) - fMeasureText : rectF.left + this.dp10;
            setPaintAlpha(127);
            canvas.drawText(this.curTimeStr, f3, f2, this.mSelectBgPaint);
            return;
        }
        setTextSize(this.dp11);
        float fMeasureText2 = this.mSelectBgPaint.measureText(this.curTimeStr);
        float fMeasureText3 = this.mSelectBgPaint.measureText("高潮");
        RectF rectF2 = this.mSelectBgRect;
        float f4 = i2 == 1 ? ((rectF2.right - this.dp10) - fMeasureText2) - width : rectF2.left + this.dp10;
        RectF rectF3 = this.mSelectBgRect;
        double d4 = rectF3.top + rectF3.bottom;
        Double.isNaN(d4);
        double d5 = this.fontMetrics.top;
        Double.isNaN(d5);
        setPaintAlpha(127);
        canvas.drawText(this.curTimeStr, f4, (float) ((d4 / 2.0d) - d5), this.mSelectBgPaint);
        setPaintAlpha(178);
        float f5 = i2 == 1 ? (((this.mSelectBgRect.right - this.dp10) - fMeasureText3) - ((fMeasureText2 - fMeasureText3) / 2.0f)) - width : this.mSelectBgRect.left + this.dp10 + ((fMeasureText2 - fMeasureText3) / 2.0f);
        RectF rectF4 = this.mSelectBgRect;
        double d6 = rectF4.top + rectF4.bottom;
        Double.isNaN(d6);
        double d7 = this.fontMetrics.bottom;
        Double.isNaN(d7);
        canvas.drawText("高潮", f5, (float) ((d6 / 2.0d) - d7), this.mSelectBgPaint);
    }

    private void setColor() {
        Paint paint;
        AttachInfo attachInfo = this.attachInfo;
        int textLineColor = attachInfo == null ? -1 : attachInfo.getTextLineColor();
        if (this.mTextColor == textLineColor || (paint = this.mSelectBgPaint) == null) {
            return;
        }
        this.mTextColor = textLineColor;
        paint.setColor(textLineColor);
        this.mSelectBgPaint.setColorFilter(TextBitmapUtils.color2ColorFilter(this.mTextColor));
    }

    private void setPaintAlpha(int i2) {
        int i3;
        Paint paint = this.mSelectBgPaint;
        if (this.isFling) {
            double d2 = i2;
            Double.isNaN(d2);
            i3 = (int) (d2 * 0.2d);
        } else {
            i3 = (int) (i2 * this.mAlphaFactor);
        }
        paint.setAlpha(i3);
    }

    private void setTextSize(float f2) {
        Paint paint = this.mSelectBgPaint;
        if (paint != null) {
            paint.setTextSize(f2);
            if (this.mTextSize != f2) {
                this.fontMetrics = this.mSelectBgPaint.getFontMetrics();
            }
            this.mTextSize = f2;
        }
    }

    public void draw(Canvas canvas, int i2) {
        if (canvas == null) {
            return;
        }
        setColor();
        setPaintAlpha(38);
        this.mSelectBgPaint.setStyle(Paint.Style.FILL);
        RectF rectF = this.mSelectBgRect;
        int i3 = this.dp5;
        canvas.drawRoundRect(rectF, i3, i3, this.mSelectBgPaint);
        setPaintAlpha(255);
        setTextSize(this.dp12);
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            this.mSrc.set(0, 0, bitmap.getWidth(), this.mBitmap.getHeight());
            RectF rectF2 = this.mSelectBgRect;
            float fHeight = rectF2.top + ((rectF2.height() - this.mBitmap.getHeight()) / 2.0f);
            RectF rectF3 = this.mDst;
            float width = this.mSelectBgRect.right - this.mBitmap.getWidth();
            int i4 = this.dp10;
            rectF3.set(width - i4, fHeight, this.mSelectBgRect.right - i4, this.mBitmap.getHeight() + fHeight);
            canvas.drawBitmap(this.mBitmap, this.mSrc, this.mDst, this.mSelectBgPaint);
        }
        drawTimeTxt(i2, canvas);
    }

    public void onLayout(float f2, float f3, float f4, float f5) {
        RectF rectF = this.mSelectBgRect;
        int i2 = this.dp10;
        rectF.left = f2 + i2;
        rectF.right = f3 - i2;
        rectF.top = f4;
        rectF.bottom = f5;
    }

    public void setAlphaFactor(float f2) {
        this.mAlphaFactor = f2;
    }

    public void setAttachInfo(AttachInfo attachInfo) {
        this.attachInfo = attachInfo;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setCurTimeStr(String str, long j) {
        this.curTimeStr = str;
        AttachInfo attachInfo = this.attachInfo;
        if (attachInfo != null) {
            this.isClimax = attachInfo.isShowClimax(j);
        }
    }

    public void setFling(boolean z) {
        this.isFling = z;
    }
}
