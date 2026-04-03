package g.a.n2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final Method a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        a = method;
    }

    public static final <E> Set<E> a(int i2) {
        Set<E> setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(i2));
        f.z.d.j.b(setNewSetFromMap, "Collections.newSetFromMa…ityHashMap(expectedSize))");
        return setNewSetFromMap;
    }

    public static final boolean b(Executor executor) {
        Method method;
        f.z.d.j.f(executor, "executor");
        try {
            if (!(executor instanceof ScheduledExecutorService)) {
                executor = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executor;
            if (scheduledExecutorService == null || (method = a) == null) {
                return false;
            }
            method.invoke(scheduledExecutorService, Boolean.TRUE);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
