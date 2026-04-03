package com.kugou.framework.musichunter;

import com.kugou.framework.libcommon.LogUtils;
import com.kugou.framework.libcommon.RequestPackage;
import com.kugou.framework.libcommon.netcore.HttpEntity;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProtocol {
    public String mMachineID = Utils.getMachineID();
    public String uuid = Utils.getUuid();

    public abstract class BaseRequestPackage implements RequestPackage {
        private final String url;

        public BaseRequestPackage(String str) {
            this.url = str;
        }

        public void appendSignature(Map<String, Object> map, byte[] bArr) {
            map.put("appid", Global.appId);
            map.put("dfid", "-");
            map.put("mid", BaseProtocol.this.mMachineID);
            map.put("uuid", BaseProtocol.this.uuid);
            map.put("clientver", Integer.valueOf(Global.CLIENT_VER));
            map.put("clienttime", String.valueOf(System.currentTimeMillis() / 1000));
            try {
                map.put("signature", Utils.getSignature(Global.appKey, Utils.map2SortString(map), bArr));
            } catch (IOException e2) {
                e2.printStackTrace();
                LogUtils.log("生成签名出现错误");
            }
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public Map<String, String> getHttpHeaders() {
            return null;
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return null;
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public String getRequestModuleName() {
            return Global.SP_NAME;
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public String getUrl() {
            return this.url;
        }
    }
}
