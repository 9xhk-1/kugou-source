package e.c.a.g.a.d.r.p.b;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends AbstractRequestPackage implements AbsHttpClient.ICheckChinaIP {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f524d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f525e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f526f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f527g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f528h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f529i = 8;
    public static int j = 9;
    public static int k = 10;
    public static int l = 11;
    public boolean a;
    public Context b = e.c.c.o.f.a();
    public long c;

    public a(e.c.a.g.a.d.r.p.a.h hVar, boolean z) {
        this.a = z;
        long configAsLong = e.c.a.g.a.f.e.c.c().getConfigAsLong(e.c.a.g.a.f.e.b.c, 3337L);
        int iC = e.c.a.g.a.r.e.b.c(this.b);
        l1.n(this.b);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Hashtable<String, Object> hashtable = new Hashtable<>();
        this.mParams = hashtable;
        hashtable.put("appid", Long.valueOf(configAsLong));
        this.mParams.put("clientver", iC + "");
        if (!e.c.a.g.a.r.b.F() || a(hVar)) {
            this.mParams.put("userid", 0);
            this.mParams.put("token", "");
            this.mParams.put(CommNetSongUrlInfo.FAIL_PROCESS_VIP, 0);
        } else {
            long jO = e.c.a.g.a.r.b.o();
            this.c = jO;
            this.mParams.put("userid", Long.valueOf(jO));
            this.mParams.put("token", e.c.a.g.a.r.b.n());
            this.mParams.put(CommNetSongUrlInfo.FAIL_PROCESS_VIP, Integer.valueOf(e.c.a.g.a.r.b.z()));
        }
        if (hVar == null || TextUtils.isEmpty(hVar.a)) {
            return;
        }
        if (hVar.a.equals("collection") || hVar.a.equals("kKuqunSong") || hVar.a.equals("kSiliaoSong") || hVar.a.equals("kUgcMusicLib") || hVar.a.equals("kUgcUpload") || hVar.a.equals("kLocalSong") || hVar.a.equals("kLocalSinger") || hVar.a.equals("kLocalAlbum") || hVar.a.equals("kLocalIpod") || hVar.a.equals("kRecentPlay") || hVar.a.equals("kDownload") || hVar.a.equals("kILike") || hVar.a.equals("kListILike") || hVar.a.equals("kListFavorite") || hVar.a.equals("kListFavoriteOl") || hVar.a.equals("kListOwn") || hVar.a.equals("kPlayerMoreDialog") || hVar.a.equals("kMoreDialog") || hVar.a.equals("kListNoPrivUpdate") || hVar.a.equals("kListOwn")) {
            try {
                this.mParams.put("source", new JSONObject(hVar.a()));
            } catch (JSONException e2) {
                g0.k(e2);
            }
        }
    }

    public final boolean a(e.c.a.g.a.d.r.p.a.h hVar) {
        if (hVar != null) {
            return "special_local_query".equals(hVar.a) || "import_playlist".equals(hVar.a) || "kListNoPrivUpdate".equals(hVar.a);
        }
        return false;
    }

    @Override // com.kugou.common.network.AbsHttpClient.ICheckChinaIP
    public void checkIp() throws Exception {
    }

    @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
    public String getGetRequestParams() {
        return "";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    public String getRequestType() {
        return "POST";
    }

    @Override // com.kugou.common.network.AbsHttpClient.ICheckChinaIP
    public boolean shouldBeSilent() {
        return this.a;
    }
}
