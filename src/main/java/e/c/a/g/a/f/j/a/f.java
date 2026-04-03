package e.c.a.g.a.f.j.a;

import android.os.Parcelable;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.music.entity.CExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.ExtraInfo;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.p1;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final a a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a(ExtraInfo extraInfo) {
            CExtraInfo cExtraInfo;
            String source = null;
            if (extraInfo != null && (cExtraInfo = extraInfo.cExtraInfo) != null) {
                source = cExtraInfo.getSource();
            }
            if (g0.a) {
                if (TextUtils.isEmpty(source)) {
                    p1.h(KGApplication.getContext(), "source为空，请处理");
                }
                if (j.a("未知来源", source)) {
                    p1.h(KGApplication.getContext(), "source是未知来源，请处理");
                }
            }
            return source == null ? "" : source;
        }

        public final String b(Parcelable parcelable) {
            if (!(parcelable instanceof KGMusicWrapper)) {
                return parcelable instanceof KGSong ? c(((KGSong) parcelable).w1()) : parcelable instanceof KGMusic ? c(((KGMusic) parcelable).getExtraInfo()) : a(null);
            }
            KGMusic kgmusic = ((KGMusicWrapper) parcelable).getKgmusic();
            return c(kgmusic != null ? kgmusic.getExtraInfo() : null);
        }

        public final String c(ExtraInfo extraInfo) {
            return a(extraInfo);
        }
    }
}
