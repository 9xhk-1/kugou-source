package com.kugou.framework.bilib.statistics;

import android.text.TextUtils;
import com.kugou.framework.bilib.LibLog;
import com.kugou.framework.bilib.bi.easytrace.EasytraceSender;
import com.kugou.framework.bilib.bi.easytrace.StatisticsThreadPool;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.bilib.common.SystemUtils;
import com.kugou.framework.libcommon.NetworkUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class StatisManager {
    public static final String KG_BI_STATISTIC_DATA_FILE_PATH = "tgsq_sdk.data";
    public static final String KG_STATISTIC_DATA_FILE_PATH = "kgstatistics.data";
    private static final String LOGTAG = "StatisManager";
    private static volatile StatisManager mInstance;

    private StatisManager() {
    }

    public static StatisManager getInstance() {
        if (mInstance == null) {
            synchronized (StatisManager.class) {
                if (mInstance == null) {
                    mInstance = new StatisManager();
                }
            }
        }
        return mInstance;
    }

    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public void excute() {
        if (online()) {
            StatisticsThreadPool.getInstance().execute(new Runnable() { // from class: com.kugou.framework.bilib.statistics.StatisManager.1
                @Override // java.lang.Runnable
                public void run() {
                    StatisManager.this.sendCache();
                }
            });
        }
    }

    public boolean online() {
        return NetworkUtils.isWifiConnected(LibConfig.getContext());
    }

    public void save(String str) {
        BiSaver.save(str, LibConfig.getContext().getFilesDir() + File.separator + KG_BI_STATISTIC_DATA_FILE_PATH);
    }

    public void send() {
        if (LibConfig.isDebug()) {
            LibLog.d(LOGTAG, "send");
        }
        sendCache();
        List<String> list = null;
        new EasytraceSender();
        for (String str : list) {
            if (!EasytraceSender.send(str)) {
                if (LibConfig.isDebug()) {
                    LibLog.d(LOGTAG, "send failed, and save");
                }
                save(str);
            }
        }
    }

    public void sendCache() {
        try {
            File file = new File(LibConfig.getContext().getCacheDir(), KG_BI_STATISTIC_DATA_FILE_PATH);
            boolean z = true;
            boolean z2 = false;
            try {
                LibLog.d(LOGTAG, "ReadStatisticFileToSend");
                String file2 = SystemUtils.readFile(file.getAbsolutePath());
                if (!TextUtils.isEmpty(file2)) {
                    StatisticLog statisticLog = new StatisticLog();
                    StatisticLog.fromJson(statisticLog, file2);
                    Iterator<String> it = statisticLog.getList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (!EasytraceSender.send(it.next())) {
                            z = false;
                            break;
                        }
                    }
                }
                z2 = z;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                if (LibConfig.isDebug()) {
                    LibLog.d(LOGTAG, "OOM : " + e2.getMessage());
                }
            }
            if (!z2) {
                if (LibConfig.isDebug()) {
                    LibLog.d(LOGTAG, "send cache failed");
                }
            } else {
                if (LibConfig.isDebug()) {
                    LibLog.d(LOGTAG, "send cache successfully");
                }
                SystemUtils.deleteFile(file.getAbsolutePath());
                if (LibConfig.isDebug()) {
                    LibLog.d(LOGTAG, "ReadStatisticFileToSend successful");
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (LibConfig.isDebug()) {
                LibLog.d(LOGTAG, "send cache failed: " + e3.getMessage());
            }
        }
    }
}
