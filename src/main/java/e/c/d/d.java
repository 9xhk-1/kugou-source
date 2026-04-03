package e.c.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import com.kugou.common.filemanager.downloadengine.DownloadEngine;
import com.kugou.common.filemanager.downloadengine.DownloadStateInfo;
import com.kugou.common.filemanager.downloadengine.DownloadStatusInfo;
import com.kugou.common.filemanager.downloadengine.Engine;
import com.kugou.common.filemanager.downloadengine.EngineOption;
import com.kugou.common.filemanager.downloadengine.ID3Setter;
import com.kugou.common.filemanager.downloadengine.http.HttpTaskManager;
import e.c.d.d;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    @NonNull
    public HandlerC0210d a;

    @NonNull
    public DownloadEngine b;

    @NonNull
    public final List<g> c;

    public class a implements Engine.CallbackFormatID3 {
        public a(d dVar) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.CallbackFormatID3
        public void fetchID3(String str, int i2, String str2, long j, ID3Setter iD3Setter) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.CallbackFormatID3
        public int formatID3(String[] strArr, String str, String str2, String str3, byte[] bArr) {
            return 0;
        }
    }

    public class b implements Engine.ICheckNatCallback {
        public b(d dVar) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.ICheckNatCallback
        public void onCheckNatFailed(boolean z) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.ICheckNatCallback
        public void onCheckNatResult(boolean z, String str, int i2, int i3) {
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this(dVar);
        }
    }

    public class c implements Engine.IDownloadCallback {
        public c() {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public void OnSaveLastFlowInfo(String str) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public Engine.CardInfo getCardInfo() {
            return null;
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public String getTaskQuality(String str) {
            return "";
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public boolean isEncryptedFile(String str) {
            return false;
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public boolean isRealEncryptedFile(String str) {
            return false;
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public boolean loadDownloadLibrary() {
            e.c.d.f.a.e().d("DownloadManager", "loadDownloadLibrary");
            try {
                System.loadLibrary("jengine");
                return true;
            } catch (Throwable th) {
                e.c.d.f.a.e().eLF("DownloadManager", "loadDownloadLibrary fail\n" + Log.getStackTraceString(th));
                return false;
            }
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public void onCachedEncryptKeyChanged(String str) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public void onDownloadStateChanged(String str, DownloadStateInfo downloadStateInfo) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = downloadStateInfo;
            d.this.a.sendMessage(messageObtain);
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public void onDownloadStatus(String str, DownloadStatusInfo downloadStatusInfo) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            messageObtain.obj = downloadStatusInfo;
            d.this.a.sendMessage(messageObtain);
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public void onLogEvents(String str, String str2, boolean z) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public void onPeerID6Changed(long j) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.Engine.IDownloadCallback
        public void onPeerIDChanged(long j) {
        }

        public /* synthetic */ c(d dVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: e.c.d.d$d, reason: collision with other inner class name */
    public class HandlerC0210d extends Handler {
        public HandlerC0210d(@NonNull Looper looper) {
            super(looper);
        }

        public final void c(h hVar) {
            for (g gVar : d.this.c()) {
                if (d.this.f(gVar)) {
                    hVar.notify(gVar);
                }
            }
        }

        public final void d(final String str, final DownloadStateInfo downloadStateInfo) {
            c(new h() { // from class: e.c.d.b
                @Override // e.c.d.d.h
                public final void notify(d.g gVar) {
                    gVar.onDownloadStateChanged(str, downloadStateInfo);
                }
            });
        }

        public final void e(final String str, final DownloadStatusInfo downloadStatusInfo) {
            c(new h() { // from class: e.c.d.a
                @Override // e.c.d.d.h
                public final void notify(d.g gVar) {
                    gVar.onDownloadStatus(str, downloadStatusInfo);
                }
            });
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                DownloadStateInfo downloadStateInfo = (DownloadStateInfo) message.obj;
                d(downloadStateInfo.getKey(), downloadStateInfo);
            } else {
                if (i2 != 2) {
                    return;
                }
                DownloadStatusInfo downloadStatusInfo = (DownloadStatusInfo) message.obj;
                e(downloadStatusInfo.getKey(), downloadStatusInfo);
            }
        }
    }

    public static class e {
        public static final d a = new d(null);
    }

    public class f implements HttpTaskManager.IHttpProxyProvider {
        public f(d dVar) {
        }

        @Override // com.kugou.common.filemanager.downloadengine.http.HttpTaskManager.IHttpProxyProvider
        public Header[] getAllHeaders(String str) {
            return new Header[0];
        }

        @Override // com.kugou.common.filemanager.downloadengine.http.HttpTaskManager.IHttpProxyProvider
        public HttpHost getProxy(String str) {
            return null;
        }

        public /* synthetic */ f(d dVar, a aVar) {
            this(dVar);
        }
    }

    public interface g {
        void onDownloadStateChanged(String str, DownloadStateInfo downloadStateInfo);

        void onDownloadStatus(String str, DownloadStatusInfo downloadStatusInfo);
    }

    public interface h {
        void notify(g gVar);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d d() {
        return e.a;
    }

    public final List<g> c() {
        ArrayList arrayList;
        synchronized (this.c) {
            arrayList = new ArrayList(this.c);
        }
        return arrayList;
    }

    public DownloadEngine e() {
        return this.b;
    }

    public boolean f(g gVar) {
        boolean zContains;
        synchronized (this.c) {
            zContains = this.c.contains(gVar);
        }
        return zContains;
    }

    public boolean g(g gVar) {
        if (gVar == null) {
            return false;
        }
        synchronized (this.c) {
            if (this.c.contains(gVar)) {
                return false;
            }
            this.c.add(gVar);
            return true;
        }
    }

    public boolean h(g gVar) {
        boolean zRemove;
        if (gVar == null) {
            return false;
        }
        synchronized (this.c) {
            zRemove = this.c.remove(gVar);
        }
        return zRemove;
    }

    public d() {
        this.c = new ArrayList();
        HandlerThread handlerThread = new HandlerThread("DownloadManager");
        handlerThread.start();
        this.a = new HandlerC0210d(handlerThread.getLooper());
        EngineOption engineOption = new EngineOption();
        engineOption.EnginePort = 7701;
        engineOption.PeerID = 0L;
        engineOption.UUID = "b7f6e68f-1451-11eb-a236-001a7dda7111";
        engineOption.ClientVersion = 9000;
        engineOption.ChannelID = 201;
        engineOption.AppID = 1005;
        engineOption.MachineToken = "40f74c891c3af7a3b2dc44fd92fa721a008479287f1a373a9ea04391ee592d4e98950e68eeaa170995c6e174140b7bfaeebd26b3dbe91d930d26b33a5714dd8c";
        engineOption.UserAgent = "fastkugou-downloadEngine";
        engineOption.EnableHttpsSupport = true;
        a aVar = null;
        this.b = new DownloadEngine(e.c.d.f.a.c(), new c(this, aVar), new b(this, aVar), new a(this), new f(this, aVar), engineOption, null, null);
    }
}
