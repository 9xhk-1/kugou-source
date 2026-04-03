package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class LyricMakerCell extends EmptyCell {
    private static final String[] titleArray = {"歌词制作：", "翻译：", "音译："};
    private Bitmap mArrowBitmap;
    private AttachInfo mAttachInfo;
    private float mCellMargin;
    private Paint.FontMetrics mFontMetrics;
    private float mLineSpacing;
    private float mTextHeight;
    private Paint mTextPaint;
    private String[] nameArray;
    private float[] textWidthArray;
    private float[] titleWidthArray;

    public LyricMakerCell(Context context, int i2, String str, String str2, String str3, AttachInfo attachInfo, int i3) {
        super(context, i2);
        String[] strArr = titleArray;
        this.textWidthArray = new float[strArr.length];
        this.titleWidthArray = new float[strArr.length];
        this.mAttachInfo = attachInfo;
        int i4 = 0;
        this.nameArray = new String[]{str, str2, str3};
        Paint paint = new Paint(1);
        this.mTextPaint = paint;
        paint.setTextSize(this.mAttachInfo.getFooterTextSize());
        this.mTextPaint.setColor(this.mAttachInfo.getFooterTextColor());
        this.mTextPaint.setColorFilter(new LightingColorFilter(this.mAttachInfo.getFooterTextColor(), 0));
        this.mTextPaint.setTypeface(this.mAttachInfo.getTypeface());
        this.mFontMetrics = this.mTextPaint.getFontMetrics();
        while (true) {
            String[] strArr2 = this.nameArray;
            if (i4 >= strArr2.length) {
                this.mLineSpacing = Utils.dip2px(context, 20.0f);
                this.mCellMargin = Utils.dip2px(context, 30.0f);
                Paint.FontMetrics fontMetrics = this.mFontMetrics;
                this.mTextHeight = fontMetrics.bottom - fontMetrics.top;
                this.mArrowBitmap = BitmapFactory.decodeResource(this.mContext.getResources(), i3);
                setAlignMode(this.mAttachInfo.getCellAlignMode());
                return;
            }
            if (!TextUtils.isEmpty(strArr2[i4])) {
                float[] fArr = this.textWidthArray;
                Paint paint2 = this.mTextPaint;
                StringBuilder sb = new StringBuilder();
                String[] strArr3 = titleArray;
                sb.append(strArr3[i4]);
                sb.append(this.nameArray[i4]);
                fArr[i4] = paint2.measureText(sb.toString());
                this.titleWidthArray[i4] = this.mTextPaint.measureText(strArr3[i4]);
            }
            i4++;
        }
    }

    public int calculateIndex(float f2, float f3) {
        float f4 = getVisibleRect().top + this.mCellMargin;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.nameArray;
            if (i2 >= strArr.length) {
                return 0;
            }
            if (!TextUtils.isEmpty(strArr[i2])) {
                float f5 = this.mTextHeight + f4;
                if (f3 > f4 && f3 < f5) {
                    return i3;
                }
                i3++;
                f4 = f5 + this.mLineSpacing;
            }
            i2++;
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public boolean isInClickArea(float f2, float f3) {
        return ((float) getCellRect().top) < f3 && ((float) getCellRect().bottom) > f3;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = getVisibleRect().top + this.mCellMargin;
        float f3 = this.mTextHeight / 2.0f;
        Paint.FontMetrics fontMetrics = this.mFontMetrics;
        float f4 = (-(fontMetrics.bottom + fontMetrics.top)) / 2.0f;
        int i2 = 0;
        while (true) {
            String[] strArr = this.nameArray;
            if (i2 >= strArr.length) {
                return;
            }
            if (!TextUtils.isEmpty(strArr[i2])) {
                float f5 = f2 + f3 + f4;
                Bitmap bitmap = this.mArrowBitmap;
                if (bitmap == null || bitmap.isRecycled()) {
                    float f6 = getAlignMode() != 1 ? getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.textWidthArray[i2]) / 2.0f) : getVisibleRect().left;
                    this.mTextPaint.setAlpha(127);
                    canvas.drawText(titleArray[i2], f6, f5, this.mTextPaint);
                    this.mTextPaint.setAlpha(255);
                    canvas.drawText(this.nameArray[i2], f6 + this.titleWidthArray[i2], f5, this.mTextPaint);
                } else {
                    float width = getAlignMode() != 1 ? getVisibleRect().left + ((((getVisibleRect().right - getVisibleRect().left) - this.textWidthArray[i2]) - this.mArrowBitmap.getWidth()) / 2.0f) : getVisibleRect().left;
                    this.mTextPaint.setAlpha(127);
                    canvas.drawText(titleArray[i2], width, f5, this.mTextPaint);
                    this.mTextPaint.setAlpha(255);
                    canvas.drawText(this.nameArray[i2], this.titleWidthArray[i2] + width, f5, this.mTextPaint);
                    canvas.drawBitmap(this.mArrowBitmap, width + this.textWidthArray[i2], f2 + ((this.mTextHeight - this.mArrowBitmap.getHeight()) / 2.0f) + Utils.dip2px(this.mContext, 1.0f), this.mTextPaint);
                }
                f2 = f5 + this.mLineSpacing;
            }
            i2++;
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            String[] strArr = this.nameArray;
            if (i4 >= strArr.length) {
                setMeasureResult(i2, (int) (((int) (i5 - this.mLineSpacing)) + this.mCellMargin));
                return;
            } else {
                if (!TextUtils.isEmpty(strArr[i4])) {
                    i5 = (int) (((int) (i5 + this.mTextHeight)) + this.mLineSpacing);
                }
                i4++;
            }
        }
    }

    public void setLineSpacing(float f2) {
        this.mLineSpacing = f2;
    }

    public void setLyricMakerTextColor(int i2) {
        Paint paint = this.mTextPaint;
        if (paint != null) {
            paint.setColor(i2);
            this.mTextPaint.setColorFilter(new LightingColorFilter(i2, 0));
        }
    }
}
