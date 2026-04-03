package e.c.a.g.a.p;

import android.view.View;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements View.OnClickListener {
    public final DelegateFragment a;

    public static final class a implements View.OnClickListener {
        public static final a a = new a();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020015, "click").setType("4"));
            KGApplication.exit();
        }
    }

    public e(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        this.a = delegateFragment;
        view.findViewById(R.id.tv_exit_app).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.g()) {
            return;
        }
        String str = e.c.a.g.a.d.x.f.q() ? "退出将暂停播放音乐，是否确认退出应用" : "是否确认退出应用";
        e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(this.a.requireActivity());
        aVar.e(str);
        aVar.a("取消");
        aVar.b("确认");
        aVar.d(a.a);
        aVar.show();
    }
}
