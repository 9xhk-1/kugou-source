package e.c.a.g.a.p;

import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements View.OnClickListener {
    public View a;

    public c(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        View viewFindViewById = view.findViewById(R.id.edit_name_entry);
        this.a = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(this);
        }
        a();
    }

    public final void a() {
        boolean z = e.c.a.g.a.f.a.e() || !e.c.a.g.a.r.b.F();
        View view = this.a;
        if (view == null) {
            return;
        }
        view.setVisibility(z ? 8 : 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.h(1000)) {
            return;
        }
        s0.a.g();
        e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("2").setTab(e.c.a.g.a.r.b.F() ? "1" : "0"));
    }
}
