package e.c.a.g.a.d.r.q;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.g0;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static volatile a c;
    public b a;
    public boolean b = false;

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (g0.a) {
                g0.e("refreshPlayQueue", "前台 action=" + action);
            }
            if ("com.kugou.android.user_login_success".equals(action)) {
                boolean z = false;
                if ("com.kugou.android.user_login_success".equals(action) && intent.getBooleanExtra("key_login_type", false)) {
                    z = true;
                }
                if (z) {
                    return;
                }
            } else if (!"com.kugou.android.user_login_out".equals(action)) {
                "com.kugou.android.login_token_expire".equals(action);
            }
            if (a.this.e()) {
                return;
            }
            if (g0.a) {
                g0.e("refreshPlayQueue", "dorefreshMusicTagSongStatus.");
            }
            a.this.f(action);
        }
    }

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public void b() {
        h();
    }

    public void d() {
        g();
    }

    public synchronized boolean e() {
        return this.b;
    }

    public final void f(String str) {
        f.D(str);
    }

    public final void g() {
        if (this.a == null) {
            this.a = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.kugou.android.user_login_success");
            intentFilter.addAction("com.kugou.android.user_login_out");
            intentFilter.addAction("com.kugou.android.login_token_expire");
            e.c.a.g.a.f.d.a.b(this.a, intentFilter);
        }
    }

    public final void h() {
        b bVar = this.a;
        if (bVar != null) {
            e.c.a.g.a.f.d.a.g(bVar);
            this.a = null;
        }
    }
}
