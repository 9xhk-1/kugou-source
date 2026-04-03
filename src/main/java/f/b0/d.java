package f.b0;

import f.z.d.g;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b implements f.b0.a<Integer> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f1513i = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f1512h = new d(1, 0);

    public static final class a {
        public a() {
        }

        public final d a() {
            return d.f1512h;
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public d(int i2, int i3) {
        super(i2, i3, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b0.a
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return f(((Number) comparable).intValue());
    }

    @Override // f.b0.b
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (a() != dVar.a() || b() != dVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i2) {
        return a() <= i2 && i2 <= b();
    }

    @Override // f.b0.a
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Integer getEndInclusive() {
        return Integer.valueOf(b());
    }

    @Override // f.b0.a
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Integer getStart() {
        return Integer.valueOf(a());
    }

    @Override // f.b0.b
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // f.b0.b, f.b0.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // f.b0.b
    public String toString() {
        return a() + ".." + b();
    }
}
