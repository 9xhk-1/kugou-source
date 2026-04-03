package e.c.a.g.a.f.j.b;

import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public class k extends e.c.a.g.a.f.j.b.a {
    public ReadWriteLock a = new ReentrantReadWriteLock();
    public a b = new a();

    public static class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f686e = 0;
        public ArrayList<Long> a = new ArrayList<>();
        public HashMap<Long, Long> b = new HashMap<>();
        public HashMap<String, Long> c = new HashMap<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HashMap<Long, n> f685d = new HashMap<>();

        public final void h() {
            if (this.f685d.size() >= 3000) {
                int size = this.f685d.size() - 3000;
                if (g0.a) {
                    g0.e("FeeStatus_FeesMemoryCache_addFees", "remove size=" + size + ", count=" + this.f685d.size());
                }
                for (int i2 = 0; i2 < size; i2++) {
                    n nVarRemove = this.f685d.remove(this.a.remove(0));
                    if (nVarRemove != null) {
                        this.b.remove(Long.valueOf(nVarRemove.getMixId()));
                        this.c.remove(nVarRemove.getFeeKey());
                    }
                }
            }
        }

        public final void i() {
            this.f685d.clear();
            this.b.clear();
            this.c.clear();
            this.a.clear();
        }

        public final Long j(o oVar) {
            Long l = this.b.get(Long.valueOf(oVar.getMixId()));
            return l == null ? this.c.get(oVar.getFeeKey()) : l;
        }

        public final n k(o oVar) {
            return l(j(oVar));
        }

        public final n l(Long l) {
            if (l == null) {
                return null;
            }
            return this.f685d.get(l);
        }

        public final void m(n nVar) {
            long j = this.f686e;
            long j2 = 1 + j;
            this.f686e = j2;
            if (j2 == Long.MAX_VALUE) {
                this.f686e = 0L;
            }
            this.a.add(Long.valueOf(j));
            this.f685d.put(Long.valueOf(j), nVar);
            if (nVar.getMixId() > 0) {
                this.b.put(Long.valueOf(nVar.getMixId()), Long.valueOf(j));
            }
            this.c.put(nVar.getFeeKey(), Long.valueOf(j));
        }

        public final void n(Long l, n nVar) {
            if (l == null) {
                l = j(nVar);
            }
            if (l != null) {
                this.b.remove(Long.valueOf(nVar.getMixId()));
                this.c.remove(nVar.getFeeKey());
                this.f685d.remove(l);
                this.a.remove(l);
            }
        }
    }

    @Override // e.c.a.g.a.f.j.b.a
    public n a(o oVar) {
        this.a.readLock().lock();
        try {
            return this.b.k(oVar);
        } finally {
            this.a.readLock().unlock();
        }
    }

    @Override // e.c.a.g.a.f.j.b.c
    public void addFees(n nVar) {
        this.a.writeLock().lock();
        try {
            Long lJ = this.b.j(nVar);
            n nVarL = this.b.l(lJ);
            if (nVarL != null) {
                nVarL.updateData(nVar);
                if (!m.a(nVarL)) {
                    this.b.n(lJ, nVar);
                    if (g0.a && nVar != null) {
                        g0.e("FeeStatus_FeesMemoryCache_addFee_remove_unavailableInsertData", e.b(nVar));
                    }
                } else if (g0.a && nVar != null) {
                    g0.e("FeeStatus_FeesMemoryCache_addFee_updateData", e.b(nVar));
                }
            } else if (m.a(nVar)) {
                this.b.h();
                d dVarA = e.a(nVar);
                this.b.m(dVarA);
                if (g0.a && nVar != null) {
                    g0.e("FeeStatus_FeesMemoryCache_addFee_addData", e.b(dVarA));
                }
            }
        } finally {
            this.a.writeLock().unlock();
        }
    }

    @Override // e.c.a.g.a.f.j.b.a
    public List<n> b(List<o> list) {
        ArrayList arrayList = new ArrayList();
        this.a.readLock().lock();
        try {
            boolean z = g0.a;
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                n nVarK = this.b.k(it.next());
                if (nVarK != null) {
                    arrayList.add(nVarK);
                }
            }
            boolean z2 = g0.a;
            return arrayList;
        } finally {
            this.a.readLock().unlock();
        }
    }

    @Override // e.c.a.g.a.f.j.b.c
    public void clearCache() {
        this.a.writeLock().lock();
        try {
            this.b.i();
        } finally {
            this.a.writeLock().unlock();
        }
    }

    @Override // e.c.a.g.a.f.j.b.c
    public void addFees(List<n> list) {
        this.a.writeLock().lock();
        try {
            for (n nVar : list) {
                Long lJ = this.b.j(nVar);
                n nVarL = this.b.l(lJ);
                if (nVarL != null) {
                    nVarL.updateData(nVar);
                    if (!m.a(nVarL)) {
                        this.b.n(lJ, nVar);
                        if (g0.a && nVar != null) {
                            g0.e("FeeStatus_FeesMemoryCache_addFees_remove_unavailableInsertData", e.b(nVar));
                        }
                    } else if (g0.a && nVar != null) {
                        g0.e("FeeStatus_FeesMemoryCache_addFees_updateData", e.b(nVar));
                    }
                } else if (m.a(nVar)) {
                    d dVarA = e.a(nVar);
                    this.b.m(dVarA);
                    if (g0.a && nVar != null) {
                        g0.e("FeeStatus_FeesMemoryCache_addFees_addData", e.b(dVarA));
                    }
                }
            }
            this.b.h();
        } finally {
            this.a.writeLock().unlock();
        }
    }
}
