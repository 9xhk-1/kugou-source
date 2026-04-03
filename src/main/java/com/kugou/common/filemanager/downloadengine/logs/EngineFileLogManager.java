package com.kugou.common.filemanager.downloadengine.logs;

import android.support.annotation.IntRange;
import com.kugou.common.filemanager.downloadengine.NetLog;
import com.kugou.common.filemanager.downloadengine.utils.FileUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class EngineFileLogManager {
    public static final long CLEAN_DAYS = 7;
    public static final int MAX_NUM_LOGS = 30;
    private String mDir;
    private final String LOG_DOWN_FILES_DIR = "/downflog/";
    private HashMap<String, EngineFileLog> mLogs = new HashMap<>();

    public EngineFileLogManager(String str) {
        this.mDir = str + "/downflog/";
    }

    private static String keyToName(String str, @IntRange(from = 0, to = 999) int i2) {
        String str2;
        String str3 = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
        if (i2 > 0) {
            str2 = "_c" + i2;
        } else {
            str2 = "";
        }
        return "dfl_" + str3 + "_" + str + str2 + ".log";
    }

    public void clean() {
        try {
            File[] fileArrListFiles = new File(this.mDir).listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - 604800000;
                long[] jArr = new long[fileArrListFiles.length];
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < fileArrListFiles.length; i4++) {
                    File file = fileArrListFiles[i4];
                    if (!file.isDirectory()) {
                        long jLastModified = file.lastModified();
                        if (jLastModified > 0) {
                            if (jLastModified < jCurrentTimeMillis) {
                                FileUtil.deleteFile(file);
                                i3++;
                            } else {
                                jArr[i4] = jLastModified;
                                arrayList.add(Long.valueOf(jLastModified));
                            }
                        }
                    }
                }
                if (arrayList.size() > 30) {
                    Collections.sort(arrayList);
                    long jLongValue = ((Long) arrayList.get(arrayList.size() - 30)).longValue();
                    int i5 = 0;
                    while (i2 < fileArrListFiles.length) {
                        if (jArr[i2] > 0 && jArr[i2] < jLongValue) {
                            FileUtil.deleteFile(fileArrListFiles[i2]);
                            i5++;
                        }
                        i2++;
                    }
                    i2 = i5;
                }
                if (NetLog.isDebug()) {
                    NetLog.d("EngineFileLog clean old(" + i3 + ")+more(" + i2 + ") of " + fileArrListFiles.length);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void close(String str) {
        EngineFileLog engineFileLog;
        synchronized (this.mLogs) {
            engineFileLog = this.mLogs.get(str);
            if (engineFileLog != null) {
                this.mLogs.remove(str);
            }
        }
        if (engineFileLog != null) {
            engineFileLog.close();
        }
    }

    public void discard() {
        Collection<EngineFileLog> collectionValues;
        synchronized (this.mLogs) {
            collectionValues = this.mLogs.values();
            this.mLogs.clear();
        }
        if (collectionValues == null || collectionValues.isEmpty()) {
            return;
        }
        for (EngineFileLog engineFileLog : collectionValues) {
            if (engineFileLog != null) {
                engineFileLog.discard();
            }
        }
    }

    public void flush(String str) {
        EngineFileLog engineFileLog;
        synchronized (this.mLogs) {
            engineFileLog = this.mLogs.get(str);
        }
        if (engineFileLog != null) {
            engineFileLog.flush();
        }
    }

    public void flushAll() {
        Collection<EngineFileLog> collectionValues;
        synchronized (this.mLogs) {
            collectionValues = this.mLogs.values();
        }
        if (collectionValues == null || collectionValues.isEmpty()) {
            return;
        }
        for (EngineFileLog engineFileLog : collectionValues) {
            if (engineFileLog != null) {
                engineFileLog.flush();
            }
        }
    }

    public boolean has(String str) {
        boolean zContainsKey;
        synchronized (this.mLogs) {
            zContainsKey = this.mLogs.containsKey(str);
        }
        return zContainsKey;
    }

    public void log(String str, String str2, boolean z) {
        EngineFileLog engineFileLog;
        synchronized (this.mLogs) {
            engineFileLog = this.mLogs.get(str);
        }
        if (engineFileLog != null) {
            boolean zMarkCritical = z ? engineFileLog.markCritical() : false;
            engineFileLog.write(str2);
            if (zMarkCritical) {
                engineFileLog.flush();
            }
        }
    }

    public void markCritical(String str) {
        EngineFileLog engineFileLog;
        synchronized (this.mLogs) {
            engineFileLog = this.mLogs.get(str);
        }
        if (engineFileLog != null) {
            engineFileLog.markCritical();
        }
    }

    public void open(String str, @IntRange(from = 0, to = 999) int i2) {
        synchronized (this.mLogs) {
            if (!this.mLogs.containsKey(str)) {
                this.mLogs.put(str, new EngineFileLog(keyToName(str, i2), this.mDir));
            } else if (NetLog.isDebug()) {
                NetLog.d("EngineFileLog exists [" + str + "]");
            }
        }
    }

    public void saveAndClose(String str) {
        markCritical(str);
        close(str);
    }
}
