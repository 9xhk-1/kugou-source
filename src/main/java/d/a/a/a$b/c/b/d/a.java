package d.a.a.a$b.c.b.d;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import f.d;
import f.z.d.j;
import f.z.d.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a implements d.a.a.a$b.c.b.b<d.a.a.a$b.c.b.c.b> {
    public final List<e.g.a.b.a.b.d.a> a = new ArrayList();

    public a() {
        new d.a.a.a$b.c.b.a().a(this);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // d.a.a.a$b.c.b.b
    public void a(d.a.a.a$b.c.b.c.a aVar) {
        d.a.a.a$b.c.b.c.b bVar = (d.a.a.a$b.c.b.c.b) aVar;
        j.e(bVar, NotificationCompat.CATEGORY_EVENT);
        ConcurrentHashMap<f.c0.b<?>, d<?>> concurrentHashMapA = e.g.a.b.b.a.g.a.a.a();
        f.c0.b bVarA = s.a(Context.class);
        Objects.requireNonNull(concurrentHashMapA, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        d<?> dVar = null;
        d<?> orDefault = concurrentHashMapA.getOrDefault(bVarA, null);
        if (orDefault != null) {
            Object value = orDefault.getValue();
            Context context = value instanceof Context ? (Context) value : null;
            String str = bVar.a;
            e.g.b.b.a.a("State.CardStateProcessor", "[DEBUG_" + str + "] handlerStateEvent event: " + bVar + ", context: " + context);
            if (context != null) {
                String str2 = bVar.b;
                switch (str2.hashCode()) {
                    case -1627988953:
                        if (str2.equals("render_fail")) {
                            Iterator<T> it = this.a.iterator();
                            while (it.hasNext()) {
                                ((e.g.a.b.a.b.d.a) it.next()).onRenderFail(context, str);
                            }
                        }
                        break;
                    case -1352294148:
                        if (str2.equals("create")) {
                            Iterator<T> it2 = this.a.iterator();
                            while (it2.hasNext()) {
                                ((e.g.a.b.a.b.d.a) it2.next()).onCardCreate(context, str);
                            }
                        }
                        break;
                    case -1219769254:
                        if (str2.equals("subscribed")) {
                            Iterator<T> it3 = this.a.iterator();
                            while (it3.hasNext()) {
                                ((e.g.a.b.a.b.d.a) it3.next()).subscribed(context, str);
                            }
                        }
                        break;
                    case -934426579:
                        if (str2.equals("resume")) {
                            Iterator<T> it4 = this.a.iterator();
                            while (it4.hasNext()) {
                                ((e.g.a.b.a.b.d.a) it4.next()).onResume(context, str);
                            }
                        }
                        break;
                    case 106440182:
                        if (str2.equals("pause")) {
                            Iterator<T> it5 = this.a.iterator();
                            while (it5.hasNext()) {
                                ((e.g.a.b.a.b.d.a) it5.next()).onPause(context, str);
                            }
                        }
                        break;
                    case 901853107:
                        if (str2.equals("unsubscribed")) {
                            Iterator<T> it6 = this.a.iterator();
                            while (it6.hasNext()) {
                                ((e.g.a.b.a.b.d.a) it6.next()).unSubscribed(context, str);
                            }
                        }
                        break;
                    case 1557372922:
                        if (str2.equals("destroy")) {
                            Iterator<T> it7 = this.a.iterator();
                            while (it7.hasNext()) {
                                ((e.g.a.b.a.b.d.a) it7.next()).onDestroy(context, str);
                            }
                        }
                        break;
                }
            }
            dVar = orDefault;
        }
        if (dVar == null) {
            e.g.a.b.b.a.g.a.a.b(s.a(Context.class));
        }
    }
}
