package kotlinx.coroutines;

import f.w.g;
import f.z.c.p;

/* JADX INFO: loaded from: classes2.dex */
public interface CoroutineExceptionHandler extends g.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f1692e = a.a;

    public static final class a implements g.c<CoroutineExceptionHandler> {
        public static final /* synthetic */ a a = new a();
    }

    @Override // f.w.g.b, f.w.g
    /* synthetic */ <R> R fold(R r, p<? super R, ? super g.b, ? extends R> pVar);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ <E extends g.b> E get(g.c<E> cVar);

    @Override // f.w.g.b
    /* synthetic */ g.c<?> getKey();

    void handleException(g gVar, Throwable th);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ g minusKey(g.c<?> cVar);

    @Override // f.w.g.b, f.w.g
    /* synthetic */ g plus(g gVar);
}
