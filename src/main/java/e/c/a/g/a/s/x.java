package e.c.a.g.a.s;

import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    public static void a(int i2, int i3, KGSong kGSong) {
        String str;
        kGSong.D3(i2);
        kGSong.l4(i3);
        StringBuilder sb = new StringBuilder();
        sb.append(kGSong.h1());
        if (!TextUtils.isEmpty(kGSong.g1())) {
            sb.append(" -《");
            sb.append(kGSong.g1());
            sb.append("》");
        } else if (!TextUtils.isEmpty(kGSong.y2())) {
            sb.append(" - ");
            sb.append(kGSong.y2());
        }
        String strL2 = kGSong.l2();
        String string = sb.toString();
        String strY2 = kGSong.y2();
        String strV2 = kGSong.v2();
        String strC = c(strV2);
        if (TextUtils.isEmpty(strC)) {
            str = strL2;
        } else {
            str = strL2 + " " + strC;
        }
        if (!TextUtils.isEmpty(strV2)) {
            strL2 = strL2 + " " + strV2;
        }
        kGSong.m4(h1.p(str, i2));
        kGSong.r4(h1.p(string, i2));
        kGSong.J4(h1.p(strY2, i2));
        kGSong.e3(h1.b(kGSong.s1()));
        kGSong.P2(h1.b(kGSong.g1()));
        kGSong.R2(h1.b(kGSong.j1()));
        kGSong.I4(h1.b(kGSong.y2()));
        kGSong.s4(h1.b(strL2));
    }

    public static void b(List<e.c.a.g.a.g.o.h> list) {
        int color = ContextCompat.getColor(KGApplication.getContext(), R.color.auto_ht);
        int color2 = ContextCompat.getColor(KGApplication.getContext(), R.color.auto_st);
        for (int i2 = 0; i2 < list.size(); i2++) {
            a(color, color2, list.get(i2).a());
            ArrayList<KGSong> arrayListB = list.get(i2).b();
            if (arrayListB != null && arrayListB.size() > 0) {
                for (int i3 = 0; i3 < arrayListB.size(); i3++) {
                    a(color, color2, arrayListB.get(i3));
                }
            }
        }
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        int color = ContextCompat.getColor(KGApplication.getContext(), R.color.auto_nt);
        int iIndexOf = sb.indexOf("<em>");
        int iIndexOf2 = sb.indexOf("</em>");
        if (iIndexOf > iIndexOf2 || (iIndexOf == 0 && iIndexOf2 == sb.length())) {
            return sb.toString();
        }
        if (iIndexOf == -1 && iIndexOf2 == -1) {
            sb.insert(sb.length(), "</font>");
            sb.insert(0, "<font color=" + color + ">");
            return sb.toString();
        }
        if (iIndexOf == 0) {
            sb.insert(sb.length(), "</font>");
            sb.insert(iIndexOf2 + 5, "<font color=" + color + ">");
        } else if (iIndexOf2 == sb.length()) {
            sb.insert(iIndexOf, "</font>");
            sb.insert(0, "<font color=" + color + ">");
        } else {
            sb.insert(sb.length(), "</font>");
            sb.insert(iIndexOf2 + 5, "<font color=" + color + ">");
            sb.insert(iIndexOf, "</font>");
            sb.insert(0, "<font color=" + color + ">");
        }
        return sb.toString();
    }
}
