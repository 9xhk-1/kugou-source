package e.c.a.g.a.g.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kugou.android.watch.lite.component.MainFragment;
import com.kugou.common.config.ConfigKey;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public final ViewGroup a;
    public final View b;

    public b(MainFragment mainFragment, ViewGroup viewGroup) {
        f.z.d.j.e(mainFragment, "frag");
        f.z.d.j.e(viewGroup, "container");
        this.a = viewGroup;
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(c(), viewGroup, false);
        f.z.d.j.d(viewInflate, "from(container.context)\n        .inflate(getLayoutRes(), container, false)");
        this.b = viewInflate;
        viewGroup.addView(viewInflate);
    }

    public void a() {
    }

    public final View b() {
        return this.b;
    }

    public abstract int c();

    public final int d(ConfigKey configKey, boolean z) {
        return e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(configKey, z) ? 0 : 8;
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }
}
