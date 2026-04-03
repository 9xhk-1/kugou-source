package f.c0;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface e<V> extends f.c0.a<V> {

    public interface a<V> extends Object<V>, Object<V> {
        /* synthetic */ R call(Object... objArr);

        /* synthetic */ R callBy(Map<Object, ? extends Object> map);

        /* synthetic */ List<Annotation> getAnnotations();

        /* synthetic */ String getName();

        /* synthetic */ List<Object> getParameters();

        /* synthetic */ e<V> getProperty();

        /* synthetic */ g getReturnType();

        /* synthetic */ List<Object> getTypeParameters();

        /* synthetic */ h getVisibility();

        /* synthetic */ boolean isAbstract();

        /* synthetic */ boolean isExternal();

        /* synthetic */ boolean isFinal();

        /* synthetic */ boolean isInfix();

        /* synthetic */ boolean isInline();

        /* synthetic */ boolean isOpen();

        /* synthetic */ boolean isOperator();

        /* synthetic */ boolean isSuspend();
    }

    @Override // f.c0.a
    /* synthetic */ R call(Object... objArr);

    @Override // f.c0.a
    /* synthetic */ R callBy(Map<Object, ? extends Object> map);

    @Override // f.c0.a
    /* synthetic */ List<Annotation> getAnnotations();

    a<V> getGetter();

    @Override // f.c0.a
    /* synthetic */ String getName();

    @Override // f.c0.a
    /* synthetic */ List<Object> getParameters();

    @Override // f.c0.a
    /* synthetic */ g getReturnType();

    @Override // f.c0.a
    /* synthetic */ List<Object> getTypeParameters();

    @Override // f.c0.a
    /* synthetic */ h getVisibility();

    @Override // f.c0.a
    /* synthetic */ boolean isAbstract();

    boolean isConst();

    @Override // f.c0.a
    /* synthetic */ boolean isFinal();

    boolean isLateinit();

    @Override // f.c0.a
    /* synthetic */ boolean isOpen();

    @Override // f.c0.a
    /* synthetic */ boolean isSuspend();
}
