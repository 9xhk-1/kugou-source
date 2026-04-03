package g.a.p2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "lastScheduledTask");
    public static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(o.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1647d = AtomicIntegerFieldUpdater.newUpdater(o.class, "consumerIndex");
    public final AtomicReferenceArray<i> a = new AtomicReferenceArray<>(128);
    private volatile Object lastScheduledTask = null;
    public volatile int producerIndex = 0;
    public volatile int consumerIndex = 0;

    public final boolean b(i iVar, e eVar) {
        f.z.d.j.f(iVar, "task");
        f.z.d.j.f(eVar, "globalQueue");
        i iVar2 = (i) b.getAndSet(this, iVar);
        if (iVar2 != null) {
            return c(iVar2, eVar);
        }
        return true;
    }

    public final boolean c(i iVar, e eVar) {
        f.z.d.j.f(iVar, "task");
        f.z.d.j.f(eVar, "globalQueue");
        boolean z = true;
        while (!j(iVar)) {
            g(eVar);
            z = false;
        }
        return z;
    }

    public final void d(e eVar, i iVar) {
        if (!eVar.a(iVar)) {
            throw new IllegalStateException("GlobalQueue could not be closed yet".toString());
        }
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final void f(e eVar) {
        i iVar;
        f.z.d.j.f(eVar, "globalQueue");
        i iVar2 = (i) b.getAndSet(this, null);
        if (iVar2 != null) {
            d(eVar, iVar2);
        }
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                iVar = null;
            } else {
                int i3 = i2 & 127;
                if (((i) this.a.get(i3)) != null && f1647d.compareAndSet(this, i2, i2 + 1)) {
                    iVar = (i) this.a.getAndSet(i3, null);
                }
            }
            if (iVar == null) {
                return;
            } else {
                d(eVar, iVar);
            }
        }
    }

    public final void g(e eVar) {
        i iVar;
        int iB = f.b0.f.b(e() / 2, 1);
        for (int i2 = 0; i2 < iB; i2++) {
            while (true) {
                int i3 = this.consumerIndex;
                iVar = null;
                if (i3 - this.producerIndex == 0) {
                    break;
                }
                int i4 = i3 & 127;
                if (((i) this.a.get(i4)) != null && f1647d.compareAndSet(this, i3, i3 + 1)) {
                    iVar = (i) this.a.getAndSet(i4, null);
                    break;
                }
            }
            if (iVar == null) {
                return;
            }
            d(eVar, iVar);
        }
    }

    public final i h() {
        i iVar = (i) b.getAndSet(this, null);
        if (iVar != null) {
            return iVar;
        }
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (((i) this.a.get(i3)) != null && f1647d.compareAndSet(this, i2, i2 + 1)) {
                return (i) this.a.getAndSet(i3, null);
            }
        }
    }

    public final int i() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final boolean j(i iVar) {
        if (e() == 127) {
            return false;
        }
        int i2 = this.producerIndex & 127;
        if (this.a.get(i2) != null) {
            return false;
        }
        this.a.lazySet(i2, iVar);
        c.incrementAndGet(this);
        return true;
    }

    public final boolean k(o oVar, e eVar) {
        i iVar;
        f.z.d.j.f(oVar, "victim");
        f.z.d.j.f(eVar, "globalQueue");
        long jA = m.f1646f.a();
        int iE = oVar.e();
        if (iE == 0) {
            return l(jA, oVar, eVar);
        }
        int iB = f.b0.f.b(iE / 2, 1);
        int i2 = 0;
        boolean z = false;
        while (i2 < iB) {
            while (true) {
                int i3 = oVar.consumerIndex;
                iVar = null;
                if (i3 - oVar.producerIndex != 0) {
                    int i4 = i3 & 127;
                    i iVar2 = (i) oVar.a.get(i4);
                    if (iVar2 != null) {
                        if (!(jA - iVar2.a >= m.a || oVar.e() > m.b)) {
                            break;
                        }
                        if (f1647d.compareAndSet(oVar, i3, i3 + 1)) {
                            iVar = (i) oVar.a.getAndSet(i4, null);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (iVar == null) {
                break;
            }
            b(iVar, eVar);
            i2++;
            z = true;
        }
        return z;
    }

    public final boolean l(long j, o oVar, e eVar) {
        i iVar = (i) oVar.lastScheduledTask;
        if (iVar == null || j - iVar.a < m.a || !b.compareAndSet(oVar, iVar, null)) {
            return false;
        }
        b(iVar, eVar);
        return true;
    }
}
