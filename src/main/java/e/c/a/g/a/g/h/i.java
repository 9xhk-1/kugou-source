package e.c.a.g.a.g.h;

import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import e.c.a.g.a.s.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements View.OnClickListener {
    public i(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        view.findViewById(R.id.setting_entry).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s0.a.y();
    }
}
