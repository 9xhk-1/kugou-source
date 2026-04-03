package e.c.a.g.a.p;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements View.OnClickListener {
    public final DelegateFragment a;
    public TextView b;

    public static final class a implements View.OnClickListener {
        public static final a a = new a();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.r.e.d.d().c();
            e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.user_login_out"));
            p1.h(KGApplication.getContext(), "退出登录成功");
            e.c.a.g.a.e.b.b(new YoungBITask(22020015, "click").setType("3"));
        }
    }

    public h(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        this.a = delegateFragment;
        TextView textView = (TextView) view.findViewById(R.id.user_info_login_out);
        this.b = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        b();
    }

    public final void a() {
        e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(this.a.requireActivity());
        aVar.e("是否确认退出登录");
        aVar.a("取消");
        aVar.b("确认");
        aVar.d(a.a);
        aVar.show();
    }

    public final void b() {
        if (e.c.a.g.a.r.b.F()) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setBackground(ResourcesCompat.getDrawable(this.a.getResources(), R.drawable.common_button_gray, null));
            }
            TextView textView2 = this.b;
            if (textView2 == null) {
                return;
            }
            textView2.setText("退出登录");
            return;
        }
        TextView textView3 = this.b;
        if (textView3 != null) {
            textView3.setBackground(ResourcesCompat.getDrawable(this.a.getResources(), R.drawable.common_bg_blue_radius, null));
        }
        TextView textView4 = this.b;
        if (textView4 == null) {
            return;
        }
        textView4.setText("登录");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null || u1.i(view)) {
            return;
        }
        e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("8").setTab(e.c.a.g.a.r.b.F() ? "1" : "0"));
        if (e.c.a.g.a.r.b.F()) {
            a();
        } else {
            s0.a.l("2");
        }
    }
}
