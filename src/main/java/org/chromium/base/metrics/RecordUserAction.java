package org.chromium.base.metrics;

/* JADX INFO: loaded from: classes2.dex */
public class RecordUserAction {

    public interface UserActionCallback {
        void onActionRecorded(String str);
    }

    private static native long nativeAddActionCallbackForTesting(UserActionCallback userActionCallback);

    private static native void nativeRecordUserAction(String str);

    private static native void nativeRemoveActionCallbackForTesting(long j);
}
