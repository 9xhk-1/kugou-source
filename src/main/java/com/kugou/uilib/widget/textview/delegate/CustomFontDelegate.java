package com.kugou.uilib.widget.textview.delegate;

import android.content.res.TypedArray;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.widget.textview.font.FontManager;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.textview.delegate.TextViewDelegate")
public class CustomFontDelegate extends TextViewDelegate {
    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUITextView_kgui_custom_font);
    }

    public void setTypeFace(int i2) {
        T t = this.mView;
        ((TextView) t).setTypeface(FontManager.getInstance(((TextView) t).getContext()).getFontType(i2));
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(TextView textView, TypedArray typedArray) {
        super.init(textView, typedArray);
        int integer = typedArray.getInteger(R.styleable.KGUITextView_kgui_custom_font, 0);
        T t = this.mView;
        ((TextView) t).setTypeface(FontManager.getInstance(((TextView) t).getContext()).getFontType(integer));
    }
}
