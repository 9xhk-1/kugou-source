package f.e0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements f.d0.b<f.b0.d> {
    public final CharSequence a;
    public final int b;
    public final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f.z.c.p<CharSequence, Integer, f.i<Integer, Integer>> f1516d;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
    public static final class a implements Iterator<f.b0.d> {
        public int a = -1;
        public int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1517d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public f.b0.d f1518f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1519h;

        public a() {
            int iH = f.b0.f.h(d.this.b, 0, d.this.a.length());
            this.b = iH;
            this.f1517d = iH;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void a() {
            /*
                r6 = this;
                int r0 = r6.f1517d
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.a = r1
                r0 = 0
                r6.f1518f = r0
                goto L9e
            Lc:
                f.e0.d r0 = f.e0.d.this
                int r0 = f.e0.d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f1519h
                int r0 = r0 + r3
                r6.f1519h = r0
                f.e0.d r4 = f.e0.d.this
                int r4 = f.e0.d.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f1517d
                f.e0.d r4 = f.e0.d.this
                java.lang.CharSequence r4 = f.e0.d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                int r0 = r6.b
                f.b0.d r1 = new f.b0.d
                f.e0.d r4 = f.e0.d.this
                java.lang.CharSequence r4 = f.e0.d.b(r4)
                int r4 = f.e0.o.y(r4)
                r1.<init>(r0, r4)
                r6.f1518f = r1
                r6.f1517d = r2
                goto L9c
            L47:
                f.e0.d r0 = f.e0.d.this
                f.z.c.p r0 = f.e0.d.a(r0)
                f.e0.d r4 = f.e0.d.this
                java.lang.CharSequence r4 = f.e0.d.b(r4)
                int r5 = r6.f1517d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                f.i r0 = (f.i) r0
                if (r0 != 0) goto L77
                int r0 = r6.b
                f.b0.d r1 = new f.b0.d
                f.e0.d r4 = f.e0.d.this
                java.lang.CharSequence r4 = f.e0.d.b(r4)
                int r4 = f.e0.o.y(r4)
                r1.<init>(r0, r4)
                r6.f1518f = r1
                r6.f1517d = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.b
                f.b0.d r4 = f.b0.f.j(r4, r2)
                r6.f1518f = r4
                int r2 = r2 + r0
                r6.b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.f1517d = r2
            L9c:
                r6.a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: f.e0.d.a.a():void");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f.b0.d next() {
            if (this.a == -1) {
                a();
            }
            if (this.a == 0) {
                throw new NoSuchElementException();
            }
            f.b0.d dVar = this.f1518f;
            Objects.requireNonNull(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f1518f = null;
            this.a = -1;
            return dVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i2, int i3, f.z.c.p<? super CharSequence, ? super Integer, f.i<Integer, Integer>> pVar) {
        f.z.d.j.e(charSequence, "input");
        f.z.d.j.e(pVar, "getNextMatch");
        this.a = charSequence;
        this.b = i2;
        this.c = i3;
        this.f1516d = pVar;
    }

    @Override // f.d0.b
    public Iterator<f.b0.d> iterator() {
        return new a();
    }
}
