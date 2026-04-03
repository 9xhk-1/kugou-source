package com.kugou.android.watch.lite.base.main;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.base.main.MainContainerLayout;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewBase;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.util.ViewPager;
import com.kugou.datacollect.bi.use.TraceFullTask;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.LyricManager;
import e.c.a.g.a.d.x.h;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
@e.c.a.g.a.d.b0.a(viewType = 2)
@e.c.c.l.f.b(id = 356753938)
public class MainFragmentContainer extends AbsFrameworkFragment implements MainContainerLayout.a, e.c.a.g.a.d.t.a {
    public Runnable A;
    public final ViewPager.g B;
    public float C;
    public ValueAnimator D;
    public ValueAnimator E;
    public AbsFrameworkFragment o;
    public AbsFrameworkFragment p;
    public AbsFrameworkFragment q;
    public MainContainerLayout t;
    public MainFragmentViewPage u;
    public g v;
    public e.c.a.g.a.g.b w;
    public boolean y;
    public int z;
    public final AbsFrameworkFragment[] r = new AbsFrameworkFragment[3];
    public int s = 0;
    public Handler x = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.c.a.g.a.f.m.c.a.e("once_request_mobile_net", false)) {
                return;
            }
            MainFragmentContainer.this.getActivity().finish();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MainFragmentContainer.this.u0();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class c implements ViewPager.g {

        public class a implements Runnable {
            public final /* synthetic */ int a;

            public a(int i2) {
                this.a = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                MainFragmentContainer.this.s = this.a;
                MainFragmentContainer.this.C0(this.a);
            }
        }

        public c() {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageScrollStateChanged(int i2) {
            if (g0.a) {
                g0.b("gehu_frame", "OnPageChangeListener onPageScrollStateChanged:" + i2);
            }
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageScrolled(int i2, float f2, int i3) {
            MainFragmentContainer.this.x0(true, (i2 + f2) - 1.0f);
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelected(int i2, boolean z) {
            if (MainFragmentContainer.this.v.f467f.get(i2) instanceof Fragment) {
                return;
            }
            MainFragmentViewPage mainFragmentViewPage = MainFragmentContainer.this.u;
            a aVar = new a(i2);
            MainFragmentViewPage unused = MainFragmentContainer.this.u;
            mainFragmentViewPage.postDelayed(aVar, 400L);
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelectedAfterAnimation(int i2) {
            MainFragmentContainer.this.s0(i2, false);
            MainFragmentContainer.this.H0(i2);
            MainFragmentContainer.this.s = i2;
            MainFragmentContainer.this.C0(i2);
            MainFragmentContainer.this.F0(i2);
            MainFragmentContainer.this.w.b(i2);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String a;

        public d(MainFragmentContainer mainFragmentContainer, String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String strE = e.c.a.g.a.f.n.a.b().e(42, "");
            KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
            String strValueOf = kGMusicWrapperE == null ? "" : String.valueOf(kGMusicWrapperE.getMixId());
            LyricData lyricData = LyricManager.getInstance().getLyricData();
            TraceFullTask svar1 = new YoungBITask(3003, "click").setMixsongid(strValueOf).setType(this.a).setSvar1(strE);
            if (lyricData == null) {
                str = "empty";
            } else {
                str = lyricData.getLyricType() + "";
            }
            e.c.a.g.a.e.b.b(svar1.setSvar2(str));
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MainFragmentContainer.this.x0(false, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            MainFragmentContainer.this.x0(false, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class g extends e.c.a.g.a.d.p.b {
        public g(FragmentManager fragmentManager, Context context, int i2) {
            super(fragmentManager, context, i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 3;
        }

        @Override // e.c.a.g.a.d.p.b
        public Fragment getItem(int i2) {
            return MainFragmentContainer.this.A0(i2);
        }
    }

    public MainFragmentContainer() {
        this.y = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.P, 1) == 1;
        this.z = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.E1, 700);
        this.A = new b();
        this.B = new c();
        this.C = Float.MIN_VALUE;
    }

    public final AbsFrameworkFragment A0(int i2) {
        if (g() == null || g().Z() == null) {
            return null;
        }
        if (i2 == 0) {
            if (this.o == null) {
                AbsFrameworkFragment absFrameworkFragmentOnCreateMainFragment = g().Z().onCreateMainFragment();
                this.o = absFrameworkFragmentOnCreateMainFragment;
                this.r[0] = absFrameworkFragmentOnCreateMainFragment;
                if (absFrameworkFragmentOnCreateMainFragment != null) {
                    absFrameworkFragmentOnCreateMainFragment.setArguments(new Bundle());
                    if (B()) {
                        this.o.Y();
                    }
                    if (A()) {
                        this.o.W();
                    }
                }
            }
            return this.o;
        }
        if (i2 == 1) {
            if (this.p == null) {
                AbsFrameworkFragment absFrameworkFragmentOnCreatePlayerFragment = g().Z().onCreatePlayerFragment();
                this.p = absFrameworkFragmentOnCreatePlayerFragment;
                this.r[1] = absFrameworkFragmentOnCreatePlayerFragment;
                if (absFrameworkFragmentOnCreatePlayerFragment != null) {
                    absFrameworkFragmentOnCreatePlayerFragment.setArguments(new Bundle());
                    if (B()) {
                        this.p.Y();
                    }
                    if (A()) {
                        this.p.W();
                    }
                }
            }
            return this.p;
        }
        if (i2 != 2) {
            return null;
        }
        if (this.q == null) {
            AbsFrameworkFragment absFrameworkFragmentOnCreateLyricFragment = g().Z().onCreateLyricFragment();
            this.q = absFrameworkFragmentOnCreateLyricFragment;
            this.r[2] = absFrameworkFragmentOnCreateLyricFragment;
            if (absFrameworkFragmentOnCreateLyricFragment != null) {
                absFrameworkFragmentOnCreateLyricFragment.setArguments(new Bundle());
                if (B()) {
                    this.q.Y();
                }
                if (A()) {
                    this.q.W();
                }
            }
        }
        return this.q;
    }

    public void B0() {
        if (this.s == 0 && g().k0()) {
            g().R().s(true);
        } else {
            g().R().s(false);
        }
    }

    public final synchronized void C0(int i2) {
        if (g0.a) {
            g0.b("gehu_frame", "initTabFragment: " + i2);
        }
        g gVar = this.v;
        if (gVar != null) {
            gVar.f(i2);
        }
    }

    public final void D0() {
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void E() {
        super.E();
        for (AbsFrameworkFragment absFrameworkFragment : this.r) {
            if (absFrameworkFragment != null && absFrameworkFragment.isAdded()) {
                absFrameworkFragment.E();
            }
        }
    }

    public View E0() {
        if (g0.a) {
            g0.b("MainFragmentContainer", "onCreateView");
        }
        MainContainerLayout mainContainerLayout = new MainContainerLayout(getActivity());
        this.t = mainContainerLayout;
        mainContainerLayout.setViewState(this);
        return this.t;
    }

    public final void F0(int i2) {
        B0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        int i2 = 0;
        while (true) {
            AbsFrameworkFragment[] absFrameworkFragmentArr = this.r;
            if (i2 >= absFrameworkFragmentArr.length) {
                Log.d("mhs_wacth_update", "MainFragmentContainer onFragmentPause");
                e.c.a.g.a.g.o.b.p();
                return;
            }
            AbsFrameworkFragment absFrameworkFragment = absFrameworkFragmentArr[i2];
            if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && i2 == this.s) {
                absFrameworkFragment.G();
            }
            i2++;
        }
    }

    public void G0() {
        g gVar = new g(getChildFragmentManager(), getActivity(), this.s);
        this.v = gVar;
        this.o = (AbsFrameworkFragment) gVar.b(0);
        this.p = (AbsFrameworkFragment) this.v.b(1);
        AbsFrameworkFragment absFrameworkFragment = (AbsFrameworkFragment) this.v.b(2);
        this.q = absFrameworkFragment;
        AbsFrameworkFragment[] absFrameworkFragmentArr = this.r;
        absFrameworkFragmentArr[0] = this.o;
        absFrameworkFragmentArr[1] = this.p;
        absFrameworkFragmentArr[2] = absFrameworkFragment;
        this.v.i(this.s);
        MainFragmentViewPage pagerContainer = this.t.getPagerContainer();
        this.u = pagerContainer;
        pagerContainer.setAdapter(this.v);
        this.u.setOffscreenPageLimit(2);
        this.u.setOnPageChangeListener(this.B);
        this.u.Q(false, new e.c.a.g.a.d.p.c());
        this.w = this.t.getMainIndicator();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_indicator_home, null));
        arrayList.add(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_indicator_player, null));
        arrayList.add(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_indicator_lyric, null));
        this.w.a(3, arrayList);
        this.w.b(0);
        s0(this.s, true);
    }

    public final void H0(int i2) {
        if (i2 == 2) {
            I0("1");
        } else if (i2 == 1 && this.s == 2) {
            I0("2");
        }
    }

    public final void I0(String str) {
        j0.b().a(new d(this, str));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        int i2 = 0;
        while (true) {
            AbsFrameworkFragment[] absFrameworkFragmentArr = this.r;
            if (i2 >= absFrameworkFragmentArr.length) {
                Log.e("mhs_watch_error", "checkPlayerVoice onFragmentResume");
                t0();
                return;
            }
            AbsFrameworkFragment absFrameworkFragment = absFrameworkFragmentArr[i2];
            if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && i2 == this.s && g().k0()) {
                absFrameworkFragment.J();
            }
            i2++;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void O() {
        super.O();
        for (AbsFrameworkFragment absFrameworkFragment : this.r) {
            if (absFrameworkFragment != null && absFrameworkFragment.isAdded()) {
                absFrameworkFragment.O();
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void b(View view) {
        this.u.c(view);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public boolean d() {
        return false;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public int o() {
        return 1;
    }

    @Override // com.kugou.android.watch.lite.base.main.MainContainerLayout.a
    public void onAttachedToWindow() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return E0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(e.c.a.g.a.t.d dVar) {
        if (l1.m0() && dVar != null) {
            if (dVar.b == e.c.a.g.a.t.d.c) {
                try {
                    Log.e("mhs_watch_error", "checkPlayerVoice event");
                    t0();
                } catch (Exception e2) {
                    Log.d("mhs_watch", "onEventMainThread checkResumeData error:" + e2.getMessage());
                }
            }
            Log.d("mhs_watch", "service updatePlaybackState， event.eventType:" + dVar.b);
        }
    }

    @Override // com.kugou.android.watch.lite.base.main.MainContainerLayout.a
    public void onFirstLayout() {
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AbsFrameworkFragment absFrameworkFragmentZ0 = z0();
        if (absFrameworkFragmentZ0 != null && absFrameworkFragmentZ0.isAdded() && absFrameworkFragmentZ0.onKeyDown(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        AbsFrameworkFragment absFrameworkFragmentZ0 = z0();
        if (absFrameworkFragmentZ0 != null && absFrameworkFragmentZ0.isAdded() && absFrameworkFragmentZ0.onKeyLongPress(i2, keyEvent)) {
            return true;
        }
        return super.onKeyLongPress(i2, keyEvent);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        AbsFrameworkFragment absFrameworkFragmentZ0 = z0();
        if (absFrameworkFragmentZ0 != null && absFrameworkFragmentZ0.isAdded() && absFrameworkFragmentZ0.onKeyMultiple(i2, i3, keyEvent)) {
            return true;
        }
        return super.onKeyMultiple(i2, i3, keyEvent);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AbsFrameworkFragment absFrameworkFragmentZ0 = z0();
        if (absFrameworkFragmentZ0 != null && absFrameworkFragmentZ0.isAdded() && absFrameworkFragmentZ0.onKeyUp(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        int i2 = 0;
        while (true) {
            AbsFrameworkFragment[] absFrameworkFragmentArr = this.r;
            if (i2 >= absFrameworkFragmentArr.length) {
                return;
            }
            AbsFrameworkFragment absFrameworkFragment = absFrameworkFragmentArr[i2];
            if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && i2 == this.s) {
                absFrameworkFragment.G();
            }
            i2++;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        D0();
        int i2 = 0;
        while (true) {
            AbsFrameworkFragment[] absFrameworkFragmentArr = this.r;
            if (i2 >= absFrameworkFragmentArr.length) {
                break;
            }
            AbsFrameworkFragment absFrameworkFragment = absFrameworkFragmentArr[i2];
            if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && i2 == this.s && g().k0()) {
                absFrameworkFragment.J();
            }
            i2++;
        }
        if (this.y && l1.V() && !e.c.a.g.a.f.m.c.a.e("once_request_mobile_net", false)) {
            u0.c(getActivity(), "当前未连接WiFi，是否同意我们使用您的流量用于播放、搜索、下载歌曲等操作", new a());
        }
        h.y().r();
        Log.e("mhs_watch_error", "checkPlayerVoice onResume");
        t0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        G0();
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public String p() {
        AbsFrameworkFragment absFrameworkFragment = this.r[this.s];
        return absFrameworkFragment instanceof DelegateFragment ? absFrameworkFragment.p() : "首页";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public int r() {
        return this.s;
    }

    public final void s0(int i2, boolean z) {
        if (this.s != i2 || z) {
            this.s = i2;
        }
    }

    @Override // e.c.a.g.a.d.t.a
    public void scrollerToDispersal() {
        if (this.D == null) {
            v0();
        }
        if (this.D.isRunning()) {
            return;
        }
        this.D.start();
    }

    @Override // e.c.a.g.a.d.t.a
    public void scrollerToTogether() {
        if (this.E == null) {
            w0();
        }
        if (this.E.isRunning()) {
            return;
        }
        this.E.start();
    }

    public final void t0() {
        if (e.c.a.g.a.t.e.a.x()) {
            Log.e("mhs_watch_error", "checkPlayerVoice forceStopAppTime = " + this.z);
            this.x.removeCallbacks(this.A);
            this.x.postDelayed(this.A, (long) this.z);
        }
    }

    public final void u0() {
        if (l1.m0()) {
            Log.d("mhs_watch", "checkResumeData, mCurrentTabIndex = " + this.s + ", VoiceCmdEvent.sHasFinishLoginCheck = " + e.c.a.g.a.t.c.b + ", VoiceCmdEvent.sPlaySearchInfoCache = " + e.c.a.g.a.t.c.c + ", VoiceCmdEvent.sNeedJumpListenSong = " + e.c.a.g.a.t.c.f1229d);
            if (e.c.a.g.a.t.c.b && e.c.a.g.a.t.c.c != null && l1.m0() && !e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true)) {
                e.c.a.g.a.t.e eVar = e.c.a.g.a.t.e.a;
                e.c.a.g.a.t.a aVar = e.c.a.g.a.t.c.c;
                eVar.F(aVar.a, aVar.b);
                e.c.a.g.a.t.c.c = null;
            }
            if (e.c.a.g.a.t.c.b && e.c.a.g.a.t.c.f1229d && l1.m0() && !e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true)) {
                e.c.a.g.a.t.c.f1229d = false;
                Bundle bundle = new Bundle();
                bundle.putBoolean("startIdentify", true);
                s0.a.c(bundle);
            }
            if (e.c.a.g.a.t.c.b && e.c.a.g.a.t.c.f1231f != null && l1.m0() && !e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true)) {
                g().F0(true);
            }
            if (!e.c.a.g.a.t.c.b || TextUtils.isEmpty(e.c.a.g.a.t.c.j) || !l1.m0() || e.c.a.g.a.f.m.c.a.e("sp_key_show_privacy", true)) {
                return;
            }
            p1.h(KGApplication.getContext(), e.c.a.g.a.t.c.j);
            e.c.a.g.a.t.c.j = null;
        }
    }

    public final void v0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.D = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(FragmentViewBase.s);
        this.D.setInterpolator(new LinearInterpolator());
        this.D.addUpdateListener(new e());
    }

    public final void w0() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.E = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(FragmentViewBase.s);
        this.E.setInterpolator(new LinearInterpolator());
        this.E.addUpdateListener(new f());
    }

    public final void x0(boolean z, float f2) {
        if (this.C != f2) {
            this.C = f2;
        }
    }

    public AbsFrameworkFragment y0() {
        return this.r[this.s];
    }

    public AbsFrameworkFragment z0() {
        if (g().Z() == null) {
            return null;
        }
        int i2 = this.s;
        if (i2 == 0) {
            return this.o;
        }
        if (i2 == 1) {
            return this.p;
        }
        if (i2 != 2) {
            return null;
        }
        return this.q;
    }
}
