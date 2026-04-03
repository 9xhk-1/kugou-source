package e.c.a.g.a.d.r.r.b;

import android.content.Context;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import org.greenrobot.eventbus.EventBus;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static boolean a = false;

    public class a implements Func1<Integer, Boolean> {
        public final /* synthetic */ Context a;

        public a(c cVar, Context context) {
            this.a = context;
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Integer num) {
            c.a = true;
            if (g0.a) {
                g0.e("zzm-log", "在sycing");
            }
            new b().b(this.a, num.intValue());
            if (g0.a) {
                g0.e("zzm-log", "sycing ending");
            }
            c.a = false;
            EventBus.getDefault().post(new e.c.a.g.a.d.r.r.a.b(1));
            return Boolean.TRUE;
        }
    }

    public void a(Context context, int i2) {
        Observable.just(Integer.valueOf(i2)).subscribeOn(Schedulers.io()).map(new a(this, context)).subscribe(i1.a, i1.b);
    }
}
