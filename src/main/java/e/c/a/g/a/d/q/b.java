package e.c.a.g.a.d.q;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.app.NotificationCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.headset.MediaButtonIntentReceiver;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.c;
import e.c.a.g.a.s.g0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public volatile MediaSessionCompat a;
    public final BroadcastReceiver b;
    public PendingIntent c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ComponentName f471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f473g = c.a.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ExecutorService f474h = Executors.newSingleThreadExecutor();

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: e.c.a.g.a.d.q.b$a$a, reason: collision with other inner class name */
        public class RunnableC0067a implements Runnable {
            public final /* synthetic */ Intent a;

            public RunnableC0067a(Intent intent) {
                this.a = intent;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.h(this.a);
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.d.q.b$a$b, reason: collision with other inner class name */
        public class RunnableC0068b implements Runnable {
            public RunnableC0068b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.i();
            }
        }

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("com.kugou.young.watch.playstatechanged".equals(action)) {
                if (!b.this.f473g) {
                    b.this.h(intent);
                    return;
                } else {
                    b.this.j();
                    b.this.f474h.submit(new RunnableC0067a(intent));
                    return;
                }
            }
            if ("com.kugou.young.watch.metachanged".equals(action)) {
                if (!b.this.f473g) {
                    b.this.i();
                } else {
                    b.this.j();
                    b.this.f474h.submit(new RunnableC0068b());
                }
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.q.b$b, reason: collision with other inner class name */
    public class C0069b extends e.c.a.g.a.d.q.a {
        public C0069b() {
        }

        @Override // e.c.a.g.a.d.q.a, android.support.v4.media.session.MediaSessionCompat.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (g0.a) {
                g0.b("WatchMediaSession", "mediaButtonEvent: getAction = " + keyEvent.getAction() + ", getKeyCode = " + keyEvent.getKeyCode());
            }
            try {
                if (b.this.c != null) {
                    if (g0.a) {
                        g0.b("onMediaButtonEvent", "mediaButtonEvent: send");
                    }
                    b.this.c.send(b.this.f470d, 0, intent);
                }
            } catch (PendingIntent.CanceledException e2) {
                g0.k(e2);
            }
            return super.onMediaButtonEvent(intent);
        }

        @Override // e.c.a.g.a.d.q.a, android.support.v4.media.session.MediaSessionCompat.Callback
        public void onPause() {
            super.onPause();
            e.c.a.g.a.f.d.a.e(new Intent().setAction("young_action_notification_play"), true);
        }

        @Override // e.c.a.g.a.d.q.a, android.support.v4.media.session.MediaSessionCompat.Callback
        public void onPlay() {
            super.onPlay();
            e.c.a.g.a.f.d.a.e(new Intent().setAction("young_action_notification_play"), true);
        }

        @Override // e.c.a.g.a.d.q.a, android.support.v4.media.session.MediaSessionCompat.Callback
        public void onSeekTo(long j) {
            super.onSeekTo(j);
            f.E((int) j);
        }

        @Override // e.c.a.g.a.d.q.a, android.support.v4.media.session.MediaSessionCompat.Callback
        public void onSkipToNext() {
            super.onSkipToNext();
            e.c.a.g.a.f.d.a.e(new Intent().setAction("young_action_notification_next"), true);
        }

        @Override // e.c.a.g.a.d.q.a, android.support.v4.media.session.MediaSessionCompat.Callback
        public void onSkipToPrevious() {
            super.onSkipToPrevious();
            e.c.a.g.a.f.d.a.e(new Intent().setAction("young_action_notification_previous"), true);
        }

        public /* synthetic */ C0069b(b bVar, a aVar) {
            this();
        }
    }

    public b(Context context) {
        this.f470d = context;
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, MediaButtonIntentReceiver.class.getName());
        this.f471e = componentName;
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(this.f471e);
        this.c = PendingIntent.getBroadcast(context, 0, intent, 0);
        try {
            ((AudioManager) this.f470d.getSystemService("audio")).registerMediaButtonEventReceiver(this.f471e);
        } catch (Exception e2) {
            g0.k(e2);
        }
        this.f472f = new Handler(Looper.getMainLooper());
        a aVar = new a();
        this.b = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.kugou.young.watch.playstatechanged");
        intentFilter.addAction("com.kugou.young.watch.metachanged");
        e.c.a.g.a.f.d.a.b(aVar, intentFilter);
    }

    public final void h(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("arg_is_playing", false);
        o(booleanExtra ? 3 : 2);
        Log.e("mhs_watch_anr", "adapterChange, songPlaying = " + booleanExtra);
    }

    public final void i() {
        n();
        o(f.q() ? 3 : 2);
        Log.e("mhs_watch_anr", "adapterChange, adapterMetaChange.");
    }

    public final void j() {
        if (this.f474h == null) {
            this.f474h = Executors.newSingleThreadExecutor();
        }
    }

    public final MediaSessionCompat k() {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = new MediaSessionCompat(this.f470d, "WatchMediaSession", null, null);
                    this.a.setFlags(3);
                    this.a.setCallback(new C0069b(this, null), this.f472f);
                    this.a.setActive(true);
                }
            }
        }
        return this.a;
    }

    public NotificationCompat.MediaStyle l() {
        return new NotificationCompat.MediaStyle().setShowActionsInCompactView(2, 3, 0).setMediaSession(k().getSessionToken());
    }

    public void m() {
        e.c.a.g.a.f.d.a.g(this.b);
        try {
            ((AudioManager) this.f470d.getSystemService("audio")).unregisterMediaButtonEventReceiver(this.f471e);
            this.f471e = null;
        } catch (Exception e2) {
            g0.k(e2);
        }
        if (this.a != null) {
            this.a.setActive(false);
            this.a.release();
        }
        this.f472f = null;
    }

    public void n() {
        KGMusicWrapper currentSong = e.c.a.g.a.d.x.b.b().getCurrentSong();
        if (currentSong == null) {
            return;
        }
        String displayName = currentSong.getDisplayName();
        if (TextUtils.isEmpty(displayName)) {
            displayName = KGApplication.getContext().getString(R.string.noti_title);
        }
        k().setMetadata(new MediaMetadataCompat.Builder().putString(MediaMetadataCompat.METADATA_KEY_TITLE, displayName).putLong(MediaMetadataCompat.METADATA_KEY_DURATION, currentSong.getDuration()).putString(MediaMetadataCompat.METADATA_KEY_ARTIST, currentSong.getArtistName()).putString(MediaMetadataCompat.METADATA_KEY_ALBUM, currentSong.getAlbumName()).build());
    }

    public void o(int i2) {
        k().setPlaybackState(new PlaybackStateCompat.Builder().setState(i2, f.d(), 1.0f, SystemClock.elapsedRealtime()).setActions(820L).build());
    }
}
