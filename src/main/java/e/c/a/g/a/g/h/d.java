package e.c.a.g.a.g.h;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.r;
import e.c.a.g.a.s.s0;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements View.OnClickListener {
    public final TextView a;
    public int b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f791d;

    public static final class a<T, R> implements Func1 {
        public static final a<T, R> a = new a<>();

        /* JADX INFO: renamed from: e.c.a.g.a.g.h.d$a$a, reason: collision with other inner class name */
        public static final class C0123a<T> implements r {
            public static final C0123a<T> a = new C0123a<>();

            @Override // e.c.a.g.a.s.r
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final boolean isFilter(e.c.a.g.a.d.f.c.a.a aVar) {
                return aVar != null && e.c.a.g.a.g.o.b.i(aVar.o());
            }
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer call(Integer num) {
            int size;
            e.c.a.g.a.g.d.d dVar = e.c.a.g.a.g.d.d.a;
            if (dVar.h()) {
                List<e.c.a.g.a.d.f.c.a.a> listC = dVar.c();
                Log.d("mhs_watch_result", f.z.d.j.l("1.downloadSongs = ", listC == null ? null : Integer.valueOf(listC.size())));
                if (listC != null) {
                    l0.a(listC, C0123a.a);
                }
                Log.d("mhs_watch_result", f.z.d.j.l("2.downloadSongs = ", listC != null ? Integer.valueOf(listC.size()) : null));
                size = listC.size();
            } else {
                size = 0;
            }
            return Integer.valueOf(size);
        }
    }

    public static final class b<T> implements Action1 {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Integer num) {
            d dVar = d.this;
            f.z.d.j.d(num, "it");
            dVar.b = num.intValue();
            d.this.i(num.intValue());
            Log.d("mhs_watch_result", f.z.d.j.l("4, currentCount = ", Integer.valueOf(d.this.b)));
        }
    }

    public static final class c<T> implements Action1 {
        public c() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void call(Throwable th) {
            Log.d("mhs_watch_result", f.z.d.j.l("5, it = ", th));
            d.this.a.setVisibility(8);
        }
    }

    public d(DelegateFragment delegateFragment, View view) {
        f.z.d.j.e(delegateFragment, "host");
        f.z.d.j.e(view, "entry");
        view.findViewById(R.id.download_entry).setOnClickListener(this);
        View viewFindViewById = view.findViewById(R.id.tv_download_count);
        f.z.d.j.d(viewFindViewById, "entry.findViewById(R.id.tv_download_count)");
        this.a = (TextView) viewFindViewById;
        g();
        this.f791d = "";
    }

    public final void e() {
        int i2 = this.b - 1;
        this.b = i2;
        if (i2 < 0) {
            this.b = 0;
        }
        i(this.b);
    }

    public final void f() {
        h();
    }

    public final void g() {
        Observable.just(1).delay(2000L, TimeUnit.MICROSECONDS).subscribeOn(Schedulers.io()).map(a.a).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(), new c());
    }

    public final void h() {
        if (f.z.d.j.a(this.a.getText(), this.f791d)) {
            return;
        }
        String string = this.a.getText().toString();
        this.f791d = string;
        e.c.a.g.a.g.f.d.a(2, string);
    }

    public final void i(int i2) {
        if (i2 > 0) {
            this.a.setText(String.valueOf(i2));
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.f791d)) {
            h();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s0.a.f();
    }
}
