package e.c.c.m;

import android.content.Context;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.networkutils.NetLog;
import com.kugou.common.network.proxy.KGHttpProxy;
import com.kugou.common.network.retry.IRetryStrategy;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;

/* JADX INFO: loaded from: classes2.dex */
public class h extends AbsHttpClient {

    public static class a extends AbsHttpVars {
        @Override // com.kugou.common.network.AbsHttpVars
        public KGHttpProxy getHttpProxy(String str) {
            return null;
        }

        @Override // com.kugou.common.network.AbsHttpVars
        public NetLog.ILog getILog() {
            return null;
        }

        @Override // com.kugou.common.network.AbsHttpVars
        public IRetryStrategy getRetryStrategy() {
            return null;
        }

        @Override // com.kugou.common.network.AbsHttpVars
        public boolean isRetryStaticsOn() {
            return false;
        }

        @Override // com.kugou.common.network.AbsHttpVars
        public void logRetryNetwork(RetryStaticsLOG retryStaticsLOG) {
        }

        @Override // com.kugou.common.network.AbsHttpVars
        public void startNetTraffic() {
        }

        @Override // com.kugou.common.network.AbsHttpVars
        public void stopNetTraffic(long j) {
        }
    }

    public h(Context context) {
        super(false, context, (AbsHttpVars) new a());
    }
}
