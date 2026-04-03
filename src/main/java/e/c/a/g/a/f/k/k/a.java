package e.c.a.g.a.f.k.k;

import com.kugou.common.apm.ResponseHandlerForApm;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.ResponsePackage;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> implements ResponsePackage<T> {
    public String jsonStr;
    private int statusCode = 200;
    private String errDesc = "";
    public ResponseHandlerForApm responseHandlerForApm = new ResponseHandlerForApm();
    private byte[] data = null;

    public String getErrorDescription() {
        return this.errDesc;
    }

    public String getJsonStr() {
        return this.jsonStr;
    }

    public String getJsonString() {
        return this.jsonStr;
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public void getResponseData(T t) {
    }

    public byte[] getResponseData() {
        return this.data;
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public ResponseTypeChecker.ResponseType getResponseType() {
        return ResponseTypeChecker.ResponseType.IGNORE;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void handleFail(int i2, String str, String str2) {
        e.c.a.g.a.d.b.a netApmDataWhenSuccess = ResponseHandlerForApm.getNetApmDataWhenSuccess(i2, str);
        netApmDataWhenSuccess.d(i2);
        netApmDataWhenSuccess.h(this.statusCode);
        netApmDataWhenSuccess.e(str);
        netApmDataWhenSuccess.f(str2);
        onHandleApmData(netApmDataWhenSuccess);
    }

    public void handleSuccess() {
        e.c.a.g.a.d.b.a netApmDataWhenSuccess = this.responseHandlerForApm.getNetApmDataWhenSuccess(this.statusCode, this.data);
        netApmDataWhenSuccess.h(this.statusCode);
        onHandleApmData(netApmDataWhenSuccess);
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onContentException(int i2, String str, int i3, byte[] bArr) {
        this.statusCode = i3;
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            this.errDesc = new String(bArr, "UTF-8");
        } catch (Exception unused) {
            this.errDesc = "onContentException";
        }
    }

    public abstract void onHandleApmData(e.c.a.g.a.d.b.a aVar);

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        this.statusCode = i3;
        this.errDesc = "onHeaderException";
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public void setContext(byte[] bArr) {
        try {
            this.statusCode = 200;
            this.data = bArr;
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            this.jsonStr = new String(bArr, "UTF-8");
        } catch (Exception unused) {
        }
    }
}
