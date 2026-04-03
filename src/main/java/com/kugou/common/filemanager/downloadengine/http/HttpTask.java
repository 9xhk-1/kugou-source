package com.kugou.common.filemanager.downloadengine.http;

import com.kugou.common.filemanager.downloadengine.DownloadFileInfo;
import com.kugou.common.filemanager.downloadengine.DownloadStateInfo;
import com.kugou.common.filemanager.downloadengine.DownloadStatusInfo;
import com.kugou.common.filemanager.downloadengine.Engine;
import com.kugou.common.filemanager.downloadengine.NetLog;
import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import com.kugou.common.filemanager.downloadengine.http.HttpTaskManager;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class HttpTask {
    private Engine.IDownloadCallback engineCallback;
    private DownloadFileInfo fileInfo;
    private String fileKey;
    private RandomAccessFile fileStream;
    private HttpConnector http;
    private HttpTaskManager.IHttpProxyProvider proxyProvider;
    private HttpSpeed speed = new HttpSpeed();
    private ThreadPoolExecutor threadPool;
    private long writePos;

    public HttpTask(ThreadPoolExecutor threadPoolExecutor, String str, Engine.IDownloadCallback iDownloadCallback, HttpTaskManager.IHttpProxyProvider iHttpProxyProvider) {
        this.threadPool = threadPoolExecutor;
        this.fileKey = str;
        this.engineCallback = iDownloadCallback;
        this.proxyProvider = iHttpProxyProvider;
    }

    private synchronized String getDownloadUrl(HttpConnector httpConnector) {
        DownloadFileInfo downloadFileInfo;
        if (this.http == httpConnector && (downloadFileInfo = this.fileInfo) != null && downloadFileInfo.hasUrl()) {
            return this.fileInfo.getUrls()[0];
        }
        return null;
    }

    private synchronized long getFileSize(HttpConnector httpConnector) {
        DownloadFileInfo downloadFileInfo;
        if (this.http != httpConnector || (downloadFileInfo = this.fileInfo) == null) {
            return 0L;
        }
        return downloadFileInfo.getFileSize();
    }

    private synchronized void notifyFailed(HttpConnector httpConnector, int i2) {
        DownloadStateInfo downloadStateInfo = new DownloadStateInfo();
        downloadStateInfo.setKey(this.fileKey);
        downloadStateInfo.setState(FileDownloadState.FILE_DOWNLOAD_STATE_FAILED.ordinal());
        downloadStateInfo.setError(i2);
        if (this.http == httpConnector) {
            pCloseStream();
            this.engineCallback.onDownloadStateChanged(this.fileKey, downloadStateInfo);
        }
    }

    private synchronized void notifyProgress(HttpConnector httpConnector, long j) {
        if (this.http == httpConnector && this.fileInfo != null) {
            DownloadStatusInfo downloadStatusInfo = new DownloadStatusInfo();
            downloadStatusInfo.setKey(this.fileKey);
            downloadStatusInfo.setFileSize(this.fileInfo.getFileSize());
            downloadStatusInfo.setDownloadSize(j);
            downloadStatusInfo.setState(FileDownloadState.FILE_DOWNLOAD_STATE_DOWNLOADING.ordinal());
            this.speed.calc();
            downloadStatusInfo.setSpeedAvg(this.speed.getAvgSpeed());
            downloadStatusInfo.setSpeedNow(this.speed.getSpeed());
            downloadStatusInfo.setSpeedRecent(this.speed.getSpeed());
            this.engineCallback.onDownloadStatus(this.fileKey, downloadStatusInfo);
        }
    }

    private synchronized void notifyState(HttpConnector httpConnector, FileDownloadState fileDownloadState) {
        DownloadStateInfo downloadStateInfo = new DownloadStateInfo();
        downloadStateInfo.setKey(this.fileKey);
        downloadStateInfo.setState(fileDownloadState.ordinal());
        downloadStateInfo.setError(0);
        if (this.http == httpConnector) {
            this.engineCallback.onDownloadStateChanged(this.fileKey, downloadStateInfo);
        }
    }

    private synchronized void notifySucceed(HttpConnector httpConnector) {
        DownloadStateInfo downloadStateInfo = new DownloadStateInfo();
        downloadStateInfo.setKey(this.fileKey);
        downloadStateInfo.setState(FileDownloadState.FILE_DOWNLOAD_STATE_SUCCEEDED.ordinal());
        downloadStateInfo.setError(0);
        if (this.http == httpConnector) {
            this.speed.calcFinal();
            downloadStateInfo.createStatistics();
            downloadStateInfo.getStatistics().setFileSize(this.fileInfo.getFileSize());
            downloadStateInfo.getStatistics().setAvgSpeed(this.speed.getAvgSpeed());
            pCloseStream();
            this.engineCallback.onDownloadStateChanged(this.fileKey, downloadStateInfo);
        }
    }

    private void pCloseStream() {
        RandomAccessFile randomAccessFile = this.fileStream;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException e2) {
                NetLog.uploadException(e2);
            }
            this.fileStream = null;
        }
        this.writePos = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pDownloadThread(HttpConnector httpConnector) {
        try {
            requestWhole(httpConnector);
        } catch (Exception e2) {
            NetLog.uploadException(e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        notifyFailed(r14, 104);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean requestWhole(com.kugou.common.filemanager.downloadengine.http.HttpConnector r14) {
        /*
            r13 = this;
            java.lang.String r0 = r13.getDownloadUrl(r14)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto Lc
            return r2
        Lc:
            r3 = 0
            r1 = 103(0x67, float:1.44E-43)
            com.kugou.common.filemanager.downloadengine.http.KGHttpResponse r0 = r14.getHttpResponse(r0)     // Catch: java.lang.Exception -> L76
            if (r0 == 0) goto L72
            int r5 = r0.getResponseCode()     // Catch: java.lang.Exception -> L76
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 == r6) goto L1f
            goto L72
        L1f:
            long r5 = r0.getContentLength()     // Catch: java.lang.Exception -> L76
            boolean r5 = r13.updateFileSize(r14, r5)     // Catch: java.lang.Exception -> L76
            if (r5 != 0) goto L2f
            r0 = 102(0x66, float:1.43E-43)
            r13.notifyFailed(r14, r0)     // Catch: java.lang.Exception -> L76
            return r2
        L2f:
            com.kugou.common.filemanager.downloadengine.entity.FileDownloadState r5 = com.kugou.common.filemanager.downloadengine.entity.FileDownloadState.FILE_DOWNLOAD_STATE_DOWNLOADING     // Catch: java.lang.Exception -> L76
            r13.notifyState(r14, r5)     // Catch: java.lang.Exception -> L76
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.lang.Exception -> L76
            r5 = 16384(0x4000, float:2.2959E-41)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L6b
        L3c:
            int r12 = r0.read(r5)     // Catch: java.lang.Throwable -> L6b
            r6 = -1
            if (r12 == r6) goto L59
            r6 = r13
            r7 = r14
            r8 = r3
            r10 = r5
            r11 = r12
            boolean r6 = r6.writeFile(r7, r8, r10, r11)     // Catch: java.lang.Throwable -> L6b
            if (r6 == 0) goto L54
            long r6 = (long) r12     // Catch: java.lang.Throwable -> L6b
            long r3 = r3 + r6
            r13.notifyProgress(r14, r3)     // Catch: java.lang.Throwable -> L6b
            goto L3c
        L54:
            r5 = 104(0x68, float:1.46E-43)
            r13.notifyFailed(r14, r5)     // Catch: java.lang.Throwable -> L6b
        L59:
            if (r0 == 0) goto L5e
            r0.close()     // Catch: java.lang.Exception -> L76
        L5e:
            long r5 = r13.getFileSize(r14)     // Catch: java.lang.Exception -> L76
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L7d
            r13.notifySucceed(r14)     // Catch: java.lang.Exception -> L76
            r14 = 1
            return r14
        L6b:
            r3 = move-exception
            if (r0 == 0) goto L71
            r0.close()     // Catch: java.lang.Exception -> L76
        L71:
            throw r3     // Catch: java.lang.Exception -> L76
        L72:
            r13.notifyFailed(r14, r1)     // Catch: java.lang.Exception -> L76
            return r2
        L76:
            r0 = move-exception
            com.kugou.common.filemanager.downloadengine.NetLog.uploadException(r0)
            r13.notifyFailed(r14, r1)
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.filemanager.downloadengine.http.HttpTask.requestWhole(com.kugou.common.filemanager.downloadengine.http.HttpConnector):boolean");
    }

    private synchronized boolean updateFileSize(HttpConnector httpConnector, long j) {
        DownloadFileInfo downloadFileInfo;
        if (this.http != httpConnector || (downloadFileInfo = this.fileInfo) == null) {
            return false;
        }
        if (downloadFileInfo.getFileSize() == 0) {
            this.fileInfo.setFileSize(j);
        } else if (this.fileInfo.getFileSize() != j) {
            return false;
        }
        return true;
    }

    private synchronized boolean writeFile(HttpConnector httpConnector, long j, byte[] bArr, int i2) throws IOException {
        if (this.http != httpConnector) {
            return false;
        }
        if (this.fileStream == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.fileInfo.getFilePath(), "rw");
            try {
                long length = randomAccessFile.length();
                if (length < j) {
                    randomAccessFile.close();
                    return false;
                }
                if (length > j) {
                    randomAccessFile.setLength(j);
                }
                this.fileStream = randomAccessFile;
                try {
                    this.writePos = randomAccessFile.length();
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
        if (this.writePos != j) {
            return false;
        }
        this.fileStream.write(bArr, 0, i2);
        long j2 = i2;
        this.writePos += j2;
        this.speed.addBytes(j2);
        return true;
    }

    public String getFileKey() {
        return this.fileKey;
    }

    public synchronized boolean startDownload(DownloadFileInfo downloadFileInfo) {
        this.fileInfo = downloadFileInfo;
        if (this.engineCallback.isRealEncryptedFile(downloadFileInfo.getFilePath())) {
            new File(downloadFileInfo.getFilePath()).delete();
        }
        String str = null;
        String[] urls = downloadFileInfo.getUrls();
        if (urls != null && urls.length > 0) {
            str = urls[0];
        }
        final HttpConnector httpConnector = new HttpConnector(this.proxyProvider, str);
        this.http = httpConnector;
        this.speed.start();
        this.threadPool.execute(new Runnable() { // from class: com.kugou.common.filemanager.downloadengine.http.HttpTask.1
            @Override // java.lang.Runnable
            public void run() {
                HttpTask.this.pDownloadThread(httpConnector);
            }
        });
        return true;
    }

    public synchronized void stopDownload() {
        HttpConnector httpConnector = this.http;
        if (httpConnector != null) {
            try {
                httpConnector.close();
            } catch (Exception e2) {
                NetLog.uploadException(e2);
            }
            this.http = null;
            pCloseStream();
            this.speed.stop();
        }
    }
}
