package e.c.a.g.a.g.h.m.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import com.kugou.android.watch.lite.recommend.entity.SheetMusicBean;
import e.c.a.g.a.f.l.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e.c.a.g.a.f.o.h.a<SheetMusicBean> {
    public final View.OnClickListener c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LayoutInflater f820d;

    /* JADX INFO: renamed from: e.c.a.g.a.g.h.m.c.a$a, reason: collision with other inner class name */
    public static final class C0133a extends b {
        public final TextView c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f822e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0133a(View view, View.OnClickListener onClickListener) {
            super(view);
            j.e(view, "itemView");
            j.e(onClickListener, "listener");
            this.c = (TextView) view.findViewById(R.id.tv_num);
            this.f821d = (TextView) view.findViewById(R.id.song_name);
            this.f822e = (TextView) view.findViewById(R.id.author_name);
            view.setOnClickListener(onClickListener);
        }

        @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.e
        public void c(Object obj, int i2) {
            super.c(obj, i2);
            if (obj instanceof SheetMusicBean) {
                this.itemView.setTag(Integer.valueOf(i2));
                this.c.setText(String.valueOf(i2 + 1));
                SheetMusicBean sheetMusicBean = (SheetMusicBean) obj;
                this.f821d.setText(sheetMusicBean.audio_name);
                this.f822e.setText(sheetMusicBean.author_name);
            }
        }
    }

    public a(View.OnClickListener onClickListener) {
        j.e(onClickListener, "listener");
        this.c = onClickListener;
        this.f820d = LayoutInflater.from(KGApplication.getContext());
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public void b(KGRecyclerView.e<?> eVar, int i2) {
        if (eVar instanceof C0133a) {
            ((C0133a) eVar).c(getItem(i2), i2);
        }
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public KGRecyclerView.e<?> d(ViewGroup viewGroup, int i2) {
        View viewInflate = this.f820d.inflate(R.layout.item_new_song, viewGroup, false);
        j.d(viewInflate, "inflater.inflate(R.layout.item_new_song, viewGroup, false)");
        return new C0133a(viewInflate, this.c);
    }
}
