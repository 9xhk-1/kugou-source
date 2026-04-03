package com.kugou.android.watch.lite.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Rating;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.service.media.MediaBrowserService;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.ipc.core.RemoteConnector;
import com.kugou.android.watch.lite.common.INoGuard;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.t.e;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 21)
public class MediaService extends MediaBrowserService implements INoGuard {
    private static final String ACTION_CANCEL_LIKE = "cancelLike";
    private static final String ACTION_CANCEL_STORE = "cancelStore";
    private static final String ACTION_DOWNLOAD = "download";
    private static final String ACTION_LIKE = "like";
    private static final String ACTION_RECOGNIZE_MUSIC = "recognize_music";
    private static final String ACTION_SETTING_LOOP_MODE = "setting_loop_mode";
    private static final String ACTION_STORE = "store";
    private static final String CHANNEL_ID_STRING = "media_service";
    private static final String EVENT_DELAY_EXTRA = "event_delay_extra";
    private static final String ID = "media_root_id";
    private static final String LOOP_MODE_EXTRA = "loop_mode_extra";
    private static final int NOTIFICATION_ID = 100001;
    private static final String NOTIFICATION_NAME = "media_play";
    private static final String TAG = "MediaService, mhs_watch";
    private static final String XTC_DEMO_PACKAGENAME = "com.kugou.common.hotfix.watchvoicecontroller";
    private static final String XTC_VOICE_PACKAGENAME = "com.xtc.i3launcher";
    public MediaSession.Callback callback;
    private int defaultKey;
    private boolean isXTC;
    private BroadcastReceiver mBroadcastReceiver;
    private Handler mHandler;
    private MediaSession mediaSession;

    public class a extends MediaSession.Callback {
        public a() {
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(@NonNull String str, @Nullable Bundle bundle, @Nullable ResultReceiver resultReceiver) {
            super.onCommand(str, bundle, resultReceiver);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(@NonNull String str, @Nullable Bundle bundle) {
            super.onCustomAction(str, bundle);
            Log.d(MediaService.TAG, "onCustomAction:" + str + ", isXTC = " + MediaService.this.isXTC);
            if (MediaService.this.isXTC) {
                str.hashCode();
                switch (str) {
                    case "cancelStore":
                    case "like":
                    case "store":
                    case "download":
                    case "cancelLike":
                        MediaService.this.updatePlaybackStateNoSupport();
                        break;
                    case "setting_loop_mode":
                        if (bundle != null) {
                            MediaService.this.handleSettingLoopMode(bundle.getInt(MediaService.LOOP_MODE_EXTRA));
                            break;
                        }
                        break;
                    case "recognize_music":
                        MediaService.this.handleRecognizeMusic();
                        break;
                    default:
                        Log.w(MediaService.TAG, "Unknown action:" + str);
                        break;
                }
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            super.onFastForward();
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(@NonNull Intent intent) {
            return super.onMediaButtonEvent(intent);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            super.onPause();
            if (MediaService.this.isXTC) {
                Log.d(MediaService.TAG, "onPause");
                e.a.D();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            super.onPlay();
            if (MediaService.this.isXTC) {
                Log.d(MediaService.TAG, "onPlay");
                e.a.E();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            super.onPlayFromMediaId(str, bundle);
            if (!MediaService.this.isXTC) {
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) {
            super.onPlayFromSearch(str, bundle);
            if (MediaService.this.isXTC) {
                Log.d(MediaService.TAG, "onPlayFromSearch");
                e.a.F(str, bundle);
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri uri, Bundle bundle) {
            super.onPlayFromUri(uri, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            super.onPrepare();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String str, Bundle bundle) {
            super.onPrepareFromMediaId(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String str, Bundle bundle) {
            super.onPrepareFromSearch(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            super.onPrepareFromUri(uri, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            super.onRewind();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j) {
            super.onSeekTo(j);
            Log.d(MediaService.TAG, "onSeekTo, pos = " + j);
            if (MediaService.this.isXTC && j == 0) {
                MediaService.this.updatePlaybackStateNoSupport();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(@NonNull Rating rating) {
            super.onSetRating(rating);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            super.onSkipToNext();
            if (MediaService.this.isXTC) {
                Log.d(MediaService.TAG, "onSkipToNext");
                e.a.G();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            super.onSkipToPrevious();
            if (MediaService.this.isXTC) {
                Log.d(MediaService.TAG, "onSkipToPrevious");
                e.a.H();
            }
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j) {
            super.onSkipToQueueItem(j);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            super.onStop();
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (MediaService.this.isXTC && "com.kugou.young.xtc.statusupdate".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra(e.a.l(), MediaService.this.defaultKey);
                if (MediaService.this.defaultKey != intExtra) {
                    MediaService.this.updatePlaybackState(intExtra);
                }
                Log.d("mhs_watch", "service updatePlaybackState， event.playState:" + intExtra);
            }
        }
    }

    public MediaService() {
        this.isXTC = l1.m0() && e.a.x();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.callback = new a();
        this.defaultKey = -100012;
        this.mBroadcastReceiver = new b();
    }

    private void dealForeground() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID_STRING, NOTIFICATION_NAME, 3);
                if (notificationManager != null) {
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                startForeground(NOTIFICATION_ID, new Notification.Builder(getApplicationContext(), CHANNEL_ID_STRING).build());
                Log.e("mhs_watch_crash", "dealForeground  startForeground");
                hasStartMediaService();
            } catch (Exception e2) {
                g0.l(e2, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRecognizeMusic() {
        Log.d(TAG, "Handling recognize_music action");
        e.a.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSettingLoopMode(int i2) {
        Log.d(TAG, "Handling setting loop mode action");
        e.a.t(i2);
    }

    private void hasStartMediaService() {
        RemoteConnector.l();
    }

    private void initMediaSession() {
        MediaSession mediaSession = new MediaSession(this, "kugouXtcVoiceMediaService");
        this.mediaSession = mediaSession;
        mediaSession.setCallback(this.callback);
        this.mediaSession.setActive(true);
        setSessionToken(this.mediaSession.getSessionToken());
    }

    private boolean isSafePlaying() {
        try {
            if (f.o()) {
                return f.q();
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaybackState(int i2) {
        MediaSession mediaSession;
        if (this.isXTC && (mediaSession = this.mediaSession) != null) {
            mediaSession.setPlaybackState(new PlaybackState.Builder().setState(i2, 0L, 1.0f).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlaybackStateNoSupport() {
        if (Build.VERSION.SDK_INT < 22 || this.mediaSession == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("errorCode", "000008");
        bundle.putString("errorMsg", "暂不支持该功能");
        int i2 = isSafePlaying() ? 3 : 2;
        Log.d("mhs_watch", "updatePlaybackStateNoSupport state = " + i2);
        this.mediaSession.setPlaybackState(new PlaybackState.Builder().setState(i2, 0L, 1.0f).setExtras(bundle).build());
    }

    @Override // android.service.media.MediaBrowserService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.isXTC = l1.m0() && e.a.x();
        Log.d(TAG, "服务类 开关onCreate isXTC = " + this.isXTC);
        try {
            dealForeground();
            initMediaSession();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.kugou.young.xtc.statusupdate");
            e.c.a.g.a.f.d.a.b(this.mBroadcastReceiver, intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.isXTC) {
            return;
        }
        try {
            boolean configAsBoolean = c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.J2, false);
            Log.e("mhs_watch", "voice_force_stop_service switch is close:" + configAsBoolean);
            if (configAsBoolean) {
                stopSelf();
                Log.e("mhs_watch", "服务已停掉:" + e.a.y());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.isXTC) {
            stopForeground(true);
            MediaSession mediaSession = this.mediaSession;
            if (mediaSession != null) {
                mediaSession.release();
            }
            e.c.a.g.a.f.d.a.g(this.mBroadcastReceiver);
        }
    }

    @Override // android.service.media.MediaBrowserService
    @Nullable
    public MediaBrowserService.BrowserRoot onGetRoot(@NonNull String str, int i2, @Nullable Bundle bundle) {
        if (g0.f()) {
            Log.d(TAG, "onGetRoot clientPackageName:" + str + ", 前台进程 = " + KGApplication.isForeProcess() + ",有无页面 Foreground.isForeground() =" + e.c.a.g.a.d.l.a.e());
        }
        if ("com.xtc.i3launcher".equals(str) || XTC_DEMO_PACKAGENAME.equals(str) || l1.m0()) {
            if (g0.f()) {
                Log.d("mhs_watch", "来自小天才语音拉起， clientPackageName:" + str + ", isXTC = " + this.isXTC + ", SystemUtils.isXTC = " + l1.m0());
            }
            e.c.a.g.a.t.c.f1230e = true;
        }
        return new MediaBrowserService.BrowserRoot(ID, null);
    }

    @Override // android.service.media.MediaBrowserService
    public void onLoadChildren(@NonNull String str, @NonNull MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        dealForeground();
        return super.onStartCommand(intent, i2, i3);
    }
}
