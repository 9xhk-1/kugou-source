package e.c.a.g.a.g.d;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.room.RoomMasterTable;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import e.c.a.g.a.d.s.i;
import e.c.a.g.a.d.x.f;
import e.c.a.g.a.s.i1;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import e.c.a.g.a.s.u1;
import java.util.List;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public class c extends e.c.a.g.a.f.o.h.a<KGMusicWrapper> {
    public DelegateFragment c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f745f = e.c.a.g.a.g.o.b.l();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Subscription f746g;

    public interface a {
        void onLongClick(KGMusicWrapper kGMusicWrapper);
    }

    public class b extends e.c.a.g.a.f.l.b {
        public final TextView c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f747d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f748e;

        public class a implements View.OnClickListener {

            /* JADX INFO: renamed from: e.c.a.g.a.g.d.c$b$a$a, reason: collision with other inner class name */
            public class C0111a implements Action1<Pair<Integer, List<KGMusicWrapper>>> {
                public C0111a() {
                }

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void call(Pair<Integer, List<KGMusicWrapper>> pair) {
                    if (c.this.c.m0()) {
                        c.this.c.i0();
                        if (pair == null) {
                            return;
                        }
                        f.y(true, (List) pair.second, ((Integer) pair.first).intValue(), true, c.this.c.l());
                    }
                }
            }

            /* JADX INFO: renamed from: e.c.a.g.a.g.d.c$b$a$b, reason: collision with other inner class name */
            public class C0112b implements Action1<Throwable> {
                public C0112b() {
                }

                @Override // rx.functions.Action1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void call(Throwable th) {
                    if (c.this.c.m0()) {
                        c.this.c.i0();
                        p1.h(KGApplication.getContext(), "播放失败，请重试");
                    }
                }
            }

            /* JADX INFO: renamed from: e.c.a.g.a.g.d.c$b$a$c, reason: collision with other inner class name */
            public class C0113c implements Func1<String, Pair<Integer, List<KGMusicWrapper>>> {
                public final /* synthetic */ KGMusicWrapper a;

                public C0113c(KGMusicWrapper kGMusicWrapper) {
                    this.a = kGMusicWrapper;
                }

                @Override // rx.functions.Func1
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Pair<Integer, List<KGMusicWrapper>> call(String str) {
                    if (!c.this.f745f || !e.c.a.g.a.g.o.b.f(this.a.getKgmusic())) {
                        return new e.c.a.g.a.g.a(b.this.getAdapterPosition() - 1, c.this.i()).b();
                    }
                    p1.i(b.this.d(), e.c.a.g.a.g.o.b.d(), "isFilter,music = " + this.a);
                    return null;
                }
            }

            public a(c cVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!u1.i(view) && b.this.getAdapterPosition() >= 0) {
                    KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) view.getTag();
                    if (kGMusicWrapper == null) {
                        p1.h(b.this.d(), "歌曲数据异常");
                        return;
                    }
                    b.this.f(kGMusicWrapper);
                    if (u0.n(b.this.d(), false) || !e.c.a.g.a.f.j.c.d.c(kGMusicWrapper) || i.a(kGMusicWrapper) || e.c.a.g.a.r.b.O()) {
                        c.this.c.q0(true);
                        c.this.c.h0();
                        i1.a(c.this.f746g);
                        c.this.f746g = Observable.just("").map(new C0113c(kGMusicWrapper)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0111a(), new C0112b());
                        return;
                    }
                    e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("7").setFo("/下载页/离线").setSvar1(kGMusicWrapper.getMixId() + ":" + kGMusicWrapper.getHashValue()).setSvar2(kGMusicWrapper.getDisplayName()));
                    p1.h(b.this.d(), "暂无法播放VIP歌曲，请检查是否网络无连接");
                }
            }
        }

        /* JADX INFO: renamed from: e.c.a.g.a.g.d.c$b$b, reason: collision with other inner class name */
        public class ViewOnLongClickListenerC0114b implements View.OnLongClickListener {
            public ViewOnLongClickListenerC0114b(c cVar) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                KGMusicWrapper kGMusicWrapper = (KGMusicWrapper) view.getTag();
                if (c.this.f743d == null || kGMusicWrapper == null) {
                    return true;
                }
                c.this.f743d.onLongClick(kGMusicWrapper);
                return true;
            }
        }

        public b(@NonNull View view) {
            super(view);
            view.setOnClickListener(new a(c.this));
            view.setOnLongClickListener(new ViewOnLongClickListenerC0114b(c.this));
            this.f747d = (TextView) view.findViewById(R.id.song_name);
            this.c = (TextView) view.findViewById(R.id.author_name);
            this.f748e = (TextView) view.findViewById(R.id.tv_num);
        }

        public final void f(KGMusicWrapper kGMusicWrapper) {
            if (c.this.f744e.equals(RoomMasterTable.DEFAULT_ID)) {
                e.c.a.g.a.e.b.b(new YoungBITask(20483, "click").setType("1").setMixsongid(String.valueOf(kGMusicWrapper.getMixId())));
            } else {
                e.c.a.g.a.e.b.b(new YoungBITask(20484, "click").setType("1").setMixsongid(String.valueOf(kGMusicWrapper.getMixId())));
            }
        }
    }

    public c(DelegateFragment delegateFragment, String str, a aVar) {
        this.c = delegateFragment;
        this.f744e = str;
        this.f743d = aVar;
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public void b(KGRecyclerView.e eVar, int i2) {
        b bVar = (b) eVar;
        KGMusicWrapper item = getItem(i2);
        if (item == null) {
            bVar.f747d.setText("未知歌曲");
            bVar.c.setText("未知歌手");
        } else {
            String displayName = item.getDisplayName();
            String[] strArrSplit = displayName != null ? displayName.split(" - ") : null;
            bVar.f747d.setText((CharSequence) l0.d(strArrSplit, 1, "未知歌曲"));
            bVar.c.setText((CharSequence) l0.d(strArrSplit, 0, "未知歌手"));
        }
        bVar.f748e.setText(String.valueOf(i2 + 1));
        eVar.itemView.setTag(item);
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public KGRecyclerView.e d(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_new_song, viewGroup, false));
    }
}
