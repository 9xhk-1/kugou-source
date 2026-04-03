package e.c.a.g.a.f.i;

import android.net.Uri;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes.dex */
public class i implements f {
    public final f[] a;
    public final PriorityQueue<d> b;
    public long[] c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f675f;

    public static class b implements Comparator<d> {
        public b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            long j = dVar.f676d;
            long j2 = dVar2.f676d;
            return j != j2 ? j < j2 ? -1 : 1 : dVar.c - dVar2.c;
        }
    }

    public static class c implements Comparator<d> {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            long j = dVar.f676d;
            long j2 = dVar2.f676d;
            return j != j2 ? j < j2 ? 1 : -1 : dVar.c - dVar2.c;
        }
    }

    public static class d {
        public int a = -1;
        public final f b;
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f676d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f677e;

        public d(f fVar, int i2) {
            this.b = fVar;
            this.c = i2;
        }

        public boolean a() {
            if (this.a >= this.b.getCount() - 1) {
                return false;
            }
            f fVar = this.b;
            int i2 = this.a + 1;
            this.a = i2;
            e imageAt = fVar.getImageAt(i2);
            this.f677e = imageAt;
            this.f676d = imageAt.getDateTaken();
            return true;
        }
    }

    public i(f[] fVarArr, int i2) {
        f[] fVarArr2 = (f[]) fVarArr.clone();
        this.a = fVarArr2;
        PriorityQueue<d> priorityQueue = new PriorityQueue<>(4, i2 == 1 ? new b() : new c());
        this.b = priorityQueue;
        this.c = new long[16];
        this.f673d = 0;
        this.f674e = new int[fVarArr2.length];
        this.f675f = -1;
        priorityQueue.clear();
        int length = fVarArr2.length;
        for (int i3 = 0; i3 < length; i3++) {
            d dVar = new d(this.a[i3], i3);
            if (dVar.a()) {
                this.b.add(dVar);
            }
        }
    }

    public static <T> int a(T[] tArr, T t) {
        for (int i2 = 0; i2 < tArr.length; i2++) {
            if (tArr[i2].equals(t)) {
                return i2;
            }
        }
        return -1;
    }

    public final void b(int i2) {
        int i3 = this.f673d;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            long[] jArr = this.c;
            long j = jArr[i5];
            i4 += (int) ((-1) & j);
            if (i4 > i2) {
                jArr[i5] = j - 1;
                return;
            }
        }
    }

    public final d c() {
        d dVarPoll = this.b.poll();
        if (dVarPoll == null) {
            return null;
        }
        int i2 = dVarPoll.c;
        if (i2 == this.f675f) {
            int i3 = this.f673d - 1;
            long[] jArr = this.c;
            jArr[i3] = jArr[i3] + 1;
        } else {
            this.f675f = i2;
            long[] jArr2 = this.c;
            int length = jArr2.length;
            int i4 = this.f673d;
            if (length == i4) {
                long[] jArr3 = new long[i4 * 2];
                System.arraycopy(jArr2, 0, jArr3, 0, i4);
                this.c = jArr3;
            }
            long[] jArr4 = this.c;
            int i5 = this.f673d;
            this.f673d = i5 + 1;
            jArr4[i5] = 1 | (((long) this.f675f) << 32);
        }
        return dVarPoll;
    }

    @Override // e.c.a.g.a.f.i.f
    public void close() {
        int length = this.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.a[i2].close();
        }
    }

    public final boolean d(e eVar, int i2) {
        f container = eVar.getContainer();
        if (container == null || !container.removeImage(eVar)) {
            return false;
        }
        b(i2);
        return true;
    }

    @Override // e.c.a.g.a.f.i.f
    public HashMap<String, String> getBucketIds() {
        HashMap<String, String> map = new HashMap<>();
        for (f fVar : this.a) {
            map.putAll(fVar.getBucketIds());
        }
        return map;
    }

    @Override // e.c.a.g.a.f.i.f
    public int getCount() {
        int count = 0;
        for (f fVar : this.a) {
            count += fVar.getCount();
        }
        return count;
    }

    @Override // e.c.a.g.a.f.i.f
    public e getImageAt(int i2) {
        if (i2 < 0 || i2 > getCount()) {
            throw new IndexOutOfBoundsException("index " + i2 + " out of range max is " + getCount());
        }
        int i3 = 0;
        Arrays.fill(this.f674e, 0);
        int i4 = this.f673d;
        int i5 = 0;
        while (i3 < i4) {
            long j = this.c[i3];
            int i6 = (int) ((-1) & j);
            int i7 = (int) (j >> 32);
            int i8 = i5 + i6;
            if (i8 > i2) {
                return this.a[i7].getImageAt(this.f674e[i7] + (i2 - i5));
            }
            int[] iArr = this.f674e;
            iArr[i7] = iArr[i7] + i6;
            i3++;
            i5 = i8;
        }
        while (true) {
            d dVarC = c();
            if (dVarC == null) {
                return null;
            }
            if (i5 == i2) {
                e eVar = dVarC.f677e;
                if (dVarC.a()) {
                    this.b.add(dVarC);
                }
                return eVar;
            }
            if (dVarC.a()) {
                this.b.add(dVarC);
            }
            i5++;
        }
    }

    @Override // e.c.a.g.a.f.i.f
    public e getImageForUri(Uri uri) {
        for (f fVar : this.a) {
            e imageForUri = fVar.getImageForUri(uri);
            if (imageForUri != null) {
                return imageForUri;
            }
        }
        return null;
    }

    @Override // e.c.a.g.a.f.i.f
    public synchronized int getImageIndex(e eVar) {
        f container = eVar.getContainer();
        int iA = a(this.a, container);
        if (iA == -1) {
            throw new IllegalArgumentException();
        }
        int imageIndex = container.getImageIndex(eVar);
        int i2 = this.f673d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            long j = this.c[i4];
            int i5 = (int) ((-1) & j);
            if (((int) (j >> 32)) == iA) {
                if (imageIndex < i5) {
                    return i3 + imageIndex;
                }
                imageIndex -= i5;
            }
            i3 += i5;
        }
        while (true) {
            d dVarC = c();
            if (dVarC == null) {
                return -1;
            }
            if (dVarC.f677e == eVar) {
                if (dVarC.a()) {
                    this.b.add(dVarC);
                }
                return i3;
            }
            if (dVarC.a()) {
                this.b.add(dVarC);
            }
            i3++;
        }
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean isEmpty() {
        for (f fVar : this.a) {
            if (!fVar.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean removeImage(e eVar) {
        return d(eVar, getImageIndex(eVar));
    }

    @Override // e.c.a.g.a.f.i.f
    public boolean removeImageAt(int i2) {
        e imageAt = getImageAt(i2);
        if (imageAt == null) {
            return false;
        }
        return d(imageAt, i2);
    }
}
