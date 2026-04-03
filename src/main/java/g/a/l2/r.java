package g.a.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface r<E> {
    boolean close(Throwable th);

    g.a.q2.c<E, r<E>> getOnSend();

    void invokeOnClose(f.z.c.l<? super Throwable, f.s> lVar);

    boolean isClosedForSend();

    boolean isFull();

    boolean offer(E e2);

    Object send(E e2, f.w.d<? super f.s> dVar);
}
