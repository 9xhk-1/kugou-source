package e.c.a.g.a.d.r.p.b;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.ResponsePackage;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g implements AbsHttpClient.IHttpProperty, ResponsePackage<e.c.a.g.a.d.r.p.a.f> {
    public String a;

    @Override // com.kugou.common.network.protocol.ResponsePackage
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void getResponseData(e.c.a.g.a.d.r.p.a.f fVar) {
        if (fVar == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.a);
            fVar.h(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ret_mediastore");
            if (jSONObjectOptJSONObject == null) {
                return;
            }
            e.c.a.g.a.d.r.p.a.b bVar = new e.c.a.g.a.d.r.p.a.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(d.d(jSONObjectOptJSONObject.toString()));
            bVar.d(arrayList);
            e.c.a.g.a.d.r.p.a.a aVar = new e.c.a.g.a.d.r.p.a.a();
            aVar.h(bVar);
            fVar.g(aVar);
        } catch (Exception unused) {
        }
    }

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
            this.a = new String(bArr, "UTF-8");
        } catch (Exception unused) {
        }
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onContentType(String str) {
        return true;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpException
    public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onHeaders(Header[] headerArr) {
        return true;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onResponseCode(int i2) {
        return true;
    }

    @Override // com.kugou.common.network.protocol.ResponsePackage
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
