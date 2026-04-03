package e.c.a.g.a.s;

import android.os.Looper;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class m1 {
    public static void a() {
        if (g0.f() && Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("Make sure the content of your adapter is modified from UI thread");
        }
    }

    public static void b() {
        if (g0.f() && Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("is running in UI thread");
        }
    }

    public static boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void d(int i2, Action1<String> action1) {
        Observable.just("").delay(i2, TimeUnit.MILLISECONDS).subscribe(action1, i1.b);
    }

    public static void e(int i2, Action1<String> action1) {
        Observable.just("").delay(i2, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(action1, i1.b);
    }

    public static void f(Action1<String> action1) {
        Observable.just("").subscribeOn(Schedulers.io()).subscribe(action1, i1.b);
    }
}
