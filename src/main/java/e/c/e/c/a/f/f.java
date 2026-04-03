package e.c.e.c.a.f;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.kugou.common.player.kgplayer.PlayStream;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;
import e.c.e.b.e.d;
import e.c.e.b.e.e;
import e.c.e.b.g.a;
import e.c.e.c.a.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f<T> implements e.c.e.c.a.c<T>, d.c<T> {

    @NonNull
    public e.c.e.b.e.e<T> a;

    @NonNull
    public final e.c.e.b.g.a<e.c.e.c.a.b> b;
    public final d<c.a> c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d<c.b<T>> f1313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d<c.InterfaceC0238c<T>> f1314e;

    public class a implements d.a<c.a> {
        public a() {
        }

        @Override // e.c.e.c.a.f.f.d.a
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c.a create() {
            return new e.c.e.c.a.f.a(f.this.a);
        }
    }

    public class b implements d.a<c.b<T>> {
        public b() {
        }

        @Override // e.c.e.c.a.f.f.d.a
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c.b<T> create() {
            return new e.c.e.c.a.f.c(f.this.a, f.this.b);
        }
    }

    public class c implements d.a<c.InterfaceC0238c<T>> {
        public c() {
        }

        @Override // e.c.e.c.a.f.f.d.a
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c.InterfaceC0238c<T> create() {
            return new g(f.this.a);
        }
    }

    public static class d<T> {
        public a<T> a;
        public volatile T b;

        public interface a<T> {
            @NonNull
            T create();
        }

        public d(a<T> aVar) {
            this.a = aVar;
        }

        public T a() {
            if (this.b == null) {
                this.b = this.a.create();
            }
            return this.b;
        }
    }

    public f() {
        e.c.e.b.g.a<e.c.e.c.a.b> aVar = new e.c.e.b.g.a<>();
        this.b = aVar;
        e.c.e.b.b.b.f().s("MainPlayerManager", "new MainPlayerManager");
        e.a aVar2 = new e.a();
        aVar2.b("MainPlayerManager");
        e.c.e.b.e.b<T> bVarA = aVar2.a();
        this.a = bVarA;
        this.c = new d<>(new a());
        this.f1313d = new d<>(new b());
        this.f1314e = new d<>(new c());
        bVarA.setAudio(new e(bVarA.audio()));
        this.a.audio().setDirector(this);
        this.a.audio().addSyncListener(new e.c.e.c.a.f.e(this.a, aVar));
        this.a.audio().addListener(new e.c.e.c.a.f.d());
        this.a.extendManager().d(new e.c.e.c.a.f.b(this.a, aVar));
    }

    public e.c.e.b.e.e<T> c() {
        return this.a;
    }

    @Override // e.c.e.c.a.c
    public c.a getIControl() {
        return this.c.a();
    }

    @Override // e.c.e.c.a.c
    public c.b<T> getIInfo() {
        return this.f1313d.a();
    }

    @Override // e.c.e.c.a.c
    public c.InterfaceC0238c<T> getIQueue() {
        return this.f1314e.a();
    }

    public class e extends e.c.e.b.e.g.a<T> {

        public class a implements a.b<e.c.e.c.a.b> {
            public final /* synthetic */ int a;
            public final /* synthetic */ long b;

            public a(e eVar, int i2, long j) {
                this.a = i2;
                this.b = j;
            }

            @Override // e.c.e.b.g.a.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void notify(@NonNull e.c.e.c.a.b bVar) {
                bVar.onLoad(this.a, this.b);
            }
        }

        public e(d.b<T> bVar) {
            super(bVar);
        }

        public final void a() {
            f.this.b.c(new a(this, f.this.a.audio().getToken(), SystemClock.elapsedRealtime()));
        }

        @Override // e.c.e.b.e.g.a, e.c.e.b.e.d.b
        public void setDataSource(String str, long j, long j2, AudioTypeInfo audioTypeInfo) {
            super.setDataSource(str, j, j2, audioTypeInfo);
            a();
            prepareAsync();
        }

        @Override // e.c.e.b.e.g.a, e.c.e.b.e.d.b
        public void setDataSource(PlayStream playStream, long j, long j2, AudioTypeInfo audioTypeInfo) {
            super.setDataSource(playStream, j, j2, audioTypeInfo);
            a();
            prepareAsync();
        }
    }
}
