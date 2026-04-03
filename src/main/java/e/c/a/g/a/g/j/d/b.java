package e.c.a.g.a.g.j.d;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.recyclerview.widget.RecyclerView;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.r1;
import f.b0.f;
import f.s;
import f.z.c.p;
import f.z.d.j;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public final View a;
    public float b;
    public float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p<? super Float, ? super Float, s> f932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f.z.c.a<s> f933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Subscription f934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f935h;

    public static final class a implements View.OnGenericMotionListener {
        public a() {
        }

        @Override // android.view.View.OnGenericMotionListener
        public final boolean onGenericMotion(View view, MotionEvent motionEvent) {
            if (view.getVisibility() != 0 || motionEvent.getAction() != 8) {
                return false;
            }
            float fA = r1.a(motionEvent);
            b bVar = b.this;
            bVar.b = fA > 0.0f ? f.a(bVar.b - b.this.c, 0.0f) : f.d(bVar.b + b.this.c, 1.0f);
            if (!(fA == 0.0f)) {
                b.this.p();
            }
            p pVar = b.this.f932e;
            if (pVar != null) {
                pVar.invoke(Float.valueOf(b.this.b), Float.valueOf(fA));
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.j.d.b$b, reason: collision with other inner class name */
    public static final class C0140b<T> implements Action1 {
        public C0140b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Long l) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (b.this.f935h <= 0 || jCurrentTimeMillis - b.this.f935h <= b.this.f931d) {
                return;
            }
            b.this.i();
            f.z.c.a aVar = b.this.f933f;
            if (aVar == null) {
                return;
            }
            aVar.invoke();
        }
    }

    public b(View view) {
        j.e(view, "view");
        this.a = view;
        this.c = 0.005f;
        this.f931d = RecyclerView.MAX_SCROLL_DURATION;
        this.f935h = -1L;
        view.setOnGenericMotionListener(new a());
    }

    public final boolean h() {
        return this.f935h > 0;
    }

    public final void i() {
        i1.a(this.f934g);
        this.f934g = null;
        this.f935h = -1L;
    }

    public final void j(float f2) {
        this.b = f2;
    }

    public final void k(f.z.c.a<s> aVar) {
        this.f933f = aVar;
    }

    public final void l(int i2) {
        this.f931d = i2;
    }

    public final void m(p<? super Float, ? super Float, s> pVar) {
        this.f932e = pVar;
    }

    public final void n(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.c = f2;
    }

    public final void o() {
        if (this.f934g != null || this.f933f == null) {
            return;
        }
        this.f934g = Observable.interval(500L, TimeUnit.MILLISECONDS).subscribe(new C0140b(), i1.b);
    }

    public final void p() {
        this.f935h = System.currentTimeMillis();
        o();
    }
}
