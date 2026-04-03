package e.c.e.c.a.f;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import e.c.e.b.c.e.c;
import e.c.e.b.g.a;
import e.c.e.c.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class b<T> implements Object {

    @NonNull
    public e.c.e.b.e.e<T> a;

    @NonNull
    public final e.c.e.b.g.a<e.c.e.c.a.b> b;

    public class a extends a.C0237a {
        public a() {
        }

        @Override // e.c.e.b.c.b.a.C0215a, e.c.e.b.c.b.a, e.c.e.b.c.c, e.c.e.c.a.a
        public e.c.e.b.c.e.c getSongActionHooker() {
            return new C0240b(b.this, null);
        }
    }

    /* JADX INFO: renamed from: e.c.e.c.a.f.b$b, reason: collision with other inner class name */
    public class C0240b extends c.a<T> {

        /* JADX INFO: renamed from: e.c.e.c.a.f.b$b$a */
        public class a implements a.b<e.c.e.c.a.b> {
            public final /* synthetic */ int a;
            public final /* synthetic */ long b;
            public final /* synthetic */ int c;

            public a(C0240b c0240b, int i2, long j, int i3) {
                this.a = i2;
                this.b = j;
                this.c = i3;
            }

            @Override // e.c.e.b.g.a.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void notify(@NonNull e.c.e.c.a.b bVar) {
                bVar.onSeekTo(this.a, this.b, this.c);
            }
        }

        public C0240b() {
        }

        @Override // e.c.e.b.c.e.c.a, e.c.e.b.c.e.c
        public void afterSeekTo(e.c.e.b.c.e.a<c.e, Void> aVar) {
            b.this.b.c(new a(this, b.this.a.audio().getToken(), SystemClock.elapsedRealtime(), aVar.a.a));
        }

        public /* synthetic */ C0240b(b bVar, a aVar) {
            this();
        }
    }

    public b(@NonNull e.c.e.b.e.e<T> eVar, @NonNull e.c.e.b.g.a<e.c.e.c.a.b> aVar) {
        this.a = eVar;
        this.b = aVar;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public e.c.e.c.a.a getProvider() {
        return new a();
    }
}
