package com.kugou.common.network.intercept;

import android.os.SystemClock;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class SSALimit {
    private static final int LIMIT_CALLBACK = 3;
    private static final long LIMIT_INTERVAL = 600000;
    private final Object mutex;
    private Queue<Long> queue;

    public static class Holder {
        public static final SSALimit INSTANCE = new SSALimit();
    }

    public static class LimitStatus {
        public final boolean isBlocked;
        public final long nextPopTime;

        public LimitStatus(boolean z, long j) {
            this.isBlocked = z;
            this.nextPopTime = j;
        }
    }

    private boolean canOfferOnQueueOK() {
        boolean z = true;
        if (this.queue.size() < 3) {
            return true;
        }
        Long lPeek = this.queue.peek();
        if (lPeek != null && getCurrentDeviceTime() - lPeek.longValue() <= LIMIT_INTERVAL) {
            z = false;
        }
        if (z) {
            this.queue.poll();
        }
        return z;
    }

    public static SSALimit getInstance() {
        return Holder.INSTANCE;
    }

    public boolean canPopIntercept() {
        synchronized (this.mutex) {
            if (!canOfferOnQueueOK()) {
                return false;
            }
            this.queue.offer(Long.valueOf(getCurrentDeviceTime()));
            return true;
        }
    }

    public long getCurrentDeviceTime() {
        return SystemClock.elapsedRealtime();
    }

    public LimitStatus getLimitStatus() {
        LimitStatus limitStatus;
        synchronized (this.mutex) {
            Long lPeek = this.queue.peek();
            boolean zCanOfferOnQueueOK = canOfferOnQueueOK();
            long currentDeviceTime = getCurrentDeviceTime();
            long jMax = 0;
            if (!zCanOfferOnQueueOK && lPeek != null) {
                jMax = Math.max(LIMIT_INTERVAL - (currentDeviceTime - lPeek.longValue()), 0L);
            }
            limitStatus = new LimitStatus(!zCanOfferOnQueueOK, jMax);
        }
        return limitStatus;
    }

    private SSALimit() {
        this.mutex = new Object();
        this.queue = new LinkedList();
    }
}
