package com.kugou.framework.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* JADX INFO: loaded from: classes2.dex */
public class LyricView extends View implements ILyricView {
    public int backgroundColor;
    public String defaultMsg;
    public int frontColor;
    public float leading;
    public LyricData lyricData;
    public boolean lyricSplited;
    public int mShadowColor;
    public float paddingBottom;
    public float paddingLeft;
    public float paddingRight;
    public float paddingTop;
    public Paint pen;
    public boolean resetRowIndex;
    public float rowHeight;
    public float rowMargin;
    public float textSize;
    public float wordHeight;

    public interface InterceptLongClickCallback {
        boolean shouldInterceptLongClickEvent();
    }

    public interface LongClickCallBack {
        void longClickCallBack(int i2);
    }

    public LyricView(Context context) {
        this(context, null);
    }

    public void drawBorder(Canvas canvas, String str, float f2, float f3, int i2, int i3, Paint paint) {
        int color = paint.getColor();
        paint.setColor(i3);
        canvas.drawText(str, f2 + 0.5f, f3, paint);
        canvas.drawText(str, f2, f3 - 0.5f, paint);
        canvas.drawText(str, f2, f3 + 0.5f, paint);
        canvas.drawText(str, f2 - 0.5f, f3, paint);
        paint.setColor(i2);
        canvas.drawText(str, f2, f3, paint);
        paint.setColor(color);
    }

    public float getContentWidth() {
        return (getMeasuredWidth() - this.paddingLeft) - this.paddingRight;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public String getCurrentLyrics() {
        LyricData lyricData = this.lyricData;
        return lyricData != null ? lyricData.getCurrentLyrics() : "";
    }

    public float getLeading(Paint paint) {
        return paint.getFontMetrics().leading;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public LyricData getLyricData() {
        return this.lyricData;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public Paint getPen() {
        return this.pen;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getRowHeight() {
        return this.rowHeight;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getTextSize() {
        return this.textSize;
    }

    public float getWordHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public void initPen() {
        if (this.pen == null) {
            this.pen = new Paint();
        }
        this.pen.setAntiAlias(true);
        this.pen.setStrokeCap(Paint.Cap.ROUND);
        this.pen.setTextSize(this.textSize);
        this.pen.setTypeface(Typeface.defaultFromStyle(0));
        this.wordHeight = getWordHeight(this.pen);
        float leading = getLeading(this.pen);
        this.leading = leading;
        this.rowHeight = this.wordHeight + leading + this.rowMargin;
    }

    public void initSetting() {
        this.paddingLeft = 10.0f;
        this.paddingTop = 10.0f;
        this.paddingRight = 10.0f;
        this.paddingBottom = 10.0f;
        this.frontColor = -11892033;
        this.backgroundColor = -2697514;
        this.rowMargin = 6.0f;
        this.textSize = 25.0f;
        this.lyricSplited = true;
        initPen();
    }

    public boolean isLyrViewShown() {
        return isShown();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public synchronized boolean isLyricLoaded() {
        return this.lyricData != null;
    }

    public boolean isLyricSplited() {
        return this.lyricSplited;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (LyricManager.lyrDataLock) {
            if (this.lyricData == null) {
                showDefaultMsg(canvas);
            } else {
                showLyric(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max(200, size), BasicMeasure.EXACTLY);
        }
        if (mode2 != 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max(150, size2), BasicMeasure.EXACTLY);
        }
        super.onMeasure(i2, i3);
    }

    public synchronized void refresh() {
        invalidate();
    }

    public synchronized void release() {
        synchronized (LyricManager.lyrDataLock) {
            this.lyricData = null;
            postInvalidate();
        }
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void resetRowIndex() {
        synchronized (LyricManager.lyrDataLock) {
            LyricData lyricData = this.lyricData;
            if (lyricData != null) {
                lyricData.setRowIndex(0);
                this.lyricData.setWordIndex(-1);
                this.resetRowIndex = true;
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
        postInvalidate();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setDefaultMsg(String str) {
        setDefaultMsg(str, true);
    }

    public void setFrontColor(int i2) {
        this.frontColor = i2;
        postInvalidate();
    }

    public void setLyricData(LyricData lyricData) {
        synchronized (LyricManager.lyrDataLock) {
            this.lyricData = lyricData;
            this.resetRowIndex = true;
        }
    }

    public void setLyricSplited(boolean z) {
        this.lyricSplited = z;
    }

    public void setPaddingBottom(float f2) {
        this.paddingBottom = f2;
    }

    public void setPaddingLeft(float f2) {
        this.paddingLeft = f2;
    }

    public void setPaddingRight(float f2) {
        this.paddingRight = f2;
    }

    public void setPaddingTop(float f2) {
        this.paddingTop = f2;
    }

    public void setRowMargin(float f2) {
        this.rowMargin = f2;
    }

    public void setShadowColor(int i2) {
        this.mShadowColor = i2;
    }

    public void setTextSize(float f2) {
        if (this.textSize == f2) {
            return;
        }
        this.textSize = f2;
        initPen();
        if (this.lyricData != null) {
            LyricManager.getInstance().splitLyric();
        }
        postInvalidate();
        requestLayout();
    }

    public void showDefaultMsg(Canvas canvas) {
        this.pen.setColor(this.backgroundColor);
        canvas.drawText(this.defaultMsg, (getWidth() - this.pen.measureText(this.defaultMsg)) / 2.0f, ((getHeight() + this.wordHeight) / 2.0f) - this.leading, this.pen);
    }

    public synchronized void showLyric(Canvas canvas) {
        if (this.lyricData == null) {
            return;
        }
        int width = getWidth();
        float height = (getHeight() / 2.0f) + (this.wordHeight / 2.0f);
        float f2 = (width - this.paddingLeft) - this.paddingRight;
        String[] strArr = this.lyricData.getWords()[this.lyricData.getRowIndex()];
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        String string = sb.toString();
        canvas.drawText(string, ((f2 - this.pen.measureText(string)) / 2.0f) + this.paddingLeft, height, this.pen);
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setDefaultMsg(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.defaultMsg = str;
        if (z) {
            postInvalidate();
        }
    }

    public LyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.defaultMsg = LyricConstent.defaultMsg;
        initSetting();
    }
}
