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
public class WrapLineLrcCell extends WrapLineCell {
    private LyricLineInfo[] mAnimationLyricInfos;
    private LyricLineInfo[] mHighLightLyricInfo;

    /* JADX INFO: renamed from: com.kugou.framework.lyric4.cell.lyric.WrapLineLrcCell$1, reason: invalid class name */
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

    public WrapLineLrcCell(Context context, String[] strArr, AttachInfo attachInfo, int i2) {
        super(context, strArr, attachInfo, i2);
    }

    private LyricLineInfo[] getLyricInfo() {
        return this.mIsHighLighting ? this.mHighLightLyricInfo : this.mLyricLineInfo;
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
        if (this.mAttachInfo.isStroke()) {
            drawText(canvas, lyricLineInfo, str, f2 - this.mAttachInfo.getStrokeSize(), f3, f4 + this.mAttachInfo.getStrokeSize(), getStrokePaint());
        }
        if (this.mIsHighLighting) {
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getPlayLinePaint(getHighLightPaint()));
        } else {
            drawText(canvas, lyricLineInfo, str, f2, f3, f4, getSelectLinePaint(getDefaultPaint()));
        }
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
        this.mIsHighLighting = getAttachInfo().getCurrentHighLightLine() == this.mLine;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int length = 0;
        while (i2 < getLyricInfo().length) {
            float lineHeight = f2 + (getLyricInfo()[i2].getLineHeight() / 2.0f);
            float baseLineOffset = this.mVisibleRect.top + lineHeight + getLyricInfo()[i2].getBaseLineOffset();
            float f4 = this.mVisibleRect.top + f3;
            float lineHeight2 = lineHeight + (getLyricInfo()[i2].getLineHeight() / 2.0f) + this.mLineSpacing;
            int alignMode = getAlignMode();
            if (alignMode == 0) {
                lineWidth = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - getLyricInfo()[i2].getLineWidth()) / 2.0f);
            } else if (alignMode == 1 || alignMode != 2) {
                int i3 = getVisibleRect().left;
                lineWidth = i3;
            } else {
                lineWidth = getVisibleRect().right - getLyricInfo()[i2].getLineWidth();
            }
            float f5 = lineWidth;
            RectF rectF = this.mTempRect;
            rectF.left = f5;
            rectF.top = getVisibleRect().top + f3;
            this.mTempRect.right = getLyricInfo()[i2].getLineWidth() + f5;
            RectF rectF2 = this.mTempRect;
            rectF2.bottom = rectF2.top + getLyricInfo()[i2].getLineHeight();
            float lineHeight3 = f3 + getLyricInfo()[i2].getLineHeight() + this.mLineSpacing;
            if (isRectInVisibleRange(this.mTempRect)) {
                drawLyricLine(canvas, getLyricInfo()[i2], getLyricInfo()[i2].getLyricLine(), f5, f4, baseLineOffset, getDefaultPaint(), length, length + getLyricInfo()[i2].getLyricWords().length, this.mTempRect);
            }
            length += getLyricInfo()[i2].getLyricWords().length;
            i2++;
            f2 = lineHeight2;
            f3 = lineHeight3;
        }
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onDrawAnimation(Canvas canvas, float f2) {
        float lineWidth;
        this.mIsHighLighting = getAttachInfo().getCurrentHighLightLine() == this.mLine;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i2 = 0;
        while (true) {
            LyricLineInfo[] lyricLineInfoArr = this.mAnimationLyricInfos;
            if (i2 >= lyricLineInfoArr.length) {
                return;
            }
            float lineHeight = f3 + (lyricLineInfoArr[i2].getLineHeight() / 2.0f);
            float baseLineOffset = this.mVisibleRect.top + lineHeight + this.mAnimationLyricInfos[i2].getBaseLineOffset();
            float f5 = this.mVisibleRect.top + f4;
            float lineHeight2 = lineHeight + (this.mAnimationLyricInfos[i2].getLineHeight() / 2.0f) + this.mLineSpacing;
            int alignMode = getAlignMode();
            if (alignMode == 0) {
                lineWidth = getVisibleRect().left + (((getVisibleRect().right - getVisibleRect().left) - this.mAnimationLyricInfos[i2].getLineWidth()) / 2.0f);
            } else if (alignMode == 1 || alignMode != 2) {
                int i3 = getVisibleRect().left;
                lineWidth = i3;
            } else {
                lineWidth = getVisibleRect().right - this.mAnimationLyricInfos[i2].getLineWidth();
            }
            float f6 = lineWidth;
            Paint defaultPaint = getDefaultPaint();
            Paint strokePaint = getStrokePaint();
            int i4 = AnonymousClass1.$SwitchMap$com$kugou$framework$lyric4$cell$State[getState().ordinal()];
            if (i4 == 1) {
                defaultPaint.setTextSize(getAttachInfo().getTextSize() * f2);
                strokePaint.setTextSize(getAttachInfo().getTextSize() * f2);
            } else if (i4 == 2) {
                defaultPaint.setTextSize(getAttachInfo().getTextSize() * getAttachInfo().getHighLightTextZoomRate() * f2);
                strokePaint.setTextSize(getAttachInfo().getTextSize() * getAttachInfo().getHighLightTextZoomRate() * f2);
            } else if (i4 == 3) {
                defaultPaint.setTextSize(getAttachInfo().getTextSize());
                strokePaint.setTextSize(getAttachInfo().getTextSize());
            }
            float lineHeight3 = f4 + this.mAnimationLyricInfos[i2].getLineHeight() + this.mLineSpacing;
            if (this.mAttachInfo.isStroke()) {
                LyricLineInfo[] lyricLineInfoArr2 = this.mAnimationLyricInfos;
                drawText(canvas, lyricLineInfoArr2[i2], lyricLineInfoArr2[i2].getLyricLine(), f6 - this.mAttachInfo.getStrokeSize(), f5, baseLineOffset + this.mAttachInfo.getStrokeSize(), strokePaint);
            }
            if (this.mIsHighLighting) {
                LyricLineInfo[] lyricLineInfoArr3 = this.mAnimationLyricInfos;
                drawText(canvas, lyricLineInfoArr3[i2], lyricLineInfoArr3[i2].getLyricLine(), f6, f5, baseLineOffset, getPlayLinePaint(defaultPaint));
            } else {
                LyricLineInfo[] lyricLineInfoArr4 = this.mAnimationLyricInfos;
                drawText(canvas, lyricLineInfoArr4[i2], lyricLineInfoArr4[i2].getLyricLine(), f6, f5, baseLineOffset, defaultPaint);
            }
            int length = this.mAnimationLyricInfos[i2].getLyricWords().length;
            i2++;
            f3 = lineHeight2;
            f4 = lineHeight3;
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
        int lineHeight = 0;
        for (int i4 = 0; i4 < getLyricInfo().length; i4++) {
            lineHeight = (int) (lineHeight + getLyricInfo()[i4].getLineHeight());
        }
        setMeasureResult(i2, lineHeight + (this.mLineSpacing * (getLyricInfo().length - 1)) + getPaddingTop() + getPaddingBottom());
    }

    @Override // com.kugou.framework.lyric4.cell.lyric.WrapLineCell, com.kugou.framework.lyric4.cell.Cell
    public void onMeasureCellWithAnimation(int i2, int i3, float f2) {
        LyricLineInfo[] lyricLineInfoArrUpdateAnimationLyricLineInfo = updateAnimationLyricLineInfo(f2);
        this.mAnimationLyricInfos = lyricLineInfoArrUpdateAnimationLyricLineInfo;
        int lineHeight = 0;
        for (LyricLineInfo lyricLineInfo : lyricLineInfoArrUpdateAnimationLyricLineInfo) {
            lineHeight = (int) (lineHeight + lyricLineInfo.getLineHeight());
        }
        setMeasureResult(i2, lineHeight + (this.mLineSpacing * (this.mAnimationLyricInfos.length - 1)) + getPaddingTop() + getPaddingBottom());
    }
}
