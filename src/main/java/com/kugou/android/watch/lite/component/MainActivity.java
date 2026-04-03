package com.kugou.android.watch.lite.component;

import android.R;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.base.activity.FrameworkActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.datacollect.senter.DeviceFingerModel;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import com.kugou.common.startAppAPM.task.MemoryReportHelper;
import com.kugou.framework.tmeab.TMEABManager;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.d.x.v.c;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.r.e.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.r0;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.y0;
import f.z.d.j;
import f.z.d.u;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes.dex */
public final class MainActivity extends FrameworkActivity {
    public static final a q = new a(null);
    public static boolean r = false;
    public static boolean s = true;
    public boolean j;
    public e.c.a.f.a k;
    public boolean m;
    public boolean n;
    public final f.d l = f.f.b(new b());
    public final f.d o = f.f.b(e.a);
    public final BroadcastReceiver p = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.MainActivity$broadcastReceiver$1

        public static final class a implements View.OnClickListener {
            public static final a a = new a();

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.a.l("1");
            }
        }

        public static final class b implements Runnable {
            public static final b a = new b();

            @Override // java.lang.Runnable
            public final void run() {
                f.x();
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            j.e(context, "context");
            j.e(intent, "intent");
            String action = intent.getAction();
            if (TextUtils.isEmpty(action) || action == null) {
                return;
            }
            switch (action.hashCode()) {
                case -1203446588:
                    if (action.equals("com.kugou.young.watch.playstatechanged") && intent.getBooleanExtra("arg_is_playing", false)) {
                        c.a().d(this.a);
                        return;
                    }
                    return;
                case -816261678:
                    if (action.equals("com.kugou.android.login_token_expire")) {
                        e.c.a.g.a.d.r.b.d().b();
                        d.d().c();
                        EventBus.getDefault().post(new e.c.a.g.a.r.d.b(6));
                        if (this.a.isFinishing() || this.a.isDestroyed()) {
                            return;
                        }
                        MainActivity mainActivity = this.a;
                        mainActivity.T();
                        e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(mainActivity);
                        aVar.e("账号信息过期，请重新登录");
                        aVar.a("取消");
                        aVar.b("确认");
                        aVar.d(a.a);
                        aVar.show();
                        return;
                    }
                    return;
                case -663260908:
                    if (action.equals("com.kugou.android.auto.login_time_error")) {
                        MainActivity mainActivity2 = this.a;
                        mainActivity2.T();
                        p1.h(mainActivity2, "当前系统时间错误，请检查无误后重新启动app");
                        e.c.a.g.a.e.b.b(new YoungBITask(22020024, "statistics").setSource("TIME_ERROR"));
                        return;
                    }
                    return;
                case -643285989:
                    if (action.equals("com.kugou.android.user_login_out")) {
                        e.c.a.g.a.d.r.b.d().b();
                        return;
                    }
                    return;
                case -429996727:
                    if (!action.equals("com.kugou.android.action.VIP_PAY_SUCCESS")) {
                        return;
                    }
                    break;
                case -411132336:
                    if (action.equals("com.kugou.android.user_login_success")) {
                        if (!intent.getBooleanExtra("key_login_type", false)) {
                            e.c.a.g.a.d.r.a.c().i();
                            e.c.a.g.a.g.h.l.c cVar = e.c.a.g.a.g.h.l.c.a;
                            MainActivity mainActivity3 = this.a;
                            mainActivity3.T();
                            cVar.d(mainActivity3);
                        }
                        e.c.d.d.d().e().onUserInfoChange(e.c.a.g.a.r.b.o(), e.c.a.g.a.r.b.z(), e.c.a.g.a.r.b.O(), e.c.a.g.a.r.b.n());
                        e.c.a.g.a.d.r.b.d().b();
                        return;
                    }
                    return;
                case -140236885:
                    if (action.equals("com.kugou.android.action.traffic.protection")) {
                        MainActivity mainActivity4 = this.a;
                        mainActivity4.T();
                        u0.e(mainActivity4, b.a);
                        return;
                    }
                    return;
                case 764269154:
                    if (action.equals("com.kugou.young.watch.metachanged")) {
                        this.a.c0();
                        return;
                    }
                    return;
                case 1466345912:
                    if (!action.equals("com.kugou.android.action.BECOME_VIP_STATE")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            e.c.a.g.a.d.r.b.d().b();
            f.D(action);
            EventBus.getDefault().post(new e.c.a.g.a.r.d.b(5));
        }
    };

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }

        public final void a(Context context, Intent intent) {
            f.z.d.j.e(context, "context");
            if (intent == null) {
                intent = s0.a.a(context, MainActivity.class);
            }
            intent.setClass(context, MainActivity.class);
            if (context instanceof Activity) {
                intent.addFlags(67108864);
            } else {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static final class b extends f.z.d.k implements f.z.c.a<e.c.a.g.a.q.a> {
        public b() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.q.a invoke() {
            if (l1.m0()) {
                return new e.c.a.g.a.q.a(MainActivity.this);
            }
            return null;
        }
    }

    public static final class c<T> implements Action1 {
        public static final c<T> a = new c<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            e.c.a.g.a.g.e.d dVar = e.c.a.g.a.g.e.d.a;
            Context context = KGApplication.getContext();
            f.z.d.j.d(context, "getContext()");
            dVar.a(context);
        }
    }

    public static final class d<T> implements Action1 {
        public static final d<T> a = new d<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            e.c.a.g.a.g.e.d dVar = e.c.a.g.a.g.e.d.a;
            Context context = KGApplication.getContext();
            f.z.d.j.d(context, "getContext()");
            dVar.m(context);
        }
    }

    public static final class e extends f.z.d.k implements f.z.c.a<Boolean> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        public final boolean a() {
            return e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.I2, true);
        }

        @Override // f.z.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(a());
        }
    }

    public static final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MainActivity.this.S();
        }
    }

    public static final class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (l1.l0(KGApplication.getContext())) {
                MainActivity.this.b0();
            }
        }
    }

    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MainActivity.this.a0();
        }
    }

    public static final class i<T> implements Action1 {
        public i() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            try {
                String launcherTag = "";
                if (l1.X()) {
                    launcherTag = DeviceFingerModel.getLauncherTag(KGApplication.getContext());
                    f.z.d.j.d(launcherTag, "getLauncherTag(KGApplication.getContext())");
                }
                Log.e("mhs_watch", "MainActivity report devices");
                long jD = e.c.a.g.a.s.d.d(KGApplication.getContext());
                long jI = l1.i(e.c.c.o.f.a());
                String strL = f.z.d.j.l("KGAppImpl.isFirstInstall = ", Boolean.valueOf(e.c.a.g.a.d.c.b.c));
                try {
                    u uVar = u.a;
                    String str2 = String.format(", onCreate: 首次安装:%s, 覆盖安装：%s, oldVer:%s, newVer:%s", Arrays.copyOf(new Object[]{Boolean.valueOf(MainActivity.this.n), KGApplication.isCoverInstall, Integer.valueOf(e.c.a.g.a.f.m.a.b().d(-1)), Integer.valueOf(e.c.a.g.a.f.m.a.b().a(-1))}, 4));
                    f.z.d.j.d(str2, "java.lang.String.format(format, *args)");
                    strL = f.z.d.j.l(strL, str2);
                } catch (Exception unused) {
                }
                e.c.a.g.a.e.b.b(new YoungBITask(12821076, "startup").setSvar1(m.g()).setSvar2(m.d()).setSvar3("存储内存=" + (jD / ((long) 1048576)) + ", 运行内存 = " + jI).setSvar4(f.z.d.j.l("九学王尾标=", launcherTag)).setSvar5(strL));
            } catch (Exception e2) {
                g0.k(e2);
                e2.printStackTrace();
            }
        }
    }

    public static final class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Intent intent = MainActivity.this.getIntent();
            Integer numValueOf = intent == null ? null : Integer.valueOf(intent.getIntExtra("key_net_request_dialog_type", -1));
            if (numValueOf != null && numValueOf.intValue() == 1) {
                e.c.a.g.a.d.x.f.B();
                return;
            }
            if (numValueOf != null && numValueOf.intValue() == 2) {
                e.c.a.g.a.d.x.f.x();
            } else if (numValueOf != null && numValueOf.intValue() == 3) {
                e.c.a.g.a.d.x.f.s();
            }
        }
    }

    public static final class k<T, R> implements Func1 {
        public static final k<T, R> a = new k<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long call(String str) {
            return Long.valueOf(e.c.a.g.a.d.x.f.p(true) ? y0.c(e.c.a.g.a.d.x.f.e(), 30) : -1L);
        }
    }

    public static final class l<T> implements Action1 {
        public l() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Long l) {
            String string;
            f.z.d.j.d(l, "listenPartSec");
            if (l.longValue() <= 0 || !MainActivity.this.j) {
                return;
            }
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            if (e.c.a.g.a.r.b.O()) {
                if (r0.f(kGMusicWrapperE == null ? null : kGMusicWrapperE.getMusicTransParamEnenty())) {
                    p1.h(MainActivity.this, "付费专辑歌曲，可试听" + l + "秒，请登录手机端购买专辑后播放~");
                }
            } else {
                p1.h(MainActivity.this, "会员专属歌曲，可试听" + l + (char) 31186);
            }
            YoungBITask youngBITask = new YoungBITask(20493, "exposure");
            String str = "";
            if (kGMusicWrapperE != null && (string = Long.valueOf(kGMusicWrapperE.getMixId()).toString()) != null) {
                str = string;
            }
            e.c.a.g.a.e.b.b(youngBITask.setMixsongid(str).setType("1"));
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity
    public void A(Bundle bundle) {
        super.A(bundle);
        e.c.a.g.a.d.r.a.c().i();
        e.c.a.g.a.g.p.b.f1018d.a().n();
        TMEABManager.Companion.getInstance().initConfig();
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity
    public void B() {
        boolean zA;
        super.B();
        e.c.a.f.a aVarV = V();
        T();
        aVarV.b(this);
        if (l1.m0()) {
            j0.h(new f(), 700L);
        }
        if (e.c.a.g.a.r.b.F()) {
            zA = false;
        } else if (f.z.d.j.a(KGApplication.isFirstStartAfterInstall, Boolean.TRUE)) {
            new e.c.a.g.a.r.e.c().b();
            new e.c.a.g.a.r.e.c().c();
            KGApplication.isFirstStartAfterInstall = Boolean.FALSE;
            this.n = true;
            zA = true;
        } else {
            zA = new e.c.a.g.a.r.e.c().a();
        }
        e.c.a.g.a.t.c.b = true;
        if (!zA) {
            EventBus.getDefault().post(new e.c.a.g.a.t.d(e.c.a.g.a.t.d.c));
        }
        if (g0.f()) {
            Log.d("mhs_watch", "onFirstFaceAsync VoiceCmdEvent.sHasFinishLoginCheck = " + e.c.a.g.a.t.c.b + "  CommonEnvManager.isLogin() = " + e.c.a.g.a.r.b.F() + "  KGApplication.isFirstStartAfterInstall = " + KGApplication.isFirstStartAfterInstall + "  jumpLogin = " + zA);
        }
        Y();
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity
    public void C() {
        super.C();
        this.j = true;
        ApmReportHelper apmReportHelper = ApmReportHelper.INSTANCE;
        apmReportHelper.uiStartApmLoadTime();
        apmReportHelper.startAppSuccess();
        Log.e("mhs_watch_resume", "onFirstResume");
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity
    public void E() {
        if (e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.p4, true)) {
            e.c.a.g.a.d.s.h.i().j(e.c.a.g.a.r.b.o());
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity
    public void F() {
        super.F();
        if (e.c.a.g.a.d.d0.c.a.r()) {
            j0.b().a(new g());
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity
    public void G() {
        super.G();
        this.j = true;
        Log.e("mhs_watch_resume", "onNormalResume");
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity
    public void I() {
        super.I();
        runOnUiThread(new h());
        e.c.a.g.a.f.e.d.b().a();
        e.c.a.g.a.e.b.a(new YoungBITask(1, "startup").setState(e.c.a.g.a.t.c.f1234i ? "1" : "2").setSvar4(e.c.a.g.a.t.c.f1230e ? "1" : "0").setSvar5(e.c.a.g.a.f.m.c.a.e("key_xtc_widget_add", false) ? "1" : "0"));
        if (g0.f()) {
            g0.b("mhs_watch", f.z.d.j.l("isFirstStartApp = ", Boolean.valueOf(e.c.a.g.a.t.c.f1234i)));
        }
        e.c.a.g.a.t.c.f1234i = false;
        m1.e(3500, new i());
        if (e.c.a.g.a.d.c.b.c) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020028, "click"));
        }
    }

    public final boolean R() {
        Configuration configuration;
        Resources resources = getResources();
        Integer numValueOf = null;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            numValueOf = Integer.valueOf(configuration.orientation);
        }
        return numValueOf != null && numValueOf.intValue() == 2;
    }

    public final void S() {
        if (r || u0.v(this) || !u0.x(this) || isFinishing() || isDestroyed()) {
            return;
        }
        r = true;
        try {
            e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(this);
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.e("您的网络已被家长禁用");
            aVar.a("关闭");
            aVar.b("知道了");
            aVar.show();
        } catch (WindowManager.BadTokenException e2) {
            g0.i(e2);
        }
    }

    public final MainActivity T() {
        return this;
    }

    public final e.c.a.g.a.q.a U() {
        return (e.c.a.g.a.q.a) this.l.getValue();
    }

    public final e.c.a.f.a V() {
        if (this.k == null) {
            this.k = new e.c.a.f.a();
        }
        e.c.a.f.a aVar = this.k;
        f.z.d.j.c(aVar);
        return aVar;
    }

    public final void W(Bundle bundle) {
        y(bundle);
        X();
        e.c.a.g.a.f.o.d.b(findViewById(R.id.content));
        e.c.a.g.a.q.a aVarU = U();
        if (aVarU == null) {
            return;
        }
        aVarU.e(getIntent());
    }

    public final void X() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.android.user_login_success");
        intentFilter.addAction("com.kugou.android.login_token_expire");
        intentFilter.addAction("com.kugou.android.user_login_out");
        intentFilter.addAction("com.kugou.young.watch.metachanged");
        intentFilter.addAction("com.kugou.young.watch.playstatechanged");
        intentFilter.addAction("com.kugou.android.action.traffic.protection");
        intentFilter.addAction("com.kugou.android.action.VIP_PAY_SUCCESS");
        intentFilter.addAction("com.kugou.android.action.BECOME_VIP_STATE");
        intentFilter.addAction("com.kugou.android.auto.login_time_error");
        e.c.a.g.a.f.d.a.b(this.p, intentFilter);
    }

    public final void Y() {
        if (e.c.a.g.a.g.e.d.a.k()) {
            m1.f(c.a);
            m1.f(d.a);
        }
    }

    public final boolean Z() {
        return ((Boolean) this.o.getValue()).booleanValue();
    }

    public final void a0() {
        Intent intent = getIntent();
        String action = intent == null ? null : intent.getAction();
        if (action == null) {
            return;
        }
        if (f.z.d.j.a(action, "action_show_hint")) {
            LimitUseActivity.b.a(this);
        } else if (f.z.d.j.a(action, "action_show_net_request_dialog")) {
            T();
            u0.e(this, new j());
        }
    }

    public final void b0() {
        e.c.a.g.a.d.d0.c cVar = e.c.a.g.a.d.d0.c.a;
        if (cVar.r()) {
            if (!cVar.e()) {
                Log.e("mhs_watch_xlog", "resumeDownload 不能写入xlog 不上传");
                return;
            }
            try {
                if (cVar.h() && !e.c.a.g.a.f.m.b.m().B()) {
                    Log.e("mhs_watch_xlog", "forceUploadXlogContent = " + cVar.h() + ", 强制上传 之前没有上传过.");
                    e.c.a.g.a.g.g.d.a.g(e.c.a.g.a.r.b.F() ? f.z.d.j.l("", Long.valueOf(e.c.a.g.a.r.b.o())) : "123123123", 3);
                    return;
                }
                String strD = e.c.a.g.a.f.m.b.m().D();
                f.z.d.j.d(strD, "getInstance().isNeedUploadFeedbackFiles()");
                Log.e("mhs_watch_xlog", "forceUploadXlogContent = " + cVar.h() + ", msg = ." + strD);
                Object[] array = new f.e0.e("_").b(strD, 0).toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr = (String[]) array;
                if (strArr == null || !Boolean.parseBoolean(strArr[0]) || TextUtils.isEmpty(strArr[1])) {
                    Log.e("mhs_watch_xlog", "不需要重试上传");
                } else {
                    Log.e("mhs_watch_xlog", "重试上传");
                    e.c.a.g.a.g.g.d.a.g(strArr[1], 2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void c0() {
        if (this.j) {
            Observable.just("").delay(500L, TimeUnit.MILLISECONDS).map(k.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(), i1.b);
        }
    }

    public final void d0() {
        c.b bVar = e.c.a.g.a.f.e.c.a;
        boolean z = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.a3, 1) == 1;
        Log.e("mhs_crash_fix", f.z.d.j.l("updateConfig result:", Boolean.valueOf(z)));
        e.c.a.g.a.f.m.d.l(z);
        boolean z2 = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.Z2, 1) == 1;
        Log.e("mhs_crash_fix", f.z.d.j.l("updateConfigkill result:", Boolean.valueOf(z2)));
        e.c.a.g.a.f.m.d.m(z2);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (g0.a) {
            g0.c("Exit001", "MainActivity.finish end");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void handleShowPlayerAfterFee(e.c.a.g.a.d.x.j jVar) {
        f.z.d.j.e(jVar, NotificationCompat.CATEGORY_EVENT);
        K(true);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10001 && i3 == 10000) {
            e.c.a.g.a.j.a.c().d(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.c.a.g.a.d.x.v.c.a().a(this);
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        f.z.d.j.e(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        int i2 = configuration.orientation;
        if (i2 == 2) {
            Log.e("mhs_watch", "屏幕变化 onConfigurationChanged, 横屏");
        } else if (i2 == 1) {
            Log.e("mhs_watch", "屏幕变化 onConfigurationChanged, 竖屏");
        }
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity, com.kugou.android.watch.lite.base.activity.SwipeBackActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        W(bundle);
        if (l1.b0()) {
            getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
        }
        if (l1.X()) {
            if (Z()) {
                getWindow().setSoftInputMode(34);
            }
            boolean z = !R();
            s = z;
            Log.e("mhs_watch", f.z.d.j.l("oncreate setcurrentCanKillProcess = ", Boolean.valueOf(z)));
        }
        ApmReportHelper.INSTANCE.netStartApmLoadTime();
        if (l1.m0()) {
            c.b bVar = e.c.a.g.a.f.e.c.a;
            int configAsInt = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.G2, 27);
            boolean zA = e.c.a.g.a.g.o.b.a();
            boolean z2 = bVar.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.F2, true) && Build.VERSION.SDK_INT >= configAsInt && !zA;
            if (g0.f()) {
                StringBuilder sb = new StringBuilder();
                sb.append("oncreate 语音功能是否生效 = ");
                sb.append(z2);
                sb.append(", sdkVoiceMaxVersion = ");
                sb.append(configAsInt);
                sb.append(", android.os.Build.VERSION.SDK_INT >= sdkVoiceMaxVersion = ");
                int i2 = Build.VERSION.SDK_INT;
                sb.append(i2 >= configAsInt);
                sb.append(", android.os.Build.VERSION.SDK_INT = ");
                sb.append(i2);
                sb.append(", forDisableXtcVoiceMod = ");
                sb.append(zA);
                sb.append(", phonemod = ");
                sb.append((Object) l1.q());
                Log.e("mhs_watch", sb.toString());
            }
            e.c.a.g.a.f.m.d.p(z2);
        }
        d0();
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity, com.kugou.android.watch.lite.base.activity.AbsBaseActivity, com.kugou.android.watch.lite.base.activity.StateFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        e.c.a.g.a.f.d.a.g(this.p);
        e.c.a.f.a aVar = this.k;
        if (aVar != null) {
            aVar.d();
        }
        e.c.a.g.a.d.r.q.a.c().b();
        e.c.a.g.a.d.x.v.c.a().b();
        e.c.a.g.a.g.h.l.c.a.f();
        e.c.a.g.a.d.x.h.y().w();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.p.a aVar) {
        f.z.d.j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        new e.c.a.g.a.f.c.c().g();
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity, com.kugou.android.watch.lite.base.main.FrameworkContentView.b
    public void onFirstFace() {
        super.onFirstFace();
        e.c.a.g.a.d.r.q.a.c().d();
        e.c.a.g.a.d.x.f.I(true);
        Log.d("mhs_watch", "onFirstFace");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        Glide.with((FragmentActivity) this).onLowMemory();
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        a0();
        e.c.a.g.a.q.a aVarU = U();
        if (aVarU == null) {
            return;
        }
        aVarU.e(intent);
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity, com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.j = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        f.z.d.j.e(strArr, "permissions");
        f.z.d.j.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        e.c.a.g.a.d.x.v.c.a().c(i2, strArr, iArr);
    }

    @Override // com.kugou.android.watch.lite.base.activity.FrameworkActivity, com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (e.c.a.g.a.f.a.l() && this.m) {
            y0.e();
        }
        this.m = false;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Glide.with((FragmentActivity) this).onTrimMemory(i2);
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        this.m = true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.g.p.c.b bVar) {
        f.z.d.j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        new e.c.a.g.a.g.p.c.c().b(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.d.m.a aVar) {
        f.z.d.j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        MemoryReportHelper.INSTANCE.memoryReport(1, "当前运行内存不足，可能会导致卡顿");
    }
}
