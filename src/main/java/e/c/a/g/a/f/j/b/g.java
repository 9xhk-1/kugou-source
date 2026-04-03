package e.c.a.g.a.f.j.b;

import com.kugou.android.watch.lite.common.music.entity.KGFile;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicForUI;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.LocalMusic;
import com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g<T> {
    public static HashMap<Class, Integer> b;
    public int a = -1;

    static {
        HashMap<Class, Integer> map = new HashMap<>();
        b = map;
        map.put(e.c.a.g.a.f.j.a.a.class, 0);
        b.put(KGMusicForUI.class, 1);
        b.put(KGMusic.class, 1);
        b.put(LocalMusic.class, 1);
        b.put(KGPlaylistMusic.class, 3);
        b.put(KGSong.class, 5);
        b.put(KGMusicWrapper.class, 6);
        b.put(KGFile.class, 7);
        b.put(e.c.a.g.a.g.k.c.a.class, 8);
    }

    public List<b> a(List<T> list) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0) {
            if (c(list.get(0)) == -1) {
                return null;
            }
            arrayList = new ArrayList();
            try {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(b(it.next()));
                }
            } catch (Exception e2) {
                if (g0.a) {
                    g0.k(e2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b b(T t) {
        if (c(t) != 1) {
            return null;
        }
        return new f((KGMusic) t);
    }

    public final int c(T t) {
        if (this.a == -1 && b.containsKey(t.getClass())) {
            this.a = b.get(t.getClass()).intValue();
        }
        return this.a;
    }
}
