package e.c.a.g.a.g.h.k;

import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.newsong.NewSongList;
import e.c.a.g.a.l.e;
import e.c.a.g.a.s.s0;
import e.c.a.g.a.s.u0;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes2.dex */
public class c extends e.c.a.g.a.g.h.a implements View.OnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f807d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e.c.a.g.a.l.d f808f;

    public class a implements Action1<e.c.a.g.a.f.k.c<NewSongList>> {
        public a() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.c.a.g.a.f.k.c<NewSongList> cVar) {
            if (!cVar.f() || cVar.a() == null || cVar.a().list == null) {
                return;
            }
            e.i(c.this.f808f.g());
            Glide.with(c.this.a).load(cVar.a().list.get(0).r1()).placeholder(R.drawable.album_img_default).into(c.this.f807d);
        }
    }

    public class b implements Action1<Throwable> {
        public b() {
        }

        @Override // rx.functions.Action1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(Throwable th) {
            c.this.f807d.setImageResource(R.drawable.album_img_default);
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.g.h.k.c$c, reason: collision with other inner class name */
    public class RunnableC0127c implements Runnable {
        public RunnableC0127c(c cVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            s0.a.q();
        }
    }

    public c(DelegateFragment delegateFragment, View view) {
        super(delegateFragment, view);
        this.f808f = new e.c.a.g.a.l.d();
        this.f807d = (ImageView) view.findViewById(R.id.new_song_img);
        view.setOnClickListener(this);
        c();
    }

    public void c() {
        this.f808f.j(this.a.m()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(), new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u0.d(this.a.requireActivity(), new RunnableC0127c(this));
    }
}
