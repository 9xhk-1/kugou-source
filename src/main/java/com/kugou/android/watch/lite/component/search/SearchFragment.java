package com.kugou.android.watch.lite.component.search;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateListFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.CExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.common.apm.sdk.ApmDataTypeID;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public class SearchFragment extends DelegateListFragment<List<KGSong>, KGSong> implements View.OnClickListener {
    public View H;
    public EditText I;
    public TextView J;
    public ImageView K;
    public LinearLayout L;
    public KGRecyclerView M;
    public n N;
    public e.c.a.g.a.g.o.e P;
    public final e.c.a.g.a.g.o.d O = new e.c.a.g.a.g.o.d();
    public String Q = "";
    public String R = "2";
    public boolean S = false;
    public boolean T = e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.K2, true);
    public String U = "搜索页面";
    public int V = 5;
    public final e.c.a.g.a.k.d.a W = new e.c.a.g.a.k.d.a(ApmDataTypeID.SEARCH_LIST_REPORT);
    public final View.OnClickListener X = new k();

    /* JADX INFO: loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchFragment.this.W1(this.a);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class b implements Func1<e.c.a.g.a.g.o.g, e.c.a.g.a.f.k.c<List<KGSong>>> {
        public b(SearchFragment searchFragment) {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.c.a.g.a.f.k.c<List<KGSong>> call(e.c.a.g.a.g.o.g gVar) {
            e.c.a.g.a.f.k.c<List<KGSong>> cVar = new e.c.a.g.a.f.k.c<>();
            cVar.h(gVar.g());
            cVar.m(gVar.a() ? 1 : 0);
            if (!gVar.a()) {
                cVar.i(gVar.e());
            }
            ArrayList<e.c.a.g.a.g.o.h> arrayListF = gVar.f();
            int i2 = 0;
            if (arrayListF != null) {
                ArrayList arrayList = new ArrayList(arrayListF.size());
                int i3 = 0;
                while (i2 < arrayListF.size()) {
                    arrayList.add(arrayListF.get(i2).a());
                    i2++;
                    i3 = 1;
                }
                cVar.g(arrayList);
                i2 = i3;
            }
            if (i2 == 0 && !gVar.a()) {
                cVar.h(true);
            }
            return cVar;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class c implements Func1<String, e.c.a.g.a.g.o.g> {
        public final /* synthetic */ int a;

        public c(int i2) {
            this.a = i2;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.c.a.g.a.g.o.g call(String str) {
            if (!e.c.a.g.a.g.o.i.a.b().c(str)) {
                return e.c.a.g.a.g.o.f.d(SearchFragment.this.Q, this.a, SearchFragment.this.p(), e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.G1, 0), true, false, "", SearchFragment.this.m());
            }
            e.c.a.g.a.g.o.g gVar = new e.c.a.g.a.g.o.g();
            gVar.d(true);
            gVar.j(true);
            return gVar;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchFragment.this.P.notifyDataSetChanged();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SearchFragment.this.I.isFocusable()) {
                return;
            }
            SearchFragment.this.I.setFocusable(true);
            SearchFragment.this.I.setFocusableInTouchMode(true);
            SearchFragment.this.I.requestFocus();
            l1.t0(SearchFragment.this.I);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.c.a.g.a.j.a.c().f("search", SearchFragment.this.getActivity());
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class g implements e.c.a.g.a.s.y1.a<String> {
        public g() {
        }

        @Override // e.c.a.g.a.s.y1.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCall(String str) {
            SearchFragment.this.I.setText(str);
            SearchFragment.this.V1(false);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 3) {
                return false;
            }
            SearchFragment.this.V1(false);
            return true;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class i implements View.OnKeyListener {
        public i() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (i2 != 111 && i2 != 66) {
                return false;
            }
            SearchFragment.this.V1(false);
            return true;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchFragment.this.V1(false);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(view instanceof TextView) || u1.i(view)) {
                return;
            }
            SearchFragment.this.I.setText(((TextView) view).getText().toString());
            Editable text = SearchFragment.this.I.getText();
            Selection.setSelection(text, text.length());
            SearchFragment.this.V1(true);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class l implements Runnable {
        public final /* synthetic */ String a;

        public l(SearchFragment searchFragment, String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c.a.g.a.e.b.b(new YoungBITask(20591, "click").setType("取消").setSvar1(this.a));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public class m implements Runnable {
        public final /* synthetic */ String a;

        public m(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchFragment.this.O.b();
            SearchFragment.this.L.removeAllViews();
            u1.e(SearchFragment.this.J, SearchFragment.this.K);
            p1.h(KGApplication.getContext(), "删除成功");
            e.c.a.g.a.e.b.b(new YoungBITask(20591, "click").setType("删除").setSvar1(this.a));
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static class n extends BroadcastReceiver {
        public final WeakReference<SearchFragment> a;

        public n(SearchFragment searchFragment) {
            this.a = new WeakReference<>(searchFragment);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SearchFragment searchFragment = this.a.get();
            if (searchFragment == null || !searchFragment.z()) {
                return;
            }
            searchFragment.c2(intent);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public e.c.a.g.a.f.o.h.a<KGSong> D0() {
        return this.P;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void D1() {
        u1.e(this.J, this.L);
        super.D1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public String G0() {
        return "暂时没有内容哦";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public List<KGSong> I0(boolean z, e.c.a.g.a.f.k.c<List<KGSong>> cVar) {
        return cVar.a();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void I1() {
        this.W.j();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void L() {
        super.L();
        if (l1.c0()) {
            l1.J(getContext(), this.I);
        }
    }

    public final void T1() {
        x0();
        G1();
    }

    public final void U1() {
        String strValueOf = String.valueOf(this.O.c().size());
        e.c.a.g.a.g.o.c cVar = new e.c.a.g.a.g.o.c(requireActivity());
        cVar.b(new m(strValueOf));
        cVar.a(new l(this, strValueOf));
        cVar.show();
        e.c.a.g.a.e.b.b(new YoungBITask(20590, "click").setSvar1(strValueOf));
    }

    public final void V1(boolean z) {
        l1.J(this.I.getContext(), this.I);
        X1();
        if (u0.m(getContext())) {
            u0.d(getContext(), new a(z));
        } else {
            T1();
        }
    }

    public final void W1(boolean z) {
        if (!u0.m(getContext())) {
            T1();
            return;
        }
        String string = this.I.getText().toString();
        if (TextUtils.isEmpty(string) || h1.m(string)) {
            T1();
            this.Q = "";
            this.P.h();
            this.P.notifyDataSetChanged();
            y1();
            e2();
            return;
        }
        this.Q = string;
        g2(string);
        this.S = false;
        if (z) {
            e.c.a.g.a.e.b.b(new YoungBITask(5006, "click").setKw1(string));
        }
        f2();
        j1();
    }

    public final void X1() {
        View view;
        if (!l1.f0() || (view = getView()) == null) {
            return;
        }
        view.requestFocus();
    }

    public void Y1() {
        Deque<String> dequeC = this.O.c();
        Iterator<String> it = dequeC.iterator();
        while (it.hasNext()) {
            b2(it.next(), false);
        }
        if (dequeC.isEmpty()) {
            u1.e(this.J, this.K, this.L);
        } else {
            X1();
            u1.p(this.J, this.K, this.L);
        }
        u1.e(this.M, L0());
    }

    public final void Z1() {
        if (l1.m0()) {
            this.I.setOnClickListener(new e());
        }
        if (e.c.a.g.a.j.a.c().b()) {
            this.I.setFocusable(false);
            this.I.setFocusableInTouchMode(false);
            this.I.setOnClickListener(new f());
            e.c.a.g.a.j.a.c().a("search", new g());
        }
        this.I.setOnEditorActionListener(new h());
        this.I.setOnKeyListener(new i());
        this.H.setOnClickListener(new j());
    }

    public final void a2(View view) {
        this.H = view.findViewById(R.id.search_bar_button);
        this.I = (EditText) view.findViewById(R.id.search_bar_edit);
        this.J = (TextView) view.findViewById(R.id.search_history_title);
        this.K = (ImageView) view.findViewById(R.id.search_delete);
        this.L = (LinearLayout) view.findViewById(R.id.search_history_container);
        this.M = (KGRecyclerView) view.findViewById(R.id.search_list);
        this.K.setOnClickListener(this);
        this.P = new e.c.a.g.a.g.o.e(getContext(), this);
        z0(this.M, new LinearLayoutManager(getContext()), this.P, Collections.emptyList());
        Y1();
        Z1();
        h2(getArguments().getString("voice_search_text", ""));
        e.c.a.g.a.d.d0.a.a("mhs_watch_search", "进入搜索页面， keyword = " + this.Q + ", 网络是否正常 = " + u0.m(getContext()));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public boolean b1() {
        return this.T;
    }

    public final void b2(String str, boolean z) {
        TextView textViewA = this.O.a(getContext(), str);
        textViewA.setOnClickListener(this.X);
        this.L.addView(textViewA, z ? 0 : -1);
    }

    public final void c2(Intent intent) {
        e.c.a.g.a.g.o.e eVar;
        if (intent == null || !"com.kugou.young.watch.metachanged".equals(intent.getAction()) || this.M == null || (eVar = this.P) == null || eVar.j()) {
            return;
        }
        this.M.post(new d());
    }

    public String d2(List<? extends KGSong> list) {
        if (list == null || list.isEmpty()) {
            return "无更多数据";
        }
        Log.d("mhs_watch", "newAddedData = " + list.size());
        StringBuilder sb = new StringBuilder();
        if (this.P != null) {
            sb.append("总大小 = " + this.P.getCount());
            sb.append("_");
        }
        sb.append(",返回大小 = " + list.size());
        sb.append(",");
        for (int i2 = 0; i2 < list.size(); i2++) {
            KGSong kGSong = list.get(i2);
            if (kGSong != null) {
                if (g0.f() && kGSong != null) {
                    Log.e("mhs_watch_error", "isVipMusic" + e.c.a.g.a.f.j.c.d.d(kGSong) + ", firstSong.hashOffset = " + kGSong.H1());
                }
                sb.append(kGSong.s1());
                sb.append("_");
                sb.append(kGSong.T1());
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public final void e2() {
        X1();
        if (!this.O.c().isEmpty()) {
            u1.p(this.J, this.L, this.K);
        }
        u1.e(this.M, L0());
        e.c.a.g.a.d.d0.a.a("mhs_watch_search", "showHistory traceState = " + this.R + ", keyword = " + this.Q);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void f1(List<? extends KGSong> list, boolean z) {
        super.f1(list, z);
        this.P.n(this.Q);
        String strD2 = d2(list);
        if (z) {
            this.R = "3";
            e.c.a.g.a.e.b.b(new YoungBITask(5002, "exposure").setKw1(this.Q).setState(this.R).setTab("1").setSvar1(strD2));
        } else {
            this.R = l0.g(list) ? "2" : "1";
            e.c.a.g.a.e.b.b(new YoungBITask(5002, "exposure").setKw1(this.Q).setState(this.R).setTab("1").setSvar1(strD2));
        }
        e.c.a.g.a.d.d0.a.a("mhs_watch_search", "onDataSetChanged traceState = " + this.R + ", reportSearchData = " + strD2 + ", keyword = " + this.Q + ", isLoadMore = " + z);
    }

    public final void f2() {
        X1();
        u1.e(this.J, this.L, this.K);
        u1.p(this.M, L0());
        e.c.a.g.a.d.d0.a.a("mhs_watch_search", "showSearchResult 显示搜索结果， traceState = " + this.R + ", keyword = " + this.Q);
    }

    public final void g2(String str) {
        if (this.O.d(str)) {
            int childCount = this.L.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                TextView textView = (TextView) this.L.getChildAt(i2);
                if (str.equals(textView.getText().toString())) {
                    this.L.removeView(textView);
                    break;
                }
                i2++;
            }
            b2(str, true);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void h1() {
        this.W.e();
    }

    public final void h2(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.Q = str;
        this.I.setText(str);
        g2(str);
        f2();
        j1();
        this.I.requestFocus();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void i1() {
        super.i1();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void l1(@Nullable Throwable th, @Nullable Integer num) {
        super.l1(th, num);
        this.W.b(th, this.V, this.U, num);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void m1() {
        super.m1();
        this.W.h(true);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void n1(e.c.a.g.a.f.k.c<List<KGSong>> cVar) {
        super.n1(cVar);
        if (cVar == null) {
            l1(null, 10);
        } else if (cVar.f()) {
            this.W.i(!l0.g(cVar.a()));
        } else {
            l1(new e.c.a.b.a.a.a.a(cVar.b()), 11);
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public Observable<e.c.a.g.a.f.k.c<List<KGSong>>> o1(int i2) {
        if (!TextUtils.isEmpty(this.Q)) {
            return Observable.just(this.Q).map(new c(i2)).map(new b(this));
        }
        e.c.a.g.a.f.k.c cVar = new e.c.a.g.a.f.k.c();
        cVar.h(true);
        cVar.g(new ArrayList());
        cVar.m(1);
        return Observable.just(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (u1.i(view)) {
            return;
        }
        int id = view.getId();
        if (id == R.id.search_delete) {
            U1();
            return;
        }
        if (id != R.id.search_song_root) {
            return;
        }
        KGMusicWrapper kGMusicWrapperF = e.c.a.g.a.f.j.a.c.f((KGSong) view.getTag(), Initiator.create(m()).carryPagePath(n()));
        ArrayList arrayList = new ArrayList();
        kGMusicWrapperF.getKgmusic().applyExtraInfo(CExtraInfo.addSource("21"));
        arrayList.add(kGMusicWrapperF);
        if (e.c.a.g.a.d.x.f.n()) {
            e.c.a.g.a.d.x.f.y(true, arrayList, 0, true, l());
        } else {
            e.c.a.g.a.d.x.f.l(true, arrayList, true, l());
        }
        this.S = true;
        e.c.a.g.a.e.b.b(new YoungBITask(5004, "click").setMixsongid(String.valueOf(kGMusicWrapperF.getMixId())).setTab("1"));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        n nVar = new n(this);
        this.N = nVar;
        e.c.a.g.a.f.d.a.b(nVar, new IntentFilter("com.kugou.young.watch.metachanged"));
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        x0();
        try {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                l1.J(getContext(), activity.getCurrentFocus());
            }
        } catch (Exception e2) {
            g0.k(e2);
        }
        e.c.a.g.a.f.d.a.g(this.N);
        if (!this.S) {
            e.c.a.g.a.e.b.b(new YoungBITask(5003, "exposure").setKw1(this.Q).setState(this.R).setTab("1"));
        }
        e.c.a.g.a.j.a.c().e("search");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(e.c.a.g.a.t.d dVar) {
        if (dVar == null) {
            return;
        }
        h2(dVar.a);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        EditText editText;
        super.onPause();
        if (!l1.m0() || (editText = this.I) == null) {
            return;
        }
        editText.setFocusable(false);
        this.I.setFocusableInTouchMode(false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        a2(view);
        e.c.a.g.a.e.b.b(new YoungBITask(5001, "exposure"));
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "搜索页";
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateListFragment
    public void y1() {
        u1.e(this.J, this.L);
        this.R = "2";
        e.c.a.g.a.e.b.b(new YoungBITask(5002, "exposure").setKw1(this.Q).setState(this.R).setTab("1").setSvar1("数据全为空"));
        e.c.a.g.a.d.d0.a.a("mhs_watch_search", "showEmpty 数据全为空 traceState = " + this.R + ", keyword = " + this.Q + ", NetworkUtil.isGlobalNetAvailable(getContext()) = " + u0.m(getContext()));
        super.y1();
    }
}
