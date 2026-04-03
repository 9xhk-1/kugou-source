package e.c.a.g.a.d.x.v;

import android.R;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.ActivityCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.component.MainActivity;
import com.kugou.common.permission.Permission;
import com.kugou.common.startAppAPM.task.MemoryReportHelper;
import com.kugou.common.utils.PermissionsUtil;
import e.c.a.g.a.d.x.v.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c.a {
    public static final a c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f627d;
    public final boolean a;
    public Subscription b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.x.v.b$b, reason: collision with other inner class name */
    public static final class C0097b<T, R> implements Func1 {
        public C0097b() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(String str) {
            if (g0.a) {
                g0.b("AppAction", f.z.d.j.l("checkFunHealth: availableBlocks=", Long.valueOf(e.c.a.g.a.s.d.d(KGApplication.getContext()))));
                g0.b("AppAction", f.z.d.j.l("checkFunHealth: availableMemory=", Long.valueOf(l1.i(e.c.c.o.f.a()))));
            }
            if (b.this.j() && e.c.a.g.a.s.q.q()[1] >= 314572800) {
                return 1;
            }
            if (e.c.a.g.a.f.a.i() || e.c.a.g.a.s.d.d(KGApplication.getContext()) >= 209715200) {
                return (e.c.a.g.a.f.a.h() || l1.i(e.c.c.o.f.a()) > 100) ? null : 3;
            }
            return 2;
        }
    }

    public static final class c<T> implements Action1 {
        public final /* synthetic */ MainActivity a;
        public final /* synthetic */ b b;

        public static final class a implements Runnable {
            public static final a a = new a();

            @Override // java.lang.Runnable
            public final void run() {
                s0.a.y();
                e.c.a.g.a.f.m.c.a.j("once_use_cache_clear_guide", true);
            }
        }

        public c(MainActivity mainActivity, b bVar) {
            this.a = mainActivity;
            this.b = bVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Integer num) {
            if (num != null && num.intValue() == 1) {
                n nVar = new n(this.a, 314572800L);
                nVar.a(a.a);
                nVar.show();
                e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
                cVar.h("last_time_cache_clear_guide", l1.b());
                cVar.g("count_week_cache_clear_guide", cVar.b("count_week_cache_clear_guide", 0) + 1);
                e.c.a.g.a.e.b.b(new YoungBITask(20586, "exposure"));
            } else if (num != null && num.intValue() == 2) {
                if (this.b.l()) {
                    p1.h(KGApplication.getContext(), "存储内存不足，应用功能受限");
                }
                MemoryReportHelper.INSTANCE.memoryReport(2, "存储内存不足，应用功能受限");
            } else if (num != null && num.intValue() == 3) {
                if (this.b.k()) {
                    p1.h(KGApplication.getContext(), "运行内存不足，可能会导致卡顿或闪退");
                }
                MemoryReportHelper.INSTANCE.memoryReport(3, "运行内存不足，可能会导致卡顿或闪退");
            }
            this.b.b = null;
        }
    }

    public static final class d implements Action0 {
        public d() {
        }

        @Override // rx.functions.Action0
        public final void call() {
            b.this.b = null;
        }
    }

    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.n();
        }
    }

    public static final class f implements PermissionsUtil.OnPermissionDilaogListener {
        public final /* synthetic */ MainActivity a;

        public f(MainActivity mainActivity) {
            this.a = mainActivity;
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onNo() {
            Log.d("mhs_watch", "initData onNo");
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onYes() {
            Log.d("mhs_watch", "initData onYes");
            ActivityCompat.requestPermissions(this.a, new String[]{Permission.READ_PHONE_STATE}, 1001);
        }
    }

    public b() {
        this.a = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.J0, 1) == 1;
    }

    @Override // e.c.a.g.a.d.x.v.c.a
    public void a(MainActivity mainActivity) {
        f.z.d.j.e(mainActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        super.a(mainActivity);
        m(mainActivity);
        mainActivity.findViewById(R.id.content).postDelayed(new e(), 200L);
    }

    @Override // e.c.a.g.a.d.x.v.c.a
    public void b() {
        super.b();
        boolean z = true;
        i1.a(this.b);
        if (!l1.X()) {
            if (e.c.a.g.a.f.a.k()) {
                if (g0.a) {
                    g0.b("AppAction", f.z.d.j.l("onExitMainPage: 关闭应用，是否正播放歌曲：", Boolean.valueOf(e.c.a.g.a.d.x.f.q())));
                }
                KGApplication.exit();
                return;
            }
            return;
        }
        try {
            if (e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.l4, 0) != 1) {
                z = false;
            }
            g0.c("AppAction", f.z.d.j.l("onExitMainPage: 关闭应用，isEnable = ", Boolean.valueOf(z)));
            if (z) {
                KGApplication.exit();
            } else {
                e.c.a.g.a.d.x.f.t();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // e.c.a.g.a.d.x.v.c.a
    public void c(int i2, String[] strArr, int[] iArr) {
        f.z.d.j.e(strArr, "permissions");
        f.z.d.j.e(iArr, "grantResults");
        super.c(i2, strArr, iArr);
        if (i2 == 1001) {
            if ((!(iArr.length == 0)) && f.u.i.g(iArr) == -1) {
                e.c.a.g.a.f.m.c.a.h("last_request_phone_time", System.currentTimeMillis());
            }
        }
    }

    @Override // e.c.a.g.a.d.x.v.c.a
    public void d(MainActivity mainActivity) {
        f.z.d.j.e(mainActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (Build.VERSION.SDK_INT < 23 || l1.f0()) {
            return;
        }
        if (l1.H()) {
            if (g0.f()) {
                g0.b("AppAction", "requestPhonePermission: 已有权限");
                return;
            }
            return;
        }
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        long jD = e.c.a.g.a.s.k.d(cVar.c("last_request_phone_time", -1L));
        long jD2 = e.c.a.g.a.s.k.d(System.currentTimeMillis());
        boolean z = false;
        if (1 <= jD && jD <= jD2) {
            z = true;
        }
        if (z) {
            if (g0.f()) {
                g0.b("AppAction", "requestPhonePermission: 今天已申请过,不再申请权限");
                return;
            }
            return;
        }
        if (g0.f()) {
            g0.b("AppAction", "requestPhonePermission: permission.READ_PHONE_STATE");
        }
        Log.d("mhs_watch", "initData isShowDialog = " + this.a + ", isXTC = " + l1.m0());
        if (!this.a) {
            ActivityCompat.requestPermissions(mainActivity, new String[]{Permission.READ_PHONE_STATE}, 1001);
        } else {
            cVar.h("last_request_phone_time", System.currentTimeMillis());
            PermissionsUtil.getInstance().showPermissionRequestDialog(mainActivity, "申请电话权限，获得您的设备信息、手机通话状态，该信息用于标识您为酷狗概念版的用户、 监听设备来电时，暂停铃声、音乐的播放，向您提供个性化内容展示、提供安全保障等主要功能。", new f(mainActivity), Permission.READ_PHONE_STATE);
        }
    }

    public final boolean j() {
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        long jC = cVar.c("last_time_cache_clear_guide", 0L);
        long jD = e.c.a.g.a.s.k.d(l1.b());
        long jD2 = e.c.a.g.a.s.k.d(jC);
        if (jD - jD2 >= TimeUnit.DAYS.toMillis(7L)) {
            if (g0.a) {
                g0.b("AppAction", "canShowClearGuide: 重置次数");
            }
            cVar.g("count_week_cache_clear_guide", 0);
            cVar.j("once_use_cache_clear_guide", false);
        }
        if (cVar.e("once_use_cache_clear_guide", false)) {
            if (g0.a) {
                g0.b("AppAction", "canShowClearGuide: 已使用过");
            }
            return false;
        }
        int iB = cVar.b("count_week_cache_clear_guide", 0);
        if (g0.a) {
            g0.b("AppAction", f.z.d.j.l("canShowClearGuide: 已展示次数", Integer.valueOf(iB)));
        }
        if (iB >= 2 || jD <= jD2) {
            return false;
        }
        if (!g0.a) {
            return true;
        }
        g0.b("AppAction", "canShowClearGuide: 上次弹窗不是今天");
        return true;
    }

    public final boolean k() {
        return e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.b4, 0) == 1;
    }

    public final boolean l() {
        return e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.a4, 1) == 1;
    }

    public final void m(MainActivity mainActivity) {
        if (f627d) {
            return;
        }
        f627d = true;
        this.b = Observable.just("").subscribeOn(Schedulers.io()).delay(2L, TimeUnit.SECONDS).map(new C0097b()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(mainActivity, this), i1.b, new d());
    }

    public final void n() {
        if (l1.V() && !u0.a && u0.o(KGApplication.getContext())) {
            u0.a = true;
            if (e.c.a.g.a.f.m.c.a.e("once_request_mobile_net", false)) {
                p1.h(KGApplication.getContext(), KGApplication.getContext().getString(com.kugou.android.watch.lite.R.string.show_2g_3g_tips));
            }
        }
    }
}
