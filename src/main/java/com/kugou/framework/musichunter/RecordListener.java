package com.kugou.framework.musichunter;

/* JADX INFO: loaded from: classes2.dex */
public interface RecordListener {
    void onAudioBuffer(byte[] bArr, int i2);

    void onAudioInit(int i2);

    void onRecordComplete(int i2, int i3, int i4);

    void onRecordError(String str);

    void onRecordInitFailure(int i2, int i3);

    void onVolumeChanged(double d2);
}
