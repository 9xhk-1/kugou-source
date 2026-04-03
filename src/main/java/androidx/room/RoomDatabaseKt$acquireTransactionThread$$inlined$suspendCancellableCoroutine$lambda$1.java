package androidx.room;

import f.s;
import f.z.c.l;
import f.z.d.k;
import g.a.m1;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1 extends k implements l<Throwable, s> {
    public final /* synthetic */ m1 $controlJob$inlined;
    public final /* synthetic */ Executor $this_acquireTransactionThread$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1(Executor executor, m1 m1Var) {
        super(1);
        this.$this_acquireTransactionThread$inlined = executor;
        this.$controlJob$inlined = m1Var;
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ s invoke(Throwable th) {
        invoke2(th);
        return s.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        m1.a.b(this.$controlJob$inlined, null, 1, null);
    }
}
