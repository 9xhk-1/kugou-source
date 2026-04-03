package e.c.e.b.b.c;

import android.support.annotation.NonNull;
import e.c.e.b.g.a;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e.c.e.b.b.a {
    public e.c.e.b.g.a<e.c.e.b.a.a> a = new e.c.e.b.g.a<>();

    /* JADX INFO: renamed from: e.c.e.b.b.c.a$a, reason: collision with other inner class name */
    public class C0213a implements a.b<e.c.e.b.a.a> {
        public final /* synthetic */ e.c.e.b.a.a a;

        public C0213a(e.c.e.b.a.a aVar) {
            this.a = aVar;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.b.a.a aVar) {
            if (aVar == this.a || !a.this.a.a(aVar)) {
                return;
            }
            aVar.onAskedPause(this.a.myMark());
        }
    }

    public class b implements a.b<e.c.e.b.a.a> {
        public final /* synthetic */ e.c.e.b.a.a a;

        public b(e.c.e.b.a.a aVar) {
            this.a = aVar;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.b.a.a aVar) {
            if (aVar == this.a || !a.this.a.a(aVar)) {
                return;
            }
            aVar.onAskedMute(this.a.myMark());
        }
    }

    public class c implements a.b<e.c.e.b.a.a> {
        public final /* synthetic */ e.c.e.b.a.a a;

        public c(e.c.e.b.a.a aVar) {
            this.a = aVar;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull e.c.e.b.a.a aVar) {
            if (aVar == this.a || !a.this.a.a(aVar)) {
                return;
            }
            aVar.onAskedUnmute(this.a.myMark());
        }
    }

    @Override // e.c.e.b.b.a
    public void askOtherMute(e.c.e.b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        this.a.b(new b(aVar));
    }

    @Override // e.c.e.b.b.a
    public void askOtherPause(e.c.e.b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        this.a.b(new C0213a(aVar));
    }

    @Override // e.c.e.b.b.a
    public void askOtherUnmute(e.c.e.b.a.a aVar) {
        if (aVar == null) {
            return;
        }
        this.a.b(new c(aVar));
    }

    @Override // e.c.e.b.b.a
    public void registerResponder(e.c.e.b.a.a aVar) {
        this.a.e(aVar);
    }

    @Override // e.c.e.b.b.a
    public void unregisterResponder(e.c.e.b.a.a aVar) {
        this.a.f(aVar);
    }
}
