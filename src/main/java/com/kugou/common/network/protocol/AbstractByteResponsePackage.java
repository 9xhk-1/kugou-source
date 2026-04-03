package com.kugou.common.network.protocol;

import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.networkutils.Convertor;
import com.kugou.common.network.networkutils.MD5Util;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractByteResponsePackage<T> implements ResponsePackage<T> {
    public int readDWord(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        readFullBytes(inputStream, bArr);
        return Convertor.bytesToInt(bArr);
    }

    public void readFullBytes(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        while (length > 0) {
            int i2 = inputStream.read(bArr, bArr.length - length, length);
            if (i2 < 0) {
                throw new IOException("read over at " + length + "/" + bArr.length);
            }
            length -= i2;
        }
    }

    public String readHash(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[16];
        readFullBytes(inputStream, bArr);
        StringBuilder sb = new StringBuilder(32);
        for (int i2 = 0; i2 < 16; i2++) {
            sb.append(MD5Util.byteHEX(bArr[i2]));
        }
        return sb.toString();
    }

    public String readString(InputStream inputStream, int i2) throws IOException {
        if (i2 <= 0) {
            return null;
        }
        byte[] bArr = new byte[i2];
        readFullBytes(inputStream, bArr);
        return new String(bArr, AbsHttpClient.GB2312);
    }

    public short readWord(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[2];
        readFullBytes(inputStream, bArr);
        return Convertor.byteToShort(bArr);
    }
}
