package com.kugou.common.filemanager.downloadengine.entity;

/* JADX INFO: loaded from: classes2.dex */
public enum FileDownloadState {
    FILE_DOWNLOAD_STATE_NONE,
    FILE_DOWNLOAD_STATE_WAITING,
    FILE_DOWNLOAD_STATE_DOWNLOADING,
    FILE_DOWNLOAD_STATE_STOP,
    FILE_DOWNLOAD_STATE_FAILED,
    FILE_DOWNLOAD_STATE_SUCCEEDED,
    FILE_DOWNLOAD_STATE_MOCK_WAITING;

    public static boolean isWaitingOrDownloading(int i2) {
        return i2 == FILE_DOWNLOAD_STATE_WAITING.ordinal() || i2 == FILE_DOWNLOAD_STATE_DOWNLOADING.ordinal();
    }

    public static FileDownloadState stateOf(int i2) {
        FileDownloadState[] fileDownloadStateArrValues = values();
        return (i2 < 0 || i2 >= fileDownloadStateArrValues.length) ? FILE_DOWNLOAD_STATE_NONE : fileDownloadStateArrValues[i2];
    }
}
