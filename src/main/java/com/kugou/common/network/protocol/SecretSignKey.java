package com.kugou.common.network.protocol;

import android.text.TextUtils;
import com.kugou.common.network.networkutils.MD5Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SecretSignKey {
    private static void joinKeyValues(StringBuilder sb, Map<String, Object> map) {
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            sb.append(str);
            sb.append(map.get(str));
        }
    }

    public static String token(String str, Map<String, Object> map, String str2) {
        StringBuilder sb = new StringBuilder();
        joinKeyValues(sb, map);
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        return new MD5Util().getMD5ofStr(sb.toString(), "UTF-8").toLowerCase(Locale.US);
    }
}
