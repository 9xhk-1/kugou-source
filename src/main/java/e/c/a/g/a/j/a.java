package e.c.a.g.a.j;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.kugou.common.network.netgate.AckManager;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.y1.c;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static volatile a c;
    public Map<String, e.c.a.g.a.s.y1.a<String>> a;
    public String b = null;

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public void a(String str, e.c.a.g.a.s.y1.a<String> aVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        if (this.a.containsKey(str)) {
            return;
        }
        this.a.put(str, aVar);
    }

    public boolean b() {
        boolean z = g0.a;
        return l1.V() && "TGR-L10".equalsIgnoreCase(l1.q());
    }

    public void d(@Nullable Intent intent) {
        Map<String, e.c.a.g.a.s.y1.a<String>> map = this.a;
        if (map == null) {
            return;
        }
        c.a(map.get(this.b), h1.q(intent != null ? intent.getStringExtra("voice_value") : null, ""));
    }

    public void e(String str) {
        Map<String, e.c.a.g.a.s.y1.a<String>> map = this.a;
        if (map != null) {
            map.remove(str);
        }
    }

    public void f(String str, Activity activity) {
        if (activity == null) {
            return;
        }
        ComponentName componentName = new ComponentName("com.huawei.kidwatch.voiceinput", "com.huawei.kidwatch.voiceinput.VoiceInputActivity");
        boolean z = g0.a;
        try {
            activity.startActivityForResult(new Intent().setComponent(componentName), AckManager.SERVICE_ID_ACK_DNS);
            this.b = str;
        } catch (ActivityNotFoundException e2) {
            g0.k(e2);
            p1.h(activity, "系统语音输入法异常");
        } catch (SecurityException e3) {
            g0.k(e3);
            p1.h(activity, "无法打开系统语音输入法");
        }
    }
}
