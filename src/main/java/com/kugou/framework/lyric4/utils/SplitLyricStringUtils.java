package com.kugou.framework.lyric4.utils;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SplitLyricStringUtils {
    private static int getWordEnd(String str, int i2) {
        int i3;
        if (i2 < 0 || i2 >= str.length()) {
            return 0;
        }
        int i4 = i2;
        for (int i5 = i2 + 1; i5 < str.length() && str.charAt(i5) <= 127 && str.charAt(i2) <= 127 && str.charAt(i5) != ' '; i5++) {
            i4 = i5;
        }
        while (true) {
            i3 = i4;
            i4++;
            if (i4 >= str.length() || (str.charAt(i4) != ' ' && str.charAt(i4) != 12288)) {
                break;
            }
        }
        return i3;
    }

    public static String[] splitLyricString(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[]{""};
        }
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        if (str.length() > 0) {
            while (i2 <= str.length() - 1) {
                int wordEnd = (getWordEnd(str, i2) - i2) + 1 + i2;
                arrayList.add(str.substring(i2, wordEnd));
                i2 = wordEnd;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
