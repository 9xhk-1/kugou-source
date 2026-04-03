package com.tencent.tmachine.trace.cpu.util;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class StringUtil {
    public static String[] splitWorker(String str, char c) {
        return splitWorker(str, c, false);
    }

    public static String[] splitWorker(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (i2 < length) {
            if (str.charAt(i2) == c) {
                if (z2 || z) {
                    arrayList.add(str.substring(i3, i2));
                    z2 = false;
                    z3 = true;
                }
                i3 = i2 + 1;
                i2 = i3;
            } else {
                i2++;
                z2 = true;
                z3 = false;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i3, i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
