package e.c.e.b.c.e;

/* JADX INFO: loaded from: classes2.dex */
public interface c<T> {

    public static class a<T> implements c<T> {
        @Override // e.c.e.b.c.e.c
        public void afterLoad(e.c.e.b.c.e.a<b<T>, Void> aVar) {
        }

        @Override // e.c.e.b.c.e.c
        public void afterPause(e.c.e.b.c.e.a<C0217c, Void> aVar) {
        }

        @Override // e.c.e.b.c.e.c
        public void afterPlay(e.c.e.b.c.e.a<d, Void> aVar) {
        }

        @Override // e.c.e.b.c.e.c
        public void afterSeekTo(e.c.e.b.c.e.a<e, Void> aVar) {
        }

        @Override // e.c.e.b.c.e.c
        public void afterSetVolume(e.c.e.b.c.e.a<f, Void> aVar) {
        }

        @Override // e.c.e.b.c.e.c
        public int beforeLoad(e.c.e.b.c.e.a<b<T>, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.c
        public int beforePause(e.c.e.b.c.e.a<C0217c, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.c
        public int beforePlay(e.c.e.b.c.e.a<d, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.c
        public int beforeSeekTo(e.c.e.b.c.e.a<e, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.c
        public int beforeSetVolume(e.c.e.b.c.e.a<f, Void> aVar) {
            return 0;
        }
    }

    public static class b<T> {
        public T a;
        public boolean b;
        public long c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1291d;

        public b(T t, boolean z, long j, long j2) {
            this.a = t;
            this.b = z;
            this.c = j;
            this.f1291d = j2;
        }
    }

    /* JADX INFO: renamed from: e.c.e.b.c.e.c$c, reason: collision with other inner class name */
    public static class C0217c {
    }

    public static class d {
    }

    public static class e {
        public int a;

        public e(int i2) {
            this.a = i2;
        }
    }

    public static class f {
        public f(float f2) {
        }
    }

    void afterLoad(e.c.e.b.c.e.a<b<T>, Void> aVar);

    void afterPause(e.c.e.b.c.e.a<C0217c, Void> aVar);

    void afterPlay(e.c.e.b.c.e.a<d, Void> aVar);

    void afterSeekTo(e.c.e.b.c.e.a<e, Void> aVar);

    void afterSetVolume(e.c.e.b.c.e.a<f, Void> aVar);

    int beforeLoad(e.c.e.b.c.e.a<b<T>, Void> aVar);

    int beforePause(e.c.e.b.c.e.a<C0217c, Void> aVar);

    int beforePlay(e.c.e.b.c.e.a<d, Void> aVar);

    int beforeSeekTo(e.c.e.b.c.e.a<e, Void> aVar);

    int beforeSetVolume(e.c.e.b.c.e.a<f, Void> aVar);
}
