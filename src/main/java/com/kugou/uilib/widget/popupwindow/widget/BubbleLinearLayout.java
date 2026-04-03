package com.kugou.uilib.widget.popupwindow.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUISystemUtil;

/* JADX INFO: loaded from: classes2.dex */
public class BubbleLinearLayout extends LinearLayout {
    public int BACKGROUND_COLOR;
    public int CORNER_RADIUS;
    public int LEG_HALF_BASE;
    public float MIN_LEG_DISTANCE;
    public int PADDING;
    public int SHADOW_COLOR;
    public int STROKE_WIDTH;
    private float mBubbleLegOffset;
    private final Path mBubbleLegPrototype;
    private BubbleLegOrientation mBubbleOrientation;
    private Paint mFillPaint;
    private final Paint mPaint;
    private final Path mPath;

    /* JADX INFO: renamed from: com.kugou.uilib.widget.popupwindow.widget.BubbleLinearLayout$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$kugou$uilib$widget$popupwindow$widget$BubbleLinearLayout$BubbleLegOrientation;

        static {
            int[] iArr = new int[BubbleLegOrientation.values().length];
            $SwitchMap$com$kugou$uilib$widget$popupwindow$widget$BubbleLinearLayout$BubbleLegOrientation = iArr;
            try {
                iArr[BubbleLegOrientation.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$popupwindow$widget$BubbleLinearLayout$BubbleLegOrientation[BubbleLegOrientation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kugou$uilib$widget$popupwindow$widget$BubbleLinearLayout$BubbleLegOrientation[BubbleLegOrientation.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum BubbleLegOrientation {
        TOP,
        LEFT,
        RIGHT,
        BOTTOM,
        NONE
    }

    public BubbleLinearLayout(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.bubble);
            try {
                this.PADDING = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.bubble_bubble_padding, this.PADDING);
                this.SHADOW_COLOR = typedArrayObtainStyledAttributes.getInt(R.styleable.bubble_bubble_shadowColor, this.SHADOW_COLOR);
                this.BACKGROUND_COLOR = typedArrayObtainStyledAttributes.getInt(R.styleable.bubble_bubble_backgroundColor, this.BACKGROUND_COLOR);
                this.LEG_HALF_BASE = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.bubble_bubble_halfBaseOfLeg, this.LEG_HALF_BASE);
                this.MIN_LEG_DISTANCE = this.PADDING + r4;
                this.STROKE_WIDTH = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.bubble_bubble_strokeWidth, this.STROKE_WIDTH);
                this.CORNER_RADIUS = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.bubble_bubble_cornerRadius, this.CORNER_RADIUS);
            } finally {
                if (typedArrayObtainStyledAttributes != null) {
                    typedArrayObtainStyledAttributes.recycle();
                }
            }
        }
        this.mPaint.setColor(this.SHADOW_COLOR);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(this.STROKE_WIDTH);
        this.mPaint.setStrokeJoin(Paint.Join.MITER);
        setLayerType(1, this.mPaint);
        Paint paint = new Paint(this.mPaint);
        this.mFillPaint = paint;
        paint.setColor(this.BACKGROUND_COLOR);
        setLayerType(1, this.mFillPaint);
        renderBubbleLegPrototype();
        int i2 = this.PADDING;
        setPadding(i2, i2, i2, i2);
    }

    private Matrix renderBubbleLegMatrix(float f2, float f3) {
        BubbleLegOrientation bubbleLegOrientation = this.mBubbleOrientation;
        float fMax = (bubbleLegOrientation == BubbleLegOrientation.TOP || bubbleLegOrientation == BubbleLegOrientation.BOTTOM) ? Math.max(this.mBubbleLegOffset * f2, this.MIN_LEG_DISTANCE) : Math.max(this.mBubbleLegOffset * f3, this.MIN_LEG_DISTANCE);
        float fMin = Math.min(fMax, f3 - this.MIN_LEG_DISTANCE);
        Matrix matrix = new Matrix();
        int i2 = AnonymousClass1.$SwitchMap$com$kugou$uilib$widget$popupwindow$widget$BubbleLinearLayout$BubbleLegOrientation[this.mBubbleOrientation.ordinal()];
        if (i2 == 1) {
            f2 = fMax == 0.0f ? f2 - this.MIN_LEG_DISTANCE : fMax;
            matrix.postRotate(90.0f);
            f3 = 0.0f;
        } else if (i2 == 2) {
            f3 = fMax == 0.0f ? f3 - this.MIN_LEG_DISTANCE : fMax;
            matrix.postRotate(180.0f);
        } else if (i2 != 3) {
            f3 = fMin;
            f2 = 0.0f;
        } else {
            f2 = fMax == 0.0f ? f2 - this.MIN_LEG_DISTANCE : fMax;
            matrix.postRotate(270.0f);
        }
        matrix.postTranslate(f2, f3);
        return matrix;
    }

    private void renderBubbleLegPrototype() {
        this.mBubbleLegPrototype.moveTo(0.0f, 0.0f);
        this.mBubbleLegPrototype.lineTo(this.PADDING * 1.5f, (-r1) / 1.5f);
        Path path = this.mBubbleLegPrototype;
        int i2 = this.PADDING;
        path.lineTo(i2 * 1.5f, i2 / 1.5f);
        this.mBubbleLegPrototype.close();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        this.mPath.rewind();
        Path path = this.mPath;
        int i2 = this.PADDING;
        RectF rectF = new RectF(i2, i2, width - i2, height - i2);
        int i3 = this.CORNER_RADIUS;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
        this.mPath.addPath(this.mBubbleLegPrototype, renderBubbleLegMatrix(width, height));
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.drawPath(this.mPath, this.mFillPaint);
    }

    public void setBubbleBackgroundColor(@ColorInt int i2) {
        this.BACKGROUND_COLOR = i2;
        this.mFillPaint.setColor(i2);
    }

    public void setBubbleCornerRadius(float f2) {
        this.CORNER_RADIUS = KGUISystemUtil.dp2px(f2);
    }

    public void setBubbleLegOffset(float f2) {
        this.mBubbleLegOffset = f2;
    }

    public void setBubbleParams(BubbleLegOrientation bubbleLegOrientation, float f2) {
        this.mBubbleLegOffset = f2;
        this.mBubbleOrientation = bubbleLegOrientation;
    }

    public void setBubbleStrokeWidth(float f2) {
        this.STROKE_WIDTH = KGUISystemUtil.dp2px(f2);
    }

    public BubbleLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.PADDING = 30;
        this.LEG_HALF_BASE = 30;
        this.STROKE_WIDTH = 2;
        this.CORNER_RADIUS = 8;
        this.SHADOW_COLOR = Color.argb(100, 0, 0, 0);
        this.BACKGROUND_COLOR = Color.parseColor("#CC000000");
        this.MIN_LEG_DISTANCE = this.PADDING + this.LEG_HALF_BASE;
        this.mFillPaint = null;
        this.mPath = new Path();
        this.mBubbleLegPrototype = new Path();
        this.mPaint = new Paint(4);
        this.mBubbleLegOffset = 0.5f;
        this.mBubbleOrientation = BubbleLegOrientation.LEFT;
        init(context, attributeSet);
    }
}
