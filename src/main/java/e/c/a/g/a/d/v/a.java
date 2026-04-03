package e.c.a.g.a.d.v;

import android.content.Context;
import android.os.SystemClock;
import e.c.a.g.a.s.i1;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public class a extends e {
    public long a = -1;

    /* JADX INFO: renamed from: e.c.a.g.a.d.v.a$a, reason: collision with other inner class name */
    public class C0079a implements Action1<String> {
        public C0079a() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            a.this.f();
        }
    }

    @Override // e.c.a.g.a.d.v.e
    public void a(Context context) {
    }

    @Override // e.c.a.g.a.d.v.e
    public long c() {
        return this.a;
    }

    @Override // e.c.a.g.a.d.v.e
    public boolean d() {
        return false;
    }

    public final void f() {
        this.a = SystemClock.elapsedRealtime();
    }

    @Override // com.kugou.android.watch.lite.base.main.FrameworkContentView.b
    public void onFirstFace() {
        Observable.just("").delay(100L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0079a(), i1.b);
    }
}
