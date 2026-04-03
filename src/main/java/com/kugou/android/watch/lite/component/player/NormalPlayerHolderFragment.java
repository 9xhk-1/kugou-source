package com.kugou.android.watch.lite.component.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.widget.SwipeViewPager;
import com.kugou.android.watch.lite.component.player.lyric.MainLyricFragment;
import com.kugou.android.watch.lite.util.ViewPager;
import com.kugou.datacollect.bi.use.TraceFullTask;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.LyricManager;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import f.u.m;
import f.u.u;
import f.z.d.j;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
public final class NormalPlayerHolderFragment extends DelegateFragment {
    public SwipeViewPager r;
    public e.c.a.g.a.g.b u;
    public final List<String> s = m.f("播放页", "歌词页");
    public final List<DelegateFragment> t = new ArrayList();
    public final boolean v = e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.E2, false);

    public static final class a extends FragmentPagerAdapter {
        public a(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return NormalPlayerHolderFragment.this.t.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) NormalPlayerHolderFragment.this.t.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return (CharSequence) NormalPlayerHolderFragment.this.s.get(i2);
        }
    }

    public static final class b extends ViewPager.j {
        public b() {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.j, com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelectedAfterAnimation(int i2) {
            e.c.a.g.a.g.b bVar = NormalPlayerHolderFragment.this.u;
            if (bVar == null) {
                j.t("mMainIndicator");
                throw null;
            }
            bVar.b(i2);
            NormalPlayerHolderFragment.this.A0(i2);
        }
    }

    public static final class c implements SwipeViewPager.b {
        public c() {
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canLeftSwipe() {
            SwipeViewPager swipeViewPager = NormalPlayerHolderFragment.this.r;
            boolean z = false;
            if (swipeViewPager != null && swipeViewPager.getCurrentItem() == 0) {
                z = true;
            }
            return !z;
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canRightSwipe() {
            return true;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ int a;

        public d(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String string;
            String string2;
            String str = "";
            String strE = e.c.a.g.a.f.n.a.b().e(42, "");
            LyricData lyricData = LyricManager.getInstance().getLyricData();
            YoungBITask youngBITask = new YoungBITask(3003, "click");
            KGMusicWrapper kGMusicWrapperE = f.e();
            if (kGMusicWrapperE != null && (string2 = Long.valueOf(kGMusicWrapperE.getMixId()).toString()) != null) {
                str = string2;
            }
            TraceFullTask svar1 = youngBITask.setMixsongid(str).setType(this.a == 0 ? "2" : "1").setSvar1(strE);
            String str2 = "empty";
            if (lyricData != null && (string = Integer.valueOf(lyricData.getLyricType()).toString()) != null) {
                str2 = string;
            }
            e.c.a.g.a.e.b.b(svar1.setSvar2(str2));
        }
    }

    public final void A0(int i2) {
        j0.b().a(new d(i2));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        DelegateFragment delegateFragment;
        super.G();
        SwipeViewPager swipeViewPager = this.r;
        if (swipeViewPager == null || (delegateFragment = (DelegateFragment) u.w(this.t, swipeViewPager.getCurrentItem())) == null) {
            return;
        }
        delegateFragment.G();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        DelegateFragment delegateFragment;
        super.J();
        SwipeViewPager swipeViewPager = this.r;
        if (swipeViewPager == null || (delegateFragment = (DelegateFragment) u.w(this.t, swipeViewPager.getCurrentItem())) == null) {
            return;
        }
        delegateFragment.J();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void b(View view) {
        SwipeViewPager swipeViewPager;
        super.b(view);
        if (view == null || (swipeViewPager = this.r) == null) {
            return;
        }
        swipeViewPager.c(view);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public int o() {
        return 1;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_player_holder, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        this.r = (SwipeViewPager) view.findViewById(R.id.view_pager);
        z0();
        View viewFindViewById = view.findViewById(R.id.main_point_container);
        j.d(viewFindViewById, "view.findViewById(R.id.main_point_container)");
        e.c.a.g.a.g.b bVar = new e.c.a.g.a.g.b((LinearLayout) viewFindViewById);
        this.u = bVar;
        if (bVar == null) {
            j.t("mMainIndicator");
            throw null;
        }
        bVar.a(this.s.size(), m.f(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_indicator_player, null), ResourcesCompat.getDrawable(getResources(), R.drawable.ic_indicator_lyric, null)));
        e.c.a.g.a.g.b bVar2 = this.u;
        if (bVar2 == null) {
            j.t("mMainIndicator");
            throw null;
        }
        bVar2.b(0);
        View viewFindViewById2 = view.findViewById(R.id.app_info_container);
        j.d(viewFindViewById2, "view.findViewById(R.id.app_info_container)");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
        if (this.v) {
            linearLayout.setVisibility(8);
        }
        if (l1.m0()) {
            linearLayout.setPadding(linearLayout.getPaddingLeft(), 0, l1.c(5.0f), 0);
        }
        if (l1.f0()) {
            linearLayout.setPadding(linearLayout.getPaddingLeft(), 0, l1.c(15.0f), 0);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        DelegateFragment delegateFragment;
        super.setUserVisibleHint(z);
        SwipeViewPager swipeViewPager = this.r;
        if (swipeViewPager == null || (delegateFragment = (DelegateFragment) u.w(this.t, swipeViewPager.getCurrentItem())) == null) {
            return;
        }
        delegateFragment.setUserVisibleHint(z);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public boolean t0() {
        return false;
    }

    public final void z0() {
        PagerAdapter adapter;
        this.t.clear();
        this.t.add(new NormalPlayerFragment());
        this.t.add(new MainLyricFragment());
        SwipeViewPager swipeViewPager = this.r;
        if (swipeViewPager != null) {
            swipeViewPager.setAdapter(new a(getChildFragmentManager()));
        }
        SwipeViewPager swipeViewPager2 = this.r;
        if (swipeViewPager2 != null && (adapter = swipeViewPager2.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
        SwipeViewPager swipeViewPager3 = this.r;
        if (swipeViewPager3 != null) {
            swipeViewPager3.setOnPageChangeListener(new b());
        }
        SwipeViewPager swipeViewPager4 = this.r;
        if (swipeViewPager4 != null) {
            swipeViewPager4.setOffscreenPageLimit(2);
        }
        SwipeViewPager swipeViewPager5 = this.r;
        if (swipeViewPager5 == null) {
            return;
        }
        swipeViewPager5.T(new c());
    }
}
