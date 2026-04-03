package e.c.a.g.a.p;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.v1;

/* JADX INFO: loaded from: classes2.dex */
public class d implements View.OnClickListener {
    public final DelegateFragment a;
    public final View b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f1153d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f1154f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1155h;

    public d(DelegateFragment delegateFragment, View view) {
        this.f1155h = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.E, 1) == 1;
        this.a = delegateFragment;
        View viewFindViewById = view.findViewById(R.id.pic_entry);
        this.b = viewFindViewById;
        this.f1153d = (ImageView) view.findViewById(R.id.icon_login);
        this.f1154f = (ImageView) view.findViewById(R.id.iv_vip_state);
        viewFindViewById.setOnClickListener(this);
        a();
    }

    public void a() {
        if (e.c.a.g.a.f.a.f()) {
            this.b.setVisibility(8);
            return;
        }
        if (!e.c.a.g.a.r.b.F()) {
            this.b.setVisibility(8);
            this.f1153d.setImageResource(R.drawable.icon_main_login_entry);
            return;
        }
        Glide.with(this.a).load(e.c.a.g.a.r.b.t()).into(this.f1153d);
        int iC = v1.c();
        if (iC > 0) {
            this.f1154f.setImageResource(iC);
            this.f1154f.setVisibility(0);
        } else {
            this.f1154f.setVisibility(8);
        }
        this.b.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.h(1000)) {
            return;
        }
        if (!e.c.a.g.a.r.b.F()) {
            s0.a.l("0");
        } else if (!l1.m0() || !this.f1155h) {
            s0.a.h(this.a.requireActivity());
        } else {
            if (!u0.n(KGApplication.getContext(), true)) {
                Log.e("mhs_watch_avatar", "EditPicEntry, isGlobalNetAvailable = 网络异常");
                return;
            }
            s0.a.d(this.a.requireActivity());
        }
        e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("1").setTab(e.c.a.g.a.r.b.F() ? "1" : "0"));
    }
}
