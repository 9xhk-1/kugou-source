package e.c.a.g.a.d.x.r;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static b b = new b();
    public ArrayList<a> a = new ArrayList<>();

    public static synchronized b f() {
        return b;
    }

    public void a(Intent intent) {
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a(intent);
        }
    }

    public void b(Intent intent) {
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().b(intent);
        }
    }

    public void c(Intent intent) {
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().c(intent);
        }
    }

    public void d(Intent intent) {
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().d(intent);
        }
    }

    public void e(Intent intent) {
        Iterator<a> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().e(intent);
        }
    }

    public void g(a aVar) {
        if (this.a.contains(aVar)) {
            return;
        }
        this.a.add(aVar);
    }
}
