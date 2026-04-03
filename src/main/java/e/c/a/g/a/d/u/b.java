package e.c.a.g.a.d.u;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.s.l1;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {
    public Service a;

    public Notification a(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), l1.i0() ? R.layout.notification_remote_view_small : R.layout.notification_remote_view);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent().addFlags(268435456).setAction("young_action_notification_start_app"), 134217728);
        remoteViews.setOnClickPendingIntent(R.id.notification_content, broadcast);
        remoteViews.setOnClickPendingIntent(R.id.notification_song_name, broadcast);
        remoteViews.setOnClickPendingIntent(R.id.notification_btn_pre, PendingIntent.getBroadcast(context, 2, new Intent().setAction("young_action_notification_previous"), 134217728));
        remoteViews.setOnClickPendingIntent(R.id.notification_btn_next, PendingIntent.getBroadcast(context, 3, new Intent().setAction("young_action_notification_next"), 134217728));
        remoteViews.setOnClickPendingIntent(R.id.notification_btn_play, PendingIntent.getBroadcast(context, 4, new Intent().setAction("young_action_notification_play"), 134217728));
        remoteViews.setOnClickPendingIntent(R.id.notification_close, PendingIntent.getBroadcast(context, 5, new Intent().setAction("young_action_notification_close").setPackage(context.getPackageName()), 134217728));
        Notification notificationBuild = new NotificationCompat.Builder(context, "1025").setContent(remoteViews).setAutoCancel(false).setSmallIcon(R.drawable.icon).setWhen(System.currentTimeMillis()).build();
        notificationBuild.flags = 134217730;
        return notificationBuild;
    }

    public final void b(Notification notification) {
        KGMusicWrapper currentSong = e.c.a.g.a.d.x.b.b().getCurrentSong();
        String displayName = currentSong != null ? currentSong.getDisplayName() : null;
        if (TextUtils.isEmpty(displayName)) {
            displayName = KGApplication.getContext().getString(R.string.noti_title);
        }
        notification.contentView.setTextViewText(R.id.notification_song_name, displayName);
        notification.contentView.setImageViewResource(R.id.notification_btn_play, e.c.a.g.a.d.x.f.q() ? R.drawable.icon_notification_pause : R.drawable.icon_notification_play);
    }

    @Override // e.c.a.g.a.d.u.c
    public void cancel(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(1);
    }

    @Override // e.c.a.g.a.d.u.c
    public void init() {
    }

    @Override // e.c.a.g.a.d.u.c
    public void showNotification(Context context) {
        if (this.a == null) {
            return;
        }
        Notification notificationA = a(context);
        b(notificationA);
        this.a.startForeground(1, notificationA);
    }

    @Override // e.c.a.g.a.d.u.c
    public void startNotification(Service service) {
        this.a = service;
        Notification notificationA = a(service);
        b(notificationA);
        e.a(service, "1025");
        service.startForeground(1, notificationA);
    }
}
