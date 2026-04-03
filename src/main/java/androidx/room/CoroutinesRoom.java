package androidx.room;

import androidx.annotation.RestrictTo;
import f.w.d;
import f.w.e;
import f.z.d.g;
import f.z.d.j;
import g.a.m2.a;
import g.a.m2.c;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        private Companion() {
        }

        public final <R> a<R> createFlow(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<R> callable) {
            j.f(roomDatabase, "db");
            j.f(strArr, "tableNames");
            j.f(callable, "callable");
            return c.a(new CoroutinesRoom$Companion$createFlow$1(strArr, z, roomDatabase, callable, null));
        }

        public final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, d<? super R> dVar) {
            e transactionDispatcher;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) dVar.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                transactionDispatcher = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return g.a.e.c(transactionDispatcher, new CoroutinesRoom$Companion$execute$2(callable, null), dVar);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    private CoroutinesRoom() {
    }

    public static final <R> a<R> createFlow(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z, strArr, callable);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, d<? super R> dVar) {
        return Companion.execute(roomDatabase, z, callable, dVar);
    }
}
