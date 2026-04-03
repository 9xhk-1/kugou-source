package e.c.a.g.a.d.r;

import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import e.c.a.g.a.s.g0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static e.c.a.g.a.d.r.p.a.c a(e.c.a.g.a.d.r.p.a.c cVar, int i2) {
        return cVar == null ? cVar : c(cVar.A(), i2);
    }

    public static e.c.a.g.a.d.r.p.a.c b(e.c.a.g.a.d.r.p.a.c cVar, SongQuality songQuality) {
        return g.j(cVar) ? cVar : a(cVar, d(songQuality));
    }

    public static e.c.a.g.a.d.r.p.a.c c(List<e.c.a.g.a.d.r.p.a.c> list, int i2) {
        if (list != null && !list.isEmpty()) {
            for (e.c.a.g.a.d.r.p.a.c cVar : list) {
                if (cVar != null && cVar.p() == i2) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public static int d(SongQuality songQuality) {
        return g.H(songQuality);
    }

    public static String e(e.c.a.g.a.d.r.p.a.c cVar) {
        return cVar == null ? "UNKNOWN" : cVar.p() == 1 ? "流畅音质" : cVar.p() == 2 ? "标准音质" : cVar.p() == 4 ? "高品音质" : cVar.p() == 5 ? "无损音质" : "UNKNOWN";
    }

    public static e.c.a.g.a.d.r.p.a.c f(e.c.a.g.a.d.r.p.a.c cVar, SongQuality songQuality) {
        e.c.a.g.a.d.r.p.a.c cVarB = b(cVar, songQuality);
        return cVarB == null ? cVar : cVarB;
    }

    public static void g(String str, e.c.a.g.a.d.r.p.a.c cVar) {
        if (cVar != null && g0.a) {
            String str2 = "Goods{name=" + cVar.s() + "\n,音质=" + e(cVar) + "[hash=" + cVar.k() + "]\n,是否已发布=" + g.D(cVar) + ",是否权限禁止=" + g.n(cVar) + ",是否有版权歌曲=" + g.i(cVar) + "\n,是否新歌曲=" + h.g(cVar) + ",是否免费[考虑身份]=" + g.o(cVar) + "\n";
            if (!g.o(cVar)) {
                str2 = (str2 + ",是否已购买=" + g.l(cVar) + ",是否专辑购买=" + g.j(cVar) + ",是否可以酷币购买=" + g.a(cVar) + "\n,是否可以音乐包购买=" + g.b(cVar) + ",是否音乐包免费=" + g.d(cVar) + ",是否VIP免费=" + g.e(cVar) + "\n") + ",是否登录=" + e.c.a.g.a.r.b.F() + ",音乐包类型=" + e.c.a.g.a.r.b.i() + "[<=0非音乐包;1/2-普通;3/4-豪华],VIP类型=" + e.c.a.g.a.r.b.z() + "[1/2-普通;3/4-超级;6-豪华 ]";
                if (e.c.a.g.a.r.b.F()) {
                    str2 = str2 + ",是否老用户=" + e.c.a.g.a.r.b.h();
                }
            }
            g0.e(str, str2 + '}');
        }
    }
}
