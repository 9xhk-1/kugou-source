package okio;

import androidx.exifinterface.media.ExifInterface;
import com.tme.fireeye.crash.crashmodule.jni.NativeCrashHandler;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public static final int REPLACEMENT_CHARACTER = 65533;
    public Segment head;
    public long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public boolean readWrite;
        private Segment segment;
        public long offset = -1;
        public int start = -1;
        public int end = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            this.segment = null;
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }

        public long expandBuffer(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i2);
            }
            if (i2 > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i2);
            }
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = buffer.size;
            Segment segmentWritableSegment = buffer.writableSegment(i2);
            int i3 = 8192 - segmentWritableSegment.limit;
            segmentWritableSegment.limit = 8192;
            long j2 = i3;
            this.buffer.size = j + j2;
            this.segment = segmentWritableSegment;
            this.offset = j;
            this.data = segmentWritableSegment.data;
            this.start = 8192 - i3;
            this.end = 8192;
            return j2;
        }

        public int next() {
            long j = this.offset;
            if (j != this.buffer.size) {
                return j == -1 ? seek(0L) : seek(j + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException();
        }

        public long resizeBuffer(long j) {
            Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = buffer.size;
            if (j <= j2) {
                if (j < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j);
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    Buffer buffer2 = this.buffer;
                    Segment segment = buffer2.head.prev;
                    int i2 = segment.limit;
                    long j4 = i2 - segment.pos;
                    if (j4 > j3) {
                        segment.limit = (int) (((long) i2) - j3);
                        break;
                    }
                    buffer2.head = segment.pop();
                    SegmentPool.recycle(segment);
                    j3 -= j4;
                }
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    Segment segmentWritableSegment = this.buffer.writableSegment(1);
                    int iMin = (int) Math.min(j5, 8192 - segmentWritableSegment.limit);
                    int i3 = segmentWritableSegment.limit + iMin;
                    segmentWritableSegment.limit = i3;
                    j5 -= (long) iMin;
                    if (z) {
                        this.segment = segmentWritableSegment;
                        this.offset = j2;
                        this.data = segmentWritableSegment.data;
                        this.start = i3 - iMin;
                        this.end = i3;
                        z = false;
                    }
                }
            }
            this.buffer.size = j;
            return j2;
        }

        public int seek(long j) {
            if (j >= -1) {
                Buffer buffer = this.buffer;
                long j2 = buffer.size;
                if (j <= j2) {
                    if (j == -1 || j == j2) {
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    long j3 = 0;
                    Segment segment = buffer.head;
                    Segment segmentPush = this.segment;
                    if (segmentPush != null) {
                        long j4 = this.offset - ((long) (this.start - segmentPush.pos));
                        if (j4 > j) {
                            j2 = j4;
                            segmentPush = segment;
                            segment = segmentPush;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segmentPush = segment;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i2 = segmentPush.limit;
                            int i3 = segmentPush.pos;
                            if (j < ((long) (i2 - i3)) + j3) {
                                break;
                            }
                            j3 += (long) (i2 - i3);
                            segmentPush = segmentPush.next;
                        }
                    } else {
                        while (j2 > j) {
                            segment = segment.prev;
                            j2 -= (long) (segment.limit - segment.pos);
                        }
                        segmentPush = segment;
                        j3 = j2;
                    }
                    if (this.readWrite && segmentPush.shared) {
                        Segment segmentUnsharedCopy = segmentPush.unsharedCopy();
                        Buffer buffer2 = this.buffer;
                        if (buffer2.head == segmentPush) {
                            buffer2.head = segmentUnsharedCopy;
                        }
                        segmentPush = segmentPush.push(segmentUnsharedCopy);
                        segmentPush.prev.pop();
                    }
                    this.segment = segmentPush;
                    this.offset = j;
                    this.data = segmentPush.data;
                    int i4 = segmentPush.pos + ((int) (j - j3));
                    this.start = i4;
                    int i5 = segmentPush.limit;
                    this.end = i5;
                    return i5 - i4;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.buffer.size)));
        }
    }

    private ByteString digest(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i2 = segment.pos;
                messageDigest.update(bArr, i2, segment.limit - i2);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i3 = segment2.pos;
                    messageDigest.update(bArr2, i3, segment2.limit - i3);
                }
            }
            return ByteString.of(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            Segment segment = this.head;
            if (segment != null) {
                byte[] bArr = segment.data;
                int i2 = segment.pos;
                mac.update(bArr, i2, segment.limit - i2);
                Segment segment2 = this.head;
                while (true) {
                    segment2 = segment2.next;
                    if (segment2 == this.head) {
                        break;
                    }
                    byte[] bArr2 = segment2.data;
                    int i3 = segment2.pos;
                    mac.update(bArr2, i3, segment2.limit - i3);
                }
            }
            return ByteString.of(mac.doFinal());
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public void clear() {
        try {
            skip(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0L;
        }
        Segment segment = this.head.prev;
        int i2 = segment.limit;
        return (i2 >= 8192 || !segment.owner) ? j : j - ((long) (i2 - segment.pos));
    }

    public Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0L, this.size);
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer emitCompleteSegments() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.size;
        if (j != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i2 = segment.pos;
        int i3 = segment2.pos;
        while (j2 < this.size) {
            long jMin = Math.min(segment.limit - i2, segment2.limit - i3);
            int i4 = 0;
            while (i4 < jMin) {
                int i5 = i2 + 1;
                int i6 = i3 + 1;
                if (segment.data[i2] != segment2.data[i3]) {
                    return false;
                }
                i4++;
                i2 = i5;
                i3 = i6;
            }
            if (i2 == segment.limit) {
                segment = segment.next;
                i2 = segment.pos;
            }
            if (i3 == segment2.limit) {
                segment2 = segment2.next;
                i3 = segment2.pos;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    public byte getByte(long j) {
        int i2;
        Util.checkOffsetAndCount(this.size, j, 1L);
        long j2 = this.size;
        if (j2 - j <= j) {
            long j3 = j - j2;
            Segment segment = this.head;
            do {
                segment = segment.prev;
                int i3 = segment.limit;
                i2 = segment.pos;
                j3 += (long) (i3 - i2);
            } while (j3 < 0);
            return segment.data[i2 + ((int) j3)];
        }
        Segment segment2 = this.head;
        while (true) {
            int i4 = segment2.limit;
            int i5 = segment2.pos;
            long j4 = i4 - i5;
            if (j < j4) {
                return segment2.data[i5 + ((int) j)];
            }
            j -= j4;
            segment2 = segment2.next;
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.limit;
            for (int i4 = segment.pos; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.data[i4];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i2;
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.Buffer.2
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & ExifInterface.MARKER;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) {
                return Buffer.this.read(bArr, i2, i3);
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public ByteString md5() {
        return digest("MD5");
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() { // from class: okio.Buffer.1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i2) {
                Buffer.this.writeByte((int) ((byte) i2));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Buffer.this.write(bArr, i2, i3);
            }
        };
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.size;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = this.head;
        int i2 = segment.pos;
        int i3 = segment.limit;
        int i4 = i2 + 1;
        byte b = segment.data[i2];
        this.size = j - 1;
        if (i4 == i3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return b;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // okio.BufferedSource
    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        r1 = new okio.Buffer().writeDecimalLong(r3).writeByte((int) r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r8 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readDecimalLong():long");
    }

    public Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a5 A[EDGE_INSN: B:45:0x00a5->B:38:0x00a5 BREAK  A[LOOP:0: B:5:0x000b->B:47:?], SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            okio.Segment r6 = r15.head
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r0 == 0) goto L76
            r1 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto L9f
        L9d:
            r6.pos = r8
        L9f:
            if (r1 != 0) goto La5
            okio.Segment r6 = r15.head
            if (r6 != 0) goto Lb
        La5:
            long r1 = r15.size
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.size = r1
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb5
        Lb4:
            throw r0
        Lb5:
            goto Lb4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.size;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        Segment segment = this.head;
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 4) {
            return ((readByte() & ExifInterface.MARKER) << 24) | ((readByte() & ExifInterface.MARKER) << 16) | ((readByte() & ExifInterface.MARKER) << 8) | (readByte() & ExifInterface.MARKER);
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & ExifInterface.MARKER) << 24) | ((bArr[i4] & ExifInterface.MARKER) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & ExifInterface.MARKER) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & ExifInterface.MARKER);
        this.size = j - 4;
        if (i9 == i3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i9;
        }
        return i10;
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        long j = this.size;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        Segment segment = this.head;
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        long j2 = (((long) bArr[i2]) & 255) << 56;
        int i5 = i4 + 1;
        long j3 = ((((long) bArr[i4]) & 255) << 48) | j2;
        int i6 = i5 + 1;
        long j4 = j3 | ((((long) bArr[i5]) & 255) << 40);
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 24);
        int i9 = i8 + 1;
        long j6 = j5 | ((((long) bArr[i8]) & 255) << 16);
        int i10 = i9 + 1;
        long j7 = j6 | ((((long) bArr[i9]) & 255) << 8);
        int i11 = i10 + 1;
        long j8 = j7 | (((long) bArr[i10]) & 255);
        this.size = j - 8;
        if (i11 == i3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i11;
        }
        return j8;
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        return Util.reverseBytesLong(readLong());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.size;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        Segment segment = this.head;
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 2) {
            return (short) (((readByte() & ExifInterface.MARKER) << 8) | (readByte() & ExifInterface.MARKER));
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & ExifInterface.MARKER) << 8) | (bArr[i4] & ExifInterface.MARKER);
        this.size = j - 2;
        if (i5 == i3) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (this.size == 0) {
            throw new EOFException();
        }
        byte b = getByte(0L);
        if ((b & 128) == 0) {
            i2 = b & 127;
            i3 = 1;
            i4 = 0;
        } else if ((b & 224) == 192) {
            i2 = b & 31;
            i3 = 2;
            i4 = 128;
        } else if ((b & 240) == 224) {
            i2 = b & 15;
            i3 = 3;
            i4 = 2048;
        } else {
            if ((b & 248) != 240) {
                skip(1L);
                return REPLACEMENT_CHARACTER;
            }
            i2 = b & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j = i3;
        if (this.size < j) {
            throw new EOFException("size < " + i3 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b) + ")");
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j2 = i5;
            byte b2 = getByte(j2);
            if ((b2 & 192) != 128) {
                skip(j2);
                return REPLACEMENT_CHARACTER;
            }
            i2 = (i2 << 6) | (b2 & 63);
        }
        skip(j);
        return i2 > 1114111 ? REPLACEMENT_CHARACTER : ((i2 < 55296 || i2 > 57343) && i2 >= i4) ? i2 : REPLACEMENT_CHARACTER;
    }

    @Override // okio.BufferedSource
    public String readUtf8Line() throws EOFException {
        long jIndexOf = indexOf((byte) 10);
        if (jIndexOf != -1) {
            return readUtf8Line(jIndexOf);
        }
        long j = this.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    public List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Segment segment = this.head;
        arrayList.add(Integer.valueOf(segment.limit - segment.pos));
        Segment segment2 = this.head;
        while (true) {
            segment2 = segment2.next;
            if (segment2 == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(segment2.limit - segment2.pos));
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        Segment segment = this.head;
        if (segment == null) {
            return options.indexOf(ByteString.EMPTY);
        }
        ByteString[] byteStringArr = options.byteStrings;
        int length = byteStringArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            ByteString byteString = byteStringArr[i2];
            if (this.size >= byteString.size() && rangeEquals(segment, segment.pos, byteString, 0, byteString.size())) {
                try {
                    skip(byteString.size());
                    return i2;
                } catch (EOFException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
        return -1;
    }

    public int selectPrefix(Options options) {
        Segment segment = this.head;
        ByteString[] byteStringArr = options.byteStrings;
        int length = byteStringArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            ByteString byteString = byteStringArr[i2];
            int iMin = (int) Math.min(this.size, byteString.size());
            if (iMin == 0 || rangeEquals(segment, segment.pos, byteString, 0, iMin)) {
                return i2;
            }
        }
        return -1;
    }

    public ByteString sha1() {
        return digest("SHA-1");
    }

    public ByteString sha256() {
        return digest("SHA-256");
    }

    public ByteString sha512() {
        return digest("SHA-512");
    }

    public long size() {
        return this.size;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.head == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, r0.limit - r0.pos);
            long j2 = iMin;
            this.size -= j2;
            j -= j2;
            Segment segment = this.head;
            int i2 = segment.pos + iMin;
            segment.pos = i2;
            if (i2 == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return snapshot().toString();
    }

    public Segment writableSegment(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment != null) {
            Segment segment2 = segment.prev;
            return (segment2.limit + i2 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        Segment segmentTake = SegmentPool.take();
        this.head = segmentTake;
        segmentTake.prev = segmentTake;
        segmentTake.next = segmentTake;
        return segmentTake;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long j2 = source.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    public Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment segmentSharedCopy = this.head.sharedCopy();
        buffer.head = segmentSharedCopy;
        segmentSharedCopy.prev = segmentSharedCopy;
        segmentSharedCopy.next = segmentSharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment == this.head) {
                buffer.size = this.size;
                return buffer;
            }
            buffer.head.prev.push(segment.sharedCopy());
        }
    }

    public Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, j, j2);
        if (j2 == 0) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            int i2 = segment.limit;
            int i3 = segment.pos;
            if (j < i2 - i3) {
                break;
            }
            j -= (long) (i2 - i3);
            segment = segment.next;
        }
        while (j2 > 0) {
            int i4 = (int) (((long) segment.pos) + j);
            int iMin = (int) Math.min(segment.limit - i4, j2);
            outputStream.write(segment.data, i4, iMin);
            j2 -= (long) iMin;
            segment = segment.next;
            j = 0;
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j) {
        return indexOf(b, j, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(ByteString byteString, long j) {
        int i2;
        int i3;
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long j3 = this.size;
        if (j3 - j < j) {
            while (j3 > j) {
                segment = segment.prev;
                j3 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j2;
                if (j4 >= j) {
                    break;
                }
                segment = segment.next;
                j2 = j4;
            }
            j3 = j2;
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j3 < this.size) {
                byte[] bArr = segment.data;
                i2 = (int) ((((long) segment.pos) + j) - j3);
                int i4 = segment.limit;
                while (i2 < i4) {
                    byte b3 = bArr[i2];
                    if (b3 == b || b3 == b2) {
                        i3 = segment.pos;
                        return ((long) (i2 - i3)) + j3;
                    }
                    i2++;
                }
                j3 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j = j3;
            }
            return -1L;
        }
        byte[] bArrInternalArray = byteString.internalArray();
        while (j3 < this.size) {
            byte[] bArr2 = segment.data;
            i2 = (int) ((((long) segment.pos) + j) - j3);
            int i5 = segment.limit;
            while (i2 < i5) {
                byte b4 = bArr2[i2];
                for (byte b5 : bArrInternalArray) {
                    if (b4 == b5) {
                        i3 = segment.pos;
                        return ((long) (i2 - i3)) + j3;
                    }
                }
                i2++;
            }
            j3 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j = j3;
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j, ByteString byteString, int i2, int i3) {
        if (j < 0 || i2 < 0 || i3 < 0 || this.size - j < i3 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (getByte(((long) i4) + j) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public int read(byte[] bArr, int i2, int i3) {
        Util.checkOffsetAndCount(bArr.length, i2, i3);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(i3, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i2, iMin);
        int i4 = segment.pos + iMin;
        segment.pos = i4;
        this.size -= (long) iMin;
        if (i4 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = true;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    public Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.buffer = this;
        unsafeCursor.readWrite = false;
        return unsafeCursor;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jIndexOf = indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return readUtf8Line(jIndexOf);
        }
        if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
            return readUtf8Line(j2);
        }
        Buffer buffer = new Buffer();
        copyTo(buffer, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + (char) 8230);
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i2) {
        Segment segmentWritableSegment = writableSegment(1);
        byte[] bArr = segmentWritableSegment.data;
        int i3 = segmentWritableSegment.limit;
        segmentWritableSegment.limit = i3 + 1;
        bArr[i3] = (byte) i2;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= NativeCrashHandler.NATIVE_RECORD_FILE_LOCK_EXPIRED_TIME) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment segmentWritableSegment = writableSegment(i2);
        byte[] bArr = segmentWritableSegment.data;
        int i3 = segmentWritableSegment.limit + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        segmentWritableSegment.limit += i2;
        this.size += (long) i2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment segmentWritableSegment = writableSegment(iNumberOfTrailingZeros);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        for (int i3 = (i2 + iNumberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment.limit += iNumberOfTrailingZeros;
        this.size += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i2) {
        Segment segmentWritableSegment = writableSegment(4);
        byte[] bArr = segmentWritableSegment.data;
        int i3 = segmentWritableSegment.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        segmentWritableSegment.limit = i6 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeIntLe(int i2) {
        return writeInt(Util.reverseBytesInt(i2));
    }

    @Override // okio.BufferedSink
    public Buffer writeLong(long j) {
        Segment segmentWritableSegment = writableSegment(8);
        byte[] bArr = segmentWritableSegment.data;
        int i2 = segmentWritableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j >>> 8) & 255);
        bArr[i9] = (byte) (j & 255);
        segmentWritableSegment.limit = i9 + 1;
        this.size += 8;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeLongLe(long j) {
        return writeLong(Util.reverseBytesLong(j));
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i2) {
        Segment segmentWritableSegment = writableSegment(2);
        byte[] bArr = segmentWritableSegment.data;
        int i3 = segmentWritableSegment.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        segmentWritableSegment.limit = i4 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShortLe(int i2) {
        return writeShort((int) Util.reverseBytesShort((short) i2));
    }

    public Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0L, j);
        Segment segment = this.head;
        while (j > 0) {
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, iMin);
            int i2 = segment.pos + iMin;
            segment.pos = i2;
            long j2 = iMin;
            this.size -= j2;
            j -= j2;
            if (i2 == segment.limit) {
                Segment segmentPop = segment.pop();
                this.head = segmentPop;
                SegmentPool.recycle(segment);
                segment = segmentPop;
            }
        }
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8CodePoint(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            writeByte((i2 >> 6) | 192);
            writeByte((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 < 55296 || i2 > 57343) {
                writeByte((i2 >> 12) | 224);
                writeByte(((i2 >> 6) & 63) | 128);
                writeByte((i2 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else {
            if (i2 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
            }
            writeByte((i2 >> 18) | OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_3);
            writeByte(((i2 >> 12) & 63) | 128);
            writeByte(((i2 >> 6) & 63) | 128);
            writeByte((i2 & 63) | 128);
        }
        return this;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.size;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (segment = this.head) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    segment = segment.prev;
                    j4 -= (long) (segment.limit - segment.pos);
                }
            } else {
                while (true) {
                    long j6 = ((long) (segment.limit - segment.pos)) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    segment = segment.next;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = segment.data;
                int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j5) - j4);
                for (int i2 = (int) ((((long) segment.pos) + j7) - j4); i2 < iMin; i2++) {
                    if (bArr[i2] == b) {
                        return ((long) (i2 - segment.pos)) + j4;
                    }
                }
                j4 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.BufferedSource
    public String readString(long j, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        Segment segment = this.head;
        if (((long) segment.pos) + j > segment.limit) {
            return new String(readByteArray(j), charset);
        }
        String str = new String(segment.data, segment.pos, (int) j, charset);
        int i2 = (int) (((long) segment.pos) + j);
        segment.pos = i2;
        this.size -= j;
        if (i2 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    @Override // okio.BufferedSource
    public String readUtf8(long j) throws EOFException {
        return readString(j, Util.UTF_8);
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            Segment segmentWritableSegment = writableSegment(1);
            int i2 = inputStream.read(segmentWritableSegment.data, segmentWritableSegment.limit, (int) Math.min(j, 8192 - segmentWritableSegment.limit));
            if (i2 == -1) {
                if (!z) {
                    throw new EOFException();
                }
                return;
            } else {
                segmentWritableSegment.limit += i2;
                long j2 = i2;
                this.size += j2;
                j -= j2;
            }
        }
    }

    public String readUtf8Line(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String utf8 = readUtf8(j2);
                skip(2L);
                return utf8;
            }
        }
        String utf82 = readUtf8(j);
        skip(1L);
        return utf82;
    }

    public ByteString snapshot(int i2) {
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        return new SegmentedByteString(this, i2);
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // okio.BufferedSink
    public Buffer writeString(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i2);
        }
        if (i3 >= i2) {
            if (i3 <= str.length()) {
                if (charset != null) {
                    if (charset.equals(Util.UTF_8)) {
                        return writeUtf8(str, i2, i3);
                    }
                    byte[] bytes = str.substring(i2, i3).getBytes(charset);
                    return write(bytes, 0, bytes.length);
                }
                throw new IllegalArgumentException("charset == null");
            }
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str, int i2, int i3) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i2);
        }
        if (i3 >= i2) {
            if (i3 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
            }
            while (i2 < i3) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < 128) {
                    Segment segmentWritableSegment = writableSegment(1);
                    byte[] bArr = segmentWritableSegment.data;
                    int i4 = segmentWritableSegment.limit - i2;
                    int iMin = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) cCharAt;
                    while (i5 < iMin) {
                        char cCharAt2 = str.charAt(i5);
                        if (cCharAt2 >= 128) {
                            break;
                        }
                        bArr[i5 + i4] = (byte) cCharAt2;
                        i5++;
                    }
                    int i6 = segmentWritableSegment.limit;
                    int i7 = (i4 + i5) - i6;
                    segmentWritableSegment.limit = i6 + i7;
                    this.size += (long) i7;
                    i2 = i5;
                } else {
                    if (cCharAt < 2048) {
                        writeByte((cCharAt >> 6) | 192);
                        writeByte((cCharAt & '?') | 128);
                    } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                        int i8 = i2 + 1;
                        char cCharAt3 = i8 < i3 ? str.charAt(i8) : (char) 0;
                        if (cCharAt <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i9 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            writeByte((i9 >> 18) | OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_3);
                            writeByte(((i9 >> 12) & 63) | 128);
                            writeByte(((i9 >> 6) & 63) | 128);
                            writeByte((i9 & 63) | 128);
                            i2 += 2;
                        } else {
                            writeByte(63);
                            i2 = i8;
                        }
                    } else {
                        writeByte((cCharAt >> '\f') | 224);
                        writeByte(((cCharAt >> 6) & 63) | 128);
                        writeByte((cCharAt & '?') | 128);
                    }
                    i2++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
    }

    private boolean rangeEquals(Segment segment, int i2, ByteString byteString, int i3, int i4) {
        int i5 = segment.limit;
        byte[] bArr = segment.data;
        while (i3 < i4) {
            if (i2 == i5) {
                segment = segment.next;
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i2 = segment.pos;
                i5 = segment.limit;
            }
            if (bArr[i2] != byteString.getByte(i3)) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int i3 = read(bArr, i2, bArr.length - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = i3;
            Util.checkOffsetAndCount(bArr.length, i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                Segment segmentWritableSegment = writableSegment(1);
                int iMin = Math.min(i4 - i2, 8192 - segmentWritableSegment.limit);
                System.arraycopy(bArr, i2, segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
                i2 += iMin;
                segmentWritableSegment.limit += iMin;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            Util.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
            Segment segment = this.head;
            while (true) {
                int i2 = segment.limit;
                int i3 = segment.pos;
                if (j < i2 - i3) {
                    break;
                }
                j -= (long) (i2 - i3);
                segment = segment.next;
            }
            while (j2 > 0) {
                Segment segmentSharedCopy = segment.sharedCopy();
                int i4 = (int) (((long) segmentSharedCopy.pos) + j);
                segmentSharedCopy.pos = i4;
                segmentSharedCopy.limit = Math.min(i4 + ((int) j2), segmentSharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    segmentSharedCopy.prev = segmentSharedCopy;
                    segmentSharedCopy.next = segmentSharedCopy;
                    buffer.head = segmentSharedCopy;
                } else {
                    segment2.prev.push(segmentSharedCopy);
                }
                j2 -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
                segment = segment.next;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, iMin);
        int i2 = segment.pos + iMin;
        segment.pos = i2;
        this.size -= (long) iMin;
        if (i2 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int iRemaining = byteBuffer.remaining();
            int i2 = iRemaining;
            while (i2 > 0) {
                Segment segmentWritableSegment = writableSegment(1);
                int iMin = Math.min(i2, 8192 - segmentWritableSegment.limit);
                byteBuffer.get(segmentWritableSegment.data, segmentWritableSegment.limit, iMin);
                i2 -= iMin;
                segmentWritableSegment.limit += iMin;
            }
            this.size += (long) iRemaining;
            return iRemaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public long indexOf(ByteString byteString, long j) throws IOException {
        byte[] bArr;
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j >= 0) {
            Segment segment = this.head;
            long j3 = -1;
            if (segment == null) {
                return -1L;
            }
            long j4 = this.size;
            if (j4 - j < j) {
                while (j4 > j) {
                    segment = segment.prev;
                    j4 -= (long) (segment.limit - segment.pos);
                }
            } else {
                while (true) {
                    long j5 = ((long) (segment.limit - segment.pos)) + j2;
                    if (j5 >= j) {
                        break;
                    }
                    segment = segment.next;
                    j2 = j5;
                }
                j4 = j2;
            }
            byte b = byteString.getByte(0);
            int size = byteString.size();
            long j6 = 1 + (this.size - ((long) size));
            long j7 = j;
            Segment segment2 = segment;
            long j8 = j4;
            while (j8 < j6) {
                byte[] bArr2 = segment2.data;
                int iMin = (int) Math.min(segment2.limit, (((long) segment2.pos) + j6) - j8);
                int i2 = (int) ((((long) segment2.pos) + j7) - j8);
                while (i2 < iMin) {
                    if (bArr2[i2] == b) {
                        bArr = bArr2;
                        if (rangeEquals(segment2, i2 + 1, byteString, 1, size)) {
                            return ((long) (i2 - segment2.pos)) + j8;
                        }
                    } else {
                        bArr = bArr2;
                    }
                    i2++;
                    bArr2 = bArr;
                }
                j8 += (long) (segment2.limit - segment2.pos);
                segment2 = segment2.next;
                j7 = j8;
                j3 = -1;
            }
            return j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // okio.BufferedSink
    public BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long j2 = source.read(this, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
        }
        return this;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0L, j);
            while (j > 0) {
                Segment segment = buffer.head;
                if (j < segment.limit - segment.pos) {
                    Segment segment2 = this.head;
                    Segment segment3 = segment2 != null ? segment2.prev : null;
                    if (segment3 != null && segment3.owner) {
                        if ((((long) segment3.limit) + j) - ((long) (segment3.shared ? 0 : segment3.pos)) <= 8192) {
                            segment.writeTo(segment3, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    buffer.head = segment.split((int) j);
                }
                Segment segment4 = buffer.head;
                long j2 = segment4.limit - segment4.pos;
                buffer.head = segment4.pop();
                Segment segment5 = this.head;
                if (segment5 == null) {
                    this.head = segment4;
                    segment4.prev = segment4;
                    segment4.next = segment4;
                } else {
                    segment5.prev.push(segment4).compact();
                }
                buffer.size -= j2;
                this.size += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
