package e.c.a.g.a.r.e.i;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    public class a implements Func1<e.c.a.g.a.r.e.i.a, b> {
        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b call(e.c.a.g.a.r.e.i.a aVar) {
            return new b(new c().b(aVar.a, 5), true);
        }
    }

    public static Observable<b> a(String str) {
        return Observable.just(new e.c.a.g.a.r.e.i.a(str)).subscribeOn(Schedulers.io()).map(new a()).observeOn(AndroidSchedulers.mainThread());
    }
}
