package e.c.e.b.f;

import android.support.annotation.NonNull;
import e.c.e.b.f.d;
import e.c.e.b.g.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b<T> implements e.c.e.b.f.d<T> {
    public final List<T> a = new ArrayList();
    public final Object b = new Object();
    public final e.c.e.b.g.a<d.a<T>> c = new e.c.e.b.g.a<>();

    public class a implements a.b<d.a<T>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ List b;

        public a(b bVar, int i2, List list) {
            this.a = i2;
            this.b = list;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull d.a<T> aVar) {
            aVar.onInsert(this.a, this.b);
            aVar.onQueueChange();
        }
    }

    /* JADX INFO: renamed from: e.c.e.b.f.b$b, reason: collision with other inner class name */
    public class C0233b implements a.b<d.a<T>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public C0233b(b bVar, int i2, Object obj) {
            this.a = i2;
            this.b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull d.a<T> aVar) {
            aVar.onRemove(this.a, this.b);
            aVar.onQueueChange();
        }
    }

    public class c implements a.b<d.a<T>> {
        public c(b bVar) {
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull d.a<T> aVar) {
            aVar.onClear();
            aVar.onQueueChange();
        }
    }

    public class d implements a.b<d.a<T>> {
        public final /* synthetic */ List a;

        public d(b bVar, List list) {
            this.a = list;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull d.a<T> aVar) {
            aVar.onSetQueue(this.a);
            aVar.onQueueChange();
        }
    }

    public class e implements a.b<d.a<T>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public e(b bVar, int i2, Object obj) {
            this.a = i2;
            this.b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull d.a<T> aVar) {
            aVar.onUpdate(this.a, this.b);
        }
    }

    @Override // e.c.e.b.f.d
    public void clear() {
        synchronized (this.b) {
            this.a.clear();
        }
        this.c.b(new c(this));
    }

    @Override // e.c.e.b.f.d
    public List<T> getQueue() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // e.c.e.b.f.d
    public int getSize() {
        return this.a.size();
    }

    @Override // e.c.e.b.f.d
    public T getSong(int i2) {
        synchronized (this.b) {
            if (i2 >= 0) {
                if (i2 < getSize()) {
                    return this.a.get(i2);
                }
            }
            return null;
        }
    }

    @Override // e.c.e.b.f.d
    public boolean insert(int i2, List<T> list) {
        if (list == null) {
            return false;
        }
        synchronized (this.b) {
            if (i2 < 0) {
                i2 = getSize();
                this.a.addAll(i2, list);
            } else {
                this.a.addAll(i2, list);
            }
        }
        this.c.b(new a(this, i2, list));
        return true;
    }

    @Override // e.c.e.b.f.d
    public void registerObserver(d.a<T> aVar) {
        this.c.e(aVar);
    }

    @Override // e.c.e.b.f.d
    public T remove(int i2) {
        T tRemove;
        synchronized (this.b) {
            tRemove = this.a.remove(i2);
        }
        this.c.b(new C0233b(this, i2, tRemove));
        return tRemove;
    }

    @Override // e.c.e.b.f.d
    public void setQueue(List<T> list) {
        if (list == null) {
            return;
        }
        synchronized (this.b) {
            this.a.clear();
            this.a.addAll(list);
        }
        this.c.b(new d(this, list));
    }

    @Override // e.c.e.b.f.d
    public void unregisterObserver(d.a<T> aVar) {
        this.c.f(aVar);
    }

    @Override // e.c.e.b.f.d
    public T update(int i2, d.b<T> bVar) {
        T t = this.a.get(i2);
        if (bVar != null) {
            bVar.update(i2, t);
        }
        this.c.b(new e(this, i2, t));
        return t;
    }
}
