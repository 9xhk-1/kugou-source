package e.c.a.d;

import android.text.TextUtils;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.q0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public static void b(Map<String, String> map, byte[] bArr) {
        if (map == null) {
            return;
        }
        String strG = l1.g();
        StringBuilder sb = new StringBuilder();
        String strA = a(map);
        sb.append(strG);
        sb.append(strA);
        if (bArr == null || bArr.length == 0) {
            sb.append(strG);
            map.put("signature", q0.k(sb.toString()));
            return;
        }
        int iMin = Math.min(bArr.length, 256);
        byte[] bytes = sb.toString().getBytes();
        byte[] bytes2 = strG.getBytes();
        byte[] bArr2 = new byte[bytes.length + iMin + bytes2.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, iMin);
        System.arraycopy(bytes2, 0, bArr2, bytes.length + iMin, bytes2.length);
        map.put("signature", q0.h(bArr2));
    }
}
