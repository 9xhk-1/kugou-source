package e.c.e.c.a.e;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: e.c.e.c.a.e.a$a, reason: collision with other inner class name */
    public static class C0239a implements a {
        @Override // e.c.e.c.a.e.a
        public int beforeSetPlayMode(e.c.e.b.c.e.a<b, Void> aVar) {
            return 0;
        }
    }

    public static class b {
        public int a;
        public boolean b;

        public b(int i2, boolean z) {
            this.a = i2;
            this.b = z;
        }
    }

    void afterSetPlayMode(e.c.e.b.c.e.a<b, Void> aVar);

    int beforeSetPlayMode(e.c.e.b.c.e.a<b, Void> aVar);
}
