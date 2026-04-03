package e.c.a.g.a.g.g.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.feedback.FeedbackFragment;
import com.kugou.common.datacollect.senter.DeviceFingerModel;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import e.c.a.g.a.r.d.d.a;
import e.c.a.g.a.r.f.a;
import e.c.a.g.a.s.b0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.p1;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.apache.http.cookie.ClientCookie;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public Subscription a = null;
    public String b = "";

    public class a implements Func1<List<e.c.a.g.a.r.c.a>, e> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f783d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f784f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f785h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f786i;
        public final /* synthetic */ int j;

        public a(c cVar, String str, String str2, int i2, int i3, String str3, String str4, int i4) {
            this.a = str;
            this.b = str2;
            this.f783d = i2;
            this.f784f = i3;
            this.f785h = str3;
            this.f786i = str4;
            this.j = i4;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call(List<e.c.a.g.a.r.c.a> list) {
            return c.e(this.a, this.b, this.f783d + 1, this.f784f, this.f785h, this.f786i, this.j, list);
        }
    }

    public class b implements Func1<List<e.c.a.g.a.r.c.a>, Observable<List<e.c.a.g.a.r.c.a>>> {
        public final /* synthetic */ FeedbackFragment a;

        public class a implements Func1<List<a.c>, Observable<List<e.c.a.g.a.r.c.a>>> {
            public final /* synthetic */ List a;

            public a(b bVar, List list) {
                this.a = list;
            }

            @Override // rx.functions.Func1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Observable<List<e.c.a.g.a.r.c.a>> call(List<a.c> list) {
                return Observable.just(this.a);
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.g.g.c.c$b$b, reason: collision with other inner class name */
        public class C0120b implements Func0<List<a.c>> {
            public C0120b(b bVar) {
            }

            @Override // rx.functions.Func0, java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<a.c> call() {
                return new ArrayList();
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.g.g.c.c$b$c, reason: collision with other inner class name */
        public class C0121c implements Action2<List<a.c>, a.c> {
            public C0121c(b bVar) {
            }

            @Override // rx.functions.Action2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(List<a.c> list, a.c cVar) {
                if (cVar == null || cVar.a != 1) {
                    return;
                }
                list.add(cVar);
            }
        }

        public class d implements Func1<e.c.a.g.a.r.c.a, Observable<a.c>> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;

            public class a implements Func1<a.c, a.c> {
                public final /* synthetic */ e.c.a.g.a.r.c.a a;

                public a(e.c.a.g.a.r.c.a aVar) {
                    this.a = aVar;
                }

                public a.c a(a.c cVar) {
                    if (cVar.a == 1) {
                        e.c.a.g.a.r.c.a aVar = this.a;
                        aVar.f1159f = cVar.b;
                        aVar.f1160h = d.this.b + cVar.b;
                        b.this.a.R0("reportFeedbackWithUpload 上传成功， result = " + cVar + ", entry = " + this.a);
                    } else {
                        b.this.a.R0("reportFeedbackWithUpload 上传失败， result = " + cVar);
                    }
                    return cVar;
                }

                @Override // rx.functions.Func1
                public /* bridge */ /* synthetic */ a.c call(a.c cVar) {
                    a.c cVar2 = cVar;
                    a(cVar2);
                    return cVar2;
                }
            }

            public d(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // rx.functions.Func1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Observable<a.c> call(e.c.a.g.a.r.c.a aVar) {
                return e.c.a.g.a.r.f.a.e(aVar.a(), c.this.b(), this.a).map(new a(aVar));
            }
        }

        public b(FeedbackFragment feedbackFragment) {
            this.a = feedbackFragment;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable<List<e.c.a.g.a.r.c.a>> call(List<e.c.a.g.a.r.c.a> list) {
            a.C0178a c0178aC = e.c.a.g.a.r.d.d.a.c(c.this.b(), "", "POST");
            if (c0178aC == null || c0178aC.a != 1 || TextUtils.isEmpty(c0178aC.b)) {
                this.a.R0("reportFeedbackWithUpload  认证失败， entity = " + c0178aC);
                throw new RuntimeException();
            }
            this.a.R0("reportFeedbackWithUpload  认证成功， entity = " + c0178aC);
            return Observable.from(list).flatMap(new d(c0178aC.b, c.this.d())).collect(new C0120b(this), new C0121c(this)).flatMap(new a(this, list));
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.g.c.c$c, reason: collision with other inner class name */
    public class RunnableC0122c implements Runnable {
        public final /* synthetic */ e a;

        public RunnableC0122c(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.c.a.g.a.g.g.d.a.g(this.a.a(), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String c() {
        return "" + e.c.a.g.a.f.m.b.m().h(2) + "-" + ((l.b(KGApplication.getContext()) / 1024) / 1024) + "-" + l.c() + "-" + (l1.X() ? DeviceFingerModel.getLauncherTag(KGApplication.getContext()) : "");
    }

    public static e e(String str, String str2, int i2, int i3, String str3, String str4, int i4, List<e.c.a.g.a.r.c.a> list) {
        try {
            e eVar = new e();
            TreeMap treeMap = new TreeMap();
            long configAsLong = e.c.a.g.a.f.e.c.c().getConfigAsLong(e.c.a.g.a.f.e.b.c);
            int iC = e.c.a.g.a.r.e.b.c(KGApplication.getContext());
            String strC = c();
            String strN = l1.n(KGApplication.getContext());
            treeMap.put("appid", String.valueOf(configAsLong));
            treeMap.put("clientver", String.valueOf(iC));
            treeMap.put("clienttime", (System.currentTimeMillis() / 1000) + "");
            treeMap.put("dfid", m.e());
            treeMap.put("mid", strN);
            treeMap.put("iscrash", "2");
            treeMap.put("content", str);
            treeMap.put("plat", l1.r(KGApplication.getContext()));
            treeMap.put("contact", str2);
            treeMap.put("mode", l1.q());
            treeMap.put(ClientCookie.VERSION_ATTR, String.valueOf(l1.G()));
            treeMap.put("nettype", l1.o(KGApplication.getContext()));
            treeMap.put(NotificationCompat.CATEGORY_SYSTEM, l1.u());
            treeMap.put("preversion", "" + e.c.a.g.a.d.c.a.a.a());
            treeMap.put("user_id", String.valueOf(e.c.a.g.a.r.b.o()));
            treeMap.put("deviceid", strN);
            treeMap.put("viptype", f());
            treeMap.put("flowtype", "0");
            treeMap.put("ctype", String.valueOf(i2));
            treeMap.put("patchid", l1.j());
            treeMap.put("feedbacktype", String.valueOf(i3));
            treeMap.put("isjailbreak", String.valueOf(0));
            treeMap.put("memory", strC);
            treeMap.put("gitversion", b0.a());
            if (i3 == 1 || i3 == 2) {
                StringBuffer stringBuffer = new StringBuffer();
                if (list != null && !list.isEmpty()) {
                    for (int i5 = 0; i5 < list.size(); i5++) {
                        String str5 = list.get(i5).f1160h;
                        if (!TextUtils.isEmpty(str5)) {
                            stringBuffer.append(str5);
                        }
                        if (i5 < list.size() - 1) {
                            stringBuffer.append(RetryStaticsLOG.MARK_SEPERATE);
                        }
                    }
                }
                treeMap.put("pics", stringBuffer.toString());
            }
            treeMap.put("soversion", "");
            treeMap.put("faq_category", str3);
            treeMap.put("faq_question", str4 + "  memory:" + strC + "  src:" + i4);
            if (g0.a) {
                g0.b("zlx_fb", "commit feedback params: " + treeMap.toString());
            }
            d dVar = new d(treeMap);
            f fVar = new f();
            e.c.a.g.a.f.k.k.e.a().request(dVar, fVar);
            fVar.getResponseData(eVar);
            return eVar;
        } catch (Exception e2) {
            g0.k(e2);
            return null;
        }
    }

    public static String f() {
        return !e.c.a.g.a.r.b.F() ? "1" : e.c.a.g.a.r.b.O() ? "3" : "2";
    }

    public static /* synthetic */ void g(FeedbackFragment feedbackFragment, int i2, String str, e eVar) {
        boolean z;
        feedbackFragment.i0();
        String str2 = "提交成功";
        if (eVar == null || eVar.a() == null) {
            p1.h(e.c.c.o.f.a(), str);
            z = false;
            str2 = "提交失败";
        } else {
            p1.h(e.c.c.o.f.a(), "提交成功");
            z = true;
            if (eVar != null) {
                j(eVar, i2);
            }
        }
        feedbackFragment.R0("reportFeedbackWithUpload  result = " + str2 + " , response = " + eVar);
        if (z) {
            try {
                feedbackFragment.e();
                EventBus.getDefault().post(new e.c.a.g.a.g.g.b.a());
            } catch (Exception e2) {
                e2.printStackTrace();
                feedbackFragment.R0("reportFeedbackWithUpload main error = " + e2.getMessage());
            }
        }
    }

    public static /* synthetic */ void h(FeedbackFragment feedbackFragment, Throwable th) {
        p1.h(e.c.c.o.f.a(), "网络错误");
        feedbackFragment.i0();
        feedbackFragment.R0("reportFeedbackWithUpload  error = " + th.getMessage());
    }

    public static void j(e eVar, int i2) {
        if (e.c.a.g.a.d.d0.c.a.r()) {
            Log.e("mhs_watch_xlog", "clickSource = " + i2);
            if (i2 == 2) {
                Log.e("mhs_watch_xlog", "不上传日志");
                return;
            }
            Log.e("mhs_watch_xlog", "上传日志");
            if (eVar.a() != null) {
                j0.b().a(new RunnableC0122c(eVar));
            }
        }
    }

    public String b() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        boolean z = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.j, 1) == 1;
        Log.e("mhs_watch_uploadimg", "young.qa.upload_new_bucket = " + z);
        if (z) {
            this.b = "h5feedback";
        } else {
            this.b = "mobileservice";
        }
        return this.b;
    }

    public final String d() {
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.l);
        return !TextUtils.isEmpty(config) ? config : "h5feedback".equals(this.b) ? "https://bssdl.kugou.net/bss/h5feedback/" : "http://mobileservice.bssdl.kugou.com/";
    }

    public void i() {
        i1.a(this.a);
    }

    public void k(final FeedbackFragment feedbackFragment, String str, String str2, int i2, int i3, String str3, String str4, int i4, List<e.c.a.g.a.r.c.a> list, final String str5, final int i5) {
        feedbackFragment.p0();
        feedbackFragment.o0(e.c.a.g.a.f.o.g.b.f719f);
        i1.a(this.a);
        this.a = Observable.just(list).observeOn(Schedulers.io()).flatMap(new b(feedbackFragment)).map(new a(this, str, str2, i2, i3, str3, str4, i4)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: e.c.a.g.a.g.g.c.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                c.g(feedbackFragment, i5, str5, (e) obj);
            }
        }, new Action1() { // from class: e.c.a.g.a.g.g.c.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                c.h(feedbackFragment, (Throwable) obj);
            }
        });
    }
}
