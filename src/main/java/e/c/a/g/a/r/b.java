package e.c.a.g.a.r;

import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.network.NetModeControler;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import e.c.a.g.a.f.m.c;
import e.c.a.g.a.r.g.e;
import e.c.a.g.a.s.a0;
import e.c.a.g.a.s.u0;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static volatile boolean a = false;

    public static String A() {
        return e.c.a.g.a.f.n.a.b().e(OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_HEIGHT_3, null);
    }

    public static int B() {
        return e.c.a.g.a.f.n.a.b().c(155, 65535);
    }

    public static boolean C() {
        if (!F()) {
            return true;
        }
        return c.a.e(o() + "has_cloud_sync_succeeded", false);
    }

    public static boolean D() {
        return (b() & 1) != 0;
    }

    public static boolean E() {
        return (b() & 2) != 0;
    }

    public static boolean F() {
        return c.a.e("key_user_login", false);
    }

    public static boolean G() {
        int i2 = i();
        return Q() || (i2 > 0 && i2 < 5);
    }

    public static boolean H() {
        if (G()) {
            return true;
        }
        int iB = c.a.b("user_music_type", 0);
        return iB > 0 && iB < 5;
    }

    public static boolean I() {
        return i() > 0 && i() <= 2;
    }

    public static boolean J() {
        if (!a) {
            a = true;
            NetModeControler.getInstance().refreshNetMode(u0.s(f.a()));
        }
        return NetModeControler.getInstance().isOnLine();
    }

    public static boolean K() {
        return e.c.a.g.a.f.n.a.b().a(10204, false);
    }

    public static boolean L() {
        return i() > 2;
    }

    public static boolean M() {
        return e.c.a.f.b.a.b(y());
    }

    public static boolean N() {
        return z() == 6 || Q();
    }

    public static boolean O() {
        return R() || Q();
    }

    public static boolean P() {
        return e.c.a.f.b.a.c(SVIPExtInfoUtil.getMineSVIPExtInfo().getVipUserYType());
    }

    public static boolean Q() {
        return e.c.a.g.a.f.n.a.b().c(152, 0) == 1;
    }

    public static boolean R() {
        int iZ = z();
        return (iZ > 0 && iZ < 5) || iZ == 6;
    }

    public static void S(long j, boolean z) {
        c.a.j("keys_sync_succ" + j, z);
    }

    public static void T() {
        e.c.a.g.a.f.n.a.b().g(8, 0);
        e.c.a.g.a.f.n.a.b().i(7, null);
        e.c.a.g.a.f.n.a.b().i(9, null);
        e.c.a.g.a.f.n.a.b().i(10, null);
        e.c.a.g.a.f.n.a.b().i(11, null);
        e.c.a.g.a.f.n.a.b().i(12, null);
        e.c.a.g.a.f.n.a.b().f(23, false);
        e.c.a.g.a.f.n.a.b().g(25, 0);
        e.c.a.g.a.f.n.a.b().g(152, 0);
        e.c.a.g.a.f.n.a.b().f(29, false);
        e.c.a.g.a.f.n.a.b().i(36, "0");
        e.c.a.g.a.f.n.a.b().g(35, 0);
        e.c.a.g.a.f.n.a.b().g(39, 0);
        e.c.a.g.a.f.n.a.b().g(79, 0);
        e.c.a.g.a.f.n.a.b().g(118, 0);
        e.c.a.g.a.f.n.a.b().g(10201, 0);
    }

    public static void U(boolean z) {
        e.c.a.g.a.f.n.a.b().f(143, z);
    }

    public static boolean V(int i2) {
        c.a.g(q() + "loveplaylistver", i2);
        return true;
    }

    public static void W(long j) {
        e.c.a.g.a.f.n.a.b().h(140, j);
    }

    public static void X(String str) {
        e.c.a.g.a.f.n.a.b().i(66, str);
    }

    public static void Y(boolean z) {
        e.c.a.g.a.f.n.a.b().f(17, z);
    }

    public static boolean Z(String str) {
        c.a.i(o() + "keys_fav_global_id", str);
        return true;
    }

    public static void a(UserData userData) {
        Log.d("constructUserInfo", "constructUserInfo: " + userData);
        if (userData != null) {
            e.c.a.g.a.f.n.a.b().h(8, userData.getUserid());
            e.c.a.g.a.f.n.a.b().i(7, userData.getUsername());
            e.c.a.g.a.f.n.a.b().i(9, userData.getNickname());
            e.c.a.g.a.f.n.a.b().i(10, userData.getPic());
            e.c.a.g.a.f.n.a.b().f(23, (userData.getVip_type() == 0 || userData.getVip_type() == 5) ? false : true);
            e.c.a.g.a.f.n.a.b().g(25, userData.getVip_type());
            e.c.a.g.a.f.n.a.b().g(152, userData.getYoungIsVip());
            e.c.a.g.a.f.n.a.b().f(10204, userData.isPaidVip());
            e.c.a.g.a.f.n.a.b().i(11, userData.getLogin_email());
            e.c.a.g.a.f.n.a.b().i(12, userData.getLogin_mobile());
            e.c.a.g.a.f.n.a.b().i(26, userData.getVip_begin_time());
            e.c.a.g.a.f.n.a.b().i(27, userData.getVip_end_time());
            e.c.a.g.a.f.n.a.b().i(153, userData.getYoungVipBeginTime());
            e.c.a.g.a.f.n.a.b().i(OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_HEIGHT_3, userData.getYoungVipEndTime());
            e.c.a.g.a.f.n.a.b().i(24, userData.getVip_clearday() + "");
            e.c.a.g.a.f.n.a.b().i(30, userData.getSignature());
            e.c.a.g.a.f.n.a.b().f(29, false);
            e.c.a.g.a.f.n.a.b().g(39, userData.getMusicType());
            e.c.a.g.a.f.n.a.b().i(38, userData.getMusicBegin());
            e.c.a.g.a.f.n.a.b().i(37, userData.getMusicEnd());
            e.c.a.g.a.f.n.a.b().g(79, userData.getM_is_old());
            e.c.a.g.a.f.n.a.b().g(118, userData.getRoamType());
            e.c.a.g.a.f.n.a.b().i(119, userData.getRoamBeginTime());
            e.c.a.g.a.f.n.a.b().i(120, userData.getRoamEndTime());
            e.c.a.g.a.f.n.a.b().g(10201, userData.getYearType());
            e.c.a.g.a.f.n.a.b().g(155, userData.getYoungVipType());
            e.c.a.g.a.f.n.a.b().i(10202, userData.getVip_end_time());
            e.c.a.g.a.f.n.a.b().i(10203, userData.getServertime());
            c.a.g("user_music_type", userData.getMusicType());
        }
    }

    public static void a0(int i2) {
        c.a.g(q() + "favplaylistver", i2);
    }

    public static int b() {
        return e.c.a.g.a.f.n.a.b().c(10201, 0);
    }

    public static void b0(String str) {
        c.a.i("key_user_nick_name", str);
        e.c.a.g.a.f.n.a.b().i(9, str);
    }

    public static String c() {
        return e.c.a.g.a.f.n.a.b().e(80, "1");
    }

    public static void c0(String str) {
        c.a.i("key_user_pic", str);
    }

    public static int d() {
        return c.a.b(q() + "loveplaylistver", 0);
    }

    public static void d0(int i2) {
        e.c.a.g.a.f.n.a.b().g(35, Math.max(i2, 0));
    }

    public static boolean e() {
        return e.c.a.g.a.f.n.a.b().a(17, false);
    }

    public static void e0(String str) {
        e.c.a.g.a.f.n.a.b().i(36, str);
    }

    public static String f() {
        String strE = e.c.a.g.a.f.n.a.b().e(37, null);
        return TextUtils.isEmpty(strE) ? w() : strE;
    }

    public static String g() {
        String strD = c.a.d("user_music_end_time", "");
        return "null".equals(strD) ? "" : strD;
    }

    public static int h() {
        return e.c.a.g.a.f.n.a.b().c(79, 0);
    }

    public static int i() {
        return e.c.a.g.a.f.n.a.b().c(39, 0);
    }

    public static String j() {
        if (!F()) {
            return "";
        }
        return c.a.d(o() + "keys_fav_global_id", "");
    }

    public static int k() {
        return c.a.b(q() + "favplaylistver", 0);
    }

    public static int l() {
        return c.a.b("KEY_PERSONAL_FM_SONG_POOL" + o(), e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.T0, 1));
    }

    public static long m() {
        return e.c.a.g.a.f.n.a.b().d(43, 0L);
    }

    public static String n() {
        return c.a.d("key_user_token", "");
    }

    public static long o() {
        return c.a.c("key_user_id", 0L);
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArrSplit = str.split("/");
        if (strArrSplit.length < 1) {
            return null;
        }
        if (!str.contains("sina") && !str.contains("qlogo") && !str.contains("tencent")) {
            return e.g() + strArrSplit[strArrSplit.length - 1];
        }
        return e.g() + strArrSplit[strArrSplit.length - 2] + strArrSplit[strArrSplit.length - 1] + ".jpg";
    }

    public static String q() {
        return c.a.d("key_user_name", "");
    }

    public static String r() {
        return c.a.d("key_user_nick_name", "");
    }

    public static String s() {
        return c.a.d("key_user_pic", "");
    }

    public static String t() {
        return a0.c(s());
    }

    public static String u() {
        return e.c.a.g.a.f.n.a.b().e(10202, "");
    }

    public static int v() {
        return e.c.a.g.a.f.n.a.b().c(35, 0);
    }

    public static String w() {
        String strG = G() ? g() : "";
        return TextUtils.isEmpty(strG) ? "0" : strG;
    }

    public static String x() {
        String strE = e.c.a.g.a.f.n.a.b().e(27, null);
        return TextUtils.isEmpty(strE) ? "0" : strE;
    }

    public static int y() {
        return SVIPExtInfoUtil.getMineSVIPExtInfo(true).getVipUserType();
    }

    public static int z() {
        return e.c.a.g.a.f.n.a.b().c(25, 0);
    }
}
