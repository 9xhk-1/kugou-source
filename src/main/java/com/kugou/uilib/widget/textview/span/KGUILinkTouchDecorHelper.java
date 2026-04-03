package com.kugou.uilib.widget.textview.span;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.widget.TextView;
import com.kugou.uilib.utils.KGUILog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class KGUILinkTouchDecorHelper {
    private WeakReference<ITouchableSpan> mPressedSpanRf;

    public ITouchableSpan getPressedSpan(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = x - textView.getTotalPaddingLeft();
        int totalPaddingTop = y - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        float f2 = scrollX;
        try {
            int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f2);
            if (f2 < layout.getLineLeft(lineForVertical) || f2 > layout.getLineRight(lineForVertical)) {
                offsetForHorizontal = -1;
            }
            ITouchableSpan[] iTouchableSpanArr = (ITouchableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ITouchableSpan.class);
            if (iTouchableSpanArr.length > 0) {
                return iTouchableSpanArr[0];
            }
            return null;
        } catch (IndexOutOfBoundsException e2) {
            if (KGUILog.DEBUG) {
                KGUILog.d("TouchDecorHelper-getPressedSpan", e2.getMessage());
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() == 0) {
            ITouchableSpan pressedSpan = getPressedSpan(textView, spannable, motionEvent);
            if (pressedSpan != null) {
                pressedSpan.setPressed(true);
                Selection.setSelection(spannable, spannable.getSpanStart(pressedSpan), spannable.getSpanEnd(pressedSpan));
                this.mPressedSpanRf = new WeakReference<>(pressedSpan);
            }
            if (textView instanceof ISpanTouchFix) {
                ((ISpanTouchFix) textView).setTouchSpanHit(pressedSpan != null);
            }
            return pressedSpan != null;
        }
        if (motionEvent.getAction() == 2) {
            WeakReference<ITouchableSpan> weakReference = this.mPressedSpanRf;
            ITouchableSpan iTouchableSpan = weakReference != null ? weakReference.get() : null;
            if (textView instanceof ISpanTouchFix) {
                ((ISpanTouchFix) textView).setTouchSpanHit(iTouchableSpan != null);
            }
            return iTouchableSpan != null;
        }
        if (motionEvent.getAction() != 1) {
            WeakReference<ITouchableSpan> weakReference2 = this.mPressedSpanRf;
            ITouchableSpan iTouchableSpan2 = weakReference2 != null ? weakReference2.get() : null;
            if (iTouchableSpan2 != null) {
                iTouchableSpan2.setPressed(false);
            }
            if (textView instanceof ISpanTouchFix) {
                ((ISpanTouchFix) textView).setTouchSpanHit(false);
            }
            this.mPressedSpanRf = null;
            Selection.removeSelection(spannable);
            return false;
        }
        WeakReference<ITouchableSpan> weakReference3 = this.mPressedSpanRf;
        ITouchableSpan iTouchableSpan3 = weakReference3 != null ? weakReference3.get() : null;
        if (iTouchableSpan3 != null) {
            iTouchableSpan3.setPressed(false);
            if (motionEvent.getAction() == 1) {
                iTouchableSpan3.onClick(textView);
            }
        } else {
            z = false;
        }
        this.mPressedSpanRf = null;
        Selection.removeSelection(spannable);
        if (textView instanceof ISpanTouchFix) {
            ((ISpanTouchFix) textView).setTouchSpanHit(z);
        }
        return z;
    }
}
