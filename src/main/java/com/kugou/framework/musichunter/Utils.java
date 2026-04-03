package com.kugou.framework.musichunter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.kugou.framework.libcommon.MD5Util;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import com.kugou.framework.musichunter.BIDelegate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    private static String machineID;
    private static String uuid;

    public static long getBeforeUID() {
        try {
            return (Long.parseLong(MD5Util.getMD5ofStr(getUuid()).substring(0, 8), 16) & 2147483647L) << 32;
        } catch (Exception unused) {
            return getFadeMachineID();
        }
    }

    private static long getFadeMachineID() {
        return (System.currentTimeMillis() & 2147483647L) << 32;
    }

    public static String getMachineID() {
        Context context = Global.globalContext;
        if (context != null) {
            return BIDelegate.PrivacyUtils.getMid(context);
        }
        if (machineID == null) {
            machineID = String.valueOf(getFadeMachineID());
        }
        return machineID;
    }

    public static String getSignature(String str, String str2, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = str.getBytes();
        byteArrayOutputStream.write(bytes);
        byteArrayOutputStream.write(str2.getBytes(Charset.forName("UTF-8")));
        if (bArr != null) {
            byteArrayOutputStream.write(bArr);
        }
        byteArrayOutputStream.write(bytes);
        byteArrayOutputStream.flush();
        return MD5Util.getMd5(byteArrayOutputStream.toByteArray());
    }

    public static String getStandardUuid() {
        return getUuid();
    }

    public static long getUniqueID() {
        return getBeforeUID() + (System.currentTimeMillis() & 4294967295L);
    }

    public static synchronized String getUuid() {
        Context context = Global.globalContext;
        if (context != null) {
            return BIDelegate.PrivacyUtils.getUUID(context);
        }
        if (uuid == null) {
            uuid = MD5Util.getMD5ofStr(new BigInteger(64, new SecureRandom()).toString(16));
        }
        return uuid;
    }

    public static boolean isNetworkConected(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static String map2SortString(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sortParams(map, sb);
        return sb.toString();
    }

    private static void sortParams(Map<String, ?> map, StringBuilder sb) {
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
                sb.append(map.get(str));
            }
        }
    }

    public static String toRequestParams(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        Iterator<String> it = map.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        String next = it.next();
        String strValueOf = String.valueOf(map.get(next));
        sb.append(next);
        sb.append('=');
        sb.append(strValueOf);
        while (it.hasNext()) {
            sb.append('&');
            String next2 = it.next();
            String strValueOf2 = String.valueOf(map.get(next2));
            sb.append(next2);
            sb.append('=');
            sb.append(strValueOf2);
        }
        return sb.toString();
    }

    @SuppressLint({"NewApi"})
    public static String getSignature(String str, String str2) {
        return MD5Util.getMD5ofStr(str + str2 + str);
    }
}
