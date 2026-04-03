package com.kugou.common.network.networkutils;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class AckUtil {
    private static String EncodeMvFileName(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("/", "／").replace("*", "×").replace("?", "？").replace("<", "＜").replace(">", "＞").replace(":", "：").replace("\"", "＂").replace("\\", "＼").replace(RetryStaticsLOG.MARK_SEPERATE, "｜");
    }

    public static String getCurrentNetworkName(Context context) {
        String networkType = KGNetworkUtil.getNetworkType(context);
        return networkType != null ? networkType.toUpperCase(Locale.US) : networkType;
    }
}
