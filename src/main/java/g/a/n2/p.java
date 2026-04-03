package g.a.n2;

import f.j;
import g.a.k0;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class p {
    public static final String a;
    public static final String b;

    static {
        Object objA;
        Object objA2;
        try {
            j.a aVar = f.j.a;
            Class<?> cls = Class.forName("f.w.j.a.a");
            f.z.d.j.b(cls, "Class.forName(baseContinuationImplClass)");
            objA = cls.getCanonicalName();
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = f.k.a(th);
            f.j.a(objA);
        }
        if (f.j.b(objA) != null) {
            objA = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) objA;
        try {
            j.a aVar3 = f.j.a;
            Class<?> cls2 = Class.forName("g.a.n2.p");
            f.z.d.j.b(cls2, "Class.forName(stackTraceRecoveryClass)");
            objA2 = cls2.getCanonicalName();
            f.j.a(objA2);
        } catch (Throwable th2) {
            j.a aVar4 = f.j.a;
            objA2 = f.k.a(th2);
            f.j.a(objA2);
        }
        if (f.j.b(objA2) != null) {
            objA2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (String) objA2;
    }

    public static final StackTraceElement a(String str) {
        f.z.d.j.f(str, "message");
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    public static final <E extends Throwable> f.i<E, StackTraceElement[]> b(E e2) {
        boolean z;
        Throwable cause = e2.getCause();
        if (cause == null || !f.z.d.j.a(cause.getClass(), e2.getClass())) {
            return f.o.a(e2, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e2.getStackTrace();
        f.z.d.j.b(stackTrace, "currentTrace");
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            f.z.d.j.b(stackTraceElement, "it");
            if (g(stackTraceElement)) {
                z = true;
                break;
            }
            i2++;
        }
        return z ? f.o.a(cause, stackTrace) : f.o.a(e2, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E c(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(a("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        f.z.d.j.b(stackTrace, "causeTrace");
        String str = a;
        f.z.d.j.b(str, "baseContinuationImplClassName");
        int iF = f(stackTrace, str);
        int i2 = 0;
        if (iF == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array == null) {
                throw new f.p("null cannot be cast to non-null type kotlin.Array<T>");
            }
            e3.setStackTrace((StackTraceElement[]) array);
            return e3;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + iF];
        for (int i3 = 0; i3 < iF; i3++) {
            stackTraceElementArr[i3] = stackTrace[i3];
        }
        Iterator<T> it = arrayDeque.iterator();
        while (it.hasNext()) {
            stackTraceElementArr[iF + i2] = (StackTraceElement) it.next();
            i2++;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    public static final ArrayDeque<StackTraceElement> d(f.w.j.a.e eVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = eVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(eVar instanceof f.w.j.a.e)) {
                eVar = null;
            }
            if (eVar == null || (eVar = eVar.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = eVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    public static final boolean e(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && f.z.d.j.a(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && f.z.d.j.a(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && f.z.d.j.a(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    public static final int f(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (f.z.d.j.a(str, stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
        }
        return -1;
    }

    public static final boolean g(StackTraceElement stackTraceElement) {
        f.z.d.j.f(stackTraceElement, "$this$isArtificial");
        String className = stackTraceElement.getClassName();
        f.z.d.j.b(className, "className");
        return f.e0.n.s(className, "\b\b\b", false, 2, null);
    }

    public static final void h(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (g(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i3) {
            return;
        }
        while (true) {
            StackTraceElement stackTraceElement = stackTraceElementArr[length2];
            StackTraceElement last = arrayDeque.getLast();
            f.z.d.j.b(last, "result.last");
            if (e(stackTraceElement, last)) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i3) {
                return;
            } else {
                length2--;
            }
        }
    }

    public static final <E extends Throwable> E i(E e2, f.w.j.a.e eVar) {
        f.i iVarB = b(e2);
        Throwable th = (Throwable) iVarB.a();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) iVarB.b();
        E e3 = (E) f.e(th);
        if (e3 == null) {
            return e2;
        }
        ArrayDeque<StackTraceElement> arrayDequeD = d(eVar);
        if (arrayDequeD.isEmpty()) {
            return e2;
        }
        if (th != e2) {
            h(stackTraceElementArr, arrayDequeD);
        }
        c(th, e3, arrayDequeD);
        return e3;
    }

    public static final <E extends Throwable> E j(E e2) {
        E e3;
        f.z.d.j.f(e2, "exception");
        if (!k0.d() || (e3 = (E) f.e(e2)) == null) {
            return e2;
        }
        l(e3);
        return e3;
    }

    public static final <E extends Throwable> E k(E e2, f.w.d<?> dVar) {
        f.z.d.j.f(e2, "exception");
        f.z.d.j.f(dVar, "continuation");
        return (k0.d() && (dVar instanceof f.w.j.a.e)) ? (E) i(e2, (f.w.j.a.e) dVar) : e2;
    }

    public static final <E extends Throwable> E l(E e2) {
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        f.z.d.j.b(stackTrace, "stackTrace");
        String str = b;
        f.z.d.j.b(str, "stackTraceRecoveryClassName");
        int iF = f(stackTrace, str);
        int i2 = iF + 1;
        String str2 = a;
        f.z.d.j.b(str2, "baseContinuationImplClassName");
        int iF2 = f(stackTrace, str2);
        int i3 = 0;
        int i4 = (length - iF) - (iF2 == -1 ? 0 : length - iF2);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i4];
        while (i3 < i4) {
            stackTraceElementArr[i3] = i3 == 0 ? a("Coroutine boundary") : stackTrace[(i2 + i3) - 1];
            i3++;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    public static final <E extends Throwable> E m(E e2) {
        E e3;
        f.z.d.j.f(e2, "exception");
        if (k0.d() && (e3 = (E) e2.getCause()) != null) {
            boolean z = true;
            if (!(!f.z.d.j.a(e3.getClass(), e2.getClass()))) {
                StackTraceElement[] stackTrace = e2.getStackTrace();
                f.z.d.j.b(stackTrace, "exception.stackTrace");
                int length = stackTrace.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    f.z.d.j.b(stackTraceElement, "it");
                    if (g(stackTraceElement)) {
                        break;
                    }
                    i2++;
                }
                if (z) {
                    return e3;
                }
            }
        }
        return e2;
    }
}
