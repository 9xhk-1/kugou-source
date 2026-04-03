package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.kugou.uilib.R;
import com.kugou.uilib.anno.DelegateAnno;
import com.kugou.uilib.anno.ExposeMethod;
import com.kugou.uilib.utils.KGUISystemUtil;
import com.kugou.uilib.widget.baseDelegate.AbsViewDelegate;
import com.kugou.uilib.widget.imageview.round.roundedimageview.Corner;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@DelegateAnno(targetView = "com.kugou.uilib.widget.baseDelegate.IViewDelegate")
public class CornerDelegate<T extends View> extends AbsViewDelegate<T> {
    public static final float DEFAULT_BORDER_WIDTH = 0.0f;
    public static final float DEFAULT_RADIUS = -1.0f;
    private Path borderPath;
    private int mBorderColor;
    private Paint mBorderPaint;
    private RectF mRect;
    private Path roundPath;
    private boolean useClipPath;
    private T view;
    private final float[] mCornerRadii = {-1.0f, -1.0f, -1.0f, -1.0f};
    private float cornerRadiusOverride = -1.0f;
    private float mBorderWidth = 0.0f;

    public static boolean isNeed(TypedArray typedArray) {
        return typedArray.hasValue(R.styleable.KGUIView_kgui_corner_radius) || typedArray.hasValue(R.styleable.KGUIView_kgui_corner_radius_top_left) || typedArray.hasValue(R.styleable.KGUIView_kgui_corner_radius_top_right) || typedArray.hasValue(R.styleable.KGUIView_kgui_corner_radius_bottom_left) || typedArray.hasValue(R.styleable.KGUIView_kgui_corner_radius_bottom_right) || typedArray.hasValue(R.styleable.KGUIView_kgui_border_width);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void afterDraw(Canvas canvas) {
        if (this.mBorderWidth > 0.0f) {
            if (canvas.getDrawFilter() == null) {
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            }
            canvas.drawPath(this.borderPath, this.mBorderPaint);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t, TypedArray typedArray) {
        this.cornerRadiusOverride = typedArray.getDimensionPixelSize(R.styleable.KGUIView_kgui_corner_radius, -1);
        this.mCornerRadii[0] = typedArray.getDimensionPixelSize(R.styleable.KGUIView_kgui_corner_radius_top_left, -1);
        this.mCornerRadii[1] = typedArray.getDimensionPixelSize(R.styleable.KGUIView_kgui_corner_radius_top_right, -1);
        this.mCornerRadii[2] = typedArray.getDimensionPixelSize(R.styleable.KGUIView_kgui_corner_radius_bottom_right, -1);
        this.mCornerRadii[3] = typedArray.getDimensionPixelSize(R.styleable.KGUIView_kgui_corner_radius_bottom_left, -1);
        this.mBorderWidth = typedArray.getDimensionPixelSize(R.styleable.KGUIView_kgui_border_width, -1);
        this.mBorderColor = typedArray.getColor(R.styleable.KGUIView_kgui_border_color, 0);
        init(t);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.useClipPath || this.mBorderWidth > 0.0f) {
            if (this.mBorderWidth < 0.0f) {
                this.mBorderWidth = 0.0f;
            }
            this.mRect.set(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
            this.roundPath.reset();
            float[] fArr = this.mCornerRadii;
            float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
            for (int i6 = 0; i6 < fArrCopyOf.length; i6++) {
                if (fArrCopyOf[i6] < 0.0f) {
                    fArrCopyOf[i6] = 0.0f;
                } else if (fArrCopyOf[i6] > this.view.getHeight() / 2.0f) {
                    fArrCopyOf[i6] = this.view.getHeight() / 2.0f;
                } else if (fArrCopyOf[i6] > this.view.getWidth() / 2.0f) {
                    fArrCopyOf[i6] = this.view.getWidth() / 2.0f;
                }
            }
            float[] fArr2 = {fArrCopyOf[0], fArrCopyOf[0], fArrCopyOf[1], fArrCopyOf[1], fArrCopyOf[2], fArrCopyOf[2], fArrCopyOf[3], fArrCopyOf[3]};
            this.roundPath.addRoundRect(this.mRect, fArr2, Path.Direction.CCW);
            this.borderPath.reset();
            this.borderPath.addRoundRect(this.mRect, fArr2, Path.Direction.CW);
            RectF rectF = this.mRect;
            float f2 = rectF.left;
            float f3 = this.mBorderWidth;
            rectF.set(f2 + f3, rectF.top + f3, rectF.right - f3, rectF.bottom - f3);
            this.borderPath.addRoundRect(this.mRect, fArr2, Path.Direction.CCW);
        }
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void preDraw(Canvas canvas) {
        if (this.useClipPath || this.mBorderWidth > 0.0f) {
            canvas.clipPath(this.roundPath);
        }
    }

    @ExposeMethod
    public void setBorderColor(@ColorInt int i2) {
        this.mBorderPaint.setColor(i2);
        this.view.invalidate();
    }

    @ExposeMethod
    public void setBorderStrokeWidth(int i2) {
        float f2 = i2;
        this.mBorderWidth = f2;
        this.mBorderPaint.setStrokeWidth(f2);
        this.view.requestLayout();
    }

    @ExposeMethod
    public void setCornerRadius(float f2) {
        float fDp2px = KGUISystemUtil.dp2px(f2);
        int length = this.mCornerRadii.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.mCornerRadii[i2] = fDp2px;
        }
        init(this.view);
        this.view.requestLayout();
    }

    @ExposeMethod
    public void setCurrentCornerRadius(float f2) {
        float fDp2px = KGUISystemUtil.dp2px(f2);
        int length = this.mCornerRadii.length;
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr = this.mCornerRadii;
            if (fArr[i2] >= 0.0f) {
                fArr[i2] = fDp2px;
            }
        }
        init(this.view);
        this.view.requestLayout();
    }

    @ExposeMethod
    public void setCornerRadius(float f2, @Corner int... iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == 6) {
                float[] fArr = this.mCornerRadii;
                fArr[0] = f2;
                fArr[1] = f2;
                fArr[3] = f2;
                fArr[2] = f2;
            } else if (iArr[i2] == 4) {
                float[] fArr2 = this.mCornerRadii;
                fArr2[0] = f2;
                fArr2[1] = f2;
            } else if (iArr[i2] == 5) {
                float[] fArr3 = this.mCornerRadii;
                fArr3[3] = f2;
                fArr3[2] = f2;
            } else {
                this.mCornerRadii[iArr[i2]] = f2;
            }
        }
        init(this.view);
        this.view.requestLayout();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.AbsViewDelegate, com.kugou.uilib.widget.baseDelegate.IViewDelegate
    public void init(T t) {
        boolean z;
        boolean z2;
        this.view = t;
        int length = this.mCornerRadii.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                z2 = false;
                break;
            } else {
                if (this.mCornerRadii[i2] > 0.0f) {
                    z = true;
                    z2 = true;
                    break;
                }
                i2++;
            }
        }
        if (!z) {
            if (this.cornerRadiusOverride < 0.0f) {
                this.cornerRadiusOverride = -1.0f;
            } else {
                z2 = false;
            }
            int length2 = this.mCornerRadii.length;
            for (int i3 = 0; i3 < length2; i3++) {
                this.mCornerRadii[i3] = this.cornerRadiusOverride;
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21 && !z2) {
            this.useClipPath = false;
            t.setClipToOutline(true);
            t.setOutlineProvider(new ViewOutlineProvider() { // from class: com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate.1
                @Override // android.view.ViewOutlineProvider
                @RequiresApi(api = 21)
                public void getOutline(View view, Outline outline) {
                    int width;
                    float f2 = CornerDelegate.this.mCornerRadii[0];
                    if (f2 <= view.getHeight() / 2.0f) {
                        if (f2 > view.getWidth() / 2.0f) {
                            width = view.getWidth();
                        }
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f2);
                    }
                    width = view.getHeight();
                    f2 = width / 2.0f;
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f2);
                }
            });
        } else {
            if (i4 >= 21) {
                t.setClipToOutline(false);
            }
            this.useClipPath = true;
        }
        this.roundPath = new Path();
        this.borderPath = new Path();
        this.mRect = new RectF();
        Paint paint = new Paint();
        this.mBorderPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mBorderPaint.setAntiAlias(false);
        this.mBorderPaint.setColor(this.mBorderColor);
        if (t instanceof ViewGroup) {
            t.setWillNotDraw(false);
        }
    }
}
