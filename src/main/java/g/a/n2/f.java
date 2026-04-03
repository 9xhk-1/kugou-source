package g.a.n2;

import f.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final int a = d(Throwable.class, -1);
    public static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    public static final WeakHashMap<Class<? extends Throwable>, f.z.c.l<Throwable, Throwable>> c = new WeakHashMap<>();

    public static final class a extends f.z.d.k implements f.z.c.l<Throwable, Throwable> {
        public final /* synthetic */ Constructor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(Throwable th) {
            Object objA;
            Object objNewInstance;
            f.z.d.j.f(th, "e");
            try {
                j.a aVar = f.j.a;
                objNewInstance = this.a.newInstance(th.getMessage(), th);
            } catch (Throwable th2) {
                j.a aVar2 = f.j.a;
                objA = f.k.a(th2);
                f.j.a(objA);
            }
            if (objNewInstance == null) {
                throw new f.p("null cannot be cast to non-null type kotlin.Throwable");
            }
            objA = (Throwable) objNewInstance;
            f.j.a(objA);
            if (f.j.c(objA)) {
                objA = null;
            }
            return (Throwable) objA;
        }
    }

    public static final class b extends f.z.d.k implements f.z.c.l<Throwable, Throwable> {
        public final /* synthetic */ Constructor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(Throwable th) {
            Object objA;
            Object objNewInstance;
            f.z.d.j.f(th, "e");
            try {
                j.a aVar = f.j.a;
                objNewInstance = this.a.newInstance(th);
            } catch (Throwable th2) {
                j.a aVar2 = f.j.a;
                objA = f.k.a(th2);
                f.j.a(objA);
            }
            if (objNewInstance == null) {
                throw new f.p("null cannot be cast to non-null type kotlin.Throwable");
            }
            objA = (Throwable) objNewInstance;
            f.j.a(objA);
            if (f.j.c(objA)) {
                objA = null;
            }
            return (Throwable) objA;
        }
    }

    public static final class c extends f.z.d.k implements f.z.c.l<Throwable, Throwable> {
        public final /* synthetic */ Constructor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(Throwable th) {
            Object obj;
            Object objNewInstance;
            f.z.d.j.f(th, "e");
            try {
                j.a aVar = f.j.a;
                objNewInstance = this.a.newInstance(th.getMessage());
            } catch (Throwable th2) {
                j.a aVar2 = f.j.a;
                Object objA = f.k.a(th2);
                f.j.a(objA);
                obj = objA;
            }
            if (objNewInstance == null) {
                throw new f.p("null cannot be cast to non-null type kotlin.Throwable");
            }
            Throwable th3 = (Throwable) objNewInstance;
            th3.initCause(th);
            f.j.a(th3);
            obj = th3;
            boolean zC = f.j.c(obj);
            Object obj2 = obj;
            if (zC) {
                obj2 = null;
            }
            return (Throwable) obj2;
        }
    }

    public static final class d extends f.z.d.k implements f.z.c.l<Throwable, Throwable> {
        public final /* synthetic */ Constructor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.a = constructor;
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(Throwable th) {
            Object obj;
            Object objNewInstance;
            f.z.d.j.f(th, "e");
            try {
                j.a aVar = f.j.a;
                objNewInstance = this.a.newInstance(new Object[0]);
            } catch (Throwable th2) {
                j.a aVar2 = f.j.a;
                Object objA = f.k.a(th2);
                f.j.a(objA);
                obj = objA;
            }
            if (objNewInstance == null) {
                throw new f.p("null cannot be cast to non-null type kotlin.Throwable");
            }
            Throwable th3 = (Throwable) objNewInstance;
            th3.initCause(th);
            f.j.a(th3);
            obj = th3;
            boolean zC = f.j.c(obj);
            Object obj2 = obj;
            if (zC) {
                obj2 = null;
            }
            return (Throwable) obj2;
        }
    }

    public static final class e<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            Constructor constructor = (Constructor) t2;
            f.z.d.j.b(constructor, "it");
            Integer numValueOf = Integer.valueOf(constructor.getParameterTypes().length);
            Constructor constructor2 = (Constructor) t;
            f.z.d.j.b(constructor2, "it");
            return f.v.a.a(numValueOf, Integer.valueOf(constructor2.getParameterTypes().length));
        }
    }

    /* JADX INFO: renamed from: g.a.n2.f$f, reason: collision with other inner class name */
    public static final class C0275f extends f.z.d.k implements f.z.c.l {
        public static final C0275f a = new C0275f();

        public C0275f() {
            super(1);
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Throwable th) {
            f.z.d.j.f(th, "it");
            return null;
        }
    }

    public static final class g extends f.z.d.k implements f.z.c.l {
        public static final g a = new g();

        public g() {
            super(1);
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Throwable th) {
            f.z.d.j.f(th, "it");
            return null;
        }
    }

    public static final f.z.c.l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new d(constructor);
        }
        if (length == 1) {
            Class<?> cls = parameterTypes[0];
            if (f.z.d.j.a(cls, Throwable.class)) {
                return new b(constructor);
            }
            if (f.z.d.j.a(cls, String.class)) {
                return new c(constructor);
            }
        } else if (length == 2 && f.z.d.j.a(parameterTypes[0], String.class) && f.z.d.j.a(parameterTypes[1], Throwable.class)) {
            return new a(constructor);
        }
        return null;
    }

    public static final int b(Class<?> cls, int i2) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            f.z.d.j.b(declaredFields, "declaredFields");
            int i3 = 0;
            for (Field field : declaredFields) {
                f.z.d.j.b(field, "it");
                if (!Modifier.isStatic(r4.getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i2;
    }

    public static /* synthetic */ int c(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return b(cls, i2);
    }

    public static final int d(Class<?> cls, int i2) {
        Object objA;
        f.z.a.b(cls);
        try {
            j.a aVar = f.j.a;
            objA = Integer.valueOf(c(cls, 0, 1, null));
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = f.k.a(th);
            f.j.a(objA);
        }
        Integer numValueOf = Integer.valueOf(i2);
        if (f.j.c(objA)) {
            objA = numValueOf;
        }
        return ((Number) objA).intValue();
    }

    public static final <E extends Throwable> E e(E e2) {
        Object objA;
        f.z.d.j.f(e2, "exception");
        if (e2 instanceof g.a.z) {
            try {
                j.a aVar = f.j.a;
                objA = ((g.a.z) e2).createCopy();
                f.j.a(objA);
            } catch (Throwable th) {
                j.a aVar2 = f.j.a;
                objA = f.k.a(th);
                f.j.a(objA);
            }
            return (E) (f.j.c(objA) ? null : objA);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = b;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        lock.lock();
        try {
            f.z.c.l<Throwable, Throwable> lVar = c.get(e2.getClass());
            if (lVar != null) {
                return (E) lVar.invoke(e2);
            }
            int i2 = 0;
            if (a != d(e2.getClass(), 0)) {
                ReentrantReadWriteLock.ReadLock lock2 = reentrantReadWriteLock.readLock();
                int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i3 = 0; i3 < readHoldCount; i3++) {
                    lock2.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    c.put((Class<? extends Throwable>) e2.getClass(), C0275f.a);
                    f.s sVar = f.s.a;
                    return null;
                } finally {
                    while (i2 < readHoldCount) {
                        lock2.lock();
                        i2++;
                    }
                    writeLock.unlock();
                }
            }
            Constructor<?>[] constructors = e2.getClass().getConstructors();
            f.z.d.j.b(constructors, "exception.javaClass.constructors");
            f.z.c.l<Throwable, Throwable> lVarA = null;
            for (Constructor constructor : f.u.i.s(constructors, new e())) {
                f.z.d.j.b(constructor, "constructor");
                lVarA = a(constructor);
                if (lVarA != null) {
                    break;
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = b;
            ReentrantReadWriteLock.ReadLock lock3 = reentrantReadWriteLock2.readLock();
            int readHoldCount2 = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i4 = 0; i4 < readHoldCount2; i4++) {
                lock3.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock2.writeLock();
            writeLock2.lock();
            try {
                c.put((Class<? extends Throwable>) e2.getClass(), lVarA != null ? lVarA : g.a);
                f.s sVar2 = f.s.a;
                while (i2 < readHoldCount2) {
                    lock3.lock();
                    i2++;
                }
                writeLock2.unlock();
                if (lVarA != null) {
                    return (E) lVarA.invoke(e2);
                }
                return null;
            } finally {
                while (i2 < readHoldCount2) {
                    lock3.lock();
                    i2++;
                }
                writeLock2.unlock();
            }
        } finally {
            lock.unlock();
        }
    }
}
