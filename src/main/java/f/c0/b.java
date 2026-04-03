package f.c0;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;

/* JADX WARN: Unexpected interfaces in signature: [f.c0.c] */
/* JADX INFO: loaded from: classes2.dex */
public interface b<T> extends d, Object {
    boolean equals(Object obj);

    /* synthetic */ List<Annotation> getAnnotations();

    Collection<Object<T>> getConstructors();

    @Override // f.c0.d
    Collection<a<?>> getMembers();

    Collection<b<?>> getNestedClasses();

    T getObjectInstance();

    String getQualifiedName();

    List<b<? extends T>> getSealedSubclasses();

    String getSimpleName();

    List<g> getSupertypes();

    List<Object> getTypeParameters();

    h getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isFun();

    boolean isInner();

    boolean isInstance(Object obj);

    boolean isOpen();

    boolean isSealed();

    boolean isValue();
}
