package f.w.j.a;

import f.z.d.s;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends j implements f.z.d.h<Object> {
    public final int a;

    public k(int i2, f.w.d<Object> dVar) {
        super(dVar);
        this.a = i2;
    }

    @Override // f.z.d.h
    public int getArity() {
        return this.a;
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
}
