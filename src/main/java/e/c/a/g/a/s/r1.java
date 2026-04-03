package e.c.a.g.a.s;

import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.kugou.common.config.ConfigKey;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class r1 {

    public class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public class b implements Comparator<Map.Entry<String, ?>> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, ?> entry, Map.Entry<String, ?> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }

    public class c implements Comparator<Map.Entry<String, Object>> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }

    public static float a(MotionEvent motionEvent) {
        if (motionEvent.isFromSource(2)) {
            return motionEvent.getAxisValue(9);
        }
        if (Build.VERSION.SDK_INT < 26 || !motionEvent.isFromSource(4194304)) {
            return 0.0f;
        }
        return motionEvent.getAxisValue(26);
    }

    @Deprecated
    public static String[] b(ConfigKey configKey) {
        return e.c.a.g.a.f.e.c.c().getAllValuesOfConfig(configKey);
    }

    public static String[] c(ConfigKey configKey, String str) {
        String[] strArrB = b(configKey);
        return (strArrB == null || strArrB.length == 0) ? new String[]{str} : strArrB;
    }

    public static String d(String str) {
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d);
        return e.c.c.o.i.g(config + str + config);
    }

    public static String e(String str, Map<String, Object> map, String str2) {
        if (map == null || map.size() < 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Set<String> setKeySet = map.keySet();
        String[] strArr = (String[]) setKeySet.toArray(new String[setKeySet.size()]);
        Arrays.sort(strArr, new a());
        for (String str3 : strArr) {
            sb.append(str3);
            sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
            sb.append(map.get(str3));
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        return new e.c.c.o.i().e(str + sb.toString() + str);
    }

    public static String f(String str, Map<String, String> map, String str2) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        return e(str, map2, str2);
    }

    public static String g(Map<String, ?> map) {
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

    public static String h(Map<String, Object> map, String str) {
        if (map == null) {
            return null;
        }
        map.put("_t", Long.valueOf(System.currentTimeMillis() / 1000));
        ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new c());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : arrayList) {
            sb.append((String) entry.getKey());
            sb.append(entry.getValue());
        }
        sb.append("R6snCXJgbCaj9WFRJKefTMIFp0ey6Gza");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (g0.a) {
            g0.b("lzm", "sign-s: " + sb.toString());
        }
        map.put("sign", e.c.c.o.i.j(sb.toString()));
        return sb.toString();
    }

    public static void i(Map<String, Object> map, byte[] bArr) {
        if (map == null) {
            return;
        }
        map.put("_t", String.valueOf(System.currentTimeMillis() / 1000));
        ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new b());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : arrayList) {
            sb.append((String) entry.getKey());
            sb.append(entry.getValue());
        }
        sb.append("R6snCXJgbCaj9WFRJKefTMIFp0ey6Gza");
        if (bArr == null) {
            map.put("sign", e.c.c.o.i.j(sb.toString()));
            return;
        }
        byte[] bytes = sb.toString().getBytes();
        byte[] bArr2 = new byte[bytes.length + bArr.length];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        if (g0.a) {
            g0.b("lzm", "sign-s: " + sb.toString());
        }
        map.put("sign", e.c.c.o.i.h(bArr2));
    }
}
