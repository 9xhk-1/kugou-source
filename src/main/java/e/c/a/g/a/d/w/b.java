package e.c.a.g.a.d.w;

import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile b c;
    public HashSet<String> a = new a(this);
    public HashSet<String> b = new C0080b(this);

    public class a extends HashSet<String> {
        public a(b bVar) {
            add("android.content.Context");
            add("android.content.ContextWrapper");
            add("android.view.ContextThemeWrapper");
            add("android.app.Activity");
            add("android.support.v4.app.FragmentActivity");
            add("androidx.appcompat.app.AppCompatActivity");
            add("com.kugou.android.watch.lite.component.MainActivity");
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.w.b$b, reason: collision with other inner class name */
    public class C0080b extends HashSet<String> {
        public C0080b(b bVar) {
            add("android.support.v4.app.Fragment");
            add("android.support.v4.app.FragmentCompat");
        }
    }

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    public boolean b(String str) {
        return this.a.contains(str);
    }

    public boolean c(String str) {
        return this.b.contains(str);
    }
}
