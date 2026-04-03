package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.IntDef;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.Cell;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseLyricCell extends Cell {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public int mAlignMode;
    public int mHighLightWordIndex;
    public int mHighLightWordPercentage;
    public String[] mLyricWords;
    public Paint mPaint;
    public Language mShowingLanguage;
    public Paint mStrokePaint;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({0, 1, 2})
    public @interface AlignMode {
    }

    public BaseLyricCell(Context context, String[] strArr, AttachInfo attachInfo) {
        super(context);
        this.mAlignMode = 0;
        this.mPaint = new Paint(1);
        this.mStrokePaint = new Paint(1);
        this.mShowingLanguage = Language.Origin;
        this.mLyricWords = strArr;
        this.mAttachInfo = attachInfo;
        this.mPaint.setTextSize(attachInfo.getTextSize());
        this.mPaint.setColor(attachInfo.getTextColor());
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
        this.mStrokePaint.setStrokeWidth(this.mAttachInfo.getStrokeSize());
        this.mStrokePaint.setFakeBoldText(true);
        Typeface typeface = attachInfo.getTypeface();
        if (typeface != null) {
            this.mPaint.setTypeface(typeface);
            this.mStrokePaint.setTypeface(typeface);
        } else {
            this.mPaint.setTypeface(null);
            this.mStrokePaint.setTypeface(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void checkBlur() {
        /*
            r6 = this;
            com.kugou.framework.lyric4.AttachInfo r0 = r6.mAttachInfo
            if (r0 == 0) goto L71
            android.graphics.Paint r1 = r6.mPaint
            if (r1 != 0) goto La
            goto L71
        La:
            int r0 = r0.getBlur()
            r1 = 0
            if (r0 <= 0) goto L6c
            com.kugou.framework.lyric4.AttachInfo r2 = r6.mAttachInfo
            boolean r2 = r2.getIsSliding()
            if (r2 != 0) goto L6c
            com.kugou.framework.lyric4.AttachInfo r2 = r6.mAttachInfo
            int r2 = r2.getLyrType()
            r3 = 3
            if (r2 == r3) goto L6c
            com.kugou.framework.lyric4.AttachInfo r2 = r6.mAttachInfo
            int r2 = r2.getCurrentHighLightLine()
            int r3 = r6.mLine
            if (r2 != r3) goto L2e
            r0 = 0
            goto L56
        L2e:
            int r3 = r2 - r3
            int r3 = java.lang.Math.abs(r3)
            r4 = 9
            r5 = 1
            if (r3 != r5) goto L45
            r2 = 5
            if (r0 >= r2) goto L3f
            int r0 = r0 + (-1)
            goto L56
        L3f:
            if (r0 >= r4) goto L42
            goto L54
        L42:
            int r0 = r0 + (-4)
            goto L56
        L45:
            int r3 = r6.mLine
            int r2 = r2 - r3
            int r2 = java.lang.Math.abs(r2)
            r3 = 2
            if (r2 != r3) goto L56
            if (r0 >= r4) goto L54
            int r0 = r0 + (-2)
            goto L56
        L54:
            int r0 = r0 + (-3)
        L56:
            if (r0 <= 0) goto L66
            android.graphics.Paint r1 = r6.mPaint
            android.graphics.BlurMaskFilter r2 = new android.graphics.BlurMaskFilter
            float r0 = (float) r0
            android.graphics.BlurMaskFilter$Blur r3 = android.graphics.BlurMaskFilter.Blur.NORMAL
            r2.<init>(r0, r3)
            r1.setMaskFilter(r2)
            goto L71
        L66:
            android.graphics.Paint r0 = r6.mPaint
            r0.setMaskFilter(r1)
            goto L71
        L6c:
            android.graphics.Paint r0 = r6.mPaint
            r0.setMaskFilter(r1)
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric4.cell.lyric.BaseLyricCell.checkBlur():void");
    }

    public int getActualAlphaValue(int i2) {
        return (int) (getAlphaValue() * this.mAttachInfo.getAlpha() * ((Color.alpha(i2) * 1.0f) / 255.0f));
    }

    public int getAlignMode() {
        return this.mAlignMode;
    }

    @Override // com.kugou.framework.lyric4.cell.Cell
    public AttachInfo getAttachInfo() {
        return this.mAttachInfo;
    }

    public Paint getDefaultPaint() {
        this.mPaint.setColor(this.mAttachInfo.getTextColor());
        this.mPaint.setAlpha(getActualAlphaValue(this.mAttachInfo.getTextColor()));
        if (this.mAttachInfo.isBoldText()) {
            this.mPaint.setFakeBoldText(true);
        } else {
            this.mPaint.setFakeBoldText(false);
        }
        checkBlur();
        if (Language.Translation == this.mShowingLanguage && this.mAttachInfo.getTranslationTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTranslationTextSize());
        } else if (Language.Transliteration == this.mShowingLanguage && this.mAttachInfo.getTransliterationTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTransliterationTextSize());
        } else if (Language.Chinese != this.mShowingLanguage || this.mAttachInfo.getChineseTextSize() == -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTextSize());
        } else {
            this.mPaint.setTextSize(this.mAttachInfo.getChineseTextSize());
        }
        return this.mPaint;
    }

    public Paint getHighLightPaint() {
        this.mPaint.setColor(this.mAttachInfo.getTextHighLightColor());
        this.mPaint.setAlpha(getActualAlphaValue(this.mAttachInfo.getTextHighLightColor()));
        if (this.mAttachInfo.isBoldText() || this.mAttachInfo.isBoldHighLightWord()) {
            this.mPaint.setFakeBoldText(true);
        } else {
            this.mPaint.setFakeBoldText(false);
        }
        if (Language.Translation == this.mShowingLanguage && this.mAttachInfo.getTranslationTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTranslationTextSize());
        } else if (Language.Transliteration == this.mShowingLanguage && this.mAttachInfo.getTransliterationTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTransliterationTextSize());
        } else if (Language.Chinese != this.mShowingLanguage || this.mAttachInfo.getChineseTextSize() == -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTextSize());
        } else {
            this.mPaint.setTextSize(this.mAttachInfo.getChineseTextSize());
        }
        return this.mPaint;
    }

    public int getHighLightWordIndex() {
        return this.mHighLightWordIndex;
    }

    public int getHighLightWordPercentage() {
        return this.mHighLightWordPercentage;
    }

    public String[] getLyricWords() {
        return this.mLyricWords;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public Paint getPlayLinePaint(Paint paint) {
        if (!this.mAttachInfo.isShowPlayingLineLight() || this.mAttachInfo.getLyrType() != 1) {
            if (paint != null && this.mAttachInfo.isBoldHighLightWord()) {
                paint.setFakeBoldText(true);
            }
            return paint;
        }
        if (paint == null) {
            paint = this.mPaint;
        }
        paint.setColor(this.mAttachInfo.getTextLineColor());
        paint.setAlpha(getActualAlphaValue(this.mAttachInfo.getTextLineColor()));
        if (this.mAttachInfo.isBoldHighLightWord()) {
            paint.setFakeBoldText(true);
        }
        return paint;
    }

    public Paint getSelectLinePaint(Paint paint) {
        if (!isHighLighting() && this.mShowSelectLine && this.mAttachInfo.isShowPlayingLineLight() && !this.mAttachInfo.isShowSelectBgMode()) {
            if (paint == null) {
                paint = this.mPaint;
            }
            paint.setColor(this.mAttachInfo.getSelectedLineColor());
            paint.setAlpha(getActualAlphaValue(this.mAttachInfo.getSelectedLineColor()));
        }
        return paint;
    }

    public Language getShowingLanguage() {
        return this.mShowingLanguage;
    }

    public Paint getStrokePaint() {
        if (this.mStrokePaint == null) {
            Paint paint = new Paint(1);
            this.mStrokePaint = paint;
            paint.setStyle(Paint.Style.STROKE);
        }
        if (this.mAttachInfo.isBoldText()) {
            this.mStrokePaint.setFakeBoldText(true);
        } else {
            this.mStrokePaint.setFakeBoldText(false);
        }
        this.mStrokePaint.setStrokeWidth(this.mAttachInfo.getStrokePenSize());
        this.mStrokePaint.setColor(this.mAttachInfo.getStrokeColor());
        this.mStrokePaint.setAlpha(getActualAlphaValue(this.mAttachInfo.getStrokeColor()));
        if (Language.Translation == this.mShowingLanguage && this.mAttachInfo.getTranslationTextSize() != -1) {
            this.mStrokePaint.setTextSize(this.mAttachInfo.getTranslationTextSize());
        } else if (Language.Transliteration == this.mShowingLanguage && this.mAttachInfo.getTransliterationTextSize() != -1) {
            this.mStrokePaint.setTextSize(this.mAttachInfo.getTransliterationTextSize());
        } else if (Language.Chinese != this.mShowingLanguage || this.mAttachInfo.getChineseTextSize() == -1) {
            this.mStrokePaint.setTextSize(this.mAttachInfo.getTextSize());
        } else {
            this.mStrokePaint.setTextSize(this.mAttachInfo.getChineseTextSize());
        }
        return this.mStrokePaint;
    }

    public void setAlignMode(int i2) {
        this.mAlignMode = i2;
    }

    public void setHighLightWordIndex(int i2) {
        this.mHighLightWordIndex = i2;
    }

    public void setHighLightWordPercentage(int i2) {
        this.mHighLightWordPercentage = i2;
    }

    public void setShowingLanguage(Language language) {
        this.mShowingLanguage = language;
    }

    public Paint getSelectLinePaint(Paint paint, float f2) {
        if (!isHighLighting() && this.mShowSelectLine && this.mAttachInfo.isShowPlayingLineLight() && !this.mAttachInfo.isShowSelectBgMode()) {
            if (paint == null) {
                paint = this.mPaint;
            }
            paint.setColor(this.mAttachInfo.getSelectedLineColor());
            paint.setAlpha((int) (getActualAlphaValue(this.mAttachInfo.getSelectedLineColor()) * f2));
        }
        return paint;
    }

    public Paint getPlayLinePaint(Paint paint, float f2) {
        if (this.mAttachInfo.isShowPlayingLineLight() && this.mAttachInfo.getLyrType() == 1) {
            if (paint == null) {
                paint = this.mPaint;
            }
            paint.setColor(this.mAttachInfo.getTextLineColor());
            paint.setAlpha((int) (getActualAlphaValue(this.mAttachInfo.getTextLineColor()) * f2));
            if (this.mAttachInfo.isBoldHighLightWord()) {
                paint.setFakeBoldText(true);
            }
            return paint;
        }
        if (paint != null && this.mAttachInfo.isBoldHighLightWord()) {
            paint.setFakeBoldText(true);
        }
        return paint;
    }

    public Paint getHighLightPaint(float f2) {
        this.mPaint.setColor(this.mAttachInfo.getTextHighLightColor());
        this.mPaint.setAlpha((int) (getActualAlphaValue(this.mAttachInfo.getTextHighLightColor()) * f2));
        if (!this.mAttachInfo.isBoldText() && !this.mAttachInfo.isBoldHighLightWord()) {
            this.mPaint.setFakeBoldText(false);
        } else {
            this.mPaint.setFakeBoldText(true);
        }
        if (Language.Translation == this.mShowingLanguage && this.mAttachInfo.getTranslationTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTranslationTextSize());
        } else if (Language.Transliteration == this.mShowingLanguage && this.mAttachInfo.getTransliterationTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTransliterationTextSize());
        } else if (Language.Chinese == this.mShowingLanguage && this.mAttachInfo.getChineseTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getChineseTextSize());
        } else {
            this.mPaint.setTextSize(this.mAttachInfo.getTextSize());
        }
        return this.mPaint;
    }

    public Paint getDefaultPaint(float f2) {
        this.mPaint.setColor(this.mAttachInfo.getTextColor());
        this.mPaint.setAlpha((int) (getActualAlphaValue(this.mAttachInfo.getTextColor()) * f2));
        if (this.mAttachInfo.isBoldText()) {
            this.mPaint.setFakeBoldText(true);
        } else {
            this.mPaint.setFakeBoldText(false);
        }
        checkBlur();
        if (Language.Translation == this.mShowingLanguage && this.mAttachInfo.getTranslationTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTranslationTextSize());
        } else if (Language.Transliteration == this.mShowingLanguage && this.mAttachInfo.getTransliterationTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getTransliterationTextSize());
        } else if (Language.Chinese == this.mShowingLanguage && this.mAttachInfo.getChineseTextSize() != -1) {
            this.mPaint.setTextSize(this.mAttachInfo.getChineseTextSize());
        } else {
            this.mPaint.setTextSize(this.mAttachInfo.getTextSize());
        }
        return this.mPaint;
    }
}
