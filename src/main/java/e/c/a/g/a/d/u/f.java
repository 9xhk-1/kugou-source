package e.c.a.g.a.d.u;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;

/* JADX INFO: loaded from: classes.dex */
public class f implements c {
    public final NotificationManager a = (NotificationManager) KGApplication.getContext().getSystemService("notification");
    public Service b;
    public Notification c;

    public final Notification a(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("show_heytap_indicator", true);
        NotificationCompat.Builder when = new NotificationCompat.Builder(context, str).setAutoCancel(false).setSmallIcon(R.drawable.icon).setOngoing(true).addExtras(bundle).setCategory(NotificationCompat.CATEGORY_NAVIGATION).setWhen(System.currentTimeMillis());
        e.c.a.g.a.d.q.b bVarH = e.c.a.g.a.d.x.f.h();
        if (bVarH != null) {
            when.setStyle(bVarH.l());
        }
        Notification notificationBuild = when.build();
        notificationBuild.flags = 134217730;
        return notificationBuild;
    }

    public final void b(Context context) {
        if (this.c == null) {
            this.c = a(context, "1025");
            e.a(context, "1025");
        }
    }

    @Override // e.c.a.g.a.d.u.c
    public void cancel(Context context) {
        this.a.cancel(1);
        e.c.a.g.a.d.q.b bVarH = e.c.a.g.a.d.x.f.h();
        if (bVarH != null) {
            bVarH.m();
        }
    }

    @Override // e.c.a.g.a.d.u.c
    public void init() {
    }

    @Override // e.c.a.g.a.d.u.c
    public void showNotification(Context context) {
        b(context);
        if (!e.c.a.g.a.d.x.f.q()) {
            this.a.cancel(1);
            return;
        }
        Service service = this.b;
        if (service != null) {
            service.startForeground(1, this.c);
        }
    }

    @Override // e.c.a.g.a.d.u.c
    public void startNotification(Service service) {
        this.b = service;
        b(service);
        e.a(service, "1025");
        showNotification(service);
    }
}
