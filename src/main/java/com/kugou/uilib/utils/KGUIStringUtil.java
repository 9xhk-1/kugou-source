package com.kugou.uilib.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIStringUtil {
    public static String getTrimString(String str) {
        return TextUtils.isEmpty(str) ? "" : str.trim();
    }
}
