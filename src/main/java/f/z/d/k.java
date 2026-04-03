package f.z.d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k<R> implements h<R>, Serializable {
    private final int arity;

    public k(int i2) {
        this.arity = i2;
    }

    @Override // f.z.d.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strE = s.e(this);
        j.d(strE, "Reflection.renderLambdaToString(this)");
        return strE;
    }
}
