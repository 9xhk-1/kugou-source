package com.tencent.tmachine.trace.looper.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.tencent.tmachine.trace.util.ReflectUtils;
import com.tencent.tmachine.trace.util.TMachineLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityThreadUtil {
    private static final String TAG = "TMachine.ActivityThreadHacker";
    private static Object activityThreadH = null;
    private static final List<Handler.Callback> handlerCallbacks = new ArrayList();
    public static boolean hasHacked = false;

    public static final class HackCallback implements Handler.Callback {
        public static int BIND_SERVICE = 121;
        public static int CREATE_SERVICE = 114;
        public static int DESTROY_ACTIVITY = 109;
        public static int EXECUTE_TRANSACTION = 159;
        public static int INSTALL_PROVIDER = 145;
        public static int LAUNCH_ACTIVITY = 100;
        public static int PAUSE_ACTIVITY = 101;
        public static int PAUSE_ACTIVITY_FINISHING = 102;
        public static int RECEIVER = 113;
        public static int RELAUNCH_ACTIVITY = 160;
        public static int RELAUNCH_ACTIVITY_BEFORE_9 = 126;
        public static int RELAUNCH_ACTIVITY_SINCE_9 = 160;
        public static int RESUME_ACTIVITY = 107;
        public static int SERVICE_ARGS = 115;
        public static int STOP_ACTIVITY_HIDE = 104;
        public static int STOP_ACTIVITY_SHOW = 103;
        public static int STOP_SERVICE = 116;
        public static int UNBIND_SERVICE = 122;
        private static Method method;
        private final Handler.Callback mOriginalCallback;

        public HackCallback(Handler.Callback callback) {
            this.mOriginalCallback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
        public static boolean isActivityMsg(Message message) {
            if (message == null) {
                return false;
            }
            int i2 = message.what;
            if (i2 == EXECUTE_TRANSACTION && message.obj != null) {
                try {
                    if (method == null) {
                        Method declaredMethod = Class.forName("android.app.servertransaction.ClientTransaction").getDeclaredMethod("getCallbacks", new Class[0]);
                        method = declaredMethod;
                        declaredMethod.setAccessible(true);
                    }
                    List list = (List) method.invoke(message.obj, new Object[0]);
                    if (list != null && !list.isEmpty()) {
                        if (list.get(0).getClass().getName().endsWith(".LaunchActivityItem")) {
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            return Build.VERSION.SDK_INT <= 27 ? i2 == LAUNCH_ACTIVITY || i2 == PAUSE_ACTIVITY || i2 == PAUSE_ACTIVITY_FINISHING || i2 == STOP_ACTIVITY_SHOW || i2 == STOP_ACTIVITY_HIDE || i2 == RESUME_ACTIVITY || i2 == DESTROY_ACTIVITY || i2 == RELAUNCH_ACTIVITY : i2 == RELAUNCH_ACTIVITY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isProviderMsg(int i2) {
            return i2 == INSTALL_PROVIDER;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isReceiverMsg(Message message) {
            if (message.what == RECEIVER) {
                return true;
            }
            Handler target = message.getTarget();
            Runnable callback = message.getCallback();
            return target != null && target == ActivityThreadUtil.activityThreadH && callback != null && callback.toString().contains("LoadedApk$ReceiverDispatcher");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isServiceMsg(int i2) {
            return i2 == CREATE_SERVICE || i2 == SERVICE_ARGS || i2 == STOP_SERVICE || i2 == BIND_SERVICE || i2 == UNBIND_SERVICE;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                Iterator it = ActivityThreadUtil.handlerCallbacks.iterator();
                while (it.hasNext()) {
                    ((Handler.Callback) it.next()).handleMessage(message);
                }
            } catch (Throwable th) {
                TMachineLog.e(ActivityThreadUtil.TAG, "[handleMessage] err", th);
            }
            Handler.Callback callback = this.mOriginalCallback;
            return callback != null && callback.handleMessage(message);
        }
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public static void hackSysHandlerCallback() {
        if (hasHacked) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 != null) {
                initKeyMsgWhat(obj2);
                Class<? super Object> superclass = obj2.getClass().getSuperclass();
                if (superclass != null) {
                    Field declaredField3 = superclass.getDeclaredField("mCallback");
                    declaredField3.setAccessible(true);
                    declaredField3.set(obj2, new HackCallback((Handler.Callback) declaredField3.get(obj2)));
                    activityThreadH = obj2;
                    hasHacked = true;
                    TMachineLog.i(TAG, "hook system handler completed. SDK_INT:%s", Integer.valueOf(Build.VERSION.SDK_INT));
                }
            }
        } catch (Exception e2) {
            TMachineLog.e(TAG, "hook system handler err! %s", e2);
        }
    }

    private static void initKeyMsgWhat(Object obj) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= 27) {
            HackCallback.LAUNCH_ACTIVITY = ((Integer) ReflectUtils.reflectObject(obj, "LAUNCH_ACTIVITY", Integer.valueOf(HackCallback.LAUNCH_ACTIVITY), false)).intValue();
            HackCallback.PAUSE_ACTIVITY = ((Integer) ReflectUtils.reflectObject(obj, "PAUSE_ACTIVITY", Integer.valueOf(HackCallback.PAUSE_ACTIVITY), false)).intValue();
            HackCallback.PAUSE_ACTIVITY_FINISHING = ((Integer) ReflectUtils.reflectObject(obj, "PAUSE_ACTIVITY_FINISHING", Integer.valueOf(HackCallback.PAUSE_ACTIVITY_FINISHING), false)).intValue();
            HackCallback.STOP_ACTIVITY_SHOW = ((Integer) ReflectUtils.reflectObject(obj, "STOP_ACTIVITY_SHOW", Integer.valueOf(HackCallback.STOP_ACTIVITY_SHOW), false)).intValue();
            HackCallback.STOP_ACTIVITY_HIDE = ((Integer) ReflectUtils.reflectObject(obj, "STOP_ACTIVITY_HIDE", Integer.valueOf(HackCallback.STOP_ACTIVITY_HIDE), false)).intValue();
            HackCallback.RESUME_ACTIVITY = ((Integer) ReflectUtils.reflectObject(obj, "RESUME_ACTIVITY", Integer.valueOf(HackCallback.RESUME_ACTIVITY), false)).intValue();
            HackCallback.DESTROY_ACTIVITY = ((Integer) ReflectUtils.reflectObject(obj, "DESTROY_ACTIVITY", Integer.valueOf(HackCallback.DESTROY_ACTIVITY), false)).intValue();
        }
        if (i2 <= 27) {
            HackCallback.RELAUNCH_ACTIVITY = ((Integer) ReflectUtils.reflectObject(obj, "RELAUNCH_ACTIVITY", Integer.valueOf(HackCallback.RELAUNCH_ACTIVITY_BEFORE_9), false)).intValue();
        } else {
            HackCallback.RELAUNCH_ACTIVITY = ((Integer) ReflectUtils.reflectObject(obj, "RELAUNCH_ACTIVITY", Integer.valueOf(HackCallback.RELAUNCH_ACTIVITY_SINCE_9), false)).intValue();
        }
        HackCallback.CREATE_SERVICE = ((Integer) ReflectUtils.reflectObject(obj, "CREATE_SERVICE", Integer.valueOf(HackCallback.CREATE_SERVICE), false)).intValue();
        HackCallback.SERVICE_ARGS = ((Integer) ReflectUtils.reflectObject(obj, "SERVICE_ARGS", Integer.valueOf(HackCallback.SERVICE_ARGS), false)).intValue();
        HackCallback.STOP_SERVICE = ((Integer) ReflectUtils.reflectObject(obj, "STOP_SERVICE", Integer.valueOf(HackCallback.STOP_SERVICE), false)).intValue();
        HackCallback.BIND_SERVICE = ((Integer) ReflectUtils.reflectObject(obj, "BIND_SERVICE", Integer.valueOf(HackCallback.BIND_SERVICE), false)).intValue();
        HackCallback.UNBIND_SERVICE = ((Integer) ReflectUtils.reflectObject(obj, "UNBIND_SERVICE", Integer.valueOf(HackCallback.UNBIND_SERVICE), false)).intValue();
        HackCallback.RECEIVER = ((Integer) ReflectUtils.reflectObject(obj, "RECEIVER", Integer.valueOf(HackCallback.RECEIVER), false)).intValue();
        HackCallback.INSTALL_PROVIDER = ((Integer) ReflectUtils.reflectObject(obj, "INSTALL_PROVIDER", Integer.valueOf(HackCallback.INSTALL_PROVIDER), false)).intValue();
    }

    public static String isKeyMsg(Message message) {
        if (message == null) {
            return null;
        }
        int i2 = message.what;
        if (HackCallback.isActivityMsg(message)) {
            return i2 == HackCallback.EXECUTE_TRANSACTION ? "LAUNCH_ACTIVITY" : msgWhatToString(i2);
        }
        if (HackCallback.isServiceMsg(i2)) {
            return msgWhatToString(i2);
        }
        if (HackCallback.isReceiverMsg(message)) {
            return i2 != HackCallback.RECEIVER ? "RECEIVER" : msgWhatToString(i2);
        }
        if (HackCallback.isProviderMsg(i2)) {
            return msgWhatToString(i2);
        }
        return null;
    }

    private static String msgWhatToString(int i2) {
        return i2 == HackCallback.LAUNCH_ACTIVITY ? "LAUNCH_ACTIVITY" : i2 == HackCallback.PAUSE_ACTIVITY ? "PAUSE_ACTIVITY" : i2 == HackCallback.PAUSE_ACTIVITY_FINISHING ? "PAUSE_ACTIVITY_FINISHING" : i2 == HackCallback.STOP_ACTIVITY_SHOW ? "STOP_ACTIVITY_SHOW" : i2 == HackCallback.STOP_ACTIVITY_HIDE ? "STOP_ACTIVITY_HIDE" : i2 == HackCallback.RESUME_ACTIVITY ? "RESUME_ACTIVITY" : i2 == HackCallback.DESTROY_ACTIVITY ? "DESTROY_ACTIVITY" : i2 == HackCallback.RELAUNCH_ACTIVITY ? "RELAUNCH_ACTIVITY" : i2 == HackCallback.CREATE_SERVICE ? "CREATE_SERVICE" : i2 == HackCallback.SERVICE_ARGS ? "SERVICE_ARGS" : i2 == HackCallback.STOP_SERVICE ? "STOP_SERVICE" : i2 == HackCallback.BIND_SERVICE ? "BIND_SERVICE" : i2 == HackCallback.UNBIND_SERVICE ? "UNBIND_SERVICE" : i2 == HackCallback.RECEIVER ? "RECEIVER" : i2 == HackCallback.INSTALL_PROVIDER ? "INSTALL_PROVIDER" : Integer.toString(i2);
    }

    public static void register(Handler.Callback callback) {
        if (callback != null) {
            handlerCallbacks.add(callback);
        }
    }

    public static void unRegister(Handler.Callback callback) {
        if (callback != null) {
            handlerCallbacks.remove(callback);
        }
    }
}
