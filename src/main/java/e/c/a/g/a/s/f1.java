package e.c.a.g.a.s;

/* JADX INFO: loaded from: classes.dex */
public class f1 {
    public final int a;
    public final int b;

    public f1(int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f1.class != obj.getClass()) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return this.a == f1Var.a && this.b == f1Var.b;
    }

    public int hashCode() {
        return (this.a * 31) + this.b;
    }

    public String toString() {
        return "Size{width=" + this.a + ", height=" + this.b + '}';
    }
}
