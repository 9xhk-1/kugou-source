package rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.observers.SerializedSubscriber;
import rx.plugins.RxJavaHooks;

/* JADX INFO: loaded from: classes2.dex */
public final class OperatorWithLatestFromMany<T, R> implements Observable.OnSubscribe<R> {
    public final FuncN<R> combiner;
    public final Observable<T> main;
    public final Observable<?>[] others;
    public final Iterable<Observable<?>> othersIterable;

    public static final class WithLatestMainSubscriber<T, R> extends Subscriber<T> {
        public static final Object EMPTY = new Object();
        public final Subscriber<? super R> actual;
        public final FuncN<R> combiner;
        public final AtomicReferenceArray<Object> current;
        public boolean done;
        public final AtomicInteger ready;

        public WithLatestMainSubscriber(Subscriber<? super R> subscriber, FuncN<R> funcN, int i2) {
            this.actual = subscriber;
            this.combiner = funcN;
            AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(i2 + 1);
            for (int i3 = 0; i3 <= i2; i3++) {
                atomicReferenceArray.lazySet(i3, EMPTY);
            }
            this.current = atomicReferenceArray;
            this.ready = new AtomicInteger(i2);
            request(0L);
        }

        public void innerComplete(int i2) {
            if (this.current.get(i2) == EMPTY) {
                onCompleted();
            }
        }

        public void innerError(int i2, Throwable th) {
            onError(th);
        }

        public void innerNext(int i2, Object obj) {
            if (this.current.getAndSet(i2, obj) == EMPTY) {
                this.ready.decrementAndGet();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            unsubscribe();
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaHooks.onError(th);
                return;
            }
            this.done = true;
            unsubscribe();
            this.actual.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.ready.get() != 0) {
                request(1L);
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.current;
            int length = atomicReferenceArray.length();
            atomicReferenceArray.lazySet(0, t);
            Object[] objArr = new Object[atomicReferenceArray.length()];
            for (int i2 = 0; i2 < length; i2++) {
                objArr[i2] = atomicReferenceArray.get(i2);
            }
            try {
                this.actual.onNext(this.combiner.call(objArr));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }

        @Override // rx.Subscriber, rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.actual.setProducer(producer);
        }
    }

    public static final class WithLatestOtherSubscriber extends Subscriber<Object> {
        public final int index;
        public final WithLatestMainSubscriber<?, ?> parent;

        public WithLatestOtherSubscriber(WithLatestMainSubscriber<?, ?> withLatestMainSubscriber, int i2) {
            this.parent = withLatestMainSubscriber;
            this.index = i2;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.parent.innerComplete(this.index);
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // rx.Observer
        public void onNext(Object obj) {
            this.parent.innerNext(this.index, obj);
        }
    }

    public OperatorWithLatestFromMany(Observable<T> observable, Observable<?>[] observableArr, Iterable<Observable<?>> iterable, FuncN<R> funcN) {
        this.main = observable;
        this.others = observableArr;
        this.othersIterable = iterable;
        this.combiner = funcN;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        int length;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Observable<?>[] observableArr = this.others;
        int i2 = 0;
        if (observableArr != null) {
            length = observableArr.length;
        } else {
            observableArr = new Observable[8];
            int i3 = 0;
            for (Observable<?> observable : this.othersIterable) {
                if (i3 == observableArr.length) {
                    observableArr = (Observable[]) Arrays.copyOf(observableArr, (i3 >> 2) + i3);
                }
                observableArr[i3] = observable;
                i3++;
            }
            length = i3;
        }
        WithLatestMainSubscriber withLatestMainSubscriber = new WithLatestMainSubscriber(subscriber, this.combiner, length);
        serializedSubscriber.add(withLatestMainSubscriber);
        while (i2 < length) {
            if (serializedSubscriber.isUnsubscribed()) {
                return;
            }
            int i4 = i2 + 1;
            WithLatestOtherSubscriber withLatestOtherSubscriber = new WithLatestOtherSubscriber(withLatestMainSubscriber, i4);
            withLatestMainSubscriber.add(withLatestOtherSubscriber);
            observableArr[i2].unsafeSubscribe(withLatestOtherSubscriber);
            i2 = i4;
        }
        this.main.unsafeSubscribe(withLatestMainSubscriber);
    }
}
