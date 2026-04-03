package com.kugou.uilib.widget.textview.delegate;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.textview.delegate.TextViewDelegate")
public class CenterLeftDrawableDelegate<T extends TextView> extends TextViewDelegate {
    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.KGUITextView_kgui_textview_leftdrawable_center, false);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        Drawable[] compoundDrawables = ((TextView) this.mView).getCompoundDrawables();
        if (compoundDrawables != null && (drawable = compoundDrawables[0]) != null) {
            canvas.translate((((TextView) this.mView).getWidth() - ((((TextView) this.mView).getPaint().measureText(((TextView) this.mView).getText().toString()) + drawable.getIntrinsicWidth()) + ((TextView) this.mView).getCompoundDrawablePadding())) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }
}
