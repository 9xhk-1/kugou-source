package com.kugou.android.watch.lite.base.other;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.kugou.android.watch.lite.base.activity.FrameworkActivity;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment;
import com.kugou.android.watch.lite.base.main.FrameworkContentView;
import com.kugou.android.watch.lite.base.main.MainFragmentContainer;
import com.kugou.android.watch.lite.base.uiframe.FragmentStackView;
import com.kugou.android.watch.lite.base.uiframe.FragmentViewBase;
import e.c.a.g.a.s.f0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ViewPagerFrameworkDelegate {
    public static final String s = "com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate";
    public static String t = "";
    public static final String u;
    public static final String v;
    public static final String w;
    public static final String x;
    public static String y;
    public static final int z;
    public MainFragmentContainer a;
    public e.c.a.g.a.d.t.b b;
    public AbsFrameworkFragment c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f50d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameworkActivity f51e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f52f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f53g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f54h;
    public ArrayList<k> j;
    public k[] k;
    public FragmentStackView m;
    public long q;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FragmentStackView.c f55i = new a();
    public HashMap<String, FragmentViewBase> l = new HashMap<>();
    public int n = 0;
    public boolean o = false;
    public Bundle p = new Bundle();
    public boolean r = false;

    public static class FragmentCls implements Parcelable {
        public static final Parcelable.Creator<FragmentCls> CREATOR = new a();
        public String a;
        public Integer b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Bundle f56d;

        public class a implements Parcelable.Creator<FragmentCls> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FragmentCls createFromParcel(Parcel parcel) {
                return new FragmentCls(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public FragmentCls[] newArray(int i2) {
                return new FragmentCls[i2];
            }
        }

        public /* synthetic */ FragmentCls(a aVar) {
            this();
        }

        public static FragmentCls a() {
            FragmentCls fragmentCls = new FragmentCls();
            fragmentCls.b = 0;
            fragmentCls.a = "";
            fragmentCls.f56d = new Bundle();
            return fragmentCls;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("containerId", this.b);
                jSONObject.put("cls", this.a);
                jSONObject.put("bundle", this.f56d);
            } catch (JSONException e2) {
                g0.k(e2);
            }
            return jSONObject.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            try {
                parcel.writeString(this.a);
                parcel.writeInt(this.b.intValue());
                parcel.writeBundle(this.f56d);
            } catch (StackOverflowError e2) {
                f0.h(e2.getMessage());
            }
        }

        public FragmentCls(Parcel parcel) {
            this.a = parcel.readString();
            this.b = Integer.valueOf(parcel.readInt());
            this.f56d = parcel.readBundle(KGApplication.getContext().getClassLoader());
        }

        public FragmentCls() {
        }
    }

    public class a implements FragmentStackView.c {
        public a() {
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentStackView.c
        public void onContainerEnterFinished(FragmentViewBase.c cVar) {
            AbsFrameworkFragment absFrameworkFragment;
            if (cVar == null || (absFrameworkFragment = cVar.a) == null) {
                return;
            }
            ViewPagerFrameworkDelegate.this.A(absFrameworkFragment, cVar.b, cVar.c, cVar.f90d, cVar.f91e);
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentStackView.c
        public void onContainerScrollStart(FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2) {
            AbsFrameworkFragment absFrameworkFragmentM;
            if (fragmentViewBase == null || (absFrameworkFragmentM = ViewPagerFrameworkDelegate.this.M(fragmentViewBase.getId())) == null) {
                return;
            }
            if (ViewPagerFrameworkDelegate.this.b != null) {
                ViewPagerFrameworkDelegate.this.b.recordChangeBefore();
            }
            AbsFrameworkFragment absFrameworkFragment = ViewPagerFrameworkDelegate.this.c;
            ViewPagerFrameworkDelegate.this.c = absFrameworkFragmentM;
            if (ViewPagerFrameworkDelegate.this.b != null) {
                ViewPagerFrameworkDelegate.this.b.recordChangeAfter();
            }
            if (ViewPagerFrameworkDelegate.this.f52f != null) {
                ViewPagerFrameworkDelegate.this.f52f.onSlideToLeftCallback();
            }
            if (absFrameworkFragment != null) {
                absFrameworkFragment.S(true);
                absFrameworkFragment.Z(true);
            }
            if (ViewPagerFrameworkDelegate.this.b != null) {
                ViewPagerFrameworkDelegate.this.b.executeNavChanged();
            }
            ViewPagerFrameworkDelegate.this.y(absFrameworkFragmentM);
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentStackView.c
        public void onContainerScrolledOut(FragmentViewBase fragmentViewBase) {
            FragmentViewBase top1stContainerView = ViewPagerFrameworkDelegate.this.m.getTop1stContainerView();
            if (top1stContainerView == null || fragmentViewBase == null) {
                return;
            }
            AbsFrameworkFragment absFrameworkFragmentM = ViewPagerFrameworkDelegate.this.M(top1stContainerView.getId());
            AbsFrameworkFragment absFrameworkFragmentM2 = ViewPagerFrameworkDelegate.this.M(fragmentViewBase.getId());
            if (absFrameworkFragmentM == null || absFrameworkFragmentM2 == null) {
                return;
            }
            ViewPagerFrameworkDelegate.this.c = absFrameworkFragmentM2;
            if (ViewPagerFrameworkDelegate.this.a != null) {
                ViewPagerFrameworkDelegate.this.a.B0();
            }
            absFrameworkFragmentM.setUserVisibleHint(false);
            absFrameworkFragmentM.setMenuVisibility(false);
            absFrameworkFragmentM2.setUserVisibleHint(true);
            absFrameworkFragmentM2.setMenuVisibility(true);
            ViewPagerFrameworkDelegate.this.y0(fragmentViewBase, true);
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentStackView.c
        public void onDraggingCompactStateChanged(FragmentViewBase fragmentViewBase, int i2) {
            if (fragmentViewBase != null && ViewPagerFrameworkDelegate.this.M(fragmentViewBase.getId()) == null) {
            }
        }

        @Override // com.kugou.android.watch.lite.base.uiframe.FragmentStackView.c
        public void onScrollStateChanged(int i2) {
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ AbsFrameworkFragment a;

        public b(AbsFrameworkFragment absFrameworkFragment) {
            this.a = absFrameworkFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPagerFrameworkDelegate.this.w0(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ MainFragmentContainer a;
        public final /* synthetic */ FragmentViewBase b;

        public c(MainFragmentContainer mainFragmentContainer, FragmentViewBase fragmentViewBase) {
            this.a = mainFragmentContainer;
            this.b = fragmentViewBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = new k();
            if (this.a.isAdded()) {
                this.b.setIgnoredViews(this.a.j());
                boolean zB = this.a.B();
                boolean zA = this.a.A();
                if (!zB && !zA) {
                    kVar.a = this.a;
                }
                kVar.c = this.a;
            }
            ViewPagerFrameworkDelegate.this.J(kVar);
            ViewPagerFrameworkDelegate.this.K();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPagerFrameworkDelegate.this.f52f.onFragmentFirstStart();
        }
    }

    public class e implements Runnable {
        public final /* synthetic */ AbsFrameworkFragment a;
        public final /* synthetic */ Class b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Bundle f58d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FragmentViewBase f59f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ FragmentViewBase f60h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ FragmentViewBase f61i;
        public final /* synthetic */ boolean j;

        public e(AbsFrameworkFragment absFrameworkFragment, Class cls, Bundle bundle, FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2, FragmentViewBase fragmentViewBase3, boolean z) {
            this.a = absFrameworkFragment;
            this.b = cls;
            this.f58d = bundle;
            this.f59f = fragmentViewBase;
            this.f60h = fragmentViewBase2;
            this.f61i = fragmentViewBase3;
            this.j = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPagerFrameworkDelegate.this.t("animationFirst");
            ViewPagerFrameworkDelegate.this.q(this.a, this.b, this.f58d, this.f59f, this.f60h, this.f61i, true, this.j);
        }
    }

    public class f implements Runnable {
        public final /* synthetic */ FragmentViewBase a;
        public final /* synthetic */ FragmentViewBase b;

        public f(FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2) {
            this.a = fragmentViewBase;
            this.b = fragmentViewBase2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPagerFrameworkDelegate.this.r = false;
            ViewPagerFrameworkDelegate.this.m.e(this.a, this.b);
            ViewPagerFrameworkDelegate.this.t("fragmentFirst");
        }
    }

    public class g implements Runnable {
        public final /* synthetic */ AbsFrameworkFragment a;
        public final /* synthetic */ AbsFrameworkFragment b;

        public g(ViewPagerFrameworkDelegate viewPagerFrameworkDelegate, AbsFrameworkFragment absFrameworkFragment, AbsFrameworkFragment absFrameworkFragment2) {
            this.a = absFrameworkFragment;
            this.b = absFrameworkFragment2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.S(false);
            this.b.setMenuVisibility(true);
            this.b.setUserVisibleHint(true);
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ AbsFrameworkFragment a;
        public final /* synthetic */ FragmentViewBase b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FragmentViewBase f63d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FragmentViewBase f64f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ boolean f65h;

        public h(AbsFrameworkFragment absFrameworkFragment, FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2, FragmentViewBase fragmentViewBase3, boolean z) {
            this.a = absFrameworkFragment;
            this.b = fragmentViewBase;
            this.f63d = fragmentViewBase2;
            this.f64f = fragmentViewBase3;
            this.f65h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewPagerFrameworkDelegate.this.A(this.a, this.b, this.f63d, this.f64f, this.f65h);
        }
    }

    public interface i {
        AbsFrameworkFragment onCreateLyricFragment();

        AbsFrameworkFragment onCreateMainFragment();

        AbsFrameworkFragment onCreatePlayerFragment();

        void onFinishFragment(int i2);

        void onFragmentFirstStart();

        void onKeyBackSlideCallback();

        void onNewBundle(Bundle bundle);

        void onPlayerSlideCallback(boolean z, boolean z2);

        void onSlideToLeftCallback();

        void onSlideToRightCallback();
    }

    public static class j {
        public AbsFrameworkFragment a;
        public Class<? extends Fragment> b;
        public Bundle c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f67d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f68e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f69f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f70g;
    }

    public static class k {
        public AbsFrameworkFragment a;
        public AbsFrameworkFragment b;
        public AbsFrameworkFragment c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AbsFrameworkFragment f71d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public AbsFrameworkFragment f72e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AbsFrameworkFragment f73f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AbsFrameworkFragment f74g;
    }

    public static class l extends Handler {
        public boolean a = false;
        public final WeakReference<ViewPagerFrameworkDelegate> b;

        public l(ViewPagerFrameworkDelegate viewPagerFrameworkDelegate) {
            this.b = new WeakReference<>(viewPagerFrameworkDelegate);
        }

        public boolean a() {
            return this.a;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ViewPagerFrameworkDelegate viewPagerFrameworkDelegate = this.b.get();
            if (viewPagerFrameworkDelegate == null || viewPagerFrameworkDelegate.R() == null || viewPagerFrameworkDelegate.R().isFinishing()) {
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                this.a = true;
                j jVar = (j) message.obj;
                viewPagerFrameworkDelegate.I0(jVar.a, jVar.b, jVar.c, jVar.f67d, jVar.f68e, jVar.f69f, jVar.f70g);
                this.a = false;
                return;
            }
            if (i2 == 2) {
                viewPagerFrameworkDelegate.N(((j) message.obj).a, true);
            } else {
                if (i2 != 3) {
                    return;
                }
                if (g0.a) {
                    g0.b(ViewPagerFrameworkDelegate.s, "MSG_START_PLAYER_FRAGMENT");
                }
                viewPagerFrameworkDelegate.F0(true);
            }
        }
    }

    static {
        String name = ViewPagerFrameworkDelegate.class.getName();
        u = name + ":restore_fragmentclsls";
        v = name + ":restore_player_fragment-state";
        w = name + ":has_nav_bar";
        x = name + ":has_nav_bar_s_btns";
        y = "fragment_save_state";
        z = ViewConfiguration.getPressedStateDuration();
    }

    public ViewPagerFrameworkDelegate(FrameworkActivity frameworkActivity, i iVar) {
        this.f51e = frameworkActivity;
        this.f52f = iVar;
        e.c.a.g.a.d.v.c.d(this);
    }

    public final void A(@NonNull AbsFrameworkFragment absFrameworkFragment, FragmentViewBase fragmentViewBase, FragmentViewBase fragmentViewBase2, FragmentViewBase fragmentViewBase3, boolean z2) {
        k kVar = new k();
        AbsFrameworkFragment absFrameworkFragmentM = M(fragmentViewBase.getId());
        if (absFrameworkFragmentM != null && absFrameworkFragmentM.isAdded()) {
            fragmentViewBase.setIgnoredViews(absFrameworkFragmentM.j());
            boolean zB = absFrameworkFragmentM.B();
            boolean zA = absFrameworkFragmentM.A();
            if (!zB && !zA) {
                kVar.a = absFrameworkFragmentM;
            }
            kVar.c = absFrameworkFragmentM;
        }
        AbsFrameworkFragment absFrameworkFragmentM2 = M(fragmentViewBase2 == null ? -1 : fragmentViewBase2.getId());
        if (absFrameworkFragmentM2 != null && absFrameworkFragmentM2.isAdded()) {
            kVar.f71d = absFrameworkFragmentM2;
        }
        AbsFrameworkFragment absFrameworkFragmentM3 = M(fragmentViewBase3 != null ? fragmentViewBase3.getId() : -1);
        if (absFrameworkFragmentM3 != null && absFrameworkFragmentM3.isAdded()) {
            kVar.f73f = absFrameworkFragmentM3;
        }
        J(kVar);
        K();
        i iVar = this.f52f;
        if (iVar != null) {
            iVar.onSlideToRightCallback();
        }
    }

    public void A0(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment != null) {
            String name = absFrameworkFragment.getClass().getName();
            String strValueOf = String.valueOf(absFrameworkFragment.getId());
            this.p.remove(name);
            this.p.remove(strValueOf);
        }
    }

    public final void B(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && absFrameworkFragment.A()) {
            int iD0 = d0(absFrameworkFragment.getId()) - 1;
            if (i0(iD0)) {
                if (g0.a) {
                    j0("dispatchFragmentFinish=" + absFrameworkFragment.getClass().getSimpleName());
                }
                i iVar = this.f52f;
                if (iVar != null) {
                    iVar.onFinishFragment(iD0);
                }
            }
        }
    }

    public final void B0(AbsFrameworkFragment absFrameworkFragment, int i2) {
        if (this.f51e.isFinishing()) {
            return;
        }
        FragmentManager supportFragmentManager = this.f51e.getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        AbsFrameworkFragment absFrameworkFragmentM = M(i2);
        if (absFrameworkFragmentM != null) {
            fragmentTransactionBeginTransaction.replace(i2, absFrameworkFragment, String.valueOf(i2));
        }
        try {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        } catch (Exception unused) {
        }
        A0(absFrameworkFragmentM);
    }

    public final void C(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment == null || !absFrameworkFragment.isAdded()) {
            return;
        }
        if (g0.a) {
            j0("dispatchFragmentFirstStart=" + absFrameworkFragment.getClass().getSimpleName());
        }
        absFrameworkFragment.E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C0(@NonNull Bundle bundle) {
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(s);
        Bundle bundle2 = bundle.getBundle(u);
        if (integerArrayList != null && bundle2 != null) {
            int size = integerArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    FragmentCls fragmentCls = (FragmentCls) bundle2.getParcelable(String.valueOf(integerArrayList.get(i2).intValue()));
                    if (fragmentCls != null) {
                        fragmentCls.f56d.setClassLoader(R().getClassLoader());
                        L0(null, Class.forName(fragmentCls.a), fragmentCls.f56d, false, false, false, false, true);
                    }
                } catch (ClassNotFoundException e2) {
                    g0.k(e2);
                }
            }
        }
        this.f53g.post(new d());
    }

    public final void D(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && absFrameworkFragment.A()) {
            if (g0.a) {
                j0("dispatchFragmentPause=" + absFrameworkFragment.getClass().getSimpleName());
            }
            absFrameworkFragment.G();
        }
    }

    public void D0(AbsFrameworkFragment absFrameworkFragment, boolean z2) {
        FragmentViewBase fragmentViewBase;
        if (absFrameworkFragment == null || (fragmentViewBase = (FragmentViewBase) this.m.findViewById(absFrameworkFragment.getId())) == null) {
            return;
        }
        fragmentViewBase.setSlidingEnabled(z2);
    }

    public final void E(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && absFrameworkFragment.A()) {
            if (g0.a) {
                j0("dispatchFragmentRestart=" + absFrameworkFragment.getClass().getSimpleName());
            }
            absFrameworkFragment.I();
        }
    }

    public void E0(AbsFrameworkFragment absFrameworkFragment, boolean z2) {
        FragmentViewBase fragmentViewBase;
        if (absFrameworkFragment == null && (absFrameworkFragment = a0()) == null) {
            return;
        }
        int i2 = 0;
        for (int iU = U() - 1; iU > 0; iU--) {
            FragmentViewBase fragmentViewBaseI = this.m.i(iU);
            if (fragmentViewBaseI != null) {
                AbsFrameworkFragment absFrameworkFragmentM = M(fragmentViewBaseI.getId());
                if (fragmentViewBaseI.p || absFrameworkFragmentM == absFrameworkFragment) {
                    fragmentViewBaseI.p = false;
                    break;
                }
                i2++;
            }
        }
        if (i2 > 0) {
            FragmentViewBase fragmentViewBase2 = null;
            try {
                fragmentViewBase = (FragmentViewBase) this.m.findViewById(absFrameworkFragment.getId());
            } catch (ClassCastException unused) {
            }
            if (fragmentViewBase == null) {
                try {
                    fragmentViewBase2 = (FragmentViewBase) this.m.getChildAt(0);
                    absFrameworkFragment = a0();
                } catch (ClassCastException unused2) {
                    fragmentViewBase2 = fragmentViewBase;
                }
                fragmentViewBase = fragmentViewBase2;
            }
            if (fragmentViewBase == null) {
                IllegalStateException illegalStateException = new IllegalStateException("ViewPagerFrameworkDelegate showFragment cannot find target fragment.");
                if (g0.a) {
                    throw illegalStateException;
                }
            }
            FragmentViewBase top1stContainerView = this.m.getTop1stContainerView();
            if (top1stContainerView == null) {
                IllegalStateException illegalStateException2 = new IllegalStateException("ViewPagerFrameworkDelegate showFragment leave container is null");
                if (g0.a) {
                    throw illegalStateException2;
                }
            }
            AbsFrameworkFragment absFrameworkFragmentM2 = M(top1stContainerView.getId());
            e.c.a.g.a.d.t.b bVar = this.b;
            if (bVar != null) {
                bVar.recordChangeBefore();
            }
            this.c = absFrameworkFragment;
            MainFragmentContainer mainFragmentContainer = this.a;
            if (mainFragmentContainer != null) {
                mainFragmentContainer.B0();
            }
            e.c.a.g.a.d.t.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.recordChangeAfter();
            }
            if (absFrameworkFragmentM2 != null) {
                absFrameworkFragmentM2.setUserVisibleHint(false);
                absFrameworkFragmentM2.setMenuVisibility(false);
                absFrameworkFragmentM2.Z(true);
            }
            absFrameworkFragment.setUserVisibleHint(true);
            absFrameworkFragment.setMenuVisibility(true);
            if (z2) {
                this.m.l(top1stContainerView, fragmentViewBase);
            } else {
                fragmentViewBase.o();
                y0(fragmentViewBase, false);
            }
            e.c.a.g.a.d.t.b bVar3 = this.b;
            if (bVar3 != null) {
                bVar3.executeNavChanged();
            }
            y(absFrameworkFragment);
            i iVar = this.f52f;
            if (iVar != null) {
                iVar.onSlideToLeftCallback();
            }
            if (absFrameworkFragmentM2 != null) {
                absFrameworkFragmentM2.S(true);
            }
        }
    }

    public final void F(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && absFrameworkFragment.A()) {
            absFrameworkFragment.J();
            t = absFrameworkFragment.getClass().getName();
        }
    }

    public void F0(boolean z2) {
        N0(z2, null);
    }

    public final void G(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && absFrameworkFragment.A()) {
            absFrameworkFragment.K();
        }
    }

    public void G0(Bundle bundle) {
        try {
            M0();
        } catch (Exception unused) {
        }
        if (bundle != null) {
            C0(bundle);
        } else {
            this.f52f.onFragmentFirstStart();
        }
    }

    public final void H(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && absFrameworkFragment.A()) {
            if (g0.a) {
                j0("dispatchFragmentStop=" + absFrameworkFragment.getClass().getSimpleName());
            }
            absFrameworkFragment.L();
        }
    }

    public void H0(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle, boolean z2, boolean z3, boolean z4) {
        I0(absFrameworkFragment, cls, bundle, z2, z3, z4, false);
    }

    public final void I(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment != null && absFrameworkFragment.isAdded() && absFrameworkFragment.A()) {
            if (g0.a) {
                j0("dispatchPersistentFragmentRestart=" + absFrameworkFragment.getClass().getSimpleName());
            }
            absFrameworkFragment.O();
        }
    }

    public void I0(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        if (bundle != null) {
            try {
                z6 = bundle.getBoolean("viewpager_framework_delegate_open_two_fragment", false);
            } catch (Exception unused) {
                z6 = false;
            }
        } else {
            z6 = false;
        }
        try {
            if (this.n == 0 && !this.r) {
                if ((z6 || this.m.getScrollState() == 0) && cls != null) {
                    AbsFrameworkFragment absFrameworkFragmentV = (absFrameworkFragment == null || absFrameworkFragment.h() != 1) ? V() : absFrameworkFragment;
                    if (absFrameworkFragmentV == null) {
                        return;
                    }
                    Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                    if (x(absFrameworkFragmentV, cls, bundle2)) {
                        absFrameworkFragmentV.getArguments().putAll(bundle2);
                        absFrameworkFragmentV.N(absFrameworkFragmentV.getArguments());
                        return;
                    }
                    t = cls.getName();
                    absFrameworkFragmentV.H();
                    AbsFrameworkFragment absFrameworkFragmentL = z4 ? L(cls) : null;
                    if (absFrameworkFragmentL != null && absFrameworkFragmentL.z()) {
                        absFrameworkFragmentL.getArguments().putAll(bundle2);
                        absFrameworkFragmentL.N(bundle2);
                        E0(absFrameworkFragmentL, z2);
                        y(absFrameworkFragmentL);
                        return;
                    }
                    if (!z3) {
                        FragmentViewBase fragmentViewBaseA = this.l.get(cls.getName());
                        if (fragmentViewBaseA == null) {
                            fragmentViewBaseA = e.c.a.g.a.d.b0.c.c().a(this.f51e, cls, bundle2);
                            if (e.c.a.g.a.d.p.a.class.isAssignableFrom(cls)) {
                                this.l.put(cls.getName(), fragmentViewBaseA);
                            }
                        } else {
                            fragmentViewBaseA.o();
                            this.m.m(fragmentViewBaseA);
                        }
                        int iD0 = d0(absFrameworkFragmentV.getId());
                        if (absFrameworkFragment != null) {
                            E0(absFrameworkFragmentV, false);
                        }
                        int iU = U() - 2;
                        FragmentViewBase fragmentViewBaseI = this.m.i(iD0);
                        FragmentViewBase fragmentViewBaseI2 = this.m.i(iU);
                        this.m.g(fragmentViewBaseA);
                        if (!z2) {
                            q(absFrameworkFragmentV, cls, bundle2, fragmentViewBaseA, fragmentViewBaseI, fragmentViewBaseI2, false, z5);
                            this.m.f();
                            return;
                        }
                        u(cls.getSimpleName());
                        fragmentViewBaseA.m(this.m.getWidth(), this.m.getHeight(), bundle);
                        if (fragmentViewBaseA.i() && e.c.a.g.a.d.b0.b.b().d()) {
                            v(absFrameworkFragmentV, cls, bundle2, fragmentViewBaseA, fragmentViewBaseI, fragmentViewBaseI2, z5);
                            return;
                        } else {
                            O(absFrameworkFragmentV, cls, bundle2, fragmentViewBaseA, fragmentViewBaseI, fragmentViewBaseI2, z5);
                            return;
                        }
                    }
                    int id = absFrameworkFragmentV.getId();
                    View viewFindViewById = this.m.findViewById(id);
                    if (viewFindViewById == null) {
                        f0.h("replace mode, can not find container. targetContainerId: " + id + " stack info: " + Q());
                        return;
                    }
                    FragmentViewBase fragmentViewBase = viewFindViewById instanceof FragmentViewBase ? (FragmentViewBase) viewFindViewById : null;
                    if (fragmentViewBase == null) {
                        f0.h("replace mode, view is not FragmentViewBase. targetContainerId: " + id + " stack info: " + Q() + " view info: " + viewFindViewById.toString());
                        return;
                    }
                    E0(absFrameworkFragmentV, z2);
                    AbsFrameworkFragment absFrameworkFragmentZ = z(cls, bundle2, fragmentViewBase, z5);
                    absFrameworkFragmentZ.Y();
                    e.c.a.g.a.d.t.b bVar = this.b;
                    if (bVar != null) {
                        bVar.recordChangeBefore();
                    }
                    B0(absFrameworkFragmentZ, id);
                    this.c = absFrameworkFragmentZ;
                    MainFragmentContainer mainFragmentContainer = this.a;
                    if (mainFragmentContainer != null) {
                        mainFragmentContainer.B0();
                    }
                    e.c.a.g.a.d.t.b bVar2 = this.b;
                    if (bVar2 != null) {
                        bVar2.recordChangeAfter();
                    }
                    s(bundle2, cls.getName(), id);
                    fragmentViewBase.setIgnoredViews(absFrameworkFragmentZ.j());
                    e.c.a.g.a.d.t.b bVar3 = this.b;
                    if (bVar3 != null) {
                        bVar3.executeNavChanged();
                    }
                    y(absFrameworkFragmentZ);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public final void J(k kVar) {
        synchronized (this) {
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            this.j.add(kVar);
        }
    }

    public void J0(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle, boolean z2, boolean z3, boolean z4) {
        K0(absFrameworkFragment, cls, bundle, z2, z3, z4, false);
    }

    public final boolean K() {
        int size;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("pending action must run in main thread!");
        }
        boolean z2 = false;
        while (true) {
            synchronized (this) {
                ArrayList<k> arrayList = this.j;
                if (arrayList == null || arrayList.size() == 0) {
                    break;
                }
                size = this.j.size();
                k[] kVarArr = this.k;
                if (kVarArr == null || kVarArr.length < size) {
                    this.k = new k[size];
                }
                this.j.toArray(this.k);
                this.j.clear();
            }
            for (int i2 = size - 1; i2 >= 1; i2--) {
                AbsFrameworkFragment absFrameworkFragment = this.k[i2].f72e;
                if (absFrameworkFragment != null) {
                    int i3 = i2 - 1;
                    while (true) {
                        if (i3 >= 0) {
                            k[] kVarArr2 = this.k;
                            if (absFrameworkFragment == kVarArr2[i3].f73f) {
                                kVarArr2[i2].f72e = null;
                                kVarArr2[i3].f73f = null;
                                break;
                            }
                            i3--;
                        }
                    }
                }
            }
            for (int i4 = 0; i4 < size; i4++) {
                if (g0.a) {
                    j0("========i=" + i4 + "========");
                }
                C(this.k[i4].a);
                I(this.k[i4].b);
                F(this.k[i4].c);
                D(this.k[i4].f71d);
                G(this.k[i4].c);
                E(this.k[i4].f72e);
                H(this.k[i4].f73f);
                B(this.k[i4].f74g);
                this.k[i4] = null;
            }
            z2 = true;
        }
        return z2;
    }

    public void K0(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle, boolean z2, boolean z3, boolean z4, boolean z5) {
        L0(absFrameworkFragment, cls, bundle, z2, z3, z4, z5, false);
    }

    public AbsFrameworkFragment L(Class<? extends Fragment> cls) {
        int iU = U();
        for (int i2 = 0; i2 < iU; i2++) {
            AbsFrameworkFragment absFrameworkFragmentM = M(S(i2).getId());
            if (absFrameworkFragmentM != null && absFrameworkFragmentM.getClass().getName() == cls.getName()) {
                return absFrameworkFragmentM;
            }
        }
        return null;
    }

    public void L0(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        j jVar = new j();
        if (!this.f53g.a() || z5) {
            jVar.a = absFrameworkFragment;
            jVar.b = cls;
            jVar.c = bundle;
            jVar.f67d = z2;
            jVar.f68e = z3;
            jVar.f69f = z4;
            jVar.f70g = z6;
            this.f53g.sendMessageDelayed(this.f53g.obtainMessage(1, jVar), z);
        }
    }

    public final AbsFrameworkFragment M(int i2) {
        return (AbsFrameworkFragment) this.f51e.getSupportFragmentManager().findFragmentByTag(String.valueOf(i2));
    }

    public final void M0() {
        MainFragmentContainer mainFragmentContainer = new MainFragmentContainer();
        this.a = mainFragmentContainer;
        mainFragmentContainer.Y();
        mainFragmentContainer.setArguments(new Bundle());
        FragmentViewBase fragmentViewBaseA = e.c.a.g.a.d.b0.c.c().a(this.f51e, MainFragmentContainer.class, mainFragmentContainer.getArguments());
        fragmentViewBaseA.setId(Math.abs(mainFragmentContainer.hashCode()));
        this.m.g(fragmentViewBaseA);
        FragmentManager supportFragmentManager = this.f51e.getSupportFragmentManager();
        fragmentViewBaseA.e(mainFragmentContainer, false);
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(fragmentViewBaseA.getId(), mainFragmentContainer, String.valueOf(Math.abs(mainFragmentContainer.hashCode())));
        try {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        } catch (Exception unused) {
        }
        this.c = mainFragmentContainer;
        ViewCompat.postOnAnimation(this.m, new c(mainFragmentContainer, fragmentViewBaseA));
        y(mainFragmentContainer);
        t = MainFragmentContainer.class.getName();
    }

    public void N(AbsFrameworkFragment absFrameworkFragment, boolean z2) {
        if (absFrameworkFragment == null || this.m.getScrollState() != 0 || this.r) {
            return;
        }
        int iD0 = d0(absFrameworkFragment.getId()) - 1;
        if (i0(iD0)) {
            E0(M(T(iD0)), z2 && absFrameworkFragment.w());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N0(boolean z2, Bundle bundle) {
        try {
            Class<?> cls = Class.forName("com.kugou.android.watch.lite.component.player.NormalPlayerHolderFragment");
            Runnable runnable = this.f50d;
            if (runnable != null) {
                runnable.run();
            }
            H0(V(), cls, bundle, z2, false, false);
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    public final void O(@NonNull AbsFrameworkFragment absFrameworkFragment, @NonNull Class<? extends Fragment> cls, @NonNull Bundle bundle, @NonNull FragmentViewBase fragmentViewBase, @Nullable FragmentViewBase fragmentViewBase2, @Nullable FragmentViewBase fragmentViewBase3, boolean z2) {
        q(absFrameworkFragment, cls, bundle, fragmentViewBase, fragmentViewBase2, fragmentViewBase3, true, z2);
        this.r = true;
        this.f53g.postAtFrontOfQueue(new f(fragmentViewBase, fragmentViewBase2));
    }

    public e.c.a.g.a.d.v.b P() {
        int iU = U();
        AbsFrameworkFragment[] absFrameworkFragmentArr = new AbsFrameworkFragment[iU];
        View[] viewArr = new View[iU];
        for (int i2 = 0; i2 < iU; i2++) {
            FragmentViewBase fragmentViewBaseI = this.m.i(i2);
            viewArr[i2] = fragmentViewBaseI;
            if (fragmentViewBaseI == null) {
                absFrameworkFragmentArr[i2] = null;
            } else {
                absFrameworkFragmentArr[i2] = M(fragmentViewBaseI.getId());
            }
        }
        e.c.a.g.a.d.v.b bVar = new e.c.a.g.a.d.v.b();
        bVar.a = absFrameworkFragmentArr;
        return bVar;
    }

    public String Q() {
        StringBuilder sb = new StringBuilder();
        int iU = U();
        sb.append("size: ");
        sb.append(iU);
        sb.append(", [");
        for (int i2 = 0; i2 < iU; i2++) {
            FragmentViewBase fragmentViewBaseI = this.m.i(i2);
            if (i2 != 0) {
                sb.append(", ");
            }
            if (fragmentViewBaseI == null) {
                sb.append("(view null)");
            } else {
                AbsFrameworkFragment absFrameworkFragmentM = M(fragmentViewBaseI.getId());
                if (absFrameworkFragmentM == null) {
                    sb.append("(fragment null)");
                } else {
                    sb.append(absFrameworkFragmentM.getClass().getSimpleName());
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public FrameworkActivity R() {
        return this.f51e;
    }

    public final FragmentViewBase S(int i2) {
        return this.m.i(i2);
    }

    public final int T(int i2) {
        FragmentViewBase fragmentViewBaseS = S(i2);
        if (fragmentViewBaseS != null) {
            return fragmentViewBaseS.getId();
        }
        return -1;
    }

    public final int U() {
        FragmentStackView fragmentStackView = this.m;
        if (fragmentStackView == null) {
            return 0;
        }
        return fragmentStackView.getChildCount();
    }

    public AbsFrameworkFragment V() {
        if (this.c == null) {
            this.c = b0();
        }
        return this.c;
    }

    public Bundle W(String str) {
        FragmentCls fragmentCls;
        Bundle bundle = this.p;
        if (bundle == null || (fragmentCls = (FragmentCls) bundle.getParcelable(str)) == null) {
            return null;
        }
        Bundle bundle2 = fragmentCls.f56d.getBundle(y);
        bundle2.setClassLoader(R().getClassLoader());
        return bundle2;
    }

    public FragmentViewBase X(AbsFrameworkFragment absFrameworkFragment) {
        FragmentStackView fragmentStackView;
        if (absFrameworkFragment == null || (fragmentStackView = this.m) == null) {
            return null;
        }
        return (FragmentViewBase) fragmentStackView.findViewById(absFrameworkFragment.getId());
    }

    public AbsFrameworkFragment Y() {
        FragmentViewBase fragmentViewBaseS = S(Math.max(0, U() - 2));
        if (fragmentViewBaseS == null) {
            return null;
        }
        return M(fragmentViewBaseS.getId());
    }

    public i Z() {
        return this.f52f;
    }

    public MainFragmentContainer a0() {
        if (this.a == null) {
            this.a = (MainFragmentContainer) M(S(0).getId());
        }
        return this.a;
    }

    public final AbsFrameworkFragment b0() {
        if (this.m == null) {
            return null;
        }
        FragmentViewBase fragmentViewBaseI = this.m.i(Math.max(0, U() - 1));
        if (fragmentViewBaseI != null) {
            return M(fragmentViewBaseI.getId());
        }
        return null;
    }

    public final boolean c0() {
        synchronized (this) {
            ArrayList<k> arrayList = this.j;
            return arrayList != null && arrayList.size() > 0;
        }
    }

    public int d0(int i2) {
        int iU = U();
        for (int i3 = 0; i3 < iU; i3++) {
            if (S(i3).getId() == i2) {
                return i3;
            }
        }
        return -1;
    }

    public final void e0(FrameworkContentView frameworkContentView) {
        this.o = false;
        this.m = frameworkContentView.getContent();
        this.f53g = new l(this);
        this.m.setContainerStateListener(this.f55i);
        this.o = true;
    }

    public boolean f0() {
        return this.o;
    }

    public final boolean g0(String str) {
        return "PlayerFragment".equals(str);
    }

    public boolean h0() {
        if (V() != null) {
            return g0(V().getClass().getSimpleName());
        }
        return false;
    }

    public boolean i0(int i2) {
        int iU = U();
        return iU > 0 && i2 >= 0 && i2 < iU;
    }

    public final void j0(String str) {
        if (g0.a) {
            g0.c("playerFramework", "ViewPagerFrameworkDelegate-->log," + str);
        }
    }

    public boolean k0() {
        AbsFrameworkFragment absFrameworkFragment = this.c;
        return absFrameworkFragment != null && absFrameworkFragment == this.a;
    }

    public void l0(FrameworkContentView frameworkContentView, Bundle bundle) {
        if (bundle != null) {
            bundle.getBoolean(v);
            bundle.getBoolean(w, true);
            bundle.getBoolean(x, true);
            bundle.getInt("key_current_tab_index", 0);
            bundle.getBoolean("key_isFirstInit", true);
        }
        e0(frameworkContentView);
    }

    public final boolean m0() {
        if (c0()) {
            return false;
        }
        return t0();
    }

    public boolean n0(int i2, KeyEvent keyEvent) {
        AbsFrameworkFragment absFrameworkFragmentV = V();
        if (absFrameworkFragmentV != null && absFrameworkFragmentV.isAdded() && absFrameworkFragmentV.onKeyDown(i2, keyEvent)) {
            return true;
        }
        if (i2 != 4) {
            return false;
        }
        if (m0()) {
            this.f52f.onKeyBackSlideCallback();
        } else if (this.n == 0 && U() == 1 && !l1.n0() && !l1.b0()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f54h >= 2000 || keyEvent.getRepeatCount() != 0) {
                p1.h(this.f51e, "再按一次返回桌面");
                this.f54h = jCurrentTimeMillis;
            } else {
                if (l1.X()) {
                    return false;
                }
                try {
                    this.f51e.moveTaskToBack(true);
                } catch (NullPointerException e2) {
                    if (g0.a) {
                        f0.h("MediaActivity moveTaskToBack failed");
                    } else {
                        g0.k(e2);
                    }
                }
            }
        }
        return true;
    }

    public boolean o0(int i2, KeyEvent keyEvent) {
        AbsFrameworkFragment absFrameworkFragmentV = V();
        if (absFrameworkFragmentV == null || !absFrameworkFragmentV.isAdded()) {
            return false;
        }
        return absFrameworkFragmentV.onKeyLongPress(i2, keyEvent);
    }

    public boolean p0(int i2, int i3, KeyEvent keyEvent) {
        AbsFrameworkFragment absFrameworkFragmentV = V();
        if (absFrameworkFragmentV == null || !absFrameworkFragmentV.isAdded()) {
            return false;
        }
        return absFrameworkFragmentV.onKeyMultiple(i2, i3, keyEvent);
    }

    public final void q(@NonNull AbsFrameworkFragment absFrameworkFragment, @NonNull Class<? extends Fragment> cls, @NonNull Bundle bundle, @NonNull FragmentViewBase fragmentViewBase, @Nullable FragmentViewBase fragmentViewBase2, @Nullable FragmentViewBase fragmentViewBase3, boolean z2, boolean z3) {
        try {
            AbsFrameworkFragment absFrameworkFragmentZ = z(cls, bundle, fragmentViewBase, z3);
            if (!z2) {
                absFrameworkFragmentZ.Y();
            }
            fragmentViewBase.setId(absFrameworkFragmentZ.hashCode());
            fragmentViewBase.e(absFrameworkFragmentZ, absFrameworkFragmentZ instanceof e.c.a.g.a.d.p.a);
            e.c.a.g.a.d.t.b bVar = this.b;
            if (bVar != null) {
                bVar.recordChangeBefore();
            }
            r(absFrameworkFragmentZ, fragmentViewBase.getId());
            this.c = absFrameworkFragmentZ;
            MainFragmentContainer mainFragmentContainer = this.a;
            if (mainFragmentContainer != null) {
                mainFragmentContainer.B0();
            }
            e.c.a.g.a.d.t.b bVar2 = this.b;
            if (bVar2 != null) {
                bVar2.recordChangeAfter();
            }
            e.c.a.g.a.d.t.b bVar3 = this.b;
            if (bVar3 != null) {
                bVar3.executeNavChanged();
            }
            absFrameworkFragment.setMenuVisibility(false);
            absFrameworkFragment.setUserVisibleHint(false);
            if (!e.c.a.g.a.d.b0.b.b().d()) {
                fragmentViewBase.setEnterInfo(new FragmentViewBase.c(absFrameworkFragmentZ, fragmentViewBase, fragmentViewBase2, fragmentViewBase3, z2));
            }
            this.m.post(new g(this, absFrameworkFragment, absFrameworkFragmentZ));
            y(absFrameworkFragmentZ);
            if (!z2 || e.c.a.g.a.d.b0.b.b().d()) {
                ViewCompat.postOnAnimationDelayed(this.m, new h(absFrameworkFragmentZ, fragmentViewBase, fragmentViewBase2, fragmentViewBase3, z2), 10L);
            }
            s(absFrameworkFragmentZ.getArguments(), absFrameworkFragmentZ.getClass().getName(), absFrameworkFragmentZ.getId());
        } catch (Exception unused) {
        }
    }

    public boolean q0(int i2, KeyEvent keyEvent) {
        AbsFrameworkFragment absFrameworkFragmentV = V();
        if (absFrameworkFragmentV == null || !absFrameworkFragmentV.isAdded()) {
            return false;
        }
        return absFrameworkFragmentV.onKeyUp(i2, keyEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(AbsFrameworkFragment absFrameworkFragment, int i2) {
        if (this.f51e.isFinishing()) {
            return;
        }
        FragmentManager supportFragmentManager = this.f51e.getSupportFragmentManager();
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        if (M(absFrameworkFragment.getId()) == null) {
            fragmentTransactionBeginTransaction.add(i2, absFrameworkFragment, String.valueOf(i2));
        }
        try {
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        } catch (Exception unused) {
        }
        if (absFrameworkFragment instanceof e.c.a.g.a.d.p.a) {
            ((e.c.a.g.a.d.p.a) absFrameworkFragment).onFragmentAddToShow();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r0(Intent intent) {
        String stringExtra;
        if (intent == null || (stringExtra = intent.getStringExtra("key_fragment_class_full_name")) == null) {
            return;
        }
        try {
            e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.ACTION_DISMISS_DIALOG"));
            Class<?> cls = Class.forName(stringExtra);
            Bundle bundleExtra = intent.getBundleExtra("key_fragment_args");
            this.f51e.onNewBundle(bundleExtra);
            H0(null, cls, bundleExtra, false, false, false);
        } catch (Exception unused) {
        }
    }

    public final void s(Bundle bundle, String str, int i2) {
        FragmentCls fragmentClsA = FragmentCls.a();
        fragmentClsA.f56d = bundle;
        fragmentClsA.a = str;
        fragmentClsA.b = Integer.valueOf(i2);
        this.p.putParcelable(String.valueOf(i2), fragmentClsA);
        if (g0.a) {
            g0.b("ocean-restore", ViewPagerFrameworkDelegate.class.getSimpleName() + ".addSaveFragmentBundle()--");
        }
        w(str);
    }

    public void s0(Bundle bundle) {
        int iU = U();
        if (iU > 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < iU; i2++) {
                View childAt = this.m.getChildAt(i2);
                if (childAt != null) {
                    arrayList.add(Integer.valueOf(childAt.getId()));
                }
            }
            bundle.putIntegerArrayList(s, arrayList);
        }
        if (a0() != null) {
            bundle.putInt("key_current_tab_index", a0().r());
        }
        bundle.putBoolean(v, h0());
        bundle.putBundle(u, this.p);
        bundle.putBoolean(w, V() == null || V().x());
        bundle.putBoolean(x, k0());
        bundle.putBoolean("key_isFirstInit", false);
        bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, null);
        bundle.putParcelable("android:fragments", null);
        if (g0.a) {
            g0.b("ocean", ViewPagerFrameworkDelegate.class.getSimpleName() + ".onSaveInstanceState()-mSaveFragmentCls-" + bundle);
        }
    }

    public final void t(String str) {
        if (g0.f()) {
            g0.e("FrameworkDelegate", String.format(Locale.getDefault(), "%s : %d ms", str, Long.valueOf(SystemClock.elapsedRealtime() - this.q)));
        }
    }

    public boolean t0() {
        if (this.m.getScrollState() != 0 || this.r) {
            return true;
        }
        FragmentViewBase top1stContainerView = this.m.getTop1stContainerView();
        FragmentViewBase top2ndContainerView = this.m.getTop2ndContainerView();
        if (top1stContainerView != null && top2ndContainerView != null) {
            AbsFrameworkFragment absFrameworkFragmentM = M(top1stContainerView.getId());
            AbsFrameworkFragment absFrameworkFragmentM2 = M(top2ndContainerView.getId());
            if (absFrameworkFragmentM != null && absFrameworkFragmentM2 != null) {
                E0(absFrameworkFragmentM2, absFrameworkFragmentM.w());
                return true;
            }
        }
        return false;
    }

    public final void u(String str) {
        if (g0.f()) {
            this.q = SystemClock.elapsedRealtime();
        }
    }

    public void u0(Bundle bundle, int i2) {
        Bundle bundle2 = this.p;
        if (bundle2 != null) {
            FragmentCls fragmentCls = (FragmentCls) bundle2.getParcelable(String.valueOf(i2));
            if (fragmentCls != null) {
                if (fragmentCls.f56d == null) {
                    fragmentCls.f56d = new Bundle();
                }
                fragmentCls.f56d.putBundle(y, bundle);
            }
            this.p.putParcelable(String.valueOf(i2), fragmentCls);
        }
        w("newFragment");
    }

    public final void v(@NonNull AbsFrameworkFragment absFrameworkFragment, @NonNull Class<? extends Fragment> cls, @NonNull Bundle bundle, @NonNull FragmentViewBase fragmentViewBase, @Nullable FragmentViewBase fragmentViewBase2, @Nullable FragmentViewBase fragmentViewBase3, boolean z2) {
        this.m.e(fragmentViewBase, fragmentViewBase2);
        this.m.post(new e(absFrameworkFragment, cls, bundle, fragmentViewBase, fragmentViewBase2, fragmentViewBase3, z2));
    }

    public void v0(Bundle bundle, int i2, String str) {
        if (this.p != null) {
            FragmentCls fragmentCls = new FragmentCls((a) null);
            Bundle bundle2 = new Bundle();
            fragmentCls.f56d = bundle2;
            bundle2.putBundle(y, bundle);
            fragmentCls.b = Integer.valueOf(i2);
            fragmentCls.a = str;
            this.p.putParcelable(str, fragmentCls);
        }
        w(str);
    }

    public final void w(String str) {
        int i2;
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        if (this.p == null) {
            i2 = 0;
        } else {
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeBundle(this.p);
            int iDataSize = parcelObtain.dataSize();
            parcelObtain.recycle();
            i2 = iDataSize;
        }
        if (i2 >= 409600) {
            this.p.keySet();
            this.p.clear();
        }
    }

    public void w0(AbsFrameworkFragment absFrameworkFragment) {
        if (absFrameworkFragment == null) {
            return;
        }
        int id = absFrameworkFragment.getId();
        z0(absFrameworkFragment);
        View viewFindViewById = this.m.findViewById(id);
        if (viewFindViewById instanceof FragmentViewBase) {
            this.m.m((FragmentViewBase) viewFindViewById);
        }
    }

    public final boolean x(AbsFrameworkFragment absFrameworkFragment, Class<? extends Fragment> cls, Bundle bundle) {
        if (absFrameworkFragment != null && cls != null) {
            if (g0.a) {
                j0("compareFragment--target=" + absFrameworkFragment.getClass().getName() + "\tsource.getName()=" + cls.getName());
            }
            if (absFrameworkFragment.getClass().getName() == cls.getName()) {
                if (bundle == null) {
                    return true;
                }
                try {
                    return !bundle.getBoolean("flag_new_instance");
                } catch (RuntimeException e2) {
                    if (g0.a) {
                        throw e2;
                    }
                    g0.k(e2);
                    return true;
                }
            }
        }
        return false;
    }

    public void x0(AbsFrameworkFragment absFrameworkFragment, int i2) {
        this.f53g.postDelayed(new b(absFrameworkFragment), i2);
    }

    public final void y(AbsFrameworkFragment absFrameworkFragment) {
        FragmentStackView fragmentStackView;
        FragmentViewBase fragmentViewBase;
        if (absFrameworkFragment == null || (fragmentStackView = this.m) == null || (fragmentViewBase = (FragmentViewBase) fragmentStackView.findViewById(absFrameworkFragment.getId())) == null) {
            return;
        }
        fragmentViewBase.setSlidingEnabled(absFrameworkFragment.d());
    }

    public final boolean y0(FragmentViewBase fragmentViewBase, boolean z2) {
        FragmentViewBase fragmentViewBaseI;
        FragmentViewBase top1stContainerView = this.m.getTop1stContainerView();
        if (top1stContainerView != null && fragmentViewBase != null) {
            AbsFrameworkFragment absFrameworkFragmentM = M(top1stContainerView.getId());
            AbsFrameworkFragment absFrameworkFragmentM2 = M(fragmentViewBase.getId());
            if (absFrameworkFragmentM != null && absFrameworkFragmentM2 != null) {
                ArrayList<AbsFrameworkFragment> arrayList = new ArrayList();
                for (int childCount = this.m.getChildCount() - 1; childCount > 0; childCount--) {
                    FragmentViewBase fragmentViewBaseI2 = this.m.i(childCount);
                    if (fragmentViewBaseI2 == fragmentViewBase) {
                        break;
                    }
                    AbsFrameworkFragment absFrameworkFragmentM3 = M(fragmentViewBaseI2.getId());
                    arrayList.add(absFrameworkFragmentM3);
                    k kVar = new k();
                    if (absFrameworkFragmentM.isAdded()) {
                        kVar.f71d = absFrameworkFragmentM3;
                        kVar.f73f = absFrameworkFragmentM3;
                        kVar.f74g = absFrameworkFragmentM3;
                    }
                    J(kVar);
                }
                if (arrayList.size() > 1) {
                    k kVar2 = new k();
                    kVar2.f72e = absFrameworkFragmentM2;
                    J(kVar2);
                }
                k kVar3 = new k();
                if (absFrameworkFragmentM2.isAdded()) {
                    fragmentViewBase.setIgnoredViews(absFrameworkFragmentM2.j());
                    boolean zB = absFrameworkFragmentM2.B();
                    boolean zA = absFrameworkFragmentM2.A();
                    if (!zB && !zA) {
                        kVar3.a = absFrameworkFragmentM2;
                    }
                    kVar3.c = absFrameworkFragmentM2;
                }
                int iIndexOfChild = this.m.indexOfChild(fragmentViewBase) - 1;
                if (iIndexOfChild >= 0 && (fragmentViewBaseI = this.m.i(iIndexOfChild)) != null) {
                    kVar3.f72e = M(fragmentViewBaseI.getId());
                }
                if (absFrameworkFragmentM.isAdded()) {
                    absFrameworkFragmentM.R(true);
                }
                J(kVar3);
                K();
                for (AbsFrameworkFragment absFrameworkFragment : arrayList) {
                    if (absFrameworkFragment != null) {
                        int id = absFrameworkFragment.getId();
                        z0(absFrameworkFragment);
                        FragmentStackView fragmentStackView = this.m;
                        fragmentStackView.m((FragmentViewBase) fragmentStackView.findViewById(id));
                    }
                }
                fragmentViewBase.o();
                return true;
            }
        }
        return false;
    }

    public final AbsFrameworkFragment z(@NonNull Class<? extends Fragment> cls, @NonNull Bundle bundle, @NonNull FragmentViewBase fragmentViewBase, boolean z2) throws IllegalAccessException, InstantiationException {
        AbsFrameworkFragment absFrameworkFragmentM = M(fragmentViewBase.getId());
        if (absFrameworkFragmentM == null || !e.c.a.g.a.d.p.a.class.isAssignableFrom(cls)) {
            absFrameworkFragmentM = (AbsFrameworkFragment) cls.newInstance();
            absFrameworkFragmentM.U(this.f51e);
            absFrameworkFragmentM.setArguments(bundle);
            absFrameworkFragmentM.D();
        } else {
            absFrameworkFragmentM.Z(false);
            if (absFrameworkFragmentM.getArguments() != null) {
                absFrameworkFragmentM.getArguments().putAll(bundle);
            } else {
                absFrameworkFragmentM.setArguments(bundle);
            }
            k kVar = new k();
            kVar.b = absFrameworkFragmentM;
            J(kVar);
            K();
        }
        absFrameworkFragmentM.X(z2);
        return absFrameworkFragmentM;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z0(com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment r5) {
        /*
            r4 = this;
            com.kugou.android.watch.lite.base.activity.FrameworkActivity r0 = r4.f51e
            boolean r0 = r0.isFinishing()
            if (r0 == 0) goto L9
            return
        L9:
            com.kugou.android.watch.lite.base.activity.FrameworkActivity r0 = r4.f51e
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r1 = r0.beginTransaction()
            boolean r2 = r5 instanceof e.c.a.g.a.d.p.a
            if (r2 == 0) goto L24
            r2 = r5
            e.c.a.g.a.d.p.a r2 = (e.c.a.g.a.d.p.a) r2
            boolean r3 = r2.canDestroy()
            if (r3 != 0) goto L24
            r2.onFragmentRemoveToHide()
            goto L27
        L24:
            r1.remove(r5)
        L27:
            r1.commitAllowingStateLoss()     // Catch: java.lang.Exception -> L2d
            r0.executePendingTransactions()     // Catch: java.lang.Exception -> L2d
        L2d:
            r4.A0(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate.z0(com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment):void");
    }
}
