package com.kugou.framework.lyric4.cell.lyric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.BaseLyricView;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class CantoneseCell extends EmptyCell {
    private final int CONTENT_HEIGHT_DP;
    private Bitmap mArrowBitmap;
    private AttachInfo mAttachInfo;
    private RectF mBackRect;
    private Paint mBackgroundPaint;
    private Bitmap mCantoneseCover;
    private String mCantoneseText;
    private float mCellMargin;
    private RectF mCircleDstRect;
    private Path mCirclePath;
    private Rect mCircleSrcRect;
    private float mContentHeight;
    private float mCoverWidth;
    private Paint.FontMetrics mFontMetrics;
    private float mSpacing3dp;
    private float mSpacing5dp;
    private float mSpacing6dp;
    private Paint mTextPaint;

    @SuppressLint({"WrongConstant"})
    public CantoneseCell(Context context, int i2, Bitmap bitmap, String str, AttachInfo attachInfo, int i3) {
        super(context, i2);
        this.CONTENT_HEIGHT_DP = 30;
        this.mBackRect = new RectF();
        this.mCirclePath = new Path();
        this.mCircleSrcRect = new Rect();
        this.mCircleDstRect = new RectF();
        this.mCantoneseCover = bitmap;
        this.mCantoneseText = str;
        this.mAttachInfo = attachInfo;
        Paint paint = new Paint(1);
        this.mTextPaint = paint;
        paint.setTextSize(sp2px(getContext(), 10.0f));
        this.mTextPaint.setColor(this.mAttachInfo.getFooterTextColor());
        this.mTextPaint.setColorFilter(new LightingColorFilter(this.mAttachInfo.getFooterTextColor(), 0));
        this.mTextPaint.setTypeface(this.mAttachInfo.getTypeface());
        this.mFontMetrics = this.mTextPaint.getFontMetrics();
        this.mCellMargin = Utils.dip2px(context, 30.0f);
        int iDip2px = Utils.dip2px(this.mContext, 9.0f);
        this.mArrowBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), i3), iDip2px, iDip2px, true);
        setAlignMode(this.mAttachInfo.getCellAlignMode());
        this.mContentHeight = Utils.dip2px(this.mContext, 30.0f);
        Paint paint2 = new Paint(1);
        this.mBackgroundPaint = paint2;
        paint2.setColor(402653183);
        this.mSpacing3dp = Utils.dip2px(this.mContext, 3.0f);
        this.mSpacing5dp = Utils.dip2px(this.mContext, 5.0f);
        this.mSpacing6dp = Utils.dip2px(this.mContext, 6.0f);
        this.mCoverWidth = Utils.dip2px(this.mContext, 24.0f);
    }

    private int sp2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public boolean isInClickArea(float f2, float f3) {
        return ((float) getCellRect().top) < f3 && ((float) getCellRect().bottom) > f3;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        BaseLyricView.OnCellExposeListener onCellExposeListener;
        super.onDraw(canvas);
        float width = this.mArrowBitmap.getWidth();
        float fMeasureText = this.mTextPaint.measureText(this.mCantoneseText);
        float f2 = this.mSpacing3dp;
        float f3 = this.mCoverWidth + f2 + this.mSpacing5dp + fMeasureText + f2 + width + this.mSpacing6dp;
        float f4 = getVisibleRect().top + this.mCellMargin;
        float f5 = getAlignMode() != 1 ? getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - f3) / 2.0f) : getVisibleRect().left;
        float f6 = f5 + f3;
        float f7 = f4 + this.mContentHeight;
        RectF rectF = this.mBackRect;
        rectF.left = f5;
        rectF.right = f6;
        rectF.bottom = f7;
        rectF.top = f4;
        if (isRectInVisibleRange(rectF) && (onCellExposeListener = this.mOnCellExposeListener) != null) {
            onCellExposeListener.onExpose(0);
        }
        float fDip2px = Utils.dip2px(this.mContext, 17.5f);
        canvas.drawRoundRect(f5, f4, f6, f7, fDip2px, fDip2px, this.mBackgroundPaint);
        float f8 = f5 + this.mSpacing3dp;
        Bitmap bitmap = this.mCantoneseCover;
        if (bitmap != null && !bitmap.isRecycled()) {
            float f9 = this.mCoverWidth;
            float f10 = f9 / 2.0f;
            float f11 = ((this.mContentHeight - f9) / 2.0f) + f4;
            int iSave = canvas.save();
            this.mCirclePath.reset();
            Path path = this.mCirclePath;
            float f12 = this.mCoverWidth;
            path.addCircle((f12 / 2.0f) + f8, (f12 / 2.0f) + f11, f10, Path.Direction.CCW);
            canvas.clipPath(this.mCirclePath);
            Rect rect = this.mCircleSrcRect;
            rect.left = 0;
            rect.top = 0;
            rect.right = this.mCantoneseCover.getWidth();
            this.mCircleSrcRect.bottom = this.mCantoneseCover.getHeight();
            RectF rectF2 = this.mCircleDstRect;
            rectF2.left = f8;
            rectF2.top = f11;
            float f13 = this.mCoverWidth;
            rectF2.right = f8 + f13;
            rectF2.bottom = f11 + f13;
            canvas.drawBitmap(this.mCantoneseCover, this.mCircleSrcRect, rectF2, (Paint) null);
            canvas.restoreToCount(iSave);
            f8 += this.mCoverWidth;
        }
        float f14 = f8 + this.mSpacing5dp;
        Paint.FontMetrics fontMetrics = this.mFontMetrics;
        canvas.drawText(this.mCantoneseText, f14, (this.mContentHeight / 2.0f) + f4 + ((-(fontMetrics.bottom + fontMetrics.top)) / 2.0f), this.mTextPaint);
        canvas.drawBitmap(this.mArrowBitmap, f14 + fMeasureText + this.mSpacing3dp, f4 + ((this.mContentHeight - this.mArrowBitmap.getHeight()) / 2.0f), this.mTextPaint);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasureResult(i2, (int) (((int) this.mContentHeight) + this.mCellMargin));
    }

    public void setCantoneseTextColor(int i2) {
        Paint paint = this.mTextPaint;
        if (paint != null) {
            paint.setColor(i2);
            this.mTextPaint.setColorFilter(new LightingColorFilter(i2, 0));
        }
    }
}
