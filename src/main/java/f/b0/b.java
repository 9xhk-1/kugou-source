package f.b0;

import f.u.z;
import f.z.d.g;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public class b implements Iterable<Integer> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f1508f = new a(null);
    public final int a;
    public final int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1509d;

    public static final class a {
        public a() {
        }

        public final b a(int i2, int i3, int i4) {
            return new b(i2, i3, i4);
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public b(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.a = i2;
        this.b = f.x.c.b(i2, i3, i4);
        this.f1509d = i4;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.f1509d;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public z iterator() {
        return new c(this.a, this.b, this.f1509d);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.a != bVar.a || this.b != bVar.b || this.f1509d != bVar.f1509d) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.f1509d;
    }

    public boolean isEmpty() {
        if (this.f1509d > 0) {
            if (this.a > this.b) {
                return true;
            }
        } else if (this.a < this.b) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f1509d > 0) {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i2 = this.f1509d;
        } else {
            sb = new StringBuilder();
            sb.append(this.a);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i2 = -this.f1509d;
        }
        sb.append(i2);
        return sb.toString();
    }
}
