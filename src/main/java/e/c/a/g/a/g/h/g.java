package e.c.a.g.a.g.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import e.c.a.g.a.s.s0;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements View.OnClickListener {
    public final TextView a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f798d;

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(Integer num) {
            return Integer.valueOf(f.b0.f.b(e.c.a.g.a.g.m.b.a.d(), 0));
        }
    }

    public static final class b<T> implements Action1 {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Integer num) {
            g gVar = g.this;
            f.z.d.j.d(num, "it");
            gVar.b = num.intValue();
            g.this.h(num.intValue());
        }
    }

    public static final class c<T> implements Action1 {
        public c() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            g.this.a.setVisibility(8);
        }
    }

    public g(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        view.findViewById(R.id.history_entry).setOnClickListener(this);
        View viewFindViewById = view.findViewById(R.id.tv_history_count);
        f.z.d.j.d(viewFindViewById, "entry.findViewById(R.id.tv_history_count)");
        this.a = (TextView) viewFindViewById;
        f();
        this.f798d = "";
    }

    public final void d() {
        int i2 = this.b - 1;
        this.b = i2;
        if (i2 < 0) {
            this.b = 0;
        }
        h(this.b);
    }

    public final void e() {
        g();
    }

    public final void f() {
        Observable.just(1).delay(2000L, TimeUnit.MICROSECONDS).subscribeOn(Schedulers.io()).map(a.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(), new c());
    }

    public final void g() {
        if (f.z.d.j.a(this.a.getText(), this.f798d)) {
            return;
        }
        String string = this.a.getText().toString();
        this.f798d = string;
        e.c.a.g.a.g.f.d.a(3, string);
    }

    public final void h(int i2) {
        if (i2 > 0) {
            this.a.setText(String.valueOf(i2));
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.f798d)) {
            g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s0.a.t();
    }
}
