package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SpscArrayQueueColdField<E> extends ConcurrentCircularArrayQueue<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final int lookAheadStep;

    public SpscArrayQueueColdField(int i2) {
        super(i2);
        this.lookAheadStep = Math.min(i2 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }
}
