package com.kugou.uilib.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.internal.view.SupportMenu;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.textview.span.ISpanTouchFix;
import com.kugou.uilib.widget.textview.span.KGUILinkTouchMovementMethod;
import com.kugou.uilib.widget.textview.span.SpanStrGenUtil;

/* JADX INFO: loaded from: classes2.dex */
public class KGUISpanTextView extends KGUITextView implements ISpanTouchFix {
    private static final String TAG = "KGUISpanTextView";
    private boolean enableAt;
    private boolean enableEmoji;
    private boolean enableLink;
    private boolean enableTopic;
    private boolean mIsPressedRecord;
    private boolean mNeedForceEventToParent;
    private boolean mTouchSpanHit;
    public int spanNormalBgColor;
    public int spanNormalColor;
    public int spanPressedBgColor;
    public int spanPressedColor;

    public KGUISpanTextView(Context context) {
        this(context, null);
    }

    private void parseAttribute(AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes;
        if (attributeSet == null || (typedArrayObtainAttributes = getResources().obtainAttributes(attributeSet, R.styleable.KGUITextView)) == null) {
            return;
        }
        this.spanNormalColor = typedArrayObtainAttributes.getColor(R.styleable.KGUITextView_kgui_span_normal_text_color, -16776961);
        this.spanPressedColor = typedArrayObtainAttributes.getColor(R.styleable.KGUITextView_kgui_span_pressed_text_color, -16776961);
        this.spanNormalBgColor = typedArrayObtainAttributes.getColor(R.styleable.KGUITextView_kgui_span_normal_bg_color, 0);
        this.spanPressedBgColor = typedArrayObtainAttributes.getColor(R.styleable.KGUITextView_kgui_span_pressed_bg_color, SupportMenu.CATEGORY_MASK);
        this.enableTopic = typedArrayObtainAttributes.getBoolean(R.styleable.KGUITextView_kgui_span_topic_enable, false);
        this.enableAt = typedArrayObtainAttributes.getBoolean(R.styleable.KGUITextView_kgui_span_at_enable, false);
        this.enableLink = typedArrayObtainAttributes.getBoolean(R.styleable.KGUITextView_kgui_span_link_enable, false);
        this.enableEmoji = typedArrayObtainAttributes.getBoolean(R.styleable.KGUITextView_kgui_span_emoji_enable, false);
        typedArrayObtainAttributes.recycle();
        if (this.enableAt || this.enableLink || this.enableTopic || this.enableEmoji) {
            setMovementMethodDefault();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((getText() instanceof Spannable) && (getMovementMethod() instanceof KGUILinkTouchMovementMethod)) {
            this.mTouchSpanHit = true;
            return this.mNeedForceEventToParent ? this.mTouchSpanHit : super.onTouchEvent(motionEvent);
        }
        this.mTouchSpanHit = false;
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mTouchSpanHit || this.mNeedForceEventToParent) {
            return false;
        }
        return super.performClick();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        if (this.mTouchSpanHit || this.mNeedForceEventToParent) {
            return false;
        }
        return super.performLongClick();
    }

    public void setContent(String str) {
        setText(SpanStrGenUtil.genSp(str, this.spanNormalColor, this.spanPressedColor, this.spanNormalBgColor, this.spanPressedBgColor));
    }

    public void setMovementMethodCompat(MovementMethod movementMethod) {
        setMovementMethod(movementMethod);
        if (this.mNeedForceEventToParent) {
            setNeedForceEventToParent(true);
        }
    }

    public void setMovementMethodDefault() {
        setMovementMethodCompat(KGUILinkTouchMovementMethod.getInstance());
    }

    public void setNeedForceEventToParent(boolean z) {
        this.mNeedForceEventToParent = z;
        setFocusable(!z);
        setClickable(!z);
        setLongClickable(!z);
    }

    @Override // android.view.View
    public final void setPressed(boolean z) {
        this.mIsPressedRecord = z;
        if (this.mTouchSpanHit) {
            return;
        }
        super.setPressed(z);
    }

    @Override // com.kugou.uilib.widget.textview.span.ISpanTouchFix
    public void setTouchSpanHit(boolean z) {
        if (this.mTouchSpanHit != z) {
            this.mTouchSpanHit = z;
            setPressed(this.mIsPressedRecord);
        }
    }

    public KGUISpanTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUISpanTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsPressedRecord = false;
        this.mNeedForceEventToParent = false;
        setHighlightColor(0);
        parseAttribute(attributeSet);
    }
}
