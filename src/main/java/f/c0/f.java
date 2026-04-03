package f.c0;

import f.c0.e;
import f.z.c.l;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface f<T, V> extends e<V>, l<T, V> {

    public interface a<T, V> extends e.a<V>, l<T, V> {
        @Override // f.c0.e.a
        /* synthetic */ R call(Object... objArr);

        @Override // f.c0.e.a
        /* synthetic */ R callBy(Map<Object, ? extends Object> map);

        @Override // f.c0.e.a
        /* synthetic */ List<Annotation> getAnnotations();

        @Override // f.c0.e.a
        /* synthetic */ String getName();

        @Override // f.c0.e.a
        /* synthetic */ List<Object> getParameters();

        @Override // f.c0.e.a
        /* synthetic */ e<V> getProperty();

        @Override // f.c0.e.a
        /* synthetic */ g getReturnType();

        @Override // f.c0.e.a
        /* synthetic */ List<Object> getTypeParameters();

        @Override // f.c0.e.a
        /* synthetic */ h getVisibility();

        @Override // f.z.c.l
        /* synthetic */ R invoke(P1 p1);

        @Override // f.c0.e.a
        /* synthetic */ boolean isAbstract();

        @Override // f.c0.e.a
        /* synthetic */ boolean isExternal();

        @Override // f.c0.e.a
        /* synthetic */ boolean isFinal();

        @Override // f.c0.e.a
        /* synthetic */ boolean isInfix();

        @Override // f.c0.e.a
        /* synthetic */ boolean isInline();

        @Override // f.c0.e.a
        /* synthetic */ boolean isOpen();

        @Override // f.c0.e.a
        /* synthetic */ boolean isOperator();

        @Override // f.c0.e.a
        /* synthetic */ boolean isSuspend();
    }

    @Override // f.c0.e, f.c0.a
    /* synthetic */ R call(Object... objArr);

    @Override // f.c0.e, f.c0.a
    /* synthetic */ R callBy(Map<Object, ? extends Object> map);

    V get(T t);

    @Override // f.c0.e, f.c0.a
    /* synthetic */ List<Annotation> getAnnotations();

    Object getDelegate(T t);

    @Override // f.c0.e
    /* synthetic */ e.a<V> getGetter();

    @Override // f.c0.e
    a<T, V> getGetter();

    @Override // f.c0.e, f.c0.a
    /* synthetic */ String getName();

    @Override // f.c0.e, f.c0.a
    /* synthetic */ List<Object> getParameters();

    @Override // f.c0.e, f.c0.a
    /* synthetic */ g getReturnType();

    @Override // f.c0.e, f.c0.a
    /* synthetic */ List<Object> getTypeParameters();

    @Override // f.c0.e, f.c0.a
    /* synthetic */ h getVisibility();

    @Override // f.z.c.l
    /* synthetic */ R invoke(P1 p1);

    @Override // f.c0.e, f.c0.a
    /* synthetic */ boolean isAbstract();

    @Override // f.c0.e
    /* synthetic */ boolean isConst();

    @Override // f.c0.e, f.c0.a
    /* synthetic */ boolean isFinal();

    @Override // f.c0.e
    /* synthetic */ boolean isLateinit();

    @Override // f.c0.e, f.c0.a
    /* synthetic */ boolean isOpen();

    @Override // f.c0.e, f.c0.a
    /* synthetic */ boolean isSuspend();
}
