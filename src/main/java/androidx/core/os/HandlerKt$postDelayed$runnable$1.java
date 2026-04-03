package androidx.core.os;

import f.z.c.a;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    public final /* synthetic */ a $action;

    public HandlerKt$postDelayed$runnable$1(a aVar) {
        this.$action = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
