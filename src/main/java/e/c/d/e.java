package e.c.d;

import com.kugou.common.filemanager.downloadengine.entity.FileDownloadState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public final int a;
    public final Object b = new Object();
    public final Map<String, c> c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, c> f1289d = new HashMap();

    public e(String str, int i2) {
        this.a = i2;
    }

    public boolean a(c cVar) {
        if (cVar == null) {
            return false;
        }
        synchronized (this.b) {
            String str = cVar.a;
            if (!this.f1289d.containsKey(str) && !this.c.containsKey(str)) {
                cVar.i(FileDownloadState.FILE_DOWNLOAD_STATE_WAITING, "add to DownloadQueue");
                this.f1289d.put(str, cVar);
                d();
                return true;
            }
            return false;
        }
    }

    public final void b() {
        d();
    }

    public boolean c(c cVar) {
        boolean z;
        if (cVar == null) {
            return false;
        }
        synchronized (this.b) {
            String str = cVar.a;
            z = this.f1289d.remove(str) != null;
            if (!z) {
                boolean z2 = this.c.remove(str) != null;
                if (z2) {
                    b();
                }
                z = z2;
            }
        }
        return z;
    }

    public final void d() {
        synchronized (this.b) {
            int size = this.a - this.c.size();
            if (size <= 0) {
                return;
            }
            Iterator<Map.Entry<String, c>> it = this.f1289d.entrySet().iterator();
            while (size > 0 && it.hasNext()) {
                c value = it.next().getValue();
                if (value.g()) {
                    this.c.put(value.a, value);
                    it.remove();
                    size--;
                }
            }
        }
    }
}
