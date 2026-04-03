package e.c.a.g.a.f.d;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import e.c.a.g.a.d.o.d.c.b;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        b(broadcastReceiver, intentFilter);
        c(broadcastReceiver, intentFilter);
    }

    public static void b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver == null) {
            return;
        }
        try {
            LocalBroadcastManager.getInstance(f.a()).registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (broadcastReceiver == null) {
            return;
        }
        try {
            f.a().registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void d(Intent intent) {
        e(intent, false);
    }

    public static void e(Intent intent, boolean z) {
        if (z) {
            b.c(intent);
        } else {
            b.b(intent);
        }
    }

    public static void f(BroadcastReceiver broadcastReceiver) {
        g(broadcastReceiver);
        h(broadcastReceiver);
    }

    public static void g(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        try {
            LocalBroadcastManager.getInstance(f.a()).unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void h(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return;
        }
        try {
            f.a().unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
