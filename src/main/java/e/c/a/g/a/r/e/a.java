package e.c.a.g.a.r.e;

import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.ResponsePackage;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<T> implements ResponsePackage<T> {
    public String a;

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public abstract void getResponseData(T t);

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public ResponseTypeChecker.ResponseType getResponseType() {
        return ResponseTypeChecker.ResponseType.IGNORE;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onContentException(int i2, String str, int i3, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            new String(bArr, "UTF-8");
        } catch (Exception unused) {
        }
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
    public void setContext(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    this.a = new String(bArr, "UTF-8");
                }
            } catch (Exception unused) {
            }
        }
    }
}
