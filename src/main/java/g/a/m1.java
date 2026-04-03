package g.a;

import f.w.g;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes2.dex */
public interface m1 extends g.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f1605g = b.a;

    public static final class a {
        public static /* synthetic */ void b(m1 m1Var, CancellationException cancellationException, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i2 & 1) != 0) {
                cancellationException = null;
            }
            m1Var.cancel(cancellationException);
        }

        public static <R> R c(m1 m1Var, R r, f.z.c.p<? super R, ? super g.b, ? extends R> pVar) {
            f.z.d.j.f(pVar, "operation");
            return (R) g.b.a.a(m1Var, r, pVar);
        }

        public static <E extends g.b> E d(m1 m1Var, g.c<E> cVar) {
            f.z.d.j.f(cVar, "key");
            return (E) g.b.a.b(m1Var, cVar);
        }

        public static /* synthetic */ t0 e(m1 m1Var, boolean z, boolean z2, f.z.c.l lVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                z2 = true;
            }
            return m1Var.invokeOnCompletion(z, z2, lVar);
        }

        public static f.w.g f(m1 m1Var, g.c<?> cVar) {
            f.z.d.j.f(cVar, "key");
            return g.b.a.c(m1Var, cVar);
        }

        public static f.w.g g(m1 m1Var, f.w.g gVar) {
            f.z.d.j.f(gVar, "context");
            return g.b.a.d(m1Var, gVar);
        }

        public static m1 h(m1 m1Var, m1 m1Var2) {
            f.z.d.j.f(m1Var2, "other");
            return m1Var2;
        }
    }

    public static final class b implements g.c<m1> {
        public static final /* synthetic */ b a = new b();

        static {
            CoroutineExceptionHandler.a aVar = CoroutineExceptionHandler.f1692e;
        }
    }

    o attachChild(q qVar);

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ <R> R fold(R r, f.z.c.p<? super R, ? super g.b, ? extends R> pVar);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ <E extends g.b> E get(g.c<E> cVar);

    CancellationException getCancellationException();

    f.d0.b<m1> getChildren();

    @Override // f.w.g.b
    /* synthetic */ g.c<?> getKey();

    g.a.q2.a getOnJoin();

    t0 invokeOnCompletion(f.z.c.l<? super Throwable, f.s> lVar);

    t0 invokeOnCompletion(boolean z, boolean z2, f.z.c.l<? super Throwable, f.s> lVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(f.w.d<? super f.s> dVar);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ f.w.g minusKey(g.c<?> cVar);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ f.w.g plus(f.w.g gVar);

    m1 plus(m1 m1Var);

    boolean start();
}
