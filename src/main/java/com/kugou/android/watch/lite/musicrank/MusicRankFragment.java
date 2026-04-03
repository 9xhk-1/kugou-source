package com.kugou.android.watch.lite.musicrank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.widget.PlayerBall;
import com.kugou.android.watch.lite.common.widget.SwipeViewPager;
import com.kugou.android.watch.lite.util.ViewPager;
import e.c.a.g.a.d.x.f;
import f.u.m;
import f.z.d.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class MusicRankFragment extends DelegateFragment {
    public TabLayout r;
    public SwipeViewPager s;
    public final List<String> t = m.f("飙升榜", "热歌榜");
    public final List<Fragment> u = new ArrayList();
    public PlayerBall v;

    public static final class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MusicRankFragment.this.u.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) MusicRankFragment.this.u.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return (CharSequence) MusicRankFragment.this.t.get(i2);
        }
    }

    public static final class b implements SwipeViewPager.b {
        public b() {
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canLeftSwipe() {
            SwipeViewPager swipeViewPager = MusicRankFragment.this.s;
            if (swipeViewPager != null) {
                return swipeViewPager.getCurrentItem() != 0;
            }
            j.t("viewpager");
            throw null;
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canRightSwipe() {
            return true;
        }
    }

    public static final class c implements ViewPager.g {
        public c() {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelected(int i2, boolean z) {
            TabLayout tabLayout = MusicRankFragment.this.r;
            if (tabLayout == null) {
                j.t("tabLayout");
                throw null;
            }
            TabLayout tabLayout2 = MusicRankFragment.this.r;
            if (tabLayout2 == null) {
                j.t("tabLayout");
                throw null;
            }
            tabLayout.selectTab(tabLayout2.getTabAt(i2));
            int i3 = 0;
            for (Object obj : MusicRankFragment.this.u) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    m.i();
                    throw null;
                }
                ((Fragment) obj).setUserVisibleHint(i3 == i2);
                i3 = i4;
            }
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelectedAfterAnimation(int i2) {
        }
    }

    public static final class d implements TabLayout.OnTabSelectedListener {
        public d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            SwipeViewPager swipeViewPager = MusicRankFragment.this.s;
            if (swipeViewPager == null) {
                j.t("viewpager");
                throw null;
            }
            TabLayout tabLayout = MusicRankFragment.this.r;
            if (tabLayout != null) {
                swipeViewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
            } else {
                j.t("tabLayout");
                throw null;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
        PlayerBall playerBall = this.v;
        if (playerBall == null) {
            return;
        }
        playerBall.j(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
        PlayerBall playerBall = this.v;
        if (playerBall == null) {
            return;
        }
        playerBall.j(f.q());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_music_rank, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PlayerBall playerBall = this.v;
        if (playerBall == null) {
            return;
        }
        playerBall.j(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PlayerBall playerBall = this.v;
        if (playerBall == null) {
            return;
        }
        playerBall.j(f.q());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        View viewFindViewById = view.findViewById(R.id.tab_layout);
        j.d(viewFindViewById, "view.findViewById(R.id.tab_layout)");
        this.r = (TabLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.view_pager);
        j.d(viewFindViewById2, "view.findViewById(R.id.view_pager)");
        this.s = (SwipeViewPager) viewFindViewById2;
        PlayerBall playerBall = (PlayerBall) view.findViewById(R.id.play_ball);
        this.v = playerBall;
        if (playerBall != null) {
            playerBall.setupFragment(this);
        }
        z0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "音乐排行榜";
    }

    public final View y0(String str) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.young_layout_tab_text, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.text_tab)).setText(str);
        j.d(viewInflate, "tab");
        return viewInflate;
    }

    public final void z0() {
        TabLayout tabLayout = this.r;
        if (tabLayout == null) {
            j.t("tabLayout");
            throw null;
        }
        if (tabLayout == null) {
            j.t("tabLayout");
            throw null;
        }
        tabLayout.addTab(tabLayout.newTab().setCustomView(y0(this.t.get(0))));
        TabLayout tabLayout2 = this.r;
        if (tabLayout2 == null) {
            j.t("tabLayout");
            throw null;
        }
        if (tabLayout2 == null) {
            j.t("tabLayout");
            throw null;
        }
        tabLayout2.addTab(tabLayout2.newTab().setCustomView(y0(this.t.get(1))));
        this.u.add(new SoarRankFragment());
        this.u.add(new HotRankFragment());
        SwipeViewPager swipeViewPager = this.s;
        if (swipeViewPager == null) {
            j.t("viewpager");
            throw null;
        }
        swipeViewPager.setAdapter(new a(getChildFragmentManager()));
        SwipeViewPager swipeViewPager2 = this.s;
        if (swipeViewPager2 == null) {
            j.t("viewpager");
            throw null;
        }
        swipeViewPager2.T(new b());
        SwipeViewPager swipeViewPager3 = this.s;
        if (swipeViewPager3 == null) {
            j.t("viewpager");
            throw null;
        }
        swipeViewPager3.setOnPageChangeListener(new c());
        TabLayout tabLayout3 = this.r;
        if (tabLayout3 == null) {
            j.t("tabLayout");
            throw null;
        }
        tabLayout3.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new d());
        SwipeViewPager swipeViewPager4 = this.s;
        if (swipeViewPager4 != null) {
            swipeViewPager4.setOffscreenPageLimit(2);
        } else {
            j.t("viewpager");
            throw null;
        }
    }
}
