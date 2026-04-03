package rx.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Subscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public final class IndexedRingBuffer<E> implements Subscription {
    public static final int SIZE;
    private final ElementSection<E> elements = new ElementSection<>();
    private final IndexSection removed = new IndexSection();
    public final AtomicInteger index = new AtomicInteger();
    public final AtomicInteger removedIndex = new AtomicInteger();

    public static final class ElementSection<E> {
        public final AtomicReferenceArray<E> array = new AtomicReferenceArray<>(IndexedRingBuffer.SIZE);
        public final AtomicReference<ElementSection<E>> next = new AtomicReference<>();

        public ElementSection<E> getNext() {
            if (this.next.get() != null) {
                return this.next.get();
            }
            ElementSection<E> elementSection = new ElementSection<>();
            return this.next.compareAndSet(null, elementSection) ? elementSection : this.next.get();
        }
    }

    public static class IndexSection {
        private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);
        private final AtomicReference<IndexSection> _next = new AtomicReference<>();

        public int getAndSet(int i2, int i3) {
            return this.unsafeArray.getAndSet(i2, i3);
        }

        public IndexSection getNext() {
            if (this._next.get() != null) {
                return this._next.get();
            }
            IndexSection indexSection = new IndexSection();
            return this._next.compareAndSet(null, indexSection) ? indexSection : this._next.get();
        }

        public void set(int i2, int i3) {
            this.unsafeArray.set(i2, i3);
        }
    }

    static {
        int i2 = PlatformDependent.isAndroid() ? 8 : 128;
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                i2 = Integer.parseInt(property);
            } catch (NumberFormatException e2) {
                System.err.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
        SIZE = i2;
    }

    private ElementSection<E> getElementSection(int i2) {
        int i3 = SIZE;
        if (i2 < i3) {
            return this.elements;
        }
        int i4 = i2 / i3;
        ElementSection<E> next = this.elements;
        for (int i5 = 0; i5 < i4; i5++) {
            next = next.getNext();
        }
        return next;
    }

    private synchronized int getIndexForAdd() {
        int andIncrement;
        int indexFromPreviouslyRemoved = getIndexFromPreviouslyRemoved();
        if (indexFromPreviouslyRemoved >= 0) {
            int i2 = SIZE;
            if (indexFromPreviouslyRemoved < i2) {
                andIncrement = this.removed.getAndSet(indexFromPreviouslyRemoved, -1);
            } else {
                andIncrement = getIndexSection(indexFromPreviouslyRemoved).getAndSet(indexFromPreviouslyRemoved % i2, -1);
            }
            if (andIncrement == this.index.get()) {
                this.index.getAndIncrement();
            }
        } else {
            andIncrement = this.index.getAndIncrement();
        }
        return andIncrement;
    }

    private synchronized int getIndexFromPreviouslyRemoved() {
        int i2;
        int i3;
        do {
            i2 = this.removedIndex.get();
            if (i2 <= 0) {
                return -1;
            }
            i3 = i2 - 1;
        } while (!this.removedIndex.compareAndSet(i2, i3));
        return i3;
    }

    private IndexSection getIndexSection(int i2) {
        int i3 = SIZE;
        if (i2 < i3) {
            return this.removed;
        }
        int i4 = i2 / i3;
        IndexSection next = this.removed;
        for (int i5 = 0; i5 < i4; i5++) {
            next = next.getNext();
        }
        return next;
    }

    public static <T> IndexedRingBuffer<T> getInstance() {
        return new IndexedRingBuffer<>();
    }

    private synchronized void pushRemovedIndex(int i2) {
        int andIncrement = this.removedIndex.getAndIncrement();
        int i3 = SIZE;
        if (andIncrement < i3) {
            this.removed.set(andIncrement, i2);
        } else {
            getIndexSection(andIncrement).set(andIncrement % i3, i2);
        }
    }

    public int add(E e2) {
        int indexForAdd = getIndexForAdd();
        int i2 = SIZE;
        if (indexForAdd < i2) {
            this.elements.array.set(indexForAdd, e2);
            return indexForAdd;
        }
        getElementSection(indexForAdd).array.set(indexForAdd % i2, e2);
        return indexForAdd;
    }

    public int forEach(Func1<? super E, Boolean> func1) {
        return forEach(func1, 0);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return false;
    }

    public void releaseToPool() {
        int i2 = this.index.get();
        int i3 = 0;
        loop0: for (ElementSection<E> elementSection = this.elements; elementSection != null; elementSection = elementSection.next.get()) {
            int i4 = 0;
            while (i4 < SIZE) {
                if (i3 >= i2) {
                    break loop0;
                }
                elementSection.array.set(i4, null);
                i4++;
                i3++;
            }
        }
        this.index.set(0);
        this.removedIndex.set(0);
    }

    public E remove(int i2) {
        E andSet;
        int i3 = SIZE;
        if (i2 < i3) {
            andSet = this.elements.array.getAndSet(i2, null);
        } else {
            andSet = getElementSection(i2).array.getAndSet(i2 % i3, null);
        }
        pushRemovedIndex(i2);
        return andSet;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        releaseToPool();
    }

    public int forEach(Func1<? super E, Boolean> func1, int i2) {
        int iForEach = forEach(func1, i2, this.index.get());
        if (i2 > 0 && iForEach == this.index.get()) {
            return forEach(func1, 0, i2);
        }
        if (iForEach == this.index.get()) {
            return 0;
        }
        return iForEach;
    }

    private int forEach(Func1<? super E, Boolean> func1, int i2, int i3) {
        ElementSection<E> elementSection;
        int i4;
        int i5 = this.index.get();
        ElementSection<E> elementSection2 = this.elements;
        int i6 = SIZE;
        if (i2 >= i6) {
            ElementSection<E> elementSection3 = getElementSection(i2);
            i4 = i2;
            i2 %= i6;
            elementSection = elementSection3;
        } else {
            elementSection = elementSection2;
            i4 = i2;
        }
        loop0: while (elementSection != null) {
            while (i2 < SIZE) {
                if (i4 >= i5 || i4 >= i3) {
                    break loop0;
                }
                E e2 = elementSection.array.get(i2);
                if (e2 != null && !func1.call(e2).booleanValue()) {
                    return i4;
                }
                i2++;
                i4++;
            }
            elementSection = elementSection.next.get();
            i2 = 0;
        }
        return i4;
    }
}
