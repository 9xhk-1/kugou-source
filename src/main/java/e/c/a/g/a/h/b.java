package e.c.a.g.a.h;

import android.content.Context;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.h.k;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c {
    public static final String s = c.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<j> f1057d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1058f;
    public a k;
    public Context l;
    public k m;
    public String n;
    public e.c.a.g.a.d.b.a r;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1059h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1060i = 0;
    public int j = 200;
    public long o = 0;
    public long p = 0;
    public boolean q = false;

    public interface a {
        void onFail();

        void onFinish(boolean z, e.c.a.g.a.d.b.a aVar);

        void onSucceed();
    }

    public b(Context context, List<j> list, int i2, String str) {
        this.f1058f = 0;
        this.n = "";
        this.l = context;
        this.f1057d = list;
        this.f1058f = i2;
        this.m = new k(context);
        this.n = str;
        j();
    }

    @Override // e.c.a.g.a.h.c
    public void a() {
    }

    @Override // e.c.a.g.a.h.c
    public void b() {
        this.f1059h = this.f1060i;
    }

    @Override // e.c.a.g.a.h.c
    public int d() {
        return 1;
    }

    @Override // e.c.a.g.a.h.c
    public int e() {
        return ((int) (new Random().nextFloat() * 5000.0f)) + BaseConnection.CONNECT_TIMEOUT;
    }

    @Override // e.c.a.g.a.h.c
    public void g() {
        this.k.onFinish(this.q, this.r);
    }

    @Override // e.c.a.g.a.h.c
    public boolean h() {
        ArrayList<KGSong> arrayList;
        k.a aVarA = this.m.a(i(this.f1059h), this.n, this.f1058f == this.f1057d.size(), this.o, this.p);
        if (aVarA == null) {
            return false;
        }
        this.r = aVarA.f1079f;
        if (aVarA.a != 1) {
            return false;
        }
        k(aVarA);
        e.c.a.g.a.f.m.c.a.h("KY_PERSONAL_FM_LAST_SYNC" + e.c.a.g.a.r.b.o(), System.currentTimeMillis());
        d dVar = aVarA.f1077d;
        if (dVar != null && (arrayList = dVar.c) != null && arrayList.size() > 0) {
            ArrayList<KGSong> arrayListA = dVar.a();
            if (g0.a) {
                g0.c(s, "追加歌曲数=" + arrayListA.size());
            }
        }
        return true;
    }

    public JSONArray i(int i2) {
        this.f1058f = this.f1059h;
        JSONArray jSONArray = new JSONArray();
        List<j> list = this.f1057d;
        if (list != null && this.f1058f < list.size()) {
            Stack stack = new Stack();
            int i3 = 0;
            while (this.f1058f < this.f1057d.size() && i3 < this.j) {
                stack.push(this.f1057d.get(this.f1058f));
                i3++;
                this.f1058f++;
            }
            this.p = ((j) stack.peek()).f1076g;
            while (!stack.isEmpty()) {
                jSONArray.put(((j) stack.pop()).b(0));
            }
            this.f1060i = this.f1058f;
        }
        return jSONArray;
    }

    public final void j() {
        try {
            this.j = new JSONObject(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.E0)).optInt("HistoryLimit", HttpStatus.SC_BAD_REQUEST);
        } catch (JSONException e2) {
            g0.k(e2);
        }
    }

    public final void k(k.a aVar) {
        this.n = this.f1057d.get(this.f1060i - 1).a();
        if (this.f1060i >= this.f1057d.size()) {
            this.q = true;
            c();
        }
        this.o = this.p;
    }

    public void l(a aVar) {
        this.k = aVar;
    }
}
