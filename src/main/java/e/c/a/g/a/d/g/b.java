package e.c.a.g.a.d.g;

import android.graphics.Canvas;
import android.view.ViewGroup;
import com.kugou.android.watch.lite.R;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public int a;
    public boolean b;

    public class a implements Runnable {
        public final /* synthetic */ ViewGroup a;

        public a(b bVar, ViewGroup viewGroup) {
            this.a = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.getTag(R.id.activity_over_flag) instanceof Boolean) {
                return;
            }
            e.c.a.g.a.d.g.a aVar = new e.c.a.g.a.d.g.a();
            aVar.setBounds(0, 0, this.a.getWidth(), this.a.getHeight());
            this.a.getOverlay().add(aVar);
            this.a.setTag(R.id.activity_over_flag, Boolean.TRUE);
            this.a.invalidate();
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.g.b$b, reason: collision with other inner class name */
    public static class C0051b {
        public static final b a = new b(null);
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b b() {
        return C0051b.a;
    }

    public void a(Canvas canvas) {
        int i2;
        if (!this.b || (i2 = this.a) == 0) {
            return;
        }
        canvas.drawColor(i2);
    }

    public void c(ViewGroup viewGroup) {
        if (!this.b || viewGroup == null) {
            return;
        }
        viewGroup.post(new a(this, viewGroup));
    }

    public b() {
        this.a = 0;
        this.b = false;
    }
}
