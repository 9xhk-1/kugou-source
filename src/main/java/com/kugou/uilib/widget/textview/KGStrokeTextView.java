package com.kugou.uilib.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUILog;

/* JADX INFO: loaded from: classes2.dex */
public class KGStrokeTextView extends KGUITextView {
    private final int DEFAULT_STROKE_COLOR;
    private final int DEFAULT_STROKE_WIDTH;
    private boolean isNeedStroke;
    private int mStrokeColor;
    private int mStrokeWidth;
    private boolean notInvalidate;

    public KGStrokeTextView(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.notInvalidate) {
            return;
        }
        super.invalidate();
    }

    @Override // com.kugou.uilib.widget.textview.KGUIBaseTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.isNeedStroke) {
            this.notInvalidate = true;
            ColorStateList textColors = getTextColors();
            TextPaint paint = getPaint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeMiter(10.0f);
            setTextColor(this.mStrokeColor);
            paint.setStrokeWidth(this.mStrokeWidth);
            super.onDraw(canvas);
            paint.setStyle(Paint.Style.FILL);
            setTextColor(textColors);
            if (KGUILog.DEBUG) {
                KGUILog.i("StrokeTextView1", "onDraw: ");
            }
            this.notInvalidate = false;
        }
        super.onDraw(canvas);
    }

    public KGStrokeTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGStrokeTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.DEFAULT_STROKE_COLOR = 0;
        this.DEFAULT_STROKE_WIDTH = 1;
        this.isNeedStroke = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUITextView);
            try {
                this.mStrokeColor = typedArrayObtainStyledAttributes.getColor(R.styleable.KGUITextView_kgui_textview_stroke_color, 0);
                this.mStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.KGUITextView_kgui_textview_stroke_width, 1);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }
}
