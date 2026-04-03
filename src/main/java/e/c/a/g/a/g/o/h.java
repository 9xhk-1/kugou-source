package e.c.a.g.a.g.o;

import android.support.annotation.Nullable;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class h implements Serializable {
    public KGSong a;
    public ArrayList<KGSong> b;

    public KGSong a() {
        return this.a;
    }

    @Nullable
    public ArrayList<KGSong> b() {
        return this.b;
    }

    public void c(int i2) {
    }

    public void d(KGSong kGSong) {
        this.a = kGSong;
    }

    public void e(ArrayList<KGSong> arrayList) {
        this.b = arrayList;
    }
}
