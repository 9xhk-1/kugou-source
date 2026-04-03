package com.kugou.framework.musichunter;

/* JADX INFO: loaded from: classes2.dex */
public class AudioBuffer {
    private byte[] data;
    private int length;

    public AudioBuffer(byte[] bArr, int i2) {
        this.data = bArr;
        this.length = i2;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getLength() {
        return this.length;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setLength(int i2) {
        this.length = i2;
    }
}
