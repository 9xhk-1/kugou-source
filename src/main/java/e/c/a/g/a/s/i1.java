package e.c.a.g.a.s;

import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class i1 {
    public static final Action1 a = new a();
    public static final Action1<Throwable> b = new b();

    public class a implements Action1 {
        @Override // rx.functions.Action1
        public void call(Object obj) {
        }
    }

    public class b implements Action1<Throwable> {
        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            if (g0.a) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Subscription... subscriptionArr) {
        if (subscriptionArr == null || subscriptionArr.length <= 0) {
            return;
        }
        for (Subscription subscription : subscriptionArr) {
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }
}
