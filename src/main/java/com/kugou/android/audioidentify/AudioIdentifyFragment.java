package com.kugou.android.audioidentify;

import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.widget.SwipeViewPager;
import com.kugou.android.watch.lite.util.ViewPager;
import com.kugou.common.network.retry.IWebViewACKRetryStrategy;
import com.kugou.common.network.retry.WebViewACKRetryStrategy;
import com.kugou.framework.musichunter.IMusicHunterEvent;
import com.kugou.framework.musichunter.MusicHunter;
import com.kugou.framework.musichunter.NetSongResponse;
import com.kugou.framework.musichunter.RecognizeResult;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.o;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import f.u.m;
import f.u.u;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class AudioIdentifyFragment extends DelegateFragment {
    public MusicHunter A;
    public IWebViewACKRetryStrategy B;
    public TabLayout r;
    public SwipeViewPager s;
    public final String[] t = {"听歌识曲", "哼唱识曲"};
    public final List<AbsIdentifyFragment> u = new ArrayList();
    public int v;
    public PowerManager.WakeLock w;
    public boolean x;
    public boolean y;
    public int z;

    public final class a implements IMusicHunterEvent {
        public final /* synthetic */ AudioIdentifyFragment a;

        public a(AudioIdentifyFragment audioIdentifyFragment) {
            j.e(audioIdentifyFragment, "this$0");
            this.a = audioIdentifyFragment;
        }

        public final void a(String str, int i2) {
            if (g0.a) {
                g0.b("audio_identify_frag", "onFailRecognize: ");
            }
            this.a.v = 0;
            if (!this.a.y) {
                ((AbsIdentifyFragment) this.a.u.get(this.a.z)).I0(7);
            }
            this.a.H0();
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onCancel(String str, int i2, boolean z) {
            if (g0.a) {
                g0.b("audio_identify_frag", "onCancel: ");
            }
            this.a.v = 0;
            ((AbsIdentifyFragment) this.a.u.get(this.a.z)).G0(z);
            if (z) {
                ((AbsIdentifyFragment) this.a.u.get(this.a.z)).L0();
            } else {
                ((AbsIdentifyFragment) this.a.u.get(this.a.z)).I0(9);
            }
            this.a.H0();
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onFinish(RecognizeResult recognizeResult, String str, int i2, int i3) {
            MusicHunter musicHunter = this.a.A;
            if (musicHunter == null) {
                j.t("mMusicHunter");
                throw null;
            }
            musicHunter.getTimeOffset(recognizeResult);
            if (g0.a) {
                g0.b("audio_identify_frag", "onFinish: ");
            }
            ((AbsIdentifyFragment) this.a.u.get(this.a.z)).U0();
            NetSongResponse response = recognizeResult == null ? null : recognizeResult.getResponse();
            if (l0.g(response == null ? null : response.getSongs())) {
                if (g0.a) {
                    g0.e("audio_identify_frag", "没有识别结果");
                }
                MusicHunter musicHunter2 = this.a.A;
                if (musicHunter2 == null) {
                    j.t("mMusicHunter");
                    throw null;
                }
                musicHunter2.cancel();
                a(str, i3);
                this.a.v = 0;
                ((AbsIdentifyFragment) this.a.u.get(this.a.z)).H0();
            } else {
                this.a.v = 4;
            }
            ((AbsIdentifyFragment) this.a.u.get(this.a.z)).J0(recognizeResult, str, i2, i3, this.a.y, response != null ? response.isGuess() : false);
            this.a.H0();
            this.a.N0();
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onFirstSliceSend() {
            if (g0.a) {
                g0.b("audio_identify_frag", "onFirstSliceSend: ");
            }
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onHunterStop() {
            if (g0.a) {
                g0.b("audio_identify_frag", "onStop: ");
            }
            this.a.N0();
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onInitFailure(int i2) {
            if (g0.a) {
                g0.b("audio_identify_frag", "onInitFailure: ");
            }
            this.a.v = 0;
            ((AbsIdentifyFragment) this.a.u.get(this.a.z)).L0();
            MusicHunter musicHunter = this.a.A;
            if (musicHunter == null) {
                j.t("mMusicHunter");
                throw null;
            }
            musicHunter.cancel();
            onRecordError(i2);
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onMusicHunterStart() {
            if (g0.a) {
                g0.b("audio_identify_frag", "onMusicHunterStart: ");
            }
            this.a.v = 1;
            this.a.y = false;
            this.a.x = false;
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onNetError(RecognizeResult recognizeResult) {
            if (g0.a) {
                g0.b("audio_identify_frag", "onDisconnectServer: ");
            }
            this.a.v = 0;
            MusicHunter musicHunter = this.a.A;
            if (musicHunter == null) {
                j.t("mMusicHunter");
                throw null;
            }
            musicHunter.cancel();
            ((AbsIdentifyFragment) this.a.u.get(this.a.z)).I0(8);
            p1.h(KGApplication.getContext(), "网络异常，请稍后重试");
            u0.z(41, "AudioIdentifyFragment");
            this.a.H0();
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onNoStorage() {
            if (g0.a) {
                g0.b("audio_identify_frag", "onNoStorage: ");
            }
            this.a.v = 0;
            MusicHunter musicHunter = this.a.A;
            if (musicHunter == null) {
                j.t("mMusicHunter");
                throw null;
            }
            musicHunter.cancel();
            ((AbsIdentifyFragment) this.a.u.get(this.a.z)).L0();
            p1.h(this.a.getContext(), "存储空间不够，暂时无法保存录音片段");
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        @WorkerThread
        public void onRecognizeOnline() {
            if (g0.a) {
                g0.b("audio_identify_frag", "onRecognizeOnline: ");
            }
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onRecordError(int i2) {
            if (g0.a) {
                g0.b("audio_identify_frag", "onRecordError: ");
            }
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        @WorkerThread
        public void onRecordVolumeSize(double d2, boolean z) {
            if (g0.a) {
                g0.b("audio_identify_frag", "onRecordVolumeSize: ");
            }
        }

        @Override // com.kugou.framework.musichunter.IMusicHunterEvent
        public void onVolumeChanged(double d2) {
        }
    }

    public static final class b implements MusicHunter.Config {
        @Override // com.kugou.framework.musichunter.MusicHunter.Config
        public boolean canAccessDeviceId() {
            return false;
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MusicHunter musicHunter = AudioIdentifyFragment.this.A;
            if (musicHunter != null) {
                musicHunter.stopRecord();
            } else {
                j.t("mMusicHunter");
                throw null;
            }
        }
    }

    public static final class d extends FragmentPagerAdapter {
        public d(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return AudioIdentifyFragment.this.u.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) AudioIdentifyFragment.this.u.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return AudioIdentifyFragment.this.t[i2];
        }
    }

    public static final class e implements SwipeViewPager.b {
        public e() {
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canLeftSwipe() {
            SwipeViewPager swipeViewPager = AudioIdentifyFragment.this.s;
            if (swipeViewPager != null) {
                return swipeViewPager.getCurrentItem() > 0;
            }
            j.t("mViewPager");
            throw null;
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canRightSwipe() {
            SwipeViewPager swipeViewPager = AudioIdentifyFragment.this.s;
            if (swipeViewPager != null) {
                return swipeViewPager.getCurrentItem() < 2;
            }
            j.t("mViewPager");
            throw null;
        }
    }

    public static final class f extends ViewPager.j {
        public f() {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.j, com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelected(int i2, boolean z) {
            TabLayout tabLayout = AudioIdentifyFragment.this.r;
            if (tabLayout == null) {
                j.t("mTabLayout");
                throw null;
            }
            TabLayout tabLayout2 = AudioIdentifyFragment.this.r;
            if (tabLayout2 == null) {
                j.t("mTabLayout");
                throw null;
            }
            tabLayout.selectTab(tabLayout2.getTabAt(i2));
            Iterator it = AudioIdentifyFragment.this.u.iterator();
            int i3 = 0;
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    if (i2 == 0) {
                        AudioIdentifyFragment.this.K0(0);
                        return;
                    } else {
                        if (i2 != 1) {
                            return;
                        }
                        AudioIdentifyFragment.this.K0(1);
                        return;
                    }
                }
                Object next = it.next();
                int i4 = i3 + 1;
                if (i3 < 0) {
                    m.i();
                    throw null;
                }
                AbsIdentifyFragment absIdentifyFragment = (AbsIdentifyFragment) next;
                if (i3 != i2) {
                    z2 = false;
                }
                absIdentifyFragment.setUserVisibleHint(z2);
                i3 = i4;
            }
        }
    }

    public static final class g implements TabLayout.OnTabSelectedListener {
        public g() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            SwipeViewPager swipeViewPager = AudioIdentifyFragment.this.s;
            if (swipeViewPager == null) {
                j.t("mViewPager");
                throw null;
            }
            TabLayout tabLayout = AudioIdentifyFragment.this.r;
            if (tabLayout != null) {
                swipeViewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
            } else {
                j.t("mTabLayout");
                throw null;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static final class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MusicHunter musicHunter = AudioIdentifyFragment.this.A;
            if (musicHunter != null) {
                musicHunter.stopRecord();
            } else {
                j.t("mMusicHunter");
                throw null;
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        H0();
        MusicHunter musicHunter = this.A;
        if (musicHunter == null) {
            j.t("mMusicHunter");
            throw null;
        }
        if (musicHunter.isRecording()) {
            N0();
        }
    }

    public final void H0() {
        PowerManager.WakeLock wakeLock = this.w;
        if (wakeLock == null) {
            return;
        }
        wakeLock.release();
    }

    public final View I0(String str) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_audio_identify_tab_text, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.text_tab)).setText(str);
        j.d(viewInflate, "from(context).inflate(R.layout.item_audio_identify_tab_text, null, false)\n            .apply {\n                findViewById<TextView>(R.id.text_tab).text = tabName\n            }");
        return viewInflate;
    }

    public final void J0() {
        IWebViewACKRetryStrategy webViewACKRetryStrategy = WebViewACKRetryStrategy.getInstance();
        j.d(webViewACKRetryStrategy, "getInstance()");
        this.B = webViewACKRetryStrategy;
        if (webViewACKRetryStrategy == null) {
            j.t("mACKRetryStrategy");
            throw null;
        }
        webViewACKRetryStrategy.initAckMapByKey("audio_identify_frag");
        MusicHunter.setDebugModel(g0.f());
        MusicHunter.preInit(getActivity(), String.valueOf(l1.f()), l1.g(), new b());
        this.A = new MusicHunter(getActivity(), new a(this));
    }

    public final void K0(int i2) {
        this.z = i2;
        for (AbsIdentifyFragment absIdentifyFragment : this.u) {
            if (absIdentifyFragment.z()) {
                absIdentifyFragment.U0();
                absIdentifyFragment.L0();
            }
        }
        j0.b().a(new c());
        this.y = true;
        if (this.v == 1) {
            MusicHunter musicHunter = this.A;
            if (musicHunter == null) {
                j.t("mMusicHunter");
                throw null;
            }
            musicHunter.cancel(true);
        }
    }

    public final void L0() {
        boolean z = false;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            TabLayout tabLayout = this.r;
            if (tabLayout == null) {
                j.t("mTabLayout");
                throw null;
            }
            if (tabLayout == null) {
                j.t("mTabLayout");
                throw null;
            }
            tabLayout.addTab(tabLayout.newTab().setCustomView(I0(this.t[i2])));
            if (i3 >= 2) {
                if (l1.g0()) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        TabLayout tabLayout2 = this.r;
                        if (tabLayout2 == null) {
                            j.t("mTabLayout");
                            throw null;
                        }
                        TabLayout.Tab tabAt = tabLayout2.getTabAt(i4);
                        View customView = tabAt == null ? null : tabAt.getCustomView();
                        if (customView instanceof TextView) {
                            ((TextView) customView).setTextSize(12.0f);
                        }
                        if (i5 >= 2) {
                            TabLayout tabLayout3 = this.r;
                            if (tabLayout3 == null) {
                                j.t("mTabLayout");
                                throw null;
                            }
                            tabLayout3.getLayoutParams().height = -2;
                        } else {
                            i4 = i5;
                        }
                    }
                }
                Bundle bundle = new Bundle();
                Bundle arguments = getArguments();
                if (arguments != null && arguments.getBoolean("startIdentify", false)) {
                    z = true;
                }
                bundle.putBoolean("startIdentify", z);
                this.u.add(new TingIdentifyFragment(bundle));
                this.u.add(new HengIdentifyFragment());
                SwipeViewPager swipeViewPager = this.s;
                if (swipeViewPager == null) {
                    j.t("mViewPager");
                    throw null;
                }
                swipeViewPager.setOffscreenPageLimit(2);
                SwipeViewPager swipeViewPager2 = this.s;
                if (swipeViewPager2 == null) {
                    j.t("mViewPager");
                    throw null;
                }
                swipeViewPager2.setAdapter(new d(getChildFragmentManager()));
                SwipeViewPager swipeViewPager3 = this.s;
                if (swipeViewPager3 == null) {
                    j.t("mViewPager");
                    throw null;
                }
                swipeViewPager3.T(new e());
                SwipeViewPager swipeViewPager4 = this.s;
                if (swipeViewPager4 == null) {
                    j.t("mViewPager");
                    throw null;
                }
                swipeViewPager4.setOnPageChangeListener(new f());
                TabLayout tabLayout4 = this.r;
                if (tabLayout4 == null) {
                    j.t("mTabLayout");
                    throw null;
                }
                tabLayout4.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new g());
                AbsIdentifyFragment absIdentifyFragment = (AbsIdentifyFragment) u.v(this.u);
                if (absIdentifyFragment == null) {
                    return;
                }
                absIdentifyFragment.setUserVisibleHint(true);
                return;
            }
            i2 = i3;
        }
    }

    public final void M0() {
        if (this.w == null) {
            Object systemService = k0().getSystemService("power");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(536870922, AudioIdentifyFragment.class.getSimpleName());
            wakeLockNewWakeLock.setReferenceCounted(false);
            this.w = wakeLockNewWakeLock;
        }
        PowerManager.WakeLock wakeLock = this.w;
        if (wakeLock == null || wakeLock.isHeld()) {
            return;
        }
        wakeLock.acquire();
    }

    public final void N0() {
        this.y = true;
        j0.b().a(new h());
        MusicHunter musicHunter = this.A;
        if (musicHunter == null) {
            j.t("mMusicHunter");
            throw null;
        }
        musicHunter.cancel(this.y);
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.v = 0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_audio_identify, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        o.a(this);
        if (this.v == 1) {
            if (g0.a) {
                g0.b("audio_identify_frag", "识别过程中退出页面");
            }
            this.v = 0;
        }
        MusicHunter musicHunter = this.A;
        if (musicHunter != null) {
            musicHunter.quit();
        } else {
            j.t("mMusicHunter");
            throw null;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.c.b.a aVar) {
        j.e(aVar, NotificationCompat.CATEGORY_EVENT);
        if (e.c.a.g.a.d.x.f.q()) {
            e.c.a.g.a.d.x.f.t();
        }
        MusicHunter musicHunter = this.A;
        if (musicHunter == null) {
            j.t("mMusicHunter");
            throw null;
        }
        musicHunter.setRecordType(aVar.a);
        MusicHunter musicHunter2 = this.A;
        if (musicHunter2 == null) {
            j.t("mMusicHunter");
            throw null;
        }
        musicHunter2.start(aVar.a);
        int i2 = aVar.a;
        M0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        H0();
        MusicHunter musicHunter = this.A;
        if (musicHunter == null) {
            j.t("mMusicHunter");
            throw null;
        }
        if (musicHunter.isRecording()) {
            N0();
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        EventBus.getDefault().register(this);
        View viewFindViewById = view.findViewById(R.id.tab_layout);
        j.d(viewFindViewById, "view.findViewById(R.id.tab_layout)");
        this.r = (TabLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.view_pager);
        j.d(viewFindViewById2, "view.findViewById(R.id.view_pager)");
        this.s = (SwipeViewPager) viewFindViewById2;
        L0();
        J0();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.c.b.b bVar) {
        j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        N0();
    }
}
