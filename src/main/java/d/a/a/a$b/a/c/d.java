package d.a.a.a$b.a.c;

import android.util.Base64;
import f.f;
import f.s;
import f.z.d.j;
import f.z.d.k;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d extends d.a.a.a$b.a.c.a {
    public final f.d a = f.b(a.a);

    public static final class a extends k implements f.z.c.a<LinkedHashMap<String, String>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        public LinkedHashMap<String, String> invoke() {
            return new LinkedHashMap<>();
        }
    }

    @Override // d.a.a.a$b.a.c.a
    public void a(String str, byte[] bArr) {
        Object obj;
        j.e(str, "key");
        e.g.b.b bVar = e.g.b.b.a;
        StringBuilder sb = new StringBuilder();
        sb.append("update card Key is: ");
        sb.append(str);
        sb.append(" , value is null: ");
        sb.append(bArr == null);
        bVar.a("DSLCardMemSource", sb.toString());
        synchronized (c()) {
            if (bArr == null) {
                obj = null;
            } else {
                Map<String, String> mapC = c();
                j.e(bArr, "<this>");
                byte[] bArrEncode = Base64.encode(bArr, 0);
                j.d(bArrEncode, "encode(this, 0)");
                mapC.put(str, new String(bArrEncode, f.e0.c.a));
                obj = bArr;
            }
            if (obj == null) {
                c().remove(str);
            }
        }
    }

    @Override // d.a.a.a$b.a.c.a
    public byte[] b(String str) {
        byte[] bArrDecode;
        j.e(str, "key");
        e.g.b.b.a.a("DSLCardMemSource", j.l("get card data key is:", str));
        synchronized (c()) {
            String str2 = c().get(str);
            if (str2 == null) {
                bArrDecode = null;
            } else {
                j.e(str2, "<this>");
                byte[] bytes = str2.getBytes(f.e0.c.a);
                j.d(bytes, "(this as java.lang.String).getBytes(charset)");
                bArrDecode = Base64.decode(bytes, 0);
                j.d(bArrDecode, "decode(this.toByteArray(Charsets.UTF_8), 0)");
            }
            s sVar = s.a;
        }
        return bArrDecode;
    }

    public final Map<String, String> c() {
        return (Map) this.a.getValue();
    }
}
