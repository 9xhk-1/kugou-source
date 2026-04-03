package e.f.a.b.a.k;

import e.f.a.b.a.c;
import e.f.a.b.a.k.c.d;
import e.f.a.b.a.k.c.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static <T extends e> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                d dVar = new d(bArr);
                dVar.z("utf-8");
                tNewInstance.b(dVar);
                return tNewInstance;
            } catch (Throwable th) {
                c.b("ProtocolHelper", "[decode2JceStruct] err", th);
            }
        }
        return null;
    }
}
