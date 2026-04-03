package com.kugou.framework.musichunter;

import com.kugou.framework.libcommon.netcore.HttpEntity;
import com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MusicPcmHttpProtocol extends BaseFingerPrintHttpProtocol {

    public class RecognizeRequestPackage extends BaseFingerPrintHttpProtocol.BaseRequestPackage {
        public RecognizeRequestPackage(byte[] bArr) {
            super(UrlSource.MUSIC_HUNTER_PCM, bArr);
        }

        @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol.BaseRequestPackage
        public void fillQueries(Map<String, Object> map) {
            map.put("fpid", Long.valueOf(MusicPcmHttpProtocol.this.uniqueID));
            map.put("area_code", Global.area_code);
            map.put("include_unpublish", 1);
            map.put("userid", 0);
        }

        @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol.BaseRequestPackage, com.kugou.framework.musichunter.BaseProtocol.BaseRequestPackage, com.kugou.framework.libcommon.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return new HttpEntity(this.param.fingerprintSlice, "application/octet-stream");
        }
    }

    public MusicPcmHttpProtocol(long j) {
        super(j);
    }

    @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol
    public BaseFingerPrintHttpProtocol.BaseRequestPackage createRequestPackage(RequestParam requestParam) {
        return new RecognizeRequestPackage(requestParam.fingerprintSlice);
    }

    @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol
    public /* bridge */ /* synthetic */ RecognizeResult requestIntime(RequestParam requestParam) {
        return super.requestIntime(requestParam);
    }
}
