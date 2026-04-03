package com.kugou.common.permission.rationale;

import android.support.annotation.NonNull;
import com.kugou.common.permission.Rationale;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class RationaleTrace {
    public static final String[] PERMISSION_INSTALL = {"install"};
    public static final String[] PERMISSION_OVERLAY = {"overlay"};
    public static final String[] PERMISSION_PARTICULAR = {"particular"};
    private TraceCallback traceCallback;

    public static class Holder {
        public static final RationaleTrace INSTANCE = new RationaleTrace();
    }

    public interface TraceCallback {
        boolean hasShowPermissionRationale(String str, String str2);

        void onTraceOccur(String[] strArr, String str);
    }

    public static class TraceCallbackNoOp implements TraceCallback {
        private final Map<String, Boolean> traceMap;

        private TraceCallbackNoOp() {
            this.traceMap = new HashMap();
        }

        @Override // com.kugou.common.permission.rationale.RationaleTrace.TraceCallback
        public boolean hasShowPermissionRationale(String str, String str2) {
            Boolean bool = this.traceMap.get(str + str2);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }

        @Override // com.kugou.common.permission.rationale.RationaleTrace.TraceCallback
        public void onTraceOccur(String[] strArr, String str) {
            for (String str2 : strArr) {
                this.traceMap.put(str2 + str, Boolean.TRUE);
            }
        }
    }

    public static RationaleTrace getInstance() {
        return Holder.INSTANCE;
    }

    private static String getRationaleHash(List<String> list, Rationale<?> rationale) {
        return rationale instanceof BaseKGRationale ? ((BaseKGRationale) rationale).rationaleKey(list) : String.valueOf(rationale.getClass().getName().hashCode());
    }

    public static boolean hasShowRationale(String str, Rationale<?> rationale) {
        return getInstance().traceCallback.hasShowPermissionRationale(str, getRationaleHash(Collections.singletonList(str), rationale));
    }

    public static void trace(String[] strArr, Rationale<?> rationale) {
        getInstance().traceCallback.onTraceOccur(strArr, getRationaleHash(Arrays.asList(strArr), rationale));
    }

    public void setTraceCallback(@NonNull TraceCallback traceCallback) {
        this.traceCallback = traceCallback;
    }

    private RationaleTrace() {
        this.traceCallback = new TraceCallbackNoOp();
    }
}
