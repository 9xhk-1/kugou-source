package com.tme.fireeye.lib.base.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import e.f.a.b.a.i.c;

/* JADX INFO: loaded from: classes.dex */
public final class AutoReleaseObserverWrapper extends c implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        b().c(a());
    }
}
