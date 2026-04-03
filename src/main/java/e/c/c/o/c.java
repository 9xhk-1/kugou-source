package e.c.c.o;

import e.b.a.s;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static byte[] a(byte[] bArr, int i2) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            s sVar = new s(byteArrayOutputStream, -1);
            DataOutputStream dataOutputStream = new DataOutputStream(sVar);
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            sVar.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException unused) {
            return null;
        }
    }
}
