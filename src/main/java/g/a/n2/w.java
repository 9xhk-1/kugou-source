package g.a.n2;

import f.w.g;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements g.c<v<?>> {
    public final ThreadLocal<?> a;

    public w(ThreadLocal<?> threadLocal) {
        f.z.d.j.f(threadLocal, "threadLocal");
        this.a = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof w) && f.z.d.j.a(this.a, ((w) obj).a);
        }
        return true;
    }

    public int hashCode() {
        ThreadLocal<?> threadLocal = this.a;
        if (threadLocal != null) {
            return threadLocal.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.a + ")";
    }
}
