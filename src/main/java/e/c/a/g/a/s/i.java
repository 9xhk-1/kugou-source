package e.c.a.g.a.s;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class i extends RecyclerView.ItemDecoration {
    public int a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1205e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1206f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f1207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f1208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f1209i;
    public Integer j;

    public i a(int i2) {
        this.c = i2;
        return this;
    }

    public i b(int i2) {
        this.f1208h = Integer.valueOf(i2);
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        if (recyclerView.getAdapter() != null) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) - this.f1205e;
            if (childAdapterPosition < 0) {
                rect.set(0, 0, 0, 0);
                return;
            }
            if (childAdapterPosition == 0) {
                Integer num = this.f1207g;
                int iIntValue = num != null ? num.intValue() : this.b;
                Integer num2 = this.f1209i;
                rect.set(num2 != null ? num2.intValue() : this.a, iIntValue, this.f1204d, this.c);
                return;
            }
            if (childAdapterPosition != (r5.getItemCount() - 1) - this.f1206f) {
                rect.set(this.a, this.b, this.f1204d, this.c);
                return;
            }
            Integer num3 = this.f1208h;
            int iIntValue2 = num3 != null ? num3.intValue() : this.c;
            Integer num4 = this.j;
            rect.set(this.a, this.b, num4 != null ? num4.intValue() : this.f1204d, iIntValue2);
        }
    }
}
