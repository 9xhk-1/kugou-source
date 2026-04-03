package com.kugou.common.network.networkutils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SecureSignUtil {
    private static String getParamsString(Hashtable<String, Object> hashtable) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Map.Entry> arrayList = new ArrayList(hashtable.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Object>>() { // from class: com.kugou.common.network.networkutils.SecureSignUtil.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<String, Object> entry, Map.Entry<String, Object> entry2) {
                return entry.getKey().compareTo(entry2.getKey());
            }
        });
        for (Map.Entry entry : arrayList) {
            sb.append(((String) entry.getKey()) + entry.getValue());
        }
        return sb.toString();
    }

    private static String getSign(String str, Hashtable<String, Object> hashtable, byte[] bArr) {
        byte[] bytes;
        try {
            bytes = (getParamsString(hashtable) + str).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bytes = null;
        }
        if (bytes == null) {
            return "";
        }
        if (bArr != null) {
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            bytes = bArr2;
        }
        return new MD5Util().getMD5StrOfBytes(bytes);
    }

    public static Hashtable<String, Object> sign(Hashtable<String, Object> hashtable, String str, String str2, long j, boolean z) {
        return sign(hashtable, str, str2, j, null, z);
    }

    public static Hashtable<String, Object> sign(Hashtable<String, Object> hashtable, String str, String str2, long j, byte[] bArr, boolean z) {
        if (hashtable != null) {
            if (z) {
                hashtable.put("appid", str);
            } else {
                hashtable.put("apikey", str);
            }
            hashtable.put("_t", Long.valueOf(j));
            hashtable.put("sign", getSign(str2, hashtable, bArr));
            for (Map.Entry entry : hashtable.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof String) {
                    String strEncode = (String) value;
                    try {
                        strEncode = URLEncoder.encode(strEncode, "utf-8");
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                    entry.setValue(strEncode);
                }
            }
        }
        return hashtable;
    }
}
