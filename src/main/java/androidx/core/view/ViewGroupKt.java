package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import f.d0.b;
import f.s;
import f.z.c.l;
import f.z.c.p;
import f.z.d.j;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(ViewGroup viewGroup, View view) {
        j.f(viewGroup, "$this$contains");
        j.f(view, "view");
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, l<? super View, s> lVar) {
        j.f(viewGroup, "$this$forEach");
        j.f(lVar, "action");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            j.b(childAt, "getChildAt(index)");
            lVar.invoke(childAt);
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, p<? super Integer, ? super View, s> pVar) {
        j.f(viewGroup, "$this$forEachIndexed");
        j.f(pVar, "action");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            Integer numValueOf = Integer.valueOf(i2);
            View childAt = viewGroup.getChildAt(i2);
            j.b(childAt, "getChildAt(index)");
            pVar.invoke(numValueOf, childAt);
        }
    }

    public static final View get(ViewGroup viewGroup, int i2) {
        j.f(viewGroup, "$this$get");
        View childAt = viewGroup.getChildAt(i2);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + viewGroup.getChildCount());
    }

    public static final b<View> getChildren(final ViewGroup viewGroup) {
        j.f(viewGroup, "$this$children");
        return new b<View>() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // f.d0.b
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final int getSize(ViewGroup viewGroup) {
        j.f(viewGroup, "$this$size");
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        j.f(viewGroup, "$this$isEmpty");
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        j.f(viewGroup, "$this$isNotEmpty");
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(final ViewGroup viewGroup) {
        j.f(viewGroup, "$this$iterator");
        return new Iterator<View>() { // from class: androidx.core.view.ViewGroupKt.iterator.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < viewGroup.getChildCount();
            }

            @Override // java.util.Iterator
            public void remove() {
                ViewGroup viewGroup2 = viewGroup;
                int i2 = this.index - 1;
                this.index = i2;
                viewGroup2.removeViewAt(i2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public View next() {
                ViewGroup viewGroup2 = viewGroup;
                int i2 = this.index;
                this.index = i2 + 1;
                View childAt = viewGroup2.getChildAt(i2);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
            }
        };
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        j.f(viewGroup, "$this$minusAssign");
        j.f(view, "view");
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        j.f(viewGroup, "$this$plusAssign");
        j.f(view, "view");
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2) {
        j.f(marginLayoutParams, "$this$setMargins");
        marginLayoutParams.setMargins(i2, i2, i2, i2);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        j.f(marginLayoutParams, "$this$updateMargins");
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.leftMargin;
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.rightMargin;
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        j.f(marginLayoutParams, "$this$updateMargins");
        marginLayoutParams.setMargins(i2, i3, i4, i5);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        j.f(marginLayoutParams, "$this$updateMarginsRelative");
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = marginLayoutParams.getMarginStart();
        }
        if ((i6 & 2) != 0) {
            i3 = marginLayoutParams.topMargin;
        }
        if ((i6 & 4) != 0) {
            i4 = marginLayoutParams.getMarginEnd();
        }
        if ((i6 & 8) != 0) {
            i5 = marginLayoutParams.bottomMargin;
        }
        j.f(marginLayoutParams, "$this$updateMarginsRelative");
        marginLayoutParams.setMarginStart(i2);
        marginLayoutParams.topMargin = i3;
        marginLayoutParams.setMarginEnd(i4);
        marginLayoutParams.bottomMargin = i5;
    }
}
