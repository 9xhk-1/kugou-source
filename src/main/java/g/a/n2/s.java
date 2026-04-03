package g.a.n2;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s {
    public static final int a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return a;
    }

    public static final String b(String str) {
        f.z.d.j.f(str, "propertyName");
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
