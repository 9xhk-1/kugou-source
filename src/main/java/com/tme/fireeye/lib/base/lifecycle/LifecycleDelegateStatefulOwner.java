package com.tme.fireeye.lib.base.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import e.f.a.b.a.i.e;

/* JADX INFO: loaded from: classes.dex */
public final class LifecycleDelegateStatefulOwner extends e implements LifecycleObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f277d;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onReceiveStart() {
        e();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onReceiveStop() {
        d();
    }

    public String toString() {
        return this.f277d.toString();
    }
}
