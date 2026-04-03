package com.kugou.common.network.intercept;

import com.kugou.common.network.networkutils.UrlEncoderUtil;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
public class SSAInterceptor implements Interceptor {
    private OnVerificationListener listener;
    private Set<String> whiteList = new HashSet();
    private final Lock lock = new ReentrantLock();
    private boolean isEnableInterceptAll = false;
    private AtomicBoolean isVerified = new AtomicBoolean(false);

    public static class Holder {
        public static SSAInterceptor INSTANCE = new SSAInterceptor();

        private Holder() {
        }
    }

    public static SSAInterceptor getInstance() {
        return Holder.INSTANCE;
    }

    private boolean isAllowIntercept(String str) {
        return this.whiteList.contains(str);
    }

    private Response ssaProceed(Interceptor.Chain chain, Response response, String str) throws IOException {
        Request request = chain.request();
        if (!getLock().tryLock()) {
            getLock().lock();
            boolean verifyResult = getVerifyResult();
            getLock().unlock();
            return verifyResult ? chain.proceed(request.newBuilder().build()) : response;
        }
        resetVerifyResult();
        if (!onIntercept(request.url().toString(), str, getOnVerificationListener())) {
            return response;
        }
        Headers.Builder builderNewBuilder = request.headers().newBuilder();
        Headers headers = getOnVerificationListener().getHeaders();
        if (headers != null) {
            builderNewBuilder.addAll(headers);
        }
        Response responseProceed = chain.proceed(request.newBuilder().headers(builderNewBuilder.build()).build());
        String str2 = responseProceed.headers().get("SSA-CODE");
        return str2 != null ? ssaProceed(chain, responseProceed, str2) : responseProceed;
    }

    public void addUrlListToWhite(List<String> list) {
        this.whiteList.addAll(list);
    }

    public void addUrlToWhite(String str) {
        this.whiteList.add(str);
    }

    public Lock getLock() {
        return this.lock;
    }

    public OnVerificationListener getOnVerificationListener() {
        return this.listener;
    }

    public boolean getVerifyResult() {
        return this.isVerified.get();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        Request request = chain.request();
        Response responseProceed = chain.proceed(request);
        return (!request.isSupportSSA() || (str = responseProceed.headers().get("SSA-CODE")) == null) ? responseProceed : ssaProceed(chain, responseProceed, str);
    }

    public boolean isEnableInterceptAll() {
        return this.isEnableInterceptAll;
    }

    public boolean onIntercept(String str, String str2, OnVerificationListener onVerificationListener) {
        try {
            if (!SSALimit.getInstance().canPopIntercept() || (!this.isEnableInterceptAll && !isAllowIntercept(UrlEncoderUtil.excludeUrlParams(str)))) {
                return false;
            }
            boolean zOnIntercept = onVerificationListener.onIntercept(str, str2);
            this.isVerified.set(zOnIntercept);
            return zOnIntercept;
        } finally {
            this.lock.unlock();
        }
    }

    public void resetVerifyResult() {
        this.isVerified.set(false);
    }

    public void setEnableInterceptAll(boolean z) {
        this.isEnableInterceptAll = z;
    }

    public void setOnVerificationListener(OnVerificationListener onVerificationListener) {
        this.listener = onVerificationListener;
    }
}
