package com.kugou.android.watch.lite.base.fragment;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.widget.loading.CommonLoadingView;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import f.s;
import f.u.m;
import f.z.c.p;
import f.z.d.j;
import f.z.d.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public abstract class DelegateListFragment<T, E> extends DelegateFragment {
    public int A = 1;
    public RecyclerView.OnScrollListener B;
    public Subscription C;
    public View.OnClickListener D;
    public e.c.a.g.a.g.j.d.b E;
    public ScrollView F;
    public CommonLoadingView G;
    public View r;
    public View s;
    public View t;
    public TextView u;
    public View v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DelegateListFragment<T, E> a;

        public a(DelegateListFragment<T, E> delegateListFragment) {
            this.a = delegateListFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            View.OnClickListener onClickListener = this.a.D;
            if (onClickListener == null) {
                return;
            }
            onClickListener.onClick(view);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DelegateListFragment<T, E> a;

        public b(DelegateListFragment<T, E> delegateListFragment) {
            this.a = delegateListFragment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (u0.m(this.a.getContext())) {
                this.a.z = true;
                this.a.q1();
            }
        }
    }

    public static final class c extends RecyclerView.OnScrollListener {
        public final /* synthetic */ DelegateListFragment<T, E> a;

        public c(DelegateListFragment<T, E> delegateListFragment) {
            this.a = delegateListFragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            j.e(recyclerView, "recyclerView");
            if (this.a.W0() && i2 == 0) {
                this.a.H1(recyclerView);
            }
        }
    }

    public static final class d extends k implements p<Float, Float, s> {
        public final /* synthetic */ KGRecyclerView a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DelegateListFragment<T, E> f35d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(KGRecyclerView kGRecyclerView, int i2, DelegateListFragment<T, E> delegateListFragment) {
            super(2);
            this.a = kGRecyclerView;
            this.b = i2;
            this.f35d = delegateListFragment;
        }

        public final void a(float f2, float f3) {
            this.a.scrollBy(0, f3 > 0.0f ? -this.b : this.b);
            if (this.f35d.Y0(this.a)) {
                this.f35d.g1();
            }
        }

        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ s invoke(Float f2, Float f3) {
            a(f2.floatValue(), f3.floatValue());
            return s.a;
        }
    }

    public static final class e<T> implements Action1 {
        public final /* synthetic */ DelegateListFragment<T, E> a;
        public final /* synthetic */ boolean b;

        public e(DelegateListFragment<T, E> delegateListFragment, boolean z) {
            this.a = delegateListFragment;
            this.b = z;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<T> cVar) {
            this.a.v1(false);
            this.a.h1();
            DelegateListFragment<T, E> delegateListFragment = this.a;
            delegateListFragment.r1(delegateListFragment.E0() + 1);
            this.a.N0(r0.E0() - 1);
            DelegateListFragment<T, E> delegateListFragment2 = this.a;
            j.d(cVar, "response");
            delegateListFragment2.P0(cVar, this.b);
            this.a.p1(cVar, this.b);
            if (cVar.f() || !l0.g(this.a.I0(this.b, cVar)) || TextUtils.isEmpty(cVar.c())) {
                this.a.M0(cVar, this.b);
            } else {
                this.a.O0(this.b, new Exception(cVar.c()));
            }
            this.a.n1(cVar);
        }
    }

    public static final class f<T> implements Action1 {
        public final /* synthetic */ DelegateListFragment<T, E> a;
        public final /* synthetic */ boolean b;

        public f(DelegateListFragment<T, E> delegateListFragment, boolean z) {
            this.a = delegateListFragment;
            this.b = z;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            DelegateListFragment<T, E> delegateListFragment = this.a;
            boolean z = this.b;
            j.d(th, "throwable");
            delegateListFragment.O0(z, th);
            this.a.v1(false);
            this.a.l1(th, 12);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void A0(DelegateListFragment delegateListFragment, KGRecyclerView kGRecyclerView, RecyclerView.LayoutManager layoutManager, KGRecyclerView.a aVar, List list, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configRv");
        }
        if ((i2 & 8) != 0) {
            list = m.d();
        }
        delegateListFragment.z0(kGRecyclerView, layoutManager, aVar, list);
    }

    public static /* synthetic */ void C0(DelegateListFragment delegateListFragment, boolean z, Throwable th, Integer num, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: errorReport");
        }
        if ((i2 & 4) != 0) {
            num = 1;
        }
        delegateListFragment.B0(z, th, num);
    }

    public final void A1() {
        View view = this.r;
        if (view != null) {
            view.setVisibility(0);
        }
        if (Build.VERSION.SDK_INT < 24) {
            View view2 = this.r;
            View viewFindViewById = view2 == null ? null : view2.findViewById(R.id.progress_info);
            if (viewFindViewById instanceof CommonLoadingView) {
                ((CommonLoadingView) viewFindViewById).getLoadingPresenter().startAnim();
            }
        }
    }

    public void B0(boolean z, Throwable th, Integer num) {
        j.e(th, "throwable");
    }

    public final void B1() {
        View view = this.t;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public final void C1() {
        TextView textView = this.u;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public abstract e.c.a.g.a.f.o.h.a<E> D0();

    public void D1() {
        y0();
        d1();
        w1();
        S0();
        T0();
        U0();
        T0();
        R0();
    }

    public final int E0() {
        return this.A;
    }

    public final void E1() {
        if (l0.g(D0().i())) {
            w1();
            S0();
            T0();
            R0();
            D0().notifyDataSetChanged();
        }
    }

    public int F0() {
        return R.layout.comm_empty_view;
    }

    public final void F1() {
        Q0();
        B1();
    }

    public abstract String G0();

    public void G1() {
        Q0();
        S0();
        T0();
        C1();
        T0();
    }

    public float H0() {
        return 14.0f;
    }

    public final void H1(RecyclerView recyclerView) {
        if (recyclerView != null && Y0(recyclerView)) {
            g1();
        }
    }

    public abstract List<E> I0(boolean z, e.c.a.g.a.f.k.c<T> cVar);

    public void I1() {
    }

    public String J0() {
        return "我也是有底线的~";
    }

    public Integer K0() {
        return Integer.valueOf(R.layout.kg_young_no_more_layout);
    }

    public final ScrollView L0() {
        return this.F;
    }

    public void M0(e.c.a.g.a.f.k.c<T> cVar, boolean z) {
        j.e(cVar, "response");
    }

    public void N0(int i2) {
    }

    public void O0(boolean z, Throwable th) {
        j.e(th, "throwable");
        Q0();
        S0();
        u1(false);
        String strB = e.c.a.g.a.f.k.k.f.b(th, "加载失败");
        if (!l0.g(D0().i())) {
            C1();
            t1(true);
            p1.h(getContext(), strB);
        } else {
            TextView textView = this.u;
            if (textView != null) {
                textView.setText(strB);
            }
            G1();
            t1(false);
        }
    }

    public void P0(e.c.a.g.a.f.k.c<T> cVar, boolean z) {
        j.e(cVar, "response");
        Q0();
        S0();
        u1(false);
        ArrayList arrayList = new ArrayList();
        List<E> listI0 = I0(z, cVar);
        this.x = cVar.e();
        if (listI0 != null && Boolean.valueOf(!listI0.isEmpty()).booleanValue()) {
            for (T t : listI0) {
                if (t != null) {
                    arrayList.add(t);
                }
            }
            if (!z && !D0().j()) {
                D0().h();
            }
            D0().f(arrayList);
            D0().notifyDataSetChanged();
            f1(arrayList, z);
            e1(cVar, z);
        }
        I1();
        if (this.x) {
            j.d(D0().i(), "getAdapter().datas");
            if (!r6.isEmpty()) {
                t1(false);
                F1();
                return;
            }
        }
        if (this.x && D0().i().isEmpty()) {
            t1(false);
            y1();
            return;
        }
        t1(true);
        if (this.x || !D0().i().isEmpty()) {
            return;
        }
        Z0(true);
    }

    public final void Q0() {
        View view = this.s;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void R0() {
        View view = this.v;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void S0() {
        View view = this.r;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void T0() {
        View view = this.t;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void U0() {
        TextView textView = this.u;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public final void V0(KGRecyclerView kGRecyclerView) {
        ViewGroup viewGroup = (ViewGroup) l0();
        if ((viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout) || (viewGroup instanceof ConstraintLayout)) {
            View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.layout_rotary_keypad_holder, viewGroup, false);
            this.F = (ScrollView) viewInflate;
            viewGroup.addView(viewInflate, 0);
            int iC = l1.c(7.0f);
            j.d(viewInflate, "scrollHolder");
            e.c.a.g.a.g.j.d.b bVar = new e.c.a.g.a.g.j.d.b(viewInflate);
            bVar.m(new d(kGRecyclerView, iC, this));
            s sVar = s.a;
            this.E = bVar;
        }
    }

    public final boolean W0() {
        return this.y;
    }

    public final boolean X0() {
        return this.x;
    }

    public boolean Y0(RecyclerView recyclerView) {
        j.e(recyclerView, "recyclerView");
        if (this.w || !(recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        return linearLayoutManager.findLastVisibleItemPosition() >= linearLayoutManager.getItemCount() + (-4);
    }

    public final void Z0(boolean z) {
        if (this.x || this.w) {
            return;
        }
        if (z) {
            A1();
        }
        m1();
        boolean zN = u0.n(getActivity(), false);
        if (l0.g(D0().i()) && !zN && a1()) {
            G1();
            if (this.A == 1) {
                B0(z, new Throwable("网络异常"), 4);
                return;
            }
            return;
        }
        this.w = true;
        E1();
        t1(false);
        i1.a(this.C);
        this.C = o1(this.A).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, z), new f(this, z));
    }

    public boolean a1() {
        return true;
    }

    public boolean b1() {
        return false;
    }

    public boolean c1() {
        return true;
    }

    public final void d1() {
        D0().notifyDataSetChanged();
    }

    public void e1(e.c.a.g.a.f.k.c<T> cVar, boolean z) {
        j.e(cVar, "response");
    }

    public void f1(List<? extends E> list, boolean z) {
        j.e(list, "newAddedData");
    }

    public final void g1() {
        if (!a1() || u0.n(getActivity(), false)) {
            Z0(true);
        }
    }

    public void h1() {
    }

    public void i1() {
    }

    public final void j1() {
        k1(false);
    }

    public final void k1(boolean z) {
        if (getContext() == null) {
            return;
        }
        if (!u0.n(getContext(), false) && a1()) {
            G1();
            B0(false, new Throwable("网络异常"), 5);
            return;
        }
        if (c1()) {
            D1();
        }
        this.A = 1;
        this.x = false;
        Z0(false);
    }

    public void l1(Throwable th, Integer num) {
    }

    public void m1() {
    }

    public void n1(e.c.a.g.a.f.k.c<T> cVar) {
    }

    public abstract Observable<e.c.a.g.a.f.k.c<T>> o1(int i2);

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        w0();
        e.c.a.g.a.g.j.d.b bVar = this.E;
        if (bVar == null) {
            return;
        }
        bVar.i();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        CommonLoadingView commonLoadingView;
        super.onDestroyView();
        if (!b1() || (commonLoadingView = this.G) == null || commonLoadingView == null) {
            return;
        }
        commonLoadingView.c();
    }

    public void p1(e.c.a.g.a.f.k.c<T> cVar, boolean z) {
        j.e(cVar, "response");
    }

    public void q1() {
        k1(true);
    }

    public final void r1(int i2) {
        this.A = i2;
    }

    public final void s1(boolean z) {
        this.y = z;
    }

    public final void t1(boolean z) {
        s1(z);
    }

    public final void u1(boolean z) {
        this.w = z;
    }

    public final void v1(boolean z) {
        this.w = z;
    }

    public final void w0() {
        i1.a(this.C);
    }

    public final void w1() {
        View view = this.s;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public final void x0() {
        i1.a(this.C);
    }

    public void x1() {
        Q0();
        S0();
        U0();
        T0();
        R0();
        if (this.x) {
            B1();
        } else {
            T0();
        }
    }

    public final void y0() {
        D0().h();
    }

    public void y1() {
        Q0();
        S0();
        T0();
        U0();
        T0();
        z1();
    }

    public final void z0(KGRecyclerView kGRecyclerView, RecyclerView.LayoutManager layoutManager, KGRecyclerView.a aVar, List<? extends View> list) {
        View viewInflate;
        View viewFindViewById;
        View view;
        j.e(kGRecyclerView, "rv");
        j.e(layoutManager, "manager");
        j.e(aVar, "adapter");
        j.e(list, "headers");
        kGRecyclerView.setHasFixedSize(true);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.comm_footer_loading, (ViewGroup) null);
        this.r = viewInflate2.findViewById(R.id.progress_footer);
        S0();
        View viewInflate3 = layoutInflaterFrom.inflate(R.layout.comm_progress_dialog, (ViewGroup) null);
        this.s = viewInflate3.findViewById(R.id.loading_view_layout);
        if (b1() && (view = this.s) != null) {
            if ((view == null ? null : view.findViewById(R.id.loading_view)) != null) {
                View view2 = this.s;
                if ((view2 == null ? null : view2.findViewById(R.id.loading_view)) instanceof CommonLoadingView) {
                    View view3 = this.s;
                    View viewFindViewById2 = view3 == null ? null : view3.findViewById(R.id.loading_view);
                    CommonLoadingView commonLoadingView = viewFindViewById2 instanceof CommonLoadingView ? (CommonLoadingView) viewFindViewById2 : null;
                    this.G = commonLoadingView;
                    if (commonLoadingView != null) {
                        commonLoadingView.setNeedControlAnim(true);
                    }
                }
            }
        }
        Q0();
        Integer numK0 = K0();
        if (numK0 != null) {
            viewInflate = layoutInflaterFrom.inflate(numK0.intValue(), (ViewGroup) null);
            this.t = viewInflate.findViewById(R.id.no_more_layout);
            TextView textView = (TextView) viewInflate.findViewById(R.id.no_more_tv);
            textView.setText(J0());
            textView.setOnClickListener(new a(this));
            T0();
        } else {
            viewInflate = null;
        }
        View viewInflate4 = layoutInflaterFrom.inflate(R.layout.comm_loading_failed, (ViewGroup) null);
        this.u = (TextView) viewInflate4.findViewById(R.id.common_refresh);
        if (viewInflate4 != null && (viewFindViewById = viewInflate4.findViewById(R.id.common_refresh)) != null) {
            viewFindViewById.setOnClickListener(new b(this));
        }
        U0();
        View viewInflate5 = layoutInflaterFrom.inflate(F0(), (ViewGroup) null, false);
        this.v = viewInflate5;
        TextView textView2 = viewInflate5 != null ? (TextView) viewInflate5.findViewById(R.id.common_empty) : null;
        Objects.requireNonNull(textView2, "null cannot be cast to non-null type android.widget.TextView");
        textView2.setText(G0());
        textView2.setTextSize(1, H0());
        R0();
        this.B = new c(this);
        kGRecyclerView.setLayoutManager(layoutManager);
        kGRecyclerView.setAdapter(aVar);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            kGRecyclerView.d((View) it.next());
        }
        RecyclerView.OnScrollListener onScrollListener = this.B;
        if (onScrollListener != null) {
            kGRecyclerView.addOnScrollListener(onScrollListener);
        }
        if (viewInflate3 != null) {
            kGRecyclerView.d(viewInflate3);
        }
        if (viewInflate4 != null) {
            kGRecyclerView.d(viewInflate4);
        }
        View view4 = this.v;
        if (view4 != null) {
            kGRecyclerView.d(view4);
        }
        if (viewInflate2 != null) {
            kGRecyclerView.c(viewInflate2);
        }
        if (viewInflate != null) {
            kGRecyclerView.c(viewInflate);
        }
        if (l1.f0()) {
            V0(kGRecyclerView);
        }
    }

    public final void z1() {
        View view = this.v;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }
}
