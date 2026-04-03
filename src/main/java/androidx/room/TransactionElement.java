package androidx.room;

import androidx.annotation.RestrictTo;
import f.w.e;
import f.w.g;
import f.z.c.p;
import f.z.d.j;
import g.a.m1;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TransactionElement implements g.b {
    public static final Key Key = new Key(null);
    private final AtomicInteger referenceCount;
    private final e transactionDispatcher;
    private final m1 transactionThreadControlJob;

    public static final class Key implements g.c<TransactionElement> {
        private Key() {
        }

        public /* synthetic */ Key(f.z.d.g gVar) {
            this();
        }
    }

    public TransactionElement(m1 m1Var, e eVar) {
        j.f(m1Var, "transactionThreadControlJob");
        j.f(eVar, "transactionDispatcher");
        this.transactionThreadControlJob = m1Var;
        this.transactionDispatcher = eVar;
        this.referenceCount = new AtomicInteger(0);
    }

    public final void acquire() {
        this.referenceCount.incrementAndGet();
    }

    @Override // f.w.g.b, f.w.g
    public <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar) {
        j.f(pVar, "operation");
        return (R) g.b.a.a(this, r, pVar);
    }

    @Override // f.w.g.b, f.w.g
    public <E extends g.b> E get(g.c<E> cVar) {
        j.f(cVar, "key");
        return (E) g.b.a.b(this, cVar);
    }

    @Override // f.w.g.b
    public g.c<TransactionElement> getKey() {
        return Key;
    }

    public final e getTransactionDispatcher$room_ktx_release() {
        return this.transactionDispatcher;
    }

    @Override // f.w.g.b, f.w.g
    public g minusKey(g.c<?> cVar) {
        j.f(cVar, "key");
        return g.b.a.c(this, cVar);
    }

    @Override // f.w.g.b, f.w.g
    public g plus(g gVar) {
        j.f(gVar, "context");
        return g.b.a.d(this, gVar);
    }

    public final void release() {
        int iDecrementAndGet = this.referenceCount.decrementAndGet();
        if (iDecrementAndGet < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
        if (iDecrementAndGet == 0) {
            m1.a.b(this.transactionThreadControlJob, null, 1, null);
        }
    }
}
