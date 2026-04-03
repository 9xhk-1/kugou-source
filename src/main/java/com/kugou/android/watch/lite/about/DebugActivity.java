package com.kugou.android.watch.lite.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.activity.StateFragmentActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.component.LimitUseActivity;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import com.kugou.android.watch.lite.qrscan.risk.RiskActivity;
import com.kugou.android.watch.lite.user.login.LoginRiskActivity;
import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import com.kugou.common.startAppAPM.task.MemoryReportHelper;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import f.u.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DebugActivity extends StateFragmentActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f7d = new a(null);
    public DebugActivity a = this;
    public CheckBox b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }

        public final void a(Context context) {
            if (context == null) {
                return;
            }
            context.startActivity(s0.a.a(context, DebugActivity.class));
        }
    }

    public static final class b implements View.OnClickListener {
        public static final b a = new b();

        public static final class a implements Runnable {
            public static final a a = new a();

            @Override // java.lang.Runnable
            public final void run() {
                e.c.a.g.a.g.d.d.a.a();
                e.c.a.g.a.g.m.b.a.c();
                p1.h(KGApplication.getContext(), "删除成功，重启生效");
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            j0.b().a(a.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public static final c a = new c();

        public static final class a implements Runnable {
            public static final a a = new a();

            @Override // java.lang.Runnable
            public final void run() {
                p1.h(KGApplication.getContext(), "开始注入下载记录，请稍等");
                String strJ = e.c.a.g.a.r.b.j();
                e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
                f.z.d.j.d(strJ, "favId");
                int i2 = 0;
                List<KGPlaylistMusic> listN = bVar.n(strJ, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                if (listN == null || listN.isEmpty()) {
                    return;
                }
                List listF = u.F(listN.subList(0, f.b0.f.e(501, listN.size())));
                ArrayList arrayList = new ArrayList(f.u.n.j(listF, 10));
                for (Object obj : listF) {
                    int i3 = i2 + 1;
                    e.c.a.g.a.d.f.c.a.a aVar = null;
                    if (i2 < 0) {
                        f.u.m.i();
                        throw null;
                    }
                    KGMusic kGMusicN = e.c.a.g.a.g.k.a.a.n(((KGPlaylistMusic) obj).p());
                    if (kGMusicN != null) {
                        KGMusicWrapper kGMusicWrapperD = e.c.a.g.a.f.j.a.c.d(kGMusicN, Initiator.create(e.c.a.g.a.d.v.c.c().m()));
                        aVar = new e.c.a.g.a.d.f.c.a.a();
                        aVar.w(f.z.d.j.l("down-key-", Integer.valueOf(i2)));
                        aVar.x(FileDownloadState.FILE_DOWNLOAD_STATE_SUCCEEDED.ordinal());
                        aVar.A(kGMusicWrapperD.getMixId());
                        aVar.B(kGMusicWrapperD.getSongQuality());
                        String hashValue = kGMusicWrapperD.getHashValue();
                        f.z.d.j.d(hashValue, "wrapper.hashValue");
                        aVar.C(hashValue);
                        String feeAlbumID = kGMusicWrapperD.getFeeAlbumID();
                        if (feeAlbumID == null) {
                            feeAlbumID = "";
                        }
                        aVar.y(feeAlbumID);
                        aVar.z(f.z.d.j.l("down-path-", Integer.valueOf(i2)));
                        aVar.D(f.z.d.j.l("down-tmpCachePath-", Integer.valueOf(i2)));
                    }
                    arrayList.add(aVar);
                    i2 = i3;
                }
                e.c.a.g.a.g.d.d.a.j(u.r(arrayList));
                p1.f(KGApplication.getContext(), "下载注入成功，重启生效");
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            j0.b().a(a.a);
        }
    }

    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DebugActivity.this.startActivity(new Intent(DebugActivity.this.e(), (Class<?>) LoginRiskActivity.class));
        }
    }

    public static final class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            LimitUseActivity.b.a(DebugActivity.this);
        }
    }

    public static final class f implements View.OnClickListener {
        public static final f a = new f();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            KGApplication.getContext().startActivity(s0.a.a(KGApplication.getContext(), RiskActivity.class).putExtra("arg_event_id", "test_evnt_id").putExtra("arg_bus_id", "test_bus_id"));
        }
    }

    public static final class g implements View.OnClickListener {
        public static final g a = new g();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemoryReportHelper.INSTANCE.memoryReport(1, "当前运行内存不足，可能会导致卡顿");
        }
    }

    public static final class h implements View.OnClickListener {
        public static final h a = new h();

        public static final class a implements Runnable {
            public static final a a = new a();

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                p1.h(KGApplication.getContext(), "开始注入历史记录，请稍等");
                String strJ = e.c.a.g.a.r.b.j();
                e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
                f.z.d.j.d(strJ, "favId");
                int i2 = 0;
                List<KGPlaylistMusic> listN = bVar.n(strJ, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                if (listN == null || listN.isEmpty()) {
                    return;
                }
                List<KGPlaylistMusic> listSubList = listN.subList(0, f.b0.f.e(523, listN.size()));
                long jCurrentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList(f.u.n.j(listSubList, 10));
                for (Object obj : listSubList) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        f.u.m.i();
                        throw null;
                    }
                    KGMusic kGMusicN = e.c.a.g.a.g.k.a.a.n(((KGPlaylistMusic) obj).p());
                    e.c.a.g.a.d.f.c.a.q qVar = new e.c.a.g.a.d.f.c.a.q();
                    qVar.e(jCurrentTimeMillis - ((long) (i2 * 1000)));
                    qVar.f(kGMusicN == null ? 0L : kGMusicN.mixId);
                    String str2 = "";
                    if (kGMusicN != null && (str = kGMusicN.hashValue) != null) {
                        str2 = str;
                    }
                    qVar.d(str2);
                    arrayList.add(qVar);
                    i2 = i3;
                }
                e.c.a.g.a.g.m.b.a.h(arrayList);
                p1.f(KGApplication.getContext(), "历史注入成功，重启生效");
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            j0.b().a(a.a);
        }
    }

    public static final class i implements View.OnClickListener {
        public static final i a = new i();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            s0.a.C(new Bundle());
        }
    }

    public static final class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DebugActivity.this.finish();
        }
    }

    public static final class k implements CompoundButton.OnCheckedChangeListener {
        public k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CheckBox checkBoxF;
            e.c.a.g.a.c.a.a.h(z);
            CheckBox checkBoxF2 = DebugActivity.this.f();
            boolean z2 = false;
            if (checkBoxF2 != null && !checkBoxF2.isChecked()) {
                z2 = true;
            }
            if (z2 && z && (checkBoxF = DebugActivity.this.f()) != null) {
                checkBoxF.setChecked(true);
            }
        }
    }

    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.c.a.a.e(!r2.b());
            DebugActivity.this.h();
            p1.h(DebugActivity.this.getApplicationContext(), "重启应用后生效");
        }
    }

    public static final class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.a.g.a.c.a.a.g(!r2.c());
            DebugActivity.this.i();
            p1.h(DebugActivity.this.getApplicationContext(), "重启应用后生效");
        }
    }

    public static final class n implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int iU = h1.u(String.valueOf(editable), -1);
            if (iU > 0) {
                e.c.a.g.a.c.a.a.f(iU);
                if (g0.a) {
                    g0.b("young-hqd", f.z.d.j.l("setCustomChannel: 自定义渠道为：", Integer.valueOf(iU)));
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public static final class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            p1.h(DebugActivity.this.getApplicationContext(), String.valueOf(new int[]{1, 2}[10]));
        }
    }

    public static final class p implements View.OnClickListener {
        public static final p a = new p();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.b.a.b.a.a().g();
        }
    }

    public static final class q implements View.OnClickListener {
        public static final q a = new q();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.b.a.b.a.a().h();
        }
    }

    public static final class r implements View.OnClickListener {
        public static final r a = new r();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.c.b.a.b.a.a().f();
        }
    }

    public final DebugActivity e() {
        return this.a;
    }

    public final CheckBox f() {
        return this.b;
    }

    public final void g(int i2, String str, Object obj) {
        ((TextView) findViewById(i2)).setText(str + (char) 65306 + obj);
    }

    public final void h() {
        g(R.id.tv_health_time_limit, "健康提示时间改1分钟", Boolean.valueOf(e.c.a.g.a.c.a.a.b()));
    }

    public final void i() {
        g(R.id.tv_mock_url, "接口走代理模式", Boolean.valueOf(e.c.a.g.a.c.a.a.c()));
    }

    @Override // com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_debug);
        findViewById(R.id.back_view).setOnClickListener(new j());
        g(R.id.version_code, "版本号", Integer.valueOf(l1.G()));
        g(R.id.git_version, "gitVersion", "8bc5fbeb");
        g(R.id.tv_uuid, "uuid", e.c.a.g.a.s.m.i(false));
        g(R.id.tv_mid, "mid", l1.n(e.c.c.o.f.a()));
        g(R.id.tv_channel, "channel", l1.j());
        h();
        i();
        CheckBox checkBox = (CheckBox) findViewById(R.id.test_mode_checkbox);
        this.b = checkBox;
        if (checkBox != null) {
            checkBox.setChecked(e.c.a.g.a.c.a.a.d());
        }
        CheckBox checkBox2 = this.b;
        if (checkBox2 != null) {
            checkBox2.setOnCheckedChangeListener(new k());
        }
        findViewById(R.id.tv_health_time_limit).setOnClickListener(new l());
        findViewById(R.id.tv_mock_url).setOnClickListener(new m());
        EditText editText = (EditText) findViewById(R.id.et_custom_channel);
        int iA = e.c.a.g.a.c.a.a.a();
        editText.setText(iA > 0 ? String.valueOf(iA) : "");
        editText.addTextChangedListener(new n());
        findViewById(R.id.button_test_java_crash).setOnClickListener(new o());
        View viewFindViewById = findViewById(R.id.debug_fire_eye_java);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(p.a);
        }
        View viewFindViewById2 = findViewById(R.id.debug_fire_eye_native);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(q.a);
        }
        View viewFindViewById3 = findViewById(R.id.debug_fire_eye_anr);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(r.a);
        }
        findViewById(R.id.button_del_down_and_recent).setOnClickListener(b.a);
        findViewById(R.id.button_download_add).setOnClickListener(c.a);
        findViewById(R.id.button_login_jump).setOnClickListener(new d());
        findViewById(R.id.button_limit_jump).setOnClickListener(new e());
        findViewById(R.id.button_risk_jump).setOnClickListener(f.a);
        findViewById(R.id.button_memory_jump).setOnClickListener(g.a);
        findViewById(R.id.button_recent_add).setOnClickListener(h.a);
        findViewById(R.id.button_test_jump_pay).setOnClickListener(i.a);
    }
}
