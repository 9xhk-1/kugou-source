package com.tencent.tmachine.trace.provider.stacktrace;

import f.z.d.g;

/* JADX INFO: loaded from: classes2.dex */
public final class StackTraceConfig {
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_CONSUME_THRESHOLD = -1;
    public static final long DEFAULT_TRACE_DURATION = 30000;
    public static final long DEFAULT_TRACE_INTERVAL = 50;
    private boolean enableFullStackCollect;
    private long traceInterval = 50;
    private long traceDuration = DEFAULT_TRACE_DURATION;
    private long consumeThreshold = -1;
    private boolean withLockTrace = true;
    private boolean withSignature = true;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final long getConsumeThreshold() {
        return this.consumeThreshold;
    }

    public final long getTraceDuration() {
        return this.traceDuration;
    }

    public final long getTraceInterval() {
        return this.traceInterval;
    }

    public final boolean isEnableFullStackCollect() {
        return this.enableFullStackCollect;
    }

    public final boolean isWithLockTrace() {
        return this.withLockTrace;
    }

    public final boolean isWithSignature() {
        return this.withSignature;
    }

    public final StackTraceConfig setConsumeThreshold(long j) {
        this.consumeThreshold = j;
        return this;
    }

    public final StackTraceConfig setEnableFullStackCollect(boolean z) {
        this.enableFullStackCollect = z;
        return this;
    }

    public final StackTraceConfig setTraceDuration(long j) {
        this.traceDuration = j;
        return this;
    }

    public final StackTraceConfig setTraceInterval(long j) {
        this.traceInterval = j;
        return this;
    }

    public final StackTraceConfig setWithLockTrace(boolean z) {
        this.withLockTrace = z;
        return this;
    }

    public final StackTraceConfig setWithSignature(boolean z) {
        this.withSignature = z;
        return this;
    }

    public String toString() {
        return "StackTraceConfig(traceInterval=" + this.traceInterval + ", traceDuration=" + this.traceDuration + ", consumeThreshold=" + this.consumeThreshold + ", withLockTrace=" + this.withLockTrace + ", withSignature=" + this.withSignature + ", enableFullStackCollect=" + this.enableFullStackCollect + ')';
    }
}
