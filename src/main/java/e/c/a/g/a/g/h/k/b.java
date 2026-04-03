package e.c.a.g.a.g.h.k;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.r;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import java.util.ArrayList;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class b extends e.c.a.g.a.g.h.a implements View.OnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f805d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f806f;

    public class a implements Action1<e.c.a.g.a.l.b> {
        public a() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c.a.g.a.l.b bVar) {
            if (bVar == null || bVar.e() == null || bVar.e().size() <= 0) {
                return;
            }
            KGSong kGSongC = b.this.c(bVar);
            String strR1 = kGSongC.r1();
            if (TextUtils.isEmpty(strR1)) {
                strR1 = kGSongC.M1();
            }
            String strD = a0.d(strR1);
            Glide.with(b.this.a).load(strD).into(b.this.f805d);
            e.c.a.g.a.f.m.c.a.i("music_rank_last_cover_url", strD);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.h.k.b$b, reason: collision with other inner class name */
    public class C0126b implements Action1<Throwable> {
        public C0126b(b bVar) {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
        }
    }

    public class c implements Func1<Integer, e.c.a.g.a.l.b> {
        public c() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.c.a.g.a.l.b call(Integer num) {
            return e.c.a.g.a.k.a.c("首页").b("小天才", 1, e.c.a.g.a.k.c.c.a(1), b.this.a.m());
        }
    }

    public class d implements r<KGSong> {
        public d(b bVar) {
        }

        @Override // e.c.a.g.a.s.r
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean isFilter(KGSong kGSong) {
            return e.c.a.g.a.g.o.b.g(kGSong);
        }
    }

    public class e implements Action1<e.c.a.g.a.l.b> {
        public e() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c.a.g.a.l.b bVar) {
            if (bVar == null || bVar.e() == null || bVar.e().size() <= 0) {
                return;
            }
            String strD = a0.d(b.this.c(bVar).r1());
            Glide.with(b.this.a).load(strD).into(b.this.f805d);
            e.c.a.g.a.f.m.c.a.i("music_rank_last_cover_url", strD);
        }
    }

    public class f implements Action1<Throwable> {
        public f(b bVar) {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
        }
    }

    public class g implements Func1<Integer, e.c.a.g.a.l.b> {
        public g() {
        }

        @Override // rx.functions.Func1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e.c.a.g.a.l.b call(Integer num) {
            return e.c.a.g.a.k.b.c("首页").e("小天才", 1, e.c.a.g.a.k.c.c.a(1), b.this.a.m());
        }
    }

    public class h implements Runnable {
        public h(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            s0.a.p();
        }
    }

    public b(DelegateFragment delegateFragment, View view) {
        super(delegateFragment, view);
        this.f806f = e.c.a.g.a.g.e.d.a.g();
        this.f805d = (ImageView) view.findViewById(R.id.song_rank_img);
        view.setOnClickListener(this);
        if (this.f806f) {
            e();
        } else {
            d();
        }
    }

    public final KGSong c(e.c.a.g.a.l.b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(bVar.e());
        l0.a(arrayList, new d(this));
        return arrayList.size() != 0 ? (KGSong) arrayList.get(0) : bVar.e().get(0);
    }

    public void d() {
        if (u0.n(KGApplication.getApplication(), false)) {
            Observable.just(1).subscribeOn(Schedulers.io()).map(new g()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(), new f(this));
        } else {
            Glide.with(this.a).load(e.c.a.g.a.f.m.c.a.d("music_rank_last_cover_url", "")).error(R.drawable.album_img_default).into(this.f805d);
        }
    }

    public void e() {
        if (u0.n(KGApplication.getApplication(), false)) {
            Observable.just(1).subscribeOn(Schedulers.io()).map(new c()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(), new C0126b(this));
        } else {
            Glide.with(this.a).load(e.c.a.g.a.f.m.c.a.d("music_rank_last_cover_url", "")).error(R.drawable.album_img_default).into(this.f805d);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u0.d(this.a.requireActivity(), new h(this));
    }
}
