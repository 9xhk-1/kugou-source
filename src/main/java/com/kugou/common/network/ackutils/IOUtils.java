package com.kugou.common.network.ackutils;

import android.database.Cursor;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long jCopyLarge = copyLarge(inputStream, outputStream);
        if (jCopyLarge > 2147483647L) {
            return -1;
        }
        return (int) jCopyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (-1 == i2) {
                return j;
            }
            outputStream.write(bArr, 0, i2);
            j += (long) i2;
        }
    }

    @Deprecated
    public static void readAndIgnoreReturnValue(InputStream inputStream, byte[] bArr) throws IOException {
        if (inputStream == null || bArr == null) {
            return;
        }
        readAndIgnoreReturnValue(inputStream, false, bArr, 0, bArr.length);
    }

    @Deprecated
    public static void skipAndIgnoreReturnValue(InputStream inputStream, long j) throws IOException {
        if (inputStream == null || j < 0) {
            return;
        }
        long jSkip = inputStream.skip(j);
        if (jSkip < 0) {
            Log.d("IOUtils", "skip count = " + jSkip);
        }
    }

    public static void closeQuietly(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    @Deprecated
    public static void readAndIgnoreReturnValue(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        readAndIgnoreReturnValue(inputStream, false, bArr, i2, i3);
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    @Deprecated
    public static void readAndIgnoreReturnValue(InputStream inputStream) throws IOException {
        readAndIgnoreReturnValue(inputStream, true, null, 0, 0);
    }

    private static void readAndIgnoreReturnValue(InputStream inputStream, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        if (inputStream == null) {
            return;
        }
        if (z || (bArr != null && i2 >= 0 && i2 + i3 < bArr.length)) {
            if (z) {
                i4 = inputStream.read();
            } else {
                i4 = inputStream.read(bArr, i2, i3);
            }
            if (i4 < 0) {
                Log.d("IOUtils", "read length = " + i4);
            }
        }
    }
}
