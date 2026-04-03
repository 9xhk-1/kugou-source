package com.kugou.common.network.ackutils;

import com.kugou.common.network.networkutils.NetLog;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class SystemUtils {
    public static boolean isPicked(float f2) {
        if (NetLog.isDebug()) {
            NetLog.d("SystemUtils", "isPicked percent= " + f2);
        }
        if (f2 <= 0.0f) {
            return false;
        }
        return f2 >= 100.0f || new Random().nextFloat() < f2 / 100.0f;
    }
}
