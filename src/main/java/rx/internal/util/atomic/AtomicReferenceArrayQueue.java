package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> {
    public final AtomicReferenceArray<E> buffer;
    public final int mask;

    public AtomicReferenceArrayQueue(int i2) {
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
        this.mask = iRoundToPowerOfTwo - 1;
        this.buffer = new AtomicReferenceArray<>(iRoundToPowerOfTwo);
    }

    public final int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    public final int calcElementOffset(long j, int i2) {
        return ((int) j) & i2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    public final E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    public final void soElement(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e2) {
        atomicReferenceArray.lazySet(i2, e2);
    }

    public final void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e2) {
        atomicReferenceArray.lazySet(i2, e2);
    }

    public final void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e2) {
        atomicReferenceArray.set(i2, e2);
    }

    public final E lpElement(int i2) {
        return this.buffer.get(i2);
    }

    public final E lvElement(int i2) {
        return lvElement(this.buffer, i2);
    }

    public final void soElement(int i2, E e2) {
        this.buffer.lazySet(i2, e2);
    }

    public final void spElement(int i2, E e2) {
        this.buffer.lazySet(i2, e2);
    }
}
