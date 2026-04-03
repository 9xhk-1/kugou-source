package e.c.a.g.a.g.j.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public final View a;
    public final b b;
    public final ImageView c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e.c.a.g.a.g.j.e.a f937e;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (c.this.c.isSelected()) {
                return;
            }
            c.this.f(!r2.c.isSelected());
            c.this.c().onSelect(c.this);
        }
    }

    public c(View view, b bVar) {
        j.e(view, "itemView");
        j.e(bVar, "selectListener");
        this.a = view;
        this.b = bVar;
        this.c = (ImageView) view.findViewById(R.id.type_checkbox);
        this.f936d = (TextView) view.findViewById(R.id.type_title);
        view.setOnClickListener(new a());
    }

    public final e.c.a.g.a.g.j.e.a b() {
        return this.f937e;
    }

    public final b c() {
        return this.b;
    }

    public final void d() {
        this.a.setVisibility(8);
    }

    public final boolean e() {
        return this.c.isSelected();
    }

    public final void f(boolean z) {
        if (z) {
            this.c.setImageResource(R.drawable.young_ic_select);
        } else {
            this.c.setImageResource(R.drawable.shape_circle_frame);
        }
        this.c.setSelected(z);
        e.c.a.g.a.g.j.e.a aVar = this.f937e;
        if (aVar == null) {
            return;
        }
        aVar.e(z);
    }

    public final void g(e.c.a.g.a.g.j.e.a aVar) {
        j.e(aVar, "item");
        this.f937e = aVar;
        f(aVar.d());
        this.f936d.setText(aVar.a());
    }

    public final void h() {
        this.a.setVisibility(0);
    }
}
