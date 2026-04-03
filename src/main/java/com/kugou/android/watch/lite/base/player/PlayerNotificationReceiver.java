package com.kugou.android.watch.lite.base.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.component.SplashActivity;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.d.x.h;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes.dex */
public class PlayerNotificationReceiver extends BroadcastReceiver {
    public final h a;

    public PlayerNotificationReceiver(h hVar) {
        this.a = hVar;
    }

    public final void a(int i2) {
        Intent intentA = s0.a.a(this.a.x(), SplashActivity.class);
        intentA.setAction("action_show_net_request_dialog");
        intentA.putExtra("key_net_request_dialog_type", i2);
        this.a.x().startActivity(intentA);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        action.hashCode();
        switch (action) {
            case "young_action_notification_close":
                KGApplication.exit();
                break;
            case "young_action_notification_previous":
                if (!u1.h(500)) {
                    if (!u0.r(context)) {
                        p1.h(context, "当前无网络连接~");
                    } else if (!u0.y(context)) {
                        f.B();
                    } else {
                        a(1);
                    }
                    break;
                }
                break;
            case "young_action_notification_start_app":
                if (!u1.h(500)) {
                    this.a.x().startActivity(s0.a.a(this.a.x(), SplashActivity.class));
                    l1.a(this.a.x());
                    break;
                }
                break;
            case "young_action_notification_next":
                if (!u1.h(500)) {
                    if (!u0.r(context)) {
                        p1.h(context, "当前无网络连接~");
                    } else if (!u0.y(context)) {
                        f.s();
                    } else {
                        a(3);
                    }
                    break;
                }
                break;
            case "young_action_notification_play":
                if (!u1.h(500)) {
                    if (this.a.getIInfo().isPlaying()) {
                        f.t();
                    } else if (!u0.r(context)) {
                        p1.h(context, "当前无网络连接~");
                    } else if (!u0.y(context)) {
                        f.x();
                    } else {
                        a(2);
                    }
                    break;
                }
                break;
        }
    }
}
