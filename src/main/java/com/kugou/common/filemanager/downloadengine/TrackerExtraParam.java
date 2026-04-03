package com.kugou.common.filemanager.downloadengine;

/* JADX INFO: loaded from: classes2.dex */
public class TrackerExtraParam {
    public String businessJson = "";
    public CommonAuth commonAuth;
    public MusicRadio musicRadio;

    public static class CommonAuth {
        public String auth;
        public int moduleId;
        public String openTime;

        public CommonAuth(String str, int i2, String str2) {
            this.auth = str;
            this.moduleId = i2;
            this.openTime = str2;
        }
    }

    public static class MusicRadio {
        public long radioTimestamp;
        public String radioToken;

        public MusicRadio(long j, String str) {
            this.radioTimestamp = j;
            this.radioToken = str;
        }
    }
}
