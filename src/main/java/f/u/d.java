package f.u;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d<E> extends f.u.a<E> implements List<E> {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public final void a(int i2, int i3) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void b(int i2, int i3) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("index: " + i2 + ", size: " + i3);
            }
        }

        public final void c(int i2, int i3, int i4) {
            if (i2 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
            }
            if (i2 <= i3) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i2 + " > toIndex: " + i3);
        }

        public final boolean d(Collection<?> collection, Collection<?> collection2) {
            f.z.d.j.e(collection, "c");
            f.z.d.j.e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!f.z.d.j.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection<?> collection) {
            f.z.d.j.e(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }
    }

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
    public class b implements Iterator<E> {
        public int a;

        public b() {
        }

        public final int a() {
            return this.a;
        }

        public final void b(int i2) {
            this.a = i2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < d.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            d dVar = d.this;
            int i2 = this.a;
            this.a = i2 + 1;
            return (E) dVar.get(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
    public class c extends d<E>.b implements ListIterator<E> {
        public c(int i2) {
            super();
            d.a.b(i2, d.this.size());
            b(i2);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            d dVar = d.this;
            b(a() - 1);
            return (E) dVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: f.u.d$d, reason: collision with other inner class name */
    public static final class C0267d<E> extends d<E> implements RandomAccess {
        public int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d<E> f1527d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1528f;

        /* JADX WARN: Multi-variable type inference failed */
        public C0267d(d<? extends E> dVar, int i2, int i3) {
            f.z.d.j.e(dVar, "list");
            this.f1527d = dVar;
            this.f1528f = i2;
            d.a.c(i2, i3, dVar.size());
            this.b = i3 - i2;
        }

        @Override // f.u.a
        public int a() {
            return this.b;
        }

        @Override // f.u.d, java.util.List
        public E get(int i2) {
            d.a.a(i2, this.b);
            return this.f1527d.get(this.f1528f + i2);
        }
    }

    @Override // java.util.List
    public void add(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return a.d(this, (Collection) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i2);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return a.e(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (f.z.d.j.a(it.next(), obj)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (f.z.d.j.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i2, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i2, int i3) {
        return new C0267d(this, i2, i3);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i2) {
        return new c(i2);
    }
}
