package g.a;

import f.w.g;
import g.a.d2;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 extends f.w.a implements d2<String> {
    public static final a b = new a(null);
    public final long a;

    public static final class a implements g.c<e0> {
        public a() {
        }

        public /* synthetic */ a(f.z.d.g gVar) {
            this();
        }
    }

    public e0(long j) {
        super(b);
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    @Override // g.a.d2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void restoreThreadContext(f.w.g gVar, String str) {
        f.z.d.j.f(gVar, "context");
        f.z.d.j.f(str, "oldState");
        Thread threadCurrentThread = Thread.currentThread();
        f.z.d.j.b(threadCurrentThread, "Thread.currentThread()");
        threadCurrentThread.setName(str);
    }

    @Override // g.a.d2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String updateThreadContext(f.w.g gVar) {
        String name;
        f.z.d.j.f(gVar, "context");
        f0 f0Var = (f0) gVar.get(f0.b);
        if (f0Var == null || (name = f0Var.getName()) == null) {
            name = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        f.z.d.j.b(threadCurrentThread, "currentThread");
        String name2 = threadCurrentThread.getName();
        f.z.d.j.b(name2, "oldName");
        int iJ = f.e0.o.J(name2, " @", 0, false, 6, null);
        if (iJ < 0) {
            iJ = name2.length();
        }
        StringBuilder sb = new StringBuilder(name.length() + iJ + 10);
        String strSubstring = name2.substring(0, iJ);
        f.z.d.j.b(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(strSubstring);
        sb.append(" @");
        sb.append(name);
        sb.append('#');
        sb.append(this.a);
        String string = sb.toString();
        f.z.d.j.b(string, "StringBuilder(capacity).…builderAction).toString()");
        threadCurrentThread.setName(string);
        return name2;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e0) {
                if (this.a == ((e0) obj).a) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // f.w.a, f.w.g.b, f.w.g
    public <R> R fold(R r, f.z.c.p<? super R, ? super g.b, ? extends R> pVar) {
        f.z.d.j.f(pVar, "operation");
        return (R) d2.a.a(this, r, pVar);
    }

    @Override // f.w.a, f.w.g.b, f.w.g
    public <E extends g.b> E get(g.c<E> cVar) {
        f.z.d.j.f(cVar, "key");
        return (E) d2.a.b(this, cVar);
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    @Override // f.w.a, f.w.g.b, f.w.g
    public f.w.g minusKey(g.c<?> cVar) {
        f.z.d.j.f(cVar, "key");
        return d2.a.c(this, cVar);
    }

    @Override // f.w.a, f.w.g.b, f.w.g
    public f.w.g plus(f.w.g gVar) {
        f.z.d.j.f(gVar, "context");
        return d2.a.d(this, gVar);
    }

    public String toString() {
        return "CoroutineId(" + this.a + ')';
    }
}
