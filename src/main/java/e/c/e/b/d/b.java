package e.c.e.b.d;

import android.os.Message;
import android.support.annotation.NonNull;
import e.c.e.b.g.a;

/* JADX INFO: loaded from: classes2.dex */
public class b implements e.c.e.b.d.a {
    public final boolean a;
    public final e.c.e.b.g.a<e.c.e.b.d.a> b;

    public class a implements r {
        public final /* synthetic */ int a;

        public a(b bVar, int i2) {
            this.a = i2;
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onBufferingUpdate(this.a);
        }
    }

    /* JADX INFO: renamed from: e.c.e.b.d.b$b, reason: collision with other inner class name */
    public class C0222b implements r {
        public final /* synthetic */ Message a;

        public C0222b(b bVar, Message message) {
            this.a = message;
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onPlayerMessageReceived(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Message a;

        public c(b bVar, Message message) {
            this.a = message;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.recycle();
        }
    }

    public class d implements r {
        public d(b bVar) {
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onBufferStart();
        }
    }

    public class e implements r {
        public e(b bVar) {
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onBufferEnd();
        }
    }

    public class f implements r {
        public f(b bVar) {
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onPlay();
        }
    }

    public class g implements r {
        public g(b bVar) {
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onPause();
        }
    }

    public class h implements r {
        public h(b bVar) {
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onStop();
        }
    }

    public class i implements a.b<e.c.e.b.d.a> {
        public final /* synthetic */ r a;

        public i(b bVar, r rVar) {
            this.a = rVar;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.b.d.a aVar) {
            this.a.call(aVar);
        }
    }

    public class j implements a.b<e.c.e.b.d.a> {
        public final /* synthetic */ r a;

        public j(b bVar, r rVar) {
            this.a = rVar;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.b.d.a aVar) {
            this.a.call(aVar);
        }
    }

    public class k implements r {
        public k(b bVar) {
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onPrepared();
        }
    }

    public class l implements r {
        public l(b bVar) {
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onCompletion();
        }
    }

    public class m implements r {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public m(b bVar, int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onError(this.a, this.b);
        }
    }

    public class n implements r {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public n(b bVar, int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onInfo(this.a, this.b);
        }
    }

    public class o implements r {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public o(b bVar, int i2, int i3, String str) {
            this.a = i2;
            this.b = i3;
            this.c = str;
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onInfo(this.a, this.b, this.c);
        }
    }

    public class p implements r {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ byte[] c;

        public p(b bVar, int i2, int i3, byte[] bArr) {
            this.a = i2;
            this.b = i3;
            this.c = bArr;
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onInfo(this.a, this.b, this.c);
        }
    }

    public class q implements r {
        public q(b bVar) {
        }

        @Override // e.c.e.b.d.b.r
        public void call(e.c.e.b.d.a aVar) {
            aVar.onSeekComplete();
        }
    }

    public interface r {
        void call(e.c.e.b.d.a aVar);
    }

    public b(boolean z, e.c.e.b.d.a... aVarArr) {
        this.b = new e.c.e.b.g.a<>();
        this.a = z;
        if (aVarArr != null) {
            for (e.c.e.b.d.a aVar : aVarArr) {
                if (aVar != null) {
                    a(aVar);
                }
            }
        }
    }

    public boolean a(e.c.e.b.d.a aVar) {
        return this.b.e(aVar);
    }

    public final void b(@NonNull r rVar) {
        c(rVar, null);
    }

    public final void c(@NonNull r rVar, Runnable runnable) {
        if (this.a) {
            this.b.d(new i(this, rVar), runnable);
        } else {
            this.b.b(new j(this, rVar));
        }
    }

    @Override // e.c.e.b.d.a
    public void onBufferEnd() {
        b(new e(this));
    }

    @Override // e.c.e.b.d.a
    public void onBufferStart() {
        b(new d(this));
    }

    @Override // e.c.e.b.d.a
    public void onBufferingUpdate(int i2) {
        b(new a(this, i2));
    }

    @Override // e.c.e.b.d.a
    public void onCompletion() {
        b(new l(this));
    }

    @Override // e.c.e.b.d.a
    public void onError(int i2, int i3) {
        b(new m(this, i2, i3));
    }

    @Override // e.c.e.b.d.a
    public void onInfo(int i2, int i3) {
        b(new n(this, i2, i3));
    }

    @Override // e.c.e.b.d.a
    public void onPause() {
        b(new g(this));
    }

    @Override // e.c.e.b.d.a
    public void onPlay() {
        b(new f(this));
    }

    @Override // e.c.e.b.d.a
    public void onPlayerMessageReceived(Message message) {
        Message messageObtain = Message.obtain(message);
        c(new C0222b(this, messageObtain), new c(this, messageObtain));
    }

    @Override // e.c.e.b.d.a
    public void onPrepared() {
        b(new k(this));
    }

    @Override // e.c.e.b.d.a
    public void onSeekComplete() {
        b(new q(this));
    }

    @Override // e.c.e.b.d.a
    public void onStop() {
        b(new h(this));
    }

    @Override // e.c.e.b.d.a
    public void onInfo(int i2, int i3, String str) {
        b(new o(this, i2, i3, str));
    }

    @Override // e.c.e.b.d.a
    public void onInfo(int i2, int i3, byte[] bArr) {
        b(new p(this, i2, i3, bArr));
    }

    public b(e.c.e.b.d.a... aVarArr) {
        this(false, aVarArr);
    }
}
