package e.c.e.b.f;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface d<T> {

    public interface a<T> {

        /* JADX INFO: renamed from: e.c.e.b.f.d$a$a, reason: collision with other inner class name */
        public static class C0234a<T> implements a<T> {
            @Override // e.c.e.b.f.d.a
            public void onClear() {
            }

            @Override // e.c.e.b.f.d.a
            public void onInsert(int i2, List<T> list) {
            }

            @Override // e.c.e.b.f.d.a
            public void onRemove(int i2, T t) {
            }

            @Override // e.c.e.b.f.d.a
            public void onSetQueue(List<T> list) {
            }

            @Override // e.c.e.b.f.d.a
            public void onUpdate(int i2, T t) {
            }
        }

        void onClear();

        void onInsert(int i2, List<T> list);

        void onQueueChange();

        void onRemove(int i2, T t);

        void onSetQueue(List<T> list);

        void onUpdate(int i2, T t);
    }

    public interface b<T> {
        boolean update(int i2, T t);
    }

    void clear();

    List<T> getQueue();

    int getSize();

    T getSong(int i2);

    boolean insert(int i2, List<T> list);

    void registerObserver(a<T> aVar);

    T remove(int i2);

    void setQueue(List<T> list);

    void unregisterObserver(a<T> aVar);

    T update(int i2, b<T> bVar);
}
