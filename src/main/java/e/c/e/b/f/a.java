package e.c.e.b.f;

import android.support.annotation.NonNull;
import e.c.e.b.f.c;
import e.c.e.b.g.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements c {

    @NonNull
    public d<?> a;
    public volatile int b = -1;
    public final e.c.e.b.g.a<c.a> c = new e.c.e.b.g.a<>();

    /* JADX INFO: renamed from: e.c.e.b.f.a$a, reason: collision with other inner class name */
    public class C0232a implements a.b<c.a> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public C0232a(a aVar, int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // e.c.e.b.g.a.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void notify(@NonNull c.a aVar) {
            aVar.onIndexChange(this.a, this.b);
        }
    }

    public a(@NonNull d<?> dVar) {
        updateQueueList(dVar);
    }

    @NonNull
    public d<?> a() {
        return this.a;
    }

    @Override // e.c.e.b.f.c
    public int getCurrentIndex() {
        return this.b;
    }

    @Override // e.c.e.b.f.c
    public int getOnCompleteNextIndex() {
        return getNextIndex();
    }

    @Override // e.c.e.b.f.c
    public int next() {
        int nextIndex = getNextIndex();
        setCurrentIndex(nextIndex);
        return nextIndex;
    }

    @Override // e.c.e.b.f.c
    public int onCompleteNext() {
        int onCompleteNextIndex = getOnCompleteNextIndex();
        setCurrentIndex(onCompleteNextIndex);
        return onCompleteNextIndex;
    }

    @Override // e.c.e.b.f.c
    public int previous() {
        int previousIndex = getPreviousIndex();
        setCurrentIndex(previousIndex);
        return previousIndex;
    }

    @Override // e.c.e.b.f.c
    public void registerObserver(c.a aVar) {
        this.c.e(aVar);
    }

    @Override // e.c.e.b.f.c
    public void setCurrentIndex(int i2) {
        int i3 = this.b;
        this.b = i2;
        this.c.b(new C0232a(this, i3, i2));
    }

    @Override // e.c.e.b.f.c
    public void unregisterObserver(c.a aVar) {
        this.c.f(aVar);
    }

    @Override // e.c.e.b.f.c
    public void updateQueueList(@NonNull d<?> dVar) {
        Objects.requireNonNull(dVar);
        this.a = dVar;
    }
}
