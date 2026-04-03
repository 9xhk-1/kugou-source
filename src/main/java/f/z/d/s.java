package f.z.d;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public static final t a;
    public static final f.c0.b[] b;

    static {
        t tVar = null;
        try {
            tVar = (t) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (tVar == null) {
            tVar = new t();
        }
        a = tVar;
        b = new f.c0.b[0];
    }

    public static f.c0.b a(Class cls) {
        return a.a(cls);
    }

    public static f.c0.d b(Class cls) {
        return a.b(cls, "");
    }

    public static f.c0.f c(m mVar) {
        a.c(mVar);
        return mVar;
    }

    public static String d(h hVar) {
        return a.d(hVar);
    }

    public static String e(k kVar) {
        return a.e(kVar);
    }
}
