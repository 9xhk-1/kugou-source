package e.g.e.a.a;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.xtc.system.music.notification.MusicNotificationReceiver;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final long p = TimeUnit.MINUTES.toMillis(5);
    public Context a;
    public NotificationManager b;
    public Notification c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RemoteViews f1496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AlarmManager f1497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PendingIntent f1498f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1499g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1500h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1501i;
    public final int j;
    public int k;
    public int l;
    public int m;
    public SparseArray<PendingIntent> n;
    public int o;

    public static final class b {
        public Context a;
        public int b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1502d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1503e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1504f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1505g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1506h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1507i;
        public SparseArray<PendingIntent> j = new SparseArray<>(5);
        public PendingIntent k;

        public a l() {
            return new a(this);
        }

        public b m(PendingIntent pendingIntent) {
            this.k = pendingIntent;
            return this;
        }

        public b n(Context context) {
            this.a = context;
            return this;
        }

        public b o(int i2, PendingIntent pendingIntent) {
            this.f1503e = i2;
            this.j.put(i2, pendingIntent);
            return this;
        }

        public b p(int i2, PendingIntent pendingIntent) {
            this.f1502d = i2;
            this.j.put(i2, pendingIntent);
            return this;
        }

        public b q(int i2) {
            this.b = i2;
            return this;
        }

        public b r(int i2, PendingIntent pendingIntent) {
            this.c = i2;
            this.j.put(i2, pendingIntent);
            return this;
        }

        public b s(int i2, int i3) {
            this.f1506h = i2;
            this.f1507i = i3;
            return this;
        }

        public b t(int i2, PendingIntent pendingIntent) {
            this.f1504f = i2;
            this.j.put(i2, pendingIntent);
            return this;
        }
    }

    public void a() {
        this.b.cancel(258);
    }

    public RemoteViews b() {
        return this.f1496d;
    }

    public final void c() {
        int[] iArr = {this.j, this.f1500h, this.f1499g, this.f1501i};
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[i2];
            this.f1496d.setOnClickPendingIntent(i3, this.n.get(i3));
        }
    }

    public final void d() {
        k();
        this.f1498f = PendingIntent.getBroadcast(this.a, 1, new Intent(this.a, (Class<?>) MusicNotificationReceiver.class), 268435456);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.d("MusicNotification", "scheduleAutoCancel:currentTimeMillis=" + jCurrentTimeMillis);
        this.f1497e.setExact(0, jCurrentTimeMillis + p, this.f1498f);
        MusicNotificationReceiver.a = this;
    }

    public void e() {
        this.b.notify(258, this.c);
    }

    public a f(String str) {
        this.c.extras.putString("ALBUM_COVER_URL", str);
        return this;
    }

    public a g() {
        this.c.extras.putInt("PLAY_STATE", 32);
        this.f1496d.setImageViewResource(this.f1499g, this.l);
        d();
        return this;
    }

    public a h() {
        k();
        this.c.extras.putInt("PLAY_STATE", 16);
        this.f1496d.setImageViewResource(this.f1499g, this.k);
        return this;
    }

    public a i(String str) {
        this.c.extras.putString("SINGER_NAME", str);
        this.f1496d.setTextViewText(this.m, str);
        return this;
    }

    public a j(String str) {
        Notification notification = this.c;
        notification.tickerText = str;
        notification.extras.putString("SONG_NAME", str);
        this.f1496d.setTextViewText(this.j, str);
        return this;
    }

    public final void k() {
        PendingIntent pendingIntent = this.f1498f;
        if (pendingIntent == null) {
            return;
        }
        this.f1497e.cancel(pendingIntent);
        this.f1498f = null;
        MusicNotificationReceiver.a = null;
    }

    public a(b bVar) {
        Context applicationContext = bVar.a.getApplicationContext();
        this.a = applicationContext;
        Resources resources = applicationContext.getResources();
        PackageManager packageManager = this.a.getPackageManager();
        String packageName = this.a.getPackageName();
        try {
            this.o = packageManager.getApplicationInfo(packageName, 0).icon;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("MusicNotification", "MusicNotification:", e2);
        }
        this.f1497e = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f1496d = new RemoteViews(packageName, bVar.b);
        int i2 = bVar.f1504f;
        this.j = i2;
        int i3 = bVar.f1502d;
        this.f1500h = i3;
        int i4 = bVar.c;
        this.f1499g = i4;
        int i5 = bVar.f1503e;
        this.f1501i = i5;
        this.m = bVar.f1505g;
        this.k = bVar.f1506h != 0 ? bVar.f1506h : c.selector_action_pause_song;
        this.l = bVar.f1507i != 0 ? bVar.f1507i : c.selector_action_play_song;
        this.n = bVar.j;
        c();
        this.b = (NotificationManager) this.a.getSystemService("notification");
        e.g.e.a.a.b.a(this.a);
        int i6 = Build.VERSION.SDK_INT;
        Notification.Builder builder = i6 >= 26 ? new Notification.Builder(this.a, "1024") : new Notification.Builder(this.a);
        builder.setContent(this.f1496d).setAutoCancel(false).setSmallIcon(this.o).setLargeIcon(BitmapFactory.decodeResource(resources, this.o)).setContentIntent(bVar.k).setWhen(System.currentTimeMillis());
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_MUSIC", true);
        bundle.putParcelable("PLAY_PAUSE_INTENT", this.n.get(i4));
        bundle.putParcelable("PREVIOUS_INTENT", this.n.get(i3));
        bundle.putParcelable("NEXT_INTENT", this.n.get(i5));
        bundle.putParcelable("SONG_NAME_INTENT", this.n.get(i2));
        Notification notificationBuild = builder.build();
        this.c = notificationBuild;
        notificationBuild.extras.putAll(bundle);
        this.c.flags = 2;
        String type = this.a.getContentResolver().getType(Uri.parse("content://com.xtc.provider/BaseDataProvider/music_notification_type/12"));
        if (i6 >= 24 || TextUtils.equals(type, "header")) {
            this.c.flags |= 134217728;
        }
    }
}
