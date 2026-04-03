package com.kugou.android.watch.lite.base.main;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.uiframe.FragmentStackView;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FrameworkContentView extends FrameLayout {
    public boolean a;
    public ArrayList<b> b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FragmentStackView f42d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f43f;

    public final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameworkContentView.this.c();
        }
    }

    public interface b {
        void onFirstFace();
    }

    public FrameworkContentView(Context context) {
        super(context);
        this.a = true;
        b(context);
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        if (this.b.contains(bVar)) {
            return;
        }
        this.b.add(bVar);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (g0.a) {
            g0.e("FrameworkContentView", String.format("addView child :%s", view.toString()));
        }
    }

    public final void b(Context context) {
        FragmentStackView fragmentStackView = new FragmentStackView(context);
        this.f42d = fragmentStackView;
        fragmentStackView.setId(R.id.comm_framework_pager);
        this.f42d.setBackgroundColor(0);
        addView(this.f42d, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(context);
        this.f43f = frameLayout;
        frameLayout.setImportantForAccessibility(2);
        addView(this.f43f, new FrameLayout.LayoutParams(-1, -1));
    }

    public void c() {
        ArrayList<b> arrayList = this.b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.b.get(i2).onFirstFace();
            }
            this.b.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.a) {
            this.a = false;
            post(new a());
        }
    }

    public FrameLayout getAdditionalContainer() {
        return this.f43f;
    }

    public FragmentStackView getContent() {
        return this.f42d;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        if (!e.c.a.g.a.d.b0.b.b().c()) {
            return super.invalidateChildInParent(iArr, rect);
        }
        invalidate();
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null || childAt.getVisibility() != 8) {
                if (g0.a) {
                    g0.e("FrameworkContentView", String.format("onMeasure child :%s", childAt.toString()));
                }
                if (!(childAt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    throw new IllegalArgumentException(String.format("主动崩溃信息收集，count:%s, index:%s view:%s", Integer.valueOf(childCount), Integer.valueOf(i4), childAt.toString()));
                }
            }
        }
        super.onMeasure(i2, i3);
    }
}
