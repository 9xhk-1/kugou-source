package e.b.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static byte[] a(byte[] bArr) {
        byte[] byteArray = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            r rVar = new r(byteArrayInputStream);
            byte[] bArr2 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i2 = rVar.read(bArr2, 0, 1024);
                if (i2 == -1) {
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    rVar.close();
                    byteArrayInputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, i2);
            }
        } catch (IOException unused) {
            return byteArray;
        }
    }
}
