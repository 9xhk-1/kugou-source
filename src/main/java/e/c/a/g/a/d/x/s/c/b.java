package e.c.a.g.a.d.x.s.c;

import android.text.TextUtils;
import com.kugou.common.network.protocol.response.IResponseTypeChecker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b implements IResponseTypeChecker {
    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public boolean checkResponseType(byte[] bArr) {
        String string;
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        try {
            string = new JSONObject(new String(bArr)).getString("content");
        } catch (Exception unused) {
            string = "";
        }
        return !TextUtils.isEmpty(string);
    }

    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public int getCheckType() {
        return 2;
    }
}
