package e.c.a.g.a.g.e;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m1;
import e.g.c.b;
import f.z.d.j;
import org.json.JSONObject;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static final d a;
    public static final boolean b;
    public static final String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Integer f754h;

    public static final class a extends b.a {

        /* JADX INFO: renamed from: e.c.a.g.a.g.e.d$a$a, reason: collision with other inner class name */
        public static final class C0117a<T> implements Action1 {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f755d;

            public C0117a(String str, String str2, String str3) {
                this.a = str;
                this.b = str2;
                this.f755d = str3;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void call(String str) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", this.a);
                    jSONObject.put("desc", this.b);
                    jSONObject.put("result", this.f755d);
                    e eVar = e.a;
                    String string = jSONObject.toString();
                    j.d(string, "json.toString()");
                    eVar.a(string);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // e.g.c.b
        public void onResult(String str, String str2, String str3) {
            Log.d(d.a.i(), "getAgeRange code: " + ((Object) str) + " desc: " + ((Object) str2) + ", result: " + ((Object) str3));
            m1.f(new C0117a(str, str2, str3));
        }
    }

    public static final class b<T> implements Action1 {
        public static final b<T> a = new b<>();

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(String str) {
            try {
                e.a.a("");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static {
        d dVar = new d();
        a = dVar;
        new Handler(Looper.getMainLooper());
        c.b bVar = e.c.a.g.a.f.e.c.a;
        bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.I0, 1);
        b = bVar.a().getConfigAsInt(e.c.a.g.a.f.e.b.L0, 1) == 1;
        c = "GradeOptionHelper";
        f750d = "https://activity.kugou.com/level/v-e518262d/index.html";
        f751e = "https://activity.kugou.com/level/v-e518262d/index.html";
        f753g = dVar.l();
    }

    public final void a(Context context) {
        j.e(context, "context");
        if (!l1.m0()) {
            e.a.a("");
            return;
        }
        try {
            new e.g.c.c.a(context).d(new a());
        } catch (Exception e2) {
            e2.printStackTrace();
            m1.f(b.a);
        }
    }

    public final String b() {
        return (TextUtils.isEmpty(e()) || d().equals(e())) ? d() : e();
    }

    public final int c() {
        return e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.j3, 1);
    }

    public String d() {
        return f751e;
    }

    public String e() {
        return f750d;
    }

    public final int f() {
        if (f754h == null) {
            if (k()) {
                f754h = Integer.valueOf(e.c.a.g.a.f.m.c.a.b("xtc_family_level", 0));
            } else {
                f754h = 0;
            }
            Log.e("mhs_watch_level", "levelValue = null.");
        }
        Integer num = f754h;
        int iIntValue = num != null ? num.intValue() : 0;
        Log.e("mhs_watch_level", "levelValue = " + f754h + ", result = " + iIntValue);
        return iIntValue;
    }

    public final boolean g() {
        return f753g;
    }

    public final int h() {
        return e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.l3, 5);
    }

    public final String i() {
        return c;
    }

    public final void j() {
        if (f752f) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strC = e.c.a.g.a.r.e.i.d.c(d());
        j.d(strC, "shareCustomContent(kgCodeUrlLong)");
        n(strC);
        Log.i(c, "refreshQrcode: kgCodeUrlShort=" + e() + " ， kgCodeUrlLong=" + d() + "， cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (d().equals(e())) {
            return;
        }
        f752f = true;
    }

    public final boolean k() {
        return (l1.m0() || l1.V()) && e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.i3, 1) == 1;
    }

    public final boolean l() {
        int iF = f();
        Log.e("mhs_watch_level", "needJumpFamilyLogic.");
        return b && iF >= 1 && iF <= 5;
    }

    public final void m(Context context) {
        j.e(context, "context");
        try {
            e.a.c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void n(String str) {
        j.e(str, "<set-?>");
        f750d = str;
    }
}
