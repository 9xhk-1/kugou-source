package e.c.a.g.a.f.o.i;

import android.view.View;
import android.view.ViewGroup;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static volatile c b;
    public final a a;

    public c() {
        a aVarA = a.a();
        this.a = aVarA;
        if (g0.a) {
            g0.b("ScreenCornerAdapt", "strategy: corner=" + aVarA.c() + "  margin=" + aVarA.b());
        }
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public boolean b() {
        return this.a.h();
    }

    public void c(int i2, View view) {
        if (view == null) {
            return;
        }
        int iF = this.a.f(i2);
        int iG = this.a.g(i2);
        if (iF > 0 || iG > 0) {
            view.setPadding(iF, iG, iF, iG);
        }
    }

    public void d(int i2, View view) {
        if (view == null) {
            return;
        }
        int iF = this.a.f(i2);
        int iG = this.a.g(i2);
        if (iF > 0 || iG > 0) {
            view.setPadding(iF, iG, iF, view.getPaddingBottom());
        }
    }

    public void e(int i2, View view) {
        int iF;
        if (view != null && (iF = this.a.f(i2)) > 0) {
            view.setPadding(iF, view.getPaddingTop(), iF, view.getPaddingBottom());
        }
    }

    public void f(int i2, View view) {
        int iG;
        if (view != null && (iG = this.a.g(i2)) > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += iG;
            }
        }
    }
}
