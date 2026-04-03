package com.kugou.android.watch.lite.base.player;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.f.d.a;
import e.c.a.g.a.s.g0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class CheckPlayDelegate {
    public final long a;
    public final PendingIntent b = PendingIntent.getBroadcast(KGApplication.getContext(), 100, new Intent("action_kill_app"), 0);
    public final AlarmManager c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f75d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f76e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CheckPlayDelegate$receiver$1 f77f;

    /* JADX WARN: Type inference failed for: r4v6, types: [android.content.BroadcastReceiver, com.kugou.android.watch.lite.base.player.CheckPlayDelegate$receiver$1] */
    public CheckPlayDelegate(long j) {
        this.a = j;
        Object systemService = KGApplication.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        this.c = (AlarmManager) systemService;
        ?? r4 = new BroadcastReceiver() { // from class: com.kugou.android.watch.lite.base.player.CheckPlayDelegate$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (this.a.f()) {
                    return;
                }
                this.a.c();
                KGApplication.exit();
            }
        };
        this.f77f = r4;
        a.c(r4, new IntentFilter("action_kill_app"));
    }

    public final void c() {
        Log.i("CheckPlay", "checkPlay: cancel auto kill alarm intent");
        this.c.cancel(this.b);
        this.f75d = false;
    }

    public final void d() {
        if (g0.a) {
            g0.b("CheckPlay", "checkPlay: isForeground=" + this.f76e + "  isPlaying=" + f() + " exitSeconds=" + this.a);
        }
        if (this.a <= 0) {
            return;
        }
        if (this.f76e) {
            c();
            return;
        }
        if (f()) {
            c();
            return;
        }
        if (this.f75d) {
            return;
        }
        try {
            this.c.set(2, SystemClock.elapsedRealtime() + (this.a * 1000), this.b);
            this.f75d = true;
            Log.i("CheckPlay", "checkPlay: send auto kill alarm intent");
        } catch (Exception e2) {
            g0.i(e2);
        }
    }

    public final void e() {
        c();
        a.h(this.f77f);
    }

    public final boolean f() {
        return f.o() && f.q();
    }

    public final void g(boolean z) {
        this.f76e = z;
        d();
    }
}
