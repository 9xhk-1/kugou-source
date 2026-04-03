package com.kugou.common.filemanager.downloadengine;

/* JADX INFO: loaded from: classes2.dex */
public interface IPlayBufferQuery {

    public static class PlayBufferInfo {
        public long playBufferSize;
        public long playPosition;

        public PlayBufferInfo(long j, long j2) {
            this.playPosition = j;
            this.playBufferSize = j2;
        }

        public long getPlayBufferSize() {
            return this.playBufferSize;
        }

        public long getPlayPosition() {
            return this.playPosition;
        }
    }

    Object query(String str);
}
