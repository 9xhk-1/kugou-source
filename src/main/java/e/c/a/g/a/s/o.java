package e.c.a.g.a.s;

import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class o {
    public static void a(Object obj) {
        if (obj == null || !EventBus.getDefault().isRegistered(obj)) {
            return;
        }
        EventBus.getDefault().unregister(obj);
    }
}
