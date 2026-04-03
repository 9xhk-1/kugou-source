package f.w.j.a;

import f.z.d.s;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends d implements f.z.d.h<Object> {
    private final int arity;

    public l(int i2, f.w.d<Object> dVar) {
        super(dVar);
        this.arity = i2;
    }

    @Override // f.z.d.h
    public int getArity() {
        return this.arity;
    }

    @Override // f.w.j.a.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strD = s.d(this);
        f.z.d.j.d(strD, "Reflection.renderLambdaToString(this)");
        return strD;
    }

    public l(int i2) {
        this(i2, null);
    }
}
