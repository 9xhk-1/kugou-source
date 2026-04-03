package f.z.d;

/* JADX INFO: loaded from: classes2.dex */
public class t {
    public f.c0.b a(Class cls) {
        return new e(cls);
    }

    public f.c0.d b(Class cls, String str) {
        return new l(cls, str);
    }

    public f.c0.f c(m mVar) {
        return mVar;
    }

    public String d(h hVar) {
        String string = hVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public String e(k kVar) {
        return d(kVar);
    }
}
