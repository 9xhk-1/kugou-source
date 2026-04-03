package com.kugou.android.watch.lite.component.ringtone.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes2.dex */
public class AudioSliderBar extends FrameLayout {
    public final ImageView a;
    public final ImageView b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f186d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f187f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f189i;
    public int j;
    public float k;
    public float l;
    public int m;
    public int n;
    public int o;
    public a p;

    public interface a {
        void onLeftBarClick(@NonNull View view);

        void onLeftSlide(int i2);

        void onRightBarClick(@NonNull View view);

        void onRightSlide(int i2);

        void onTouchFocus(boolean z);
    }

    public AudioSliderBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int getMaxLeftMargin() {
        return (getContentWidth() - c(this.b)) - this.a.getWidth();
    }

    private int getMaxRightMargin() {
        return (getContentWidth() - c(this.a)) - this.b.getWidth();
    }

    public final void a(View view, boolean z) {
        if (z) {
            i(view);
        }
        a aVar = this.p;
        if (aVar != null) {
            aVar.onTouchFocus(z);
        }
    }

    public final void b(View view) {
        i(view);
        a aVar = this.p;
        if (aVar != null) {
            ImageView imageView = this.a;
            if (view == imageView) {
                aVar.onLeftBarClick(imageView);
                return;
            }
            ImageView imageView2 = this.b;
            if (view == imageView2) {
                aVar.onRightBarClick(imageView2);
            }
        }
    }

    public final int c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getWidth();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + view.getWidth() + marginLayoutParams.rightMargin;
    }

    public boolean d() {
        return this.f187f == this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.component.ringtone.widget.AudioSliderBar.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean e() {
        return this.f187f == this.b;
    }

    public final boolean f(View view, float f2, float f3) {
        return view != null && f3 >= ((float) view.getTop()) && f3 <= ((float) view.getBottom()) && f2 >= ((float) view.getLeft()) && f2 <= ((float) view.getRight());
    }

    public final void g(int i2) {
        int i3 = (int) (((i2 * 1.0f) / this.j) * this.m);
        this.n = i3;
        int iMin = Math.min(i3, this.o);
        this.n = iMin;
        a aVar = this.p;
        if (aVar != null) {
            aVar.onLeftSlide(iMin);
        }
    }

    public int getLeftProgress() {
        return this.n;
    }

    public int getMaxProgress() {
        return this.m;
    }

    public int getRightProgress() {
        return this.o;
    }

    public final void h(int i2) {
        int i3 = (int) ((((r0 - i2) * 1.0f) / this.j) * this.m);
        this.o = i3;
        int iMax = Math.max(this.n, i3);
        this.o = iMax;
        a aVar = this.p;
        if (aVar != null) {
            aVar.onRightSlide(iMax);
        }
    }

    public final void i(View view) {
        this.f187f = view;
        ImageView imageView = this.a;
        if (view == imageView) {
            imageView.setImageResource(R.drawable.ic_slide_left);
            this.b.setImageResource(R.drawable.ic_slide_right_small);
        } else if (view == this.b) {
            imageView.setImageResource(R.drawable.ic_slide_left_small);
            this.b.setImageResource(R.drawable.ic_slide_right);
        }
    }

    public final void j(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.leftMargin == i2) {
                return;
            }
            marginLayoutParams.leftMargin = i2;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public final void k(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.rightMargin == i2) {
                return;
            }
            marginLayoutParams.rightMargin = i2;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public void l(int i2, int i3) {
        if (this.o < i2) {
            setRightProgress(i3);
            setLeftProgress(i2);
        } else {
            setLeftProgress(i2);
            setRightProgress(i3);
        }
    }

    public final void m() {
        this.j = (getContentWidth() - this.a.getMeasuredWidth()) - this.b.getMeasuredWidth();
    }

    public final void n() {
        j(this.a, Math.min((int) (((this.n * 1.0f) / this.m) * this.j), getMaxLeftMargin()));
    }

    public final void o() {
        k(this.b, Math.min((int) ((1.0f - ((this.o * 1.0f) / this.m)) * this.j), getMaxRightMargin()));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        m();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        m();
    }

    public void setLeftProgress(int i2) {
        int iE = l1.e(i2, 0, this.o);
        if (this.n != iE) {
            this.n = iE;
            n();
        }
    }

    public void setMaxProgress(int i2) {
        this.m = i2;
        this.o = i2;
    }

    public void setOnSlideListener(a aVar) {
        this.p = aVar;
    }

    public void setRightProgress(int i2) {
        int iE = l1.e(i2, this.n, this.m);
        if (this.o != iE) {
            this.o = iE;
            o();
        }
    }

    public AudioSliderBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 100;
        this.n = 0;
        this.o = 100;
        LayoutInflater.from(context).inflate(R.layout.view_slide_bar, (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R.id.left_bar);
        this.a = imageView;
        this.b = (ImageView) findViewById(R.id.right_bar);
        i(imageView);
    }
}
