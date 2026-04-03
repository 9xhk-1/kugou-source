package com.kugou.android.watch.lite.base.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.kugou.android.watch.lite.R;
import e.c.a.g.a.g.b;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes.dex */
public class MainContainerLayout extends FrameLayout {
    public final int a;
    public MainFragmentViewPage b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f44d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f45f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f46h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f47i;
    public boolean j;

    public interface a {
        void onAttachedToWindow();

        void onFirstLayout();
    }

    public MainContainerLayout(Context context) {
        super(context);
        this.j = false;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.a = 0;
        a(context);
    }

    public final void a(Context context) {
        MainFragmentViewPage mainFragmentViewPage = new MainFragmentViewPage(context);
        this.b = mainFragmentViewPage;
        mainFragmentViewPage.setId(R.id.comm_main_container_viewpager);
        this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        View view = new View(context);
        this.f46h = view;
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(context);
        this.f44d = frameLayout;
        frameLayout.setClickable(true);
        this.f44d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.a));
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(1);
        u1.n(linearLayout, 0, 0, 0, l1.c(2.5f));
        this.f45f = new b(linearLayout);
        addView(this.b);
        addView(linearLayout);
    }

    public b getMainIndicator() {
        return this.f45f;
    }

    public MainFragmentViewPage getPagerContainer() {
        return this.b;
    }

    public View getTopBarContainer() {
        return this.f44d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f47i;
        if (aVar != null) {
            aVar.onAttachedToWindow();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.j) {
            return;
        }
        a aVar = this.f47i;
        if (aVar != null) {
            aVar.onFirstLayout();
        }
        this.j = true;
    }

    public void setViewState(a aVar) {
        this.f47i = aVar;
    }
}
