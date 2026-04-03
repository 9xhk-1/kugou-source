package e.c.a.g.a.g.h.m;

import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements View.OnClickListener {
    public final TextView a;

    public b(DelegateFragment delegateFragment, View view) {
        j.e(delegateFragment, "host");
        j.e(view, "root");
        TextView textView = (TextView) view.findViewById(R.id.recommend_entry);
        this.a = textView;
        a();
        textView.setOnClickListener(this);
    }

    public final void a() {
        TextView textView = this.a;
        j.d(textView, "mEntry");
        textView.setVisibility(c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.L1, false) ? 0 : 8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.g()) {
            return;
        }
        s0.a.u();
    }
}
