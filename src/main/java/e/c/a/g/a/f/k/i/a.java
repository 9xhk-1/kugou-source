package e.c.a.g.a.f.k.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.qrscan.risk.RiskActivity;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.s0;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f692e;
    public String a;
    public final Object b = new Object();
    public volatile boolean c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BroadcastReceiver f693d = new b();

    /* JADX INFO: renamed from: e.c.a.g.a.f.k.i.a$a, reason: collision with other inner class name */
    public class C0104a implements e.c.a.g.a.f.k.h.b {
        public C0104a() {
        }

        @Override // e.c.a.g.a.f.k.h.b
        public Headers getHeaders() {
            if (TextUtils.isEmpty(a.this.a)) {
                return null;
            }
            Headers.Builder builder = new Headers.Builder();
            builder.set("VerifyData", a.this.a);
            return builder.build();
        }

        @Override // e.c.a.g.a.f.k.h.b
        public boolean onIntercept(String str, String str2, String str3) {
            if (g0.f()) {
                g0.b("IOTDelegate", "url: " + str + " eventId: " + str2 + " busId: " + str3);
            }
            KGApplication.getContext().startActivity(s0.a.a(KGApplication.getContext(), RiskActivity.class).putExtra("arg_event_id", str2).putExtra("arg_bus_id", str3));
            synchronized (a.this.b) {
                try {
                    a.this.b.wait();
                } catch (InterruptedException e2) {
                    g0.k(e2);
                }
            }
            a.this.j();
            return a.this.c;
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.kugou.android.check_iot".equals(intent.getAction())) {
                a.this.h(intent.getBooleanExtra("arg_result", false));
            }
        }
    }

    public a() {
        i();
    }

    public static a f() {
        if (f692e == null) {
            synchronized (a.class) {
                if (f692e == null) {
                    f692e = new a();
                    f692e.g();
                }
            }
        }
        return f692e;
    }

    public void g() {
        e.c.a.g.a.f.k.h.a.a().i(false);
        e.c.a.g.a.f.k.h.a.a().j(new C0104a());
    }

    public final void h(boolean z) {
        this.c = z;
        synchronized (this.b) {
            this.b.notify();
        }
    }

    public final void i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.android.check_iot");
        e.c.a.g.a.f.d.a.b(this.f693d, intentFilter);
    }

    public final void j() {
        if (g0.a) {
            g0.b("IOTDelegate", "resetWashStatus");
        }
    }
}
