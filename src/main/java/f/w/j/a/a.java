package f.w.j.a;

import f.j;
import f.s;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements f.w.d<Object>, e, Serializable {
    private final f.w.d<Object> completion;

    public a(f.w.d<Object> dVar) {
        this.completion = dVar;
    }

    public f.w.d<s> create(f.w.d<?> dVar) {
        f.z.d.j.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // f.w.j.a.e
    public e getCallerFrame() {
        f.w.d<Object> dVar = this.completion;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    public final f.w.d<Object> getCompletion() {
        return this.completion;
    }

    @Override // f.w.j.a.e
    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // f.w.d
    public final void resumeWith(Object obj) {
        a aVar = this;
        while (true) {
            h.b(aVar);
            f.w.d<Object> dVar = aVar.completion;
            f.z.d.j.c(dVar);
            try {
                obj = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                j.a aVar2 = f.j.a;
                obj = f.k.a(th);
                f.j.a(obj);
            }
            if (obj == f.w.i.c.d()) {
                return;
            }
            j.a aVar3 = f.j.a;
            f.j.a(obj);
            aVar.releaseIntercepted();
            if (!(dVar instanceof a)) {
                dVar.resumeWith(obj);
                return;
            }
            aVar = (a) dVar;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public f.w.d<s> create(Object obj, f.w.d<?> dVar) {
        f.z.d.j.e(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
