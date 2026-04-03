package g.a.l2;

/* JADX INFO: loaded from: classes2.dex */
public interface f<E> {

    public static final class a {

        /* JADX INFO: renamed from: g.a.l2.f$a$a, reason: collision with other inner class name */
        @f.w.j.a.f(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", l = {461}, m = "next")
        public static final class C0273a extends f.w.j.a.d {
            public /* synthetic */ Object a;
            public int b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ f f1599d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Object f1600f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0273a(f fVar, f.w.d dVar) {
                super(dVar);
                this.f1599d = fVar;
            }

            @Override // f.w.j.a.a
            public final Object invokeSuspend(Object obj) {
                this.a = obj;
                this.b |= Integer.MIN_VALUE;
                return a.a(null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static /* synthetic */ <E> java.lang.Object a(g.a.l2.f<? extends E> r4, f.w.d<? super E> r5) throws java.lang.Throwable {
            /*
                boolean r0 = r5 instanceof g.a.l2.f.a.C0273a
                if (r0 == 0) goto L13
                r0 = r5
                g.a.l2.f$a$a r0 = (g.a.l2.f.a.C0273a) r0
                int r1 = r0.b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.b = r1
                goto L18
            L13:
                g.a.l2.f$a$a r0 = new g.a.l2.f$a$a
                r0.<init>(r4, r5)
            L18:
                java.lang.Object r5 = r0.a
                java.lang.Object r1 = f.w.i.c.d()
                int r2 = r0.b
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r4 = r0.f1600f
                g.a.l2.f r4 = (g.a.l2.f) r4
                f.k.b(r5)
                goto L43
            L2d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L35:
                f.k.b(r5)
                r0.f1600f = r4
                r0.b = r3
                java.lang.Object r5 = r4.hasNext(r0)
                if (r5 != r1) goto L43
                return r1
            L43:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L50
                java.lang.Object r4 = r4.next()
                return r4
            L50:
                g.a.l2.i r4 = new g.a.l2.i
                java.lang.String r5 = "Channel was closed"
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.l2.f.a.a(g.a.l2.f, f.w.d):java.lang.Object");
        }
    }

    Object hasNext(f.w.d<? super Boolean> dVar);

    E next();

    /* synthetic */ Object next(f.w.d<? super E> dVar);
}
