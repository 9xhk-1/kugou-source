package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: loaded from: classes2.dex */
@SuppressAnimalSniffer
public abstract class SpmcArrayQueueProducerIndexCacheField<E> extends SpmcArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    public SpmcArrayQueueProducerIndexCacheField(int i2) {
        super(i2);
    }

    public final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    public final void svProducerIndexCache(long j) {
        this.producerIndexCache = j;
    }
}
