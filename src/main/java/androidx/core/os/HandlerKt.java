package androidx.core.os;

import android.os.Handler;
import f.s;
import f.z.c.a;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerKt {
    public static final Runnable postAtTime(Handler handler, long j, Object obj, a<s> aVar) {
        j.f(handler, "$this$postAtTime");
        j.f(aVar, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(aVar);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j, Object obj, a aVar, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        j.f(handler, "$this$postAtTime");
        j.f(aVar, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(aVar);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    public static final Runnable postDelayed(Handler handler, long j, Object obj, a<s> aVar) {
        j.f(handler, "$this$postDelayed");
        j.f(aVar, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(aVar);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j, Object obj, a aVar, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        j.f(handler, "$this$postDelayed");
        j.f(aVar, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(aVar);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
