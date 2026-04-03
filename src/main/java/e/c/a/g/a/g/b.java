package e.c.a.g.a.g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import e.c.a.g.a.s.g;
import e.c.a.g.a.s.l1;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public LinearLayout a;
    public Context b;
    public GradientDrawable c = new GradientDrawable();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public GradientDrawable f739d = new GradientDrawable();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<Drawable> f740e;

    public b(LinearLayout linearLayout) {
        this.a = linearLayout;
        this.b = linearLayout.getContext();
    }

    public void a(int i2, List<Drawable> list) {
        this.f740e = list;
        this.a.removeAllViews();
        int iD = l1.d(this.b, 7.0f);
        int iD2 = l1.d(this.b, 4.0f);
        this.c.setColor(g.a(-1, 0.6f));
        float f2 = iD;
        this.c.setCornerRadius(f2);
        this.f739d.setColor(-1);
        this.f739d.setCornerRadius(f2);
        for (int i3 = 0; i3 < i2; i3++) {
            View view = new View(this.b);
            view.setBackground(this.c);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iD, iD);
            layoutParams.leftMargin = iD2;
            layoutParams.rightMargin = iD2;
            this.a.addView(view, layoutParams);
        }
    }

    public void b(int i2) {
        int childCount = this.a.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.a.getChildAt(i3);
            if (i3 == i2) {
                List<Drawable> list = this.f740e;
                if (list == null) {
                    childAt.setBackground(this.f739d);
                } else {
                    Drawable drawable = list.get(i2);
                    if (drawable != null) {
                        childAt.setBackground(drawable);
                    } else {
                        childAt.setBackground(this.f739d);
                    }
                }
            } else {
                childAt.setBackground(this.c);
            }
        }
    }
}
