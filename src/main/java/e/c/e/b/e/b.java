package e.c.e.b.e;

import android.support.annotation.NonNull;
import e.c.e.b.c.e.b;
import e.c.e.b.d.a;
import e.c.e.b.e.d;
import e.c.e.b.e.e;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> implements e<T> {

    @NonNull
    public d<T> a;

    @NonNull
    public f<T> b;
    public C0228b<T> c;

    public static class a<T> extends e.c.e.b.e.g.a<T> {

        @NonNull
        public d<T> b;

        @NonNull
        public f<T> c;

        /* JADX INFO: renamed from: e.c.e.b.e.b$a$a, reason: collision with other inner class name */
        public static class C0226a<T> extends a.C0221a {

            @NonNull
            public d<T> a;

            @NonNull
            public f<T> b;

            /* JADX INFO: renamed from: e.c.e.b.e.b$a$a$a, reason: collision with other inner class name */
            public class C0227a implements e.c.e.b.c.d<b.e, Void, e.c.e.b.c.e.b> {
                public C0227a() {
                }

                @Override // e.c.e.b.c.d
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void impl(e.c.e.b.c.e.a<b.e, Void> aVar) {
                    C0226a.this.b.m();
                    C0226a.this.a.audio().loadDataSource(C0226a.this.b.c(), true);
                    return null;
                }

                @Override // e.c.e.b.c.d
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public void invokeAfter(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.e, Void> aVar) {
                    bVar.afterOnCompleteNext(aVar);
                }

                @Override // e.c.e.b.c.d
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public int invokeBefore(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.e, Void> aVar) {
                    return bVar.beforeOnCompleteNext(aVar);
                }
            }

            public C0226a(@NonNull d<T> dVar, @NonNull f<T> fVar) {
                this.a = dVar;
                this.b = fVar;
            }

            public final void a() {
                this.a.extendManager().a(e.c.e.b.c.e.b.class, new b.e(), new C0227a());
            }

            @Override // e.c.e.b.d.a.C0221a, e.c.e.b.d.a
            public void onCompletion() {
                a();
            }
        }

        public a(@NonNull d<T> dVar, @NonNull f<T> fVar) {
            super(dVar.audio());
            this.b = dVar;
            this.c = fVar;
            addListener(new C0226a(dVar, fVar));
        }

        @Override // e.c.e.b.e.g.a, e.c.e.b.e.d.b
        public void play() {
            if (this.b.audio().isPrepared()) {
                super.play();
            } else {
                this.b.audio().loadDataSource(this.c.c(), true);
            }
        }
    }

    /* JADX INFO: renamed from: e.c.e.b.e.b$b, reason: collision with other inner class name */
    public static class C0228b<T> implements e.b<T> {

        @NonNull
        public e.c.e.b.e.d<T> a;

        @NonNull
        public e.c.e.b.e.f<T> b;

        /* JADX INFO: renamed from: e.c.e.b.e.b$b$a */
        public class a implements e.c.e.b.c.d<b.f, Void, e.c.e.b.c.e.b> {
            public a() {
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<b.f, Void> aVar) {
                C0228b.this.b.n();
                C0228b.this.a.audio().loadDataSource(C0228b.this.b.c(), true);
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.f, Void> aVar) {
                bVar.afterPrevious(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.f, Void> aVar) {
                return bVar.beforePrevious(aVar);
            }
        }

        /* JADX INFO: renamed from: e.c.e.b.e.b$b$b, reason: collision with other inner class name */
        public class C0229b implements e.c.e.b.c.d<b.d, Void, e.c.e.b.c.e.b> {
            public C0229b() {
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<b.d, Void> aVar) {
                C0228b.this.b.l();
                C0228b.this.a.audio().loadDataSource(C0228b.this.b.c(), true);
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.d, Void> aVar) {
                bVar.afterNext(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.d, Void> aVar) {
                return bVar.beforeNext(aVar);
            }
        }

        /* JADX INFO: renamed from: e.c.e.b.e.b$b$c */
        public class c implements e.c.e.b.c.d<b.h, Void, e.c.e.b.c.e.b> {
            public final /* synthetic */ int a;

            public c(int i2) {
                this.a = i2;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<b.h, Void> aVar) {
                C0228b.this.b.q(this.a);
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.h, Void> aVar) {
                bVar.afterSetIndex(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.h, Void> aVar) {
                return bVar.beforeSetIndex(aVar);
            }
        }

        /* JADX INFO: renamed from: e.c.e.b.e.b$b$d */
        public class d implements e.c.e.b.c.d<b.c, Boolean, e.c.e.b.c.e.b> {
            public final /* synthetic */ int a;
            public final /* synthetic */ List b;

            public d(int i2, List list) {
                this.a = i2;
                this.b = list;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean impl(e.c.e.b.c.e.a<b.c, Boolean> aVar) {
                return Boolean.valueOf(C0228b.this.b.k(this.a, this.b));
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.c, Boolean> aVar) {
                bVar.afterInsert(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.c, Boolean> aVar) {
                return bVar.beforeInsert(aVar);
            }
        }

        /* JADX INFO: renamed from: e.c.e.b.e.b$b$e */
        public class e implements e.c.e.b.c.d<b.g, T, e.c.e.b.c.e.b> {
            public final /* synthetic */ int a;

            public e(int i2) {
                this.a = i2;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.g, T> aVar) {
                bVar.afterRemove(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.g, T> aVar) {
                return bVar.beforeRemove(aVar);
            }

            @Override // e.c.e.b.c.d
            public T impl(e.c.e.b.c.e.a<b.g, T> aVar) {
                return C0228b.this.b.p(this.a);
            }
        }

        /* JADX INFO: renamed from: e.c.e.b.e.b$b$f */
        public class f implements e.c.e.b.c.d<b.a, Object, e.c.e.b.c.e.b> {
            public f() {
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.a, Object> aVar) {
                bVar.afterClear(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.a, Object> aVar) {
                return bVar.beforeClear(aVar);
            }

            @Override // e.c.e.b.c.d
            public Object impl(e.c.e.b.c.e.a<b.a, Object> aVar) {
                C0228b.this.b.a();
                return null;
            }
        }

        /* JADX INFO: renamed from: e.c.e.b.e.b$b$g */
        public class g implements e.c.e.b.c.d<b.i, Void, e.c.e.b.c.e.b> {
            public final /* synthetic */ List a;

            public g(List list) {
                this.a = list;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void impl(e.c.e.b.c.e.a<b.i, Void> aVar) {
                C0228b.this.b.s(this.a);
                return null;
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void invokeAfter(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.i, Void> aVar) {
                bVar.afterSetQueue(aVar);
            }

            @Override // e.c.e.b.c.d
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int invokeBefore(e.c.e.b.c.e.b bVar, e.c.e.b.c.e.a<b.i, Void> aVar) {
                return bVar.beforeSetQueue(aVar);
            }
        }

        public C0228b(@NonNull e.c.e.b.e.d<T> dVar, @NonNull e.c.e.b.e.f<T> fVar) {
            this.a = dVar;
            this.b = fVar;
        }

        @Override // e.c.e.b.e.e.b
        public void clear() {
            this.a.extendManager().a(e.c.e.b.c.e.b.class, new b.a(), new f());
        }

        @Override // e.c.e.b.e.e.b
        public int getCurrentIndex() {
            return this.b.b();
        }

        @Override // e.c.e.b.e.e.b
        public e.c.e.b.f.c getMode() {
            return this.b.d();
        }

        @Override // e.c.e.b.e.e.b
        public int getNextIndex() {
            return this.b.e();
        }

        @Override // e.c.e.b.e.e.b
        public int getOnCompleteNextIndex() {
            return this.b.f();
        }

        @Override // e.c.e.b.e.e.b
        public int getPreviousIndex() {
            return this.b.g();
        }

        @Override // e.c.e.b.e.e.b
        public List<T> getQueue() {
            return this.b.h();
        }

        @Override // e.c.e.b.e.e.b
        public e.c.e.b.f.d<T> getQueueList() {
            return this.b.i();
        }

        @Override // e.c.e.b.e.e.b
        public int getSize() {
            return this.b.j();
        }

        @Override // e.c.e.b.e.e.b
        public boolean insert(int i2, List<T> list) {
            return ((Boolean) this.a.extendManager().a(e.c.e.b.c.e.b.class, new b.c(i2, list), new d(i2, list))).booleanValue();
        }

        @Override // e.c.e.b.e.e.b
        public void next() {
            this.a.extendManager().a(e.c.e.b.c.e.b.class, new b.d(), new C0229b());
        }

        @Override // e.c.e.b.e.e.b
        public void playByIndex(int i2, boolean z) {
            setCurrentIndex(i2);
            T tC = this.b.c();
            if (tC != null) {
                this.a.audio().loadDataSource(tC, z);
            }
        }

        @Override // e.c.e.b.e.e.b
        public void playSongList(List<T> list, int i2, boolean z) {
            setQueue(list);
            playByIndex(i2, z);
        }

        @Override // e.c.e.b.e.e.b
        public void previous() {
            this.a.extendManager().a(e.c.e.b.c.e.b.class, new b.f(), new a());
        }

        @Override // e.c.e.b.e.e.b
        public void registerObserver(e.c<T> cVar) {
            this.b.o(cVar);
        }

        @Override // e.c.e.b.e.e.b
        public T remove(int i2) {
            return (T) this.a.extendManager().a(e.c.e.b.c.e.b.class, new b.g(i2), new e(i2));
        }

        @Override // e.c.e.b.e.e.b
        public void setCurrentIndex(int i2) {
            this.a.extendManager().a(e.c.e.b.c.e.b.class, new b.h(i2), new c(i2));
        }

        @Override // e.c.e.b.e.e.b
        public void setMode(e.c.e.b.f.c cVar) {
            this.b.r(cVar);
        }

        @Override // e.c.e.b.e.e.b
        public void setQueue(List<T> list) {
            this.a.extendManager().a(e.c.e.b.c.e.b.class, new b.i(list), new g(list));
        }

        @Override // e.c.e.b.e.e.b
        public void setQueueList(e.c.e.b.f.d<T> dVar) {
            this.b.t(dVar);
        }

        @Override // e.c.e.b.e.e.b
        public void unregisterObserver(e.c<T> cVar) {
            this.b.u(cVar);
        }
    }

    public b(String str) {
        d.a aVar = new d.a();
        aVar.b(str);
        this.a = aVar.a();
        e.c.e.b.f.b bVar = new e.c.e.b.f.b();
        f<T> fVar = new f<>(bVar, new e.c.e.b.f.e(bVar));
        this.b = fVar;
        d<T> dVar = this.a;
        dVar.setAudio(new a(dVar, fVar));
    }

    @Override // e.c.e.b.e.e, e.c.e.b.e.d
    @NonNull
    public d.b<T> audio() {
        return this.a.audio();
    }

    @Override // e.c.e.b.e.e, e.c.e.b.e.d
    @NonNull
    public e.c.e.b.c.a extendManager() {
        return this.a.extendManager();
    }

    @Override // e.c.e.b.e.e, e.c.e.b.e.d
    @NonNull
    public d.InterfaceC0231d extra() {
        return this.a.extra();
    }

    @Override // e.c.e.b.e.e
    public e.b<T> queue() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = new C0228b<>(this.a, this.b);
                }
            }
        }
        return this.c;
    }

    @Override // e.c.e.b.e.e, e.c.e.b.e.d
    public void setAudio(@NonNull d.b<T> bVar) {
        this.a.setAudio(bVar);
    }

    @Override // e.c.e.b.e.e, e.c.e.b.e.d
    public void setExtra(@NonNull d.InterfaceC0231d interfaceC0231d) {
        this.a.setExtra(interfaceC0231d);
    }

    @Override // e.c.e.b.e.e, e.c.e.b.e.d
    public void setVideo(@NonNull d.e eVar) {
        this.a.setVideo(eVar);
    }

    @Override // e.c.e.b.e.e, e.c.e.b.e.d
    @NonNull
    public d.e video() {
        return this.a.video();
    }
}
