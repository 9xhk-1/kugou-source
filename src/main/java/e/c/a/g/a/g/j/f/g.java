package e.c.a.g.a.g.j.f;

import android.view.MotionEvent;
import android.view.View;
import e.c.a.g.a.s.r1;
import f.s;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public f.z.c.a<s> a;
    public final int b;

    public static final class a implements View.OnGenericMotionListener {
        public a() {
        }

        @Override // android.view.View.OnGenericMotionListener
        public final boolean onGenericMotion(View view, MotionEvent motionEvent) {
            f.z.c.a aVar;
            if (motionEvent.getAction() == 8 && Math.abs(r1.a(motionEvent)) > g.this.b && (aVar = g.this.a) != null) {
                aVar.invoke();
            }
            return true;
        }
    }

    public g(View view) {
        j.e(view, "holder");
        this.b = 20;
        view.setOnGenericMotionListener(new a());
    }

    public final void c(f.z.c.a<s> aVar) {
        this.a = aVar;
    }
}
