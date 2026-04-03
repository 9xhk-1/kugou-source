package com.kugou.android.watch.lite.user.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.widget.SwipeViewPager;
import com.kugou.android.watch.lite.util.ViewPager;
import e.c.a.g.a.r.e.k.f;
import e.c.a.g.a.s.d0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.o;
import f.u.m;
import f.u.u;
import f.z.d.g;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class UserLoginIntegrationXtcFragment extends DelegateFragment {
    public static final a y = new a(null);
    public static int z = 2;
    public TabLayout r;
    public SwipeViewPager s;
    public final String[] u;
    public String[] v;
    public boolean x;
    public final String[] t = {"扫码登录"};
    public final List<UserLoginItemFragment> w = new ArrayList();

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final int a() {
            return UserLoginIntegrationXtcFragment.z;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class b extends FragmentPagerAdapter {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return UserLoginIntegrationXtcFragment.this.w.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) UserLoginIntegrationXtcFragment.this.w.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return UserLoginIntegrationXtcFragment.this.v[i2];
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class c implements SwipeViewPager.b {
        public c() {
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canLeftSwipe() {
            SwipeViewPager swipeViewPager = UserLoginIntegrationXtcFragment.this.s;
            if (swipeViewPager != null) {
                return swipeViewPager.getCurrentItem() > 0;
            }
            j.t("mViewPager");
            throw null;
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canRightSwipe() {
            SwipeViewPager swipeViewPager = UserLoginIntegrationXtcFragment.this.s;
            if (swipeViewPager != null) {
                return swipeViewPager.getCurrentItem() < UserLoginIntegrationXtcFragment.y.a();
            }
            j.t("mViewPager");
            throw null;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class d extends ViewPager.j {
        public d() {
        }

        @Override // com.kugou.android.watch.lite.util.ViewPager.j, com.kugou.android.watch.lite.util.ViewPager.g
        public void onPageSelected(int i2, boolean z) {
            TabLayout tabLayout = UserLoginIntegrationXtcFragment.this.r;
            if (tabLayout == null) {
                j.t("mTabLayout");
                throw null;
            }
            TabLayout tabLayout2 = UserLoginIntegrationXtcFragment.this.r;
            if (tabLayout2 == null) {
                j.t("mTabLayout");
                throw null;
            }
            tabLayout.selectTab(tabLayout2.getTabAt(i2));
            Iterator it = UserLoginIntegrationXtcFragment.this.w.iterator();
            int i3 = 0;
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    if (i2 == 0) {
                        UserLoginIntegrationXtcFragment.this.D0(0);
                        return;
                    } else {
                        if (i2 != 1) {
                            return;
                        }
                        UserLoginIntegrationXtcFragment.this.D0(1);
                        return;
                    }
                }
                Object next = it.next();
                int i4 = i3 + 1;
                if (i3 < 0) {
                    m.i();
                    throw null;
                }
                UserLoginItemFragment userLoginItemFragment = (UserLoginItemFragment) next;
                if (i3 != i2) {
                    z2 = false;
                }
                userLoginItemFragment.setUserVisibleHint(z2);
                i3 = i4;
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class e implements TabLayout.OnTabSelectedListener {
        public e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            SwipeViewPager swipeViewPager = UserLoginIntegrationXtcFragment.this.s;
            if (swipeViewPager == null) {
                j.t("mViewPager");
                throw null;
            }
            TabLayout tabLayout = UserLoginIntegrationXtcFragment.this.r;
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

    public UserLoginIntegrationXtcFragment() {
        String[] strArr = {"扫码登录", "验证码登录"};
        this.u = strArr;
        this.v = strArr;
    }

    public final View A0(String str) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_login_tab_text, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.text_tab)).setText(str);
        j.d(viewInflate, "from(context).inflate(R.layout.item_login_tab_text, null, false)\n            .apply {\n                findViewById<TextView>(R.id.text_tab).text = tabName\n            }");
        return viewInflate;
    }

    public final void B0() {
        boolean zA = d0.a(getArguments(), "key_hide_phone_login", false);
        this.x = zA;
        if (!zA || l1.m0()) {
            this.v = this.u;
            z = 2;
        } else {
            this.v = this.t;
            z = 1;
        }
        TabLayout tabLayout = this.r;
        if (tabLayout != null) {
            tabLayout.setVisibility(z == 1 ? 8 : 0);
        } else {
            j.t("mTabLayout");
            throw null;
        }
    }

    public final void C0() {
    }

    public final void D0(int i2) {
    }

    public final void E0() {
        int i2 = z;
        if (i2 > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                TabLayout tabLayout = this.r;
                if (tabLayout == null) {
                    j.t("mTabLayout");
                    throw null;
                }
                if (tabLayout == null) {
                    j.t("mTabLayout");
                    throw null;
                }
                tabLayout.addTab(tabLayout.newTab().setCustomView(A0(this.v[i3])));
                if (i4 >= i2) {
                    break;
                } else {
                    i3 = i4;
                }
            }
        }
        this.w.add(new UserLoginItemFragment(e.c.a.g.a.r.e.k.c.class));
        if (!this.x || l1.m0()) {
            this.w.add(new UserLoginItemFragment(f.class));
        }
        SwipeViewPager swipeViewPager = this.s;
        if (swipeViewPager == null) {
            j.t("mViewPager");
            throw null;
        }
        swipeViewPager.setAdapter(new b(getChildFragmentManager()));
        SwipeViewPager swipeViewPager2 = this.s;
        if (swipeViewPager2 == null) {
            j.t("mViewPager");
            throw null;
        }
        swipeViewPager2.T(new c());
        SwipeViewPager swipeViewPager3 = this.s;
        if (swipeViewPager3 == null) {
            j.t("mViewPager");
            throw null;
        }
        swipeViewPager3.setOnPageChangeListener(new d());
        TabLayout tabLayout2 = this.r;
        if (tabLayout2 == null) {
            j.t("mTabLayout");
            throw null;
        }
        tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
        UserLoginItemFragment userLoginItemFragment = (UserLoginItemFragment) u.v(this.w);
        if (userLoginItemFragment == null) {
            return;
        }
        userLoginItemFragment.setUserVisibleHint(true);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_login, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        o.a(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.c.b.a aVar) {
        j.e(aVar, NotificationCompat.CATEGORY_EVENT);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
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
        B0();
        E0();
        C0();
    }
}
