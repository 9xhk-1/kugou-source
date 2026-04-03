package com.kugou.uilib.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.textview.span.KGUITouchableSpan;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIExpandableTextView extends KGUISpanTextView {
    private static final String GAP_TO_EXPAND_HINT = " ";
    private static final String GAP_TO_SHRINK_HINT = " ";
    private static final int MAX_LINES_ON_SHRINK = 3;
    private static final boolean SHOW_TO_EXPAND_HINT = true;
    private static final boolean SHOW_TO_SHRINK_HINT = true;
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    private TextView.BufferType mBufferType;
    private int mCurrState;
    private String mEllipsisHint;
    private String mGapToExpandHint;
    private String mGapToShrinkHint;
    private Layout mLayout;
    private int mLayoutWidth;
    private int mMaxLinesOnShrink;
    private CharSequence mOrigText;
    private boolean mShowToExpandHint;
    private boolean mShowToShrinkHint;
    private int mTextLineCount;
    private TextPaint mTextPaint;
    private String mToExpandHint;
    private String mToShrinkHint;
    private boolean mToggleEnable;
    private KGUITouchableSpan mTouchableSpan;

    public KGUIExpandableTextView(Context context) {
        this(context, null, 0);
    }

    private String getContentOfString(String str) {
        return str == null ? "" : str;
    }

    private int getLengthOfString(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence getNewTextByConfig() {
        String str;
        int i2;
        int i3;
        int i4;
        if (TextUtils.isEmpty(this.mOrigText)) {
            return this.mOrigText;
        }
        Layout layout = getLayout();
        this.mLayout = layout;
        if (layout != null) {
            this.mLayoutWidth = layout.getWidth();
        }
        if (this.mLayoutWidth <= 0) {
            if (getWidth() == 0) {
                return this.mOrigText;
            }
            this.mLayoutWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        }
        this.mTextPaint = getPaint();
        this.mTextLineCount = -1;
        int i5 = this.mCurrState;
        if (i5 != 0) {
            if (i5 != 1) {
                return this.mOrigText;
            }
            if (!this.mShowToShrinkHint) {
                return this.mOrigText;
            }
            DynamicLayout dynamicLayout = new DynamicLayout(this.mOrigText, this.mTextPaint, this.mLayoutWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            this.mLayout = dynamicLayout;
            int lineCount = dynamicLayout.getLineCount();
            this.mTextLineCount = lineCount;
            if (lineCount <= this.mMaxLinesOnShrink) {
                return this.mOrigText;
            }
            SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(this.mOrigText).append((CharSequence) this.mGapToShrinkHint).append((CharSequence) this.mToShrinkHint);
            spannableStringBuilderAppend.setSpan(this.mTouchableSpan, spannableStringBuilderAppend.length() - getLengthOfString(this.mToShrinkHint), spannableStringBuilderAppend.length(), 33);
            return spannableStringBuilderAppend;
        }
        DynamicLayout dynamicLayout2 = new DynamicLayout(this.mOrigText, this.mTextPaint, this.mLayoutWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.mLayout = dynamicLayout2;
        int lineCount2 = dynamicLayout2.getLineCount();
        this.mTextLineCount = lineCount2;
        if (lineCount2 <= this.mMaxLinesOnShrink) {
            return this.mOrigText;
        }
        int lineEnd = getValidLayout().getLineEnd(this.mMaxLinesOnShrink - 1);
        int lineStart = getValidLayout().getLineStart(this.mMaxLinesOnShrink - 1);
        int lengthOfString = (lineEnd - getLengthOfString(this.mEllipsisHint)) - (this.mShowToExpandHint ? getLengthOfString(this.mToExpandHint) + getLengthOfString(this.mGapToExpandHint) : 0);
        if (lengthOfString > lineStart) {
            lineEnd = lengthOfString;
        }
        int width = getValidLayout().getWidth();
        double dMeasureText = this.mTextPaint.measureText(this.mOrigText.subSequence(lineStart, lineEnd).toString());
        Double.isNaN(dMeasureText);
        int i6 = width - ((int) (dMeasureText + 0.5d));
        TextPaint textPaint = this.mTextPaint;
        StringBuilder sb = new StringBuilder();
        sb.append(getContentOfString(this.mEllipsisHint));
        if (this.mShowToExpandHint) {
            str = getContentOfString(this.mToExpandHint) + getContentOfString(this.mGapToExpandHint);
        } else {
            str = "";
        }
        sb.append(str);
        float fMeasureText = textPaint.measureText(sb.toString());
        float f2 = i6;
        if (f2 > fMeasureText) {
            int i7 = 0;
            int i8 = 0;
            while (f2 > i7 + fMeasureText && (i4 = lineEnd + (i8 = i8 + 1)) <= this.mOrigText.length()) {
                double dMeasureText2 = this.mTextPaint.measureText(this.mOrigText.subSequence(lineEnd, i4).toString());
                Double.isNaN(dMeasureText2);
                i7 = (int) (dMeasureText2 + 0.5d);
            }
            i2 = lineEnd + (i8 - 2);
        } else {
            int i9 = 0;
            int i10 = 0;
            while (i9 + i6 < fMeasureText && (i3 = lineEnd + (i10 - 1)) > lineStart) {
                double dMeasureText3 = this.mTextPaint.measureText(this.mOrigText.subSequence(i3, lineEnd).toString());
                Double.isNaN(dMeasureText3);
                i9 = (int) (dMeasureText3 + 0.5d);
            }
            i2 = lineEnd + i10;
        }
        SpannableStringBuilder spannableStringBuilderAppend2 = new SpannableStringBuilder(removeEndLineBreak(this.mOrigText.subSequence(0, i2))).append((CharSequence) this.mEllipsisHint);
        if (this.mShowToExpandHint) {
            spannableStringBuilderAppend2.append((CharSequence) (getContentOfString(this.mGapToExpandHint) + getContentOfString(this.mToExpandHint)));
            spannableStringBuilderAppend2.setSpan(this.mTouchableSpan, spannableStringBuilderAppend2.length() - getLengthOfString(this.mToExpandHint), spannableStringBuilderAppend2.length(), 33);
        }
        return spannableStringBuilderAppend2;
    }

    private Layout getValidLayout() {
        Layout layout = this.mLayout;
        return layout != null ? layout : getLayout();
    }

    private void init() {
        this.mTouchableSpan = new KGUITouchableSpan(this.spanNormalColor, this.spanPressedColor, this.spanNormalBgColor, this.spanPressedBgColor) { // from class: com.kugou.uilib.widget.textview.KGUIExpandableTextView.1
            @Override // com.kugou.uilib.widget.textview.span.KGUITouchableSpan
            public void onSpanClick(View view) {
                if (KGUIExpandableTextView.this.mToggleEnable) {
                    KGUIExpandableTextView.this.toggle();
                }
            }
        };
        setMovementMethodDefault();
        if (TextUtils.isEmpty(this.mEllipsisHint)) {
            this.mEllipsisHint = getResources().getString(R.string.kgui_ellisize_suffix);
        }
        if (TextUtils.isEmpty(this.mToExpandHint)) {
            this.mToExpandHint = getResources().getString(R.string.kgui_ellisize_all);
        }
        if (TextUtils.isEmpty(this.mToShrinkHint)) {
            this.mToShrinkHint = getResources().getString(R.string.kgui_ellisize_ellisize);
        }
    }

    private void parseAttr(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes;
        if (attributeSet == null || (typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUIExpandableTextView)) == null) {
            return;
        }
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.KGUIExpandableTextView_kgui_MaxLinesOnShrink) {
                this.mMaxLinesOnShrink = typedArrayObtainStyledAttributes.getInteger(index, 3);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_EllipsisHint) {
                this.mEllipsisHint = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_ToExpandHint) {
                this.mToExpandHint = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_ToShrinkHint) {
                this.mToShrinkHint = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_ToExpandHintShow) {
                this.mShowToExpandHint = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_ToShrinkHintShow) {
                this.mShowToShrinkHint = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_EnableToggle) {
                this.mToggleEnable = typedArrayObtainStyledAttributes.getBoolean(index, true);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_InitState) {
                this.mCurrState = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_GapToExpandHint) {
                this.mGapToExpandHint = typedArrayObtainStyledAttributes.getString(index);
            } else if (index == R.styleable.KGUIExpandableTextView_kgui_GapToShrinkHint) {
                this.mGapToShrinkHint = typedArrayObtainStyledAttributes.getString(index);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private CharSequence removeEndLineBreak(CharSequence charSequence) {
        while (charSequence.toString().endsWith("\n")) {
            charSequence = charSequence.subSequence(0, charSequence.length() - 1);
        }
        return charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTextInternal(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggle() {
        int i2 = this.mCurrState;
        if (i2 == 0) {
            this.mCurrState = 1;
        } else if (i2 == 1) {
            this.mCurrState = 0;
        }
        setTextInternal(getNewTextByConfig(), this.mBufferType);
    }

    @Override // com.kugou.uilib.widget.textview.KGUIBaseTextView, android.widget.TextView
    public void setText(CharSequence charSequence, final TextView.BufferType bufferType) {
        this.mOrigText = charSequence;
        this.mBufferType = bufferType;
        post(new Runnable() { // from class: com.kugou.uilib.widget.textview.KGUIExpandableTextView.2
            @Override // java.lang.Runnable
            public void run() {
                KGUIExpandableTextView kGUIExpandableTextView = KGUIExpandableTextView.this;
                kGUIExpandableTextView.setTextInternal(kGUIExpandableTextView.getNewTextByConfig(), bufferType);
            }
        });
        setTextInternal(getNewTextByConfig(), bufferType);
    }

    public KGUIExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUIExpandableTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mGapToExpandHint = " ";
        this.mGapToShrinkHint = " ";
        this.mShowToExpandHint = true;
        this.mShowToShrinkHint = true;
        this.mMaxLinesOnShrink = 3;
        this.mCurrState = 0;
        this.mToggleEnable = true;
        this.mBufferType = TextView.BufferType.NORMAL;
        this.mTextLineCount = -1;
        this.mLayoutWidth = 0;
        parseAttr(context, attributeSet);
        init();
    }
}
