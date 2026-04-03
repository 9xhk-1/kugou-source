package g.a.l2;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public interface e<E> extends r<E>, n<E> {
    public static final b a = b.b;

    public static final class a {
    }

    public static final class b {
        public static final /* synthetic */ b b = new b();
        public static final int a = g.a.n2.r.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        public final int a() {
            return a;
        }
    }

    @Override // g.a.l2.n
    /* synthetic */ void cancel();

    @Override // g.a.l2.n
    /* synthetic */ void cancel(CancellationException cancellationException);

    @Override // g.a.l2.n
    /* synthetic */ boolean cancel(Throwable th);

    @Override // g.a.l2.r
    /* synthetic */ boolean close(Throwable th);

    @Override // g.a.l2.n
    /* synthetic */ g.a.q2.b<E> getOnReceive();

    @Override // g.a.l2.n
    /* synthetic */ g.a.q2.b<t<E>> getOnReceiveOrClosed();

    @Override // g.a.l2.n
    /* synthetic */ g.a.q2.b<E> getOnReceiveOrNull();

    @Override // g.a.l2.r
    /* synthetic */ g.a.q2.c<E, r<E>> getOnSend();

    @Override // g.a.l2.r
    /* synthetic */ void invokeOnClose(f.z.c.l<? super Throwable, f.s> lVar);

    @Override // g.a.l2.n
    /* synthetic */ boolean isClosedForReceive();

    @Override // g.a.l2.r
    /* synthetic */ boolean isClosedForSend();

    @Override // g.a.l2.n
    /* synthetic */ boolean isEmpty();

    @Override // g.a.l2.r
    /* synthetic */ boolean isFull();

    @Override // g.a.l2.n
    /* synthetic */ f<E> iterator();

    @Override // g.a.l2.r
    /* synthetic */ boolean offer(E e2);

    @Override // g.a.l2.n
    /* synthetic */ E poll();

    @Override // g.a.l2.n
    /* synthetic */ Object receive(f.w.d<? super E> dVar);

    @Override // g.a.l2.n
    /* synthetic */ Object receiveOrClosed(f.w.d<? super t<? extends E>> dVar);

    @Override // g.a.l2.n
    /* synthetic */ Object receiveOrNull(f.w.d<? super E> dVar);

    @Override // g.a.l2.r
    /* synthetic */ Object send(E e2, f.w.d<? super f.s> dVar);
}
