package e.c.a.g.a.s;

import android.util.Log;
import com.kugou.android.watch.lite.bi.YoungBITask;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public class g0 {
    public static boolean a = false;
    public static float b;
    public static Boolean c;

    public class a implements Action1<String> {
        public final /* synthetic */ Throwable a;
        public final /* synthetic */ boolean b;

        public a(Throwable th, boolean z) {
            this.a = th;
            this.b = z;
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020024, "statistics").setSource("uploadException").setSvar1("" + Log.getStackTraceString(this.a)).setSvar2("" + this.b));
        }
    }

    public static boolean a() {
        if (c == null) {
            b = e.c.a.g.a.f.e.c.c().getConfigAsFloat(e.c.a.g.a.f.e.b.f4, 0.01f);
            c = Boolean.valueOf(Math.random() < ((double) b));
        }
        return c.booleanValue();
    }

    public static void b(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static String d() {
        return f() ? Log.getStackTraceString(new RuntimeException("KGLog_StackTrace")) : "";
    }

    public static void e(String str, String str2) {
        if (a) {
            Log.i(str, str2);
        }
    }

    public static boolean f() {
        return a;
    }

    public static boolean g() {
        return f() && e.c.a.g.a.c.a.a.d();
    }

    public static void h(String str, Throwable th) {
        if (f()) {
            c(str, Log.getStackTraceString(th));
        }
    }

    public static void i(Throwable th) {
        h("KGLog", th);
    }

    public static void j(Error error) {
        if (a) {
            error.printStackTrace();
        }
    }

    public static void k(Throwable th) {
        l(th, false);
    }

    public static void l(Throwable th, boolean z) {
        if (a) {
            th.printStackTrace();
        }
        if (a() || ((z && b > 0.0f) || a)) {
            m1.f(new a(th, z));
        }
    }
}
