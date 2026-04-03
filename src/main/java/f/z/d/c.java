package f.z.d;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements f.c0.a, Serializable {
    public static final Object j = a.a;
    public transient f.c0.a a;
    public final Object b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class f1551d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1552f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1554i;

    public static class a implements Serializable {
        public static final a a = new a();
    }

    public c() {
        this(j);
    }

    public f.c0.a a() {
        f.c0.a aVar = this.a;
        if (aVar != null) {
            return aVar;
        }
        f.c0.a aVarB = b();
        this.a = aVarB;
        return aVarB;
    }

    public abstract f.c0.a b();

    public Object c() {
        return this.b;
    }

    @Override // f.c0.a
    public Object call(Object... objArr) {
        return e().call(objArr);
    }

    @Override // f.c0.a
    public Object callBy(Map map) {
        return e().callBy(map);
    }

    public f.c0.d d() {
        Class cls = this.f1551d;
        if (cls == null) {
            return null;
        }
        return this.f1554i ? s.b(cls) : s.a(cls);
    }

    public f.c0.a e() {
        f.c0.a aVarA = a();
        if (aVarA != this) {
            return aVarA;
        }
        throw new f.z.b();
    }

    public String f() {
        return this.f1553h;
    }

    @Override // f.c0.a
    public List<Annotation> getAnnotations() {
        return e().getAnnotations();
    }

    @Override // f.c0.a
    public String getName() {
        return this.f1552f;
    }

    @Override // f.c0.a
    public List<Object> getParameters() {
        return e().getParameters();
    }

    @Override // f.c0.a
    public f.c0.g getReturnType() {
        return e().getReturnType();
    }

    @Override // f.c0.a
    public List<Object> getTypeParameters() {
        return e().getTypeParameters();
    }

    @Override // f.c0.a
    public f.c0.h getVisibility() {
        return e().getVisibility();
    }

    @Override // f.c0.a
    public boolean isAbstract() {
        return e().isAbstract();
    }

    @Override // f.c0.a
    public boolean isFinal() {
        return e().isFinal();
    }

    @Override // f.c0.a
    public boolean isOpen() {
        return e().isOpen();
    }

    @Override // f.c0.a
    public boolean isSuspend() {
        return e().isSuspend();
    }

    public c(Object obj) {
        this(obj, null, null, null, false);
    }

    public c(Object obj, Class cls, String str, String str2, boolean z) {
        this.b = obj;
        this.f1551d = cls;
        this.f1552f = str;
        this.f1553h = str2;
        this.f1554i = z;
    }
}
