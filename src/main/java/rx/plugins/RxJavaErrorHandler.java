package rx.plugins;

import rx.annotations.Beta;
import rx.exceptions.Exceptions;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RxJavaErrorHandler {
    public static final String ERROR_IN_RENDERING_SUFFIX = ".errorRendering";

    @Deprecated
    public void handleError(Throwable th) {
    }

    @Beta
    public final String handleOnNextValueRendering(Object obj) {
        try {
            return render(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ERROR_IN_RENDERING_SUFFIX;
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            return obj.getClass().getName() + ERROR_IN_RENDERING_SUFFIX;
        }
    }

    @Beta
    public String render(Object obj) throws InterruptedException {
        return null;
    }
}
