package e.c.a.g.a.r.e.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.user.login.UserData;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.g1;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends g1.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DelegateFragment f1183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f1184i;
    public final b j;
    public final ScrollView k;
    public final String l;
    public final FrameLayout m;
    public final View n;
    public final View o;
    public boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public boolean t;

    public a(DelegateFragment delegateFragment, View view, int i2, b bVar, ScrollView scrollView) {
        j.e(delegateFragment, "fragment");
        j.e(view, "view");
        this.f1183h = delegateFragment;
        this.f1184i = view;
        this.j = bVar;
        this.k = scrollView;
        this.l = "AbsLoginStyle";
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.style_container);
        this.m = frameLayout;
        this.n = view.findViewById(R.id.login_entry_container);
        this.o = LayoutInflater.from(view.getContext()).inflate(i2, (ViewGroup) frameLayout, false);
        c.b bVar2 = e.c.a.g.a.f.e.c.a;
        this.q = bVar2.a().getConfigAsInt(e.c.a.g.a.f.e.b.G0, 1) == 1;
        this.r = bVar2.a().getConfigAsInt(e.c.a.g.a.f.e.b.H0, 0) == 1;
        this.s = bVar2.a().getConfigAsInt(e.c.a.g.a.f.e.b.l0, 1) == 1;
    }

    public static /* synthetic */ void A(a aVar, String str, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportHead");
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        aVar.z(str, str2);
    }

    public static /* synthetic */ void t(a aVar, Integer num, UserData userData, Integer num2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loginStatusReport");
        }
        if ((i2 & 2) != 0) {
            userData = null;
        }
        if ((i2 & 4) != 0) {
            num2 = -100;
        }
        aVar.s(num, userData, num2);
    }

    public final void B(boolean z) {
        if (g0.f()) {
            Log.e("mhs_watch", j.l(" showLoginEntryContainer loginEntryContainer = ", this.n));
        }
        View view = this.n;
        if (view == null || view == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // e.c.a.g.a.s.g1.b
    public void d(Object obj) {
        super.d(obj);
        FrameLayout frameLayout = this.m;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        FrameLayout frameLayout2 = this.m;
        if (frameLayout2 == null) {
            return;
        }
        frameLayout2.addView(this.o);
    }

    @Override // e.c.a.g.a.s.g1.b
    public void e() {
        super.e();
        FrameLayout frameLayout = this.m;
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
    }

    public final void g(e.c.a.g.a.n.b.c cVar) {
        if (TextUtils.isEmpty(cVar == null ? null : cVar.f1121g)) {
            return;
        }
        A(this, j.l("检查token 返回结果，confirmLogin = ", cVar == null ? null : cVar.f1121g), null, 2, null);
    }

    public String h() {
        return "AbsLoginStyle";
    }

    public final View i() {
        return this.o;
    }

    public final Context j() {
        Context context = this.f1183h.getContext();
        if (context != null) {
            return context;
        }
        Context context2 = KGApplication.getContext();
        j.d(context2, "getContext()");
        return context2;
    }

    public final boolean k() {
        return this.p;
    }

    public final DelegateFragment l() {
        return this.f1183h;
    }

    public final String m(e.c.a.g.a.n.b.c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("检查token token登录 loginStatus: ");
        sb.append("nickName->");
        sb.append(cVar == null ? null : cVar.f1119e);
        sb.append(" userId->");
        sb.append(cVar == null ? null : Long.valueOf(cVar.f1118d));
        sb.append(" token->");
        sb.append(cVar != null ? cVar.f1121g : null);
        String string = sb.toString();
        j.d(string, "loginData.toString()");
        return string;
    }

    public final b n() {
        return this.j;
    }

    public final ScrollView o() {
        return this.k;
    }

    public final String p(e.c.a.g.a.n.b.d dVar) {
        if (dVar == null) {
            return null;
        }
        return dVar.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String q(e.c.a.g.a.n.b.a r7) {
        /*
            r6 = this;
            boolean r0 = r6.q
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L39
            if (r7 != 0) goto Lb
            r0 = r3
            goto Ld
        Lb:
            java.lang.String r0 = r7.f1116d
        Ld:
            if (r0 == 0) goto L18
            int r0 = r0.length()
            if (r0 != 0) goto L16
            goto L18
        L16:
            r0 = 0
            goto L19
        L18:
            r0 = 1
        L19:
            if (r0 != 0) goto L39
            if (r7 != 0) goto L1f
            r0 = r3
            goto L21
        L1f:
            java.lang.String r0 = r7.f1116d
        L21:
            if (r7 != 0) goto L25
            r4 = r3
            goto L29
        L25:
            java.lang.String r4 = r7.a()
        L29:
            r5 = 2
            boolean r0 = f.e0.n.m(r0, r4, r1, r5, r3)
            if (r0 == 0) goto L31
            goto L39
        L31:
            if (r7 != 0) goto L34
            goto L36
        L34:
            java.lang.String r3 = r7.f1116d
        L36:
            r6.p = r2
            goto L42
        L39:
            if (r7 != 0) goto L3c
            goto L40
        L3c:
            java.lang.String r3 = r7.b(r2)
        L40:
            r6.p = r1
        L42:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.r.e.k.a.q(e.c.a.g.a.n.b.a):java.lang.String");
    }

    public final boolean r() {
        return this.r;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0095 A[Catch: Exception -> 0x0116, TryCatch #0 {Exception -> 0x0116, blocks: (B:5:0x000e, B:7:0x0014, B:32:0x009c, B:45:0x00d5, B:51:0x0100, B:55:0x010e, B:54:0x0106, B:48:0x00f0, B:50:0x00f6, B:35:0x00ab, B:38:0x00b9, B:41:0x00c6, B:29:0x008f, B:31:0x0095, B:25:0x0086, B:21:0x007d, B:15:0x006b, B:17:0x0071, B:10:0x0032, B:12:0x0038), top: B:60:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(java.lang.Integer r10, com.kugou.android.watch.lite.user.login.UserData r11, java.lang.Integer r12) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.g.a.r.e.k.a.s(java.lang.Integer, com.kugou.android.watch.lite.user.login.UserData, java.lang.Integer):void");
    }

    public void u() {
    }

    public void v() {
    }

    public void w() {
    }

    public void x() {
    }

    public final void y(int i2, e.c.a.g.a.n.b.c cVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                A(this, "switchViewVisibility" + i2 + ", codeInfo =" + cVar, null, 2, null);
            } else if (!this.t) {
                A(this, "switchViewVisibility" + i2 + ", codeInfo =" + cVar, null, 2, null);
                this.t = true;
            }
        }
        if (i2 == 0 || i2 == 1 || i2 == 5) {
            this.t = false;
        }
    }

    public final void z(String str, String str2) {
        if (!this.s) {
            if (g0.f()) {
                g0.c("mhs_watch", j.l("TYPE_LOGIN needReport = ", Boolean.valueOf(this.s)));
                return;
            }
            return;
        }
        e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("4").setFo("/首页/登录页面").setTab(str2).setSvar1(str).setSvar2(h()));
        e.c.a.g.a.d.d0.a.a(this.l, "page /首页/登录页面 1," + ((Object) str2) + ", 2," + ((Object) str) + ", 3 " + h());
    }
}
