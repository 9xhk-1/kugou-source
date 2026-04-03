package retrofit2.converter.file;

import java.io.File;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes2.dex */
public class FileConverter implements Converter<ResponseBody, File> {
    private static final int MAX_RATE = 2048;
    private static final int MIN_BPS_LIMIT = 2048;
    private int bpsLimit = 0;
    private final String savePath;

    public FileConverter(String str) {
        this.savePath = str;
    }

    public void setBpsLimit(int i2) {
        if (i2 < 2048) {
            throw new IllegalArgumentException("byte per second was set too small, min value is 2048");
        }
        this.bpsLimit = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
    
        r8 = android.os.SystemClock.elapsedRealtime() - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        if (r8 >= 1000) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        android.os.SystemClock.sleep(r8);
     */
    @Override // retrofit2.Converter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File convert(okhttp3.ResponseBody r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r13.savePath
            r0.<init>(r1)
            r1 = 0
            boolean r2 = r0.exists()     // Catch: java.lang.Throwable -> L61
            if (r2 == 0) goto L11
            r0.delete()     // Catch: java.lang.Throwable -> L61
        L11:
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L61
            java.io.InputStream r14 = r14.byteStream()     // Catch: java.lang.Throwable -> L61
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5c
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L5c
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L5a
            r6 = 0
        L24:
            r8 = r6
        L25:
            int r1 = r14.read(r2)     // Catch: java.lang.Throwable -> L5a
            r10 = -1
            if (r1 == r10) goto L4e
            r10 = 0
            r3.write(r2, r10, r1)     // Catch: java.lang.Throwable -> L5a
            int r10 = r13.bpsLimit     // Catch: java.lang.Throwable -> L5a
            if (r10 <= 0) goto L25
            long r11 = (long) r1     // Catch: java.lang.Throwable -> L5a
            long r8 = r8 + r11
            long r10 = (long) r10     // Catch: java.lang.Throwable -> L5a
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r1 < 0) goto L25
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L5a
            long r8 = r8 - r4
            r4 = 1000(0x3e8, double:4.94E-321)
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 >= 0) goto L49
            android.os.SystemClock.sleep(r8)     // Catch: java.lang.Throwable -> L5a
        L49:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L5a
            goto L24
        L4e:
            r3.flush()     // Catch: java.lang.Throwable -> L5a
            if (r14 == 0) goto L56
            r14.close()
        L56:
            r3.close()
            return r0
        L5a:
            r0 = move-exception
            goto L5e
        L5c:
            r0 = move-exception
            r3 = r1
        L5e:
            r1 = r14
            r14 = r0
            goto L63
        L61:
            r14 = move-exception
            r3 = r1
        L63:
            if (r1 == 0) goto L68
            r1.close()
        L68:
            if (r3 == 0) goto L6d
            r3.close()
        L6d:
            goto L6f
        L6e:
            throw r14
        L6f:
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.converter.file.FileConverter.convert(okhttp3.ResponseBody):java.io.File");
    }
}
