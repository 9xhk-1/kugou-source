package e.c.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.kugou.common.filemanager.downloadengine.DownloadEngine;
import com.kugou.common.filemanager.downloadengine.DownloadFileInfo;
import com.kugou.common.filemanager.downloadengine.DownloadOption;
import com.kugou.common.filemanager.downloadengine.TrackerExtraParam;
import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public final String a;
    public final String b;
    public final String[] c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final DownloadFileInfo f1281f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final DownloadOption f1282g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final DownloadEngine f1283h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f1284i;
    public volatile FileDownloadState j;

    public static class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static AtomicLong f1285g = new AtomicLong();
        public DownloadEngine a;
        public String b = g();
        public String c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String[] f1286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f1287e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f1288f;

        public static String g() {
            return String.valueOf(f1285g.incrementAndGet());
        }

        public c a() {
            i(this.a == null, "engine");
            i(TextUtils.isEmpty(this.b), "key");
            i(TextUtils.isEmpty(this.c), "filePath");
            i(this.f1286d == null, "urls");
            return new c(this.a, this.b, this.c, this.f1286d, this.f1287e, this.f1288f);
        }

        public b b(DownloadEngine downloadEngine) {
            this.a = downloadEngine;
            return this;
        }

        public b c(String str) {
            this.f1287e = str;
            return this;
        }

        public b d(String str) {
            this.c = str;
            return this;
        }

        public b e(long j) {
            this.f1288f = j;
            return this;
        }

        public b f(String str) {
            this.b = str;
            return this;
        }

        public b h(String[] strArr) {
            this.f1286d = strArr;
            return this;
        }

        public final void i(boolean z, String str) {
            if (z) {
                throw new IllegalArgumentException("must set the " + str);
            }
        }
    }

    public final DownloadFileInfo a() {
        return new DownloadFileInfo(this.a, this.b, this.c, new String[]{""}, "", this.f1279d, "", this.f1280e, false, 0, "", 1, "0", 0L, new TrackerExtraParam(), false, 0, 2, 1, false, "", "");
    }

    public final DownloadOption b() {
        return new DownloadOption(1, false, false, false, false, false, 0L, false, false);
    }

    public final void c() {
        if (!this.f1284i) {
            this.f1284i = true;
            this.f1283h.addDownload(this.f1281f);
        }
        this.f1283h.startDownload(this.f1281f, this.f1282g);
        this.j = FileDownloadState.FILE_DOWNLOAD_STATE_DOWNLOADING;
    }

    public final void d(int i2) {
        this.f1283h.stopDownload(this.f1281f.getKey(), i2);
        this.j = FileDownloadState.FILE_DOWNLOAD_STATE_STOP;
    }

    @NonNull
    public DownloadFileInfo e() {
        return this.f1281f;
    }

    public long f() {
        return this.f1283h.makeStream(this.a);
    }

    public boolean g() {
        c();
        return true;
    }

    public boolean h(int i2) {
        d(i2);
        return true;
    }

    public void i(FileDownloadState fileDownloadState, String str) {
        e.c.d.f.a.e().d("DownloadFile", "[" + this.a + "] setState " + this.j + " -> " + fileDownloadState + " (" + str + ")");
        this.j = fileDownloadState;
    }

    public c(@NonNull DownloadEngine downloadEngine, String str, String str2, String[] strArr, String str3, long j) {
        this.j = FileDownloadState.FILE_DOWNLOAD_STATE_NONE;
        this.f1283h = downloadEngine;
        this.a = str;
        this.b = str2;
        this.c = strArr;
        this.f1279d = str3;
        this.f1280e = j;
        this.f1281f = a();
        this.f1282g = b();
    }
}
