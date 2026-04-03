package com.kugou.uilib.widget.textview.span;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class KGUILinkTouchMovementMethod extends LinkMovementMethod {
    private static KGUILinkTouchDecorHelper sHelper = new KGUILinkTouchDecorHelper();
    private static KGUILinkTouchMovementMethod sInstance;

    public static MovementMethod getInstance() {
        if (sInstance == null) {
            sInstance = new KGUILinkTouchMovementMethod();
        }
        return sInstance;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return sHelper.onTouchEvent(textView, spannable, motionEvent) || Touch.onTouchEvent(textView, spannable, motionEvent);
    }
}
