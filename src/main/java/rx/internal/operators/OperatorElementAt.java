package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class OperatorElementAt<T> implements Observable.Operator<T, T> {
    public final T defaultValue;
    public final boolean hasDefault;
    public final int index;

    public static class InnerProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 1;
        public final Producer actual;

        public InnerProducer(Producer producer) {
            this.actual = producer;
        }

        @Override // rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (j <= 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.request(Long.MAX_VALUE);
        }
    }

    public OperatorElementAt(int i2) {
        this(i2, null, false);
    }

    public OperatorElementAt(int i2, T t) {
        this(i2, t, true);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorElementAt.1
            private int currentIndex;

            @Override // rx.Observer
            public void onCompleted() {
                int i2 = this.currentIndex;
                OperatorElementAt operatorElementAt = OperatorElementAt.this;
                if (i2 <= operatorElementAt.index) {
                    if (operatorElementAt.hasDefault) {
                        subscriber.onNext(operatorElementAt.defaultValue);
                        subscriber.onCompleted();
                        return;
                    }
                    subscriber.onError(new IndexOutOfBoundsException(OperatorElementAt.this.index + " is out of bounds"));
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                subscriber.onError(th);
            }

            @Override // rx.Observer
            public void onNext(T t) {
                int i2 = this.currentIndex;
                this.currentIndex = i2 + 1;
                if (i2 == OperatorElementAt.this.index) {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                    unsubscribe();
                }
            }

            @Override // rx.Subscriber, rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                subscriber.setProducer(new InnerProducer(producer));
            }
        };
        subscriber.add(subscriber2);
        return subscriber2;
    }

    private OperatorElementAt(int i2, T t, boolean z) {
        if (i2 >= 0) {
            this.index = i2;
            this.defaultValue = t;
            this.hasDefault = z;
        } else {
            throw new IndexOutOfBoundsException(i2 + " is out of bounds");
        }
    }
}
