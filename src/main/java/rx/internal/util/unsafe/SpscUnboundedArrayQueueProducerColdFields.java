package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SpscUnboundedArrayQueueProducerColdFields<E> extends SpscUnboundedArrayQueueProducerFields<E> {
    public E[] producerBuffer;
    public long producerLookAhead;
    public int producerLookAheadStep;
    public long producerMask;
}
