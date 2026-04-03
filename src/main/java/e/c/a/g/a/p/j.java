package e.c.a.g.a.p;

import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements View.OnClickListener {
    public final View a;
    public final TextView b;

    public j(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "root");
        View viewFindViewById = view.findViewById(R.id.story_entry);
        this.a = viewFindViewById;
        TextView textView = (TextView) view.findViewById(R.id.tv_personality_status);
        this.b = textView;
        viewFindViewById.setOnClickListener(this);
        textView.setOnClickListener(this);
        if (e.c.a.g.a.f.m.c.a.e("KEY_ENABLE_PERSONALITY_REC", true)) {
            textView.setText("开");
        } else {
            textView.setText("关");
        }
        if (e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.I1, true)) {
            u1.p(viewFindViewById, textView);
        } else {
            u1.e(viewFindViewById, textView);
        }
    }

    public final void a(boolean z) {
        if (z) {
            e.c.a.g.a.f.m.c.a.j("KEY_ENABLE_PERSONALITY_REC", true);
            p1.h(KGApplication.getContext(), "个性化推荐已打开");
            this.b.setText("开");
        } else {
            e.c.a.g.a.f.m.c.a.j("KEY_ENABLE_PERSONALITY_REC", false);
            p1.h(KGApplication.getContext(), "个性化推荐已关闭");
            this.b.setText("关");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u0.m(KGApplication.getContext())) {
            boolean zE = e.c.a.g.a.f.m.c.a.e("KEY_ENABLE_PERSONALITY_REC", true);
            String str = e.c.a.g.a.r.b.F() ? "1" : "0";
            if (zE) {
                s0.a.e();
                e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("7").setTab(str));
            } else {
                EventBus.getDefault().post(new l(!zE));
                e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("6").setTab(str));
            }
        }
    }
}
