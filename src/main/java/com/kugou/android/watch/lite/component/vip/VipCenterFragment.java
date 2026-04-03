package com.kugou.android.watch.lite.component.vip;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.user.entity.BusiVip;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import com.kugou.common.userinfo.protocol.GetVIPInfoProtocol;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.k;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.o;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.s1;
import e.c.a.g.a.s.u1;
import e.c.a.g.a.s.v1;
import e.c.a.g.a.s.x1;
import e.c.a.g.a.s.z;
import f.z.d.j;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.internal.CustomAdapt;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
@e.c.c.l.f.b(id = -1)
public final class VipCenterFragment extends DelegateFragment implements View.OnClickListener, CustomAdapt {
    public TextView A;
    public ImageView B;
    public Subscription D;
    public a E;
    public ImageView r;
    public TextView s;
    public ImageView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;
    public final z C = new s1();
    public boolean F = e.c.a.g.a.r.b.O();
    public String G = "";

    /* JADX INFO: loaded from: classes2.dex */
    public abstract class a {
        public final /* synthetic */ VipCenterFragment a;

        public a(VipCenterFragment vipCenterFragment) {
            j.e(vipCenterFragment, "this$0");
            this.a = vipCenterFragment;
        }

        public final void a() {
            View[] viewArr = new View[6];
            TextView textView = this.a.u;
            if (textView == null) {
                j.t("contentTitleTv1");
                throw null;
            }
            viewArr[0] = textView;
            TextView textView2 = this.a.v;
            if (textView2 == null) {
                j.t("contentDescTv1");
                throw null;
            }
            viewArr[1] = textView2;
            TextView textView3 = this.a.w;
            if (textView3 == null) {
                j.t("contentTitleTv2");
                throw null;
            }
            viewArr[2] = textView3;
            TextView textView4 = this.a.x;
            if (textView4 == null) {
                j.t("contentDescTv2");
                throw null;
            }
            viewArr[3] = textView4;
            TextView textView5 = this.a.y;
            if (textView5 == null) {
                j.t("contentTitleTv3");
                throw null;
            }
            viewArr[4] = textView5;
            TextView textView6 = this.a.z;
            if (textView6 == null) {
                j.t("contentDescTv3");
                throw null;
            }
            viewArr[5] = textView6;
            u1.e(viewArr);
        }

        public abstract void b();

        public final void c(String str, String str2) {
            boolean z = true;
            if (!(str == null || str.length() == 0)) {
                TextView textView = this.a.u;
                if (textView == null) {
                    j.t("contentTitleTv1");
                    throw null;
                }
                textView.setText(str);
                TextView textView2 = this.a.u;
                if (textView2 == null) {
                    j.t("contentTitleTv1");
                    throw null;
                }
                textView2.setVisibility(0);
            }
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            TextView textView3 = this.a.v;
            if (textView3 == null) {
                j.t("contentDescTv1");
                throw null;
            }
            textView3.setText(str2);
            TextView textView4 = this.a.v;
            if (textView4 != null) {
                textView4.setVisibility(0);
            } else {
                j.t("contentDescTv1");
                throw null;
            }
        }

        public final void d(String str, String str2) {
            boolean z = true;
            if (!(str == null || str.length() == 0)) {
                TextView textView = this.a.w;
                if (textView == null) {
                    j.t("contentTitleTv2");
                    throw null;
                }
                textView.setText(str);
                TextView textView2 = this.a.w;
                if (textView2 == null) {
                    j.t("contentTitleTv2");
                    throw null;
                }
                textView2.setVisibility(0);
            }
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            TextView textView3 = this.a.x;
            if (textView3 == null) {
                j.t("contentDescTv2");
                throw null;
            }
            textView3.setText(str2);
            TextView textView4 = this.a.x;
            if (textView4 != null) {
                textView4.setVisibility(0);
            } else {
                j.t("contentDescTv2");
                throw null;
            }
        }

        public final void e(String str, String str2) {
            boolean z = true;
            if (!(str == null || str.length() == 0)) {
                TextView textView = this.a.y;
                if (textView == null) {
                    j.t("contentTitleTv3");
                    throw null;
                }
                textView.setText(str);
                TextView textView2 = this.a.y;
                if (textView2 == null) {
                    j.t("contentTitleTv3");
                    throw null;
                }
                textView2.setVisibility(0);
            }
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            TextView textView3 = this.a.z;
            if (textView3 == null) {
                j.t("contentDescTv3");
                throw null;
            }
            textView3.setText(str2);
            TextView textView4 = this.a.z;
            if (textView4 != null) {
                textView4.setVisibility(0);
            } else {
                j.t("contentDescTv3");
                throw null;
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class b extends a {
        public final /* synthetic */ VipCenterFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VipCenterFragment vipCenterFragment) {
            super(vipCenterFragment);
            j.e(vipCenterFragment, "this$0");
            this.b = vipCenterFragment;
        }

        @Override // com.kugou.android.watch.lite.component.vip.VipCenterFragment.a
        public void b() {
            a();
            TextView textView = this.b.A;
            if (textView == null) {
                j.t("button");
                throw null;
            }
            textView.setText("立即开通");
            c("酷狗概念版VIP", "开通畅听千万曲库");
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class c extends a {
        public final /* synthetic */ VipCenterFragment b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VipCenterFragment vipCenterFragment) {
            super(vipCenterFragment);
            j.e(vipCenterFragment, "this$0");
            this.b = vipCenterFragment;
        }

        @Override // com.kugou.android.watch.lite.component.vip.VipCenterFragment.a
        public void b() {
            a();
            boolean zM = e.c.a.g.a.r.b.M();
            if (zM) {
                long jE = k.e(SVIPExtInfoUtil.getMineSVIPExtInfo().getSu_vip_end_time());
                c("酷狗音乐超级VIP", jE > 0 ? j.l("有效期至 ", k.c(jE, "yyyy-MM-dd")) : null);
            }
            boolean zQ = e.c.a.g.a.r.b.Q();
            if (zQ) {
                long jE2 = k.e(e.c.a.g.a.r.b.A());
                d("酷狗概念版VIP", jE2 > 0 ? j.l("有效期至 ", k.c(jE2, "yyyy-MM-dd")) : null);
            }
            if (!zM) {
                boolean z = true;
                if (e.c.a.g.a.r.b.z() == 6) {
                    long jE3 = k.e(e.c.a.g.a.r.b.f());
                    String strL = jE3 > 0 ? j.l("有效期至 ", k.c(jE3, "yyyy-MM-dd")) : null;
                    if (strL != null && strL.length() != 0) {
                        z = false;
                    }
                    if (!z || !zQ) {
                        e("酷狗音乐豪华VIP", strL);
                    }
                }
            }
            TextView textView = this.b.A;
            if (textView != null) {
                textView.setText(zQ ? "立即续费" : "立即开通");
            } else {
                j.t("button");
                throw null;
            }
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class d<T, R> implements Func1 {
        public static final d<T, R> a = new d<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final UserData call(String str) {
            UserData vIPInfo = new GetVIPInfoProtocol().getVIPInfo(e.c.a.g.a.r.b.o(), e.c.a.g.a.r.b.n());
            if (vIPInfo != null) {
                boolean z = true;
                if (vIPInfo.getStatus() == 1) {
                    e.c.a.g.a.f.k.c<UserData> cVarA = e.c.a.g.a.r.d.d.b.a.a();
                    if (!cVarA.f()) {
                        return null;
                    }
                    UserData userDataA = cVarA.a();
                    BusiVip[] busiVip = userDataA != null ? userDataA.getBusiVip() : null;
                    if (busiVip != null) {
                        if (!(busiVip.length == 0)) {
                            z = false;
                        }
                    }
                    if (!z) {
                        vIPInfo.setBusiVip(busiVip);
                    }
                }
            }
            return vIPInfo;
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class e<T> implements Action1 {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(UserData userData) {
            if (userData == null || userData.getStatus() != 1) {
                VipCenterFragment.this.C.showFailView();
                return;
            }
            e.c.a.g.a.r.b.a(userData);
            SVIPExtInfoUtil.saveSVIPExtInfo(userData);
            if (!VipCenterFragment.this.F && e.c.a.g.a.r.b.O()) {
                e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.action.BECOME_VIP_STATE"));
            }
            VipCenterFragment.this.K0();
            VipCenterFragment.this.C.showContentView();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class f<T> implements Action1 {
        public f() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            VipCenterFragment.this.C.showFailView();
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VipCenterFragment.this.I0();
        }
    }

    public final a F0() {
        return e.c.a.g.a.r.b.O() ? new c(this) : new b(this);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void G() {
        super.G();
    }

    public final String G0() {
        boolean z = e.c.a.g.a.r.b.M() || e.c.a.g.a.r.b.z() == 6;
        boolean zQ = e.c.a.g.a.r.b.Q();
        return (zQ && z) ? "3" : z ? "2" : zQ ? "1" : "";
    }

    public final void H0() {
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            j.c(arguments);
            String string = arguments.getString("vip_source", "");
            j.d(string, "arguments!!.getString(VipJumpHelper.VIP_SOURCE, \"\")");
            this.G = string;
        }
    }

    public final void I0() {
        this.C.showLoadingView();
        i1.a(this.D);
        this.D = Observable.just("").subscribeOn(Schedulers.io()).map(d.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(), new f());
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public void J() {
        super.J();
    }

    public final void J0() {
        if (!e.c.a.g.a.f.b.d()) {
            TextView textView = this.A;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            } else {
                j.t("button");
                throw null;
            }
        }
        TextView textView2 = this.A;
        if (textView2 == null) {
            j.t("button");
            throw null;
        }
        textView2.setVisibility(0);
        String strK = e.c.a.g.a.r.b.O() ? e.c.a.g.a.g.p.b.f1018d.a().k() : e.c.a.g.a.g.p.b.f1018d.a().g();
        if (strK == null || strK.length() == 0) {
            ImageView imageView = this.B;
            if (imageView != null) {
                imageView.setVisibility(8);
                return;
            } else {
                j.t("openLabelIv");
                throw null;
            }
        }
        ImageView imageView2 = this.B;
        if (imageView2 == null) {
            j.t("openLabelIv");
            throw null;
        }
        imageView2.setVisibility(0);
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(this).load(strK);
        ImageView imageView3 = this.B;
        if (imageView3 != null) {
            requestBuilderLoad.into(imageView3);
        } else {
            j.t("openLabelIv");
            throw null;
        }
    }

    public final void K0() {
        TextView textView = this.s;
        if (textView == null) {
            j.t("mUserNameTv");
            throw null;
        }
        textView.setText(e.c.a.g.a.r.b.r());
        int iC = v1.c();
        if (iC > 0) {
            ImageView imageView = this.t;
            if (imageView == null) {
                j.t("mVipStateIv");
                throw null;
            }
            imageView.setImageResource(iC);
            ImageView imageView2 = this.t;
            if (imageView2 == null) {
                j.t("mVipStateIv");
                throw null;
            }
            imageView2.setVisibility(0);
        } else {
            ImageView imageView3 = this.t;
            if (imageView3 == null) {
                j.t("mVipStateIv");
                throw null;
            }
            imageView3.setVisibility(8);
        }
        RequestBuilder requestBuilderPlaceholder = Glide.with(this).load(e.c.a.g.a.r.b.t()).placeholder(R.drawable.icon_main_login_entry);
        ImageView imageView4 = this.r;
        if (imageView4 != null) {
            requestBuilderPlaceholder.into(imageView4);
        } else {
            j.t("mUserAvatarIv");
            throw null;
        }
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public float getSizeInDp() {
        if (l1.X()) {
            return 175.0f;
        }
        return AutoSizeConfig.getInstance().getDesignWidthInDp();
    }

    @Override // me.jessyan.autosize.internal.CustomAdapt
    public boolean isBaseOnWidth() {
        return AutoSizeConfig.getInstance().isBaseOnWidth();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment
    public int o() {
        return 4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        j.e(view, "v");
        if (!u1.g() && view.getId() == R.id.vip_button) {
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(this.G)) {
                bundle.putString("vip_source", this.G);
            }
            s0.a.C(bundle);
            boolean zO = e.c.a.g.a.r.b.O();
            e.c.a.g.a.e.b.b(new YoungBITask(12820968, "click").setType(zO ? "1" : "0").setSvar1(G0()).setSvar2(zO ? "1" : "2"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_vip_center, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.DelegateFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        o.a(this);
        i1.a(this.D);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(e.c.a.g.a.r.d.b bVar) {
        j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        K0();
        a aVarF0 = F0();
        this.E = aVarF0;
        if (aVarF0 == null) {
            return;
        }
        aVarF0.b();
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        EventBus.getDefault().register(this);
        H0();
        View viewFindViewById = view.findViewById(R.id.icon_login);
        j.d(viewFindViewById, "view.findViewById<ImageView>(R.id.icon_login)");
        this.r = (ImageView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.login_title);
        j.d(viewFindViewById2, "view.findViewById<TextView>(R.id.login_title)");
        this.s = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.iv_vip_state);
        j.d(viewFindViewById3, "view.findViewById<ImageView>(R.id.iv_vip_state)");
        this.t = (ImageView) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.vip_content_group);
        View viewFindViewById5 = view.findViewById(R.id.vip_content_title_1);
        j.d(viewFindViewById5, "view.findViewById(R.id.vip_content_title_1)");
        this.u = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.vip_content_desc_1);
        j.d(viewFindViewById6, "view.findViewById(R.id.vip_content_desc_1)");
        this.v = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.vip_content_title_2);
        j.d(viewFindViewById7, "view.findViewById(R.id.vip_content_title_2)");
        this.w = (TextView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.vip_content_desc_2);
        j.d(viewFindViewById8, "view.findViewById(R.id.vip_content_desc_2)");
        this.x = (TextView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.vip_content_title_3);
        j.d(viewFindViewById9, "view.findViewById(R.id.vip_content_title_3)");
        this.y = (TextView) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.vip_content_desc_3);
        j.d(viewFindViewById10, "view.findViewById(R.id.vip_content_desc_3)");
        this.z = (TextView) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.vip_button);
        j.d(viewFindViewById11, "view.findViewById(R.id.vip_button)");
        this.A = (TextView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.vip_open_label);
        j.d(viewFindViewById12, "view.findViewById(R.id.vip_open_label)");
        this.B = (ImageView) viewFindViewById12;
        J0();
        viewFindViewById4.setBackground(u1.d(x1.a(9), new int[]{-11616011, -4867841, -1520129}, GradientDrawable.Orientation.LEFT_RIGHT));
        TextView textView = this.A;
        if (textView == null) {
            j.t("button");
            throw null;
        }
        textView.setOnClickListener(this);
        a aVarF0 = F0();
        this.E = aVarF0;
        if (aVarF0 != null) {
            aVarF0.b();
        }
        this.C.bindView(view, new int[]{R.id.content_view, R.id.common_loading, R.id.common_refresh, -1, -1, -1, -1});
        view.findViewById(R.id.common_refresh).setOnClickListener(new g());
        K0();
        e.c.a.g.a.e.b.b(new YoungBITask(12820967, "exposure").setType(e.c.a.g.a.r.b.O() ? "1" : "0").setSvar1(G0()));
        I0();
    }
}
