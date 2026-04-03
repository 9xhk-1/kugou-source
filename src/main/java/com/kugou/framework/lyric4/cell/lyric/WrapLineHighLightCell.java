package com.kugou.framework.lyric4.cell.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.cell.State;
import com.kugou.framework.lyric4.cell.breakline.LyricLineInfo;
import com.kugou.framework.lyric4.cell.breakline.LyricWord;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class WrapLineHighLightCell extends WrapLineCell {
    private LyricLineInfo[] mAnimationLyricInfos;
    private LyricLineInfo[] mHighLightLyricInfo;

    /* JADX INFO: renamed from: com.kugou.framework.lyric4.cell.lyric.WrapLineHighLightCell$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$framework$lyric4$cell$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$kugou$framework$lyric4$cell$State = iArr;
            try {
                iArr[State.ZOOM_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kugou$framework$lyric4$cell$State[State.ZOOM_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kugou$framework$lyric4$cell$State[State.STANDARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WrapLineHighLightCell(Context context, String[] strArr, AttachInfo attachInfo, int i2) {
        super(context, strArr, attachInfo, i2);
    }

    private Paint getDefaultHighLightPaint() {
        this.mPaint.setColor(this.mAttachInfo.getTextLineColor());
        this.mPaint.setAlpha(getActualAlphaValue(this.mAttachInfo.getTextLineColor()));
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
            this.mPaint.setTextSize(this.mAttachInfo.getTextSize() * this.mAttachInfo.getHighLightTextZoomRate());
        } else {
            this.mPaint.setTextSize(this.mAttachInfo.getChineseTextSize());
        }
        return this.mPaint;
    }

    private LyricLineInfo[] updateAnimationLyricLineInfo(float f2) {
        LyricLineInfo[] lyricLineInfoArr;
        LyricLineInfo[] lyricLineInfoArr2;
        int i2 = AnonymousClass1.$SwitchMap$com$kugou$framework$lyric4$cell$State[getState().ordinal()];
        float f3 = 1.0f;
        if (i2 == 1) {
            lyricLineInfoArr = this.mLyricLineInfo;
        } else {
            if (i2 != 2) {
                lyricLineInfoArr2 = this.mLyricLineInfo;
                return updateLyricLineInfo(lyricLineInfoArr2, f3);
            }
            f2 = 1.0f / f2;
            lyricLineInfoArr = this.mHighLightLyricInfo;
        }
        f3 = f2;
        lyricLineInfoArr2 = lyricLineInfoArr;
        return updateLyricLineInfo(lyricLineInfoArr2, f3);
    }

    private void updateHighLightWordAndPercentage() {
        if (getLyricLineInfos().length == 1) {
            this.mHighLightWordIndex = getAttachInfo().getCurrentHighLightWord();
            this.mHighLightWordPercentage = getAttachInfo().getCurrentHighLightPercentage();
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (LyricLineInfo lyricLineInfo : getLyricLineInfos()) {
            for (LyricWord lyricWord : lyricLineInfo.getLyricWords()) {
                if (lyricWord.getIndex() >= getAttachInfo().getCurrentHighLightWord()) {
                    if (lyricWord.getIndex() != getAttachInfo().getCurrentHighLightWord()) {
                        if (lyricWord.getIndex() > getAttachInfo().getCurrentHighLightWord()) {
                            break;
                        }
                    } else {
                        i2++;
                    }
                } else {
                    i3++;
                }
            }
        }
        if (i2 == 1) {
            this.mHighLightWordIndex = i3;
            this.mHighLightWordPercentage = getAttachInfo().getCurrentHighLightPercentage();
        } else {
            this.mHighLightWordIndex = getAttachInfo().getCurrentHighLightWord() + ((i2 * getAttachInfo().getCurrentHighLightPercentage()) / 100);
            this.mHighLightWordPercentage = 100;
        }
    }

    private LyricLineInfo[] updateLyricLineInfo(LyricLineInfo[] lyricLineInfoArr, float f2) {
        ArrayList arrayList = new ArrayList();
        for (LyricLineInfo lyricLineInfo : lyricLineInfoArr) {
            LyricLineInfo lyricLineInfo2 = new LyricLineInfo();
            lyricLineInfo2.setSpanMap(lyricLineInfo.getSpanMap());
            lyricLineInfo2.setLyricWords(updateLyricWords(lyricLineInfo.getLyricWords(), f2));
            lyricLineInfo2.setLyricLine(lyricLineInfo.getLyricLine());
            lyricLineInfo2.setLineHeight(lyricLineInfo.getLineHeight() * f2);
            lyricLineInfo2.setLineWidth(lyricLineInfo.getLineWidth() * f2);
            lyricLineInfo2.setExtraWidth(lyricLineInfo.getExtraWidth());
            lyricLineInfo2.setBaseLineOffset(lyricLineInfo.getBaseLineOffset() * f2);
            arrayList.add(lyricLineInfo2);
        }
        return (LyricLineInfo[]) arrayList.toArray(new LyricLineInfo[arrayList.size()]);
    }

    private LyricWord[] updateLyricWords(LyricWord[] lyricWordArr, float f2) {
        ArrayList arrayList = new ArrayList();
        for (LyricWord lyricWord : lyricWordArr) {
            arrayList.add(new LyricWord(lyricWord.getLyricWord(), lyricWord.getIndex(), lyricWord.getLyricWordWidth() * f2, lyricWord.getLyricWordLength()));
        }
        return (LyricWord[]) arrayList.toArray(new LyricWord[arrayList.size()]);
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell
    public void drawLyricLine(Canvas canvas, LyricLineInfo lyricLineInfo, String str, float f2, float f3, float f4, Paint paint, int i2, int i3, RectF rectF) {
        int i4 = 0;
        this.mIsHighLighting = getAttachInfo().getCurrentHighLightLine() == this.mLine;
        if (this.mAttachInfo.isStroke()) {
            drawText(canvas, lyricLineInfo, str, f2 - this.mAttachInfo.getStrokeSize(), f3, f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
        }
        if (!this.mIsHighLighting) {
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getSelectLinePaint(getDefaultPaint()));
            return;
        }
        updateHighLightWordAndPercentage();
        int i5 = this.mHighLightWordIndex;
        if (i5 < i2) {
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getDefaultHighLightPaint());
            return;
        }
        if (i5 >= i3) {
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getHighLightPaint());
            return;
        }
        if (this.mShowHighLightLine) {
            int i6 = i5 - i2;
            float lyricWordWidth = 0.0f;
            while (i4 <= i6) {
                lyricWordWidth += i4 != i6 ? lyricLineInfo.getLyricWords()[i4].getLyricWordWidth() : (lyricLineInfo.getLyricWords()[i4].getLyricWordWidth() * this.mHighLightWordPercentage) / 100.0f;
                i4++;
            }
            float lineWidth = lyricWordWidth / lyricLineInfo.getLineWidth();
            if (lineWidth <= 0.0f) {
                drawText(canvas, lyricLineInfo, str, f2, f3, f4, getDefaultHighLightPaint());
                return;
            }
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getDefaultHighLightPaint());
            canvas.save();
            RectF rectF2 = this.mTempRect;
            rectF2.right = rectF2.left + (lyricLineInfo.getLineWidth() * lineWidth);
            canvas.clipRect(this.mTempRect);
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getHighLightPaint());
            canvas.restore();
        }
    }

    public LyricLineInfo[] getDefaultLyricLineInfos() {
        if (this.mLyricLineInfo == null) {
            this.mLyricLineInfo = new LyricLineInfo[0];
        }
        return this.mLyricLineInfo;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.BaseLyricCell
    public Paint getDefaultPaint() {
        return super.getDefaultPaint();
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.BaseLyricCell
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
            this.mPaint.setTextSize(this.mAttachInfo.getTextSize() * this.mAttachInfo.getHighLightTextZoomRate());
        } else {
            this.mPaint.setTextSize(this.mAttachInfo.getChineseTextSize());
        }
        return this.mPaint;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell
    public LyricLineInfo[] getLyricLineInfos() {
        if (this.mHighLightLyricInfo == null) {
            this.mHighLightLyricInfo = new LyricLineInfo[0];
        }
        if (this.mLyricLineInfo == null) {
            this.mLyricLineInfo = new LyricLineInfo[0];
        }
        return this.mIsHighLighting ? this.mHighLightLyricInfo : this.mLyricLineInfo;
    }

    public Paint getPlayLinePaint() {
        Paint playLinePaint = super.getPlayLinePaint(getDefaultPaint());
        if (this.mAttachInfo.isBoldHighLightWord()) {
            this.mPaint.setFakeBoldText(true);
        }
        return playLinePaint;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.BaseLyricCell
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
        } else if (Language.Chinese == this.mShowingLanguage && this.mAttachInfo.getChineseTextSize() != -1) {
            this.mStrokePaint.setTextSize(this.mAttachInfo.getChineseTextSize());
        } else if (this.mIsHighLighting) {
            this.mStrokePaint.setTextSize(this.mAttachInfo.getTextSize() * this.mAttachInfo.getHighLightTextZoomRate());
        } else {
            this.mStrokePaint.setTextSize(this.mAttachInfo.getTextSize());
        }
        return this.mStrokePaint;
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onDraw(Canvas canvas) {
        float lineWidth;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int length = 0;
        while (i2 < getLyricLineInfos().length) {
            float lineHeight = f2 + (getLyricLineInfos()[i2].getLineHeight() / 2.0f);
            float baseLineOffset = this.mVisibleRect.top + lineHeight + getLyricLineInfos()[i2].getBaseLineOffset();
            float f4 = this.mVisibleRect.top + f3;
            float lineHeight2 = lineHeight + (getLyricLineInfos()[i2].getLineHeight() / 2.0f) + this.mLineSpacing;
            int alignMode = getAlignMode();
            if (alignMode == 0) {
                lineWidth = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - getLyricLineInfos()[i2].getLineWidth()) / 2.0f);
            } else if (alignMode == 1 || alignMode != 2) {
                int i3 = getVisibleRect().left;
                lineWidth = i3;
            } else {
                lineWidth = getVisibleRect().right - getLyricLineInfos()[i2].getLineWidth();
            }
            float f5 = lineWidth;
            RectF rectF = this.mTempRect;
            rectF.left = f5;
            rectF.top = getVisibleRect().top + f3;
            this.mTempRect.right = getLyricLineInfos()[i2].getLineWidth() + f5;
            RectF rectF2 = this.mTempRect;
            rectF2.bottom = rectF2.top + getLyricLineInfos()[i2].getLineHeight();
            float lineHeight3 = f3 + getLyricLineInfos()[i2].getLineHeight() + this.mLineSpacing;
            if (isRectInVisibleRange(this.mTempRect)) {
                drawLyricLine(canvas, getLyricLineInfos()[i2], getLyricLineInfos()[i2].getLyricLine(), f5, f4, baseLineOffset, getDefaultPaint(), length, length + getLyricLineInfos()[i2].getLyricWords().length, this.mTempRect);
            }
            length += getLyricLineInfos()[i2].getLyricWords().length;
            i2++;
            f2 = lineHeight2;
            f3 = lineHeight3;
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onDrawAnimation(Canvas canvas, float f2) {
        float lineWidth;
        float lineHeight;
        int length;
        Paint paint;
        Paint paint2;
        Paint paint3;
        boolean z = getAttachInfo().getCurrentHighLightLine() == this.mLine;
        this.mIsHighLighting = z;
        if (z && !this.mShowHighLightLine) {
            updateHighLightWordAndPercentage();
        }
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            LyricLineInfo[] lyricLineInfoArr = this.mAnimationLyricInfos;
            if (i2 >= lyricLineInfoArr.length) {
                return;
            }
            float lineHeight2 = f3 + (lyricLineInfoArr[i2].getLineHeight() / 2.0f);
            float baseLineOffset = this.mVisibleRect.top + lineHeight2 + this.mAnimationLyricInfos[i2].getBaseLineOffset();
            float f5 = this.mVisibleRect.top + f4;
            float lineHeight3 = lineHeight2 + (this.mAnimationLyricInfos[i2].getLineHeight() / 2.0f) + this.mLineSpacing;
            int alignMode = getAlignMode();
            if (alignMode == 0) {
                lineWidth = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mAnimationLyricInfos[i2].getLineWidth()) / 2.0f);
            } else if (alignMode == 1 || alignMode != 2) {
                int i4 = getVisibleRect().left;
                lineWidth = i4;
            } else {
                lineWidth = getVisibleRect().right - this.mAnimationLyricInfos[i2].getLineWidth();
            }
            float f6 = lineWidth;
            Paint selectLinePaint = getSelectLinePaint(getDefaultPaint());
            Paint strokePaint = getStrokePaint();
            int i5 = AnonymousClass1.$SwitchMap$com$kugou$framework$lyric4$cell$State[getState().ordinal()];
            if (i5 == 1) {
                selectLinePaint.setTextSize(getAttachInfo().getTextSize() * f2);
                strokePaint.setTextSize(getAttachInfo().getTextSize() * f2);
                lineHeight = f4 + this.mAnimationLyricInfos[i2].getLineHeight() + this.mLineSpacing;
                if (this.mShowHighLightLine) {
                    if (this.mAttachInfo.isStroke()) {
                        LyricLineInfo[] lyricLineInfoArr2 = this.mAnimationLyricInfos;
                        paint = selectLinePaint;
                        drawText(canvas, lyricLineInfoArr2[i2], lyricLineInfoArr2[i2].getLyricLine(), f6 - this.mAttachInfo.getStrokeSize(), f5, baseLineOffset + this.mAttachInfo.getStrokeSize(), strokePaint);
                    } else {
                        paint = selectLinePaint;
                    }
                    LyricLineInfo[] lyricLineInfoArr3 = this.mAnimationLyricInfos;
                    drawText(canvas, lyricLineInfoArr3[i2], lyricLineInfoArr3[i2].getLyricLine(), f6, f5, baseLineOffset, paint);
                } else if (this.mHighLightWordIndex < i3) {
                    if (this.mAttachInfo.isStroke()) {
                        LyricLineInfo[] lyricLineInfoArr4 = this.mAnimationLyricInfos;
                        drawText(canvas, lyricLineInfoArr4[i2], lyricLineInfoArr4[i2].getLyricLine(), f6 - this.mAttachInfo.getStrokeSize(), f5, baseLineOffset + this.mAttachInfo.getStrokeSize(), strokePaint);
                    }
                    LyricLineInfo[] lyricLineInfoArr5 = this.mAnimationLyricInfos;
                    drawText(canvas, lyricLineInfoArr5[i2], lyricLineInfoArr5[i2].getLyricLine(), f6, f5, baseLineOffset, getDefaultHighLightPaint());
                }
                length = this.mAnimationLyricInfos[i2].getLyricWords().length;
            } else if (i5 == 2) {
                selectLinePaint.setTextSize(getAttachInfo().getTextSize() * getAttachInfo().getHighLightTextZoomRate() * f2);
                strokePaint.setTextSize(getAttachInfo().getTextSize() * getAttachInfo().getHighLightTextZoomRate() * f2);
                lineHeight = f4 + this.mAnimationLyricInfos[i2].getLineHeight() + this.mLineSpacing;
                if (this.mAttachInfo.isStroke()) {
                    LyricLineInfo[] lyricLineInfoArr6 = this.mAnimationLyricInfos;
                    paint2 = selectLinePaint;
                    drawText(canvas, lyricLineInfoArr6[i2], lyricLineInfoArr6[i2].getLyricLine(), f6 - this.mAttachInfo.getStrokeSize(), f5, baseLineOffset + this.mAttachInfo.getStrokeSize(), strokePaint);
                } else {
                    paint2 = selectLinePaint;
                }
                LyricLineInfo[] lyricLineInfoArr7 = this.mAnimationLyricInfos;
                drawText(canvas, lyricLineInfoArr7[i2], lyricLineInfoArr7[i2].getLyricLine(), f6, f5, baseLineOffset, paint2);
                length = this.mAnimationLyricInfos[i2].getLyricWords().length;
            } else if (i5 != 3) {
                i2++;
                f3 = lineHeight3;
            } else {
                selectLinePaint.setTextSize(getAttachInfo().getTextSize());
                strokePaint.setTextSize(getAttachInfo().getTextSize());
                lineHeight = f4 + this.mAnimationLyricInfos[i2].getLineHeight() + this.mLineSpacing;
                if (this.mAttachInfo.isStroke()) {
                    LyricLineInfo[] lyricLineInfoArr8 = this.mAnimationLyricInfos;
                    paint3 = selectLinePaint;
                    drawText(canvas, lyricLineInfoArr8[i2], lyricLineInfoArr8[i2].getLyricLine(), f6 - this.mAttachInfo.getStrokeSize(), f5, baseLineOffset + this.mAttachInfo.getStrokeSize(), strokePaint);
                } else {
                    paint3 = selectLinePaint;
                }
                LyricLineInfo[] lyricLineInfoArr9 = this.mAnimationLyricInfos;
                drawText(canvas, lyricLineInfoArr9[i2], lyricLineInfoArr9[i2].getLyricLine(), f6, f5, baseLineOffset, paint3);
                length = this.mAnimationLyricInfos[i2].getLyricWords().length;
            }
            i3 += length;
            f4 = lineHeight;
            i2++;
            f3 = lineHeight3;
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.mHighLightLyricInfo = updateLyricLineInfo(this.mLyricLineInfo, getAttachInfo().getHighLightTextZoomRate());
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCell(int i2, int i3, float f2) {
        this.mIsHighLighting = getAttachInfo().getCurrentHighLightLine() == this.mLine;
        int length = getLyricLineInfos().length;
        StringBuilder sb = new StringBuilder();
        int lineHeight = 0;
        for (int i4 = 0; i4 < length; i4++) {
            LyricLineInfo lyricLineInfo = getLyricLineInfos()[i4];
            if (lyricLineInfo != null) {
                lineHeight = (int) (lineHeight + lyricLineInfo.getLineHeight());
                sb.append(lyricLineInfo.getLyricLine());
            }
        }
        this.mLyricLine = sb.toString();
        setMeasureResult(i2, lineHeight + (this.mLineSpacing * (getLyricLineInfos().length - 1)) + getPaddingTop() + getPaddingBottom());
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
        this.mAnimationLyricInfos = updateAnimationLyricLineInfo(f2);
        int i4 = 0;
        int lineHeight = 0;
        while (true) {
            LyricLineInfo[] lyricLineInfoArr = this.mAnimationLyricInfos;
            if (i4 >= lyricLineInfoArr.length) {
                setMeasureResult(i2, lineHeight + (this.mLineSpacing * (lyricLineInfoArr.length - 1)) + getPaddingTop() + getPaddingBottom());
                return;
            } else {
                lineHeight = (int) (lineHeight + lyricLineInfoArr[i4].getLineHeight());
                i4++;
            }
        }
    }
}
