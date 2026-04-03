package com.kugou.common.datacollect.senter;

import android.support.annotation.IntRange;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.datacollect.senter.UpdateDfidResult;
import com.kugou.common.datacollect.senter.vo.DeviceData;
import com.kugou.common.datacollect.util.AesEncryptionUtil;
import com.kugou.common.network.ExceptionParse;
import com.kugou.common.network.RequestDelay;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.networkutils.SecureSignUtil;
import com.kugou.common.network.protocol.ResponsePackage;
import com.kugou.common.player.kugouplayer.j;
import com.kugou.common.setting.QrydidIDHelper;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.k.a;
import e.c.a.g.a.f.k.k.e;
import e.c.a.g.a.s.f1;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.t;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONObject;
import retrofit2.Response;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateDeviceIdModel {
    private static final String TAG = "UpdateDeviceIdModel";
    private static volatile boolean hasUpdateDeviceIdByNet = false;
    private static volatile UpdateDeviceIdModel instance;
    private boolean hasRequestUpdateDfid;
    private final Object idsLock = new Object();
    private final long[] phoneIds = new long[2];
    private final int deviceIdVersion = 2;
    private int requestCount = 0;
    private boolean hasSendBigPackage = false;

    public static class CsccPostEntity {
        public static final int ERROR_CODE_1310 = 1310;
        public static final int ERROR_CODE_1311 = 1311;
        public String eid;
        public int errCode;
        public RequestDelay requestDelay;
        public int status;
        public long deviceId = 0;
        public long machineId = 0;
        public String dfid = "";

        public boolean isSuccess(boolean z) {
            int i2;
            return z ? this.status == 1 || (i2 = this.errCode) == 1310 || i2 == 1311 : this.status == 1 || this.errCode == 1311;
        }

        public String toString() {
            return "CsccPostEntity{deviceId=" + this.deviceId + ", machineId=" + this.machineId + ", dfid='" + this.dfid + "', status=" + this.status + ", errCode=" + this.errCode + ", eid='" + this.eid + "', requestDelay=" + this.requestDelay + '}';
        }
    }

    public static class PostResponsePackage implements ResponsePackage<CsccPostEntity> {
        private String mRawString;

        private PostResponsePackage() {
        }

        @Override // com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.IGNORE;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
        }

        @Override // com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                try {
                    this.mRawString = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    g0.k(e2);
                }
            }
            if (g0.f()) {
                Log.d("BLUE", "CsccPostProtocol got result " + this.mRawString);
            }
        }

        @Override // com.kugou.common.network.protocol.ResponsePackage
        public void getResponseData(CsccPostEntity csccPostEntity) {
            try {
                if (g0.f()) {
                    Log.d("siganid", "UpdateDeviceIdModel mRawString:" + this.mRawString);
                }
                JSONObject jSONObject = new JSONObject(this.mRawString);
                csccPostEntity.status = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                csccPostEntity.errCode = jSONObject.getInt("errcode");
                csccPostEntity.deviceId = Long.parseLong(jSONObject.getJSONObject("data").getString("deviceid"));
                csccPostEntity.machineId = jSONObject.getJSONObject("data").getLong("machineid");
            } catch (Exception e2) {
                g0.k(e2);
            }
        }
    }

    public static class RequestPackage extends a {
        public byte[] mData;

        public RequestPackage(byte[] bArr) {
            this.mData = bArr;
        }

        @Override // e.c.a.g.a.f.k.a
        public String getDefaultUrl() {
            return "https://gatecollect.kugou.com/collect/v3/query";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            return new ByteArrayEntity(this.mData);
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "CsccPost";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // e.c.a.g.a.f.k.a
        public ConfigKey getUrlConfigKey() {
            return b.W2;
        }
    }

    private UpdateDeviceIdModel() {
    }

    public static UpdateDeviceIdModel init() {
        if (instance == null) {
            synchronized (UpdateDeviceIdModel.class) {
                if (instance == null) {
                    instance = new UpdateDeviceIdModel();
                }
            }
        }
        return instance;
    }

    private long[] lookupPhoneIds() {
        synchronized (this.idsLock) {
            long[] jArr = this.phoneIds;
            long j = jArr[0];
            long j2 = jArr[1];
            if (j > 0) {
                if (g0.f()) {
                    Log.d(TAG, "lookupPhoneIds11: return : " + j);
                }
                return this.phoneIds;
            }
            long jC = e.c.a.g.a.f.m.b.m().c();
            long jD = e.c.a.g.a.f.m.b.m().d();
            String strF = e.c.a.g.a.f.m.b.m().f();
            if (g0.f()) {
                Log.d(TAG, "lookupPhoneIds22: devId:" + jC + " machineId:" + jD + " dfId:" + strF);
            }
            if (jC > 0 && jD > 0 && !isDeviceIdExpire() && !TextUtils.isEmpty(strF) && !"-".equals(strF)) {
                long[] jArr2 = this.phoneIds;
                jArr2[0] = jC;
                jArr2[1] = jD;
                if (!this.hasRequestUpdateDfid) {
                    this.hasRequestUpdateDfid = true;
                    j0.b().a(new Runnable() { // from class: com.kugou.common.datacollect.senter.UpdateDeviceIdModel.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g0.f()) {
                                Log.i(UpdateDeviceIdModel.TAG, " run: requestUpdateDfid  in new thread :");
                            }
                            UpdateDeviceIdModel.this.requestUpdateDfid(0);
                        }
                    });
                }
                return this.phoneIds;
            }
            if (g0.f()) {
                Log.d(TAG, "lookupPhoneIds33: from server " + g0.d());
            }
            updateDeviceIdByNet(jC, jD);
            if (g0.f()) {
                Log.i(TAG, " lookupPhoneIds: 1234:");
            }
            requestUpdateDfid(1);
            return this.phoneIds;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUpdateDfid(@IntRange(from = 0, to = 2) int i2) {
        int i3;
        if (g0.f()) {
            Log.e(TAG, " requestUpdateDfid:  request times:" + this.requestCount);
        }
        if (this.requestCount > 10) {
            return;
        }
        if (this.hasSendBigPackage) {
            if (g0.f()) {
                Log.e(TAG, " requestUpdateDfid: already send big package. abort :");
                return;
            }
            return;
        }
        String[] strArr = {""};
        String strF = e.c.a.g.a.f.m.b.m().f();
        if (g0.f()) {
            Log.i(TAG, " requestUpdateDfid: dfid :" + strF);
        }
        if (TextUtils.isEmpty(strF) || "-".equals(strF) || i2 > 0) {
            strArr[0] = t.c(new DeviceFingerModel().getDeviceFingerBean(i2));
            if (g0.f()) {
                Log.i(TAG, "big requestUpdateDfid: deviceFingerStr :" + strArr[0]);
            }
            this.hasSendBigPackage = true;
            i3 = 0;
        } else {
            strArr[0] = t.c(SmallDeviceFingerModel.init().getDeviceFingerBean());
            if (g0.f()) {
                Log.i(TAG, " small requestUpdateDfid: deviceFingerStr :" + strArr[0]);
            }
            i3 = 1;
        }
        j.A aU = j.u(strArr[0].getBytes());
        if (aU == null) {
            if (g0.f()) {
                Log.e(TAG, " requestUpdateDfid: pAndDf is null:");
                return;
            }
            return;
        }
        try {
            this.requestCount++;
            Response<UpdateDfidResult> responseExecute = UpdateDeviceFingerProtocol.requestUpdateDeviceFinger(aU.r, e.c.a.g.a.r.g.b.a(AesEncryptionUtil.hex2byte(new String(aU.a))), i3).execute();
            if (!responseExecute.isSuccessful() || responseExecute.body() == null) {
                if (g0.f()) {
                    Log.d(TAG, "requestUpdateDfid fail, " + responseExecute);
                    return;
                }
                return;
            }
            UpdateDfidResult updateDfidResultBody = responseExecute.body();
            UpdateDfidResult.DataBean data = updateDfidResultBody.getData();
            if (g0.f()) {
                Log.i(TAG, " requestUpdateDfid: model :" + updateDfidResultBody);
            }
            if (updateDfidResultBody.getStatus() != 1 || data == null) {
                return;
            }
            if (!TextUtils.isEmpty(data.getDfid())) {
                e.c.a.g.a.f.m.b.m().L(data.getDfid());
            }
            if (data.getScheme() == 1 || data.getScheme() == 2) {
                if (g0.f()) {
                    Log.i(TAG, " requestUpdateDfid: scheme :" + data.getScheme());
                }
                requestUpdateDfid(data.getScheme());
            }
        } catch (IOException e2) {
            if (g0.f()) {
                Log.i(TAG, " requestUpdateDfid: :" + e2.getMessage());
            }
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDeviceIdByNet(long j, long j2) {
        CsccPostEntity csccPostEntity = getdeviceIdByNet(j, j2);
        if (g0.f()) {
            Log.d(TAG, " updateDeviceIdByNet: netResult :" + csccPostEntity);
        }
        long j3 = csccPostEntity.deviceId;
        long j4 = csccPostEntity.machineId;
        e.c.a.g.a.f.m.b.m().I(j3);
        e.c.a.g.a.f.m.b.m().J(j4);
        e.c.a.g.a.f.m.b.m().O(2);
        long[] jArr = this.phoneIds;
        jArr[0] = j3;
        jArr[1] = j4;
    }

    public long getDeviceId() {
        return lookupPhoneIds()[0];
    }

    public long getMachineId() {
        return lookupPhoneIds()[1];
    }

    public CsccPostEntity getdeviceIdByNet(long j, long j2) {
        if (g0.f()) {
            Log.d(TAG, "getdeviceIdByNet() called with: devId = [" + j + "], machineId = [" + j2 + "]");
        }
        CsccPostEntity csccPostEntity = new CsccPostEntity();
        Hashtable hashtable = new Hashtable();
        String strQ = l1.q();
        if (h1.k(strQ)) {
            strQ = "unknown";
        }
        f1 f1VarY = l1.y(KGApplication.getContext());
        int[] iArr = {f1VarY.a, f1VarY.b};
        QrydidIDHelper qrydidIDHelperCreate = QrydidIDHelper.create();
        String eud = qrydidIDHelperCreate.getEud();
        String emd = qrydidIDHelperCreate.getEmd();
        hasUpdateDeviceIdByNet = true;
        DeviceData deviceData = new DeviceData(eud, emd, strQ, iArr);
        if (g0.f()) {
            Log.e(TAG, " getdeviceIdByNet: deviceData:" + deviceData);
        }
        byte[] bytes = new byte[0];
        try {
            bytes = t.c(deviceData).getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            g0.k(e2);
        }
        Hashtable<String, Object> hashtableSign = SecureSignUtil.sign(hashtable, String.valueOf(l1.f()), l1.g(), System.currentTimeMillis(), bytes, true);
        RequestPackage requestPackage = new RequestPackage(bytes);
        PostResponsePackage postResponsePackage = new PostResponsePackage();
        requestPackage.setParams(hashtableSign);
        if (g0.f()) {
            Log.d("siganid-updatedeviceid", "UpdateDeviceIdModel url:" + requestPackage.getUrlConfigKey());
            Log.d("siganid-updatedeviceid", "UpdateDeviceIdModel Params:" + requestPackage.getParams());
        }
        e eVarA = e.a();
        eVarA.disableOffline(true);
        try {
            try {
                eVarA.request(requestPackage, postResponsePackage);
                postResponsePackage.getResponseData(csccPostEntity);
                if (g0.f()) {
                    Log.d("siganid-updatedeviceid", "UpdateDeviceIdModel result:" + csccPostEntity.toString());
                }
            } catch (Exception e3) {
                g0.k(e3);
                csccPostEntity.eid = ExceptionParse.parseResultCode(e3);
                csccPostEntity.requestDelay = eVarA.getRequestDelay();
                if (g0.f()) {
                    Log.d(TAG, " getdeviceIdByNet: error :" + e3.getMessage());
                }
            }
            return csccPostEntity;
        } finally {
            eVarA.stop();
        }
    }

    public boolean isDeviceIdExpire() {
        if (e.c.a.g.a.f.m.b.m().i() >= 2) {
            return false;
        }
        if (!g0.f()) {
            return true;
        }
        Log.d(TAG, "deviceid 过期需要重新获取 ");
        return true;
    }

    public boolean isPhoneIdsValid() {
        long[] jArrLookupPhoneIds = lookupPhoneIds();
        long j = jArrLookupPhoneIds[0];
        long j2 = jArrLookupPhoneIds[1];
        return j > 0;
    }

    @Deprecated
    public void updateDeviceFinger() {
        if (hasUpdateDeviceIdByNet) {
            if (g0.f()) {
                Log.d(TAG, " updateDeviceFinger: already update,just return ");
            }
        } else {
            if (g0.f()) {
                Log.d(TAG, "updateDeviceFinger");
            }
            j0.b().a(new Runnable() { // from class: com.kugou.common.datacollect.senter.UpdateDeviceIdModel.2
                @Override // java.lang.Runnable
                public void run() {
                    long jC = e.c.a.g.a.f.m.b.m().c();
                    long jD = e.c.a.g.a.f.m.b.m().d();
                    if (g0.f()) {
                        Log.d(UpdateDeviceIdModel.TAG, " updateDeviceFinger run: set devId " + jC + " machineId " + jD);
                    }
                    UpdateDeviceIdModel.this.updateDeviceIdByNet(jC, jD);
                }
            });
        }
    }
}
