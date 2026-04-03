package retrofit2;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.kugou.common.network.AbsHttpVars;
import com.kugou.common.network.EventListenerProxy;
import com.kugou.common.network.Ipv6ClientListenerInfo;
import com.kugou.common.network.OKHttpManager;
import com.kugou.common.network.intercept.AbsAckInterceptor;
import com.kugou.common.network.intercept.SSAInterceptor;
import com.kugou.common.network.quic.CronetOKClientInterceptor;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.KGOKHttpClientExt;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes2.dex */
public class RetrofitClientManager {

    public static class AckInterceptorHolder {
        public static AckInterceptorImpl INSTANCE = new AckInterceptorImpl();

        private AckInterceptorHolder() {
        }
    }

    public static class AckInterceptorImpl extends AbsAckInterceptor {
        public final AbsHttpVars httpVars;
        public final Interceptor mockInterceptor;
        public final Interceptor outerInterceptor;

        public AckInterceptorImpl() {
            try {
                AbsHttpVars absHttpVars = (AbsHttpVars) Class.forName(Retrofit.httpVarsClassName).getDeclaredMethod("getInstance2", new Class[0]).invoke(null, new Object[0]);
                this.httpVars = absHttpVars;
                String outerInterceptor = absHttpVars.getOuterInterceptor();
                if (TextUtils.isEmpty(outerInterceptor)) {
                    this.outerInterceptor = getEmptyInterceptor();
                } else {
                    this.outerInterceptor = (Interceptor) Class.forName(outerInterceptor).newInstance();
                }
                String mockInterceptor = absHttpVars.getMockInterceptor();
                if (TextUtils.isEmpty(mockInterceptor)) {
                    this.mockInterceptor = getEmptyInterceptor();
                } else {
                    this.mockInterceptor = (Interceptor) Class.forName(mockInterceptor).newInstance();
                }
            } catch (Exception unused) {
                throw new IllegalStateException("httpVarsClassName is not correct");
            }
        }

        public Interceptor getEmptyInterceptor() {
            return new Interceptor() { // from class: retrofit2.RetrofitClientManager.AckInterceptorImpl.1
                @Override // okhttp3.Interceptor
                public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                    return chain.proceed(chain.request());
                }
            };
        }

        @Override // com.kugou.common.network.intercept.AbsAckInterceptor
        public AbsHttpVars getHttpVarsImpl() {
            return this.httpVars;
        }

        public Interceptor getMockInterceptor() {
            return this.mockInterceptor;
        }

        @NonNull
        public Interceptor getOuterInterceptor() {
            return this.outerInterceptor;
        }
    }

    public static class GateWayClient {

        public static class Holder {
            public static OkHttpClient INSTANCE = RetrofitClientManager.addInterceptor(KGOKHttpClientExt.onlyCallByKGHttpClient2().eventListener(EventListenerProxy.getInstance().rebuild()).connectionPool(OKHttpManager.gatewayConnectionPool)).build();
        }

        private GateWayClient() {
        }
    }

    public static class Ipv6Client {

        public static class Holder {
            public static OkHttpClient init() {
                OkHttpClient.Builder builderConnectionPool = KGOKHttpClientExt.onlyCallByKGHttpClient2().connectionPool(OKHttpManager.sGlobalHttpDftTimeOutConnectionPool);
                RetrofitClientManager.addInterceptor(builderConnectionPool);
                Dns initIpv6Dns = Ipv6ClientListenerInfo.init().getInitIpv6Dns();
                if (initIpv6Dns != null) {
                    builderConnectionPool.dns(initIpv6Dns);
                }
                EventListener initIpv6EventListener = Ipv6ClientListenerInfo.init().getInitIpv6EventListener();
                builderConnectionPool.connectIpv6Timeout(500L, TimeUnit.MILLISECONDS);
                if (initIpv6EventListener != null) {
                    builderConnectionPool.eventListener(initIpv6EventListener);
                }
                return builderConnectionPool.build();
            }
        }

        private Ipv6Client() {
        }
    }

    public static class NormalClient {

        public static class Holder {
            public static OkHttpClient init() {
                OkHttpClient.Builder builderConnectionPool = KGOKHttpClientExt.onlyCallByKGHttpClient2().connectionPool(OKHttpManager.sGlobalHttpDftTimeOutConnectionPool);
                RetrofitClientManager.addInterceptor(builderConnectionPool);
                Dns initIpv6Dns = Ipv6ClientListenerInfo.init().getInitIpv6Dns();
                if (initIpv6Dns != null) {
                    builderConnectionPool.dns(initIpv6Dns);
                }
                builderConnectionPool.connectIpv6Timeout(500L, TimeUnit.MILLISECONDS);
                builderConnectionPool.eventListener(EventListenerProxy.getInstance().rebuild());
                return builderConnectionPool.build();
            }
        }

        private NormalClient() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static OkHttpClient.Builder addInterceptor(OkHttpClient.Builder builder) {
        return builder.addInterceptor(AckInterceptorHolder.INSTANCE.getOuterInterceptor()).addInterceptor(AckInterceptorHolder.INSTANCE.getMockInterceptor()).addInterceptor(AckInterceptorHolder.INSTANCE).addInterceptor(new CronetOKClientInterceptor()).addInterceptor(SSAInterceptor.getInstance());
    }

    public static AckInterceptorImpl getInstance() {
        return AckInterceptorHolder.INSTANCE;
    }

    public static OkHttpClient getOKHttpClient(HttpUrl httpUrl) {
        return (httpUrl.isHttps() && httpUrl.host().contains(OKHttpManager.GATEWAY_KEY)) ? GateWayClient.Holder.INSTANCE : NormalClient.Holder.init();
    }
}
