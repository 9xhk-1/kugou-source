package com.kugou.common.filemanager.downloadengine.http;

import com.kugou.common.filemanager.downloadengine.DownloadFileInfo;
import com.kugou.common.filemanager.downloadengine.Engine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
public class HttpTaskManager {
    private Engine.IDownloadCallback engineCallback;
    private IHttpProxyProvider proxyProvider;
    private final HashMap<String, HttpTask> tasks = new HashMap<>();
    private ThreadPoolExecutor threadPool;

    public interface IHttpProxyProvider {
        Header[] getAllHeaders(String str);

        HttpHost getProxy(String str);
    }

    public HttpTaskManager(ThreadPoolExecutor threadPoolExecutor, Engine.IDownloadCallback iDownloadCallback, IHttpProxyProvider iHttpProxyProvider) {
        this.threadPool = threadPoolExecutor;
        this.engineCallback = iDownloadCallback;
        this.proxyProvider = iHttpProxyProvider;
    }

    public boolean startDownload(DownloadFileInfo downloadFileInfo) {
        HttpTask httpTask;
        boolean zStartDownload;
        String key = downloadFileInfo.getKey();
        synchronized (this.tasks) {
            if (this.tasks.containsKey(key)) {
                httpTask = this.tasks.get(key);
            } else {
                HttpTask httpTask2 = new HttpTask(this.threadPool, key, this.engineCallback, this.proxyProvider);
                this.tasks.put(key, httpTask2);
                httpTask = httpTask2;
            }
            zStartDownload = httpTask.startDownload(downloadFileInfo);
        }
        return zStartDownload;
    }

    public void stopAll() {
        synchronized (this.tasks) {
            Iterator<HttpTask> it = this.tasks.values().iterator();
            while (it.hasNext()) {
                it.next().stopDownload();
            }
            this.tasks.clear();
        }
    }

    public void stopDownload(String str) {
        synchronized (this.tasks) {
            if (this.tasks.containsKey(str)) {
                this.tasks.get(str).stopDownload();
                this.tasks.remove(str);
            }
        }
    }
}
