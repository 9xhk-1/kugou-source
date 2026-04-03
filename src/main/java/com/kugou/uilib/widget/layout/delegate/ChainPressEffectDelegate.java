package com.kugou.uilib.widget.layout.delegate;

import android.content.res.TypedArray;
import android.view.ViewGroup;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.widget.layout.delegate.base.IViewGroupDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.layout.delegate.base.IViewGroupDelegate")
public class ChainPressEffectDelegate extends IViewGroupDelegate {
    private ViewGroup view;

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.KGUIViewGroup_kgui_press_chain_enable, false);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void drawableStateChanged() {
        boolean zIsPressed = this.view.isPressed();
        int childCount = this.view.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.view.getChildAt(i2).setPressed(zIsPressed);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(ViewGroup viewGroup, TypedArray typedArray) {
        this.view = viewGroup;
    }
}
