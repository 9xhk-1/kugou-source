package e.c.a.g.a.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import e.c.a.g.a.s.u1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g extends e.c.a.g.a.f.o.h.a<KGSong> {
    public DelegateFragment c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f1109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<KGMusicWrapper> f1111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1112g = e.c.a.g.a.g.e.d.a.f();

    public interface a {
        void onClick(KGSong kGSong, int i2);
    }

    public class b extends e.c.a.g.a.f.l.b {
        public final TextView c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f1113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f1114e;

        public class a implements View.OnClickListener {
            public a(g gVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!u1.i(view) && b.this.getAdapterPosition() >= 0) {
                    int adapterPosition = b.this.getAdapterPosition() - 1;
                    e.c.a.g.a.d.x.f.y(true, g.this.p(), adapterPosition, true, g.this.c.l());
                    KGSong kGSong = g.this.i().get(adapterPosition);
                    if (g.this.f1109d != null) {
                        g.this.f1109d.onClick(kGSong, adapterPosition);
                    }
                    g.this.o(kGSong, adapterPosition);
                }
            }
        }

        public b(@NonNull View view) {
            super(view);
            view.setOnClickListener(new a(g.this));
            this.f1113d = (TextView) view.findViewById(R.id.song_name);
            this.c = (TextView) view.findViewById(R.id.author_name);
            this.f1114e = (TextView) view.findViewById(R.id.tv_num);
        }
    }

    public g(DelegateFragment delegateFragment, String str) {
        this.c = delegateFragment;
        this.f1110e = str;
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public void b(KGRecyclerView.e eVar, int i2) {
        b bVar = (b) eVar;
        KGSong item = getItem(i2);
        bVar.f1113d.setText(item.A2());
        bVar.f1114e.setText(String.valueOf(i2 + 1));
        String[] strArrH2 = item.h2();
        StringBuilder sb = new StringBuilder();
        if (strArrH2.length > 0) {
            int length = strArrH2.length;
            for (int i3 = 0; i3 < length; i3++) {
                sb.append(strArrH2[i3]);
                if (i3 != length - 1) {
                    sb.append("、");
                }
            }
        }
        bVar.c.setText(sb.toString());
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public KGRecyclerView.e d(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.c.getContext()).inflate(R.layout.item_new_song, viewGroup, false));
    }

    public void o(KGSong kGSong, int i2) {
        if (kGSong != null) {
            if ("5".equals(this.f1110e) || "1".equals(this.f1110e) || "2".equals(this.f1110e)) {
                e.c.a.g.a.e.b.b(new YoungBITask(20476, "click").setSvar1(String.valueOf(i2)).setIvar1("" + this.f1112g).setType(this.f1110e).setMixsongid(String.valueOf(kGSong.T1())));
            }
        }
    }

    public List<KGMusicWrapper> p() {
        List<KGMusicWrapper> list = this.f1111f;
        if (list == null || list.size() != getCount()) {
            String str = "22";
            if (!"1".equals(this.f1110e) && !"2".equals(this.f1110e)) {
                if ("3".equals(this.f1110e)) {
                    str = "25";
                } else if ("4".equals(this.f1110e)) {
                    str = "28";
                } else if (!"5".equals(this.f1110e)) {
                    str = "";
                }
            }
            this.f1111f = e.c.a.g.a.f.j.a.c.g(i(), Initiator.create(this.c.m()).carryPagePath(this.c.n()), str);
        }
        return this.f1111f;
    }

    public void q(a aVar) {
        this.f1109d = aVar;
    }
}
