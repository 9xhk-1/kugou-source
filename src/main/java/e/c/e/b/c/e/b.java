package e.c.e.b.c.e;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface b<T> {

    public static class a {
    }

    /* JADX INFO: renamed from: e.c.e.b.c.e.b$b, reason: collision with other inner class name */
    public static class C0216b<T> implements b<T> {
        @Override // e.c.e.b.c.e.b
        public int beforeClear(e.c.e.b.c.e.a<a, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.b
        public int beforeInsert(e.c.e.b.c.e.a<c, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.b
        public int beforeNext(e.c.e.b.c.e.a<d, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.b
        public int beforeOnCompleteNext(e.c.e.b.c.e.a<e, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.b
        public int beforePrevious(e.c.e.b.c.e.a<f, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.b
        public int beforeRemove(e.c.e.b.c.e.a<g, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.b
        public int beforeSetIndex(e.c.e.b.c.e.a<h, Void> aVar) {
            return 0;
        }

        @Override // e.c.e.b.c.e.b
        public int beforeSetQueue(e.c.e.b.c.e.a<i, Void> aVar) {
            return 0;
        }
    }

    public static class c<T> {
        public List<T> a;

        public c(int i2, List<T> list) {
            this.a = list;
        }
    }

    public static class d {
    }

    public static class e {
    }

    public static class f {
    }

    public static class g {
        public g(int i2) {
        }
    }

    public static class h {
        public h(int i2) {
        }
    }

    public static class i<T> {
        public List<T> a;

        public i(List<T> list) {
            this.a = list;
        }
    }

    void afterClear(e.c.e.b.c.e.a<a, Void> aVar);

    void afterInsert(e.c.e.b.c.e.a<c, Void> aVar);

    void afterNext(e.c.e.b.c.e.a<d, Void> aVar);

    void afterOnCompleteNext(e.c.e.b.c.e.a<e, Void> aVar);

    void afterPrevious(e.c.e.b.c.e.a<f, Void> aVar);

    void afterRemove(e.c.e.b.c.e.a<g, Void> aVar);

    void afterSetIndex(e.c.e.b.c.e.a<h, Void> aVar);

    void afterSetQueue(e.c.e.b.c.e.a<i, Void> aVar);

    int beforeClear(e.c.e.b.c.e.a<a, Void> aVar);

    int beforeInsert(e.c.e.b.c.e.a<c, Void> aVar);

    int beforeNext(e.c.e.b.c.e.a<d, Void> aVar);

    int beforeOnCompleteNext(e.c.e.b.c.e.a<e, Void> aVar);

    int beforePrevious(e.c.e.b.c.e.a<f, Void> aVar);

    int beforeRemove(e.c.e.b.c.e.a<g, Void> aVar);

    int beforeSetIndex(e.c.e.b.c.e.a<h, Void> aVar);

    int beforeSetQueue(e.c.e.b.c.e.a<i, Void> aVar);
}
