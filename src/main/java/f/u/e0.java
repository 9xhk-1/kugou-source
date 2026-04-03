package f.u;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class e0<T> extends d<T> implements RandomAccess {
    public final int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1529d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1530f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object[] f1531h;

    public static final class a extends c<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1532d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1533f;

        public a() {
            this.f1532d = e0.this.size();
            this.f1533f = e0.this.f1529d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.u.c
        public void a() {
            if (this.f1532d == 0) {
                b();
                return;
            }
            c(e0.this.f1531h[this.f1533f]);
            this.f1533f = (this.f1533f + 1) % e0.this.b;
            this.f1532d--;
        }
    }

    public e0(Object[] objArr, int i2) {
        f.z.d.j.e(objArr, "buffer");
        this.f1531h = objArr;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i2).toString());
        }
        if (i2 <= objArr.length) {
            this.b = objArr.length;
            this.f1530f = i2;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i2 + " cannot be larger than the buffer size: " + objArr.length).toString());
    }

    @Override // f.u.a
    public int a() {
        return this.f1530f;
    }

    public final void e(T t) {
        if (g()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f1531h[(this.f1529d + size()) % this.b] = t;
        this.f1530f = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final e0<T> f(int i2) {
        Object[] array;
        int i3 = this.b;
        int iE = f.b0.f.e(i3 + (i3 >> 1) + 1, i2);
        if (this.f1529d == 0) {
            array = Arrays.copyOf(this.f1531h, iE);
            f.z.d.j.d(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iE]);
        }
        return new e0<>(array, size());
    }

    public final boolean g() {
        return size() == this.b;
    }

    @Override // f.u.d, java.util.List
    public T get(int i2) {
        d.a.a(i2, size());
        return (T) this.f1531h[(this.f1529d + i2) % this.b];
    }

    public final void h(int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i2).toString());
        }
        if (!(i2 <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i2 + ", size = " + size()).toString());
        }
        if (i2 > 0) {
            int i3 = this.f1529d;
            int i4 = (i3 + i2) % this.b;
            if (i3 > i4) {
                h.d(this.f1531h, null, i3, this.b);
                h.d(this.f1531h, null, 0, i4);
            } else {
                h.d(this.f1531h, null, i3, i4);
            }
            this.f1529d = i4;
            this.f1530f = size() - i2;
        }
    }

    @Override // f.u.d, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return new a();
    }

    @Override // f.u.a, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        f.z.d.j.e(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            f.z.d.j.d(tArr, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = this.f1529d; i3 < size && i4 < this.b; i4++) {
            tArr[i3] = this.f1531h[i4];
            i3++;
        }
        while (i3 < size) {
            tArr[i3] = this.f1531h[i2];
            i3++;
            i2++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr;
    }

    public e0(int i2) {
        this(new Object[i2], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.u.a, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
