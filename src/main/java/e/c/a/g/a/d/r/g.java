package e.c.a.g.a.d.r;

import android.text.TextUtils;
import androidx.media.AudioAttributesCompat;
import com.kugou.android.watch.lite.common.music.entity.KGFile;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.l1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SongQuality.values().length];
            a = iArr;
            try {
                iArr[SongQuality.QUALITY_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SongQuality.QUALITY_HIGH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SongQuality.QUALITY_HIGHEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[SongQuality.QUALITY_SUPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static boolean A(KGMusic kGMusic) {
        if (e.c.a.g.a.d.s.i.d(kGMusic)) {
            return true;
        }
        int i2 = (!TextUtils.isEmpty(kGMusic.getHashValue()) ? 1 : 0) | (TextUtils.isEmpty(kGMusic.getHash320()) ? 0 : 16) | (TextUtils.isEmpty(kGMusic.getSqHash()) ? 0 : 256);
        int charge = kGMusic.getCharge();
        if (charge >= 16) {
            i = (TextUtils.isEmpty(kGMusic.getHash320()) ? 0 : 32) | (TextUtils.isEmpty(kGMusic.getHashValue()) ? 0 : 2) | (TextUtils.isEmpty(kGMusic.getSqHash()) ? 0 : 512);
        } else if (TextUtils.isEmpty(kGMusic.getHashValue())) {
            i = 0;
        }
        return charge <= 0 || ((charge & i) != i && (charge & i2) <= 0);
    }

    public static boolean B(KGMusicWrapper kGMusicWrapper, boolean z) {
        boolean zC = z ? e.c.a.g.a.d.x.d.c(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId(), kGMusicWrapper.isNeedListenPart()) : false;
        return !zC ? e.c.a.g.a.d.i.b.c(kGMusicWrapper.getHashValue(), kGMusicWrapper.getSongQuality(), kGMusicWrapper.getMixId()) : zC;
    }

    public static boolean C(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.C() & 2) > 0;
    }

    public static boolean D(e.c.a.g.a.d.r.p.a.c cVar) {
        return cVar.z() > 0;
    }

    public static e.c.a.g.a.d.r.p.a.g E(KGFile kGFile) {
        return F(kGFile, false);
    }

    public static e.c.a.g.a.d.r.p.a.g F(KGFile kGFile, boolean z) {
        if (kGFile == null) {
            return null;
        }
        e.c.a.g.a.d.r.p.a.g gVar = new e.c.a.g.a.d.r.p.a.g();
        if (z) {
            if (!TextUtils.isEmpty(kGFile.getFilehash())) {
                gVar.k(kGFile.getFilehash().toLowerCase());
            }
        } else if (!TextUtils.isEmpty(kGFile.getMusichash())) {
            gVar.k(kGFile.getMusichash().toLowerCase());
        }
        if (!TextUtils.isEmpty(kGFile.getAlbumID())) {
            gVar.j(kGFile.getAlbumID());
        }
        if (kGFile.getMixId() > 0) {
            gVar.i(kGFile.getMixId());
        }
        gVar.m(kGFile.getTrackName());
        gVar.l(0);
        gVar.p(d.c);
        return gVar;
    }

    public static SongQuality G(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 5 ? SongQuality.QUALITY_NONE : SongQuality.QUALITY_SUPER : SongQuality.QUALITY_HIGHEST : SongQuality.QUALITY_HIGH : SongQuality.QUALITY_LOW;
    }

    public static int H(SongQuality songQuality) {
        int i2 = a.a[songQuality.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 3) {
            return i2 != 4 ? 2 : 5;
        }
        return 4;
    }

    public static e.c.a.g.a.d.r.p.a.g I(KGMusic kGMusic) {
        if (kGMusic == null) {
            return null;
        }
        e.c.a.g.a.d.r.p.a.g gVar = new e.c.a.g.a.d.r.p.a.g();
        if (!TextUtils.isEmpty(kGMusic.getHashValue())) {
            gVar.k(kGMusic.getHashValue().toLowerCase());
        }
        gVar.m(kGMusic.getDisplayName());
        if (!TextUtils.isEmpty(kGMusic.getFeeAlbumId())) {
            gVar.j(kGMusic.getFeeAlbumId());
        }
        if (kGMusic.getMixId() > 0) {
            gVar.i(kGMusic.getMixId());
        }
        gVar.l(0);
        gVar.p(d.c);
        return gVar;
    }

    public static e.c.a.g.a.d.r.p.a.g J(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper == null) {
            return new e.c.a.g.a.d.r.p.a.g();
        }
        e.c.a.g.a.d.r.p.a.g gVar = new e.c.a.g.a.d.r.p.a.g();
        gVar.k(kGMusicWrapper.getHashValue().toLowerCase());
        gVar.m(kGMusicWrapper.getDisplayName());
        if (kGMusicWrapper.getMixId() > 0) {
            gVar.i(kGMusicWrapper.getMixId());
        }
        gVar.l(0);
        gVar.p(d.c);
        return gVar;
    }

    public static boolean K(e.c.a.g.a.d.r.p.a.c cVar) {
        return c(cVar) && L(cVar) && (cVar.v() & 1) > 0;
    }

    public static boolean L(e.c.a.g.a.d.r.p.a.c cVar) {
        return cVar.n() == 1;
    }

    public static int[] M(int[] iArr, e.c.a.g.a.d.r.p.a.c cVar) {
        int iP = cVar.p();
        if (iP == 1 || iP == 2) {
            iArr[0] = cVar.y();
        } else if (iP == 4) {
            iArr[1] = cVar.y();
        } else if (iP == 5) {
            iArr[2] = cVar.y();
        }
        return iArr;
    }

    public static KGSong N(KGSong kGSong, e.c.a.g.a.d.r.p.a.c cVar) {
        int iP = cVar.p();
        if (iP == 1) {
            kGSong.L3(cVar.k());
        } else if (iP == 2) {
            kGSong.B3(cVar.k());
        } else if (iP == 4) {
            kGSong.C3(cVar.k());
        } else if (iP == 5) {
            kGSong.C4(cVar.k());
        }
        if (cVar.o() != null) {
            int iP2 = cVar.p();
            if (iP2 == 1) {
                kGSong.M3(cVar.o().d());
            } else if (iP2 == 2) {
                kGSong.o4(cVar.o().d());
            } else if (iP2 == 4) {
                kGSong.p4(cVar.o().d());
            } else if (iP2 == 5) {
                kGSong.D4(cVar.o().d());
            }
        }
        return kGSong;
    }

    public static e.c.a.g.a.d.r.p.a.g O(KGSong kGSong) {
        if (kGSong == null) {
            return null;
        }
        e.c.a.g.a.d.r.p.a.g gVar = new e.c.a.g.a.d.r.p.a.g();
        if (kGSong.J1() != null) {
            gVar.k(kGSong.J1().toLowerCase().toString());
        }
        if (!TextUtils.isEmpty(kGSong.y1())) {
            gVar.j(kGSong.y1());
        }
        if (kGSong.T1() > 0) {
            gVar.i(kGSong.T1());
        }
        gVar.m(kGSong.s1());
        gVar.l(0);
        gVar.p(d.c);
        return gVar;
    }

    public static e.c.a.g.a.d.r.p.a.g P(e.c.a.g.a.d.r.p.a.c cVar) {
        e.c.a.g.a.d.r.p.a.g gVar = new e.c.a.g.a.d.r.p.a.g();
        if (cVar != null) {
            if (TextUtils.isEmpty(cVar.k())) {
                gVar.k("");
            } else {
                gVar.k(cVar.k().toLowerCase());
            }
            gVar.m(cVar.s());
            gVar.l(cVar.m());
            gVar.p(cVar.D());
            gVar.j(cVar.d());
            gVar.i(cVar.q());
        }
        return gVar;
    }

    public static KGSong Q(e.c.a.g.a.d.r.p.a.c cVar, String str, int i2) {
        KGSong kGSong = new KGSong(str);
        if (cVar != null) {
            kGSong.j3("mp3");
            kGSong.e3(h1.x(cVar.s()));
            N(kGSong, cVar);
            kGSong.p3(cVar.m());
            kGSong.Y2(i2);
            kGSong.t4(G(cVar.p()).getType());
            kGSong.t3(kGSong.s1());
            kGSong.n3(cVar.d());
            if (cVar.A() != null && cVar.A().size() > 0) {
                int[] iArr = new int[3];
                for (e.c.a.g.a.d.r.p.a.c cVar2 : cVar.A()) {
                    if (cVar2 != null) {
                        N(kGSong, cVar2);
                        M(iArr, cVar2);
                        kGSong.e3(h1.x(cVar2.s()));
                        kGSong.t3(kGSong.s1());
                    }
                }
                kGSong.S3(iArr[0], iArr[1], iArr[2]);
            }
            kGSong.i3(cVar.i());
            if (cVar.o() != null) {
                kGSong.g3(cVar.o().b());
                kGSong.X2(cVar.o().a());
                kGSong.j3(cVar.o().c());
            }
            if (TextUtils.isEmpty(kGSong.J1()) && !TextUtils.isEmpty(kGSong.O1())) {
                kGSong.B3(cVar.k());
                kGSong.M3(((((int) kGSong.t1()) / 1000) * 32000) / 8);
                if (cVar.o() != null) {
                    kGSong.o4(cVar.o().d());
                }
            }
            if (!TextUtils.isEmpty(cVar.D())) {
                kGSong.U3(cVar.D());
            }
            kGSong.m3(cVar.j());
            kGSong.e4(cVar.v());
            kGSong.b4(cVar.t());
            kGSong.O4(l1.b());
            kGSong.Q3(cVar.q());
            kGSong.setMusicTransParamEnenty(cVar.r());
        }
        return kGSong;
    }

    public static ArrayList<KGSong> R(List<e.c.a.g.a.d.r.p.a.c> list, String str, int i2) {
        ArrayList<KGSong> arrayList = new ArrayList<>();
        if (list != null) {
            Iterator<e.c.a.g.a.d.r.p.a.c> it = list.iterator();
            while (it.hasNext()) {
                KGSong kGSongQ = Q(it.next(), str, i2);
                if (!TextUtils.isEmpty(kGSongQ.J1()) || !TextUtils.isEmpty(kGSongQ.O1()) || !TextUtils.isEmpty(kGSongQ.t2()) || !TextUtils.isEmpty(kGSongQ.K1())) {
                    arrayList.add(kGSongQ);
                }
            }
        }
        return arrayList;
    }

    public static boolean a(e.c.a.g.a.d.r.p.a.c cVar) {
        return c(cVar) && (cVar.v() & 2) > 0;
    }

    public static boolean b(e.c.a.g.a.d.r.p.a.c cVar) {
        return c(cVar) && (cVar.v() & 1) > 0;
    }

    public static boolean c(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.j() & 4) == 4;
    }

    public static boolean d(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.j() & 8) == 8;
    }

    public static boolean e(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.j() & 2) == 2;
    }

    public static boolean f(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.v() & 4) > 0;
    }

    public static String g(int i2) {
        switch (i2) {
            case 31301:
                return "没有找到对应版权";
            case 31302:
                return "版权不在有效期内";
            case 31303:
                return "版权禁止该行为";
            case 31304:
                return "提供的资源信息不正确 ";
            case 31305:
                return "当前包月下载数已用完";
            case 31306:
                return "资源不存在";
            case 31307:
                return "资源不发布";
            case 31308:
                return "不支持vip支付";
            case 31309:
                return "资源免费使用（不用购买）";
            case 31310:
                return "资源已经购买 ";
            case 31311:
                return "该用户未购买音乐包";
            case 31312:
                return "支付金额不足 ";
            case 31313:
                return "歌曲不允许单独购买";
            case 31314:
                return "酷币系统消费失败";
            case 31315:
                return "请求重复";
            case 31316:
                return "订单号重复";
            case 31317:
                return "系统维护中";
            default:
                switch (i2) {
                    case 31401:
                        return "酷币余额不足 ";
                    case 31402:
                        return "重复订单号";
                    case 31403:
                        return "业务消费失败 ";
                    case 31404:
                        return "appstore验证失败";
                    case 31405:
                        return "订单号不存在 ";
                    case 31406:
                        return "防止消费扣款并发";
                    case 31407:
                        return "获取用户信息失败";
                    case 31408:
                        return "用户不在本机房";
                    default:
                        return "支付出现问题,未完成购买";
                }
        }
    }

    public static HashMap<String, Boolean> h(List<e.c.a.g.a.d.r.n.a<KGSong>> list) {
        HashMap<String, Boolean> map = new HashMap<>();
        if (list != null && list.size() >= 1) {
            for (e.c.a.g.a.d.r.n.a<KGSong> aVar : list) {
                if (aVar != null && aVar.b() != null && e.c.a.g.a.f.j.c.c.b() && e.c.a.g.a.f.j.c.c.d(aVar.b())) {
                    map.put(aVar.a().J1(), Boolean.TRUE);
                }
            }
        }
        return map;
    }

    public static boolean i(e.c.a.g.a.d.r.p.a.c cVar) {
        return cVar == null || cVar.g() >= 0;
    }

    public static boolean j(e.c.a.g.a.d.r.p.a.c cVar) {
        if (cVar == null) {
            return false;
        }
        return "album".equalsIgnoreCase(cVar.D());
    }

    public static boolean k(String str) {
        return "album".equalsIgnoreCase(str);
    }

    public static boolean l(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.C() & 6) > 0;
    }

    public static boolean m(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.C() & 4) > 0;
    }

    public static boolean n(e.c.a.g.a.d.r.p.a.c cVar) {
        if (cVar == null) {
            return false;
        }
        return !D(cVar) || (cVar.C() == 0 && cVar.j() == 0);
    }

    public static boolean o(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.C() & 1) > 0;
    }

    public static boolean p(e.c.a.g.a.d.r.p.a.c cVar) {
        return o(cVar) || l(cVar);
    }

    public static boolean q(int i2) {
        return 19 == i2;
    }

    public static boolean r(e.c.a.g.a.d.r.p.a.c cVar) {
        return false;
    }

    public static boolean s(MusicTransParamEnenty musicTransParamEnenty) {
        return false;
    }

    public static boolean t(e.c.a.g.a.d.r.p.a.c cVar) {
        return (cVar.y() & 2) == 0;
    }

    public static boolean u(int i2) {
        if (i2 > 0) {
            return (i2 & 4) == 4 || (i2 & 64) == 64 || (i2 & 1024) == 1024;
        }
        return false;
    }

    public static boolean v(int i2) {
        if (i2 > 0 && (i2 & 8) == 8) {
            return false;
        }
        if ((i2 & 4) == 4) {
        }
        return true;
    }

    public static boolean w(int i2) {
        return i2 > 0 && (i2 & 2) == 2;
    }

    public static boolean x(KGMusic kGMusic) {
        int charge = kGMusic.getCharge();
        if (charge >= 16) {
            i = (TextUtils.isEmpty(kGMusic.getHashValue()) ? 0 : 2) | (TextUtils.isEmpty(kGMusic.getHash320()) ? 0 : 32) | (TextUtils.isEmpty(kGMusic.getSqHash()) ? 0 : 512);
        } else if (TextUtils.isEmpty(kGMusic.getHashValue())) {
            i = 0;
        }
        return charge > 0 && (charge & i) == i;
    }

    public static boolean y(int i2) {
        return i2 > 0 && ((i2 & 1) == 1 || (i2 & 16) == 16 || (i2 & 256) == 256);
    }

    public static boolean z(int i2) {
        if (i2 > 0) {
            return (i2 & 2) != 2 && (i2 & AudioAttributesCompat.FLAG_ALL_PUBLIC) <= 0;
        }
        return true;
    }
}
