package kotlinx.coroutines.android;

import android.os.Build;
import android.support.annotation.Keep;
import f.c0.e;
import f.d;
import f.f;
import f.w.a;
import f.w.g;
import f.z.d.j;
import f.z.d.n;
import f.z.d.s;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler, f.z.c.a<Method> {
    public static final /* synthetic */ e[] $$delegatedProperties;
    private final d preHandler$delegate;

    static {
        n nVar = new n(s.a(AndroidExceptionPreHandler.class), "preHandler", "getPreHandler()Ljava/lang/reflect/Method;");
        s.c(nVar);
        $$delegatedProperties = new e[]{nVar};
    }

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.f1692e);
        this.preHandler$delegate = f.b(this);
    }

    private final Method getPreHandler() {
        d dVar = this.preHandler$delegate;
        e eVar = $$delegatedProperties[0];
        return (Method) dVar.getValue();
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(g gVar, Throwable th) {
        j.f(gVar, "context");
        j.f(th, "exception");
        Thread threadCurrentThread = Thread.currentThread();
        if (Build.VERSION.SDK_INT >= 28) {
            j.b(threadCurrentThread, "thread");
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            return;
        }
        Method preHandler = getPreHandler();
        Object objInvoke = preHandler != null ? preHandler.invoke(null, new Object[0]) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) (objInvoke instanceof Thread.UncaughtExceptionHandler ? objInvoke : null);
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(threadCurrentThread, th);
        }
    }

    @Override // f.z.c.a
    public Method invoke() {
        try {
            boolean z = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            j.b(declaredMethod, "it");
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    z = true;
                }
            }
            if (z) {
                return declaredMethod;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
