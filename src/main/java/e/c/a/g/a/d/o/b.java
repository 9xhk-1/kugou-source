package e.c.a.g.a.d.o;

import android.os.Binder;
import com.kugou.android.watch.lite.base.application.KGApplication;
import e.c.a.g.a.d.o.c.c;

/* JADX INFO: loaded from: classes.dex */
public class b implements e.c.a.g.a.d.o.c.a {
    public final Binder a(String str) {
        return null;
    }

    @Override // e.c.a.g.a.d.o.c.a
    public Binder createService(String str) {
        if (KGApplication.isForeProcess()) {
            return a(str);
        }
        return null;
    }

    @Override // e.c.a.g.a.d.o.c.a
    public <T extends Binder & c> T createTwin(String str) {
        str.hashCode();
        if (str.equals("@twin:PierceCaller")) {
            return new e.c.a.g.a.d.o.f.b();
        }
        if (str.equals("@twin:Broadcast")) {
            return new e.c.a.g.a.d.o.d.c.a();
        }
        return null;
    }
}
