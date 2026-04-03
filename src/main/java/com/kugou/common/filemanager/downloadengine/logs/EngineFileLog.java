package com.kugou.common.filemanager.downloadengine.logs;

import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.NetLog;
import com.kugou.common.filemanager.downloadengine.utils.FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public class EngineFileLog {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private static final int FLUSH_SIZE;
    private static final int FORCE_FLUSH_SIZE = 131072;
    private String logDir;
    private String name;
    private FileOutputStream output;
    private boolean save = false;
    private StringBuilder strBuf = new StringBuilder();

    static {
        FLUSH_SIZE = (NetLog.isDebug() ? 4 : 16) * 1024;
    }

    public EngineFileLog(String str, String str2) {
        this.logDir = str2;
        this.name = str;
    }

    private void closeOnly() {
        FileOutputStream fileOutputStream = this.output;
        if (fileOutputStream != null) {
            try {
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                    if (NetLog.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            } finally {
                this.output = null;
            }
        }
    }

    private static String dateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
    }

    private void flushStrBuf() {
        try {
            if (this.output == null) {
                return;
            }
            String string = this.strBuf.toString();
            this.strBuf.setLength(0);
            this.output.write(string.getBytes("UTF-8"));
            if (NetLog.isDebug()) {
                NetLog.d("EngineFileLog flush " + this.name + ", length " + string.length());
            }
        } catch (Exception e2) {
            NetLog.uploadException(e2);
        }
    }

    private boolean openFile() {
        if (this.output == null) {
            try {
                if (!FileUtil.isExist(this.logDir)) {
                    FileUtil.createDirectory(this.logDir);
                }
                this.output = new FileOutputStream(new File(this.logDir, this.name), true);
            } catch (Exception e2) {
                NetLog.uploadException(e2);
            }
        }
        return this.output != null;
    }

    private static String strNow() {
        return dateToString(new Date());
    }

    public synchronized void close() {
        flush();
        closeOnly();
    }

    public synchronized void discard() {
        this.strBuf.setLength(0);
        closeOnly();
    }

    public synchronized void flush() {
        if (this.save && this.strBuf.length() != 0) {
            if (openFile()) {
                flushStrBuf();
            }
        }
    }

    public synchronized boolean markCritical() {
        boolean z;
        z = !this.save;
        if (z && NetLog.isDebug()) {
            NetLog.d("EngineFileLog " + this.name + " mark critical");
        }
        this.save = true;
        return z;
    }

    public synchronized void write(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int length = str.length() + 24 + 2;
        if (!this.save && this.strBuf.length() + length >= 131072) {
            this.save = true;
            flush();
            if (NetLog.isDebug()) {
                NetLog.d("EngineFileLog " + this.name + " save by too big");
            }
        }
        try {
            StringBuilder sb = this.strBuf;
            sb.append(strNow());
            sb.append(' ');
            sb.append(str);
            sb.append("\r\n");
        } catch (OutOfMemoryError unused) {
            this.strBuf.setLength(0);
        }
        if (this.save && this.strBuf.length() > FLUSH_SIZE && openFile()) {
            flushStrBuf();
        }
    }
}
