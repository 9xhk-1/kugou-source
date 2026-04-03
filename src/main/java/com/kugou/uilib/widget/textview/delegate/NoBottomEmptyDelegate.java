package com.kugou.uilib.widget.textview.delegate;

import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.textview.delegate.TextViewDelegate")
public class NoBottomEmptyDelegate extends TextViewDelegate {
    private final Rect mLastLineShowRect = new Rect();
    private final Rect mLastLineActualIndexRect = new Rect();
    private boolean enable = true;

    private int calculateExtraSpace() {
        if (Build.VERSION.SDK_INT > 16) {
            int iMin = Math.min(((TextView) this.mView).getMaxLines(), ((TextView) this.mView).getLineCount()) - 1;
            int lineCount = ((TextView) this.mView).getLineCount() - 1;
            if (iMin >= 0) {
                Layout layout = ((TextView) this.mView).getLayout();
                int lineBounds = ((TextView) this.mView).getLineBounds(iMin, this.mLastLineShowRect);
                ((TextView) this.mView).getLineBounds(lineCount, this.mLastLineActualIndexRect);
                int measuredHeight = ((TextView) this.mView).getMeasuredHeight();
                int height = ((TextView) this.mView).getLayout().getHeight();
                int i2 = this.mLastLineActualIndexRect.bottom;
                int i3 = this.mLastLineShowRect.bottom;
                if (measuredHeight == height - (i2 - i3)) {
                    return i3 - (lineBounds + layout.getPaint().getFontMetricsInt().descent);
                }
            }
        }
        return 0;
    }

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.getBoolean(R.styleable.KGUITextView_kgui_textview_last_line_no_bottom, false);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public int[] measure(int i2, int i3) {
        if (this.enable) {
            return new int[]{i2, i3 - calculateExtraSpace()};
        }
        return null;
    }

    public void setEnable(boolean z) {
        this.enable = z;
        ((TextView) this.mView).requestLayout();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(TextView textView, TypedArray typedArray) {
        super.init(textView, typedArray);
    }
}
