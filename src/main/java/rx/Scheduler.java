package rx;

import java.util.concurrent.TimeUnit;
import rx.annotations.Experimental;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.SchedulerWhen;
import rx.internal.subscriptions.SequentialSubscription;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Scheduler {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public static abstract class Worker implements Subscription {
        public long now() {
            return System.currentTimeMillis();
        }

        public abstract Subscription schedule(Action0 action0);

        public abstract Subscription schedule(Action0 action0, long j, TimeUnit timeUnit);

        public Subscription schedulePeriodically(Action0 action0, long j, long j2, TimeUnit timeUnit) {
            long nanos = timeUnit.toNanos(j2);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(now());
            long nanos3 = nanos2 + timeUnit.toNanos(j);
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
            sequentialSubscription.replace(schedule(new Action0(nanos2, nanos3, action0, sequentialSubscription2, nanos) { // from class: rx.Scheduler.Worker.1
                public long count;
                public long lastNowNanos;
                public long startInNanos;
                public final /* synthetic */ Action0 val$action;
                public final /* synthetic */ long val$firstNowNanos;
                public final /* synthetic */ long val$firstStartInNanos;
                public final /* synthetic */ SequentialSubscription val$mas;
                public final /* synthetic */ long val$periodInNanos;

                {
                    this.val$firstNowNanos = nanos2;
                    this.val$firstStartInNanos = nanos3;
                    this.val$action = action0;
                    this.val$mas = sequentialSubscription2;
                    this.val$periodInNanos = nanos;
                    this.lastNowNanos = nanos2;
                    this.startInNanos = nanos3;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0039  */
                @Override // rx.functions.Action0
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void call() {
                    /*
                        r11 = this;
                        rx.functions.Action0 r0 = r11.val$action
                        r0.call()
                        rx.internal.subscriptions.SequentialSubscription r0 = r11.val$mas
                        boolean r0 = r0.isUnsubscribed()
                        if (r0 != 0) goto L59
                        java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
                        rx.Scheduler$Worker r1 = rx.Scheduler.Worker.this
                        long r1 = r1.now()
                        long r0 = r0.toNanos(r1)
                        long r2 = rx.Scheduler.CLOCK_DRIFT_TOLERANCE_NANOS
                        long r4 = r0 + r2
                        long r6 = r11.lastNowNanos
                        r8 = 1
                        int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                        if (r10 < 0) goto L39
                        long r4 = r11.val$periodInNanos
                        long r6 = r6 + r4
                        long r6 = r6 + r2
                        int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                        if (r2 < 0) goto L2e
                        goto L39
                    L2e:
                        long r2 = r11.startInNanos
                        long r6 = r11.count
                        long r6 = r6 + r8
                        r11.count = r6
                        long r6 = r6 * r4
                        long r2 = r2 + r6
                        goto L49
                    L39:
                        long r2 = r11.val$periodInNanos
                        long r4 = r0 + r2
                        long r6 = r11.count
                        long r6 = r6 + r8
                        r11.count = r6
                        long r2 = r2 * r6
                        long r2 = r4 - r2
                        r11.startInNanos = r2
                        r2 = r4
                    L49:
                        r11.lastNowNanos = r0
                        long r2 = r2 - r0
                        rx.internal.subscriptions.SequentialSubscription r0 = r11.val$mas
                        rx.Scheduler$Worker r1 = rx.Scheduler.Worker.this
                        java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS
                        rx.Subscription r1 = r1.schedule(r11, r2, r4)
                        r0.replace(r1)
                    L59:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: rx.Scheduler.Worker.AnonymousClass1.call():void");
                }
            }, j, timeUnit));
            return sequentialSubscription2;
        }
    }

    public abstract Worker createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    @Experimental
    public <S extends Scheduler & Subscription> S when(Func1<Observable<Observable<Completable>>, Completable> func1) {
        return new SchedulerWhen(func1, this);
    }
}
