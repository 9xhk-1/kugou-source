package f.e0;

import f.u.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g extends f {

    public static final class a extends f.z.d.k implements f.z.c.l<String, String> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final String a(String str) {
            f.z.d.j.e(str, "line");
            return str;
        }

        @Override // f.z.c.l
        public /* bridge */ /* synthetic */ String invoke(String str) {
            String str2 = str;
            a(str2);
            return str2;
        }
    }

    public static final class b extends f.z.d.k implements f.z.c.l<String, String> {
        public final /* synthetic */ String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.a = str;
        }

        @Override // f.z.c.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            f.z.d.j.e(str, "line");
            return this.a + str;
        }
    }

    public static final f.z.c.l<String, String> b(String str) {
        return str.length() == 0 ? a.a : new b(str);
    }

    public static final int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (!f.e0.a.c(str.charAt(i2))) {
                break;
            }
            i2++;
        }
        return i2 == -1 ? str.length() : i2;
    }

    public static final String d(String str, String str2) throws IOException {
        String strInvoke;
        f.z.d.j.e(str, "$this$replaceIndent");
        f.z.d.j.e(str2, "newIndent");
        List<String> listM = o.M(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (!n.n((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(f.u.n.j(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer num = (Integer) u.E(arrayList2);
        int i2 = 0;
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * listM.size());
        f.z.c.l<String, String> lVarB = b(str2);
        int iE = f.u.m.e(listM);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listM) {
            int i3 = i2 + 1;
            String str3 = null;
            if (i2 < 0) {
                f.u.m.i();
                throw null;
            }
            String str4 = (String) obj2;
            if ((i2 != 0 && i2 != iE) || !n.n(str4)) {
                String strD0 = q.d0(str4, iIntValue);
                str3 = (strD0 == null || (strInvoke = lVarB.invoke(strD0)) == null) ? str4 : strInvoke;
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        StringBuilder sb = new StringBuilder(length);
        u.z(arrayList3, sb, "\n", null, null, 0, null, null, 124, null);
        String string = sb.toString();
        f.z.d.j.d(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String e(String str) {
        f.z.d.j.e(str, "$this$trimIndent");
        return d(str, "");
    }
}
