package com.tencent.tmachine.trace.looper.monitor;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.tmachine.trace.looper.listeners.ILooperListener;
import com.tencent.tmachine.trace.util.ReflectUtils;
import com.tencent.tmachine.trace.util.TMachineLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class LooperMonitor implements MessageQueue.IdleHandler {
    private static final long CHECK_TIME = 60000;
    private static final String TAG = "TMachine.LooperMonitor";
    private Looper looper;
    private LooperPrinter printer;
    private static final Map<Looper, LooperMonitor> sLooperMonitorMap = new ConcurrentHashMap();
    private static final LooperMonitor sMainMonitor = of(Looper.getMainLooper());
    private static boolean isReflectLoggingError = false;
    private final Map<ILooperListener, LooperDispatchListener> listeners = new HashMap();
    private long lastCheckPrinterTime = 0;

    public static final class LooperDispatchListener {
        private long beginNs;
        private final ILooperListener dispatchListener;
        public boolean isHasDispatchStart = false;

        public LooperDispatchListener(ILooperListener iLooperListener) {
            this.dispatchListener = iLooperListener;
        }

        public boolean isValid() {
            return this.dispatchListener.isValid();
        }

        @CallSuper
        public void onDispatchEnd(String str, Message message) {
            this.isHasDispatchStart = false;
            this.dispatchListener.onDispatchEnd(str, this.beginNs, System.nanoTime());
        }

        @CallSuper
        public void onDispatchStart(String str, Message message) {
            this.isHasDispatchStart = true;
            this.beginNs = System.nanoTime();
            this.dispatchListener.onDispatchBegin(str);
        }
    }

    public class LooperPrinter implements Printer {
        public boolean isHasChecked = false;
        public boolean isValid = false;
        public Printer origin;

        public LooperPrinter(Printer printer) {
            this.origin = printer;
        }

        @Override // android.util.Printer
        public void println(String str) {
            Printer printer = this.origin;
            if (printer != null) {
                printer.println(str);
                if (this.origin == this) {
                    throw new RuntimeException("TMachine.LooperMonitor origin == this");
                }
            }
            if (!this.isHasChecked) {
                boolean z = str.charAt(0) == '>' || str.charAt(0) == '<';
                this.isValid = z;
                this.isHasChecked = true;
                if (!z) {
                    TMachineLog.e(LooperMonitor.TAG, "[println] Printer is inValid! x:%s", str);
                }
            }
            if (this.isValid) {
                LooperMonitor.this.dispatch(str.charAt(0) == '>', str, null);
            }
        }
    }

    private LooperMonitor(Looper looper) {
        Objects.requireNonNull(looper);
        this.looper = looper;
        resetPrinter();
        addIdleHandler(looper);
    }

    private synchronized void addIdleHandler(Looper looper) {
        if (Build.VERSION.SDK_INT >= 23) {
            looper.getQueue().addIdleHandler(this);
        } else {
            try {
                ((MessageQueue) ReflectUtils.get(looper.getClass(), "mQueue", looper)).addIdleHandler(this);
            } catch (Exception e2) {
                TMachineLog.e(TAG, "[removeIdleHandler] %s", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatch(boolean z, String str, Message message) {
        synchronized (this.listeners) {
            for (LooperDispatchListener looperDispatchListener : this.listeners.values()) {
                if (z) {
                    if (!looperDispatchListener.isHasDispatchStart) {
                        looperDispatchListener.onDispatchStart(str, message);
                    }
                } else if (looperDispatchListener.isHasDispatchStart) {
                    looperDispatchListener.onDispatchEnd(str, message);
                }
            }
        }
    }

    public static LooperMonitor of(@NonNull Looper looper) {
        Map<Looper, LooperMonitor> map = sLooperMonitorMap;
        LooperMonitor looperMonitor = map.get(looper);
        if (looperMonitor != null) {
            return looperMonitor;
        }
        LooperMonitor looperMonitor2 = new LooperMonitor(looper);
        map.put(looper, looperMonitor2);
        return looperMonitor2;
    }

    public static void register(ILooperListener iLooperListener) {
        sMainMonitor.addListener(iLooperListener);
    }

    private synchronized void removeIdleHandler(Looper looper) {
        if (Build.VERSION.SDK_INT >= 23) {
            looper.getQueue().removeIdleHandler(this);
        } else {
            try {
                ((MessageQueue) ReflectUtils.get(looper.getClass(), "mQueue", looper)).removeIdleHandler(this);
            } catch (Exception e2) {
                TMachineLog.e(TAG, "[removeIdleHandler] %s", e2);
            }
        }
    }

    private synchronized void resetPrinter() {
        Printer printer;
        Exception e2;
        Printer printer2 = null;
        try {
        } catch (Exception e3) {
            printer = null;
            e2 = e3;
        }
        if (!isReflectLoggingError) {
            printer = (Printer) ReflectUtils.get(this.looper.getClass(), "mLogging", this.looper);
            try {
                LooperPrinter looperPrinter = this.printer;
                if (printer == looperPrinter && looperPrinter != null) {
                    return;
                }
                if (printer != null && looperPrinter != null && printer.getClass().getName().equals(this.printer.getClass().getName())) {
                    TMachineLog.w(TAG, "LooperPrinter might be loaded by different classloader, my = " + this.printer.getClass().getClassLoader() + ", other = " + printer.getClass().getClassLoader(), new Object[0]);
                    return;
                }
            } catch (Exception e4) {
                e2 = e4;
                isReflectLoggingError = true;
                TMachineLog.e(TAG, "[resetPrinter] %s", e2);
            }
            printer2 = printer;
        }
        if (this.printer != null) {
            TMachineLog.w(TAG, "maybe thread:%s printer[%s] was replace other[%s]!", this.looper.getThread().getName(), this.printer, printer2);
        }
        Looper looper = this.looper;
        LooperPrinter looperPrinter2 = new LooperPrinter(printer2);
        this.printer = looperPrinter2;
        looper.setMessageLogging(looperPrinter2);
        if (printer2 != null) {
            TMachineLog.i(TAG, "reset printer, originPrinter[%s] in %s", printer2, this.looper.getThread().getName());
        }
    }

    public static void unregister(ILooperListener iLooperListener) {
        sMainMonitor.removeListener(iLooperListener);
    }

    public void addListener(ILooperListener iLooperListener) {
        synchronized (this.listeners) {
            this.listeners.put(iLooperListener, new LooperDispatchListener(iLooperListener));
        }
    }

    @Deprecated
    public Map getListeners() {
        return this.listeners;
    }

    public Looper getLooper() {
        return this.looper;
    }

    public synchronized void onRelease() {
        if (this.printer != null) {
            synchronized (this.listeners) {
                this.listeners.clear();
            }
            TMachineLog.v(TAG, "[onRelease] %s, origin printer:%s", this.looper.getThread().getName(), this.printer.origin);
            this.looper.setMessageLogging(this.printer.origin);
            removeIdleHandler(this.looper);
            this.looper = null;
            this.printer = null;
        }
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        if (SystemClock.uptimeMillis() - this.lastCheckPrinterTime < CHECK_TIME) {
            return true;
        }
        resetPrinter();
        this.lastCheckPrinterTime = SystemClock.uptimeMillis();
        return true;
    }

    public void removeListener(ILooperListener iLooperListener) {
        synchronized (this.listeners) {
            this.listeners.remove(iLooperListener);
        }
    }
}
