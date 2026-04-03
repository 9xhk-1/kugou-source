package com.kugou.uilib.widget.textview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserView;
import java.lang.Character;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIVerticalTextView extends KGUITextView {
    private boolean mIsVerticalMode;
    private int[] mLineBreakIndex;
    private int mLineCount;
    private float[] mLineWidths;

    public KGUIVerticalTextView(Context context) {
        super(context);
        this.mIsVerticalMode = true;
        init();
    }

    private void init() {
    }

    private static boolean isCJKCharacter(int i2) {
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(i2);
        return unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlockOf == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || unicodeBlockOf == Character.UnicodeBlock.HANGUL_SYLLABLES || unicodeBlockOf == Character.UnicodeBlock.HANGUL_JAMO || unicodeBlockOf == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO || unicodeBlockOf == Character.UnicodeBlock.HIRAGANA || unicodeBlockOf == Character.UnicodeBlock.KATAKANA || unicodeBlockOf == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    public boolean isVerticalMode() {
        return this.mIsVerticalMode;
    }

    @Override // com.kugou.uilib.widget.textview.KGUIBaseTextView, android.widget.TextView, android.view.View
    @TargetApi(16)
    public void onDraw(Canvas canvas) {
        Paint.FontMetricsInt fontMetricsInt;
        if (!this.mIsVerticalMode) {
            super.onDraw(canvas);
            return;
        }
        if (this.mLineCount == 0) {
            return;
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        char[] charArray = getText().toString().toCharArray();
        canvas.save();
        float width = (getWidth() - getPaddingRight()) - this.mLineWidths[0];
        float lineSpacingMultiplier = width;
        float paddingTop = getPaddingTop();
        int i2 = 0;
        int i3 = 0;
        while (i2 < charArray.length) {
            int iCodePointAt = Character.codePointAt(charArray, i2);
            int iCharCount = Character.charCount(iCodePointAt);
            boolean z = !isCJKCharacter(iCodePointAt);
            int iSave = canvas.save();
            if (z) {
                canvas.rotate(90.0f, width, paddingTop);
            }
            float f2 = z ? (paddingTop - ((this.mLineWidths[i3] - (fontMetricsInt2.bottom - fontMetricsInt2.top)) / 2.0f)) - fontMetricsInt2.descent : paddingTop - fontMetricsInt2.ascent;
            float f3 = width;
            Paint.FontMetricsInt fontMetricsInt3 = fontMetricsInt2;
            int i4 = i2;
            canvas.drawText(charArray, i2, iCharCount, width, f2, paint);
            canvas.restoreToCount(iSave);
            i2 = i4 + iCharCount;
            if (i2 < charArray.length) {
                if (i4 + 1 > this.mLineBreakIndex[i3]) {
                    int i5 = i3 + 1;
                    float[] fArr = this.mLineWidths;
                    if (i5 < fArr.length) {
                        lineSpacingMultiplier -= (fArr[i5] * getLineSpacingMultiplier()) + getLineSpacingExtra();
                        i3 = i5;
                        paddingTop = getPaddingTop();
                        width = lineSpacingMultiplier;
                        fontMetricsInt = fontMetricsInt3;
                    }
                }
                if (z) {
                    paddingTop += paint.measureText(charArray, i4, iCharCount);
                    fontMetricsInt = fontMetricsInt3;
                    width = f3;
                } else {
                    fontMetricsInt = fontMetricsInt3;
                    paddingTop += fontMetricsInt.descent - fontMetricsInt.ascent;
                    width = f3;
                }
            } else {
                fontMetricsInt = fontMetricsInt3;
                width = f3;
            }
            fontMetricsInt2 = fontMetricsInt;
        }
        canvas.restore();
    }

    @Override // com.kugou.uilib.widget.textview.KGUIBaseTextView, android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        int i4;
        float fMeasureText;
        float f2;
        super.onMeasure(i2, i3);
        if (this.mIsVerticalMode) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i2);
            int size2 = View.MeasureSpec.getSize(i3);
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            float paddingTop = getPaddingTop() + getPaddingBottom();
            char[] charArray = getText().toString().toCharArray();
            TextPaint paint = getPaint();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int paddingBottom = (mode2 == 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : size2) - getPaddingBottom();
            float paddingTop2 = getPaddingTop();
            this.mLineCount = 0;
            this.mLineWidths = new float[charArray.length + 1];
            this.mLineBreakIndex = new int[charArray.length + 1];
            float f3 = paddingTop2;
            int i5 = 0;
            int i6 = 0;
            int i7 = 1;
            while (i5 < charArray.length) {
                int iCharCount = Character.charCount(Character.codePointAt(charArray, i5));
                if (!isCJKCharacter(r12)) {
                    i4 = size;
                    f2 = fontMetricsInt.descent - fontMetricsInt.ascent;
                    fMeasureText = paint.measureText(charArray, i5, iCharCount);
                } else {
                    i4 = size;
                    float fMeasureText2 = paint.measureText(charArray, i5, iCharCount);
                    fMeasureText = fontMetricsInt.descent - fontMetricsInt.ascent;
                    f2 = fMeasureText2;
                }
                float f4 = paddingTop2 + fMeasureText;
                TextPaint textPaint = paint;
                if (f4 > ((float) paddingBottom) && i5 > 0) {
                    if (f3 >= paddingTop2) {
                        paddingTop2 = f3;
                    }
                    this.mLineBreakIndex[i6] = i5 - iCharCount;
                    paddingLeft += this.mLineWidths[i6];
                    i6++;
                    f3 = paddingTop2;
                    paddingTop2 = getPaddingTop() + fMeasureText;
                } else {
                    paddingTop2 = f4;
                    if (f3 < f4) {
                        f3 = paddingTop2;
                    }
                }
                float[] fArr = this.mLineWidths;
                if (fArr[i6] < f2) {
                    fArr[i6] = f2;
                }
                i5 += iCharCount;
                if (i5 >= charArray.length) {
                    paddingLeft += fArr[i6];
                    paddingTop = getPaddingBottom() + f3;
                }
                i7 = iCharCount;
                size = i4;
                paint = textPaint;
            }
            int i8 = size;
            if (charArray.length > 0) {
                this.mLineCount = i6 + 1;
                this.mLineBreakIndex[i6] = charArray.length - i7;
            }
            int i9 = this.mLineCount;
            if (i9 > 1) {
                int i10 = i9 - 1;
                for (int i11 = 0; i11 < i10; i11++) {
                    paddingLeft += (this.mLineWidths[i11] * (getLineSpacingMultiplier() - 1.0f)) + getLineSpacingExtra();
                }
            }
            if (mode2 == 1073741824) {
                paddingTop = size2;
            } else if (mode2 == Integer.MIN_VALUE) {
                paddingTop = Math.min(paddingTop, size2);
            }
            if (mode == 1073741824) {
                paddingLeft = i8;
            } else if (mode == Integer.MIN_VALUE) {
                paddingLeft = Math.min(paddingLeft, i8);
            }
            setMeasuredDimension((int) paddingLeft, (int) paddingTop);
        }
    }

    public void setVerticalMode(boolean z) {
        this.mIsVerticalMode = z;
        requestLayout();
    }

    public KGUIVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsVerticalMode = true;
        init();
    }

    public KGUIVerticalTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsVerticalMode = true;
        init();
    }
}
