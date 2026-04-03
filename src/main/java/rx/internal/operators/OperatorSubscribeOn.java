package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public final class OperatorSubscribeOn<T> implements Observable.OnSubscribe<T> {
    public final Scheduler scheduler;
    public final Observable<T> source;

    /* JADX INFO: renamed from: rx.internal.operators.OperatorSubscribeOn$1, reason: invalid class name */
    public class AnonymousClass1 implements Action0 {
        public final /* synthetic */ Scheduler.Worker val$inner;
        public final /* synthetic */ Subscriber val$subscriber;

        public AnonymousClass1(Subscriber subscriber, Scheduler.Worker worker) {
            this.val$subscriber = subscriber;
            this.val$inner = worker;
        }

        @Override // rx.functions.Action0
        public void call() {
            final Thread threadCurrentThread = Thread.currentThread();
            OperatorSubscribeOn.this.source.unsafeSubscribe(new Subscriber<T>(this.val$subscriber) { // from class: rx.internal.operators.OperatorSubscribeOn.1.1
                @Override // rx.Observer
                public void onCompleted() {
                    try {
                        AnonymousClass1.this.val$subscriber.onCompleted();
                    } finally {
                        AnonymousClass1.this.val$inner.unsubscribe();
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th) {
                    try {
                        AnonymousClass1.this.val$subscriber.onError(th);
                    } finally {
                        AnonymousClass1.this.val$inner.unsubscribe();
                    }
                }

                @Override // rx.Observer
                public void onNext(T t) {
                    AnonymousClass1.this.val$subscriber.onNext(t);
                }

                @Override // rx.Subscriber, rx.observers.AssertableSubscriber
                public void setProducer(final Producer producer) {
                    AnonymousClass1.this.val$subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorSubscribeOn.1.1.1
                        @Override // rx.Producer
                        public void request(final long j) {
                            if (threadCurrentThread == Thread.currentThread()) {
                                producer.request(j);
                            } else {
                                AnonymousClass1.this.val$inner.schedule(new Action0() { // from class: rx.internal.operators.OperatorSubscribeOn.1.1.1.1
                                    @Override // rx.functions.Action0
                                    public void call() {
                                        producer.request(j);
                                    }
                                });
                            }
                        }
                    });
                }
            });
        }
    }

    public OperatorSubscribeOn(Observable<T> observable, Scheduler scheduler) {
        this.scheduler = scheduler;
        this.source = observable;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        Scheduler.Worker workerCreateWorker = this.scheduler.createWorker();
        subscriber.add(workerCreateWorker);
        workerCreateWorker.schedule(new AnonymousClass1(subscriber, workerCreateWorker));
    }
}
