package com.kugou.framework.musichunter;

import com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MusicFCHttpProtocol extends BaseFingerPrintHttpProtocol {
    private int recordType;

    public class RecognizeRequestPackage extends BaseFingerPrintHttpProtocol.BaseRequestPackage {
        private final int fcIndex;

        public RecognizeRequestPackage(byte[] bArr, int i2) {
            super(UrlSource.MUSIC_HUNTER_FC, bArr);
            this.fcIndex = i2;
        }

        @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol.BaseRequestPackage
        public void fillQueries(Map<String, Object> map) {
            super.fillQueries(map);
            map.put("index", Integer.valueOf(this.fcIndex));
            map.put("request_type", Integer.valueOf(MusicFCHttpProtocol.this.recordType));
            map.put("userid", 0);
        }
    }

    public MusicFCHttpProtocol(long j, int i2) {
        super(j);
        this.recordType = i2;
    }

    @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol
    public BaseFingerPrintHttpProtocol.BaseRequestPackage createRequestPackage(RequestParam requestParam) {
        return new RecognizeRequestPackage(requestParam.fingerprintSlice, requestParam.fcIndex);
    }

    @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol
    public /* bridge */ /* synthetic */ RecognizeResult requestIntime(RequestParam requestParam) {
        return super.requestIntime(requestParam);
    }
}
