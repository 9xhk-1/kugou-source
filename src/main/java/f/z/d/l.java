package f.z.d;

import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements d {
    public final Class<?> a;

    public l(Class<?> cls, String str) {
        j.e(cls, "jClass");
        j.e(str, "moduleName");
        this.a = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof l) && j.a(getJClass(), ((l) obj).getJClass());
    }

    @Override // f.z.d.d
    public Class<?> getJClass() {
        return this.a;
    }

    @Override // f.z.d.d, f.c0.d
    public Collection<f.c0.a<?>> getMembers() {
        throw new f.z.b();
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
