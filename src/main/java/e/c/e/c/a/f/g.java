package e.c.e.c.a.f;

import android.support.annotation.NonNull;
import e.c.e.c.a.c;
import e.c.e.c.a.e.a;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g<T> implements c.InterfaceC0238c<T> {

    @NonNull
    public e.c.e.b.e.e<T> a;
    public volatile int b = 0;

    public class a implements e.c.e.b.c.d<a.b, Void, e.c.e.c.a.e.a> {
        public a() {
        }

        @Override // e.c.e.b.c.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void impl(e.c.e.b.c.e.a<a.b, Void> aVar) {
            a.b bVar = aVar.a;
            int i2 = bVar.a;
            boolean z = bVar.b;
            e.c.e.b.f.d<T> queueList = g.this.a.queue().getQueueList();
            int currentIndex = g.this.a.queue().getCurrentIndex();
            if (i2 == 0) {
                g.this.a.queue().setMode(new e.c.e.b.f.e(queueList));
            } else if (i2 == 1) {
                g.this.a.queue().setMode(new e.c.e.b.f.g(queueList));
            } else if (i2 == 2) {
                g.this.a.queue().setMode(new e.c.e.b.f.f(queueList));
            }
            g.this.a.queue().setCurrentIndex(currentIndex);
            g.this.b = i2;
            return null;
        }

        @Override // e.c.e.b.c.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void invokeAfter(e.c.e.c.a.e.a aVar, e.c.e.b.c.e.a<a.b, Void> aVar2) {
            aVar.afterSetPlayMode(aVar2);
        }

        @Override // e.c.e.b.c.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int invokeBefore(e.c.e.c.a.e.a aVar, e.c.e.b.c.e.a<a.b, Void> aVar2) {
            return aVar.beforeSetPlayMode(aVar2);
        }
    }

    public g(@NonNull e.c.e.b.e.e<T> eVar) {
        this.a = eVar;
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void append(List<T> list) {
        insert(-1, list);
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public int getCurrentIndex() {
        return this.a.queue().getCurrentIndex();
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public int getNextIndex() {
        return this.a.queue().getNextIndex();
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public int getOnCompleteNextIndex() {
        return this.a.queue().getOnCompleteNextIndex();
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public int getPlayMode() {
        return this.b;
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public int getPreviousIndex() {
        return this.a.queue().getPreviousIndex();
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public List<T> getQueue() {
        return this.a.queue().getQueue();
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void insert(int i2, List<T> list) {
        this.a.queue().insert(i2, list);
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void next() {
        this.a.queue().next();
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public boolean playByIndex(int i2, boolean z) {
        if (i2 < 0 || i2 >= this.a.queue().getSize()) {
            return false;
        }
        this.a.queue().playByIndex(i2, z);
        return true;
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void playSongList(List<T> list, int i2, boolean z) {
        this.a.queue().playSongList(list, i2, z);
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void previous() {
        this.a.queue().previous();
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void setCurrentIndex(int i2) {
        this.a.queue().setCurrentIndex(i2);
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void setPlayMode(int i2) {
        setPlayMode(i2, true);
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void setQueue(List<T> list) {
        this.a.queue().setQueue(list);
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public int size() {
        return this.a.queue().getSize();
    }

    @Override // e.c.e.c.a.c.InterfaceC0238c
    public void setPlayMode(int i2, boolean z) {
        this.a.extendManager().a(e.c.e.c.a.e.a.class, new a.b(i2, z), new a());
    }
}
