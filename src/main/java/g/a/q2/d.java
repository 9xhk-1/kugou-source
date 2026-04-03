package g.a.q2;

import g.a.t0;

/* JADX INFO: loaded from: classes2.dex */
public interface d<R> {
    void disposeOnSelect(t0 t0Var);

    f.w.d<R> getCompletion();

    boolean isSelected();

    Object performAtomicTrySelect(g.a.n2.b bVar);

    void resumeSelectCancellableWithException(Throwable th);

    boolean trySelect(Object obj);
}
