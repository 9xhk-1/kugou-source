package org.chromium.base.metrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RecordHistogram {
    public static Map<String, Long> a = Collections.synchronizedMap(new HashMap());

    private static native int nativeGetHistogramTotalCountForTesting(String str);

    private static native int nativeGetHistogramValueCountForTesting(String str, int i2);

    private static native long nativeRecordBooleanHistogram(String str, long j, boolean z);

    private static native long nativeRecordCustomCountHistogram(String str, long j, int i2, int i3, int i4, int i5);

    private static native long nativeRecordCustomTimesHistogramMilliseconds(String str, long j, int i2, int i3, int i4, int i5);

    private static native long nativeRecordEnumeratedHistogram(String str, long j, int i2, int i3);

    private static native long nativeRecordLinearCountHistogram(String str, long j, int i2, int i3, int i4, int i5);

    private static native long nativeRecordSparseHistogram(String str, long j, int i2);
}
