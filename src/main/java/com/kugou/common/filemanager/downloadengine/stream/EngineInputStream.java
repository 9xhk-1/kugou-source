package com.kugou.common.filemanager.downloadengine.stream;

import com.kugou.common.filemanager.downloadengine.Engine;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class EngineInputStream extends InputStream {
    private Engine engine;
    private long pos;
    private long stream;

    public EngineInputStream(long j, Engine engine) {
        this.stream = j;
        this.engine = engine;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.stream;
        if (j != 0) {
            this.engine.releaseStream(j);
            this.stream = 0L;
        }
    }

    public long getLength() throws IOException {
        long j = this.stream;
        if (j == 0) {
            throw new IOException("stream invalid or closed");
        }
        long streamLength = this.engine.getStreamLength(j);
        if (streamLength >= 0) {
            return streamLength;
        }
        throw new IOException("stream invalid or failed");
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j = this.stream;
        if (j == 0) {
            return -1;
        }
        byte[] bArr = new byte[1];
        int stream = this.engine.readStream(j, this.pos, bArr);
        if (stream == 1) {
            this.pos++;
            return bArr[0];
        }
        if (stream == 0) {
            return -1;
        }
        throw new IOException("stream closed or failed");
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        this.pos += j;
        return j;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        long j = this.stream;
        if (j != 0) {
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            byte[] bArr2 = new byte[i3];
            int stream = this.engine.readStream(j, this.pos, bArr2);
            if (stream < 0) {
                throw new IOException("stream closed or failed");
            }
            if (stream <= 0) {
                return -1;
            }
            this.pos += (long) stream;
            for (int i4 = 0; i4 < stream; i4++) {
                bArr[i2 + i4] = bArr2[i4];
            }
            return stream;
        }
        throw new IOException("stream invalid or closed");
    }
}
