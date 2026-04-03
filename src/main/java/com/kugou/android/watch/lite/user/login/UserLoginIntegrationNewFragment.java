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
public final class UserLoginIntegrationNewFragment extends DelegateFragment {
    public static final a w = new a(null);
    public static int x = 3;
    public TabLayout r;
    public SwipeViewPager s;
    public final String[] t;
    public String[] u;
    public final List<UserLoginItemFragment> v = new ArrayList();

    /* JADX INFO: loaded from: classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final int a() {
            return UserLoginIntegrationNewFragment.x;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class b extends FragmentPagerAdapter {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return UserLoginIntegrationNewFragment.this.v.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) UserLoginIntegrationNewFragment.this.v.get(i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i2) {
            return UserLoginIntegrationNewFragment.this.u[i2];
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class c implements SwipeViewPager.b {
        public c() {
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canLeftSwipe() {
            SwipeViewPager swipeViewPager = UserLoginIntegrationNewFragment.this.s;
            if (swipeViewPager != null) {
                return swipeViewPager.getCurrentItem() > 0;
            }
            j.t("mViewPager");
            throw null;
        }

        @Override // com.kugou.android.watch.lite.common.widget.SwipeViewPager.b
        public boolean canRightSwipe() {
            SwipeViewPager swipeViewPager = UserLoginIntegrationNewFragment.this.s;
            if (swipeViewPager != null) {
                return swipeViewPager.getCurrentItem() < UserLoginIntegrationNewFragment.w.a();
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
            TabLayout tabLayout = UserLoginIntegrationNewFragment.this.r;
            if (tabLayout == null) {
                j.t("mTabLayout");
                throw null;
            }
            TabLayout tabLayout2 = UserLoginIntegrationNewFragment.this.r;
            if (tabLayout2 == null) {
                j.t("mTabLayout");
                throw null;
            }
            tabLayout.selectTab(tabLayout2.getTabAt(i2));
            Iterator it = UserLoginIntegrationNewFragment.this.v.iterator();
            int i3 = 0;
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    if (i2 == 0) {
                        UserLoginIntegrationNewFragment.this.D0(0);
                        return;
                    } else if (i2 == 1) {
                        UserLoginIntegrationNewFragment.this.D0(1);
                        return;
                    } else {
                        if (i2 != 2) {
                            return;
                        }
                        UserLoginIntegrationNewFragment.this.D0(2);
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
            SwipeViewPager swipeViewPager = UserLoginIntegrationNewFragment.this.s;
            if (swipeViewPager == null) {
                j.t("mViewPager");
                throw null;
            }
            TabLayout tabLayout = UserLoginIntegrationNewFragment.this.r;
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

    public UserLoginIntegrationNewFragment() {
        String[] strArr = {"微信", "APP", "手机号"};
        this.t = strArr;
        this.u = strArr;
    }

    public final View A0(String str) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.item_login_tab_text, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.text_tab)).setText(str);
        j.d(viewInflate, "from(context).inflate(R.layout.item_login_tab_text, null, false)\n            .apply {\n                findViewById<TextView>(R.id.text_tab).text = tabName\n            }");
        return viewInflate;
    }

    public final void B0() {
        this.u = this.t;
        x = 3;
    }

    public final void C0() {
    }

    public final void D0(int i2) {
    }

    public final void E0() {
        int i2;
        int i3 = x;
        int i4 = 0;
        if (i3 > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                TabLayout tabLayout = this.r;
                if (tabLayout == null) {
                    j.t("mTabLayout");
                    throw null;
                }
                if (tabLayout == null) {
                    j.t("mTabLayout");
                    throw null;
                }
                tabLayout.addTab(tabLayout.newTab().setCustomView(A0(this.u[i5])));
                if (i6 >= i3) {
                    break;
                } else {
                    i5 = i6;
                }
            }
        }
        if (l1.g0() && (i2 = x) > 0) {
            while (true) {
                int i7 = i4 + 1;
                TabLayout tabLayout2 = this.r;
                if (tabLayout2 == null) {
                    j.t("mTabLayout");
                    throw null;
                }
                TabLayout.Tab tabAt = tabLayout2.getTabAt(i4);
                View customView = tabAt == null ? null : tabAt.getCustomView();
                if (customView instanceof TextView) {
                    ((TextView) customView).setTextSize(11.0f);
                }
                if (i7 >= i2) {
                    break;
                } else {
                    i4 = i7;
                }
            }
        }
        this.v.add(new UserLoginItemFragment(e.c.a.g.a.r.e.k.g.class));
        this.v.add(new UserLoginItemFragment(e.c.a.g.a.r.e.k.d.class));
        this.v.add(new UserLoginItemFragment(f.class));
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
        TabLayout tabLayout3 = this.r;
        if (tabLayout3 == null) {
            j.t("mTabLayout");
            throw null;
        }
        tabLayout3.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
        UserLoginItemFragment userLoginItemFragment = (UserLoginItemFragment) u.v(this.v);
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
        B0();
        View viewFindViewById = view.findViewById(R.id.tab_layout);
        j.d(viewFindViewById, "view.findViewById(R.id.tab_layout)");
        this.r = (TabLayout) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.view_pager);
        j.d(viewFindViewById2, "view.findViewById(R.id.view_pager)");
        this.s = (SwipeViewPager) viewFindViewById2;
        E0();
        C0();
    }
}
