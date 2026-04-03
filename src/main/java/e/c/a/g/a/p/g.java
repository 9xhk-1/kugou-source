package e.c.a.g.a.p;

import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements View.OnClickListener {
    public g(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        TextView textView = (TextView) view.findViewById(R.id.feedback_entry);
        if (e.c.a.g.a.f.a.g()) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        if (l1.V()) {
            textView.setText("反馈/投诉");
        } else {
            textView.setText("我要反馈");
        }
        textView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s0.a.j(1);
        e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("4").setTab(e.c.a.g.a.r.b.F() ? "1" : "0"));
    }
}
