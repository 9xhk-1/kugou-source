package d.a.a.a$b.d;

import f.j;
import f.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class h implements j {
    public d.a.a.a$b.a.a a(byte[] bArr) {
        Object objA;
        f.z.d.j.e(bArr, "param");
        try {
            j.a aVar = f.j.a;
            objA = d.a.a.a$b.d.k.a.a.a(new JSONObject(new String(bArr, f.e0.c.a)));
            e.g.b.b.a.a("State.JsonDataTranslator", "[Json] onDecode data size is " + bArr.length + ", action is " + objA);
            f.j.a(objA);
        } catch (Throwable th) {
            j.a aVar2 = f.j.a;
            objA = k.a(th);
            f.j.a(objA);
        }
        Throwable thB = f.j.b(objA);
        if (thB != null) {
            e.g.b.b.a.a("State.JsonDataTranslator", f.z.d.j.l("onDecode has error: ", thB.getMessage()));
        }
        d.a.a.a$b.a.a aVar3 = new d.a.a.a$b.a.a("", -1, null);
        if (f.j.c(objA)) {
            objA = aVar3;
        }
        return (d.a.a.a$b.a.a) objA;
    }
}
