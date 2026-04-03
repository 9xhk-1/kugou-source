package com.kugou.uilib.widget.textview.delegate;

import android.content.res.TypedArray;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.textview.delegate.TextViewDelegate")
public class LineSpaceDelegate extends TextViewDelegate {
    private int minLineCount;
    private float mult;
    public Runnable setSpacingTask = new Runnable() { // from class: com.kugou.uilib.widget.textview.delegate.LineSpaceDelegate.1
        @Override // java.lang.Runnable
        public void run() {
            int lineCount = ((TextView) LineSpaceDelegate.this.mView).getLineCount();
            if (lineCount > LineSpaceDelegate.this.minLineCount) {
                ((TextView) LineSpaceDelegate.this.mView).setLineSpacing(((TextView) LineSpaceDelegate.this.mView).getLineSpacingExtra(), LineSpaceDelegate.this.mult);
            } else if (lineCount == LineSpaceDelegate.this.minLineCount) {
                ((TextView) LineSpaceDelegate.this.mView).setLineSpacing(((TextView) LineSpaceDelegate.this.mView).getLineSpacingExtra(), 0.0f);
            }
        }
    };

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUITextView_kgui_line_space_min_line_count) || typedArray.hasValue(R.styleable.KGUITextView_kgui_line_space_mult);
    }

    @Override // com.kugou.uilib.widget.textview.delegate.TextViewDelegate
    public void afterSetText() {
        ((TextView) this.mView).removeCallbacks(this.setSpacingTask);
        ((TextView) this.mView).post(this.setSpacingTask);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onFinishInflate() {
        afterSetText();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(TextView textView, TypedArray typedArray) {
        super.init(textView);
        this.minLineCount = typedArray.getInteger(R.styleable.KGUITextView_kgui_line_space_min_line_count, 1);
        this.mult = typedArray.getFloat(R.styleable.KGUITextView_kgui_line_space_mult, 1.5f);
    }
}
