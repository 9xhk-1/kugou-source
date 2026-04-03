package e.c.a.g.a.g.h;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.common.startAppAPM.task.ApmReportHelper;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u1;
import f.z.d.p;
import java.util.Objects;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements View.OnClickListener {
    public final DelegateFragment a;
    public final View b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f799d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f800f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f801h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f802i;

    public static final class a<T> implements Action1 {
        public final /* synthetic */ p b;

        public a(p pVar) {
            this.b = pVar;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            j.this.g(this.b.a);
        }
    }

    public j(DelegateFragment delegateFragment, ViewGroup viewGroup) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(viewGroup, "root");
        this.a = delegateFragment;
        View viewFindViewById = viewGroup.findViewById(R.id.vip_entry_container);
        this.b = viewFindViewById;
        this.f799d = (ImageView) viewGroup.findViewById(R.id.entry_icon);
        this.f800f = (TextView) viewGroup.findViewById(R.id.entry_title);
        this.f801h = (TextView) viewGroup.findViewById(R.id.entry_btn);
        this.f802i = -1;
        ViewParent parent = viewFindViewById.getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        this.f802i = ((ViewGroup) parent).indexOfChild(viewFindViewById);
        e();
        f();
        u1.b(this, viewFindViewById);
        p pVar = new p();
        ApmReportHelper.INSTANCE.startVipEntryAPM();
        if (e.c.a.g.a.f.b.c()) {
            viewFindViewById.setVisibility(0);
            pVar.a = true;
        } else {
            viewFindViewById.setVisibility(8);
            pVar.a = false;
        }
        m1.f(new a(pVar));
    }

    public final boolean b() {
        return this.b.getVisibility() == 0;
    }

    public final void c() {
        if (b()) {
            e.c.a.g.a.e.b.b(new YoungBITask(12820965, "exposure").setType(e.c.a.g.a.r.b.O() ? "1" : "0"));
        }
    }

    public final void d() {
        if (b()) {
            e();
            f();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e() {
        /*
            r7 = this;
            e.c.a.g.a.g.p.b$b r0 = e.c.a.g.a.g.p.b.f1018d
            e.c.a.g.a.g.p.b r0 = r0.a()
            e.c.a.g.a.g.p.d.f r0 = r0.i()
            boolean r1 = e.c.a.g.a.r.b.F()
            if (r1 == 0) goto L18
            boolean r1 = e.c.a.g.a.r.b.O()
            if (r1 == 0) goto L18
            r1 = 1
            goto L19
        L18:
            r1 = 0
        L19:
            r2 = 0
            if (r1 == 0) goto L24
            if (r0 != 0) goto L1f
            goto L26
        L1f:
            java.lang.String r3 = r0.g()
            goto L2c
        L24:
            if (r0 != 0) goto L28
        L26:
            r3 = r2
            goto L2c
        L28:
            java.lang.String r3 = r0.c()
        L2c:
            if (r1 == 0) goto L36
            if (r0 != 0) goto L31
            goto L38
        L31:
            java.lang.String r4 = r0.h()
            goto L3e
        L36:
            if (r0 != 0) goto L3a
        L38:
            r4 = r2
            goto L3e
        L3a:
            java.lang.String r4 = r0.d()
        L3e:
            java.lang.String r5 = "会员"
            java.lang.String r4 = e.c.a.g.a.s.h1.q(r4, r5)
            if (r1 == 0) goto L55
            if (r0 != 0) goto L4a
            r5 = r2
            goto L4e
        L4a:
            java.lang.String r5 = r0.e()
        L4e:
            java.lang.String r6 = "续费"
            java.lang.String r5 = e.c.a.g.a.s.h1.q(r5, r6)
            goto L63
        L55:
            if (r0 != 0) goto L59
            r5 = r2
            goto L5d
        L59:
            java.lang.String r5 = r0.a()
        L5d:
            java.lang.String r6 = "开通"
            java.lang.String r5 = e.c.a.g.a.s.h1.q(r5, r6)
        L63:
            if (r1 == 0) goto L6d
            if (r0 != 0) goto L68
            goto L74
        L68:
            java.lang.String r2 = r0.f()
            goto L74
        L6d:
            if (r0 != 0) goto L70
            goto L74
        L70:
            java.lang.String r2 = r0.b()
        L74:
            com.kugou.android.watch.lite.base.fragment.DelegateFragment r0 = r7.a
            com.bumptech.glide.RequestManager r0 = com.bumptech.glide.Glide.with(r0)
            com.bumptech.glide.RequestBuilder r0 = r0.load(r3)
            r1 = 2131165482(0x7f07012a, float:1.7945182E38)
            com.bumptech.glide.request.BaseRequestOptions r0 = r0.error(r1)
            com.bumptech.glide.RequestBuilder r0 = (com.bumptech.glide.RequestBuilder) r0
            android.widget.ImageView r1 = r7.f799d
            r0.into(r1)
            android.widget.TextView r0 = r7.f800f
            r0.setText(r4)
            android.widget.TextView r0 = r7.f801h
            r0.setText(r5)
            android.widget.TextView r0 = r7.f801h
            r1 = 25
            int r1 = e.c.a.g.a.s.x1.a(r1)
            r3 = -13581582(0xffffffffff30c2f2, float:-2.3495634E38)
            int r2 = e.c.a.g.a.s.g.b(r2, r3)
            android.graphics.drawable.GradientDrawable r1 = e.c.a.g.a.s.u1.c(r1, r2)
            r0.setBackground(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.g.h.j.e():void");
    }

    public final void f() {
        ViewParent parent = this.b.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(this.b);
            int i2 = (e.c.a.g.a.r.b.F() && e.c.a.g.a.r.b.O()) ? this.f802i : 3;
            if (iIndexOfChild != i2) {
                viewGroup.removeView(this.b);
                viewGroup.addView(this.b, f.b0.f.e(i2, viewGroup.getChildCount()));
            }
        }
    }

    public final void g(boolean z) {
        String strL = "";
        if (z) {
            ApmReportHelper.INSTANCE.vipEntryAPMSuccess("");
            return;
        }
        int i2 = 0;
        try {
            String strJ = l1.j();
            if (!e.c.a.g.a.f.b.a()) {
                i2 = 1;
                strL = f.z.d.j.l("配置不展示 channel = ", strJ);
            } else if (f.z.d.j.a(strJ, "150") && !l1.m0()) {
                i2 = 2;
                strL = f.z.d.j.l("客户端异常渠道号出错 channel = ", strJ);
            } else if (l1.m0() && f.z.d.j.a(e.c.a.g.a.f.b.a, Boolean.FALSE)) {
                i2 = 3;
                strL = f.z.d.j.l("小天才系统不支持支付 channel = ", strJ);
            } else if (l1.V()) {
                i2 = 4;
            } else if (l1.g0()) {
                i2 = 5;
            } else if (l1.m0() || l1.g0() || l1.V() || l1.X()) {
                strL = f.z.d.j.l("其他异常 channel = ", strJ);
                i2 = 7;
            } else {
                i2 = 6;
                strL = f.z.d.j.l("这个渠道本来就不支持 channel = ", strJ);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ApmReportHelper.INSTANCE.failVipEntryAPM(Integer.valueOf(i2), strL);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.z.d.j.e(view, "view");
        if (u1.g()) {
            return;
        }
        boolean zO = e.c.a.g.a.r.b.O();
        e.c.a.g.a.e.b.b(new YoungBITask(12820966, "click").setType(zO ? "1" : "0").setSvar1(zO ? "1" : "0"));
        if (view.getId() == R.id.vip_entry_container) {
            if (!e.c.a.g.a.r.b.F()) {
                s0.a.l("8");
                return;
            }
            if (zO) {
                s0.a.A();
                return;
            }
            s0 s0Var = s0.a;
            s0Var.A();
            Bundle bundle = new Bundle();
            bundle.putBoolean("viewpager_framework_delegate_open_two_fragment", true);
            s0Var.C(bundle);
        }
    }
}
