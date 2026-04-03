package e.c.a.g.a.s;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class s1 implements z {
    public View[] a = new View[7];
    public View[] b = new View[7];

    public final void a(int i2) {
        for (int i3 = 0; i3 < 7; i3++) {
            if (i3 == i2) {
                u1.p(this.a[i3]);
            } else {
                u1.e(this.a[i3]);
            }
        }
    }

    @Override // e.c.a.g.a.s.z
    public void bindView(View view, int[] iArr) {
        if (iArr.length != 7) {
            throw new IllegalArgumentException(String.format("ids length must be $s, suggest format: new int[]{R.id.xxx, 0, 0, 0, R.id.yyy, R.id.zzz}", 7));
        }
        for (int i2 = 0; i2 < 7; i2++) {
            View viewFindViewById = view.findViewById(iArr[i2]);
            this.a[i2] = viewFindViewById;
            if (i2 >= 1 && i2 <= 4) {
                this.b[i2] = viewFindViewById;
            }
        }
    }

    @Override // e.c.a.g.a.s.z
    public View getNoMoreView() {
        return this.a[6];
    }

    @Override // e.c.a.g.a.s.z
    public void resizeFooterLoadingView(int i2, int i3, int i4, int i5) {
        u1.n(this.a[5], i2, i3, i4, i5);
    }

    @Override // e.c.a.g.a.s.z
    public void setView(int i2, View view) {
        if (i2 >= 7) {
            throw new IllegalArgumentException(String.format("ids length must be <$s", 7));
        }
        this.a[i2] = view;
    }

    @Override // e.c.a.g.a.s.z
    public void showContentView() {
        a(0);
    }

    @Override // e.c.a.g.a.s.z
    public void showEmptyView() {
        a(3);
    }

    @Override // e.c.a.g.a.s.z
    public void showFailView() {
        a(2);
    }

    @Override // e.c.a.g.a.s.z
    public void showFooterLoadingView() {
        View[] viewArr = this.a;
        if (viewArr[5] != null) {
            viewArr[5].setVisibility(0);
        }
    }

    @Override // e.c.a.g.a.s.z
    public void showLoadingView() {
        a(1);
    }

    @Override // e.c.a.g.a.s.z
    public void showLoginView() {
        a(4);
    }

    @Override // e.c.a.g.a.s.z
    public void showNoMoreView() {
        View[] viewArr = this.a;
        if (viewArr[6] != null) {
            viewArr[6].setVisibility(0);
        }
    }
}
