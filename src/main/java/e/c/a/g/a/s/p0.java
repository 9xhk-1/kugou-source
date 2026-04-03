package e.c.a.g.a.s;

import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.framework.lyric.loader.language.Language;
import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {
    public static final p0 a = new p0();
    public static final String b = "p0";

    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return f.v.a.a(Long.valueOf(-((File) t).lastModified()), Long.valueOf(-((File) t2).lastModified()));
        }
    }

    public static final void a() {
        KGMusicWrapper kGMusicWrapperE = e.c.a.g.a.d.x.f.e();
        if (kGMusicWrapperE != null) {
            e.c.a.g.a.d.f.d.a.a.a.b(kGMusicWrapperE.getMixId());
        } else {
            e.c.a.g.a.d.f.d.a.a.a.a();
        }
        File file = new File(e.c.a.g.a.f.f.a.m);
        File[] fileArrListFiles = file.listFiles();
        if (g0.a) {
            String str = b;
            String[] list = file.list();
            g0.b(str, f.z.d.j.l("clearLyric: before=", list == null ? null : Integer.valueOf(list.length)));
        }
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            int i2 = HttpStatus.SC_BAD_REQUEST;
            if (length > 400) {
                if (fileArrListFiles.length > 1) {
                    f.u.h.e(fileArrListFiles, new a());
                }
                int length2 = fileArrListFiles.length;
                if (400 < length2) {
                    while (true) {
                        int i3 = i2 + 1;
                        q.l(fileArrListFiles[i2]);
                        if (i3 >= length2) {
                            break;
                        } else {
                            i2 = i3;
                        }
                    }
                }
            }
        }
        if (g0.a) {
            String str2 = b;
            String[] list2 = file.list();
            g0.b(str2, f.z.d.j.l("clearLyric: after=", list2 != null ? Integer.valueOf(list2.length) : null));
        }
    }

    public static final boolean b(List<? extends Language> list, Language language) {
        f.z.d.j.e(list, "languageList");
        f.z.d.j.e(language, "targetLanguage");
        Iterator<? extends Language> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == language) {
                return true;
            }
        }
        return false;
    }
}
