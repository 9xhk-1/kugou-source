package androidx.room;

import f.k;
import f.s;
import f.w.d;
import f.w.i.c;
import f.w.j.a.f;
import f.w.j.a.l;
import f.z.c.p;
import f.z.d.j;
import g.a.g0;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.kt", l = {}, m = "invokeSuspend")
public final class CoroutinesRoom$Companion$execute$2<R> extends l implements p<g0, d<? super R>, Object> {
    public final /* synthetic */ Callable $callable;
    public int label;
    private g0 p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$2(Callable callable, d dVar) {
        super(2, dVar);
        this.$callable = callable;
    }

    @Override // f.w.j.a.a
    public final d<s> create(Object obj, d<?> dVar) {
        j.f(dVar, "completion");
        CoroutinesRoom$Companion$execute$2 coroutinesRoom$Companion$execute$2 = new CoroutinesRoom$Companion$execute$2(this.$callable, dVar);
        coroutinesRoom$Companion$execute$2.p$ = (g0) obj;
        return coroutinesRoom$Companion$execute$2;
    }

    @Override // f.z.c.p
    public final Object invoke(g0 g0Var, Object obj) {
        return ((CoroutinesRoom$Companion$execute$2) create(g0Var, (d) obj)).invokeSuspend(s.a);
    }

    @Override // f.w.j.a.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        c.d();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        k.b(obj);
        return this.$callable.call();
    }
}
