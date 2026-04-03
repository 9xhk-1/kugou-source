package e.c.e.c.a.f;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import e.c.e.b.d.a;
import e.c.e.b.g.a;

/* JADX INFO: loaded from: classes2.dex */
public class e<T> extends a.C0221a {

    @NonNull
    public e.c.e.b.e.e<T> a;

    @NonNull
    public final e.c.e.b.g.a<e.c.e.c.a.b> b;

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
            bVar.onBufferStart(this.a, this.b);
        }
    }

    public class b implements a.b<e.c.e.c.a.b> {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public b(e eVar, int i2, long j) {
            this.a = i2;
            this.b = j;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.c.a.b bVar) {
            bVar.onBufferEnd(this.a, this.b);
        }
    }

    public class c implements a.b<e.c.e.c.a.b> {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public c(e eVar, int i2, long j) {
            this.a = i2;
            this.b = j;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.c.a.b bVar) {
            bVar.onPlay(this.a, this.b);
        }
    }

    public class d implements a.b<e.c.e.c.a.b> {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public d(e eVar, int i2, long j) {
            this.a = i2;
            this.b = j;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.c.a.b bVar) {
            bVar.onPause(this.a, this.b);
        }
    }

    /* JADX INFO: renamed from: e.c.e.c.a.f.e$e, reason: collision with other inner class name */
    public class C0241e implements a.b<e.c.e.c.a.b> {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public C0241e(e eVar, int i2, long j) {
            this.a = i2;
            this.b = j;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.c.a.b bVar) {
            bVar.onSeekComplete(this.a, this.b);
        }
    }

    public class f implements a.b<e.c.e.c.a.b> {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;

        public f(e eVar, int i2, long j) {
            this.a = i2;
            this.b = j;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.c.a.b bVar) {
            bVar.onCompletion(this.a, this.b);
        }
    }

    public class g implements a.b<e.c.e.c.a.b> {
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ int c;

        public g(e eVar, int i2, long j, int i3) {
            this.a = i2;
            this.b = j;
            this.c = i3;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.c.a.b bVar) {
            bVar.onBufferingUpdate(this.a, this.b, this.c);
        }
    }

    public e(@NonNull e.c.e.b.e.e<T> eVar, @NonNull e.c.e.b.g.a<e.c.e.c.a.b> aVar) {
        this.a = eVar;
        this.b = aVar;
    }

    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    public final int b() {
        return this.a.audio().getToken();
    }

    @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
    public void onBufferEnd() {
        this.b.c(new b(this, b(), a()));
    }

    @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
    public void onBufferStart() {
        this.b.c(new a(this, b(), a()));
    }

    @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
    public void onBufferingUpdate(int i2) {
        this.b.c(new g(this, b(), a(), i2));
    }

    @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
    public void onCompletion() {
        this.b.c(new f(this, b(), a()));
    }

    @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
    public void onPause() {
        this.b.c(new d(this, b(), a()));
    }

    @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
    public void onPlay() {
        this.b.c(new c(this, b(), a()));
    }

    @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
    public void onSeekComplete() {
        this.b.c(new C0241e(this, b(), a()));
    }
}
