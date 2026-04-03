package g.a;

/* JADX INFO: loaded from: classes2.dex */
public interface j<T> extends f.w.d<T> {

    public static final class a {
        public static /* synthetic */ Object a(j jVar, Object obj, Object obj2, int i2, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i2 & 2) != 0) {
                obj2 = null;
            }
            return jVar.tryResume(obj, obj2);
        }
    }

    boolean cancel(Throwable th);

    void completeResume(Object obj);

    @Override // f.w.d
    /* synthetic */ f.w.g getContext();

    /* synthetic */ void initCancellability();

    void invokeOnCancellation(f.z.c.l<? super Throwable, f.s> lVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    void resume(T t, f.z.c.l<? super Throwable, f.s> lVar);

    void resumeUndispatched(b0 b0Var, T t);

    void resumeUndispatchedWithException(b0 b0Var, Throwable th);

    @Override // f.w.d
    /* synthetic */ void resumeWith(Object obj);

    Object tryResume(T t, Object obj);

    Object tryResumeWithException(Throwable th);
}
