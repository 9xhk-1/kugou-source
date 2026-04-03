package e.c.a.g.a.d.u;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.component.SplashActivity;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.s0;
import e.g.e.a.a.a;

/* JADX INFO: loaded from: classes.dex */
public class g implements c {
    public Notification a(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_remote_view);
        e.a(context, "1025");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "1025");
        builder.setContent(remoteViews).setAutoCancel(false).setSmallIcon(R.drawable.icon).setWhen(System.currentTimeMillis());
        Notification notificationBuild = builder.build();
        notificationBuild.flags = 134217730;
        return notificationBuild;
    }

    public final e.g.e.a.a.a b(Context context) throws SecurityException {
        Intent action = new Intent().addFlags(268435456).setAction("young_action_notification_start_app");
        a.b bVar = new a.b();
        bVar.n(context);
        bVar.q(R.layout.notification_remote_view);
        bVar.t(R.id.notification_song_name, PendingIntent.getBroadcast(context, 1, action, 134217728));
        bVar.p(R.id.notification_btn_pre, PendingIntent.getBroadcast(context, 2, new Intent().setAction("young_action_notification_previous"), 134217728));
        bVar.o(R.id.notification_btn_next, PendingIntent.getBroadcast(context, 3, new Intent().setAction("young_action_notification_next"), 134217728));
        bVar.r(R.id.notification_btn_play, PendingIntent.getBroadcast(context, 4, new Intent().setAction("young_action_notification_play"), 134217728));
        bVar.s(R.drawable.icon_notification_pause, R.drawable.icon_notification_play);
        bVar.m(PendingIntent.getActivity(context, 1, s0.a.a(context, SplashActivity.class), 134217728));
        return bVar.l();
    }

    @Override // e.c.a.g.a.d.u.c
    public void cancel(Context context) {
        b(context).a();
    }

    @Override // e.c.a.g.a.d.u.c
    public void init() {
    }

    @Override // e.c.a.g.a.d.u.c
    public void showNotification(Context context) {
        try {
            e.g.e.a.a.a aVarB = b(context);
            RemoteViews remoteViewsB = aVarB.b();
            Intent intent = new Intent();
            intent.setAction("young_action_notification_close");
            intent.setPackage(context.getPackageName());
            remoteViewsB.setOnClickPendingIntent(R.id.notification_close, PendingIntent.getBroadcast(context, 0, intent, 134217728));
            KGMusicWrapper currentSong = e.c.a.g.a.d.x.b.b().getCurrentSong();
            if (currentSong != null) {
                aVarB.j(currentSong.getDisplayName());
                aVarB.i(currentSong.getArtistName());
                aVarB.f(a0.d(currentSong.getImgUrl()));
            }
            try {
                if (e.c.a.g.a.d.x.f.q()) {
                    aVarB.h();
                } else {
                    aVarB.g();
                }
            } catch (Exception e2) {
                g0.i(e2);
            }
            aVarB.e();
        } catch (Exception unused) {
        }
    }

    @Override // e.c.a.g.a.d.u.c
    public void startNotification(Service service) {
        service.startForeground(1, a(service));
        showNotification(service);
    }
}
