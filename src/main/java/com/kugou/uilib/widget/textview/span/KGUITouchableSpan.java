package com.kugou.uilib.widget.textview.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import com.kugou.uilib.utils.KGUILog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGUITouchableSpan extends ClickableSpan implements ITouchableSpan {
    private static final String TAG = "KGUITouchableSpan";
    private boolean mIsNeedUnderline = false;
    private boolean mIsPressed;

    @ColorInt
    private int mNormalBackgroundColor;

    @ColorInt
    private int mNormalTextColor;

    @ColorInt
    private int mPressedBackgroundColor;

    @ColorInt
    private int mPressedTextColor;

    public KGUITouchableSpan(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        this.mNormalTextColor = i2;
        this.mPressedTextColor = i3;
        this.mNormalBackgroundColor = i4;
        this.mPressedBackgroundColor = i5;
    }

    @Override // android.text.style.ClickableSpan, com.kugou.uilib.widget.textview.span.ITouchableSpan
    public final void onClick(View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            onSpanClick(view);
        }
    }

    public abstract void onSpanClick(View view);

    @Override // com.kugou.uilib.widget.textview.span.ITouchableSpan
    public void setPressed(boolean z) {
        this.mIsPressed = z;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        if (KGUILog.DEBUG) {
            KGUILog.i(TAG, "updateDrawState: mIsPressed=" + this.mIsPressed + " this=" + this);
        }
        textPaint.setColor(this.mIsPressed ? this.mPressedTextColor : this.mNormalTextColor);
        textPaint.bgColor = this.mIsPressed ? this.mPressedBackgroundColor : this.mNormalBackgroundColor;
        textPaint.setUnderlineText(this.mIsNeedUnderline);
    }
}
