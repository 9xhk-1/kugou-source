package com.kugou.android.watch.lite.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.widget.PlayerBall;
import e.c.a.g.a.f.d.a;
import e.c.a.g.a.g.h.c;
import e.c.a.g.a.g.h.d;
import e.c.a.g.a.g.h.e;
import e.c.a.g.a.g.h.f;
import e.c.a.g.a.g.h.g;
import e.c.a.g.a.g.h.h;
import e.c.a.g.a.g.h.i;
import e.c.a.g.a.g.h.j;
import e.c.a.g.a.g.n.d;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.o;
import e.c.c.l.f.b;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
@b(id = -1)
public final class MainFragment extends DelegateFragment {
    public PlayerBall A;
    public final BroadcastReceiver B = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.MainFragment$broadcastReceiver$1
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:109:0x018a  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0132  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r6, android.content.Intent r7) {
            /*
                Method dump skipped, instruction units count: 508
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.component.MainFragment$broadcastReceiver$1.onReceive(android.content.Context, android.content.Intent):void");
        }
    };
    public f r;
    public e s;
    public d t;
    public g u;
    public c v;
    public e.c.a.g.a.g.h.m.b w;
    public j x;
    public h y;
    public e.c.a.g.a.g.h.b z;

    public final void C0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.android.user_login_success");
        intentFilter.addAction("com.kugou.android.login_token_expire");
        intentFilter.addAction("com.kugou.android.user_login_out");
        intentFilter.addAction("com.kugou.android.mymusic.fav.cloudsycing");
        intentFilter.addAction("com.kugou.android.download_file_success");
        intentFilter.addAction("com.kugou.android.refresh_filtersong");
        intentFilter.addAction("com.kugou.android.update_fav_btn_state");
        intentFilter.addAction("com.kugou.young.watch.songdbupdated");
        intentFilter.addAction("com.kugou.android.cloud_music_delete_success");
        intentFilter.addAction("com.kugou.android.action.user_vip_expire");
        intentFilter.addAction("com.kugou.android.action.config.update.complete");
        a.b(this.B, intentFilter);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        PlayerBall playerBall = this.A;
        if (playerBall != null) {
            playerBall.j(false);
        }
        e.c.a.g.a.g.h.b bVar = this.z;
        if (bVar == null) {
            return;
        }
        bVar.e();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        PlayerBall playerBall = this.A;
        if (playerBall != null) {
            playerBall.j(e.c.a.g.a.d.x.f.q());
        }
        j jVar = this.x;
        if (jVar != null) {
            jVar.c();
        }
        e.c.a.g.a.g.h.b bVar = this.z;
        if (bVar != null) {
            bVar.f();
        }
        g gVar = this.u;
        if (gVar != null) {
            gVar.e();
        }
        d dVar = this.t;
        if (dVar != null) {
            dVar.f();
        }
        h hVar = this.y;
        if (hVar != null) {
            hVar.b();
        }
        Log.e("mhs_watch_resume", "onFragmentResume");
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public int o() {
        return 4;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_main, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a.g(this.B);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e.c.a.g.a.g.h.b bVar = this.z;
        if (bVar != null) {
            bVar.a();
        }
        o.a(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.r.d.b bVar) {
        f.z.d.j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        f fVar = this.r;
        if (fVar == null) {
            return;
        }
        fVar.c();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        e.c.a.g.a.g.h.b bVar = this.z;
        if (bVar != null) {
            bVar.g();
        }
        g gVar = this.u;
        if (gVar != null) {
            gVar.e();
        }
        d dVar = this.t;
        if (dVar != null) {
            dVar.f();
        }
        Log.e("mhs_watch_resume", "onResume");
        EventBus.getDefault().post(new e.c.a.g.a.t.b());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.j.e(view, "view");
        super.onViewCreated(view, bundle);
        e.c.a.g.a.r.e.d.d().f();
        this.y = new h(this, view);
        this.r = new f(this, view.findViewById(R.id.login_entry));
        View viewJ0 = j0(R.id.header_content_container);
        Objects.requireNonNull(viewJ0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewJ0;
        e.c.a.g.a.g.h.b aVar = m.m() ? new e.c.a.g.a.g.h.n.a(this, viewGroup) : new e.c.a.g.a.g.h.k.a(this, viewGroup);
        this.z = aVar;
        f.z.d.j.c(aVar);
        aVar.h();
        PlayerBall playerBall = (PlayerBall) view.findViewById(R.id.play_ball);
        this.A = playerBall;
        if (playerBall != null) {
            playerBall.setupFragment(this);
        }
        new i(this, view);
        this.x = new j(this, (ViewGroup) view);
        this.s = new e(this, view);
        this.t = new d(this, view);
        this.u = new g(this, view);
        this.v = new c(this, view);
        this.w = new e.c.a.g.a.g.h.m.b(this, view);
        C0();
        EventBus.getDefault().register(this);
        e.c.a.g.a.g.n.d dVar = new e.c.a.g.a.g.n.d();
        Context context = KGApplication.getContext();
        f.z.d.j.d(context, "getContext()");
        dVar.c(context);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "首页";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        j jVar;
        super.setUserVisibleHint(z);
        PlayerBall playerBall = this.A;
        if (playerBall != null) {
            playerBall.j(z && e.c.a.g.a.d.x.f.q());
        }
        if (!z || (jVar = this.x) == null) {
            return;
        }
        jVar.c();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.d.b bVar) {
        f.z.d.j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        d dVar = this.t;
        if (dVar == null) {
            return;
        }
        dVar.e();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.r.d.c cVar) {
        f fVar = this.r;
        if (fVar != null) {
            fVar.c();
        }
        j jVar = this.x;
        if (jVar == null) {
            return;
        }
        jVar.e();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.m.a aVar) {
        f.z.d.j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        if (aVar.a()) {
            g gVar = this.u;
            if (gVar == null) {
                return;
            }
            gVar.f();
            return;
        }
        g gVar2 = this.u;
        if (gVar2 == null) {
            return;
        }
        gVar2.d();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.p.a aVar) {
        f.z.d.j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        j jVar = this.x;
        if (jVar == null) {
            return;
        }
        jVar.e();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(d.a aVar) {
        f.z.d.j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        e.c.a.g.a.d.h.a aVar2 = new e.c.a.g.a.d.h.a(activity);
        aVar2.e("由于手表系统升级，需重新设置铃声。若打开失败，可重启设备\n路径：设置-> 声音->来电铃声");
        aVar2.f(16);
        aVar2.b("知道了");
        aVar2.a("返回");
        aVar2.show();
    }
}
