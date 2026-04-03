package e.c.a.g.a.d.x.t;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public final e.c.a.g.a.d.x.t.a a = a(2);

    public class a extends TypeToken<List<KGMusicWrapper>> {
        public a(c cVar) {
        }
    }

    public e.c.a.g.a.d.x.t.a a(int i2) {
        return i2 == 2 ? new d() : i2 == 1 ? new b() : new b();
    }

    public List<KGMusicWrapper> b(String str) {
        return (List) new Gson().fromJson(str, new a(this).getType());
    }

    public String c(List<KGMusicWrapper> list) {
        return new Gson().toJson(list);
    }
}
