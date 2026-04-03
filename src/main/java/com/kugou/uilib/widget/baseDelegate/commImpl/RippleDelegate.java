package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.baseDelegate.IViewDelegate")
public class RippleDelegate<T extends View> extends AbsViewDelegate<T> {
    private ColorStateList mRippleColor;

    public static boolean isNeed(TypedArray typedArray) {
        return Build.VERSION.SDK_INT >= 21 && typedArray.hasValue(R.styleable.KGUIView_kgui_ripple_color);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public Drawable getWarpBackground(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new RippleDrawable(this.mRippleColor, drawable, drawable == null ? new ColorDrawable(-1) : drawable);
        }
        return drawable;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        super.init(t, typedArray);
        this.mRippleColor = typedArray.getColorStateList(R.styleable.KGUIView_kgui_ripple_color);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onFinishInflate() {
        T t = this.mView;
        t.setBackground(t.getBackground());
    }
}
