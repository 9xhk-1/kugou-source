package e.c.a.g.a.f.k.k;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.common.network.KGHttpVariables;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.networkutils.KGNetworkUtil;
import com.kugou.common.network.protocol.RequestPackage;
import com.kugou.common.network.protocol.ResponsePackage;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class e extends AbsHttpClient {
    public boolean a;

    public class a implements g {
        public a(e eVar) {
        }

        @Override // e.c.a.g.a.f.k.k.g
        public void onRequestDone(int i2, long j) {
        }
    }

    public e() {
        super(e.c.c.o.f.a(), KGHttpVariables.getInstance());
        this.a = false;
    }

    @Deprecated
    public static e a() {
        return new e();
    }

    @Nullable
    public final g b(@NonNull String str) throws IOException {
        SystemClock.elapsedRealtime();
        String strA = c.a(str);
        if (b.a().c() && !b.a().b(strA)) {
            throw new IOException("is not core request");
        }
        if (isMonitorEnable()) {
            return new a(this);
        }
        return null;
    }

    @Override // com.kugou.common.network.AbsHttpClient
    public boolean isStatisticHost() {
        return this.a;
    }

    @Override // com.kugou.common.network.AbsHttpClient
    public void request(RequestPackage requestPackage, ResponsePackage<Object> responsePackage) throws Exception {
        String strB = c.b(requestPackage);
        this.a = d.e(strB);
        setMonitorEnable(!d.b(strB));
        g gVarB = null;
        try {
            try {
                gVarB = b(strB);
                if (isMonitorEnable()) {
                    this.stackHash = KGNetworkUtil.genStackHash(2);
                }
                super.request(requestPackage, responsePackage);
                if (responsePackage instanceof e.c.a.g.a.f.k.k.a) {
                    ((e.c.a.g.a.f.k.k.a) responsePackage).handleSuccess();
                }
                if (gVarB != null) {
                    try {
                        gVarB.onRequestDone(0, getReadContentBytes());
                    } catch (Exception unused) {
                    }
                }
            } catch (Error e2) {
                throw e2;
            } catch (Exception e3) {
                int iC = f.c(e3);
                if (responsePackage instanceof e.c.a.g.a.f.k.k.a) {
                    ((e.c.a.g.a.f.k.k.a) responsePackage).handleFail(iC, e3.getMessage(), e3.getClass().getName());
                }
                if (!(e3 instanceof IOException) && (e3 instanceof IllegalStateException)) {
                    TextUtils.equals("network is offline-mode", e3.getMessage());
                }
                throw e3;
            }
        } catch (Throwable th) {
            if (gVarB != null) {
                try {
                    gVarB.onRequestDone(0, getReadContentBytes());
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    @Override // com.kugou.common.network.AbsHttpClient
    public void requestWithWatch(RequestPackage requestPackage, AbsHttpClient.IStreamHandler iStreamHandler) throws Exception {
        this.a = d.e(c.b(requestPackage));
        setMonitorEnable(!d.b(r0));
        super.requestWithWatch(requestPackage, iStreamHandler);
    }
}
