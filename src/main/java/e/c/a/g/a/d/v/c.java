package e.c.a.g.a.d.v;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.base.main.MainFragmentContainer;
import com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate;
import e.c.a.g.a.s.g0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static WeakReference<ViewPagerFrameworkDelegate> a;

    public static b a() {
        ViewPagerFrameworkDelegate viewPagerFrameworkDelegate;
        WeakReference<ViewPagerFrameworkDelegate> weakReference = a;
        if (weakReference == null || (viewPagerFrameworkDelegate = weakReference.get()) == null) {
            return null;
        }
        return viewPagerFrameworkDelegate.P();
    }

    public static AbsFrameworkFragment b() {
        ViewPagerFrameworkDelegate viewPagerFrameworkDelegate;
        WeakReference<ViewPagerFrameworkDelegate> weakReference = a;
        if (weakReference == null || (viewPagerFrameworkDelegate = weakReference.get()) == null) {
            return null;
        }
        if (g0.a) {
            g0.b("zhpu_fragment", "current : " + viewPagerFrameworkDelegate.V().getClass().getSimpleName());
        }
        return viewPagerFrameworkDelegate.V();
    }

    public static AbsFrameworkFragment c() {
        ViewPagerFrameworkDelegate viewPagerFrameworkDelegate;
        WeakReference<ViewPagerFrameworkDelegate> weakReference = a;
        if (weakReference == null || (viewPagerFrameworkDelegate = weakReference.get()) == null) {
            return null;
        }
        if (g0.a) {
            g0.b("zhpu_fragment", "last : " + viewPagerFrameworkDelegate.V().getClass().getSimpleName());
        }
        return viewPagerFrameworkDelegate.Y();
    }

    public static void d(ViewPagerFrameworkDelegate viewPagerFrameworkDelegate) {
        a = new WeakReference<>(viewPagerFrameworkDelegate);
    }

    public static void e(Class<? extends Fragment> cls, Bundle bundle) {
        f(cls, bundle, true, false, false);
    }

    public static void f(Class<? extends Fragment> cls, Bundle bundle, boolean z, boolean z2, boolean z3) {
        ViewPagerFrameworkDelegate viewPagerFrameworkDelegate;
        WeakReference<ViewPagerFrameworkDelegate> weakReference = a;
        if (weakReference == null || (viewPagerFrameworkDelegate = weakReference.get()) == null) {
            Context context = KGApplication.getContext();
            Intent intent = new Intent();
            intent.setClassName(context, "com.kugou.android.watch.lite.component.MainActivity");
            intent.putExtra("fragment_class", cls.getName());
            intent.setAction("fragment_act");
            intent.putExtra("fragment_bundle", bundle);
            intent.putExtra("enable_anim", true);
            intent.putExtra("is_clear_top", false);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return;
        }
        AbsFrameworkFragment absFrameworkFragmentV = viewPagerFrameworkDelegate.V();
        if (absFrameworkFragmentV != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (absFrameworkFragmentV instanceof MainFragmentContainer) {
                MainFragmentContainer mainFragmentContainer = (MainFragmentContainer) absFrameworkFragmentV;
                if (mainFragmentContainer.y0() != null) {
                    bundle.putString("key_identifier", mainFragmentContainer.y0().p());
                } else {
                    bundle.putString("key_identifier", absFrameworkFragmentV.p());
                }
            } else {
                bundle.putString("key_identifier", absFrameworkFragmentV.p());
            }
        }
        viewPagerFrameworkDelegate.J0(null, cls, bundle, z, z2, z3);
    }
}
