package g.a.n2;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> {
    public Object[] a = new Object[16];
    public int b;
    public int c;

    public final void a(T t) {
        f.z.d.j.f(t, "element");
        Object[] objArr = this.a;
        int i2 = this.c;
        objArr[i2] = t;
        int length = (objArr.length - 1) & (i2 + 1);
        this.c = length;
        if (length == this.b) {
            b();
        }
    }

    public final void b() {
        Object[] objArr = this.a;
        int length = objArr.length;
        Object[] objArr2 = new Object[length << 1];
        f.u.h.c(objArr, objArr2, 0, this.b, 0, 10, null);
        Object[] objArr3 = this.a;
        int length2 = objArr3.length;
        int i2 = this.b;
        f.u.h.c(objArr3, objArr2, length2 - i2, 0, i2, 4, null);
        this.a = objArr2;
        this.b = 0;
        this.c = length;
    }

    public final boolean c() {
        return this.b == this.c;
    }

    public final T d() {
        int i2 = this.b;
        if (i2 == this.c) {
            return null;
        }
        Object[] objArr = this.a;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.b = (i2 + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new f.p("null cannot be cast to non-null type T");
    }
}
