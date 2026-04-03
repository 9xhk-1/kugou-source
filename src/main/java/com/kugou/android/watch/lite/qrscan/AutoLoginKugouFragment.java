package com.kugou.android.watch.lite.qrscan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.user.login.LoginRiskActivity;
import com.kugou.android.watch.lite.user.login.UserData;
import e.c.a.g.a.r.e.h;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.v;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
@e.c.c.l.f.b(id = -1)
@Deprecated
public class AutoLoginKugouFragment extends DelegateFragment {
    public TextView A;
    public TextView B;
    public ImageView C;
    public boolean D;
    public boolean E;
    public TextView F;
    public Subscription G;
    public final h.d H = new a();
    public View r;
    public ImageView s;
    public TextView t;
    public k u;
    public e.c.a.g.a.n.b.a v;
    public LinearLayout w;
    public TextView x;
    public LinearLayout y;
    public TextView z;

    public class a implements h.d {

        /* JADX INFO: renamed from: com.kugou.android.watch.lite.qrscan.AutoLoginKugouFragment$a$a, reason: collision with other inner class name */
        public class C0020a implements Action1<String> {
            public C0020a() {
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(String str) {
                AutoLoginKugouFragment.this.i0();
                AutoLoginKugouFragment.this.startActivity(new Intent(AutoLoginKugouFragment.this.getActivity(), (Class<?>) LoginRiskActivity.class));
            }
        }

        public a() {
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginFailed(UserData userData, int i2) {
            AutoLoginKugouFragment.this.i0();
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginRisk() {
            i1.a(AutoLoginKugouFragment.this.G);
            AutoLoginKugouFragment.this.G = Observable.just("").subscribeOn(AndroidSchedulers.mainThread()).subscribe(new C0020a(), i1.b);
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginSucceed(UserData userData, int i2) {
            e.c.a.g.a.r.b.Y(true);
            AutoLoginKugouFragment.this.i0();
            p1.h(KGApplication.getApplication(), "扫码登录成功~");
            EventBus.getDefault().post(new e.c.a.g.a.n.a());
            AutoLoginKugouFragment.this.e();
        }
    }

    public class b implements Action1<Observable<Object>> {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Observable<Object> observable) {
            AutoLoginKugouFragment.this.G0(5, null);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AutoLoginKugouFragment.this.q0(true);
            AutoLoginKugouFragment.this.u.obtainMessage(2).sendToTarget();
            e.c.a.g.a.e.b.b(new YoungBITask(20498, "click").setType("5"));
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AutoLoginKugouFragment.this.e();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AutoLoginKugouFragment.this.e();
        }
    }

    public class f implements Action1<Observable<Object>> {
        public final /* synthetic */ e.c.a.g.a.n.b.c a;

        public f(e.c.a.g.a.n.b.c cVar) {
            this.a = cVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Observable<Object> observable) {
            AutoLoginKugouFragment.this.G0(0, this.a);
        }
    }

    public class g implements Action1<Observable<Object>> {
        public final /* synthetic */ e.c.a.g.a.n.b.c a;

        public g(e.c.a.g.a.n.b.c cVar) {
            this.a = cVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Observable<Object> observable) {
            AutoLoginKugouFragment.this.G0(4, this.a);
        }
    }

    public class h implements Action1<Observable<Object>> {
        public final /* synthetic */ e.c.a.g.a.n.b.c a;

        public h(e.c.a.g.a.n.b.c cVar) {
            this.a = cVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Observable<Object> observable) {
            AutoLoginKugouFragment.this.G0(1, this.a);
        }
    }

    public class i implements Action1<Observable<Object>> {
        public final /* synthetic */ e.c.a.g.a.n.b.c a;

        public i(e.c.a.g.a.n.b.c cVar) {
            this.a = cVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Observable<Object> observable) {
            AutoLoginKugouFragment.this.G0(2, this.a);
        }
    }

    public class j implements Action1<Observable<Object>> {
        public final /* synthetic */ e.c.a.g.a.n.b.a a;
        public final /* synthetic */ Bitmap b;

        public j(e.c.a.g.a.n.b.a aVar, Bitmap bitmap) {
            this.a = aVar;
            this.b = bitmap;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Observable<Object> observable) {
            if (g0.a) {
                g0.b("AutoLoginKugouFragment", "refreshQrcode call: codeImg.setImageBitmap(bitmap)");
            }
            AutoLoginKugouFragment.this.D = true;
            AutoLoginKugouFragment.this.v = this.a;
            AutoLoginKugouFragment.this.s.setImageBitmap(this.b);
            AutoLoginKugouFragment.this.u.obtainMessage(0).sendToTarget();
        }
    }

    public static class k extends v<AutoLoginKugouFragment> {
        public long b;

        public k(AutoLoginKugouFragment autoLoginKugouFragment) {
            super(autoLoginKugouFragment);
        }

        @Override // e.c.a.g.a.s.v
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AutoLoginKugouFragment autoLoginKugouFragment, Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.b = System.currentTimeMillis();
            } else if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                removeCallbacksAndMessages(null);
                autoLoginKugouFragment.F0();
                return;
            }
            if (autoLoginKugouFragment.E0()) {
                return;
            }
            if (System.currentTimeMillis() - this.b < 120000) {
                sendMessageDelayed(obtainMessage(1), System.currentTimeMillis() - this.b < 60000 ? 1000L : 5000L);
                return;
            }
            if (g0.a) {
                g0.b("AutoLoginKugouFragment", " case MSG_LOOP_QUERY: obtainMessage(MSG_REFRESH_QRCODE)");
            }
            sendMessage(obtainMessage(2));
        }
    }

    public void D0() {
        e.c.a.g.a.e.b.b(new YoungBITask(20478, "exposure").setType("1").setTab(getArguments() != null ? getArguments().getString("source", "0") : "0"));
    }

    public final boolean E0() {
        if (g0.a) {
            g0.e("AutoLoginKugouFragment", "queryQRCodeStatus");
        }
        e.c.a.g.a.n.b.c cVarE = e.c.a.g.a.n.b.b.e(this.v.c());
        if (cVarE != null && cVarE.b) {
            int i2 = cVarE.c;
            if (i2 == 0) {
                Observable.just(Observable.empty()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(cVarE), i1.b);
                return true;
            }
            if (i2 == 1) {
                Observable.just(Observable.empty()).observeOn(AndroidSchedulers.mainThread()).subscribe(new h(cVarE), i1.b);
            } else if (i2 == 2) {
                Observable.just(Observable.empty()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(cVarE), i1.b);
            } else if (i2 == 4) {
                Observable.just(Observable.empty()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(cVarE), i1.b);
                q0(false);
                if (g0.a) {
                    g0.e("AutoLoginKugouFragment", "loginStatus: nickName->" + cVarE.f1119e + " pic->" + cVarE.f1120f + " userId->" + cVarE.f1118d + " token->" + cVarE.f1121g);
                }
                e.c.a.g.a.r.e.h hVar = new e.c.a.g.a.r.e.h();
                hVar.t(this.H);
                hVar.l(false, 5, cVarE.f1119e, cVarE.f1118d + "", cVarE.f1121g);
                return true;
            }
        }
        return false;
    }

    public final void F0() {
        if (g0.a) {
            g0.e("AutoLoginKugouFragment", "refreshQrcode");
        }
        e.c.a.g.a.n.b.a aVarA = e.c.a.g.a.n.b.b.a();
        if (!this.E) {
            i0();
        }
        this.E = false;
        String strA = aVarA != null ? aVarA.a() : null;
        if (aVarA != null && !TextUtils.isEmpty(strA)) {
            if (g0.a) {
                g0.b("AutoLoginKugouFragment", "refreshQrcode: str=" + strA);
            }
            int iD = l1.d(e.c.c.o.f.a(), 160.0f);
            Bitmap bitmapB = a0.b(strA, iD, iD, -16777216, -1);
            if (bitmapB != null && !bitmapB.isRecycled()) {
                if (g0.a) {
                    g0.b("AutoLoginKugouFragment", "refreshQrcode: bitmap != null && !bitmap.isRecycled()");
                }
                Observable.just(Observable.empty()).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(aVarA, bitmapB), i1.b);
                return;
            } else if (g0.a) {
                g0.b("AutoLoginKugouFragment", "refreshQrcode: bitmap fail");
            }
        }
        Observable.just(Observable.empty()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(), i1.b);
    }

    @MainThread
    public final void G0(int i2, @Nullable e.c.a.g.a.n.b.c cVar) {
        if (g0.a) {
            g0.b("AutoLoginKugouFragment", "switchViewVisibility: codeStatus=" + i2);
        }
        if (i2 == 0) {
            this.w.setVisibility(0);
            this.y.setVisibility(8);
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.F.setText("二维码已失效");
            this.x.setText("刷新");
            this.x.requestFocus();
            return;
        }
        if (i2 == 1) {
            this.y.setVisibility(8);
            this.w.setVisibility(8);
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            return;
        }
        if (i2 == 2) {
            this.y.setVisibility(0);
            this.w.setVisibility(8);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            if (cVar != null) {
                Glide.with(this).load(cVar.f1120f).placeholder(R.drawable.auto_default_avatar).into(this.C);
                this.z.setText(cVar.f1119e);
                this.A.setText("请在手机上确认登录");
                return;
            }
            return;
        }
        if (i2 == 4) {
            this.y.setVisibility(0);
            this.w.setVisibility(8);
            this.s.setVisibility(8);
            this.t.setVisibility(8);
            if (cVar != null) {
                Glide.with(this).load(cVar.f1120f).placeholder(R.drawable.auto_default_avatar).into(this.C);
                this.z.setText(cVar.f1119e);
                this.A.setText("正在登录...");
                return;
            }
            return;
        }
        if (i2 != 5) {
            return;
        }
        this.w.setVisibility(0);
        this.y.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setImageBitmap(null);
        this.t.setVisibility(0);
        this.F.setText("网络异常");
        this.x.setText("刷新重试");
        this.x.requestFocus();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.auto_login_kugou_and_weixin_fragment_layout, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (g0.a) {
            g0.b("AutoLoginKugouFragment", "onDestroyView: ");
        }
        super.onDestroyView();
        this.u.removeCallbacksAndMessages(null);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (g0.a) {
            g0.b("AutoLoginKugouFragment", "onFragmentResume: isSuccess=" + this.D + " isAlive()=" + z());
        }
        if (this.D || this.u != null) {
            return;
        }
        this.u = new k(this);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (g0.a) {
            g0.b("AutoLoginKugouFragment", "onViewCreated: ");
        }
        this.r = view.findViewById(R.id.content_view);
        if (l1.X()) {
            u1.l(this.r, 17);
        }
        this.s = (ImageView) view.findViewById(R.id.code_img);
        TextView textView = (TextView) view.findViewById(R.id.tip);
        this.t = textView;
        textView.setText("请在酷狗概念版手机端\n“我的-右上角-扫一扫”\n扫码登录");
        this.w = (LinearLayout) u1.a(view, R.id.invalid_container);
        this.x = (TextView) u1.a(view, R.id.invalid_refresh);
        this.y = (LinearLayout) u1.a(view, R.id.info_container);
        this.C = (ImageView) u1.a(view, R.id.info_img);
        this.z = (TextView) u1.a(view, R.id.info_name);
        this.A = (TextView) u1.a(view, R.id.info_tip);
        this.B = (TextView) u1.a(view, R.id.info_back);
        this.F = (TextView) view.findViewById(R.id.tv_invalidate);
        c cVar = new c();
        this.B.setOnClickListener(cVar);
        this.x.setOnClickListener(cVar);
        View viewFindViewById = view.findViewById(R.id.login_by_phone);
        View viewFindViewById2 = view.findViewById(R.id.iv_login_by_phone);
        if (e.c.a.g.a.f.a.t()) {
            viewFindViewById.setVisibility(8);
            viewFindViewById2.setVisibility(8);
        } else {
            viewFindViewById.setVisibility(0);
            viewFindViewById2.setVisibility(0);
            viewFindViewById.setOnClickListener(new d());
            viewFindViewById2.setOnClickListener(new e());
        }
        if (this.u == null) {
            this.u = new k(this);
        }
        this.u.obtainMessage(2).sendToTarget();
        G0(1, null);
        l1.I(getActivity());
        D0();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment
    public String s0() {
        return "扫码登录页";
    }
}
