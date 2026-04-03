package com.kugou.uilib.widget.textview.delegate;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.textview.delegate.TextViewDelegate")
public class TextColorAlphaDelegate extends TextViewDelegate {
    private float alpha = 1.0f;

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUITextView_kgui_text_alpha);
    }

    @Override // com.kugou.uilib.widget.textview.delegate.TextViewDelegate
    public int getTextColor(int i2) {
        float f2 = this.alpha;
        return f2 < 1.0f ? Color.argb((int) (f2 * 255.0f), Color.red(i2), Color.green(i2), Color.blue(i2)) : i2;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onFinishInflate() {
        super.onFinishInflate();
        T t = this.mView;
        ((TextView) t).setTextColor(((TextView) t).getCurrentTextColor());
    }

    public void setTextAlpha(float f2) {
        this.alpha = f2;
        T t = this.mView;
        ((TextView) t).setTextColor(((TextView) t).getCurrentTextColor());
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(TextView textView, TypedArray typedArray) {
        super.init(textView, typedArray);
        this.alpha = typedArray.getFloat(R.styleable.KGUITextView_kgui_text_alpha, 1.0f);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(TextView textView) {
        super.init(textView);
    }
}
