package androidx.room;

import f.j;
import f.s;
import f.w.e;
import f.w.g;
import f.w.i.b;
import f.w.i.c;
import f.w.j.a.d;
import f.w.j.a.f;
import f.w.j.a.h;
import f.z.c.l;
import f.z.c.p;
import f.z.d.j;
import f.z.d.k;
import g.a.g0;
import g.a.m1;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class RoomDatabaseKt {

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$1, reason: invalid class name */
    @f(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabase.kt", l = {99}, m = "createTransactionContext")
    public static final class AnonymousClass1 extends d {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(f.w.d dVar) {
            super(dVar);
        }

        @Override // f.w.j.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.createTransactionContext(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$2, reason: invalid class name */
    public static final class AnonymousClass2 extends k implements l<Throwable, s> {
        public final /* synthetic */ g.a.s $controlJob;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(g.a.s sVar) {
            super(1);
            this.$controlJob = sVar;
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ s invoke(Throwable th) {
            invoke2(th);
            return s.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            m1.a.b(this.$controlJob, null, 1, null);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$1, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabase.kt", l = {50, 51}, m = "withTransaction")
    public static final class C03201 extends d {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public C03201(f.w.d dVar) {
            super(dVar);
        }

        @Override // f.w.j.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.withTransaction(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$2, reason: invalid class name and case insensitive filesystem */
    @f(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabase.kt", l = {58}, m = "invokeSuspend")
    public static final class C03212<R> extends f.w.j.a.l implements p<g0, f.w.d<? super R>, Object> {
        public final /* synthetic */ l $block;
        public final /* synthetic */ RoomDatabase $this_withTransaction;
        public Object L$0;
        public Object L$1;
        public int label;
        private g0 p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03212(RoomDatabase roomDatabase, l lVar, f.w.d dVar) {
            super(2, dVar);
            this.$this_withTransaction = roomDatabase;
            this.$block = lVar;
        }

        @Override // f.w.j.a.a
        public final f.w.d<s> create(Object obj, f.w.d<?> dVar) {
            j.f(dVar, "completion");
            C03212 c03212 = new C03212(this.$this_withTransaction, this.$block, dVar);
            c03212.p$ = (g0) obj;
            return c03212;
        }

        @Override // f.z.c.p
        public final Object invoke(g0 g0Var, Object obj) {
            return ((C03212) create(g0Var, (f.w.d) obj)).invokeSuspend(s.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.w.j.a.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            TransactionElement transactionElement;
            TransactionElement transactionElement2;
            Object objD = c.d();
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    f.k.b(obj);
                    g0 g0Var = this.p$;
                    g.b bVar = g0Var.getCoroutineContext().get(TransactionElement.Key);
                    if (bVar == null) {
                        j.n();
                        throw null;
                    }
                    transactionElement = (TransactionElement) bVar;
                    transactionElement.acquire();
                    try {
                        this.$this_withTransaction.beginTransaction();
                        try {
                            l lVar = this.$block;
                            this.L$0 = g0Var;
                            this.L$1 = transactionElement;
                            this.label = 1;
                            obj = lVar.invoke(this);
                            if (obj == objD) {
                                return objD;
                            }
                            transactionElement2 = transactionElement;
                        } catch (Throwable th) {
                            th = th;
                            this.$this_withTransaction.endTransaction();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        transactionElement.release();
                        throw th;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    TransactionElement transactionElement3 = (TransactionElement) this.L$1;
                    try {
                        f.k.b(obj);
                        transactionElement2 = transactionElement3;
                    } catch (Throwable th3) {
                        th = th3;
                        this.$this_withTransaction.endTransaction();
                        throw th;
                    }
                }
                this.$this_withTransaction.setTransactionSuccessful();
                this.$this_withTransaction.endTransaction();
                transactionElement2.release();
                return obj;
            } catch (Throwable th4) {
                th = th4;
                transactionElement = objD;
            }
        }
    }

    public static final /* synthetic */ Object acquireTransactionThread(final Executor executor, final m1 m1Var, f.w.d<? super e> dVar) {
        final g.a.k kVar = new g.a.k(b.c(dVar), 1);
        kVar.invokeOnCancellation(new RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$1(executor, m1Var));
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends f.w.j.a.l implements p<g0, f.w.d<? super s>, Object> {
                    public Object L$0;
                    public int label;
                    private g0 p$;

                    public AnonymousClass1(f.w.d dVar) {
                        super(2, dVar);
                    }

                    @Override // f.w.j.a.a
                    public final f.w.d<s> create(Object obj, f.w.d<?> dVar) {
                        j.f(dVar, "completion");
                        AnonymousClass1 anonymousClass1 = RoomDatabaseKt$acquireTransactionThread$$inlined$suspendCancellableCoroutine$lambda$2.this.new AnonymousClass1(dVar);
                        anonymousClass1.p$ = (g0) obj;
                        return anonymousClass1;
                    }

                    @Override // f.z.c.p
                    public final Object invoke(g0 g0Var, f.w.d<? super s> dVar) {
                        return ((AnonymousClass1) create(g0Var, dVar)).invokeSuspend(s.a);
                    }

                    @Override // f.w.j.a.a
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        Object objD = c.d();
                        int i2 = this.label;
                        if (i2 == 0) {
                            f.k.b(obj);
                            g0 g0Var = this.p$;
                            g.a.j jVar = kVar;
                            g.b bVar = g0Var.getCoroutineContext().get(e.c);
                            if (bVar == null) {
                                j.n();
                                throw null;
                            }
                            j.a aVar = f.j.a;
                            f.j.a(bVar);
                            jVar.resumeWith(bVar);
                            m1 m1Var = m1Var;
                            this.L$0 = g0Var;
                            this.label = 1;
                            if (m1Var.join(this) == objD) {
                                return objD;
                            }
                        } else {
                            if (i2 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            f.k.b(obj);
                        }
                        return s.a;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    g.a.f.b(null, new AnonymousClass1(null), 1, null);
                }
            });
        } catch (RejectedExecutionException e2) {
            kVar.cancel(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e2));
        }
        Object objL = kVar.l();
        if (objL == c.d()) {
            h.c(dVar);
        }
        return objL;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.Object createTransactionContext(androidx.room.RoomDatabase r6, f.w.d<? super f.w.g> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = (androidx.room.RoomDatabaseKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt$createTransactionContext$1 r0 = new androidx.room.RoomDatabaseKt$createTransactionContext$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f.w.i.c.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            g.a.s r6 = (g.a.s) r6
            java.lang.Object r0 = r0.L$0
            androidx.room.RoomDatabase r0 = (androidx.room.RoomDatabase) r0
            f.k.b(r7)
            goto L71
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            f.k.b(r7)
            r7 = 0
            g.a.s r7 = g.a.q1.b(r7, r3, r7)
            f.w.g r2 = r0.getContext()
            g.a.m1$b r4 = g.a.m1.f1605g
            f.w.g$b r2 = r2.get(r4)
            g.a.m1 r2 = (g.a.m1) r2
            if (r2 == 0) goto L57
            androidx.room.RoomDatabaseKt$createTransactionContext$2 r4 = new androidx.room.RoomDatabaseKt$createTransactionContext$2
            r4.<init>(r7)
            r2.invokeOnCompletion(r4)
        L57:
            java.util.concurrent.Executor r2 = r6.getTransactionExecutor()
            java.lang.String r4 = "transactionExecutor"
            f.z.d.j.b(r2, r4)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = acquireTransactionThread(r2, r7, r0)
            if (r0 != r1) goto L6d
            return r1
        L6d:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L71:
            f.w.e r7 = (f.w.e) r7
            androidx.room.TransactionElement r1 = new androidx.room.TransactionElement
            r1.<init>(r6, r7)
            java.lang.ThreadLocal r0 = r0.getSuspendingTransactionId()
            java.lang.String r2 = "suspendingTransactionId"
            f.z.d.j.b(r0, r2)
            int r6 = java.lang.System.identityHashCode(r6)
            java.lang.Integer r6 = f.w.j.a.b.b(r6)
            g.a.d2 r6 = g.a.e2.a(r0, r6)
            f.w.g r7 = r7.plus(r1)
            f.w.g r6 = r7.plus(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.createTransactionContext(androidx.room.RoomDatabase, f.w.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089 A[PHI: r7
  0x0089: PHI (r7v11 java.lang.Object) = (r7v8 java.lang.Object), (r7v1 java.lang.Object) binds: [B:26:0x0086, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object withTransaction(androidx.room.RoomDatabase r5, f.z.c.l<? super f.w.d<? super R>, ? extends java.lang.Object> r6, f.w.d<? super R> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.room.RoomDatabaseKt.C03201
            if (r0 == 0) goto L13
            r0 = r7
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = (androidx.room.RoomDatabaseKt.C03201) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomDatabaseKt$withTransaction$1 r0 = new androidx.room.RoomDatabaseKt$withTransaction$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f.w.i.c.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r5 = r0.L$2
            f.w.g r5 = (f.w.g) r5
            java.lang.Object r5 = r0.L$1
            f.z.c.l r5 = (f.z.c.l) r5
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            f.k.b(r7)
            goto L89
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            f.z.c.l r6 = (f.z.c.l) r6
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            f.k.b(r7)
            goto L72
        L4d:
            f.k.b(r7)
            f.w.g r7 = r0.getContext()
            androidx.room.TransactionElement$Key r2 = androidx.room.TransactionElement.Key
            f.w.g$b r7 = r7.get(r2)
            androidx.room.TransactionElement r7 = (androidx.room.TransactionElement) r7
            if (r7 == 0) goto L65
            f.w.e r7 = r7.getTransactionDispatcher$room_ktx_release()
            if (r7 == 0) goto L65
            goto L74
        L65:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = createTransactionContext(r5, r0)
            if (r7 != r1) goto L72
            return r1
        L72:
            f.w.g r7 = (f.w.g) r7
        L74:
            androidx.room.RoomDatabaseKt$withTransaction$2 r2 = new androidx.room.RoomDatabaseKt$withTransaction$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r7 = g.a.e.c(r7, r2, r0)
            if (r7 != r1) goto L89
            return r1
        L89:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabaseKt.withTransaction(androidx.room.RoomDatabase, f.z.c.l, f.w.d):java.lang.Object");
    }
}
