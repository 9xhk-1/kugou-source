package e.c.e.b.e;

import android.os.Message;
import android.support.annotation.NonNull;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import com.kugou.common.player.kgplayer.KGCorePlayer;
import com.kugou.common.player.kgplayer.KGMediaPlayer;
import com.kugou.common.player.kgplayer.KGPlayer;
import com.kugou.common.player.kgplayer.PlayStream;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;
import com.kugou.common.player.kugouplayer.LibraryManager;
import e.c.e.b.c.e.c;
import e.c.e.b.d.a;
import e.c.e.b.e.d;
import e.c.e.b.g.b;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements e.c.e.b.e.d<T> {

    @NonNull
    public String a;

    @NonNull
    public e.c.e.b.c.a b = new e.c.e.b.c.a();
    public b<T> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d.b<T> f1292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f1293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f1294f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public e.c.e.b.e.c f1295g;

    public static class b<T> implements d.b<T> {

        @NonNull
        public final e.c.e.b.e.d<T> a;

        @NonNull
        public e.c.e.b.e.c b;

        @NonNull
        public final h<T> c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile d.c<T> f1296d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile e.c.e.b.a.a f1297e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f1298f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final e.c.e.b.d.a f1299g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final e.c.e.b.d.b f1300h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final e.c.e.b.d.b f1301i;

        /* JADX INFO: renamed from: e.c.e.b.e.a$b$a, reason: collision with other inner class name */
        public class C0224a implements e.c.e.b.c.d<c.b<T>, Void, e.c.e.b.c.e.c> {
            public C0224a() {
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<c.b<T>, Void> aVar) {
                c.b<T> bVar = aVar.a;
                T t = bVar.a;
                boolean z = bVar.b;
                long j = bVar.c;
                long j2 = bVar.f1291d;
                b.this.f(t);
                b.this.c.f1303e = z;
                d.c cVar = b.this.f1296d;
                Objects.requireNonNull(cVar, "must set the director by CorePlayer.Audio#setDirector");
                cVar.loadDataSource(t, z, j, j2);
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.b<T>, Void> aVar) {
                cVar.afterLoad(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.b<T>, Void> aVar) {
                return cVar.beforeLoad(aVar);
            }
        }

        /* JADX INFO: renamed from: e.c.e.b.e.a$b$b, reason: collision with other inner class name */
        public class C0225b implements b.InterfaceC0236b {
            public C0225b() {
            }

            @Override // e.c.e.b.g.b.InterfaceC0236b
            public void call() {
                b.this.f1299g.onCompletion();
            }
        }

        public class c implements e.c.e.b.c.d<c.d, Void, e.c.e.b.c.e.c> {
            public c() {
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<c.d, Void> aVar) {
                b.this.setVolume(1.0f);
                b.this.b.start();
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.d, Void> aVar) {
                cVar.afterPlay(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.d, Void> aVar) {
                return cVar.beforePlay(aVar);
            }
        }

        public class d implements e.c.e.b.c.d<c.C0217c, Void, e.c.e.b.c.e.c> {
            public d() {
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<c.C0217c, Void> aVar) {
                b.this.b.pause();
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.C0217c, Void> aVar) {
                cVar.afterPause(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.C0217c, Void> aVar) {
                return cVar.beforePause(aVar);
            }
        }

        public class e implements e.c.e.b.c.d<c.e, Void, e.c.e.b.c.e.c> {
            public final /* synthetic */ int a;

            public e(int i2) {
                this.a = i2;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<c.e, Void> aVar) {
                b.this.b.seekTo(this.a);
                b.this.c.c.h();
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.e, Void> aVar) {
                cVar.afterSeekTo(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.e, Void> aVar) {
                return cVar.beforeSeekTo(aVar);
            }
        }

        public class f implements e.c.e.b.c.d<c.f, Void, e.c.e.b.c.e.c> {
            public final /* synthetic */ float a;

            public f(float f2) {
                this.a = f2;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<c.f, Void> aVar) {
                b.this.b.setVolume(this.a);
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.f, Void> aVar) {
                cVar.afterSetVolume(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.c cVar, e.c.e.b.c.e.a<c.f, Void> aVar) {
                return cVar.beforeSetVolume(aVar);
            }
        }

        public class g extends a.C0221a {
            public g() {
            }

            @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
            public void onPause() {
                b.this.c.c.f();
            }

            @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
            public void onPlay() {
                b.this.c.c.g();
            }

            @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
            public void onPrepared() {
                b.this.c.f1302d = true;
                if (b.this.c.f1303e) {
                    b.this.play();
                }
            }

            @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
            public void onSeekComplete() {
                b.this.c.f1302d = true;
                b.this.c.c.i();
            }
        }

        public static class h<T> {
            public AtomicInteger a = new AtomicInteger();
            public volatile T b;
            public e.c.e.b.g.b c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public volatile boolean f1302d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public volatile boolean f1303e;

            public h(@NonNull e.c.e.b.e.d<T> dVar) {
                this.c = new e.c.e.b.g.b(dVar);
            }

            public int c() {
                return this.a.get();
            }

            public void d() {
                this.c.l();
                this.f1302d = false;
                this.f1303e = false;
            }

            public void e(T t) {
                this.b = t;
                this.a.incrementAndGet();
            }
        }

        public b(@NonNull String str, @NonNull a<T> aVar, @NonNull e.c.e.b.e.c cVar) {
            this.a = aVar;
            this.b = cVar;
            h<T> hVar = new h<>(aVar);
            this.c = hVar;
            hVar.d();
            e.c.e.b.d.b bVar = new e.c.e.b.d.b(new e.c.e.b.d.a[0]);
            this.f1300h = bVar;
            e.c.e.b.d.b bVar2 = new e.c.e.b.d.b(true, new e.c.e.b.d.a[0]);
            this.f1301i = bVar2;
            e.c.e.b.d.b bVar3 = new e.c.e.b.d.b(bVar, bVar2);
            this.f1299g = bVar3;
            e eVar = new e(str, bVar3);
            this.f1298f = eVar;
            cVar.setIKGPlayerListener(eVar);
            addListener(new g());
            setPlayControlMember(new c(aVar));
        }

        @Override // e.c.e.b.e.d.b
        public void addListener(e.c.e.b.d.a aVar) {
            this.f1301i.a(aVar);
        }

        @Override // e.c.e.b.e.d.b
        public void addSyncListener(e.c.e.b.d.a aVar) {
            this.f1300h.a(aVar);
        }

        public final void f(T t) {
            stop();
            reset();
            this.c.e(t);
        }

        @Override // e.c.e.b.e.d.b
        public int getBufferedPosition() {
            return this.b.getBufferSize();
        }

        @Override // e.c.e.b.e.d.b
        public int getCurrentPosition() {
            if (isPrepared()) {
                return this.b.getCurrentPosition();
            }
            return 0;
        }

        @Override // e.c.e.b.e.d.b
        public T getCurrentSong() {
            return (T) this.c.b;
        }

        @Override // e.c.e.b.e.d.b
        public int getDuration() {
            return this.b.getDuration();
        }

        @Override // e.c.e.b.e.d.b
        public int getPlayStatus() {
            return this.b.getPlayStatus();
        }

        @Override // e.c.e.b.e.d.b
        public int getToken() {
            return this.c.c();
        }

        @Override // e.c.e.b.e.d.b
        public boolean isBuffering() {
            return this.b.isBuffering();
        }

        @Override // e.c.e.b.e.d.b
        public boolean isCore() {
            return this.b instanceof KGCorePlayer;
        }

        @Override // e.c.e.b.e.d.b
        public boolean isPlaying() {
            return this.b.isPlaying();
        }

        @Override // e.c.e.b.e.d.b
        public boolean isPrepared() {
            return this.c.f1302d;
        }

        @Override // e.c.e.b.e.d.b
        public void loadDataSource(T t, boolean z) {
            loadDataSource(t, z, 0L, 0L);
        }

        @Override // e.c.e.b.e.d.b
        public void pause() {
            this.a.extendManager().a(e.c.e.b.c.e.c.class, new c.C0217c(), new d());
        }

        @Override // e.c.e.b.e.d.b
        public void play() {
            this.a.extendManager().a(e.c.e.b.c.e.c.class, new c.d(), new c());
        }

        @Override // e.c.e.b.e.d.b
        public void prepareAsync() {
            this.b.prepareAsync();
        }

        @Override // e.c.e.b.e.d.b
        public void reset() {
            this.b.reset();
            this.c.d();
        }

        @Override // e.c.e.b.e.d.b
        public void seekTo(int i2) {
            this.a.extendManager().a(e.c.e.b.c.e.c.class, new c.e(i2), new e(i2));
        }

        @Override // e.c.e.b.e.d.b
        public void setDataSource(String str, long j, long j2, AudioTypeInfo audioTypeInfo) {
            if (audioTypeInfo == null) {
                this.b.setDataSource(str, j, j2);
            } else {
                this.b.setDataSource(str, j, j2, audioTypeInfo);
            }
        }

        @Override // e.c.e.b.e.d.b
        public void setDirector(d.c<T> cVar) {
            this.f1296d = cVar;
        }

        @Override // e.c.e.b.e.d.b
        public void setPlayControlMember(@NonNull e.c.e.b.a.a aVar) {
            Objects.requireNonNull(aVar, "responder should not be null!");
            e.c.e.b.a.a aVar2 = this.f1297e;
            this.f1297e = aVar;
            if (aVar2 != null) {
                e.c.e.b.b.b.b().unregisterResponder(this.f1297e);
            }
            e.c.e.b.b.b.b().registerResponder(aVar);
        }

        @Override // e.c.e.b.e.d.b
        public void setVolume(float f2) {
            this.a.extendManager().a(e.c.e.b.c.e.c.class, new c.f(f2), new f(f2));
        }

        @Override // e.c.e.b.e.d.b
        public void stop() {
            this.b.stop();
        }

        @Override // e.c.e.b.e.d.b
        public void updateEndPosition(long j) {
            this.c.c.j((int) j, new C0225b());
        }

        @Override // e.c.e.b.e.d.b
        public void loadDataSource(T t, boolean z, long j, long j2) {
            this.a.extendManager().a(e.c.e.b.c.e.c.class, new c.b(t, z, j, j2), new C0224a());
        }

        @Override // e.c.e.b.e.d.b
        public void setDataSource(PlayStream playStream, long j, long j2, AudioTypeInfo audioTypeInfo) {
            if (audioTypeInfo == null) {
                this.b.setDataSource(playStream, j, j2);
            } else {
                this.b.setDataSource(playStream, j, j2, audioTypeInfo);
            }
        }
    }

    public static class c implements e.c.e.b.a.a {
        public a a;

        public c(a aVar) {
            this.a = aVar;
        }

        @Override // e.c.e.b.a.a
        public String myMark() {
            return this.a.a;
        }

        @Override // e.c.e.b.a.a
        public void onAskedMute(String str) {
            this.a.audio().setVolume(0.0f);
        }

        @Override // e.c.e.b.a.a
        public void onAskedPause(String str) {
            this.a.audio().pause();
        }

        @Override // e.c.e.b.a.a
        public void onAskedUnmute(String str) {
            this.a.audio().setVolume(1.0f);
        }

        @Override // e.c.e.b.a.a
        public boolean pardon(String str) {
            return false;
        }
    }

    public static class d implements d.InterfaceC0231d {
        public volatile int[] a;

        public d() {
            this.a = new int[]{1, 1};
        }

        @Override // e.c.e.b.e.d.InterfaceC0231d
        public int[] getLocalPlaySpeedCache() {
            return this.a;
        }
    }

    public static class f implements d.e {
        public f() {
        }
    }

    public a(@NonNull String str) {
        this.a = str;
        synchronized (this) {
            this.f1295g = b();
        }
    }

    @Override // e.c.e.b.e.d
    @NonNull
    public d.b<T> audio() {
        if (this.f1292d == null) {
            synchronized (this) {
                if (this.f1292d == null) {
                    b<T> bVar = new b<>(this.a, this, this.f1295g);
                    this.c = bVar;
                    this.f1292d = bVar;
                }
            }
        }
        return this.f1292d;
    }

    @NonNull
    public final KGPlayer b() {
        KGCorePlayer kGCorePlayerCreate = LibraryManager.loadLibrary() ? KGCorePlayer.create(e.c.e.b.b.b.d()) : null;
        return kGCorePlayerCreate == null ? new KGMediaPlayer(e.c.e.b.b.b.d()) : kGCorePlayerCreate;
    }

    @Override // e.c.e.b.e.d
    @NonNull
    public e.c.e.b.c.a extendManager() {
        return this.b;
    }

    @Override // e.c.e.b.e.d
    @NonNull
    public d.InterfaceC0231d extra() {
        if (this.f1294f == null) {
            synchronized (this) {
                if (this.f1294f == null) {
                    this.f1294f = new d();
                }
            }
        }
        return this.f1294f;
    }

    @Override // e.c.e.b.e.d
    public void setAudio(@NonNull d.b<T> bVar) {
        Objects.requireNonNull(bVar);
        synchronized (this) {
            this.f1292d = bVar;
        }
    }

    @Override // e.c.e.b.e.d
    public void setExtra(@NonNull d.InterfaceC0231d interfaceC0231d) {
    }

    @Override // e.c.e.b.e.d
    public void setVideo(@NonNull d.e eVar) {
    }

    @Override // e.c.e.b.e.d
    @NonNull
    public d.e video() {
        if (this.f1293e == null) {
            synchronized (this) {
                if (this.f1293e == null) {
                    this.f1293e = new f();
                }
            }
        }
        return this.f1293e;
    }

    public static class e implements KGPlayer.IKGVideoPlayerListener {
        public final String a;
        public e.c.e.b.d.a b;

        public e(String str, e.c.e.b.d.a aVar) {
            this.a = str + "-Listener";
            this.b = aVar;
        }

        public final void a() {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onBufferEnd();
            }
        }

        public final void b() {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onBufferStart();
            }
        }

        public final void c(int i2) {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onBufferingUpdate(i2);
            }
        }

        public final void d() {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onCompletion();
            }
        }

        public final void e(int i2, int i3) {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onError(i2, i3);
            }
        }

        public final void f(int i2, int i3) {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onInfo(i2, i3);
            }
        }

        public final void g(int i2, int i3, String str) {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onInfo(i2, i3, str);
            }
        }

        public final void h(int i2, int i3, byte[] bArr) {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onInfo(i2, i3, bArr);
            }
        }

        public final void i() {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onPause();
            }
        }

        public final void j() {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onPlay();
            }
        }

        public final void k(Message message) {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onPlayerMessageReceived(message);
            }
        }

        public final void l() {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onPrepared();
            }
        }

        public final void m() {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onSeekComplete();
            }
        }

        public final void n() {
            e.c.e.b.d.a aVar = this.b;
            if (aVar != null) {
                aVar.onStop();
            }
        }

        public final void o(int i2, int i3) {
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.b
        public void onBufferingUpdate(KGPlayer kGPlayer, int i2) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().d(this.a, "onBufferingUpdate percent= " + i2);
            }
            c(i2);
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.InterfaceC0230c
        public void onCompletion(KGPlayer kGPlayer) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().d(this.a, "onCompletion");
            }
            d();
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.d
        public void onError(KGPlayer kGPlayer, int i2, int i3) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().d(this.a, "onError what = " + i2 + ", extra = " + i3);
            }
            e(i2, i3);
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.e
        public void onInfo(KGPlayer kGPlayer, int i2, int i3) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().d(this.a, "onInfo what = " + i2 + ", extra = " + i3);
            }
            f(i2, i3);
            if (i2 == 0) {
                b();
                return;
            }
            if (i2 == 1) {
                a();
                return;
            }
            if (i2 != 2) {
                return;
            }
            if (i3 == 5) {
                j();
            } else if (i3 == 6) {
                i();
            } else {
                if (i3 != 8) {
                    return;
                }
                n();
            }
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.f
        public void onPlayerMessageReceived(KGPlayer kGPlayer, Message message) {
            k(message);
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.g
        public void onPrepared(KGPlayer kGPlayer) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().d(this.a, "onPrepared");
            }
            l();
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.h
        public void onSeekComplete(KGPlayer kGPlayer) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().d(this.a, "onSeekComplete");
            }
            m();
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(KGPlayer kGPlayer, int i2, int i3) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().d(this.a, "onVideoSizeChanged:" + i2 + RetryStaticsLOG.MARK_END + i3);
            }
            o(i2, i3);
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.e
        public void onInfo(KGPlayer kGPlayer, int i2, int i3, String str) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.b.b.b.f().d(this.a, "onInfo what = " + i2 + ", extra = " + i3 + ", data = " + str);
            }
            g(i2, i3, str);
        }

        @Override // com.kugou.common.player.kgplayer.KGPlayer.IKGVideoPlayerListener, e.c.e.b.e.c.a, e.c.e.b.e.c.e
        public void onInfo(KGPlayer kGPlayer, int i2, int i3, byte[] bArr) {
            if (e.c.e.b.b.b.f().debug()) {
                e.c.e.a.a.b bVarF = e.c.e.b.b.b.f();
                String str = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append("onInfo what = ");
                sb.append(i2);
                sb.append(", extra = ");
                sb.append(i3);
                sb.append(", datasize = ");
                sb.append(bArr != null ? bArr.length : 0);
                bVarF.d(str, sb.toString());
            }
            h(i2, i3, bArr);
        }
    }
}
