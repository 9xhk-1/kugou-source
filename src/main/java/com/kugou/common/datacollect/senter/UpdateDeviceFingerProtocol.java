package com.kugou.common.datacollect.senter;

import com.kugou.common.player.kugouplayer.j;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.r.g.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.r1;
import e.c.a.g.a.s.t;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateDeviceFingerProtocol {
    public static final String MODULE_NAME = "UpdateDeviceFingerProtocol";

    public static class UpdateConverterFactory extends Converter.Factory {
        private final byte[] mParams;

        private UpdateConverterFactory(byte[] bArr) {
            this.mParams = bArr;
        }

        public static UpdateConverterFactory create(byte[] bArr) {
            return new UpdateConverterFactory(bArr);
        }

        @Override // retrofit2.Converter.Factory
        public Converter<ResponseBody, UpdateDfidResult> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return new Converter<ResponseBody, UpdateDfidResult>() { // from class: com.kugou.common.datacollect.senter.UpdateDeviceFingerProtocol.UpdateConverterFactory.1
                @Override // retrofit2.Converter
                public UpdateDfidResult convert(ResponseBody responseBody) throws IOException {
                    if (responseBody == null) {
                        return new UpdateDfidResult(0, 0, null);
                    }
                    try {
                        byte[] bArrV = j.v(UpdateConverterFactory.this.mParams, responseBody.bytes());
                        if (bArrV == null) {
                            if (g0.a) {
                                g0.e(UpdateDeviceFingerProtocol.MODULE_NAME, "convert wrong");
                            }
                            return new UpdateDfidResult(0, 0, null);
                        }
                        UpdateDfidResult updateDfidResult = (UpdateDfidResult) t.a(new String(bArrV), UpdateDfidResult.class);
                        if (g0.a) {
                            g0.e(UpdateDeviceFingerProtocol.MODULE_NAME, "convert updateDfidResult:" + updateDfidResult);
                        }
                        return updateDfidResult;
                    } catch (Exception unused) {
                        return new UpdateDfidResult(0, 0, null);
                    }
                }
            };
        }
    }

    public interface UpdateDeviceFingerApi {
        @POST
        Call<UpdateDfidResult> requestUpdateDfid(@HeaderMap Map<String, String> map, @QueryMap Map<String, String> map2, @Body RequestBody requestBody);
    }

    public static Call<UpdateDfidResult> requestUpdateDeviceFinger(byte[] bArr, String str, int i2) {
        if (g0.a) {
            g0.e(MODULE_NAME, "requestUpdateDeviceFinger");
        }
        UpdateDeviceFingerApi updateDeviceFingerApi = (UpdateDeviceFingerApi) new Retrofit.Builder().setModuleName(MODULE_NAME).addConverterFactory(UpdateConverterFactory.create(bArr)).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).setMultiUrl(r1.c(b.V2, "https://userservice.kugou.com/risk/v2/r_register_dev")).setExcludeEndChar().build().create(UpdateDeviceFingerApi.class);
        RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), str);
        c cVarZ = c.z();
        cVarZ.f("appid");
        cVarZ.c("platid", String.valueOf(1));
        cVarZ.i("clientver");
        cVarZ.h("clienttime");
        cVarZ.o("mid");
        cVarZ.q("userid");
        cVarZ.c("part", String.valueOf(i2));
        cVarZ.c("p", new String(bArr));
        cVarZ.c("dfid", e.c.a.g.a.f.m.b.m().f());
        Map<String, String> mapE = cVarZ.E();
        String strA = c.A(c.B(mapE) + str);
        mapE.put("signature", strA);
        HashMap map = new HashMap();
        map.put("signature", strA);
        c.y(map);
        return updateDeviceFingerApi.requestUpdateDfid(map, mapE, requestBodyCreate);
    }
}
