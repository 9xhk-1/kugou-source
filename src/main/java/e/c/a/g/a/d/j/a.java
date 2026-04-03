package e.c.a.g.a.d.j;

import android.app.Activity;
import com.kugou.android.watch.lite.component.MainActivity;
import e.c.a.g.a.s.g0;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f441f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f442d;
    public boolean c = false;
    public Set<C0056a> a = new CopyOnWriteArraySet();
    public Set<Integer> b = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<WeakReference<Activity>> f443e = new LinkedList();

    /* JADX INFO: renamed from: e.c.a.g.a.d.j.a$a, reason: collision with other inner class name */
    public static class C0056a extends SoftReference<Activity> {
        public final int a;

        public C0056a(Activity activity) {
            super(activity);
            this.a = activity.hashCode();
        }

        public boolean equals(Object obj) {
            return this.a == obj.hashCode();
        }

        public int hashCode() {
            return this.a;
        }
    }

    public interface b {
        void onAllActivityFinished();
    }

    public static a e() {
        if (f441f == null) {
            synchronized (a.class) {
                f441f = new a();
            }
        }
        return f441f;
    }

    public void a(Activity activity) {
        if (g0.a) {
            g0.e("ActivityHolder", "add0 an Activity: " + activity);
        }
        Set<C0056a> set = this.a;
        if (set != null) {
            set.add(new C0056a(activity));
        }
        List<WeakReference<Activity>> list = this.f443e;
        if (list != null) {
            list.add(new WeakReference<>(activity));
        }
    }

    public void b() {
        Activity activity;
        Set<C0056a> set = this.a;
        if (set == null || set.size() <= 0) {
            return;
        }
        this.c = true;
        for (C0056a c0056a : this.a) {
            if (c0056a != null && (activity = c0056a.get()) != null && !activity.isFinishing()) {
                this.b.add(Integer.valueOf(activity.hashCode()));
                activity.finish();
            }
        }
    }

    public Activity c() {
        Set<C0056a> set = this.a;
        if (set == null || set.size() <= 0) {
            return null;
        }
        C0056a c0056a = (C0056a) new ArrayList(this.a).get(r0.size() - 1);
        if (c0056a == null || c0056a.get() == null) {
            return null;
        }
        return c0056a.get();
    }

    public MainActivity d() {
        Set<C0056a> set = this.a;
        if (set == null || set.size() <= 0) {
            return null;
        }
        C0056a c0056a = (C0056a) new ArrayList(this.a).get(r0.size() - 1);
        if (c0056a == null || c0056a.get() == null || !(c0056a.get() instanceof MainActivity)) {
            return null;
        }
        return (MainActivity) c0056a.get();
    }

    public final boolean f(Activity activity) {
        return this.b.contains(Integer.valueOf(activity.hashCode()));
    }

    public final void g() {
        if (g0.a) {
            g0.e("ActivityHolder", "all activity finished");
        }
        b bVar = this.f442d;
        if (bVar != null) {
            bVar.onAllActivityFinished();
        }
    }

    public final void h(Activity activity) {
        if (activity != null && f(activity)) {
            this.b.remove(Integer.valueOf(activity.hashCode()));
            if (this.b.size() <= 0) {
                this.c = false;
                this.a.clear();
                g();
            }
        }
    }

    public void i(Activity activity) {
        if (activity == null) {
            return;
        }
        Set<C0056a> set = this.a;
        if (set != null) {
            boolean zRemove = set.remove(new C0056a(activity));
            if (g0.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("remove an Activity: ");
                sb.append(activity);
                sb.append(zRemove ? " success" : " fail");
                g0.e("ActivityHolder", sb.toString());
            }
        }
        if (this.c) {
            h(activity);
        }
    }
}
