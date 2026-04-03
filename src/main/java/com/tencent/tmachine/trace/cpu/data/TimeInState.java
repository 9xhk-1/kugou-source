package com.tencent.tmachine.trace.cpu.data;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TimeInState {
    public static final TimeInState EMPTY = new TimeInState();
    private final LinkedHashMap<Long, Long> frequencyTimes = new LinkedHashMap<>();

    public long cpuTime() {
        Iterator<Long> it = this.frequencyTimes.values().iterator();
        long jLongValue = 0;
        while (it.hasNext()) {
            jLongValue += it.next().longValue() * 10;
        }
        return jLongValue;
    }

    public long getTimeOfFrequency(long j) {
        Long l = this.frequencyTimes.get(Long.valueOf(j));
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void setTime(long j, long j2) {
        this.frequencyTimes.put(Long.valueOf(j), Long.valueOf(j2));
    }
}
