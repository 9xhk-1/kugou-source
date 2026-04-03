package e.c.a.g.a.d.p;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.widget.AutoLoadingView;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends PagerAdapter {
    public FragmentManager a;
    public FragmentTransaction b;
    public Object c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<Object> f467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f469h;

    public b(FragmentManager fragmentManager, Context context, int i2) {
        this(fragmentManager, context, new int[]{R.id.home_navigation_tab_main, R.id.home_navigation_tab_player, R.id.home_navigation_tab_mine}, i2);
    }

    public final void a(FrameLayout frameLayout, int i2) {
        AutoLoadingView autoLoadingView = new AutoLoadingView(this.f466e);
        autoLoadingView.setId(R.id.progress_info);
        autoLoadingView.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        autoLoadingView.setLayoutParams(layoutParams);
        frameLayout.addView(autoLoadingView);
    }

    public Fragment b(int i2) {
        ArrayList<Object> arrayList = this.f467f;
        if (arrayList == null) {
            return null;
        }
        Object obj = arrayList.get(i2);
        if (obj instanceof Fragment) {
            return (Fragment) obj;
        }
        return null;
    }

    public View c(FrameLayout frameLayout) {
        if (frameLayout == null) {
            return null;
        }
        return frameLayout.findViewById(R.id.progress_info);
    }

    public final void d(Object obj) {
        View viewC;
        if (obj == null) {
            return;
        }
        if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        } else {
            if (!(obj instanceof FrameLayout) || (viewC = c((FrameLayout) obj)) == null) {
                return;
            }
            viewC.setVisibility(8);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (obj instanceof FrameLayout) {
            viewGroup.removeView((FrameLayout) obj);
        }
        if (g0.a) {
            g0.e("MainFragmentPagerAdapter", "destroyItem:" + i2 + RetryStaticsLOG.MARK_SEPERATE + obj);
        }
    }

    public void e() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f468g;
            if (i2 >= iArr.length) {
                h("initFragmentLayouts");
                return;
            }
            Fragment fragmentFindFragmentByTag = this.a.findFragmentByTag(g(iArr[i2]));
            if (fragmentFindFragmentByTag != null) {
                this.f467f.add(fragmentFindFragmentByTag);
            } else if (i2 == this.f465d) {
                this.f467f.add(getItem(i2));
            } else {
                FrameLayout frameLayout = new FrameLayout(this.f466e);
                frameLayout.setId(this.f468g[i2]);
                frameLayout.setBackgroundColor(0);
                frameLayout.bringToFront();
                this.f467f.add(frameLayout);
            }
            i2++;
        }
    }

    public void f(int i2) {
        if (b(i2) == null) {
            Fragment item = getItem(i2);
            this.f467f.remove(i2);
            this.f467f.add(i2, item);
            notifyDataSetChanged();
            if (g0.a) {
                g0.e("MainFragmentPagerAdapter", "loadTabFragment position:" + i2);
            }
        }
        h("loadTabFragment " + i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.b;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.b = null;
            if (g0.f()) {
                this.f469h = System.currentTimeMillis();
                if (g0.a) {
                    g0.c("burone5", ">>>>start executePendingTransactions()");
                }
            }
            this.a.executePendingTransactions();
            if (g0.f()) {
                g0.c("burone5", "<<<<finish executePendingTransactions(), cost = " + (System.currentTimeMillis() - this.f469h));
            }
        }
    }

    public String g(int i2) {
        return "android:switcher:" + i2;
    }

    public abstract Fragment getItem(int i2);

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        int iIndexOf = this.f467f.indexOf(obj);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        return -2;
    }

    public void h(String str) {
        if (g0.a) {
            g0.e("MainFragmentPagerAdapter", "printLog after function:" + str + "||size:" + this.f467f.size());
        }
        for (Object obj : this.f467f) {
            if (obj instanceof FrameLayout) {
                if (g0.a) {
                    g0.e("MainFragmentPagerAdapter", "printLog FrameLayout:");
                }
            } else if ((obj instanceof Fragment) && g0.a) {
                g0.e("MainFragmentPagerAdapter", "printLog Fragment:");
            }
        }
    }

    public void i(int i2) {
        this.f465d = i2;
        f(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        if (g0.a) {
            g0.e("MainFragmentPagerAdapter", "instantiateItem:" + i2 + "||Childcount:" + viewGroup.getChildCount());
        }
        Object obj = this.f467f.get(i2);
        if (!(obj instanceof FrameLayout)) {
            if (!(obj instanceof Fragment)) {
                return obj;
            }
            if (this.b == null) {
                this.b = this.a.beginTransaction();
            }
            Fragment fragmentFindFragmentByTag = this.a.findFragmentByTag(g(this.f468g[i2]));
            if (fragmentFindFragmentByTag != null) {
                this.b.attach(fragmentFindFragmentByTag);
            } else {
                fragmentFindFragmentByTag = (Fragment) obj;
                this.b.add(viewGroup.getId(), fragmentFindFragmentByTag, g(this.f468g[i2]));
            }
            if (this.f465d != i2) {
                fragmentFindFragmentByTag.setMenuVisibility(false);
                fragmentFindFragmentByTag.setUserVisibleHint(false);
            }
            return fragmentFindFragmentByTag;
        }
        FrameLayout frameLayout = (FrameLayout) obj;
        if (frameLayout.getParent() == null) {
            viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
            if (frameLayout.getChildCount() == 0) {
                a(frameLayout, i2);
            }
            try {
                c(frameLayout).setVisibility(8);
            } catch (Exception e2) {
                if (g0.a) {
                    g0.b("MainFragmentPagerAdapter", "instantiateItem:Exception " + frameLayout + "||" + e2.getMessage());
                }
            }
        }
        return frameLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return obj instanceof Fragment ? ((Fragment) obj).getView() == view : obj == view;
    }

    public void j(Object obj) {
        View viewC;
        if (obj == null) {
            return;
        }
        if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
        } else {
            if (!(obj instanceof FrameLayout) || (viewC = c((FrameLayout) obj)) == null) {
                return;
            }
            viewC.setVisibility(0);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Object obj2 = this.c;
        if (obj != obj2) {
            d(obj2);
            j(obj);
            this.f465d = i2;
            this.c = obj;
            if (g0.a) {
                g0.e("MainFragmentPagerAdapter", "setPrimaryItem:" + i2);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
    }

    public b(FragmentManager fragmentManager, Context context, int[] iArr, int i2) {
        this.b = null;
        this.c = null;
        this.f465d = 1;
        this.f467f = new ArrayList<>();
        this.f469h = 0L;
        this.f466e = context;
        this.a = fragmentManager;
        this.f468g = iArr;
        this.f465d = i2;
        e();
    }
}
