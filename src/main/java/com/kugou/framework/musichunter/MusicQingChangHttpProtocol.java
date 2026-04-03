package com.kugou.framework.musichunter;

import com.kugou.framework.libcommon.netcore.HttpEntity;
import com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MusicQingChangHttpProtocol extends BaseFingerPrintHttpProtocol {

    public class RecognizeRequestPackage extends BaseFingerPrintHttpProtocol.BaseRequestPackage {
        public int index;
        public boolean pcmEnd;

        public RecognizeRequestPackage(byte[] bArr, boolean z, int i2) {
            super(UrlSource.MUSIC_HUNTER_QC, bArr);
            this.index = i2;
            this.pcmEnd = z;
        }

        @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol.BaseRequestPackage
        public void fillQueries(Map<String, Object> map) {
            map.put("area_code", Global.area_code);
            map.put("userid", 0);
            map.put("token", "");
            map.put("sdk", 1);
            map.put("uuid", MusicQingChangHttpProtocol.this.uuid);
            map.put("reqid", Long.valueOf(MusicQingChangHttpProtocol.this.uniqueID));
            map.put("pcm_sn", Integer.valueOf(this.index));
            map.put("last", this.pcmEnd ? "1" : "0");
            map.put("mid", MusicQingChangHttpProtocol.this.mMachineID);
            map.put("dfid", "-");
        }

        @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol.BaseRequestPackage, com.kugou.framework.musichunter.BaseProtocol.BaseRequestPackage, com.kugou.framework.libcommon.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return new HttpEntity(this.param.fingerprintSlice, "application/octet-stream");
        }
    }

    public MusicQingChangHttpProtocol(long j) {
        super(j);
    }

    @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol
    public BaseFingerPrintHttpProtocol.BaseRequestPackage createRequestPackage(RequestParam requestParam) {
        return new RecognizeRequestPackage(requestParam.fingerprintSlice, requestParam.isLast, requestParam.index);
    }

    @Override // com.kugou.framework.musichunter.BaseFingerPrintHttpProtocol
    public /* bridge */ /* synthetic */ RecognizeResult requestIntime(RequestParam requestParam) {
        return super.requestIntime(requestParam);
    }
}
