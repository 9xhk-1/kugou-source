package com.kugou.android.audioidentify;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.common.apm.task.AudioIdentifyAPM;
import com.kugou.common.permission.Permission;
import com.kugou.common.utils.PermissionsUtil;
import com.kugou.framework.musichunter.RecognizeResult;
import e.c.a.g.a.s.c0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.g1;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.r;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import f.u.u;
import f.z.c.l;
import f.z.d.k;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsIdentifyFragment extends DelegateFragment implements View.OnClickListener {
    public final AudioIdentifyAPM A = new AudioIdentifyAPM();
    public View r;
    public TextView s;
    public TextView t;
    public TextView u;
    public View v;
    public View w;
    public g1<d> x;
    public boolean y;
    public Subscription z;

    public static final class a extends d {
        @Override // e.c.a.g.a.s.g1.b
        public void d(Object obj) {
            super.d(obj);
            AbsIdentifyFragment absIdentifyFragmentG = g();
            absIdentifyFragmentG.y0().setVisibility(8);
            absIdentifyFragmentG.z0().setVisibility(0);
            absIdentifyFragmentG.A0().setText(h1.q(obj instanceof String ? (String) obj : null, "识别失败，请更靠近音源进行识别"));
            absIdentifyFragmentG.A0().setTextColor(ContextCompat.getColor(g().requireContext(), R.color.c_999999));
        }
    }

    public static class b extends d {
        @Override // e.c.a.g.a.s.g1.b
        public void d(Object obj) {
            super.d(obj);
            AbsIdentifyFragment absIdentifyFragmentG = g();
            absIdentifyFragmentG.y0().setVisibility(0);
            absIdentifyFragmentG.z0().setVisibility(8);
            absIdentifyFragmentG.A0().setText("点击开始识别");
            absIdentifyFragmentG.A0().setTextColor(ContextCompat.getColor(g().requireContext(), R.color.app_blue));
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final f.d f3i = f.f.b(new a());

        public static final class a extends k implements f.z.c.a<e.c.a.a.b> {
            public a() {
                super(0);
            }

            @Override // f.z.c.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final e.c.a.a.b invoke() {
                return l1.g0() ? new e.c.a.a.c(c.this.g().C0(), c.this.g().D0()) : new e.c.a.a.a(c.this.g().C0(), c.this.g().D0());
            }
        }

        @Override // e.c.a.g.a.s.g1.b
        public void d(Object obj) {
            super.d(obj);
            AbsIdentifyFragment absIdentifyFragmentG = g();
            absIdentifyFragmentG.y0().setVisibility(0);
            absIdentifyFragmentG.z0().setVisibility(8);
            absIdentifyFragmentG.A0().setText("识别中");
            absIdentifyFragmentG.A0().setTextColor(ContextCompat.getColor(g().requireContext(), R.color.c_999999));
            l().startWaveAnim();
        }

        @Override // e.c.a.g.a.s.g1.b
        public void e() {
            super.e();
            l().stopWaveAnim();
        }

        @Override // com.kugou.android.audioidentify.AbsIdentifyFragment.d
        public void h() {
            super.h();
            l().stopWaveAnim();
        }

        @Override // com.kugou.android.audioidentify.AbsIdentifyFragment.d
        public void i() {
            super.i();
            l().startWaveAnim();
        }

        public final e.c.a.a.b l() {
            return (e.c.a.a.b) this.f3i.getValue();
        }
    }

    public static abstract class d extends g1.b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public AbsIdentifyFragment f4h;

        public final AbsIdentifyFragment g() {
            AbsIdentifyFragment absIdentifyFragment = this.f4h;
            if (absIdentifyFragment != null) {
                return absIdentifyFragment;
            }
            f.z.d.j.t("mHost");
            throw null;
        }

        public void h() {
        }

        public void i() {
        }

        public final void j(AbsIdentifyFragment absIdentifyFragment) {
            f.z.d.j.e(absIdentifyFragment, "<set-?>");
            this.f4h = absIdentifyFragment;
        }

        public final void k(AbsIdentifyFragment absIdentifyFragment) {
            f.z.d.j.e(absIdentifyFragment, "fragment");
            j(absIdentifyFragment);
        }
    }

    public static final class e implements PermissionsUtil.OnPermissionDilaogListener {
        public e() {
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onNo() {
            Log.d("mhs_watch", "initData onNo");
        }

        @Override // com.kugou.common.utils.PermissionsUtil.OnPermissionDilaogListener
        public void onYes() {
            Log.d("mhs_watch", "initData onYes");
            AbsIdentifyFragment.this.v0();
        }
    }

    public static final class f<T> implements r {
        public static final f<T> a = new f<>();

        @Override // e.c.a.g.a.s.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final boolean isFilter(KGSong kGSong) {
            return e.c.a.g.a.g.o.b.g(kGSong);
        }
    }

    public static final class g extends k implements l<KGSong, CharSequence> {
        public static final g a = new g();

        public g() {
            super(1);
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(KGSong kGSong) {
            return String.valueOf(kGSong == null ? null : Long.valueOf(kGSong.T1()));
        }
    }

    public static final class h<T> implements c0.a {
        public h() {
        }

        @Override // e.c.a.g.a.s.c0.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d create(Class<? extends d> cls) {
            d aVar;
            if (f.z.d.j.a(cls, b.class)) {
                aVar = new b();
            } else if (f.z.d.j.a(cls, c.class)) {
                aVar = new c();
            } else {
                if (!f.z.d.j.a(cls, a.class)) {
                    throw new IllegalArgumentException(f.z.d.j.l("invalid state : ", cls));
                }
                aVar = new a();
            }
            aVar.k(AbsIdentifyFragment.this);
            return aVar;
        }
    }

    public static final class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbsIdentifyFragment.this.B0().performClick();
        }
    }

    public static final class j<T> implements Action1 {
        public j() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            AbsIdentifyFragment.this.I0(10);
        }
    }

    public final TextView A0() {
        TextView textView = this.u;
        if (textView != null) {
            return textView;
        }
        f.z.d.j.t("mIdentifyResultTv");
        throw null;
    }

    public final View B0() {
        View view = this.r;
        if (view != null) {
            return view;
        }
        f.z.d.j.t("mStartBtn");
        throw null;
    }

    public final View C0() {
        View view = this.v;
        if (view != null) {
            return view;
        }
        f.z.d.j.t("mWaveView1");
        throw null;
    }

    public final View D0() {
        View view = this.w;
        if (view != null) {
            return view;
        }
        f.z.d.j.t("mWaveView2");
        throw null;
    }

    public final boolean E0(String str) {
        return ContextCompat.checkSelfPermission(requireContext(), str) == -1;
    }

    public boolean F0() {
        return false;
    }

    public void G0(boolean z) {
        if (z) {
            AudioIdentifyAPM audioIdentifyAPM = this.A;
            if (audioIdentifyAPM == null) {
                return;
            }
            audioIdentifyAPM.failByUserCancel("02");
            return;
        }
        AudioIdentifyAPM audioIdentifyAPM2 = this.A;
        if (audioIdentifyAPM2 == null) {
            return;
        }
        audioIdentifyAPM2.failedBySdk(2);
    }

    public void H0() {
        AudioIdentifyAPM audioIdentifyAPM = this.A;
        if (audioIdentifyAPM == null) {
            return;
        }
        audioIdentifyAPM.failedByEmpty();
    }

    public void I0(int i2) {
        AudioIdentifyAPM audioIdentifyAPM;
        g1<d> g1Var = this.x;
        if (g1Var == null) {
            f.z.d.j.t("uiStateCtrl");
            throw null;
        }
        g1Var.b(a.class);
        if (i2 == 7 || i2 == 8) {
            AudioIdentifyAPM audioIdentifyAPM2 = this.A;
            if (audioIdentifyAPM2 == null) {
                return;
            }
            audioIdentifyAPM2.failedBySdk(i2);
            return;
        }
        if (i2 == 10 && (audioIdentifyAPM = this.A) != null) {
            audioIdentifyAPM.failedByTimeOut();
        }
    }

    public void J0(RecognizeResult recognizeResult, String str, int i2, int i3, boolean z, boolean z2) {
        boolean z3 = (recognizeResult == null || recognizeResult.getResponse() == null || recognizeResult.getResponse().getSongs() == null || recognizeResult.getResponse().getSongs().size() <= 0) ? false : true;
        ArrayList<KGSong> arrayList = new ArrayList<>();
        try {
            f.z.d.j.c(recognizeResult);
            ArrayList<KGSong> arrayListA = e.c.a.c.a.a(new JSONObject(recognizeResult.getResponse().getOriginalContent()));
            f.z.d.j.d(arrayListA, "parse(JSONObject(result!!.getResponse().getOriginalContent()))");
            recognizeResult.getResponse().setExtTag(arrayListA);
            arrayList = z3 ? arrayListA : new ArrayList<>();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ArrayList<KGSong> arrayList2 = arrayList;
        int iE = l0.e(arrayList2);
        l0.a(arrayList2, f.a);
        if (iE <= 0 || l0.e(arrayList2) <= 0) {
            AudioIdentifyAPM audioIdentifyAPM = this.A;
            if (audioIdentifyAPM != null) {
                audioIdentifyAPM.failByFilter();
            }
        } else {
            AudioIdentifyAPM audioIdentifyAPM2 = this.A;
            if (audioIdentifyAPM2 != null) {
                audioIdentifyAPM2.success();
            }
        }
        if (!arrayList2.isEmpty()) {
            g1<d> g1Var = this.x;
            if (g1Var == null) {
                f.z.d.j.t("uiStateCtrl");
                throw null;
            }
            g1Var.b(b.class);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            ArrayList<KGSong> arrayList3 = new ArrayList<>();
            for (KGSong kGSong : arrayList2) {
                if (!u.o(linkedHashSet, kGSong == null ? null : Long.valueOf(kGSong.T1()))) {
                    linkedHashSet.add(Long.valueOf(kGSong == null ? 0L : kGSong.T1()));
                    arrayList3.add(kGSong);
                } else if (g0.a) {
                    g0.b("AbsIdentifyFragment", f.z.d.j.l("onIdentifyFinish: drop song ", kGSong == null ? null : Long.valueOf(kGSong.T1())));
                }
            }
            s0.a.k(arrayList3, x0());
        } else if (iE > 0) {
            g1<d> g1Var2 = this.x;
            if (g1Var2 == null) {
                f.z.d.j.t("uiStateCtrl");
                throw null;
            }
            g1Var2.c(a.class, "识别暂无歌曲");
        } else {
            g1<d> g1Var3 = this.x;
            if (g1Var3 == null) {
                f.z.d.j.t("uiStateCtrl");
                throw null;
            }
            g1Var3.b(a.class);
        }
        YoungBITask youngBITask = new YoungBITask(20434, "statistics");
        if (!l0.g(arrayList2)) {
            youngBITask.append(ApmDataKey.STATE, String.valueOf(l0.e(arrayList2)));
            youngBITask.setType("1");
            String strB = u.B(arrayList2, null, null, null, 0, null, g.a, 31, null);
            if (strB == null) {
                strB = "";
            }
            youngBITask.setMixsongid(strB);
        } else {
            youngBITask.setType("2");
        }
        youngBITask.setSvar1(w0());
        e.c.a.g.a.e.b.b(youngBITask);
    }

    public void K0(boolean z) {
        g1<d> g1Var = this.x;
        if (g1Var == null) {
            f.z.d.j.t("uiStateCtrl");
            throw null;
        }
        g1Var.b(c.class);
        AudioIdentifyAPM audioIdentifyAPM = this.A;
        if (audioIdentifyAPM == null) {
            return;
        }
        audioIdentifyAPM.start(f.z.d.j.l("", Integer.valueOf(x0())));
    }

    public void L0() {
        g1<d> g1Var = this.x;
        if (g1Var != null) {
            g1Var.b(b.class);
        } else {
            f.z.d.j.t("uiStateCtrl");
            throw null;
        }
    }

    public final void M0(TextView textView) {
        f.z.d.j.e(textView, "<set-?>");
        this.s = textView;
    }

    public final void N0(TextView textView) {
        f.z.d.j.e(textView, "<set-?>");
        this.t = textView;
    }

    public final void O0(TextView textView) {
        f.z.d.j.e(textView, "<set-?>");
        this.u = textView;
    }

    public final void P0(View view) {
        f.z.d.j.e(view, "<set-?>");
        this.r = view;
    }

    public final void Q0(View view) {
        f.z.d.j.e(view, "<set-?>");
        this.v = view;
    }

    public final void R0(View view) {
        f.z.d.j.e(view, "<set-?>");
        this.w = view;
    }

    public final void S0() {
        if (u0.m(getContext())) {
            EventBus.getDefault().post(new e.c.a.c.b.a(x0()));
            K0(false);
            T0();
        }
    }

    public final void T0() {
        i1.a(this.z);
        this.z = Observable.just("").delay(20000L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(), i1.b);
    }

    public final void U0() {
        i1.a(this.z);
        this.z = null;
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public int o() {
        return 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.z.d.j.e(view, "v");
        if (u1.i(view)) {
            return;
        }
        int id = view.getId();
        if (id == R.id.identify_again || id == R.id.identify_start) {
            g1<d> g1Var = this.x;
            if (g1Var == null) {
                f.z.d.j.t("uiStateCtrl");
                throw null;
            }
            d dVar = (d) g1Var.a();
            if (dVar instanceof c) {
                EventBus.getDefault().post(new e.c.a.c.b.b());
                return;
            }
            if (dVar instanceof b ? true : dVar instanceof a) {
                g1<d> g1Var2 = this.x;
                if (g1Var2 == null) {
                    f.z.d.j.t("uiStateCtrl");
                    throw null;
                }
                if (g1Var2.a() instanceof a) {
                    e.c.a.g.a.e.b.b(new YoungBITask(20435, "click").setType("2").setTab("8").setSvar1(w0()));
                }
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(Permission.RECORD_AUDIO);
                PermissionsUtil.getInstance().showPermissionRequestDialogCommon(getActivity(), getString(R.string.record_audio_tips), new e(), arrayList);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f.z.d.j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_abstract_identify, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        U0();
        g1<d> g1Var = this.x;
        if (g1Var == null) {
            f.z.d.j.t("uiStateCtrl");
            throw null;
        }
        if (g1Var.a() instanceof a) {
            e.c.a.g.a.e.b.b(new YoungBITask(20435, "click").setType("2").setTab("6").setSvar1(w0()));
        }
        g1<d> g1Var2 = this.x;
        if (g1Var2 != null) {
            g1Var2.d();
        } else {
            f.z.d.j.t("uiStateCtrl");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        g1<d> g1Var = this.x;
        if (g1Var != null) {
            ((d) g1Var.a()).h();
        } else {
            f.z.d.j.t("uiStateCtrl");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        f.z.d.j.e(strArr, "permissions");
        f.z.d.j.e(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1100) {
            Integer numH = f.u.i.h(iArr);
            if (numH != null && numH.intValue() == 0) {
                S0();
            } else {
                p1.h(getContext(), "授权录音才可使用哦");
            }
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g1<d> g1Var = this.x;
        if (g1Var != null) {
            ((d) g1Var.a()).i();
        } else {
            f.z.d.j.t("uiStateCtrl");
            throw null;
        }
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        f.z.d.j.e(view, "view");
        super.onViewCreated(view, bundle);
        e.c.a.g.a.f.o.e.a(view.findViewById(R.id.root_view));
        View viewFindViewById = view.findViewById(R.id.identify_start);
        f.z.d.j.d(viewFindViewById, "view.findViewById(R.id.identify_start)");
        P0(viewFindViewById);
        View viewFindViewById2 = view.findViewById(R.id.identify_dec);
        f.z.d.j.d(viewFindViewById2, "view.findViewById(R.id.identify_dec)");
        M0((TextView) viewFindViewById2);
        View viewFindViewById3 = view.findViewById(R.id.identify_again);
        f.z.d.j.d(viewFindViewById3, "view.findViewById(R.id.identify_again)");
        N0((TextView) viewFindViewById3);
        View viewFindViewById4 = view.findViewById(R.id.identify_result);
        f.z.d.j.d(viewFindViewById4, "view.findViewById(R.id.identify_result)");
        O0((TextView) viewFindViewById4);
        View viewFindViewById5 = view.findViewById(R.id.identify_wave_1);
        f.z.d.j.d(viewFindViewById5, "view.findViewById(R.id.identify_wave_1)");
        Q0(viewFindViewById5);
        View viewFindViewById6 = view.findViewById(R.id.identify_wave_2);
        f.z.d.j.d(viewFindViewById6, "view.findViewById(R.id.identify_wave_2)");
        R0(viewFindViewById6);
        B0().setOnClickListener(this);
        z0().setOnClickListener(this);
        g1<d> g1Var = new g1<>(new h());
        this.x = g1Var;
        if (g1Var == null) {
            f.z.d.j.t("uiStateCtrl");
            throw null;
        }
        g1Var.f(b.class);
        if (!F0() || B0() == null) {
            return;
        }
        B0().postDelayed(new i(), 1000L);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || this.y) {
            return;
        }
        this.y = true;
        e.c.a.g.a.e.b.b(new YoungBITask(20433, "exposure").setSvar1(w0()));
    }

    public final void v0() {
        if (E0(Permission.RECORD_AUDIO)) {
            requestPermissions(new String[]{Permission.RECORD_AUDIO}, 1100);
        } else {
            S0();
        }
    }

    public final String w0() {
        int iX0 = x0();
        return iX0 != 0 ? iX0 != 1 ? "" : "3" : "1";
    }

    public abstract int x0();

    public final TextView y0() {
        TextView textView = this.s;
        if (textView != null) {
            return textView;
        }
        f.z.d.j.t("mDescTv");
        throw null;
    }

    public final TextView z0() {
        TextView textView = this.t;
        if (textView != null) {
            return textView;
        }
        f.z.d.j.t("mIdentifyAgainBtn");
        throw null;
    }
}
