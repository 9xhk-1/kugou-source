package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: loaded from: classes2.dex */
public final class OnSubscribeFromEmitter<T> implements Observable.OnSubscribe<T> {
    public final Action1<Emitter<T>> Emitter;
    public final Emitter.BackpressureMode backpressure;

    /* JADX INFO: renamed from: rx.internal.operators.OnSubscribeFromEmitter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$rx$Emitter$BackpressureMode;

        static {
            int[] iArr = new int[Emitter.BackpressureMode.values().length];
            $SwitchMap$rx$Emitter$BackpressureMode = iArr;
            try {
                iArr[Emitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$rx$Emitter$BackpressureMode[Emitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static abstract class BaseEmitter<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        public final Subscriber<? super T> actual;
        public final SerialSubscription serial = new SerialSubscription();

        public BaseEmitter(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // rx.Subscription
        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onCompleted();
            } finally {
                this.serial.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onError(th);
            } finally {
                this.serial.unsubscribe();
            }
        }

        public void onRequested() {
        }

        public void onUnsubscribed() {
        }

        @Override // rx.Producer
        public final void request(long j) {
            if (BackpressureUtils.validate(j)) {
                BackpressureUtils.getAndAddRequest(this, j);
                onRequested();
            }
        }

        @Override // rx.Emitter
        public final long requested() {
            return get();
        }

        @Override // rx.Emitter
        public final void setCancellation(Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }

        @Override // rx.Emitter
        public final void setSubscription(Subscription subscription) {
            this.serial.set(subscription);
        }

        @Override // rx.Subscription
        public final void unsubscribe() {
            this.serial.unsubscribe();
            onUnsubscribed();
        }
    }

    public static final class BufferEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        public volatile boolean done;
        public Throwable error;
        public final Queue<Object> queue;
        public final AtomicInteger wip;

        public BufferEmitter(Subscriber<? super T> subscriber, int i2) {
            super(subscriber);
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(i2) : new SpscUnboundedAtomicArrayQueue<>(i2);
            this.wip = new AtomicInteger();
        }

        public void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            Queue<Object> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j = get();
                long j2 = 0;
                while (j2 != j) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z = this.done;
                    Object objPoll = queue.poll();
                    boolean z2 = objPoll == null;
                    if (z && z2) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.getValue(objPoll));
                    j2++;
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z3 = this.done;
                    boolean zIsEmpty = queue.isEmpty();
                    if (z3 && zIsEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    BackpressureUtils.produced(this, j2);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.queue.offer(NotificationLite.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter
        public void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter
        public void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public static final class DropEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.NoOverflowBaseEmitter
        public void onOverflow() {
        }
    }

    public static final class ErrorEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public ErrorEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            super.onCompleted();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
            } else {
                this.done = true;
                super.onError(th);
            }
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.NoOverflowBaseEmitter, rx.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            super.onNext(t);
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.NoOverflowBaseEmitter
        public void onOverflow() {
            onError(new MissingBackpressureException("fromEmitter: could not emit value due to lack of requests"));
        }
    }

    public static final class LatestEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        public volatile boolean done;
        public Throwable error;
        public final AtomicReference<Object> queue;
        public final AtomicInteger wip;

        public LatestEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
        
            if (r8 != r4) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            if (r0.isUnsubscribed() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
        
            r1.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
        
            r4 = r15.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        
            if (r1.get() != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0065, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
        
            if (r4 == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
        
            if (r10 == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006a, code lost:
        
            r0 = r15.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006c, code lost:
        
            if (r0 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006e, code lost:
        
            super.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0072, code lost:
        
            super.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0075, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0078, code lost:
        
            if (r8 == 0) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007a, code lost:
        
            rx.internal.operators.BackpressureUtils.produced(r15, r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x007d, code lost:
        
            r3 = r15.wip.addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain() {
            /*
                r15 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r15.wip
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                rx.Subscriber<? super T> r0 = r15.actual
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r15.queue
                r2 = 1
                r3 = 1
            Lf:
                long r4 = r15.get()
                r6 = 0
                r8 = r6
            L16:
                r10 = 0
                r11 = 0
                int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r12 == 0) goto L4f
                boolean r12 = r0.isUnsubscribed()
                if (r12 == 0) goto L26
                r1.lazySet(r11)
                return
            L26:
                boolean r12 = r15.done
                java.lang.Object r13 = r1.getAndSet(r11)
                if (r13 != 0) goto L30
                r14 = 1
                goto L31
            L30:
                r14 = 0
            L31:
                if (r12 == 0) goto L41
                if (r14 == 0) goto L41
                java.lang.Throwable r0 = r15.error
                if (r0 == 0) goto L3d
                super.onError(r0)
                goto L40
            L3d:
                super.onCompleted()
            L40:
                return
            L41:
                if (r14 == 0) goto L44
                goto L4f
            L44:
                java.lang.Object r10 = rx.internal.operators.NotificationLite.getValue(r13)
                r0.onNext(r10)
                r10 = 1
                long r8 = r8 + r10
                goto L16
            L4f:
                int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r12 != 0) goto L76
                boolean r4 = r0.isUnsubscribed()
                if (r4 == 0) goto L5d
                r1.lazySet(r11)
                return
            L5d:
                boolean r4 = r15.done
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L66
                r10 = 1
            L66:
                if (r4 == 0) goto L76
                if (r10 == 0) goto L76
                java.lang.Throwable r0 = r15.error
                if (r0 == 0) goto L72
                super.onError(r0)
                goto L75
            L72:
                super.onCompleted()
            L75:
                return
            L76:
                int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r4 == 0) goto L7d
                rx.internal.operators.BackpressureUtils.produced(r15, r8)
            L7d:
                java.util.concurrent.atomic.AtomicInteger r4 = r15.wip
                int r3 = -r3
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeFromEmitter.LatestEmitter.drain():void");
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter, rx.Observer
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t) {
            this.queue.set(NotificationLite.next(t));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter
        public void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromEmitter.BaseEmitter
        public void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }
    }

    public static abstract class NoOverflowBaseEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public NoOverflowBaseEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            if (get() == 0) {
                onOverflow();
            } else {
                this.actual.onNext(t);
                BackpressureUtils.produced(this, 1L);
            }
        }

        public abstract void onOverflow();
    }

    public static final class NoneEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public NoneEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            long j;
            if (this.actual.isUnsubscribed()) {
                return;
            }
            this.actual.onNext(t);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
        }
    }

    public OnSubscribeFromEmitter(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        this.Emitter = action1;
        this.backpressure = backpressureMode;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        int i2 = AnonymousClass1.$SwitchMap$rx$Emitter$BackpressureMode[this.backpressure.ordinal()];
        BaseEmitter bufferEmitter = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new BufferEmitter(subscriber, RxRingBuffer.SIZE) : new LatestEmitter(subscriber) : new DropEmitter(subscriber) : new ErrorEmitter(subscriber) : new NoneEmitter(subscriber);
        subscriber.add(bufferEmitter);
        subscriber.setProducer(bufferEmitter);
        this.Emitter.call(bufferEmitter);
    }
}
