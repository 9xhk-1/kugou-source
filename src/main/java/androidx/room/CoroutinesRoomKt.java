package androidx.room;

import f.p;
import f.z.d.j;
import g.a.b0;
import g.a.e1;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class CoroutinesRoomKt {
    public static final b0 getQueryDispatcher(RoomDatabase roomDatabase) {
        j.f(roomDatabase, "$this$queryDispatcher");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        j.b(backingFieldMap, "backingFieldMap");
        Object objA = backingFieldMap.get("QueryDispatcher");
        if (objA == null) {
            Executor queryExecutor = roomDatabase.getQueryExecutor();
            j.b(queryExecutor, "queryExecutor");
            objA = e1.a(queryExecutor);
            backingFieldMap.put("QueryDispatcher", objA);
        }
        if (objA != null) {
            return (b0) objA;
        }
        throw new p("null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
    }

    public static final b0 getTransactionDispatcher(RoomDatabase roomDatabase) {
        j.f(roomDatabase, "$this$transactionDispatcher");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        j.b(backingFieldMap, "backingFieldMap");
        Object objA = backingFieldMap.get("TransactionDispatcher");
        if (objA == null) {
            Executor transactionExecutor = roomDatabase.getTransactionExecutor();
            j.b(transactionExecutor, "transactionExecutor");
            objA = e1.a(transactionExecutor);
            backingFieldMap.put("TransactionDispatcher", objA);
        }
        if (objA != null) {
            return (b0) objA;
        }
        throw new p("null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
    }
}
