package f.w.j.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends a {
    public j(f.w.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == f.w.h.a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // f.w.d
    public f.w.g getContext() {
        return f.w.h.a;
    }
}
