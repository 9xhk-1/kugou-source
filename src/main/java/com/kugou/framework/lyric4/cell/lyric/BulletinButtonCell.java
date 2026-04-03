package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class BulletinButtonCell extends EmptyCell {
    private AttachInfo mAttachInfo;
    private RectF mBGRect;
    private float mBaseline;
    private Bitmap mBitmap;
    private RectF mBitmapDstRect;
    private Rect mBitmapSrcRect;
    private int mDrawablePadding;
    private int mDrawableWidth;
    private Paint.FontMetrics mFontMetrics;
    private int mHeight;
    private int mLRPadding;
    private int mMarginBottom;
    private int mMarginTop;
    private Paint mPaint;
    private int mStrokeWidth;
    private String mText;
    private int mWidth;

    public BulletinButtonCell(Context context, int i2, int i3, String str, AttachInfo attachInfo) {
        super(context, i2);
        this.mPaint = new Paint(1);
        this.mBGRect = new RectF();
        this.mBitmapSrcRect = new Rect();
        this.mBitmapDstRect = new RectF();
        this.mText = str;
        this.mAttachInfo = attachInfo;
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i3);
        this.mBitmap = bitmapDecodeResource;
        Bitmap alphaBitmap = getAlphaBitmap(bitmapDecodeResource, this.mAttachInfo.getTextColor());
        this.mBitmap = alphaBitmap;
        this.mBitmapSrcRect.set(0, 0, alphaBitmap.getWidth(), this.mBitmap.getHeight());
        this.mStrokeWidth = Utils.dip2px(getContext(), 0.5f);
        this.mHeight = Utils.dip2px(getContext(), 25.0f);
        this.mMarginTop = Utils.dip2px(getContext(), 25.0f);
        this.mMarginBottom = Utils.dip2px(getContext(), 5.0f);
        this.mLRPadding = Utils.dip2px(context, 10.0f);
        this.mDrawablePadding = Utils.dip2px(context, 5.0f);
        this.mDrawableWidth = Utils.dip2px(context, 10.0f);
        this.mPaint.setTextSize(Utils.dip2px(getContext(), 11.0f));
        this.mPaint.setColor(this.mAttachInfo.getTextColor());
        this.mPaint.setTypeface(this.mAttachInfo.getTypeface());
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        this.mFontMetrics = fontMetrics;
        this.mBaseline = (this.mHeight / 2.0f) - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
        this.mWidth = (int) ((this.mLRPadding * 2) + this.mDrawableWidth + this.mDrawablePadding + this.mPaint.measureText(this.mText));
    }

    public static Bitmap getAlphaBitmap(Bitmap bitmap, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(i2);
        canvas.drawBitmap(bitmap.extractAlpha(), 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public boolean isInClick(float f2, float f3) {
        return this.mBGRect.contains((int) f2, (int) f3);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public boolean isInClickArea(float f2, float f3) {
        return this.mBGRect.contains((int) f2, (int) f3);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        this.mPaint.setAlpha(this.mIsPressed ? 100 : 255);
        int cellAlignMode = this.mAttachInfo.getCellAlignMode();
        int i2 = cellAlignMode != 1 ? cellAlignMode != 2 ? getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mWidth) / 2) : (getVisibleRect().right - getVisibleRect().left) - this.mWidth : getVisibleRect().left;
        int i3 = getVisibleRect().top + this.mMarginTop;
        float f2 = i3;
        this.mBGRect.set(i2, f2, this.mWidth + i2, this.mHeight + i3);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mStrokeWidth);
        RectF rectF = this.mBGRect;
        int i4 = this.mHeight;
        canvas.drawRoundRect(rectF, i4, i4, this.mPaint);
        this.mBitmapDstRect.set(this.mLRPadding + i2, i3 + ((this.mHeight - this.mDrawableWidth) / 2), r3 + r5, r5 + r1);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawBitmap(this.mBitmap, this.mBitmapSrcRect, this.mBitmapDstRect, this.mPaint);
        canvas.drawText(this.mText, i2 + this.mLRPadding + this.mDrawableWidth + this.mDrawablePadding, f2 + this.mBaseline, this.mPaint);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.EmptyCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        setMeasureResult(i2, this.mHeight + this.mMarginTop + this.mMarginBottom);
    }
}
