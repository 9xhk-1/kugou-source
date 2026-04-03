package g.a;

import f.w.g;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public interface y1 extends m1 {
    @Override // g.a.m1
    /* synthetic */ o attachChild(q qVar);

    @Override // g.a.m1
    /* synthetic */ void cancel();

    @Override // g.a.m1
    /* synthetic */ void cancel(CancellationException cancellationException);

    @Override // g.a.m1
    /* synthetic */ boolean cancel(Throwable th);

    @Override // g.a.m1, f.w.g.b, f.w.g
    /* synthetic */ <R> R fold(R r, f.z.c.p<? super R, ? super g.b, ? extends R> pVar);

    @Override // g.a.m1, f.w.g.b, f.w.g
    /* synthetic */ <E extends g.b> E get(g.c<E> cVar);

    @Override // g.a.m1
    /* synthetic */ CancellationException getCancellationException();

    CancellationException getChildJobCancellationCause();

    @Override // g.a.m1
    /* synthetic */ f.d0.b<m1> getChildren();

    @Override // g.a.m1, f.w.g.b
    /* synthetic */ g.c<?> getKey();

    @Override // g.a.m1
    /* synthetic */ g.a.q2.a getOnJoin();

    @Override // g.a.m1
    /* synthetic */ t0 invokeOnCompletion(f.z.c.l<? super Throwable, f.s> lVar);

    @Override // g.a.m1
    /* synthetic */ t0 invokeOnCompletion(boolean z, boolean z2, f.z.c.l<? super Throwable, f.s> lVar);

    /* synthetic */ boolean isActive();

    @Override // g.a.m1
    /* synthetic */ boolean isCancelled();

    @Override // g.a.m1
    /* synthetic */ boolean isCompleted();

    @Override // g.a.m1
    /* synthetic */ Object join(f.w.d<? super f.s> dVar);

    @Override // g.a.m1, f.w.g.b, f.w.g
    /* synthetic */ f.w.g minusKey(g.c<?> cVar);

    @Override // g.a.m1, f.w.g.b, f.w.g
    /* synthetic */ f.w.g plus(f.w.g gVar);

    @Override // g.a.m1
    /* synthetic */ m1 plus(m1 m1Var);

    @Override // g.a.m1
    /* synthetic */ boolean start();
}
