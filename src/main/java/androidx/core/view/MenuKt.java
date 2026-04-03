package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import f.d0.b;
import f.s;
import f.z.c.l;
import f.z.c.p;
import f.z.d.j;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem menuItem) {
        j.f(menu, "$this$contains");
        j.f(menuItem, "item");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (j.a(menu.getItem(i2), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, l<? super MenuItem, s> lVar) {
        j.f(menu, "$this$forEach");
        j.f(lVar, "action");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menu.getItem(i2);
            j.b(item, "getItem(index)");
            lVar.invoke(item);
        }
    }

    public static final void forEachIndexed(Menu menu, p<? super Integer, ? super MenuItem, s> pVar) {
        j.f(menu, "$this$forEachIndexed");
        j.f(pVar, "action");
        int size = menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            Integer numValueOf = Integer.valueOf(i2);
            MenuItem item = menu.getItem(i2);
            j.b(item, "getItem(index)");
            pVar.invoke(numValueOf, item);
        }
    }

    public static final MenuItem get(Menu menu, int i2) {
        j.f(menu, "$this$get");
        MenuItem item = menu.getItem(i2);
        j.b(item, "getItem(index)");
        return item;
    }

    public static final b<MenuItem> getChildren(final Menu menu) {
        j.f(menu, "$this$children");
        return new b<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // f.d0.b
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(Menu menu) {
        j.f(menu, "$this$size");
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        j.f(menu, "$this$isEmpty");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        j.f(menu, "$this$isNotEmpty");
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(final Menu menu) {
        j.f(menu, "$this$iterator");
        return new Iterator<MenuItem>() { // from class: androidx.core.view.MenuKt.iterator.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < menu.size();
            }

            @Override // java.util.Iterator
            public void remove() {
                Menu menu2 = menu;
                int i2 = this.index - 1;
                this.index = i2;
                menu2.removeItem(i2);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.Iterator
            public MenuItem next() {
                Menu menu2 = menu;
                int i2 = this.index;
                this.index = i2 + 1;
                MenuItem item = menu2.getItem(i2);
                if (item != null) {
                    return item;
                }
                throw new IndexOutOfBoundsException();
            }
        };
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        j.f(menu, "$this$minusAssign");
        j.f(menuItem, "item");
        menu.removeItem(menuItem.getItemId());
    }
}
