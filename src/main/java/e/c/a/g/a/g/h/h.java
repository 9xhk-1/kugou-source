package e.c.a.g.a.g.h;

import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public String a;
    public final boolean b;

    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (u1.i(view)) {
                return;
            }
            h.this.c("搜索入口点击");
            s0.a.w();
        }
    }

    public h(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "root");
        View viewFindViewById = view.findViewById(R.id.search_bar);
        if (e.c.a.g.a.f.a.j()) {
            viewFindViewById.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById.setOnClickListener(new a());
        }
        this.a = "SearchEntry";
        this.b = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.o0, 1) == 1;
    }

    public final void b() {
        c("搜索入口曝光");
    }

    public final void c(String str) {
        e.c.a.g.a.d.d0.a.a(this.a, f.z.d.j.l("page /搜索入口 1,", str));
        if (this.b) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setFo("搜索入口").setType("8").setSvar1(str));
        } else if (g0.f()) {
            g0.c("mhs_watch", f.z.d.j.l("TYPE_PIC needReport = ", Boolean.valueOf(this.b)));
        }
    }
}
