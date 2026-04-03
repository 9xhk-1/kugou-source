package e.c.a.g.a.d.u;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static void a(Context context, String str) {
        if (context == null || Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(str, "notification", 4);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public static boolean b() {
        return e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.P0, 1) == 1;
    }
}
