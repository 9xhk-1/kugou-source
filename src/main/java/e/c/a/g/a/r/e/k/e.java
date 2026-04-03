package e.c.a.g.a.r.e.k;

import android.os.Handler;
import android.os.Looper;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.user.login.UserData;
import e.c.a.g.a.r.e.h;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u1;
import f.z.d.j;
import f.z.d.q;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final e a = new e();
    public static boolean b;
    public static final Handler c;

    public static final class a implements Runnable {
        public final /* synthetic */ h.c a;
        public final /* synthetic */ q b;

        public a(h.c cVar, q qVar) {
            this.a = cVar;
            this.b = qVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.c cVar = this.a;
            if (cVar == null) {
                return;
            }
            cVar.onLoginRefrash(this.b.a);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ h.c a;
        public final /* synthetic */ q b;

        public b(h.c cVar, q qVar) {
            this.a = cVar;
            this.b = qVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.c cVar = this.a;
            if (cVar == null) {
                return;
            }
            cVar.onLoginRefrash(this.b.a);
        }
    }

    static {
        b = e.c.a.g.a.f.e.c.a.a().getConfigAsInt(e.c.a.g.a.f.e.b.N3, 1) == 1;
        c = new Handler(Looper.getMainLooper());
    }

    public final void a(UserData userData, h.c cVar) {
        j.e(userData, "loginResult");
        j.e(cVar, "callback");
        if (b) {
            String string = Integer.valueOf(userData.getError_code()).toString();
            if (string == null) {
                string = "";
            }
            q qVar = new q();
            if ("20010".equals(string) || "20006".equals(string)) {
                qVar.a = 1;
            } else if ("34178".equals(string) || "20018".equals(string)) {
                qVar.a = 2;
            }
            if ("20018".equals(string)) {
                if (!u1.h(1000)) {
                    p1.f(KGApplication.getApplication(), "登录超时，请刷新重试");
                }
                c.post(new a(cVar, qVar));
            } else if ("20010".equals(string) || "20006".equals(string) || "34178".equals(string)) {
                if (!u1.h(1000)) {
                    p1.f(KGApplication.getApplication(), "请稍后刷新重试");
                }
                c.post(new b(cVar, qVar));
            }
        }
    }
}
