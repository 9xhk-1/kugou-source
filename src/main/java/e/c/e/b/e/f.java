package e.c.e.b.e;

import android.support.annotation.NonNull;
import e.c.e.b.e.e;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class f<T> {

    @NonNull
    public volatile e.c.e.b.f.d<T> a;

    @NonNull
    public volatile e.c.e.b.f.c b;

    public f(e.c.e.b.f.d<T> dVar, e.c.e.b.f.c cVar) {
        if (dVar == null || cVar == null) {
            throw null;
        }
        this.a = dVar;
        this.b = cVar;
    }

    public void a() {
        this.a.clear();
    }

    public int b() {
        return this.b.getCurrentIndex();
    }

    public T c() {
        return this.a.getSong(this.b.getCurrentIndex());
    }

    public e.c.e.b.f.c d() {
        return this.b;
    }

    public int e() {
        return this.b.getNextIndex();
    }

    public int f() {
        return this.b.getOnCompleteNextIndex();
    }

    public int g() {
        return this.b.getPreviousIndex();
    }

    public List<T> h() {
        return this.a.getQueue();
    }

    public e.c.e.b.f.d<T> i() {
        return this.a;
    }

    public int j() {
        return this.a.getSize();
    }

    public boolean k(int i2, List<T> list) {
        return this.a.insert(i2, list);
    }

    public int l() {
        return this.b.next();
    }

    public int m() {
        return this.b.onCompleteNext();
    }

    public int n() {
        return this.b.previous();
    }

    public void o(e.c<T> cVar) {
        this.a.registerObserver(cVar);
        this.b.registerObserver(cVar);
    }

    public T p(int i2) {
        return this.a.remove(i2);
    }

    public void q(int i2) {
        this.b.setCurrentIndex(i2);
    }

    public void r(e.c.e.b.f.c cVar) {
        Objects.requireNonNull(cVar);
        this.b = cVar;
    }

    public void s(List<T> list) {
        this.a.setQueue(list);
    }

    public void t(e.c.e.b.f.d<T> dVar) {
        Objects.requireNonNull(dVar);
        this.a = dVar;
        this.b.updateQueueList(dVar);
    }

    public void u(e.c<T> cVar) {
        this.a.unregisterObserver(cVar);
        this.b.unregisterObserver(cVar);
    }
}
