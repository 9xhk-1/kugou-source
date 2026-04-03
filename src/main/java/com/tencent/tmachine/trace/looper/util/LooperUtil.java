package com.tencent.tmachine.trace.looper.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.tencent.tmachine.trace.util.ReflectUtils;
import com.tencent.tmachine.trace.util.TMachineLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LooperUtil {
    private static final String TAG = "LooperUtil";
    private static Field mQueueField;
    private static Field nextField;

    @SuppressLint({"DiscouragedPrivateApi"})
    public static List<Message> getLooperPendingMessages() {
        try {
            if (mQueueField == null || nextField == null) {
                Field declaredField = Looper.class.getDeclaredField("mQueue");
                mQueueField = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = Message.class.getDeclaredField("next");
                nextField = declaredField2;
                declaredField2.setAccessible(true);
            }
            MessageQueue queue = Build.VERSION.SDK_INT <= 23 ? (MessageQueue) mQueueField.get(Looper.getMainLooper()) : Looper.getMainLooper().getQueue();
            ArrayList arrayList = new ArrayList();
            for (Message message = (Message) ReflectUtils.get(MessageQueue.class, "mMessages", queue); message != null; message = (Message) nextField.get(message)) {
                arrayList.add(message);
            }
            return arrayList;
        } catch (Throwable th) {
            TMachineLog.e(TAG, "[getLooperPendingMessages] error", th);
            return null;
        }
    }
}
