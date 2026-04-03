package e.c.a.g.a.g.f;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l0;

/* JADX INFO: loaded from: classes.dex */
public class b extends e.c.a.g.a.f.o.h.a<KGMusicWrapper> {
    public final LayoutInflater c = LayoutInflater.from(KGApplication.getContext());

    public static class a extends KGRecyclerView.e<KGMusicWrapper> {
        public final TextView c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f764d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f765e;

        public a(@NonNull View view) {
            super(view);
            this.f764d = (TextView) view.findViewById(R.id.song_name);
            this.c = (TextView) view.findViewById(R.id.author_name);
            this.f765e = (TextView) view.findViewById(R.id.tv_num);
        }

        public void d(KGMusicWrapper kGMusicWrapper, int i2) {
            super.c(kGMusicWrapper, i2);
            KGMusic kgmusic = kGMusicWrapper != null ? kGMusicWrapper.getKgmusic() : null;
            if (kgmusic == null) {
                return;
            }
            String[] strArrT = h1.t(kgmusic.displayName, " - ");
            if (g0.f()) {
                Log.d("mhs_watch_fav_show", "kgMusic.displayName = " + kgmusic.displayName + ", kgMusic = " + kgmusic.getMixId());
            }
            if (kgmusic == null || kgmusic.getMixId() != 0 || strArrT == null || strArrT.length != 1) {
                this.f764d.setText((CharSequence) l0.d(strArrT, 1, "未知歌曲"));
                this.c.setText((CharSequence) l0.d(strArrT, 0, "未知歌手"));
            } else {
                try {
                    this.f764d.setText((CharSequence) l0.d(strArrT, 0, "未知歌曲"));
                } catch (Exception unused) {
                    this.f764d.setText("未知歌曲");
                }
                this.c.setText("未知歌手");
            }
            this.f765e.setText(String.valueOf(i2 + 1));
            this.itemView.setTag(kGMusicWrapper);
        }
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public void b(KGRecyclerView.e eVar, int i2) {
        a aVar = (a) eVar;
        KGMusicWrapper item = getItem(i2);
        if (item == null) {
            return;
        }
        aVar.d(item, i2);
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public KGRecyclerView.e d(ViewGroup viewGroup, int i2) {
        return new a(this.c.inflate(R.layout.item_new_song, viewGroup, false));
    }
}
