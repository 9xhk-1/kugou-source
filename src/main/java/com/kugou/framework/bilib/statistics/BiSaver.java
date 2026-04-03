package com.kugou.framework.bilib.statistics;

import android.text.TextUtils;
import com.kugou.framework.bilib.common.SystemUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class BiSaver {
    private static final String LOGTAG = "BiSaver";

    public static void save(String str, String str2) {
        StatisticLog statisticLog = new StatisticLog();
        try {
            File file = new File(str2);
            if (file.exists()) {
                String file2 = SystemUtils.readFile(file.getAbsolutePath());
                if (!TextUtils.isEmpty(file2)) {
                    StatisticLog.fromJson(statisticLog, file2);
                }
            }
            statisticLog.addUrl(str);
            SystemUtils.writeFile(file.getAbsolutePath(), StatisticLog.toJson(statisticLog));
            SystemUtils.writeFile(str2, StatisticLog.toJson(statisticLog));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
