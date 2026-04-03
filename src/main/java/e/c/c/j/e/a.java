package e.c.c.j.e;

import android.text.TextUtils;
import com.kugou.framework.bilib.statistics.cscc.DataWrapper;
import e.c.c.o.f;
import e.c.c.o.m;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public int a = 10;
    public Map<String, Object> b;
    public int c;

    public a(Map<String, Object> map) {
        this.c = 0;
        this.b = map;
        String strN = m.n(f.a());
        if ("wifi".equals(strN)) {
            this.c = 1;
            return;
        }
        if ("4G".equals(strN)) {
            this.c = 4;
            return;
        }
        if ("3G".equals(strN)) {
            this.c = 3;
        } else if ("2G".equals(strN)) {
            this.c = 2;
        } else {
            this.c = 0;
        }
    }

    public final String a(int i2) {
        return i2 + DataWrapper.MARK_SEPERATE + this.a + DataWrapper.MARK_SEPERATE + 3 + DataWrapper.MARK_SEPERATE + e.c.c.l.e.a.f().c() + DataWrapper.MARK_SEPERATE + this.c + DataWrapper.MARK_SEPERATE + e.c.c.b.f1244d + DataWrapper.MARK_SEPERATE + 1 + DataWrapper.MARK_SEPERATE + "1\r\n";
    }

    public byte[] b() {
        return c();
    }

    public final byte[] c() {
        JSONObject jSONObject = new JSONObject();
        Map<String, Object> map = this.b;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key instanceof String) {
                    Object value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null) {
                        try {
                            jSONObject.put(entry.getKey(), value);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
        byte[] bytes = new byte[0];
        try {
            bytes = jSONObject.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        String strA = a(bytes.length);
        byte[] bytes2 = new byte[0];
        try {
            bytes2 = strA.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
        }
        byte[] bArr = new byte[bytes.length + bytes2.length];
        System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
        System.arraycopy(bytes, 0, bArr, strA.length(), bytes.length);
        return bArr;
    }
}
