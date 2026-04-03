package e.c.a.g.a.g.o;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.u1;

/* JADX INFO: loaded from: classes2.dex */
public class e extends e.c.a.g.a.f.o.h.a<KGSong> {
    public final View.OnClickListener c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f1001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutInflater f1002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1003f;

    public static class a extends e.c.a.g.a.f.l.b {
        public final TextView c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f1004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1006f;

        public a(@NonNull View view) {
            super(view);
            this.c = (TextView) view.findViewById(R.id.song_name);
            this.f1004d = (TextView) view.findViewById(R.id.author_name);
            Resources resources = view.getResources();
            this.f1005e = resources.getColor(R.color.auto_ht);
            this.f1006f = resources.getColor(R.color.white);
            view.setBackground(u1.c(l1.c(9.0f), resources.getColor(R.color.nor_list_bg)));
        }

        public void e(TextView... textViewArr) {
            for (TextView textView : textViewArr) {
                textView.setTextColor(this.f1005e);
            }
        }

        public void f(TextView... textViewArr) {
            for (TextView textView : textViewArr) {
                textView.setTextColor(this.f1006f);
            }
        }
    }

    public e(Context context, View.OnClickListener onClickListener) {
        this.f1001d = context;
        this.c = onClickListener;
        this.f1002e = LayoutInflater.from(context);
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public void b(KGRecyclerView.e eVar, int i2) {
        a aVar = (a) eVar;
        KGSong item = getItem(i2);
        aVar.itemView.setTag(item);
        String string = Html.fromHtml(item.l2()).toString();
        String string2 = Html.fromHtml(item.j1()).toString();
        KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
        if (kGMusicWrapperE == null || !item.J1().equals(kGMusicWrapperE.getHashValue())) {
            aVar.f(aVar.c, aVar.f1004d);
        } else {
            aVar.e(aVar.c, aVar.f1004d);
        }
        aVar.c.setText(m(string, this.f1003f));
        aVar.f1004d.setText(m(string2, this.f1003f));
    }

    @Override // com.kugou.android.watch.lite.common.widget.recyclerview.KGRecyclerView.a
    public KGRecyclerView.e d(ViewGroup viewGroup, int i2) {
        a aVar = new a(this.f1002e.inflate(R.layout.item_search_song, viewGroup, false));
        aVar.itemView.setOnClickListener(this.c);
        return aVar;
    }

    public final CharSequence m(String str, String str2) {
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        int iIndexOf = lowerCase.indexOf(lowerCase2);
        if (iIndexOf < 0) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f1001d, R.color.auto_ht)), iIndexOf, Math.min(lowerCase2.length() + iIndexOf, str.length()), 33);
        return spannableString;
    }

    public void n(String str) {
        this.f1003f = str;
    }
}
