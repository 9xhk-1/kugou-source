package f.c0;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public interface a<R> {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    /* synthetic */ List<Annotation> getAnnotations();

    String getName();

    List<Object> getParameters();

    g getReturnType();

    List<Object> getTypeParameters();

    h getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
