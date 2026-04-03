package e.c.a.g.a.d.s;

import androidx.annotation.IntRange;
import androidx.collection.LongSparseArray;
import java.util.HashSet;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public final LongSparseArray<a> b = new LongSparseArray<>();
    public final ReadWriteLock a = new ReentrantReadWriteLock();

    public static class a {
        public final HashSet<Long> a = new HashSet<>();
        public final HashSet<Long> b = new HashSet<>();
        public final HashSet<String> c = new HashSet<>();

        public final boolean f(@IntRange(from = 0) long j) {
            return this.a.contains(Long.valueOf(j));
        }

        public final boolean g(@IntRange(from = 0) long j, String str) {
            return this.b.contains(Long.valueOf(j)) || this.c.contains(str);
        }

        public HashSet<Long> h() {
            return this.a;
        }

        public HashSet<String> i() {
            return this.c;
        }

        public HashSet<Long> j() {
            return this.b;
        }

        public String toString() {
            return "KubiBuyData{albumIds=" + this.a + "mixIds=" + this.b + ", hashs=" + this.c + '}';
        }
    }

    public void a(@IntRange(from = 0) long j, HashSet<Long> hashSet) {
        this.a.writeLock().lock();
        try {
            a aVar = this.b.get(j);
            if (aVar != null) {
                aVar.a.addAll(hashSet);
            } else {
                a aVar2 = new a();
                aVar2.a.addAll(hashSet);
                this.b.put(j, aVar2);
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public void b(@IntRange(from = 0) long j, a aVar) {
        if (aVar == null) {
            return;
        }
        this.a.writeLock().lock();
        try {
            a aVar2 = this.b.get(j);
            if (aVar2 != null) {
                aVar2.a.addAll(aVar.a);
                aVar2.b.addAll(aVar.b);
                aVar2.c.addAll(aVar.c);
            } else {
                this.b.put(j, aVar);
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public void c(@IntRange(from = 0) long j, HashSet<Long> hashSet, HashSet<String> hashSet2) {
        this.a.writeLock().lock();
        try {
            a aVar = this.b.get(j);
            if (aVar != null) {
                aVar.b.addAll(hashSet);
                aVar.c.addAll(hashSet2);
            } else {
                a aVar2 = new a();
                aVar2.b.addAll(hashSet);
                aVar2.c.addAll(hashSet2);
                this.b.put(j, aVar2);
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public boolean d(@IntRange(from = 0) long j, @IntRange(from = 0) long j2) {
        this.a.readLock().lock();
        try {
            a aVar = this.b.get(j);
            return aVar != null ? aVar.f(j2) : false;
        } finally {
            this.a.readLock().unlock();
        }
    }

    public boolean e(@IntRange(from = 0) long j, @IntRange(from = 0) long j2, String str) {
        this.a.readLock().lock();
        try {
            a aVar = this.b.get(j);
            return aVar != null ? aVar.g(j2, str) : false;
        } finally {
            this.a.readLock().unlock();
        }
    }

    public void f(@IntRange(from = 0) long j, HashSet<Long> hashSet) {
        this.a.writeLock().lock();
        try {
            a aVar = this.b.get(j);
            if (aVar != null) {
                aVar.b.removeAll(hashSet);
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    public void g(@IntRange(from = 0) long j, HashSet<Long> hashSet) {
        this.a.writeLock().lock();
        try {
            a aVar = this.b.get(j);
            if (aVar != null) {
                aVar.a.removeAll(hashSet);
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }
}
