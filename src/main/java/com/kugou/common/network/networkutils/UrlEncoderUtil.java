package com.kugou.common.network.networkutils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.material.badge.BadgeDrawable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class UrlEncoderUtil {
    public static String checkAndEncodeHeadInfo(String str) {
        return hasExpChar(str) ? encodeHeadInfo(str) : str;
    }

    public static String encode(String str) {
        return isEmpty(str) ? "" : URLEncoder.encode(str).replace(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20");
    }

    public static String encodeHeadInfo(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String escape(String str) {
        StringBuilder sb = new StringBuilder(20);
        if (str != null) {
            sb.ensureCapacity(str.length() * 6);
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isDigit(cCharAt) || Character.isLowerCase(cCharAt) || Character.isUpperCase(cCharAt)) {
                    sb.append(cCharAt);
                } else if (cCharAt < 256) {
                    sb.append("%");
                    if (cCharAt < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toString(cCharAt, 16));
                } else {
                    sb.append("%u");
                    sb.append(Integer.toString(cCharAt, 16));
                }
            }
        }
        return sb.toString();
    }

    public static String excludeUrlParams(@NonNull String str) {
        int iIndexOf = str.indexOf(63);
        return iIndexOf >= 0 ? str.substring(0, iIndexOf) : str;
    }

    public static boolean hasExpChar(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String encode(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2).replace(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20");
        } catch (UnsupportedEncodingException unused) {
            return encode(str);
        }
    }
}
