package e.f.a.b.a.m;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    String string = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return string;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
                byteArrayOutputStream.flush();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
