package e.c.a.g.a.d.o.c;

import android.os.Binder;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    Binder createService(String str);

    <T extends Binder & c> T createTwin(String str);
}
