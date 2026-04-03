package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.anno.ExposeMethod;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.baseDelegate.IViewDelegate")
public class RatioWHDelegate<T extends View> extends AbsViewDelegate<T> {
    public boolean baseWidth;
    public float ratio = -1.0f;

    private void initLayoutParams() {
        ViewGroup.LayoutParams layoutParams;
        if (this.ratio <= 0.0f || (layoutParams = this.mView.getLayoutParams()) == null) {
            return;
        }
        if (this.baseWidth) {
            layoutParams.height = 0;
        } else {
            layoutParams.width = 0;
        }
    }

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUIView_kgui_ratio_wh);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        super.init(t, typedArray);
        try {
            String string = typedArray.getString(R.styleable.KGUIView_kgui_ratio_wh);
            if (!TextUtils.isEmpty(string)) {
                String[] strArrSplit = string.split(",");
                if (strArrSplit.length == 2) {
                    this.baseWidth = strArrSplit[0].equals("w");
                    String[] strArrSplit2 = strArrSplit[1].split(":");
                    if (strArrSplit2.length == 2) {
                        this.ratio = Float.parseFloat(strArrSplit2[0]) / Float.parseFloat(strArrSplit2[1]);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.ratio = -1.0f;
        }
        initLayoutParams();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public int[] measure(int i2, int i3) {
        if (this.ratio <= 0.0f) {
            return null;
        }
        if (this.baseWidth) {
            int size = View.MeasureSpec.getSize(i2);
            if (size <= 0) {
                return null;
            }
            int i4 = (int) (size / this.ratio);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, BasicMeasure.EXACTLY);
            this.mView.getLayoutParams().height = i4;
            return new int[]{i2, iMakeMeasureSpec};
        }
        int size2 = View.MeasureSpec.getSize(i3);
        if (size2 <= 0) {
            return null;
        }
        int i5 = (int) (size2 * this.ratio);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, BasicMeasure.EXACTLY);
        this.mView.getLayoutParams().width = i5;
        return new int[]{iMakeMeasureSpec2, i3};
    }

    @ExposeMethod
    public void setBaseWidth(boolean z) {
        this.baseWidth = z;
    }

    @ExposeMethod
    public void setRatio(float f2) {
        this.ratio = f2;
        initLayoutParams();
        this.mView.requestLayout();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t) {
        super.init(t);
    }
}
