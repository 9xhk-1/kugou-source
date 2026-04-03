package retrofit2;

import f.s;
import f.z.c.l;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends k implements l<Throwable, s> {
    public final /* synthetic */ Call $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    @Override // f.z.c.l
    public /* bridge */ /* synthetic */ s invoke(Throwable th) {
        invoke2(th);
        return s.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
