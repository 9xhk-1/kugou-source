package org.chromium.net;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    public final Looper a;
    public final Handler b;
    public b c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f1707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1709f;

    @SuppressLint({"NewApi", "ParcelCreator"})
    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkChangeNotifierAutoDetect.this.f1708e) {
                if (NetworkChangeNotifierAutoDetect.this.f1709f) {
                    NetworkChangeNotifierAutoDetect.this.f1709f = false;
                } else {
                    NetworkChangeNotifierAutoDetect.d(NetworkChangeNotifierAutoDetect.this);
                    throw null;
                }
            }
        }
    }

    public static class b {
        public c a(d dVar) {
            throw null;
        }
    }

    public static class c {
        public int a() {
            throw null;
        }
    }

    public static class d {
    }

    public static /* synthetic */ void d(NetworkChangeNotifierAutoDetect networkChangeNotifierAutoDetect) {
        networkChangeNotifierAutoDetect.e();
        throw null;
    }

    public final void e() {
        f().a();
        throw null;
    }

    public c f() {
        return this.c.a(this.f1707d);
    }

    public final boolean g() {
        return this.a == Looper.myLooper();
    }

    public final void h(Runnable runnable) {
        if (g()) {
            runnable.run();
        } else {
            this.b.post(runnable);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        h(new a());
    }
}
