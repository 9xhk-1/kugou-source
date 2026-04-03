package e.c.a.g.a.g.j.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import f.z.d.j;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends e.c.a.g.a.f.l.a<b> {
    public final View.OnClickListener c;

    /* JADX INFO: renamed from: e.c.a.g.a.g.j.h.a$a, reason: collision with other inner class name */
    public static final class C0146a extends e.c.a.g.a.f.l.b {
        public final ImageView c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f959d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0146a(View view, View.OnClickListener onClickListener) {
            super(view);
            j.e(view, "item");
            j.e(onClickListener, "clickListener");
            this.c = (ImageView) this.itemView.findViewById(R.id.item_cover);
            this.f959d = (TextView) this.itemView.findViewById(R.id.item_title);
            this.itemView.setOnClickListener(onClickListener);
        }

        public final void e(b bVar, int i2) {
            super.c(bVar, i2);
            if (bVar == null) {
                return;
            }
            this.c.setImageDrawable(bVar.b);
            this.c.invalidate();
            this.f959d.setText(bVar.c);
            this.itemView.setTag(bVar);
        }
    }

    public a(View.OnClickListener onClickListener) {
        j.e(onClickListener, "clickListener");
        this.c = onClickListener;
    }

    @Override // e.c.a.g.a.f.l.a
    public e.c.a.g.a.f.l.b f(LayoutInflater layoutInflater, ViewGroup viewGroup, int i2) {
        j.e(layoutInflater, "inflater");
        View viewInflate = layoutInflater.inflate(R.layout.item_player_more, viewGroup, false);
        j.d(viewInflate, "view");
        return new C0146a(viewInflate, this.c);
    }

    public final b j(int i2) {
        Object next;
        List<b> listC = c();
        j.d(listC, "srcDataList");
        Iterator<T> it = listC.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((b) next).a == i2) {
                break;
            }
        }
        return (b) next;
    }

    @Override // e.c.a.g.a.f.l.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void d(e.c.a.g.a.f.l.b bVar, b bVar2, int i2) {
        if (bVar instanceof C0146a) {
            ((C0146a) bVar).e(b(i2), i2);
        }
    }
}
