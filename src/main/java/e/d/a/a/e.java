package e.d.a.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static byte[] a(File file, int i2) {
        ByteBuffer byteBuffer;
        Map<Integer, ByteBuffer> mapB = b(file);
        if (mapB == null || (byteBuffer = mapB.get(Integer.valueOf(i2))) == null) {
            return null;
        }
        return c(byteBuffer);
    }

    public static Map<Integer, ByteBuffer> b(File file) {
        FileChannel channel;
        RandomAccessFile randomAccessFile;
        Map<Integer, ByteBuffer> mapF = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    channel = randomAccessFile.getChannel();
                } catch (IOException unused) {
                    channel = null;
                } catch (Throwable th) {
                    th = th;
                    channel = null;
                }
                try {
                    mapF = a.f(a.b(channel).a());
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (IOException unused3) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (randomAccessFile != null) {
                    }
                    return mapF;
                } catch (Throwable th2) {
                    th = th2;
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused6) {
                        throw th;
                    }
                }
            } catch (IOException unused7) {
                channel = null;
                randomAccessFile = null;
            } catch (Throwable th3) {
                th = th3;
                channel = null;
                randomAccessFile = null;
            }
            randomAccessFile.close();
        } catch (f | IOException unused8) {
        }
        return mapF;
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(bArrArray, byteBuffer.position() + iArrayOffset, iArrayOffset + byteBuffer.limit());
    }

    public static String d(File file, int i2) {
        byte[] bArrA = a(file, i2);
        if (bArrA == null) {
            return null;
        }
        try {
            return new String(bArrA, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
