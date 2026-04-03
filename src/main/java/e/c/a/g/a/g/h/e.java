package e.c.a.g.a.g.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import e.c.a.g.a.g.i.w;
import e.c.a.g.a.g.i.y;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.s0;
import java.util.ArrayList;
import java.util.Set;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements View.OnClickListener {
    public final View a;
    public final TextView b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f792d;

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(Integer num) {
            String strJ = e.c.a.g.a.r.b.j();
            if (TextUtils.isEmpty(strJ)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                Set<String> setE = e.c.a.g.a.g.o.b.e();
                f.z.d.j.d(setE, "getSongLimitGradeIdSet()");
                for (String str : setE) {
                    try {
                        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
                            arrayList.add(Long.valueOf(Long.parseLong(str)));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
            f.z.d.j.d(strJ, "favId");
            return Integer.valueOf(bVar.c(strJ, arrayList));
        }
    }

    public static final class b<T> implements Action1 {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Integer num) {
            e.this.g(num);
        }
    }

    public static final class c<T> implements Action1 {
        public c() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            e.this.b.setVisibility(8);
        }
    }

    public static final class d implements Runnable {
        public static final d a = new d();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                e.c.a.g.a.g.k.b bVar = e.c.a.g.a.g.k.b.a;
                String strJ = e.c.a.g.a.r.b.j();
                f.z.d.j.d(strJ, "getMyFavPlaylistId()");
                e.c.a.g.a.d.f.c.a.j jVarI = bVar.i(strJ);
                w wVarD = y.e().d();
                wVarD.q(w.l.d());
                y.e().a(1, jVarI == null ? 0 : jVarI.e(), wVarD);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.h.e$e, reason: collision with other inner class name */
    public static final class RunnableC0124e implements Runnable {
        public static final RunnableC0124e a = new RunnableC0124e();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                e.c.a.g.a.i.b.a.b();
            } catch (Exception e2) {
                e2.printStackTrace();
                g0.k(e2);
            }
        }
    }

    public e(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "root");
        View viewFindViewById = view.findViewById(R.id.fav_entry);
        f.z.d.j.d(viewFindViewById, "root.findViewById(R.id.fav_entry)");
        this.a = viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.tv_fav_count);
        f.z.d.j.d(viewFindViewById2, "root.findViewById(R.id.tv_fav_count)");
        this.b = (TextView) viewFindViewById2;
        this.f792d = -1;
        viewFindViewById.setOnClickListener(this);
        d();
        f();
        e();
    }

    public final void c() {
        if (!e.c.a.g.a.r.b.F()) {
            this.b.setVisibility(8);
        } else {
            this.b.setText("");
            Observable.just(1).subscribeOn(Schedulers.io()).map(a.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(), new c());
        }
    }

    public final void d() {
        if (e.c.a.g.a.r.b.F()) {
            j0.b().a(d.a);
        } else {
            this.b.setVisibility(8);
        }
    }

    public final void e() {
        if (e.c.a.g.a.r.b.F()) {
            j0.b().a(RunnableC0124e.a);
        }
    }

    public final void f() {
        boolean configAsBoolean = e.c.a.g.a.f.e.c.a.a().getConfigAsBoolean(e.c.a.g.a.f.e.b.K1, true);
        this.a.setVisibility(configAsBoolean ? 0 : 8);
        this.b.setVisibility(configAsBoolean ? 0 : 8);
    }

    public final void g(Integer num) {
        if (num == null) {
            this.b.setVisibility(8);
            if (this.f792d > 0) {
                e.c.a.g.a.g.f.d.d("-1003", null);
                return;
            }
            return;
        }
        if (num.intValue() != this.f792d) {
            e.c.a.g.a.g.f.d.a(1, num.toString());
        }
        if (num.intValue() > 0) {
            this.b.setText(num.toString());
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
        e.c.a.g.a.f.m.b.m().K(num.intValue());
        this.f792d = num.intValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s0.a.i();
    }
}
