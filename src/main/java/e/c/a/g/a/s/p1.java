package e.c.a.g.a.s;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.datacollect.bi.use.TraceFullTask;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class p1 {
    public static boolean a;
    public static boolean b;
    public static Boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f1218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f1219e;

    public class a implements Action1<String> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ CharSequence b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1220d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f1221f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f1222h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ int f1223i;
        public final /* synthetic */ StringBuilder j;
        public final /* synthetic */ String k;

        public a(Context context, CharSequence charSequence, int i2, int i3, int i4, int i5, StringBuilder sb, String str) {
            this.a = context;
            this.b = charSequence;
            this.f1220d = i2;
            this.f1221f = i3;
            this.f1222h = i4;
            this.f1223i = i5;
            this.j = sb;
            this.k = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            p1.c(this.a, this.b, this.f1220d, this.f1221f, this.f1222h, this.f1223i).show();
            p1.d(this.j, this.k);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ StringBuilder b;

        public b(String str, StringBuilder sb) {
            this.a = str;
            this.b = sb;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                boolean zContains = !TextUtils.isEmpty(this.a) ? this.a.contains("isFilter") : false;
                TraceFullTask type = new YoungBITask(22020029, "statistics").setType("2");
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(zContains ? 1 : 0);
                TraceFullTask svar1 = type.setIvar1(sb.toString()).setFs("toast上报").setSvar1(this.b.toString());
                StringBuilder sb2 = new StringBuilder();
                String str = "会员";
                sb2.append(e.c.a.g.a.r.b.O() ? "会员" : "非会员");
                sb2.append(", ");
                sb2.append(e.c.a.g.a.r.b.F() ? "登录" : "未登录");
                e.c.a.g.a.e.b.b(svar1.setSvar3(sb2.toString()).setSvar2(this.a));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("1,");
                sb3.append(zContains ? 1 : 0);
                sb3.append("2,");
                sb3.append((Object) this.b);
                sb3.append("3,");
                if (!e.c.a.g.a.r.b.O()) {
                    str = "非会员";
                }
                sb3.append(str);
                sb3.append("4,");
                sb3.append(this.a);
                e.c.a.g.a.d.d0.a.a("ToastUtils", sb3.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static {
        a = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.f0, 1) == 1;
        b = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.h0, 1) == 1;
        f1218d = "tips_key";
        f1219e = "need_jump_app";
    }

    public static e.c.a.g.a.s.z1.c c(Context context, CharSequence charSequence, int i2, int i3, int i4, int i5) {
        e.c.a.g.a.s.z1.c cVarA = e.c.a.g.a.s.z1.c.a(context, charSequence, i2);
        if (i3 != 0) {
            cVarA.setGravity(i3, i4, i5);
        }
        n(context, cVarA, cVarA.getView());
        cVarA.setGravity(17, 0, 0);
        cVarA.setText(charSequence);
        if (Build.VERSION.SDK_INT == 25) {
            o1.a(cVarA);
        }
        return cVarA;
    }

    public static void d(StringBuilder sb, String str) {
        if (a) {
            j0.b().a(new b(str, sb));
        } else {
            Log.e("mhs_watch", "needReprotToastStack = false");
        }
    }

    public static void e(Context context, CharSequence charSequence, int i2, int i3, int i4, int i5, String str) {
        Context context2;
        if (context == null) {
            return;
        }
        try {
            Boolean boolValueOf = Boolean.valueOf(e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.i4, true));
            c = boolValueOf;
            context2 = boolValueOf.booleanValue() ? KGApplication.getContext() : context;
        } catch (Throwable th) {
            th.printStackTrace();
            context2 = context;
        }
        CharSequence charSequenceE = e.c.a.g.a.f.i.m.a().e(charSequence);
        if (TextUtils.isEmpty(charSequenceE)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("toast: ");
        sb.append(charSequenceE);
        if (!b) {
            sb.append("\n,stack: ");
            sb.append(Log.getStackTraceString(new Throwable("toast-stacktrace")));
        }
        try {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                Observable.just("").observeOn(AndroidSchedulers.mainThread()).subscribe(new a(context2, charSequenceE, i2, i3, i4, i5, sb, str), i1.b);
            } else {
                c(context2, charSequenceE, i2, i3, i4, i5).show();
                d(sb, str);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void f(Context context, CharSequence charSequence) {
        e(context, charSequence, 1, 17, 0, 0, "");
    }

    public static void g(Context context, int i2) {
        l(context, context.getResources().getString(i2), 17);
    }

    public static void h(Context context, CharSequence charSequence) {
        l(context, charSequence, 17);
    }

    public static void i(Context context, CharSequence charSequence, String str) {
        e(context, charSequence, 0, 17, 0, 0, str);
    }

    public static void j(Context context, CharSequence charSequence, String str, boolean z) {
        e(context, charSequence, 0, 17, 0, 0, str);
        if (z) {
            m("" + ((Object) charSequence));
        }
    }

    public static void k(Context context, CharSequence charSequence, boolean z) {
        l(context, charSequence, 17);
        if (z) {
            m("" + ((Object) charSequence));
        }
    }

    public static void l(Context context, CharSequence charSequence, int i2) {
        e(context, charSequence, 0, i2, 0, 0, "");
    }

    public static void m(String str) {
        if (l1.m0() && e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.i0, 1) == 1) {
            Intent intent = new Intent("com.kugou.young.watch.xtc.toast.sys");
            intent.putExtra(f1218d, str);
            e.c.a.g.a.f.d.a.d(intent);
        }
    }

    public static void n(Context context, e.c.a.g.a.s.z1.c cVar, View view) {
        if (view == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-298634445);
        gradientDrawable.setCornerRadius(l1.c(8.0f));
        view.setBackground(gradientDrawable);
        view.setPadding(0, 0, 0, 0);
        TextView textView = (TextView) view.findViewById(R.id.message);
        if (textView != null) {
            cVar.c(textView);
            textView.setBackground(null);
            textView.setTextSize(2, 16.0f);
            textView.setTextColor(-1);
            textView.setGravity(17);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            if (marginLayoutParams != null) {
                marginLayoutParams.setMargins(0, 0, 0, 0);
                if (l1.n0() || l1.X() || l1.b0() || l1.N()) {
                    marginLayoutParams.width = l1.z(context);
                    marginLayoutParams.height = -2;
                }
                textView.setLayoutParams(marginLayoutParams);
            }
            int iD = l1.d(context, 10.0f);
            int iD2 = l1.d(context, 8.0f);
            textView.setPadding(iD, iD2, iD, iD2);
        }
    }
}
