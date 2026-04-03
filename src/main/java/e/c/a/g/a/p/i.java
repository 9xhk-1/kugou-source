package e.c.a.g.a.p;

import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements View.OnClickListener {
    public i(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        view.findViewById(R.id.logoff_entry).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.g()) {
            return;
        }
        s0.a.o();
        e.c.a.g.a.e.b.b(new YoungBITask(22020015, "click").setType("2"));
    }
}
