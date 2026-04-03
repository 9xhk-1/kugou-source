package e.c.a.g.a.g.e;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.startAppAPM.task.RingBiReportHelper;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e a = new e();
    public static boolean b = e.c.a.g.a.g.e.d.a.k();
    public static Subscription c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Subscription f756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static e.c.a.g.a.d.h.a f757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Subscription f760h;

    public interface a {
        void dismiss();

        void onNo();

        void onYes();
    }

    public static final class b<T> implements Action1 {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        public b(String str, int i2) {
            this.a = str;
            this.b = i2;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<String> cVar) {
            Log.e("mhs_watch_grade", f.z.d.j.l("api resp.isSuccess = ", cVar == null ? null : Boolean.valueOf(cVar.f())));
            String str = cVar.f() ? "成功" : "失败";
            RingBiReportHelper.INSTANCE.reportHeadGrade("checkAndUploadBindMid 上传结果 result = " + str + ", resp.data = " + ((Object) cVar.a()), this.a);
            if (cVar.f()) {
                if (this.b == 1) {
                    EventBus.getDefault().post(new e.c.a.g.a.g.e.g.a(1));
                }
                Log.e("mhs_watch_grade", f.z.d.j.l("uploadBindMid success resp.data = ", cVar.a()));
            } else if (cVar.b() == 20002 || cVar.b() == 20003) {
                p1.h(KGApplication.getContext(), "网络异常，请稍后重试");
            } else if (TextUtils.isEmpty(cVar.c())) {
                p1.h(KGApplication.getContext(), "网络异常，请稍后重试");
            } else {
                p1.h(KGApplication.getContext(), cVar.c());
            }
        }
    }

    public static final class c<T> implements Action1 {
        public static final c<T> a = new c<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            Log.e("mhs_watch_grade", f.z.d.j.l("uploadGradeResult success resp.error error = ", th));
        }
    }

    public static final class d<T> implements Action1 {
        public static final d<T> a = new d<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<String> cVar) {
            Log.e("mhs_watch_grade", f.z.d.j.l("getLimitSong api resp.isSuccess = ", Boolean.valueOf(cVar.f())));
            String str = cVar.f() ? "成功" : "失败";
            RingBiReportHelper.reportHeadGrade$default(RingBiReportHelper.INSTANCE, "getLimitSong 上传结果 result = " + str + ", resp.errorMsg = " + ((Object) cVar.c()) + ", resp.errcode = " + cVar.b(), null, 2, null);
            if (cVar.f()) {
                try {
                    JSONArray jSONArray = new JSONObject(cVar.a()).getJSONArray("mixsongids");
                    String[] strArr = new String[jSONArray.length()];
                    int i2 = 0;
                    int length = jSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            strArr[i2] = jSONArray.getString(i2);
                            if (i3 >= length) {
                                break;
                            } else {
                                i2 = i3;
                            }
                        }
                    }
                    String strN = f.u.i.n(strArr, ",", null, null, 0, null, null, 62, null);
                    e.c.a.g.a.g.e.f.a(KGApplication.getContext()).c(e.c.a.g.a.g.e.f.c, strN);
                    Log.e("mhs_watch_grade", "getLimitSong success resp mixsongids = " + jSONArray + ", concatenatedString = " + strN);
                    e.c.a.g.a.g.o.b.s();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.e.e$e, reason: collision with other inner class name */
    public static final class C0118e<T> implements Action1 {
        public static final C0118e<T> a = new C0118e<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            Log.e("mhs_watch_grade", f.z.d.j.l("uploadGradeResult success resp.error error = ", th));
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ a a;

        public f(a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e eVar = e.a;
            eVar.h(true);
            eVar.b(1);
            eVar.i(null);
            RingBiReportHelper.INSTANCE.reportHeadGrade("showWillBindDialog 同意 ", "");
            a aVar = this.a;
            if (aVar == null) {
                return;
            }
            aVar.onYes();
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ a a;

        public g(a aVar) {
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e.a.i(null);
            RingBiReportHelper.INSTANCE.reportHeadGrade("showWillBindDialog 取消 ", "");
            a aVar = this.a;
            if (aVar == null) {
                return;
            }
            aVar.onNo();
        }
    }

    public static final class h implements DialogInterface.OnDismissListener {
        public final /* synthetic */ a a;

        public h(a aVar) {
            this.a = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.dismiss();
            }
            e eVar = e.a;
            if (eVar.d()) {
                return;
            }
            eVar.b(4);
            Log.e("mhs_watch_updategrade", "弹窗取消强制重置");
        }
    }

    public static final class i<T> implements Action1 {
        public final /* synthetic */ String a;

        public i(String str) {
            this.a = str;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(e.c.a.g.a.f.k.c<String> cVar) {
            Log.e("mhs_watch_grade", f.z.d.j.l("api resp.isSuccess = ", Boolean.valueOf(cVar.f())));
            String str = cVar.f() ? "成功" : "失败";
            RingBiReportHelper.INSTANCE.reportHeadGrade("uploadAgeResult 上传结果 result = " + str + ", resp.data = " + ((Object) cVar.a()), this.a);
            if (cVar.f()) {
                try {
                    int i2 = new JSONObject(cVar.a()).getInt("level");
                    e.c.a.g.a.f.m.c.a.g("xtc_family_level", i2);
                    Log.e("mhs_watch_grade", f.z.d.j.l("uploadAgeResult success resp 等级 = ", Integer.valueOf(i2)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static final class j<T> implements Action1 {
        public static final j<T> a = new j<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            Log.e("mhs_watch_grade", f.z.d.j.l("uploadGradeResult success resp.error error = ", th));
        }
    }

    public final void a(String str) {
        f.z.d.j.e(str, "age");
        Log.d("mhs_watch_grade", f.z.d.j.l("checkAndReportIfNeeded do., watch.switch.upload_history_enable = ", Boolean.valueOf(b)));
        if (!b) {
            Log.e("mhs_watch_grade", "checkAndReportIfNeeded switch false.");
        } else if (u0.n(KGApplication.getContext(), false)) {
            k(str);
        } else {
            Log.e("mhs_watch_grade", f.z.d.j.l("checkAndReportIfNeeded 没有login直接返回, isGlobalNetAvailable = ", Boolean.valueOf(u0.n(KGApplication.getContext(), false))));
        }
    }

    public final void b(int i2) {
        Log.d("mhs_watch_grade", f.z.d.j.l("checkAndUploadBindMid do., watch.switch.upload_history_enable = ", Boolean.valueOf(b)));
        if (!b) {
            Log.e("mhs_watch_grade", "checkAndUploadBindMid switch false.");
            return;
        }
        if (!u0.n(KGApplication.getContext(), false)) {
            Log.e("mhs_watch_grade", f.z.d.j.l("checkAndUploadBindMid 没有login直接返回, isGlobalNetAvailable = ", Boolean.valueOf(u0.n(KGApplication.getContext(), false))));
            return;
        }
        String strL = f.z.d.j.l("uploadApi 绑定 status = ", Integer.valueOf(i2));
        RingBiReportHelper.reportHeadGrade$default(RingBiReportHelper.INSTANCE, f.z.d.j.l("家长分级，从小天才获取到的值 = ", strL), null, 2, null);
        i1.a(f756d);
        f756d = e.c.a.g.a.g.e.b.a.d(i2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(strL, i2), c.a);
    }

    public final void c() {
        Log.d("mhs_watch_grade", f.z.d.j.l("checkAndReportIfNeeded do., watch.switch.upload_history_enable = ", Boolean.valueOf(b)));
        if (!b) {
            Log.e("mhs_watch_grade", "checkAndReportIfNeeded switch false.");
        } else if (!u0.n(KGApplication.getContext(), false)) {
            Log.e("mhs_watch_grade", f.z.d.j.l("checkAndReportIfNeeded 没有login直接返回, isGlobalNetAvailable = ", Boolean.valueOf(u0.n(KGApplication.getContext(), false))));
        } else {
            i1.a(f760h);
            f760h = e.c.a.g.a.g.e.b.a.b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(d.a, C0118e.a);
        }
    }

    public final boolean d() {
        return f758f;
    }

    public final boolean e() {
        e.c.a.g.a.d.h.a aVar = f757e;
        if (aVar != null) {
            if (aVar != null && aVar.isShowing()) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return f759g >= 3;
    }

    public final void g() {
        f759g = 0;
        i1.a(f756d);
        i1.a(f760h);
    }

    public final void h(boolean z) {
        f758f = z;
    }

    public final void i(e.c.a.g.a.d.h.a aVar) {
        f757e = aVar;
    }

    public final void j(Activity activity, a aVar) {
        f.z.d.j.e(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        f.z.d.j.e(aVar, "bindListener");
        if (e()) {
            Log.d("mhs_watch", "弹窗正在展示");
            return;
        }
        f759g++;
        RingBiReportHelper.INSTANCE.reportHeadGrade(f.z.d.j.l("showWillBindDialog 展示", "即将绑定该设备，请确认是否为家长操作"), "");
        f758f = false;
        e.c.a.g.a.d.h.a aVar2 = new e.c.a.g.a.d.h.a(activity);
        f757e = aVar2;
        aVar2.setCancelable(false);
        aVar2.setCanceledOnTouchOutside(false);
        aVar2.e("即将绑定该设备，请确认是否为家长操作");
        aVar2.a("取消");
        aVar2.b("确认");
        aVar2.d(new f(aVar));
        aVar2.c(new g(aVar));
        aVar2.show();
        aVar2.setOnDismissListener(new h(aVar));
    }

    public final void k(String str) {
        String strL = f.z.d.j.l("uploadApi key = ", str);
        RingBiReportHelper.reportHeadGrade$default(RingBiReportHelper.INSTANCE, f.z.d.j.l("家长分级，从小天才获取到的值 = ", strL), null, 2, null);
        i1.a(c);
        c = e.c.a.g.a.g.e.b.a.c(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(strL), j.a);
    }
}
