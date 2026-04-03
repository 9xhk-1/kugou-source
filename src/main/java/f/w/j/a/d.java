package f.w.j.a;

import f.w.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends a {
    private final f.w.g _context;
    private transient f.w.d<Object> intercepted;

    public d(f.w.d<Object> dVar, f.w.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // f.w.d
    public f.w.g getContext() {
        f.w.g gVar = this._context;
        f.z.d.j.c(gVar);
        return gVar;
    }

    public final f.w.d<Object> intercepted() {
        f.w.d<Object> dVarInterceptContinuation = this.intercepted;
        if (dVarInterceptContinuation == null) {
            f.w.e eVar = (f.w.e) getContext().get(f.w.e.c);
            if (eVar == null || (dVarInterceptContinuation = eVar.interceptContinuation(this)) == null) {
                dVarInterceptContinuation = this;
            }
            this.intercepted = dVarInterceptContinuation;
        }
        return dVarInterceptContinuation;
    }

    @Override // f.w.j.a.a
    public void releaseIntercepted() {
        f.w.d<?> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b bVar = getContext().get(f.w.e.c);
            f.z.d.j.c(bVar);
            ((f.w.e) bVar).releaseInterceptedContinuation(dVar);
        }
        this.intercepted = c.a;
    }

    public d(f.w.d<Object> dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
