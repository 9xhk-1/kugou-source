package com.kugou.android.watch.lite.component.player.wdiget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGFile;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import com.kugou.android.watch.lite.common.widget.recyclerview.DisableScrollRecyclerView;
import com.kugou.common.apm.task.MusicRingToneAPM;
import com.kugou.common.apm.task.ShareSongAPM;
import com.kugou.common.event.FavSongStatusItemEvent;
import com.kugou.common.event.RingToneStatusItemEvent;
import com.kugou.common.event.ShareSongStatusItemEvent;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import com.xtc.shareapi.share.communication.BaseResponse;
import e.c.a.g.a.q.a;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.r0;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import f.s;
import f.u.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class PlayerMoreFragment extends DelegateFragment {
    public MusicRingToneAPM C;
    public boolean r;
    public Subscription s;
    public Subscription t;
    public BroadcastReceiver u;
    public long v;
    public int z;
    public final f.d w = f.f.b(new n());
    public final f.d x = f.f.b(new a());
    public final ShareSongAPM y = new ShareSongAPM();
    public final ArrayList<KGMusic> A = new ArrayList<>();
    public final ArrayList<KGMusic> B = new ArrayList<>();
    public final Object D = new Object();

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a extends f.z.d.k implements f.z.c.a<e.c.a.g.a.g.j.h.a> {

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.component.player.wdiget.PlayerMoreFragment$a$a, reason: collision with other inner class name */
        public static final class ViewOnClickListenerC0013a implements View.OnClickListener {
            public final /* synthetic */ PlayerMoreFragment a;

            public ViewOnClickListenerC0013a(PlayerMoreFragment playerMoreFragment) {
                this.a = playerMoreFragment;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof e.c.a.g.a.g.j.h.b) {
                    this.a.M0((e.c.a.g.a.g.j.h.b) tag);
                }
            }
        }

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.g.j.h.a invoke() {
            return new e.c.a.g.a.g.j.h.a(new ViewOnClickListenerC0013a(PlayerMoreFragment.this));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class b<T, R> implements Func1 {
        public static final b<T, R> a = new b<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long call(String str) {
            return Long.valueOf(e.c.a.g.a.s.l.c());
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class c<T> implements Action1 {
        public final /* synthetic */ int a;
        public final /* synthetic */ PlayerMoreFragment b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f174d;

        public c(int i2, PlayerMoreFragment playerMoreFragment, Runnable runnable) {
            this.a = i2;
            this.b = playerMoreFragment;
            this.f174d = runnable;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Long l) {
            if (g0.a) {
                g0.b("hqd", f.z.d.j.l("availableSpace: ", l));
            }
            f.z.d.j.d(l, "availableSpace");
            if (l.longValue() < 0 || l.longValue() > this.a) {
                this.f174d.run();
                return;
            }
            Context context = this.b.getContext();
            if (context == null) {
                context = this.b.requireContext();
            }
            e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(context);
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.g();
            aVar.e("当前设备存储空间不足，暂无法下载歌曲，请清理空间后重试");
            aVar.show();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class d<T, R> implements Func1 {
        public final /* synthetic */ e.c.a.g.a.d.r.p.a.g a;
        public final /* synthetic */ PlayerMoreFragment b;

        public d(e.c.a.g.a.d.r.p.a.g gVar, PlayerMoreFragment playerMoreFragment) {
            this.a = gVar;
            this.b = playerMoreFragment;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(KGMusicWrapper kGMusicWrapper) {
            e.c.a.g.a.g.n.f.b bVarC = new e.c.a.g.a.g.n.f.a().c(this.a);
            if (bVarC == null) {
                return -1;
            }
            this.b.R0(f.z.d.j.l("铃声鉴权结果, result = ", bVarC), "doPrivilegeCheck");
            if (bVarC.h() == 1) {
                int iB = (bVarC.i() == 5 || e.c.a.g.a.g.n.h.c.i(bVarC)) ? 5 : e.c.a.g.a.g.n.h.c.b(bVarC);
                kGMusicWrapper.getInnerKGfile().setOldCpy(bVarC.e());
                if (iB == 5) {
                    return 2;
                }
            }
            return 1;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class e<T, R> implements Func1 {
        public final /* synthetic */ e.c.a.g.a.d.r.p.a.g a;
        public final /* synthetic */ PlayerMoreFragment b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ KGMusicWrapper f175d;

        public e(e.c.a.g.a.d.r.p.a.g gVar, PlayerMoreFragment playerMoreFragment, KGMusicWrapper kGMusicWrapper) {
            this.a = gVar;
            this.b = playerMoreFragment;
            this.f175d = kGMusicWrapper;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(Integer num) {
            List<e.c.a.g.a.d.r.p.a.c> listD;
            if (num == null || num.intValue() != 1) {
                return num;
            }
            e.c.a.g.a.d.r.p.a.h hVar = new e.c.a.g.a.d.r.p.a.h();
            hVar.b = "audio";
            e.c.a.g.a.d.r.p.b.e eVar = new e.c.a.g.a.d.r.p.b.e();
            e.c.a.g.a.d.r.p.a.g gVar = this.a;
            f.z.d.j.d(gVar, "resource");
            e.c.a.g.a.d.r.p.a.a aVarF = eVar.f(hVar, "download", 0, f.u.m.c(gVar), 0);
            e.c.a.g.a.d.r.p.a.c cVar = null;
            if (aVarF != null && (listD = aVarF.d()) != null) {
                cVar = (e.c.a.g.a.d.r.p.a.c) u.v(listD);
            }
            this.b.R0(f.z.d.j.l("铃声鉴权结果, 步骤2 goods = ", cVar), "doPrivilegeCheck");
            if (g0.a) {
                e.c.a.g.a.d.r.i.g("young-hqd", cVar);
            }
            if (e.c.a.g.a.d.r.g.l(cVar)) {
                return 1;
            }
            if (e.c.a.g.a.d.r.g.e(cVar) && !e.c.a.g.a.r.b.O()) {
                return 4;
            }
            if (e.c.a.g.a.d.r.g.j(cVar) && !e.c.a.g.a.d.r.g.l(cVar)) {
                return 5;
            }
            if (e.c.a.g.a.d.r.g.n(cVar)) {
                return 3;
            }
            MusicTransParamEnenty musicTransParamEnenty = this.f175d.getMusicTransParamEnenty();
            if ((r0.h(musicTransParamEnenty) || r0.e(musicTransParamEnenty)) && !e.c.a.g.a.r.b.O()) {
                return 4;
            }
            if (e.c.a.g.a.r.b.F()) {
                e.c.a.g.a.g.h.o.a aVar = e.c.a.g.a.g.h.o.a.a;
                if (aVar.a() == 1 && aVar.e() && !e.c.a.g.a.d.r.g.j(cVar) && !e.c.a.g.a.r.b.O()) {
                    return 6;
                }
            }
            return 1;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class f<T> implements Action1 {
        public final /* synthetic */ KGMusicWrapper b;

        public f(KGMusicWrapper kGMusicWrapper) {
            this.b = kGMusicWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x010a  */
        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void call(java.lang.Integer r11) {
            /*
                Method dump skipped, instruction units count: 309
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.component.player.wdiget.PlayerMoreFragment.f.call(java.lang.Integer):void");
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class g<T> implements Action1 {
        public g() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            PlayerMoreFragment.this.i0();
            p1.h(KGApplication.getContext(), "网络异常，请稍后重试");
            int i2 = 2;
            if (u0.n(KGApplication.getContext(), false)) {
                PlayerMoreFragment.this.G0(3, 11, "0");
                i2 = 3;
            } else {
                PlayerMoreFragment.this.G0(1, 2, "0");
            }
            try {
                PlayerMoreFragment playerMoreFragment = PlayerMoreFragment.this;
                StringBuilder sb = new StringBuilder();
                sb.append("网络异常，请稍后重试, step = ");
                sb.append(i2);
                sb.append(", stack = ");
                sb.append((Object) (th == null ? null : th.getMessage()));
                playerMoreFragment.R0(sb.toString(), "doPrivilegeCheck");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class h implements Runnable {
        public final /* synthetic */ KGMusicWrapper b;

        public h(KGMusicWrapper kGMusicWrapper) {
            this.b = kGMusicWrapper;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PlayerMoreFragment.this.F0(this.b);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class i implements Func1<String, Boolean> {
        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(String str) {
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            if (kGMusicWrapperE == null) {
                return null;
            }
            return Boolean.valueOf(e.c.a.g.a.g.f.g.r(kGMusicWrapperE.getHashValue(), kGMusicWrapperE.getMixId()));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class j<T> implements Action1 {
        public j() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Boolean bool) {
            PlayerMoreFragment.this.V0(bool != null && bool.booleanValue());
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class k<T> implements Action1 {
        public static final k<T> a = new k<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            Action1<Throwable> action1 = i1.b;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PlayerMoreFragment.this.e();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class m<T> implements Action1 {
        public final /* synthetic */ String a;

        public m(String str) {
            this.a = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            try {
                RingBiReportHelper.INSTANCE.reportPlayMore("播放器菜单功能", f.z.d.j.l("更多展示了多少入口:", this.a));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class n extends f.z.d.k implements f.z.c.a<e.c.a.g.a.q.d> {
        public n() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e.c.a.g.a.q.d invoke() {
            return new e.c.a.g.a.q.h().a(PlayerMoreFragment.this.getActivity());
        }
    }

    public static /* synthetic */ boolean A0(PlayerMoreFragment playerMoreFragment, boolean z, boolean z2, boolean z3, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = true;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return playerMoreFragment.z0(z, z2, z3, i2);
    }

    public final void B0(int i2, Runnable runnable) {
        Observable.just("").subscribeOn(Schedulers.io()).map(b.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(i2, this, runnable), i1.b);
    }

    public final ArrayList<e.c.a.g.a.g.j.h.b> C0() {
        ArrayList<e.c.a.g.a.g.j.h.b> arrayList = new ArrayList<>();
        String strL = "";
        if (e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.K1, true)) {
            arrayList.add(new e.c.a.g.a.g.j.h.b(1, "收藏", R.drawable.ic_player_act_fav));
            strL = f.z.d.j.l("", ",收藏");
        }
        arrayList.add(new e.c.a.g.a.g.j.h.b(2, "下载", R.drawable.ic_player_act_download));
        String strL2 = f.z.d.j.l(strL, ",下载");
        if (!e.c.a.g.a.f.a.o()) {
            arrayList.add(new e.c.a.g.a.g.j.h.b(3, "铃声", R.drawable.ic_player_act_ringtone));
            strL2 = f.z.d.j.l(strL2, ",铃声");
        }
        if (K0().isShareEnable()) {
            YoungBITask youngBITask = new YoungBITask(22020010, "exposure");
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            e.c.a.g.a.e.b.b(youngBITask.setMixsongid(kGMusicWrapperE == null ? null : Long.valueOf(kGMusicWrapperE.getMixId()).toString()));
            arrayList.add(new e.c.a.g.a.g.j.h.b(4, "分享", R.drawable.ic_player_act_share));
            strL2 = f.z.d.j.l(strL2, ",分享");
        }
        if (l1.m0()) {
            arrayList.add(new e.c.a.g.a.g.j.h.b(5, "举报", R.drawable.ic_player_act_song_report));
            strL2 = f.z.d.j.l(strL2, ",举报");
        }
        S0(strL2);
        return arrayList;
    }

    public final void D0(KGMusicWrapper kGMusicWrapper) {
        if (m0()) {
            return;
        }
        T0();
        e.c.a.g.a.d.r.p.a.g gVarJ = e.c.a.g.a.d.r.g.J(kGMusicWrapper);
        if (gVarJ == null) {
            p1.h(getContext(), "数据异常，请稍后重试");
            R0("数据异常，请稍后重试", "doPrivilegeCheck");
        } else {
            R0("铃声开始鉴权", "doPrivilegeCheck");
            p0();
            i1.a(this.t);
            this.t = Observable.just(kGMusicWrapper).subscribeOn(Schedulers.io()).map(new d(gVarJ, this)).map(new e(gVarJ, this, kGMusicWrapper)).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(kGMusicWrapper), new g());
        }
    }

    public final void E0() {
        if (A0(this, true, true, true, 0, 8, null)) {
            if (!e.c.a.g.a.r.b.F()) {
                s0.a.l("5");
                return;
            }
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            if (kGMusicWrapperE == null) {
                return;
            }
            if (e.c.a.g.a.g.o.b.l() && e.c.a.g.a.g.o.b.f(kGMusicWrapperE.getKgmusic())) {
                p1.i(KGApplication.getContext(), e.c.a.g.a.g.o.b.d(), f.z.d.j.l("isFilter, music = ", kGMusicWrapperE.getKgmusic()));
            } else if (l1.n0()) {
                B0(50, new h(kGMusicWrapperE));
            } else {
                F0(kGMusicWrapperE);
            }
        }
    }

    public final void F0(KGMusicWrapper kGMusicWrapper) {
        e.c.a.g.a.g.j.g.a.a(45, kGMusicWrapper);
        Initiator initiatorCarryPagePath = Initiator.create(m()).carryPagePath(n());
        f.z.d.j.d(initiatorCarryPagePath, "create(pageKey).carryPagePath(pagePath)");
        e.c.a.g.a.d.i.d.d(f.u.m.g(e.c.a.g.a.f.j.a.c.i(kGMusicWrapper)), initiatorCarryPagePath, l());
    }

    public final void G0(int i2, int i3, String str) {
        MusicRingToneAPM musicRingToneAPM = this.C;
        if (musicRingToneAPM != null) {
            f.z.d.j.c(musicRingToneAPM);
            musicRingToneAPM.fail(i2, i3, str);
        }
    }

    public final void H0(e.c.a.g.a.g.j.h.b bVar) {
        if (A0(this, true, true, true, 0, 8, null)) {
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            if (!e.c.a.g.a.r.b.F()) {
                s0.a.n("3", kGMusicWrapperE == null ? -1L : kGMusicWrapperE.getMixId());
                g().x0(this, 500);
                return;
            }
            Object obj = bVar.f960d;
            if (obj instanceof Boolean) {
                boolean z = !((Boolean) obj).booleanValue();
                if (z) {
                    e.c.a.g.a.g.j.g.a.a(5, kGMusicWrapperE);
                } else {
                    e.c.a.g.a.g.j.g.a.a(6, kGMusicWrapperE);
                }
                I0(z);
            }
        }
    }

    public final void I0(boolean z) {
        if (!z) {
            V0(false);
        }
        KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
        KGMusic kgmusic = kGMusicWrapperE == null ? null : kGMusicWrapperE.getKgmusic();
        if (kgmusic != null) {
            ApmReportHelper apmReportHelper = ApmReportHelper.INSTANCE;
            apmReportHelper.startFavAPM(apmReportHelper.getUUiqueKey(kgmusic, Boolean.valueOf(z)));
            if (z) {
                this.A.add(kgmusic);
            } else {
                this.B.add(kgmusic);
            }
        }
        if (z && kgmusic != null && e.c.a.g.a.f.j.c.b.g() && e.c.a.g.a.f.j.c.b.k(kgmusic.getTrackName())) {
            p1.h(KGApplication.getContext(), "收藏失败！该歌曲在当前设备端暂不支持收藏操作");
            ArrayList arrayList = new ArrayList();
            arrayList.add(kgmusic);
            EventBus.getDefault().post(new FavSongStatusItemEvent(109, arrayList, ApmReportHelper.INSTANCE.getJsonErrorMsg(kgmusic, "合规过滤")));
            return;
        }
        if (z) {
            this.v = System.currentTimeMillis();
        }
        q0(true);
        h0();
        e.c.a.g.a.g.f.g.k().h(z ? 1 : 3, m(), kgmusic, "", l());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        if (this.r && e.c.a.g.a.r.b.F()) {
            s0.a.z();
        }
        this.r = false;
    }

    public final e.c.a.g.a.g.j.h.a J0() {
        return (e.c.a.g.a.g.j.h.a) this.x.getValue();
    }

    public final e.c.a.g.a.q.d K0() {
        return (e.c.a.g.a.q.d) this.w.getValue();
    }

    public final void L0() {
        i0();
        i1.a(this.s);
        this.s = Observable.just("").map(new i()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(), k.a);
    }

    public final void M0(e.c.a.g.a.g.j.h.b bVar) {
        int i2 = bVar.a;
        if (i2 == 1) {
            H0(bVar);
            return;
        }
        if (i2 == 2) {
            E0();
            return;
        }
        if (i2 == 3) {
            N0();
        } else if (i2 == 4) {
            O0();
        } else {
            if (i2 != 5) {
                return;
            }
            P0();
        }
    }

    public final void N0() {
        RingBiReportHelper.INSTANCE.reportHead("点击铃声 ", f.z.d.j.l("openRingtone song = ", e.c.a.g.a.d.x.f.e()), Boolean.TRUE);
        if (l1.V() && f.e0.n.l("TGR-L10", l1.q(), true)) {
            p1.h(getContext(), "该机型不支持");
            R0("该机型不支持 getPhoneModel = " + ((Object) l1.q()) + ", SystemUtils.isHuawei() = " + l1.V(), "openRingtone");
            return;
        }
        if (A0(this, true, true, true, 0, 8, null)) {
            if (g0.f()) {
                g0.b("mhs_ring_vip", f.z.d.j.l("wrapper =   PlayerController.getCurrentSong() = ", e.c.a.g.a.d.x.f.e()));
            }
            if (!e.c.a.g.a.r.b.F() && e.c.a.g.a.g.h.o.a.a.a() != 0) {
                s0.a.l("11");
                return;
            }
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            if (kGMusicWrapperE == null) {
                p1.h(getContext(), "请先选择歌曲");
                R0("请先选择歌曲 ", "openRingtone");
                return;
            }
            if (kGMusicWrapperE.getDuration() <= 0) {
                Log.d("young-hqd", "openRingtone: fix duration");
                KGFile innerKGfile = kGMusicWrapperE.getInnerKGfile();
                if (innerKGfile != null) {
                    innerKGfile.setDuration(e.c.a.g.a.d.x.f.g());
                }
            }
            if (TextUtils.isEmpty(kGMusicWrapperE.getHashValue()) || kGMusicWrapperE.getMixId() <= 0) {
                p1.h(getContext(), "歌曲数据异常");
                R0(f.z.d.j.l("歌曲数据异常 wrapper = ", kGMusicWrapperE), "openRingtone");
            } else if (e.c.a.g.a.g.o.b.l() && e.c.a.g.a.g.o.b.f(kGMusicWrapperE.getKgmusic())) {
                p1.i(getContext(), e.c.a.g.a.g.o.b.d(), f.z.d.j.l("isFilter, music = ", kGMusicWrapperE.getKgmusic()));
                R0(f.z.d.j.l("歌词过滤 wrapper = ", kGMusicWrapperE), "openRingtone");
            } else {
                D0(kGMusicWrapperE);
                e.c.a.g.a.e.b.b(new YoungBITask(12820841, "click").setMixsongid(String.valueOf(kGMusicWrapperE.getMixId())));
            }
        }
    }

    public final void O0() {
        this.y.start();
        this.z = 0;
        if (!z0(true, true, true, 1)) {
            ShareSongAPM.fail$default(this.y, Integer.valueOf(this.z), "checkCommon", null, 4, null);
            return;
        }
        KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
        if (kGMusicWrapperE == null) {
            p1.h(KGApplication.getContext(), "当前歌曲为空");
            ShareSongAPM.fail$default(this.y, 4, "当前歌曲为空", null, 4, null);
        } else if (e.c.a.g.a.g.o.b.l() && e.c.a.g.a.g.o.b.f(kGMusicWrapperE.getKgmusic())) {
            p1.i(getContext(), e.c.a.g.a.g.o.b.d(), f.z.d.j.l("isFilter, music = ", kGMusicWrapperE.getKgmusic()));
            ShareSongAPM.fail$default(this.y, 5, "歌曲过滤", null, 4, null);
        } else {
            K0().share(kGMusicWrapperE, this.y);
            e.c.a.g.a.e.b.b(new YoungBITask(22020011, "click").setMixsongid(String.valueOf(kGMusicWrapperE.getMixId())));
        }
    }

    public final void P0() {
        if (A0(this, true, false, true, 0, 8, null)) {
            if (e.c.a.g.a.r.b.F()) {
                s0.a.z();
            } else {
                this.r = true;
                s0.a.l("0");
            }
        }
    }

    public final void Q0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.young.watch.metachanged");
        intentFilter.addAction("com.kugou.android.cloud_music_delete_success");
        intentFilter.addAction("com.kugou.android.update_fav_btn_state");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.component.player.wdiget.PlayerMoreFragment$registerFavReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action;
                if (intent == null || (action = intent.getAction()) == null) {
                    return;
                }
                int iHashCode = action.hashCode();
                if (iHashCode != -502153045) {
                    if (iHashCode == 764269154) {
                        if (action.equals("com.kugou.young.watch.metachanged")) {
                            this.a.L0();
                            return;
                        }
                        return;
                    } else if (iHashCode != 875757098 || !action.equals("com.kugou.android.cloud_music_delete_success")) {
                        return;
                    }
                } else if (!action.equals("com.kugou.android.update_fav_btn_state")) {
                    return;
                }
                if (g0.f()) {
                    g0.c("mhs_watch", "收藏 按钮更新");
                }
                this.a.U0(false);
            }
        };
        this.u = broadcastReceiver;
        e.c.a.g.a.f.d.a.b(broadcastReceiver, intentFilter);
    }

    public final void R0(String str, String str2) {
        RingBiReportHelper.reportHead$default(RingBiReportHelper.INSTANCE, str, str2, null, 4, null);
    }

    public final void S0(String str) {
        m1.f(new m(str));
    }

    public final void T0() {
        synchronized (this.D) {
            MusicRingToneAPM musicRingToneAPM = this.C;
            if (musicRingToneAPM != null) {
                f.z.d.j.c(musicRingToneAPM);
                musicRingToneAPM.release();
            }
            MusicRingToneAPM musicRingToneAPM2 = new MusicRingToneAPM();
            this.C = musicRingToneAPM2;
            f.z.d.j.c(musicRingToneAPM2);
            musicRingToneAPM2.start();
            s sVar = s.a;
        }
    }

    public final void U0(boolean z) {
        if (z) {
            I0(true);
        } else {
            L0();
        }
    }

    public final void V0(boolean z) {
        if (z && this.v > 0) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020018, "statistics").setDuration(String.valueOf(System.currentTimeMillis() - this.v)));
        }
        e.c.a.g.a.g.j.h.b bVarJ = J0().j(1);
        if (bVarJ == null) {
            return;
        }
        if (z && e.c.a.g.a.r.b.F()) {
            bVarJ.f960d = Boolean.TRUE;
            bVarJ.b.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(KGApplication.getContext(), R.color.c_f72626), PorterDuff.Mode.SRC_ATOP));
            bVarJ.c = "已收藏";
        } else {
            bVarJ.f960d = Boolean.valueOf(z);
            bVarJ.b.clearColorFilter();
            bVarJ.c = "收藏";
        }
        J0().h(bVarJ);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_player_more, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        K0().onDestroy();
        i1.a(this.s, this.t);
        this.s = null;
        this.t = null;
        e.c.a.g.a.f.d.a.g(this.u);
        this.u = null;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(RingToneStatusItemEvent ringToneStatusItemEvent) {
        f.z.d.j.e(ringToneStatusItemEvent, NotificationCompat.CATEGORY_EVENT);
        if (ringToneStatusItemEvent.isSuccess) {
            y0();
            return;
        }
        int i2 = MusicRingToneAPM.KEY_DATA_RETYR_RINGTONG.equals(ringToneStatusItemEvent.result) ? 1 : 2;
        String str = ringToneStatusItemEvent.result;
        f.z.d.j.d(str, "event.result");
        G0(4, i2, str);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.j.e(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = view.findViewById(R.id.root_view);
        e.c.a.g.a.f.o.e.a(viewFindViewById);
        e.c.a.g.a.f.o.i.c.a().c(2, viewFindViewById);
        DisableScrollRecyclerView disableScrollRecyclerView = (DisableScrollRecyclerView) view.findViewById(R.id.recycler_view);
        int iMax = Math.max(l1.c(20.0f), (int) (l1.x() * 0.1f));
        e.c.a.g.a.s.i iVar = new e.c.a.g.a.s.i();
        iVar.a(iMax);
        disableScrollRecyclerView.addItemDecoration(iVar);
        disableScrollRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        disableScrollRecyclerView.setHasFixedSize(true);
        disableScrollRecyclerView.setAdapter(J0());
        J0().i(C0());
        u1.b(new l(), view.findViewById(R.id.iv_close));
        L0();
        Q0();
        YoungBITask youngBITask = new YoungBITask(22020009, "exposure");
        KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
        e.c.a.g.a.e.b.b(youngBITask.setMixsongid(kGMusicWrapperE == null ? null : Long.valueOf(kGMusicWrapperE.getMixId()).toString()));
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "播放页更多";
    }

    public final void y0() {
        synchronized (this.D) {
            MusicRingToneAPM musicRingToneAPM = this.C;
            if (musicRingToneAPM != null) {
                f.z.d.j.c(musicRingToneAPM);
                musicRingToneAPM.netFinish();
                MusicRingToneAPM musicRingToneAPM2 = this.C;
                f.z.d.j.c(musicRingToneAPM2);
                musicRingToneAPM2.success();
                this.C = null;
            }
            s sVar = s.a;
        }
    }

    public final boolean z0(boolean z, boolean z2, boolean z3, int i2) {
        if (z3 && u1.h(700)) {
            if (i2 == 1) {
                this.z = 1;
            }
            return false;
        }
        if (z && e.c.a.g.a.d.x.f.r()) {
            if (i2 == 1) {
                this.z = 2;
            }
            p1.h(KGApplication.getContext(), "播放队列暂无歌曲，请添加后操作");
            return false;
        }
        if (!z2 || u0.m(KGApplication.getContext())) {
            return true;
        }
        if (i2 == 1) {
            this.z = 3;
        }
        return false;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(ShareSongStatusItemEvent shareSongStatusItemEvent) {
        f.z.d.j.e(shareSongStatusItemEvent, NotificationCompat.CATEGORY_EVENT);
        int i2 = shareSongStatusItemEvent.state;
        if (i2 == 1) {
            this.y.success("小天才歌曲分享成功");
            return;
        }
        if (i2 == 2) {
            ShareSongAPM.fail$default(this.y, 10, "分享取消", null, 4, null);
            return;
        }
        ShareSongAPM shareSongAPM = this.y;
        a.C0174a c0174a = e.c.a.g.a.q.a.f1156d;
        BaseResponse baseResponse = shareSongStatusItemEvent.extJson;
        f.z.d.j.d(baseResponse, "event.extJson");
        String strA = c0174a.a(baseResponse);
        BaseResponse baseResponse2 = shareSongStatusItemEvent.extJson;
        shareSongAPM.fail(11, strA, baseResponse2 == null ? null : Integer.valueOf(baseResponse2.getCode()));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(FavSongStatusItemEvent favSongStatusItemEvent) {
        f.z.d.j.e(favSongStatusItemEvent, NotificationCompat.CATEGORY_EVENT);
        Log.e("mhs_watch", f.z.d.j.l("event = ", favSongStatusItemEvent));
        try {
            ArrayList arrayList = new ArrayList();
            int i2 = favSongStatusItemEvent.state;
            if (i2 >= 100 && i2 < 200) {
                Iterator<? extends KGMusic> it = favSongStatusItemEvent.mMusics.iterator();
                while (it.hasNext()) {
                    KGMusic next = it.next();
                    Iterator<KGMusic> it2 = this.A.iterator();
                    while (it2.hasNext()) {
                        KGMusic next2 = it2.next();
                        if (f.z.d.j.a(next2 == null ? null : Long.valueOf(next2.mixId), next == null ? null : Long.valueOf(next.mixId))) {
                            arrayList.add(next2);
                            if (next2 != null) {
                                ApmReportHelper apmReportHelper = ApmReportHelper.INSTANCE;
                                Boolean bool = Boolean.TRUE;
                                String uUiqueKey = apmReportHelper.getUUiqueKey(next2, bool);
                                int i3 = favSongStatusItemEvent.state;
                                if (i3 == 105) {
                                    apmReportHelper.successFavAPM(uUiqueKey, bool);
                                } else {
                                    apmReportHelper.failFavAPM(uUiqueKey, Integer.valueOf(i3), favSongStatusItemEvent.extJson);
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.A.removeAll(arrayList);
                }
            }
            int i4 = favSongStatusItemEvent.state;
            if (i4 < 200 || i4 >= 300) {
                return;
            }
            Iterator<? extends KGMusic> it3 = favSongStatusItemEvent.mMusics.iterator();
            while (it3.hasNext()) {
                KGMusic next3 = it3.next();
                Iterator<KGMusic> it4 = this.B.iterator();
                while (it4.hasNext()) {
                    KGMusic next4 = it4.next();
                    if (f.z.d.j.a(next4 == null ? null : Long.valueOf(next4.mixId), next3 == null ? null : Long.valueOf(next3.mixId))) {
                        arrayList.add(next4);
                        if (next4 != null) {
                            ApmReportHelper apmReportHelper2 = ApmReportHelper.INSTANCE;
                            Boolean bool2 = Boolean.FALSE;
                            String uUiqueKey2 = apmReportHelper2.getUUiqueKey(next4, bool2);
                            int i5 = favSongStatusItemEvent.state;
                            if (i5 == 201) {
                                apmReportHelper2.successFavAPM(uUiqueKey2, bool2);
                            } else {
                                apmReportHelper2.failFavAPM(uUiqueKey2, Integer.valueOf(i5), favSongStatusItemEvent.extJson);
                            }
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.B.removeAll(arrayList);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
