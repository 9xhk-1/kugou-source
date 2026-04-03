package com.kugou.uilib.widget.textview.delegate;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.textview.delegate.TextViewDelegate")
public class DrawableSizeDelegate extends TextViewDelegate {
    private final int DEFAULT_VALUE = -1;
    private float leftHeight = -1.0f;
    private float leftWidth = -1.0f;
    private float rightHeight = -1.0f;
    private float rightWidth = -1.0f;
    private float topHeight = -1.0f;
    private float topWidth = -1.0f;
    private float bottomHeight = -1.0f;
    private float bottomWidth = -1.0f;

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUITextView_kgui_textview_leftdrawable_height) || typedArray.hasValue(R.styleable.KGUITextView_kgui_textview_leftdrawable_width) || typedArray.hasValue(R.styleable.KGUITextView_kgui_textview_rightdrawable_height) || typedArray.hasValue(R.styleable.KGUITextView_kgui_textview_rightdrawable_width) || typedArray.hasValue(R.styleable.KGUITextView_kgui_textview_topdrawable_height) || typedArray.hasValue(R.styleable.KGUITextView_kgui_textview_topdrawable_width) || typedArray.hasValue(R.styleable.KGUITextView_kgui_textview_bottomdrawable_height) || typedArray.hasValue(R.styleable.KGUITextView_kgui_textview_bottomdrawable_width);
    }

    private void setImageSize(Drawable drawable, int i2) {
        float f2;
        float f3;
        if (drawable == null) {
            return;
        }
        if (i2 == 0) {
            f2 = this.leftHeight;
            f3 = this.leftWidth;
        } else if (i2 == 1) {
            f2 = this.topHeight;
            f3 = this.topWidth;
        } else if (i2 == 2) {
            f2 = this.rightHeight;
            f3 = this.rightWidth;
        } else if (i2 != 3) {
            f2 = -1.0f;
            f3 = -1.0f;
        } else {
            f2 = this.bottomHeight;
            f3 = this.bottomWidth;
        }
        if (f3 == -1.0f || f2 == -1.0f) {
            return;
        }
        drawable.setBounds(0, 0, (int) f3, (int) f2);
    }

    public void setDrawableSize(int i2, int i3, int i4) {
        Drawable drawable = ((TextView) this.mView).getCompoundDrawables()[i2];
        if (drawable == null || i3 == -1 || i4 == -1) {
            return;
        }
        drawable.setBounds(0, 0, i3, i4);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(TextView textView, TypedArray typedArray) {
        super.init(textView, typedArray);
        if (typedArray != null) {
            this.leftHeight = typedArray.getDimension(R.styleable.KGUITextView_kgui_textview_leftdrawable_height, -1.0f);
            this.leftWidth = typedArray.getDimension(R.styleable.KGUITextView_kgui_textview_leftdrawable_width, -1.0f);
            this.rightHeight = typedArray.getDimension(R.styleable.KGUITextView_kgui_textview_rightdrawable_height, -1.0f);
            this.rightWidth = typedArray.getDimension(R.styleable.KGUITextView_kgui_textview_rightdrawable_width, -1.0f);
            this.topHeight = typedArray.getDimension(R.styleable.KGUITextView_kgui_textview_topdrawable_height, -1.0f);
            this.topWidth = typedArray.getDimension(R.styleable.KGUITextView_kgui_textview_topdrawable_width, -1.0f);
            this.bottomHeight = typedArray.getDimension(R.styleable.KGUITextView_kgui_textview_bottomdrawable_height, -1.0f);
            this.bottomWidth = typedArray.getDimension(R.styleable.KGUITextView_kgui_textview_bottomdrawable_width, -1.0f);
            Drawable[] compoundDrawables = ((TextView) this.mView).getCompoundDrawables();
            int length = compoundDrawables.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                setImageSize(compoundDrawables[i2], i3);
                i2++;
                i3++;
            }
            ((TextView) this.mView).setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
    }
}
