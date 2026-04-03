package e.c.a.g.a.s;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* JADX INFO: loaded from: classes2.dex */
public class q1 {
    public static Header[] a(Header[] headerArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(headerArr));
        e.c.a.g.a.f.m.b bVarM = e.c.a.g.a.f.m.b.m();
        try {
            String strC = e.c.a.g.a.r.e.e.c(bVarM);
            if (strC == null) {
                strC = "";
            }
            arrayList.add(new BasicHeader("KG-DEVID", strC));
            arrayList.add(new BasicHeader("KG-CLIENTTIMEMS", e.c.a.g.a.r.e.e.d(bVarM)));
        } catch (Exception unused) {
            arrayList.add(new BasicHeader("KG-CLIENTTIMEMS", String.valueOf(System.currentTimeMillis() / 1000)));
        }
        return (Header[]) arrayList.toArray(new Header[0]);
    }
}
