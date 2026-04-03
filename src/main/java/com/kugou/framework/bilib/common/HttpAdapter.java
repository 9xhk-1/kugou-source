package com.kugou.framework.bilib.common;

import androidx.core.app.NotificationCompat;
import com.kugou.framework.bilib.statistics.cscc.protocol.CsccGenProtocol;
import com.kugou.framework.bilib.statistics.cscc.protocol.CsccPostProtocol;
import com.kugou.framework.libcommon.KGHttpClient;
import com.kugou.framework.libcommon.RequestPackage;
import com.kugou.framework.libcommon.ResponsePackage;
import com.kugou.framework.libcommon.netcore.HttpEntity;
import com.kugou.framework.musichunter.Global;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class HttpAdapter {
    private static NetService2 sNetService2;

    public static abstract class BaseRequestPackage implements RequestPackage {
        private final String url;

        public static class GetRequestPackage extends BaseRequestPackage {
            private final Map<String, Object> param;

            public GetRequestPackage(String str, Map<String, Object> map) {
                super(str);
                this.param = map;
            }

            @Override // com.kugou.framework.libcommon.RequestPackage
            public String getGetRequestParams() {
                return BaseRequestPackage.toRequestParams(this.param);
            }

            @Override // com.kugou.framework.libcommon.RequestPackage
            public Map<String, Object> getRequestMapParams() {
                return this.param;
            }

            @Override // com.kugou.framework.libcommon.RequestPackage
            public String getRequestType() {
                return "GET";
            }
        }

        public BaseRequestPackage(String str) {
            this.url = str;
        }

        public static String toRequestParams(Map<String, ?> map) {
            if (map == null || map.isEmpty()) {
                return "";
            }
            Iterator<String> it = map.keySet().iterator();
            StringBuilder sb = new StringBuilder();
            String next = it.next();
            String strEncode = URLEncoder.encode(String.valueOf(map.get(next)));
            sb.append(next);
            sb.append('=');
            sb.append(strEncode);
            while (it.hasNext()) {
                sb.append('&');
                String next2 = it.next();
                String strEncode2 = URLEncoder.encode(String.valueOf(map.get(next2)));
                sb.append(next2);
                sb.append('=');
                sb.append(strEncode2);
            }
            return sb.toString();
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

    public static class CsccGenEntityResponse extends StringResponsePackage<CsccGenProtocol.CsccGenEntity> {
        public CsccGenEntityResponse() {
            super();
        }

        @Override // com.kugou.framework.bilib.common.HttpAdapter.StringResponsePackage, com.kugou.framework.libcommon.ResponsePackage
        public void getResponseData(CsccGenProtocol.CsccGenEntity csccGenEntity) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonString());
                csccGenEntity.status = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                csccGenEntity.errCode = jSONObject.optInt("errcode");
                csccGenEntity.data = jSONObject.optString("data");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            super.getResponseData(csccGenEntity);
        }
    }

    public static class CsccPostEntityResponse extends StringResponsePackage<CsccPostProtocol.CsccPostEntity> {
        public CsccPostEntityResponse() {
            super();
        }

        @Override // com.kugou.framework.bilib.common.HttpAdapter.StringResponsePackage, com.kugou.framework.libcommon.ResponsePackage
        public void getResponseData(CsccPostProtocol.CsccPostEntity csccPostEntity) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonString());
                csccPostEntity.status = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                csccPostEntity.errCode = jSONObject.optInt("errcode");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            super.getResponseData(csccPostEntity);
        }
    }

    public static class NetService2 {
        private static CsccPostProtocol.CsccPostEntity doPost(String str, final Map<String, Object> map, final byte[] bArr) {
            BaseRequestPackage baseRequestPackage = new BaseRequestPackage(str) { // from class: com.kugou.framework.bilib.common.HttpAdapter.NetService2.2
                @Override // com.kugou.framework.libcommon.RequestPackage
                public String getGetRequestParams() {
                    return BaseRequestPackage.toRequestParams(map);
                }

                @Override // com.kugou.framework.bilib.common.HttpAdapter.BaseRequestPackage, com.kugou.framework.libcommon.RequestPackage
                public HttpEntity getPostRequestEntity() {
                    return new HttpEntity(bArr, "");
                }

                @Override // com.kugou.framework.libcommon.RequestPackage
                public Map<String, Object> getRequestMapParams() {
                    return map;
                }

                @Override // com.kugou.framework.libcommon.RequestPackage
                public String getRequestType() {
                    return "POST";
                }
            };
            CsccPostEntityResponse csccPostEntityResponse = new CsccPostEntityResponse();
            try {
                CsccPostProtocol.CsccPostEntity csccPostEntity = new CsccPostProtocol.CsccPostEntity();
                KGHttpClient.getInstance(LibConfig.getContext()).request(baseRequestPackage, csccPostEntityResponse);
                csccPostEntityResponse.getResponseData(csccPostEntity);
                return csccPostEntity;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public CsccGenProtocol.CsccGenEntity getGen2(Map<String, Object> map) {
            BaseRequestPackage.GetRequestPackage getRequestPackage = new BaseRequestPackage.GetRequestPackage(HttpAdapter.getGenUrl(), map) { // from class: com.kugou.framework.bilib.common.HttpAdapter.NetService2.1
                @Override // com.kugou.framework.bilib.common.HttpAdapter.BaseRequestPackage, com.kugou.framework.libcommon.RequestPackage
                public Map<String, String> getHttpHeaders() {
                    HashMap map2 = new HashMap();
                    map2.put("platform", "android");
                    return map2;
                }
            };
            CsccGenEntityResponse csccGenEntityResponse = new CsccGenEntityResponse();
            try {
                CsccGenProtocol.CsccGenEntity csccGenEntity = new CsccGenProtocol.CsccGenEntity();
                KGHttpClient.getInstance(LibConfig.getContext()).request(getRequestPackage, csccGenEntityResponse);
                csccGenEntityResponse.getResponseData(csccGenEntity);
                return csccGenEntity;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public CsccPostProtocol.CsccPostEntity postDataApm(Map<String, Object> map, byte[] bArr) {
            return doPost(LibConfig.getInstance().getApmUrl() + "v2/post", map, bArr);
        }

        public CsccPostProtocol.CsccPostEntity postDataDomain2(Map<String, Object> map, byte[] bArr) {
            return doPost(LibConfig.getInstance().getBaseHost2() + "v2/post", map, bArr);
        }

        public CsccPostProtocol.CsccPostEntity postDataNOR(Map<String, Object> map, byte[] bArr) {
            return doPost(LibConfig.getInstance().getNorUrl() + "v2/post", map, bArr);
        }
    }

    public static class StringResponsePackage<E> implements ResponsePackage<E> {
        public String mJsonString;

        private StringResponsePackage() {
        }

        public String getJsonString() {
            return this.mJsonString;
        }

        @Override // com.kugou.framework.libcommon.ResponsePackage
        public void getResponseData(E e2) {
        }

        @Override // com.kugou.framework.libcommon.ResponsePackage
        public void setContext(byte[] bArr) {
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            try {
                this.mJsonString = new String(bArr, Charset.forName("UTF-8"));
            } catch (Exception unused) {
            }
        }
    }

    public static String getGenUrl() {
        return LibConfig.getInstance().getNorUrl() + "v2/gen";
    }

    public static NetService2 getsNetService2() {
        return sNetService2;
    }

    public static void init() {
        try {
            sNetService2 = new NetService2();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
