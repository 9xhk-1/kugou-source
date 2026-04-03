package rx.subjects;

import androidx.appcompat.widget.ActivityChooserView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class ReplaySubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    public final ReplayState<T> state;

    public interface ReplayBuffer<T> {
        void complete();

        void drain(ReplayProducer<T> replayProducer);

        Throwable error();

        void error(Throwable th);

        boolean isComplete();

        boolean isEmpty();

        T last();

        void next(T t);

        int size();

        T[] toArray(T[] tArr);
    }

    public static final class ReplayProducer<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        public final Subscriber<? super T> actual;
        public int index;
        public Object node;
        public final AtomicLong requested = new AtomicLong();
        public final ReplayState<T> state;
        public int tailIndex;

        public ReplayProducer(Subscriber<? super T> subscriber, ReplayState<T> replayState) {
            this.actual = subscriber;
            this.state = replayState;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // rx.Producer
        public void request(long j) {
            if (j > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j);
                this.state.buffer.drain(this);
            } else {
                if (j >= 0) {
                    return;
                }
                throw new IllegalArgumentException("n >= required but it was " + j);
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.state.remove(this);
        }
    }

    public static final class ReplayState<T> extends AtomicReference<ReplayProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        public static final ReplayProducer[] EMPTY = new ReplayProducer[0];
        public static final ReplayProducer[] TERMINATED = new ReplayProducer[0];
        private static final long serialVersionUID = 5952362471246910544L;
        public final ReplayBuffer<T> buffer;

        public ReplayState(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            lazySet(EMPTY);
        }

        public boolean add(ReplayProducer<T> replayProducer) {
            ReplayProducer<T>[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = get();
                if (replayProducerArr == TERMINATED) {
                    return false;
                }
                int length = replayProducerArr.length;
                replayProducerArr2 = new ReplayProducer[length + 1];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
            return true;
        }

        public boolean isTerminated() {
            return get() == TERMINATED;
        }

        @Override // rx.Observer
        public void onCompleted() {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.complete();
            for (ReplayProducer<T> replayProducer : getAndSet(TERMINATED)) {
                replayBuffer.drain(replayProducer);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.error(th);
            ArrayList arrayList = null;
            for (ReplayProducer<T> replayProducer : getAndSet(TERMINATED)) {
                try {
                    replayBuffer.drain(replayProducer);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.next(t);
            for (ReplayProducer<T> replayProducer : get()) {
                replayBuffer.drain(replayProducer);
            }
        }

        public void remove(ReplayProducer<T> replayProducer) {
            ReplayProducer<T>[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = get();
                if (replayProducerArr == TERMINATED || replayProducerArr == EMPTY) {
                    return;
                }
                int length = replayProducerArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (replayProducerArr[i3] == replayProducer) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    replayProducerArr2 = EMPTY;
                } else {
                    ReplayProducer[] replayProducerArr3 = new ReplayProducer[length - 1];
                    System.arraycopy(replayProducerArr, 0, replayProducerArr3, 0, i2);
                    System.arraycopy(replayProducerArr, i2 + 1, replayProducerArr3, i2, (length - i2) - 1);
                    replayProducerArr2 = replayProducerArr3;
                }
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer<T> replayProducer = new ReplayProducer<>(subscriber, this);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (add(replayProducer) && replayProducer.isUnsubscribed()) {
                remove(replayProducer);
            } else {
                this.buffer.drain(replayProducer);
            }
        }
    }

    public ReplaySubject(ReplayState<T> replayState) {
        super(replayState);
        this.state = replayState;
    }

    public static <T> ReplaySubject<T> create() {
        return create(16);
    }

    public static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeBoundBuffer(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED)));
    }

    public static <T> ReplaySubject<T> createUnboundedTime() {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeAndTimeBoundBuffer(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Long.MAX_VALUE, Schedulers.immediate())));
    }

    public static <T> ReplaySubject<T> createWithSize(int i2) {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeBoundBuffer(i2)));
    }

    public static <T> ReplaySubject<T> createWithTime(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return createWithTimeAndSize(j, timeUnit, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, scheduler);
    }

    public static <T> ReplaySubject<T> createWithTimeAndSize(long j, TimeUnit timeUnit, int i2, Scheduler scheduler) {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeAndTimeBoundBuffer(i2, timeUnit.toMillis(j), scheduler)));
    }

    public Throwable getThrowable() {
        if (this.state.isTerminated()) {
            return this.state.buffer.error();
        }
        return null;
    }

    public T getValue() {
        return this.state.buffer.last();
    }

    public T[] getValues(T[] tArr) {
        return this.state.buffer.toArray(tArr);
    }

    public boolean hasAnyValue() {
        return !this.state.buffer.isEmpty();
    }

    public boolean hasCompleted() {
        return this.state.isTerminated() && this.state.buffer.error() == null;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.state.get().length != 0;
    }

    public boolean hasThrowable() {
        return this.state.isTerminated() && this.state.buffer.error() != null;
    }

    public boolean hasValue() {
        return hasAnyValue();
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.state.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        this.state.onError(th);
    }

    @Override // rx.Observer
    public void onNext(T t) {
        this.state.onNext(t);
    }

    public int size() {
        return this.state.buffer.size();
    }

    public int subscriberCount() {
        return this.state.get().length;
    }

    public static final class ReplaySizeBoundBuffer<T> implements ReplayBuffer<T> {
        public volatile boolean done;
        public Throwable error;
        public volatile Node<T> head;
        public final int limit;
        public int size;
        public Node<T> tail;

        public static final class Node<T> extends AtomicReference<Node<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            public final T value;

            public Node(T t) {
                this.value = t;
            }
        }

        public ReplaySizeBoundBuffer(int i2) {
            this.limit = i2;
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
        
            if (r10 != r5) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        
            if (r2.isUnsubscribed() == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
        
            r18.node = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
        
            r14 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0070, code lost:
        
            if (r7.get() != null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0072, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0073, code lost:
        
            if (r14 == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
        
            if (r12 == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
        
            r18.node = null;
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
        
            if (r1 == null) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
        
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
        
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0087, code lost:
        
            if (r10 == 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0090, code lost:
        
            if (r5 == Long.MAX_VALUE) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0092, code lost:
        
            rx.internal.operators.BackpressureUtils.produced(r18.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0097, code lost:
        
            r18.node = r7;
            r4 = r18.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        
            return;
         */
        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain(rx.subjects.ReplaySubject.ReplayProducer<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r18.getAndIncrement()
                if (r2 == 0) goto Lb
                return
            Lb:
                rx.Subscriber<? super T> r2 = r1.actual
                r3 = 1
                r4 = 1
            Lf:
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                long r5 = r5.get()
                java.lang.Object r7 = r1.node
                rx.subjects.ReplaySubject$ReplaySizeBoundBuffer$Node r7 = (rx.subjects.ReplaySubject.ReplaySizeBoundBuffer.Node) r7
                r8 = 0
                if (r7 != 0) goto L1f
                rx.subjects.ReplaySubject$ReplaySizeBoundBuffer$Node<T> r7 = r0.head
            L1f:
                r10 = r8
            L20:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L5d
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L2f
                r1.node = r13
                return
            L2f:
                boolean r14 = r0.done
                java.lang.Object r15 = r7.get()
                rx.subjects.ReplaySubject$ReplaySizeBoundBuffer$Node r15 = (rx.subjects.ReplaySubject.ReplaySizeBoundBuffer.Node) r15
                if (r15 != 0) goto L3c
                r16 = 1
                goto L3e
            L3c:
                r16 = 0
            L3e:
                if (r14 == 0) goto L50
                if (r16 == 0) goto L50
                r1.node = r13
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L4c
                r2.onError(r1)
                goto L4f
            L4c:
                r2.onCompleted()
            L4f:
                return
            L50:
                if (r16 == 0) goto L53
                goto L5d
            L53:
                T r7 = r15.value
                r2.onNext(r7)
                r12 = 1
                long r10 = r10 + r12
                r7 = r15
                goto L20
            L5d:
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 != 0) goto L85
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L6a
                r1.node = r13
                return
            L6a:
                boolean r14 = r0.done
                java.lang.Object r15 = r7.get()
                if (r15 != 0) goto L73
                r12 = 1
            L73:
                if (r14 == 0) goto L85
                if (r12 == 0) goto L85
                r1.node = r13
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L81
                r2.onError(r1)
                goto L84
            L81:
                r2.onCompleted()
            L84:
                return
            L85:
                int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r12 == 0) goto L97
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L97
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                rx.internal.operators.BackpressureUtils.produced(r5, r10)
            L97:
                r1.node = r7
                int r4 = -r4
                int r4 = r1.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.ReplaySubject.ReplaySizeBoundBuffer.drain(rx.subjects.ReplaySubject$ReplayProducer):void");
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th) {
            this.error = th;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return this.head.get() == null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = node.get();
                if (node2 == null) {
                    return node.value;
                }
                node = node2;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t) {
            Node<T> node = new Node<>(t);
            this.tail.set(node);
            this.tail = node;
            int i2 = this.size;
            if (i2 == this.limit) {
                this.head = this.head.get();
            } else {
                this.size = i2 + 1;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            Node<T> node = this.head.get();
            int i2 = 0;
            while (node != null && i2 != Integer.MAX_VALUE) {
                node = node.get();
                i2++;
            }
            return i2;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (Node<T> node = this.head.get(); node != null; node = node.get()) {
                arrayList.add(node.value);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }
    }

    public static <T> ReplaySubject<T> create(int i2) {
        if (i2 > 0) {
            return new ReplaySubject<>(new ReplayState(new ReplayUnboundedBuffer(i2)));
        }
        throw new IllegalArgumentException("capacity > 0 required but it was " + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    public static final class ReplaySizeAndTimeBoundBuffer<T> implements ReplayBuffer<T> {
        public volatile boolean done;
        public Throwable error;
        public volatile TimedNode<T> head;
        public final int limit;
        public final long maxAgeMillis;
        public final Scheduler scheduler;
        public int size;
        public TimedNode<T> tail;

        public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            public final long timestamp;
            public final T value;

            public TimedNode(T t, long j) {
                this.value = t;
                this.timestamp = j;
            }
        }

        public ReplaySizeAndTimeBoundBuffer(int i2, long j, Scheduler scheduler) {
            this.limit = i2;
            TimedNode<T> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
            this.maxAgeMillis = j;
            this.scheduler = scheduler;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            evictFinal();
            this.done = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
        
            if (r10 != r5) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        
            if (r2.isUnsubscribed() == false) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
        
            r18.node = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006c, code lost:
        
            r14 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
        
            if (r7.get() != null) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0074, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
        
            if (r14 == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
        
            if (r12 == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
        
            r18.node = null;
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007d, code lost:
        
            if (r1 == null) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
        
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0086, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
        
            if (r10 == 0) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
        
            if (r5 == Long.MAX_VALUE) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0094, code lost:
        
            rx.internal.operators.BackpressureUtils.produced(r18.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
        
            r18.node = r7;
            r4 = r18.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:?, code lost:
        
            return;
         */
        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain(rx.subjects.ReplaySubject.ReplayProducer<T> r18) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                int r2 = r18.getAndIncrement()
                if (r2 == 0) goto Lb
                return
            Lb:
                rx.Subscriber<? super T> r2 = r1.actual
                r3 = 1
                r4 = 1
            Lf:
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                long r5 = r5.get()
                java.lang.Object r7 = r1.node
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode r7 = (rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.TimedNode) r7
                r8 = 0
                if (r7 != 0) goto L21
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode r7 = r17.latestHead()
            L21:
                r10 = r8
            L22:
                r12 = 0
                r13 = 0
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 == 0) goto L5f
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L31
                r1.node = r13
                return
            L31:
                boolean r14 = r0.done
                java.lang.Object r15 = r7.get()
                rx.subjects.ReplaySubject$ReplaySizeAndTimeBoundBuffer$TimedNode r15 = (rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.TimedNode) r15
                if (r15 != 0) goto L3e
                r16 = 1
                goto L40
            L3e:
                r16 = 0
            L40:
                if (r14 == 0) goto L52
                if (r16 == 0) goto L52
                r1.node = r13
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L4e
                r2.onError(r1)
                goto L51
            L4e:
                r2.onCompleted()
            L51:
                return
            L52:
                if (r16 == 0) goto L55
                goto L5f
            L55:
                T r7 = r15.value
                r2.onNext(r7)
                r12 = 1
                long r10 = r10 + r12
                r7 = r15
                goto L22
            L5f:
                int r14 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
                if (r14 != 0) goto L87
                boolean r14 = r2.isUnsubscribed()
                if (r14 == 0) goto L6c
                r1.node = r13
                return
            L6c:
                boolean r14 = r0.done
                java.lang.Object r15 = r7.get()
                if (r15 != 0) goto L75
                r12 = 1
            L75:
                if (r14 == 0) goto L87
                if (r12 == 0) goto L87
                r1.node = r13
                java.lang.Throwable r1 = r0.error
                if (r1 == 0) goto L83
                r2.onError(r1)
                goto L86
            L83:
                r2.onCompleted()
            L86:
                return
            L87:
                int r12 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
                if (r12 == 0) goto L99
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r12 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r12 == 0) goto L99
                java.util.concurrent.atomic.AtomicLong r5 = r1.requested
                rx.internal.operators.BackpressureUtils.produced(r5, r10)
            L99:
                r1.node = r7
                int r4 = -r4
                int r4 = r1.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.subjects.ReplaySubject.ReplaySizeAndTimeBoundBuffer.drain(rx.subjects.ReplaySubject$ReplayProducer):void");
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th) {
            evictFinal();
            this.error = th;
            this.done = true;
        }

        public void evictFinal() {
            long jNow = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> timedNode = this.head;
            TimedNode<T> timedNode2 = timedNode;
            while (true) {
                TimedNode<T> timedNode3 = timedNode2.get();
                if (timedNode3 == null || timedNode3.timestamp > jNow) {
                    break;
                } else {
                    timedNode2 = timedNode3;
                }
            }
            if (timedNode != timedNode2) {
                this.head = timedNode2;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return latestHead().get() == null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            TimedNode<T> timedNodeLatestHead = latestHead();
            while (true) {
                TimedNode<T> timedNode = timedNodeLatestHead.get();
                if (timedNode == null) {
                    return timedNodeLatestHead.value;
                }
                timedNodeLatestHead = timedNode;
            }
        }

        public TimedNode<T> latestHead() {
            long jNow = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null || timedNode2.timestamp > jNow) {
                    break;
                }
                timedNode = timedNode2;
            }
            return timedNode;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t) {
            TimedNode<T> timedNode;
            long jNow = this.scheduler.now();
            TimedNode<T> timedNode2 = new TimedNode<>(t, jNow);
            this.tail.set(timedNode2);
            this.tail = timedNode2;
            long j = jNow - this.maxAgeMillis;
            int i2 = this.size;
            TimedNode<T> timedNode3 = this.head;
            if (i2 == this.limit) {
                timedNode = timedNode3.get();
            } else {
                i2++;
                timedNode = timedNode3;
            }
            while (true) {
                TimedNode<T> timedNode4 = timedNode.get();
                if (timedNode4 == null || timedNode4.timestamp > j) {
                    break;
                }
                i2--;
                timedNode = timedNode4;
            }
            this.size = i2;
            if (timedNode != timedNode3) {
                this.head = timedNode;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            TimedNode<T> timedNode = latestHead().get();
            int i2 = 0;
            while (timedNode != null && i2 != Integer.MAX_VALUE) {
                timedNode = timedNode.get();
                i2++;
            }
            return i2;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (TimedNode<T> timedNode = latestHead().get(); timedNode != null; timedNode = timedNode.get()) {
                arrayList.add(timedNode.value);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }
    }

    public static final class ReplayUnboundedBuffer<T> implements ReplayBuffer<T> {
        public final int capacity;
        public volatile boolean done;
        public Throwable error;
        public final Object[] head;
        public volatile int size;
        public Object[] tail;
        public int tailIndex;

        public ReplayUnboundedBuffer(int i2) {
            this.capacity = i2;
            Object[] objArr = new Object[i2 + 1];
            this.head = objArr;
            this.tail = objArr;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> replayProducer) {
            if (replayProducer.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replayProducer.actual;
            int i2 = this.capacity;
            int iAddAndGet = 1;
            do {
                long j = replayProducer.requested.get();
                Object[] objArr = (Object[]) replayProducer.node;
                if (objArr == null) {
                    objArr = this.head;
                }
                int i3 = replayProducer.tailIndex;
                int i4 = replayProducer.index;
                long j2 = 0;
                while (j2 != j) {
                    if (subscriber.isUnsubscribed()) {
                        replayProducer.node = null;
                        return;
                    }
                    boolean z = this.done;
                    boolean z2 = i4 == this.size;
                    if (z && z2) {
                        replayProducer.node = null;
                        Throwable th = this.error;
                        if (th != null) {
                            subscriber.onError(th);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    if (i3 == i2) {
                        objArr = (Object[]) objArr[i3];
                        i3 = 0;
                    }
                    subscriber.onNext(objArr[i3]);
                    j2++;
                    i3++;
                    i4++;
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        replayProducer.node = null;
                        return;
                    }
                    boolean z3 = this.done;
                    boolean z4 = i4 == this.size;
                    if (z3 && z4) {
                        replayProducer.node = null;
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    BackpressureUtils.produced(replayProducer.requested, j2);
                }
                replayProducer.index = i4;
                replayProducer.tailIndex = i3;
                replayProducer.node = objArr;
                iAddAndGet = replayProducer.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
            } else {
                this.error = th;
                this.done = true;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            return this.size == 0;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            int i2 = this.size;
            if (i2 == 0) {
                return null;
            }
            Object[] objArr = this.head;
            int i3 = this.capacity;
            while (i2 >= i3) {
                objArr = (Object[]) objArr[i3];
                i2 -= i3;
            }
            return (T) objArr[i2 - 1];
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t) {
            if (this.done) {
                return;
            }
            int i2 = this.tailIndex;
            Object[] objArr = this.tail;
            if (i2 == objArr.length - 1) {
                Object[] objArr2 = new Object[objArr.length];
                objArr2[0] = t;
                this.tailIndex = 1;
                objArr[i2] = objArr2;
                this.tail = objArr2;
            } else {
                objArr[i2] = t;
                this.tailIndex = i2 + 1;
            }
            this.size++;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            int i2 = this.size;
            if (tArr.length < i2) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
            }
            Object[] objArr = this.head;
            int i3 = this.capacity;
            int i4 = 0;
            while (true) {
                int i5 = i4 + i3;
                if (i5 >= i2) {
                    break;
                }
                System.arraycopy(objArr, 0, tArr, i4, i3);
                objArr = objArr[i3];
                i4 = i5;
            }
            System.arraycopy(objArr, 0, tArr, i4, i2 - i4);
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }
    }
}
