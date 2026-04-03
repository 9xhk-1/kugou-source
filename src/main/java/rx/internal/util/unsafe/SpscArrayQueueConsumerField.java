package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: loaded from: classes2.dex */
@SuppressAnimalSniffer
public abstract class SpscArrayQueueConsumerField<E> extends SpscArrayQueueL2Pad<E> {
    public static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueConsumerField.class, "consumerIndex");
    public long consumerIndex;

    public SpscArrayQueueConsumerField(int i2) {
        super(i2);
    }
}
