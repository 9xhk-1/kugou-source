package e.c.a.g.a.d.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecordingConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.CheckPlayDelegate;
import com.kugou.android.watch.lite.base.player.PlayerNotificationReceiver;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.common.network.ListenNetStateReceiver;
import e.c.a.g.a.d.r.o.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import e.c.e.c.a.b;
import e.c.e.c.a.c;
import java.util.Iterator;
import java.util.List;
import rx.functions.Action1;

/* JADX WARN: Unexpected interfaces in signature: [e.c.a.g.a.d.x.a] */
/* JADX INFO: loaded from: classes.dex */
public class h implements e.c.e.c.a.c<KGMusicWrapper>, Object {
    public static final String q = "h";
    public static volatile h r = null;
    public static boolean s = false;
    public static e.c.a.g.a.d.h.a t = null;
    public static boolean u = false;
    public final CheckPlayDelegate b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AudioManager f564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f565i;
    public boolean j;
    public e.c.a.g.a.i.a k;
    public ListenNetStateReceiver l;
    public AudioManager.AudioRecordingCallback m;
    public final PlayerNotificationReceiver n;
    public b.a o;
    public e.c.a.g.a.d.q.b p;
    public final e.c.a.g.a.d.x.v.a a = e.c.a.g.a.d.x.v.a.f();
    public final Object c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f560d = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.D(hVar.getCurrentSong());
        }
    }

    public class b implements AudioManager.OnAudioFocusChangeListener {
        public boolean a = false;

        public class a implements Action1<String> {
            public final /* synthetic */ boolean a;

            public a(boolean z) {
                this.a = z;
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(String str) {
                h.this.f564h.abandonAudioFocus(h.this.f565i);
                if (this.a) {
                    h.this.C();
                }
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.d.x.h$b$b, reason: collision with other inner class name */
        public class C0085b implements Action1<String> {
            public C0085b(b bVar) {
            }

            @Override // rx.functions.Action1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void call(String str) {
                if (e.c.a.g.a.d.x.f.q()) {
                    e.c.a.g.a.d.x.f.t();
                }
            }
        }

        public b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            if (g0.a) {
                g0.b(h.q, "onAudioFocusChange: " + i2);
            }
            if (i2 == -3 || i2 == -2) {
                if (e.c.a.g.a.d.x.f.q()) {
                    e.c.a.g.a.d.x.f.t();
                    this.a = true;
                    return;
                }
                return;
            }
            if (i2 != -1) {
                if (i2 == 1 && this.a) {
                    this.a = false;
                    e.c.a.g.a.d.x.f.x();
                    return;
                }
                return;
            }
            boolean zQ = e.c.a.g.a.d.x.f.q();
            if (zQ) {
                e.c.a.g.a.d.x.f.t();
                this.a = false;
            }
            m1.d(500, new a(zQ));
            if (l1.n0()) {
                m1.d(1500, new C0085b(this));
            }
        }
    }

    public class c implements Runnable {

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.f564h.requestAudioFocus(h.this.f565i, 1, 1);
                e.c.a.g.a.d.x.f.x();
            }
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activityC;
            if (h.s || (activityC = e.c.a.g.a.d.j.a.e().c()) == null) {
                return;
            }
            boolean unused = h.s = true;
            e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(activityC);
            if (h.this.j) {
                e.c.a.g.a.d.h.a unused2 = h.t = aVar;
            }
            aVar.setCancelable(false);
            aVar.setCanceledOnTouchOutside(false);
            aVar.e("概念版音频播放被其他应用中断");
            aVar.a("取消");
            aVar.b("恢复播放");
            aVar.d(new a());
            aVar.show();
        }
    }

    public class d extends b.a {

        public class a implements Runnable {
            public final /* synthetic */ KGMusicWrapper a;

            public a(KGMusicWrapper kGMusicWrapper) {
                this.a = kGMusicWrapper;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.s();
                try {
                    e.c.a.g.a.d.x.p.a.a.a(this.a);
                } catch (Exception e2) {
                    g0.k(e2);
                }
                try {
                    e.c.a.g.a.d.x.s.a.a.f(this.a);
                } catch (Exception e3) {
                    g0.k(e3);
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    KGMusicWrapper currentSong = h.this.getCurrentSong();
                    if (currentSong.getKgmusic() != null) {
                        e.c.a.g.a.g.m.b.a.i(currentSong);
                        if (h.this.f561e) {
                            h.this.D(currentSong);
                            h.this.k = new e.c.a.g.a.i.a(currentSong);
                            h.this.k.b();
                            h.this.f560d.postDelayed(h.this.f562f, h.this.f563g);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                h.this.B("com.kugou.young.watch.songdbupdated");
            }
        }

        public d() {
        }

        @Override // e.c.e.c.a.b
        public void onLoad(int i2, long j) {
            KGMusicWrapper currentSong = h.this.getCurrentSong();
            if (currentSong == null || TextUtils.isEmpty(currentSong.getHashValue())) {
                return;
            }
            e.c.a.g.a.d.u.d.b().showNotification(KGApplication.getContext());
            h.this.B("com.kugou.young.watch.metachanged");
            j0.b().a(new a(currentSong));
        }

        @Override // e.c.e.c.a.b
        public void onPause(int i2, long j) {
            e.c.a.g.a.d.u.d.b().showNotification(KGApplication.getContext());
            h.this.B("com.kugou.young.watch.playstatechanged");
            h.this.b.d();
            if (h.this.f561e) {
                h hVar = h.this;
                hVar.D(hVar.getCurrentSong());
            }
        }

        @Override // e.c.e.c.a.b
        public void onPlay(int i2, long j) {
            e.c.a.g.a.d.x.e.a();
            if (u0.g(h.this.x())) {
                h.this.u();
                h.this.pause();
                return;
            }
            j0.b().a(new b());
            h.this.f564h.requestAudioFocus(h.this.f565i, 1, 1);
            e.c.a.g.a.d.u.d.b().showNotification(KGApplication.getContext());
            h.this.B("com.kugou.young.watch.playstatechanged");
            h.this.b.d();
        }
    }

    public class e implements Runnable {
        public e(h hVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activityC = e.c.a.g.a.d.j.a.e().c();
            if (activityC != null) {
                boolean unused = h.u = true;
                e.c.a.g.a.d.h.a aVar = new e.c.a.g.a.d.h.a(activityC);
                aVar.setCancelable(false);
                aVar.setCanceledOnTouchOutside(false);
                aVar.e("您的网络已被家长禁用");
                aVar.a("关闭");
                aVar.b("知道了");
                aVar.show();
            }
        }
    }

    public class f extends AudioManager.AudioRecordingCallback {
        public boolean a;

        public f(h hVar) {
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> list) {
            if (l0.g(list)) {
                if (this.a) {
                    e.c.a.g.a.d.x.f.x();
                    this.a = false;
                }
            } else if (e.c.a.g.a.d.x.f.q()) {
                e.c.a.g.a.d.x.f.t();
                this.a = true;
                Iterator<AudioRecordingConfiguration> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().getClientAudioSource() == 1) {
                        e.c.a.g.a.d.x.e.d(6);
                    }
                }
            }
            super.onRecordingConfigChanged(list);
        }
    }

    public class g implements b.InterfaceC0075b {

        public class a implements Runnable {
            public final /* synthetic */ int a;
            public final /* synthetic */ boolean b;

            public a(int i2, boolean z) {
                this.a = i2;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                h.this.playByIndex(this.a, this.b);
            }
        }

        public g() {
        }

        @Override // e.c.a.g.a.d.r.o.b.InterfaceC0075b
        public void notifyQueueChange() {
            e.c.a.g.a.d.x.g.h().j(h.this.getIQueue());
            h.this.B("com.kugou.young.watch.queuechanged");
        }

        @Override // e.c.a.g.a.d.r.o.b.InterfaceC0075b
        public void resumePlay(KGMusicWrapper kGMusicWrapper) {
            if (kGMusicWrapper == h.this.getCurrentSong() && h.this.isPlayListenPartMode(false)) {
                int currentIndex = h.this.getCurrentIndex();
                boolean zIsPlaying = h.this.isPlaying();
                int currentPosition = h.this.getCurrentPosition();
                kGMusicWrapper.setDisposableStartMs(currentPosition);
                kGMusicWrapper.setForceNext(true);
                if (g0.a) {
                    g0.e("refreshPlayQueue", "support isPlayListenPartMode pos:" + currentIndex + "，isPlaying:" + h.this.isPlaying() + ", sms: " + currentPosition);
                }
                j0.b().a(new a(currentIndex, zIsPlaying));
            }
        }
    }

    public h() {
        this.b = new CheckPlayDelegate(r0.a.a());
        e.c.a.g.a.f.h.a.a aVar = e.c.a.g.a.f.h.a.a.a;
        this.f561e = aVar.k();
        this.f562f = new a();
        this.f563g = aVar.d() * 1000;
        this.f565i = new b();
        this.j = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.Q, 1) == 1;
        this.m = null;
        this.n = new PlayerNotificationReceiver(this);
        this.o = new d();
    }

    public static boolean A() {
        return r != null;
    }

    public static h y() {
        if (r == null) {
            synchronized (h.class) {
                if (r == null) {
                    r = new h();
                }
            }
        }
        return r;
    }

    public void B(String str) {
        Intent intent = new Intent(str);
        if ("com.kugou.young.watch.metachanged".equals(str) || "com.kugou.young.watch.songdbupdated".equals(str)) {
            intent.putExtra("arg_song", getIInfo().getCurrentSong());
        }
        if ("com.kugou.young.watch.playmodechanged".equals(str)) {
            intent.putExtra("arg_play_mode", getIQueue().getPlayMode());
        }
        if ("com.kugou.young.watch.playstatechanged".equals(str)) {
            intent.putExtra("arg_is_playing", getIInfo().isPlaying());
        }
        e.c.a.g.a.f.d.a.d(intent);
    }

    public final void C() {
        e.c.a.g.a.d.x.e.d(2);
        if (this.j && e.c.a.g.a.d.x.f.o() && e.c.a.g.a.d.x.f.q()) {
            Log.e("mhs_watch", "onLoseAudioFocus, isPlaying.");
            return;
        }
        if (!e.c.a.g.a.d.l.a.e()) {
            p1.h(x(), "酷狗概念版歌曲被外部暂停，请手动恢复播放");
        }
        j0.g(new c());
    }

    public final void D(KGMusicWrapper kGMusicWrapper) {
        this.f560d.removeCallbacks(this.f562f);
        e.c.a.g.a.i.a aVar = this.k;
        if (aVar != null) {
            aVar.c(kGMusicWrapper, 2);
            this.k = null;
        }
    }

    public synchronized void append(List<KGMusicWrapper> list) {
        m1.b();
        getIQueue().append(list);
    }

    public void cancelNotification() {
        e.c.a.g.a.d.u.d.b().cancel(x());
    }

    public int getBufferedPosition() {
        return getIInfo().getBufferedPosition();
    }

    public int getCurrentIndex() {
        return getIQueue().getCurrentIndex();
    }

    public int getCurrentPosition() {
        return getIInfo().getCurrentPosition();
    }

    public KGMusicWrapper getCurrentSong() {
        return getIInfo().getCurrentSong();
    }

    public int getDuration() {
        return getIInfo().getDuration();
    }

    @Override // e.c.e.c.a.c
    public c.a getIControl() {
        return e.c.a.g.a.d.x.b.a();
    }

    @Override // e.c.e.c.a.c
    public c.b<KGMusicWrapper> getIInfo() {
        return e.c.a.g.a.d.x.b.b();
    }

    @Override // e.c.e.c.a.c
    public c.InterfaceC0238c<KGMusicWrapper> getIQueue() {
        return e.c.a.g.a.d.x.b.c();
    }

    public e.c.a.g.a.d.q.b getMediaSession() {
        return this.p;
    }

    public int getNextIndex() {
        return getIQueue().getNextIndex();
    }

    public int getOnCompleteNextIndex() {
        return getIQueue().getOnCompleteNextIndex();
    }

    public int getPlayMode() {
        return getIQueue().getPlayMode();
    }

    public int getPlayStatus() {
        return getIInfo().getPlayStatus();
    }

    public int[] getPosAndDuration() {
        return new int[]{getIInfo().getCurrentPosition(), getIInfo().getDuration()};
    }

    public int getPreviousIndex() {
        return getIQueue().getPreviousIndex();
    }

    public List<KGMusicWrapper> getQueue() {
        return getIQueue().getQueue();
    }

    public synchronized void insert(List<KGMusicWrapper> list, boolean z) {
        m1.b();
        KGMusicWrapper currentSong = getCurrentSong();
        KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) l0.c(list, 0);
        if (currentSong == null || !(kGMusicWrapper == null || currentSong.getHashValue().equals(kGMusicWrapper.getHashValue()))) {
            int iMin = Math.min(getCurrentIndex() + 1, getIQueue().size());
            getIQueue().insert(iMin, list);
            if (z) {
                List<KGMusicWrapper> queue = getIQueue().getQueue();
                for (int i2 = 0; i2 < queue.size(); i2++) {
                    KGMusicWrapper kGMusicWrapper2 = queue.get(i2);
                    if (kGMusicWrapper2.getHashValue() != null && kGMusicWrapper2.getHashValue().equals(kGMusicWrapper.getHashValue())) {
                        playByIndex(i2, true);
                        return;
                    }
                }
                playByIndex(iMin, true);
            }
        }
    }

    public boolean isBuffering() {
        return getIInfo().isBuffering();
    }

    public boolean isPlayListenPartMode(boolean z) {
        KGMusicWrapper currentSong = getCurrentSong();
        if (currentSong != null) {
            return z ? currentSong.isListenPart() && isPlaying() : currentSong.isListenPart();
        }
        return false;
    }

    public boolean isPlaying() {
        return getIInfo().isPlaying();
    }

    public boolean isPrepared() {
        return getIInfo().isPrepared();
    }

    public void next() {
        synchronized (this.c) {
            getIQueue().next();
        }
    }

    public void pause() {
        getIControl().pause();
        e.c.a.g.a.d.d0.a.a("Play", "pause");
    }

    public void pauseWhenExit() {
        getIInfo().removeListener(this.o);
        pause();
        e.c.a.g.a.d.d0.a.a("Play", "pauseWhenExit");
    }

    public void play() {
        getIControl().play();
    }

    public synchronized boolean playByIndex(int i2, boolean z) {
        m1.b();
        return getIQueue().playByIndex(i2, z);
    }

    public synchronized void playSongList(List<KGMusicWrapper> list, int i2, boolean z) {
        m1.b();
        if (!l0.g(list)) {
            e.c.a.g.a.f.m.c.a.j("play_auto_start", z);
            t();
            getIQueue().playSongList(list, l1.e(i2, 0, list.size() - 1), z);
        }
    }

    public void previous() {
        synchronized (this.c) {
            getIQueue().previous();
        }
    }

    public void r() {
        if (!this.j || t == null) {
            return;
        }
        try {
            if (e.c.a.g.a.d.x.f.o() && e.c.a.g.a.d.x.f.q()) {
                t.dismiss();
                t = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("mhs_watch", "checkAndHideDilaog, e = " + e2);
        }
    }

    public void refreshPlayQueue(String str) {
        e.c.a.g.a.d.r.o.b.d(str, getCurrentSong(), isPlayListenPartMode(false), getQueue(), new g());
    }

    public final void s() {
        if (getIQueue().size() - getIQueue().getCurrentIndex() <= 2) {
            B("com.kugou.young.watch.playtotail");
        }
    }

    public void seekTo(int i2) {
        getIControl().seekTo(i2);
    }

    public void setCurrentIndex(int i2) {
        getIQueue().setCurrentIndex(i2);
    }

    public void setPlayMode(int i2, boolean z) {
        getIQueue().setPlayMode(i2, z);
    }

    public void setQueue(List<KGMusicWrapper> list) {
        m1.b();
        getIQueue().setQueue(list);
    }

    public void setVolume(float f2) {
        getIControl().setVolume(f2);
    }

    public int size() {
        return getIQueue().size();
    }

    public final void t() {
        if (x() == null || l1.k(x()) > 0) {
            return;
        }
        p1.h(e.c.c.o.f.a(), "静音中，请调大音量后播放");
    }

    public final void u() {
        if (!u && l1.m0() && u0.x(x())) {
            e.c.a.g.a.e.b.b(new YoungBITask(12820992, "statistics"));
            j0.g(new e(this));
        }
    }

    public void updateEndPosition(long j) {
        getIControl().updateEndPosition(j);
    }

    public void updateForegroundState(boolean z) {
        this.b.g(z);
        e.c.a.g.a.d.d0.a.a(q, "updateForegroundState: " + z);
    }

    public void updateListenPart(List<KGMusicWrapper> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        e.c.a.g.a.d.r.o.b.i(list, getQueue());
    }

    public void v() {
        AudioManager.AudioRecordingCallback audioRecordingCallback;
        e.c.a.g.a.d.x.v.a aVar = this.a;
        if (aVar != null) {
            aVar.g();
        }
        ListenNetStateReceiver listenNetStateReceiver = this.l;
        if (listenNetStateReceiver != null) {
            e.c.a.g.a.f.d.a.h(listenNetStateReceiver);
        }
        this.b.e();
        e.c.a.g.a.d.q.b bVar = this.p;
        if (bVar != null) {
            bVar.m();
            this.p = null;
        }
        try {
            pause();
            this.f564h.abandonAudioFocus(this.f565i);
            if (Build.VERSION.SDK_INT >= 24 && (audioRecordingCallback = this.m) != null) {
                this.f564h.unregisterAudioRecordingCallback(audioRecordingCallback);
            }
            getIInfo().removeListener(this.o);
            e.c.a.g.a.f.d.a.f(this.n);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void w() {
        t = null;
    }

    public Context x() {
        return KGApplication.getContext();
    }

    public void z() {
        this.p = new e.c.a.g.a.d.q.b(KGApplication.getContext());
        e.c.a.g.a.d.x.r.b.f().g(new e.c.a.g.a.d.x.r.c(x()));
        this.f564h = (AudioManager) x().getSystemService("audio");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("young_action_notification_previous");
        intentFilter.addAction("young_action_notification_next");
        intentFilter.addAction("young_action_notification_play");
        intentFilter.addAction("young_action_notification_start_app");
        intentFilter.addAction("young_action_notification_volume_up");
        intentFilter.addAction("young_action_notification_volume_down");
        intentFilter.addAction("young_action_notification_close");
        intentFilter.addAction("android.media.action.MICROPHONE_MUTE_CHANGED");
        intentFilter.addAction("android.media.action.SPEAKERPHONE_STATE_CHANGED");
        e.c.a.g.a.f.d.a.a(this.n, intentFilter);
        if (Build.VERSION.SDK_INT >= 24) {
            f fVar = new f(this);
            this.m = fVar;
            this.f564h.registerAudioRecordingCallback(fVar, new Handler(Looper.getMainLooper()));
        }
        ListenNetStateReceiver listenNetStateReceiver = new ListenNetStateReceiver();
        this.l = listenNetStateReceiver;
        e.c.a.g.a.f.d.a.c(listenNetStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.l.checkNetState(x());
        getIInfo().addListener(this.o);
        this.a.h(this);
        e.c.a.g.a.d.x.g.h().i();
    }
}
