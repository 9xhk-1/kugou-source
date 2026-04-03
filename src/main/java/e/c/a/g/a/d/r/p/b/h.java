package e.c.a.g.a.d.r.p.b;

import com.kugou.common.network.ResponseTypeChecker;
import e.c.a.g.a.s.g0;
import org.apache.http.Header;

/* JADX INFO: loaded from: classes.dex */
public abstract class h<E> extends e.c.a.g.a.f.k.k.a<E> {
    public String a;

    @Override // e.c.a.g.a.f.k.k.a
    public String getJsonString() {
        return this.a;
    }

    @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
    public ResponseTypeChecker.ResponseType getResponseType() {
        return ResponseTypeChecker.ResponseType.JSON;
    }

    @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
    public void onContentException(int i2, String str, int i3, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            this.a = new String(bArr, "UTF-8");
        } catch (Exception unused) {
        }
    }

    @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.AbsHttpClient.IHttpException
    public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
    }

    @Override // e.c.a.g.a.f.k.k.a, com.kugou.common.network.protocol.ResponsePackage
    public void setContext(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            this.a = new String(bArr, "UTF-8");
        } catch (Exception e2) {
            g0.k(e2);
        }
    }
}
