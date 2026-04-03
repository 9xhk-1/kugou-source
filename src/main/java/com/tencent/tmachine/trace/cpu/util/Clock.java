package com.tencent.tmachine.trace.cpu.util;

import f.z.d.g;

/* JADX INFO: loaded from: classes2.dex */
public final class Clock {
    public static final Companion Companion = new Companion(null);
    private static final Timer anchor;
    private static final Clock clock;

    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: renamed from: default, reason: not valid java name */
        public final Clock m14default() {
            return Clock.clock;
        }

        public final long getCurrentTimestampMicros() {
            return Clock.anchor.getCurrentTimestampMicros();
        }

        public final long getCurrentTimestampMs() {
            return Clock.anchor.getCurrentTimestampMicros() / ((long) 1000);
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    static {
        Clock clock2 = new Clock();
        clock = clock2;
        anchor = clock2.getTime();
    }

    /* JADX INFO: renamed from: default, reason: not valid java name */
    public static final Clock m13default() {
        return Companion.m14default();
    }

    public static final long getCurrentTimestampMicros() {
        return Companion.getCurrentTimestampMicros();
    }

    public static final long getCurrentTimestampMs() {
        return Companion.getCurrentTimestampMs();
    }

    public final Timer getTime() {
        return new Timer();
    }
}
