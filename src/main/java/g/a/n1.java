package g.a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 extends CancellationException implements z<n1> {
    public final m1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(String str, Throwable th, m1 m1Var) {
        super(str);
        f.z.d.j.f(str, "message");
        f.z.d.j.f(m1Var, "job");
        this.a = m1Var;
        if (th != null) {
            initCause(th);
        }
    }

    @Override // g.a.z
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public n1 createCopy() {
        if (!k0.c()) {
            return null;
        }
        String message = getMessage();
        if (message != null) {
            return new n1(message, this, this.a);
        }
        f.z.d.j.n();
        throw null;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof n1) {
                n1 n1Var = (n1) obj;
                if (!f.z.d.j.a(n1Var.getMessage(), getMessage()) || !f.z.d.j.a(n1Var.a, this.a) || !f.z.d.j.a(n1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (!k0.c()) {
            return this;
        }
        Throwable thFillInStackTrace = super.fillInStackTrace();
        f.z.d.j.b(thFillInStackTrace, "super.fillInStackTrace()");
        return thFillInStackTrace;
    }

    public int hashCode() {
        String message = getMessage();
        if (message == null) {
            f.z.d.j.n();
            throw null;
        }
        int iHashCode = ((message.hashCode() * 31) + this.a.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.a;
    }
}
