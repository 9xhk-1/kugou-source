package com.kugou.android.watch.lite.setting;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.about.DebugActivity;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.component.privacy.PrivacyActivity;
import e.c.a.g.a.p.c;
import e.c.a.g.a.p.d;
import e.c.a.g.a.p.e;
import e.c.a.g.a.p.f;
import e.c.a.g.a.p.g;
import e.c.a.g.a.p.h;
import e.c.a.g.a.p.i;
import e.c.a.g.a.p.j;
import e.c.a.g.a.p.k;
import e.c.a.g.a.p.l;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.o;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class SettingFragment extends DelegateFragment {
    public e.c.a.g.a.p.d r;
    public e.c.a.g.a.p.c s;
    public j t;
    public h u;
    public e.c.a.g.a.p.b v;
    public int w;
    public TextView x;
    public final BroadcastReceiver y = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.setting.SettingFragment$broadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f.z.d.j.e(context, "context");
            f.z.d.j.e(intent, "intent");
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action == null) {
                return;
            }
            int iHashCode = action.hashCode();
            if (iHashCode != -816261678) {
                if (iHashCode != -643285989) {
                    if (iHashCode != -411132336 || !action.equals("com.kugou.android.user_login_success")) {
                        return;
                    }
                } else if (!action.equals("com.kugou.android.user_login_out")) {
                    return;
                }
            } else if (!action.equals("com.kugou.android.login_token_expire")) {
                return;
            }
            c cVar = this.a.s;
            if (cVar != null) {
                cVar.a();
            }
            d dVar = this.a.r;
            if (dVar != null) {
                dVar.a();
            }
            h hVar = this.a.u;
            if (hVar != null) {
                hVar.b();
            }
            this.a.E0();
        }
    };

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SettingFragment.this.B0("https://activity.kugou.com/vo-activity/9d1de340-f12f-11ea-a6d8-cb820bfee842/index.html#/service", "用户协议");
            e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("10").setTab(e.c.a.g.a.r.b.F() ? "1" : "0"));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SettingFragment.C0(SettingFragment.this, "https://activity.kugou.com/terms/v-9d1de340/index.html#/privacy", null, 2, null);
            e.c.a.g.a.e.b.b(new YoungBITask(20485, "click").setType("9").setTab(e.c.a.g.a.r.b.F() ? "1" : "0"));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SettingFragment.this.w++;
            if (SettingFragment.this.w >= 8) {
                DebugActivity.f7d.a(SettingFragment.this.getContext());
                SettingFragment.this.w = 0;
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String config = e.c.a.g.a.f.e.c.a.a().getConfig(e.c.a.g.a.f.e.b.L2);
            if (config.length() == 0) {
                config = "https://beian.miit.gov.cn";
            }
            SettingFragment.this.B0(config, "APP备案号");
        }
    }

    public static /* synthetic */ void C0(SettingFragment settingFragment, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "隐私政策";
        }
        settingFragment.B0(str, str2);
    }

    public final void B0(String str, String str2) {
        if (getContext() instanceof Activity) {
            Intent intent = new Intent(getContext(), (Class<?>) PrivacyActivity.class);
            intent.putExtra("privacy_url", str);
            intent.putExtra("privacy_name", str2);
            startActivity(intent);
        }
    }

    public final void D0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.android.user_login_success");
        intentFilter.addAction("com.kugou.android.login_token_expire");
        intentFilter.addAction("com.kugou.android.user_login_out");
        e.c.a.g.a.f.d.a.b(this.y, intentFilter);
        EventBus.getDefault().register(this);
        e.c.a.g.a.r.a.h();
    }

    public final void E0() {
        if (!e.c.a.g.a.r.b.F()) {
            TextView textView = this.x;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = this.x;
        if (textView2 != null) {
            textView2.setText(f.z.d.j.l("ID: ", Long.valueOf(e.c.a.g.a.r.b.o())));
        }
        TextView textView3 = this.x;
        if (textView3 == null) {
            return;
        }
        textView3.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_setting, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        o.a(this);
        e.c.a.g.a.f.d.a.g(this.y);
        e.c.a.g.a.p.b bVar = this.v;
        if (bVar == null) {
            return;
        }
        bVar.j();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.r.d.c cVar) {
        e.c.a.g.a.p.d dVar = this.r;
        if (dVar == null) {
            return;
        }
        dVar.a();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        E0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.j.e(view, "view");
        super.onViewCreated(view, bundle);
        this.r = new e.c.a.g.a.p.d(this, view);
        this.s = new e.c.a.g.a.p.c(this, view);
        this.t = new j(this, view);
        new e.c.a.g.a.p.a(this, view);
        this.u = new h(this, view);
        if (e.c.a.g.a.g.e.d.a.k()) {
            new f(this, view);
        }
        new g(this, view);
        new k(this, view);
        new i(this, view);
        new e(this, view);
        this.v = new e.c.a.g.a.p.b(this, view);
        view.findViewById(R.id.privacy_user).setOnClickListener(new a());
        view.findViewById(R.id.privacy).setOnClickListener(new b());
        this.x = (TextView) view.findViewById(R.id.user_id);
        E0();
        TextView textView = (TextView) view.findViewById(R.id.version_name);
        textView.setText(f.z.d.j.l("酷狗概念版 v", e.c.a.g.a.s.d.a(getContext())));
        if (g0.a) {
            textView.setOnClickListener(new c());
        }
        TextView textView2 = (TextView) view.findViewById(R.id.record_number);
        String config = e.c.a.g.a.f.e.c.a.a().getConfig(e.c.a.g.a.f.e.b.M2);
        if (config.length() == 0) {
            config = "粤ICP备09017694号-36A";
        }
        textView2.setText(f.z.d.j.l("酷狗概念版APP备案号:\n", config));
        textView2.setOnClickListener(new d());
        D0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "设置页";
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.r.d.b bVar) {
        f.z.d.j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        if (bVar.a == 1) {
            if (bVar.b == 200) {
                e.c.a.g.a.e.b.b(new YoungBITask(20486, "statistics").setSvar1("2").setSvar2(bVar.c));
            } else {
                e.c.a.g.a.e.b.b(new YoungBITask(20486, "statistics"));
            }
        }
        e.c.a.g.a.p.d dVar = this.r;
        if (dVar == null) {
            return;
        }
        dVar.a();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(l lVar) {
        f.z.d.j.e(lVar, NotificationCompat.CATEGORY_EVENT);
        j jVar = this.t;
        if (jVar == null) {
            return;
        }
        jVar.a(lVar.a());
    }
}
