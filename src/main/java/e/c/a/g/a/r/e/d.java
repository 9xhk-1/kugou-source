package e.c.a.g.a.r.e;

import android.content.Intent;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import e.c.a.g.a.g.i.w;
import e.c.a.g.a.r.e.h;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.k;
import e.c.a.g.a.s.l1;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final String b = "d";
    public static volatile d c;
    public Subscription a;

    public class a implements Action1<String> {
        public a() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(String str) {
            if (g0.a) {
                g0.b(d.b, "startVipExpireTaskIfNeed: ACTION_USER_VIP_EXPIRE");
            }
            e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.action.user_vip_expire"));
            d.this.a = null;
        }
    }

    public class b implements Action1<Throwable> {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            d.this.a = null;
        }
    }

    public class c implements h.d {

        public class a implements Action1<UserData> {
            public a(c cVar) {
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(UserData userData) {
                int error_code = userData.getError_code();
                if (error_code == 20018 || error_code == 20017) {
                    if (g0.a) {
                        g0.b(d.b, "onLoginFailed: token expire");
                    }
                    e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.login_token_expire"));
                }
            }
        }

        public c() {
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginFailed(UserData userData, int i2) {
            if (g0.a) {
                g0.b(d.b, "onLoginFailed: errCode" + userData.getError_code());
            }
            Observable.just(userData).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), i1.b);
            e.c.a.g.a.e.b.b(new YoungBITask(20479, "statistics").setType(i2 == 5 ? "1" : i2 == 4 ? "2" : "3"));
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginRisk() {
            if (g0.a) {
                g0.b(d.b, "onLoginRisk: ");
            }
        }

        @Override // e.c.a.g.a.r.e.h.d
        public void onLoginSucceed(UserData userData, int i2) {
            if (g0.a) {
                g0.b(d.b, "onLoginSucceed: ");
            }
            d.this.e(i2);
        }

        public /* synthetic */ c(d dVar, a aVar) {
            this();
        }
    }

    public static d d() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    public void c() {
        w.l.h(false);
        i1.a(this.a);
        e.c.a.g.a.r.b.V(0);
        e.c.a.g.a.r.b.a0(0);
        e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
        cVar.j("key_user_login", false);
        cVar.i("key_user_token", "");
        cVar.g("key_user_id", 0);
        cVar.i("key_user_name", "");
        cVar.i("key_user_nick_name", "");
        cVar.i("key_user_pic", "");
        e.c.a.g.a.r.b.Z("");
        e.c.a.g.a.r.b.T();
        SVIPExtInfoUtil.removeFromSettingPrefs();
        e.c.a.g.a.g.f.c.a.v();
    }

    public void e(int i2) {
        g();
    }

    public void f() {
        if (e.c.a.g.a.r.b.F()) {
            if (g0.a) {
                g0.b(b, "在线登陆");
            }
            h hVar = new h();
            hVar.t(new c(this, null));
            String strQ = e.c.a.g.a.r.b.q();
            long jO = e.c.a.g.a.r.b.o();
            hVar.l(true, 2, strQ, String.valueOf(jO), e.c.a.g.a.r.b.n());
        }
    }

    public void g() {
        long jE = k.e(e.c.a.g.a.r.b.u()) - l1.b();
        if (g0.a) {
            g0.b(b, "startVipExpireTaskIfNeed: remainDuration=" + jE);
        }
        if (jE > 0) {
            i1.a(this.a);
            this.a = Observable.just("").delay(jE, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(), new b());
        }
    }
}
