package e.c.a.g.a.d.w;

import android.app.Activity;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.base.main.MainFragmentContainer;
import com.kugou.android.watch.lite.common.widget.loading.CommonLoadingView;
import e.c.a.g.a.d.v.c;
import e.c.a.g.a.s.d1;
import e.c.a.g.a.s.f0;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(@NonNull Class cls, @NonNull View view) {
        e.c.c.l.f.b bVar = (e.c.c.l.f.b) cls.getAnnotation(e.c.c.l.f.b.class);
        if (bVar != null) {
            view.setTag(805306114, Integer.valueOf(bVar.id()));
        } else if (g0.a && !b.a().b(cls.getName()) && !b.a().c(cls.getName())) {
            f0.h(cls.getName() + "没有添加PageInfoAnnotation注解，请先添加注解。添加注解参考: http://kgmedit.kugou.net/wiki/android/?incsub_wiki=%E7%BA%A2%E8%8F%8A%E7%8E%87%E4%B8%8A%E6%8A%A5%E4%BD%BF%E7%94%A8%E6%96%87%E6%A1%A3");
        }
        view.setTag(805306113, cls.getName());
        view.setTag(805306115, Long.valueOf(SystemClock.elapsedRealtime()));
        view.setTag(805306116, b(cls, view));
    }

    public static String b(Class cls, View view) {
        e.c.a.g.a.d.v.b bVarA;
        AbsFrameworkFragment[] absFrameworkFragmentArr;
        String[] strArrSplit;
        AbsFrameworkFragment absFrameworkFragmentZ0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/");
        View view2 = null;
        try {
            bVarA = c.a();
        } catch (Exception e2) {
            g0.k(e2);
            sb2.append(-1);
            bVarA = null;
        }
        int i2 = 528178838;
        if (bVarA != null && (absFrameworkFragmentArr = bVarA.a) != null) {
            int length = absFrameworkFragmentArr.length - 1;
            int iG = 528178838;
            int iG2 = -1;
            boolean z = true;
            for (int i3 = 0; i3 <= length; i3++) {
                AbsFrameworkFragment absFrameworkFragment = absFrameworkFragmentArr[i3];
                if (i3 != length || (absFrameworkFragment != null && !absFrameworkFragment.C())) {
                    if (absFrameworkFragment != null) {
                        view2 = absFrameworkFragment.getView();
                        if (view2 != null) {
                            iG = f(view2);
                        }
                        if (iG == 528178838) {
                            iG = g(absFrameworkFragment);
                        }
                        if ((absFrameworkFragment instanceof MainFragmentContainer) && length >= 0 && (absFrameworkFragmentZ0 = ((MainFragmentContainer) absFrameworkFragment).z0()) != null) {
                            View view3 = absFrameworkFragmentZ0.getView();
                            if (view3 != null) {
                                iG2 = f(view3);
                            }
                            if (iG2 == 528178838) {
                                iG2 = g(absFrameworkFragmentZ0);
                            }
                        }
                    }
                    if (z) {
                        sb2.append(iG);
                        z = false;
                    } else {
                        sb2.append("/");
                        sb2.append(iG);
                    }
                    if (iG2 > 0) {
                        sb2.append("/");
                        sb2.append(iG2);
                        iG2 = -1;
                    }
                    if (g0.a) {
                        if (absFrameworkFragment != null) {
                            view2 = absFrameworkFragment.getView();
                        }
                        String str = "null";
                        if (view2 == null) {
                            sb.append("null");
                        } else {
                            String strD = d(view2);
                            if (strD != null) {
                                String[] strArrSplit2 = strD.split("\\.");
                                str = strArrSplit2.length > 0 ? strArrSplit2[strArrSplit2.length - 1] : strD;
                            }
                            if (!TextUtils.isEmpty(str) && (strArrSplit = str.split("\\.")) != null && strArrSplit.length > 0) {
                                str = strArrSplit[strArrSplit.length - 1];
                            }
                            sb.append("/" + str);
                        }
                    }
                }
            }
            int iF = f(view);
            if (iF == 528178838) {
                iF = h(cls);
            }
            if (iF != 528178838 && iF != iG) {
                sb2.append("/");
                sb2.append(iF);
            }
            if (g0.a) {
                i2 = iF;
            }
        }
        sb2.append("/");
        if (g0.a) {
            g0.b("burone-source-id", "PageId.nameStack = " + sb.toString() + "\nPageId.idStack   = " + sb2.toString() + "\nPageId.currentId = " + i2 + "\nPageId.currentNm = " + cls.getSimpleName() + "\n ");
        }
        return sb2.toString();
    }

    public static boolean c(View view, View[] viewArr, Rect rect) {
        boolean z;
        boolean z2;
        if (view == null || !(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        loop0: while (true) {
            z = false;
            while (true) {
                childCount--;
                if (childCount < 0 || z) {
                    break loop0;
                }
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt.getVisibility() != 8) {
                    if (childAt.isClickable() || childAt.isLongClickable()) {
                        Rect rectL = l(childAt);
                        if (rectL.contains(rect) || rectL.intersect(rect)) {
                            viewArr[0] = childAt;
                            z2 = true;
                        }
                    } else {
                        z2 = false;
                    }
                    if (c(childAt, viewArr, rect) || z2) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static String d(View view) {
        Object parent;
        while (view != null && (parent = view.getParent()) != null) {
            Object tag = view.getTag(805306113);
            if (tag != null && (tag instanceof String)) {
                return (String) tag;
            }
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return null;
    }

    public static int e(Activity activity) {
        return h(activity.getClass());
    }

    public static int f(View view) {
        Object parent;
        while (view != null && (parent = view.getParent()) != null) {
            Object tag = view.getTag(805306114);
            if (tag != null && (tag instanceof Integer)) {
                return ((Integer) tag).intValue();
            }
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return 528178838;
    }

    public static int g(Fragment fragment) {
        return h(fragment.getClass());
    }

    public static int h(Class cls) {
        e.c.c.l.f.b bVar = (e.c.c.l.f.b) cls.getAnnotation(e.c.c.l.f.b.class);
        if (bVar != null) {
            return bVar.id();
        }
        return 528178838;
    }

    public static int i(CommonLoadingView commonLoadingView) {
        ArrayList<View> arrayListA = d1.a();
        if (arrayListA == null || arrayListA.size() < 2) {
            return 528178838;
        }
        View[] viewArr = new View[1];
        c(arrayListA.get(arrayListA.size() - 2), viewArr, l(commonLoadingView));
        return f(viewArr[0]);
    }

    public static String j(View view) {
        if (view != null) {
            return (String) view.getTag(805306116);
        }
        return null;
    }

    public static long k(View view) {
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                return 0L;
            }
            Object tag = view.getTag(805306115);
            if (tag != null && (tag instanceof Long)) {
                return ((Long) tag).longValue();
            }
            if (!(parent instanceof View)) {
                return 0L;
            }
            view = (View) parent;
        }
        return 0L;
    }

    public static Rect l(View view) {
        Rect rect = new Rect();
        if (view != null) {
            int[] iArr = new int[2];
            view.getDrawingRect(rect);
            view.getLocationOnScreen(iArr);
            rect.offset(iArr[0], iArr[1]);
        }
        return rect;
    }
}
