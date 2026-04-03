package e.c.a.g.a.p;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.component.family.FamilyControlCodeActivity;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.u1;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements View.OnClickListener {

    public static final class a<T> implements Action1 {
        public static final a<T> a = new a<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            e.c.a.g.a.g.e.d.a.j();
        }
    }

    public f(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        TextView textView = (TextView) view.findViewById(R.id.family_control_entry);
        textView.setVisibility(0);
        textView.setText("家长管控绑定码");
        textView.setOnClickListener(this);
        m1.f(a.a);
    }

    public final void a(Context context, String str) {
        if (context instanceof Activity) {
            Intent intent = new Intent(context, (Class<?>) FamilyControlCodeActivity.class);
            intent.putExtra("privacy_name", str);
            ((Activity) context).startActivity(intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.h(1000)) {
            return;
        }
        RingBiReportHelper.reportHeadGrade$default(RingBiReportHelper.INSTANCE, "点击跳转到家长管控绑定页面", null, 2, null);
        a(view != null ? view.getContext() : null, "家长管控绑定码");
        e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("11").setTab(e.c.a.g.a.r.b.F() ? "1" : "0"));
    }
}
