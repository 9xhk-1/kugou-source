package androidx.room;

import androidx.room.InvalidationTracker;
import f.k;
import f.s;
import f.w.d;
import f.w.g;
import f.w.i.c;
import f.w.j.a.f;
import f.w.j.a.l;
import f.z.c.p;
import f.z.d.j;
import g.a.b0;
import g.a.g0;
import g.a.l2.e;
import g.a.m2.b;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", l = {75}, m = "invokeSuspend")
public final class CoroutinesRoom$Companion$createFlow$1<R> extends l implements p<b<? super R>, d<? super s>, Object> {
    public final /* synthetic */ Callable $callable;
    public final /* synthetic */ RoomDatabase $db;
    public final /* synthetic */ boolean $inTransaction;
    public final /* synthetic */ String[] $tableNames;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public int label;
    private b p$;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    @f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", l = {80, 82}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements p<g0, d<? super s>, Object> {
        public final /* synthetic */ g $flowContext;
        public final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$observer$1 $observer;
        public final /* synthetic */ e $observerChannel;
        public final /* synthetic */ b $this_flow;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        private g0 p$;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        @f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", l = {82}, m = "invokeSuspend")
        public static final class C00041 extends l implements p<g0, d<? super s>, Object> {
            public final /* synthetic */ Object $result;
            public Object L$0;
            public int label;
            private g0 p$;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00041(Object obj, d dVar) {
                super(2, dVar);
                this.$result = obj;
            }

            @Override // f.w.j.a.a
            public final d<s> create(Object obj, d<?> dVar) {
                j.f(dVar, "completion");
                C00041 c00041 = AnonymousClass1.this.new C00041(this.$result, dVar);
                c00041.p$ = (g0) obj;
                return c00041;
            }

            @Override // f.z.c.p
            public final Object invoke(g0 g0Var, d<? super s> dVar) {
                return ((C00041) create(g0Var, dVar)).invokeSuspend(s.a);
            }

            @Override // f.w.j.a.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objD = c.d();
                int i2 = this.label;
                if (i2 == 0) {
                    k.b(obj);
                    g0 g0Var = this.p$;
                    b bVar = AnonymousClass1.this.$this_flow;
                    Object obj2 = this.$result;
                    this.L$0 = g0Var;
                    this.label = 1;
                    if (bVar.emit(obj2, this) == objD) {
                        return objD;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
                return s.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(b bVar, CoroutinesRoom$Companion$createFlow$1$observer$1 coroutinesRoom$Companion$createFlow$1$observer$1, e eVar, g gVar, d dVar) {
            super(2, dVar);
            this.$this_flow = bVar;
            this.$observer = coroutinesRoom$Companion$createFlow$1$observer$1;
            this.$observerChannel = eVar;
            this.$flowContext = gVar;
        }

        @Override // f.w.j.a.a
        public final d<s> create(Object obj, d<?> dVar) {
            j.f(dVar, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_flow, this.$observer, this.$observerChannel, this.$flowContext, dVar);
            anonymousClass1.p$ = (g0) obj;
            return anonymousClass1;
        }

        @Override // f.z.c.p
        public final Object invoke(g0 g0Var, d<? super s> dVar) {
            return ((AnonymousClass1) create(g0Var, dVar)).invokeSuspend(s.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[Catch: all -> 0x009f, TRY_LEAVE, TryCatch #1 {all -> 0x009f, blocks: (B:17:0x004e, B:21:0x005e, B:23:0x0066), top: B:37:0x004e }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x008d -> B:37:0x004e). Please report as a decompilation issue!!! */
        @Override // f.w.j.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                r11 = this;
                java.lang.Object r0 = f.w.i.c.d()
                int r1 = r11.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L35
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r11.L$2
                g.a.l2.f r1 = (g.a.l2.f) r1
                java.lang.Object r4 = r11.L$1
                f.s r4 = (f.s) r4
                java.lang.Object r4 = r11.L$0
                g.a.g0 r4 = (g.a.g0) r4
                f.k.b(r12)     // Catch: java.lang.Throwable -> La1
                r12 = r4
                goto L4d
            L1f:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L27:
                java.lang.Object r1 = r11.L$1
                g.a.l2.f r1 = (g.a.l2.f) r1
                java.lang.Object r4 = r11.L$0
                g.a.g0 r4 = (g.a.g0) r4
                f.k.b(r12)     // Catch: java.lang.Throwable -> La1
                r5 = r4
                r4 = r11
                goto L5e
            L35:
                f.k.b(r12)
                g.a.g0 r12 = r11.p$
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r1 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r1 = r1.$db
                androidx.room.InvalidationTracker r1 = r1.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r4 = r11.$observer
                r1.addObserver(r4)
                g.a.l2.e r1 = r11.$observerChannel     // Catch: java.lang.Throwable -> La1
                g.a.l2.f r1 = r1.iterator()     // Catch: java.lang.Throwable -> La1
            L4d:
                r4 = r11
            L4e:
                r4.L$0 = r12     // Catch: java.lang.Throwable -> L9f
                r4.L$1 = r1     // Catch: java.lang.Throwable -> L9f
                r4.label = r3     // Catch: java.lang.Throwable -> L9f
                java.lang.Object r5 = r1.hasNext(r4)     // Catch: java.lang.Throwable -> L9f
                if (r5 != r0) goto L5b
                return r0
            L5b:
                r10 = r5
                r5 = r12
                r12 = r10
            L5e:
                java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Throwable -> L9f
                boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L9f
                if (r12 == 0) goto L8f
                java.lang.Object r12 = r1.next()     // Catch: java.lang.Throwable -> L9f
                f.s r12 = (f.s) r12     // Catch: java.lang.Throwable -> L9f
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r6 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this     // Catch: java.lang.Throwable -> L9f
                java.util.concurrent.Callable r6 = r6.$callable     // Catch: java.lang.Throwable -> L9f
                java.lang.Object r6 = r6.call()     // Catch: java.lang.Throwable -> L9f
                f.w.g r7 = r4.$flowContext     // Catch: java.lang.Throwable -> L9f
                androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1 r8 = new androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1     // Catch: java.lang.Throwable -> L9f
                r9 = 0
                r8.<init>(r6, r9)     // Catch: java.lang.Throwable -> L9f
                r4.L$0 = r5     // Catch: java.lang.Throwable -> L9f
                r4.L$1 = r12     // Catch: java.lang.Throwable -> L9f
                r4.L$2 = r1     // Catch: java.lang.Throwable -> L9f
                r4.L$3 = r6     // Catch: java.lang.Throwable -> L9f
                r4.label = r2     // Catch: java.lang.Throwable -> L9f
                java.lang.Object r12 = g.a.e.c(r7, r8, r4)     // Catch: java.lang.Throwable -> L9f
                if (r12 != r0) goto L8d
                return r0
            L8d:
                r12 = r5
                goto L4e
            L8f:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r12 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r12 = r12.$db
                androidx.room.InvalidationTracker r12 = r12.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r0 = r4.$observer
                r12.removeObserver(r0)
                f.s r12 = f.s.a
                return r12
            L9f:
                r12 = move-exception
                goto La3
            La1:
                r12 = move-exception
                r4 = r11
            La3:
                androidx.room.CoroutinesRoom$Companion$createFlow$1 r0 = androidx.room.CoroutinesRoom$Companion$createFlow$1.this
                androidx.room.RoomDatabase r0 = r0.$db
                androidx.room.InvalidationTracker r0 = r0.getInvalidationTracker()
                androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1 r1 = r4.$observer
                r0.removeObserver(r1)
                goto Lb2
            Lb1:
                throw r12
            Lb2:
                goto Lb1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom$Companion$createFlow$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$createFlow$1(String[] strArr, boolean z, RoomDatabase roomDatabase, Callable callable, d dVar) {
        super(2, dVar);
        this.$tableNames = strArr;
        this.$inTransaction = z;
        this.$db = roomDatabase;
        this.$callable = callable;
    }

    @Override // f.w.j.a.a
    public final d<s> create(Object obj, d<?> dVar) {
        j.f(dVar, "completion");
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$tableNames, this.$inTransaction, this.$db, this.$callable, dVar);
        coroutinesRoom$Companion$createFlow$1.p$ = (b) obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // f.z.c.p
    public final Object invoke(Object obj, d<? super s> dVar) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(obj, dVar)).invokeSuspend(s.a);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1, java.lang.Object] */
    @Override // f.w.j.a.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objD = c.d();
        int i2 = this.label;
        if (i2 == 0) {
            k.b(obj);
            b bVar = this.p$;
            final e eVarA = g.a.l2.g.a(-1);
            final String[] strArr = this.$tableNames;
            ?? r10 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.CoroutinesRoom$Companion$createFlow$1$observer$1
                @Override // androidx.room.InvalidationTracker.Observer
                public void onInvalidated(Set<String> set) {
                    j.f(set, "tables");
                    eVarA.offer(s.a);
                }
            };
            eVarA.offer(s.a);
            g context = getContext();
            b0 transactionDispatcher = this.$inTransaction ? CoroutinesRoomKt.getTransactionDispatcher(this.$db) : CoroutinesRoomKt.getQueryDispatcher(this.$db);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(bVar, r10, eVarA, context, null);
            this.L$0 = bVar;
            this.L$1 = eVarA;
            this.L$2 = r10;
            this.L$3 = context;
            this.L$4 = transactionDispatcher;
            this.label = 1;
            if (g.a.e.c(transactionDispatcher, anonymousClass1, this) == objD) {
                return objD;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b(obj);
        }
        return s.a;
    }
}
