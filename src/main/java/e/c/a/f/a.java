package e.c.a.f;

import android.support.annotation.Nullable;
import com.kugou.android.watch.lite.base.activity.AbsFrameworkActivity;
import com.kugou.common.userinfo.protocol.LoginExtendInfo;
import com.kugou.common.userinfo.protocol.LoginExtendInfoProtocol;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public Subscription a;

    /* JADX INFO: renamed from: e.c.a.f.a$a, reason: collision with other inner class name */
    public class C0040a implements Action1<e.c.a.g.a.f.k.c<LoginExtendInfo>> {
        public C0040a() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c.a.g.a.f.k.c<LoginExtendInfo> cVar) {
            if (cVar.f()) {
                if (g0.a) {
                    g0.c("unicorntest", "发送 Sticky LoginExtendInfoEvent事件");
                }
                EventBus.getDefault().post(new e.c.a.g.a.r.d.b(5));
            }
            a.this.a = null;
        }
    }

    public class b implements Action1<Throwable> {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            th.printStackTrace();
            a.this.a = null;
        }
    }

    public class c implements Observable.OnSubscribe<e.c.a.g.a.f.k.c<LoginExtendInfo>> {
        public c(a aVar) {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Subscriber<? super e.c.a.g.a.f.k.c<LoginExtendInfo>> subscriber) {
            subscriber.onNext(new LoginExtendInfoProtocol().get());
            subscriber.onCompleted();
        }
    }

    public void b(@Nullable AbsFrameworkActivity absFrameworkActivity) {
        if (e.c.a.g.a.r.b.F()) {
            c(false, false, 2, absFrameworkActivity, true);
        }
    }

    public void c(boolean z, boolean z2, int i2, @Nullable AbsFrameworkActivity absFrameworkActivity, boolean z3) {
        i1.a(this.a);
        this.a = Observable.create(new c(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0040a(), new b());
    }

    public void d() {
        i1.a(this.a);
    }
}
