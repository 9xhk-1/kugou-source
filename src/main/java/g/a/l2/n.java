package g.a.l2;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public interface n<E> {

    public static final class a {
    }

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    g.a.q2.b<E> getOnReceive();

    g.a.q2.b<t<E>> getOnReceiveOrClosed();

    g.a.q2.b<E> getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    f<E> iterator();

    E poll();

    Object receive(f.w.d<? super E> dVar);

    Object receiveOrClosed(f.w.d<? super t<? extends E>> dVar);

    Object receiveOrNull(f.w.d<? super E> dVar);
}
