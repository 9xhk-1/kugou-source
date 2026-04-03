package e.c.a.g.a.s;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kugou.android.watch.lite.base.application.KGApplication;

/* JADX INFO: loaded from: classes2.dex */
public class u1 {
    public static long a;
    public static int b;

    public static <T extends View> T a(View view, int i2) {
        if (view != null) {
            return (T) view.findViewById(i2);
        }
        return null;
    }

    public static void b(View.OnClickListener onClickListener, View... viewArr) {
        if (viewArr != null) {
            for (View view : viewArr) {
                if (view != null) {
                    view.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public static GradientDrawable c(int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }

    public static GradientDrawable d(int i2, int[] iArr, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i2);
        gradientDrawable.setColors(iArr);
        gradientDrawable.setOrientation(orientation);
        return gradientDrawable;
    }

    public static void e(View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null && view.getVisibility() != 8) {
                view.setVisibility(8);
            }
        }
    }

    public static void f(View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null && view.getVisibility() != 4) {
                view.setVisibility(4);
            }
        }
    }

    public static boolean g() {
        return h(700);
    }

    public static boolean h(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - a < ((long) i2);
        if (!z) {
            a = jCurrentTimeMillis;
        }
        return z;
    }

    public static boolean i(View view) {
        return j(view, 700L);
    }

    public static boolean j(View view, long j) {
        int id = view.getId();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - a) < j && id == b) {
            return true;
        }
        a = jCurrentTimeMillis;
        b = id;
        return false;
    }

    public static void k(View view) {
        if (view == null) {
            return;
        }
        f1 f1VarY = l1.y(KGApplication.getContext());
        if (f1VarY.a > 240 || f1VarY.b > 240) {
            return;
        }
        view.setScaleX(0.9f);
        view.setScaleY(0.9f);
    }

    public static void l(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i2;
            view.requestLayout();
        }
    }

    public static void m(View view, int i2, int i3, int i4, int i5) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
            view.setLayoutParams(layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i2 <= 0) {
                i2 = marginLayoutParams.leftMargin;
            }
            if (i3 <= 0) {
                i3 = marginLayoutParams.topMargin;
            }
            if (i4 <= 0) {
                i4 = marginLayoutParams.rightMargin;
            }
            if (i5 <= 0) {
                i5 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i2, i3, i4, i5);
        }
    }

    public static View n(View view, int i2, int i3, int i4, int i5) {
        if (view != null && view.getLayoutParams() != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(l1.d(view.getContext(), i2), l1.d(view.getContext(), i3), l1.d(view.getContext(), i4), l1.d(view.getContext(), i5));
        }
        return view;
    }

    public static void o(View view, int i2) {
        if (view == null || view.getVisibility() == i2) {
            return;
        }
        view.setVisibility(i2);
    }

    public static void p(View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null && view.getVisibility() != 0) {
                view.setVisibility(0);
            }
        }
    }
}
