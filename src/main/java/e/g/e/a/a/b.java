package e.g.e.a.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel("1024", "notification", 1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
