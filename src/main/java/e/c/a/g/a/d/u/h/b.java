package e.c.a.g.a.d.u.h;

import android.content.Intent;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.g0;
import qihoo.sdk.widget.i.OnPlayWidgetEventListener;

/* JADX INFO: loaded from: classes.dex */
public class b implements OnPlayWidgetEventListener {
    @Override // qihoo.sdk.widget.i.OnPlayWidgetEventListener
    public void onExit() {
        if (g0.a) {
            g0.b("QihooPlayWidgetEventListener", "onExit: ");
        }
        e.c.a.g.a.f.d.a.d(new Intent().setAction("young_action_notification_close"));
    }

    @Override // qihoo.sdk.widget.i.OnPlayWidgetEventListener
    public void onNext() {
        if (g0.a) {
            g0.b("QihooPlayWidgetEventListener", "onNext: ");
        }
        e.c.a.g.a.f.d.a.d(new Intent().setAction("young_action_notification_next"));
    }

    @Override // qihoo.sdk.widget.i.OnPlayWidgetEventListener
    public void onPause() {
        if (g0.a) {
            g0.b("QihooPlayWidgetEventListener", "onPause: ");
        }
        e.c.a.g.a.f.d.a.d(new Intent().setAction("young_action_notification_play"));
    }

    @Override // qihoo.sdk.widget.i.OnPlayWidgetEventListener
    public void onPlay() {
        if (g0.a) {
            g0.b("QihooPlayWidgetEventListener", "onPlay: ");
        }
        e.c.a.g.a.f.d.a.d(new Intent().setAction("young_action_notification_play"));
    }

    @Override // qihoo.sdk.widget.i.OnPlayWidgetEventListener
    public void onPre() {
        if (g0.a) {
            g0.b("QihooPlayWidgetEventListener", "onPre: ");
        }
        e.c.a.g.a.f.d.a.d(new Intent().setAction("young_action_notification_previous"));
    }

    @Override // qihoo.sdk.widget.i.OnPlayWidgetEventListener
    public void onProgressUpdate(int i2) {
        if (g0.a) {
            g0.b("QihooPlayWidgetEventListener", "onProgressUpdate: ");
        }
        f.E(i2);
    }

    @Override // qihoo.sdk.widget.i.OnPlayWidgetEventListener
    public void onWigetClick() {
        if (g0.a) {
            g0.b("QihooPlayWidgetEventListener", "onWigetClick: ");
        }
        e.c.a.g.a.f.d.a.d(new Intent().setAction("young_action_notification_start_app"));
    }
}
