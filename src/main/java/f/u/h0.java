package f.u;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @f.w.j.a.f(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
    public static final class a<T> extends f.w.j.a.k implements f.z.c.p<f.d0.d<? super List<? extends T>>, f.w.d<? super f.s>, Object> {
        public /* synthetic */ Object b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f1535d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f1536f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1537h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1538i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ Iterator l;
        public final /* synthetic */ boolean m;
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2, int i3, Iterator it, boolean z, boolean z2, f.w.d dVar) {
            super(2, dVar);
            this.j = i2;
            this.k = i3;
            this.l = it;
            this.m = z;
            this.n = z2;
        }

        @Override // f.w.j.a.a
        public final f.w.d<f.s> create(Object obj, f.w.d<?> dVar) {
            f.z.d.j.e(dVar, "completion");
            a aVar = new a(this.j, this.k, this.l, this.m, this.n, dVar);
            aVar.b = obj;
            return aVar;
        }

        @Override // f.z.c.p
        public final Object invoke(Object obj, f.w.d<? super f.s> dVar) {
            return ((a) create(obj, dVar)).invokeSuspend(f.s.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v20, types: [f.u.a, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r1v21, types: [f.u.e0] */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5, types: [f.d0.d, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v17 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v3, types: [f.u.a, f.u.e0, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5, types: [f.u.e0] */
        /* JADX WARN: Type inference failed for: r5v6, types: [f.u.e0] */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v8, types: [f.d0.d, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please report as a decompilation issue!!! */
        @Override // f.w.j.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 363
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: f.u.h0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final void a(int i2, int i3) {
        String str;
        if (i2 > 0 && i3 > 0) {
            return;
        }
        if (i2 != i3) {
            str = "Both size " + i2 + " and step " + i3 + " must be greater than zero.";
        } else {
            str = "size " + i2 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final <T> Iterator<List<T>> b(Iterator<? extends T> it, int i2, int i3, boolean z, boolean z2) {
        f.z.d.j.e(it, "iterator");
        return !it.hasNext() ? v.a : f.d0.e.a(new a(i2, i3, it, z2, z, null));
    }
}
