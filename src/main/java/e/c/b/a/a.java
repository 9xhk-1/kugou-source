package e.c.b.a;

import com.kugou.android.watch.lite.base.other.ViewPagerFrameworkDelegate;
import com.kugou.datacollect.crash.bean.CrashBean;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements e.f.a.a.c.c.a {
    public static final C0199a a = new C0199a(null);

    /* JADX INFO: renamed from: e.c.b.a.a$a, reason: collision with other inner class name */
    public static final class C0199a {
        public C0199a() {
        }

        public /* synthetic */ C0199a(g gVar) {
            this();
        }

        public final String a() {
            boolean z = true;
            try {
                String str = l1.C(true).a;
                String str2 = ViewPagerFrameworkDelegate.t;
                if (str2 != null) {
                    if (str2.length() <= 0) {
                        z = false;
                    }
                    if (!z) {
                        str2 = null;
                    }
                    if (str2 != null) {
                        str = str + ':' + str2;
                    }
                }
                j.d(str, "{\n                var str = SystemUtils.getTopTaskInfo(true).shortClassName\n                ViewPagerFrameworkDelegate.sCurrentResumeFragment?.takeIf {\n                    it.isNotEmpty()\n                }?.let {\n                    str += \":$it\"\n                }\n                str\n            }");
                return str;
            } catch (Throwable th) {
                g0.h("FireEyeCrashListener", th);
                return "";
            }
        }
    }

    @Override // e.f.a.a.c.c.a
    public byte[] getCrashExtraData(boolean z, String str, String str2, String str3, int i2, long j) {
        String string;
        j.e(str, "crashType");
        j.e(str2, "crashAddress");
        j.e(str3, "crashStack");
        if (z) {
            g0.b("FireEyeCrash", j.l("crashStack:\n:", str3));
        }
        StringBuilder sb = new CrashBean(1007).exceptionInfo;
        byte[] bytes = null;
        if (sb != null && (string = sb.toString()) != null) {
            bytes = string.getBytes(f.e0.c.a);
            j.d(bytes, "(this as java.lang.String).getBytes(charset)");
        }
        return bytes == null ? new byte[0] : bytes;
    }

    @Override // e.f.a.a.c.c.a
    public String getCrashExtraMessage(boolean z, String str, String str2, String str3, int i2, long j) {
        j.e(str, "crashType");
        j.e(str2, "crashAddress");
        j.e(str3, "crashStack");
        return "";
    }

    @Override // e.f.a.a.c.c.a
    public boolean onCrashHandleEnd(boolean z) {
        if (!g0.a) {
            return true;
        }
        g0.b("FireEyeCrash", j.l("onCrashHandleEnd:\nisNativeCrashed:", Boolean.valueOf(z)));
        return true;
    }

    @Override // e.f.a.a.c.c.a
    public void onCrashHandleStart(boolean z) {
        if (g0.a) {
            g0.b("FireEyeCrash", j.l("onCrashHandleStart:\nisNativeCrashed:", Boolean.valueOf(z)));
        }
    }

    @Override // e.f.a.a.c.c.a
    public boolean onCrashSaving(boolean z, String str, String str2, String str3, int i2, long j, String str4, String str5, String str6, String str7) {
        j.e(str, "crashType");
        j.e(str2, "crashAddress");
        j.e(str3, "crashStack");
        j.e(str4, "userID");
        j.e(str5, "deviceID");
        j.e(str6, "crashUUID");
        j.e(str7, "processName");
        if (!g0.a) {
            return true;
        }
        g0.b("FireEyeCrash", f.e0.g.e("\n                 onCrashSaving:\n                 isNativeCrashed:" + z + ", \n                 crashType:" + str + ", \n                 crashAddress:" + str2 + ", \n                 crashStack:" + str3 + ", \n                 native_sicode:" + i2 + ", \n                 crashTime:" + j + ", \n                 userID:" + str4 + ", \n                 deviceID:" + str5 + ", \n                 crashUUID:" + str6 + ", \n                 processName:" + str7 + "\n                 "));
        return true;
    }
}
