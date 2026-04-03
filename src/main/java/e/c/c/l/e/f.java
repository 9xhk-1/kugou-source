package e.c.c.l.e;

import com.kugou.datacollect.bi.senter.CsccEntity;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static byte[] a() {
        short s;
        try {
            s = Short.parseShort(e.c.c.b.b);
        } catch (Exception e2) {
            e2.printStackTrace();
            s = 0;
        }
        int i2 = e.c.c.k.f.e.q().i();
        Short shValueOf = Short.valueOf(Short.parseShort(e.c.c.e.a));
        byte[] bArrB = e.c.c.o.a.b(e.c.c.o.a.c(e.c.c.o.a.g(e.c.c.o.a.a(e.c.c.o.a.e(new byte[0], (short) 43), (byte) 9), new int[4]), 0L), 0);
        byte b = (byte) 0;
        return e.c.c.o.a.b(e.c.c.o.a.f(e.c.c.o.a.a(e.c.c.o.a.e(e.c.c.o.a.b(e.c.c.o.a.e(e.c.c.o.a.d(e.c.c.o.a.a(bArrB, b), ""), s), i2), shValueOf.shortValue()), b), new byte[0]), 0);
    }

    public static byte[] b(List<CsccEntity> list) {
        if (list == null) {
            return null;
        }
        byte[] bArrA = a();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bArrA);
            for (int i2 = 0; i2 < list.size(); i2++) {
                byte[] bArrC = list.get(i2).c();
                if (bArrC != null) {
                    byteArrayOutputStream.write(bArrC);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
