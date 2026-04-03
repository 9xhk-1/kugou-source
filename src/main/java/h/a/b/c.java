package h.a.b;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import h.a.b.m;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    public static class a {
        public final i a;

        /* JADX INFO: renamed from: h.a.b.c$a$a, reason: collision with other inner class name */
        public static class C0277a implements Comparator<e> {
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(e eVar, e eVar2) {
                if ("Fallback-Cronet-Provider".equals(eVar.e())) {
                    return 1;
                }
                if ("Fallback-Cronet-Provider".equals(eVar2.e())) {
                    return -1;
                }
                return -a.c(eVar.f(), eVar2.f());
            }
        }

        public a(Context context) {
            this(d(context));
        }

        @VisibleForTesting
        public static int c(String str, String str2) {
            if (str == null || str2 == null) {
                throw new IllegalArgumentException("The input values cannot be null");
            }
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            for (int i2 = 0; i2 < strArrSplit.length && i2 < strArrSplit2.length; i2++) {
                try {
                    int i3 = Integer.parseInt(strArrSplit[i2]);
                    int i4 = Integer.parseInt(strArrSplit2[i2]);
                    if (i3 != i4) {
                        return Integer.signum(i3 - i4);
                    }
                } catch (NumberFormatException e2) {
                    throw new IllegalArgumentException("Unable to convert version segments into integers: " + strArrSplit[i2] + " & " + strArrSplit2[i2], e2);
                }
            }
            return Integer.signum(strArrSplit.length - strArrSplit2.length);
        }

        public static i d(Context context) {
            List<e> listD = e.d(context);
            i(context, listD);
            return listD.get(0).c().a;
        }

        @VisibleForTesting
        public static List<e> i(Context context, List<e> list) {
            if (list.size() == 0) {
                throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
            }
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().g()) {
                    it.remove();
                }
            }
            if (list.size() == 0) {
                throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
            }
            Collections.sort(list, new C0277a());
            return list;
        }

        public a a(String str, int i2, int i3) {
            this.a.a(str, i2, i3);
            return this;
        }

        public c b() {
            return this.a.b();
        }

        public a e(boolean z) {
            this.a.c(z);
            return this;
        }

        public a f(int i2, long j) {
            this.a.d(i2, j);
            return this;
        }

        public a g(boolean z) {
            this.a.e(z);
            return this;
        }

        @Deprecated
        public a h(boolean z) {
            return this;
        }

        public a j(String str) {
            this.a.f(str);
            return this;
        }

        public a(i iVar) {
        }
    }

    public abstract m.a a(String str, m.b bVar, Executor executor);

    public abstract URLConnection b(URL url) throws IOException;
}
