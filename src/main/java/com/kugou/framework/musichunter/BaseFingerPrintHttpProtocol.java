package com.kugou.framework.musichunter;

import com.kugou.framework.libcommon.KGHttpClient;
import com.kugou.framework.libcommon.LogUtils;
import com.kugou.framework.libcommon.netcore.HttpEntity;
import com.kugou.framework.musichunter.BaseProtocol;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseFingerPrintHttpProtocol extends BaseProtocol {
    public long uniqueID;

    public static class RecoginizeResponsePackage extends StringResponsePackage<RecognizeResult> {
        private byte[] mData;

        @Override // com.kugou.framework.musichunter.StringResponsePackage, com.kugou.framework.libcommon.ResponsePackage
        public void setContext(byte[] bArr) {
            this.mData = bArr;
        }

        @Override // com.kugou.framework.musichunter.StringResponsePackage, com.kugou.framework.libcommon.ResponsePackage
        public void getResponseData(RecognizeResult recognizeResult) {
            byte[] bArr;
            if (recognizeResult == null || (bArr = this.mData) == null || bArr.length <= 0) {
                return;
            }
            try {
                recognizeResult.parse(new String(this.mData, "utf-8"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BaseFingerPrintHttpProtocol(long j) {
        this.uniqueID = j;
    }

    public abstract BaseRequestPackage createRequestPackage(RequestParam requestParam);

    public RecognizeResult requestIntime(RequestParam requestParam) {
        RecognizeResult recognizeResult = new RecognizeResult();
        BaseRequestPackage baseRequestPackageCreateRequestPackage = createRequestPackage(requestParam);
        RecoginizeResponsePackage recoginizeResponsePackage = new RecoginizeResponsePackage();
        try {
            LogUtils.log("music hunter network 网络请求开始");
            KGHttpClient.getInstance(Global.getGlobalContext()).request(baseRequestPackageCreateRequestPackage, recoginizeResponsePackage);
            recoginizeResponsePackage.getResponseData(recognizeResult);
            recognizeResult.setSuccess(true);
            LogUtils.log("music hunter network 网络请求结束");
        } catch (Exception e2) {
            e2.printStackTrace();
            recognizeResult.setSuccess(false);
            LogUtils.log("music hunter network 网络请求发生异常 " + e2.getMessage());
        }
        return recognizeResult;
    }

    public abstract class BaseRequestPackage extends BaseProtocol.BaseRequestPackage {
        public RequestParam param;

        public BaseRequestPackage(String str, byte[] bArr) {
            super(str);
            RequestParam requestParam = new RequestParam();
            this.param = requestParam;
            requestParam.fingerprintSlice = bArr;
        }

        public void fillQueries(Map<String, Object> map) {
            map.put("fpid", Long.valueOf(BaseFingerPrintHttpProtocol.this.uniqueID));
            map.put("area_code", Global.area_code);
            map.put("include_unpublish", 1);
            map.put("multi_result", 1);
            map.put("userid", 0);
            map.put("token", "");
            map.put("sdk", 1);
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public String getGetRequestParams() {
            HashMap map = new HashMap();
            fillQueries(map);
            appendSignature(map, this.param.fingerprintSlice);
            return Utils.toRequestParams(map);
        }

        @Override // com.kugou.framework.musichunter.BaseProtocol.BaseRequestPackage, com.kugou.framework.libcommon.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return new HttpEntity(this.param.fingerprintSlice, (String) null);
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public Map<String, Object> getRequestMapParams() {
            HashMap map = new HashMap();
            fillQueries(map);
            appendSignature(map, this.param.fingerprintSlice);
            return map;
        }

        @Override // com.kugou.framework.libcommon.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        public BaseRequestPackage(String str, RequestParam requestParam) {
            super(str);
            this.param = requestParam;
        }
    }
}
