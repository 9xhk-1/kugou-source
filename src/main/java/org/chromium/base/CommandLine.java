package org.chromium.base;

import android.support.annotation.Nullable;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CommandLine {
    public static final AtomicReference<CommandLine> a = new AtomicReference<>();

    public static class b extends CommandLine {
        public HashMap<String, String> b;
        public ArrayList<String> c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1693d;

        public b(@Nullable String[] strArr) {
            super();
            this.b = new HashMap<>();
            ArrayList<String> arrayList = new ArrayList<>();
            this.c = arrayList;
            this.f1693d = 1;
            if (strArr == null || strArr.length == 0 || strArr[0] == null) {
                arrayList.add("");
            } else {
                arrayList.add(strArr[0]);
                g(strArr, 1);
            }
        }

        @Override // org.chromium.base.CommandLine
        public boolean c(String str) {
            return this.b.containsKey(str);
        }

        public void f(String str, String str2) {
            this.b.put(str, str2 == null ? "" : str2);
            String str3 = BaseConnection.HTTP_REQ_ENTITY_PREFIX + str;
            if (str2 != null && !str2.isEmpty()) {
                str3 = str3 + BaseConnection.HTTP_REQ_ENTITY_MERGE + str2;
            }
            ArrayList<String> arrayList = this.c;
            int i2 = this.f1693d;
            this.f1693d = i2 + 1;
            arrayList.add(i2, str3);
        }

        public final void g(String[] strArr, int i2) {
            boolean z = true;
            for (String str : strArr) {
                if (i2 > 0) {
                    i2--;
                } else {
                    if (str.equals(BaseConnection.HTTP_REQ_ENTITY_PREFIX)) {
                        z = false;
                    }
                    if (z && str.startsWith(BaseConnection.HTTP_REQ_ENTITY_PREFIX)) {
                        String[] strArrSplit = str.split(BaseConnection.HTTP_REQ_ENTITY_MERGE, 2);
                        f(strArrSplit[0].substring(2), strArrSplit.length > 1 ? strArrSplit[1] : null);
                    } else {
                        this.c.add(str);
                    }
                }
            }
        }
    }

    public static CommandLine b() {
        return a.get();
    }

    public static void d(@Nullable String[] strArr) {
        e(new b(strArr));
    }

    public static void e(CommandLine commandLine) {
        CommandLine andSet = a.getAndSet(commandLine);
        if (andSet != null) {
            andSet.a();
        }
    }

    private static native void nativeAppendSwitch(String str);

    private static native void nativeAppendSwitchWithValue(String str, String str2);

    private static native void nativeAppendSwitchesAndArguments(String[] strArr);

    private static native String nativeGetSwitchValue(String str);

    private static native boolean nativeHasSwitch(String str);

    private static native void nativeInit(String[] strArr);

    public void a() {
    }

    public abstract boolean c(String str);

    public CommandLine() {
    }
}
