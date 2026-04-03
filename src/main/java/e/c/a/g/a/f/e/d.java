package e.c.a.g.a.f.e;

import android.content.Intent;
import com.kugou.common.config.BasicKeys;
import com.kugou.common.config.KGConfigUpdaterBase;
import com.kugou.common.config.v2.UpdateConfigResponseV2;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.c.o.h;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends KGConfigUpdaterBase {
    public static volatile d b;
    public volatile int a = 0;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g0.a) {
                g0.b("KGConfigUpdater", "KGConfigUpdater.executeSafe");
            }
            d.this.execute();
        }
    }

    public static d b() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public void a() {
        h.b().a(new a());
    }

    @Override // com.kugou.common.config.KGConfigUpdaterBase
    public int getCursorId() {
        return c.c().getConfigAsInt(BasicKeys.cursorId);
    }

    @Override // com.kugou.common.config.KGConfigUpdaterBase
    public String getPackageChannelId() {
        return l1.j();
    }

    @Override // com.kugou.common.config.KGConfigUpdaterBase
    public File getWholeConfigFile() {
        return c.c().getConfigFile();
    }

    @Override // com.kugou.common.config.KGConfigUpdaterBase
    public void onException(Exception exc) {
        if (g0.a) {
            g0.i(exc);
        }
    }

    @Override // com.kugou.common.config.KGConfigUpdaterBase
    public void onSaveSuccess(UpdateConfigResponseV2 updateConfigResponseV2) throws Throwable {
        c.c().updateFromCache();
        int i2 = this.a;
        int cursorId = getCursorId();
        if (cursorId > i2) {
            e.c.a.g.a.f.d.a.e(new Intent("com.kugou.android.action.config.update.complete"), true);
        }
        if (g0.a) {
            g0.b("KGConfigUpdater", "onSaveSuccess: oldCursor=" + i2 + "  newCursor=" + cursorId);
        }
    }

    @Override // com.kugou.common.config.KGConfigUpdaterBase
    public UpdateConfigResponseV2 requestUpdates() {
        this.a = getCursorId();
        return new e.c.a.g.a.f.e.a().requestAll(c.c().getConfigAsInt(BasicKeys.cursorId, 0), true);
    }

    @Override // com.kugou.common.config.KGConfigUpdaterBase
    public boolean saveDataToCache(int i2, JSONObject jSONObject) {
        try {
            return c.c().saveJSONObjectToFile(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
