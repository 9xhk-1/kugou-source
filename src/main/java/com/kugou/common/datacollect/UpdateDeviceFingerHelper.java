package com.kugou.common.datacollect;

import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.datacollect.senter.UpdateDeviceIdModel;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.u0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateDeviceFingerHelper {
    private static volatile UpdateDeviceFingerHelper sInstance;
    private Subscription refreshSub;
    private int requestState = 0;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int FAIL = 3;
        public static final int IDLE = 0;
        public static final int ONCE_UPDATE = 2;
        public static final int REQUESTING = 1;
    }

    private UpdateDeviceFingerHelper() {
    }

    public static UpdateDeviceFingerHelper getInstance() {
        if (sInstance == null) {
            synchronized (UpdateDeviceFingerHelper.class) {
                if (sInstance == null) {
                    sInstance = new UpdateDeviceFingerHelper();
                }
            }
        }
        return sInstance;
    }

    public void tryUpdate() {
        int i2 = this.requestState;
        if (i2 == 2 || i2 == 1 || !u0.n(KGApplication.getContext(), false)) {
            return;
        }
        this.requestState = 1;
        i1.a(this.refreshSub);
        this.refreshSub = Observable.just("").subscribeOn(Schedulers.io()).map(new Func1<String, String>() { // from class: com.kugou.common.datacollect.UpdateDeviceFingerHelper.3
            @Override // rx.functions.Func1
            public String call(String str) {
                UpdateDeviceIdModel.init().getDeviceId();
                return str;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<String>() { // from class: com.kugou.common.datacollect.UpdateDeviceFingerHelper.1
            @Override // rx.functions.Action1
            public void call(String str) {
                if (UpdateDeviceIdModel.init().isPhoneIdsValid()) {
                    UpdateDeviceFingerHelper.this.requestState = 2;
                } else {
                    UpdateDeviceFingerHelper.this.requestState = 3;
                }
                UpdateDeviceFingerHelper.this.refreshSub = null;
            }
        }, new Action1<Throwable>() { // from class: com.kugou.common.datacollect.UpdateDeviceFingerHelper.2
            @Override // rx.functions.Action1
            public void call(Throwable th) {
                UpdateDeviceFingerHelper.this.requestState = 3;
                UpdateDeviceFingerHelper.this.refreshSub = null;
            }
        });
    }
}
