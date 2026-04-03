package e.c.a.g.a.d.a0;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.swipeback.SwipeBackLayout;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public Activity a;
    public SwipeBackLayout b;

    public a(Activity activity) {
        this.a = activity;
    }

    public View a(int i2) {
        SwipeBackLayout swipeBackLayout = this.b;
        if (swipeBackLayout != null) {
            return swipeBackLayout.findViewById(i2);
        }
        return null;
    }

    public SwipeBackLayout b() {
        return this.b;
    }

    public void c() {
        this.a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.a.getWindow().getDecorView().setBackgroundDrawable(null);
        this.b = (SwipeBackLayout) LayoutInflater.from(this.a).inflate(R.layout.swipeback_layout, (ViewGroup) null);
    }

    public void d() {
        this.b.c(this.a);
        if (e.c.a.g.a.f.a.q()) {
            this.b.setShowCircle(true);
            View contentView = this.b.getContentView();
            if (contentView != null) {
                contentView.setBackgroundColor(1912602624);
            }
        }
    }
}
