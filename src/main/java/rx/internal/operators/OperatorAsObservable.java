package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public final class OperatorAsObservable<T> implements Observable.Operator<T, T> {

    public static final class Holder {
        public static final OperatorAsObservable<Object> INSTANCE = new OperatorAsObservable<>();
    }

    public static <T> OperatorAsObservable<T> instance() {
        return (OperatorAsObservable<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return subscriber;
    }
}
