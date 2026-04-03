package com.kugou.uilib.widget.textview.delegate;

import android.content.res.TypedArray;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.textview.delegate.TextViewDelegate")
public class MarqueeFocusedDelegate extends TextViewDelegate {
    private boolean enable = true;

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.KGUITextView_kgui_textview_marquee_focused, false);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public boolean isFocused() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        this.enable = z;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(TextView textView, TypedArray typedArray) {
        super.init(textView, typedArray);
    }
}
