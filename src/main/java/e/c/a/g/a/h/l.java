package e.c.a.g.a.h;

import com.kugou.android.watch.lite.common.music.entity.SingerInfo;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public SingerInfo[] l;
    public JSONArray m;
    public String a = "";
    public int b = 0;
    public String c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1083d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1084e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1085f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1086g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1087h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1088i = "";
    public int j = 0;
    public String k = "";
    public long n = 0;
    public int o = 0;

    public String a() {
        return this.f1083d;
    }

    public JSONArray b() {
        return this.m;
    }

    public String c() {
        return this.f1088i;
    }

    public void d(JSONArray jSONArray) {
        this.m = jSONArray;
    }

    public String toString() {
        return "RequestMode( action=" + this.a + ", markList=" + this.c + ", curMark=" + this.f1083d + ", isOverPlay=" + this.f1084e + ", playTime=" + this.f1085f + ", hashLikeList=" + this.f1086g + ", songId=" + this.f1087h + ", hash=" + this.f1088i + ", fileName=" + this.k + ", remainSongcnt=" + this.j + ", mode=" + this.o + " )";
    }
}
