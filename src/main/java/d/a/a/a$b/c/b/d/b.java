package d.a.a.a$b.c.b.d;

import androidx.core.app.NotificationCompat;
import d.a.a.a$b.c.b.c.c;
import f.z.d.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d.a.a.a$b.c.b.b<c> {
    public final List<Object> a = new ArrayList();

    public b() {
        new d.a.a.a$b.c.b.a().a(this);
    }

    @Override // d.a.a.a$b.c.b.b
    public void a(d.a.a.a$b.c.b.c.a aVar) {
        c cVar = (c) aVar;
        j.e(cVar, NotificationCompat.CATEGORY_EVENT);
        e.g.b.b.a.a("Update.CardUpdateProcessor", "[DEBUG_" + cVar.a + "] handleEvent event begin...");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            ((d.a.a.a$b.d.b) it.next()).a(cVar.b);
        }
    }
}
