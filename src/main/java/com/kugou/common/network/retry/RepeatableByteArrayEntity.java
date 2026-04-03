package com.kugou.common.network.retry;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

/* JADX INFO: loaded from: classes2.dex */
public class RepeatableByteArrayEntity extends AbstractHttpEntity {
    private final byte[] mData;

    public RepeatableByteArrayEntity(byte[] bArr) {
        this.mData = bArr;
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IllegalStateException, IOException {
        return new ByteArrayInputStream(this.mData);
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.mData.length;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.mData);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = byteArrayInputStream.read(bArr);
                if (i2 == -1) {
                    outputStream.flush();
                    return;
                }
                outputStream.write(bArr, 0, i2);
            }
        } finally {
            byteArrayInputStream.close();
        }
    }
}
