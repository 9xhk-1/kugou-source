package androidx.core.util;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import f.e0.c;
import f.s;
import f.z.c.l;
import f.z.d.i;
import f.z.d.j;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public final class AtomicFileKt {
    @RequiresApi(17)
    public static final byte[] readBytes(android.util.AtomicFile atomicFile) throws IOException {
        j.f(atomicFile, "$this$readBytes");
        byte[] fully = atomicFile.readFully();
        j.b(fully, "readFully()");
        return fully;
    }

    @RequiresApi(17)
    public static final String readText(android.util.AtomicFile atomicFile, Charset charset) throws IOException {
        j.f(atomicFile, "$this$readText");
        j.f(charset, "charset");
        byte[] fully = atomicFile.readFully();
        j.b(fully, "readFully()");
        return new String(fully, charset);
    }

    public static /* synthetic */ String readText$default(android.util.AtomicFile atomicFile, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = c.a;
        }
        return readText(atomicFile, charset);
    }

    @RequiresApi(17)
    public static final void tryWrite(android.util.AtomicFile atomicFile, l<? super FileOutputStream, s> lVar) throws IOException {
        j.f(atomicFile, "$this$tryWrite");
        j.f(lVar, "block");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            j.b(fileOutputStreamStartWrite, "stream");
            lVar.invoke(fileOutputStreamStartWrite);
            i.b(1);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
            i.a(1);
        } catch (Throwable th) {
            i.b(1);
            atomicFile.failWrite(fileOutputStreamStartWrite);
            i.a(1);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeBytes(android.util.AtomicFile atomicFile, byte[] bArr) throws IOException {
        j.f(atomicFile, "$this$writeBytes");
        j.f(bArr, "array");
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            j.b(fileOutputStreamStartWrite, "stream");
            fileOutputStreamStartWrite.write(bArr);
            atomicFile.finishWrite(fileOutputStreamStartWrite);
        } catch (Throwable th) {
            atomicFile.failWrite(fileOutputStreamStartWrite);
            throw th;
        }
    }

    @RequiresApi(17)
    public static final void writeText(android.util.AtomicFile atomicFile, String str, Charset charset) throws IOException {
        j.f(atomicFile, "$this$writeText");
        j.f(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        j.f(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        j.b(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(atomicFile, bytes);
    }

    public static /* synthetic */ void writeText$default(android.util.AtomicFile atomicFile, String str, Charset charset, int i2, Object obj) throws IOException {
        if ((i2 & 2) != 0) {
            charset = c.a;
        }
        writeText(atomicFile, str, charset);
    }
}
