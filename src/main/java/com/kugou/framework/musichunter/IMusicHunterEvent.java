package com.kugou.framework.musichunter;

/* JADX INFO: loaded from: classes2.dex */
public interface IMusicHunterEvent {
    void onCancel(String str, int i2, boolean z);

    void onFinish(RecognizeResult recognizeResult, String str, int i2, int i3);

    void onFirstSliceSend();

    void onHunterStop();

    void onInitFailure(int i2);

    void onMusicHunterStart();

    void onNetError(RecognizeResult recognizeResult);

    void onNoStorage();

    void onRecognizeOnline();

    void onRecordError(int i2);

    void onRecordVolumeSize(double d2, boolean z);

    @Deprecated
    void onVolumeChanged(double d2);
}
